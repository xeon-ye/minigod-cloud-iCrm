<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>办理任务</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">

        <c:choose>
            <c:when test="${taskDto.actKey =='customerAccountOpenApplication' || taskDto.actKey =='customerAccountOpenApplicationOffline' || taskDto.actKey =='customerAccountMarginOpenApplication'}">
                <ul class="layui-tab-title">
                    <li id="flowInfo" class="layui-this">流程信息</li>
                    <li id="operatorLogInfo">操作记录</li>
                    <li id="custInfo" onclick="busInfoClick('${flag}','${approveTaskPageUri}')">开户资料</li>
                </ul>
            </c:when>
            <c:when test="${taskDto.actKey =='clientFundWithdrawApplication'}">
                <ul class="layui-tab-title">
                    <li id="fundWithdrawInfo">出金详情</li>
                    <li id="flowInfo" class="layui-this">流程信息</li>
                </ul>
            </c:when>
            <c:when test="${taskDto.actKey =='fundWithdrawRefundApplication'}">
                <ul class="layui-tab-title">
                    <li id="fundWithdrawRefundInfo">出金详情</li>
                    <li id="flowInfo" class="layui-this">流程信息</li>
                </ul>
            </c:when>
            <c:when test="${taskDto.actKey =='fundDepositApplication'}">
                <ul class="layui-tab-title">
                    <li id="fundDepositInfo">入金详情</li>
                    <li id="flowInfo" class="layui-this">流程信息</li>
                </ul>
            </c:when>
            <c:when test="${taskDto.actKey =='professionalApplication'}">
                <ul class="layui-tab-title">
                    <c:if test="${flag ==0 || flag ==3}">
                        <li id="professionalInfo">记录详情</li>
                        <li id="flowInfo" class="layui-this">流程信息</li>
                    </c:if>
                    <c:if test="${flag ==1}">
                        <li id="flowInfo" class="layui-this">流程信息</li>
                        <li id="professionalInfo">审核详情</li>
                    </c:if>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="layui-tab-title">
                    <li class="layui-this" id="flowInfo">流程信息</li>
                    <li onclick="busInfoClick('${flag}','${approveTaskPageUri}')">任务审批</li>
                </ul>
            </c:otherwise>
        </c:choose>

        <div class="layui-tab-content" id="tabContent" style="margin-left: 10px">

        </div>
    </div>
</div>
</body>

