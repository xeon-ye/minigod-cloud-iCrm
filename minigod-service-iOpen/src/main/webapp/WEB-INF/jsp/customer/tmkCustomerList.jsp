<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>电销客户管理</title>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post" action="${webRoot}/tmkCustomer/getTmkCustomerList">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 120px">分配日期:</label>
                            <div class="col-xs-8">
                                <input type="text" id="distributionDate" name="distributionDate"
                                       value="${params.distributionDate}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:120px">手机号码:</label>
                            <div class="col-xs-8">
                                <input type="text" name="phoneNumber" value="${params.phoneNumber}"
                                       placeholder="请输入手机号码"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 120px">触达情况:</label>
                            <div class="col-xs-8">
                                <tag:select id="contactStatus" name="contactStatus" nameKey="SEC_CONTACT_STATUS"
                                            isAddDefaltOption="true" initSelectedKey="${params.contactStatus}"
                                            clazz="form-control"/>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 120px">添加微信:</label>
                            <div class="col-xs-8">
                                <tag:select id="addWechat" name="addWechat" nameKey="SEC_ADD_WECHAT"
                                            isAddDefaltOption="true" initSelectedKey="${params.addWechat}"
                                            clazz="form-control"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 120px">开户情况:</label>
                            <div class="col-xs-8">
                                <tag:select id="openAccountStatus" name="openAccountStatus"
                                            nameKey="SEC_OPEN_ACCOUNT_STATUS"
                                            isAddDefaltOption="true" initSelectedKey="${params.openAccountStatus}"
                                            clazz="form-control"/>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 120px">入金情况:</label>
                            <div class="col-xs-8">
                                <tag:select id="depositStatus" name="depositStatus" nameKey="SEC_DEPOSIT_STATUS"
                                            isAddDefaltOption="true" initSelectedKey="${params.depositStatus}"
                                            clazz="form-control"/>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 120px">香港银行卡:</label>
                            <div class="col-xs-8">
                                <tag:select id="isBankCard" name="isBankCard" nameKey="YES_NO"
                                            isAddDefaltOption="true" initSelectedKey="${params.isBankCard}"
                                            clazz="form-control"/>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:120px">资产级别:</label>
                            <div class="col-xs-8">
                                <input type="text" name="assetLevel" value="${params.assetLevel}"
                                       placeholder="请输入资产级别"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:120px">负责人:</label>
                            <div class="col-xs-8">
                                <input type="text" name="operator" value="${params.operator}"
                                       placeholder="请输入负责人"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;
                            <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                            </button>
                            <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                                    class="layui-icon">&#x1002;</i>重
                                置
                            </button>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="layui-table-tool-self" style="width:99%">
                <label style="width: 35px"></label>
                <button class="layui-btn layui-btn-radius layui-btn-normal " style="float: right;margin-right: 20px"
                        type="button" onclick="importExcel();"><i
                        class="layui-icon ">&#xe61f;</i>导入
                </button>
            </div>
        </form>
    </div>
    <table id="tableList" lay-filter="table_list" class="layui-table">
        <thead>
        <tr width="99%">
            <th lay-data="{field:'createTime',minWidth:'170'}">分配日期</th>
            <th lay-data="{field:'phoneNumber'}">手机号码</th>
            <th lay-data="{field:'isOpenWechat',minWidth:'120'}">是否开通微信</th>
            <th lay-data="{field:'sex'}">客户性别</th>
            <th lay-data="{field:'stockExperience'}">港美股经验</th>
            <th lay-data="{field:'assetLevel'}">资产级别</th>
            <th lay-data="{field:'remark',width:'150'}">备注</th>
            <th lay-data="{field:'operator'}">负责人</th>
            <th lay-data="{field:'contactStatus'}">触达情况</th>
            <th lay-data="{field:'addWechat'}">添加微信</th>
            <th lay-data="{field:'openAccountStatus'}">开户情况</th>
            <th lay-data="{field:'depositStatus'}">入金情况</th>
            <th lay-data="{field:'isBankCard'}">香港银行卡</th>
            <th lay-data="{field:'contentDescription',minWidth:'200'}">沟通内容记录</th>
            <th lay-data="{field:'updateTime',minWidth:'170'}">更新时间</th>
            <th lay-data="{field:'register',width:'100',fixed:'right'}">操作</th>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="info" varStatus="i">
            <tr>
                <infotd hidden=" true">${info.id}</infotd>
                <td width="170px;"><fmt:formatDate value="${info.createTime}"
                                                   pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td width="120px;">${info.phoneNumber}</td>
                <td>${info.isOpenWechat}</td>
                <td>${info.sex}</td>
                <td>${info.stockExperience}</td>
                <td>${info.assetLevel}</td>
                <td width="150px;">${info.remark}</td>
                <td>${info.operator}</td>
                <td>
                        ${fns:getCodeName("SEC_CONTACT_STATUS", info.contactStatus)}
                </td>
                <td>
                        ${fns:getCodeName("SEC_ADD_WECHAT",info.addWechat)}
                </td>
                <td>
                        ${fns:getCodeName("SEC_OPEN_ACCOUNT_STATUS",info.openAccountStatus)}
                </td>
                <td>
                        ${fns:getCodeName("SEC_DEPOSIT_STATUS",info.depositStatus)}
                </td>
                <td>
                        ${fns:getCodeName("YES_NO",info.isBankCard)}
                </td>
                <td width="220px;">${info.contentDescription}</td>
                <td width="170px;"><fmt:formatDate value="${info.updateTime}"
                                                   pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <button class="layui-btn layui-btn-small" type="button"
                            onclick="register('${info.id}')">
                        <i class="layui-icon">&#xe60a;</i>登记
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
<script>
    layui.form.render('select');

    layui.laydate.render({
        elem: '#distributionDate' //指定元素
    });

    $(function () {
        layui.use('table', function () {
            var table = layui.table;
            table.init('table_list', { //转化静态表格
                cellMinWidth: 120,
                limit:${page.pageSize}
                , text: {
                    none: '暂无相关数据' //默认：无数据
                }
            });
        });
    });

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
//        layer.alert(obj);
        window.location.href = '${webRoot}/clientAssetFlowInfo/assetDetailListExpExcel?clientAssetFlowInfoEntity=&' + obj;
    }

    // 登记
    function register(id) {
        var url = "${webRoot}/tmkCustomer/toRegisterPage?id=" + id;
        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["登记", true],
            area: ['50%', '75%'], // 宽高
            content: [url, 'no']
        });
    }

    // 导入excel弹层
    function importExcel() {
        var url = "${webRoot}/tmkCustomer/toUploadExcel";
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["从Excel文件导入数据", true],
            area: ['35%', '40%'],
            content: [url, 'no']
        });
    }
</script>

</html>