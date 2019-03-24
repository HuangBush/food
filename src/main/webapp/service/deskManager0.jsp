<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'deskManager0.jsp' starting page</title>
    
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
   <div  style="width:379.8px;height:425px;">
   	<!-- 未开台桌台详单 -->
     	<div  style="margin:15px 25px" >
   			<div style="margin:20 auto"><center><h2>桌台：${desk.d_name}</h2></center></div>
   			<div>-----------------------------------------------------------------------------</div>
   			<div>-----------------------------------------------------------------------------</div>
   			<div>-----------------------------------------------------------------------------</div>
   			<div>-----------------------------------------------------------------------------</div>
   			<div id="desk">
   				<div style="margin-top:40px;margin-bottom:40px;">
   				<div id="buy" class="layui-btn layui-btn-lg layui-btn-radius layui-btn-warm">销台</div>
   				<div id="ma" class="layui-btn layui-btn-lg layui-btn-radius "style="float:right;">印码</div>
   			</div>
   			<div style="margin-bottom:60px;">
   				<div id="delete" class="layui-btn layui-btn-lg layui-btn-radius layui-btn-danger">删除</div>
   				<div id="add" class="layui-btn layui-btn-lg layui-btn-radius "style="float:right;background-image: url(/food/img/black.jpg);background-size:cover">新增</div>
   			
   			</div>
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
		
		//删除桌子
		$('#delete').click(function(){
		var name='${desk.d_name}';
              $.ajax({
                url:"${pageContext.request.contextPath }/deleteDesk.action?name="+name,
                type:"post",
                processData:false,
                contentType:false,
                success:function(){
                },
                error:function(){
                }
            });        
		alert("删除成功！");
		parent.layer.closeAll();//关闭弹窗
		});
		
		//添加桌子
		$('#add').click(function(){
           layer.open({
	               //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
	               type: 2,
	               shadeClose:true,
	               area: ['412px', '490px'],
	               offset: '0px',
	               move: false,
	               title: "添加桌台",
	               content:'${pageContext.request.contextPath }/service/addDesk.jsp',
	               end: function() {
       				//刷新页面, 
       				parent.layer.closeAll();//关闭弹窗
					location.reload();
					}
	           });
         });
         
         //桌面销台
         $('#buy').click(function(){
			var did = '${desk.d_id}';
              $.ajax({
                url:"${pageContext.request.contextPath }/updateDeskPositionByName.action?d_id="+did,
                type:"post",
               // data:os_id, 
                processData:false,
                contentType:false,
                success:function(){
                },
                error:function(){
                }
            });        
		alert("销台成功！");
		parent.layer.closeAll();//关闭弹窗
		});
		
		//打印二维码
		$('#ma').click(function(){
		var d_id = '${desk.d_id}';
              $.ajax({
                url:"${pageContext.request.contextPath }/createQRcode.action?d_id="+d_id,
                type:"post",
                processData:false,
                contentType:false,
                success:function(res){
                	alert("-------------------"+res);
                	$('#desk').html("");
                	$('#desk').append('<center><img  src="${pageContext.request.contextPath }/'+res+'"width="300px",height="300px;"></center>');
                },
                error:function(res){
                	alert("++++++++++++++++++++"+res);
                	$('#desk').html("");
                	$('#desk').append('<img  src="${pageContext.request.contextPath }/'+res+'">');
                }
            });        
		});
		
		
   	</script>
  </body>
</html>
