<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'dishManage.jsp' starting page</title>
    
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
  	<jsp:include page="nav.jsp"></jsp:include>
  	<div style="margin-left: 250px;">
    <table class="layui-hide" id="test" lay-filter="test" ></table>
 	</div>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    <button class="layui-btn layui-btn-radius layui-btn-warm" lay-event="addFish">添加新菜</button>
  </div>
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">类型</a>
  <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="no">售空</a>
  <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="yes">有货</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
              
          
<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
 
<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,url:'/test/table/demo1.json'
    ,toolbar: '#toolbarDemo'
	,height:500
	,width:900
    ,title: '菜品信息表'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'m_id', title:'编号', width:80, fixed: 'left', unresize: true, sort: true}
      ,{field:'m_name', title:'菜名', width:120, edit: 'text'}
      ,{field:'m_salary', title:'价格', width:150, edit: 'text', templet: function(res){
        return '<em>'+ res.email +'</em>'
      }}
      ,{field:'m_num', title:'销量', width:80, sort: true}
      ,{field:'m_type', title:'类型', width:100}
      ,{field:'m_condition', title:'状态',width:100}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
    ]]
    ,page: true
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'getCheckData':
        var data = checkStatus.data;
        layer.alert(JSON.stringify(data));
      break;
      case 'getCheckLength':
        var data = checkStatus.data;
        layer.msg('选中了：'+ data.length + ' 个');
      break;
      case 'isAll':
        layer.msg(checkStatus.isAll ? '全选': '未全选');
      break;
      case 'addFish':
    	  
      break;
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('确定真的删除？', function(index){
        obj.del();
        layer.close(index);
      });
    }else if(obj.event === 'no'){
        layer.confirm('没货了!', function(index){
            obj.del();
            layer.close(index);
          });
        }else if(obj.event === 'yes'){
            layer.confirm('有货了！', function(index){
                obj.del();
                layer.close(index);
              });
            }else if(obj.event === 'edit'){
      layer.prompt({
        formType: 2
        ,value: data.email
      }, function(value, index){
        obj.update({
          email: value
        });
        layer.close(index);
      });
    }
  });
});
</script>
  </body>
</html>
