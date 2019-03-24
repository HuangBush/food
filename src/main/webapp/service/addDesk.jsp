<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addDesk.jsp' starting page</title>
    
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
  
  <body>
  	<div  style="width:379.8px;height:420px;">
   		<form id="fm" class="layui-form layui-from-pane"  style="margin-top:25px" >
            <div class="layui-form-item">
                <label class="layui-form-label">桌台名称</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="d_name"  required  lay-verify="required" autocomplete="off" class="layui-input"  >
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">桌台密码</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="d_password"  required  lay-verify="required" autocomplete="off" class="layui-input" >
                </div>
            </div>
            <div class="layui-form-item">
            	<label class="layui-form-label">桌台类型</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="d_type"  required  lay-verify="required" autocomplete="off" class="layui-input"  >
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">桌台位置</label>
                <div class="layui-input-inline">
                    <input style="width: 250px;" type="text" name="d_place"  required  lay-verify="required" autocomplete="off" class="layui-input" >
                </div>
            </div>
              <div class="layui-form-item" style="margin-top:40px">
                	<div class="layui-input-block" id="btn">
                    	<button id="bt" class="layui-btn  layui-btn-submit ">添加</button>
                	</div>
            </div>
        </form>
   	</div>
   	<script type="text/javascript">
	$("#bt").click(function(){
            var form = new FormData(document.getElementById("fm"));
              $.ajax({
                url:"${pageContext.request.contextPath }/addDesk.action",
                type:"post",
                data:form,
                processData:false,
                contentType:false,
                success:function(){
                },
                error:function(){
                }
            });        
		alert("添加成功");
		parent.layer.closeAll();//关闭弹窗
	});
</script>
  </body>
</html>
