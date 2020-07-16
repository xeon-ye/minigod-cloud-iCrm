<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>交易统计报表</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <script >
    </script>
</head>

<body>
<div class="main-container" id="main-container" >
    <div class="row" style="margin-top: 5px;">
        <form class="layui-form" id="search-from" method="post" action="${webRoot}/tradeReport/reportList">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:180px;">日期:</label>
                            <div class="layui-input-inline">
                                <tag:select id="date" name="date" otherAttr="lay-filter='searchFilter'"  nameKey="COMMON_DATE_TYPE" initSelectedKey="${params.date}" clazz="layui-input"></tag:select>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:180px;">开始日期:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="beginDate" name="beginDate" value="${params.beginDate}"  class="layui-input" >
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:180px;">结束日期:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="endDate" name="endDate" value="${params.endDate}"   class="layui-input" >
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:180px;">客户类型:</label>
                            <div class="layui-input-inline">
                                <tag:select name="clientType" id="clientType" nameKey="CRM_CLIENT_TYPE" initSelectedKey="${params.clientType}"></tag:select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:180px;">委托类型:</label>
                            <div class="layui-input-inline">
                                <tag:select name="entrustWay" id="entrustWay" nameKey="CRM_ENTRUST_WAY" initSelectedKey="${params.entrustWay}"></tag:select>
                            </div>
                        </td>


                        <td>
                            <label class="layui-form-label" style="width:120px;"></label>
                            <button class="layui-btn" type="button" onclick="queryForm();"><i class="layui-icon">&#xe615;</i>搜 索</button>&nbsp;&nbsp;&nbsp;&nbsp;
                            <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>&nbsp;&nbsp;&nbsp;&nbsp;
                            <shiro:hasPermission name="tradeReport:tradeReportExp">
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
            <table id="table-list" class="layui-table" >
                <thead>
                <tr width="99%" >
                    <th>时间</th>
                    <th>客户类型</th>
                    <th>委托客户数</th>
                    <th>委托类型</th>
                    <th>委托笔数</th>
                    <th>成交笔数</th>
                    <th>去年成交笔数同比%</th>
                    <th>成交笔数环比%</th>
                    <th>成交金额HKD</th>
                    <th>去年成交金额同比%</th>
                    <th>成交金额环比%</th>
                </tr>
                </thead>
                <tbody >
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr>
                        <td>${info.date}</td>
                        <td>
                            <c:if test="${info.clientType == 0}">
                                个人
                            </c:if>
                            <c:if test="${info.clientType == 1 or info.clientType==4}">
                                机构
                            </c:if>
                        </td>
                        <td>${info.entrustClientCount}</td>
                        <td>${fns:getCodeName("CRM_ENTRUST_WAY",info.entrustWay)}</td>
                        <td>${info.entrustCount}</td>
                        <td>${info.tradeCount}</td>
                        <td>${info.countRatioT}</td>
                        <td>${info.countRatioH}</td>
                        <td>${info.tradeBalance}</td>
                        <td>${info.balanceRatioT}</td>
                        <td>${info.balanceRatioH}</td>
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

    function fallDate(bigDate, smallDate) {
        bigDate = new Date(bigDate.replace(/-/g, "/"));  //把日期字符串转换成日期格式
        smallDate = new Date(smallDate.replace(/-/g, "/"));  //把日期字符串转换成日期格式
        var days = (bigDate - smallDate) / (1000 * 60 * 60 * 24)
        return days;
    }

    function queryForm() {

        if($("#date").val() == 0){
            if($("#endDate").val()==null || $("#endDate").val()=='' || $("#beginDate").val()==null || $("#beginDate").val()==''){
                myToast("按日查询，请填写起始日期",2);
                return;
            }
           if(fallDate($("#endDate").val(),$("#beginDate").val())>=32 ||  fallDate($("#endDate").val(),$("#beginDate").val())<=0){
               myToast("结束日期必须大于开始日期30天以内",2);
               return;
           }
        }
        if($("#date").val() == 1){
            if($("#endDate").val()!=null && $("#endDate").val()!='' && $("#beginDate").val()!=null && $("#beginDate").val()!=''){
                if(fallDate($("#endDate").val(),$("#beginDate").val())>=367 ||  fallDate($("#endDate").val(),$("#beginDate").val())<=0){
                    myToast("结束日期必须大于开始日期一年以内",2);
                    return;
                }
            }
        }
        $("#search-from").submit();
    }


    // 设置最小可选的日期
    function minDate() {
        var now = new Date();
        return now.getFullYear() + "-" + (now.getMonth()) + "-" + now.getDate();
    }

    // 设置最小可选的日期
    function maxDate() {
        var now = new Date();
        return now.getFullYear() + "-" + (now.getMonth()+1) + "-" + now.getDate();
    }


    /**
     * 导出excel
     */
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/tradeReport/tradeReportExp?info=&' + obj;
    }

    layui.laydate.render({
        elem: '#beginDate'
    });
    layui.laydate.render({
        elem: '#endDate'
    });

    /**
     * 切换用户类型select事件
     */
    layui.use(['form'], function(){
        if($("#date").val()==2){
            $("#beginDate").attr("disabled","disabled");
            $("#endDate").attr("disabled","disabled");
        }
        if($("#date").val()!=0){
            $("#beginDate").removeAttr("disabled","disabled");
            $("#endDate").removeAttr("disabled","disabled");
        }
        var form = layui.form;
        form.on('select(searchFilter)', function(data){
            if(data.value==2){
                $("#beginDate").attr("disabled","disabled").val("");
                $("#endDate").attr("disabled","disabled").val("");
            }
            if(data.value!=2){
                $("#beginDate").removeAttr("disabled","disabled").val("");
                $("#endDate").removeAttr("disabled","disabled").val("");
            }
        });
        form.render('select');
    });


</script>

</html>