<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<form action="" id="actFieldForm">
    <div class="row">
        <<div class="form-group col-sm-8 ">
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
                <c:if test="${openImgModified == 0 and supImgModified == 0 }">
                    <div class="col-sm-1">
                        <button class="layui-btn" type="button" onclick="clickSubmit()">同意</button>
                    </div>

                </c:if>

                <c:if test="${accountOpenApplicationEntity.applicationStatus == '3'}">
                    <div class="col-sm-1">
                        <button class="layui-btn layui-btn-danger" type="button" onclick="backPrevious()">退回</button>
                    </div>
                </c:if>

                <c:if test="${accountOpenApplicationEntity.applicationStatus == '1' || accountOpenApplicationEntity.applicationStatus == '2'}">
                    <c:if test="${openImgModified == 1 and supImgModified == 0 }">
                        <div class="col-sm-1">
                            <button class="layui-btn " type="button" onclick="openAccountInfoEdit(${taskDto.busId});">编辑资料</button>
                        </div>
                    </c:if>
                    <c:if test="${openImgModified == 0 and supImgModified == 1 }">
                        <div class="col-sm-1">
                            <button class="layui-btn " type="button"
                                    onclick="addSupInformation('${customerAccountOpenInfoEntity.applicationId}')">补充材料
                            </button>
                        </div>
                    </c:if>
                    <c:if test="${openImgModified == 0 and supImgModified == 0 }">
                        <div class="col-sm-1">
                            <button class="layui-btn " type="button" onclick="openAccountInfoEdit(${taskDto.busId});">编辑资料</button>
                        </div>
                        <div class="col-sm-1">
                            <button class="layui-btn " type="button"
                                    onclick="addSupInformation('${customerAccountOpenInfoEntity.applicationId}')">补充材料
                            </button>
                        </div>
                    </c:if>
                </c:if>

                <c:if test="${openImgModified==0 and supImgModified == 0 }">
                    <div class="col-sm-1">
                        <button class="layui-btn layui-btn-danger" type="button"
                                onclick="doRejectTermination('${taskDto.busId}','${taskDto.taskId}','${taskDto.defId}','${taskDto.instanceId}','${taskDto.actKey}')">
                            终止
                        </button>
                    </div>

                </c:if>
                <c:if test="${accountOpenApplicationEntity.applicationStatus == '3'}">
                    <div class="col-sm-1">
                        <button class="layui-btn layui-btn-danger" type="button"
                                onclick="doReject('${taskDto.busId}','${taskDto.taskId}','${taskDto.defId}','${taskDto.instanceId}','${taskDto.actKey}')">
                            拒绝
                        </button>
                    </div>
                </c:if>

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
    function doRejectTermination(busId, taskId, defId, instanceId,actKey) {
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
       var param = "&busId=" + busId + "&taskId=" + taskId + "&defId=" + defId + "&instanceId=" + instanceId+ "&actKey=" + actKey;
        confirm("确认终止流程吗?", function () {
            var remark = $("#remark").val();
            var params = "remark=" + remark + param;
            var url = "${webRoot}/offlineCustAccOpen/doRejectTermination";
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
        var param = "&busId=" + busId + "&taskId=" + taskId + "&defId=" + defId + "&instanceId=" + instanceId+ "&actKey=" + actKey;
        confirm("确认拒绝流程吗?", function () {
            //var applicationId = busId;
            var remark = $("#remark").val();
            var params = "remark=" + remark + param;
            var url = "${webRoot}/offlineCustAccOpen/doReject";
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

    /*
     * 拒绝并加入黑名单
     */
    function doRejectBlackList(busId, taskId, defId, instanceId,actKey) {
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
        var param = "&busId=" + busId + "&taskId=" + taskId + "&defId=" + defId + "&instanceId=" + instanceId+ "&actKey=" + actKey;
        confirm("确认拒绝并加入黑名单吗?", function () {
            var remark = $("#remark").val();
            var params = "remark=" + remark + param;
            var url = "${webRoot}/offlineCustAccOpen/doRejectBlackList";
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

    /**
     * 退回任务上一处理节点
     */
    function backPrevious() {
        if ($("#remark").val() == "") {
            alertMsg("请填写审批意见");
            return;
        }
        var backFlag ='2';//退回节点

        confirm("确认退回此任务吗?", function () {
            var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&defId=" + '${taskDto.defId}' + "&instanceId=" + '${taskDto.instanceId}'
                + "&remark=" + $("#remark").val() + "&backFlag=" + backFlag
            var url = "${webRoot}/customer/doBack";
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
     * 办理任务
     */
    function clickSubmit() {
        if(${accountOpenApplicationEntity.applicationStatus == 2 }){
            var isAmlSuspicious = $('input[name="isAmlSuspicious"]').filter(':checked').val();
            if(isAmlSuspicious==null || isAmlSuspicious==''){
                alertMsg("请勾选该申请人有无AML可疑信息");
            }else if($("#amlFlag").val()== "true"){
                alertMsg("请上传aml证明文件")
            }else{
                confirm("确认办理此任务吗?", function () {
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
                            alertMsg(result.msg);
                        }
                    });

                });
            }
        }else{
            confirm("确认办理此任务吗?", function () {
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

    /**
     * 编辑资料
     * @param actKey
     * @param busId
     */
    function openAccountInfoEdit(applicationId) {
        var url = webRoot + "/offlineCustAccOpen/custAccOpenEdit?applicationId=" + applicationId;
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

