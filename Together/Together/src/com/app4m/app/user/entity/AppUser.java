package com.app4m.app.user.entity;

import javax.persistence.Transient;

import base.entity.BaseEntity;

/**
 * 
* @ClassName: AppUser 
* @Description: �û��� 
* @author jason.jiang 
* @date 2016-3-20 ����3:02:35 
*
 */
@SuppressWarnings("serial")
public class AppUser extends BaseEntity{
	private String id;//��ʶ��������
	private String userAccount;//�û��˺�
	private String appUserName;//�û�����
	private String password;//����
	private String userMail;
	private String activeCode;
	//�û���ϵ 0.�໥��ע 1.small��עbig 2.small��עbig big����small -1.big��עsmall��  -2.small����big big��עsmall -10.�໥���� -11.small����big,big��״̬ -12.big����small,small��״̬
	private String relationStatus;
	private int status;//�û�״̬  0������δ����״̬  -1���˺Ŷ���  1.����״̬
	private int newMessages;//�ж��Ƿ�������Ϣδ����1��ʾ�У�0��ʾľ��
	
	@Transient
	public final static int ACTIVEDSTATUS  = 1;
	@Transient
	public final static int ACTIVINGSTATUS = 0;
	@Transient
	public final static int DESTROYSTATUS =-1;
	@Transient
	String message;//���������û��Ƿ����
	public String getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getAppUserName() {
		return appUserName;
	}
	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public String getRelationStatus() {
		return relationStatus;
	}
	public void setRelationStatus(String relationStatus) {
		this.relationStatus = relationStatus;
	}
	public int getNewMessages() {
		return newMessages;
	}
	public void setNewMessages(int newMessages) {
		this.newMessages = newMessages;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
} 