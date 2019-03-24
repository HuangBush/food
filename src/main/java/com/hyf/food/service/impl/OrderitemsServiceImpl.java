package com.hyf.food.service.impl;

import com.hyf.food.entity.Orderitems;
import com.hyf.food.mapper.OrderitemsMapper;
import com.hyf.food.service.IOrderitemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderitemsServiceImpl implements IOrderitemsService {
	
	@Autowired
	private OrderitemsMapper orderitemsMapper;
	
	/***
	 *  根据餐桌id和总订单状态并按照日期降序排列获取第一个订单的所有子订单
	 * @param d_id
	 * @return
	 */
	public Orderitems queryOrderItemsByDidAndDateDescLimit1(Long d_id, long os_position) {
		return orderitemsMapper.queryOrderItemsByDidAndDateDescLimit1(d_id,os_position);
	}
	
	/***
	 * 根据状态和餐厅id查询总订单
	 * @param os_position
	 * @return
	 */
	public List<Orderitems> queryOrderitemsByPosition(long os_position,long d_id) {
		return orderitemsMapper.queryOrderitemsByPosition(os_position, d_id);
	}
	
	/***
	 * 增加一个未付款的总订单
	 * @Options 用来返回插入后的osid 值在os中
	 * @param d_id
	 * @return
	 */
	public int addOrderitems(Orderitems os) {
		return orderitemsMapper.addOrderitems(os);
	}
	

	/***
	 * 根据总订单id查询总订单信息
	 * 2/27
	 * @param os_id
	 * @return
	 */
	public Orderitems queryOrderitsmByOsid(long os_id) {
		return orderitemsMapper.queryOrderitsmByOsid(os_id);
	}
	
	/***
	 * 删除总订单
	 * @param os_id
	 * @return
	 */
	public int updateOrderitemsPositionByOsid(long os_position,long os_id) {
		return orderitemsMapper.updateOrderitemsPositionByOsid(os_position,os_id);
	}
	
	/***
	 * 根据总订单id修改总订单总价
	 * @param os_allprice
	 * @param os_id
	 * @return
	 */
	public int updateOrderitemsPriceByOsid(float os_allprice,long os_id) {
		return orderitemsMapper.updateOrderitemsPriceByOsid(os_allprice, os_id);
	}
	
	/***
	 * 彻底删除总订单
	 * @param os_id
	 * @return
	 */
	public int deleteOrderitemsByOsid(long os_id) {
		return orderitemsMapper.deleteOrderitemsByOsid(os_id);
	}
	
	/******************张洋的方法************************/
	/***
	 * 按照分页获取内容
	 * @param before
	 * @param after
	 * @return
	 */
	public List<Orderitems> findAllPage(int before,int after) {
		return orderitemsMapper.findAllPage(before, after);
	}
	
	/***
	 * 计算有多少条数据
	 * @return
	 */
	public int count() {
		return orderitemsMapper.count();
	}
	
	
	/***
	 * 删除订单信息
	 * @param os_id
	 * @return
	 */
	public int deleteOrderitemsMsgByOsid(long os_id) {
		return orderitemsMapper.deleteOrderitemsMsgByOsid(os_id);
	}
	
	/***
	 * 按时间查询总订单信息
	 * @param os_regtime
	 * @return
	 */
	public List<Orderitems> queryOrderitemsByRegtime( Date os_regtime) {
		return orderitemsMapper.queryOrderitemsByRegtime(os_regtime);
	}
	
	/***
	 * 根据订单状态查询订单信息
	 * @param os_position
	 * @return
	 */
	public List<Orderitems> queryOrderitemsByOsPosition(long os_position) {
		return orderitemsMapper.queryOrderitemsByOsPosition(os_position);
	}
	
	/***
	 * 根据订单ID查询订单信息
	 * @param os_id
	 * @return
	 */
	public Orderitems queryOrderitemsByOsId(long os_id) {
		return orderitemsMapper.queryOrderitemsByOsId(os_id);
	}
	
	/***
	 * 根据桌面ID查询订单信息
	 * @param os_id
	 * @return
	 */
	public List<Orderitems> queryOrderitemsByDid(long d_id) {
		return orderitemsMapper.queryOrderitemsByDid(d_id);
	}
	/****************************************************/
	
	/***
	 * 根据桌面ID删除订单状态为0的信息
	 * @param os_id
	 * @return
	 */
	public int deleteOrderitemsByDidAndPosition(long d_id) {
		return orderitemsMapper.deleteOrderitemsByDidAndPosition(d_id);
	}
}
