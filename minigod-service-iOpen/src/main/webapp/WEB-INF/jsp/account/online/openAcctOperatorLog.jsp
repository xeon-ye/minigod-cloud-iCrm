<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<div class="row" style="width: 99%">
    <table id="table-list" class="layui-table">
        <thead>
        <tr>
            <th style="width:180px">操作时间</th>
            <th style="width:100px">流程节点</th>
            <th style="width:220px">操作类型</th>
            <th style="width:200px">操作员</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="log" items="${openAcctOperatorLogInfo}" varStatus="i">
            <tr id="log_${log.id }">
                <td><fmt:formatDate value="${log.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${log.currentNode }</td>
                <td>
                    <c:if test="${log.operateType eq 0}">未知</a></c:if>
                    <c:if test="${log.operateType eq 1}">编辑资料</a></c:if>
                    <c:if test="${log.operateType eq 2}">补充材料</a></c:if>
                    <c:if test="${log.operateType eq 3}">上传AML文件</a></c:if>
                    <c:if test="${log.operateType eq 4}">删除AML文件</a></c:if>
                </td>
                <td>${log.createUser }</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>