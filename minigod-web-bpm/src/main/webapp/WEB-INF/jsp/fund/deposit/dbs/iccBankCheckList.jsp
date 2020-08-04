<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>DBS入金核对</title>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
    <script src="${webRoot}/js/jquery.serializejson.js"></script>
    <link rel="stylesheet" href="${webRoot}/viewer/css/tips.css">
</head>
<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 10px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/dbsIccBankFlow/iccBankCheckList">
            <input type="hidden" name="id" value="${params.id}"/>
            <input type="hidden" name="bankName" value="1"/>
            <input type="hidden" id="flowSource" name="flowSource" value="${params.flowSource}">
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <label class="layui-form-label" style="width: 120px">流水号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="msgId" value="${params.msgId}" placeholder="请输入流水号"
                           class="form-control">
                </div>

                <label class="layui-form-label" style="width: 120px">汇款帐户名称:</label>
                <div class="layui-input-inline">
                    <input type="text" name="senderAccName" value="${params.senderAccName}" placeholder="请输入汇款帐户名称"
                           class="form-control">
                </div>

                <label class="layui-form-label" style="width: 120px">汇款帐户号码:</label>
                <div class="layui-input-inline">
                    <input type="text" name="senderAccNo" value="${params.senderAccNo}" placeholder="请输入汇款帐户号码"
                           class="form-control">
                </div>

                <label class="layui-form-label" style="width: 120px">币种:</label>
                <div class="layui-input-inline">
                    <tag:select id="currency" name="currency" nameKey="SEC_MONEY_TYPE_TRD"
                                isAddDefaltOption="true" initSelectedKey="${params.currency}"
                                clazz="form-control" initDidableKey="0,w"/>
                </div>

                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button class="layui-btn layui-btn-radius" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                </button>

                <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="refresh"><i
                        class="layui-icon layui-btn-radius">&#x1002;</i>重置
                </button>
            </div>

            <br/>
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <button class="layui-btn layui-btn-radius layui-btn-danger " style="float: right;margin-right: 10px"
                        type="button" onclick="deliverTaskBatch();"><i
                        class="layui-icon ">&#xe60f;</i>释放办理
                </button>
                <button class="layui-btn layui-btn-radius layui-btn-normal " style="float: right;margin-right: 20px"
                        type="button" onclick="applyTaskBatch();"><i
                        class="layui-icon">&#xe61f;</i>批量申领
                </button>
            </div>
        </form>
    </div>
    <div class="row" style="overflow-x:auto">
        <div class="col-xs-12">
            <table id="table-list" class="layui-table" style="width:100%">
                <thead>
                <tr width="99%">
                    <th hidden=true>id</th>
                    <th style="width: 5px;height: 20px;"><input type="checkbox" id="checkAll"/></th>
                    <th>操作</th>
                    <th>流水号</th>
                    <th>交易日期</th>
                    <th>交易时间</th>
                    <th>交易类型</th>
                    <th>汇款帐户名称</th>
                    <th>汇款帐户号码</th>
                    <th>汇款银行ID</th>
                    <th>币种</th>
                    <th>汇款金额</th>
                    <th>手续费</th>
                    <th>到账金额</th>
                    <th>收款帐户号码</th>
                    <th>客户流水号</th>
                    <th>银行流水号</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty page.result}">
                    <tr>
                        <td colspan="14" align="center">暂无数据</td>
                    </tr>
                </c:if>
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr name="${info.id }">
                        <td hidden=" true">${info.id}</td>
                        <td>
                            <input name="selectFlag" type="checkbox" value="${info.id}"/>
                        </td>
                        <td>
                            <c:if test="${info.assignDrafter == null or info.assignDrafter == ''}">
                                <div class="layui-btn-group">
                                    <c:if test="${info.areChargeMoney == null or info.areEnqStatus == '' or info.areEnqStatus!='ACSP'}">
                                        <button class="layui-btn layui-btn-mini" type="button"
                                                onclick="toQueryARE('${info.id}')">
                                            <i class="layui-icon">&#xe605;</i>获取手续费
                                        </button>
                                    </c:if>

                                    <button class="layui-btn layui-btn-mini" type="button"
                                            onclick="applyTask('${info.id}')">
                                        <i class="layui-icon">&#xe605;</i>申领
                                    </button>
                                </div>
                            </c:if>
                            <c:if test="${info.assignDrafter == currentUserId}">
                                <div class="layui-btn-group">
                                    <c:if test="${info.areChargeMoney == null or info.areEnqStatus == '' or info.areEnqStatus!='ACSP'}">
                                        <button class="layui-btn layui-btn-mini" type="button"
                                                onclick="toQueryARE('${info.id}')">
                                            <i class="layui-icon">&#xe605;</i>获取手续费
                                        </button>
                                    </c:if>

                                    <button class="layui-btn layui-btn-mini" type="button"
                                            onclick="toCheckTab('${info.id}')">
                                        <i class="layui-icon">&#xe705;</i>核对
                                    </button>
                                    <button class="layui-btn layui-btn-danger layui-btn-mini" type="button"
                                            onclick="deleteById('${info.id}')">
                                        <i class="layui-icon">&#xe640;</i>删除
                                    </button>
                                </div>
                            </c:if>
                        </td>
                        <td>${info.msgId}</td>
                        <td><fmt:formatDate value="${info.timeStamp}" pattern="dd/MM/yyyy"/></td>
                        <td><fmt:formatDate value="${info.timeStamp}" pattern="HH:mm:ss"/></td>
                        <td>${info.txnType}</td>
                        <td>${info.senderAccName}</td>
                        <td>${info.senderAccNo}</td>
                        <td>${info.senderBankId}</td>
                        <td>
                                ${fns:getCodeName("SEC_MONEY_TYPE_EN", info.currency)}
                        </td>
                        <td><fmt:formatNumber value="${info.actualMoney}" pattern="#,##0.00#"/></td>
                        <c:if test="${info.areChargeMoney == null or info.areEnqStatus == '' or info.areEnqStatus!='ACSP'}">
                            <td><span style="color: red">未获取</span></td>
                        </c:if>
                        <c:if test="${info.areEnqStatus =='ACSP'}">
                            <td><fmt:formatNumber value="${info.areChargeMoney}" pattern="#,##0.00#"/></td>
                        </c:if>
                        <td><fmt:formatNumber value="${info.creditAmount}" pattern="#,##0.00#"/></td>
                        <td>${info.subAccno}</td>
                        <td>${info.customerReference}</td>
                        <td>${info.referenceNo}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <sys:page page="${page}"></sys:page>
