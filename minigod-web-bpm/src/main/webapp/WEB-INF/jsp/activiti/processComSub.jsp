<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<form action="" id="actFieldForm">
    <%--<div class="row" name="isagreeShow">
        <div class="form-group col-sm-6 col-md-5 ">
            <label class="col-sm-3 control-label no-padding-right">是否同意:</label>
            <div class="col-sm-9">
                <span class="col-xs-11 block input-icon input-icon-right">
                    <tag:select nameKey="YES_NO" name="isagree" clazz="form-control" />
                </span>
            </div>
        </div>
    </div>--%>
    <div class="row">
        <div class="form-group col-sm-8 ">
            <label class="control-label col-sm-2">审批意见:</label>
            <div class="col-sm-10">
                <div class="form-group">
                    <textarea name="remark" id="remark" class="form-control" rows="3"></textarea>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 20px;margin-left: 20%">
        <c:if test="${taskDto.dealId == '' || taskDto.dealId ==null}">
            <button class="layui-btn layui-btn-small" type="button"
                    onclick="applyTaskHandle('${taskDto.actKey}','${taskDto.busId}','${taskDto.instanceId}','${taskDto.taskId}','${taskDto.defId}','${taskDto.nodeType}','${currentUserId}')">
                <i class="layui-icon">&#xe60a;</i>申请办理
            </button>
        </c:if>
        <c:if test="${taskDto.dealId == currentUserId}">
            <button class="layui-btn" type="button" onclick="clickSubmit()">办理</button>
            <button class="layui-btn layui-btn-danger" type="button" onclick="backStartUser()">驳回到发起人</button>
            <button class="layui-btn layui-btn-danger" type="button" onclick="backPrevious()">退回上一步</button>
            <%--<button class="layui-btn layui-btn-warm" type="button" onclick="turnToDo()">转办</button>--%>
            <%--<button class="layui-btn layui-btn-danger" type="button" onclick="backPrevious()">跳转</button>--%>
        </c:if>
        <button class="layui-btn layui-btn-primary" type="button" onclick="closeThisWindow()">关 闭</button>
    </div>
</form>
<script>
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
        getChangeFileds();
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
     * 转办
     */
    function turnToDo() {
        var params = "busId=" + processInfo.busId + "&taskId=" + processInfo.taskId + "&defId=" + processInfo.defId + "&instanceId=" + processInfo.instanceId;
        var url = "${webRoot}/act/deal/toTurnToDo?" + params;
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["转办弹框", true],
            area: ['70%', '70%'], //宽高
            content: [url, 'no'],
            shadeClose: false,
        });
    }

    /**
     * 驳回到任务发起人，重新编辑之后再提交
     */
    function backStartUser() {
        confirm("确认驳回此任务吗?", function () {
            var url = "${webRoot}/act/deal/backStartUser";
            var params = {
                'busId': processInfo.busId,
                'taskId': processInfo.taskId,
                'instanceId': processInfo.instanceId,
                'defId': processInfo.defId
            };
            var fileArr = processInfo.changeFields;
            for (var i = 0; i < fileArr.length; i++) {
                var fieldName = fileArr[i];
                if (fieldName == '') {
                    continue;
                }
                //父级搜索表单
                var fieldValue = $("#" + fieldName + "").val();
                params[fieldName] = fieldValue;
            }
            var remark = $("#remark").val();
            params["remark"] = remark;
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    alert(result, function () {
                        //刷新父窗口列表
                        parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    });
                } else {
                    alertMsg(result.msg);
                }
            });
        });
    }

    /**
     * 退回任务上一处理节点
     */
    function backPrevious() {
        confirm("确认退回此任务吗?", function () {
            var url = "${webRoot}/act/deal/backPrevious";
            var params = {
                'busId': processInfo.busId,
                'taskId': processInfo.taskId,
                'instanceId': processInfo.instanceId,
                'defId': processInfo.defId
            };
            var fileArr = processInfo.changeFields;
            for (var i = 0; i < fileArr.length; i++) {
                var fieldName = fileArr[i];
                if (fieldName == '') {
                    continue;
                }
                //父级搜索表单
                var fieldValue = $("#" + fieldName + "").val();
                params[fieldName] = fieldValue;
            }
            var remark = $("#remark").val();
            params["remark"] = remark;
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

    /**
     * 办理任务
     */
    function clickSubmit() {

        confirm("确认办理此任务吗?", function () {

            var url = "${webRoot}/act/deal/doActTask";
            var userIds = new Array();
            $("#userTab input[name='userIds']").each(function () {
                userIds.push($(this).val());
            });
//        if( (typeof(userIds) == 'undefined' || userIds.length<1) && processInfo.isSelectUser != false){
//            alertMsg("至少选择一个下级审批用户");
//            return false;
//        }
            var params = {
                'busId': processInfo.busId,
                'taskId': processInfo.taskId,
                'instanceId': processInfo.instanceId,
                'defId': processInfo.defId,
                'varValue': processInfo.varValue,
                'varName': processInfo.varName,
                'nodeType': processInfo.nodeType,
                'nextUserIds': userIds.join(",")
            };
            var remark = $("#remark").val();
            params["remark"] = remark;

            $.post(url, params, function (result) {
                if (result.code == '0') {
                    alert(result, function () {
                        //刷新父窗口列表
                        parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    });
                } else {
                    alertMsg(result.msg);
                }
            });

        });
    }

    /**
     * 申请办理任务
     */
    function applyTaskHandle(actKey, busId, instanceId, taskId, defId, nodeType, currentUserId) {
        confirm("确认申请办理此任务吗?", function () {

            var params = {
                'busId': busId,
                'taskId': taskId,
                'instanceId': instanceId,
                'defId': defId,
                'toUserId': currentUserId
            };
            var url = "${webRoot}/act/deal/applyTaskHandle";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    alert(result, function () {
                        // 刷新父窗口列表
                        parent.location.reload();
                        // 刷新列表
                        window.location.reload();
                    })
                } else {
                    alertMsg(result.msg);
                    // 刷新列表
                    window.location.reload();
                }
            }, "json");
        });
    }
</script>

