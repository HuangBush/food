package com.hyf.food.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hyf.food.entity.Desk;


public class ClientLoginFilter implements Filter{


	@Override
	public void destroy() {
		System.out.println("ClientLoginFilter客户端登陆验证已销毁");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
	
		Desk desk =(Desk) session.getAttribute("desk");
		System.out.println("ClientLoginFilter客户端登陆验证........"+desk);
		if( desk == null ){
			req.getRequestDispatcher("/changeTable.jsp").forward(request, response);
		}else{
			chain.doFilter(request, response);
			System.out.println("ClientLoginFilter客户端登陆验证通过-----------");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("LoginFilter客户端登陆验证这正在开启.......");
		
	}

}
