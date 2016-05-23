package com.app4m.app.user.entity;

import java.util.HashMap;
import java.util.Map;

import base.entity.BaseEntity;

import com.app4m.app.user.entity.userRelation.impl.RelationOperate;


@SuppressWarnings("serial")
public class UserRelations extends BaseEntity{
	//相互关注
	public static final String INTER_FOLLOW     = "0";
	//相互拉黑
	public static final String INTER_DEFRIEND   = "-10";
	//小id关注大的id
	public static final String SMALL_FOLLOW_BIG = "1";
	//大id关注小id
	public static final String BIG_FOLLOW_SMALL = "-1";
	//小id拉黑大id
	public static final String SMALL_DEFRIEND_BIG = "-11";
	//大id拉黑小id
	public static final String BIG_DEFRIEND_SMALL ="-12";
	//小id关注大id,大id拉黑小id
	public static final String SMALLF_BIGDF = "2";
	//大id关注小id,小 id拉黑大id
	public static final String BIGF_SMALLDF = "-2";
	private String id;
	private String smallId;
	private String bigId;
	private String relationStatus;
	
	public String getRelationStatus() {
		return relationStatus;
	}

	public void setRelationStatus(String relationStatus) {
		this.relationStatus = relationStatus;
	}

	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-25
	* @Description: 查询用户关系Map
	* @param @param appUser
	* @param @return    
	* @return Map<String,String>   
	* @throws
	 */
	public static Map<String,String> getSelectMap(String userId){
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", userId);
		map.put("smallFollowStatus", UserRelations.INTER_FOLLOW);
		map.put("deFriendStatus"   , UserRelations.INTER_DEFRIEND);
		map.put("bigFollowStatus"  , UserRelations.INTER_FOLLOW);
		return map;
	}
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-28
	* @Description: 用户关系操作的基本map
	* @param @param currentUserId
	* @param @param targetId
	* @param @return    
	* @return Map<String,String>   
	* @throws
	 */
	public static Map<String,String> getUserOperateMap(String currentUserId,String targetId){
		int smallId = Integer.parseInt(targetId);
		int bigId 	= Integer.parseInt(currentUserId);
		Map<String,String> map = new HashMap<String,String>();
		map.put("isTargetIdSmall","true");
		if(smallId > bigId){
			int tempId  = smallId;
			    smallId = bigId;
			    bigId   = tempId;
			    map.put("isTargetIdSmall", "false");
		}
		map.put("smallId", String.valueOf(smallId));
		map.put("bigId"  , String.valueOf(bigId));
		return map;
	}
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-28
	* @Description: 用于用户操作map的最终map
	* @param @param map
	* @param @param relationOperater
	* @param @return    
	* @return Map<String,String>   
	* @throws
	 */
	public static Map<String,String> getFinalOperateMap(Map<String,String> map,RelationOperate relationOperate){
		//说明数据库中不存在记录
		if(!map.containsKey("currentRelation")){
			switch(relationOperate){
				case FOLLOW :	
					map.put("relationStatus", map.get("isTargetIdSmall").equals("true")?UserRelations.BIG_FOLLOW_SMALL:UserRelations.SMALL_FOLLOW_BIG);
					break;
				case DEFRIEND:
					map.put("relationStatus", map.get("isTargetIdSmall").equals("true")?UserRelations.BIG_DEFRIEND_SMALL:UserRelations.SMALL_DEFRIEND_BIG);
					break;
			}	
		}else{
			String currentRelation = map.get("currentRelation");
			switch(relationOperate){
				case FOLLOW :	
					if(currentRelation.equals(UserRelations.SMALL_FOLLOW_BIG)||currentRelation.equals(UserRelations.BIG_FOLLOW_SMALL))
						map.put("relationStatus", UserRelations.INTER_FOLLOW);
					if(currentRelation.equals(UserRelations.SMALL_DEFRIEND_BIG))
						map.put("relationStatus",UserRelations.BIGF_SMALLDF);
					if(currentRelation.equals(UserRelations.BIG_DEFRIEND_SMALL))
						map.put("relationStatus",UserRelations.SMALLF_BIGDF);
					break;
				case CANCELFOLLOW:
					if(currentRelation.equals(UserRelations.SMALL_FOLLOW_BIG)||currentRelation.equals(UserRelations.BIG_FOLLOW_SMALL))
						map.put("relationStatus", null);//取消后无关系置为空
					if(currentRelation.equals(UserRelations.INTER_FOLLOW)){
						map.put("relationStatus",map.get("isTargetIdSmall").equals("true")?UserRelations.SMALL_FOLLOW_BIG:BIG_FOLLOW_SMALL);
					}
					if(currentRelation.equals(UserRelations.BIGF_SMALLDF))
						map.put("relationStatus",UserRelations.SMALL_DEFRIEND_BIG);
					if(currentRelation.equals(UserRelations.SMALLF_BIGDF))
						map.put("relationStatus",UserRelations.BIG_DEFRIEND_SMALL);
					break;
				case DEFRIEND:
					if(currentRelation.equals(UserRelations.SMALL_DEFRIEND_BIG)||currentRelation.equals(UserRelations.BIG_DEFRIEND_SMALL)
									||Integer.parseInt(currentRelation) < Integer.parseInt(UserRelations.INTER_DEFRIEND)){
						map.put("relationStatus", UserRelations.INTER_DEFRIEND);
					}
					if(currentRelation.equals(UserRelations.INTER_FOLLOW)){
						map.put("relationStatus",map.get("isTargetIdSmall").equals("true")?UserRelations.SMALLF_BIGDF:UserRelations.BIGF_SMALLDF);
					}
					if(currentRelation.equals(UserRelations.BIG_FOLLOW_SMALL)){
						map.put("relationStatus", map.get("isTargetIdSmall").equals("true")?UserRelations.BIG_DEFRIEND_SMALL:UserRelations.BIGF_SMALLDF);
					}
					if(currentRelation.equals(UserRelations.SMALL_FOLLOW_BIG)){
						map.put("relationStatus", map.get("isTargetIdSmall").equals("true")?SMALLF_BIGDF:SMALL_DEFRIEND_BIG);
					}
					break;
				case CANCELDEFRIEND:
					if(currentRelation.equals(UserRelations.INTER_DEFRIEND)){
						map.put("relationStatus",map.get("isTargetIdSmall").equals("true")?UserRelations.BIGF_SMALLDF:UserRelations.SMALLF_BIGDF);
					}
					if(currentRelation.equals(UserRelations.BIGF_SMALLDF) || currentRelation.equals(UserRelations.SMALLF_BIGDF))
						map.put("relationStatus",UserRelations.INTER_FOLLOW);
					if(currentRelation.equals(UserRelations.BIG_DEFRIEND_SMALL) || currentRelation.equals(UserRelations.SMALL_DEFRIEND_BIG))
						map.put("relationStatus",null);
					break;
		}
	}
		return map;
	}
	
	
	//以下为get set 方法
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getSmallId() {
		return smallId;
	}

	public void setSmallId(String smallId) {
		this.smallId = smallId;
	}

	public String getBigId() {
		return bigId;
	}

	public void setBigId(String bigId) {
		this.bigId = bigId;
	}

	

}
