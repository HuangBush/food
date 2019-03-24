<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'deskManager.jsp' starting page</title>
    
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
  
  </head>
  
  <body style="background-image: url(/food/img/papper1.jpg);background-size:cover">
   <div  style="width:379.8px;height:430px;">
   
   	<!-- 已开台桌台详单 -->
     		<div style="margin:15px 25px">
     			<div ><center><h2>桌号：${d_name}</h2></center></div>
     			<div>开台时间:
     				<f:formatDate value="${order.os_regtime}" pattern="yyyy-MM-dd HH:mm"/>
     			</div>
     			<div>-----------------------------------------------------------------------------</div>
     			<div>-----------------------------------------------------------------------------</div>
     			<div>
     				<table >
     					<tr >
   							<th align="left" width="180px">菜品名称</th>
   							<th align="center" width="60px">数量</th>
   							<th align="center" width="60px">单价</th>
   							<th align="right" width="60px">小计</th>
     					</tr>
     				</table>
     			</div>
     			<div>-----------------------------------------------------------------------------</div>
     			<div>
     				<c:forEach items="${order.oiList}" var="oi">
	     				<table style="margin-bottom: 10px;">
	     					<tr height="20px">
	   							<td  align="left" width="180px">${oi.menu.m_name }</td>
	   							<td  align="center" width="60px">${oi.oi_num }</td>
	   							<td  align="center" width="60px">${oi.menu.m_price }</td>
	   							<td  align="right" width="60px">${oi.oi_price }</td>
	     					</tr>
	     				</table>
     				</c:forEach>
     			</div>
     			<div>-----------------------------------------------------------------------------</div>
     			<div>
     				<table >
     					<tr height="20px">
   							<th align="left" width="180px">合计</th>
   							<th align="center" width="140px">${size }项</th>
   							<th align="right" width="105px">${order.os_allprice }元</th>
     					</tr>
     				</table>
     			</div>
     			<div style="margin-top:40px;margin-bottom:60px;">
     				<div id="print" class="layui-btn layui-btn-lg layui-btn-radius">打印</div>
     				<div id="buy" class="layui-btn layui-btn-lg layui-btn-radius layui-btn-warm"style="float:right">结账</div>
     			</div>
   		</div>
   	</div>
   	<script type="text/javascript">
	   		//Demo
		layui.use('form', function(){
		  var form = layui.form;
		layui.use('layer', function(){
			var layer = layui.layer;
			});  
		  //监听提交
		  form.on('submit(formDemo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		});
		$('#print').click(function(){
			var that = this;
			layer.tips('请连接打印机',that);
		});
		$('#buy').click(function(){
			var os_id = '${order.getOiList().get(0).getos_id()}';
			alert(os_id);
              $.ajax({
                url:"${pageContext.request.contextPath }/accountOrder.action?os_id="+os_id,
                type:"post",
               // data:os_id, 
                processData:false,
                contentType:false,
                success:function(){
                },
                error:function(){
                }
            });        
		alert("结账成功！");
		parent.layer.closeAll();//关闭弹窗
		});
   	</script>
   	
  </body>
</html>
