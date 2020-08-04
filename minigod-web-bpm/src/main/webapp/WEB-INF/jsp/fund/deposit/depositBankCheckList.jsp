<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>入金批量拒绝列表页</title>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer-jquery.min.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
    <script src="${webRoot}/js/jquery.serializejson.js"></script>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 10px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/clientFundDeposit/bankCheckList">
            <input type="hidden" id="isload" name="isload" value="${isload}">
            <input type="hidden" id="billId" name="billId" value="${bankBill.id}">
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <label class="layui-form-label" style="width: 120px">开始日期:</label>
                <div class="layui-input-inline">
                    <input type="text" id="beginTime" name="beginTime" value="${params.beginTime}"
                           placeholder="请输入开始日期"
                           class="form-control">
                </div>

                <label class="layui-form-label" style="width: 120px">结束日期:</label>
                <div class="layui-input-inline">
                    <input type="text" id="endTime" name="endTime" value="${params.endTime}" placeholder="请输入结束日期"
                           class="form-control">
                </div>

                <label class="layui-form-label" style="width: 120px">币种:</label>
                <div class="layui-input-inline">
                    <tag:select id="moneyType" name="moneyType" nameKey="SEC_MONEY_TYPE_TRD"
                                isAddDefaltOption="true" initSelectedKey="${params.moneyType}"
                                clazz="form-control" initDidableKey="0,w"/>
                </div>

                <label class="layui-form-label" style="width: 120px">申请金额:</label>
                <div class="layui-input-inline">
                    <input type="number" name="depositBalance" value="${params.depositBalance}"
                           placeholder="请输入申请金额"
                           class="form-control">
                </div>

                <label class="layui-form-label" style="width: 120px">收款银行:</label>
                <div class="layui-input-inline">
                    <tag:select id="benefitBank" name="benefitBank" nameKey="FUND_DEPOSIT_BANK"
                                isAddDefaltOption="true" initSelectedKey="${params.benefitBank}"
                                clazz="form-control"/>
                </div>
            </div>
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <label class="layui-form-label" style="width: 120px">收款账号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="benefitNo" value="${params.benefitNo}"
                           placeholder="请输入收款账号"
                           class="form-control">
                </div>
                <label class="layui-form-label" style="width: 120px">中文名:</label>
                <div class="layui-input-inline">
                    <input type="text" name="clientName" value="${params.clientName}"
                           placeholder="请输入中文名"
                           class="form-control">
                </div>
                <label class="layui-form-label" style="width: 120px">英文名:</label>
                <div class="layui-input-inline">
                    <input type="text" name="clientNameSpell" value="${params.clientNameSpell}"
                           placeholder="请输入英文名"
                           class="form-control">
                </div>
                <label class="layui-form-label" style="width: 120px">汇款银行:</label>
                <div class="layui-input-inline">
                    <input type="text" name="depositBank" value="${params.depositBank}"
                           placeholder="请输入汇款银行"
                           class="form-control">
                </div>
                <label class="layui-form-label" style="width: 100px"></label>
                <button class="layui-btn layui-btn-radius" id="searchSubmit">
                    <i class="layui-icon">&#xe615;</i>搜 索
                </button>
                <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="reload">
                    <i class="layui-icon layui-btn-radius">&#x1002;</i>重置
                </button>

            </div>
            <br/>
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <shiro:hasPermission name="clientFundDeposit:batchReject">
                    <button class="layui-btn layui-btn-radius layui-btn-warm "
                            style="float: left;margin-right: 10px"
                            type="button" onclick="toRejectTaskBatch('${currentUserId}');"><i
                            class="layui-icon ">&#x1005;</i>批量拒绝
                    </button>
                </shiro:hasPermission>
                <button class="layui-btn layui-btn-radius layui-btn-danger " style="float: right;margin-right: 10px"
                        type="button" onclick="deliverApplyTask();"><i
                        class="layui-icon ">&#xe60f;</i>释放办理
                </button>
                <button class="layui-btn layui-btn-radius layui-btn-normal " style="float: right;margin-right: 20px"
                        type="button" onclick="applyTaskHandleBatch();"><i
                        class="layui-icon">&#xe61f;</i>批量申领
                </button>
            </div>
        </form>
    </div>
    <table id="tableList" lay-filter="table_list" class="layui-table">
        <thead>
        <tr width="99%">
            <th lay-data="{field:'id',hide:true}" hidden="true">id</th>
            <th lay-data="{field:'assignDrafter',hide:true}" hidden="true">assignDrafter</th>
            <th lay-data="{type:'checkbox',unresize:true,fixed:'left'}"></th>
            <th lay-data="{field:'applicationId',minWidth:'170',fixed: 'left'}">流水号</th>
            <th lay-data="{field:'applicationTime',minWidth:'160'}">申请时间</th>
            <th lay-data="{field:'clientId',minWidth:'120'}">客户账号</th>
            <th lay-data="{field:'clientName'}">中文名</th>
            <th lay-data="{field:'clientNameSpell'}">英文名</th>
            <th lay-data="{field:'moneyType'}">币种</th>
            <th lay-data="{field:'depositBalance'}">申请金额</th>
            <th lay-data="{field:'depositBank'}">汇款银行</th>
            <th lay-data="{field:'depositNo',minWidth:'150'}">汇款账号</th>
            <th lay-data="{field:'benefitBank'}">收款银行</th>
            <th lay-data="{field:'benefitN'}">收款账号</th>
            <th lay-data="{field:'despositImage',align:'center',fixed: 'right'}">客户凭证</th>
            <th lay-data="{field:'applyStatus',align:'center',fixed: 'right'}">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="info" varStatus="i">
            <div hidden id="imageList${info.applicationId}">
                <ul class="docs-pictures"></ul>
            </div>
            <tr name="${info.id}">
                <td hidden=" true">${info.applicationId}</td>
                <td hidden=" true">${info.assignDrafter}</td>
                <td></td>
                <td>
                    <a href="javascript:void(0);" style="display: block;color: blue"
                       onclick="viewTab('fundDepositApplication','${info.applicationId}','${info.instanceId}','','${info.defid}','','${info.assignDrafter}',0);">
                        <c:if test="${info.fireAid == 1}">
                            <i class="layui-icon" style="color: red">&#xe756;</i>
                        </c:if>${info.applicationId}</a>
                </td>
                <td><fmt:formatDate value="${info.applicationTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${info.fundAccount}</td>
                <td>${info.clientName}</td>
                <td>${info.clientNameSpell}</td>
                <td>
                        ${fns:getCodeName("SEC_MONEY_TYPE_EN", info.moneyType)}
                </td>
                <td><fmt:formatNumber value="${info.depositBalance}" pattern="#,##0.00#"/></td>
                <td>${info.depositBank}</td>
                <td>${info.depositNo}</td>
                <td>
                        ${fns:getCodeName("FUND_DEPOSIT_BANK", info.benefitBank)}
                </td>
                <td>${info.benefitNo}</td>
                <td>
                    <button class="layui-btn layui-btn-small" type="button"
                            onclick="showImages('${info.applicationId}')">
                        <i class="layui-icon">&#xe60a;</i>客户凭证
                    </button>
                </td>
                <td>
                    <c:if test="${info.assignDrafter == currentUserId}">
                        <button class="layui-btn layui-btn-mini" type="button"
                                onclick="deliverApplyTask('${info.applicationId}')">
                            <i class="layui-icon">&#xe604;</i>释放
                        </button>
                    </c:if>
                    <c:if test="${info.assignDrafter == null or info.assignDrafter == ''}">
                        <button class="layui-btn layui-btn-mini" type="button"
                                onclick="applyTask('${info.applicationId}','${currentUserId}')">
                            <i class="layui-icon">&#xe604;</i>申领
                        </button>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
