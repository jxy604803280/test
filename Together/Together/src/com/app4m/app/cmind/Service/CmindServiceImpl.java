package com.app4m.app.cmind.Service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import base.service.BaseService;

import com.app4m.app.cmind.Service.interfaces.ICmindService;
import com.app4m.app.cmind.dao.CmindDaoImpl;
import com.app4m.app.cmind.entity.Cmind;
@Service(value="cmindService")
public class CmindServiceImpl extends BaseService implements ICmindService{
	@Resource(name="cmindDao")
	private CmindDaoImpl cmindDao;
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-5-20
	* @Description: ²éÑ¯cminds
	* @param @return    
	* @throws 
	*
	 */
	public List<Cmind> selectCminds(Map<String,String> map) {		
		return cmindDao.selectCminds(map);
	}
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-5-22
	* @Description: ÐÂ½¨cmind
	* @param @param cmind    
	* @throws 
	*
	 */
	public void insertCmind(Cmind cmind) {
		cmindDao.insertCmind(cmind);
	}
	
}
