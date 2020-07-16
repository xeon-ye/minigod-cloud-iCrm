<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>汇率查询</title>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/moneyRateInfo/getMoneyRateInfoList">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 100px">货币名称:</label>
                            <div class="col-xs-8">
                                <tag:select id="fromMoneyType" name="fromMoneyType" nameKey="SEC_MONEY_TYPE" isAddDefaltOption="true" initSelectedKey="${params.fromMoneyType}" clazz="form-control"></tag:select>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">转换币种:</label>
                            <div class="col-xs-8">
                                <tag:select id="toMoneyType" name="toMoneyType" nameKey="SEC_MONEY_TYPE" isAddDefaltOption="true" initSelectedKey="${params.toMoneyType}" clazz="form-control" defaltOptionValue="2"></tag:select>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">查询日期:</label>
                            <div class="col-xs-8">
                                <input type="text" id="initDate" name="initDate" value="${params.initDate}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>&nbsp;&nbsp;&nbsp;
                            <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                            <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i class="layui-icon">&#x1002;</i>重
                                置
                            </button>
                            <shiro:hasPermission name="moneyRateListExpExcel:exp">
                                <button class="layui-btn layui-btn-danger" type="button" id="export"
                                        onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                </button>
                            </shiro:hasPermission>
                            <%--<button class="layui-btn layui-btn-danger" type="button" id="import"--%>
                                    <%--onclick="importExcel()"><i class="layui-icon">&#xe62f;</i>导 入--%>
                            <%--</button>--%>
                        </td>
                    </tr>

                </table>

            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-xs-12" style="width:99%">
            <table id="table-list" class="layui-table">
                <thead>
                <tr width="99%">
                    <th>序号</th>
                    <th>货币名称</th>
                    <th>转换币种</th>
                    <th>汇率</th>
                    <th>同步日期</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="moneyRateInfoList" varStatus="i">
                    <tr name="customer_${moneyRateInfoList.id }">
                        <td>${i.index+1 }</td>
                        <td>${fns:getCodeName("SEC_MONEY_TYPE",moneyRateInfoList.fromMoneyType)}</td>
                        <td>${fns:getCodeName("SEC_MONEY_TYPE",moneyRateInfoList.toMoneyType)}</td>
                        <td>${moneyRateInfoList.exchangeRate}</td>
                        <td>${moneyRateInfoList.initDate}</td>
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

    layui.laydate.render({
        elem: '#initDate' //指定元素
    });

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
//        layer.alert(obj);
        window.location.href = '${webRoot}/moneyRateInfo/moneyRateListExpExcel?moneyRateInfoEntity=&' + obj;
    }

    // 导入excel弹层
    function importExcel() {
        var url="${webRoot}/moneyRateInfo/goUploadExcel";
        layer.open({
            scrollbar: false,
            type: 2,
            title : ["从Excel文件导入数据" , true],
            area: ['25%', '30%'],
            content: [url,'no']
        });
    }

    layui.form.render('select');
</script>

</html>