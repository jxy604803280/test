package com.app4m.app.user.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RegisterMailInterceptor implements HandlerInterceptor {
	@Resource
	private JavaMailSender javaMailSender;
	@Resource 
	private SimpleMailMessage simpleMailMessage;
	
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub
		String targetMailAddress = request.getParameter("userMail");
		if(targetMailAddress==null || targetMailAddress ==""){
			return false;
		}
		simpleMailMessage.setTo(targetMailAddress);
		javaMailSender.send(simpleMailMessage);
		return true;
	}

}
