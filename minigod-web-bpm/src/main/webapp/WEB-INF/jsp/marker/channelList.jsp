<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>渠道信息查询</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post" action="${webRoot}/channelInfo/channelListInfo">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 100px">渠道号:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="channelId" name="channelId" value="${model.channelId}"
                                       placeholder="渠道号"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">渠道名称:</label>
                            <div class="layui-input-inline">
                                <%--<input type="text" id="channelName" name="channelName" class="form-control" style="cursor:pointer;" onclick="menuTree();" readonly="readonly" value="${model.channelName}" placeholder="请选择渠道"/>--%>
                                <%--<input hidden type="text" id="checkedChannelId" name="checkedChannelId" value="${model.checkedChannelId}"/>--%>
                                <input type="text" id="channelName" name="channelName" class="form-control"
                                       value="${model.channelName}" placeholder="请输入渠道名称"/>
                                <input hidden type="text" id="checkedChannelId" name="checkedChannelId" value="${model.checkedChannelId}"/>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">上级渠道:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="parentName" id="parentName" value="${model.parentName}"
                                       placeholder="上级渠道名字"
                                       class="form-control">
                            </div>
                        </td>
                        <td style="align-items: center">
                            <label class="layui-form-label" style="width: 120px"></label>
                                <button class="layui-btn" type="submit" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜索
                                </button>&nbsp;&nbsp;&nbsp;
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>&nbsp;&nbsp;&nbsp;

                            <shiro:hasPermission name="channelInfo:exp">
                                <button class="layui-btn layui-btn-danger" type="button" id="export"
                                        onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                </button>
                            </shiro:hasPermission>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <table id="table-list" class="layui-table" style="width:99%">
                <thead>
                <tr>
                    <th >序号</th>
                    <th >渠道号</th>
                    <th>渠道名称</th>
                    <th>上级渠道</th>
                    <th>佣金方案</th>
                    <th>证券市场</th>
                    <th>付费数值</th>
                    <th>固定费用</th>
                    <th>最高费用</th>
                    <th>最低费用</th>
                    <th>创建人</th>
                    <th>修改人</th>
                    <th>创建时间</th>
                    <th>修改时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr>
                        <td>${i.index+1 }</td>
                        <td>${info.channelId}</td>
                        <td>${info.channelName}</td>
                        <td>${info.parentName}</td>

                        <td>${info.fareKind}</td>
                        <td>${fns:getCodeName("SEC_EXCHANGE_TYPE",info.exchangeType)}</td>
                        <td><fmt:formatNumber  value="${info.balanceRatio}" type="number"   pattern="#,##0.000000#"/></td>
                        <td>${info.feeCountFix}</td>
                        <td>${info.maxFare}</td>
                        <td>${info.minFare}</td>

                        <td>${info.createBy}</td>
                        <td>${info.updateBy}</td>
                        <td>${info.createTime}</td>
                        <td>${info.updateTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
<%--<!-- 选择渠道 -->--%>
<%--<div id="menuLayer" style="display: none;padding:10px;">--%>
    <%--<ul id="menuTree" class="ztree"></ul>--%>
<%--</div>--%>
<%--<script src="${webRoot}/js/channel/channel.js"></script>--%>
</body>

<script>
    /**
     * 导出excel
     */
    function exportExcel() {
//        var channelName = $("#channelName").val();
//        var parentName = $("#parentName").val();
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();

        window.location.href = '${webRoot}/channelInfo/channelExp?userChannelInfoEntity=&' + obj;

    }
    layui.form.render('select');
</script>

</html>