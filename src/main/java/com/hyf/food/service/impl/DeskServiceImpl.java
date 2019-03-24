package com.hyf.food.service.impl;

import com.hyf.food.entity.Desk;
import com.hyf.food.mapper.DeskMapper;
import com.hyf.food.service.IDeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeskServiceImpl implements IDeskService {
	
	@Autowired
	private DeskMapper deskMapper;
	
	/***
	 * 根据餐桌id和密码查找餐桌
	 * @param desk
	 * @return
	 */
	public Desk queryDeskByIdAndPassword(Desk desk) {
		return deskMapper.queryDeskByIdAndPassword(desk);
	}
	
	/***
	 * 修改餐桌的状态
	 * @param desk
	 * @return
	 * 3/1 黄逸峰
	 */
	public int updateDeskPositionByDid(long d_position,long d_id) {
		return deskMapper.updateDeskPositionByDid(d_position, d_id);
	}
	

	/***
	 * 根据餐桌id查找餐桌
	 * @param desk
	 * @return
	 */
	public Desk queryDeskById(long d_id) {
		return deskMapper.queryDeskById(d_id);
	}
	
////////////////刘超 3.3新增///////////////////////////
/***
* 查询总共多少张桌子
* @return
*/
/***
* 查询所有张桌子
* @return
*/
public List<Desk> queryAllDesk(){
return deskMapper.queryAllDesk();
}
/***
* 根据id查询桌面
* @return
*/
public Desk queryDeskById(Long d_id){
return deskMapper.queryDeskById(d_id);
}
////////////////刘超 3.14新增///////////////////////////
/**
* 根据桌名删除桌子
* @param name
* @return
*/
public Desk deleteDeskByName(String name){
return deskMapper.deleteDeskByName(name);
}
/**
* 添加桌子
* @param desk
* @return
*/
public int addDesk(Desk desk){
return deskMapper.addDesk(desk);
}
	////////////////刘超 3.15新增///////////////////////////
	/**
	* 根据桌名修改桌子状态
	* @param name
	*/
	public int updateDeskPositionByName(String name){
		return deskMapper.updateDeskPositionByName(name);
	}
}
