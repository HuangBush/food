package com.hyf.food.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hyf.food.entity.Employee;

public interface IEmployeeService {
	/***
	 * 添加新员工
	 * @param employee
	 * @return
	 */
	int addEmployeeMsg(Employee employee);
	
	/***
	 * 删除员工信息
	 * @param e_id
	 * @return
	 */
	int deleteEmployeeMsg(long e_id);
	
	/**
	 * 修改员工信息
	 * @param employee
	 * @return
	 */
	int updateEmployeeMsg(Employee employee);
	
	/***
	 * 按id查询员工信息
	 * @param e_id
	 * @return
	 */
	Employee queryEmloyeeById(long e_id);
	
	/***
	 * 查询所有员工信息
	 * @return
	 */
	List<Employee> queryAllEmployeeMsg();
	
	/***
	 * 员工登录
	 * @param e_tel
	 * @param e_password
	 * @return
	 */
	Employee EmployeeLogin(long e_tel,String e_password);
	
	/***
	 * 按电话查询员工信息
	 * @param e_tel
	 * @return
	 */
	Employee queryEmployeeByTel(long e_tel);
	
	/***
	 * 按状态查询员工信息
	 * @param e_position
	 * @return
	 */
	List<Employee> queryEmployeeByPosition(long e_position);
	
	/***
	 * 按照分页获取内容
	 * @param before
	 * @param after
	 * @return
	 */
	public List<Employee> findAllPage(int before,int after);
	
	/***
	 * 计算有多少条数据
	 * @return
	 */
	public int count();

}
