<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>交易记录</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container" style="width: 99%;">
    <div class="" style="margin: 20px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/clientTradeFlowInfo/tradeList">
            <input style="display: none" name="fundAccount" value="${fundAccount}">
        </form>
    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col-sm-12" >
            <table id="table-list" name="tableList" class="layui-table" >
                <thead>
                <tr>
                    <th>序号</th>
                    <th>股票代码</th>
                    <th>股票名称</th>
                    <th>成本价HKD</th>
                    <th>数量</th>
                    <th>成本HKD</th>
                    <th>成交时间</th>
                    <th>方向</th>
                </tr>
                </thead>
                <tbody >
                <c:forEach items="${page.result}" var="tradeInfo" varStatus="i">
                    <tr>
                       <td>${i.index+1}</td>
                       <td>${tradeInfo.stockCode}</td>
                       <td>${tradeInfo.stockName}</td>
                       <td>${tradeInfo.businessPrice}</td>
                       <td>${tradeInfo.businessAmount}</td>
                       <td>${tradeInfo.businessBalance}</td>
                       <td>${tradeInfo.tradeDate}</td>
                        <td><span <c:if test="${tradeInfo.tradeKind == '0B'}">style="color: red" </c:if>>${fns:getCodeName("SEC_TRADE_KIND",tradeInfo.tradeKind)}</span></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <sys:page page="${page}"></sys:page>
    </div>
</div>
</body>

<script>
 function assetList(fundAccount) {
     url = "${webRoot}/clientFundDeposit/assetList?fundAccount="+fundAccount,
         layer.open({
             scrollbar: false,
             type: 2,
             title: ["资金记录", true],
             area: ['90%', '80%'], //宽高
             content: [url, 'yes'],
             shadeClose: false,
             btn: ['确认'],
             yes: function (index) {
                 layer.close(index);
             }
         });
 }

</script>

</html>