<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>入金凭证处理列表页</title>
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
              action="${webRoot}/clientFundDeposit/checkList">
            <%--<input type="hidden" name="flag" value="${params.flag}"/>--%>
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <label class="layui-form-label" style="width: 120px">开始日期:</label>
                <div class="layui-input-inline">
                    <input type="text" id="beginTime" name="beginTime" value="${params.beginTime}" placeholder="请输入开始日期"
                           class="form-control">
                </div>

                <label class="layui-form-label" style="width: 120px">结束日期:</label>
                <div class="layui-input-inline">
                    <input type="text" id="endTime" name="endTime" value="${params.endTime}" placeholder="请输入结束日期"
                           class="form-control">
                </div>

                <label class="layui-form-label" style="width:120px">小神号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="userId" value="${params.userId}" placeholder="请输入小神号"
                           class="form-control">
                </div>

                <label class="layui-form-label" style="width: 120px">客户帐号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="clientId" value="${params.clientId}"
                           placeholder="请输入客户帐号"
                           class="form-control">
                </div>
                <label class="layui-form-label" style="width: 120px">资金帐号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="fundAccount" value="${params.fundAccount}"
                           placeholder="请输入资金帐号"
                           class="form-control">
                </div>
            </div>
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <label class="layui-form-label" style="width: 120px">证券手机号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="phoneNumber" value="${params.phoneNumber}"
                           placeholder="请输入证券手机号码"
                           class="form-control">
                </div>
                <label class="layui-form-label" style="width: 120px">渠道号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="sourceChannelId" value="${params.sourceChannelId}"
                           placeholder="请输入渠道号"
                           class="form-control">
                </div>
                <label class="layui-form-label" style="width: 120px">存入方式:</label>
                <div class="layui-input-inline">
                    <tag:select id="depositType" name="depositType" nameKey="FUND_BANK_TYPE"
                                isAddDefaltOption="true" initSelectedKey="${params.depositType}"
                                clazz="form-control"/>
                </div>
                <label class="layui-form-label" style="width: 120px">币种:</label>
                <div class="layui-input-inline">
                    <tag:select id="moneyType" name="moneyType" nameKey="SEC_MONEY_TYPE_TRD"
                                isAddDefaltOption="true" initSelectedKey="${params.moneyType}"
                                clazz="form-control" initDidableKey="0,w"/>
                </div>
                <label class="layui-form-label" style="width: 120px">收款银行:</label>
                <div class="layui-input-inline">
                    <tag:select id="benefitBank" name="benefitBank" nameKey="FUND_DEPOSIT_BANK"
                                isAddDefaltOption="true" initSelectedKey="${params.benefitBank}"
                                clazz="form-control"/>
                </div>
            </div>
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <label class="layui-form-label" style="width: 120px">汇款银行:</label>
                <div class="layui-input-inline">
                    <input type="text" name="depositBank" value="${params.depositBank}"
                           placeholder="请输入汇款银行"
                           class="form-control">
                </div>

                <label class="layui-form-label" style="width: 120px">开户途径:</label>
                <div class="layui-input-inline">
                    <tag:select id="openAccountType" name="openAccountType"
                                nameKey="AO_OPEN_ACCOUNT_TYPE"
                                isAddDefaltOption="true" initSelectedKey="${params.openAccountType}"
                                clazz="form-control" initDidableKey="1,w"/>
                </div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
            </div>
            <br/>
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <button class="layui-btn layui-btn-radius layui-btn-warm"
                        style="float: left;margin-right: 10px"
                        type="button" onclick="doPassTaskBatch();"><i
                        class="layui-icon ">&#x1005;</i>批量通过
                </button>
                <button class="layui-btn layui-btn-radius layui-btn-normal"
                        style="float: left;margin-right: 20px"
                        type="button" onclick="doIgnoreBatch('${currentUserId}');"><i
                        class="layui-icon ">&#xe63f;</i>批量忽略
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
    <table id="tableList" lay-filter="table_list" class="layui-table">
        <thead>
        <tr width="99%">
            <th lay-data="{field:'id',hide:true}" hidden="true">id</th>
            <th lay-data="{field:'assignDrafter',hide:true}" hidden="true">assignDrafter</th>
            <th lay-data="{type:'checkbox',unresize:true,fixed:'left'}"></th>
            <th lay-data="{field:'option',align:'center',fixed: 'left'}">操作</th>
            <th lay-data="{field:'applicationTime',minWidth:'160'}">申请时间</th>
            <th lay-data="{field:'userId'}">小神号</th>
            <th lay-data="{field:'clientName'}">客户姓名</th>
            <th lay-data="{field:'clientNameSpell'}">英文名</th>
            <th lay-data="{field:'sex',width:'60'}">性别</th>
            <th lay-data="{field:'phoneNumber',minWidth:'130'}">证券手机号码</th>
            <th lay-data="{field:'openAccountType'}">开户途径</th>
            <th lay-data="{field:'firstDepFlag'}">是否首次入金</th>
            <th lay-data="{field:'isBanding'}">是否已绑定</th>
            <th lay-data="{field:'moneyType'}">币种</th>
            <th lay-data="{field:'depositBalance'}">申请金额</th>
            <th lay-data="{field:'depositBank'}">汇款银行</th>
            <th lay-data="{field:'depositNo',minWidth:'150'}">汇款账号</th>
            <th lay-data="{field:'benefitBank'}">收款银行</th>
            <th lay-data="{field:'sourceChannelId',width:'60'}">渠道</th>
            <th lay-data="{field:'applicationId',align:'center',minWidth:'160'}">流水号</th>
            <th lay-data="{field:'despositImage',align:'center',fixed: 'right'}">客户凭证</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="info" varStatus="i">
            <div hidden id="imageList${info.applicationId}">
                <ul class="docs-pictures"></ul>
            </div>
            <tr name="${info.id}">
                <td hidden="true">${info.id}</td>
                <td hidden="true">${info.assignDrafter}</td>
                <td></td>
                <td>
                    <div class="btn-group">
                        <c:if test="${info.fireAid == 1}">
                            <i class="layui-icon" style="color: red">&#xe756;</i>
                        </c:if>
                        <c:if test="${info.assignDrafter == null or info.assignDrafter == ''}">
                            <button class="layui-btn layui-btn-mini" type="button"
                                    onclick="applyTask('${info.applicationId}','${currentUserId}')">
                                <i class="layui-icon">&#xe604;</i>申领
                            </button>
                        </c:if>
                        <c:if test="${info.assignDrafter == currentUserId}">
                            <button class="layui-btn layui-btn-mini" type="button"
                                    onclick="doTaskTab('fundDepositApplication','${info.applicationId}','${info.instanceId}','','${info.defid}',''
                                            ,'${info.assignDrafter}','${info.currentNode}',
                                            '${fns:getCodeName("FUND_DEPOSIT_STATUS",info.applicationStatus)}')">
                                <i class="layui-icon">&#xe705;</i>办理
                            </button>
                        </c:if>
                    </div>
                </td>
                <td><fmt:formatDate value="${info.applicationTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${info.userId}</td>
                <td>${info.clientName}</td>
                <td>${info.clientNameSpell}</td>
                <td>
                        ${fns:getCodeName("COMMON_SEX", info.sex)}
                </td>
                <td>${info.phoneNumber}</td>
                <td>${info.openAccountType}</td>
                <c:choose>
                    <c:when test="${info.firstDepFlag < 1}">
                        <td>是</td>
                    </c:when>
                    <c:otherwise>
                        <td>否</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${info.isBanding > 0}">
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
                <td>${info.depositBank}</td>
                <td>${info.depositNo}</td>
                <td>
                        ${fns:getCodeName("FUND_DEPOSIT_BANK", info.benefitBank)}
                </td>
                <td>${info.sourceChannelId}</td>
                <td>${info.applicationId}</td>
                <td>
                    <button class="layui-btn layui-btn-mini" type="button"
                            onclick="showImages('${info.applicationId}')">
                        <i class="layui-icon">&#xe60a;</i>客户凭证
                    </button>
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

    $("#refresh").click(function () {
        window.location.reload();
    });

    var applicationIds = [];
    var map = new Map();
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
                for (var i = 0; i < data.length; i++) {    //循环筛选出id
                    applicationIds.push(data[i].applicationId.trim());
                    map.set(data[i].applicationId.trim(), data[i].assignDrafter.trim());
                }
            });

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
        window.location.href = '${webRoot}/clientFundDeposit/export?flag=1&queryCondition=&' + obj;
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

    // 批量办理任务
    function doPassTaskBatch() {

        if (applicationIds.toString() == "") {
            alertMsg("没有勾选需要记录");
            return;
        }

        doPassTask(applicationIds.toString(), '${currentUserId}');
    }

    // 办理任务
    function doPassTask(applicationIds, currentUserId) {
        confirm("您确定要批量处理吗?", function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            var params = {
                'applicationIds': applicationIds,
                'toUserId': currentUserId,
                'actKey': 'fundDepositApplication'
            };
            var url = "${webRoot}/clientFundDeposit/doPassTaskBatch";
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

    // 申领任务
    function applyTask(applicationIds, currentUserId) {

        if (applicationIds.toString() == "") {
            alertMsg("预约号不能为空");
            return;
        }
        confirm("您确定申领此业务吗?", function () {
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

    // 批量忽略
    function doIgnoreBatch(currentUserId) {
        if (applicationIds.toString() == "") {
            alertMsg("没有勾选需要记录");
            return;
        }

        for (var i = 0; i < applicationIds.length; i++) {    //循环筛选出id
            if (currentUserId != map.get(applicationIds[i])) {
                alertMsg("存在未被申领的记录，请先申领");
                return;
            }
        }

        confirm("您确定要批量忽略吗?", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var params = {
                'applicationIds': applicationIds.toString()
            };
            var url = "${webRoot}/clientFundDeposit/doIgnore";
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
