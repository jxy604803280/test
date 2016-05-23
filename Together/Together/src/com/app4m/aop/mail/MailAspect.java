package com.app4m.aop.mail;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.app4m.app.user.entity.AppUser;

/**
 * ��ľ������
* @ClassName: MailUtils 
* @Description: TODO 
* @author jason.jiang 
* @date 2016-3-29 ����11:38:48 
*
 */
@Component("mailAspect")
@Aspect
public class MailAspect{
	private static ExecutorService executorService = Executors.newCachedThreadPool();
	@Resource(name="mailRunnable")
	private MailRunnableImpl mailRunnable;
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-3-31
	* @Description: ���������
	* @param     
	* @return void   
	* @throws
	 */
	@SuppressWarnings("unused")
	@Pointcut("execution(* com.app4m.app.user.dao.impl.UserDaoImpl.insertAppUser(..))")
	private void targetMethod(){};
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-3-31
	* @Description: ��ִ��Ŀ�귽��ǰִ�и÷���
	* @param @param appUser    
	* @return void   
	* @throws
	 */
	@Before("targetMethod() && args(appUser)")
	public void executor(AppUser appUser){
		mailRunnable.setTo(appUser.getUserMail());
		mailRunnable.setContext("�����������Ӽ������˺�    http://localhost:8080/Together/app4m/app/user/user/activeUser?userMail=" + appUser.getUserMail() + "&&activeCode=" + appUser.getActiveCode());
		executorService.submit(mailRunnable);
	}
}