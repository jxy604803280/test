package com.app4m.app.cmind.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import base.dao.BaseDao;

import com.app4m.app.cmind.dao.interfaces.ICmindDao;
import com.app4m.app.cmind.entity.Cmind;

@Repository("cmindDao")
public class CmindDaoImpl extends BaseDao implements ICmindDao {

	public List<Cmind> selectCminds() {
		// TODO Auto-generated method stub
		return getSqlSessionTemplate().selectList("com.app4m.mybatis.mapper.cmindMapper.selectCminds");
	}

	public void insertCmind(Cmind cmind) {
		// TODO Auto-generated method stub
		getSqlSessionTemplate().insert("com.app4m.mybatis.mapper.cmindMapper.insertCmind",cmind);
	}

}
