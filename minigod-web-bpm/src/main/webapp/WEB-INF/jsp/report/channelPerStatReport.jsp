<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>渠道业绩统计报表</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post" action="${webRoot}/channelPerStat/list">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:180px;">渠道号:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="channelId" name="channelId" value="${info.channelId}"
                                       class="layui-input">
                            </div>
                        </td>
                        <%--<td>--%>
                        <%--<label class="layui-form-label" style="width:180px;">渠道:</label>--%>
                        <%--<div class="layui-input-inline">--%>
                        <%--<input type="text" id="channelName" name="channelName" value="${info.channelName}"  class="layui-input" >--%>
                        <%--</div>--%>
                        <%--</td>--%>
                        <td>
                            <label class="layui-form-label" style="width:180px;">开始日期:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="beginDate" name="beginDate" value="${info.beginDate}"
                                       class="layui-input">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:180px;">结束日期:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="endDate" name="endDate" value="${info.endDate}"
                                       class="layui-input">
                            </div>
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;&nbsp;<button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜
                            索
                        </button>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                        <td>
                            <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                        <td>

                            <shiro:hasPermission name="channelPerInfoExpExcel:exp">
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
    <table id="tableList" lay-filter="table_list" class="layui-table">
        <thead>
        <tr width="99%">
            <th lay-data="{field:'num',width:'60',fixed:'left'}">序号</th>
            <th lay-data="{field:'channelId',width:'80',fixed:'left'}">渠道号</th>
            <th lay-data="{field:'addUserQuantity',style:'background-color: #EAF6F6;'}">新增用户数</th>
            <th lay-data="{field:'totalUserQuantity',style:'background-color: #EAF6F6;'}">累计用户数</th>
            <th lay-data="{field:'addClientQuantity',style:'background-color: #F5F8FD;'}">新增开户数</th>
            <th lay-data="{field:'totalClientQuantity',style:'background-color: #F5F8FD;'}">累计开户数</th>
            <th lay-data="{field:'addDepClientQuantity',width:'130',style:'background-color: #EAF6F6;'}">新增入金客户数</th>
            <th lay-data="{field:'totalDepClientQuantity',width:'130',style:'background-color: #EAF6F6;'}">累计入金客户数</th>
            <th lay-data="{field:'addWitClientQuantity',width:'130',style:'background-color: #F5F8FD;'}">新增出金客户数</th>
            <th lay-data="{field:'totalWitClientQuantity',width:'130',style:'background-color: #F5F8FD;'}">累计出金客户数</th>
            <th lay-data="{field:'addStkTranQuantity',width:'130',style:'background-color: #EAF6F6;'}">新增转仓客户数</th>
            <th lay-data="{field:'totalStkTranQuantity',width:'130',style:'background-color: #EAF6F6;'}">累计转仓客户数</th>
            <th lay-data="{field:'addTradeClientQuantity',width:'130',style:'background-color: #F5F8FD;'}">新增交易客户数</th>
            <th lay-data="{field:'totalTradeClientQuantity',width:'130',style:'background-color: #F5F8FD;'}">累计交易客户数</th>
            <th lay-data="{field:'addIncomeBalance',width:'160',style:'background-color: #EAF6F6;'}">新增入金金额数</th>
            <th lay-data="{field:'totalIncomeBalance',width:'160',style:'background-color: #EAF6F6;'}">累计入金金额数</th>
            <th lay-data="{field:'addOutBalance',width:'160',style:'background-color: #F5F8FD;'}">新增出金金额数</th>
            <th lay-data="{field:'totalOutBalance',width:'160',style:'background-color: #F5F8FD;'}">累计出金金额数</th>
            <th lay-data="{field:'addTradeAmount',style:'background-color: #EAF6F6;'}">新增成交数量</th>
            <th lay-data="{field:'totalTradeAmount',style:'background-color: #EAF6F6;'}">累计成交数量</th>
            <th lay-data="{field:'addTradeBalance',style:'background-color: #F5F8FD;'}">新增成交金额</th>
            <th lay-data="{field:'totalTradeBalance',width:'160',style:'background-color: #F5F8FD;'}">累计成交金额</th>
            <th lay-data="{field:'addTradeBrokerage',width:'160',style:'background-color: #EAF6F6;'}">新增交易佣金</th>
            <th lay-data="{field:'totalTradeBrokerage',style:'background-color: #EAF6F6;'}">累计交易佣金</th>
            <th lay-data="{field:'addClientAsset',style:'background-color: #F5F8FD;'}">新增总资产</th>
            <th lay-data="{field:'totalClientAsset',minWidth:'150',style:'background-color: #F5F8FD;'}">累计总资产</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="info" varStatus="i">
            <tr name="">
                <td>${i.index+1 }</td>
                <td>${info.channelId}</td>
                    <%--<td>${info.channelName}</td>--%>
                <td>${info.addUserQuantity}</td>
                <td>${info.totalUserQuantity}</td>
                <td>${info.addClientQuantity}</td>
                <td>${info.totalClientQuantity}</td>
                <td>${info.addDepClientQuantity}</td>
                <td>${info.totalDepClientQuantity}</td>
                <td>${info.addWitClientQuantity}</td>
                <td>${info.totalWitClientQuantity}</td>
                <td>${info.addStkTranQuantity}</td>
                <td>${info.totalStkTranQuantity}</td>
                <td>${info.addTradeClientQuantity}</td>
                <td>${info.totalTradeClientQuantity}</td>
                <td>${info.addIncomeBalance}</td>
                <td>${info.totalIncomeBalance}</td>
                <td>${info.addOutBalance}</td>
                <td>${info.totalOutBalance}</td>
                <td>${info.addTradeAmount}</td>
                <td>${info.totalTradeAmount}</td>
                <td>${info.addTradeBalance}</td>
                <td>${info.totalTradeBalance}</td>
                <td>${info.addTradeBrokerage}</td>
                <td>${info.totalTradeBrokerage}</td>
                <td>${info.addClientAsset}</td>
                <td>${info.totalClientAsset}</td>
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
        elem: '#beginDate'
    });
    layui.laydate.render({
        elem: '#endDate'
    });

    $(function () {
        layui.use('table', function () {
            var table = layui.table;
            table.init('table_list', { //转化静态表格
                cellMinWidth: 120,
                limit:${page.pageSize}
                , text: {
                    none: '暂无相关数据' //默认：无数据
                }
            });
        });
    });

    /**
     * 导出excel
     */
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
//        layer.alert(obj);
        window.location.href = '${webRoot}/channelPerStat/channelPerInfoExpExcel?channelPerformanceStatEntity=&' + obj;
    }

    function showIncomeDetail(channelId, channelName) {
        var obj = jQuery("#search-from").serialize();
        url = "${webRoot}/clientFundDeposit/getClientFundDepositList?channelId=" + channelId + "&name=" + channelName + "&depositType=D" + "&" + obj;
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["客户详情", true],
            area: ['99%', '95%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
        });
    }

    function showOutcomeDetail(channelId, channelName) {
        var obj = jQuery("#search-from").serialize();
        url = "${webRoot}/clientFundDeposit/getClientFundDepositList?channelId=" + channelId + "&name=" + channelName + "&depositType=W" + "&" + obj;
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["客户详情", true],
            area: ['99%', '95%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
        });

    }

    function showTradeDetail(channelId, channelName) {
        var obj = jQuery("#search-from").serialize();
        url = "${webRoot}/clientTradeFlowInfo/getClientTrdFlowInfoDetailList?channelId=" + channelId + "&name=" + channelName + "&" + obj;
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["客户详情", true],
            area: ['99%', '95%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
        });

    }

    $("color").mouseover(function () {
        $(this).css({
            "border-color": "blue",
            "color": "blue"
        });
    }).mouseout(function () {
        $(this).css({
            "border-color": "",
            "color": ""
        });
    });


</script>

</html>