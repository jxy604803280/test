package base.utils.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanManager {
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object getBean(Class targetClass){
		Object obj = applicationContext.getBean(targetClass);
		return obj;
	}
	public static Object getBean(String id){
		Object obj = applicationContext.getBean(id);
		return obj;
	}
}
