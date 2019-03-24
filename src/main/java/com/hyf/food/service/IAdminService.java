package com.hyf.food.service;

import com.hyf.food.entity.Admin;

public interface IAdminService {
	/***
	 * 修改管理员信息
	 * @param admin
	 * @return
	 */
	int updateAdminMsg(Admin admin);
	
	/***
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	Admin Adminlogin(String username,String password);
	
	/***
	 * 修改管理员密码
	 * @param admin
	 * @return
	 */
	int updateAdminPsw(Admin admin);
}
