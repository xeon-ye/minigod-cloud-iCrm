<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>交易查询</title>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <shiro:hasPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post"
                  action="${webRoot}/clientTradeFlowInfo/getClientTrdFlowInfoDetailList">
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
                                <label class="layui-form-label" style="width: 100px">证券代码:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="stockCode" value="${params.stockCode}"
                                           placeholder="请输入证券代码"
                                           class="form-control">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 100px">交易市场:</label>
                                <div class="col-xs-8">
                                    <tag:select id="exchangeType" name="exchangeType" nameKey="SEC_EXCHANGE_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.exchangeType}"
                                                clazz="form-control"/>
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
                            <td>
                                <label class="layui-form-label" style="width: 100px">证券类别:</label>
                                <div class="col-xs-8">
                                    <tag:select id="stockType" name="stockType" nameKey="SEC_STOCK_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.stockType}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">交易类型:</label>
                                <div class="col-xs-8">
                                    <tag:select id="tradeKind" name="tradeKind" nameKey="SEC_TRADE_KIND"
                                                isAddDefaltOption="true" initSelectedKey="${params.tradeKind}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">委托方式:</label>
                                <div class="col-xs-8">
                                    <tag:select id="entrustWay" name="entrustWay" nameKey="SEC_ENTRUST_WAY"
                                                isAddDefaltOption="true" initSelectedKey="${params.entrustWay}"
                                                clazz="form-control"/>
                                </div>
                            </td>

                        </tr>
                        <tr>
                                <%--<td>--%>
                                <%--<label class="layui-form-label" style="width:100px">开始日期:</label>--%>
                                <%--<div class="col-xs-8">--%>
                                <%--<div class="input-group date" id="datetimepicker1">--%>
                                <%--<input type="text" id="beginDate" name="beginDate" value="${params.beginDate}"--%>
                                <%--placeholder="请输入交易日期"--%>
                                <%--class="form-control">--%>
                                <%--<span class="input-group-addon"><span--%>
                                <%--class="glyphicon glyphicon-calendar"></span></span>--%>
                                <%--</div>--%>
                                <%--</div>--%>
                                <%--</td>--%>
                                <%--<td>--%>
                                <%--<label class="layui-form-label" style="width:100px">结束日期:</label>--%>
                                <%--<div class="col-xs-8">--%>
                                <%--<div class="input-group date" id="datetimepicker2">--%>
                                <%--<input type="text" id="endDate" name="endDate" value="${params.endDate}"--%>
                                <%--placeholder="请输入交易日期"--%>
                                <%--class="form-control">--%>
                                <%--<span class="input-group-addon"><span--%>
                                <%--class="glyphicon glyphicon-calendar"></span></span>--%>
                                <%--</div>--%>
                                <%--</div>--%>
                                <%--</td>--%>

                            <td>
                                <label class="layui-form-label" style="width: 100px">渠道号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="channelId" value="${params.channelId}"
                                           placeholder="多渠道号用,分隔"
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
                                <label class="layui-form-label" style="width: 100px">交易时段:</label>
                                <div class="col-xs-8">
                                    <tag:select id="sessionType" name="sessionType" nameKey="SEC_TRD_SESSION_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.sessionType}"
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
                            <td>
                                <label class="layui-form-label" style="width: 100px">结束日期:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="endDate" name="endDate" value="${params.endDate}"
                                           class="form-control">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 100px">佣金下限:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="minFeeCount" value="${params.minFeeCount}"
                                           placeholder="请输入佣金下限"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">佣金上限:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="maxFeeCount" value="${params.maxFeeCount}"
                                           placeholder="请输入佣金上限"
                                           class="form-control">
                                </div>
                            </td>
                            <td>&nbsp;&nbsp;&nbsp;
                                <button class="layui-btn layui-btn-radius" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜
                                    索
                                </button>
                                <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="refresh"><i
                                        class="layui-icon">&#x1002;</i>重
                                    置
                                </button>

                                <shiro:hasPermission name="trdDetailListExpExcel:exp">
                                    <button class="layui-btn layui-btn-danger layui-btn-radius" type="button"
                                            id="export"
                                            onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                    </button>
                                </shiro:hasPermission>
                            </td>
                            <td>
                                <shiro:hasPermission name="clientTradeFlowInfo:imp">
                                    <button class="layui-btn layui-btn-radius layui-btn-normal" type="button"
                                            id="export"
                                            onclick="impChannelReturn()"><i class="layui-icon">&#xe654;</i>导入返佣
                                    </button>
                                </shiro:hasPermission>
                            </td>
                            <td hidden>
                                <button class="layui-btn layui-btn-danger" type="button"
                                        onclick="showGraphic()"><i class="layui-icon">&#xe601;</i>图 示
                                </button>
                            </td>
                        </tr>
                    </table>

                </div>
            </form>
        </shiro:hasPermission>

        <shiro:lacksPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post"
                  action="${webRoot}/clientTradeFlowInfo/getClientTrdFlowInfoDetailList">
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
                                <label class="layui-form-label" style="width: 100px">证券代码:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="stockCode" value="${params.stockCode}"
                                           placeholder="请输入证券代码"
                                           class="form-control">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 100px">交易市场:</label>
                                <div class="col-xs-8">
                                    <tag:select id="exchangeType" name="exchangeType" nameKey="SEC_EXCHANGE_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.exchangeType}"
                                                clazz="form-control"/>
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
                            <td>
                                <label class="layui-form-label" style="width: 100px">证券类别:</label>
                                <div class="col-xs-8">
                                    <tag:select id="stockType" name="stockType" nameKey="SEC_STOCK_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.stockType}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">交易类型:</label>
                                <div class="col-xs-8">
                                    <tag:select id="tradeKind" name="tradeKind" nameKey="SEC_TRADE_KIND"
                                                isAddDefaltOption="true" initSelectedKey="${params.tradeKind}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">委托方式:</label>
                                <div class="col-xs-8">
                                    <tag:select id="entrustWay" name="entrustWay" nameKey="SEC_ENTRUST_WAY"
                                                isAddDefaltOption="true" initSelectedKey="${params.entrustWay}"
                                                clazz="form-control"/>
                                </div>
                            </td>

                        </tr>
                        <tr>
                                <%--<td>--%>
                                <%--<label class="layui-form-label" style="width:100px">开始日期:</label>--%>
                                <%--<div class="col-xs-8">--%>
                                <%--<div class="input-group date" id="datetimepicker1">--%>
                                <%--<input type="text" id="beginDate" name="beginDate" value="${params.beginDate}"--%>
                                <%--placeholder="请输入交易日期"--%>
                                <%--class="form-control">--%>
                                <%--<span class="input-group-addon"><span--%>
                                <%--class="glyphicon glyphicon-calendar"></span></span>--%>
                                <%--</div>--%>
                                <%--</div>--%>
                                <%--</td>--%>
                                <%--<td>--%>
                                <%--<label class="layui-form-label" style="width:100px">结束日期:</label>--%>
                                <%--<div class="col-xs-8">--%>
                                <%--<div class="input-group date" id="datetimepicker2">--%>
                                <%--<input type="text" id="endDate" name="endDate" value="${params.endDate}"--%>
                                <%--placeholder="请输入交易日期"--%>
                                <%--class="form-control">--%>
                                <%--<span class="input-group-addon"><span--%>
                                <%--class="glyphicon glyphicon-calendar"></span></span>--%>
                                <%--</div>--%>
                                <%--</div>--%>
                                <%--</td>--%>

                            <td>
                                <label class="layui-form-label" style="width: 100px">渠道号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="channelId" value="${params.channelId}"
                                           placeholder="多渠道号用,分隔"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">交易时段:</label>
                                <div class="col-xs-8">
                                    <tag:select id="sessionType" name="sessionType" nameKey="SEC_TRD_SESSION_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.sessionType}"
                                                clazz="form-control"/>
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
                            <td>
                                <label class="layui-form-label" style="width: 100px">佣金下限:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="minFeeCount" value="${params.minFeeCount}"
                                           placeholder="请输入佣金下限"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">佣金上限:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="maxFeeCount" value="${params.maxFeeCount}"
                                           placeholder="请输入佣金上限"
                                           class="form-control">
                                </div>
                            </td>
                            <td>&nbsp;&nbsp;&nbsp;
                                <button class="layui-btn layui-btn-radius" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜
                                    索
                                </button>
                                <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="refresh"><i
                                        class="layui-icon">&#x1002;</i>重
                                    置
                                </button>

                                <shiro:hasPermission name="trdDetailListExpExcel:exp">
                                    <button class="layui-btn layui-btn-danger layui-btn-radius" type="button"
                                            id="export"
                                            onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                    </button>

                                </shiro:hasPermission>

                                <shiro:hasPermission name="clientTradeFlowInfo:imp">
                                    <button class="layui-btn layui-btn-danger layui-btn-radius" type="button"
                                            id="export"
                                            onclick="impChannelReturn()"><i class="layui-icon">&#xe601;</i>导入返佣名单
                                    </button>

                                </shiro:hasPermission>
                            </td>
                            <td hidden>
                                <button class="layui-btn layui-btn-danger" type="button"
                                        onclick="showGraphic()"><i class="layui-icon">&#xe601;</i>图 示
                                </button>
                            </td>
                        </tr>

                    </table>

                </div>
            </form>
        </shiro:lacksPermission>
    </div>

    <table id="tableList" lay-filter="table_list" class="layui-table">
        <thead>
        <tr width="99%">
            <th lay-data="{field:'num',width:'60',fixed:'left'}">序号</th>
            <th lay-data="{field:'id',hide:true}" hidden="true">id</th>
            <th lay-data="{field:'userId',fixed:'left'}">小神号</th>
            <th lay-data="{field:'clientName'}">客户姓名</th>
            <th lay-data="{field:'clientId',minWidth:'120'}">交易帐号</th>
            <th lay-data="{field:'fundAccount',minWidth:'120'}">资金帐号</th>
            <th lay-data="{field:'channelId',width:'70'}">渠道</th>
            <th lay-data="{field:'tradeDate',minWidth:'110'}">交易日期</th>
            <th lay-data="{field:'exchangeType'}">证券市场</th>
            <th lay-data="{field:'stockCode'}">证券代码</th>
            <th lay-data="{field:'stockName',width:'150'}">证券名称</th>
            <th lay-data="{field:'stockType'}">证券类别</th>
            <th lay-data="{field:'tradeKind'}">交易类别</th>
            <th lay-data="{field:'entrustWay'}">委托方式</th>
            <th lay-data="{field:'moneyType'}">货币名称</th>
            <th lay-data="{field:'businessAmount'}">成交数量</th>
            <th lay-data="{field:'businessBalance',width:'120'}">成交金额</th>
            <th lay-data="{field:'businessPrice'}">成交价格</th>
            <th lay-data="{field:'occurBalance',width:'120'}">清算金额</th>
            <th lay-data="{field:'feeCount'}">佣金</th>
            <th lay-data="{field:'profitFeeCount'}">净佣金</th>
            <th lay-data="{field:'feeCountRatio'}">佣金比例(%)</th>
            <th lay-data="{field:'sequenceNo'}">交易流水号</th>
            <th lay-data="{field:'sessionType',minWidth:'120'}">交易时段</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${page.result!= null && fn:length(page.result) > 0}">
            <c:forEach items="${page.result}" var="clientTrdFlowInfoList" varStatus="i">
                <tr name="customer_${clientTrdFlowInfoList.id }">
                    <td class="layui-table-fixed-l">${i.index+1 }</td>
                        <%--<td>--%>
                        <%--<button class="layui-btn layui-btn-small" type="button"--%>
                        <%--onclick="doDetail('${clientTrdFlowInfoList.id}')">--%>
                        <%--<i class="layui-icon">&#xe60a;</i>详细--%>
                        <%--</button>--%>
                        <%--</td>--%>
                    <td hidden=" true">${clientTrdFlowInfoList.id}</td>
                    <td>${clientTrdFlowInfoList.userId}</td>
                    <td>${clientTrdFlowInfoList.clientName}</td>
                    <td>${clientTrdFlowInfoList.clientId} </td>
                    <td>${clientTrdFlowInfoList.fundAccount}</td>
                    <td>${clientTrdFlowInfoList.channelId}</td>
                    <td>${clientTrdFlowInfoList.tradeDate}</td>
                    <td>
                            ${fns:getCodeName("SEC_EXCHANGE_TYPE", clientTrdFlowInfoList.exchangeType)}
                    </td>
                    <td>${clientTrdFlowInfoList.stockCode}</td>
                    <td>${clientTrdFlowInfoList.stockName}</td>
                    <td>
                            ${fns:getCodeName("SEC_STOCK_TYPE", clientTrdFlowInfoList.stockType)}
                    </td>
                    <td>
                            ${fns:getCodeName("SEC_TRADE_KIND", clientTrdFlowInfoList.tradeKind)}
                    </td>
                    <td>
                            ${fns:getCodeName("SEC_ENTRUST_WAY", clientTrdFlowInfoList.entrustWay)}
                    </td>
                    <td>

                            ${fns:getCodeName("SEC_MONEY_TYPE_TRD", clientTrdFlowInfoList.moneyType)}
                    </td>
                    <td>${clientTrdFlowInfoList.businessAmount}</td>
                    <td>${clientTrdFlowInfoList.businessBalance}</td>
                    <td>${clientTrdFlowInfoList.businessPrice}</td>
                    <td>${clientTrdFlowInfoList.occurBalance}</td>
                    <td>${clientTrdFlowInfoList.feeCount}</td>
                    <td>${clientTrdFlowInfoList.profitFeeCount}</td>
                    <td>${clientTrdFlowInfoList.feeCountRatio}</td>
                        <%--<td>${clientTrdFlowInfoList.otherFeeCount}</td>--%>
                    <td>${clientTrdFlowInfoList.sequenceNo}</td>
                    <td>

                            ${fns:getCodeName("SEC_TRD_SESSION_TYPE", clientTrdFlowInfoList.sessionType)}
                    </td>
                        <%--<td>${clientTrdFlowInfoList.createTime} </td>--%>
                        <%--<td>${clientTrdFlowInfoList.updateTime}</td>--%>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
