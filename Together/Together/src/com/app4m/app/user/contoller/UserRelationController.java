package com.app4m.app.user.contoller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import base.controller.BaseController;

import com.app4m.app.user.entity.AppUser;
import com.app4m.app.user.entity.UserRelations;
import com.app4m.app.user.entity.userRelation.impl.RelationOperate;
import com.app4m.app.user.service.interfaces.IUserRelationService;
import com.app4m.app.user.service.interfaces.IUserService;
@Controller
public class UserRelationController extends BaseController {
	@Resource(name="userRelationService")
	private IUserRelationService userRelationService;
	@Resource(name="userService")
	private IUserService userService;
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-3-27
	* @Description: ��ѯ�û���Ϣ
	* @param @param request
	* @param @param response
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping(value="app4m/app/user/userRelation/userInfo")
	public String userInfo(HttpServletRequest request,HttpServletResponse response,Model model,String id){
		AppUser appUser = (AppUser) getSession(request).getAttribute("appUser");
		Map<String,String> map = UserRelations.getSelectMap(appUser.getId());
		if(id!="" && id!=null){
			//����ѯ�ǷǱ��˵���Ϣ�����踲��id
			AppUser selectedUser = new AppUser();
			selectedUser.setId(id);
			model.addAttribute("selectedUser",userService.userInfo(selectedUser));
			map.put("id", id);	
		}
		model.addAttribute("fansCount",userRelationService.selectFansCount(map));
		model.addAttribute("followsCount",userRelationService.selectFollowsCount(map));
		model.addAttribute("strangersList",userRelationService.selectStrangers(map));
		return "app/user/userInfo";
	}
	


	
	
	
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-4
	* @Description: ��ע����
	* @param @param request
	* @param @param response
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping(value="app4m/app/user/userRelation/follow")
	public String follow(HttpServletRequest request,HttpServletResponse response,String id){
		Map<String,String> map = UserRelations.getUserOperateMap(getUser(request).getId(),id);
		userRelationService.saveOrUpdateRelation(map, RelationOperate.FOLLOW);
		return "redirect:userInfo";
	}
	
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-4
	* @Description: ȡ����ע
	* @param @param request
	* @param @param response
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping(value="app4m/app/user/userRelation/cancelFollow")
	public String cancelFollow(HttpServletRequest request,HttpServletResponse response,String id){
		Map<String,String> map = UserRelations.getUserOperateMap(getUser(request).getId(),id);
		userRelationService.saveOrUpdateRelation(map, RelationOperate.CANCELFOLLOW);
		return "redirect:userInfo";
	}
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-27
	* @Description: ����
	* @param @param request
	* @param @param response
	* @param @param id
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping(value="app4m/app/user/userRelation/deFriend")
	public String deFriend(HttpServletRequest request,HttpServletResponse response, String id){
		Map<String,String> map = UserRelations.getUserOperateMap(getUser(request).getId(),id);
		userRelationService.saveOrUpdateRelation(map, RelationOperate.DEFRIEND);
		return "redirect:userInfo";
	}
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-4
	* @Description: չʾ��˿�б�
	* @param @param request
	* @param @param response
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping("app4m/app/user/userRelation/showFans")
	public String showFans(HttpServletRequest request,HttpServletResponse response,Model model,String id){
		AppUser appUser = (AppUser) getSession(request).getAttribute("appUser");
		Map<String,String> map = UserRelations.getSelectMap(appUser.getId());
		if(id!="" && id!=null){
			//����ѯ�ǷǱ��˵���Ϣ�����踲��id
			AppUser selectedUser = new AppUser();
			selectedUser.setId(id);
			model.addAttribute("selectedUser",userService.userInfo(selectedUser));
			map.put("currentUserId",appUser.getId());
			map.put("id", id);	
		}
		model.addAttribute("fansList",userRelationService.selectFans(map));
		return "app/user/fans";
	}
	
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-4
	* @Description: չʾ��ע�����б�
	* @param @param request
	* @param @param response
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping("app4m/app/user/userRelation/showFollows")
	public String showFollows(HttpServletRequest request,HttpServletResponse response,Model model,String id){
		AppUser appUser = (AppUser) getSession(request).getAttribute("appUser");
		Map<String,String> map = UserRelations.getSelectMap(appUser.getId());
		if(id != "" && id != null && !id.equals(appUser.getId())){
			//����ѯ�ǷǱ��˵���Ϣ�����踲��id
			AppUser selectedUser = new AppUser();
			selectedUser.setId(id);
			model.addAttribute("selectedUser",userService.userInfo(selectedUser));
			map.put("id", id);	
		}
		model.addAttribute("followsList",userRelationService.selectFollows(map));
		return "app/user/follows";
	}
	
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-24
	* @Description: �Ƽ�İ����
	* @param @param request
	* @param @param response
	* @param @param model
	* @param @return    
	* @return String   
	* @throws
	 */
	public String showStrangers(HttpServletRequest request,HttpServletResponse response,Model model){
		return "";
	}
	


}
