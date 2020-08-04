<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>客户佣金套餐</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <shiro:hasPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post" action="${webRoot}/clientfarelist/fareList">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 90px">小神号:</label>
                                <div class="col-xs-7">
                                    <input type="text" id="userId" name="userId" value="${model.userId}"
                                           placeholder="请输入小神号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">姓名:</label>
                                <div class="col-xs-7">
                                    <input type="text" name="clientName" value="${model.clientName}" placeholder="请输入姓名"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">渠道号:</label>
                                <div class="col-xs-7">
                                    <input type="text" name="channelId" value="${model.channelId}" placeholder="请输入渠道号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">渠道名称:</label>
                                <div class="col-xs-7">
                                    <input type="text" id="channelName" name="channelName" class="form-control"
                                           style="cursor:pointer;" onclick="menuTree();" readonly="readonly"
                                           value="${model.channelName}" placeholder="请选择渠道"/>
                                    <input hidden type="text" id="checkedChannelId" name="checkedChannelId"
                                           value="${model.checkedChannelId}"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">证券市场:</label>
                                <div class="col-xs-7">
                                    <tag:select nameKey="SEC_EXCHANGE_TYPE" id="exchangeType" name="exchangeType"
                                                initSelectedKey="${model.exchangeType}" isAddDefaltOption="true"
                                                clazz="form-control"/>
                                </div>
                            </td>
                        </tr>
                        <tr>

                            <td>
                                <label class="layui-form-label" style="width: 90px">交易帐号:</label>
                                <div class="col-xs-7">
                                    <input type="text" name="clientId" value="${model.clientId}"
                                           placeholder="请输入交易帐号" class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">资金帐号:</label>
                                <div class="col-xs-7">
                                    <input type="text" name="fundAccount" value="${model.fundAccount}"
                                           placeholder="请输入资金帐号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">费用类型:</label>
                                <div class="col-xs-7">
                                    <tag:select nameKey="SEC_FARE_DICT" id="fareDict" name="fareDict"
                                                initSelectedKey="${model.fareDict}" isAddDefaltOption="true"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">收费方式:</label>
                                <div class="col-xs-7">
                                    <tag:select nameKey="SEC_FEE_TYPE" id="feeType" name="feeType"
                                                initSelectedKey="${model.feeType}" isAddDefaltOption="true"
                                                clazz="form-control"/>
                                </div>
                            </td>

                            <td>
                                <div class="col-xs-12">
                                    <button class="layui-btn " id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                    </button>
                                    <button class="layui-btn layui-btn-warm " type="button" id="refresh">重 置</button>

                                    <shiro:hasPermission name="clientfarelist:exp">
                                        <button class="layui-btn layui-btn-danger" type="button" id="export"
                                                onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                        </button>
                                    </shiro:hasPermission>
                                </div>
                                <div class="col-xs-2">
                                </div>
                            </td>
                        </tr>
                    </table>

                </div>
            </form>
        </shiro:hasPermission>

        <shiro:lacksPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post" action="${webRoot}/clientfarelist/fareList">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 90px">小神号:</label>
                                <div class="col-xs-7">
                                    <input type="text" id="userId" name="userId" value="${model.userId}"
                                           placeholder="请输入小神号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">姓名:</label>
                                <div class="col-xs-7">
                                    <input type="text" name="clientName" value="${model.clientName}" placeholder="请输入姓名"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">渠道号:</label>
                                <div class="col-xs-7">
                                    <input type="text" name="channelId" value="${model.channelId}" placeholder="请输入渠道号"
                                           class="form-control">
                                </div>
                            </td>
                                <%--<td>--%>
                                <%--<label class="layui-form-label" style="width: 90px">渠道:</label>--%>
                                <%--<div class="col-xs-7">--%>
                                <%--<input type="text" id="channelName" name="channelName" class="form-control"--%>
                                <%--style="cursor:pointer;" onclick="menuTree();" readonly="readonly"--%>
                                <%--value="${model.channelName}" placeholder="请选择渠道"/>--%>
                                <%--<input hidden type="text" id="checkedChannelId" name="checkedChannelId"--%>
                                <%--value="${model.checkedChannelId}"/>--%>
                                <%--</div>--%>
                                <%--</td>--%>
                            <td>
                                <label class="layui-form-label" style="width: 90px">证券市场:</label>
                                <div class="col-xs-7">
                                    <tag:select nameKey="SEC_EXCHANGE_TYPE" id="exchangeType" name="exchangeType"
                                                initSelectedKey="${model.exchangeType}" isAddDefaltOption="true"
                                                clazz="form-control"/>
                                </div>
                            </td>
                        </tr>
                        <tr>

                            <td>
                                <label class="layui-form-label" style="width: 90px">交易帐号:</label>
                                <div class="col-xs-7">
                                    <input type="text" name="clientId" value="${model.clientId}"
                                           placeholder="请输入交易帐号" class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">资金帐号:</label>
                                <div class="col-xs-7">
                                    <input type="text" name="fundAccount" value="${model.fundAccount}"
                                           placeholder="请输入资金帐号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">费用类型:</label>
                                <div class="col-xs-7">
                                    <tag:select nameKey="SEC_FARE_DICT" id="fareDict" name="fareDict"
                                                initSelectedKey="${model.fareDict}" isAddDefaltOption="true"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 90px">收费方式:</label>
                                <div class="col-xs-7">
                                    <tag:select nameKey="SEC_FEE_TYPE" id="feeType" name="feeType"
                                                initSelectedKey="${model.feeType}" isAddDefaltOption="true"
                                                clazz="form-control"/>
                                </div>
                            </td>

                            <td>
                                <div class="col-xs-12">
                                    <button class="layui-btn " id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                    </button>
                                    <button class="layui-btn layui-btn-warm " type="button" id="refresh">重 置</button>

                                    <shiro:hasPermission name="clientfarelist:exp">
                                        <button class="layui-btn layui-btn-danger" type="button" id="export"
                                                onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                        </button>
                                    </shiro:hasPermission>
                                </div>
                                <div class="col-xs-2">
                                </div>
                            </td>
                        </tr>
                    </table>

                </div>
            </form>
        </shiro:lacksPermission>
    </div>
    <table id="tableList" lay-filter="table_list" class="layui-table">
        <thead>
        <tr width="99%">
            <th lay-data="{field:'gid',hide:true}" hidden="true">id</th>
            <th lay-data="{field:'num',width:'60',fixed:'left'}">序号</th>
            <th lay-data="{field:'options',minWidth:'150',fixed:'left'}">操作</th>
            <th lay-data="{field:'userId',fixed:'left'}">小神号</th>
            <th lay-data="{field:'clientName'}">姓名</th>
            <th lay-data="{field:'clientId',minWidth:'120'}">交易帐号</th>
            <th lay-data="{field:'fundAccount',minWidth:'120'}">资金帐号</th>
            <th lay-data="{field:'channelId',width:'70'}">渠道</th>
            <th lay-data="{field:'lastFareKind'}">原套餐</th>
            <th lay-data="{field:'fareKind'}">新套餐</th>
            <th lay-data="{field:'updateUser'}">修改人</th>
            <th lay-data="{field:'modifyTime'}">修改时间</th>
            <th lay-data="{field:'auditStatus'}">审核状态</th>
            <th lay-data="{field:'syncStatus'}">同步状态</th>
            <th lay-data="{field:'exchangeType'}">证券市场</th>
            <th lay-data="{field:'fareDict'}">费用类型</th>
            <th lay-data="{field:'feeType'}">收费方式</th>
            <th lay-data="{field:'feeCountFix'}">付费数值</th>
            <th lay-data="{field:'minFare'}">最低费用</th>
            <th lay-data="{field:'maxFare'}">最高费用</th>
            <th lay-data="{field:'beginDate'}">开始日期</th>
            <th lay-data="{field:'endDate'}">结束日期</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="info" varStatus="i">
            <tr>
                <td>${info.fId}</td>
                <td>${i.index+1 }</td>
                <td>
                    <button type="button" class="layui-btn layui-btn-mini"
                            onclick="showFareProList('${info.fareKind}','${info.clientId}','${info.exchangeType}','${info.auditStatus}','${info.fId}');">
                        变更套餐
                    </button>
                    <button type="button" class="layui-btn layui-btn-mini"
                            onclick="showHistory('${info.clientId}');">历史记录
                    </button>
                </td>
                <td>${info.userId}</td>
                <td>${info.clientName}</td>
                <td>${info.clientId}</td>
                <td>${info.fundAccount}</td>
                <td>${info.channelId}</td>
                <td>${info.lastFareKind}</td>
                <td>${info.fareKind}</td>
                <td>${info.updateUser}</td>
                <td>${info.modifyTime}</td>
                <td>${fns:getCodeName("SEC_AUDIT_STATUS",info.auditStatus)}</td>
                <td>${fns:getCodeName("SEC_SYNC_STATUS",info.syncStatus)}</td>
                <td>${fns:getCodeName("SEC_EXCHANGE_TYPE", info.exchangeType)}</td>
                <td>${fns:getCodeName("SEC_FARE_DICT", info.fareDict)}</td>
                <td>${fns:getCodeName("SEC_FEE_TYPE", info.feeType)}</td>
                <td>
                    <c:choose>
                        <c:when test="${info.feeType=='0'}">
                            ${info.feeCount}
                        </c:when>
                        <c:when test="${info.feeType=='1'}">
                            ${info.feeCountFix}
                        </c:when>
                        <c:when test="${info.feeType=='5'}">
                            ${info.feeCountFix}
                        </c:when>
                    </c:choose>
                </td>
                <td>${info.minFare}</td>
                <td>${info.maxFare}</td>
                <td>
                    <fmt:formatDate value="${info.beginDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td>
                    <fmt:formatDate value="${info.endDate}" pattern="yyyy-MM-dd"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <sys:page page="${page}"></sys:page>
