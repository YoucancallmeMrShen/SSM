<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/1/14
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript"  src="${ctx}/static/plugins/jquery/jquery-3.3.1.js"></script>
    <link type="text/css" href="${ctx}/static/customer/jsonstyle.css">
</head>
<body>
<button id="pojo">返回一个pojo</button>
<button id="map">返回一个map</button>
<button id="array">返回一个数组</button>
<button id="list">返回一个list</button>
<button id="listAndMap">返回一个list，为map元素</button>
<div>
<span id="span" style="color: aqua">你好啊</span>
</div>


<script>
    $(function () {
        //接收返回的pojo
        $('#pojo').click(function () {
            $.ajax({
                url:'${ctx}/json/m1',
                type:'post',
                success:function (data) {
                    alert(data.name);
                    alert(data.password);
                }
            })
        })
        //接收返回的map
        $('#map').click(function () {
            $.ajax({
                url:'${ctx}/json/m2',
                type:'post',
                success:function (data) {
                    alert(data.name);
                    alert(data.age);
                }
            })
        })
        //接收返回的数组
        $('#array').click(function () {
            $.ajax({
                url:'${ctx}/json/m3',
                type:'post',
                success:function (data) {
                    for(var i=0;i<data.length;i++){
                        alert(data[i].name);
                        alert(data[i].password);
                    }
                }
            })
        })
        //接收返回的数组
        $('#list').click(function () {
            $.ajax({
                url:'${ctx}/json/m4',
                type:'post',
                success:function (data) {
                    for(var i=0;i<data.length;i++){
                        alert(data[i].name);
                        alert(data[i].password);
                    }
                }
            })
        })
        //解析一个list的集合，为map元素
        $('#listAndMap').click(function () {
            $.ajax({
                url:'${ctx}/json/m5',
                type:'post',
                success:function (data) {
                    for(var i=0;i<data.length;i++){
                        alert(data[i].user1.name);
                        alert(data[i].user1.password);
                        alert(data[i].user2.name);
                        alert(data[i].user2.password);
                    }
                }
            })
        })
    })

</script>
</body>
</html>
