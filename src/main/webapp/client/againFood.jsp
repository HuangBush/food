<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>已付款菜品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/menu.css">
	<style type="text/css">
		body{
		margin: 0px;
		padding: 0px;
		width: 100%;
		height: 100%;
		 background-image: url("${pageContext.request.contextPath }/img/004.jpg");
	}
	#W{
		width: 72.5%;
		height: 88%;
		margin-left: 27.5%;
		margin-top: 12px;
		overflow-y:auto; 
	}
	</style>
  </head>
  <body>
	<jsp:include page="nav.jsp">
    	<jsp:param value="again" name="nav"/>
    </jsp:include>
    <br/><br/><br/>
    <div id="w" >
    	<c:forEach  items="${os1.oiList }" var="oi" varStatus="index">
			<div id="menu">
	    		<!-- 图片 -->
	    		<div id="menu-img">
	    			<img alt="菜品" src="${pageContext.request.contextPath }${oi.menu.m_img }" height="80px;"width="110px;" style="margin-top: 10px;">
	    		</div>
	    		<!-- 文字 -->
	    		<div id="menu-text">
					<ul>
						<li id="name">${oi.menu.m_name }</li>
						<li id="num">数量：${oi.oi_num }</li>
						<li id="price">小计：${oi.oi_price }元</li>
					</ul>	
	    		</div>
	    		<!-- 选择数量 -->
	    		<%-- <div id="menu-num">
	    			<ul>
	    				<li id="add_${index.count }"><i class="layui-icon layui-icon-up  " style="font-size: 20px; color: #ed9715;"></i> </li>
	    				<li id="li_${index.count }">
	    					<span id="number_${index.count }">${oi.oi_num }</span>
	    				</li>
	    				<li id="dec_${index.count }"><i class="layui-icon layui-icon-down" style="font-size: 20px; color: #ccc;"></i></li>
	    			</ul>
	    		</div> --%>
	    	</div>
		   </c:forEach>
		   <c:if test="${os1 == null }">
		   <div >
		   		<img alt="空空如也" src="${pageContext.request.contextPath }/img/001.jpg" width="50%;"height="30%" style="margin-left: 50px;margin-top: 100px;">
		   </div>
		   </c:if>
    </div>
  </body>
</html>
