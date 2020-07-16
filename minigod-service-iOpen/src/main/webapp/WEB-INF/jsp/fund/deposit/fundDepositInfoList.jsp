<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>入金记录列表页</title>
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
<style>
    .layui-table-view .layui-form-checkbox.layui-btn-disabled[lay-skin=primary] i,
    .layui-table-view .layui-form-checkbox.layui-checkbox-disbaled[lay-skin=primary] i {
        background-color: #e9e9e9;
        border-color: #e9e9e9;
    }
</style>
<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 10px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/clientFundDeposit/list">
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">申请日期:</label>
                <div class="layui-input-block">
                    <input type="text" id="beginTime" name="beginTime" value="${params.beginTime}" placeholder="请输入开始日期"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">申请日期:</label>
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

                <label class="layui-form-label">客户帐号:</label>
                <div class="layui-input-block">
                    <input type="text" name="clientId" value="${params.clientId}"
                           placeholder="请输入客户帐号"
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
                <label class="layui-form-label">证券手机号:</label>
                <div class="layui-input-block">
                    <input type="text" name="phoneNumber" value="${params.phoneNumber}"
                           placeholder="请输入证券手机号码"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">渠道号:</label>
                <div class="layui-input-block">
                    <input type="text" name="sourceChannelId" value="${params.sourceChannelId}"
                           placeholder="请输入渠道号"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">存入方式:</label>
                <div class="layui-input-block">
                    <tag:select id="depositType" name="depositType" nameKey="FUND_BANK_TYPE"
                                isAddDefaltOption="true" initSelectedKey="${params.depositType}"
                                clazz="form-control"/>
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
                <label class="layui-form-label">状态:</label>
                <div class="layui-input-block">
                    <tag:select id="applicationStatus" name="applicationStatus"
                                nameKey="FUND_DEPOSIT_STATUS"
                                isAddDefaltOption="true" initSelectedKey="${params.applicationStatus}"
                                clazz="form-control" initDidableKey="7"/>
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">开户途径:</label>
                <div class="layui-input-block">
                    <tag:select id="openAccountType" name="openAccountType"
                                nameKey="AO_OPEN_ACCOUNT_TYPE"
                                isAddDefaltOption="true" initSelectedKey="${params.openAccountType}"
                                clazz="form-control" initDidableKey="1,w"/>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">柜台入账日期:</label>
                <div class="layui-input-block">
                    <input type="text" id="entryStTime" name="entryStTime" value="${params.entryStTime}"
                           placeholder="请输入开始日期"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">柜台入账日期:</label>
                <div class="layui-input-block">
                    <input type="text" id="entryEdTime" name="entryEdTime" value="${params.entryEdTime}"
                           placeholder="请输入结束日期"
                           class="form-control">
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">客户姓名:</label>
                <div class="layui-input-block">
                    <input type="text" name="clientName" value="${params.clientName}"
                           placeholder="请输入客户姓名"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">英文名:</label>
                <div class="layui-input-block">
                    <input type="text" name="clientNameSpell" value="${params.clientNameSpell}"
                           placeholder="请输入英文名"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">最小存入:</label>
                <div class="layui-input-block">
                    <input type="text" name="depositBalanceMin" value="${params.depositBalanceMin}"
                           placeholder="请输入最小存入金额"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">最大存入:</label>
                <div class="layui-input-block">
                    <input type="text" name="depositBalanceMax" value="${params.depositBalanceMax}"
                           placeholder="请输入最大存入金额"
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
        </form>
    </div>
    <table id="tableList" lay-filter="table_list" class="layui-table" lay-size="">
        <thead>
        <tr width="99%">
            <th lay-data="{field:'id',hide:true}" hidden="true">id</th>
            <th lay-data="{field:'status',hide:true}">status</th>
            <th lay-data="{field:'applicationTime',minWidth:'140'}">申请时间</th>
            <th lay-data="{field:'entryTime',minWidth:'100'}">柜台入账日期</th>
            <th lay-data="{field:'userId'}">小神号</th>
            <th lay-data="{field:'clientId',minWidth:'100'}">客户账号</th>
            <th lay-data="{field:'clientName'}">客户姓名</th>
            <th lay-data="{field:'clientNameSpell'}">英文名</th>
            <th lay-data="{field:'openAccountType'}">开户途径</th>
            <th lay-data="{field:'firstDepFlag'}">是否首次入金</th>
            <th lay-data="{field:'moneyType'}">币种</th>
            <th lay-data="{field:'depositBalance'}">申请金额</th>
            <th lay-data="{field:'depositBank'}">汇款银行</th>
            <th lay-data="{field:'depositNo',minWidth:'150'}">汇款账号</th>
            <th lay-data="{field:'benefitBank'}">收款银行</th>
            <th lay-data="{field:'applicationStatus'}">状态</th>
            <th lay-data="{field:'sourceChannelId',width:'60'}">渠道</th>
            <th lay-data="{field:'phoneNumber',minWidth:'130'}">证券手机号码</th>
            <th lay-data="{field:'sex',width:'60'}">性别</th>
            <th lay-data="{field:'despositImage',align:'center',fixed: 'right'}">客户凭证</th>
            <th lay-data="{field:'bankImage',align:'center',fixed: 'right'}">银行凭证</th>
            <th lay-data="{field:'applicationId',align:'center',minWidth:'170',fixed: 'right'}">流水号</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="info" varStatus="i">
            <div hidden id="imageList${info.applicationId}0">
                <ul class="docs-pictures"></ul>
            </div>
            <div hidden id="imageList${info.applicationId}1">
                <ul class="docs-pictures"></ul>
            </div>
            <tr name="${info.id}">
                <td hidden=" true">${info.applicationId}</td>
                <td hidden=" true">${info.applicationStatus}</td>
                <td><fmt:formatDate value="${info.applicationTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <c:if test="${info.applicationStatus == 6}">
                        <fmt:formatDate value="${info.entryTime}" pattern="yyyy-MM-dd"/>
                    </c:if>
                </td>
                <td>${info.userId}</td>
                <td>${info.clientId} </td>
                <td>${info.clientName}</td>
                <td>${info.clientNameSpell}</td>
                <td>${info.openAccountType}</td>
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
                <td>${info.depositBank}</td>
                <td>${info.depositNo}</td>
                <td>${fns:getCodeName("FUND_DEPOSIT_BANK", info.benefitBank)}</td>
                <td>
                        ${fns:getCodeName("FUND_DEPOSIT_STATUS", info.applicationStatus)}
                </td>
                <td>${info.sourceChannelId}</td>
                <td>${info.phoneNumber}</td>
                <td>
                        ${fns:getCodeName("COMMON_SEX", info.sex)}
                </td>
                <td>
                    <button class="layui-btn layui-btn-mini" type="button"
                            onclick="showImages('${info.applicationId}','0')">
                        <i class="layui-icon">&#xe60a;</i>客户凭证
                    </button>
                </td>
                <td>
                    <c:if test="${empty info.bankImage}">
                        <button class="layui-btn layui-btn-mini layui-btn-disabled" type="button">
                            <i class="layui-icon">&#xe60a;</i>银行凭证
                        </button>
                    </c:if>
                    <c:if test="${info.bankImage!= null && fn:length(info.bankImage) > 0}">
                        <button class="layui-btn layui-btn-mini" type="button"
                                onclick="showImages('${info.applicationId}','1')">
                            <i class="layui-icon">&#xe60a;</i>银行凭证
                        </button>
                    </c:if>
                </td>
                <td>
                    <a href="javascript:void(0);" style="display: block;color: blue"
                       onclick="viewTab('fundDepositApplication','${info.applicationId}','${info.instanceId}','','${info.defid}','','${info.assignDrafter}',0);">
                        <c:if test="${info.fireAid == 1}">
                            <i class="layui-icon" style="color: red">&#xe756;</i>
                        </c:if> ${info.applicationId}</a>
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
    layui.laydate.render({
        elem: '#entryStTime' // 指定元素
    });
    layui.laydate.render({
        elem: '#entryEdTime' // 指定元素
    });

    var applicationIds = [];
    var map = new Map();
    $(function () {
        layui.use('table', function () {
            var table = layui.table;
            table.init('table_list', { //转化静态表格
                cellMinWidth: 100,
                limit:${page.pageSize},
                text: {
                    none: '暂无相关数据' //默认：无数据
                }
                , done: function (res, curr, count) {
                    var data = res.data;
                    for (var i = 0; i < data.length; i++) {
                        if (data[i].status != '1' && data[i].status != '3' && data[i].status != '4') {
                            $(".layui-table tr[data-index=" + i + "] input[type='checkbox']").prop('disabled', true);
                            $(".layui-table tr[data-index=" + i + "] input[type='checkbox']").next().addClass('layui-btn-disabled');
                        }
                    }
                }
            });

            table.on('checkbox(table_list)', function (obj) {
                var checkStatus = table.checkStatus('tableList');
                var data = checkStatus.data;
                applicationIds = [];
                for (var i = 0; i < data.length; i++) {    //循环筛选出id
                    if (data[i].status == '1' || data[i].status == '3' || data[i].status == '4') {
                        applicationIds.push(data[i].id.trim());
                        map.set(data[i].id.trim(), data[i].status.trim());
                    }
                }
            });

        });
    });

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

    //加急处理
    function fireAid() {
        if (applicationIds.toString() == "") {
            alertMsg("没有勾选需要记录");
            return;
        }

        confirm("您确定要加急办理吗?", function () {
            var params = {
                'applicationIds': applicationIds.toString()
            };
            var url = "${webRoot}/clientFundDeposit/fireAidTask";
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

    $("#refresh").click(function () {
        window.location.reload();
    });

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled", "true").addClass('layui-btn-disabled');
        setTimeout(function () {
            $("#export").attr("disabled", false).removeClass("layui-btn-disabled");
        }, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/clientFundDeposit/export?queryCondition=&' + obj;
    }

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

    layui.form.render('select');
</script>
</body>
</html>
