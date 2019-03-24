<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css" >
		.table{
			width:153.6px;
			height:153.6px;
			float:left;
			background-image: url(/img/tt-tt.png);
			background-size:100% 100%;
		}
		
	</style>
  </head>
  <body style="background-color: #2F4056">
	 <jsp:include page="nav.jsp"></jsp:include>
     <div class="layui-col-md12" style="margin-top:70px">
     	<!-- 显示桌台 -->
     	<div id="desk" style="width:60%; margin:20px auto;">
     		<c:forEach var="desk" items="${list}" varStatus="d">
     			<c:choose>
     				<c:when test="${desk.d_position==1}">
	     				<a><div class="table table_busy_${d.count}"><span class="layui-badge">${d.count}号  &nbsp&nbsp已使用</span></div></a>
	     			</c:when>
	     			<c:when test="${desk.d_position==0}">
	     				<a><div class="table table_free_${d.count}"><span class="layui-badge layui-bg-blue">${d.count}号  &nbsp&nbsp待使用</span></div></a>
	     			</c:when>
     			</c:choose>
     			<script>
		       layui.use('layer', function(){
  				var layer = layui.layer;
  				});  
  				//已使用桌面
		        $('.table_busy_${d.count}').click(function(obj){
		        		var id="${desk.d_id}";
		        		 layer.open({
			               //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
			               type: 2,
			               shadeClose:true,
			               area: ['412px', '490px'],
			               offset: '65px',
			               move: false,
			               title: "桌台信息",
			               content:'${pageContext.request.contextPath }/querytDeskById.action?d_id='+id,
			               end: function() {
	        				//刷新页面, 
							location.reload();
							}
			           });
		        });
		        //未使用桌面
		        $('.table_free_${d.count}').click(function(obj){
		        		var id="${desk.d_id}";
		        		 layer.open({
			               //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
			               type: 2,
			               shadeClose:false,
			               area: ['412px', '490px'],
			               offset: '65px',
			               move: false,
			               title: "桌台信息",
			               content:'${pageContext.request.contextPath }/querytDeskById.action?d_id='+id,
			               end: function() {
	        				//刷新页面, 
							location.reload();
							}
			           });
		        });
		 	  </script>
     		</c:forEach>
     	</div>
     </div>
  </body>
</html>
