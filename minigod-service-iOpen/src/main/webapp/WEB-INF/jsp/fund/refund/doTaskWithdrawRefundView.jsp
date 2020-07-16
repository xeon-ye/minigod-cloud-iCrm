<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>出金成功页面</title>
</head>
<body>
<div class="main-container" id="main-container">

    <div id="div1" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">退款方式</b></div>
            </br>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-xs-2 control-label no-padding-right"><span
                            style="color: red">*</span>入账方式</label>
                    <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                                    <tag:select nameKey="WITHDRAW_REFUND_DOPOSIT_TYPE" id="refundType"
                                                                name="refundType"
                                                                isAddDefaltOption="true"
                                                                clazz="form-control "
                                                                style="display:inline;width: 75%"/>
                                </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-xs-2 control-label no-padding-right"><span
                            style="color: red">*</span>币种</label>
                    <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                                    <tag:select nameKey="SEC_MONEY_TYPE_TRD" id="currencyType"
                                                                name="currencyType"
                                                                isAddDefaltOption="true"
                                                                clazz="form-control "
                                                                style="display:inline;width: 75%" initDidableKey="0,w" initSelectedKey="${info.moneyType}" disabled="true"/>
                                </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-xs-2 control-label no-padding-right">退款金额</label>
                    <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="refundAmount" name="refundAmount" type="number" class="form-control"
                                           maxlength="50" style="display:inline;width: 75%"
                                           placeholder="请输入退款金额"/>
                                </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-xs-2 control-label no-padding-right">银行手续费</label>
                    <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="refundBankFee" name="refundBankFee" type="number" class="form-control"
                                           maxlength="50" style="display:inline;width: 75%"
                                           placeholder="请输入银行手续费"/>
                                </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-xs-2 control-label no-padding-right">退款净金额</label>
                    <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="netRefundAmount" name="netRefundAmount" type="number" class="form-control"
                                           maxlength="50" style="display:inline;width: 75%"
                                           placeholder="请输入退款净金额"/>
                                </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-xs-2 control-label no-padding-right">退还手续费</label>
                    <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right">
                        <input id="chargeMoney" name="chargeMoney" type="text" class="form-control"
                               maxlength="50" style="display:inline;width: 75%"
                               value="<fmt:formatNumber value="${info.chargeMoney}" pattern="#,##0.00"/>" readonly/>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="div2" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">入金银行</b></div>
            <div class="row" style="margin-top: 20px;">
                <form class="layui-form" id="search-from" method="post"
                      action="${webRoot}/fundWithdrawRefund/goRefundView?busId=${taskDto.busId}&taskId=${taskDto.taskId}&defId=${taskDto.defId}&instanceId=${taskDto.instanceId}">
                </form>
            </div>
            <div class="row">
                <div class="col-xs-12" style="width:99%">
                    <table id="table-list" class="layui-table">
                        <thead>
                        <tr width="99%">
                            <th style="width: 7%;height: 20px;"><input type="checkbox"/></th>
                            <th>银行名称</th>
                            <th>银行编号</th>
                            <th>币种</th>
                            <th>银行帐户</th>
                            <th>备注</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.result}" var="hsCompanyBankInfo" varStatus="i">
                            <tr name="${hsCompanyBankInfo.id }">
                                <td><input id="id" name="selectFlag" type="checkbox"
                                           value="${hsCompanyBankInfo.id}-${hsCompanyBankInfo.bankName}"/>
                                </td>
                                <td>${hsCompanyBankInfo.bankName} </td>
                                <td>${hsCompanyBankInfo.bankId} </td>
                                <td>
                                        ${fns:getCodeName("SEC_MONEY_TYPE", hsCompanyBankInfo.moneyType)}
                                </td>
                                <td>${hsCompanyBankInfo.bankAccount} </td>
                                <td>${hsCompanyBankInfo.remark}</td>
                                <td>
                                    <c:if test = "${hsCompanyBankInfo.isTop == 0 or hsCompanyBankInfo.isTop == null}">
                                        <button class="layui-btn layui-btn-small" type="button"
                                                onclick="topHsBank(${hsCompanyBankInfo.id},1)">
                                            <i class="layui-icon">&#xe604;</i>置顶
                                        </button>
                                    </c:if>
                                    <c:if test = "${hsCompanyBankInfo.isTop == 1}">
                                        <button class="layui-btn layui-btn-small" type="button"
                                                onclick="topHsBank(${hsCompanyBankInfo.id},0)">
                                            <i class="layui-icon">&#xe604;</i>取消置顶
                                        </button>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <sys:page page="${page}"></sys:page>
                </div>
            </div>
        </div>
    </div>

    <div class="row" style="margin-left: 40%;padding-bottom: 28px;margin-top: 15px;">
        <button class="layui-btn " type="button" onclick="doSubmit()">提交</button>
        <button class="layui-btn layui-btn-primary" type="button" onclick="closeThisWindow()">关 闭</button>
    </div>

</div>

