<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/1/15
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${ctx}/static/plugins/jquery/jquery-3.3.1.js" ></script>
</head>
<body>
    <button id="user">向后台发送一个User，通过ajax进行发送</button>
    <button id="userList">向后台发送一组User，通过ajax发送</button>
<script>
    $(function () {
        $('#user').click(function () {
            var obj={
                "name":"我是你爸爸",
                "password":"你爸爸就是你爸爸"
            };
            $.ajax({
                url:'${ctx}/json2/add',
                type:'post',
                contentType:'application/json',
                data:JSON.stringify(obj),
                success:function (data) {
                    
                }
            })
        })
        $('#userList').click(function () {
            var obj={
                "name":"我是你爸爸",
                "password":"你爸爸就是你爸爸"
            };
            var obj2={
                "name":"我是你爷爷",
                "password":"你爷爷就是你爷爷"
            };
            var array=new Array();
            array.push(obj);
            array.push(obj2);
            $.ajax({
                url:'${ctx}/json2/addList',
                type:'post',
                contentType:'application/json',
                data:JSON.stringify(array),
                success:function (data) {
                    if(data.code==2000){
                        alert("测试成功");
                    }
                }
            })
        })
    })

</script>
</body>
</html>
