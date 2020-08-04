<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>汇款页面</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<body>
<div class="main-container" id="main-container">
    <div id="div7" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">请选择汇款方式</b></div>

            <div style="margin-left: 5%;width: 90%;height: 200px;">

                <c:forEach var="codeEntity" items="${fundWithdrawRemTypes}" varStatus="i">
                    <c:if test="${((i.index % 2) eq 0) && i.index==0}">
                        </br>
                    </c:if>

                    <c:if test="${((i.index % 2) eq 0) && i.index >0}">
                        </br></br>
                    </c:if>
                    <span class="col-xs-4 block input-icon input-icon-right">
                        <input type="checkbox" name="errorContentTypes" id="errorContentTypes_${codeEntity.value}"
                               value="${codeEntity.value}" onclick="onChange(this.value)"/>${codeEntity.name}
                    </span>

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

    function doSubmit() {
        var errorContentTypesArray = []; //退回理由
        var backReasonTypeArray = [];
        var errorContentTypes = "";

        $('input[name="errorContentTypes"]:checked').each(function () {
            errorContentTypesArray.push($(this).val());
            backReasonTypeArray.push($(this).val());
        });
        if (backReasonTypeArray == "") {
            alertMsg("请勾选汇款方式");
            return;
        }

        if (errorContentTypesArray != "") {
            errorContentTypes = errorContentTypesArray.toString();
        }

        confirm("您确定要批量处理吗?", function () {
            var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&instanceId=" + '${taskDto.instanceId}' + "&defId=" + '${taskDto.defId}'
                + "&remark=" + '${taskDto.remark}'
                + "&remittanceType=" + errorContentTypes
                + "&applicationIds=" + '${applicationIds}';

            var url = "${webRoot}/clientFundWithdraw/doPassTaskBatch";
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    alert(result, function () {
                        // 刷新父窗口列表
                        parent.location.reload();
                        // 关闭弹框
                        closeThisWindow();
                    });
                } else {
                    alertMsg(result.msg);
                }
            });
        });
    }


</script>

</html>