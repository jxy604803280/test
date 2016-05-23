package com.app4m.app.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app4m.app.user.dao.interfaces.IUserRelationDao;
import com.app4m.app.user.entity.AppUser;
import com.app4m.app.user.entity.UserRelations;
import com.app4m.app.user.entity.userRelation.impl.RelationOperate;
import com.app4m.app.user.service.interfaces.IUserRelationService;

@Service("userRelationService")
public class UserRelationServiceImpl implements IUserRelationService {
	@Resource(name="userRelationDao")
	private IUserRelationDao userRelationDao;

	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-28
	* @Description: 更新或新建用户关系
	* @param @param map
	* @param @param relationOperate
	* @param @return    
	* @throws 
	*
	 */
	@Transactional
	public int saveOrUpdateRelation(Map<String, String> map,RelationOperate relationOperate) {
		UserRelations userRelation = userRelationDao.selectUserRelation(map);
		if(userRelation != null && userRelation.getRelationStatus() != null && !userRelation.getRelationStatus().equals("")){
			map.put("id",userRelation.getId());
			map.put("currentRelation", userRelation.getRelationStatus());
		}
		map = UserRelations.getFinalOperateMap(map, relationOperate);
		if(!map.containsKey("currentRelation")){
			userRelationDao.insertUserRelation(map);
		}else{
			userRelationDao.updateUserRelation(map);
		}
		return 0;
	}
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-24
	* @Description: 查询我关注的人
	* @param @param map
	* @param @return    
	* @throws 
	*
	 */
	public List<AppUser> selectFollows(Map<String, String> map) {
		return userRelationDao.selectFollows(map);
	}

	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-24
	* @Description: 查询我关注的人的数量
	* @param @param map
	* @param @return    
	* @throws 
	*
	 */
	public Integer selectFollowsCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userRelationDao.selectFollowsCount(map);
	}

	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-24
	* @Description: 查询粉丝
	* @param @param map
	* @param @return    
	* @throws 
	*
	 */
	public List<AppUser> selectFans(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userRelationDao.selectFans(map);
	}

	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-24
	* @Description: 查询粉丝数量
	* @param @param map
	* @param @return    
	* @throws 
	*
	 */
	public Integer selectFansCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userRelationDao.selectFansCount(map);
	}

	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-24
	* @Description: 查询陌生人
	* @param @param map
	* @param @return    
	* @throws 
	*
	 */
	public List<AppUser> selectStrangers(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userRelationDao.selectStrangers(map);
	}

	


}
