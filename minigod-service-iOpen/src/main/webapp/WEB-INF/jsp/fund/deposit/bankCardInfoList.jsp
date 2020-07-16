<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>银行卡列表页</title>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
    <script src="${webRoot}/js/jquery.serializejson.js"></script>
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
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 10px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/clientBankCardInfo/list">
            <input type="hidden" name="id" value="${params.id}"/>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">小神号:</label>
                <div class="layui-input-block">
                    <input type="text" name="userId" value="${params.userId}" placeholder="请输入小神号"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">客户账号:</label>
                <div class="layui-input-block">
                    <input type="text" name="clientId" value="${params.clientId}"
                           placeholder="请输入客户账号"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">资金帐号:</label>
                <div class="layui-input-block">
                    <input type="text" name="fundAccount" value="${params.fundAccount}"
                           placeholder="请输入资金帐号"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">证券手机号码:</label>
                <div class="layui-input-block">
                    <input type="text" name="phoneNumber" value="${params.phoneNumber}"
                           placeholder="请输入证券手机号码"
                           class="form-control">
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">开户途径:</label>
                <div class="layui-input-block">
                    <tag:select id="openAccountType" name="openAccountType"
                                nameKey="AO_OPEN_ACCOUNT_TYPE"
                                isAddDefaltOption="true" initSelectedKey="${params.openAccountType}"
                                clazz="form-control" initDidableKey="0"/>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">银行卡类型:</label>
                <div class="layui-input-block">
                    <tag:select id="bankType" name="bankType"
                                nameKey="FUND_BANK_TYPE"
                                isAddDefaltOption="true" initSelectedKey="${params.bankType}"
                                clazz="form-control" initDidableKey="7"/>
                </div>

            </div>
            <div class="layui-inline" style="margin-bottom: 2px;">
                <label class="layui-form-label">银行名称:</label>
                <div class="layui-input-block">
                    <input type="text" name="bankName" value="${params.bankName}"
                           placeholder="请输入银行名称"
                           class="form-control">
                </div>
            </div>

            <label class="layui-form-label">状态:</label>
            <div class="layui-input-block">
                <tag:select id="status" name="status"
                            nameKey="STATUS_EFFECTIVE_INVALID"
                            isAddDefaltOption="true" initSelectedKey="${params.status}"
                            clazz="form-control" initDidableKey="7"/>
            </div>

            <div class="layui-form-item" style="padding: 10px 50px;">
                <button class="layui-btn layui-btn-radius" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                </button>

                <button class="layui-btn layui-btn-warm layui-btn-radius" type="button" id="refresh"><i
                        class="layui-icon layui-btn-radius">&#x1002;</i>重置
                </button>

                <shiro:hasPermission name="clientBankCardInfo:save">
                    <button class="layui-btn layui-btn-radius" type="button" id="add"
                            onclick="toAddTab()"><i
                            class="layui-icon layui-btn-radius">&#xe654;</i>新增
                    </button>
                </shiro:hasPermission>
            </div>
    </div>
    </form>
</div>
<div class="row" style="overflow-x:auto">
    <div class="col-xs-12">
        <table id="table-list" class="layui-table" style="width:100%" lay-size="">
            <thead>
            <tr width="99%">
                <th hidden=true>id</th>
                <th>小神号</th>
                <th>客户帐号</th>
                <th>资金账号</th>
                <th>客户姓名</th>
                <th>手机号码</th>
                <th>开户途径</th>
                <th>银行名称</th>
                <th>银行账户名称</th>
                <th>银行账户号码</th>
                <th>登记时间</th>
                <th>解登时间</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${empty page.result}">
                <tr>
                    <td colspan="13" align="center">暂无数据</td>
                </tr>
            </c:if>
            <c:forEach items="${page.result}" var="info" varStatus="i">
                <tr name="${info.id }">
                    <td hidden=" true">${info.id}</td>
                    <td>${info.userId} </td>
                    <td>${info.clientId}</td>
                    <td>${info.fundAccount}</td>
                    <td>${info.clientName}</td>
                    <td>${info.phoneNumber}</td>
                    <td>
                        <c:if test="${info.openAccountType == 0}">未知</a></c:if>
                        <c:if test="${info.openAccountType == 1 && (params.openAccountType ==null || params.openAccountType ==1)}">互联网开户</a></c:if>
                        <c:if test="${info.openAccountType == 1 && info.bankType == 0 && params.openAccountType == 4}">香港银行卡</a></c:if>
                        <c:if test="${info.openAccountType == 1 && info.bankType == 1 && params.openAccountType == 5}">大陆银行卡</a></c:if>
                        <c:if test="${info.openAccountType == 1 && info.bankType == 1 && params.openAccountType == 6}">SZCA电子证书</a></c:if>
                        <c:if test="${info.openAccountType == 2}">线下开户</a></c:if>
                        <c:if test="${info.openAccountType == 3}">BPM</a></c:if>
                    </td>
                    <td>${info.bankName}</td>
                    <td>${info.bankAccount}</td>
                    <td>${info.bankNo}</td>
                    <td><fmt:formatDate value="${info.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${info.untiedTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>
                            ${fns:getCodeName("STATUS_EFFECTIVE_INVALID", info.status)}
                    </td>
                    <td>
                        <c:if test="${info.status == 0}">
                            已解登
                        </c:if>
                        <c:if test="${info.status == 1}">
                            <div class="layui-btn-group">
                                <button class="layui-btn layui-btn-mini" type="button"
                                        onclick="toEditTab('${info.id}')">
                                    <i class="layui-icon ">&#xe642;</i>编辑
                                </button>
                                <button class="layui-btn layui-btn-mini" type="button"
                                        onclick="untie('${info.id}',0)">
                                    <i class="layui-icon">&#xe64f;</i>解登
                                </button>
                            </div>
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

    // 解登
    function untie(id, status) {
        confirm("解登后的银行卡不可作为出金银行卡，是否确认继续操作？", function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            var params = {
                'id': id,
                'status': status
            };
            var url = "${webRoot}/clientBankCardInfo/untie";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
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
    function toEditTab(cardId) {

        var url = "${webRoot}/clientBankCardInfo/toEditView?flowId=" + cardId;

        var title = "<a><strong>银行卡信息编辑</strong></a>";

        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: [title, true],
            area: ['70%', '70%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 'center'
        });
    }

    // 跳转新增页
    function toAddTab() {

        var url = "${webRoot}/clientBankCardInfo/toAddView";

        var title = "<a><strong>新增银行卡信息</strong></a>";

        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: [title, true],
            area: ['70%', '70%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 'center'
        });
    }

    layui.form.render('select');
</script>
</body>
</html>
