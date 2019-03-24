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
	<style type="text/css">
	.error{
				color: red;
				font-size: 10px;
			}
	</style>
	<script type="text/javascript">
			function pwvalidate(obj){
				//获取input对象
				var value = obj.value;
				//根据id获取span标签的对象
				var spanObj = document.getElementById("pswError");
				//判断用户名是否为空
				if(value == ""){
					spanObj.innerHTML = "密码不能为空！";
					spanObj.className = "error";
					return ;
				}
				//判断用户名的长度
				if(value.length < 6 || value.length > 20){
					spanObj.innerHTML = "密码长度不合法！";
					spanObj.className = "error";
					return ;
				}
				//合法内容
				spanObj.innerHTML = "";
				//spanObj.className = "green";
			}
	</script>
  </head>
  
  <body>
  <div class="layui-row">
    <div class="layui-col-md10">
        <form class="layui-form layui-from-pane" id="emp" style="margin-top:25px" >
            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="e_name" id="e_name" placeholder="请输入姓名" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline" style="width: 250px">
                    <input style="width: 250px;" type="text" name="e_password" id="e_password" placeholder="请输入6-18位密码"  lay-verify="required" autocomplete="off" class="layui-input" onblur="pwvalidate(this);">
                    <span id="pswError"></span>
                </div>
            </div>
            
            <div class="layui-form-item">
                <label class="layui-form-label">职务</label>
                <div class="layui-input-block" style="width: 250px;">
                    <select name="e_job" lay-filter="eqptType" id="e_job">
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
    <div class="layui-inline">
      <label class="layui-form-label">入职日期</label>
      <div class="layui-input-block">
        <input style="width: 250px;" type="text" name="e_regdate" id="date1" autocomplete="off" class="layui-input" placeholder="点击选择入职时间">
      </div>
    </div>
    </div>
            <div class="layui-form-item">
                <label class="layui-form-label">电话</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="e_tel" id="e_tel"  placeholder="请输入联系电话"  lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">住址</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="e_address" id="e_address" placeholder="请输入地址"  lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">工资</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="e_salary" id="e_salary"  placeholder="请输入工资"  lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" style="margin-top:30px">
                <div class="layui-input-block">
                    <button id="btn-add" class="layui-btn layui-btn-lg layui-btn-warm " lay-submit="" lay-filter="demo11">确认添加</button>
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
	$("#btn-add").click(function(){
			//layer.closeAll('iframe');
            var form = new FormData(document.getElementById("emp"));
//             var req = new XMLHttpRequest();
//             req.open("post", "${pageContext.request.contextPath }/updateEmployeeMsg.action", false);
//             req.send(form);
            var e_name = $("#e_name").val();
            var e_password = $("#e_password").val();
            var e_job = $("#e_name").val();
            var e_regdate = $("#date1").val();
            var e_address = $("#e_address").val();
            var e_salary = $("#e_salary").val();
            var e_tel = $("#e_tel").val();

            $.ajax({
                url:"${pageContext.request.contextPath }/addEmployeeMsg.action",
                type:"post",
                contentType:"application/json;charset=utf-8",
                data:JSON.stringify({e_name:e_name,e_password:e_password,e_job:e_job,e_regdate:e_regdate,e_address:e_address,e_salary:e_salary,e_tel:e_tel}),
                success:function(data){
               	 alert("添加成功----1111111111111");
                	//alert(data+"添加成功");
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
			//alert("添加成功----1111111111111");
		parent.layer.closeAll();//关闭弹窗
			
	
	});
</script>
  </body>
</html>
