<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'ExpenseManage.jsp' starting page</title>
    
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
  
  <body style="background-color: #393D49">
  <jsp:include page="nav.jsp"></jsp:include>
  <div class="demoTable" style="margin-left: 630px; margin-top: 80px;">
    <div class="layui-inline">
    	<div class="layui-input-block">
        			 <input type="text" name="os_regtime" id="date1" autocomplete="off" class="layui-input" placeholder="点击选择支出时间">
      	</div>
    </div>
    <button class="layui-btn" data-type="reload" id="btn">搜索</button>
    </div>
   <div style="margin-left:330px;">
    <table class="layui-hide" id="test" lay-filter="test"></table>
 	</div>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-radius layui-btn-warm" lay-event="addExpense">添加支出</button>
  </div>
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs layui-icon" style="font-size: 15px;" lay-event="edit">&#xe642</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs layui-icon" style="font-size: 15px;" lay-event="del">&#xe640</a>
</script>
 
<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath }/queryAllExpense.action'
    ,toolbar: '#toolbarDemo'
	,height:550
	,width:710
	,id: 'testReload'
    ,title: '支出表'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'ex_id', title:'支出ID', width:120, fixed: 'left', unresize: true, sort: true}
      ,{field:'ex_name', title:'支出名', width:80}
      ,{field:'ex_price', title:'金额', width:80, sort: true}
      ,{field:'ex_other', title:'支出详情', width:160}
      ,{field:'ex_regtime', title:'支出日期', width:125, sort: true}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:100}
    ]]
    ,page: true
    ,request: {
		pageName: 'curr',
		limitName: 'limit'
	}
	,limit: 10
	,limits: [10, 20, 30, 40, 50]
  });
  
  var $ = layui.$, active = {
    reload: function(){
       var regtime= $("#date1").val();
      //执行重载
      table.reload('testReload', {
      method: 'post'
      ,url:'${pageContext.request.contextPath }/queryExpenseMsgByEXregtime.action'
        ,where: {
         // key: {
           regtime:regtime,
          //}
        }
        ,page: {
          curr: 1 //重新从第 1 页开始
        }
      });
    }
  };
  
  $('#btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'queryExpenseMsgByRegtime':
         layer.open({
              //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
              type: 2,
              maxmin:true,
              shadeClose:true,
              title: "按时间查找订单信息",
              area: ['450px', '330px'],
              content:'${pageContext.request.contextPath }/service/queryExpenseMsgByRegtime.jsp'
          });
      break;
      case 'addExpense':
    	   layer.open({
              //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
              type: 2,
              maxmin:true,
              shadeClose:true,
              title: "添加新支出",
              area: ['500px', '420px'],
              content:'${pageContext.request.contextPath }/service/addExpenseMsg.jsp',
              end: function() {
        		//刷新页面, 
				location.reload();
	},
          });
      break; 
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('确定真的删除？', function(index){
    	  $.ajax({
              url: "${pageContext.request.contextPath }/delExpenseMsg.action",
              type: "POST",
              data:{"ex_id":data.ex_id},
              dataType: "json",                
                 success: function(data){ 
                  if(data == 0){    
                      layer.msg(data.ex_id);
                       layer.msg("删除失败", {icon: 5});                        
                  }else{ 
                      layer.msg(data.ex_id);
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
               title: "修改支出信息",
               area: ['450px', '400px'],
               content:'${pageContext.request.contextPath }/queryExpenseById.action?ex_id='+data.ex_id,
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
		<script id="ex_regtime" type="text/html">
    		{{#
    		var date = new Date();
    		date.setTime(d.ex_regtime);
   	 		return date.Format("yyyy-MM-dd"); 
    		}} 
    </script>
    <script type="text/javascript">
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
    </script>
  </body>
</html>
