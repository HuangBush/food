package com.hyf.food.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.hyf.food.entity.Orderitem;

public interface IOrderitemService {
	
	/***
	 * 根据总订单id查找子订单信息
	 * @param os_id
	 * @return
	 */
	List<Orderitem> queryItemByOsid(Long os_id);
	
	/***
	 * 插入一个子订单
	 * @param oi
	 * @return
	 */
	int addOrderitem(Orderitem oi);
	
	/***
	 * 每次减少一份，并修改子订单总价
	 * @param oi
	 * @return
	 */
	int updateOrderitemDec(Orderitem oi);
	
	/***
	 * 每次增加一份，并修改子订单总价
	 * @param oi
	 * @return
	 */
	int updateOrderitemAdd(Orderitem oi);
	
	/***
	 * 根据总订单id和菜品id获取子订单信息
	 * @param m_id
	 * @param os_id
	 * @return
	 */
	Orderitem queryOrderitemByMidAndOsid(Long m_id,Long os_id);
	
	/***
	 * 修改子订单的状态
	 * @param oi_id
	 * @return
	 */
	int updateOrderitemPositionByOiid(long oi_position,long oi_id);
	
	/***
	 * 修改子订单的总订单id
	 * @param oiList
	 * @return
	 */
	int updateOrderitemOsidByOiid(long os_id,long oi_id);
	
	/***
	 * 根据oiid彻底删除该子订单
	 * @param oi_id
	 * @return
	 */
	int deleteOrderitemByOiid(long oi_id);
	
	/***
	 * 根据总订单ID计算有多少条子订单数据
	 * @return
	 */
	public int count(Long os_id);
	
	/***
	 * 根据总订单id查找子订单信息(并获取菜品信息)分页
	 * @param os_id
	 * @return
	 */
	List<Orderitem> queryItemByOsidAndLimit(Long os_id,int before,int after);
}
