package com.hyf.food.mapper;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyf.food.entity.Orderitems;
@Mapper
public interface OrderitemsMapper {
	
	/***
	 * 根据餐桌id和总订单状态总订单和所有子订单
	 * @param d_id
	 * @return
	 */
	@Select("select * from Orderitems where d_id = #{d_id} and os_position = #{os_position} ")
		@Results({
			@Result(column="os_id",property="oiList",
					many=@Many(select="com.hyf.food.mapper.OrderitemMapper.queryItemByOsid"))
			
		})
	Orderitems queryOrderItemsByDidAndDateDescLimit1(@Param("d_id")Long d_id,@Param("os_position")long os_position);
	
	/***
	 * 根据状态和餐厅id查询总订单
	 * @param os_position
	 * @return
	 */
	@Select("select * from orderitems where os_position=#{os_position} and d_id = #{d_id}")
	
	List<Orderitems> queryOrderitemsByPosition(@Param("os_position")long os_position,@Param("d_id")long d_id);
	
	/***
	 * 增加一个未付款的总订单
	 * @Options 用来返回插入后的osid 值在os中
	 * @param d_id
	 * @return
	 */
	@Options(useGeneratedKeys = true,keyProperty ="os_id",keyColumn = "os_id")
	@Insert("insert into orderitems (d_id) values (#{d_id})")
	int addOrderitems(Orderitems os);

	/***
	 * 根据总订单id查询总订单信息
	 * 2/27
	 * @param os_id
	 * @return
	 */
	@Select("select * from orderitems where os_id = #{os_id}")
	Orderitems queryOrderitsmByOsid(@Param("os_id")long os_id);
	
	/***
	 * 修改总订单状态
	 * @param os_id
	 * @return
	 */
	@Update("update orderitems set os_position = #{os_position} where os_id = #{os_id}")
	int updateOrderitemsPositionByOsid(@Param("os_position")long os_position,@Param("os_id")long os_id);
	
	/***
	 * 根据总订单id修改总订单总价
	 * @param os_allprice
	 * @param os_id
	 * @return
	 */
	@Update("update orderitems set os_allprice = (os_allprice+#{os_allprice}) where os_id = #{os_id}")
	int updateOrderitemsPriceByOsid(@Param("os_allprice")float os_allprice,@Param("os_id")long os_id);
	
	/***
	 * 彻底删除总订单
	 * @param os_id
	 * @return
	 */
	@Delete("delete from orderitems where os_id = #{os_id}")
	int deleteOrderitemsByOsid(@Param("os_id")long os_id);
	
	/*************张洋的方法********************/
	
	/***
	 * 按照分页获取内容
	 * @param before
	 * @param after
	 * @return
	 */
	@Select("select * from orderitems limit #{before},#{after} ")
	public List<Orderitems> findAllPage(@Param("before") int before,@Param("after") int after);
	
	/***
	 * 计算有多少条数据
	 * @return
	 */
	@Select("select count(*) from orderitems")
	public int count();
	
	/***
	 * 删除订单信息
	 * @param os_id
	 * @return
	 */
	@Update("update orderitems set os_position = 3 where os_id = #{os_id}")
	int deleteOrderitemsMsgByOsid(@Param("os_id")long os_id);
	
	/***
	 * 按时间查询总订单信息
	 * @param os_regtime
	 * @return
	 */
	@Select("select * from orderitems where os_regtime = #{os_regtime}")
	List<Orderitems> queryOrderitemsByRegtime(@Param("os_regtime") Date os_regtime);
	
	/***
	 * 根据订单状态查询订单信息
	 * @param os_position
	 * @return
	 */
	@Select("select * from orderitems where os_position = #{os_position}")
	List<Orderitems> queryOrderitemsByOsPosition(@Param("os_regtime") long os_position);
	
	/***
	 * 根据订单ID查询订单信息
	 * @param os_id
	 * @return
	 */
	@Select("select * from orderitems where os_id = #{os_id}")
	Orderitems queryOrderitemsByOsId(@Param("os_id") long os_id);
	
	/***
	 * 根据桌面ID查询订单信息
	 * @param os_id
	 * @return
	 */
	@Select("select * from orderitems where d_id = #{d_id}")
	List<Orderitems> queryOrderitemsByDid(@Param("d_id") long d_id);

	/*********************刘超**********************/
	
	/***
	 * 根据桌面ID删除订单状态为0的信息
	 * @param os_id
	 * @return
	 */
	@Delete("delete from orderitems where d_id = #{d_id} and os_position = 0")
	int deleteOrderitemsByDidAndPosition(@Param("d_id") long d_id);
}
