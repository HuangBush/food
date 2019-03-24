package com.hyf.food.action;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.hyf.food.entity.Menu;
import com.hyf.food.entity.Orderitem;
import com.hyf.food.entity.Orderitems;
import com.hyf.food.service.IMenuService;
import com.hyf.food.service.IOrderitemService;
import com.hyf.food.service.IOrderitemsService;
import com.hyf.food.utils.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/***
 * 支付宝支付接口
 * @author 黄逸峰
 *
 */
@Controller
public class AlipayAction {
	
	@Autowired 
	private IOrderitemsService orderitemsServiceImpl;
	
	@Autowired
	private IOrderitemService orderitemServiceImpl;
	
	@Autowired
	private IMenuService menuServiceImpl;
	
	/***
	 * 支付宝支付接口
	 * @param request
	 * @param os
	 * @param model1
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("alipay.do")
	public void alipay(HttpServletResponse response,HttpServletRequest request,String os_id,Model model1) throws IOException{
		System.out.println("进入支付环节"+os_id);
		
		//获取总订单信息，以便于获取总价
		long os_id1 = Long.parseLong(os_id);
		Orderitems os = orderitemsServiceImpl.queryOrderitsmByOsid(os_id1);
		
		// 商户订单号，商户网站订单系统中唯一订单号，必填
	    String out_trade_no = os.getos_id().toString();
		// 订单名称，必填
	    String subject = "自助餐厅自助订单";
		System.out.println(subject);
	    // 付款金额，必填
	    String total_amount=os.getos_allprice().toString();
	    // 商品描述，可空
	    String body = "欢迎光临";
	    // 超时时间 可空
	   String timeout_express="2m";
	    // 销售产品码 必填
	    String product_code="QUICK_WAP_WAY";
	    /**********************/
	    // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签     
	    //调用RSA签名方式
	    AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
	    AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();
	    
