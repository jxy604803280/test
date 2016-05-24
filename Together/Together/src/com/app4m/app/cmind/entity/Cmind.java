package com.app4m.app.cmind.entity;

import java.util.List;

import base.entity.BaseEntity;
/**
 * 
* @ClassName: Cmind 
* @Description: TODO 
* @author jason.jiang 
* @date 2016-5-17 ����5:24:21 
*
 */

@SuppressWarnings("serial")
public class Cmind extends BaseEntity{
	private String  cmindId; //Cmind��id
	private String  userId;//�û�id
	private String  context;//��������
	private String  photoAddress; //��ͼ��ַ
	private List<Reply> replyList; //��Cmind����ػظ�
	private String  cmindDate;//����Cmind��ʱ��
	private int     cmindDelFlag;//-1��ʾɾ��
	public final static String DELFLAG = "-1";  
	public String getCmindId() {
		return cmindId;
	}
	public void setCmindId(String cmindId) {
		this.cmindId = cmindId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPhotoAddress() {
		return photoAddress;
	}
	public void setPhotoAddress(String photoAddress) {
		this.photoAddress = photoAddress;
	}
	public List<Reply> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	public String getCmindDate() {
		return cmindDate;
	}
	public void setCmindDate(String cmindDate) {
		this.cmindDate = cmindDate;
	}
	public int getCmindDelFlag() {
		return cmindDelFlag;
	}
	public void setCmindDelFlag(int cmindDelFlag) {
		this.cmindDelFlag = cmindDelFlag;
	}
	
}
