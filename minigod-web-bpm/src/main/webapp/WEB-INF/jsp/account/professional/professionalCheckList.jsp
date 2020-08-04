<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>

<html lang="en">
<head>
    <title>专业投资者审核列表页</title>
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
    <div class="" style="margin-top: 10px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/professionalInvestor/checkList">
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label" >申请开始日期:</label>
                <div class="layui-input-block">
                    <input type="text" id="applyDateSt" name="applyDateSt" value="${params.applyDateSt}"
                           placeholder="请输入开始日期"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label" >申请结束日期：</label>
                <div class="layui-input-block">
                    <input type="text" id="applyDateEd" name="applyDateEd" value="${params.applyDateEd}"
                           placeholder="请输入结束日期"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label" >小神号:</label>
                <div class="layui-input-block">
                    <input type="text" name="userId" value="${params.userId}" placeholder="请输入小神号"
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
                <label class="layui-form-label" 100px">客户姓名:</label>
                <div class="layui-input-block">
                    <input type="text" name="clientName" value="${params.clientName}"
                           placeholder="请输入客户姓名"
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
                <label class="layui-form-label" >审核状态:</label>
                <div class="layui-input-block">
                    <tag:select id="applicationStatus" name="applicationStatus"
                                nameKey="PROFESSIONAL_APPLY_STATUS"
                                initCludeKey="1,2"
                                isAddDefaltOption="true" initSelectedKey="${params.applicationStatus}"
                                clazz="form-control"/>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label" >证券手机号:</label>
                <div class="layui-input-block">
                    <input type="text" name="phoneNumber" value="${params.phoneNumber}"
                           placeholder="请输入证券手机号码"
                           class="form-control">
                </div>

            </div>
            <div class="layui-form-item" style="padding: 10px 50px;">
                <button class="layui-btn layui-btn-radius" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                </button>
                <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="refresh"><i
                        class="layui-icon layui-btn-radius">&#x1002;</i>重置
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
    <table id="tableList" lay-filter="table_list" class="layui-table" lay-size="">
        <thead>
        <tr width="99%">
            <th lay-data="{field:'applicationId',hide:true}" hidden="true">applicationId</th>
            <th lay-data="{type:'checkbox',unresize:true,fixed:'left'}"></th>
            <th lay-data="{field:'applicationTime'}">申请日期</th>
            <th lay-data="{field:'userId'}">小神号</th>
            <th lay-data="{field:'clientId'}">客户账号</th>
            <th lay-data="{field:'clientName'}">客户姓名</th>
            <th lay-data="{field:'clientNameSpell'}">英文名</th>
            <th lay-data="{field:'sex',width:'80'}">性别</th>
            <th lay-data="{field:'phoneNumber'}">证券手机号码</th>
            <th lay-data="{field:'applicationStatus'}">审核状态</th>
            <th lay-data="{field:'option',align:'center',fixed: 'right',width:'120'}">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="info" varStatus="i">
            <tr name="${info.id}">
                <td hidden="true">${info.applicationId}</td>
                <td></td>
                <td><fmt:formatDate value="${info.applyTime}" pattern="yyyy-MM-dd"/></td>
                <td>${info.userId}</td>
                <td>${info.clientId}</td>
                <td>${info.clientName}</td>
                <td>${info.clientNameSpell}</td>
                <td>${fns:getCodeName("COMMON_SEX", info.sex)}</td>
                <td>${info.phoneNumber}</td>
                <td>${fns:getCodeName("PROFESSIONAL_APPLY_STATUS", info.applicationStatus)}</td>
                <td>
                    <c:if test="${info.assignDrafter == null or info.assignDrafter == ''}">
                        <button class="layui-btn layui-btn-mini" type="button"
                                onclick="applyTask('${info.applicationId}','${currentUserId}')">
                            <i class="layui-icon">&#xe604;</i>申领
                        </button>
                    </c:if>
                    <c:if test="${info.assignDrafter == currentUserId}">
                        <button class="layui-btn layui-btn-mini" type="button"
                                onclick="doTaskTab('professionalApplication','${info.applicationId}','${info.instanceId}','','${info.defid}',''
                                        ,'${info.assignDrafter}','${info.currentNode}',
                                        '${fns:getCodeName("PROFESSIONAL_APPLY_STATUS",info.applicationStatus)}')">
                            <i class="layui-icon">&#xe705;</i>办理
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

    var applicationIds = [];
    $(function () {
        layui.use('table', function () {
            var table = layui.table;

            table.init('table_list', { //转化静态表格
                cellMinWidth: 200,
                limit:${page.pageSize}
                , text: {
                    none: '暂无相关数据' //默认：无数据
                }
            });

            table.on('checkbox(table_list)', function (obj) {
                var checkStatus = table.checkStatus('tableList');
                var data = checkStatus.data;
                applicationIds = [];
                for (var i = 0; i < data.length; i++) {    //循环筛选出id
                    applicationIds.push(data[i].applicationId.trim());
                }
            });

        });
    });

    $("#refresh").click(function () {
        window.location.reload();
    });

    // 办理任务
    function doTaskTab(actKey, busId, instanceId, taskId, defid, nodeType, dealId, taskName, applicationStatus) {

        var url = "${webRoot}/act/deal/flowInfoTab?flag=1&actKey=" + actKey + "&busId=" + busId + "&instanceId=" + instanceId
            + "&taskId=" + taskId + "&defId=" + defid + "&nodeType=" + nodeType + "&dealId=" + dealId + "&taskName=" + taskName;

        var title = "<a><strong>审核详情页-" + applicationStatus + "</strong></a>";

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

        if (applicationIds.toString() == "") {
            alertMsg("预约号不能为空");
            return;
        }
        confirm("您确定申领此业务吗?", function () {
            var params = {
                'applicationIds': applicationIds.toString()
            };
            var url = "${webRoot}/professionalInvestor/batchApplyTaskHandle";
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

        if (applicationIds.toString() == "") {
            alertMsg("没有勾选需要记录");
            return;
        }

        applyTask(applicationIds.toString(), '${currentUserId}', '');
    }

    // 批量释放办理
    function deliverApplyTask() {
        if (applicationIds.toString() == "") {
            alertMsg("没有勾选需要记录");
            return;
        }
        confirm("您确定释放此业务吗?", function () {
            var params = {
                'applicationIds': applicationIds.toString()
            };
            var url = "${webRoot}/professionalInvestor/deliverApplyTask";
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

    //申请日期
    layui.laydate.render({
        elem: '#applyDateSt'
    });
    layui.laydate.render({
        elem: '#applyDateEd'
    });

    layui.form.render('select');
</script>
</body>
</html>
