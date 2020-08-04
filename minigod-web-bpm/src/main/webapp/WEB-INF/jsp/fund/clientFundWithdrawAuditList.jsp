<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>出金审核列表</title>
    <style>
        .layui-form-label {
            width: 120px;
            font-size: 13px;
        }

        .layui-form-label + .layui-input-block {
            margin-left: 135px;
            width: 160px;
            font-size: 13px;
        }

        .layui-btn {
            font-size: 13px;
        }

        .layui-btn-mini {
            font-size: 11px;
        }
    </style>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 10px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/clientFundWithdraw/checkAuditList">
            <input type="hidden" name="flag" value="${params.flag}"/>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">开始日期:</label>
                <div class="layui-input-block">
                    <input type="text" id="beginTime" name="beginTime" value="${params.beginTime}" placeholder="请输入开始日期"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">结束日期:</label>
                <div class="layui-input-block">
                    <input type="text" id="endTime" name="endTime" value="${params.endTime}" placeholder="请输入结束日期"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">客户帐号:</label>
                <div class="layui-input-block">
                    <input type="text" name="clientId" value="${params.clientId}"
                           placeholder="请输入客户帐号"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">资金帐号:</label>
                <div class="layui-input-block">
                    <input type="text" name="fundAccount" value="${params.fundAccount}"
                           placeholder="请输入资金帐号"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">预约号:</label>
                <div class="layui-input-block">
                    <input type="text" name="applicationId" value="${params.applicationId}" placeholder="请输入预约号"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">证券手机号:</label>
                <div class="layui-input-block">
                    <input type="text" name="phoneNumber" value="${params.phoneNumber}"
                           placeholder="请输入手机号码"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">小神号:</label>
                <div class="layui-input-block">
                    <input type="text" name="userId" value="${params.userId}" placeholder="请输入小神号"
                           class="form-control">
                </div>

            </div>
            <div class="layui-form-item" style="padding: 10px 50px;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                </button>
                <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                        class="layui-icon">&#x1002;</i>重置
                </button>
                <shiro:hasPermission name="clientFundWithdraw:expAuditList">
                    <button class="layui-btn layui-btn-danger" type="button" id="export"
                            onclick="expAuditList()"><i class="layui-icon">&#xe601;</i>导 出
                    </button>
                </shiro:hasPermission>
                <button class="layui-btn layui-btn-radius layui-btn-warm "
                        style="float: left;margin-right: 10px"
                        type="button" onclick="doPassTaskBatch();"><i
                        class="layui-icon ">&#x1005;</i>批量通过
                </button>
                <button class="layui-btn layui-btn-radius layui-btn-danger " style="float: right;margin-right: 10px"
                        type="button" onclick="deliverApplyTask();"><i
                        class="layui-icon ">&#xe60f;</i>释放办理
                </button>
                <button class="layui-btn layui-btn-radius layui-btn-normal " style="float: right;margin-right: 20px"
                        type="button" onclick="applyTaskHandleBatch();"><i
                        class="layui-icon">&#xe61f;</i>批量申领
                </button>
            </div>
    </div>
    </form>
</div>

