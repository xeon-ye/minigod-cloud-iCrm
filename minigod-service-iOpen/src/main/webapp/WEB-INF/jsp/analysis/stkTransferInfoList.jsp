<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>客户转托管查询</title>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <shiro:hasPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post"
                  action="${webRoot}/stockTransferInfo/getStkTransferInfoList">
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
                                <label class="layui-form-label" style="width: 100px">货币名称:</label>
                                <div class="col-xs-8">
                                    <tag:select id="moneyType" name="moneyType" nameKey="SEC_MONEY_TYPE_TRD"
                                                isAddDefaltOption="true" initSelectedKey="${params.moneyType}"
                                                clazz="form-control"/>
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
                                <label class="layui-form-label" style="width: 100px">证券类别:</label>
                                <div class="col-xs-8">
                                    <tag:select id="stockType" name="stockType" nameKey="SEC_STOCK_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.stockType}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">证券代码:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="stockCode" value="${params.stockCode}"
                                           placeholder="请输入证券代码"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">转仓类别:</label>
                                <div class="col-xs-8">
                                    <tag:select id="businessFlag" name="businessFlag" nameKey="SEC_BUSINESS_FLAG"
                                                isAddDefaltOption="true" initSelectedKey="${params.businessFlag}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
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

                                <shiro:hasPermission name="stkTransferInfoListExpExcel:exp">
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
                  action="${webRoot}/stockTransferInfo/getStkTransferInfoList">
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
                                <label class="layui-form-label" style="width: 100px">货币名称:</label>
                                <div class="col-xs-8">
                                    <tag:select id="moneyType" name="moneyType" nameKey="SEC_MONEY_TYPE_TRD"
                                                isAddDefaltOption="true" initSelectedKey="${params.moneyType}"
                                                clazz="form-control"/>
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
                                <%--<input type="text" id="channelName" name="channelName" class="form-control" style="cursor:pointer;" onclick="menuTree();" readonly="readonly" value="${params.channelName}" placeholder="请选择渠道"/>--%>
                                <%--<input hidden type="text" id="checkedChannelId" name="checkedChannelId" value="${params.checkedChannelId}"/>--%>
                                <%--</div>--%>
                                <%--</td>--%>
                            <td>
                                <label class="layui-form-label" style="width: 100px">证券类别:</label>
                                <div class="col-xs-8">
                                    <tag:select id="stockType" name="stockType" nameKey="SEC_STOCK_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.stockType}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">证券代码:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="stockCode" value="${params.stockCode}"
                                           placeholder="请输入证券代码"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">转仓类别:</label>
                                <div class="col-xs-8">
                                    <tag:select id="businessFlag" name="businessFlag" nameKey="SEC_BUSINESS_FLAG"
                                                isAddDefaltOption="true" initSelectedKey="${params.businessFlag}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">开始日期:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="beginDate" name="beginDate" value="${params.beginDate}"
                                           class="form-control">
                                </div>
                            </td>
                        </tr>
                        <tr>
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

                                <shiro:hasPermission name="stkTransferInfoListExpExcel:exp">
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
        <div class="col-xs-12" style="width:100%">
            <table id="table-list" class="layui-table">
                <thead>
                <tr width="99%">
                    <th>序号</th>
                    <th>小神号</th>
                    <th>客户姓名</th>
                    <th>交易帐号</th>
                    <th>资金帐号</th>
                    <th>渠道</th>
                    <th>交易日期</th>
                    <th>证券代码</th>
                    <th>证券名称</th>
                    <th>证券类别</th>
                    <th>转仓类别</th>
                    <th>货币名称</th>
                    <th>成交数量</th>
                    <th>成交金额</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="stockTransferInfoList" varStatus="i">
                    <tr name="customer_${stockTransferInfoList.id }">
                        <td>${i.index+1 }</td>
                        <td>${stockTransferInfoList.userId}</td>
                        <td>${stockTransferInfoList.clientName}</td>
                        <td>${stockTransferInfoList.clientId} </td>
                        <td>${stockTransferInfoList.fundAccount}</td>
                        <td>${stockTransferInfoList.channelId}</td>
                        <td>${stockTransferInfoList.tradeDate}</td>
                        <td>${stockTransferInfoList.stockCode}</td>
                        <td>${stockTransferInfoList.stockName}</td>
                        <td>
                                ${fns:getCodeName("SEC_STOCK_TYPE", stockTransferInfoList.stockType)}
                        </td>
                        <td>
                                ${fns:getCodeName("SEC_BUSINESS_FLAG", stockTransferInfoList.businessFlag)}
                        </td>
                        <td>
                                ${fns:getCodeName("SEC_MONEY_TYPE_TRD", stockTransferInfoList.moneyType)}
                        </td>
                        <td>${stockTransferInfoList.occurAmount}</td>
                        <td>${stockTransferInfoList.stockMktValue}</td>
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
        window.location.href = '${webRoot}/stockTransferInfo/stkTransferInfoListExpExcel?stockTransferInfoEntity=&' + obj;
    }

    layui.form.render('select');
</script>

</html>