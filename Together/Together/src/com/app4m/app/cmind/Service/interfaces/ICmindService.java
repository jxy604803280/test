package com.app4m.app.cmind.Service.interfaces;

import java.util.List;
import java.util.Map;

import com.app4m.app.cmind.entity.Cmind;


public interface ICmindService {
	public List<Cmind> selectCminds(Map<String,String> map);
	public void insertCmind(Cmind cmind);
}
