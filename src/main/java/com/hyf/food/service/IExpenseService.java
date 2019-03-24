package com.hyf.food.service;

import java.util.Date;
import java.util.List;

import com.hyf.food.entity.Expense;

public interface IExpenseService {
	/***
	 * 添加新支出
	 * @param Expense
	 * @return
	 */
	int addExpenseMsg(Expense Expense);
	
	/***
	 * 删除支出信息（按编号）
	 * @param ex_id
	 * @return
	 */
	int deleteExoenseMsg(long ex_id);
	
	/***
	 * 修改支出信息
	 * @param Expense
	 * @return
	 */
	int updateExpenseMsg(Expense Expense);
	
	/***
	 * 查询所有支出信息
	 * @return
	 */
	List<Expense> queryAllExpense();
	
	/***
	 * 按照分页获取内容
	 * @param before
	 * @param after
	 * @return
	 */
	public List<Expense> findAllPage(int before,int after);
	
	/***
	 * 计算有多少条数据
	 * @return
	 */
	public int count();
	
	/***
	 * 按编号查询支出信息
	 * @param ex_id
	 * @return
	 */
	Expense queryExpenseMsgByExid(long ex_id);
	
	/***
	 * 按时间查询订单信息
	 * @param ex_regtime
	 * @return
	 */
	List<Expense> queryExpenseMsgByRegtime(Date ex_regtime);
}
