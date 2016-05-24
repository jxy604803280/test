package com.app4m.app.cmind.controlller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import base.controller.BaseController;
import base.utils.date.DateUtils;

import com.app4m.app.cmind.Service.CmindServiceImpl;
import com.app4m.app.cmind.entity.Cmind;
@Controller(value="cmindController")
public class CmindController extends BaseController {
	@Resource(name="cmindService")
	private CmindServiceImpl cmindService;
	
	/**
	 * 查询特定人的cminds
	* @author:jason.jiang
	* @Date 2016-5-23
	* @Description: TODO
	* @param @param request
	* @param @param response
	* @param @param id 用户id
	* @param @param modelMap
	* @param @return    
	* @return String   
	* @throws
	 */
	@ResponseBody
	@RequestMapping("app4m/app/cmind/cmind/showCminds")
	public List<Cmind> showCminds(HttpServletRequest request,HttpServletResponse response,String id,RedirectAttributesModelMap modelMap){
		Map<String,String> map = new HashMap<String,String>();
		map.put("cmindDelFlag", Cmind.DELFLAG);
		map.put("userId",id);
		List<Cmind> list = cmindService.selectCminds(map);
		modelMap.addFlashAttribute("cmindsList", list);
		modelMap.addFlashAttribute("message", "hello");
		//return "redirect:/app4m/app/user/userRelation/userInfo";
		return list;
	}
	
	@RequestMapping("app4m/app/cmind/cmind/publish")
	public String publish(HttpServletRequest request,HttpServletResponse response,Cmind cmind){
		cmind.setUserId(this.getUser(request).getId());
		cmind.setCmindDate(DateUtils.getDate());
		cmindService.insertCmind(cmind);
		return "redirect:/app4m/app/user/userRelation/userInfo";
	}
}
