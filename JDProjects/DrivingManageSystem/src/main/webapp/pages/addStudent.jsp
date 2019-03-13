<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/3/11
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>XX驾校管理系统-添加学员信息</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css" charset="UTF-8">
    <link rel="stylesheet" href="${ctx}/static/custom/css/main.css" >
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <jsp:include page="${crx}/pages/head.jsp" ></jsp:include>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;position: relative;z-index: 1000">
            <div style="border: 1px solid #dddddd; padding: 10px;margin-bottom: 5px">
                <form class="layui-form" action="${ctx}/sign/addStudentBase" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="studentName" required  lay-verify="required" placeholder="姓名" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">身份证号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="studentNameId" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">联系电话</label>
                        <div class="layui-input-inline">
                            <input type="text" name="studentPhone" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">省</label>
                        <div class="layui-input-inline">
                            <select id="addressProvince" name="studentAddressProvince" lay-verify="required" lay-filter="AddressProvince">
                                <option value="0" selected>-请选择-</option>
                                <c:forEach items="${addStudentProvince}" var="obj">
                                    <option value="${obj.code}" >${obj.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <label class="layui-form-label">市</label>
                        <div class="layui-input-inline">
                            <select id="addressCity" name="studentAddressCity" lay-verify="required" lay-filter="AddressCity">
                                <option value="0" selected>-请选择-</option>
                            </select>
                        </div>
                        <label class="layui-form-label">县</label>
                        <div class="layui-input-inline">
                            <select id="addressArea" name="studentAddressArea" lay-verify="required" lay-filter="AddressArea">
                                <option value="0" selected>-请选择-</option>
                            </select>
                        </div>
                        <label class="layui-form-label">街道地址</label>
                        <div class="layui-input-inline">
                            <input type="text" name="studentAddressSupp" required  lay-verify="required" placeholder="街道地址" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">推荐人</label>
                        <div class="layui-input-inline">
                            <input type="text" name="studentReference" required  lay-verify="required" placeholder="推荐人" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">报名类型</label>
                        <div class="layui-input-inline">
                            <select name="studentType" lay-verify="required" lay-filter="AddressArea">
                                <option value="0" selected>-请选择-</option>
                                <option value="A1" >A1</option>
                                <option value="A2" >A2</option>
                                <option value="B1" >B1</option>
                                <option value="B2" >B2</option>
                                <option value="C1" >C1</option>
                                <option value="C2" >C2</option>
                                <option value="D" >D</option>
                                <option value="E" >E</option>
                            </select>
                        </div>
                        <label class="layui-form-label">报名期号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="studentSignDate" required  lay-verify="required" placeholder="报名期号" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">邮编</label>
                        <div class="layui-input-inline">
                            <input type="text" name="studentZip" required  lay-verify="required" placeholder="邮编" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-input-inline">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
            <div style="border: 1px solid #dddddd; padding: 10px;margin-bottom: 5px;">
                <form class="layui-form" action="#" onsubmit="javascript:return false;" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label"> </label>
                        <div class="layui-input-inline">
                            <select id="searchType" name="searchType" lay-verify="" lay-filter="searchType">
                                <option value="name" selected>姓名</option>
                                <option value="nameId" >身份证号</option>
                                <option value="type" >报名类型</option>
                                <option value="signDate" >报名期号</option>
                            </select>
                        </div>
                        <div class="layui-input-inline">
                            <input type="text" id="searchKeyword" name="searchKeyword" required  lay-verify="required" placeholder="关键字" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-input-inline">
                            <button id="searchBtn" class="layui-btn" lay-submit lay-filter="formDemo">查找</button>
                        </div>
                    </div>
                </form>
                <table class="layui-table" id="addStudentTable" lay-filter="addStudentTable">
                    <thead>
                        <tr>
                            <th rowspan="2">姓名</th>
                            <th rowspan="2">身份证号</th>
                            <th rowspan="2">联系电话</th>
                            <th rowspan="2">推荐人</th>
                            <th rowspan="2">报名类型</th>
                            <th rowspan="2">报名期号</th>
                            <th rowspan="2">邮编</th>
                            <th colspan="4">地址</th>
                        </tr>
                        <tr>
                            <th>省</th>
                            <th>市</th>
                            <th>县</th>
                            <th>街道</th>
                        </tr>
                    </thead>
                    <tbody id="studentBody">
                        <tr>
                        </tr>
                    </tbody>
                </table>
                <div style="float: right">
                    <div style="float: left;padding: 5px 1px">
                        <span >共</span>
                            <span id="pageNums"></span>
                        <span>页</span>
                            <span id="rowSizes"></span>
                        <span>条</span>
                        <span>当前</span>
                            <span id="pageCount"></span>
                        <span>页</span>
                    </div>
                    <div style="float: left;margin-left: 7px">
                        <button class="layui-btn-primary layui-btn-sm" page="first"><li class="layui-icon-prev layui-icon"></li></button>&nbsp;&nbsp;
                        <button class="layui-btn-primary layui-btn-sm" page="prev"><li class="layui-icon-left layui-icon"></li></button>&nbsp;&nbsp;
                        <button class="layui-btn-primary layui-btn-sm" page="next"><li class="layui-icon-right layui-icon"></li></button>&nbsp;&nbsp;
                        <button class="layui-btn-primary layui-btn-sm" page="last"><li class="layui-icon-next layui-icon"></li></button>
                    </div>
                    <div style="float: left;margin-left: 7px;" >
                        <span>到第</span>
                        <select id="pageSelect" class="layui-select layui-select-group" style="height: 30px;">

                        </select>
                        <span>页</span>
                        <button class="layui-btn-primary layui-btn-sm" id="pageSkin" >跳转</button>
                    </div>
                </div>

                <div style="clear: both;display: block;"></div>
            </div>

        </div>
    </div>
    <jsp:include page="${crx}/pages/foot.jsp" ></jsp:include>
</div>
<script src="${ctx}/static/plugins/layui/layui.all.js" charset="UTF-8"></script>
<script src="${ctx}/static/custom/js/main.js"></script>
<script charset="UTF-8">
    //JavaScript代码区域
    layui.use(['element','jquery','form','table','laypage'], function(){
        var element = layui.element;
        var $ = layui.jquery;
        var form = layui.form;
        var table = layui.table;
        var laypage = layui.laypage;
        $(function () {
            $("#l1").addClass("layui-nav-itemed");
            $("#l11").addClass("layui-this");
            $.ajax({
                url:'${ctx}/sign/getStudentBase',
                data:{type:'all',keywords:'', pageNum:1 },
                success:function (data) {
                    var dataOne = data.list;
                    var length = dataOne.length;
                    $("#pageNums").text(data.pages);
                    $("#rowSizes").text(data.total);
                    $("#pageCount").text(1);
                    loadPage(length,dataOne);
                }
            })
        })
        form.on("select(AddressProvince)",function () {
            var provinceValue = $('#addressProvince').val();
            if(provinceValue == 0){
                var html = "<option value='0' >-请选择-</option>";
                $("#addressCity").html(html);
                $("#addressArea").html(html);
                form.render();
                return;
            }else{
                $.ajax({
                    url:"${ctx}/sign/getAddress/addressCity/"+provinceValue,
                    type:"get",
                    success:function (data) {
                        var html = "<option value='0' >-请选择-</option>";
                        var length = data.length;
                        for(var i = 0; i < length; i++){
                            html += "<option value='"+data[i].code+"' >"+data[i].name+"</option>"
                        }
                        $("#addressCity").html(html);
                        form.render();
                        return;
                    }
                })

            }
        })
        form.on("select(AddressCity)",function () {
            var CityValue = $('#addressCity').val();
            if(CityValue == 0){
                var html = "<option value='0' >-请选择-</option>";
                $("#addressArea").html(html);
                $("#addressArea").html(html);
                form.render();
                return;
            }else{
                $.ajax({
                    url:"${ctx}/sign/getAddress/addressArea/"+CityValue,
                    type:"get",
                    success:function (data) {
                        var html = "<option value='0' >-请选择-</option>";
                        var length = data.length;
                        for(var i = 0; i < length; i++){
                            html += "<option value='"+data[i].code+"' >"+data[i].name+"</option>"
                        }
                        $("#addressArea").html(html);
                        form.render();
                        return;
                    }
                })
            }
        })
        $("#searchBtn").click(function () {
            var type = $("#searchType").val();
            var keyword = $("#searchKeyword").val();
            $.ajax({
                url:'${ctx}/sign/getStudentBase',
                data:{type:type, keywords:keyword, pageNum:1},
                success:function (data) {
                    var dataOne = data.list;
                    var length = dataOne.length;
                    $("#pageNums").text(data.pages);
                    $("#rowSizes").text(data.total);
                    $("#pageCount").text(1);
                    loadPage(length, dataOne);
                }
            })
        })
        $('button[page]').click(function () {
            var pageNum = 1;
            var v = $(this).attr('page');
            switch(v){
                case 'first':
                    pageNum = 1;
                    break;
                case 'prev':
                    pageNum = currPage-1;
                    if(pageNum < 1){
                        pageNum = 1;
                    }
                    break;
                case 'next':
                    pageNum = currPage + 1;
                    if(pageNum > total){
                        pageNum = total;
                    }
                    break;
                case 'last':
                    pageNum = total;
                    break;
            }
        })
        function loadPage(length,dataOne) {
            var html= "";
            for(var i = 0; i < length; i++){
                html += " <tr>\n" +
                    " <td>"+dataOne[i].studentName+"</td>" +
                    " <td>"+dataOne[i].studentNameId+"</td>" +
                    " <td>"+dataOne[i].studentPhone+"</td>" +
                    " <td>"+dataOne[i].studentReference+"</td>" +
                    " <td>"+dataOne[i].studentType+"</td>" +
                    " <td>"+dataOne[i].studentSignDate+"</td>" +
                    " <td>"+dataOne[i].studentZip+"</td>" +
                    " <td>"+dataOne[i].studentAddressProvince+"</td>" +
                    " <td>"+dataOne[i].studentAddressCity+"</td>" +
                    " <td>"+dataOne[i].studentAddressArea+"</td>" +
                    " <td>"+dataOne[i].studentAddressSupp+"</td>" +
                    "</tr>";
            }
            $("#studentBody").html(html);
        }


    });
</script>
</body>
</html>