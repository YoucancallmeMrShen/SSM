<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 绪志
  Date: 2019/3/11
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <form class="layui-form" action="" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label"> </label>
                        <div class="layui-input-inline">
                            <select id="searchType" name="searchType" lay-verify="" lay-filter="searchType">
                                <option value="all">全部</option>
                                <option value="name" >姓名</option>
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
                <table class="layui-table"  id="addStudentTable" lay-filter="addStudentTable">

                </table>
            </div>

        </div>
    </div>
    <jsp:include page="${crx}/pages/foot.jsp" ></jsp:include>
</div>
<script src="${ctx}/static/plugins/layui/layui.all.js" charset="UTF-8"></script>
<script src="${ctx}/static/custom/js/main.js"></script>
<script charset="UTF-8">
    //JavaScript代码区域
    layui.use(['element','jquery','form','table'], function(){
        var element = layui.element;
        var $ = layui.jquery;
        var form = layui.form;
        var table = layui.table;
        $(function () {
            $("#l1").addClass("layui-nav-itemed");
            $("#l11").addClass("layui-this");
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
            var searchType = $("#searchType").val();
            var searchKeyword = $("#searchKeyword").val();
            <%--$.ajax({--%>
                <%--url:"${ctx}/sign/"+searchType+"/"+searchKeyword,--%>
                <%----%>
            <%--})--%>

        })

        table.render({
            elem:'#addStudentTable',
            url:'${ctx}/sign/getStudentBase',
            method:'get',
            where:{type:'all',keywords:''},
            cols:[[
                {field:"studentName",title:"姓名", rowspan:2},
                {field:"studentNameId",title:"身份证号", rowspan:2},
                {field:"studentPhone",title:"联系电话", rowspan:2},
                {field:"studentReference",title:"推荐人", rowspan:2},
                {field:"studentType",title:"报名类型", rowspan:2},
                {field:"studentSignDate",title:"报名期号", rowspan:2},
                {field:"studentZip",title:"邮编", rowspan:2},
                {algin:"center",title:"地址",colspan:4}],
                [
                    {field:"studentAddressProvince",title:"省"},
                    {field:"studentAddressCity",title:"市"},
                    {field:"studentAddressArea",title:"县(区)"},
                    {field:"studentAddressSupp",title:"街道(乡镇)"}
                ]
            ],
            page:true,
            defaultToolbar: ['filter', 'print', 'exports'],
            response:{
                statusCode:'200'
            },
            parseData:function (res) {
                return {
                    "code": res.status,
                    "msg":res.msg,
                    "count":res.count,
                    "data":res.data.item
                }
            }
        })

    });
</script>
</body>
</html>