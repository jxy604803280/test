package com.app4m.app.user.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* @ClassName: LoginFilter 
* @Description: 将未登录用户重定向回到登录页面 
* @author jason.jiang 
* @date 2016-3-27 上午11:54:03 
*
 */

public class LoginFilter implements Filter {
	private String[] allowedUrls;
	private String redirectUrl;
	private FilterConfig filterConfig;
	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest  req  = (HttpServletRequest)  request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		allowedUrls = filterConfig.getInitParameter("allowedUrls").split(",");
		for(String allowedUrl : allowedUrls){
			if(req.getRequestURI().toString().equals(allowedUrl)||(session!=null&&session.getAttribute("appUser")!=null)){
				filterChain.doFilter(req, resp);
				return;
			}
		}
		resp.sendRedirect(req.getContextPath()+redirectUrl);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = filterConfig;
		//获取初始参数
		redirectUrl=filterConfig.getInitParameter("redirectUrl");
	}

}
