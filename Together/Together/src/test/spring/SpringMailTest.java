package test.spring;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import test.base.BaseTestOnSpring;

import com.app4m.app.user.dao.impl.UserDaoImpl;

public class SpringMailTest extends BaseTestOnSpring{
	@Resource
	JavaMailSenderImpl mailSender;
	@Resource(name="userDao")
	UserDaoImpl appUserDao;
	@Resource
	SimpleMailMessage simpleMailMessage;
	@Test
	public void startMail(){
		simpleMailMessage.setTo("604803280@qq.com");
		mailSender.send(simpleMailMessage);

	}
}

