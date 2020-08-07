<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<form action="" id="actFieldForm">
    <div class="row">
        <div class="form-group col-sm-8 ">
            <label class="control-label col-sm-2" style="padding-left: 45px;">审批意见</label>
            <div class="col-sm-10">
                <div class="form-group">
                    <textarea name="remark" id="remark" class="form-control" rows="3"></textarea>
                </div>
            </div>
        </div>
    </div>


    <div class="row" style="margin-top: 20px;margin-left: 20px" align="center">
        <div class="col-sm-12" align="center">
            <div class="col-sm-3"></div>
            <c:if test="${taskDto.dealId == '' || taskDto.dealId ==null}">
                <div class="col-sm-1">
                    <button class="layui-btn" type="button"
                            onclick="applyTaskHandle('${taskDto.actKey}','${taskDto.busId}','${taskDto.instanceId}','${taskDto.taskId}','${taskDto.defId}','${taskDto.nodeType}','${currentUserId}')">
                        申请办理
                    </button>
                </div>
            </c:if>

            <c:if test="${taskDto.dealId == currentUserId}">
                <div class="col-sm-1">
                    <button class="layui-btn" type="button" onclick="clickSubmit()">同意</button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger" type="button" onclick="goBackView()">退回</button>
                </div>

                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger" type="button"
                            onclick="doRejectTermination('${taskDto.busId}','${taskDto.taskId}','${taskDto.defId}','${taskDto.instanceId}','${taskDto.actKey}')">
                        终止
                    </button>
                </div>
                <%--<c:if test="${accountOpenApplicationEntity.applicationStatus == '3'}">
                    <div class="col-sm-1">
                        <button class="layui-btn layui-btn-danger" type="button"
                                onclick="doReject('${taskDto.busId}','${taskDto.taskId}','${taskDto.defId}','${taskDto.instanceId}','${taskDto.actKey}')">
                            拒绝
                        </button>
                    </div>
                </c:if>--%>

                <%--</c:if>--%>

            </c:if>
            <div class="col-sm-1">
                <button class="layui-btn layui-btn-primary" type="button" onclick="closeThisWindow()">关 闭</button>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 20px;margin-left: 20px">
        <div class="col-sm-10">

        </div>
        <c:if test="${accountOpenApplicationEntity.applicationStatus == '3'}">
            <div class="col-sm-1">
                <button class="layui-btn layui-btn-danger" type="button"
                        onclick="doRejectBlackList('${taskDto.busId}','${taskDto.taskId}','${taskDto.defId}','${taskDto.instanceId}','${taskDto.actKey}')">
                    拒绝并放入黑名单
                </button>
            </div>
        </c:if>
    </div>
