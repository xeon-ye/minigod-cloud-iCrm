<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>

<html lang="en">
<head>
    <title>领取列表</title>
</head>
<style>
    #table-list td {white-space:nowrap;}
    #table-list th {white-space:nowrap;}
</style>
<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 10px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/donatedStock/receiveList/">
            <div class="layui-form-item" style="margin-bottom: 2px;">

                <label class="layui-form-label" style="width:120px">领取开始时间:</label>
                <div class="layui-input-inline" >
                    <input type="text" id="receiveTimeStart" name="receiveTimeStart" value="${queryCondition.receiveTimeStart}" placeholder="请选择领取开始时间"
                           class="layui-input">
                </div>

                <label class="layui-form-label" style="width:120px">领取结束时间:</label>
                <div class="layui-input-inline">
                    <input type="text"  id="receiveTimeEnd" name="receiveTimeEnd" value="${queryCondition.receiveTimeEnd}" placeholder="请选择领取结束时间"
                           class="layui-input">
                </div>

                <label class="layui-form-label" style="width:100px">活动ID:</label>
                <div class="layui-input-inline">
                    <input type="text" name="activityId" value="${queryCondition.activityId}" placeholder="请输入活动ID"
                           class="layui-input">
                </div>

                <label class="layui-form-label" style="width: 140px">渠道号:</label>
                <div class="layui-input-inline">
                    <input type="text" id="channelId" name="channelId"
                           value="${queryCondition.channelId}" class="layui-input" placeholder="请输入渠道号">
                </div>

                <label class="layui-form-label" style="width: 140px">渠道名称:</label>
                <div class="layui-input-inline">
                    <input type="text" id="channelName" name="channelName"
                           value="${queryCondition.channelName}" class="layui-input" placeholder="请选择渠道名称">
                </div>
            </div>
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <label class="layui-form-label" style="width:120px">小神号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="userId" value="${queryCondition.userId}" placeholder="请输入小神号"
                           class="layui-input" oninput="if(value.length>5)value= value.slice(0,9)">
                </div>
                <label class="layui-form-label" style="width:120px">客户帐号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="clientId" value="${queryCondition.clientId}" placeholder="请输入客户帐号"
                           class="layui-input">
                </div>
                <label class="layui-form-label" style="width: 100px">客户名称:</label>
                <div class="layui-input-inline">
                    <input type="text" name="clientName" value="${queryCondition.clientName}" placeholder="请输入客户名称"
                           class="layui-input">
                </div>
                <label class="layui-form-label" style="width:140px">证券手机号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="phoneNumber" value="${queryCondition.phoneNumber}" placeholder="请输入证券手机号"
                           class="layui-input">
                </div>
                <label class="layui-form-label" style="width: 140px">股票代码:</label>
                <div class="layui-input-inline">
                    <input type="text" name="stockCode" value="${queryCondition.stockCode}"
                           placeholder="请输入股票代码"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item" >
                <label class="layui-form-label" style="width:120px">状态:</label>
                <div class="layui-input-inline">
                    <tag:select initSelectedKey="${queryCondition.applicationStatus}" nameKey="AO_DONATED_STOCK_STATUS"
                                name="applicationStatus" isAddDefaltOption="true"></tag:select>
                </div>
                <label class="layui-form-label" style="width: 120px">预约号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="applicationId" value="${queryCondition.applicationId}"
                           placeholder="请输入预约号"
                           class="layui-input">
                </div>
                <label class="layui-form-label" style="width:100px">开户途径:</label>
                <div class="layui-input-inline">
                    <tag:select initSelectedKey="${queryCondition.bankType}" nameKey="DONATED_STOCK_AO_WAY"
                                name="bankType" isAddDefaltOption="true"></tag:select>
                </div>
                &nbsp;&nbsp;&nbsp;
                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                        class="layui-icon">&#x1002;</i>重
                    置
                </button>
                <shiro:hasPermission name="donatedStockExpExcel:exp">
                    <button class="layui-btn layui-btn-danger" type="button" id="export"
                            onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                    </button>
                </shiro:hasPermission>
            </div>
            <br/>
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <button class="layui-btn layui-btn-radius layui-btn-danger" style="float: right;margin-right: 10px"
                        type="button" onclick="doRejectTaskBatch();"><i
                        class="layui-icon ">&#xe60f;</i>批量拒绝
                </button>
                <button class="layui-btn layui-btn-radius layui-btn-warm" style="float: right;margin-right: 10px"
                        type="button" onclick="doPassTaskBatch();"><i
                        class="layui-icon ">&#x1005;</i>批量同意
                </button>

            </div>
        </form>
    </div>
