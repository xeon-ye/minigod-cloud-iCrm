<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>编辑银行流水页</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
</head>
<body>
<div v-show="!showList" class="panel panel-default" >
    <div class="panel-heading"><b style="color: #368763;text-align:center">流水信息</b></div>
    </br>
    <div class="row">
        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">Bank Name</label>
            <div class="col-xs-9">
                 <span class="col-sm-12 block input-icon input-icon-right">
                     <tag:select nameKey="FUND_DEPOSIT_BANK_EN" id="bankName" name="bankName"
                                 initSelectedKey="${info.bankName}" disabled="false"
                                 clazz="form-control"/>
                 </span>
            </div>
        </div>

        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">Value Date</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="valueDate" name="valueDate" type="text" class="form-control"
                           value="<fmt:formatDate value="${info.valueDate}" pattern="dd/MM/yyyy"/>"
                    />
                </span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">Account Name</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="accName" name="accName" type="text" class="form-control"
                           value="${info.accName}">
                </span>
            </div>
        </div>

        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">Account Number</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="accNo" name="accNo" type="text" class="form-control"
                           value="${info.accNo}">
                </span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">Sub Account Name</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="subAccname" name="subAccname" type="text" class="form-control"
                           value="${info.subAccname}">
                </span>
            </div>
        </div>

        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">Sub Account No.</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="subAccno" name="subAccno" type="text" class="form-control"
                           value="${info.subAccno}">
                </span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">currency</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <tag:select nameKey="SEC_MONEY_TYPE_EN" id="currency" name="currency"
                                initSelectedKey="${info.currency}" initDidableKey="0,w"
                                clazz="form-control"/>
                </span>
            </div>
        </div>

        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">Credit Amount</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="creditAmount" name="creditAmount" type="number" class="form-control"
                           value="${info.creditAmount}">
                </span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">Transaction  Reference</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="referenceNo" name="referenceNo" type="text" class="form-control"
                           value="${info.referenceNo}">
                </span>
            </div>
        </div>

        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">Prticulars</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <%--这个封闭标签必须写在一行，否则前面会有神秘空格--%>
                    <textarea wrap="soft" id="particulars" name="particulars" class="form-control">${info.particulars}</textarea>
                </span>
            </div>
        </div>
    </div>

        <div class="row" style="margin-left: 40%;padding-bottom: 28px;margin-top: 15px;">
            <button class="layui-btn " type="button" onclick="submitBankFlow()">提交</button>
            <button class="layui-btn layui-btn-primary" type="button" onclick="closeThisWindow()">关 闭</button>
        </div>
</div>

</body>
<script>
    // 更新信息
    function submitBankFlow() {
        confirm("确定执行此操作吗？", function () {
            var url = "${webRoot}/depositBankBillFlow/update";
            var params = {
                'id':${info.id},
                'currency':$("#currency").val(),
                'valueDate':$("#valueDate").val(),
                'bankName':$("#bankName").val(),
                'accName':$("#accName").val(),
                'accNo':$("#accNo").val(),
                'subAccname':$("#subAccname").val(),
                'subAccno':$("#subAccno").val(),
                'creditAmount':$("#creditAmount").val(),
                'referenceNo':$("#referenceNo").val(),
                'particulars':$('#particulars').val()
            };
            $.post(url, params, function (result) {
//                if (result.code == '0') {
                    toast(result, function () {
                        //刷新父窗口列表
                        parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    })
//                } else {
//                    alertMsg(result.msg);
//                }
            });

        });
    }
    layui.laydate.render({
        elem: '#valueDate', // 指定元素
        format:'dd/MM/yyyy'
    });
    layui.form.render('select');
</script>

</html>