<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'uodateExpenseMsg.jsp' starting page</title>
    
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
    <div class="layui-row" style="">
    <div class="layui-col-md10">
        <form class="layui-form layui-from-pane" id="expense" style="margin-top:25px" >
        <div class="layui-form-item">
                <label class="layui-form-label">支出ID</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="ex_id"  required  lay-verify="required" autocomplete="off" class="layui-input" value="${expense.ex_id}" readonly="true">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">支出名</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="ex_name"  required  lay-verify="required" autocomplete="off" class="layui-input" value="${expense.ex_name}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">金额</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="ex_price"  required  lay-verify="required" autocomplete="off" class="layui-input" value="${expense.ex_price}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">支出详情</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="ex_other"  required  lay-verify="required" autocomplete="off" class="layui-input" value="${expense.ex_other}">
                </div>
            </div>
             <div class="layui-form-item">
    			<div class="layui-inline">
     				 <label class="layui-form-label">支出日期</label>
     		    <div class="layui-input-block">
        			 <input style="width: 250px;" type="text" name="ex_regtime" id="date1" autocomplete="off" class="layui-input" 
        			 	value='<fmt:formatDate  value="${expense.ex_regtime}" pattern="yyyy-MM-dd"/>'>
      			</div>
    			</div>
    		</div>

            <div class="layui-form-item" style="margin-top:20px;margin-left:100px;">
                <div class="layui-input-block">
                    <button id="btn-update" class="layui-btn  layui-btn-submit " lay-submit="" lay-filter="demo11">确认修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
});
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
<script type="text/javascript">
	$("#btn-update").click(function(){
			//layer.closeAll('iframe');
            var form = new FormData(document.getElementById("expense"));
            alert("form----"+form);
//             var req = new XMLHttpRequest();
//             req.open("post", "${pageContext.request.contextPath }/updateExpenseMsg.action", false);
//             req.send(form);
            $.ajax({
                url:"${pageContext.request.contextPath }/updateExpenseMsg.action",
                type:"post",
                data:form,
                processData:false,
                contentType:false,
                success:function(data){
                	alert(data+"修改成功");
                	layer.close(index);
                	//layer.closeAll();
                    //window.clearInterval(timer);
                    //console.log("over..");
                },
                error:function(e){
                    alert("错误！！");
                    window.clearInterval(timer);
                }
            });        
			parent.layer.closeAll();//关闭弹窗
	
	});
</script>


  </body>
</html>
