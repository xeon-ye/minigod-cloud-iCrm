<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div id="div10" v-cloak>
    <div v-show="!showList" class="panel panel-default" >
        <div class="panel-heading"><b style="color: #368763">详细信息</b></div>
        </br>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">活动名称</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <input id="activityName" name="activityName" type="text" class="form-control"
                                       value="${donatedStockInfo.activityName}" readonly/>
                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">领取时间</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <input id="receiveTime" name="receiveTime" type="text" class="form-control"
                                       value="<fmt:formatDate value="${donatedStockInfo.receiveTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                       readonly/>

                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">活动ID</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <input id="activityId" name="activityId" type="text" class="form-control"
                                       value="${donatedStockInfo.activityId}" readonly/>
                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">小神号</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="userId" name="userId" type="text" class="form-control"
                                  value="${donatedStockInfo.userId}" readonly/>

                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">渠道号</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="channelId" name="channelId" type="text" class="form-control"
                                           value="${donatedStockInfo.channelId}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">客户帐号</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="clientId" name="clientId" type="text" class="form-control"
                                  value="${donatedStockInfo.clientId}" readonly/>

                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">渠道名称</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="channelName" name="channelName" type="text" class="form-control"
                                           value="${donatedStockInfo.channelName}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">客户名称</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="clientName" name="clientName" type="text" class="form-control"
                                  value="${donatedStockInfo.clientName}" readonly/>

                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">股票代码</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="stockCode" name="stockCode" type="text" class="form-control"
                                           value="${donatedStockInfo.stockCode}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">证券手机号</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="phoneNumber" name="phoneNumber" type="text" class="form-control"
                                  value="${donatedStockInfo.phoneNumber}" readonly/>

                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">股票名称</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="stockName" name="stockName" type="text" class="form-control"
                                           value="${donatedStockInfo.stockName}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">注册时间</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                            <input id="registerTime" name="registerTime" type="text" class="form-control"
                                   value="${donatedStockInfo.registerTime}"
                                   readonly/>
                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">股票数量</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="stockQuantity" name="stockQuantity" type="text" class="form-control"
                                           value="${donatedStockInfo.stockQuantity}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">开户时间</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="openAccountTime" name="openAccountTime" type="text" class="form-control"
                                  value="<fmt:formatDate value="${donatedStockInfo.openAccountTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                  readonly/>
                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">平均成本HKD</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="totalCost" name="totalCost" type="text" class="form-control"
                                           value="${donatedStockInfo.totalCost}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">方案ID</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="programmeId" name="programmeId" type="text" class="form-control"
                                           value="${donatedStockInfo.programmeId}" readonly/>
	                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">首次入金日期</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="firstIncomeDate" name="firstTransfer" type="text" class="form-control"
                                  value="${donatedStockInfo.firstIncomeDate}" readonly/>

                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">首入金HKD</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="firstIncome" name="firstIncome" type="text" class="form-control"
                                  value="${donatedStockInfo.firstIncome}" readonly/>

                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">首次转仓日期</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="firstTransferDate" name="firstTransfer" type="text" class="form-control"
                                  value="${donatedStockInfo.firstTransferDate}" readonly/>

                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">首转仓HKD</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="firstTransfer" name="firstTransfer" type="text" class="form-control"
                                  value="${donatedStockInfo.firstTransfer}" readonly/>

                            </span>
                </div>
            </div>
        </div>


    </div>
</div>

</body>

<script type="text/javascript">


</script>
</html>