</div>
<sys:page page="${page}"></sys:page>
</div>
<!-- 选择渠道 -->
<div id="menuLayer" style="display: none;padding:10px;">
    <ul id="menuTree" class="ztree"></ul>
</div>
<script src="${webRoot}/js/channel/channel.js"></script>
<script src="${webRoot}/js/jquery.serializejson.js"></script>
</body>

<script>

    layui.laydate.render({
        elem: '#beginDate' //指定元素
    });
    layui.laydate.render({
        elem: '#endDate' //指定元素
    });

    $(function () {
        layui.use('table', function () {
            var table = layui.table;
            table.init('table_list', { //转化静态表格
                cellMinWidth: 110,
                limit:${page.pageSize}
                , text: {
                    none: '暂无相关数据' //默认：无数据
                }
            });
        });
    });

    //    $(function () {
    //        DatetimeInit();
    //    });

    // 设置日期时间控件
    function DatetimeInit() {
        $('#datetimepicker1').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            initialDate: new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            locale: moment.locale('zh-cn')
        });
        $('#datetimepicker2').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            initialDate: new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            locale: moment.locale('zh-cn')
        });
        // 初始化交易查询开始日期和结束日期
        var date = new Date();
        date.setDate(date.getDate() - 1);
        var beginNowDateStr = (date.getFullYear()) + "-" + (date.getMonth() + 1) + "-" + date.getDate();
        //对日期格式进行处理
        var beginNowDate = new Date(beginNowDateStr);
        var beginMon = date.getMonth() + 1;
        var BeginDay = date.getDate();
        var beginDate = beginNowDate.getFullYear() + "-" + (beginMon < 10 ? "0" + beginMon : beginMon) + "-" + (BeginDay < 10 ? "0" + BeginDay : BeginDay);
