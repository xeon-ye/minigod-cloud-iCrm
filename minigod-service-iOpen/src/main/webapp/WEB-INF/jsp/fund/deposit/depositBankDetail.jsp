<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>入金核对页</title>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer-jquery.min.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
    <script src="${webRoot}/js/jquery.serializejson.js"></script>

    <style>
        .layui-form-label {
            width: 120px;
            font-size: 13px;
        }

        .layui-form-label + .layui-input-block {
            margin-left: 135px;
            width: 160px;
            font-size: 13px;
        }

        .layui-btn {
            font-size: 13px;
        }

        .layui-btn-mini {
            font-size: 11px;
        }
    </style>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="layui-tab layui-tab-brief" style="margin-left: 10px">
        <div class="col-xs-12">
            <table class="layui-table" style="width:100%" lay-size="">
                <caption><b style="color: #000000">银行流水</b></caption>
                <thead>
                <tr width="99%">
                    <th hidden=true>id</th>
                    <th>Bank Name</th>
                    <th>Value Date</th>
                    <th>Account Name</th>
                    <th>Account Number</th>
                    <th>Sub Account Name</th>
                    <th>Sub Account No.</th>
                    <th>currency</th>
                    <th>Credit Amount</th>
                    <th>Transaction Reference</th>
                    <th width="20%">Particulars</th>
                </tr>
                </thead>
                <tbody>
                <tr name="${bankBill.id}">
                    <td hidden=" true">${bankBill.id}</td>
                    <td>
                        ${fns:getCodeName("FUND_DEPOSIT_BANK_EN", bankBill.bankName)}
                    </td>
                    <td><fmt:formatDate value="${bankBill.valueDate}" pattern="dd/MM/yyyy"/></td>
                    <td>${bankBill.accName}</td>
                    <td>${bankBill.accNo}</td>
                    <td>${bankBill.subAccname}</td>
                    <td>${bankBill.subAccno}</td>
                    <td>
                        ${fns:getCodeName("SEC_MONEY_TYPE_EN", bankBill.currency)}
                    </td>
                    <td><fmt:formatNumber value="${bankBill.creditAmount}" pattern="#,##0.00#"/></td>
                    <td>${bankBill.referenceNo}</td>
                    <td>${bankBill.particulars}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div>
            <br>
            <span style="color: red">注释：</span>下表是根据<span style="color: red">币种、申请金额、收款银行、收款帐户号码、模糊匹配</span>客户的入金申请，与上表中银行流水符合的只可选中1个。点击“核对通过”进入入金处理。
            <br>如果未能匹配到对应的入金申请，可点击下方“加载全部”。
        </div>
    </div>
    <div id="div1" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763;text-align:center">入金申请</b></div>
            </br>
            <form class="layui-form" id="search-from" method="post"
                  action="${webRoot}/clientFundDeposit/toCheckTab">
                <input type="hidden" id="isload" name="isload" value="${isload}">
                <input type="hidden" id="jump" name="jump" value="0">
                <input type="hidden" id="billId" name="billId" value="${bankBill.id}">

                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label" >开始日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="beginTime" name="beginTime" value="${params.beginTime}"
                               placeholder="请输入开始日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label" >结束日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="endTime" name="endTime" value="${params.endTime}" placeholder="请输入结束日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">

                    <label class="layui-form-label" >币种:</label>
                    <div class="layui-input-block">
                        <tag:select id="moneyType" name="moneyType" nameKey="SEC_MONEY_TYPE_TRD"
                                    isAddDefaltOption="true" initSelectedKey="${params.moneyType}"
                                    clazz="form-control" initDidableKey="0,w"/>
                    </div>

                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label" >申请金额:</label>
                    <div class="layui-input-block">
                        <input type="number" name="depositBalance" value="${params.depositBalance}"
                               placeholder="请输入申请金额" step="0.01"
                               class="form-control">
                    </div>

                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label" >收款银行:</label>
                    <div class="layui-input-block">
                        <tag:select id="benefitBank" name="benefitBank" nameKey="FUND_DEPOSIT_BANK"
                                    isAddDefaltOption="true" initSelectedKey="${params.benefitBank}"
                                    clazz="form-control"/>
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label" >收款账号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="benefitNo" value="${params.benefitNo}"
                               placeholder="请输入收款账号"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label" >中文名:</label>
                    <div class="layui-input-block">
                        <input type="text" name="clientName" value="${params.clientName}"
                               placeholder="请输入中文名"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label" >英文名:</label>
                    <div class="layui-input-block">
                        <input type="text" name="clientNameSpell" value="${params.clientNameSpell}"
                               placeholder="请输入英文名"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label" >汇款银行:</label>
                    <div class="layui-input-block">
                        <input type="text" name="depositBank" value="${params.depositBank}"
                               placeholder="请输入汇款银行"
                               class="form-control">
                    </div>

                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label" >客户帐号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="clientId" value="${params.clientId}"
                               placeholder="请输入客户帐号"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label" >申请时间排序:</label>
                    <div class="layui-input-block">
                        <tag:select id="order" name="order" nameKey="COMMON_ORDER"
                                    isAddDefaltOption="true" initSelectedKey="${params.order}"
                                    clazz="form-control"/>
                    </div>

                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label" >银行流水号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="referenceNo" value="${params.referenceNo}"
                               placeholder="请输入银行流水号"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-form-item" style="padding: 10px 50px;">
                    <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="reload">
                        <i class="layui-icon layui-btn-radius">&#x1002;</i>重置
                    </button>
                    <button class="layui-btn layui-btn-radius" id="searchSubmit">
                        <i class="layui-icon">&#xe615;</i>搜 索
                    </button>
                </div>
            </form>
            <div class="row" style="overflow-x:auto">
                <div class="col-xs-12">
                    <table id="table-list" class="layui-table" lay-size="">
                        <thead>
                        <tr width="99%">
                            <th hidden=true>id</th>
                            <th style="width: 10px;height: 20px;">单选</th>
                            <th>流水号</th>
                            <th>申请时间</th>
                            <th>客户账号</th>
                            <th>资金账号</th>
                            <th>中文名</th>
                            <th>英文名</th>
                            <th><span style="color: red">币种</span></th>
                            <th><span style="color: red">申请金额</span></th>
                            <th>汇款银行</th>
                            <th>汇款账号</th>
                            <th>收款银行</th>
                            <th>收款账号</th>
                            <th>凭证</th>
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
                                <td><input name="selectFlag" type="checkbox"
                                           value="${info.applicationId}|${info.assignDrafter}"/>
                                </td>
                                <td>
                                    <a href="javascript:void(0);" style="display: block;color: blue"
                                       onclick="viewTab('fundDepositApplication','${info.applicationId}','${info.instanceId}','','${info.defid}','','${info.assignDrafter}',0);">
                                        <c:if test="${info.fireAid == 1}">
                                            <i class="layui-icon" style="color: red">&#xe756;</i>
                                        </c:if>${info.applicationId}</a>
                                </td>
                                <td><fmt:formatDate value="${info.applicationTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td>${info.clientId}</td>
                                <td>${info.fundAccount}</td>
                                <td>${info.clientName}</td>
                                <td>${info.clientNameSpell}</td>
                                <td>
                                        ${fns:getCodeName("SEC_MONEY_TYPE_EN", info.moneyType)}
                                </td>
                                <td><fmt:formatNumber value="${info.depositBalance}" pattern="#,##0.00#"/></td>
                                <td>${info.depositBank}</td>
                                <td>${info.depositNo}</td>
                                <td>${fns:getCodeName("FUND_DEPOSIT_BANK", info.benefitBank)}</td>
                                <td>${info.benefitNo}</td>
                                <td>
                                    <div hidden id="imageList${info.applicationId}">
                                        <ul class="docs-pictures"></ul>
                                    </div>
                                    <button class="layui-btn layui-btn-small" type="button"
                                            onclick="showImages('${info.applicationId}')">
                                        <i class="layui-icon">&#xe60a;</i>客户凭证
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <a href="javacript:void(0);" onclick="return loadmore('${bankBill.id}')"
                       style="display: block; text-align: center;color: blue">加载更多...
                    </a>
                    <sys:page page="${page}"></sys:page>
                </div>
            </div>
        </div>
    </div>
    <div id="div4" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763;text-align:center">审批意见</b></div>
            </br>
            <div class="form-group" style="margin-left: 10px;width: 99%">
                <textarea name="remark" id="remark" class="form-control" rows="3"
                          placeholder="不超过100个字符,非必填"></textarea>
            </div>
        </div>
    </div>
    <div class="col-sm-12" align="left" style="margin-top: 30px;">
        <button class="layui-btn layui-btn-radius" type="button" onclick="toCheckView()">核对通过</button>
        <button class="layui-btn layui-btn-danger layui-btn-radius" type="button" onclick="tobackView()">退 回</button>
        <button class="layui-btn layui-btn-primary layui-btn-radius" type="button" onclick="closeThisWindow()">返 回
        </button>
    </div>
