package com.app4m.app.user.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.app4m.app.user.entity.AppUser;
import com.app4m.app.user.entity.UserRelations;

public interface IUserRelationDao {
	public List<AppUser> selectFollows(Map<String,String> map);
	public Integer 		 selectFollowsCount(Map<String,String> map);
	public List<AppUser> selectFans(Map<String,String> map);
	public Integer 		 selectFansCount(Map<String,String> map);
	public List<AppUser> selectStrangers(Map<String,String> map);
	public Integer 		 insertUserRelation(Map<String,String> map);
	public UserRelations selectUserRelation(Map<String,String> map);
	public Integer	     updateUserRelation(Map<String,String> map);
}
