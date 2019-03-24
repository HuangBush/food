package com.hyf.food.action;

import com.hyf.food.entity.Desk;
import com.hyf.food.entity.Layui;
import com.hyf.food.entity.Orderitem;
import com.hyf.food.entity.Orderitems;
import com.hyf.food.entity.Menu;
import com.hyf.food.service.IMenuService;
import com.hyf.food.service.IOrderitemService;
import com.hyf.food.service.IOrderitemsService;
import com.hyf.food.utils.FileUploadUtil;
import com.hyf.food.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@Controller
public class MenuAction {
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private IOrderitemsService orderitemsServiceImpl;
	
	@Autowired
	private IOrderitemService orderitemServiceImpl;
	
	/***
	 * 获取所有推荐菜品
	 * @param model
	 * @return
	 */
	@RequestMapping("queryRecommendMenu.do")
	public String queryRecommendMenu(Model model,HttpSession session){
		System.out.println("获取所有推荐菜品信息");
		Desk desk = (Desk) session.getAttribute("desk");
		//查询所有菜单
		List<Menu> mList = menuService.queryMenuByPosition2();
		
		//查询该餐桌是否有状态为0的总订单
		List<Orderitems> osList = orderitemsServiceImpl.queryOrderitemsByPosition(0, desk.getd_id());
		//如果没有总订单，则直接返回
		if(osList.size() == 0){
			System.out.println("获取所有推荐菜品:如果没有总订单，则直接返回");
			model.addAttribute("menu", mList);
			return "/client/orderFood.jsp";
		}
		//如果有总订单
		if(osList.size() == 1){
			//那么获取所有子订单信息
			List<Orderitem> oiList =  orderitemServiceImpl.queryItemByOsid(osList.get(0).getos_id());
			if(oiList.size() == 0){
				model.addAttribute("bageNum", 0);
				model.addAttribute("menu", mList);
				return "client/orderFood.jsp";
			}else{
				System.out.println("//那么获取所有子订单信息"+oiList.get(0).getoi_id());
				//将用户选择的菜品数量 装入到menu类的number属性中
				long bageNum = 0;//计算该总订单各个子订单菜品的总数量
				for (Orderitem orderitem : oiList) {
					bageNum = orderitem.getoi_num()+bageNum;
					for (Menu menu : mList) {
						if(menu.getm_id().equals(orderitem.getMenu().getm_id())){
							menu.setM_number(orderitem.getoi_num());
						}
					}
				}
				model.addAttribute("bageNum", bageNum);
				model.addAttribute("menu", mList);
				return "client/orderFood.jsp";
			}
		}
		else{
			System.out.println("获取所有推荐菜品:其他情况----");
			model.addAttribute("menu", mList);
			return "client/orderFood.jsp";
		}
	}
	
