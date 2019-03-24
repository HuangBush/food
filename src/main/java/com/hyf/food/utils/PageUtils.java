package com.hyf.food.utils;

import java.io.Serializable;
import java.util.List;

/***
 * layui pageUtils工具类
 * @author 黄逸峰
 *
 */
public class PageUtils implements Serializable{

    //每页记录数
    private  int limit;
    
    //当前页数
    private  int curr;
    
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCurr() {
		return curr;
	}

	public void setCurr(int curr) {
		this.curr = curr;
	}

	/***
     * 获取要查询多少条数据
     * @param limit
     * @param curr
     * @return
     */
    public  int after(){
    	return limit;
    }
    
    /***
     * 获取从哪一行开始查询
     * @param limit
     * @param curr
     * @return
     */
    public  int before(){
    	return limit*(curr);
    }
    public  int before1(){
    	return limit*(curr-1);
    }
}
