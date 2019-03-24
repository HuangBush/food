package com.hyf.food.action;

import com.hyf.food.entity.Expense;
import com.hyf.food.entity.ExpenseTableModel;
import com.hyf.food.entity.Layui;
import com.hyf.food.service.IExpenseService;
import com.hyf.food.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class ExpenseAction {
	@Autowired
	private IExpenseService ExpenseServiceImpl;
	
	
	/***
	 * 获取所有支出信息
	 * @param model
	 * @return
	 */
	@RequestMapping("queryAllExpense.action")
	public @ResponseBody Layui queryAllExpense(Model model, HttpSession session, PageUtils page){
		System.out.println(page.getLimit()+"jin---------"+page.getCurr());
		List<Expense> eList = ExpenseServiceImpl.findAllPage(page.before1(), page.after());
		System.out.println("支出管理----时间："+eList.get(0).getex_regtime());
		int count = ExpenseServiceImpl.count();
		Layui layui = new Layui();
		layui.setCount(count);
		layui.setData(eList);
		return layui;
	}
	
	/***
	 * 删除支出信息（按编号）
	 * @param model
	 * @param session
	 * @param ex_id
	 * @return
	 */
	@RequestMapping("delExpenseMsg.action")
	public @ResponseBody int delExpenseMsg(Model model,HttpSession session,String ex_id){
		long exid = Long.parseLong(ex_id);
		int i = ExpenseServiceImpl.deleteExoenseMsg(exid);
		if(i == 1){
			return 1;
		}else{
			return 0;
		}
	}
	
	/***
	 * 按ID查询支出信息
	 * @param model
	 * @return
	 */
	@RequestMapping("queryExpenseById.action")
	public String queryExpenseById(Model model,HttpSession session,String ex_id){
		long exid = Long.parseLong(ex_id);
		Expense expense = ExpenseServiceImpl.queryExpenseMsgByExid(exid);
		model.addAttribute("expense", expense);
		return "service/updateExpenseMsg.jsp";
	}
	
	@RequestMapping("updateExpenseMsg.action")
	public @ResponseBody String updateExpenseMsg(Model model,HttpSession session,Expense expense){
		System.out.println("----------------"+expense.getex_id());
		int i = ExpenseServiceImpl.updateExpenseMsg(expense);
		if(i == 1){
			return "success";
		}else{
			model.addAttribute("error", "修改出现错误！请重试。。。");
			return "error";
		}
	}

    @RequestMapping("addExpenseMsg.action")
    public String addExpenseMsg(Model model,HttpSession session,@RequestBody Expense expense){
		System.out.println("准备添加支出0------------------------------------------"+expense.getex_name());
		int i = ExpenseServiceImpl.addExpenseMsg(expense);
		if(i == 1){
			System.out.println("之处添加成功————————————————-"+i);
			return "成功";
		}else{
			System.out.println("支出添加失败-----------------------");
			model.addAttribute("error", "添加失败！请重试。。。");
			return "失败";
		}
	}
	
	/***
	 * 按订单时间查询总订单
	 * @param model
	 * @param session
	 * @param regtime
	 * @return
	 */
	@RequestMapping("queryExpenseMsgByEXregtime.action")
	public @ResponseBody
	ExpenseTableModel queryExpenseMsgByEXregtime(Model model, HttpSession session, Date regtime){
		System.out.println("riqi ------------"+regtime);
		List<Expense> list = new ArrayList<Expense>();
		list = ExpenseServiceImpl.queryExpenseMsgByRegtime(regtime);
		ExpenseTableModel et = new ExpenseTableModel();
		et.setCode(0);
		et.setCount(1000);
		et.setData(list);
		return et;

	}

}
