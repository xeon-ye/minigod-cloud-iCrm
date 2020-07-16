<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<form action="" id="actFieldForm">
    <div class="row" style="margin-top: 25px;margin-left: 20px" align="center">
        <div class="col-sm-12" align="center" style="margin-top: 30px;">
            <div class="col-sm-4"></div>
            <c:if test="${operationFlag == true && info.applicationStatus =='1'}">
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger" type="button" onclick="goRejectView()">不匹配</button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-normal" type="button" onclick="goRefundView()">退款入账
                    </button>
                </div>
            </c:if>
            <div class="col-sm-1">
                <button class="layui-btn layui-btn-primary" type="button" onclick="closeThisWindow()">返 回</button>
            </div>
        </div>
    </div>
</form>
<script>

    // 流程相关信息类
    function processInfo(busId, actKey, taskId, instanceId, changeFields, defId) {
        this.busId = busId;//业务id
        this.actKey = actKey;//流程key也是业务key
        this.taskId = taskId;//任务id
        this.instanceId = instanceId;//流程实例
        this.changeFields = changeFields;//可更改的字段
        this.defId = defId;//流程定义id
    }

    var processInfo = new processInfo();
    $(function () {
        //获取业务可更改的字段，和流程业务基本信息
        processInfo.busId = '${taskDto.busId}';
        processInfo.taskId = '${taskDto.taskId}';
        processInfo.instanceId = '${taskDto.instanceId}';
        processInfo.defId = '${taskDto.defId}';

        var flag = '${flag}';
        if (flag == '2') {
            getChangeFileds();
        }
    });


    // 获取业务可更改的字段，和流程业务基本信息,和流程节点变量
    function getChangeFileds() {
        var url = "${webRoot}/act/deal/getChangeFileds";
        var params = {
            'busId': processInfo.busId,
            'taskId': processInfo.taskId,
            'instanceId': processInfo.instanceId,
            'defId': processInfo.defId
        };
        $.post(url, params, function (result) {
            if (result.code == '0') {
                processInfo.changeFields = result.changeFields;
                processInfo.vars = result.vars;
                for (var i = 0; i < processInfo.changeFields.length; i++) {
                    var fieldName = processInfo.changeFields[i];
                    if (fieldName != null && fieldName != '') {
                        $("#actBusFields #" + fieldName).attr("readOnly", false);
                    }
                }
            } else {
                alertMsg(result.msg);
            }
        });
    }

    // 拒绝弹窗页面
    function goRejectView() {

        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&defId=" + '${taskDto.defId}' + "&instanceId=" + '${taskDto.instanceId}';

        var url = "${webRoot}/fundWithdrawRefund/goRejectView?" + params;

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["操作页面", true],
            area: ['50%', '60%'],
            content: [url, 'yes']
        });
    }

    // 退款入账
    function goRefundView() {

        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&defId=" + '${taskDto.defId}' + "&instanceId=" + '${taskDto.instanceId}';

        var url = "${webRoot}/fundWithdrawRefund/goRefundView?" + params;

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["退款入账页面", true],
            area: ['80%', '95%'],
            content: [url, 'yes']
        });
    }

</script>