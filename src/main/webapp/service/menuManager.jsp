<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'deleteMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
`
  </head>
  
  <body style="background-color: #2F4056">
  	<jsp:include page="nav.jsp"></jsp:include>
  	<div style="width:50%;margin:50px auto">
    	<table class="layui-hide" id="test" lay-filter="test" ></table>
 	</div>
 	
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm layui-btn-warm">菜单列表</button>
  </div>
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="special">推荐</a>
  <a class="layui-icon layui-icon-delete" style="font-size: 20px; color: #FF784E;" lay-event="del"></a>
  <a class="layui-icon layui-icon-add-1" style="font-size: 20px; color: red;" lay-event="add"></a>
</script>
 
		<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  table.render({
		    elem: '#test'
		    ,url:'${pageContext.request.contextPath }/queryAllMenu.action'
		    ,toolbar: '#toolbarDemo'
			,height:540
			,width:830
		    ,title: '菜品信息表'
		    ,cols: [[
		      {field:'m_id', title:'菜品编号', width:120, fixed: 'left', unresize: true, sort: true}
		      ,{field:'m_name', title:'菜品名称', width:140}
		      ,{field:'m_type', title:'菜品类型', width:130, unresize: true, sort: true}
		      ,{field:'m_price', title:'菜品价格', width:130, unresize: true, sort: true}
		      ,{field:'m_position', title:'菜品状态', width:130,templet:'#m_position', unresize: true, sort: true}
		      ,{fixed: '', title:'操作', toolbar: '#barDemo', width:180}
		    ]]
		    ,page: true
		    ,request: {
				pageName: 'curr',
				limitName: 'limit'
			},
			limit: 10,
		  });
		
		  //监听行工具事件
		  table.on('tool(test)', function(obj){
		    var data = obj.data;
		    //console.log(obj)
		    if(obj.event === 'del'){
		      layer.confirm('确定真的删除？', function(index){
		      	$.post("${pageContext.request.contextPath}/deleteMenu.action?m_id="+data.m_id+"");
		      	obj.del();
        		layer.close(index);
        		window.location.href="${pageContext.request.contextPath}/service/menuManager.jsp";
		      });
		    }else if(obj.event === 'special'){
		    layer.confirm('确定设为推荐？', function(index){
		    	$.post("${pageContext.request.contextPath}/specialMenu.action?m_id="+data.m_id+"");
		    	obj.del();
        		layer.close(index);
			    window.location.href="${pageContext.request.contextPath}/service/menuManager.jsp";
        	});
		    }else if(obj.event === 'add'){
		    	layer.confirm('确定设为在售？', function(index){
		    	$.post("${pageContext.request.contextPath}/onsaleMenu.action?m_id="+data.m_id+"");
		    	obj.del();
        		layer.close(index);
			    window.location.href="${pageContext.request.contextPath}/service/menuManager.jsp";
        	});
		    }else if(obj.event === 'edit'){
		    	   layer.open({
		               //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
		               type: 2,
		               maxmin:true,
		               shadeClose:true,
		               title: "修改菜品信息",
		               area: ['450px', '550px'],
		               content:'${pageContext.request.contextPath }/queryMenuById.action?m_id='+data.m_id,
		               end: function() {
        				//刷新页面, 
						location.reload();
						}
		           });
		           //动态向表传递赋值可以参看文章进行修改界面的更新前数据的显示，当然也是异步请求的要数据的修改数据的获取
		           //setFormValue(obj,data);
		        }
		  });
		});
		</script>
		<script type="text/html" id="m_position">
		     {{# if( d.m_position == '0'){ }} 
				在售{{# } }} 
			 {{# if( d.m_position == '1'){ }} 
				售空 {{# } }}
             {{# if( d.m_position == '2'){ }} 
				推荐 {{# } }}
             {{# if( d.m_position == '3'){ }} 
				已下架 {{# } }}
		</script>
  </body>
</html>
