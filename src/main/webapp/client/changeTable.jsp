<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>智能时尚餐厅</title>
    
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
			height: 70%;
			margin-top: 30%;
			}
	</style>
  </head>
  
  <body>
  	<div >
  		<div style="width: 100%">
  		</div>
  		<!-- 已开台桌台详单 -->
		<div style="text-align: center;font-size: 15px;font-weight: 800;">
			温馨提示
		</div>
		<br/>
		<div style="text-align: center;font-size: 15px;font-weight: 800;">
			请扫描其他桌上的二维码
		</div>
		<br/>
		<div style="text-align: center;">
			<img alt="谢谢惠顾" src="${pageContext.request.contextPath }/img/012.png" width="60%" height="50%">
		</div> 		
  	</div>
  </body>
</html>