	    // 封装请求支付信息
	    AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
	    model.setOutTradeNo(out_trade_no);
	    model.setSubject(subject);
	    model.setTotalAmount(total_amount);
	    model.setBody(body);
	    model.setTimeoutExpress(timeout_express);
	    model.setProductCode(product_code);
	    alipay_request.setBizModel(model);
	    // 设置异步通知地址
	    alipay_request.setNotifyUrl(AlipayConfig.notify_url);
	    // 设置同步地址
	    alipay_request.setReturnUrl(AlipayConfig.return_url);   
	    System.out.println("调用SDK生成表单-------------------------");
	    // form表单生产
	    String form = "";
		try {
			// 调用SDK生成表单
			form = client.pageExecute(alipay_request).getBody();
			response.setContentType("text/html;charset=" + AlipayConfig.CHARSET); 
		    response.getWriter().write(form);//直接将完整的表单html输出到页面 
		    response.getWriter().flush(); 
		    System.out.println("直接将完整的表单html输出到页面______________________________-");
		    response.getWriter().close();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 * 获取返回信息 完成支付
	 * @param request
	 * @param total_amount
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("returnMsg.do")
	public String returnMsg(HttpServletRequest request,HttpServletResponse response,Model model,HttpSession session) throws Exception{
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号

		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

		//支付宝交易号

		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		//计算得出通知验证结果
		//boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
		boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, "RSA2");
		
		if(verify_result){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码
			//该页面可做页面美工编辑
			System.out.println("验证成功");
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
			//将改总订单和子订单状态改为1
			//总订单号
			long os_id = Long.parseLong(out_trade_no);
			Orderitems os = orderitemsServiceImpl.queryOrderitsmByOsid(os_id);
			//查找所有子订单，并修改状态为1
			List<Orderitem> oiList = orderitemServiceImpl.queryItemByOsid(os_id);
			int j = 0;
			for (Orderitem oi : oiList) {
				int i = orderitemServiceImpl.updateOrderitemPositionByOiid(1,oi.getoi_id());
				if(i == 0){
					System.out.println("支付成功-----删除子菜单时失败！"+oi.getoi_id());
					break;
				}else{
					//子订单修改成功后再将菜品销量+1
					//1、获取菜品信息
					Menu menu = oi.getMenu();
					//2、再将该菜品的选择的数量 临时存入 菜品属性number中
					menu.setM_number(oi.getoi_num());
					menuServiceImpl.updateMenuNumByMid(menu);
					System.out.println("支付成功-----删除子菜单时成功！"+oi.getoi_id());
					j++;
				}
			}
			//当把所有子订单都修改后，再修改总订单
			if(j == oiList.size()){
				int i = orderitemsServiceImpl.updateOrderitemsPositionByOsid(1,os_id);
				if(i == 1){
					System.out.println("支付成功-----删除总订单成功！"+os.getos_id());
					//子订单和总订单先后修改完后，再跳转到订单页面，并发送订单信息
					model.addAttribute("os", os);//当前支付菜单的信息
					model.addAttribute("oiList", oiList);//当前支付菜单的信息
					//并将此加餐的总订单的子订单信息转移到该客人第一个订单中
					//1.获取存入Session的第一个总订单的信息
					Orderitems os1 = (Orderitems) session.getAttribute("os_pay");
					//System.out.println("获取存入Session的第一个总订单的信息---------"+os1.getOiList().get(0).getos_id());
					//1.1 如果session 没有值则不进行修改
					if(os1 == null || os1.equals("")){
						/*//当所有删除订单信息删除成功后，再将desk的session删除
						session.removeAttribute("desk");*/
						return "client/myMenu.jsp";
					}else{
						//1.2 如果有值 则修改
						int k = 0;
						//2.批量修改加餐子订单的总订单id，                //如果加餐子订单的与第一个总订单的子订单的菜品一样，则直接修改子订单数量
						for (Orderitem oi : oiList) {
							System.out.println(os1.getOiList().get(0).getos_id()+"//2.批量修改加餐子订单的总订单id，---------"+oi.getoi_id());
							System.out.println("打印总订单id-------------"+os1.getOiList().get(0).getos_id());
							k = orderitemServiceImpl.updateOrderitemOsidByOiid(os1.getOiList().get(0).getos_id(), oi.getoi_id());
							//并修改所有子订单的状态为1
							orderitemServiceImpl.updateOrderitemPositionByOiid(1, oi.getoi_id());
							k++;
							//2.1 同时修改总订单价格,如果有多个数量
							float total = (oi.getoi_price()*oi.getoi_num());
							orderitemsServiceImpl.updateOrderitemsPriceByOsid(total, os1.getOiList().get(0).getos_id());
						}
						System.out.println("修改了"+k+"条数据----------------------");
						if(k != 0){
							//3.清除掉加餐总订单的session
							session.removeAttribute("os_pay");
							session.removeAttribute("again");
							//4.将第一个订单的菜品信息传入页面
							model.addAttribute("os1", os1);
							//5.将加餐的总订单彻底删除掉
							int i1 = orderitemsServiceImpl.deleteOrderitemsByOsid(os_id);
							System.out.println(os_id+"将加餐的总订单彻底删除掉--------"+i1);
							if( i1 == 0){
								System.out.println("彻底删除失败-------------");
								return "error.jsp";
							}
							/*//当所有删除订单信息删除成功后，再将desk的session删除
							session.removeAttribute("desk");*/
							return "client/myMenu12.jsp";
						}else{
							System.out.println("删除失败-----------------------");
							return "error.jsp";
						}
					}
				}else{
					//System.out.println("支付成功-----删除总订单失败！"+os.getos_id());
					return "error.jsp";
				}
			}else{
				System.out.println("子订单未完全清空");
				return "error.jsp";
			}
		}else{
			//该页面可做页面美工编辑
			System.out.println("验证失败------------------------------");
			return "error.jsp";
		}
	}
}
