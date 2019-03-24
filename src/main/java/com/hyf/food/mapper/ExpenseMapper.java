package com.hyf.food.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.*;

import com.hyf.food.entity.Expense;
@Mapper
public interface ExpenseMapper {
	
	/***
	 * 添加新支出
	 * @param Expense
	 * @return
	 */

	@Insert("insert into expense(ex_name,ex_price,ex_other,ex_regtime) values(#{ex_name},#{ex_price},#{ex_other},#{ex_regtime})")
	int addExpenseMsg(Expense Expense);

	
	/***
	 * 删除支出信息（按编号）
	 * @param ex_id
	 * @return
	 *//*
	@Delete("delete * from expense where ex_id = #{ex_id}")
	int deleteExoenseMsg(@Param("ex_id")long ex_id);*/
	
	/***
	 * 修改支出信息
	 * @param Expense
	 * @return
	 */
	@Update("update expense set ex_name = #{ex_name},ex_price = #{ex_price},ex_other = #{ex_other},ex_regtime = #{ex_regtime} where ex_id = #{ex_id}")
	int updateExpenseMsg(Expense Expense);
	
	/***
	 * 查询所有支出信息
	 * @return
	 */
	@Select("select * from expense")
	List<Expense> queryAllExpense();
	
	//@Select("select * from expense where to_char(oi_intime,'yyyy/mm/dd') = #{ex_regtime}")
	//List<Expense> quereyExpenseByRegtime(@Param("ex_regtime")Date ex_regtime);
	/***
	 * 按照分页获取内容
	 * @param before
	 * @param after
	 * @return
	 */
	@Select("select * from expense limit #{before},#{after} ")
	public List<Expense> findAllPage(@Param("before") int before,@Param("after") int after);
	
	/***
	 * 计算有多少条数据
	 * @return
	 */
	@Select("select count(*) from expense")
	public int count();
	
	/***
	 * 按编号查询支出信息
	 * @param ex_id
	 * @return
	 */
	@Select("select * from expense where ex_id = #{ex_id}")
	Expense queryExpenseMsgByExid(@Param("ex_id") long ex_id);
	
	/***
	 * 按时间查询订单信息
	 * @param ex_regtime
	 * @return
	 */
	@Select("select * from expense where ex_regtime = #{ex_regtime}")
	List<Expense> queryExpenseMsgByRegtime(@Param("ex_regtime") Date ex_regtime);

	/***
	 * 删除支出信息（按编号）
	 * @param ex_id
	 * @return
	 */
	@Delete("delete from expense where ex_id = #{ex_id}")
	int deleteExoenseMsg(@Param("ex_id")long ex_id);
}
