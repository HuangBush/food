package com.hyf.food.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyf.food.entity.Employee;
import com.hyf.food.mapper.EmployeeMapper;
import com.hyf.food.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;

	/***
	 * 添加新员工
	 * @param employee
	 * @return
	 */
	public int addEmployeeMsg(Employee employee) {
		return employeeMapper.addEmployeeMsg(employee);
	}

	/***
	 * 删除员工信息
	 * @param e_id
	 * @return
	 */
	public int deleteEmployeeMsg(long e_id) {
		return employeeMapper.deleteEmployeeMsg(e_id);
	}

	/**
	 * 修改员工信息
	 * @param employee
	 * @return
	 */
	public int updateEmployeeMsg(Employee employee) {
		return employeeMapper.updateEmployeeMsg(employee);
	}

	/***
	 * 按id查询员工信息
	 * @param e_id
	 * @return
	 */
	public Employee queryEmloyeeById(long e_id) {
		return employeeMapper.queryEmloyeeById(e_id);
	}

	/***
	 * 查询所有员工信息
	 * @return
	 */
	public List<Employee> queryAllEmployeeMsg() {
		return employeeMapper.queryAllEmployeeMsg();
	}

	/***
	 * 员工登录
	 * @param e_tel
	 * @param e_password
	 * @return
	 */
	public Employee EmployeeLogin(long e_tel, String e_password) {
		return employeeMapper.EmployeeLogin(e_tel, e_password);
	}
	/***
	 * 按电话查询员工信息
	 * @param e_tel
	 * @return
	 */
	public Employee queryEmployeeByTel(long e_tel) {
		return employeeMapper.queryEmployeeByTel(e_tel);
	}

	/***
	 * 按状态查询员工信息
	 * @param e_position
	 * @return
	 */
	public List<Employee> queryEmployeeByPosition(long e_position) {
		return employeeMapper.queryEmployeeByPosition(e_position);
	}
	
	/***
	 * 按照分页获取内容
	 * @param before
	 * @param after
	 * @return
	 */
	public List<Employee> findAllPage(int before,int after) {
		return employeeMapper.findAllPage(before, after);
	}
	
	/***
	 * 计算有多少条数据
	 * @return
	 */
	public int count() {
		return employeeMapper.count();
	}

}
