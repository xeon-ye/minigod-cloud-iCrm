<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>图表</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <script type="text/javascript" src="${webRoot}/js/echarts.js"></script>
    <script type="text/javascript" src="${webRoot}/js/macarons.js"></script>
    <script type="text/javascript" src="${webRoot}/js/vintage.js"></script>
</head>

<body>
<div id="main" style="width: 100%;height:600px;"></div>
<br>
<div >

   <table width="60%">
       <td>
           &nbsp;&nbsp;<span class="layui-btn layui-btn-small layui-btn-danger" disabled="disabled">维度 : </span>
           <button type="button" onclick="channelShowViews();" class="layui-btn layui-btn-small layui-btn-warm" >渠道</button>
           <button type="button" onclick="MarkShowViews();" class="layui-btn layui-btn-small  layui-btn-warm" >证券市场</button>
       </td>
       <td>
           <span class="layui-btn layui-btn-small layui-btn-danger" disabled="disabled">指标 : </span>
           <button type="button" onclick="changeBusAmount();" class="layui-btn layui-btn-small" >成交数量</button>
           <button type="button" onclick="changeBusBalance();" class="layui-btn layui-btn-small" >成交金额</button>
           <button type="button" onclick="changeFreeRadio();" class="layui-btn layui-btn-small" >佣金比例</button>
       </td>
   </table>

</div>
<script>

    function channelShowViews() {
        var beginDate = "${info.beginDate}";
        var endDate = "${info.endDate}";
        window.location.href = "${webRoot}/clientTradeFlowInfo/showGraphicView?beginDate="+beginDate+"&endDate="+endDate+"&type='channel_name'";
    }
    function MarkShowViews() {
        var beginDate = "${info.beginDate}";
        var endDate = "${info.endDate}";
        window.location.href = "${webRoot}/clientTradeFlowInfo/showGraphicView?beginDate="+beginDate+"&endDate="+endDate+"&type='exchange_type'";
    }

    function changeBusAmount() {

        var myChart = echarts.init(document.getElementById('main'),'vintage');
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                //title 名字
                text: '交易查询--'+${info.type},
                //title 下面的备注
                subtext: '',
                //title 的位置
                x:'2% '
            },
            //提示格式
            tooltip: {
                trigger: 'item',
                formatter: "{b} <br/>{a} : {c}"
            },
            //显示的种类
            legend: {
                x:'90%',
                data:[]
            },
            xAxis: {
                name:'',
                data: []
            },
            yAxis: {
                name:'成交数量'
            },
            grid: {
                top:'10%',
                right:'30%'
            },
            series: [{
                name:'成交总数',
                type: 'pie',
                radius: 150,
                center: ['85%', '50%'],
                data:[]
            }, {
                name:'成交总数',
                type: 'bar',
                barMaxWidth: '50',
                data: []
            },
                {
                    name:'成交总数',
                    type: 'line',
                    data: []
                }]
        });
        //数据加载完之前先显示一段简单的loading动画
        myChart.showLoading();
        //类别数组（用于存放饼图的类别）
        var names = [];
        var data = [];
        var beginDate = "${info.beginDate}";
        var endDate = "${info.endDate}";
        var type = ${info.type};

        $.ajax({
            type: 'get',
            url: '${webRoot}/clientTradeFlowInfo/graphicShow',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            data:{
                beginDate:beginDate,
                endDate:endDate,
                type:type
            },
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result.jsonArray, function (index, item) {
                    //挨个取出类别并填入类别数组
                    names.push(item.channelName);
                    data.push({
                        name: item.channelName,
                        value: item.countBusAmount,
                    });
                });
                //隐藏加载动画
                myChart.hideLoading();
                //加载数据图表
                myChart.setOption({
                    legend: {
                        data: names
                    },
                    xAxis: {
                        data: names
                    },
                    series: [{
                        data: data
                    },{
                        data: data
                    }, {
                        data: data
                    }]
                });
            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });
    };
    changeBusAmount();