</body>
<script>
    // 流程相关信息类
    function processInfo(busId, actKey, taskId, instanceId, changeFields, defId, remark) {
        this.busId = busId;//业务id
        this.actKey = actKey;//流程key也是业务key
        this.taskId = taskId;//任务id
        this.instanceId = instanceId;//流程实例
        this.changeFields = changeFields;//可更改的字段
        this.defId = defId;//流程定义id
        this.remark = remark;//审批意见
    }

    var processInfo = new processInfo();
    $(function () {

        //获取业务可更改的字段，和流程业务基本信息
        processInfo.busId = '${taskDto.busId}';
        processInfo.taskId = '${taskDto.taskId}';
        processInfo.instanceId = '${taskDto.instanceId}';
        processInfo.defId = '${taskDto.defId}';
        processInfo.remark = '${taskDto.remark}';
    });

    function doSubmit() {

        if ($('#refundType').val() == "") {
            alertMsg("入账方式不能为空");
            return;
        }
        if ($('#currencyType').val() == "") {
            alertMsg("币种不能为空");
            return;
        }

        if ($('#refundType').val() == 1) {

            if ($('#refundAmount').val() == '' || $('#refundBankFee').val() == '') {
                alertMsg("请输入退款金额和银行手续费");
                return;
            }
        }

        if ($('#refundType').val() == 2) {

            if ($('#netRefundAmount').val() == '') {
                alertMsg("请输入退款净金额");
                return;
            }
        }

        var item_id;
        var item_name;
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        for (var i = 0; i < items.length; i++) {
            if (items[i].checked) {
                ++count;

                var arr = new Array();
                arr = items[i].value.split('-');

                item_id = arr[0];
                item_name = arr[1];
            }
        }

        if (count < 1) {
            alert("请选择行！");
            return;
        } else {
            confirm('确定该申请从<span style=\'color: red;\'>' + item_name + '</span>出账吗？', function () {
                var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&instanceId=" + '${taskDto.instanceId}' + "&defId=" + '${taskDto.defId}'
                    + "&remark=" + '${taskDto.remark}' + "&netRefundAmount=" + $('#netRefundAmount').val() + "&refundAmount=" + $('#refundAmount').val()
                    + "&refundBankFee=" + $('#refundBankFee').val() + "&refundType=" + $('#refundType').val() + "&currencyType=" + $('#currencyType').val() + "&itemId=" + item_id;

                var url = "${webRoot}/fundWithdrawRefund/doRefundSuc";
                $.post(url, params, function (result) {
                    if (result.code == '0') {
                        alert(result, function () {
                            // 刷新父窗口列表
                            parent.parent.location.reload();
                            // 关闭弹框
                            closeThisWindow();
                        });
                    } else {
                        alertMsg(result.msg);
                    }
                });
            });
        }
    }

    //置顶/取消置顶恒生公司账号
    function topHsBank(id,isTop) {
        var params = {
            'id': id,
            'isTop': isTop
        };
        var url = "${webRoot}/clientBankCardInfo/updateHsCompanyBank";
        $.post(url, params, function callback(result) {
            if (result.code == '0') {
                // 刷新列表
                window.location.reload();
            } else {
                alertMsg(result.msg);
            }
        }, "json");
    }

    $(function () {

        $("#table-list tr:gt(0)").click(function () {
            if ($('input[type="checkbox"]').is(':checked')) {
                $('input[type="checkbox"]').prop("checked", false);
                // 当前点击的checkbox
                var cobj = $(this).find("input[type='checkbox']");
                // 将当前点击的checkbox置为选中状态
                cobj.prop("checked", true);
                $("tr").removeClass();
                $(this).toggleClass('red');
            } else {
                // 每次点击前，将所有checkbox置为 未选中
                $('input[type="checkbox"]').prop("checked", false);
                // 当前点击的checkbox
                var cobj = $(this).find("input[type='checkbox']");
                // 将当前点击的checkbox置为选中状态
                cobj.prop("checked", true);
                $("tr").removeClass();
                $(this).toggleClass('red');
            }
        })

        $("#refundType").change(function () {
            var selected = $(this).children('option:selected').val();
            // alert(selected);
            if (selected == "1") {
                $('#netRefundAmount').val('');
                $('#netRefundAmount').attr("disabled", true);
                $('#refundAmount').removeAttr("disabled");
                $('#refundBankFee').removeAttr("disabled");
            } else if (selected == "2") {
                $('#netRefundAmount').removeAttr("disabled");
                $('#refundAmount').attr("disabled", true);
                $('#refundBankFee').attr("disabled", true);
                $('#refundAmount').val('');
                $('#refundBankFee').val('');
            } else {
                $('#refundAmount').removeAttr("disabled");
                $('#refundBankFee').removeAttr("disabled");
                $('#netRefundAmount').removeAttr("disabled");
                $('#refundAmount').val('');
                $('#refundBankFee').val('');
                $('#netRefundAmount').val('');
            }
        });
    });

</script>

</html>