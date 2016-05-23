package com.app4m.app.user.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import base.dao.BaseDao;

import com.app4m.app.user.dao.interfaces.IUserRelationDao;
import com.app4m.app.user.entity.AppUser;
import com.app4m.app.user.entity.UserRelations;
@Repository("userRelationDao")
public class UserRelationDaoImpl extends BaseDao implements IUserRelationDao {
	//	查询我关注的人
	public List<AppUser> selectFollows(Map<String,String> map){
		List<AppUser> list = this.getSqlSessionTemplate().selectList("com.app4m.mybatis.mapper.userRelationMapper.selectFollows", map);
		return list;
	}
	
	//查询我关注的人的数量
	public Integer selectFollowsCount(Map<String,String> map){
		return this.getSqlSessionTemplate().selectOne("com.app4m.mybatis.mapper.userRelationMapper.selectFollowsCount", map);
	}
	
	//  查询粉丝
	public List<AppUser> selectFans(Map<String,String> map){
		List<AppUser> list = this.getSqlSessionTemplate().selectList("com.app4m.mybatis.mapper.userRelationMapper.selectFans", map);
		return list;
	}
	
	//查询粉丝数量
	public Integer selectFansCount(Map<String,String> map){
		return this.getSqlSessionTemplate().selectOne("com.app4m.mybatis.mapper.userRelationMapper.selectFansCount", map);
	}
	
	//推荐陌生人
	public List<AppUser> selectStrangers(Map<String,String> map){
		return this.getSqlSessionTemplate().selectList("com.app4m.mybatis.mapper.userRelationMapper.selectStrangers", map);
	}

	//插入操作关系
	public Integer insertUserRelation(Map<String, String> map) {
		// TODO Auto-generated method stub
		return this.getSqlSessionTemplate().insert("com.app4m.mybatis.mapper.userRelationMapper.insertUserRelation", map);
	}
	//更新用户关系
	public Integer updateUserRelation(Map<String, String> map) {
		// TODO Auto-generated method stub
		return this.getSqlSessionTemplate().update("com.app4m.mybatis.mapper.userRelationMapper.updateUserRelation", map);
	}
	//查询用户关系
	public UserRelations selectUserRelation(Map<String, String> map) {
		return this.getSqlSessionTemplate().selectOne("com.app4m.mybatis.mapper.userRelationMapper.selectUserRelation", map);
	}

}
