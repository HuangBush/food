<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>是否选择加餐</title>
    
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
			background-image: url("${pageContext.request.contextPath }/img/004.jpg");
			}
	</style>
  </head>
  
  <body>
  	<div style="margin-top: 30%">
  		<label class="layui-form-label" style="width: 95%;text-align: center;font-weight: 800;font-size: 16px;color:#ccc">时尚智能餐厅提醒您</label>
	    <label class="layui-form-label" style="width: 95%;text-align: center;font-weight: 800;font-size: 16px;color:#ccc"">检测到${desk.d_name }正在被人使用</label>
	    <br/><br/><br/>
	  	<button class="layui-btn layui-btn-primary" style="width: 70%;margin-left: 15%"><a href="${pageContext.request.contextPath }/ismydesk.do">我是该桌的客人，要为该桌加菜。</a></button>
	  	<br/><br/>
	  	<button class="layui-btn " style="width: 70%;margin-left: 15%"><a href="changeTable.jsp">我不是此桌的客人，换另一桌。</a></button>
	  	<div style="width: 100%;text-align: center;">
	  		<img alt="提醒" src="${pageContext.request.contextPath }/img/012.png" width="300px" height="250px;" >
	  	</div>
  	</div>
  </body>
</html>
