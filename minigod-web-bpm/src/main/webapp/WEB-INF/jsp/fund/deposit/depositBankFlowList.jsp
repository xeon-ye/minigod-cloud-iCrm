<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>入金银行流水页</title>
    <script src="${webRoot}/viewer/js/viewer.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <link rel="stylesheet" href="${webRoot}/viewer/css/tips.css">
    <style>
        .layui-form-label {
            width: 125px;
            font-size: 13px;
        }

        .layui-form-label + .layui-input-block {
            margin-left: 140px;
            width: 160px;
            font-size: 13px;
        }

        .layui-btn {
            font-size: 13px;
        }

        .layui-btn-mini {
            font-size: 11px;
            margin-top: 5px;
            margin-bottom: 5px;
            margin-left: 5px;
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 10px;margin-left: 10px;">
        <div class="row">
            <label class="layui-form-label">请选择银行:</label>
            <div class="layui-input-inline input-icon" style="width: 160px">
                <tag:select id="bankType" name="bankType" nameKey="FUND_DEPOSIT_BANK_EN"
                            isAddDefaltOption="false"
                            clazz="form-control"/>
            </div>
            <div class="layui-input-inline">
                <button class="layui-btn layui-btn-radius layui-btn-normal " style="float: left;margin-right: 20px"
                        id="importBankBill" name="importBankBill" type="button"><i
                        class="layui-icon">&#xe61f;</i>导入银行流水
                </button>
                <div class="help-tip">
                    <p>导入文件应为所选银行提供的文件: <br/>
                        1.DBS,HSBCHK为EXCEL文件; <br/>
                        2.BOCHK为CSV文件,请设置编码为UTF-8;<br/>
                        3.请勿更改文件模板,禁止通过更改文件扩展名生成文件</p>
                </div>
            </div>
        </div>
        <br>
        <div>
            <span style="color: red">注释：</span>从中银系统导出流水时，必须要选择下载设定选项中的“<span style="color: red">纯文字文档</span>”，
            并勾选“<span style="color: red">包括栏目名称</span>”,系统会自动去掉重复导入的记录。
        </div>
        <br>
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/depositBankBillFlow/bankCheckList">
            <input type="hidden" id="flowSource" name="flowSource" value="${params.flowSource}" />
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">Min Amount:</label>
                <div class="layui-input-block">
                    <input type="number" id="creditAmountMin" name="creditAmountMin" value="${params.creditAmountMin}"
                           placeholder="min credit amount"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">Max Amount:</label>
                <div class="layui-input-block">
                    <input type="number" id="creditAmountMax" name="creditAmountMax"
                           value="${params.creditAmountMax}"
                           placeholder="max credit amount"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">Currency:</label>
                <div class="layui-input-block">
                    <tag:select nameKey="SEC_MONEY_TYPE_EN" id="currency" name="currency"
                                isAddDefaltOption="true" initSelectedKey="${params.currency}"
                                initDidableKey="0,w" clazz="form-control"/>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">Bank Name:</label>
                <div class="layui-input-block">
                    <tag:select id="bankName" name="bankName" nameKey="FUND_DEPOSIT_BANK_EN"
                                isAddDefaltOption="true" initSelectedKey="${params.bankName}"
                                clazz="form-control"/>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">Sub-Account Name:</label>
                <div class="layui-input-block">
                    <input type="text" name="subAccname" value="${params.subAccname}"
                           placeholder="sub-account name"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">Sub-Account Number:</label>
                <div class="layui-input-block">
                    <input type="text" name="subAccno" value="${params.subAccno}"
                           placeholder="sub-account number"
                           class="form-control">
                </div>
            </div>
            <div class="layui-form-item" style="padding: 10px 50px;">
                <button class="layui-btn layui-btn-radius" id="searchSubmit">
                    <i class="layui-icon">&#xe615;</i>搜 索
                </button>
                <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="refresh">
                    <i class="layui-icon layui-btn-radius">&#x1002;</i>重置
                </button>
                <shiro:hasPermission name="depositBankBillFlow:export">
                    <button class="layui-btn layui-btn-danger layui-btn-radius" type="button" id="export"
                            onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>汇 出
                    </button>
                </shiro:hasPermission>
                <shiro:hasPermission name="clientFundDeposit:batchReject">
                    <button class="layui-btn layui-btn-danger layui-btn-radius"
                            style="float: right;margin-right: 10px"
                            type="button" id="batchReject"
                            onclick="toBankCheckList()"><i class="layui-icon">&#xe69c;</i>批量退回
                    </button>
                </shiro:hasPermission>
                <button class="layui-btn layui-btn-radius layui-btn-danger" style="float: right;margin-right: 10px"
                        type="button" onclick="deliverApplyTask();"><i
                        class="layui-icon ">&#xe60f;</i>释放办理
                </button>
                <button class="layui-btn layui-btn-radius layui-btn-normal " style="float: right;margin-right: 20px"
                        type="button" onclick="applyTaskHandleBatch();"><i
                        class="layui-icon">&#xe61f;</i>批量申领
                </button>
            </div>
        </form>
        <div class="row">
            <div class="col-xs-12">
                <table id="table-list" class="layui-table" style="width:100%" lay-size="">
                    <caption><b style="color: #000000">银行流水</b></caption>
                    <thead>
                    <tr width="100%">
                        <th hidden=true>id</th>
                        <th style="width: 5px;height: 20px;"><input type="checkbox" id="checkAll"/></th>
                        <th>Bank Name</th>
                        <th>Value Date</th>
                        <th>Time</th>
                        <th>Account Name</th>
                        <th>Account Number</th>
                        <th>Sub Account Name</th>
                        <th>Sub Account No.</th>
                        <th>currency</th>
                        <th>Credit Amount</th>
                        <th>Transaction Reference</th>
                        <th>Particulars</th>
                        <th width="10%">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${empty page.result}">
                        <tr>
                            <td colspan="12" align="center">暂无数据</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${page.result}" var="info" varStatus="i">
                        <tr name="${info.id }"
                                <c:if test="${info.repeat == 1}"> style="color: #05ba4a" </c:if> >
                            <td hidden=" true">${info.id}</td>
                            <td><input name="selectFlag" type="checkbox" value="${info.id}"/></td>
                            <td>
                                    ${fns:getCodeName("FUND_DEPOSIT_BANK_EN", info.bankName)}
                            </td>
                            <td><fmt:formatDate value="${info.valueDate}" pattern="dd/MM/yyyy"/></td>
                            <td>${info.processingTime}</td>
                            <td>${info.accName}</td>
                            <td>${info.accNo}</td>
                            <td>${info.subAccname}</td>
                            <td>${info.subAccno}</td>
                            <td>
                                    ${fns:getCodeName("SEC_MONEY_TYPE_EN", info.currency)}
                            </td>
                            <td><fmt:formatNumber value="${info.creditAmount}" pattern="#,##0.00#"/></td>
                            <td>${info.referenceNo} </td>
                            <td>${info.particulars} </td>
                            <td>
                                <c:if test="${info.assignDrafter == null or info.assignDrafter == ''}">
                                    <button class="layui-btn layui-btn-mini" type="button"
                                            onclick="applyTask('${info.id}','${currentUserId}')">
                                        <i class="layui-icon">&#xe604;</i>申领
                                    </button>
                                </c:if>
                                <c:if test="${info.assignDrafter == currentUserId}">
                                    <div class="layui-btn-group">
                                        <button class="layui-btn layui-btn-mini" type="button"
                                                onclick="toEditTab('${info.id}','${info.referenceNo}','${info.bankName}')">
                                            <i class="layui-icon ">&#xe642;</i>编辑
                                        </button>
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
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <sys:page page="${page}"></sys:page>
            </div>
        </div>
    </div>
</div>
</body>
<script>

    $("#refresh").click(function () {
        window.location.reload();
    });

    layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;
        //文件上传
        var uploadFile = upload.render({
            elem: '#importBankBill'
            , url: '${webRoot}/depositBankBillFlow/readExcel'
            , accept: 'file'
            , acceptMime: 'file/xls,file/xlsx,file/csv'  //layui 2.2.6开始支持
            , exts: 'xls|xlsx|csv' //只允许上传指定格式文件
            , data: {
                bankType: $('#bankType').val()
            }
            , method: 'POST'
            , before: function (obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
                uploadFile.config.data.bankType = $('#bankType').val();
            }
            , done: function (res) {
                if (res.code == 0) {
                    window.location.reload();
                    alert(res.msg);
                } else {
                    alertMsg(res.msg);
                }
            }
        });

    });

    function toCheckTab(id) {
        var url = "${webRoot}/clientFundDeposit/toCheckTab?jump=0&isload=1&billId=" + id;
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

    // 跳转编辑页
    function toEditTab(flowId) {
        var url = "${webRoot}/depositBankBillFlow/tobackView?flowId=" + flowId;
        var title = "<a><strong>银行流水编辑</strong></a>";
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: [title, true],
            area: ['70%', '70%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 'center'
        });
    }

    function deleteById(id) {
        confirm('确定要删除该条银行流水吗？', function () {
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
                    alertMsg(result.msg);
                }
            }, "json");

        });
    }

    //跳转入金审核列表
    function toBankCheckList() {
        var url = "${webRoot}/clientFundDeposit/bankCheckList";

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["入金审核-批量退回", true],
            area: ['100%', '100%'],
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        })
    }

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled", "true").addClass('layui-btn-disabled');
        setTimeout(function () {
            $("#export").attr("disabled", false).removeClass("layui-btn-disabled");
        }, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/depositBankBillFlow/export?queryCondition=&' + obj;
    }

    // 批量释放办理
    function deliverApplyTask() {
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

    // 批量申领任务
    function applyTaskHandleBatch() {
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

    // 全选按钮事件
    $(function () {
        $("#checkAll").click(function () {
            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
        });
    });

    layui.form.render('select');
</script>

</html>
