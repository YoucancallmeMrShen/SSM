<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/3/7
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>XX驾校后台管理</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx}/static/custom/css/main.css" >
</head>
<body class="layui-layout-body">
    <div class="layui-header">
    <div class="layui-logo">XX驾校后台管理</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="">用户管理</a></li>
        <li class="layui-nav-item"><a href="">权限管理</a></li>
        <li class="layui-nav-item"><a href="">用户</a></li>
        <li class="layui-nav-item">
            <a href="javascript:;">其它系统</a>
            <dl class="layui-nav-child">
                <dd><a href="">邮件管理</a></dd>
                <dd><a href="">消息管理</a></dd>
                <dd><a href="">授权管理</a></dd>
            </dl>
        </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
        <c:if test="${loginStatus eq true}" >
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <%--http://t.cn/RCzsdCq--%>
                    <img src="${ctx}/static/custom/images/test.png" class="layui-nav-img">
                    <span>${sessionScope.loginUsername}</span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                    <dd><a href="${ctx}/login/clearSession">注销</a></dd>
                </dl>
            </li>
        </c:if>
        <c:if test="${loginStatus eq false}" >
            <li class="layui-nav-item"><a href="${ctx}/pages/login.jsp">登录</a></li>
            <li class="layui-nav-item"><a href="${ctx}/pages/register.jsp">注册</a></li>
        </c:if>

    </ul>
</div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree "  lay-filter="test">
                <li id="l1" class="layui-nav-item">
                    <a class="" href="javascript:;">报名管理</a>
                    <dl class="layui-nav-child">
                        <dd id="l11"><a href="${ctx}/sign/addStudentInit">添加学员</a></dd>
                        <dd id="l12"><a href="javascript:;">学员管理</a></dd>
                        <dd id="l13"><a href="javascript:;">学员转期</a></dd>
                        <dd id="l14"><a href="javascript:;">考号录入</a></dd>
                        <dd id="l15"><a href="javascript:;">证件录入</a></dd>
                        <dd id="l16"><a href="javascript:;">证件出证</a></dd>
                        <dd id="l17"><a href="javascript:;">证件领取</a></dd>
                        <dd id="l18"><a href="javascript:;">报名人数统计</a></dd>
                    </dl>
                </li>
                <li id="l2" class="layui-nav-item">
                    <a href="javascript:;">窗口缴费</a>
                    <dl class="layui-nav-child">
                        <dd id="l21"><a href="javascript:;">完成报名缴费</a></dd>
                        <dd id="l22"><a href="javascript:;">计时购买课程</a></dd>
                        <dd id="l23"><a href="javascript:;">考场适应费</a></dd>
                        <dd id="l24"><a href="javascript:;">补考费</a></dd>
                        <dd id="l25"><a href="javascript:;">其他缴费</a></dd>
                        <dd id="l26"><a href="javascript:;">个人收款记录</a></dd>
                    </dl>
                </li>
                <li id="l3" class="layui-nav-item">
                    <a href="javascript:;">教练管理</a>
                    <dl class="layui-nav-child">
                        <dd id="l31"><a href="javascript:;">教练课程设置</a></dd>
                        <dd id="l32"><a href="javascript:;">教练预约查询</a></dd>
                        <dd id="l33"><a href="javascript:;">教练管理</a></dd>
                        <dd id="l34"><a href="javascript:;">教练评论</a></dd>
                    </dl>
                </li>
                <li id="l4" class="layui-nav-item">
                    <a href="javascript:;">车辆管理</a>
                    <dl class="layui-nav-child">
                        <dd id="l41"><a href="javascript:;">车辆管理</a></dd>
                        <dd id="l42"><a href="javascript:;">告警提醒</a></dd>
                        <dd id="l43"><a href="javascript:;">租车管理</a></dd>
                    </dl>
                </li>
                <li id="l5" class="layui-nav-item">
                    <a href="javascript:;">计时约车</a>
                    <dl class="layui-nav-child">
                        <dd id="l51"><a href="javascript:;">学员约车</a></dd>
                        <dd id="l52"><a href="javascript:;">约车订单维护</a></dd>
                        <dd id="l53"><a href="javascript:;">约车订单查询</a></dd>
                        <dd id="l54"><a href="javascript:;">学员课时管理</a></dd>
                    </dl>
                </li>
                <li id="l6" class="layui-nav-item">
                    <a href="javascript:;">考试管理</a>
                    <dl class="layui-nav-child">
                        <dd id="l61"><a href="javascript:;">科目一成绩管理</a></dd>
                        <dd id="l62"><a href="javascript:;">科目一成绩管理</a></dd>
                        <dd id="l63"><a href="javascript:;">科目一成绩管理</a></dd>
                        <dd id="l64"><a href="javascript:;">科目一成绩管理</a></dd>
                        <dd id="l65"><a href="javascript:;">考试成绩查询</a></dd>
                        <dd id="l66"><a href="javascript:;">学员考试统计</a></dd>
                    </dl>
                </li>
                <li id="l7" class="layui-nav-item">
                    <a href="javascript:;">收款统计</a>
                    <dl class="layui-nav-child">
                        <dd id="l71"><a href="javascript:;">线下收款统计</a></dd>
                        <dd id="l72"><a href="javascript:;">其他收费统计</a></dd>
                    </dl>
                </li>
                <li id="l8" class="layui-nav-item">
                    <a href="javascript:;">退款管理</a>
                    <dl class="layui-nav-child">
                        <dd id="l81"><a href="javascript:;">报名退款</a></dd>
                        <dd id="l82"><a href="javascript:;">计时订单退款</a></dd>
                        <dd id="l83"><a href="javascript:;">补考费退款</a></dd>
                        <dd id="l84"><a href="javascript:;">考场适应费退款</a></dd>
                        <dd id="l85"><a href="javascript:;">其他退款</a></dd>
                    </dl>
                </li>
                <li id="l9" class="layui-nav-item">
                    <a href="javascript:;">新闻管理</a>
                    <dl class="layui-nav-child">
                        <dd id="l91"><a href="javascript:;">驾校简介</a></dd>
                        <dd id="l92"><a href="javascript:;">报名价格</a></dd>
                        <dd id="l93"><a href="javascript:;">报名须知</a></dd>
                        <dd id="l94"><a href="javascript:;">新闻资讯</a></dd>
                    </dl>
                </li>
                <li id="l0" class="layui-nav-item">
                    <a href="javascript:;">基础管理</a>
                    <dl class="layui-nav-child">
                        <dd id="l01"><a href="javascript:;">驾校基地</a></dd>
                        <dd id="l02"><a href="javascript:;">报名价格</a></dd>
                        <dd id="l03"><a href="javascript:;">系统时间设置</a></dd>
                        <dd id="l04"><a href="javascript:;">其他费用设置</a></dd>
                        <dd id="l05"><a href="javascript:;">系统参数设置</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <script src="${ctx}/static/plugins/layui/layui.all.js"></script>
    <script src="${ctx}/static/custom/js/main.js"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;
        });
    </script>
</body>
</html>
