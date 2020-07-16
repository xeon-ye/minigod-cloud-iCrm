<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>资金统计图</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <script type="text/javascript" src="${webRoot}/js/echarts.js"></script>
    <script type="text/javascript" src="${webRoot}/js/macarons.js"></script>
    <script type="text/javascript" src="${webRoot}/js/vintage.js"></script>
</head>

<body>
<%--<br>--%>
<%--<div>--%>
    <%--<table width="60%">--%>
        <%--<td>--%>
            <%--&nbsp;&nbsp;<span class="layui-btn layui-btn-small layui-btn-danger" disabled="disabled">维度 : </span>--%>
            <%--<button id="day" type="button" onclick="showGraphic(1);" class="layui-btn layui-btn-small layui-btn-warm">按日</button>--%>
            <%--<button id="month" type="button" onclick="showGraphic(2);" class="layui-btn layui-btn-small  layui-btn-warm">按月</button>--%>
            <%--<div class="col-xs-2">--%>
                <%--<input type="text" id="tradeDate" name="tradeDate" value="${entity.tradeDate}"--%>
                       <%--class="form-control">--%>
            <%--</div>--%>
        <%--</td>--%>
    <%--</table>--%>
<%--</div>--%>
<br>
<div id="main" style="width: 100%;height:600px;"></div>

<script>
//    layui.laydate.render({
//        elem: '#tradeDate' //指定元素
//        ,min: '2017-01-01'
//        ,max: new Date().getTime()
//    });

    $(function () {
        showGraphic(1);
    });

    function showGraphic(dateType) {
        var myChart = echarts.init(document.getElementById('main'));
        myChart.setOption({
            title:{
                text: '交易账号-'+'${entity.clientId}',
                subtext:'姓名-'+'${entity.clientName}'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['人民币', '港币', '美元', '总数']
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable: true,
            xAxis: [
                {
                    name:'时间',
                    type: 'category',
                    boundaryGap: false,
                    data: []
                }
            ],
            yAxis: [
                {
                    name:'金额'
                }
            ],
            series: [
                {
                    name: '人民币',
                    type: 'line',
                    data: []
                },
                {
                    name: '港币',
                    type: 'line',
                    data: []
                },
                {
                    name: '美元',
                    type: 'line',
                    data: []
                },
                {
                    name: '总数',
                    type: 'line',
                    data: []
                }
            ]
        });
        var x_data = [];
        var cny_data = [];
        var khd_data = [];
        var usd_data = [];
        var total_data = [];
        myChart.showLoading();
        $.ajax({
            type: 'get',
            url: '${webRoot}/clientAssetFlowInfo/getClientFundCountGraphic',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            data: {
                clientId:'${entity.clientId}',
                fundAccount: '${entity.fundAccount}',
                tradeDate: '${entity.tradeDate}',
                dateType:dateType
            },
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if(2==result.dateType){
                    $("#month").addClass("layui-btn-warm");
                    $("#day").removeClass("layui-btn-warm");
                }else{
                    $("#month").removeClass("layui-btn-warm");
                    $("#day").addClass("layui-btn-warm");
                }
                var clientName;
                var tradeAccount;
                $.each(result.jsonArray, function (index, item) {
                    x_data.push(item.dateTime);
                    cny_data.push(item.CNYAssets);
                    khd_data.push(item.HKDAssets);
                    usd_data.push(item.USDAssets);
                    total_data.push(item.totalAssets);
                    clientName = item.clientName;
                    tradeAccount = item.tradeAccount;
                });
                myChart.hideLoading();
                myChart.setOption({
                    xAxis: {
                        data: x_data
                    },
                    series: [
                        // 根据名字对应到相应的系列
                        {
                            name: '人民币',
                            data: cny_data
                        },
                        {
                            name: '港币',
                            data: khd_data
                        },
                        {
                            name: '美元',
                            data: usd_data
                        },
                        {
                            name: '总数',
                            data: total_data
                        }
                    ]
                });
            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });
    }

</script>
</body>

</html>