<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'addExpenseMsg.jsp' starting page</title>

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
<div class="layui-row">
    <div class="layui-col-md10">
        <form class="layui-form layui-from-pane" id="expense" style="margin-top:25px" >
            <div class="layui-form-item">
                <label class="layui-form-label">支出名</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" id="ex_name" name="ex_name"  placeholder="请输入支出名" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">支出日期</label>
                    <div class="layui-input-block">
                        <input style="width: 250px;" type="text" name="ex_regtime" id="date1" autocomplete="off" class="layui-input" placeholder="点击选择支出时间">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">支出详情</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" id="ex_other" name="ex_other"  placeholder="请输入支出详情"  lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">金额</label>
                <div class="layui-input-block">
                    <input style="width: 250px;" type="text" id="ex_price" name="ex_price"  placeholder="请输入支出金额"  lay-verify="required" autocomplete="off" class="layui-input">
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
    /*h这里出错  获取不到值
    * 已解决 使用普通的json传值，而不是使用formDate
    * */
    $("#btn-add").click(function(){
        //layer.closeAll('iframe');
        var form = new FormData(document.getElementById("expense"));
        var ex_name =$("#ex_name").val();
        var ex_regtime =$("#date1").val();
        var ex_other =$("#ex_other").val();
        var ex_price =$("#ex_price").val();
        alert(ex_name+"|"+ex_other+"|"+ex_price+"|"+ex_regtime);
//             var req = new XMLHttpRequest();
//             req.open("post", "${pageContext.request.contextPath }/updateEmployeeMsg.action", false);
//             req.send(form);
        $.ajax({
            url:"${pageContext.request.contextPath }/addExpenseMsg.action",
            type:"post",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify({ex_name:ex_name,ex_price:ex_price,ex_other:ex_other,ex_regtime:ex_regtime}),
            success:function(data){
                alert(data+"添加成功");
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
