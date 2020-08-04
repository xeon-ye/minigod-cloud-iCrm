<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<jsp:useBean id="dateValue" class="java.util.Date"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>入金交易</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <script type="text/javascript" src="${webRoot}/js/echarts.js"></script>
    <script type="text/javascript" src="${webRoot}/js/macarons.js"></script>
    <script type="text/javascript" src="${webRoot}/js/vintage.js"></script>
</head>
<body>
<div class="col-sm-11" id="main-container">
    <form class="customerList" id="customerList" name="customerList" style="width: 100%">
        <div id="div0" v-cloak class="">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;font-size: 18px" >入金交易信息</b></div>

                <table class="layui-table" lay-skin="nob" style="text-align: center;">
                    <tr >
                        <th style="text-align: center;width: 16.6%"><b>总入金金额</b></th>
                        <th style="text-align: center;width: 16.6%"><b>总入金笔数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>总交易金额</b></th>
                        <th style="text-align: center;width: 16.6%"><b>总交易笔数</b></th>
                    </tr>
                    <tr>
                        <td>${totalInfo.incomeMoney}</td>
                        <td>${totalInfo.incomeCount}</td>
                        <td>${totalInfo.tradeMoney}</td>
                        <td>${totalInfo.tradeCount}</td>
                    </tr>

                </table>
            </div>
        </div>
        <div id="div1" v-cloak class="">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;font-size: 18px" >昨日入金交易信息</b></div>

                <table class="layui-table" lay-skin="nob" style="text-align: center;">
                    <tr >
                        <th style="text-align: center;width: 16.6%"><b>昨日入金金额</b></th>
                        <th style="text-align: center;width: 16.6%"><b>昨日入金笔数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>昨日交易金额</b></th>
                        <th style="text-align: center;width: 16.6%"><b>昨日交易笔数</b></th>
                    </tr>
                    <tr>
                        <td>${yesterdayCount.incomeMoney}</td>
                        <td>${yesterdayCount.incomeCount}</td>
                        <td>${yesterdayCount.tradeMoney}</td>
                        <td>${yesterdayCount.tradeCount}</td>
                    </tr>

                </table>
            </div>
        </div>
        <div id="div2" v-cloak class="">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;font-size: 18px" >上周入金交易信息</b></div>

                <table class="layui-table" lay-skin="nob" style="text-align: center;">
                    <tr >
                        <th style="text-align: center;width: 16.6%"><b>上周入金金额</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上周入金笔数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上周交易金额</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上周交易笔数</b></th>
                    </tr>
                    <tr>
                        <td>${lastWeekCount.incomeMoney}</td>
                        <td>${lastWeekCount.incomeCount}</td>
                        <td>${lastWeekCount.tradeMoney}</td>
                        <td>${lastWeekCount.tradeCount}</td>
                    </tr>

                </table>
            </div>
        </div>
        <div id="div3" v-cloak class="">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;font-size: 18px" >上月入金交易信息</b></div>

                <table class="layui-table" lay-skin="nob" style="text-align: center;">
                    <tr >
                        <th style="text-align: center;width: 16.6%"><b>上月入金金额</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上月入金笔数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上月交易金额</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上月交易笔数</b></th>
                    </tr>
                    <tr>
                        <td>${lastMonthCount.incomeMoney}</td>
                        <td>${lastMonthCount.incomeCount}</td>
                        <td>${lastMonthCount.tradeMoney}</td>
                        <td>${lastMonthCount.tradeCount}</td>
                    </tr>
                </table>
            </div>
        </div>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763;font-size: 18px" >趋势图</b></div>
            <br><br>
            <td>
                &nbsp;&nbsp;<span style="font-weight:bold;" class="layui-btn layui-btn-small layui-btn-danger" disabled="disabled">指标 : </span>
                <button id="incomeMoney" type="button" onclick="changeBusAmount(null,'incomeMoney');" class="layui-btn layui-btn-small" >入金金额统计</button>
                <button id="incomeCount" type="button" onclick="changeBusAmount(null,'incomeCount');" class="layui-btn layui-btn-small" >入金笔数统计</button>
                <button id="tradeMoney" type="button" onclick="changeBusAmount(null,'tradeMoney');" class="layui-btn layui-btn-small" >交易金额统计</button>
                <button id="tradeCount" type="button" onclick="changeBusAmount(null,'tradeCount');" class="layui-btn layui-btn-small" >交易笔数统计</button>
            </td>
            <div id="main" style="width:100%;height:620px;"></div>
            <input hidden="hidden" id="cale" name="cale" type="text" value="day">
            <table width="60%" >
                <td>
                    &nbsp;&nbsp;<span style="font-weight:bold;" class="layui-btn layui-btn-small layui-btn-danger" disabled="disabled">维度 : </span>
                    <button id="day" type="button" onclick="changeBusAmount('day',null);" class="layui-btn layui-btn-small " >按日</button>
                    <button id="week" type="button" onclick="changeBusAmount('week',null);" class="layui-btn layui-btn-small  " >按周</button>
                    <button id="month" type="button" onclick="changeBusAmount('month',null);" class="layui-btn layui-btn-small  " >按月</button>
                </td>
            </table>
            <br>
            <br>
        </div>
        <br>

    </form>
