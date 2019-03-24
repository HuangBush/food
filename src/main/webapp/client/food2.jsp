<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>美味大餐</title>
    
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
    	<jsp:param value="food2" name="nav"/>
    </jsp:include>
    <br/><br/><br/>
    <div id="w" >
    <c:forEach  items="${menu }" var="menu" varStatus="index">
			<div id="menu">
	    		<!-- 图片 -->
	    		<div id="menu-img">
	    			<img alt="菜品" src="${pageContext.request.contextPath }${menu.m_img }" height="80px;"width="110px;" style="margin-top: 10px;">
	    		</div>
	    		<!-- 文字 -->
	    		<div id="menu-text">
					<ul>
						<li id="name">${menu.m_name }</li>
						<li id="num">销量：${menu.m_num }</li>
						<li id="price">价格：${menu.m_price }元</li>
					</ul>	
	    		</div>
	    		<!-- 选择数量 -->
	    		<div id="menu-num">
	    			<ul>
	    				<li id="add_${index.count }" data-method="confirmTrans"><i class="layui-icon layui-icon-up  " style="font-size: 20px; color: #ed9715;"></i> </li>
	    				<li id="li_${index.count }">
	    					<span id="number_${index.count }">${menu.m_number }</span>
	    				</li>
	    				<li id="dec_${index.count }" data-method="confirmTrans"><i class="layui-icon layui-icon-down" style="font-size: 20px; color: #ccc;"></i></li>
	    			</ul>
	    		</div>
	    	</div>
	    	<script type="text/javascript">
	    	
		    	/* 选择数量 */
		    	$("#add_${index.count }").click(function(){
		    		var number = $("#number_${index.count }").text();
		    		++number;
		    		food = '已加入一份：${menu.m_name}';
		    		if(number > 10){
		    			food = '已到最大值';
		    			var othis = $(this), method = othis.data('method');
				  		active[method] ? active[method].call(this, othis) : '';
		    			return false;
		    		}
		    		$("#number_${index.count }").remove();
		    		$("#li_${index.count }").append("<span id='number_${index.count }'>"+number+"</span>");
		    		
		    		//加一个 就往我的餐桌加一份菜 生成一个订单
		    		$.get("${pageContext.request.contextPath}/addMenu.do","m_id=${menu.m_id}",
		    			function(result){
		    				  var bageNum =parseInt($("#bage").text());
		    				  if(isNaN(bageNum)){
		    				  	$("#bage-before").after("<span id='bage' class='layui-badge' style='margin-left: 70px;'>1</span>");
		    				  }else{
		    				  	var num = parseInt(result) + parseInt($("#bage").text());
		    				    $("#bage").text(num);
		    				  }
		    			});
		    		var othis = $(this), method = othis.data('method');
				  	active[method] ? active[method].call(this, othis) : '';
		    		
		    	});
		    	
		    	
		    	$("#dec_${index.count }").click(function(){
		    		var number = $("#number_${index.count }").text();
		    		--number;
		    		food = '已减少一份：${menu.m_name}';
		    		if(number < 0){
		    			food = '已到最小值';
		    			var othis = $(this), method = othis.data('method');
				  		active[method] ? active[method].call(this, othis) : '';
		    			return false;
		    		}
		    		$("#number_${index.count }").remove();
		    		$("#li_${index.count }").append("<span id='number_${index.count }'>"+number+"</span>");
		    		
		    		//减一个 就往我的餐桌加一份菜 生成一个订单
		    		$.get("${pageContext.request.contextPath}/decMenu.do","m_id=${menu.m_id}",
		    			function(result){
		    				  var bageNum =parseInt($("#bage").text());
			    			  var num = parseInt($("#bage").text())-parseInt(result);
		    				  if(bageNum == 1){
		    				  	$("#bage").remove();
		    				  }
		    				  $("#bage").text(num);
		    			});
		    		var othis = $(this), method = othis.data('method');
				  	active[method] ? active[method].call(this, othis) : '';
		    	});
		    	
		    		//触发事件
				  var active = {
				    confirmTrans: function(){
				      //配置一个透明的询问框
				      layer.msg(food, {
				        time: 1000, //1s后自动关闭
				      });
				      }
				    };
		    	
		    </script>
		</c:forEach>
    </div>
  </body>
</html>
