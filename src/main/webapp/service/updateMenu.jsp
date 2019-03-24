<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'updateMenu.jsp' starting page</title>
    
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
        <form id="fm" class="layui-form layui-from-pane"  style="margin-top:25px" >
            <div class="layui-form-item">
                <label class="layui-form-label">菜品编号</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="m_id"  required  lay-verify="required" autocomplete="off" class="layui-input" readonly="readonly" value="${menu.m_id}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜品名称</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" name="m_name"  required  lay-verify="required" autocomplete="off" class="layui-input" value="${menu.m_name}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜品类型</label>
                <div class="layui-input-block" style="width: 250px;" value="${menu.m_type}">
                    <select name="m_type" lay-filter="eqptType">
                    	<option selected = "selected" value="${menu.m_type}">${menu.m_type}</option>
	                    <option value="精致小炒">精致小炒</option>
				        <option value="美味大餐">美味大餐</option>
				        <option value="招牌干锅">招牌干锅</option>
				        <option value="营养靓汤">营养靓汤</option>
				        <option value="精致酒水">精致酒水</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜品价格</label>
                <div class="layui-input-inline">
                    <input style="width: 250px;" type="text" name="m_price"  required  lay-verify="required" autocomplete="off" class="layui-input" value="${menu.m_price}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜品状态</label>
                <div class="layui-input-block" style="width: 250px;" value="${menu.m_position}">
                    <select name="m_position" lay-filter="eqptType">
	                    <option value="0">在售</option>
				        <option value="1">售空</option>
				        <option value="2">推荐</option>
				        <option value="3">已下架</option>
                    </select>
                </div>
            </div>
			<div class="layui-form-item">
			  	  <div style="margin-top:20px;margin-left:35px;width:150px;float:left">
			  	  	<button type="button" class="layui-btn" id="test1" style="background-color: #5FB878;margin-right: 10px;">
					  <i class="layui-icon">&#xe67c;</i>更换图片
				  	</button>
			  	  </div>
			  	  <div id="pic" style="float:left;"><input  type="hidden" name="m_img"   class="layui-input" value="${menu.m_img}"></div>
				  <div class="layui-upload-list" id="updateImg" style="float:left;overflow-y:auto;">
				  	<img  width="200" height="100" src="${pageContext.request.contextPath }${menu.m_img}" class="layui-upload-img" style="margin-bottom: 2px;">
				  </div>
			  </div>
              <div class="layui-form-item" style="margin-top:40px">
                <center>
                	<div class="layui-input-block" id="btn">
                    	<button id="btn_update" class="layui-btn  layui-btn-submit ">确认修改</button>
                	</div>
                </center>
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
	
	layui.use('upload', function(){
		  var upload = layui.upload;
		   
		  //执行实例
		  var uploadInst = upload.render({
		    elem: '#test1' //绑定元素
		    ,url: '${pageContext.request.contextPath}/uploadPicture.action' //上传接口
		    ,done: function(res){
		    	$('#pic').html("");
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

<script type="text/javascript">
	$("#btn_update").click(function(){
            var form = new FormData(document.getElementById("fm"));
              $.ajax({
                url:"${pageContext.request.contextPath }/updateMenu.action",
                type:"post",
                data:form,
                processData:false,
                contentType:false,
                success:function(){
                },
                error:function(){
                }
            });        
		alert("修改成功");
		parent.layer.closeAll();//关闭弹窗
	});
</script>

  </body>
</html>
