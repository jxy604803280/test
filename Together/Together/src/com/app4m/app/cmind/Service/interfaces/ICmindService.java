package com.app4m.app.cmind.Service.interfaces;

import java.util.List;

import com.app4m.app.cmind.entity.Cmind;


public interface ICmindService {
	public List<Cmind> selectCminds();
	public void insertCmind(Cmind cmind);
}
