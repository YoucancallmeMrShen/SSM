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
    <title>XX驾校后台管理-注册</title>
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
        <span style="color: red;font-size: x-large">${registerMessage}</span>
        <div id="contentForm">
            <form id="registerForm" action="${ctx}/register/user" method="post">
                <div class="form-group">
                    <label for="username">用户名</label><span class="rule" id="usernameRule" style="float: right;margin-right: 5px;"></span>
                    <input type="text" class="form-control" name="username" minlength="6" maxlength="16" id="username" placeholder="用户名（不能含有非法字符）">
                </div>
                <div class="form-group">
                    <label for="password1">密码</label><span class="rule" id="password1Rule" style="float: right;margin-right: 5px;"></span>
                    <input type="password" name="password" class="form-control" minlength="6" maxlength="16" id="password1" placeholder="密码">
                </div>
                <div class="form-group">
                    <label for="password2">确认密码</label><span class="rule" id="password2Rule" style="float: right;margin-right: 5px;"></span>
                    <input type="password" class="form-control" id="password2" minlength="6" maxlength="16" placeholder="确认密码">
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label><span class="rule" id="emailRule" style="float: right;margin-right: 5px;"></span>
                    <div class="input-group">
                        <input type="email" id="email" name="userEmail" class="form-control" name="email" placeholder="Email">
                        <span class="input-group-btn">
                            <a tabindex="0" class="btn btn-default" id="emailSend" style="height: 34px" role="button" data-container="body" data-toggle="popover" data-trigger="focus"
                               data-content="验证码已发送，请注意查收" ><i class="glyphicon glyphicon-send"></i></a>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="verCode">验证码</label><span class="rule" id="verCodeRule" style="float: right;margin-right: 5px;"></span>
                    <input type="text" class="form-control" minlength="6" maxlength="6" id="verCode" placeholder="请输入邮箱中的验证码">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">注册</button>
                </div>
            </form>
        </div>

    </div>
</div>
<script src="${ctx}/static/plugins/jquery/jquery-3.3.1.js" ></script>
<script src="${ctx}/static/plugins/bootstrap/js/bootstrap.js" ></script>
<script src="${ctx}/static/custom/js/register.js" charset="UTF-8" ></script>
<script>
    $(function () {
        var code = "`1`1`1";
        var timeCount = 60;
        var usernameC = false;
        var password1C = false;
        var password2C = false;
        var emailC = false;
        var codeVerC =false;
        $("#emailSend").click(function () {
            $('#emailSend').popover('toggle');
        })
        $("#username").blur(function () {
            var rule = /^[A-Za-z0-9]{4,40}$/;
            var username = $("#username").val();
            if(rule.test(username)){
                $("#usernameRule").text("✔");
                $("#usernameRule").css("color","green");
                usernameC = true;
            } else {
                $("#usernameRule").text("✘");
                $("#usernameRule").css("color","red");
            }
        })
        $("#password2").blur(function () {
            var password1 = $("#password1").val();
            var password2 = $("#password2").val();
            if(password2 == password1 && password1 != ""){
                $("#password1Rule").text("✔");
                $("#password1Rule").css("color","green");
                $("#password2Rule").text("✔");
                $("#password2Rule").css("color","green");
                password1C = true;
                password2C = true;
            } else {
                $("#password2Rule").text("两次密码一致 ✘");
                $("#password2Rule").css("color","red");
            }
        })
        $("#emailSend").click(function () {
            var rule = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            var email = $("#email").val();
            if(rule.test(email)){
                emailC = true;
                setTime();
                $("#emailRule").text("✔");
                $("#emailRule").css("color","green");
                $.ajax({
                    url:"${ctx}/mail/send",
                    type:"post",
                    data:"email="+email,
                    dataType:"text",
                    success:function (data) {
                        code = data;
                    }
                })
            }else{
                $("#emailRule").text("邮箱格式不正确 ✘");
                $("#emailRule").css("color","red");
            }
        })
        $("#verCode").blur(function () {
            var verCode = $("#verCode").val();
            if(verCode == code){
                codeVerC = true;
                $("#verCodeRule").text("✔");
                $("#verCodeRule").css("color","green");
            }else{
                $("#verCodeRule").text("验证码有误 ✘");
                $("#verCodeRule").css("color","red");
            }
        })

        var sendBtn = $("#emailSend");
        function setTime(){
            if(timeCount == 0){
                sendBtn.attr("disabled", false);
                sendBtn.html("<i class=\"glyphicon glyphicon-send\"></i>");
                sendBtn.removeClass("disabled");
                timeCount = 60;
                return;
            }else{
                sendBtn.addClass("disabled");
                sendBtn.attr("disabled", true);
                sendBtn.text( timeCount );
                timeCount--;
            }
            setTimeout(setTime ,1000);
        }
        $("#registerForm").submit(function () {
            if(usernameC && password1C && password2C && emailC && codeVerC){
                return true;
            }else{
                return false;
            }
        })
    })
</script>
</body>
</html>
