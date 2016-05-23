package com.app4m.aop.mail;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component("mailRunnable")
@Scope(value="prototype")
public class MailRunnableImpl implements Runnable {
	@Resource
	private JavaMailSenderImpl javaMailSenderImpl;
	@Resource
	private SimpleMailMessage simpleMailMessage;
	public void run() {
		javaMailSenderImpl.send(simpleMailMessage);
	}
	public void setTo(String targetMailAddress){
		simpleMailMessage.setTo(targetMailAddress);
	}
	public void setContext(String mailContext){
		simpleMailMessage.setText(mailContext);
	}

}
