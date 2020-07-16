<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<script src="${webRoot}/js/jspdf/html2canvas.js"></script>
<script src="${webRoot}/js/jspdf/jspdf.debug.js"></script>

<form action="" id="actFieldForm">
    <div class="row" style="margin-top: 25px;margin-left: 20px" align="center">
        <div class="col-sm-12" align="center" style="margin-top: 30px;">
            <div class="col-sm-4"></div>
            <c:if test="${operationFlag == true && info.applicationStatus =='1'}">
                <div class="col-sm-1">
                    <button class="layui-btn" type="button" onclick="doPass()">通过</button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn" type="button" onclick="doUpdate()">保存</button>
                </div>
                <%--<div class="col-sm-1">--%>
                    <%--<button class="layui-btn layui-btn-warm" type="button" onclick="goTurnToRecheckAuditView()">转入复审--%>
                    <%--</button>--%>
                <%--</div>--%>
            </c:if>
            <c:if test="${operationFlag == true && info.applicationStatus == '2'}">
                <div class="col-sm-1">
                    <button class="layui-btn" type="button" onclick="doPass()">通过</button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-warm" type="button"
                            onclick="goBackView()">
                        退回至初审
                    </button>
                </div>
            </c:if>
            <c:if test="${operationFlag == true && (info.applicationStatus =='1' || info.applicationStatus == '2')}">
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger" type="button"
                            onclick="goRejectView()">
                        拒绝
                    </button>
                </div>
            </c:if>
            <c:if test="${operationFlag == true && info.applicationStatus =='3'}">
                <div class="col-sm-1">
                    <button class="layui-btn" type="button"
                            onclick="doRemittance(1)">
                        网银汇款
                    </button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn  layui-btn-normal" type="button"
                            onclick="doRemittance(2)">
                        支票汇款
                    </button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-warm" type="button"
                            onclick="goBackView()">
                        退回至初审
                    </button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger" type="button"
                            onclick="goRejectView()">
                        拒绝
                    </button>
                </div>
            </c:if>
            <c:if test="${operationFlag == true && info.applicationStatus =='4'}">
                <div class="col-sm-1">
                    <button class="layui-btn" type="button"
                            onclick="goWithdrawSucView()">
                        汇款成功
                    </button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger" type="button"
                            onclick="goWithdrawFailView()">
                        汇款失败
                    </button>
                </div>
            </c:if>
            <c:if test="${info.applicationStatus == '5' && info.applicationStatus !='10' && info.applicationStatus !='11'}">
                <shiro:hasPermission name="clientFundWithdraw:refund">
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger" type="button"
                            onclick="doRefund('${info.applicationId}')">
                        退款待入账
                    </button>
                </div>
                </shiro:hasPermission>
            </c:if>
            <div class="col-sm-1">
                <button class="layui-btn  layui-btn-normal" type="button"
                        onclick="print()">打印
                </button>
            </div>
            <div class="col-sm-1">
                <button class="layui-btn layui-btn-primary" type="button" onclick="closeThisWindow()">返 回</button>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript">
    function print() {
        //判断浏览器内核是否是IE
        if(!!window.ActiveXObject || "ActiveXObject" in window){
            alert('截图打印暂不支持IE内核浏览器，请更换火狐或谷歌chrome内核浏览器，360等双核浏览器请切换至极速模式');
            return;
        }
        var loading = layer.msg('文件生成中...', {icon: 16, shade: 0.01});
        var pdf = new jsPDF('l','pt','a4');
        // 设置打印比例 越大打印越小
        pdf.internal.scaleFactor = 1.8;
        var options = {
            pagesplit: true, //设置是否自动分页
            "background": '#FFFFFF'   //如果导出的pdf为黑色背景，需要将导出的html模块内容背景 设置成白色。
        };
        var printHtml = $('#div10').get(0);   // 页面某一个div里面的内容，通过id获取div内容
        pdf.addHTML(printHtml,15, 15, options,function() {
            layer.close(loading);
            pdf.output('datauri');
        });
    }

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

    // 通过
    function doPass() {
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
                    toast(result, function () {
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

    function doUpdate() {
        confirm("确定执行此操作吗？", function () {
            var url = "${webRoot}/clientFundWithdraw/update";
            var params = {
                'applicationId':${info.applicationId},
                'clientNameSpell':  $("#clientNameSpell").val()
            };
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    toast(result, function () {
                        window.location.reload();
                    })
                } else {
                    alertMsg(result.msg);
                }
            });

        });
    }

    // 拒绝
    function doReject(busId, taskId, defId, instanceId, actKey) {
        if (busId == "") {
            alertMsg("业务ID不能为空");
            return;
        }
        if (taskId == "") {
            alertMsg("任务ID不能为空");
            return;
        }
        if (defId == "") {
            alertMsg("流程定义ID不能为空");
            return;
        }
        if (instanceId == "") {
            alertMsg("实例ID不能为空");
            return;
        }

        confirm("确定执行此操作吗？", function () {
            var params = "busId=" + busId + "&taskId=" + taskId + "&defId=" + defId + "&instanceId=" + instanceId + "&actKey=" + actKey + "&approvalOpinion=" + $("#remark").val();

            var url = "${webRoot}/clientFundWithdraw/doReject";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result, function () {
                        // 刷新父窗口列表
                        parent.location.reload();
                        // 关闭弹框
                        closeThisWindow();
                    })
                } else {
                    alertMsg(result.msg);
                }
            }, "json");
        });
    }

    // 拒绝弹窗页面
    function goRejectView() {

        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&defId=" + '${taskDto.defId}' + "&instanceId=" + '${taskDto.instanceId}';

        var url = "${webRoot}/clientFundWithdraw/goRejectView?" + params;

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["拒绝操作", true],
            area: ['50%', '60%'],
            content: [url, 'yes']
        });
    }

    // 退回至初审弹窗页面
    function goBackView() {

        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&defId=" + '${taskDto.defId}' + "&instanceId=" + '${taskDto.instanceId}';

        var url = "${webRoot}/clientFundWithdraw/goBackView?" + params;

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["退回操作", true],
            area: ['50%', '60%'],
            content: [url, 'yes']
        });
    }

    // 出金失败页面
    function goWithdrawFailView() {

        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&defId=" + '${taskDto.defId}' + "&instanceId=" + '${taskDto.instanceId}';

        var url = "${webRoot}/clientFundWithdraw/goWithdrawFailView?" + params;

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["汇款失败操作", true],
            area: ['50%', '60%'],
            content: [url, 'yes']
        });
    }

    // 出金成功页面
    function goWithdrawSucView() {

        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&defId=" + '${taskDto.defId}' + "&instanceId=" + '${taskDto.instanceId}';

        var url = "${webRoot}/clientFundWithdraw/goWithdrawSucView?" + params;

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["汇款成功页面", true],
            area: ['65%', '95%'],
            content: [url, 'yes']
        });
    }

    // 出金成功
    function doWithdrawSuc() {
        confirm("确定执行此操作吗？", function () {
            var url = "${webRoot}/clientFundWithdraw/doWithdrawSuc";
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
                }
            });

        });
    }

    // 终审通过
    function doFinalAuditPass() {
        confirm("确定执行此操作吗？", function () {
            var url = "${webRoot}/clientFundWithdraw/doFinalAuditPass";
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
                }
            });

        });
    }

    // 终审退回页面
    function goReturnView() {

        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&defId=" + '${taskDto.defId}' + "&instanceId=" + '${taskDto.instanceId}';

        var url = "${webRoot}/clientFundWithdraw/goReturnView?" + params;

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["退回操作", true],
            area: ['50%', '60%'],
            content: [url, 'yes']
        });
    }

    // 初审通过
    function doInitialAuditPass() {
        confirm("确定执行此操作吗？", function () {
            var url = "${webRoot}/clientFundWithdraw/doInitialAuditPass";
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
                }
            });

        });
    }

    // 转入复审弹窗页面
    function goTurnToRecheckAuditView() {

        var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&defId=" + '${taskDto.defId}' + "&instanceId=" + '${taskDto.instanceId}';

        var url = "${webRoot}/clientFundWithdraw/goTurnToRecheckAuditView?" + params;

        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["转入复审", true],
            area: ['50%', '60%'],
            content: [url, 'yes']
        });
    }

    // 汇款
    function doRemittance(remittanceType) {
        confirm("确定执行此操作吗？", function () {
            var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&instanceId=" + '${taskDto.instanceId}' + "&defId=" + '${taskDto.defId}'
                + "&remark=" + '${taskDto.remark}'
                + "&remittanceType=" + remittanceType;

            var url = "${webRoot}/clientFundWithdraw/doRemittance";
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

    // 发起退款申请
    function doRefund(applicationId) {

        confirm("确定执行此操作吗？", function () {
            var params = "applicationId=" + applicationId;

            var url = "${webRoot}/fundWithdrawRefund/doRefund";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result, function () {
                        // 刷新父窗口列表
                        parent.location.reload();
                        // 关闭弹框
                        closeThisWindow();
                    })
                } else {
                    alertMsg(result.msg);
                }
            }, "json");
        });
    }

</script>