package com.app4m.app.user.service.interfaces;


import com.app4m.app.user.entity.AppUser;
public interface IUserService {
	public AppUser insertAppUser(AppUser appUser);
	public String  updateAppUser(AppUser appUser);
	public AppUser userInfo(AppUser appUser);
	public AppUser login(AppUser appUser);
}
