package com.hyf.food.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyf.food.entity.Expense;
import com.hyf.food.mapper.ExpenseMapper;
import com.hyf.food.service.IExpenseService;
@Service
public class ExpenseServiceImpl implements IExpenseService {
	
	@Autowired
	private ExpenseMapper expenseMapper;

	/***
	 * 添加新支出
	 * @param Expense
	 * @return
	 */
	public int addExpenseMsg(Expense Expense) {
		return expenseMapper.addExpenseMsg(Expense);
	}

	/***
	 * 删除支出信息（按编号）
	 * @param ex_id
	 * @return
	 */
	public int deleteExoenseMsg(long ex_id) {
		return expenseMapper.deleteExoenseMsg(ex_id);
	}

	/***
	 * 修改支出信息
	 * @param Expense
	 * @return
	 */
	public int updateExpenseMsg(Expense Expense) {
		return expenseMapper.updateExpenseMsg(Expense);
	}

	/***
	 * 查询所有支出信息
	 * @return
	 */
	public List<Expense> queryAllExpense() {
		return expenseMapper.queryAllExpense();
	}
	
	/***
	 * 按照分页获取内容
	 * @param before
	 * @param after
	 * @return
	 */
	public List<Expense> findAllPage(int before,int after) {
		return expenseMapper.findAllPage(before, after);
	}
	
	/***
	 * 计算有多少条数据
	 * @return
	 */
	public int count() {
		return expenseMapper.count();
	}
	
	/***
	 * 按编号查询支出信息
	 * @param ex_id
	 * @return
	 */
	public Expense queryExpenseMsgByExid(long ex_id) {
		return expenseMapper.queryExpenseMsgByExid(ex_id);
	}
	
	/***
	 * 按时间查询订单信息
	 * @param ex_regtime
	 * @return
	 */
	public List<Expense> queryExpenseMsgByRegtime(Date ex_regtime) {
		return expenseMapper.queryExpenseMsgByRegtime(ex_regtime);
	}
}
