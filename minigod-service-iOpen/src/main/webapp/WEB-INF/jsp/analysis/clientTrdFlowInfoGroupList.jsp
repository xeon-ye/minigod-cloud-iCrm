<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>交易统计</title>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <shiro:hasPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post"
                  action="${webRoot}/clientTradeFlowInfo/getClientTrdFlowInfoGroupList">
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
                                <label class="layui-form-label" style="width: 100px">渠道号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="channelId" value="${params.channelId}"
                                           placeholder="请输入渠道号"
                                           class="form-control">
                                </div>
                            </td>
                        </tr>

                        <tr>
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
                            <td>&nbsp;&nbsp;&nbsp;
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                </button>
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                                        class="layui-icon">&#x1002;</i>重 置
                                </button>
                                <shiro:hasPermission name="trdGroupListExpExcel:exp">
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
                  action="${webRoot}/clientTradeFlowInfo/getClientTrdFlowInfoGroupList">
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
                                <label class="layui-form-label" style="width: 100px">渠道号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="channelId" value="${params.channelId}"
                                           placeholder="请输入渠道号"
                                           class="form-control">
                                </div>
                            </td>
                        </tr>

                        <tr>
                                <%--<td>--%>
                                <%--<label class="layui-form-label" style="width: 100px">渠道名称:</label>--%>
                                <%--<div class="col-xs-8">--%>
                                <%--<input type="text" id="channelName" name="channelName" class="form-control" style="cursor:pointer;" onclick="menuTree();" readonly="readonly" value="${params.channelName}" placeholder="请选择渠道"/>--%>
                                <%--<input hidden type="text" id="checkedChannelId" name="checkedChannelId" value="${params.checkedChannelId}"/>--%>
                                <%--</div>--%>
                                <%--</td>--%>

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
                            <td>&nbsp;&nbsp;&nbsp;
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                </button>
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                                        class="layui-icon">&#x1002;</i>重 置
                                </button>
                                <shiro:hasPermission name="trdGroupListExpExcel:exp">
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
                    <%--<th>操作</th>--%>
                    <th hidden=true>id</th>
                    <th>小神号</th>
                    <th>客户姓名</th>
                    <th>交易帐号</th>
                    <th>资金帐号</th>
                    <th>渠道</th>
                    <%--<th>交易日期</th>--%>
                    <%--<th>证券市场</th>--%>
                    <%--<th>证券代码</th>--%>
                    <%--<th>证券名称</th>--%>
                    <%--<th>证券类别</th>--%>
                    <%--<th>交易类别</th>--%>
                    <%--<th>委托方式</th>--%>
                    <%--<th>币种代码</th>--%>
                    <th>成交数量</th>
                    <th>成交金额</th>
                    <th>清算金额</th>
                    <th>佣金</th>
                    <th>净佣金</th>
                    <th>佣金比例(%)</th>
                    <%--<th>其他费用</th>--%>
                    <%--<th>交易流水号</th>--%>
                    <%--<th>创建时间</th>--%>
                    <%--<th>修改时间</th>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="clientTrdFlowInfoList" varStatus="i">
                    <tr name="customer_${clientTrdFlowInfoList.id }">
                        <td>${i.index+1 }</td>
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
                            <%--<td>${clientTrdFlowInfoList.tradeDate}</td>--%>
                            <%--<td>--%>
                            <%--<c:choose>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.exchangeType=='K'}">港交所</c:when>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.exchangeType=='P'}">美国市场</c:when>--%>
                            <%--</c:choose>--%>
                            <%--</td>--%>
                            <%--<td>${clientTrdFlowInfoList.stockCode}</td>--%>
                            <%--<td>${clientTrdFlowInfoList.stockName}</td>--%>
                            <%--<td>--%>
                            <%--<c:choose>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.stockType=='0'}">股票</c:when>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.stockType=='1'}">基金</c:when>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.stockType=='D'}">权证</c:when>--%>
                            <%--</c:choose>--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<c:choose>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.tradeKind=='0B'}">买入</c:when>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.tradeKind=='0S'}">卖出</c:when>--%>
                            <%--</c:choose>--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<c:choose>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.entrustWay=='7'}">网上委托</c:when>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.entrustWay=='4'}">自助委托</c:when>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.entrustWay=='T'}">电话委托</c:when>--%>
                            <%--</c:choose>--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<c:choose>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.moneyType==0}">人民币</c:when>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.moneyType==1}">美元</c:when>--%>
                            <%--<c:when test="${clientTrdFlowInfoList.moneyType==2}">港币</c:when>--%>
                            <%--</c:choose>--%>
                            <%--</td>--%>
                        <td>${clientTrdFlowInfoList.businessAmount}</td>
                        <td>${clientTrdFlowInfoList.businessBalance}</td>
                        <td>${clientTrdFlowInfoList.occurBalance}</td>
                        <td>${clientTrdFlowInfoList.feeCount}</td>
                        <td>${clientTrdFlowInfoList.profitFeeCount}</td>
                        <td>${clientTrdFlowInfoList.feeCountRatio}</td>
                            <%--<td>${clientTrdFlowInfoList.otherFeeCount}</td>--%>
                            <%--<td>${clientTrdFlowInfoList.sequenceNo}</td>--%>
                            <%--<td>${clientTrdFlowInfoList.createTime} </td>--%>
                            <%--<td>${clientTrdFlowInfoList.updateTime}</td>--%>
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
        window.location.href = '${webRoot}/clientTradeFlowInfo/trdGroupListExpExcel?clientTradeFlowInfoEntity=&' + obj;
    }

    //    layui.form.render('select');
</script>

</html>