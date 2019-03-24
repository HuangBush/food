<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'nav.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
  </head>
  <style type="text/css" >
  	a {
	  cursor:pointer;
	}
  </style>
  <body >
	    <div class="layui-layout layui-layout-admin" >
	  	<div class="layui-header" style="position:fixed;top:0px;width:100%;">
	    <div class="layui-logo"><b style="color: ">点餐后台</b></div>
	    <!-- 头部区域（可配合layui已有的水平导航） -->
	    <ul class="layui-nav layui-layout-left">
	      <li class="layui-nav-item">
	      	<a href="${pageContext.request.contextPath }/countDesk.action">
	      		<i class="layui-icon layui-icon-home" style="font-size: 22px;"></i>
	      	</a>
	      </li>
	      
	      <li class="layui-nav-item"><a href="javascript:;">收入/支出</a>
	      	<dl class="layui-nav-child">
	          <dd><a href="${pageContext.request.contextPath }/service/billManage.jsp">收入管理</a></dd>
	          <dd><a href="${pageContext.request.contextPath }/service/ExpenseManage.jsp">支出管理</a></dd>
	        </dl>
	      </li>
	      <li class="layui-nav-item">
	        <a href="${pageContext.request.contextPath }/service/menuManager.jsp">菜品管理</a>
	        <dl class="layui-nav-child">
	          <dd><a href="${pageContext.request.contextPath }/service/addMenu.jsp">新增菜品</a></dd>
	        </dl>
	      </li>
	      <li class="layui-nav-item" id="empManager"><a href="${pageContext.request.contextPath }/service/userManager.jsp">员工管理</a></li>
	    </ul>
	    <ul class="layui-nav layui-layout-right">
	      <li class="layui-nav-item">
	        <a href="#">
	          <i class="layui-icon layui-icon-user" style="font-size: 22px; color: #1E9FFF;"></i> 
	           ${admin.a_name }${emp.e_name }
	        </a>
	        <dl class="layui-nav-child">
	          <dd data-method="setTop" id="personal"><a href="javascript:;">基本资料</a></dd>
	          <dd><a href="#">安全设置</a></dd>
	        </dl>
	      </li>
	      <li class="layui-nav-item"><a href="${pageContext.request.contextPath }/loginOut.action">退了</a></li>
	    </ul>
	  	</div>
	  	</div>
  <script>
		//JavaScript代码区域
		layui.use('element', function(){
		  var element = layui.element;
		});
  </script>
   <script type="text/javascript">
  	if("${emp.e_name}"!=null &&"${emp.e_name}"!=""){
  		$("#empManager").hide();
  	}
  	if("${admin.a_name}"!=null && "${admin.a_name}"!="" ){
  	$("#empManager").show();
  	}
  	
  	//JavaScript代码区域
		layui.use('element', function(){
		  var element = layui.element;
		});
  </script>
   <script>
  layui.use('layer', function(){ //独立版的layer无需执行这一句
  
  var active = {
    setTop: function(){
      //多窗口模式，层叠置顶
      layer.open({
       		  type: 2,
              maxmin:true,
              shadeClose:true,
              title: "按状态查找员工信息",
              area: ['4500px', '2000px'],
              content:'${pageContext.request.contextPath }/queryEmployeeById.action?e_id=${emp.e_id}'
      });
    }
    
  };
  
  $('#personal').on('click', function(){
    var othis = $(this), method = othis.data('method');
    active[method] ? active[method].call(this, othis) : '';
  });
 });
           //动态向表传递赋值可以参看文章进行修改界面的更新前数据的显示，当然也是异步请求的要数据的修改数据的获取
           //setFormValue(obj,data);
  		
		
  </script>
  </body>
</html>
