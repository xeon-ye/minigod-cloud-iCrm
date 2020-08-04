<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<form action="" id="actFieldForm">
    <div class="row" style="margin-top: 25px;margin-left: 20px" align="center">
        <div class="col-sm-12" align="center" style="margin-top: 30px;">
            <div class="col-sm-4"></div>
            <c:if test="${operationFlag == 1 && info.applicationStatus =='1'}">
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-radius" type="button" onclick="doPass()">通过</button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-warm layui-btn-radius" type="button"
                            onclick="toUpDate('fundDepositApplication','${info.applicationId}'
                                    ,'${info.instanceId}','','${info.defid}','','${info.assignDrafter}',2)">修改
                    </button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger layui-btn-radius" type="button"
                            onclick="tobackView()">退回
                    </button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-normal layui-btn-radius" type="button"
                            onclick="doIgnore('${info.applicationId}')">忽略
                    </button>
                </div>
            </c:if>
            <c:if test="${operationFlag == 2}">
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-radius" type="button" onclick="doUpdate()">保存</button>
                </div>
            </c:if>
            <c:if test="${operationFlag == 1 && info.applicationStatus == '4'}">
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-radius" type="button" onclick="toEntry()">授权入账</button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger layui-btn-radius" type="button"
                            onclick="tobackView()">
                        退回
                    </button>
                </div>
            </c:if>

            <c:if test="${operationFlag == 0 && info.applicationStatus =='10'}">
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-radius layui-btn-normal" type="button" onclick="doCancelIgnore('${info.applicationId}')">取消忽略</button>
                </div>
            </c:if>

            <div class="col-sm-1">
                <button class="layui-btn layui-btn-primary layui-btn-radius" type="button" onclick="closeThisWindow()">返
                    回
                </button>
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
//        if (flag == '2') {
//            getChangeFileds();
//        }
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

    // 通过
    function doPass() {
        var images = document.querySelector('#imageList${info.applicationId}0 ul');
        var count = images.childNodes.length;
        if (count == 0 || count > 5) {
            alertMsg('请上传多余1张且少于5张图片');
        } else {
            confirm("确定执行此操作吗？", function () {
                var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
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
                        toast(result, function () {
                            //刷新父窗口列表
                            parent.location.reload();
                            //关闭弹框
                            closeThisWindow();
                        })
                    } else {
                        alertMsg(result.msg);
                        layer.close(loading);
                    }
                });

            });
        }
    }

    // 通过
    function toEntry() {
        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&instanceId=" + '${taskDto.instanceId}' +
            "&defId=" + '${taskDto.defId}' + "&remark=" + '${taskDto.remark}';

        var url = "${webRoot}/clientFundDeposit/toChooseDepositBank?" + params;

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["授权入账", true],
            area: ['60%', '60%'],
            content: [url, 'yes'],
        });
    }

    //跳转退回页面
    function tobackView() {
        var url = "${webRoot}/clientFundDeposit/tobackView?applicationId=" + '${taskDto.busId}' + "&remark=" + $("#remark").val();

        // 弹框层
        layer.open({
            scrollbar: true,
            type: 2,
            title: ["退回节点", true],
            area: ['80%', '85%'],
            content: [url, 'yes']
        });
    }

    // 更新信息
    function doUpdate() {
        var images = document.querySelector('#imageList${info.applicationId}0 ul');
        var count = images.childNodes.length;
        if (count == 0 || count > 5) {
            alertMsg('请上传多余1张且少于5张图片');
        } else {
            confirm("确定执行此操作吗？", function () {
                var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
                var url = "${webRoot}/clientFundDeposit/update";
                var params = {
                    'applicationId': '${info.applicationId}',
                    'moneyType': $("#moneyType").val(),
                    'depositBalance': $("#depositBalance").val(),
                    'depositBank': $("#depositBank").val(),
                    'depositNo': $("#depositNo").val().replace(/\s*/g, ""),
                    'benefitAccount': $("#benefitAccount").val(),
                    'benefitBank': $("#benefitBank").val(),
                    'benefitNo': $("#benefitNo").val().replace(/\s*/g, ""),
                    'swiftCode': $("#swiftCode").val()
                };
                $.post(url, params, function (result) {
                    if (result.code == '0') {
                        toast(result, function () {
                            //刷新父窗口列表
                            parent.location.reload();
                            //关闭弹框
                            closeThisWindow();
                        })
                    } else {
                        alertMsg(result.msg);
                        layer.close(loading);
                    }
                });

            });
        }
    }

    // 转入修改页面
    function toUpDate(actKey, busId, instanceId, taskId, defid, nodeType, dealId, flag) {
        var url = "${webRoot}/act/deal/flowInfoTab?actKey=" + actKey + "&busId=" + busId + "&instanceId=" + instanceId
            + "&taskId=" + taskId + "&defId=" + defid + "&nodeType=" + nodeType + "&dealId=" + dealId + "&flag=" + flag;
        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["修改信息", true],
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
    }

    // 忽略
    function doIgnore(applicationId) {
        confirm("您确定要忽略吗?", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var params = {
                'applicationIds': applicationId
            };
            var url = "${webRoot}/clientFundDeposit/doIgnore";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result, function () {
                        // 刷新列表
                        parent.location.reload();
                    })
                } else {
                    layer.close(loading);
                    alertMsg(result.msg);
                    // 刷新列表
                    parent.location.reload();
                }
            }, "json");
        });
    }

    // 取消忽略
    function doCancelIgnore(applicationIds) {
        confirm("您确定要取消忽略吗?", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var params = {
                'applicationIds': applicationIds
            };
            var url = "${webRoot}/clientFundDeposit/cancelIgnore";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result, function () {
                        // 刷新列表
                        parent.location.reload();
                    })
                } else {
                    layer.close(loading);
                    alertMsg(result.msg);
                    // 刷新列表
                    parent.location.reload();
                }
            }, "json");
        });
    }

</script>