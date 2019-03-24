<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>支付成功：订单详细</title>
    
	 <meta name="renderer" content="webkit">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"  media="all">
	  <script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
	  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
	
	<style type="text/css">
		body{
			margin: 0px;
			padding: 0px;
			width: 100%;
			height: 100%;
			}
	</style>
  </head>
  
  <body>
  	<div style="margin-top: 15%">
  		<div style="width: 100%">
  		</div>
  		<!-- 已开台桌台详单 -->
     		<div style="width: 70%;margin-left: 15%;">
     			<div style="margin:20 auto"><center><h2>${desk.d_name }</h2></center></div>
     			<div><fmt:formatDate value="${os.os_regtime }" pattern="yyyy-MM-dd hh:mm"/></div>
     			
     			<div>-----------------------------------------------------------------</div>
     			<div>-----------------------------------------------------------------</div>
     			<div>
     				<table >
     					<tr style="width: 100%">
   							<th  width="100px">菜品名称</th>
   							<th  width="60px;">数量</th>
   							<th  width="50px;">单价</th>
   							<th  width="50px;">小计</th>
     					</tr>
     				</table>
     			</div>
     			<div>-----------------------------------------------------------------</div>
     			<div>
     				<c:forEach items="${oiList }" var="oi">
	     				<table style="margin-bottom: 10px;">
	     					<tr  style="width: 100%;height:20px;text-align: center;">
	   							<td  width="100px">${oi.menu.m_name }</td>
	   							<td  width="60px;">${oi.oi_num }</td>
	   							<td  width="50px">${oi.menu.m_price }</td>
	   							<td  width="50px">${oi.oi_price }</td>
	     					</tr>
	     				</table>
     				</c:forEach>
     			</div>
     			<div>-----------------------------------------------------------------</div>
     			<div>
     				<table >
     					<tr height="20px" >
   							<th align="left" width="100px" style="text-align: center;">总计</th>
   							<th align="right" width="80px">${os.os_allprice }元</th>
     					</tr>
     				</table>
     			</div>
     			<br/>
     			<div>
     				<button class="layui-btn " style="width: 45%;margin-left: 5%;float: left;">
     					<a href="${pageContext.request.contextPath }/ismydesk.do">我想加菜</a>
     				</button>
	 	 			<button class="layui-btn layui-btn-primary" style="width: 45%;margin-left: 5%;float: left;">
	 	 				<a href="${pageContext.request.contextPath }/leaveDesk.do">结束用餐</a>
	 	 			</button>
     			</div>
     		</div>
  		
  	</div>
  </body>
</html>
