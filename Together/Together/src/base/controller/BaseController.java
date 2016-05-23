package base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.app4m.app.user.entity.AppUser;
@Controller
public class BaseController {
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-24
	* @Description: 获取用户
	* @param @param request
	* @param @return    
	* @return AppUser   
	* @throws
	 */
	public AppUser getUser(HttpServletRequest request){
		AppUser appUser = (AppUser) getSession(request).getAttribute("appUser");
		return appUser;
	}
	
	/**
	 * 
	* @author:jason.jiang
	* @Date 2016-4-24
	* @Description: 获取session
	* @param @param request
	* @param @return    
	* @return HttpSession   
	* @throws
	 */
	public HttpSession getSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		return session;
	}
}