</div>
</body>
<script>

    //弹窗入金凭证
    function toCheckView() {
        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;
        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                ++count;
                applicationIds += ids[i].value.split("|")[0] + ",";
            }
        }
        if (count != 1) {
            alertMsg("请勾选一条数据");
            return;
        }
        var applicationId = applicationIds.substring(0, applicationIds.length - 1);
        var url = "${webRoot}/clientFundDeposit/toCheckView?applicationId=" + applicationId + "&flowId=" + ${bankBill.id}
            +"&remark=" + $("#remark").val();

        // 弹框层
        layer.open({
            scrollbar: true,
            type: 2,
            title: ["上传银行流水", true],
            area: ['60%', '60%'],
            content: [url, 'yes'],
            offset: 'center'
        });
    }

    $("#reload").click(function () {
        var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
        var url = '${webRoot}/clientFundDeposit/toCheckTab?jump=0&billId=' +${bankBill.id};
        $.ajaxPrefilter('script', function (options) {
            options.cache = true;
        });
        window.location.href = url;
        layer.close(loading);
    });

    //加载更多
    function loadmore(billId) {
        var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
        var beginTime = $("#beginTime").val();
        var today = new Date();
        var date = '';
        if (beginTime != "") {
            date = new Date(beginTime);

            var difValue = (today - date) / (1000 * 60 * 60 * 24);
            if (difValue > 179) {
                layer.close(loading);
                alertMsg("仅支持加载180日内的申请，如需更多请手动搜索");
                return false;
//                day.setDate(day.getDate() - 180);
//                date=day;
            } else {
                date.setDate(date.getDate() - 15);
            }
        } else {
            date = new Date();
            date.setDate(today.getDay() - 14);
        }
        var Y = date.getFullYear();
        var M = date.getMonth() + 1;
        var D = date.getDate();
        beginTime = Y + (M < 10 ? "-0" : "-") + M + (D < 10 ? "-0" : "-") + D;

        var url = '${webRoot}/clientFundDeposit/toCheckTab?jump=0&isload=0&billId=' + billId + '&beginTime=' + beginTime;
        $.ajaxPrefilter('script', function (options) {
            options.cache = true;
        });
        window.location.href = url;
        layer.close(loading);
        return false;
    }

    //跳转退回页面
    function tobackView() {
        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;
        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                ++count;
                applicationIds += ids[i].value.split("|")[0] + ",";
            }
        }
        if (count != 1) {
            alertMsg("请先勾选需要处理的申请");
            return;
        }
        var applicationId = applicationIds.substring(0, applicationIds.length - 1);
        var url = "${webRoot}/clientFundDeposit/tobackView?applicationId=" + applicationId + "&remark=" + $("#remark").val();

        // 弹框层
        layer.open({
            scrollbar: true,
            type: 2,
            title: ["入金审核-退回", true],
            area: ['85%', '90%'],
            content: [url, 'yes']
        });
    }

    //查看详情
    function viewTab(actKey, busId, instanceId, taskId, defid, nodeType, dealId, flag) {

        var url = "${webRoot}/act/deal/flowInfoTab?actKey=" + actKey + "&busId=" + busId + "&instanceId=" + instanceId
            + "&taskId=" + taskId + "&defId=" + defid + "&nodeType=" + nodeType + "&dealId=" + dealId + "&flag=" + flag;
        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["查看详情", true],
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
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
    });

    //查看图片
    function showImages(applicationId) {
        var id = applicationId;
        <c:forEach var="info" items="${page.result}">
        if (applicationId == ${info.applicationId}) {
            <c:forEach var="imageInfo" items="${info.despositImage}" varStatus="i">
            pictureListWithId("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}",
                ${i.index}, id);
            </c:forEach>
        }
        </c:forEach>
        $('#imageList' + id).viewer();
        showImage(id, 0);
    }

    layui.form.render('select');

    layui.laydate.render({
        elem: '#beginTime' // 指定元素
    });
    layui.laydate.render({
        elem: '#endTime' // 指定元素
    });

</script>
</html>
