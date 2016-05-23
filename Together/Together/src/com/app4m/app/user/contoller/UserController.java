package com.app4m.app.user.contoller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import base.controller.BaseController;
import com.app4m.app.user.entity.AppUser;
import com.app4m.app.user.service.interfaces.IUserService;
import com.app4m.app.user.utils.CodeGenerators;



@Controller
public class UserController extends BaseController{
	@Resource(name="userService")
	private IUserService userService;
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-3-29
	* @Description: ��ת�� ע��ҳ��
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping(value="app4m/app/user/user/showRegister")
	public String showRegister()
	{
		return "app/user/register";
	}
	
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-3-31
	* @Description: ת����¼ ҳ��
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping("app4m/app/user/user/showLogin")
	public String showLogin(){
		return "app/user/login";
	}
	
	
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-3-27
	* @Description: ע���û�
	* @param @param request
	* @param @param response
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping(value="app4m/app/user/user/register")
	public String register(HttpServletRequest request,HttpServletResponse response,AppUser appUser,Model model){
		appUser.setActiveCode(CodeGenerators.generateCodes());
		AppUser appUserTemp = userService.insertAppUser(appUser);
		appUser.setMessage(appUserTemp.getMessage());
		model.addAttribute("appUser",appUser);
		//������ص�appUser����id.��˵���������ѱ�ע��
		if(appUserTemp.getId() != null && appUserTemp.getId() != ""){
			return "app/user/register";
		}
		return "app/user/login";
	}
	
	/**
	 * @throws Exception 
	* @author:jason.jiang
	* @Date 2016-3-27
	* @Description: �û���¼
	* @param  request
	* @param  response
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping(value="app4m/app/user/user/login")
	public String login(HttpServletRequest request,HttpServletResponse response,AppUser appUser,Model model) throws Exception{
		//������¼ҳ��ֱ�ӷ��ʵģ��˻ص���½ҳ��
		if(appUser==null){
			return "redirect:/showLogin";
		}
		appUser = userService.login(appUser);
		model.addAttribute("appUser",appUser);
		//û��id��˵����ѯ���������Ϣ����δע��
		if(appUser.getId()==null)
			return "app/user/register";
		switch(appUser.getStatus()){
			case AppUser.ACTIVEDSTATUS :
				if(appUser.getMessage().equals("success")){
					getSession(request).setAttribute("appUser",appUser);
				/*  model.addAttribute("fansCount",userService.selectFansCount(getSelectMap(appUser)));
					model.addAttribute("followsCount",userService.selectFollowsCount(getSelectMap(appUser)));*/
					return"redirect:/app4m/app/user/userRelation/userInfo";
				}
				break;
			default:
				appUser.setMessage("�˺�δ����");
				getSession(request).setAttribute("appUser",appUser);
				return "app/user/login";

		}
		return "";
	}
	
	/**
	* @Date 2016-3-27
	* @Description: �޸��û���Ϣ
	* @param @param request
	* @param @param response
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping(value="app4m/app/user/user/updateAppUser")
	public String updateAppUser(HttpServletRequest request,HttpServletResponse response,AppUser appUser){
		userService.updateAppUser(appUser);
		return "app/user/login";
	}
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-27
	* @Description: �����û�
	* @param @param request
	* @param @param response
	* @param @param appUser
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping(value="app4m/app/user/user/activeUser")
	public String activeUser(HttpServletRequest request,HttpServletResponse response,AppUser appUser){
		appUser.setStatus( AppUser.ACTIVEDSTATUS );
		userService.updateAppUser(appUser);
		return "redirect:login";
	}
}