<div class="row">
    <div class="col-xs-12">
        <table id="table-list" class="layui-table" lay-size="">
            <thead>
            <tr width="99%">
                <th hidden=true>id</th>
                <th style="width: 5px;height: 20px;"><input type="checkbox" id="checkAll"/></th>
                <th>预约号</th>
                <th>申请时间</th>
                <th>客户帐号</th>
                <th>资金帐号</th>
                <th>证券手机号</th>
                <th>小神号</th>
                <th>姓名</th>
                <th>英文名</th>
                <th>性别</th>
                <th>币种</th>
                <th>提取金额</th>
                <th>银行名称</th>
                <th>银行帐户</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.result}" var="info" varStatus="i">
                <tr name="${info.id }">
                    <td hidden=" true">${info.id}</td>
                    <td><input name="selectFlag" type="checkbox"
                               value="${info.applicationId}|<fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                    </td>
                    <td>${info.applicationId} </td>
                    <td><fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${info.clientId} </td>
                    <td>${info.fundAccount}</td>
                    <td>${info.phoneNumber} </td>
                    <td>${info.userId}</td>
                    <td>${info.clientName}</td>
                    <td>${info.clientNameSpell}</td>
                    <td>
                            ${fns:getCodeName("COMMON_SEX", info.sex)}
                    </td>
                    <td>
                            ${fns:getCodeName("SEC_MONEY_TYPE_TRD", info.moneyType)}
                    </td>
                    <td><fmt:formatNumber value="${info.occurBalance}" pattern="#,##0.00"/></td>
                    <td>${info.bankName}</td>
                    <td>${info.bankNo}</td>
                    <td>
                            ${fns:getCodeName("FUND_WITHDRAW_STATUS", info.applicationStatus)}
                    </td>
                    <td>
                        <div class=" btn-group ">
                            <c:if test="${info.assignDrafter == null or info.assignDrafter == '' }">
                                <button class="layui-btn layui-btn-small" type="button"
                                        onclick="applyTask('${info.applicationId}','${currentUserId}','
                                            <fmt:formatDate value="${info.createTime}"
                                                            pattern="yyyy-MM-dd HH:mm:ss"/>')">
                                    <i class="layui-icon">&#xe604;</i>申领
                                </button>
                            </c:if>
                            <c:if test="${info.assignDrafter == currentUserId}">
                                <button class="layui-btn layui-btn-small" type="button"
                                        onclick="doTaskTab('clientFundWithdrawApplication','${info.applicationId}','${info.instanceId}','','${info.defid}',''
                                                ,'${info.assignDrafter}','${info.currentNode}','${fns:getCodeName("FUND_BANK_TYPE",info.withdrawType)}'
                                                ,'${fns:getCodeName("FUND_WITHDRAW_STATUS",info.applicationStatus)}','${info.bankName}')">
                                    <i class="layui-icon">&#xe705;</i>办理
                                </button>
                            </c:if>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <sys:page page="${page}"></sys:page>
    </div>
