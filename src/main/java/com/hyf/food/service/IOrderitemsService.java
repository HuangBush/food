package com.hyf.food.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hyf.food.entity.Orderitems;

public interface IOrderitemsService {
	
	/***
	 *  根据餐桌id和总订单状态总订单和所有子订单
	 * @param d_id
	 * @return
	 */
	Orderitems queryOrderItemsByDidAndDateDescLimit1(Long d_id,long os_position);
	
	/***
	 * 根据状态和餐厅id查询总订单
	 * @param os_position
	 * @return
	 */
	List<Orderitems> queryOrderitemsByPosition(long os_position,long d_id);
	
	/***
	 * 增加一个未付款的总订单
	 * @Options 用来返回插入后的osid 值在os中
	 * @param d_id
	 * @return
	 */
	int addOrderitems(Orderitems os);
	
	/***
	 * 根据总订单id查询总订单信息
	 * 2/27
	 * @param os_id
	 * @return
	 */
	Orderitems queryOrderitsmByOsid(long os_id);
	
	/***
	 * 修改总订单状态
	 * @param os_id
	 * @return
	 */
	int updateOrderitemsPositionByOsid(long os_position,long os_id);
	
	/***
	 * 根据总订单id修改总订单总价
	 * @param os_allprice
	 * @param os_id
	 * @return
	 */
	int updateOrderitemsPriceByOsid(float os_allprice,long os_id);
	
	/***
	 * 彻底删除总订单
	 * @param os_id
	 * @return
	 */
	int deleteOrderitemsByOsid(long os_id);
	
	/***************张洋的方法************************/

	/***
	 * 按照分页获取内容
	 * @param before
	 * @param after
	 * @return
	 */
	public List<Orderitems> findAllPage(int before,int after);
	
	/***
	 * 计算有多少条数据
	 * @return
	 */
	public int count();
	
	/***
	 * 删除订单信息
	 * @param os_id
	 * @return
	 */
	int deleteOrderitemsMsgByOsid(long os_id);
	
	/***
	 * 按时间查询总订单信息
	 * @param os_regtime
	 * @return
	 */
	List<Orderitems> queryOrderitemsByRegtime( Date os_regtime);
	
	/***
	 * 根据订单状态查询订单信息
	 * @param os_position
	 * @return
	 */
	List<Orderitems> queryOrderitemsByOsPosition(long os_position);
	
	/***
	 * 根据订单ID查询订单信息
	 * @param os_id
	 * @return
	 */
	Orderitems queryOrderitemsByOsId(long os_id);
	
	/***
	 * 根据桌面ID查询订单信息
	 * @param os_id
	 * @return
	 */
	List<Orderitems> queryOrderitemsByDid(long d_id);
	
	/********************************************/
	
	/***
	 * 根据桌面ID删除订单状态为0的信息
	 * @param os_id
	 * @return
	 */
	int deleteOrderitemsByDidAndPosition(long d_id);
}
