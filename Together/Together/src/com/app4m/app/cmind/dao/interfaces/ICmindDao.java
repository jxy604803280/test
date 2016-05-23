package com.app4m.app.cmind.dao.interfaces;

import java.util.List;

import com.app4m.app.cmind.entity.Cmind;

public interface ICmindDao {
	public List<Cmind> selectCminds();
	public void insertCmind(Cmind cmind);
}
