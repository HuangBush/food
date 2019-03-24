package com.hyf.food.entity;

import java.util.List;

public class Layui  {
	
	private int code = 0;
	private String msg = "";
	private Integer count;
	private List<?> data;
	private String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Layui [code=" + code + ", msg=" + msg + ", count=" + count
				+ ", data=" + data + ", path=" + path + "]";
	}
	
 
	
}
 
 

