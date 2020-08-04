<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>客户佣金套餐</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container" >
    <div class="" style="margin-top: 20px;" >
        <form class="layui-form" id="search-from"  method="post" action="${webRoot}/clientFareSetupLog/list">
            <div class="layui-form-item" >
                <input hidden="hidden" id="clientId" name="clientId" value="${model.clientId}"></input>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-xs-12" style="width:100%">
            <table id="table-list" class="layui-table">
                <thead>
                <tr width="99%">
                    <th >
                      序号
                    </th>
                    <th>修改时间</th>
                    <th>操作人员</th>
                    <th>操作</th>
                    <th>修改前佣金方案</th>
                    <th>修改后佣金方案</th>
                    <th>新方案开始时间</th>
                    <th>新方案结束时间</th>
                    <th>审核状态</th>
                    <th>同步状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr >
                        <td>${i.index+1 }</td>
                        <td> <fmt:formatDate value="${info.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${info.updateUser}</td>
                        <td>
                            ${fns:getCodeName("SEC_OP_FALG",info.opFlag)}
                        </td>
                        <td>${info.lastFareKind}</td>
                        <td>${info.fareKind}</td>
                        <td> <fmt:formatDate value="${info.beginDate}" pattern="yyyy-MM-dd"/></td>
                        <td> <fmt:formatDate value="${info.endDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${fns:getCodeName("SEC_AUDIT_STATUS",info.auditStatus)}</td>
                        <td>${fns:getCodeName("SEC_SYNC_STATUS",info.syncStatus)}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
</body>
</html>