package com.app4m.app.user.service.interfaces;

import java.util.List;
import java.util.Map;

import com.app4m.app.user.entity.AppUser;
import com.app4m.app.user.entity.userRelation.impl.RelationOperate;

public interface IUserRelationService {
	public int           saveOrUpdateRelation(Map<String,String> map,RelationOperate relationOperate);
	public List<AppUser> selectFollows(Map<String,String> map);
	public Integer       selectFollowsCount(Map<String,String> map);
	public List<AppUser> selectFans(Map<String,String> map);
	public Integer 		 selectFansCount(Map<String,String> map);
	public List<AppUser> selectStrangers(Map<String,String> map);
}
