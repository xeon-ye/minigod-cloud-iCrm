<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<jsp:useBean id="dateValue" class="java.util.Date"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>客户数统计</title>
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
                <div class="panel-heading"><b style="color: #368763;font-size: 18px">用户信息</b></div>

                <table class="layui-table" lay-skin="nob" style="text-align: center;">
                    <tr>
                        <th style="text-align: center;width: 16.6%"><b>平台用户总数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>注册用户总数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>开户用户总数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>入金用户总数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>出金用户总数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>交易用户总数</b></th>
                    </tr>
                    <tr>
                        <td>${totalInfo.regUserCount}</td>
                        <td>${totalInfo.regUserCount}</td>
                        <td>${totalInfo.openUserCount}</td>
                        <td>${totalInfo.inComeCount}</td>
                        <td>${totalInfo.outComeCount}</td>
                        <td>${totalInfo.tradeCount}</td>
                    </tr>

                </table>
            </div>
        </div>
        <div id="div1" v-cloak class="">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;font-size: 18px">昨日用户信息</b></div>

                <table class="layui-table" lay-skin="nob" style="text-align: center;">
                    <tr>
                        <th style="text-align: center;width: 16.6%"><b>昨日新增用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>昨日注册用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>昨日开户用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>昨日入金用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>昨日出金用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>昨日交易用户数</b></th>
                    </tr>
                    <tr>
                        <td>${yesterdayClientCount.regUserCount}</td>
                        <td>${yesterdayClientCount.regUserCount}</td>
                        <td>${yesterdayClientCount.openUserCount}</td>
                        <td>${yesterdayClientCount.inComeCount}</td>
                        <td>${yesterdayClientCount.outComeCount}</td>
                        <td>${yesterdayClientCount.tradeCount}</td>
                    </tr>

                </table>
            </div>
        </div>
        <div id="div2" v-cloak class="">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;font-size: 18px">上周用户信息</b></div>

                <table class="layui-table" lay-skin="nob" style="text-align: center;">
                    <tr>
                        <th style="text-align: center;width: 16.6%"><b>上周新增用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上周注册用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上周开户用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上周入金用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上周出金用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上周交易用户数</b></th>
                    </tr>
                    <tr>
                        <td>${lastWeekCountInfo.regUserCount}</td>
                        <td>${lastWeekCountInfo.regUserCount}</td>
                        <td>${lastWeekCountInfo.openUserCount}</td>
                        <td>${lastWeekCountInfo.inComeCount}</td>
                        <td>${lastWeekCountInfo.outComeCount}</td>
                        <td>${lastWeekCountInfo.tradeCount}</td>
                    </tr>

                </table>
            </div>
        </div>
        <div id="div3" v-cloak class="">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;font-size: 18px">上月用户信息</b></div>

                <table class="layui-table" lay-skin="nob" style="text-align: center;">
                    <tr>
                        <th style="text-align: center;width: 16.6%"><b>上月新增用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上月注册用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上月开户用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上月入金用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上月出金用户数</b></th>
                        <th style="text-align: center;width: 16.6%"><b>上月交易用户数</b></th>
                    </tr>
                    <tr>
                        <td>${lastMonthCountInfo.regUserCount}</td>
                        <td>${lastMonthCountInfo.regUserCount}</td>
                        <td>${lastMonthCountInfo.openUserCount}</td>
                        <td>${lastMonthCountInfo.inComeCount}</td>
                        <td>${lastMonthCountInfo.outComeCount}</td>
                        <td>${lastMonthCountInfo.tradeCount}</td>
                    </tr>

                </table>
            </div>
        </div>
        <div id="div4" v-cloak class="">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;font-size: 18px">新增与活跃用户信息</b></div>

                <table class="layui-table lay" lay-skin="nob" style="text-align: center;width: 100%">
                    <tr>
                        <th style="text-align: center;width: 33%"><b>时间</b></th>
                        <th style="text-align: center;width: 33%"><b>新增用户数（安卓）</b></th>
                        <th style="text-align: center;width: 33%"><b>新增用户数（ios）</b></th>
                    </tr>
                    <tr>
                        <td>昨日</td>
                        <c:if test="${yesterdayCountInfo.androidUserCount == null && yesterdayCountInfo.iosUserCount==null}">
                            <td>0</td>
                            <td>0</td>
                        </c:if>
                        <c:if test="${yesterdayCountInfo.androidUserCount != null && yesterdayCountInfo.iosUserCount != null}">
                            <td>${yesterdayCountInfo.androidUserCount}</td>
                            <td>${yesterdayCountInfo.iosUserCount}</td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>近一周</td>
                        <c:if test="${nearWeekCountInfo.androidUserCount == null && nearWeekCountInfo.iosUserCount==null}">
                            <td>0</td>
                            <td>0</td>
                        </c:if>
                        <c:if test="${nearWeekCountInfo.androidUserCount != null && nearWeekCountInfo.iosUserCount != null}">
                            <td>${nearWeekCountInfo.androidUserCount}</td>
                            <td>${nearWeekCountInfo.iosUserCount}</td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>近一月</td>
                        <c:if test="${nearMonthCountInfo.androidUserCount == null && nearMonthCountInfo.iosUserCount==null}">
                            <td>0</td>
                            <td>0</td>
                        </c:if>
                        <c:if test="${nearMonthCountInfo.androidUserCount != null && nearMonthCountInfo.iosUserCount != null}">
                            <td>${nearMonthCountInfo.androidUserCount}</td>
                            <td>${nearMonthCountInfo.iosUserCount}</td>
                        </c:if>
                    </tr>
                </table>
            </div>
        </div>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763;font-size: 18px">趋势图</b></div>
            <br><br>
            <td>
                &nbsp;&nbsp;<span style="font-weight:bold;" class="layui-btn layui-btn-small layui-btn-danger"
                                  disabled="disabled">指标 : </span>
                <button id="reg"  type="button" onclick="changeBusAmount(null,'reg');" class="layui-btn layui-btn-small">
                    新增注册用户数统计
                </button>
                <button id="open"  type="button" onclick="changeBusAmount(null,'open');" class="layui-btn layui-btn-small">
                    新增开户用户数统计
                </button>
                <button id="income"  type="button" onclick="changeBusAmount(null,'income');" class="layui-btn layui-btn-small">
                    新增入金用户数统计
                </button>
                <button id="trade"  type="button" onclick="changeBusAmount(null,'trade');" class="layui-btn layui-btn-small">
                    新增交易用户数统计
                </button>
            </td>
            <div id="main" style="width:100%;height:620px;"></div>
            <input hidden="hidden" id="cale" name="cale" type="text" value="day">
            <table width="60%">
                <td>
                    &nbsp;&nbsp;<span style="font-weight:bold;" class="layui-btn layui-btn-small layui-btn-danger"
                                      disabled="disabled">维度 : </span>
                    <button id="day" type="button" onclick="changeBusAmount('day',null);" class="layui-btn layui-btn-small ">按日
                    </button>
                    <button id="week" type="button" onclick="changeBusAmount('week',null);" class="layui-btn layui-btn-small  ">
                        按周
                    </button>
                    <button id="month" type="button" onclick="changeBusAmount('month',null);" class="layui-btn layui-btn-small  ">
                        按月
                    </button>
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
    function changeBusAmount(cale, dataType) {


        var myChart = echarts.init(document.getElementById('main'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                //title 名字
                text: '',
                //title 下面的备注
                subtext: '',
                //title 的位置
                x: '2% ',
                y: '4%'
            },
            //提示格式
            tooltip: {
                trigger: 'axis',
                formatter: "{b} <br/>{a} : {c}"
            },
            //显示的种类
            legend: {
                x: '90%',
                data: []
            },
            xAxis: {
                name: '时间',
                data: []
            },
            yAxis: {
                name: ''
            },
            grid: {
                top: '18%'
            },
            series: [{
                name: '',
                smooth: true,
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
        if (cale == null || "" == cale) {
            cale = $("#cale").val();
        } else {
            $("#cale").attr("value", cale);
        }
        if (dataType == null || "" == dataType) {
            dataType = "reg";
        }
        $.ajax({
            type: 'get',
            url: '${webRoot}/clientSumStatInfo/graphicShow',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            data: {
                cale: cale,
                dataType: dataType
            },
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result.jsonArray, function (index, item) {
                    //挨个取出类别并填入类别数组
                    names.push(item.dateTime);
                    if (cale != null) {
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
                    if (dataType == "reg") {
                        title = "新增注册用户数";
                        yName = "用户数";
                        $("#reg").addClass("layui-btn-warm");
                        $("#open").removeClass("layui-btn-warm");
                        $("#income").removeClass("layui-btn-warm");
                        $("#trade").removeClass("layui-btn-warm");
                        data.push({
                            name: item.dateTime,
                            value: item.regUserCount
                        });
                    } else if (dataType == "open") {
                        title = "新增开户用户数";
                        yName = "用户数";
                        $("#open").addClass("layui-btn-warm");
                        $("#reg").removeClass("layui-btn-warm");
                        $("#income").removeClass("layui-btn-warm");
                        $("#trade").removeClass("layui-btn-warm");
                        data.push({
                            name: item.dateTime,
                            value: item.openUserCount
                        });
                    } else if (dataType == "income") {
                        title = "新增入金用户数";
                        yName = "用户数";
                        $("#income").addClass("layui-btn-warm");
                        $("#open").removeClass("layui-btn-warm");
                        $("#reg").removeClass("layui-btn-warm");
                        $("#trade").removeClass("layui-btn-warm");
                        data.push({
                            name: item.dateTime,
                            value: item.inComeCount
                        });
                    } else if (dataType == "trade") {
                        title = "新增交易用户数";
                        yName = "用户数";
                        $("#trade").addClass("layui-btn-warm");
                        $("#income").removeClass("layui-btn-warm");
                        $("#open").removeClass("layui-btn-warm");
                        $("#reg").removeClass("layui-btn-warm");
                        data.push({
                            name: item.dateTime,
                            value: item.tradeCount
                        });
                    }
                });
                //隐藏加载动画
                myChart.hideLoading();
                //加载数据图表
                myChart.setOption({
                    title: {
                        text: title,
                        subtext: subtext
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
