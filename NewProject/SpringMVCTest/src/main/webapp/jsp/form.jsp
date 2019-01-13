<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/1/12
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--请求路径一定要写“/”
        / 代表什么
        此时的上下文处于容器当中，即servlet容器
        action="/项目名称/URI"="/${ctx}/URI}"
    --%>
    <form action="${ctx}/test/m2" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="delete请求">

    </form>
</body>
</html>
