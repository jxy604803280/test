package com.app4m.app.user.entity;

import java.util.HashMap;
import java.util.Map;

import base.entity.BaseEntity;

import com.app4m.app.user.entity.userRelation.impl.RelationOperate;


@SuppressWarnings("serial")
public class UserRelations extends BaseEntity{
	//�໥��ע
	public static final String INTER_FOLLOW     = "0";
	//�໥����
	public static final String INTER_DEFRIEND   = "-10";
	//Сid��ע���id
	public static final String SMALL_FOLLOW_BIG = "1";
	//��id��עСid
	public static final String BIG_FOLLOW_SMALL = "-1";
	//Сid���ڴ�id
	public static final String SMALL_DEFRIEND_BIG = "-11";
	//��id����Сid
	public static final String BIG_DEFRIEND_SMALL ="-12";
	//Сid��ע��id,��id����Сid
	public static final String SMALLF_BIGDF = "2";
	//��id��עСid,С id���ڴ�id
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
	* @Description: ��ѯ�û���ϵMap
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
	* @Description: �û���ϵ�����Ļ���map
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
	* @Description: �����û�����map������map
	* @param @param map
	* @param @param relationOperater
	* @param @return    
	* @return Map<String,String>   
	* @throws
	 */
	public static Map<String,String> getFinalOperateMap(Map<String,String> map,RelationOperate relationOperate){
		//˵�����ݿ��в����ڼ�¼
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
						map.put("relationStatus", null);//ȡ�����޹�ϵ��Ϊ��
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
	
	
	//����Ϊget set ����
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