</form>
<script>

    /*
     * 终止
     */
    function doRejectTermination(busId, taskId, defId, instanceId, actKey) {
        var param = "&busId=" + busId + "&taskId=" + taskId + "&defId=" + defId + "&instanceId=" + instanceId + "&actKey=" + actKey;
        confirm("确认终止流程吗?", function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            //var applicationId = busId;
            var approvalOpinion = $("#remark").val();
            var params = "approvalOpinion=" + approvalOpinion + param;
            var url = "${webRoot}/customer/doRejectTermination";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {

                    layer.close(loading);

                    alert(result, function () {
                        window.parent.location.reload();
                    })
                } else {

                    layer.close(loading);
                    alertMsg(result.msg);
                }
            }, "json");
        });
    }

    /*
     * 拒绝
     */
    function doReject(busId, taskId, defId, instanceId, actKey) {
        var param = "&busId=" + busId + "&taskId=" + taskId + "&defId=" + defId + "&instanceId=" + instanceId + "&actKey=" + actKey;
        confirm("确认拒绝流程吗?", function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            //var applicationId = busId;
            var approvalOpinion = $("#remark").val();
            var params = "approvalOpinion=" + approvalOpinion + param;
            var url = "${webRoot}/customer/doReject";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    layer.close(loading);
                    alert(result, function () {
                        window.parent.location.reload();
                    })
                } else {
                    layer.close(loading);
                    alertMsg(result.msg);
                }
            }, "json");
        });
    }

    /*
     * 拒绝并加入黑名单
     */
    function doRejectBlackList(busId, taskId, defId, instanceId, actKey) {
        var param = "&busId=" + busId + "&taskId=" + taskId + "&defId=" + defId + "&instanceId=" + instanceId + "&actKey=" + actKey;
        confirm("确认拒绝并加入黑名单吗?", function () {
            var approvalOpinion = $("#remark").val();
            var params = "approvalOpinion=" + approvalOpinion + param;
            var url = "${webRoot}/customer/doRejectBlackList";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    alert(result, function () {
                        window.parent.location.reload();
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
    function processInfo(busId, actKey, taskId, instanceId, changeFields, defId, taskName) {
        this.busId = busId;//业务id
        this.actKey = actKey;//流程key也是业务key
        this.taskId = taskId;//任务id
        this.instanceId = instanceId;//流程实例
        this.changeFields = changeFields;//可更改的字段
        this.defId = defId;//流程定义id
        this.taskName = taskName;//处理任务
    }

    var processInfo = new processInfo();
    $(function () {

        //获取业务可更改的字段，和流程业务基本信息
        processInfo.busId = '${taskDto.busId}';
        processInfo.taskId = '${taskDto.taskId}';
        processInfo.instanceId = '${taskDto.instanceId}';
        processInfo.defId = '${taskDto.defId}';
        processInfo.taskName = '${taskDto.taskName}';
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

    /*
    *开户审批退回弹出页面
    */
    function goBackView() {
        if ($("#remark").val() == "") {
            alertMsg("请填写审批意见");
            return;
        }

        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&defId=" + '${taskDto.defId}' + "&instanceId=" + '${taskDto.instanceId}'
            + "&remark=" + $("#remark").val();
        var url = "${webRoot}/customer/doTaskBackView?" + params;
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["退回理由", true],
            area: ['60%', '95%'], //宽高
            content: [url, 'yes']
        });
    }


    /**
     * 办理任务
     */
    function clickSubmit() {
        if (${accountOpenApplicationEntity.applicationStatus == 2 }) {

            var creditQuota = $("#creditQuota").val();
            var creditRatio = $("#creditRatio").val();

            confirm("确认办理此任务吗?", function () {

                var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

                var url = "${webRoot}/act/deal/doActMarginTask";
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
                    'applicationId': '${customerAccountOpenInfoEntity.applicationId}',
                    'applicationStatus': '${accountOpenApplicationEntity.applicationStatus}',
                    'creditQuota': creditQuota,
                    'creditRatio': creditRatio,
                    'nextUserIds': userIds.join(",")
                };
                var remark = $("#remark").val();
                params["remark"] = remark;
                $.post(url, params, function (result) {
                    if (result.code == '0') {

                        layer.close(loading);

                        if (${accountOpenApplicationEntity.applicationStatus == '2'}) {
                            alert(result, function () {
                                //刷新父窗口列表
                                parent.location.reload();
                                //关闭弹框
                                closeThisWindow();
                            });
                        } else {
                            alert(result, function () {
                                //刷新父窗口列表
                                parent.location.reload();
                                //关闭弹框
                                closeThisWindow();
                            });
                        }
                    } else {
                        layer.close(loading);
                        alertMsg(result.msg);
                    }
                });

            });
        } else if (${accountOpenApplicationEntity.applicationStatus == 1 }) {
            var creditQuota = $("#creditQuota").val();
            var creditRatio = $("#creditRatio").val();

            confirm("确认办理此任务吗?", function () {

                var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

                var url = "${webRoot}/act/deal/doActMarginTask";
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
                    'applicationId': '${customerAccountOpenInfoEntity.applicationId}',
                    'applicationStatus': '${accountOpenApplicationEntity.applicationStatus}',
                    'creditQuota': creditQuota,
                    'creditRatio': creditRatio,
                    'nextUserIds': userIds.join(",")
                };
                var remark = $("#remark").val();
                params["remark"] = remark;
                $.post(url, params, function (result) {
                    if (result.code == '0') {

                        layer.close(loading);

                        if (${accountOpenApplicationEntity.applicationStatus == '2'}) {
                            alert(result, function () {
                                //刷新父窗口列表
                                parent.location.reload();
                                //关闭弹框
                                closeThisWindow();
                            });
                        } else {
                            alert(result, function () {
                                //刷新父窗口列表
                                parent.location.reload();
                                //关闭弹框
                                closeThisWindow();
                            });
                        }
                    } else {
                        layer.close(loading);
                        alertMsg(result.msg);
                    }
                });

            });

        } else {
            var creditQuota = $("#creditQuota").val();
            var creditRatio = $("#creditRatio").val();

            confirm("确认办理此任务吗?", function () {

                var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

                var url = "${webRoot}/act/deal/doActMarginTask";
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
                    'applicationId': '${customerAccountOpenInfoEntity.applicationId}',
                    'applicationStatus': '${accountOpenApplicationEntity.applicationStatus}',
                    'creditQuota': creditQuota,
                    'creditRatio': creditRatio,
                    'nextUserIds': userIds.join(",")
                };
                var remark = $("#remark").val();
                params["remark"] = remark;
                $.post(url, params, function (result) {
                    if (result.code == '0') {

                        layer.close(loading);

                        if (${accountOpenApplicationEntity.applicationStatus == '2'}) {
                            alert(result, function () {
                                //刷新父窗口列表
                                parent.location.reload();
                                //关闭弹框
                                closeThisWindow();
                            });
                        } else {
                            alert(result, function () {
                                //刷新父窗口列表
                                parent.location.reload();
                                //关闭弹框
                                closeThisWindow();
                            });
                        }
                    } else {
                        layer.close(loading);
                        alertMsg(result.msg);
                    }
                });

            });
        }

    }

    /**
     * 申请办理任务
     */
    function applyTaskHandle(actKey, busId, instanceId, taskId, defId, nodeType, currentUserId) {
        confirm("确认申请办理此任务吗?", function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

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

                    layer.close(loading);

                    alert(result, function () {
                        // 刷新父窗口列表
                        parent.location.reload();
                        // 刷新列表
                        window.location.reload();
                    })
                } else {

                    layer.close(loading);

                    alertMsg(result.msg);
                    // 刷新列表
                    window.location.reload();
                }
            }, "json");
        });
    }

    /**
     * 编辑资料
     * @param actKey
     * @param busId
     */
    function openAccountInfoEdit(applicationId) {
        var url = webRoot + "/customer/viewCustomerAccountInfo?applicationId=" + applicationId;
//        //弹框层
//        layer.open({
//            scrollbar: false,
//            type: 2,
//            title : ["编辑资料" , true],
//            area: ['100%', '100%'], //宽高
//            content: [url,'yes'],
//            shadeClose : false,
//        });
        window.location.href = url;
    }

    /**
     * 补充资料
     */
    function supDetail() {
        if ($("#supFlag").val() == 0) {
            for (var i = 0; i < 3; i++) {
                $("#supButton" + i).removeAttr("style", "display:none").attr("style", "display:line");
                $("#supFlag").val('1');
            }
        } else if ($("#supFlag").val() == 1) {
            for (var i = 0; i < 3; i++) {
                $("#supButton" + i).removeAttr("style", "display:line").attr("style", "display:none");
                $("#supFlag").val('0');
            }
        }
    }

</script>

