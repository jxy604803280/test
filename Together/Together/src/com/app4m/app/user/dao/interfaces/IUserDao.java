package com.app4m.app.user.dao.interfaces;


import com.app4m.app.user.entity.AppUser;


public interface IUserDao {
	public String insertAppUser(AppUser appUser);
	public String deleteAppUser(String id);
	public AppUser selectAppUser(AppUser appUser);
	public String updateAppUser(AppUser appUser);
}
