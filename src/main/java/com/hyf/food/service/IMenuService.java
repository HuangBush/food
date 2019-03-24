package com.hyf.food.service;

import java.util.List;




import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hyf.food.entity.Menu;

public interface IMenuService {
	/***
	 * 查询推荐菜单
	 * @return
	 */
	List<Menu> queryMenuByPosition2();
	
	/***
	 * 查询所有菜单
	 * @return
	 */
	List<Menu> queryMenu();
	
	/***
	 * 根据种类信息查询所有菜单
	 * @return
	 */
	List<Menu> queryMenuByType(String m_type);
	
	/**
	 * 根据id获取菜品信息
	 * @param m_id
	 * @return
	 */
	Menu queryMenuById(long m_id);
	
	/***
	 * 修改菜品销量
	 * @param menu
	 * @return
	 */
	int updateMenuNumByMid(Menu menu);
	
////////////////刘超 2.27新增///////////////////////////
/**
* 传入菜品对象添加菜品
* @param menu
* @return
*/
int addMenu(Menu menu);
////////////////刘超 3.1新增///////////////////////////
/***
* 按照分页获取内容
* @param before
* @param after
* @return
*/
List<Menu> findAllPage(int before,int after);

/***
* 计算有多少条数据
* @return
*/
int count();
/**
* 修改菜品状态为已下架
* @return
*/
int deleteMenu(long m_id);
/**
* 修改菜品状态为推荐
* @return
*/
int specialMenu(long m_id);
/**
* 修改菜品状态为在售
* @return
*/
int onsaleMenu(long m_id);
////////////////刘超 3.2新增///////////////////////////
/**
* 修改菜品信息
* @param menu
* @return
*/
int updateMenu(Menu menu);
}
