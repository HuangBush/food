package com.hyf.food.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.hyf.food.entity.Desk;
@Mapper
public interface DeskMapper {
	
	/***
	 * 根据餐桌id和密码查找餐桌
	 * @param desk
	 * @return
	 */
	@Select("select * from desk where d_id = #{d_id} and d_password = #{d_password}")
	Desk queryDeskByIdAndPassword(Desk desk);
	
	/***
	 * 修改餐桌的状态
	 * @param desk
	 * @return
	 * 3/1 黄逸峰
	 */
	@Update("update desk set d_position= #{d_position} where d_id = #{d_id}")
	int updateDeskPositionByDid(@Param("d_position")long d_position,@Param("d_id")long d_id);
	
	/***
	 * 根据餐桌id查找餐桌
	 * @param desk
	 * @return
	 */
	@Select("select * from desk where d_id = #{d_id}")
	Desk queryDeskById(@Param("d_id")long d_id);
	
	////////////////刘超 3.3新增///////////////////////////
	/***
	* 查询所有桌子
	* @return
	*/
	@Select("select * from desk")
	List<Desk> queryAllDesk();
	///***
	//* 根据id查询桌面
	//* @return
	//*/
	//@Select("select * from desk where d_id = #{d_id}")
	//Desk queryDeskById(@Param("d_id")Long d_id);
	
	////////////////刘超 3.14新增///////////////////////////
	/*
	* 根据桌名删除桌子
	*/
	@Delete("delete from desk where d_name = #{d_name}")
	Desk deleteDeskByName(@Param("d_name")String name);
	/**
	* 添加桌子
	* @param desk
	* @return
	*/
	@Insert("insert into desk(d_password,d_name,d_place,d_type) value(#{d_password},#{d_name},#{d_place},#{d_type})")
	int addDesk(Desk desk);
	////////////////刘超 3.15新增///////////////////////////
	/**
	* 根据桌名修改桌子状态
	* @param name
	*/
	@Update("update desk set d_position = 0 where d_name = #{d_name}")
	int updateDeskPositionByName(String name);
	
	}
