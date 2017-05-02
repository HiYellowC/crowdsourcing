package com.crowdsourcing.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.crowdsourcing.common.util.StringUtil;

/***
* 
* @author  HiYellowC
* @date 创建时间：2017年3月15日 下午6:02:46 
* @version 1.0 * @parameter  
* @since  
* @return
*/

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (StringUtil.isBlankString(username) || StringUtil.isBlankString(password)) {
			response.sendRedirect("/user/loginPage");
			return false;
		}
		return true;
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
