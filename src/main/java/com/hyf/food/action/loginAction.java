package com.hyf.food.action;

import com.hyf.food.entity.Admin;
import com.hyf.food.entity.Employee;
import com.hyf.food.service.IAdminService;
import com.hyf.food.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;



@Controller
public class loginAction {
	
	@Autowired
	private IAdminService adminServiceImpl;
	
	@Autowired
	private IEmployeeService employeeServiceImpl;
	
	/***
	 * 按ID查询员工信息
	 * @param model
	 * @return
	 */
	@RequestMapping("AdminAndEmployeelogin.action")
	public String AdminAndEmployeelogin(Model model,HttpSession session,String username,String password,String role){
		System.out.println("-----------------------"+username);
		Admin admin = null;
		Employee emp = null;
		if(role.equals("admin")){
			admin = adminServiceImpl.Adminlogin(username, password);
			session.setAttribute("admin", admin);
			session.removeAttribute("emp");
		}else if(role.equals("employee")){
			long etel = Long.parseLong(username);
			emp = employeeServiceImpl.EmployeeLogin(etel,password);
			session.setAttribute("emp", emp);
			session.removeAttribute("admin");
		}
		if(admin != null || emp != null){
			System.out.println("登录中——————————————————————");
			return "countDesk.action";
		}else{
			model.addAttribute("erroe", "登录失败！用户名或密码错误。。。");
			return "service/login.jsp";
		}
		
	}
	
	/***
	 * 退出
	 * @param session
	 * @return
	 */
	@RequestMapping("loginOut.action")
	public String loginOut(HttpSession session){
		System.out.println("退出管理系统——————————————————--");
		session.invalidate();
		return "service/login.jsp";
	}

}
