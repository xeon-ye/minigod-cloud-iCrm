<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>

<html lang="en">
<head>
    <title>待开户列表</title>
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
        <form class="layui-form" id="search-from" method="post" action="${webRoot}/customer/waitOpenList/">
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">预约号:</label>
                <div class="layui-input-block">
                    <input type="text" name="applicationId" value="${queryCondition.applicationId}" placeholder="请输入预约号"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">小神号:</label>
                <div class="layui-input-block">
                    <input type="text" name="userId" value="${queryCondition.userId}" placeholder="请输入小神号"
                           class="layui-input">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">姓名:</label>
                <div class="layui-input-block">
                    <input type="text" name="clientName" value="${queryCondition.clientName}" placeholder="请输入姓名"
                           class="layui-input">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">开始日期:</label>
                <div class="layui-input-block">
                    <input type="text" id="applicationTimeStart" name="applicationTimeStart"
                           value="${queryCondition.applicationTimeStart}" class="layui-input" placeholder="请选择申请开始日期">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">结束日期:</label>
                <div class="layui-input-block">
                    <input type="text" id="applicationTimeEnd" name="applicationTimeEnd"
                           value="${queryCondition.applicationTimeEnd}" class="layui-input" placeholder="请选择申请结束日期">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">证件类型:</label>
                <div class="layui-input-block">
                    <tag:select initSelectedKey="${queryCondition.idKind}" nameKey="AO_ID_KIND" name="idKind"
                                isAddDefaltOption="true"></tag:select>
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">证件号:</label>
                <div class="layui-input-block">
                    <input type="text" name="idNo" value="${queryCondition.idNo}" placeholder="请输入证件号"
                           class="layui-input">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">证券手机号:</label>
                <div class="layui-input-block">
                    <input type="text" name="phoneNumber" value="${queryCondition.phoneNumber}" placeholder="请输入证券手机号"
                           class="layui-input">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">渠道:</label>
                <div class="layui-input-block">
                    <input type="text" name="sourceChannelId" value="${queryCondition.sourceChannelId}"
                           placeholder="请输入渠道"
                           class="layui-input">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">账户等级:</label>
                <div class="layui-input-block">
                    <tag:select initSelectedKey="${queryCondition.accountLevel}" nameKey="AO_OPEN_ACCOUNT_LEVEL"
                                name="accountLevel" isAddDefaltOption="true"></tag:select>
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">客户帐号:</label>
                <div class="layui-input-block">
                    <input type="text" name="clientId" value="${queryCondition.clientId}" placeholder="请输入客户帐号"
                           class="layui-input">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">开户途径:</label>
                <div class="layui-input-block">
                    <tag:select initSelectedKey="${queryCondition.openAccountType}" nameKey="AO_OPEN_ACCOUNT_TYPE"
                                name="openAccountType" isAddDefaltOption="true" initCludeKey="1,4,5,6,2"></tag:select>
                </div>
            </div>
            <div class="layui-form-item" style="padding: 10px 50px;">
                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                        class="layui-icon">&#x1002;</i>重置
                </button>
                <shiro:hasPermission name="waitOpenAcc:exp">
                    <button class="layui-btn layui-btn-danger" type="button" id="export" onclick="exportExcel()"><i
                            class="layui-icon">&#xe601;</i>导出
                    </button>
                </shiro:hasPermission>
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
                <th>证件类型</th>
                <th>证件号</th>
                <th>渠道</th>
                <th>手机号码</th>
                <th>开户状态</th>
                <th>账户等级</th>
                <th>是否加急</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.result}" var="info" varStatus="i">
                <tr>
                    <td>
                        <input name="selectFlag" type="checkbox"
                               value="${info.customerAccountOpenApplyEntity.applicationId}"/>
                    </td>
                    <td>${info.customerAccountOpenInfoEntity.applicationId} </td>
                    <td><fmt:formatDate value="${info.customerAccountOpenInfoEntity.applicationTime}"
                                        pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>
                        <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 0}">未知</a></c:if>
                        <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 1 && (queryCondition.openAccountType ==null || queryCondition.openAccountType ==1)}">互联网开户</a></c:if>
                        <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 1 && info.customerAccountOpenInfoEntity.bankType == 0 && queryCondition.openAccountType == 4}">香港银行卡</a></c:if>
                        <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 1 && info.customerAccountOpenInfoEntity.bankType == 1 && queryCondition.openAccountType == 5}">大陆银行卡</a></c:if>
                        <c:if test="${queryCondition.openAccountType==6}">SZCA电子证书</c:if>
                        <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 2}">线下开户</a></c:if>
                        <c:if test="${info.customerAccountOpenInfoEntity.openAccountType == 3}">BPM</a></c:if>
                    </td>
                    <td>${info.customerAccountOpenInfoEntity.userId} </td>
                    <td>${info.customerAccountOpenInfoEntity.clientName}</td>
                    <td>${fns:getCodeName("AO_ID_KIND",info.customerAccountOpenInfoEntity.idKind)}</td>
                    <td>${info.customerAccountOpenInfoEntity.idNo}</td>
                    <td>${info.customerAccountOpenInfoEntity.sourceChannelId}</td>
                    <td>${info.customerAccountOpenInfoEntity.phoneNumber}</td>
                    <td>${fns:getCodeName("AO_OPEN_ACCOUNT_STATUS",info.customerAccountOpenApplyEntity.applicationStatus)}</td>
                    <td>${fns:getCodeName("AO_OPEN_ACCOUNT_LEVEL",info.customerAccountOpenInfoEntity.accountLevel)}</td>
                    <td>
                        <c:if test="${info.customerAccountOpenApplyEntity.fireAid==0}">未加急</c:if>
                        <c:if test="${info.customerAccountOpenApplyEntity.fireAid==1}"><span
                                style="color: red">已加急</span></c:if>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${info.customerAccountOpenInfoEntity.openAccountType == 2}">
                                <button class="layui-btn layui-btn-mini" type="button"
                                        onclick="doTaskTab('customerAccountOpenApplicationOffline','${info.customerAccountOpenInfoEntity.applicationId}',
                                                '${info.customerAccountOpenApplyEntity.instanceId}','','${info.customerAccountOpenApplyEntity.defid}','','${info.customerAccountOpenApplyEntity.assignDrafter}','${info.customerAccountOpenApplyEntity.currentNode}');">
                                    <i class="layui-icon">&#xe60a;</i>查看
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button class="layui-btn layui-btn-mini" type="button"
                                        onclick="doTaskTab('customerAccountOpenApplication','${info.customerAccountOpenInfoEntity.applicationId}',
                                                '${info.customerAccountOpenApplyEntity.instanceId}','','${info.customerAccountOpenApplyEntity.defid}','','${info.customerAccountOpenApplyEntity.assignDrafter}','${info.customerAccountOpenApplyEntity.currentNode}');">
                                    <i class="layui-icon">&#xe60a;</i>查看
                                </button>
                            </c:otherwise>
                        </c:choose>
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

