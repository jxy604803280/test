package com.app4m.app.cmind.controlller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import base.controller.BaseController;
import base.utils.date.DateUtils;

import com.app4m.app.cmind.Service.CmindServiceImpl;
import com.app4m.app.cmind.entity.Cmind;
@Controller(value="cmindController")
public class CmindController extends BaseController {
	@Resource(name="cmindService")
	private CmindServiceImpl cmindService;
	
	@RequestMapping("app4m/app/cmind/cmind/showCminds")
	public String showCminds(HttpServletRequest request,HttpServletResponse response,Model model){
		List<Cmind> list = cmindService.selectCminds();
		model.addAttribute("cmindsList", list);
		return "redirect:app4m/app/user/userRelation/userInfo";
	}
	
	@RequestMapping("app4m/app/cmind/cmind/publish")
	public String publish(HttpServletRequest request,HttpServletResponse response,Cmind cmind){
		cmind.setUserId(this.getUser(request).getId());
		cmind.setCmindDate(DateUtils.getDate());
		cmindService.insertCmind(cmind);
		return "redirect:app4m/app/user/userRelation/userInfo";
	}
}
