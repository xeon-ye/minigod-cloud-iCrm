<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>股份查询</title>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <shiro:hasPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post"
                  action="${webRoot}/clientStockFlowInfo/getClientStkFlowInfoDetailList">
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
                                <label class="layui-form-label" style="width: 100px">证券类别:</label>
                                <div class="col-xs-8">
                                    <tag:select id="stockType" name="stockType" nameKey="SEC_STOCK_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.stockType}"
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
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 100px">交易日期:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="tradeDate" name="tradeDate" value="${params.tradeDate}"
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

                                <shiro:hasPermission name="stkDetailListExpExcel:exp">
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
                  action="${webRoot}/clientStockFlowInfo/getClientStkFlowInfoDetailList">
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
                                <label class="layui-form-label" style="width: 100px">证券类别:</label>
                                <div class="col-xs-8">
                                    <tag:select id="stockType" name="stockType" nameKey="SEC_STOCK_TYPE"
                                                isAddDefaltOption="true" initSelectedKey="${params.stockType}"
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
                                <label class="layui-form-label" style="width: 100px">交易日期:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="tradeDate" name="tradeDate" value="${params.tradeDate}"
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

                                <shiro:hasPermission name="stkDetailListExpExcel:exp">
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
            <th lay-data="{field:'stockName'}">证券名称</th>
            <th lay-data="{field:'stockType'}">证券类别</th>
            <th lay-data="{field:'moneyType'}">货币名称</th>
            <th lay-data="{field:'beginAmount'}">期初数量</th>
            <th lay-data="{field:'currentAmount'}">当前数量</th>
            <th lay-data="{field:'frozenAmount'}">冻结数量</th>
            <th lay-data="{field:'unfrozenAmount'}">解冻数量</th>
            <th lay-data="{field:'costPrice'}">买入均价</th>
            <th lay-data="{field:'stockMktValue',minWidth:'150'}">证券市值</th>
            <th lay-data="{field:'referProfitCost',minWidth:'150'}">参考盈亏</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="clientStkFlowInfoList" varStatus="i">
            <tr name="customer_${clientStkFlowInfoList.id }">
                <td>${i.index+1 }</td>
                <td hidden=" true">${clientStkFlowInfoList.id}</td>
                <td>${clientStkFlowInfoList.userId}</td>
                <td>${clientStkFlowInfoList.clientName}</td>
                <td>${clientStkFlowInfoList.clientId} </td>
                <td>${clientStkFlowInfoList.fundAccount}</td>
                <td>${clientStkFlowInfoList.channelId}</td>
                <td>${clientStkFlowInfoList.tradeDate}</td>
                <td>${fns:getCodeName("SEC_EXCHANGE_TYPE",clientStkFlowInfoList.exchangeType)}</td>
                <td>${clientStkFlowInfoList.stockCode}</td>
                <td>${clientStkFlowInfoList.stockName}</td>
                <td>${fns:getCodeName("SEC_STOCK_TYPE",clientStkFlowInfoList.stockType)}</td>
                <td>${fns:getCodeName("SEC_MONEY_TYPE_TRD",clientStkFlowInfoList.moneyType)}</td>
                <td>${clientStkFlowInfoList.beginAmount}</td>
                <td>${clientStkFlowInfoList.currentAmount}</td>
                <td>${clientStkFlowInfoList.frozenAmount}</td>
                <td>${clientStkFlowInfoList.unfrozenAmount}</td>
                <td>${clientStkFlowInfoList.costPrice}</td>
                <td>${clientStkFlowInfoList.stockMktValue}</td>
                <td>${clientStkFlowInfoList.referProfitCost}</td>
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
        elem: '#tradeDate' //指定元素
    });

    $(function () {
        layui.use('table', function () {
            var table = layui.table;
            table.init('table_list', { //转化静态表格
                cellMinWidth: 100,
                limit:${page.pageSize}
                , text: {
                    none: '暂无相关数据' //默认：无数据
                }
            });
        });
    });

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
//        layer.alert(obj);
        window.location.href = '${webRoot}/clientStockFlowInfo/stkDetailListExpExcel?clientStockFlowInfoEntity=&' + obj;
    }

    layui.form.render('select');
</script>

</html>