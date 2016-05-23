package com.app4m.app.cmind.entity;

import base.entity.BaseEntity;

@SuppressWarnings("serial")
class Reply extends BaseEntity{
	private String replyId;//replyId
	private String replyContext;//�ظ�����
	private String cmindId;//������Cmind
	private String targetReplyId;//���ظ�����Ϊreply,���¼��id
	private String senderName;//�������ǳ�
	private String receiverName;//���Զ��������
	private String replyDate;//�ظ�����
	private int    replyDelFlag; 
	public int getReplyDelFlag() {
		return replyDelFlag;
	}
	public void setReplyDelFlag(int replyDelFlag) {
		this.replyDelFlag = replyDelFlag;
	}
	public String getTargetReplyId() {
		return targetReplyId;
	}
	public void setTargetReplyId(String targetReplyId) {
		this.targetReplyId = targetReplyId;
	}
	
	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public String getReplyContext() {
		return replyContext;
	}
	public void setReplyContext(String replyContext) {
		this.replyContext = replyContext;
	}
	public String getCmindId() {
		return cmindId;
	}
	public void setCmindId(String cmindId) {
		this.cmindId = cmindId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	
}
