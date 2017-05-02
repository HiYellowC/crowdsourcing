package com.crowdsourcing.controller;


import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.crowdsourcing.common.pojo.CrowdsourcingResult;
import com.crowdsourcing.pojo.TbUser;
import com.crowdsourcing.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/*
	 * 页面跳转
	 */
	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/";
	}
	
	/*
	 * 登陆
	 */
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String username, String password, Model model) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
		} catch(UnknownAccountException e) {
			model.addAttribute("errorInfo", "用户名或密码错误");
			return "user/user-login";
		} catch(IncorrectCredentialsException e) {
			model.addAttribute("errorInfo", "用户名或密码错误");
			return "user/user-login";
		} catch (LockedAccountException e) {
			model.addAttribute("errorInfo", "该账号被冻结，请联系管理员");
			return "user/user-login";
		}
		 return "redirect:/";
	}
	
	/*
	 * 页面跳转
	 */
	
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "user/user-login";
	}
	
	/*
	 * 注册 
	 */
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(String username, String password, Model model) {
		
		try {
			userService.saveUser(username, password);
		} catch (DuplicateKeyException e) {
			model.addAttribute("errorInfo", "此用户名已被注册");
			return "user/user-register";
		} catch (Exception e) {
			model.addAttribute("errorInfo", "未知错误，请联系管理员");
			return "user/user-register";
		}
		
		Subject subject = SecurityUtils.getSubject();
		subject.login(new UsernamePasswordToken(username, password));
		
		return "redirect:/";
	}
	
	/*
	 * 页面跳转
	 */
	@RequestMapping("/registerPage")
	public String registerPage() {
		return "user/user-register";
	}
	/*
	 * 页面跳转
	 */
	@RequestMapping("/listPage")
	public String listPage() {
		return "user/user-list";
	}
	
	/*
	 * 获得全部用户的列表
	 * status:
	 * 200 操作成功
	 * 500发生异常
	 * msg:
	 * 发生异常时为异常详情
	 * data:
	 * 成功时为用户列表
	 */
	@RequestMapping("/list")
	@ResponseBody
	public CrowdsourcingResult list() {
		List<TbUser> users = null;
		
		try {
			users = userService.getUsers();
		} catch (Exception e) {
			return CrowdsourcingResult.build(500, e.toString());
		}
		
		return CrowdsourcingResult.build(200, "", users);
	}
	
	/* 解锁用户 userId: 用户Id
	 * status:
	 * 200 操作成功
	 * 500发生异常
	 * msg:
	 * 发生异常时为异常详情
	 */
	@RequestMapping("/unlock/{userId}")
	@ResponseBody
	public CrowdsourcingResult unlock(@PathVariable Long userId) {
		
		try {
			userService.updateUserLockById(userId, false);
		} catch (Exception e) {
			return CrowdsourcingResult.build(500, e.toString());
		}
		
		return CrowdsourcingResult.ok();
	}
	
	/* 冻结用户 userId: 用户Id
	 * status:
	 * 200 操作成功
	 * 500发生异常
	 * msg:
	 * 发生异常时为异常详情
	 */
	@RequestMapping("/lock/{userId}")
	@ResponseBody
	public CrowdsourcingResult lock(@PathVariable Long userId) {
		
		try {
			userService.updateUserLockById(userId, true);
		} catch (Exception e) {
			return CrowdsourcingResult.build(500, e.toString());
		}
		
		return CrowdsourcingResult.ok();
	}
	
	
	/*
	 * 获取个人信息
	 */
	@RequestMapping("/info")
	public String info(Model model) {
		Session session = SecurityUtils.getSubject().getSession();
		Long id = (Long) session.getAttribute("id");
		
		TbUser tbUser = userService.getUserById(id);
		
		model.addAttribute("user", tbUser);
		return "user/user-info";
	}
	
	/*
	 * 修改用户权限
	 */
	@RequestMapping(value="/permission/{taskId}", method=RequestMethod.POST)
	@ResponseBody
	public CrowdsourcingResult taskTF(@PathVariable int taskId) {
		Session session = SecurityUtils.getSubject().getSession();
		Long id = (Long) session.getAttribute("id");
		
		try {
			userService.updateUserPermissionById(id, taskId);
		} catch (Exception e) {
			return CrowdsourcingResult.build(500, e.toString());
		}
		return CrowdsourcingResult.ok();
	}
}
