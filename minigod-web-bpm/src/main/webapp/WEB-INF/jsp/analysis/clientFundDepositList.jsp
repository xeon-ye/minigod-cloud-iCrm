<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>客户出入金查询</title>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <shiro:hasPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post"
                  action="${webRoot}/clientFundDeposit/getClientFundDepositList">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:100px">小神号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="userId" value="${params.userId}" placeholder="请输入小神号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">客户姓名:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="clientName" value="${params.clientName}"
                                           placeholder="请输入客户姓名"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">交易帐号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="clientId" value="${params.clientId}" placeholder="请输入交易帐号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">资金帐号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="fundAccount" value="${params.fundAccount}"
                                           placeholder="请输入资金帐号"
                                           class="form-control">
                                </div>
                            </td>

                            <td>
                                <label class="layui-form-label" style="width: 100px">存款类型:</label>
                                <div class="col-xs-8">
                                    <tag:select id="depositType" name="depositType" nameKey="SEC_DEPOSIT_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.depositType}"
                                                clazz="from-control"></tag:select>
                                </div>
                            </td>
                        </tr>
                        <tr>

                            <td>
                                <label class="layui-form-label" style="width: 100px">渠道号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="channelId" value="${params.channelId}"
                                           placeholder="请输入渠道号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">渠道名称:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="channelName" name="channelName" class="form-control"
                                           style="cursor:pointer;" onclick="menuTree();" readonly="readonly"
                                           value="${params.channelName}" placeholder="请选择渠道"/>
                                    <input hidden type="text" id="checkedChannelId" name="checkedChannelId"
                                           value="${params.checkedChannelId}"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">货币名称:</label>
                                <div class="col-xs-8">
                                    <tag:select id="moneyType" name="moneyType" nameKey="SEC_MONEY_TYPE_TRD"
                                                isAddDefaltOption="true" initSelectedKey="${params.moneyType}"
                                                clazz="form-control"></tag:select>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">开始日期:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="beginDate" name="beginDate" value="${params.beginDate}"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">结束日期:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="endDate" name="endDate" value="${params.endDate}"
                                           class="form-control">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;&nbsp;&nbsp;
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                </button>
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                                        class="layui-icon">&#x1002;</i>重
                                    置
                                </button>

                                <shiro:hasPermission name="clientFundDepListExpExcel:exp">
                                    <button class="layui-btn layui-btn-danger" type="button" id="export"
                                            onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                    </button>

                                </shiro:hasPermission>
                            </td>
                        </tr>

                    </table>

                </div>
            </form>
        </shiro:hasPermission>

        <shiro:lacksPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post"
                  action="${webRoot}/clientFundDeposit/getClientFundDepositList">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:100px">小神号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="userId" value="${params.userId}" placeholder="请输入小神号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">客户姓名:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="clientName" value="${params.clientName}"
                                           placeholder="请输入客户姓名"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">交易帐号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="clientId" value="${params.clientId}" placeholder="请输入交易帐号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">资金帐号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="fundAccount" value="${params.fundAccount}"
                                           placeholder="请输入资金帐号"
                                           class="form-control">
                                </div>
                            </td>

                            <td>
                                <label class="layui-form-label" style="width: 100px">存款类型:</label>
                                <div class="col-xs-8">
                                    <tag:select id="depositType" name="depositType" nameKey="SEC_DEPOSIT_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.depositType}"
                                                clazz="from-control"></tag:select>
                                </div>
                            </td>
                        </tr>
                        <tr>

                            <td>
                                <label class="layui-form-label" style="width: 100px">渠道号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="channelId" value="${params.channelId}"
                                           placeholder="请输入渠道号"
                                           class="form-control">
                                </div>
                            </td>
                                <%--<td>--%>
                                <%--<label class="layui-form-label" style="width: 100px">渠道名称:</label>--%>
                                <%--<div class="col-xs-8">--%>
                                <%--<input type="text" id="channelName" name="channelName" class="form-control"--%>
                                <%--style="cursor:pointer;" onclick="menuTree();" readonly="readonly"--%>
                                <%--value="${params.channelName}" placeholder="请选择渠道"/>--%>
                                <%--<input hidden type="text" id="checkedChannelId" name="checkedChannelId"--%>
                                <%--value="${params.checkedChannelId}"/>--%>
                                <%--</div>--%>
                                <%--</td>--%>
                            <td>
                                <label class="layui-form-label" style="width: 100px">货币名称:</label>
                                <div class="col-xs-8">
                                    <tag:select id="moneyType" name="moneyType" nameKey="SEC_MONEY_TYPE_TRD"
                                                isAddDefaltOption="true" initSelectedKey="${params.moneyType}"
                                                clazz="form-control"></tag:select>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">开始日期:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="beginDate" name="beginDate" value="${params.beginDate}"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">结束日期:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="endDate" name="endDate" value="${params.endDate}"
                                           class="form-control">
                                </div>
                            </td>
                            <td>&nbsp;&nbsp;&nbsp;
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                </button>
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                                        class="layui-icon">&#x1002;</i>重
                                    置
                                </button>

                                <shiro:hasPermission name="clientFundDepListExpExcel:exp">
                                    <button class="layui-btn layui-btn-danger" type="button" id="export"
                                            onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                    </button>

                                </shiro:hasPermission>
                            </td>
                        </tr>

                    </table>

                </div>
            </form>
        </shiro:lacksPermission>
    </div>
    <div class="row">
        <div class="col-xs-12" style="width:99%">
            <table id="table-list" class="layui-table">
                <thead>
                <tr width="99%">
                    <th>序号</th>
                    <th>小神号</th>
                    <th>客户姓名</th>
                    <th>交易帐号</th>
                    <th>资金帐号</th>
                    <%--<th>手机号码</th>--%>
                    <th>渠道</th>
                    <th>清算日期</th>
                    <th>存款类型</th>
                    <th>货币名称</th>
                    <th>资金发生数</th>
                    <th>是否首次出入金</th>
                    <%--<th>子账号出入金</th>--%>
                    <th>备注</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="clientFundDepositList" varStatus="i">
                    <tr name="customer_${clientFundDepositList.id }">
                        <td>${i.index+1 }</td>
                        <td>${clientFundDepositList.userId}</td>
                        <td>${clientFundDepositList.clientName}</td>
                        <td>${clientFundDepositList.clientId} </td>
                        <td>${clientFundDepositList.fundAccount}</td>
                        <%--<td>${clientFundDepositList.phoneNumber}</td>--%>
                        <td>${clientFundDepositList.channelId}</td>
                        <td>${clientFundDepositList.initDate}</td>
                        <td>${fns:getCodeName("SEC_DEPOSIT_TYPE",clientFundDepositList.depositType)}</td>
                        <td>${fns:getCodeName("SEC_MONEY_TYPE_TRD",clientFundDepositList.moneyType)}</td>
                        <td>${clientFundDepositList.occurBalance}</td>
                        <c:choose>
                            <c:when test="${clientFundDepositList.firstDepFlag < 1}">
                                <td>是</td>
                            </c:when>
                            <c:otherwise>
                                <td>否</td>
                            </c:otherwise>
                        </c:choose>
                            <%--<c:choose>--%>
                            <%--<c:when test="${clientFundDepositList.remark =='FUND DEPOSIT'}">--%>
                            <%--<td>是</td>--%>
                            <%--</c:when>--%>
                            <%--<c:otherwise>--%>
                            <%--<td>否</td>--%>
                            <%--</c:otherwise>--%>
                            <%--</c:choose>--%>
                        <td>${clientFundDepositList.remark}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
<!-- 选择渠道 -->
<div id="menuLayer" style="display: none;padding:10px;">
    <ul id="menuTree" class="ztree"></ul>
</div>
<script src="${webRoot}/js/channel/channel.js"></script>
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
        window.location.href = '${webRoot}/clientFundDeposit/clientFundDepListExpExcel?clientFundDepositEntity=&' + obj;
    }

    layui.form.render('select');
</script>

</html>