</div>
</div>
</body>
<script src="${webRoot}/js/activiti/actSumbit.js"></script>
<script>

    // 全选按钮事件
    $(function () {
        $("#checkAll").click(function () {
            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
        });
    });

    layui.laydate.render({
        elem: '#beginTime', // 指定元素
        type: 'datetime'
    });
    layui.laydate.render({
        elem: '#endTime', // 指定元素
        type: 'datetime'
    });

    // 导出excel
    function expAuditList() {
        <%--var obj = $('#search-from').serialize();--%>
        <%--//        layer.alert(obj);--%>
        <%--window.location.href = '${webRoot}/clientFundWithdraw/expAuditList?clientFundWithdrawApplyEntity=&' + obj;--%>

        <%--setTimeout(refresh, 6000);--%>
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled", "true").addClass('layui-btn-disabled');
        setTimeout(function () {
            $("#export").attr("disabled", false).removeClass("layui-btn-disabled");
        }, 6000);
        var obj = $('#search-from').serialize();
//        layer.alert(obj);
        window.location.href = '${webRoot}/clientFundWithdraw/expDealList?clientFundWithdrawApplyEntity=&' + obj;

        setTimeout(refresh, 6000);
    }

    function refresh() {
        window.location.reload();
    }

    layui.form.render('select');

    // 申领任务
    function applyTask(applicationIds, currentUserId, createTime) {

        if (applicationIds == "") {
            alertMsg("预约号不能为空");
            return;
        }
        confirm("您确定申领此业务吗?", function () {
            var params = {
                'applicationIds': applicationIds,
                'toUserId': currentUserId,
                'actKey': 'clientFundWithdrawApplication'
            };
            var url = "${webRoot}/clientFundWithdraw/batchApplyTaskHandle";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result, function () {
                        // 刷新列表
                        window.location.reload();
                    })
                } else {
                    alertMsg(result.msg);
                    // 刷新列表
                    window.location.reload();
                }
            }, "json");
        });

        // 弃用，保留代码
        <%--if (createTime != '') {--%>

        <%--var beginTime = getBeginTime();--%>
        <%--var endTime = getEndTime();--%>
        <%--var applicationTime = getDate(createTime);--%>

        <%--// alert(applicationTime + "="+beginTime+"="+endTime);--%>
        <%--// alert(applicationTime);--%>

        <%--if (applicationTime < beginTime || applicationTime > endTime) {--%>
        <%--confirm('<span style=\'color: red;\'>申领记录中存在非当天处理数据，您确定申领此业务吗？</span>', function () {--%>

        <%--if (applicationIds == "") {--%>
        <%--alertMsg("预约号不能为空");--%>
        <%--return;--%>
        <%--}--%>

        <%--confirm("您确定申领此业务吗?", function () {--%>
        <%--var params = {--%>
        <%--'applicationIds': applicationIds,--%>
        <%--'toUserId': currentUserId,--%>
        <%--'actKey': 'clientFundWithdrawApplication'--%>
        <%--};--%>
        <%--var url = "${webRoot}/clientFundWithdraw/batchApplyTaskHandle";--%>
        <%--$.post(url, params, function callback(result) {--%>
        <%--if (result.code == '0') {--%>
        <%--toast(result, function () {--%>
        <%--// 刷新列表--%>
        <%--window.location.reload();--%>
        <%--})--%>
        <%--} else {--%>
        <%--alertMsg(result.msg);--%>
        <%--// 刷新列表--%>
        <%--window.location.reload();--%>
        <%--}--%>
        <%--}, "json");--%>
        <%--});--%>
        <%--});--%>
        <%--} else {--%>

        <%--if (applicationIds == "") {--%>
        <%--alertMsg("预约号不能为空");--%>
        <%--return;--%>
        <%--}--%>
        <%--confirm("您确定申领此业务吗?", function () {--%>
        <%--var params = {--%>
        <%--'applicationIds': applicationIds,--%>
        <%--'toUserId': currentUserId,--%>
        <%--'actKey': 'clientFundWithdrawApplication'--%>
        <%--};--%>
        <%--var url = "${webRoot}/clientFundWithdraw/batchApplyTaskHandle";--%>
        <%--$.post(url, params, function callback(result) {--%>
        <%--if (result.code == '0') {--%>
        <%--toast(result, function () {--%>
        <%--// 刷新列表--%>
        <%--window.location.reload();--%>
        <%--})--%>
        <%--} else {--%>
        <%--alertMsg(result.msg);--%>
        <%--// 刷新列表--%>
        <%--window.location.reload();--%>
        <%--}--%>
        <%--}, "json");--%>
        <%--});--%>
        <%--}--%>
        <%--} else {--%>
        <%--if (applicationIds == "") {--%>
        <%--alertMsg("预约号不能为空");--%>
        <%--return;--%>
        <%--}--%>
        <%--confirm("您确定申领此业务吗?", function () {--%>
        <%--var params = {--%>
        <%--'applicationIds': applicationIds,--%>
        <%--'toUserId': currentUserId,--%>
        <%--'actKey': 'clientFundWithdrawApplication'--%>
        <%--};--%>
        <%--var url = "${webRoot}/clientFundWithdraw/batchApplyTaskHandle";--%>
        <%--$.post(url, params, function callback(result) {--%>
        <%--if (result.code == '0') {--%>
        <%--toast(result, function () {--%>
        <%--// 刷新列表--%>
        <%--window.location.reload();--%>
        <%--})--%>
        <%--} else {--%>
        <%--alertMsg(result.msg);--%>
        <%--// 刷新列表--%>
        <%--window.location.reload();--%>
        <%--}--%>
        <%--}, "json");--%>
        <%--});--%>
        <%--}--%>
    }

    // 批量申领任务
    function applyTaskHandleBatch() {

        var beginTime = getBeginTime();
        var endTime = getEndTime();

        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;
        var flag = false;

        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {

                ++count;

                applicationIds += ids[i].value.split("|")[0] + ",";

                var applicationTime = getDate(ids[i].value.split("|")[1]);
                if (applicationTime < beginTime || applicationTime > endTime) {
                    flag = true;
                }
            }
        }

        if (applicationIds.length > 1) {
            applicationIds = applicationIds.substring(0, applicationIds.length - 1);
        }

        if (applicationIds == "") {
            alertMsg("没有勾选需要记录");
            return;
        }

        applyTask(applicationIds, '${currentUserId}', '');

        // 弃用，保留代码
        <%--if (flag) {--%>
        <%--confirm('<span style=\'color: red;\'>申领记录中存在非当天处理数据，您确定申领此业务吗？</span>', function () {--%>
        <%--applyTask(applicationIds, '${currentUserId}', '');--%>
        <%--});--%>
        <%--} else {--%>
        <%--applyTask(applicationIds, '${currentUserId}', '');--%>
        <%--}--%>
    }

    // 批量释放办理
    function deliverApplyTask() {
        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;
        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                ++count;
                if (ids[i].value.split("|")[1] != "") {
                    applicationIds += ids[i].value.split("|")[0] + ",";
                }

            }
        }
        if (applicationIds.length > 1) {
            applicationIds = applicationIds.substring(0, applicationIds.length - 1);
        }

        confirm("您确定释放此业务吗?", function () {
            var params = {
                'applicationIds': applicationIds
            };
            var url = "${webRoot}/clientFundWithdraw/deliverApplyTask";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result, function () {
                        // 刷新列表
                        window.location.reload();
                    })
                } else {
                    alertMsg(result.msg);
                    // 刷新列表
                    window.location.reload();
                }
            }, "json");
        });
    }

    // 办理任务
    function doTaskTab(actKey, busId, instanceId, taskId, defid, nodeType, dealId, taskName, bankType, applicationStatus, bankName) {

        var url = "${webRoot}/act/deal/flowInfoTab?flag=1&actKey=" + actKey + "&busId=" + busId + "&instanceId=" + instanceId
            + "&taskId=" + taskId + "&defId=" + defid + "&nodeType=" + nodeType + "&dealId=" + dealId + "&taskName=" + taskName;

        var title = "<a><strong>提取资金-" + applicationStatus + "-" + bankType + "-" + bankName + "</strong></a>";

        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: [title, true],
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
    }

    // 批量办理任务
    function doPassTaskBatch() {

        var beginTime = getBeginTime();
        var endTime = getEndTime();

        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;
        var flag = false;

        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {

                ++count;

                applicationIds += ids[i].value.split("|")[0] + ",";

                var applicationTime = getDate(ids[i].value.split("|")[1]);
                if (applicationTime < beginTime || applicationTime > endTime) {
                    flag = true;
                }
            }
        }

        if (applicationIds.length > 1) {
            applicationIds = applicationIds.substring(0, applicationIds.length - 1);
        }

        if (applicationIds == "") {
            alertMsg("没有勾选需要记录");
            return;
        }

        doPassTask(applicationIds, '${currentUserId}');

        // 弃用，保留代码
        <%--if (flag) {--%>
        <%--confirm('<span style=\'color: red;\'>申领记录中存在非当天处理数据，您确定申领此业务吗？</span>', function () {--%>
        <%--doPassTask(applicationIds, '${currentUserId}');--%>
        <%--});--%>
        <%--} else {--%>
        <%--doPassTask(applicationIds, '${currentUserId}');--%>
        <%--}--%>
    }

    // 办理任务
    function doPassTask(applicationIds, currentUserId) {
        confirm("您确定要批量处理吗?", function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            var params = {
                'applicationIds': applicationIds,
                'toUserId': currentUserId,
                'actKey': 'clientFundWithdrawApplication'
            };
            var url = "${webRoot}/clientFundWithdraw/doPassTaskBatch";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result, function () {
                        // 刷新列表
                        window.location.reload();
                    })
                } else {
                    layer.close(loading);
                    alertMsg(result.msg);
                    // 刷新列表
                    window.location.reload();
                }
            }, "json");
        });
    }

    function getDate(strDate) {

        var date = eval('new Date(' + strDate.replace(/\d+(?=-[^-]+$)/,
            function (a) {
                return parseInt(a, 10) - 1;
            }).match(/\d+/g) + ')');

        return date;
    }

    function getBeginTime() {

        var dateTime = new Date(new Date().getTime() - 24 * 60 * 60 * 1000);
        var year = dateTime.getFullYear();
        var month = dateTime.getMonth() + 1;
        var date = dateTime.getDate();
        var hour = dateTime.getHours();
        var minutes = dateTime.getMinutes();
        var second = dateTime.getSeconds();

        if (month < 10) {
            month = "0" + month;
        }
        if (date < 10) {
            date = "0" + date;
        }
        if (hour < 10) {
            hour = "0" + hour;
        }
        if (minutes < 10) {
            minutes = "0" + minutes;
        }
        if (second < 10) {
            second = "0" + second;
        }

        var dataStr = year + "-" + month + "-" + date + " 11:00:00";

        var date = eval('new Date(' + dataStr.replace(/\d+(?=-[^-]+$)/,
            function (a) {
                return parseInt(a, 10) - 1;
            }).match(/\d+/g) + ')');

        return date;
    }

    function getEndTime() {

        var dateTime = new Date(new Date().getTime());
        var year = dateTime.getFullYear();
        var month = dateTime.getMonth() + 1;
        var date = dateTime.getDate();
        var hour = dateTime.getHours();
        var minutes = dateTime.getMinutes();
        var second = dateTime.getSeconds();

        if (month < 10) {
            month = "0" + month;
        }
        if (date < 10) {
            date = "0" + date;
        }
        if (hour < 10) {
            hour = "0" + hour;
        }
        if (minutes < 10) {
            minutes = "0" + minutes;
        }
        if (second < 10) {
            second = "0" + second;
        }

        var dataStr = year + "-" + month + "-" + date + " 11:00:00";

        var date = eval('new Date(' + dataStr.replace(/\d+(?=-[^-]+$)/,
            function (a) {
                return parseInt(a, 10) - 1;
            }).match(/\d+/g) + ')');

        return date;
    }
</script>


</html>