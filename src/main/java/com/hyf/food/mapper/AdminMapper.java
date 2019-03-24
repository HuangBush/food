package com.hyf.food.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hyf.food.entity.Admin;

@Mapper
public interface AdminMapper {
	
	/***
	 * 修改管理员信息
	 * @param admin
	 * @return
	 */
	@Update("update admin set a_name = #{a_name},a_password = #{a_password}")
	int updateAdminMsg(Admin admin);
	
	/***
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	@Select("select * from admin where a_name = #{a_name} and a_password = #{a_password}")
	Admin Adminlogin(@Param("a_name")String a_name,@Param("a_password")String a_password);


	
	/***
	 * 修改管理员密码
	 * @param admin
	 * @return
	 */
	@Update("update admin set a_password = #{a_password} where a_name = #{a_name}")
	int updateAdminPsw(Admin admin);
	
	
	
	
	
}
