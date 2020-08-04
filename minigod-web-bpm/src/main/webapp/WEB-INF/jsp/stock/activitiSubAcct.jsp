<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<form action="" id="actFieldForm">

    <div class="row" style="margin-top: 25px;margin-left: 20px" align="center">
        <div class="col-sm-12" align="center" style="margin-top: 30px;">
            <div class="col-sm-4"></div>
                <c:if test="${operationFlag == true && (donatedStockInfo.applicationStatus =='1' || donatedStockInfo.applicationStatus == '2')}">
                    <div class="col-sm-1">
                        <button class="layui-btn" type="button" onclick="clickSubmit()">同意</button>
                    </div>

                    <div class="col-sm-1">
                        <button class="layui-btn layui-btn-danger" type="button"
                                onclick="doReject('${taskDto.busId}','${taskDto.taskId}','${taskDto.defId}','${taskDto.instanceId}','${taskDto.actKey}')">拒绝
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

    /*
     * 拒绝
     */
    function doReject(busId, taskId, defId, instanceId,actKey) {
        if (busId == "") {
            alertMsg("业务id不能为空");
            return;
        }
        if (taskId == "") {
            alertMsg("任务id不能为空");
            return;
        }
        if (defId == "") {
            alertMsg("流程定义id不能为空");
            return;
        }
        if (instanceId == "") {
            alertMsg("实例id不能为空");
            return;
        }

        confirm("确定执行此操作吗？", function () {
            var params = "busId=" + busId + "&taskId=" + taskId + "&defId=" + defId + "&instanceId=" + instanceId+ "&actKey=" + actKey;
            var url = "${webRoot}/donatedStock/doReject";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result,function(){
                        //刷新父窗口列表
                        parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    })
                } else {
                    alertMsg(result.msg);
                }
            }, "json");
        });
    }

    /**
     * 流程相关信息类
     */
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
        if(flag == '2') {
            getChangeFileds();
        }
    });


    /**
     * 获取业务可更改的字段，和流程业务基本信息,和流程节点变量
     */
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

    /**
     * 办理任务
     */
    function clickSubmit() {
            confirm("确定执行此操作吗？", function () {
                var url = "${webRoot}/act/deal/doActTask";
                var userIds = new Array();
                $("#userTab input[name='userIds']").each(function () {
                    userIds.push($(this).val());
                });
                var params = {
                    'busId': '${taskDto.busId}',
                    'taskId': '${taskDto.taskId}',
                    'instanceId': '${taskDto.instanceId}',
                    'defId': '${taskDto.defId}',
                    'varValue': processInfo.varValue,
                    'varName': processInfo.varName,
                    'nodeType': processInfo.nodeType,
                    'nextUserIds': userIds.join(",")
                };
                var remark = $("#remark").val();
                params["remark"] = remark;
                $.post(url, params, function (result) {
                    if (result.code == '0') {
                        toast(result,function(){
                            //刷新父窗口列表
                            parent.location.reload();
                            //关闭弹框
                            closeThisWindow();
                        })
                    } else {
                        alertMsg(result.msg);
                    }
                });

            });
    }


</script>

