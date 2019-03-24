<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'updateEmployeeMsg.jsp' starting page</title>
    
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
        <form class="layui-form layui-from-pane" id="emp" style="margin-top:25px" >

            <div class="layui-form-item">
                <label class="layui-form-label">编号</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="e_id"  required  lay-verify="required" autocomplete="off" class="layui-input" readonly="readonly" value="${emp.e_id}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="e_name"  required  lay-verify="required" autocomplete="off" class="layui-input" value="${emp.e_name}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="e_password"  required  lay-verify="required" autocomplete="off" class="layui-input" value="${emp.e_password}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">电话</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="e_tel"  required  lay-verify="required" autocomplete="off" class="layui-input" value="${emp.e_tel}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">住址</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="e_address"  required  lay-verify="required" autocomplete="off" class="layui-input" value="${emp.e_address}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">职务</label>
                <div class="layui-input-block" style="width: 250px;" value="${emp.e_job}">
                    <select name="e_job" lay-filter="eqptType">
                    	<option selected = "selected" value="${emp.e_job}">${emp.e_job}</option>
                        <option value="厨师">厨师</option>
                        <option value="店长">店长</option>
                        <option value="经理">经理</option>
                        <option value="领班">领班</option>
                        <option value="传菜员">传菜员</option>
                        <option value="服务员">服务员</option>
                        <option value="水台工">水台工</option>
                        <option value="洗碗工">洗碗工</option>
                        <option value="配菜员">配菜员</option>
                        <option value="收银员">收银员</option>
                        <option value="打杂">打杂</option>
                        <option value="保安">保安</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">工资</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="e_salary"  required  lay-verify="required" autocomplete="off" class="layui-input" value="${emp.e_salary}">
                </div>
            </div>

            <div class="layui-form-item" style="margin-top:40px">
                <div class="layui-input-block">
                    <button id="btn-update" class="layui-btn  layui-btn-submit " lay-submit="" lay-filter="demo11">确认修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
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
            var form = new FormData(document.getElementById("emp"));
            alert("form----"+form);
//             var req = new XMLHttpRequest();
//             req.open("post", "${pageContext.request.contextPath }/updateEmployeeMsg.action", false);
//             req.send(form);
            $.ajax({
                url:"${pageContext.request.contextPath }/updateEmployeeMsg.action",
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
			
	
	});
</script>
  </body>
</html>
