package com.app4m.app.user.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.service.BaseService;

import com.app4m.app.user.dao.interfaces.IUserDao;
import com.app4m.app.user.entity.AppUser;
import com.app4m.app.user.service.interfaces.IUserService;


@Service(value="userService")
public class UserServiceImpl extends BaseService implements IUserService{
	@Resource(name="userDao")
	private IUserDao userDao;
	/**
	 * 此处有个发邮件的aop. 在aop。mail包下
	* @author:jason.jiang
	* @Date 2016-3-27
	* @Description: 新注册用户
	* @param @param appUser
	* @return    返回0表示插入成功，-1表示邮箱已被注册
	* @throws 
	*
	 */
	public AppUser insertAppUser(AppUser appUser) {
		AppUser appUserTemp = userDao.selectAppUser(appUser);
		if(appUserTemp == null||appUserTemp.getId() == null || appUserTemp.getId() == ""){
			userDao.insertAppUser(appUser);
			appUser.setMessage("请去邮箱激活邮件");
			return appUser;
		}
		appUserTemp.setMessage("该邮箱已被注册");
		return appUserTemp;
	}
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-3-27
	* @Description: 修改用户信息，包括注销用户
	* @param @param appUser
	* @param @return    
	* @throws 
	*
	 */
	public String updateAppUser(AppUser appUser) {
		userDao.updateAppUser(appUser);
		return "success";
	}

	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-3-27
	* @Description: 查询用户信息
	* @param @param id
	* @param @return    
	* @throws 
	*
	 */
	public AppUser userInfo(AppUser appUser) {
		// TODO Auto-generated method stub
		return userDao.selectAppUser(appUser);
	}

	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-3-31
	* @Description: 登录验证
	* @param @param appUser
	* @param @return    "success"  表明登录成功
	* @throws 
	*
	 */
	@Transactional
	public AppUser login(AppUser appUser) {
		AppUser appUserTemp = userDao.selectAppUser(appUser);
		//如果查询出有目的邮箱注册的用户  ，且密码匹配的话则返回success,若不匹配则返回密码错误，若用户不存在，则说明该邮箱未注册
		if(null!=appUserTemp){
			if(appUserTemp.getPassword().equals(appUser.getPassword())){
				switch(appUserTemp.getStatus()){
					case AppUser.ACTIVEDSTATUS :
						appUserTemp.setMessage("success");
						break;
					case AppUser.ACTIVINGSTATUS:
						appUserTemp.setMessage("noActive");
						break;
					default : appUserTemp.setMessage("您的账号有异样，已被注销或者冻结");					
				}
					
			}else{
				//为安全起见，先把查询出的密码置空，避免误用
				appUserTemp.setPassword("");
				appUserTemp.setMessage("wrongPassword");
			}
		}else{
			appUserTemp = appUser;
			appUserTemp.setMessage("noExists");
		}
		return appUserTemp;
	}


}
