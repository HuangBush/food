package com.hyf.food.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.hyf.food.entity.Menu;
@Mapper
public interface MenuMapper {
	
	/***
	 * 查询推荐菜单
	 * @return
	 */
	@Select("select * from menu where m_position = 2")
	List<Menu> queryMenuByPosition2();
	
	/***
	 * 查询所有菜单
	 * @return
	 */
	@Select("select * from menu")
	List<Menu> queryMenu();
	
	/***
	 * 根据种类信息查询所有菜单
	 * @return
	 */
	@Select("select * from menu where m_type = #{m_type} and m_position != 3")
	List<Menu> queryMenuByType(@Param("m_type")String m_type);
	
	/**
	 * 根据id获取菜品信息
	 * @param m_id
	 * @return
	 */
	@Select("select * from menu where m_id = #{m_id}")
	Menu queryMenuById(@Param("m_id")long m_id);
	
	/***
	 * 修改菜品销量
	 * @param menu
	 * @return
	 */
	@Update("update menu set m_num =(m_num+#{m_number}) where m_id = #{m_id}")
	int updateMenuNumByMid(Menu menu);
	
////////////////刘超 2.27新增///////////////////////////
/**
* 传入菜品对象添加菜品
* @param menu
* @return
*/
@Insert("insert into menu(m_name,m_price,m_img,m_type) value(#{m_name},#{m_price},#{m_img},#{m_type})")
int addMenu(Menu menu);
////////////////刘超 3.1新增///////////////////////////
/***
* 按照分页获取内容
* @param before
* @param after
* @return
*/
@Select("select * from menu limit #{before},#{after} ")
List<Menu> findAllPage(@Param("before") int before,@Param("after") int after);
/***
* 查询总共多少条数据
* @return
*/
@Select("select count(*) from menu")
int count();
/**
* 修改菜品状态为已下架
* @return
*/
@Update("update menu set m_position=3 where m_id=#{m_id}")
int deleteMenu(@Param("m_id")long m_id);
/**
* 修改菜品状态为推荐
* @return
*/
@Update("update menu set m_position=2 where m_id=#{m_id}")
int specialMenu(@Param("m_id")long m_id);
/**
* 修改菜品状态为在售
* @return
*/
@Update("update menu set m_position=0 where m_id=#{m_id}")
int onsaleMenu(@Param("m_id")long m_id);
////////////////刘超 3.2新增///////////////////////////
/**
* 修改菜品
* @param menu
* @return
*/
@Update("update menu set m_name=#{m_name},m_type=#{m_type},m_price=#{m_price},m_position=#{m_position},m_img=#{m_img} where m_id=#{m_id}")
int updateMenu(Menu menu);
}
