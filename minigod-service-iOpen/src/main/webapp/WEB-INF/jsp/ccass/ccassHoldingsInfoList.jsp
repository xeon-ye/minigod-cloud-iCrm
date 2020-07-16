<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>CCASS参与者持仓信息列表</title>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/ccassHoldings/getCcassHoldingsInfoList">
            <div class="layui-form-item">
                <div class="layui-form-item" style="margin-bottom: 2px;">
                    <input type="hidden" name="participantId" value="${params.participantId}"
                           class="layui-input">
                    <td>
                        <label class="layui-form-label" style="width:100px">股票代码:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="stockCode" value="${params.stockCode}" placeholder="请输入股票代码"
                                   class="layui-input">
                        </div>
                    </td>
                    <td>
                        <label class="layui-form-label" style="width:100px">股票名称:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="stockNameEn" value="${params.stockNameEn}"
                                   placeholder="请输入股票名称"
                                   class="layui-input">
                        </div>
                    </td>
                    <td>
                        <label class="layui-form-label" style="width:120px">持股变动日期:</label>
                        <div class="layui-input-inline">
                            <input type="text" id="holdDate" name="holdDate" value="${params.holdDate}"
                                   placeholder="请输入持股变动日期"
                                   class="layui-input">
                        </div>
                    </td>
                    <td>
                        <label class="layui-form-label" style="width:100px">更新日期:</label>
                        <div class="layui-input-inline">
                            <input type="text" id="updateDate" name="updateDate" value="${params.updateDate}"
                                   placeholder="请输入更新日期"
                                   class="layui-input">
                        </div>
                    </td>
                    <td>
                        <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                        <%--<button class="layui-btn layui-btn-warm" type="button" id="refresh"><i class="layui-icon">&#x1002;</i>重--%>
                        <%--置--%>
                        <%--</button>--%>

                        <shiro:hasPermission name="ccassParticiInfoListExpExcel:exp">
                            <button class="layui-btn layui-btn-danger" type="button" id="export"
                                    onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                            </button>
                        </shiro:hasPermission>
                        <%--<button class="layui-btn layui-btn-danger" type="button" id="import"--%>
                        <%--onclick="importExcel()"><i class="layui-icon">&#xe62f;</i>导 入--%>
                        <%--</button>--%>
                    </td>

                </div>

            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-xs-12" style="width:99%">
            <table id="table-list" class="layui-table">
                <thead>
                <tr width="99%">
                    <th>序号</th>
                    <th>股票代码</th>
                    <th>股票名称</th>
                    <th>持股数量</th>
                    <th>持股市值</th>
                    <th>持股比例</th>
                    <th>持股变动日期</th>
                    <th>更新日期</th>
                    <%--<th>创建时间</th>--%>
                    <%--<th>更新时间</th>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="ccassHoldingsInfoList" varStatus="i">
                    <tr name="ccassParticiInfo_${ccassHoldingsInfoList.id }">
                        <td>${i.index+1 }</td>
                        <td>${ccassHoldingsInfoList.stockCode}</td>
                        <td>${ccassHoldingsInfoList.stockNameEn}</td>
                        <td>${ccassHoldingsInfoList.stockHolding}</td>
                        <td>${ccassHoldingsInfoList.stockValue}</td>
                        <td>${ccassHoldingsInfoList.stakePercentage}</td>
                        <td>${ccassHoldingsInfoList.holdDate}</td>
                        <td>${ccassHoldingsInfoList.updateDate}</td>
                            <%--<td>${ccassHoldingsInfoList.createTime}</td>--%>
                            <%--<td>${ccassHoldingsInfoList.updateTime}</td>--%>
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
        elem: '#updateDate' //指定元素
    });

    layui.laydate.render({
        elem: '#holdDate' //指定元素
    });

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
//        layer.alert(obj);
        window.location.href = '${webRoot}/ccassHoldings/ccassHoldingsInfoListExpExcel?ccassHoldingsEntity=&' + obj;
    }

    // 导入excel弹层
    function importExcel() {
        var url = "${webRoot}/moneyRateInfo/goUploadExcel";
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["从Excel文件导入数据", true],
            area: ['25%', '30%'],
            content: [url, 'no']
        });
    }
</script>

</html>