<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>DBS入金参数设置</title>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
    <script src="${webRoot}/js/jquery.serializejson.js"></script>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 10px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/dbsIccDepositConfig/list">
            <input type="hidden" name="id" value="${params.id}"/>
            <%--<div class="layui-form-item" style="margin-bottom: 2px;">--%>
                <%--<label class="layui-form-label" style="width: 120px">币种:</label>--%>
                <%--<div class="layui-input-inline">--%>
                    <%--<tag:select id="ccy" name="ccy"--%>
                                <%--nameKey="SEC_CCY_TYPE"--%>
                                <%--isAddDefaltOption="true" initSelectedKey="${params.ccy}"--%>
                                <%--clazz="form-control" initDidableKey="0"/>--%>
                <%--</div>--%>

                <%--<label class="layui-form-label" style="width: 120px">状态:</label>--%>
                <%--<div class="layui-input-inline">--%>
                    <%--<tag:select id="ccy" name="ccy"--%>
                                <%--nameKey="SEC_CCY_TYPE"--%>
                                <%--isAddDefaltOption="true" initSelectedKey="${params.ccy}"--%>
                                <%--clazz="form-control" initDidableKey="0"/>--%>
                <%--</div>--%>
            <%--</div>--%>
            <div class="layui-form-item" style="margin-bottom: 2px;">

                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <%--<button class="layui-btn layui-btn-radius" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索--%>
                <%--</button>--%>

                <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="refresh"><i
                        class="layui-icon layui-btn-radius">&#x1002;</i>刷新
                </button>

                <shiro:hasPermission name="clientBankCardInfo:save">
                    <button class="layui-btn layui-btn-radius" type="button" id="add"
                            onclick="toAddTab()"><i
                            class="layui-icon layui-btn-radius">&#xe654;</i>设置参数
                    </button>
                </shiro:hasPermission>

            </div>
        </form>
    </div>
    <div class="row" style="overflow-x:auto">
        <div class="col-xs-12">
            <table id="table-list" class="layui-table" style="width:100%">
                <thead>
                <tr width="99%">
                    <th hidden=true>id</th>
                    <th>操作时间</th>
                    <th>币种</th>
                    <th>入金上限金额</th>
                    <th>生效时间</th>
                    <th>失效时间</th>
                    <th>操作员</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty page.result}">
                    <tr>
                        <td colspan="12" align="center">暂无数据</td>
                    </tr>
                </c:if>
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr name="${info.id }">
                        <td hidden=" true">${info.id}</td>
                        <td><fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                                ${fns:getCodeName("SEC_CCY_TYPE", info.ccy)}
                        </td>
                        <td>${info.maxAmount}</td>
                        <td><fmt:formatDate value="${info.validTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><fmt:formatDate value="${info.invalidTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${info.createUser}</td>
                        <td>
                            <c:if test="${info.status == 0}">待生效</c:if>
                            <c:if test="${info.status == 1}">生效中</c:if>
                            <c:if test="${info.status == 2}">已失效</c:if>
                        </td>
                        <td>
                            <button class="layui-btn layui-btn-normal layui-btn-mini" type="button"
                                    onclick="toEditTab('${info.id}',1)">
                                <i class="layui-icon">&#xe642;</i>编辑
                            </button>
                            <c:if test="${info.status == 2}">
                                <button class="layui-btn layui-btn-danger layui-btn-mini layui-btn-disabled" type="button"
                                        onclick="termination('${info.id}',1)">
                                    <i class="layui-icon">&#xe64f;</i>已终止
                                </button>
                            </c:if>
                            <c:if test="${info.status == 1 || info.status == 0}">
                                <button class="layui-btn layui-btn-danger layui-btn-mini" type="button"
                                        onclick="termination('${info.id}',1)">
                                    <i class="layui-icon">&#x1007;</i>终止
                                </button>
                            </c:if>
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

    $("#refresh").click(function () {
        window.location.reload();
    });

    // 终止
    function termination(id,isInvalid) {
        confirm("是否终止？", function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            var params = {
                'id': id,
                'isInvalid': isInvalid
            };
            var url = "${webRoot}/dbsIccDepositConfig/update";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    layer.close(loading);
                    toast(result, function () {
                        // 刷新列表
                        window.location.reload();
                    })
                } else {
                    layer.close(loading);
                    alertMsg(result.msg);
                    // 刷新列表
                    window.location.reload();
                }
            }, "json");
        });
    }

    // 跳转编辑页
    function toEditTab(id) {

        var url = "${webRoot}/dbsIccDepositConfig/toEditView?id=" + id;

        var title = "<a><strong>编辑信息</strong></a>";

        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: [title, true],
            area: ['45%', '75%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 'center'
        });
    }

    // 跳转新增页
    function toAddTab() {

        var url = "${webRoot}/dbsIccDepositConfig/toAddView";

        var title = "<a><strong>设置参数</strong></a>";

        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: [title, true],
            area: ['45%', '75%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 'center'
        });
    }

    layui.form.render('select');
</script>
</body>
</html>
