package com.crowdsourcing.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.crowdsourcing.common.util.RegexUtil;
import com.crowdsourcing.pojo.TbUser;
import com.crowdsourcing.service.UserService;

public class TaskPageInterceptor implements HandlerInterceptor {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String URI = request.getRequestURI();
		if(RegexUtil.isMatchCustomRegex(URI, "/image/task/[1-3]")) {
			int taskId = Integer.valueOf(URI.substring(URI.length() - 1, URI.length()));
			Session session = SecurityUtils.getSubject().getSession();
			Long id = (Long) session.getAttribute("id");
			TbUser user = userService.getUserById(id);
			int permission = user.getPermission();
			if ((permission & (1 << (taskId - 1))) == 0) {
				response.sendRedirect("/image/task/t/" + taskId);
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
