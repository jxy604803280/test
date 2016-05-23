package com.app4m.app.user.dao.impl;


import org.springframework.stereotype.Repository;

import base.dao.BaseDao;

import com.app4m.app.user.dao.interfaces.IUserDao;
import com.app4m.app.user.entity.AppUser;


/** 
* @ClassName: LoginDaoImpl 
* @Description: TODO 
* @author jason.jiang 
* @date 2016-3-24 ÉÏÎç1:27:15 
*  
*/
@Repository(value="userDao")
public class UserDaoImpl extends BaseDao implements IUserDao{
	public String insertAppUser(AppUser appUser) {
		// TODO Auto-generated method stub
		this.getSqlSessionTemplate().insert("com.app4m.mybatis.mapper.appUserMapper.insertAppUser",appUser);
		return "1";
	}

	
	public String updateAppUser(AppUser appUser) {
		// TODO Auto-generated method stub
		this.getSqlSessionTemplate().update("com.app4m.mybatis.mapper.appUserMapper.updateAppUser", appUser);
		return null;
	}


	public String deleteAppUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	public AppUser selectAppUser(AppUser appUser) {
		// TODO Auto-generated method stub
		AppUser appUserTemp = this.getSqlSessionTemplate().selectOne("com.app4m.mybatis.mapper.appUserMapper.selectAppUser", appUser);
		return appUserTemp;
	}


}
