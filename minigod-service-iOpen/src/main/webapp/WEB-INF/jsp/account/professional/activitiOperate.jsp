<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<form action="" id="actFieldForm">
    <div class="row" style="margin-top: 25px;margin-left: 20px" align="center">
        <div class="col-sm-12" align="center" style="margin-top: 30px;">
            <div class="col-sm-4"></div>
            <c:if test="${operationFlag == 1}">
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-radius" type="button"
                            onclick="doPass()">通过
                    </button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger layui-btn-radius" type="button"
                            onclick="tobackView()">退回
                    </button>
                </div>
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger layui-btn-radius" type="button"
                            onclick="doTermination()">终止
                    </button>
                </div>
            </c:if>
            <div class="col-sm-1">
                <button class="layui-btn layui-btn-primary layui-btn-radius" type="button" onclick="closeThisWindow()">返
                    回
                </button>
            </div

            <c:if test="${operationFlag == 3}">
                <div class="col-sm-1">
                    <button class="layui-btn layui-btn-danger layui-btn-radius" type="button"
                            onclick="doRevoke()">撤销专业投资者身份
                    </button>
                </div>
            </c:if>
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
    });

    // 通过
    function doPass() {
        confirm("确定执行此操作吗？", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var url = "${webRoot}/act/deal/doActTask";
            var params = {
                'busId': '${taskDto.busId}',
                'taskId': '${taskDto.taskId}',
                'instanceId': '${taskDto.instanceId}',
                'defId': '${taskDto.defId}'
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

    // 终止
    function doTermination() {
        confirm("确定执行此操作吗？", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var url = "${webRoot}/professionalInvestor/doTermination";
            var params = {
                'busId': '${taskDto.busId}',
                'taskId': '${taskDto.taskId}',
                'instanceId': '${taskDto.instanceId}',
                'defId': '${taskDto.defId}'
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

    //跳转退回页面
    function tobackView() {
        var url = "${webRoot}/professionalInvestor/tobackView?applicationId=" + '${taskDto.busId}' + "&remark=" + $("#remark").val() + "&applicationStatus= " +${info.applicationStatus};

        // 弹框层
        layer.open({
            scrollbar: true,
            type: 2,
            title: ["退回节点", true],
            area: ['60%', '80%'],
            content: [url, 'yes']
        });
    }

    // 撤销
    function doRevoke() {
        var revokeReson = $("#revokeReson").val();
        if(revokeReson==null||revokeReson==""){
            alertMsg("请输入撤销原因");
            return;
        }
        confirm("确定执行此操作吗？", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var url = "${webRoot}/professionalInvestor/doRevoke";
            var params = {
                'applicationId': '${info.applicationId}',
                'revokeReson':revokeReson
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

</script>