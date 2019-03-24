<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <meta charset="utf-8">
	  <title>自助点餐系统</title>
	  <meta name="renderer" content="webkit">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"  media="all">
	  <script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
	  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
	  
	  <style type="text/css">
	  .layui-nav-tree {
		    width: 100px;
		    padding: 0;
		    height: 100%;
		}
		
		.layui-bg-cyan {
		    background-color: #6e8cb4!important;
		}
	  </style>
</head>
  
  <body>
  	<div class="layui-col-xs18 layui-col-sm6 layui-col-md4">
  		${msg }
  	</div>
  </body>
</html>
