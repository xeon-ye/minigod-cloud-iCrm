<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>打印支票页面</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<body>
<div class="main-container" id="main-container">

    <div id="div7" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">请选择银行支票本</b></div>

            <div style="margin-left: 5%;width: 90%;height: 200px;">

                <c:forEach var="codeEntity" items="${codeList}" varStatus="i">
                    <c:if test="${((i.index % 2) eq 0) && i.index==0}">
                        </br>
                    </c:if>

                    <c:if test="${((i.index % 2) eq 0) && i.index >0}">
                        </br></br>
                    </c:if>
                    <c:if test="${codeEntity.value!=3}">
                    <span class="col-xs-4 block input-icon input-icon-right">
                        <input type="checkbox" name="errorContentTypes" id="errorContentTypes_${codeEntity.value}"
                               value="${codeEntity.value}" onclick="onChange(this.value)"/>${codeEntity.name}
                    </span>
                    </c:if>

                    <c:if test="${codeEntity.value==3}">
                        <span class="col-xs-4 block input-icon input-icon-right">
                        <input type="checkbox" name="nameType" id="nameType" />支票显示中文名
                    </span>
                        </br></br>
                        <span class="col-xs-4 block input-icon input-icon-right">
                                <input type="checkbox" name="printDate" id="printDate${codeEntity.value}"
                                       value="${codeEntity.value}"
                                       onclick="onClickPrint(this.value)"/>${codeEntity.name}
                            </span>
                        <div class="layui-inline">
                            <div class="layui-input-inline" style="width: 100px;">
                                <input type="text" id="day" name="day" placeholder="day" autocomplete="off"
                                       class="layui-input" disabled="disabled">
                            </div>
                            <div class="layui-input-inline" style="width: 100px;">
                                <input type="text" id="month" name="month" placeholder="month" autocomplete="off"
                                       class="layui-input" disabled="disabled">
                            </div>
                            <div class="layui-input-inline" style="width: 100px;">
                                <input type="text" id="year" name="year" placeholder="year" autocomplete="off"
                                       class="layui-input" disabled="disabled">
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            </br>
        </div>
    </div>

    <div class="row" style="margin-left: 40%;padding-bottom: 28px;margin-top: 15px;">
        <button class="layui-btn " type="button" onclick="doSubmit()">提交</button>
        <button class="layui-btn layui-btn-primary" type="button" onclick="closeThisWindow()">关 闭</button>
    </div>

</div>

</div>

</body>
<script>
    // 流程相关信息类
    function processInfo(busId, actKey, taskId, instanceId, changeFields, defId, remark) {
        this.busId = busId;//业务id
        this.actKey = actKey;//流程key也是业务key
        this.taskId = taskId;//任务id
        this.instanceId = instanceId;//流程实例
        this.changeFields = changeFields;//可更改的字段
        this.defId = defId;//流程定义id
        this.remark = remark;//审批意见
    }

    var processInfo = new processInfo();
    $(function () {

        //获取业务可更改的字段，和流程业务基本信息
        processInfo.busId = '${taskDto.busId}';
        processInfo.taskId = '${taskDto.taskId}';
        processInfo.instanceId = '${taskDto.instanceId}';
        processInfo.defId = '${taskDto.defId}';
        processInfo.remark = '${taskDto.remark}';
    });

    // 其他原因跟另外的原因不能同时选择
    // function onChange(value) {
    //     if ($("input[name='errorContentTypes']").is(':checked')) {
    //         if (value != '2') {
    //             $("input[name='errorContentTypes']").attr("disabled", false);
    //             document.getElementById("errorContentTypes_2").disabled = true;
    //         } else {
    //             $("input[name='errorContentTypes']").attr("disabled", true);
    //             document.getElementById("errorContentTypes_2").disabled = false;
    //         }
    //     } else {
    //         $("input[name='errorContentTypes']").attr("disabled", false);
    //         document.getElementById("errorContentTypes_2").disabled = false;
    //     }
    // }

    function onChange(value) {
        if ($("input[name='errorContentTypes']").is(':checked')) {

            $("input[name='errorContentTypes']").attr("disabled", true);
            document.getElementById("errorContentTypes_" + value).disabled = false;
        } else {
            $("input[name='errorContentTypes']").attr("disabled", false);
            document.getElementById("errorContentTypes_" + value).disabled = false;
        }
    }

    function onClickPrint(value) {

        if ($("input[name='printDate']").is(':checked')) {
            $("input[name='day']").removeAttr("disabled");
            $("input[name='month']").removeAttr("disabled");
            $("input[name='year']").removeAttr("disabled");
        } else {
            $("input[name='day']").attr("disabled", true);
            $("input[name='month']").attr("disabled", true);
            $("input[name='month']").attr("disabled", true);
        }
    }

    function doSubmit() {
        var errorContentTypesArray = []; //退回理由
        var backReasonTypeArray = [];
        var errorContentTypes = "";

        $('input[name="errorContentTypes"]:checked').each(function () {
            errorContentTypesArray.push($(this).val());
            backReasonTypeArray.push($(this).val());
        });

        if (backReasonTypeArray == "") {
            alertMsg("请勾选支票本");
            return;
        }

        if (errorContentTypesArray != "") {
            errorContentTypes = errorContentTypesArray.toString();
        }

        if ($("input[name='nameType']").is(':checked')) {
            var nameType=1;
        }else {
            var nameType=0;
        }

        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&instanceId=" + '${taskDto.instanceId}' + "&defId=" + '${taskDto.defId}'
            + "&remark=" + '${taskDto.remark}'
            + "&chequeType=" + errorContentTypes
            + "&applicationIds=" + '${applicationIds}'
            + "&nameType=" + nameType
            + "&day=" + $('#day').val()
            + "&month=" + $('#month').val()
            + "&year=" + $('#year').val();


        var url = "${webRoot}/clientFundWithdraw/doPrintCheque?" + params;

        downloadFile('', url);
    }

    function downloadFile(name, href) {
        var a = document.createElement("a"), //创建a标签
            e = document.createEvent("MouseEvents"); //创建鼠标事件对象
        e.initEvent("click", false, false); //初始化事件对象
        a.href = href; //设置下载地址
        a.download = name; //设置下载文件名
        a.dispatchEvent(e); //给指定的元素，执行事件click事件
    }


</script>

</html>