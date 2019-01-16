<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/1/16
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctx}/user/login" method="post">
    账号: <input type="text" name="name" ><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>

</body>
</html>
