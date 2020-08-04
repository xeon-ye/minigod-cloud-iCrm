<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>出金申请列表查询</title>
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
              action="${webRoot}/clientFundWithdraw/list">
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
                <label class="layui-form-label">小神号:</label>
                <div class="layui-input-block">
                    <input type="text" name="userId" value="${params.userId}" placeholder="请输入小神号"
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
                <label class="layui-form-label">证券手机号:</label>
                <div class="layui-input-block">
                    <input type="text" name="phoneNumber" value="${params.phoneNumber}"
                           placeholder="请输入证券手机号码"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">渠道号:</label>
                <div class="layui-input-block">
                    <input type="text" name="sourceChannelId" value="${params.sourceChannelId}"
                           placeholder="请输入渠道号"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">提取方式:</label>
                <div class="layui-input-block">
                    <tag:select id="withdrawType" name="withdrawType" nameKey="FUND_BANK_TYPE"
                                isAddDefaltOption="true" initSelectedKey="${params.withdrawType}"
                                clazz="form-control"></tag:select>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">币种:</label>
                <div class="layui-input-block">
                    <tag:select id="moneyType" name="moneyType" nameKey="SEC_MONEY_TYPE_TRD"
                                isAddDefaltOption="true" initSelectedKey="${params.moneyType}"
                                clazz="form-control" initDidableKey="0,w"></tag:select>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">提取金额:</label>
                <div class="layui-input-block">
                    <tag:select id="fundWithdrawBalance" name="fundWithdrawBalance" nameKey="FUND_WITHDRAW_BALANCE"
                                isAddDefaltOption="true" initSelectedKey="${params.fundWithdrawBalance}"
                                clazz="form-control"></tag:select>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">英文名:</label>
                <div class="layui-input-block">
                    <input type="text" name="clientNameSpell" value="${params.clientNameSpell}"
                           placeholder="请输入英文名"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">银行帐号:</label>
                <div class="layui-input-block">
                    <input type="text" name="bankNo" value="${params.bankNo}"
                           placeholder="请输入银行帐号"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">状态:</label>
                <div class="layui-input-block">
                    <tag:select id="applicationStatus" name="applicationStatus"
                                nameKey="FUND_WITHDRAW_STATUS"
                                isAddDefaltOption="true" initSelectedKey="${params.applicationStatus}"
                                clazz="form-control" initDidableKey="7"></tag:select>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">恒生处理状态:</label>
                <div class="layui-input-block">
                    <tag:select id="hsDealStatus" name="hsDealStatus"
                                nameKey="FUND_WITHDRAW_HS_DEAL_STATUS"
                                isAddDefaltOption="true" initSelectedKey="${params.hsDealStatus}"
                                clazz="form-control" initDidableKey="0"></tag:select>
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
                <label class="layui-form-label">银行名称:</label>
                <div class="layui-input-block">
                    <input type="text" name="bankName" value="${params.bankName}"
                           placeholder="请输入银行名称"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">客户姓名:</label>
                <div class="layui-input-block">
                    <input type="text" name="clientName" value="${params.clientName}"
                           placeholder="请输入客户姓名"
                           class="form-control">
                </div>

            </div>
            <div class="layui-form-item" style="padding: 10px 50px;">
                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                </button>
                <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                        class="layui-icon">&#x1002;</i>重
                    置
                </button>
                <shiro:hasPermission name="clientFundWithdraw:expList">
                    <button class="layui-btn layui-btn-danger" type="button" id="export"
                            onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                    </button>
                </shiro:hasPermission>
                <shiro:hasPermission name="clientFundWithdraw:printDetail">
                    <button class="layui-btn layui-btn-danger" type="button" id="print"
                            onclick="printDetail()"><i class="layui-icon">&#xe601;</i>打印详情
                    </button>
                </shiro:hasPermission>
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
                    <%--<th>小神号</th>--%>
                    <th>客户帐号</th>
                    <%--<th>资金帐号</th>--%>
                    <th>客户姓名</th>
                    <th>英文名</th>
                    <th>性别</th>
                    <th>证券手机号码</th>
                    <th>币种</th>
                    <th>提取金额</th>
                    <%--<th>提取方式</th>--%>
                    <th>银行名称</th>
                    <th>渠道</th>
                    <th>状态</th>
                    <th>恒生处理状态</th>
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
                            <%--<td>${info.userId}</td>--%>
                        <td>${info.clientId} </td>
                            <%--<td>${info.fundAccount}</td>--%>
                        <td>${info.clientName}</td>
                        <td>${info.clientNameSpell}</td>
                        <td>
                                ${fns:getCodeName("COMMON_SEX", info.sex)}
                        </td>
                        <td>${info.phoneNumber}</td>
                        <td>
                                ${fns:getCodeName("SEC_MONEY_TYPE_TRD", info.moneyType)}
                        </td>
                        <td><fmt:formatNumber value="${info.occurBalance}" pattern="#,##0.00"/></td>
                            <%--<td>--%>
                            <%--${fns:getCodeName("FUND_BANK_TYPE", info.withdrawType)}--%>
                            <%--</td>--%>
                        <td>${info.bankName}</td>
                        <td>${info.sourceChannelId}</td>
                        <td>
                                ${fns:getCodeName("FUND_WITHDRAW_STATUS", info.applicationStatus)}
                        </td>
                        <td>
                                ${fns:getCodeName("FUND_WITHDRAW_HS_DEAL_STATUS", info.hsDealStatus)}
                        </td>
                        <td>
                            <button class="layui-btn layui-btn-mini" type="button"
                                    onclick="viewTab('clientFundWithdrawApplication','${info.applicationId}','${info.instanceId}','','${info.defid}','','${info.assignDrafter}',0);">
                                <i class="layui-icon">&#xe60a;</i>查看
                            </button>
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

