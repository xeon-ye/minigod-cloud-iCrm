<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<br class="row">

        <table id="table-list" class="layui-table">
            <thead>
            <tr>
                <th style="width:180px">开始时间</th>
                <th style="width:180px">结束时间</th>
                <th style="width:90px">流程节点</th>
                <th style="width:200px">审批结果</th>
                <th >审批意见</th>
                <th style="width:180px">操作员</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="info" items="${taskLogs}" varStatus="i">
                <tr id="log_${info.id }">
                    <td><fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${info.dealTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${info.taskName }</td>
                    <td>${fns:getCodeName("act_task_result",info.appAction)}</td>
                    <td>${info.appOpinion }</td>
                    <td>${info.dealName }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <br/><br/>
        <b>出金审核信息</b>
        <table id="table-his-list" class="layui-table">
            <thead>
            <tr>
                <th style="width:180px">开始时间</th>
                <th style="width:180px">结束时间</th>
                <th style="width:90px">流程节点</th>
                <th style="width:200px">审批结果</th>
                <th >审批意见</th>
                <th style="width:180px">操作员</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="info" items="${tasklogHis}" varStatus="i">
                <tr id="log_${info.id }">
                    <td><fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${info.dealTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${info.taskName }</td>
                    <td>${fns:getCodeName("act_task_result",info.appAction)}</td>
                    <td>${info.appOpinion }</td>
                    <td>${info.dealName }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

</div>
<div class="row">
    <img src ="${webRoot}/act/deal/showFlowImg?processInstanceId=${instanceId}&r=<%=new Date().getTime()%>"/>
</div>