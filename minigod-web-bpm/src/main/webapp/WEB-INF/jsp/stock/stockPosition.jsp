<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>持仓情况</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container" style="width: 99%;">

    <div class="row" style="margin-top: 20px;margin-bottom: 50px">
        <div class="panel-heading"><b style="color: #368763;font-size: 18px" >资产概况</b></div>
        <div class="col-sm-12" >
            <table id="table-list-asset" name="tableList" class="layui-table" >
                <tr width="99%" >
                    <td>总资产</td>
                    <td>${stockAsset.asset}</td>
                    <td>综合购买力</td>
                    <td>${stockAsset.enableBalance}</td>
                </tr>
                <tr width="99%" >
                    <td>证券市值</td>
                    <td>${stockAsset.marketValue}</td>
                    <td>可取资金</td>
                    <td>${stockAsset.specialFetchBalance}</td>
                </tr>
            </table>
        </div>
        <div align="right" style="margin-right: 20px">
            <button class="layui-btn layui-btn-radius layui-btn-small layui-btn-primary" onclick="assetList(${fundAccount});"><i class="layui-icon " >&#xe63c;</i>资金记录</button>
        </div>
    </div>

    <div class="row">
        <div class="panel-heading"><b style="color: #368763;font-size: 18px" >持仓情况</b></div>
        <div class="col-sm-12" >
            <table id="table-list" name="tableList" class="layui-table" >
                <thead>
                <tr width="99%" >
                    <%--<th>序号</th>--%>
                    <th>股票代码</th>
                    <th>股票名称</th>
                    <th>成本价</th>
                    <th>股票数量</th>
                    <th>成本HKD</th>
                </tr>
                </thead>
                <tbody >
                <c:forEach items="${stockPositionList}" var="stock" varStatus="i">
                    <tr >
                       <%--<td>${i.index+1}</td>--%>
                       <td>${stock.assetId}</td>
                       <td>${stock.stkName}</td>
                       <td>${stock.costPrice}</td>
                       <td>
                           <fmt:formatNumber  value="${stock.currentAmount}" type="number"   pattern="#"/>
                       </td>
                       <td>${stock.totalCost}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div align="right" style="margin-right: 20px">
            <button class="layui-btn layui-btn-radius layui-btn-small layui-btn-primary" onclick="tradeList(${fundAccount});"><i class="layui-icon " >&#xe63c;</i>交易记录</button>
        </div>
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
    
 function tradeList(fundAccount) {
     url = "${webRoot}/clientTradeFlowInfo/tradeList?fundAccount="+fundAccount,
         layer.open({
             scrollbar: false,
             type: 2,
             title: ["交易记录", true],
             area: ['90%', '80%'], //宽高
             content: [url, 'yes'],
             shadeClose: false,
             btn: ['确认'],
             yes: function (index) {
                 layer.close(index);
             }
         });
 }

 $(function () {
     if(${stockPositionMsg != null}){
        alertMsg("${stockPositionMsg}")
     }else if(${stockPositionMsg == null && fundTotalMsg!=null}){
         alertMsg("${fundTotalMsg}")
     }
 })
</script>

</html>