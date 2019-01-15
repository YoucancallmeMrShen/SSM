<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/1/15
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

文件上传成功：<br>
<c:forEach items="${fileNames}" var="obj">
    ${obj}
</c:forEach>
</body>
</html>
