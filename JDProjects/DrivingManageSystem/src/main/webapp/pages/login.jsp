<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/3/7
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>XX驾校后台管理-登录</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${ctx}/static/custom/css/register.css" charset="UTF-8" >
</head>
<body>
<div id="body">
    <div id="head">
        <div id="headTitle">
            <a href="${ctx}/index.jsp" style="text-decoration: none;"><span>XX驾校后台管理系统-注册</span></a>
        </div>
    </div>
    <div id="content">
        <span style="color: red;font-size: x-large">${loginMessage}</span>
        <div id="contentForm">
            <form id="registerForm" action="${ctx}/login/user" method="post">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" name="username" minlength="6" maxlength="16" id="username" placeholder="用户名（不能含有非法字符）">
                </div>
                <div class="form-group">
                    <label for="password1">密码</label>
                    <input type="password" name="password" class="form-control" minlength="6" maxlength="16" id="password1" placeholder="密码">
                </div>
                <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="remberMe" value="rember"> 记住我
                        </label>
                        <button type="submit" class="btn btn-success">登录</button>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
<script src="${ctx}/static/plugins/jquery/jquery-3.3.1.js" ></script>
<script src="${ctx}/static/plugins/bootstrap/js/bootstrap.js" ></script>
<script>
    $(function () {

    })
</script>
</body>
</html>
