<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>渠道返佣</title>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/clientTradeFlowInfo/channelBrokerageReturn">
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
                        <td>
                            <label class="layui-form-label" style="width: 100px">佣金下限:</label>
                            <div class="col-xs-8">
                                <input type="text" name="minFeeCount" value="${params.minFeeCount}"
                                       placeholder="请输入佣金下限"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 100px">佣金上限:</label>
                            <div class="col-xs-8">
                                <input type="text" name="maxFeeCount" value="${params.maxFeeCount}"
                                       placeholder="请输入佣金上限"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">状态:</label>
                            <div class="col-xs-8">
                                <tag:select id="entryStatus" name="entryStatus" nameKey="CHANNEL_RETURN_ENTRY_STATUS"
                                            isAddDefaltOption="true" initSelectedKey="${params.entryStatus}"
                                            clazz="form-control"/>
                            </div>
                        </td>
                        <td>
                            <button class="layui-btn layui-btn-radius" id="searchSubmit"><i
                                    class="layui-icon">&#xe615;</i>搜 索
                            </button>
                            <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="refresh"><i
                                    class="layui-icon">&#x1002;</i>重
                                置
                            </button>
                            <shiro:hasPermission name="trdDetailListExpExcel:exp">
                                <button class="layui-btn layui-btn-danger layui-btn-radius" type="button" id="export"
                                        onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                </button>
                            </shiro:hasPermission>
                        </td>
                        <td>
                            <shiro:hasPermission name="channelBrokerageReturn:entry">
                                <button class="layui-btn layui-btn-normal layui-btn-radius" type="button"
                                        onclick="doAuthEntryBatch();"><i
                                        class="layui-icon">&#x1005;</i>授权入账
                                </button>
                                <button class="layui-btn layui-btn-warm layui-btn-radius" type="button"
                                        onclick="clean();"><i
                                        class="layui-icon">&#xe640;</i>清空名单
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
            <th lay-data="{field:'id',hide:true}" hidden="true">id</th>
            <th lay-data="{type:'checkbox',unresize:true,fixed:'left'}"></th>
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
            <th lay-data="{field:'sessionType'}">状态</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${page.result!= null && fn:length(page.result) > 0}">
            <c:forEach items="${page.result}" var="info" varStatus="i">
                <tr>
                    <td hidden="true">${info.id}</td>
                    <td></td>
                    <td>${info.userId}</td>
                    <td>${info.clientName}</td>
                    <td>${info.clientId}</td>
                    <td>${info.fundAccount}</td>
                    <td>${info.channelId}</td>
                    <td><fmt:formatDate value="${info.tradeDate}" pattern="yyyy-MM-dd"/></td>
                    <td>
                            ${fns:getCodeName("SEC_EXCHANGE_TYPE", info.exchangeType)}
                    </td>
                    <td>${info.stockCode}</td>
                    <td>${info.stockName}</td>
                    <td>
                            ${fns:getCodeName("SEC_STOCK_TYPE", info.stockType)}
                    </td>
                    <td>
                            ${fns:getCodeName("SEC_TRADE_KIND", info.tradeKind)}
                    </td>
                    <td>
                            ${fns:getCodeName("SEC_ENTRUST_WAY", info.entrustWay)}
                    </td>
                    <td>
                            ${fns:getCodeName("SEC_MONEY_TYPE_TRD", info.moneyType)}
                    </td>
                    <td>${info.businessAmount}</td>
                    <td>${info.businessBalance}</td>
                    <td>${info.businessPrice}</td>
                    <td>${info.occurBalance}</td>
                    <td>${info.feeCount}</td>
                    <td>${info.profitFeeCount}</td>
                    <td>${info.feeCountRatio}</td>
                    <td>${info.sequenceNo}</td>
                    <td>
                            ${fns:getCodeName("CHANNEL_RETURN_ENTRY_STATUS", info.entryStatus)}
                    </td>
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
</body>

<script>
    var ids = [];
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

            table.on('checkbox(table_list)', function (obj) {
                var checkStatus = table.checkStatus('tableList');
                var data = checkStatus.data;
                ids = [];
                for (var i = 0; i < data.length; i++) {    //循环筛选出id
                    ids.push(data[i].id.trim());
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

        var url1 = '${webRoot}/clientTradeFlowInfo/channelReturnExp?channelReturnEntity=&' + obj;

        var url2 = '${webRoot}/clientTradeFlowInfo/channelReturnGroupExp?channelReturnEntity=&' + obj;

        downloadFile('', url1);
        downloadFile('', url2);
    }

    function downloadFile(name, href) {
        var a = document.createElement("a"), //创建a标签
            e = document.createEvent("MouseEvents"); //创建鼠标事件对象
        e.initEvent("click", false, false); //初始化事件对象
        a.href = href; //设置下载地址
        a.download = name; //设置下载文件名
        a.dispatchEvent(e); //给指定的元素，执行事件click事件
    }

    // 授权入账
    function doAuthEntryBatch() {
        if (ids.toString() == "") {
            alertMsg("没有勾选需要记录");
            return;
        }

        confirm("您确定授权入账吗？", function () {
            var params = {
                'ids': ids.toString()
            };
            var url = "${webRoot}/clientTradeFlowInfo/doAuthEntryBatch";
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

    // 清空名单
    function clean() {

        confirm("您确定要清空待入账名单吗？", function () {
            var params = {
                'ids': ''
            };
            var url = "${webRoot}/clientTradeFlowInfo/doClean";
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

    layui.form.render('select');
</script>


</html>