	/***
	 * 按照菜单类别获取菜品
	 * @param model
	 * @param m_type
	 * @return
	 */
	@RequestMapping("queryAllMenuByType.do")
	public String queryAllMenuByType(Model model,String m_type,HttpSession session){
		System.out.println("按照菜单类别获取菜品-----------"+m_type);
		Desk desk = (Desk) session.getAttribute("desk");
		//查询所有菜单
		List<Menu> mList = menuService.queryMenuByType(m_type);
		model.addAttribute("menu", mList);
		//查询该餐桌是否有状态为0的总订单
		List<Orderitems> osList = orderitemsServiceImpl.queryOrderitemsByPosition(0, desk.getd_id());
		//如果没有总订单，则直接返回
		if(osList.size() == 0){
			System.out.println("获取所有推荐菜品:如果没有总订单，则直接返回");
			model.addAttribute("menu", mList);
			if(m_type.equals("酒水饮料")){
				return "client/drink.jsp";
			}
			else if(m_type.equals("精致小炒")){
				return "client/food1.jsp";
			}
			else if(m_type.equals("美味大餐")){
				return "client/food2.jsp";
			}
			else if(m_type.equals("招牌干锅")){
				return "client/food3.jsp";
			}
			else if(m_type.equals("营养靓汤")){
				return "client/food4.jsp";
			}else{
				return "client/orderFood.jsp";
			}
		}
		if(osList.size() == 1){
			//那么获取所有子订单信息
			List<Orderitem> oiList =  orderitemServiceImpl.queryItemByOsid(osList.get(0).getos_id());
			if(oiList.size() == 0){
				model.addAttribute("bageNum", 0);
				model.addAttribute("menu", mList);
				if(m_type.equals("酒水饮料")){
					return "client/drink.jsp";
				}
				else if(m_type.equals("精致小炒")){
					return "client/food1.jsp";
				}
				else if(m_type.equals("美味大餐")){
					return "client/food2.jsp";
				}
				else if(m_type.equals("招牌干锅")){
					return "client/food3.jsp";
				}
				else if(m_type.equals("营养靓汤")){
					return "client/food4.jsp";
				}else{
					return "client/orderFood.jsp";
				}
			}else{
				System.out.println("//那么获取所有子订单信息"+oiList.get(0).getoi_id());
				//将用户选择的菜品数量 装入到menu类的number属性中
				long bageNum = 0;//计算该总订单各个子订单菜品的总数量
				for (Orderitem orderitem : oiList) {
					bageNum = orderitem.getoi_num()+bageNum;
					for (Menu menu : mList) {
						if(menu.getm_id().equals(orderitem.getMenu().getm_id())){
							menu.setM_number(orderitem.getoi_num());
						}
					}
				}
				model.addAttribute("bageNum", bageNum);
				model.addAttribute("menu", mList);
				if(m_type.equals("酒水饮料")){
					return "client/drink.jsp";
				}
				else if(m_type.equals("精致小炒")){
					return "client/food1.jsp";
				}
				else if(m_type.equals("美味大餐")){
					return "client/food2.jsp";
				}
				else if(m_type.equals("招牌干锅")){
					return "client/food3.jsp";
				}
				else if(m_type.equals("营养靓汤")){
					return "client/food4.jsp";
				}else{
					return "client/orderFood.jsp";
				}
			}
		}
		else{
			System.out.println("获取所有推荐菜品:其他情况----");
			model.addAttribute("menu", mList);
			if(m_type.equals("酒水饮料")){
				return "client/drink.jsp";
			}
			else if(m_type.equals("精致小炒")){
				return "client/food1.jsp";
			}
			else if(m_type.equals("美味大餐")){
				return "client/food2.jsp";
			}
			else if(m_type.equals("招牌干锅")){
				return "client/food3.jsp";
			}
			else if(m_type.equals("营养靓汤")){
				return "client/food4.jsp";
			}else{
				return "client/orderFood.jsp";
			}
		}
	}
	
	////////////////刘超 3.1新增///////////////////////////
	/**
	* 分页查询所有菜品信息
	* @param model
	* @param page
	* @return
	*/
	@RequestMapping("queryAllMenu.action")
	public @ResponseBody
	Layui queryAllMenu(Model model, PageUtils page){
		System.out.println("***********************************"+page.getLimit()+page.getCurr());
		List<Menu> mList = menuService.findAllPage(page.before1(), page.after());
		int count = menuService.count();
		Layui layui = new Layui();
		layui.setCount(count);
		layui.setData(mList);
		System.out.println(layui);
		return layui;
	}
	/**
	* 修改菜品状态为3（已下架）
	* @param m_id
	*/
	@RequestMapping("deleteMenu.action")
	public void deleteMenu(Long m_id){
		menuService.deleteMenu(m_id);
	}
	/**
	* 修改菜品状态为2（推荐）
	* @param m_id
	*/
	@RequestMapping("specialMenu.action")
	public void specialMenu(Long m_id){
		menuService.specialMenu(m_id);
	}
	/**
	* 修改菜品状态为0（在售）
	* @param m_id
	*/
	@RequestMapping("onsaleMenu.action")
	public void onsaleMenu(Long m_id){
		menuService.onsaleMenu(m_id);
	}
	////////////////刘超 3.2新增///////////////////////////
	/**
	* 添加新菜品
	* @param m_id
	*/
	@RequestMapping("addNewMenu.action")
	public String addNewMenu(Menu menu){
		menuService.addMenu(menu);
		return "service/menuManager.jsp";
	}
	/**
	* 新菜品上传图片后返回路径
	* @param m_id
	*/
	@RequestMapping("uploadPicture.action")
	public @ResponseBody Layui updateImg(MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		//获取照片上传
		System.out.println("上传照片+++++++++++++++="+file.toString());
		String filePath = FileUploadUtil.upload(file, request);
		System.out.println("上传照片2222---------"+filePath);
		Layui lay = new Layui();
		lay.setPath(filePath);
		return lay; 
	}
	/**
	* 根据菜品编号查询菜品
	* @param m_id
	*/
	@RequestMapping("queryMenuById.action")
	public String queryMenuById(Model model,Long m_id){
		Menu menu = menuService.queryMenuById(m_id);
		model.addAttribute("menu",menu);
		return "service/updateMenu.jsp";
	}
	/**
	* 修改菜品信息
	* @param menu
	*/
	@RequestMapping("updateMenu.action")
	public void updateMenu(Menu menu){
		System.out.println("我开始修改了");
		menuService.updateMenu(menu);
		System.out.println("修改成功");
	}
	
}