<script>
    function doTaskTab(actKey, busId, instanceId, taskId, defid, nodeType, dealId, taskName) {

        var url = "${webRoot}/act/deal/flowInfoTab?flag=1&actKey=" + actKey + "&busId=" + busId + "&instanceId=" + instanceId
            + "&taskId=" + taskId + "&defId=" + defid + "&nodeType=" + nodeType + "&dealId=" + dealId + "&taskName=" + taskName;
        //弹框层
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


    layui.laydate.render({
        elem: '#applicationTimeStart' //指定元素
    });
    layui.laydate.render({
        elem: '#applicationTimeEnd' //指定元素
    });

    // 导出excel
    function exportExcel() {

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
        if (count < 1) {
            alert("请选择用户！");
            return;
        } else {
            confirm("确定要导出用户数据吗?"+applicationIds, function () {
                window.location.href = '${webRoot}/customer/waitOpenAcctListExp?applicationIds=' + applicationIds;
            });
        }

    }

    $("#refresh").click(function () {
        window.location.reload();
    })

    /**
     * 全选按钮
     */
    $(function () {
        $("#checkAll").click(function () {
            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
        });
    });

    //加急处理
    function fireAid() {
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
        if (count < 1) {
            alert("请选择行！");
            return;
        } else {
            confirm("确定要加急办理吗?", function () {
                var params = {
                    'applicationIds': applicationIds
                };
                var url = "${webRoot}/customer/fireAidTask";
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
    }

    layui.form.render('select');
</script>
</html>