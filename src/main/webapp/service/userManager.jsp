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
  
  <body style="background-color: #2F4056">
  <jsp:include page="nav.jsp"></jsp:include>
 <div class="demoTable" style="margin-left: 5px; margin-top: 80px;">
    <div class="layui-inline">
        <input class="layui-input" name="keyWord" id="keyWord" autocomplete="off">
    </div>
    <span class="input-group-btn">
       <select name="keyType" id="key_type" class="layui-btn">
          <option value="e_id" selected="selected">员工ID</option>
          <option value="e_tel">联系电话</option>
       </select>
    </span>
    <button class="layui-btn" data-type="reload">搜索</button>
  	<div style="margin-left: 5px;">
    <table class="layui-hide" id="test" lay-filter="test" ></table>
 	</div>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-radius layui-btn-warm" lay-event="addUser">添加新员工</button>
  </div>
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
 
<script>
layui.use('table', function(){
	var table = layui.table;
	  
	table.render({
	elem: '#test'
	,url:'${pageContext.request.contextPath }/queryAllEmployee.action'
	,toolbar: '#toolbarDemo'
	,height:550
	,width:1350
	,title: '员工信息表'
	,id: 'testReload'
    ,page: true
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'e_id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
      ,{field:'e_name', title:'姓名', width:120, edit: 'text'}
      ,{field:'e_password', title:'密码', width:150, edit: 'text'}
      ,{field:'e_tel', title:'电话', width:150,edit: 'text'}
      ,{field:'e_address', title:'住址', width:270,edit: 'text'}
      ,{field:'e_regdate', title:'入职时间',width:130, sort: true}
      ,{field:'e_job', title:'职务',width:100,edit: 'text'}
      ,{field:'e_position', title:'状态',width:80,templet:'#e_position'}
      ,{field:'e_salary', title:'工资',width:80,edit: 'text',sort: true}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:130}
    ]],
    request: {
		pageName: 'curr',
		limitName: 'limit'
	},
	limit: 10,
	limits: [10, 20, 30, 40, 50]
  });
  
  var $ = layui.$, active = {
    reload: function(){
       var keyWord= $("#keyWord").val();
       var keyType= $("#key_type option:selected").val();
      //执行重载
      table.reload('testReload', {
      method: 'post'
      ,url:'${pageContext.request.contextPath }/queryEmployeeMsgByIDorTel.action'
        ,where: {
         // key: {
           keyWord:keyWord,
           keyType:keyType
          //}
        }
        ,page: {
          curr: 1 //重新从第 1 页开始
        }
      });
    }
  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });

  

  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'ByPosition':
    	  layer.open({
              //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
              type: 2,
              maxmin:true,
              shadeClose:true,
              title: "按状态查找员工信息",
              area: ['450px', '200px'],
              content:'${pageContext.request.contextPath }/service/queryEmployeeMsgBy.jsp',
              
          });
      break;
      case 'ByTel':
    	  layer.open({
              //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
              type: 2,
              maxmin:true,
              shadeClose:true,
              title: "按电话号码查找员工信息",
              area: ['450px', '200px'],
              content:'${pageContext.request.contextPath }/service/queryEmployeeMsgByTel.jsp'
          });
      break;
      case 'ById':
    	  layer.open({
              //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
              type: 2,
              maxmin:true,
              shadeClose:true,
              title: "按编号查找员工信息",
              area: ['450px', '200px'],
              content:'${pageContext.request.contextPath }/service/queryEmployeeMsgById.jsp'
          });
      break;
      case 'addUser':
    	  layer.open({
              //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
              type: 2,
              maxmin:true,
              shadeClose:true,
              title: "添加新员工",
              area: ['500px', '520px'],
              content:'${pageContext.request.contextPath }/service/addEmployeeMsg.jsp',
               end: function() {
        		//刷新页面, 
				location.reload();
	},
          });
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('确定真的删除？', function(index){
    	  $.ajax({
              url: "${pageContext.request.contextPath }/delEmployeeMsg.action",
              type: "POST",
              data:{"e_id":data.e_id},
              dataType: "json",                
                 success: function(data){ 
                  if(data == 0){    
                      layer.msg(data.e_id);
                       layer.msg("删除失败", {icon: 5});                        
                  }else{ 
                      layer.msg(data.e_id);
                         //删除这一行
                      obj.del();
                         //关闭弹框
                      layer.close(index);
                      layer.msg("删除成功", {icon: 6});
                      layer.closeAll();
                    parent.location.reload();
                      Load(); //删除完需要加载数据
                      }
              },
              //error:function(){
               //   alert(data);
             // },
              
          });
        });
    }else if(obj.event === 'edit'){
    	   layer.open({
               //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
               type: 2,
               maxmin:true,
               shadeClose:true,
               title: "修改员工信息",
               area: ['450px', '550px'],
               content:'${pageContext.request.contextPath }/queryEmployeeById.action?e_id='+data.e_id,
               end: function() {
        		//刷新页面, 
				location.reload();
	},
           });
           //动态向表传递赋值可以参看文章进行修改界面的更新前数据的显示，当然也是异步请求的要数据的修改数据的获取
           //setFormValue(obj,data);
        }
  });
});

</script>


<script type="text/html" id="e_position">
		
		     {{# if( d.e_position == '0'){ }} 
				在职{{# } }} 
			 {{# if( d.e_position == '1'){ }} 
				离职 {{# } }}
		</script>
<script type="text/javascript">
			//对Date的扩展，将 Date 转化为指定格式的String   
			//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
			//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
			//例子：   
			//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
			//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
			Date.prototype.Format = function(fmt)   
			{ //author: meizz   
			var o = {   
			 "M+" : this.getMonth()+1,                 //月份   
			 "d+" : this.getDate(),                    //日   
			 "h+" : this.getHours(),                   //小时   
			 "m+" : this.getMinutes(),                 //分   
			 "s+" : this.getSeconds(),                 //秒   
			 "q+" : Math.floor((this.getMonth()+3)/3), //季度   
			 "S"  : this.getMilliseconds()             //毫秒   
			};   
			if(/(y+)/.test(fmt))   
			 fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
			for(var k in o)   
			 if(new RegExp("("+ k +")").test(fmt))   
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
			return fmt;
			}   
		</script>
		<script id="e_regdate" type="text/html">
    		{{#   
    		var date = new Date();
    		date.setTime(d.e_regdate);
   	 		return date.Format("yyyy-MM-dd"); 
    		}} 
    </script>
  </body>
</html>
