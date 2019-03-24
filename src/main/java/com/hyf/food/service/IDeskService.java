package com.hyf.food.service;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.hyf.food.entity.Desk;

public interface IDeskService {
	/***
	 * 根据餐桌id和密码查找餐桌
	 * @param desk
	 * @return
	 */
	Desk queryDeskByIdAndPassword(Desk desk);
	
	/***
	 * 修改餐桌的状态
	 * @param desk
	 * @return
	 * 3/1 黄逸峰
	 */
	int updateDeskPositionByDid(long d_position,long d_id);
	
	/***
	 * 根据餐桌id查找餐桌
	 * @param desk
	 * @return
	 */
	Desk queryDeskById(long d_id);
	
////////////////刘超 3.3新增///////////////////////////
/***
* 查询所有张桌子
* @return
*/
List<Desk> queryAllDesk();
/***
* 根据id查询桌面
* @return
*/
Desk queryDeskById(Long d_id);
////////////////刘超 3.14新增///////////////////////////
/**
* 根据桌名删除桌子
* @param name
* @return
*/
Desk deleteDeskByName(String name);
/**
* 添加桌子
* @param desk
* @return
*/
int addDesk(Desk desk);
	////////////////刘超 3.15新增///////////////////////////
	/**
	* 根据桌名修改桌子状态
	* @param name
	*/
	int updateDeskPositionByName(String name);

}
