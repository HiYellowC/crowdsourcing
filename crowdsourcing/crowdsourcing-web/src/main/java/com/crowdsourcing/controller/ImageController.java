package com.crowdsourcing.controller;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crowdsourcing.pojo.TbImage;
import com.crowdsourcing.pojo.TbRecord;
import com.crowdsourcing.service.ImageService;
import com.crowdsourcing.service.RecordService;

import redis.clients.jedis.exceptions.JedisException;

import com.crowdsourcing.common.util.ImageUtil;
import com.crowdsourcing.common.util.StreamUtil;
import com.crowdsourcing.jedis.JedisClient;
import com.crowdsourcing.common.pojo.CrowdsourcingResult;
import com.crowdsourcing.common.pojo.Rectangle;

@Controller
@RequestMapping("/image")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@Autowired
	private RecordService recordService;

	@Autowired
	private JedisClient jedisClient;

	/*
	 * 页面跳转
	 */
	@RequestMapping("/savePage")
	public String savePage() {
		return "image/image-save";
	}

	/*
	 * 上传照片
	 */
	@RequestMapping("/save")
	@ResponseBody
	public CrowdsourcingResult save(String name, String keyword, String keycode, HttpServletRequest request) {
		try {
			keyword = URLDecoder.decode(keyword, "UTF-8");
			name = URLDecoder.decode(name, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return CrowdsourcingResult.build(500, "编码异常");
		}

		/*
		 * 将inputStream转为bytes
		 */
		byte[] bytes = null;

		try (InputStream inputStream = request.getInputStream()) {
			bytes = StreamUtil.getBytesFromInputStream(inputStream);
		} catch (IOException e) {
			return CrowdsourcingResult.build(500, "IO异常");
		}
		
		/*
		 * 图片判重
		 */

		try {
			InputStream inputStream = new ByteArrayInputStream(bytes);
			String hashCode = ImageUtil.getHash(inputStream);
			synchronized (this) {
				List<String> hashList = jedisClient.lrange(keycode, 0, -1);
				for (int i = 0; i < hashList.size(); i++) {
					if (ImageUtil.distance(hashCode, hashList.get(i)) < 10) {
						return CrowdsourcingResult.build(201, "重复图片");
					}
				}
				jedisClient.lpush(keycode, hashCode);
				if (jedisClient.llen(keycode) == 1) {
					jedisClient.expire(keycode, 10 * 60);
				}
			}
		} catch (IOException e) {
			return CrowdsourcingResult.build(500, "IO异常");
		} catch (JedisException e) {
			return CrowdsourcingResult.build(500, "jedis异常");
		} catch (Exception e) {
			return CrowdsourcingResult.build(500, "未知错误");
		}

		/*
		 * 写入bytes
		 */
		Subject subject = SecurityUtils.getSubject();
		Long id = (Long) subject.getSession().getAttribute("id");
		try {
			imageService.saveImage(name, bytes, keyword, id);
		} catch (Exception e) {
			return CrowdsourcingResult.build(500, e.toString());
		}

		return CrowdsourcingResult.ok();
	}

	/*
	 * 请求任务界面 taskId(1-3): 任务编号
	 */
	@RequestMapping("/task/{taskId}")
	public String taskPage(@PathVariable int taskId, Model model) {

		Session session = SecurityUtils.getSubject().getSession();
		Long id = (Long) session.getAttribute("id");
		TbImage tbImage;

		try {
			tbImage = imageService.getImageByLastEditorIdAndStep(id, taskId);
		} catch (Exception e) {
			model.addAttribute("errorInfo", "发生错误");
			return "failure";
		}

		if (tbImage == null) {
			model.addAttribute("errorInfo", "没有照片了");
			return "failure";
		}

		Map<String, Object> info = new HashMap<>();
		info.put("keyword", tbImage.getKeyword());
		info.put("id", tbImage.getId());
		model.addAttribute("info", info);

		return "image/image-task" + taskId;
	}

	/*
	 * 任务一操作提交
	 */
	@RequestMapping("/task1")
	@ResponseBody
	public CrowdsourcingResult task1(Rectangle rectangle) {

		Session session = SecurityUtils.getSubject().getSession();
		Long editorId = (Long) session.getAttribute("id");

		try {
			imageService.saveTask1(editorId, rectangle);
		} catch (Exception e) {
			return CrowdsourcingResult.build(500, e.toString());
		}

		return CrowdsourcingResult.ok();

	}

	/*
	 * 任务二操作提交
	 */
	@RequestMapping("/task2")
	@ResponseBody
	public CrowdsourcingResult task2(Long id, String isPass) {

		Session session = SecurityUtils.getSubject().getSession();
		Long editorId = (Long) session.getAttribute("id");
		TbRecord tbRecord = recordService.getRecordByImageId(id);
		Rectangle rectangle = new Rectangle(id, tbRecord.getX(), tbRecord.getY(), tbRecord.getWidth(),
				tbRecord.getHeight());

		TbImage tbImage = imageService.getImageById(id);

		if ("pass".equals(isPass)) {
			byte[] data = null;
			try {
				data = ImageUtil.imageDrawLine(tbImage.getData(), rectangle.getX(), rectangle.getY(),
						rectangle.getWidth(), rectangle.getHeight(), Color.GREEN);
			} catch (IOException e) {
				return CrowdsourcingResult.build(500, "IO异常");
			}
			try {
				imageService.saveTask2(editorId, rectangle, data, tbRecord.getEditorId());
			} catch (Exception e) {
				return CrowdsourcingResult.build(500, e.toString());
			}
		} else {
			try {
				imageService.saveTask2(editorId, rectangle, tbRecord.getEditorId());
			} catch (Exception e) {
				return CrowdsourcingResult.build(500, e.toString());
			}
		}

		return CrowdsourcingResult.ok();
	}

	/*
	 * 任务三提交
	 */
	@RequestMapping("/task3")
	@ResponseBody
	public CrowdsourcingResult task3(Long id, String isPass) {

		Session session = SecurityUtils.getSubject().getSession();
		Long userId = (Long) session.getAttribute("id");

		try {
			imageService.saveTask3(userId, id, "pass".equals(isPass));
		} catch (Exception e) {
			return CrowdsourcingResult.build(500, e.toString());
		}

		return CrowdsourcingResult.ok();
	}
	/*
	 * 响应图片请求
	 */
	@RequestMapping("/showOriginalImage")
	public void showOriginalImage(@RequestParam(value = "id", defaultValue = "0") Long id,
			HttpServletResponse response) {

		TbImage tbImage = imageService.getImageById(id);
		
		response.setContentType("img/jpeg");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + tbImage.getImagename());
		
		byte[] bytes = tbImage.getData();

		try (OutputStream outputStream = response.getOutputStream()) {
			StreamUtil.putBytesIntoOutputStream(outputStream, bytes);
		} catch (IOException e) {

			/** IO异常处理 **/

		}
	}

	/*
	 * 响应图片请求
	 */
	@RequestMapping("/showProcessedImage")
	public void showProcessedImage(@RequestParam(value = "id", defaultValue = "0") Long id,
			HttpServletResponse response) {

		TbImage tbImage = imageService.getImageById(id);
		response.setContentType("img/jpeg");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + tbImage.getImagename());
		
		TbRecord tbRecord = recordService.getRecordByImageId(id);
		byte[] bytes = null;

		try {
			bytes = ImageUtil.imageDrawLine(tbImage.getData(), tbRecord.getX(), tbRecord.getY(), tbRecord.getWidth(),
					tbRecord.getHeight(), Color.YELLOW);
		} catch (IOException e) {

			/** 图片加工异常处理 **/

		}

		try (OutputStream outputStream = response.getOutputStream()) {
			StreamUtil.putBytesIntoOutputStream(outputStream, bytes);
		} catch (IOException e) {

			/** IO异常处理 **/

		}
	}
	/*
	 * 页面跳转
	 */
	@RequestMapping("/listPage")
	public String listPage() {
		return "image/image-list";
	}
	/*
	 * 完成图片显示
	 */
	@RequestMapping("/list")
	@ResponseBody
	public CrowdsourcingResult list(String keyword, String date) {
		
		try {
			keyword = URLDecoder.decode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return CrowdsourcingResult.build(500, "编码异常");
		}
		
		List<Long> list = null;
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			list = imageService.getIdOfImages(keyword, dateFormat.parse(date), 4);
		} catch (Exception e) {
			return CrowdsourcingResult.build(500, e.toString());
		}
		
		return CrowdsourcingResult.build(200, "", list);
	}
	
	/*
	 * 图片打包下载
	 */
	@RequestMapping("/zip")
	public void zip(String keyword, String date, HttpServletResponse response) {
		
		try {
			keyword = URLDecoder.decode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		
		response.setContentType("application/zip");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + date + ".zip");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<TbImage> list = null;
		try {
			list = imageService.getImages(keyword, dateFormat.parse(date), 4);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		try (ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream())){
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < list.size(); i++) {
				TbImage tbImage = list.get(i);
				String imageName = tbImage.getImagename();
				if (map.containsKey(imageName)) {
					Integer value = map.get(imageName);
					map.put(imageName, value + 1);
					imageName = "(" + value + ")" + imageName;
				} else {
					map.put(imageName, 1);
				}
				ZipEntry zipEntry = new ZipEntry(imageName);
				zipOutputStream.putNextEntry(zipEntry);
				zipOutputStream.write(tbImage.getData(), 0, tbImage.getData().length);
			}
		} catch (IOException e) {
			
		}
		
	}
	
	/*
	 * 页面跳转
	 */
	@RequestMapping("/task/t/{taskId}")
	public String taskTPage(@PathVariable int taskId) {
		return "image/image-taskT" + taskId;
	}
}