<script>
    $(function () {

        $.ajaxPrefilter('script', function(options) {
            options.cache = true;
        });

        //初始化tab
        var actKey = '${taskDto.actKey}';
        if (actKey == 'clientFundWithdrawApplication') {
            $("#fundWithdrawInfo").click();
        } else if (actKey == 'fundWithdrawRefundApplication') {
            $("#fundWithdrawRefundInfo").click();
        } else if(actKey == 'fundDepositApplication'){
            $("#fundDepositInfo").click();
        }else if(actKey == 'professionalApplication'){
            $("#professionalInfo").click();
        }
        else{
            $("#flowInfo").click();
        }
    });

    /**
     * 业务信息
     */
    function busInfoClick(flag, approveTaskPageUri) {
        var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
        var url = "${webRoot}/" + approveTaskPageUri;
        var dealId = '${taskDto.dealId}'
        var params = {
            'busId': '${taskDto.busId}',
            'taskId': '${taskDto.taskId}',
            'instanceId': '${taskDto.instanceId}',
            'defId': '${taskDto.defId}',
            'flag': flag,
            'dealId': dealId,
            'dealName': '${taskDto.dealName}',
            'taskName': '${taskDto.taskName}'
        };

        $.ajaxPrefilter('script', function(options) {
            options.cache = true;
        });

        $.post(url, params, function (r) {
            $("#tabContent").html(r);
            layer.close(loading);
        });
    }

    /**
     * 流程信息
     */
    $("#flowInfo").on("click", function () {
        var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
        var actKey = '${taskDto.actKey}';
        var url;
        if (actKey == 'customerAccountOpenApplication' || actKey == 'customerAccountOpenApplicationOffline') {
            url = "${webRoot}/customer/tasLogImgAcct";
        } else if (actKey == 'customerAccountMarginOpenApplication'){
            url = "${webRoot}/customer/tasLogImgMarginAcct";
        }else if (actKey == 'clientFundWithdrawApplication') {
            url = "${webRoot}/clientFundWithdraw/taskLogInfo";
        } else if (actKey == 'fundWithdrawRefundApplication') {
            url = "${webRoot}/fundWithdrawRefund/taskLogInfo";
        } else if (actKey == 'fundDepositApplication') {
            url = "${webRoot}/clientFundDeposit/taskLogInfo";
        } else if (actKey == 'professionalApplication') {
            url = "${webRoot}/professionalInvestor/taskLogInfo";
        } else {
            url = "${webRoot}/act/deal/flowInfoHtml";
        }
        var params = {
            'busId': '${taskDto.busId}',
            'instanceId': '${taskDto.instanceId}',
            'actKey': '${taskDto.actKey}'
        }

        $.ajaxPrefilter('script', function(options) {
            options.cache = true;
        });

        $.post(url, params, function (r) {
            $("#tabContent").html(r);
            layer.close(loading);
        });
    });

    /**
     * 操作记录
     */
    $("#operatorLogInfo").on("click", function () {
        var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
        var url = "${webRoot}/customer/getOperatorLogInfo";
        var params = {
            'busId': '${taskDto.busId}',
            'instanceId': '${taskDto.instanceId}',
            'actKey': '${taskDto.actKey}'
        };

        $.ajaxPrefilter('script', function(options) {
            options.cache = true;
        });

        $.post(url, params, function (r) {
            $("#tabContent").html(r);
            layer.close(loading);
        });
    });

    $("#fundWithdrawInfo").on("click", function () {
        var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
        var url = "${webRoot}/clientFundWithdraw/approve";
        var dealId = '${taskDto.dealId}'
        var params = {
            'busId': '${taskDto.busId}',
            'taskId': '${taskDto.taskId}',
            'instanceId': '${taskDto.instanceId}',
            'defId': '${taskDto.defId}',
            'flag': '${flag}',
            'dealId': dealId,
            'dealName': '${taskDto.dealName}',
            'taskName': '${taskDto.taskName}'
        };

        $.ajaxPrefilter('script', function(options) {
            options.cache = true;
        });

        $.post(url, params, function (r) {
            layer.close(loading);
            $("#tabContent").html(r);
        });
    });

    $("#fundWithdrawRefundInfo").on("click", function () {
        var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
        var url = "${webRoot}/fundWithdrawRefund/approve";
        var dealId = '${taskDto.dealId}'
        var params = {
            'busId': '${taskDto.busId}',
            'taskId': '${taskDto.taskId}',
            'instanceId': '${taskDto.instanceId}',
            'defId': '${taskDto.defId}',
            'flag': '${flag}',
            'dealId': dealId,
            'dealName': '${taskDto.dealName}',
            'taskName': '${taskDto.taskName}'
        };

        $.ajaxPrefilter('script', function(options) {
            options.cache = true;
        });

        $.post(url, params, function (r) {
            layer.close(loading);
            $("#tabContent").html(r);
        });
    });

    $("#fundDepositInfo").on("click", function () {
        var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
        var url = "${webRoot}/clientFundDeposit/clientFundDepositApprove";
        var dealId = '${taskDto.dealId}'
        var params = {
            'busId': '${taskDto.busId}',
            'taskId': '${taskDto.taskId}',
            'instanceId': '${taskDto.instanceId}',
            'defId': '${taskDto.defId}',
            'flag': '${flag}',
            'dealId': dealId,
            'dealName': '${taskDto.dealName}',
            'taskName': '${taskDto.taskName}'
        };

        $.ajaxPrefilter('script', function(options) {
            options.cache = true;
        });

        $.post(url, params, function (r) {
            layer.close(loading);
            $("#tabContent").html(r);
        });
    });

    $("#professionalInfo").on("click", function () {
        var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
        var url = "${webRoot}/professionalInvestor/approve";
        var dealId = '${taskDto.dealId}';
        var params = {
            'busId': '${taskDto.busId}',
            'taskId': '${taskDto.taskId}',
            'instanceId': '${taskDto.instanceId}',
            'defId': '${taskDto.defId}',
            'flag': '${flag}',
            'dealId': dealId,
            'dealName': '${taskDto.dealName}',
            'taskName': '${taskDto.taskName}'
        };

        $.ajaxPrefilter('script', function(options) {
            options.cache = true;
        });

        $.post(url, params, function (r) {
            layer.close(loading);
            $("#tabContent").html(r);
        });
    });

</script>
</html>