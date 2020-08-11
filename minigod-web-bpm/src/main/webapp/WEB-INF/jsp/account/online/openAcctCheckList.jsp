<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>开户审核列表</title>
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
    </style>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 10px;">
        <div class="col-md-12">
            <form class="layui-form" id="search-from" action="${webRoot}/customer/checkList">
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">预约号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="applicationId" value="${queryCondition.applicationId}"
                               placeholder="请输入预约号" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;"><label class="layui-form-label">客户姓名:</label>
                    <div class="layui-input-block">
                        <input type="text" name="clientName" value="${queryCondition.clientName}" placeholder="请输入姓名"
                               class="layui-input">
                    </div>

                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">开始日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="applicationTimeStart" name="applicationTimeStart"
                               value="${queryCondition.applicationTimeStart}"
                               placeholder="请选择开始日期" class="layui-input">
                    </div>

                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">结束日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="applicationTimeEnd" name="applicationTimeEnd"
                               value="${queryCondition.applicationTimeEnd}"
                               placeholder="请选择结束日期" class="layui-input">
                    </div>


                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">渠道:</label>
                    <div class="layui-input-block">
                        <input type="text" name="sourceChannelId" value="${queryCondition.sourceChannelId}"
                               placeholder="请输入渠道" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">证件类型:</label>
                    <div class="layui-input-block">
                        <tag:select nameKey="AO_ID_KIND" id="idKind" name="idKind" clazz="layui-input"
                                    isAddDefaltOption="true" initSelectedKey="${queryCondition.idKind}"/>
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">证件号码:</label>
                    <div class="layui-input-block">
                        <input type="text" name="idNo" value="${queryCondition.idNo}" placeholder="请输入证件号码"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">开户途径:</label>
                    <div class="layui-input-block">
                        <tag:select initSelectedKey="${queryCondition.openAccountType}" nameKey="AO_OPEN_ACCOUNT_TYPE"
                                    name="openAccountType" isAddDefaltOption="true" initCludeKey="1,4,5,6"></tag:select>
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">手机号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="phoneNumber" value="${queryCondition.phoneNumber}"
                               placeholder="请输入证券手机号"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item" style="padding: 10px 50px;">
                    <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                    <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                            class="layui-icon">&#x1002;</i>重 置
                    </button>
                    <button class="layui-btn layui-btn-radius layui-btn-normal " style="float: right;margin-right: 10px"
                            type="button" onclick="applyTaskHandleBatch();"><i
                            class="layui-icon">&#xe61f;</i>批量申领
                    </button>
                    <button class="layui-btn layui-btn-radius layui-btn-danger " style="float: right;margin-right: 20px"
                            type="button" onclick="deliverApplyTask();"><i
                            class="layui-icon ">&#xe60f;</i>释放办理
                    </button>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="width:99%">
            <table id="table-list" class="layui-table" lay-size="">
                <thead>
                <tr width="99%">
                    <th style="width: 5px;height: 20px;"><input type="checkbox" id="checkAll"/></th>
                    <th>预约号</th>
                    <th>申请时间</th>
                    <th>开户途径</th>
                    <th>小神号</th>
                    <th>客户姓名</th>
                    <th>英文名</th>
                    <th>证件类型</th>
                    <th>证件号</th>
                    <th>渠道</th>
                    <th>开户状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr id="application_${info.customerAccountOpenInfoEntity.id }" <c:if
                            test="${info.customerAccountOpenApplyEntity.fireAid == 1}"> style="color: red" </c:if>   >
                        <td><input name="selectFlag" type="checkbox"
                                   value="${info.customerAccountOpenInfoEntity.applicationId}-${info.customerAccountOpenApplyEntity.assignDrafter}"/>
                        </td>
                        <td>${info.customerAccountOpenInfoEntity.applicationId}</td>
                        <td><fmt:formatDate value="${info.customerAccountOpenInfoEntity.applicationTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                        <td>
                            <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 0}">未知</a></c:if>
                            <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 1 && (queryCondition.openAccountType ==null || queryCondition.openAccountType ==1)}">互联网开户</a></c:if>
                            <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 1 && info.customerAccountOpenInfoEntity.bankType == 0 && queryCondition.openAccountType == 4}">香港银行卡</a></c:if>
                            <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 1 && info.customerAccountOpenInfoEntity.bankType == 1 && queryCondition.openAccountType == 5}">大陆银行卡</a></c:if>
                            <c:if test="${queryCondition.openAccountType==6}">SZCA电子证书</c:if>
                            <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 2}">线下开户</a></c:if>
                            <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 3}">BPM</a></c:if>
                        </td>
                        <td>${info.customerAccountOpenInfoEntity.userId}</td>
                        <td>${info.customerAccountOpenInfoEntity.clientName}</td>
                        <td>${info.customerAccountOpenInfoEntity.clientNameSpell}</td>
                        <td>${fns:getCodeName("AO_ID_KIND",info.customerAccountOpenInfoEntity.idKind)}</td>
                        <td>${info.customerAccountOpenInfoEntity.idNo}</td>
                        <td>${info.customerAccountOpenInfoEntity.sourceChannelId}</td>
                        <td>${fns:getCodeName("AO_OPEN_ACCOUNT_STATUS",info.customerAccountOpenApplyEntity.applicationStatus)}</td>
                        <td>
                            <div class=" btn-group ">
                                <c:if test="${info.customerAccountOpenApplyEntity.assignDrafter == null or info.customerAccountOpenApplyEntity.assignDrafter == '' }">
                                    <button class="layui-btn layui-btn-small" type="button"
                                            onclick="applyTask('${info.customerAccountOpenInfoEntity.applicationId}','${currentUserId}')">
                                        <i class="layui-icon">&#xe604;</i>申领
                                    </button>
                                </c:if>
                                <c:if test="${info.customerAccountOpenApplyEntity.assignDrafter == currentUserId}">
                                    <button class="layui-btn layui-btn-small" type="button"
                                        <%--  onclick="doTaskTab('customerAccountOpenApplication','${info.customerAccountOpenInfoEntity.applicationId}','${info.customerAccountOpenApplyEntity.instanceId}')">--%>
                                            onclick="doTaskTab('customerAccountOpenApplication','${info.customerAccountOpenInfoEntity.applicationId}','${info.customerAccountOpenApplyEntity.instanceId}','','${info.customerAccountOpenApplyEntity.defid}',''
                                                    ,'${info.customerAccountOpenApplyEntity.assignDrafter}','${info.customerAccountOpenApplyEntity.currentNode}','${fns:getCodeName("NO_BANK_TYPE",info.customerAccountOpenInfoEntity.bankType)}'
                                                    ,'${fns:getCodeName("AO_OPEN_ACCOUNT_STATUS",info.customerAccountOpenApplyEntity.applicationStatus)}')">
                                        <i class="layui-icon">&#xe705;</i>办理
                                    </button>
                                </c:if>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
