<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<br class="row" style="width: 99%">

        <table id="table-list" class="layui-table">
            <thead>
            <tr>
                <th style="width:180px">开始时间</th>
                <th style="width:180px">结束时间</th>
                <th style="width:90px">流程节点</th>
                <th style="width:120px">审批结果</th>
                <th style="width:300px">审批意见</th>
                <th style="width:400px">退回理由</th>
                <%--<th>操作记录</th>--%>
                <th>操作员</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="log" items="${taskLogs}" varStatus="i">
                <tr id="log_${log.id }">
                    <td><fmt:formatDate value="${log.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${log.dealTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${log.taskName }</td>
                    <td>${fns:getCodeName("act_task_result",log.appAction)}</td>
                    <td>${log.appOpinion }</td>
                    <td>${log.backReasonType}</td>
                    <%--<td>${log.operationRecord}</td>--%>
                    <td>${log.dealName }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    <%--<c:if test="${taskLogsHis !=null}">--%>
        <br/><br/>
        <b>历史流程信息</b>
        <table id="table-his-list" class="layui-table">
            <thead>
            <tr>
                <th style="width:180px">开始时间</th>
                <th style="width:180px">结束时间</th>
                <th style="width:90px">流程节点</th>
                <th style="width:120px">审批结果</th>
                <th style="width:300px">审批意见</th>
                <th style="width:400px">退回理由</th>
                <%--<th>操作记录</th>--%>
                <th>操作员</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="log" items="${taskLogsHis}" varStatus="i">
                <tr id="log_${log.id }">
                    <td><fmt:formatDate value="${log.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${log.dealTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${log.taskName }</td>
                    <td>${fns:getCodeName("act_task_result",log.appAction)}</td>
                    <td>${log.appOpinion }</td>
                    <td>${log.backReasonType}</td>
                    <%--<td>${log.operationRecord}</td>--%>
                    <td>${log.dealName }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    <%--</c:if>--%>

</div>
<div class="row">
    <img src ="${webRoot}/act/deal/showFlowImg?processInstanceId=${instanceId}&r=<%=new Date().getTime()%>"/>
</div>