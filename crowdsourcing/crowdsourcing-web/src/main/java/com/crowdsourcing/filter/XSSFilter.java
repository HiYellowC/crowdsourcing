package com.crowdsourcing.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crowdsourcing.request.wrapper.XSSRequestWrapper;

/***
* 防XSS攻击的过滤器 
* @author  HiYellowC
* @date 创建时间：2017年4月23日 下午8:09:50 
* @version 1.0 * @parameter  
* @since  
* @return
*/

public class XSSFilter implements Filter {

	@SuppressWarnings("unused")
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		resp.setHeader("SET-COOKIE", "JSESSIONID=" + req.getSession().getId() + "; HttpOnly");
		chain.doFilter(new XSSRequestWrapper((HttpServletRequest)request), response);
	}

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

}
