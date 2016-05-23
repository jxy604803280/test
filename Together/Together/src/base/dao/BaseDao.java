package base.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

public class BaseDao {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public SqlSession getSession(){
		return sqlSessionFactory.openSession();
	}
	
}
