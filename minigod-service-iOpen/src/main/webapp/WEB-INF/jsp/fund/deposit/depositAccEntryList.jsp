<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>入账列表页</title>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer-jquery.min.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/jquery.serializejson.js"></script>
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
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
    <div class="" style="margin-top: 10px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/clientFundDeposit/accEntryList">
            <%--<input type="hidden" name="flag" value="${params.flag}"/>--%>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">开始日期:</label>
                <div class="layui-input-block">
                    <input type="text" id="beginTime" name="beginTime" value="${params.beginTime}" placeholder="请输入开始日期"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">结束日期:</label>
                <div class="layui-input-block">
                    <input type="text" id="endTime" name="endTime" value="${params.endTime}" placeholder="请输入结束日期"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">小神号:</label>
                <div class="layui-input-block">
                    <input type="text" name="userId" value="${params.userId}" placeholder="请输入小神号"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">资金帐号:</label>
                <div class="layui-input-block">
                    <input type="text" name="fundAccount" value="${params.fundAccount}"
                           placeholder="请输入资金帐号"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">币种:</label>
                <div class="layui-input-block">
                    <tag:select id="moneyType" name="moneyType" nameKey="SEC_MONEY_TYPE_TRD"
                                isAddDefaltOption="true" initSelectedKey="${params.moneyType}"
                                clazz="form-control" initDidableKey="0,w"/>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">收款银行:</label>
                <div class="layui-input-block">
                    <tag:select id="benefitBank" name="benefitBank" nameKey="FUND_DEPOSIT_BANK"
                                isAddDefaltOption="true" initSelectedKey="${params.benefitBank}"
                                clazz="form-control"/>
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">汇款银行:</label>
                <div class="layui-input-block">
                    <input type="text" name="depositBank" value="${params.depositBank}"
                           placeholder="请输入汇款银行"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">客户账号:</label>
                <div class="layui-input-block">
                    <input type="text" name="clientId" value="${params.clientId}"
                           placeholder="请输入客户账号"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">银行流水号:</label>
                <div class="layui-input-block">
                    <input type="text" name="referenceNo" value="${params.referenceNo}"
                           placeholder="请输入银行流水号"
                           class="form-control">
                </div>

            </div>
            <div class="layui-form-item" style="padding: 10px 50px;">
                <button class="layui-btn layui-btn-radius" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                </button>
                <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="refresh"><i
                        class="layui-icon layui-btn-radius">&#x1002;</i>重置
                </button>
                <shiro:hasPermission name="clientFundDeposit:export">
                    <button class="layui-btn layui-btn-danger layui-btn-radius" type="button" id="export"
                            onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                    </button>
                </shiro:hasPermission>
                <button class="layui-btn layui-btn-radius layui-btn-warm "
                        style="float: left;margin-right: 10px"
                        type="button" onclick="doPassTaskBatch();"><i
                        class="layui-icon ">&#x1005;</i>批量入账
                </button>
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
    <div class="row" style="overflow-x:auto">
        <div class="col-xs-12">
            <table id="table-list" class="layui-table" style="width:100%" lay-size="">
                <thead>
                <tr width="99%">
                    <th hidden=true>id</th>
                    <th style="width: 5px;height: 20px;"><input type="checkbox" id="checkAll"/></th>
                    <th>流水号</th>
                    <th>申请时间</th>
                    <th>英文名</th>
                    <th>是否首次入金</th>
                    <th>币种</th>
                    <th>申请金额</th>
                    <th>到账金额</th>
                    <th>汇款银行</th>
                    <th>汇款账号</th>
                    <th>银行流水号</th>
                    <th>客户凭证</th>
                    <th>银行凭证</th>
                    <th>操作</th>
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
                                   value="${info.applicationId}|<fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                        </td>
                        <td>
                            <c:if test="${info.fireAid == 1}">
                                <i class="layui-icon" style="color: red">&#xe756;</i>
                            </c:if>${info.applicationId}
                        </td>
                        <td><fmt:formatDate value="${info.applicationTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${info.clientNameSpell}</td>
                        <c:choose>
                            <c:when test="${info.firstDepFlag < 1}">
                                <td>是</td>
                            </c:when>
                            <c:otherwise>
                                <td>否</td>
                            </c:otherwise>
                        </c:choose>
                        <td>
                                ${fns:getCodeName("SEC_MONEY_TYPE_TRD", info.moneyType)}
                        </td>
                        <td><fmt:formatNumber value="${info.depositBalance}" pattern="#,##0.00#"/></td>
                        <td><fmt:formatNumber value="${info.benefitBalance}" pattern="#,##0.00#"/></td>
                        <td>${info.depositBank}</td>
                        <td>${info.depositNo}</td>
                        <td>${info.referenceNo}</td>
                        <td>
                            <div hidden id="imageList${info.applicationId}0">
                                <ul class="docs-pictures"></ul>
                            </div>
                            <button class="layui-btn layui-btn-small" type="button"
                                    onclick="showImages('${info.applicationId}','0')">
                                <i class="layui-icon">&#xe60a;</i>客户凭证
                            </button>
                        </td>
                        <td>
                            <div hidden id="imageList${info.applicationId}1">
                                <ul class="docs-pictures"></ul>
                            </div>
                            <c:if test="${empty info.bankImage}">
                                <button class="layui-btn layui-btn-small layui-btn-disabled" type="button">
                                    <i class="layui-icon">&#xe60a;</i>银行凭证
                                </button>
                            </c:if>
                            <c:if test="${info.bankImage!= null && fn:length(info.bankImage) > 0}">
                                <button class="layui-btn layui-btn-small" type="button"
                                        onclick="showImages('${info.applicationId}','1')">
                                    <i class="layui-icon">&#xe60a;</i>银行凭证
                                </button>
                            </c:if>
                        </td>
                        <td>
                            <div class=" btn-group ">
                                <c:if test="${info.assignDrafter == null or info.assignDrafter == '' }">
                                    <button class="layui-btn layui-btn-small" type="button"
                                            onclick="applyTask('${info.applicationId}','${currentUserId}')">
                                        <i class="layui-icon">&#xe604;</i>申领
                                    </button>
                                </c:if>
                                <c:if test="${info.assignDrafter == currentUserId}">
                                    <button class="layui-btn layui-btn-small" type="button"
                                            onclick="doTaskTab('fundDepositApplication','${info.applicationId}','${info.instanceId}','','${info.defid}',''
                                                    ,'${info.assignDrafter}','${info.currentNode}',
                                                    '${fns:getCodeName("FUND_DEPOSIT_STATUS",info.applicationStatus)}')">
                                        <i class="layui-icon">&#xe705;</i>办理
                                    </button>
                                </c:if>
                            </div>
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
        elem: '#beginTime', // 指定元素
    });
    layui.laydate.render({
        elem: '#endTime', // 指定元素
    });

    $("#refresh").click(function () {
        window.location.reload();
    });

    // 全选按钮事件
    $(function () {
        $("#checkAll").click(function () {
            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
        });
    });

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled", "true").addClass('layui-btn-disabled');
        setTimeout(function () {
            $("#export").attr("disabled", false).removeClass("layui-btn-disabled");
        }, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/clientFundDeposit/export?flag=3&queryCondition=&' + obj;
    }

    // 办理任务
    function doTaskTab(actKey, busId, instanceId, taskId, defid, nodeType, dealId, taskName, applicationStatus) {

        var url = "${webRoot}/act/deal/flowInfoTab?flag=1&actKey=" + actKey + "&busId=" + busId + "&instanceId=" + instanceId
            + "&taskId=" + taskId + "&defId=" + defid + "&nodeType=" + nodeType + "&dealId=" + dealId + "&taskName=" + taskName;

        var title = "<a><strong>入金办理-" + applicationStatus + "</strong></a>";

        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: [title, true],
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
    }

    // 申领任务
    function applyTask(applicationIds, currentUserId) {
        if (applicationIds == "") {
            alertMsg("预约号不能为空");
            return;
        }
        confirm("您确定申领此业务吗?", function () {
            var params = {
                'applicationIds': applicationIds,
                'toUserId': currentUserId,
                'actKey': 'fundDepositApplication'
            };
            var url = "${webRoot}/clientFundDeposit/batchApplyTaskHandle";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    // 刷新列表
                    window.location.reload();
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
        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;
        var flag = false;

        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                ++count;
                applicationIds += ids[i].value.split("|")[0] + ",";
            }
        }

        if (applicationIds.length > 1) {
            applicationIds = applicationIds.substring(0, applicationIds.length - 1);
        }

        if (applicationIds == "") {
            alertMsg("没有勾选需要记录");
            return;
        }
        applyTask(applicationIds, '${currentUserId}');
    }

    // 批量释放办理
    function deliverApplyTask() {
        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;
        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                ++count;
                if (ids[i].value.split("|")[1] != "") {
                    applicationIds += ids[i].value.split("|")[0] + ",";
                }

            }
        }
        if (applicationIds.length > 1) {
            applicationIds = applicationIds.substring(0, applicationIds.length - 1);
        }

        confirm("您确定释放此业务吗?", function () {
            var params = {
                'applicationIds': applicationIds
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
                }
            }, "json");
        });
    }

    // 批量办理任务
    function doPassTaskBatch() {
        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;

        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                ++count;
                applicationIds += ids[i].value.split("|")[0] + ",";
            }
        }

        if (applicationIds.length > 1) {
            applicationIds = applicationIds.substring(0, applicationIds.length - 1);
        }

        if (applicationIds == "") {
            alertMsg("没有勾选需要记录");
            return;
        }

        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&defId=" + '${taskDto.defId}' + "&instanceId=" + '${taskDto.instanceId}'
            + "&applicationIds=" + applicationIds;

        var url = "${webRoot}/clientFundDeposit/toChooseDepositBank?" + params;

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["入账银行", true],
            area: ['60%', '60%'],
            content: [url, 'yes']
        });
    }

    function showImages(applicationId, type) {
        var id = applicationId + type;
        <c:forEach var="info" items="${page.result}">
        if (applicationId == ${info.applicationId}) {
            if ('0' == type) {
                <c:forEach var="imageInfo" items="${info.despositImage}" varStatus="i">
                pictureListWithId("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}",
                    ${i.index}, id);
                </c:forEach>
            }
            if ('1' == type) {
                <c:forEach var="imageInfo" items="${info.bankImage}" varStatus="i">
                pictureListWithId("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}",
                    ${i.index}, id);
                </c:forEach>
            }
        }
        </c:forEach>
        $('#imageList' + id).viewer();
        showImage(id, 0);
    }

    function getDate(strDate) {

        var date = eval('new Date(' + strDate.replace(/\d+(?=-[^-]+$)/,
            function (a) {
                return parseInt(a, 10) - 1;
            }).match(/\d+/g) + ')');

        return date;
    }

    layui.form.render('select');
</script>
</body>
</html>
