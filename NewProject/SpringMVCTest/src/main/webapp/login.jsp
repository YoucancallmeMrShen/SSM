<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/1/13
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctx}/user3/session" method="post">
    <input type="text" name="name"><br>
    <input type="password" name="password"><br>
    <input type="text" name="birth"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