</div>
<script>
    var cale = $("#cale").val();
//    alertMsg(cale);
    function changeBusAmount(cale,dataType) {
        var myChart = echarts.init(document.getElementById('main'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                //title 名字
                text: '',
                //title 下面的备注
                subtext: '',
                //title 的位置
                x:'2% ',
                y:'4%'
            },
            //提示格式
            tooltip: {
                trigger: 'axis',
                formatter: "{b} <br/>{a} : {c}"
            },
            //显示的种类
            legend: {
                x:'90%',
                data:[]
            },
            xAxis: {
                name:'时间',
                data: []
            },
            yAxis: {
                name:''
            },
            grid: {
                top:'18%'
            },
            series: [{
                name:'',
                smooth:true,
                type: 'line',
                barMaxWidth: '50',
                data: []
            }]
        });
        //数据加载完之前先显示一段简单的loading动画
        myChart.showLoading();
        //类别数组（用于存放饼图的类别）
        var names = [];
        var data = [];
        var title = [];
        var yName = [];
        var subtext = [];
        if(cale==null||""==cale){
            cale = $("#cale").val();
        }else{
            $("#cale").attr("value",cale);
        }
        if(dataType==null||""==dataType){
            dataType = "incomeMoney";
        }
        $.ajax({
            type: 'get',
            url: '${webRoot}/clientIncomeCount/graphicShow',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            data:{
                cale:cale,
                dataType:dataType
            },
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result.jsonArray, function (index, item){
                    //挨个取出类别并填入类别数组
                    names.push(item.dateTime);
                    if(cale!=null){
                        if (cale == "day") {
                            $("#day").addClass("layui-btn-warm");
                            $("#week").removeClass("layui-btn-warm");
                            $("#month").removeClass("layui-btn-warm");
                            subtext = "按日";
                        } else if (cale == "week") {
                            $("#week").addClass("layui-btn-warm");
                            $("#day").removeClass("layui-btn-warm");
                            $("#month").removeClass("layui-btn-warm");
                            subtext = "按周";
                        } else if (cale == "month") {
                            $("#month").addClass("layui-btn-warm");
                            $("#day").removeClass("layui-btn-warm");
                            $("#week").removeClass("layui-btn-warm");
                            subtext = "按月";
                        }
                    }
                    if(dataType=="tradeCount"){
                        title = "交易笔数统计";
                        yName = "交易笔数";
                        $("#tradeCount").addClass("layui-btn-warm");
                        $("#tradeMoney").removeClass("layui-btn-warm");
                        $("#incomeMoney").removeClass("layui-btn-warm");
                        $("#incomeCount").removeClass("layui-btn-warm");
                        data.push({
                            name: item.dateTime,
                            value: item.tradeCount
                        });
                    }else if(dataType=="tradeMoney"){
                        title = "交易金额统计";
                        yName = "交易金额";
                        $("#tradeCount").removeClass("layui-btn-warm");
                        $("#tradeMoney").addClass("layui-btn-warm");
                        $("#incomeMoney").removeClass("layui-btn-warm");
                        $("#incomeCount").removeClass("layui-btn-warm");
                        data.push({
                            name: item.dateTime,
                            value: item.tradeMoney
                        });
                    }else if(dataType=="incomeMoney"){
                        title = "入金金额统计";
                        yName = "入金金额";
                        $("#tradeCount").removeClass("layui-btn-warm");
                        $("#tradeMoney").removeClass("layui-btn-warm");
                        $("#incomeMoney").addClass("layui-btn-warm");
                        $("#incomeCount").removeClass("layui-btn-warm");
                        data.push({
                            name: item.dateTime,
                            value: item.incomeMoney
                        });
                    }else if(dataType=="incomeCount"){
                        title = "入金笔数统计";
                        yName = "入金笔数";
                        $("#tradeCount").removeClass("layui-btn-warm");
                        $("#tradeMoney").removeClass("layui-btn-warm");
                        $("#incomeMoney").removeClass("layui-btn-warm");
                        $("#incomeCount").addClass("layui-btn-warm");
                        data.push({
                            name: item.dateTime,
                            value: item.incomeCount
                        });
                    }
                });
                //隐藏加载动画
                myChart.hideLoading();
                //加载数据图表
                myChart.setOption({
                    title:{
                        text:title,
                        subtext:subtext
                    },
                    legend: {
                        data: names
                    },
                    xAxis: {
                        data: names
                    },
                    yAxis: {
                        name: yName
                    },
                    series: [{
                        name: yName,
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
</html>
