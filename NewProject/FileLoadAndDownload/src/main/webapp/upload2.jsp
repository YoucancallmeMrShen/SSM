<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/1/15
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--要实现文件上传，必须要添加enctype="multipart/form-data" --%>
<form action="${ctx}/file/upload2" method="post" enctype="multipart/form-data">
    文件：<input type="file" name="upload"><br>
    文件：<input type="file" name="upload"><br>
    文件：<input type="file" name="upload"><br>
    文件：<input type="file" name="upload"><br>
    文件：<input type="file" name="upload"><br>
    文件：<input type="file" name="upload"><br>
    <input type="submit" value="文件上传">
</form>

</body>
</html>
