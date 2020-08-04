<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>活动打新</title>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/clientIpo/ipoIncomeList">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:100px">小神号:</label>
                            <div class="col-xs-8">
                                <input type="text" name="userId" value="${model.userId}" placeholder="请输入小神号"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">开始日期:</label>
                            <div class="col-xs-8">
                                <input type="text" id="beginDate" name="beginDate" value="${model.beginDate}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">结束日期:</label>
                            <div class="col-xs-8">
                                <input type="text" id="endDate" name="endDate" value="${model.endDate}"
                                       class="form-control">
                            </div>
                        </td>

                        <td>&nbsp;&nbsp;&nbsp;
                            <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                            <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i class="layui-icon">&#x1002;</i>重 置</button>
                            <shiro:hasPermission name="clientIpo:ipoIncomeListExp">
                            <button class="layui-btn layui-btn-danger" type="button" id="export"
                                    onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                            </button>
                            </shiro:hasPermission>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-xs-12" style="width:99%">
            <table id="table-list" class="layui-table">
                <thead>
                <tr width="99%">
                    <th>序号</th>
                    <th>小神号</th>
                    <th>注册日期</th>
                    <th>开户日期</th>
                    <th>首次入金日期</th>
                    <th>首次入金金额</th>
                    <th>活动入金金额</th>
                    <th>活动认购笔数</th>
                    <th>邀请人数</th>
                    <th>邀请入金金额</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr>
                        <td>${i.index+1 }</td>
                        <td>${info.userId}</td>
                        <td>${info.registerDate}</td>
                        <td>${info.openAccountDate} </td>
                        <td>${info.firstIncomeDate}</td>
                        <td>${info.firstIncomeMoney}</td>
                        <td>${info.ipoIncomeMoney}</td>
                        <td>${info.ipoApplyCount}</td>
                        <td>${info.inviteCount}</td>
                        <td>${info.inviteIncomeMoney}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
</body>

<script>

    layui.laydate.render({
        elem: '#beginDate' //指定元素
    });
    layui.laydate.render({
        elem: '#endDate' //指定元素
    });

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/clientIpo/ipoIncomeListExp?info=&' + obj;
    }

    $("#refresh").click(function () {
        window.location.reload();
    })

    layui.form.render('select');
</script>
</html>