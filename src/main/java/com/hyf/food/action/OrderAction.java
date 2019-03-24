package com.hyf.food.action;

import com.hyf.food.entity.*;
import com.hyf.food.service.IMenuService;
import com.hyf.food.service.IOrderitemService;
import com.hyf.food.service.IOrderitemsService;
import com.hyf.food.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class OrderAction {
	
	@Autowired
	private IOrderitemsService orderitemsServiceImpl;
	
	@Autowired
	private IMenuService menuServiceImpl;
	
	@Autowired
	private IOrderitemService orderitemServiceImpl;

	/***
	 * 加入我的菜单
	 * @param m_id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addMenu.do",produces="text/plain;charset=utf-8")
	public @ResponseBody String addMenu(String m_id,HttpSession session){
		long m_id1 = Long.parseLong(m_id);
		Desk desk = (Desk) session.getAttribute("desk");
		//根据菜品id获取菜品信息
		Menu menu = menuServiceImpl.queryMenuById(m_id1);
		//查询该餐桌是否有状态为0的总订单
		List<Orderitems> osList = orderitemsServiceImpl.queryOrderitemsByPosition(0, desk.getd_id());
		//System.out.println("bbbbbbbb"+osList.get(0).getos_regtime());
		//如果没有则 创建一个该餐桌的总订单
		if(osList.size() == 0){
			Orderitems os = new Orderitems();
			os.setd_id(desk.getd_id());
			int i = orderitemsServiceImpl.addOrderitems(os);
			if(i == 1){
				System.out.println("成功创建一个该餐桌的总订单----获取到返回的os_id"+os.getos_id());
				//根据菜品信息创建一个子订单
				Orderitem oi = new Orderitem(os.getos_id(),menu.getm_id(),(long)1,menu.getm_price());
				int j = orderitemServiceImpl.addOrderitem(oi);
				if(j == 1){
					System.out.println("成功：根据菜品信息创建一个子订单");
					return "1";
				}else{
					System.out.println("失败：根据菜品信息创建一个子订单");
					return "0";
				}
				
			}else{
				System.out.println("失败：创建一个该餐桌的总订单-----------");
			}
		}
		//如果有一个，则获取该总订单信息
		if(osList.size() == 1){
			Orderitems os1 = osList.get(0);
			System.out.println("aaaaaaaaaaaa----------"+os1.getos_id()+os1.getd_id());
			//根据菜品id查找总订单中的子订单（总订单中不能存在相同菜品的子订单）
			Orderitem oi1 = orderitemServiceImpl.queryOrderitemByMidAndOsid(menu.getm_id(), os1.getos_id());
			//如果为null  则根据菜品信息创建一个子订单
			if(oi1 == null){
				Orderitem oi2 = new Orderitem(os1.getos_id(),menu.getm_id(),(long)1,menu.getm_price());
				int k = orderitemServiceImpl.addOrderitem(oi2);
				if(k ==1 ){
					System.out.println("成功：如果为null  则根据菜品信息创建一个子订单");
					return "1";
				}else{
					System.out.println("失败：如果为null  则根据菜品信息创建一个子订单");
					return "0";
				}
			}else{
				//如果存在 则直接修改菜品信息
				int l = orderitemServiceImpl.updateOrderitemAdd(oi1);
				if(l ==1 ){
					System.out.println("成功：如果存在 则直接修改菜品信息"+oi1.getoi_id());
					return "1";
				}else{
					System.out.println("失败：如果存在 则直接修改菜品信息");
					return "0";
				}
			}
		}
		//如果有多个总订单，则报错
		else{
			System.out.println("如果有多个总订单，则报错-------------"+osList.size());
			return "0";
		}
	}
	
	/***
	 * 减少一分操作
	 * @param m_id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/decMenu.do",produces="text/plain;charset=utf-8")
	public @ResponseBody String decMenu(String m_id,HttpSession session){
		long m_id1 = Long.parseLong(m_id);
		Desk desk = (Desk) session.getAttribute("desk");
		
		//根据菜品id获取菜品信息
		Menu menu = menuServiceImpl.queryMenuById(m_id1);
		//查询该餐桌是否有状态为0的总订单
		List<Orderitems> osList = orderitemsServiceImpl.queryOrderitemsByPosition(0, desk.getd_id());
		
		//没有
		if(osList.size() == 0){
			System.out.println("失败：查询该餐桌是否有状态为0的总订单---");
			return "0";
		}
		if(osList.size() == 1){
			Orderitems os1 = osList.get(0);
			//根据菜品id查找总订单中的子订单（总订单中不能存在相同菜品的子订单）
			Orderitem oi1 = orderitemServiceImpl.queryOrderitemByMidAndOsid(menu.getm_id(), os1.getos_id());
			if(oi1 == null){
				System.out.println("失败：根据菜品id查找总订单中的子订单");
				return "0";
			}else{
				
				int l = orderitemServiceImpl.updateOrderitemDec(oi1);
				if(l ==1 ){
					//查询子订单信息
					Orderitem oi2 = orderitemServiceImpl.queryOrderitemByMidAndOsid(oi1.getm_id(), oi1.getos_id());
					if(oi2.getoi_num() == 0){
						//如果数量等于0，那么彻底删除这个子订单
						orderitemServiceImpl.deleteOrderitemByOiid(oi1.getoi_id());
						System.out.println("成功：如果数量等于0，那么彻底删除这个子订单");
						return "1";
					}else{
						System.out.println("成功：如果存在 则直接修改菜品信息"+oi1.getoi_id());
						return "1";
					}
				}else{
					System.out.println("失败：如果存在 则直接修改菜品信息");
					return "0";
				}
			}
		}
		else{
			System.out.println("其他情况---------------");
			return "0";
		}
	}
	
	/***
	 * 获取我的餐桌信息
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("mydesk.do")
	public String mydesk(HttpSession session,Model model){
		System.out.println("获取我的餐桌信息");
		Desk desk = (Desk) session.getAttribute("desk");
		//查询该餐桌是否有状态为0的总订单
		List<Orderitems> osList = orderitemsServiceImpl.queryOrderitemsByPosition(0, desk.getd_id());
		if(osList.size() == 1){
			//获取总订单中的子订单 （子订单中要包含菜品的信息）
			List<Orderitem> oiList = orderitemServiceImpl.queryItemByOsid(osList.get(0).getos_id());
			//计算该总订单各个子订单菜品的总数量
			long bageNum = 0;
			for (Orderitem orderitem : oiList) {
				bageNum = orderitem.getoi_num()+bageNum;
			}
			model.addAttribute("bageNum", bageNum);
			//存入总订单和子订单信息
			model.addAttribute("oiList", oiList);
			model.addAttribute("os", osList.get(0));
			return "client/mydesk.jsp";
			
		}else{
			System.out.println("我的餐桌没有任何总订单");
			return "redirect:client/mydesk.jsp";
		}
	}
	
	/***
	 * 清空餐桌
	 * @param os_id
	 * @param model
	 * @return
	 */
	@RequestMapping("isEmpty.do")
	public String isEmpty(String os_id,Model model){
		System.out.println("清空餐桌----------"+os_id);
		if(os_id == null || os_id.equals("")){
			return "mydesk.action"; 
		}else{
			long os_id1 = Long.parseLong(os_id);
			//查找总订单
			Orderitems os = orderitemsServiceImpl.queryOrderitsmByOsid(os_id1);
			//查找所有子订单，并修改状态为3
			List<Orderitem> oiList = orderitemServiceImpl.queryItemByOsid(os_id1);
			int j = 0;
			for (Orderitem oi : oiList) {
				int i = orderitemServiceImpl.updateOrderitemPositionByOiid(3,oi.getoi_id());
				if(i == 0){
					System.out.println("清空餐桌-----删除子菜单时失败！"+oi.getoi_id());
					break;
				}else{
					System.out.println("清空餐桌-----删除子菜单时成功！"+oi.getoi_id());
					j++;
				}
			}
			//当把所有子订单都清空是，再清空总订单
			if(j == oiList.size()){
				int i = orderitemsServiceImpl.updateOrderitemsPositionByOsid(3,os_id1);
				if(i == 1){
					System.out.println("清空餐桌-----删除总订单成功！"+os.getos_id());
					return "redirect:mydesk.do";
				}else{
					System.out.println("清空餐桌-----删除总订单失败！"+os.getos_id());
					return "error.jsp";
				}
			}else{
				System.out.println("子订单未完全清空");
				return "error.jsp";
			}
		}
	}
	
	/***
	 * 获取所有总订单信息
	 * 张洋
	 * @param model
	 * @return
	 */
	@RequestMapping("queryAllOrderitemsMsg.action")
	public @ResponseBody
	Layui queryAllOrderitems(Model model, HttpSession session, PageUtils page){
		System.out.println(page.getLimit()+"jin---------"+page.getCurr());
		List<Orderitems> oList = orderitemsServiceImpl.findAllPage(page.before(), page.after());
		int count = orderitemsServiceImpl.count();
		Layui layui = new Layui();
		layui.setCount(count);
		layui.setData(oList);
		return layui;
	}
	
	/***
	 * 删除订单信息（按编号）
	 * 张洋
	 * @param model
	 * @param session
	 * @param os_id
	 * @return
	 */
	@RequestMapping("delOrderitemsMsg.action")
	public @ResponseBody int delOrderitemsMsg(Model model,HttpSession session,String os_id){
		long osid = Long.parseLong(os_id);
		int i = orderitemsServiceImpl.deleteOrderitemsMsgByOsid(osid);
		if(i == 1){
			return 1;
		}else{
			return 0;
		}
	}
	
	/***
	 * 按订单ID或桌面ID查询总订单
	 * @param model
	 * @param session
	 * @param keyWord
	 * @param keyType
	 * @return
	 */
	@RequestMapping("queryOrderitemsMsgByOsIDorDid.action")
	public @ResponseBody OredritemsTableModel queryOrderitemsMsgByOsIDorDid(Model model,HttpSession session,String keyWord,String keyType){
		List<Orderitems> list = new ArrayList<Orderitems>();
		Orderitems os = new Orderitems();
		if(keyType.equals("os_id")){
			long osid = Long.parseLong(keyWord);
			os = orderitemsServiceImpl.queryOrderitemsByOsId(osid);
			
		}else if(keyType.equals("d_id")){
			long did = Long.parseLong(keyWord);
			list = orderitemsServiceImpl.queryOrderitemsByDid(did);
		}
		list.add(os);
		OredritemsTableModel ot = new OredritemsTableModel();
		ot.setCode(0);
		ot.setCount(1000);
		ot.setData(list);
		return ot;

	}
	
	/***
	 * 按订单时间查询总订单
	 * @param model
	 * @param session
	 * @param keyWord
	 * @param keyType
	 * @return
	 */
	@RequestMapping("queryOrderitemsMsgByOsregtime.action")
	public @ResponseBody OredritemsTableModel queryOrderitemsMsgByOsregtime(Model model,HttpSession session,Date regtime){
		System.out.println("riqi ------------"+regtime);
		List<Orderitems> list = new ArrayList<Orderitems>();
		list = orderitemsServiceImpl.queryOrderitemsByRegtime(regtime);
		OredritemsTableModel ot = new OredritemsTableModel();
		ot.setCode(0);
		ot.setCount(1000);
		ot.setData(list);
		return ot;
	}
	
	/***
	 * 按总订单编号获取所有子订单信息
	 * 张洋
	 * @param model
	 * @return
	 */
	@RequestMapping("queryOrderitemMsgByOsid.action")
	public String queryOrderitemMsgByOsid(Model model,HttpSession session,PageUtils page,String os_id){
		System.out.println(page.getLimit()+"jin--------"+os_id+"--------"+page.getCurr());
		long osid = Long.parseLong(os_id);
		List<Orderitem> oList = orderitemServiceImpl.queryItemByOsidAndLimit(osid,page.before(),page.after());
		int count = orderitemServiceImpl.count(osid);
		Layui layui = new Layui();
		layui.setCount(count);
		layui.setData(oList);
		model.addAttribute("layui", layui);
		return "service/orderitemsDetails.jsp";
	}
	
	
}
