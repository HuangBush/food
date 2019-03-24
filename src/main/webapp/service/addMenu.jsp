<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'addMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color: #2F4056">
    <jsp:include page="nav.jsp"></jsp:include>
    <div class="layui-col-md12" style="margin-top:60px;padding-top:20px">
    	<div style="color:white;"><center><h1>新增菜品</h1></center></div>
    	<div style="width:50%;margin:50px auto">
    		<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath }/addNewMenu.action" method="post">
			  <div class="layui-form-item">
			    <label class="layui-form-label">菜品</label>
			    <div class="layui-input-block">
			      <input type="text" name="m_name" required  lay-verify="required" placeholder="请输入菜品名" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">请选择类型</label>
			    <div class="layui-input-block">
			      <select name="m_type" lay-verify="required">
			        <option value=""></option>
			        <option value="精致小炒">精致小炒</option>
			        <option value="美味大餐">美味大餐</option>
			        <option value="招牌干锅">招牌干锅</option>
			        <option value="营养靓汤">营养靓汤</option>
			        <option value="精致酒水">精致酒水</option>
			      </select>
			    </div>
			  </div>
			   <div class="layui-form-item">
			    <label class="layui-form-label">价格</label>
			    <div class="layui-input-inline">
			      	<input name="m_price" lay-verify="required" placeholder="请输入价格" autocomplete="off" class="layui-input">
			    </div>
			    <div class="layui-form-mid layui-word-aux">精确到小数后两位</div>
			  </div>
			  <div class="layui-form-item">
			  	  <div style="margin-top:20px;width:150px;float:left">
			  	  	<button type="button" class="layui-btn" id="test1" style="background-color: #5FB878;margin-right: 10px;">
					  <i class="layui-icon">&#xe67c;</i>上传图片
				  	</button>
			  	  </div>
				  <div class="layui-upload-list" id="updateImg" style="float:left;overflow-y:auto;"></div>
			  </div>
			  <div class="layui-form-item" style="margin-top:50px"><center><button class="layui-btn" lay-submit lay-filter="sub">立即提交</button></center></div>
			</form>
			<script>
				//Demo
				layui.use('form', function(){
				  var form = layui.form;
				  
				  //监听提交
				  form.on('submit(sub)', function(data){
				    layer.msg(JSON.stringify(data.field));
				  });
				});
				
				layui.use('upload', function(){
				  var upload = layui.upload;
				   
				  //执行实例
				  var uploadInst = upload.render({
				    elem: '#test1' //绑定元素
				    ,url: '${pageContext.request.contextPath}/uploadPicture.action' //上传接口
				    ,done: function(res){
				    	$('#updateImg').html("");
					      $('#updateImg').append(
						'<a> <img  width="200" height="100" src="${pageContext.request.contextPath }/' +
						res.path +
						'" data-fileid="' +
						res.path +
						'" class="layui-upload-img" style="margin-bottom: 2px;"></a><input lay-verify="required" name="m_img" value="'+res.path+'" type="hidden">');
				    }
				    ,error: function(){
				      //请求异常回调
				    }
				  });
				 }); 
			</script>
    	</div>
    </div>
  </body>
</html>