</script>
</body>

<script>
    function changeBusBalance() {
        var myChart = echarts.init(document.getElementById('main'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                //title 名字
                text: '交易查询',
                //title 下面的备注
                subtext: '',
                //title 的位置
                x:'2% '
            },
            //提示格式
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} "
            },
            //显示的种类
            legend: {
                x:'90%',
                data:[]
            },
            xAxis: {
                name:'',
                data: []
            },
            yAxis: {
                name:'成交金额  '
            },
            grid: {
                top:'10%',
                right:'30%'
            },
            series: [{
                name:'成交金额',
                type: 'pie',
                radius: 150,
                center: ['85%', '50%'],
                data:[]
            }, {
                name:'成交金额',
                type: 'bar',
                data: []
            },
                {
                    name:'成交金额',
                    type: 'line',
                    data: []
                }]
        });
        //数据加载完之前先显示一段简单的loading动画
        myChart.showLoading();
        //类别数组（用于存放饼图的类别）
        var names = [];
        var data = [];
        var beginDate = "${info.beginDate}";
        var endDate = "${info.endDate}";
        var type = ${info.type};

        $.ajax({
            type: 'get',
            url: '${webRoot}/clientTradeFlowInfo/graphicShow',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            data:{
                beginDate:beginDate,
                endDate:endDate,
                type:type
            },
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result.jsonArray, function (index, item) {
                    //挨个取出类别并填入类别数组
                    names.push(item.channelName);
                    data.push({
                        name: item.channelName,
                        value: item.countBusBalance,
                        type:type
                    });
                });
                //隐藏加载动画
                myChart.hideLoading();
                //加载数据图表
                myChart.setOption({
                    legend: {
                        data: names
                    },
                    xAxis: {
                        data: names
                    },
                    series: [{
                        data: data
                    },{
                        data: data
                    }, {
                        data: data
                    }]
                });
            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });
    };

    function changeFreeRadio() {
        var myChart = echarts.init(document.getElementById('main'),'vintage');
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                //title 名字
                text: '交易查询',
                //title 下面的备注
                subtext: '',
                //title 的位置
                x:'2%'
            },
            //提示格式
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} "
            },
            //显示的种类
            legend: {
                x:'90%',
                data:[]
            },
            xAxis: {
                name:'',
                data: []
            },
            yAxis: {
                name:'佣金比例',
            },
            grid: {
                top:'10%',
                right:'30%'
            },
            series: [{
                name:'佣金比例',
                type: 'pie',
                radius: 150,
                center: ['85%', '50%'],
                data:[]
            }, {
                name:'佣金比例',
                type: 'bar',
                data: []
            },
                {
                    name:'佣金比例',
                    type: 'line',
                    data: []
                }]
        });
        //数据加载完之前先显示一段简单的loading动画
        myChart.showLoading();
        //类别数组（用于存放饼图的类别）
        var names = [];
        var data = [];
        var beginDate = "${info.beginDate}";
        var endDate = "${info.endDate}";
        var type = ${info.type};

        $.ajax({
            type: 'get',
            url: '${webRoot}/clientTradeFlowInfo/graphicShow',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            data:{
                beginDate:beginDate,
                endDate:endDate,
                type:type
            },
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result.jsonArray, function (index, item) {
                    //挨个取出类别并填入类别数组
                    names.push(item.channelName);
                    data.push({
                        name: item.channelName,
                        value: item.countFreeRadio
                    });
                });
                //隐藏加载动画
                myChart.hideLoading();
                //加载数据图表
                myChart.setOption({
                    legend: {
                        data: names
                    },
                    xAxis: {
                        data: names
                    },
                    series: [{
                        data: data
                    },{
                        data: data
                    }, {
                        data: data
                    }]
                });
            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });
    };
</script>

</html>