//        document.getElementById("beginDate").value = beginDate;

//        date.setDate(date.getDate());
//        var endNowDateStr = (date.getFullYear()) + "-" + (date.getMonth() + 1) + "-" + date.getDate();
//        //对日期格式进行处理
//        var endNowDate = new Date(endNowDateStr);
//        var endMon = date.getMonth() + 1;
//        var endDay = date.getDate();
//        var endDate = endNowDate.getFullYear() + "-" + (endMon < 10 ? "0" + endMon : endMon) + "-" + (endDay < 10 ? "0" + endDay : endDay);
//        document.getElementById("endDate").value = beginDate;
    }

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
//        layer.alert(obj);
        window.location.href = '${webRoot}/clientTradeFlowInfo/trdDetailListExpExcel?clientTradeFlowInfoEntity=&' + obj;
    }

    function showGraphic() {
        var obj = $('#search-from').serialize();
        var url = "${webRoot}/clientTradeFlowInfo/showGraphicView?info=&" + obj + "&type='channel_name'";
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["交易查询_图示", true],
            area: ['90%', '90%'], //宽高
            content: [url, 'yes'],
            shadeClose: false
        });
    }

    // 导入渠道返佣
    function impChannelReturn() {

        confirm('确定提交吗？', function () {
            $.ajax({
                type: "POST",
                url: "${webRoot}/clientTradeFlowInfo/impChannelReturn",
                data: $('#search-from').serialize(),
                dataType: "json",
                success: function (result) {
                    if (result.code == '0') {
                        toast(result, function () {
                            window.location.reload();
                        })
                    } else {
                        alertMsg(result.msg);
                    }
                }
            });
        });
    }

    layui.form.render('select');
</script>


</html>