</div>
<script>

    // 全选按钮事件
    $(function () {
        $("#checkAll").click(function () {
            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
        });
    });

    $("#refresh").click(function () {
        window.location.reload();
    });

    function toCheckTab(id) {
        var url = "${webRoot}/clientFundDeposit/toCheckTab?jump=1&isload=1&billId=" + id;
        var title = "<a><strong>入金审核</strong></a>";
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: [title, true],
            area: ['100%', '100%'], //宽高
            offset: 't',
            content: [url, 'yes'],
            shadeClose: false,
            move: false
        });
    }

    // 删除
    function deleteById(id) {
        confirm('确定要删除该条银行流水吗？', function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            var url = "${webRoot}/depositBankBillFlow/delete";
            var params = {
                'id': id
            };
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result, function () {
                        // 刷新列表
                        window.location.reload();
                    })
                } else {
                    layer.close(loading);
                    alertMsg(result.msg);
                    window.location.reload();
                }
            }, "json");

        });
    }

    // 批量申领任务
    function applyTaskBatch() {
        var sids = document.getElementsByName("selectFlag");
        var billIds = '';
        for (var i = 0; i < sids.length; i++) {
            if (sids[i].checked) {
                billIds += sids[i].value + ",";
            }
        }
        if (billIds.length > 1) {
            billIds = billIds.substring(0, billIds.length - 1);
        }
        if (billIds == "") {
            alertMsg("没有勾选需要记录");
            return;
        }
        applyTask(billIds);
    }

    // 申领任务
    function applyTask(billIds) {
        if (billIds == "") {
            alertMsg("流水号不能为空");
            return;
        }
        confirm("您确定申领此业务吗?", function () {
            var params = {
                'billIds': billIds
            };
            var url = "${webRoot}/depositBankBillFlow/batchApplyTaskHandle";
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

    /**
     * 获取手续费
     */
    function toQueryARE(id){
        confirm("确定是否进行手续费查询吗？", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var url = "${webRoot}/depositBankBillFlow/toQueryARE";
            var params = {'id': id};
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result, function () {
                        // 刷新列表
                        window.location.reload();
                    })
                } else {
                    layer.close(loading);
                    alertMsg(result.msg);
                    window.location.reload();
                }
            }, "json");

        });
    }

    // 批量释放办理
    function deliverTaskBatch() {
        var sids = document.getElementsByName("selectFlag");
        var billIds = '';
        for (var i = 0; i < sids.length; i++) {
            if (sids[i].checked) {
                billIds += sids[i].value + ",";
            }
        }
        if (billIds.length > 1) {
            billIds = billIds.substring(0, billIds.length - 1);
        }
        if (billIds == "") {
            alertMsg("没有勾选需要记录");
            return;
        }
        confirm("您确定释放此业务吗?", function () {
            var params = {
                'billIds': billIds
            };
            var url = "${webRoot}/depositBankBillFlow/deliverApplyTask";
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
</body>
</html>
