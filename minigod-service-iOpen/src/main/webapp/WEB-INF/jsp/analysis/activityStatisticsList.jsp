<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>活动统计</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;">
        <shiro:hasPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post" action="${webRoot}/activity/activityStatistics">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">小神号:</label>
                                <div class="layui-input-inline">
                                    <input type="number" name="userId" value="${params.userId}" placeholder="请输入小神号"
                                           class="layui-input" oninput="if(value.length>5)value= value.slice(0,9)">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">注册手机号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="regPhoneNumber" value="${params.regPhoneNumber}"
                                           placeholder="请输入手机号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">渠道号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userSourceChannelId" value="${params.userSourceChannelId}"
                                           placeholder="请输入渠道号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">渠道名称:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="channelName" name="sourceChannelName" class="form-control"
                                           style="cursor:pointer;" onclick="menuTree();" readonly="readonly"
                                           value="${params.sourceChannelName}" placeholder="请选择渠道"/>
                                    <input hidden type="text" id="checkedChannelId" name="checkedChannelId"
                                           value="${params.checkedChannelId}"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">来源标识:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="regSource" value="${params.regSource}"
                                           placeholder="请输入来源标识" class="layui-input">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">注册开始时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="regStartTime" name="regStartTime"
                                           value="${params.regStartTime}" placeholder="请选择注册开始时间" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">注册结束时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="regEndTime" name="regEndTime" value="${params.regEndTime}"
                                           placeholder="请选择注册结束时间" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">最后活跃开始时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="lastLoginStartTime" name="lastLoginStartTime"
                                           value="${params.lastLoginStartTime}" placeholder="请选择最后活跃开始时间"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">最后活跃结束时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="lastLoginEndTime" name="lastLoginEndTime"
                                           value="${params.lastLoginEndTime}" placeholder="请选择最后活跃结束时间"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:40px;"></label>
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                </button>&nbsp;
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>
                                &nbsp

                                <shiro:hasPermission name="activity:exp">
                                    <button class="layui-btn layui-btn-danger" type="button" id="export"
                                            onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                    </button>
                                </shiro:hasPermission>
                            </td>
                        </tr>
                    </table>

                </div>
            </form>
        </shiro:hasPermission>

        <shiro:lacksPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post" action="${webRoot}/activity/activityStatistics">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">小神号:</label>
                                <div class="layui-input-inline">
                                    <input type="number" name="userId" value="${params.userId}" placeholder="请输入小神号"
                                           class="layui-input" oninput="if(value.length>5)value= value.slice(0,9)">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">注册手机号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="regPhoneNumber" value="${params.regPhoneNumber}"
                                           placeholder="请输入手机号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">渠道号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userSourceChannelId" value="${params.userSourceChannelId}"
                                           placeholder="请输入渠道号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">来源标识:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="regSource" value="${params.regSource}"
                                           placeholder="请输入来源标识" class="layui-input">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">注册开始时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="regStartTime" name="regStartTime"
                                           value="${params.regStartTime}" placeholder="请选择注册开始时间" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">注册结束时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="regEndTime" name="regEndTime" value="${params.regEndTime}"
                                           placeholder="请选择注册结束时间" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">最后活跃开始时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="lastLoginStartTime" name="lastLoginStartTime"
                                           value="${params.lastLoginStartTime}" placeholder="请选择最后活跃开始时间"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">最后活跃结束时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="lastLoginEndTime" name="lastLoginEndTime"
                                           value="${params.lastLoginEndTime}" placeholder="请选择最后活跃结束时间"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:40px;"></label>
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                </button>&nbsp;
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>
                                &nbsp

                                <shiro:hasPermission name="activity:exp">
                                    <button class="layui-btn layui-btn-danger" type="button" id="export"
                                            onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                    </button>
                                </shiro:hasPermission>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </shiro:lacksPermission>
    </div>

    <div class="row" style="overflow-x:auto">
        <div class="col-sm-12">
            <table id="table-list" class="layui-table" style="width:100%">
                <thead>
                <tr width="99%">
                    <th hidden=true>userId</th>
                    <th>序号</th>
                    <th>注册时间</th>
                    <th>开户时间</th>
                    <th>首次入金日期</th>
                    <th>首次交易日期</th>
                    <th>首次入金金额</th>
                    <th>可用积分</th>
                    <th>首次转入日期</th>
                    <th>首次转入金额</th>
                    <th>小神号</th>
                    <%--<th>注册手机号码</th>--%>
                    <th>来源标识</th>
                    <th>渠道号</th>
                    <th>最后活跃时间</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty page.result}">
                    <tr>
                        <td colspan="23" align="center">暂无数据</td>
                    </tr>
                </c:if>
                <c:if test="${page.result!= null && fn:length(page.result) > 0}">
                    <c:forEach items="${page.result}" var="info" varStatus="i">
                        <tr>
                            <td>${i.index+1 }</td>
                            <td><fmt:formatDate value="${info.regTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td><fmt:formatDate value="${info.openAccountTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td><fmt:formatDate value="${info.firstDepositDate}" pattern="yyyy-MM-dd"/></td>
                            <td><fmt:formatDate value="${info.firstTradeDate}" pattern="yyyy-MM-dd"/></td>
                            <td>${info.firstDepositBalance}</td>
                            <td>${info.availablePoints}</td>
                            <td><fmt:formatDate value="${info.firstTransferDate}" pattern="yyyy-MM-dd"/></td>
                            <td>${info.firstTransferBalance} </td>
                            <td>${info.userId} </td>
                                <%--<td>${info.regPhoneNumber} </td>--%>
                            <td>${info.regSource} </td>
                            <td>${info.userSourceChannelId} </td>
                            <td><fmt:formatDate value="${info.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
    <sys:page page="${page}"></sys:page>
</div>
<!-- 选择渠道 -->
<div id="menuLayer" style="display: none;padding:10px;">
    <ul id="menuTree" class="ztree"></ul>
</div>
</body>

<script>
    /**
     * 导出excel
     */
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/activity/activityStatisticsExp?activityStatisticsEntity=&' + obj;
    }

    layui.laydate.render({
        elem: '#regStartTime' //指定元素
    });
    layui.laydate.render({
        elem: '#regEndTime' //指定元素
    });
    layui.laydate.render({
        elem: '#lastLoginStartTime' //指定元素
    });
    layui.laydate.render({
        elem: '#lastLoginEndTime' //指定元素
    });
</script>
<script src="${webRoot}/js/channel/channel.js"></script>
</html>