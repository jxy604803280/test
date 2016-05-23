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
	 * �˴��и����ʼ���aop. ��aop��mail����
	* @author:jason.jiang
	* @Date 2016-3-27
	* @Description: ��ע���û�
	* @param @param appUser
	* @return    ����0��ʾ����ɹ���-1��ʾ�����ѱ�ע��
	* @throws 
	*
	 */
	public AppUser insertAppUser(AppUser appUser) {
		AppUser appUserTemp = userDao.selectAppUser(appUser);
		if(appUserTemp == null||appUserTemp.getId() == null || appUserTemp.getId() == ""){
			userDao.insertAppUser(appUser);
			appUser.setMessage("��ȥ���伤���ʼ�");
			return appUser;
		}
		appUserTemp.setMessage("�������ѱ�ע��");
		return appUserTemp;
	}
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-3-27
	* @Description: �޸��û���Ϣ������ע���û�
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
	* @Description: ��ѯ�û���Ϣ
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
	* @Description: ��¼��֤
	* @param @param appUser
	* @param @return    "success"  ������¼�ɹ�
	* @throws 
	*
	 */
	@Transactional
	public AppUser login(AppUser appUser) {
		AppUser appUserTemp = userDao.selectAppUser(appUser);
		//�����ѯ����Ŀ������ע����û�  ��������ƥ��Ļ��򷵻�success,����ƥ���򷵻�����������û������ڣ���˵��������δע��
		if(null!=appUserTemp){
			if(appUserTemp.getPassword().equals(appUser.getPassword())){
				switch(appUserTemp.getStatus()){
					case AppUser.ACTIVEDSTATUS :
						appUserTemp.setMessage("success");
						break;
					case AppUser.ACTIVINGSTATUS:
						appUserTemp.setMessage("noActive");
						break;
					default : appUserTemp.setMessage("�����˺����������ѱ�ע�����߶���");					
				}
					
			}else{
				//Ϊ��ȫ������ȰѲ�ѯ���������ÿգ���������
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
