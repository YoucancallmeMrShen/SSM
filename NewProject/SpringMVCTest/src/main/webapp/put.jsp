<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/1/13
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctx}/user/put2" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="text" name="name">
    <input type="password" name="password">
    <input type="date" name="birth">
    <input type="submit" value="put测试">
</form>
${ctx}

</body>
</html>