</body>
<script src="${webRoot}/js/activiti/actSumbit.js"></script>
<script>

    //申领
    function applyTask(applicationIds, currentUserId) {
        if (applicationIds == "") {
            alertMsg("预约号不能为空");
            return;
        }
        confirm("您确定申领此业务吗?", function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            var params = {
                'applicationIds': applicationIds,
                'toUserId': currentUserId,
                'actKey': 'customerAccountOpenApplication'
            };
            var url = "${webRoot}/customer/applyTaskHandleBatch";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    layer.close(loading);
                    toast(result, function () {
                        // 刷新列表
                        window.location.reload();
                    })

                } else {
                    layer.close(loading);
                    alertMsg(result.msg);
                    // 刷新列表
                    window.location.reload();
                }
            }, "json");
        });
    }

    //批量申请
    function applyTaskHandleBatch() {
        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;
        var existApplicationIds = 0;
        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                ++count;
                if (ids[i].value.split("-")[1] == "") {
                    applicationIds += ids[i].value.split("-")[0] + ",";
                }

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

    //批量释放
    function deliverApplyTask() {
        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;
        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                ++count;
                if (ids[i].value.split("-")[1] != "") {
                    applicationIds += ids[i].value.split("-")[0] + ",";
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
            var url = "${webRoot}/customer/deliverApplyTask";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    alert(result, function () {
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

    function doTaskTab(actKey, busId, instanceId, taskId, defid, nodeType, dealId, taskName, bankType, applicationStatus) {

        var url = "${webRoot}/act/deal/flowInfoTab?flag=2&actKey=" + actKey + "&busId=" + busId + "&instanceId=" + instanceId
            + "&taskId=" + taskId + "&defId=" + defid + "&nodeType=" + nodeType + "&dealId=" + dealId + "&taskName=" + taskName;

        var title = "<a><strong>开户管理-互联网开户-" + applicationStatus + "-" + bankType + "</strong></a>";

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

    /**
     * 日期控件
     */
    layui.laydate.render({
        elem: '#applicationTimeStart' //指定元素
    });
    layui.laydate.render({
        elem: '#applicationTimeEnd' //指定元素
    });

    /**
     * 全选按钮
     */
    $(function () {
        $("#checkAll").click(function () {
            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
        });
    });

    layui.use('form', function () {
        var form = layui.form;

        form.on('radio(filter)', function (data) {

            var params = $("#search-from").serialize();
            window.location.href = "${webRoot}/customer/checkList?params=" + params;

        });

        form.render('radio');
        form.render('select');
    });


</script>

</html>