<script>

    layui.laydate.render({
        elem: '#beginTime', // 指定元素
        type: 'datetime'
    });
    layui.laydate.render({
        elem: '#endTime', // 指定元素
        type: 'datetime'
    });

    // 全选按钮事件
    $(function () {
        $("#checkAll").click(function () {
            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
        });
    });

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled", "true").addClass('layui-btn-disabled');
        setTimeout(function () {
            $("#export").attr("disabled", false).removeClass("layui-btn-disabled");
        }, 6000);
        var obj = $('#search-from').serialize();
//        layer.alert(obj);
        window.location.href = '${webRoot}/clientFundWithdraw/expList?clientFundWithdrawApplyEntity=&' + obj;
    }

    // 导出excel
    function printDetail() {
        var ischeckAll = $('#checkAll').is(":checked");

        if (ischeckAll) {
            var obj = $('#search-from').serialize();
            confirm("您确定批量打印列表中的全部数据吗?", function () {
                var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
                $('#print').attr("disabled", "true").addClass('layui-btn-disabled');
                setTimeout(function () {
                    $("#print").attr("disabled", false).removeClass("layui-btn-disabled");
                }, 6000);
                window.location.href = '${webRoot}/clientFundWithdraw/printDetail?clientFundWithdrawApplyEntity=&' + obj;
            });
        } else {
            var applicationIds = '';
            var ids = document.getElementsByName("selectFlag");
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
            if (applicationIds == "") {
                alertMsg("没有勾选需要记录");
                return;
            }
            confirm("您确定批量打印所选数据吗?", function () {
                var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
                $('#print').attr("disabled", "true").addClass('layui-btn-disabled');
                setTimeout(function () {
                    $("#print").attr("disabled", false).removeClass("layui-btn-disabled");
                }, 6000);
                window.location.href = '${webRoot}/clientFundWithdraw/printDetail?applicationIds=' + applicationIds;
            });
        }
    }

    layui.form.render('select');

    function viewTab(actKey, busId, instanceId, taskId, defid, nodeType, dealId, flag) {

        var url = "${webRoot}/act/deal/flowInfoTab?actKey=" + actKey + "&busId=" + busId + "&instanceId=" + instanceId
            + "&taskId=" + taskId + "&defId=" + defid + "&nodeType=" + nodeType + "&dealId=" + dealId + "&flag=" + flag;
        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["查看详情", true],
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
    }
</script>


</html>