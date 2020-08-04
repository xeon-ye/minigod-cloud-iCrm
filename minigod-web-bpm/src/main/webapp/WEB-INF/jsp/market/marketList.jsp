<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>行情列表</title>
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
<div class="main-container" id="main-container" style="width: 99%">
    <div class="" style="margin-top: 10px;">
        <shiro:hasPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post"
                  action="${webRoot}/clientMarketPackageInfo/list">
                <input type="hidden" name="packageType" value="${params.packageType}"/>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">购买日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="beginTime" name="beginTime" value="${params.beginTime}"
                               placeholder="请输入开始日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">结束至</label>
                    <div class="layui-input-block">
                        <input type="text" id="endTime" name="endTime" value="${params.endTime}" placeholder="请输入结束日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">行情套餐:</label>
                    <div class="layui-input-block">
                        <tag:select id="packageName" name="packageName" nameKey="MARKET_TYPE"
                                    isAddDefaltOption="true" initSelectedKey="${params.packageName}"
                                    clazz="form-control"></tag:select>
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">状态:</label>
                    <div class="layui-input-block">
                        <tag:select id="deductionStatus" name="deductionStatus"
                                    nameKey="MARKET_BUY_TYPE"
                                    isAddDefaltOption="true" initSelectedKey="${params.deductionStatus}"
                                    clazz="form-control" initDidableKey="7"></tag:select>
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

                    <label class="layui-form-label">证券手机号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="phoneNumber" value="${params.phoneNumber}" placeholder="请输入证券手机号"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">资金账号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="fundAccount" value="${params.fundAccount}" placeholder="请输入资金账号"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">客户账号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="clientId" value="${params.clientId}" placeholder="请输入客户账号"
                               class="form-control">
                    </div>

                </div>
                <div class="layui-form-item" style="padding: 10px 50px;">
                    <button class="layui-btn layui-btn-radius" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                    </button>
                    <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="refresh"><i
                            class="layui-icon">&#x1002;</i>重
                        置
                    </button>
                    <shiro:hasPermission name="clientMarketPackageInfo:expList">
                        <button class="layui-btn layui-btn-radius layui-btn-danger" type="button" id="export"
                                onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                        </button>
                    </shiro:hasPermission>
                </div>
            </form>
        </shiro:hasPermission>
        <shiro:lacksPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post"
                  action="${webRoot}/clientMarketPackageInfo/list">
                <input type="hidden" name="packageType" value="${params.packageType}"/>

                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">购买日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="beginTime" name="beginTime" value="${params.beginTime}"
                               placeholder="请输入开始日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">结束至</label>
                    <div class="layui-input-block">
                        <input type="text" id="endTime" name="endTime" value="${params.endTime}" placeholder="请输入结束日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">行情套餐:</label>
                    <div class="layui-input-block">
                        <tag:select id="packageName" name="packageName" nameKey="MARKET_TYPE"
                                    isAddDefaltOption="true" initSelectedKey="${params.packageName}"
                                    clazz="form-control"></tag:select>
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">状态:</label>
                    <div class="layui-input-block">
                        <tag:select id="deductionStatus" name="deductionStatus"
                                    nameKey="MARKET_BUY_TYPE"
                                    isAddDefaltOption="true" initSelectedKey="${params.deductionStatus}"
                                    clazz="form-control" initDidableKey="7"></tag:select>
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
                    <label class="layui-form-label">证券手机号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="phoneNumber" value="${params.phoneNumber}" placeholder="请输入证券手机号"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">资金账号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="fundAccount" value="${params.fundAccount}" placeholder="请输入资金账号"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">客户账号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="clientId" value="${params.clientId}" placeholder="请输入客户账号"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-form-item" style="padding: 10px 50px;">
                    <button class="layui-btn layui-btn-radius" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                    </button>
                    <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="refresh"><i
                            class="layui-icon">&#x1002;</i>重置
                    </button>
                    <shiro:hasPermission name="clientMarketPackageInfo:expList">
                        <button class="layui-btn layui-btn-radius layui-btn-danger" type="button" id="export"
                                onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                        </button>
                    </shiro:hasPermission>
                </div>

            </form>
        </shiro:lacksPermission>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <table id="table-list" class="layui-table" lay-size="">
                <thead>
                <tr width="99%">
                    <th hidden=true>id</th>
                    <th>购买日期</th>
                    <th>小神号</th>
                    <th>客户姓名</th>
                    <th>客户帐号</th>
                    <th>资金帐号</th>
                    <th>证券手机号码</th>
                    <th>行情套餐</th>
                    <th>单价HKD</th>
                    <th>有效期(月数)</th>
                    <th>总价HKD</th>
                    <th>扣款状态</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty page.result}">
                    <tr>
                        <td colspan="11" align="center">暂无数据</td>
                    </tr>
                </c:if>
                <c:if test="${page.result!= null && fn:length(page.result) > 0}">
                    <c:forEach items="${page.result}" var="info" varStatus="i">
                        <tr name="${info.id }">
                            <td hidden=" true">${info.id}</td>
                            <td><fmt:formatDate value="${info.buyDate}" pattern="yyyy-MM-dd"/></td>
                            <td>${info.userId}</td>
                            <td>${info.clientName}</td>
                            <td>${info.clientId}</td>
                            <td>${info.fundAccount}</td>
                            <td>${info.phoneNumber}</td>
                            <td>
                                    ${fns:getCodeName("MARKET_TYPE", info.packageName)}
                            </td>
                            <td>${info.packagePrice}</td>
                            <td>${info.validityPeriod}</td>
                            <td>${info.totalCost}</td>
                            <td>
                                    ${fns:getCodeName("MARKET_BUY_TYPE", info.deductionStatus)}
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
</body>
<script>
    layui.laydate.render({
        elem: '#beginTime', // 指定元素
    });

    layui.laydate.render({
        elem: '#endTime', // 指定元素
    });

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled", "true").addClass('layui-btn-disabled');
        setTimeout(function () {
            $("#export").attr("disabled", false).removeClass("layui-btn-disabled");
        }, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/clientMarketPackageInfo/expList?queryCondition=&' + obj;
    }

    $("#refresh").click(function () {
        window.location.reload();
    })

    layui.form.render('select');
</script>
</html>
