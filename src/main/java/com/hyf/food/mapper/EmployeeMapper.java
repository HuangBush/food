package com.hyf.food.mapper;

import com.hyf.food.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface EmployeeMapper {
	
	/***
	 * 添加新员工
	 * @param employee
	 * @return
	 */
	@Insert("insert into employee (e_name,e_password,e_job,e_tel,e_address,e_regdate,e_salary) values(#{e_name},#{e_password},#{e_job},#{e_tel},#{e_address},#{e_regdate},#{e_salary})")
	int addEmployeeMsg(Employee employee);

	
	/***
	 * 删除员工信息
	 * @param e_id
	 * @return
	 */
	@Update("update employee set e_position = 1 where e_id = #{e_id}")
	int deleteEmployeeMsg(@Param("e_id")long e_id);
	
	/**
	 * 修改员工信息
	 * @param employee
	 * @return
	 */
	@Update("update employee set e_name = #{e_name},e_tel = #{e_tel},e_password = #{e_password},e_address = #{e_address},e_regdate = #{e_regdate},e_job = #{e_job},e_salary = #{e_salary} where e_id = #{e_id}")
	int updateEmployeeMsg(Employee employee);
	
	/***
	 * 按id查询员工信息
	 * @param e_id
	 * @return
	 */
	@Select("select * from employee where e_id = #{e_id}")
	Employee queryEmloyeeById(@Param("e_id")long e_id);
	
	/***
	 * 查询所有员工信息
	 * @return
	 */
	@Select("select * from employee")
	List<Employee> queryAllEmployeeMsg();
	
	/***
	 * 员工登录
	 * @param e_tel
	 * @param e_password
	 * @return
	 */
	@Select("select * from employee where e_tel = #{e_tel} and e_password = #{e_password} and e_position = 0")
	Employee EmployeeLogin(@Param("e_tel")long e_tel,@Param("e_password")String e_password);
	
	/***
	 * 按电话查询员工信息
	 * @param e_tel
	 * @return
	 */
	@Select("select * from employee where e_tel = #{e_tel}")
	Employee queryEmployeeByTel(@Param("e_tel")long e_tel);
	
	/***
	 * 按状态查询员工信息
	 * @param e_position
	 * @return
	 */
	@Select("select * from employee where e_position = #{e_position}")
	List<Employee> queryEmployeeByPosition(@Param("e_position")long e_position);
	
	/***
	 * 按照分页获取内容
	 * @param before
	 * @param after
	 * @return
	 */
	@Select("select * from employee limit #{before},#{after} ")
	public List<Employee> findAllPage(@Param("before") int before,@Param("after") int after);
	
	/***
	 * 计算有多少条数据
	 * @return
	 */
	@Select("select count(*) from employee")
	public int count();


}
