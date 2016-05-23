package com.app4m.app.user.entity;

import javax.persistence.Transient;

import base.entity.BaseEntity;

/**
 * 
* @ClassName: AppUser 
* @Description: 用户类 
* @author jason.jiang 
* @date 2016-3-20 下午3:02:35 
*
 */
@SuppressWarnings("serial")
public class AppUser extends BaseEntity{
	private String id;//标识符，自增
	private String userAccount;//用户账号
	private String appUserName;//用户名字
	private String password;//密码
	private String userMail;
	private String activeCode;
	//用户关系 0.相互关注 1.small关注big 2.small关注big big拉黑small -1.big关注small的  -2.small拉黑big big关注small -10.相互拉黑 -11.small拉黑big,big无状态 -12.big拉黑small,small无状态
	private String relationStatus;
	private int status;//用户状态  0。邮箱未激活状态  -1：账号冻结  1.正常状态
	private int newMessages;//判断是否有新信息未读，1表示有，0表示木有
	
	@Transient
	public final static int ACTIVEDSTATUS  = 1;
	@Transient
	public final static int ACTIVINGSTATUS = 0;
	@Transient
	public final static int DESTROYSTATUS =-1;
	@Transient
	String message;//用于描述用户是否存在
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