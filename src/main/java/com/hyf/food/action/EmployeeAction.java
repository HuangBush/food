package com.hyf.food.action;

import com.hyf.food.entity.EmpTableModel;
import com.hyf.food.entity.Employee;
import com.hyf.food.entity.Layui;
import com.hyf.food.service.IEmployeeService;
import com.hyf.food.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class EmployeeAction {
	
	
	@Autowired
	private IEmployeeService EmployeeServiceImpl;
	
	/***
	 * 获取所有员工信息
	 * @param model
	 * @return
	 */
	@RequestMapping("queryAllEmployee.action")
	public @ResponseBody
	Layui queryAllEmployee(Model model, HttpSession session, PageUtils page){
		System.out.println(page.getLimit()+"jin---------"+page.getCurr());
		List<Employee> eList = EmployeeServiceImpl.findAllPage(page.before1(), page.after());
		int count = EmployeeServiceImpl.count();
		Layui layui = new Layui();
		layui.setCount(count);
		layui.setData(eList);
		return layui;
	}
	
	/***
	 * 按ID查询员工信息
	 * @param model
	 * @return
	 */
	@RequestMapping("queryEmployeeById.action")
	public String queryEmployeeById(Model model,HttpSession session,String e_id){
		System.err.println("qeeee--------"+e_id);
		long eid = Long.parseLong(e_id);
		Employee emp = EmployeeServiceImpl.queryEmloyeeById(eid);
		model.addAttribute("emp", emp);
		return "service/updateEmployeeMsg.jsp";
	}
	
	@RequestMapping("updateEmployeeMsg.action")
	public @ResponseBody String updateEmployeeMsg(Model model,HttpSession session,Employee employee){
		System.out.println("----------------"+employee.gete_id());
		int i = EmployeeServiceImpl.updateEmployeeMsg(employee);
		if(i == 1){
			return "success";
		}else{
			model.addAttribute("error", "修改出现错误！请重试。。。");
			return "error";
		}
	}
	
	@RequestMapping("addEmployeeMsg.action")
	public String addEmployeeMsg(Model model,HttpSession session,@RequestBody Employee employee){
		System.out.println("employee-------"+employee.gete_regdate());
		int i = EmployeeServiceImpl.addEmployeeMsg(employee);
		if(i == 1){
			return "成功";
		}else{
			model.addAttribute("error", "添加失败！请重试。。。");
			return "失败";
		}
	}
	
	
	
	/**
	 * 删除员工信息
	 * @param model
	 * @param session
	 * @param e_id
	 * @return
	 */
	@RequestMapping("delEmployeeMsg.action")
	public @ResponseBody int delEmployeeMsg(Model model,HttpSession session,String e_id){
		long eid = Long.parseLong(e_id);
		int i = EmployeeServiceImpl.deleteEmployeeMsg(eid);
		if(i == 1){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	@RequestMapping("queryEmployeeMsgByIDorTel.action")
	public @ResponseBody
	EmpTableModel queryEmployeeMsgByIDorTel(Model model, HttpSession session, String keyWord, String keyType){
		List<Employee> list = new ArrayList<Employee>();
		Employee emp = new Employee();
		if(keyType.equals("e_id")){
			long eid = Long.parseLong(keyWord);
			emp = EmployeeServiceImpl.queryEmloyeeById(eid);
		}else if(keyType.equals("e_tel")){
			long etel = Long.parseLong(keyWord);
			emp = EmployeeServiceImpl.queryEmployeeByTel(etel);
		}
		list.add(emp);
		EmpTableModel em = new EmpTableModel();
		em.setCode(0);
		em.setCount(1000);
		em.setData(list);
		return em;

	}
	
	@RequestMapping("queryEmployeeMsgByeid.action")
	public @ResponseBody Employee queryEmployeeMsgById(Model model,HttpSession session,long e_id){
		Employee emp = EmployeeServiceImpl.queryEmloyeeById(e_id);
		return emp;
		
	}
	
	@RequestMapping("queryEmployeeMsgByTel.action")
	public @ResponseBody Employee queryEmployeeMsgByTel(Model model,HttpSession session,long e_tel){
		Employee emp = EmployeeServiceImpl.queryEmployeeByTel(e_tel);
		return emp;
		
	}
	
	@RequestMapping("queryEmployeeMsgByPosition.action")
	public @ResponseBody List<Employee> queryEmployeeMsgByPosition(Model model,HttpSession session,long e_position){
		List<Employee> eList = EmployeeServiceImpl.queryEmployeeByPosition(e_position);
		return eList;
		
	}
	
	


}
