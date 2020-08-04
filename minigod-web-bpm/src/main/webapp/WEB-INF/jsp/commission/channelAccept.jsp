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
        <form class="layui-form" id="search-from" method="post" action="${webRoot}/channelFareSetupLog/acceptList">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 90px">业务编号:</label>
                            <div class="col-xs-7">
                                <input type="text" id="code" name="code" value="${model.code}" placeholder="业务编号"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <button class="layui-btn" type="submit">查询</button>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-xs-12" style="width:100%">
            <table id="table-list" class="layui-table">
                <thead>
                <tr width="90%">
                    <th>
                        序号
                    </th>
                    <th>业务编号</th>
                    <th>标题</th>
                    <th>渠道</th>
                    <th>申请人</th>
                    <th>申请时间</th>
                    <th>审核状态</th>
                    <th>同步时间</th>
                    <th>同步状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr>
                        <td>${i.index+1 }</td>
                        <td>${info.code}</td>
                        <td>
                            <c:choose>
                                <c:when test="${info.opFlag == 0}">
                                    新增渠道
                                </c:when>
                                <c:when test="${info.opFlag == 1}">
                                    修改渠道
                                </c:when>
                            </c:choose>
                        </td>
                        <td>${info.channelName}</td>
                        <td>${info.createUser}</td>
                        <td><fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${fns:getCodeName("SEC_AUDIT_STATUS",info.auditStatus)}</td>
                        <c:if test="${info.syncTime!=null and info.syncTime!=''}">
                            <td><fmt:formatDate value="${info.syncTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        </c:if>
                        <c:if test="${info.syncTime == null || ''==info.syncTime}">
                            <td>无</td>
                        </c:if>
                        <td>${fns:getCodeName("SEC_SYNC_STATUS",info.syncStatus)}</td>
                        <td>
                                <%--<button class="layui-btn layui-btn-warm layui-btn-mini" onclick="showImg('${info.instanceId}');">查看流程图</button>--%>

                            <c:if test="${info.auditStatus == 1}">
                                <shiro:hasPermission name="channelFareSetupLog:reject">
                                <button class="layui-btn layui-btn-danger layui-btn-small" type="button"
                                        onclick="showFlowEnd('${info.busId}');">
                                    <i class="layui-icon">&#x1007;</i>终止
                                </button>
                                </shiro:hasPermission>
                            </c:if>
                            <button class="layui-btn layui-btn-small" type="button"
                                    onclick="doTaskTab('channelFareSetApprove','${info.busId}','${info.instanceId}')"><i
                                    class="layui-icon">&#xe705;</i>审批记录
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
<script src="${webRoot}/js/activiti/actSumbit.js"></script>
<script>
    function showFlowEnd(busId) {
        url = webRoot + "/channelFareSetupLog/viewReject?busId=" + busId;
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["终止流程", true],
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
    }

    /**
     * 流程信息
     */
    function showImg(instanceId) {
        var url = webRoot + "/act/deal/showFlowImg?processInstanceId=" + instanceId + "&r=" + new Date().getTime();
        var html = "<img src ='" + url + "'/>";
        //弹框层
        layer.open({
            type: 1,
            area: ['70%', '70%'], //宽高
            content: html,
            title: ['查看流程图', true],
            shadeClose: true, //开启遮罩关闭
        });
    }

    /**
     * 终止
     * @param actKey
     * @param busId
     */
    function flowEnd(id, busId, taskId, defId, instanceId) {

        var params = "id=" + id + "&busId=" + busId + "&taskId=" + taskId + "&defId=" + defId + "&instanceId=" + instanceId;
        var url = "${webRoot}/channelFareSetupLog/viewReject";

        confirm("确认终止流程吗?", function () {
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    alert(result, function () {
                        window.location.reload();
                    })
                } else {
                    alertMsg(result.msg);
                }
            }, "json");
        });
    }

</script>
</html>