</div>
</div>
</div>
<!-- 选择渠道 -->
<div id="menuLayer" style="display: none;padding:10px;">
    <ul id="menuTree" class="ztree"></ul>
</div>
<script src="${webRoot}/js/channel/channel.js"></script>
</body>
<script>
    $(function () {
        layui.use('table', function () {
            var table = layui.table;
            table.init('table_list', { //转化静态表格
                cellMinWidth: 120,
                limit:${page.pageSize}
                , text: {
                    none: '暂无相关数据' //默认：无数据
                }
            });
        });
    });

    var fareKind;

    function ToChildren() {
        return fareKind;
    }

    //展开套餐列表
    function showFareProList(fareKindSelect, clientId, exchangeType, auditStatus, fId) {
        var url = "../clientFareSetup/checkAuditStatus";
        $.ajax({
            type: "POST",
            url: "../clientFareSetup/checkAuditStatus",
            contentType: "application/json",
            dataType: "json",
            data: clientId,
            success: function (r) {
                if (r.code == -2) {
                    alertMsg(r.msg);
                } else {
                    fareKind = fareKindSelect;
                    url = "../marker/farePackageList.html",
                        layer.open({
                            scrollbar: false,
                            type: 2,
                            title: ["客户佣金方案", true],
                            area: ['90%', '70%'], //宽高
                            content: [url, 'yes'],
                            shadeClose: false,
                            btn: ['确认', '取消'],
                            yes: function (index, layero) { //或者使用btn1
                                layer.confirm('确认变更佣金方案?', {
                                    btn: ['是', '否'], btn1: function () {
                                        var fareKind = $(layero).find("iframe")[0].contentWindow.getFareKind();
                                        var param = {
                                            id: fId,
                                            lastFareKind: fareKindSelect,
                                            fareKind: fareKind,
                                            clientId: clientId,
                                            exchangeType: exchangeType
                                        };
                                        if (fareKindSelect == null || fareKindSelect == "") {
                                            var url = "../clientFareSetup/save"
                                        } else {
                                            var url = "../clientFareSetup/update"
                                        }
                                        $.ajax({
                                            type: "POST",
                                            url: url,
                                            contentType: "application/json",
                                            data: JSON.stringify(param),
                                            success: function (r) {
                                                layer.confirm(r.msg, {
                                                    btn: ['确定'] //按钮
                                                }, function () {
                                                    location.reload();
                                                })
                                            }
                                        });
                                    },
                                    btn2: function (index) {
                                        layer.close(index);
                                    }
                                })
                            }
                        });
                }
            }
        });
    }

    /**
     * 历史记录
     */
    function showHistory(clientId) {

        url = "../clientFareSetupLog/list?clientId=" + clientId;

        layer.open({
            scrollbar: false,
            type: 2,
            title: ["客户佣金方案历史记录", true],
            area: ['90%', '90%'], //宽高
            content: [url, 'yes'],
            shadeClose: false
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
//        layer.alert(obj);
        window.location.href = '${webRoot}/clientfarelist/fareListExpExcel?info=&' + obj;
    }

    layui.form.render('select');
</script>

</html>