<sys:page page="${page}"></sys:page>
</div>
<script>
    layui.laydate.render({
        elem: '#beginTime' // 指定元素
    });
    layui.laydate.render({
        elem: '#endTime' // 指定元素
    });

    $("#reload").click(function () {
        var url = '${webRoot}/clientFundDeposit/bankCheckList';
        $.ajaxPrefilter('script', function (options) {
            options.cache = true;
        });
        window.location.href = url;
    });

    var applicationIds = [];
    var assignDrafter = [];
    $(function () {
        layui.use('table', function () {
            var table = layui.table;

            table.init('table_list', { //转化静态表格
                cellMinWidth: 100,
                limit:${page.pageSize}
                , text: {
                    none: '暂无相关数据' //默认：无数据
                }
            });

            table.on('checkbox(table_list)', function (obj) {
                var checkStatus = table.checkStatus('tableList');
                var data = checkStatus.data;
                applicationIds = [];
                assignDrafter = [];
                for (var i = 0; i < data.length; i++) {    //循环筛选出id
                    applicationIds.push(data[i].id.trim());
                    assignDrafter.push(data[i].assignDrafter.trim())
                }
            });

        });
    });

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

    //跳转退回页面
    function toRejectTaskBatch(currentUserId) {

        if (applicationIds.toString() == "") {
            alertMsg("没有勾选需要记录");
            return;
        }
        for (var i = 0; i < assignDrafter.length; i++) {
            if (assignDrafter[i] == null || assignDrafter[i] == '' || assignDrafter[i] != currentUserId) {
                alertMsg("存在未申领任务");
                return;
            }
        }
        var url = "${webRoot}/clientFundDeposit/toBatchBackView?applicationIds=" + applicationIds;

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["请选择退回原因", true],
            area: ['60%', '60%'],
            content: [url, 'yes']
        });

    }

    // 申领任务
    function applyTask(applicationIds, currentUserId) {
        if (applicationIds.toString() == "") {

            alertMsg("预约号不能为空");
            return;
        }

        confirm("您确定申领此业务吗?", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var params = {
                'applicationIds': applicationIds.toString(),
                'toUserId': currentUserId,
                'actKey': 'fundDepositApplication'
            };
            var url = "${webRoot}/clientFundDeposit/batchApplyTaskHandle";
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
                    layer.close(loading);
                }
            }, "json");
        });
    }

    // 批量申领任务
    function applyTaskHandleBatch() {

        if (applicationIds.toString() == "") {
            alertMsg("没有勾选需要记录");
            return;
        }

        applyTask(applicationIds.toString(), '${currentUserId}');
    }

    // 释放任务办理
    function deliverApplyTask(applicationId) {
        if (applicationId != null && applicationId != '') {
            applicationIds.push(applicationId);
        }
        if (applicationIds.toString() == "") {
            alertMsg("没有勾选需要记录");
            return;
        }
        confirm("您确定释放此业务吗?", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var params = {
                'applicationIds': applicationIds.toString()
            };
            var url = "${webRoot}/clientFundDeposit/deliverApplyTask";
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
                    layer.close(loading);
                }
            }, "json");
        });
    }

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
</script>
</body>
</html>
