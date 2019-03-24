package com.hyf.food.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyf.food.entity.Admin;
import com.hyf.food.mapper.AdminMapper;
import com.hyf.food.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	/***
	 * 修改管理员信息
	 * @param admin
	 * @return
	 */
	public int updateAdminMsg(Admin admin) {
		return adminMapper.updateAdminMsg(admin);
	}
	
	/***
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public Admin Adminlogin(String username,String password) {
		return adminMapper.Adminlogin(username,password);
	}
	/***
	 * 修改管理员密码
	 * @param admin
	 * @return
	 */
	public int updateAdminPsw(Admin admin) {
		return adminMapper.updateAdminPsw(admin);
	}

}
