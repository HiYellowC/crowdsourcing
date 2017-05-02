package com.crowdsourcing.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.crowdsourcing.common.pojo.Rectangle;
import com.crowdsourcing.common.util.JsonUtil;
import com.crowdsourcing.common.util.StringUtil;
import com.crowdsourcing.jedis.JedisClient;
import com.crowdsourcing.mapper.TbImageMapper;
import com.crowdsourcing.pojo.TbImage;
import com.crowdsourcing.pojo.TbImageExample;
import com.crowdsourcing.pojo.TbImageExample.Criteria;

@Service
public class ImageService {

	@Autowired
	private TbImageMapper tbImageMapper;
	
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_IMAGE_KEY}")
	private String REDIS_IMAGE_KEY;
	
	@Value("${UNAVAILABLE_IMAGE_KEY}")
	private String UNAVAILABLE_IMAGE_KEY;
	
	public void saveImage(String imagename, byte[] data, String keyword, Long createUserId) 
			throws Exception{
		TbImage image = new TbImage();
		
		image.setImagename(imagename);
		image.setKeyword(keyword);
		image.setData(data);
		image.setStep(3);
		image.setCreateUserId(createUserId);
		image.setGmtCreate(new Date());
		image.setGmtModified(new Date());
		
		tbImageMapper.insert(image);
	}
	
	public TbImage getImageByLastEditorIdAndStep(Long editorId, int step) throws Exception{
		TbImageExample tbImageExample = new TbImageExample();
		Criteria criteria1 = tbImageExample.createCriteria();
		
		criteria1.andLastEditorIdNotEqualTo(editorId);
		criteria1.andStepEqualTo(step);
		Criteria criteria2 = tbImageExample.or();
		criteria2.andLastEditorIdIsNull();
		criteria2.andStepEqualTo(step);
		tbImageExample.setOrderByClause("gmt_modified DESC");
		
		//获得符合查询条件的image列表
		List<TbImage> list = tbImageMapper.selectByExampleWithBLOBs(tbImageExample);
		//获得空闲状态的image
		Iterator<TbImage> it = list.iterator();
		while (it.hasNext()) {
			TbImage tbImage = it.next();
			Long id = tbImage.getId();
			String unavailableImageValue = jedisClient.get(UNAVAILABLE_IMAGE_KEY + id); 
			if (StringUtil.isBlankString(unavailableImageValue) || 
					(editorId + "").equals(unavailableImageValue)) {
				
				//给当前image上锁，防止重复编辑，时限120s
				jedisClient.set(UNAVAILABLE_IMAGE_KEY + id, editorId + "");
				jedisClient.expire(UNAVAILABLE_IMAGE_KEY + id, 120);
				
				//添加到缓存
				try {
					jedisClient.hset(REDIS_IMAGE_KEY, tbImage.getId() + "", JsonUtil.objectToJson(tbImage));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return tbImage;
			}
		}
		
		return null;
	}
	
	public void saveTask1(Long id, Rectangle rectangle) throws Exception{
		
		updateImageByIdSelective(rectangle.getId(), 2, id);
		recordService.saveRecord(1, id, rectangle);
		userService.updateUserQuantityById(id, 1);
		
	}
	
	public void saveTask2(Long id, Rectangle rectangle, byte[] data, Long lastEditorId) throws Exception{
		updateImageByIdWithBLOBs(rectangle.getId(), 3, id, data);
		recordService.saveRecord(2, id, rectangle, true);
		userService.updateUserQuantityById(id, 2);
		userService.updateUserQuantityById(lastEditorId, 5);
	}
	
	public void saveTask2(Long id, Rectangle rectangle, Long lastEditorId) throws Exception{
		updateImageByIdSelective(rectangle.getId(), 1, id);
		recordService.saveRecord(2, id, rectangle, false);
		userService.updateUserQuantityById(id, 2);
		userService.updateUserQuantityById(lastEditorId, 4);
	}
	
	public void saveTask3(Long userId, Long imageId, boolean isPass) throws Exception{
		if(isPass) {
			updateImageByIdSelective(imageId, 4, userId);
		} else {
			updateImageByIdSelective(imageId, 1, userId);
		}
		recordService.saveRecord(3, userId, imageId, isPass);
		userService.updateUserQuantityById(userId, 3);
	}
	
	public void updateImageByIdSelective(Long imageId, int step, Long userId) throws Exception{
		TbImage image = new TbImage();
		image.setId(imageId);
		image.setStep(step);
		image.setLastEditorId(userId);
		image.setGmtModified(new Date());
		tbImageMapper.updateByPrimaryKeySelective(image);
	}
	
	public void updateImageByIdWithBLOBs(Long id, int step, Long lastEditorId, byte[] data) 
			throws Exception{
		TbImage image = new TbImage();
		image.setId(id);
		image.setStep(step);
		image.setLastEditorId(lastEditorId);
		image.setData(data);
		image.setGmtModified(new Date());
		tbImageMapper.updateByPrimaryKeySelective(image);
		
		//同步缓存
		jedisClient.hdel(REDIS_IMAGE_KEY, id + "");
		
	}
	
	public TbImage getImageById(Long id) {
		
		try {
			String json = jedisClient.hget(REDIS_IMAGE_KEY, id + "");
			if (!StringUtil.isBlankString(json)) {
				TbImage tbImage = JsonUtil.jsonToObject(json, TbImage.class);
				return tbImage;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TbImage tbImage =  tbImageMapper.selectByPrimaryKey(id);
		
		return tbImage;
	}
	
	public List<Long> getIdOfImages(String keyword, Date date, int step) {
		TbImageExample tbImageExample = new TbImageExample();
		Criteria criteria = tbImageExample.createCriteria();
		criteria.andStepEqualTo(step);
		criteria.andKeywordEqualTo(keyword);
		criteria.andGmtCreateGreaterThanOrEqualTo(date);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		criteria.andGmtCreateLessThan(calendar.getTime());
		List<Long> result = tbImageMapper.selectByExampleOnlyId(tbImageExample);
		return result;
	}
	
	public List<TbImage> getImages(String keyword, Date date, int step) {
		TbImageExample tbImageExample = new TbImageExample();
		Criteria criteria = tbImageExample.createCriteria();
		criteria.andStepEqualTo(step);
		criteria.andKeywordEqualTo(keyword);
		criteria.andGmtCreateGreaterThanOrEqualTo(date);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		criteria.andGmtCreateLessThan(calendar.getTime());
		List<TbImage> result = tbImageMapper.selectByExampleWithBLOBs(tbImageExample);
		return result;
	}
	
}