</div>
<div class="row">
    <div class="col-sm-12" style="width:99%">
        <table id="table-list" class="layui-table">
            <thead>
            <tr width="99%">
                <th style="width: 5px;height: 20px;"><input type="checkbox" id="checkAll"/></th>
                <th>预约号</th>
                <th>领取时间</th>
                <th>渠道号</th>
                <th>渠道名称</th>
                <th>开户途径</th>
                <th>小神号</th>
                <th>客户帐号</th>
                <th>客户名称</th>
                <th>证券手机号</th>
                <th>股票名称</th>
                <th>股票数量</th>
                <th>首次入金HKD</th>
                <th>首转仓HKD</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.result}" var="info" varStatus="i">
                <tr>
                    <td>
                        <c:if test="${info.applicationStatus==1 || info.applicationStatus==2}">
                            <input name="selectFlag" type="checkbox" value="${info.applicationId}"/>
                        </c:if>
                    </td>
                    <td>${info.applicationId}</td>
                    <td><fmt:formatDate value="${info.receiveTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${info.channelId}</td>
                    <td>${info.channelName}</td>
                    <td>${fns:getCodeName("DONATED_STOCK_AO_WAY",info.bankType)}</td>
                    <td>${info.userId}</td>
                    <td>${info.clientId}</td>
                    <td>${info.clientName}</td>
                    <td>${info.phoneNumber}</td>
                    <td>${info.stockName}</td>
                    <td>${info.stockQuantity}</td>
                    <td>${info.firstIncome}</td>
                    <td>${info.firstTransfer}</td>
                    <td>${fns:getCodeName("AO_DONATED_STOCK_STATUS",info.applicationStatus)}</td>
                    <td>
                        <button class="layui-btn layui-btn-mini" type="button"
                                onclick="doTaskTab('donatedStock','${info.applicationId}','${info.instanceId}','','${info.defid}','','${info.assignDrafter}');">
                            <i class="layui-icon">&#xe60a;</i>查看
                        </button>
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

    function doTaskTab(actKey, busId, instanceId, taskId, defid, nodeType, dealId) {

        var url = "${webRoot}/act/deal/flowInfoTab?actKey=" + actKey + "&busId=" + busId + "&instanceId=" + instanceId
            + "&taskId=" + taskId + "&defId=" + defid + "&nodeType=" + nodeType + "&dealId=" + dealId;
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["办理任务", true],
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
    }

    function doPassTaskBatch() {
        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;

        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                ++count;
                applicationIds += ids[i].value + ",";
            }
        }

        if (applicationIds.length > 1) {
            applicationIds = applicationIds.substring(0, applicationIds.length - 1);
        }

        if (applicationIds == "") {
            alertMsg("没有勾选需要记录");
            return;
        }

        confirm("您确定要批量通过吗?", function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            var params = {
                'applicationIds': applicationIds
            };
            var url = "${webRoot}/donatedStock/doPassTaskBatch";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
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

    function doRejectTaskBatch() {
        var ids = document.getElementsByName("selectFlag");
        var applicationIds = '';
        var count = 0;

        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                ++count;
                applicationIds += ids[i].value + ",";
            }
        }

        if (applicationIds.length > 1) {
            applicationIds = applicationIds.substring(0, applicationIds.length - 1);
        }

        if (applicationIds == "") {
            alertMsg("没有勾选需要记录");
            return;
        }

        confirm("您确定要批量拒绝吗?", function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            var params = {
                'applicationIds': applicationIds
            };
            var url = "${webRoot}/donatedStock/doRejectTaskBatch";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
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

    /**
     * 导出excel
     */
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/donatedStock/receiveStockExpExcel?DonatedStockApplicationInfoEntity=&' + obj;
    }

    // 全选按钮事件
    $(function () {
        $("#checkAll").click(function () {
            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
        });
    });

    layui.laydate.render({
        elem: '#receiveTimeStart' //指定元素
    });
    layui.laydate.render({
        elem: '#receiveTimeEnd' //指定元素
    });


    $("#refresh").click(function () {
        window.location.reload();
    })

    layui.form.render('select');
</script>
</html>