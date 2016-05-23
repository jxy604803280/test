package test.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.app4m.app.user.entity.AppUser;



public class MybatisTest {
	@SuppressWarnings("unused")
	@Test
	public void judgeEnv() throws IOException{
		String resource = "config/mybatis.xml";
		Reader reader = Resources.getResourceAsReader(resource);
	        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
	        SqlSession session = null;
	        try {
	            session = factory.openSession();
	            AppUser appUser = new AppUser();
	            appUser.setAppUserName("mac");
	            appUser.setPassword("123");
	            int result = session.insert("com.app4m.app.login.dao.interfaces.ILoginDao",appUser);
	        }
	        finally {
	        	System.out.println();
	        	System.out.println("6666666");
	        	System.out.println();
	        	System.out.println();
	            session.close();
	            System.out.println("555555");
	        }
	}
	        
}
