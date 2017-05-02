package com.crowdsourcing.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.crowdsourcing.common.util.StringUtil;
import com.crowdsourcing.jedis.JedisClient;

public class TaskInterceptor implements HandlerInterceptor {

	@Autowired
	private JedisClient jedisClient;
	
	@Value("${UNAVAILABLE_IMAGE_KEY}")
	private String UNAVAILABLE_IMAGE_KEY;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Session session = SecurityUtils.getSubject().getSession();
		String editorId = (Long) session.getAttribute("id") + "";
		String id = request.getParameter("id");
		if (StringUtil.isEqualString(editorId, jedisClient.get(UNAVAILABLE_IMAGE_KEY + id))) {
			System.out.println("------------true------------");
			return true;
		}
		System.out.println("------------false------------");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//解锁
		String id = request.getParameter("id");
		jedisClient.del(UNAVAILABLE_IMAGE_KEY + id);

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
