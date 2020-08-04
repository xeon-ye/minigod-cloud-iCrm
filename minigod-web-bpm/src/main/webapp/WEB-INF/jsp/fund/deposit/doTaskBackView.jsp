<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>退回理由</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
</head>
<body>
<div class="main-container" id="main-container">
    <div id="div6" v-cloak>
        <c:if test="${info.applicationStatus == '3'}">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">退回节点</b></div>
                </br>
                <div style="margin-left: 5%;width: 90%">
                       <span class="col-xs-4 block input-icon input-icon-right">
                           <input type="radio" name="backFlag" value="1" checked="true"/>退回至客服
                       </span>
                    <span class="col-xs-4 block input-icon input-icon-right">
                             <input type="radio" name="backFlag" value="3"/>退回至客户
                        </span>
                </div>
                </br> </br>
            </div>
        </c:if>

        <c:if test="${info.applicationStatus == '4'}">
            <div v-show="!showList" class="panel panel-default">
                </br>
                <div style="margin-left: 5%;width: 90%">
                       <span class="col-xs-4 block input-icon input-icon-right">
                                <input type="radio" name="backFlag" value="1" checked="true"/>退至客服
                       </span>
                    <span class="col-xs-4 block input-icon input-icon-right">
                             <input type="radio" name="backFlag" value="2"/>退至结算(初审)
                        </span>
                    <span class="col-xs-4 block input-icon input-icon-right">
                             <input type="radio" name="backFlag" value="3"/>退至客户
                        </span>
                </div>
                </br> </br>
            </div>
        </c:if>
    </div>

    <div id="div7" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">退回原因</b></div>

            <div style="margin-left: 5%;width: 99%;height: 400px;">

                <c:forEach var="codeEntity" items="${backTypes}" varStatus="i">
                    <c:if test="${codeEntity.value>=11}">
                        <c:if test="${((i.index % 2) eq 0) && i.index==0}">
                            <br/>
                        </c:if>

                        <c:if test="${(((i.index % 2) eq 0) && i.index >0)}">
                            <br/><br/>
                        </c:if>
                        <span class="col-xs-11 block input-icon input-icon-right" style="margin-top: 10px;font-size:15px">
                        <input type="checkbox" name="errorContentTypes" id="errorContentTypes_${codeEntity.value}"
                               value="${codeEntity.value}" onclick="onChange(this.value)"/>${codeEntity.name}<br/>
                        </span>
                    </c:if>
                    <c:if test="${codeEntity.value==0}">
                        <span class="col-xs-3 block input-icon input-icon-right" style="margin-top: 10px;font-size:15px">
                        <input type="checkbox" name="errorContentTypes" id="errorContentTypes_${codeEntity.value}"
                               value="${codeEntity.value}" onclick="onChange(this.value)"/>${codeEntity.name}
                        </span>
                        <span class="col-xs-7 block input-icon" style="margin-top: 10px;">
                            <input class="form-control" name="otherReasons" id="otherReasons" type="text"
                                   placeholder="不超过50个字符">
                        </span>
                    </c:if>
                </c:forEach>
            </div>
            <br/>
        </div>
    </div>
    <div id="div8" v-cloak>
        <div class="row" style="margin-left: 40%;padding-bottom: 28px;margin-top: 15px;">
            <button class="layui-btn " type="button" onclick="doBack()">提交</button>
            <button class="layui-btn layui-btn-primary" type="button" onclick="closeThisWindow()">关 闭</button>
        </div>
    </div>

</div>

</body>
<script>
    /**
     * 流程相关信息类
     */
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

    //其他原因跟另外的原因不能同时选择
    function onChange(value) {
        if ($("input[name='errorContentTypes']").is(':checked')) {
            if (value != '0') {
                document.getElementById("otherReasons").style.display = "none";
                $("input[name='errorContentTypes']").attr("disabled", false);
                document.getElementById("errorContentTypes_0").disabled = true;
            } else {
                document.getElementById("otherReasons").style.display = "inline";
                $("input[name='errorContentTypes']").attr("disabled", true);
                document.getElementById("errorContentTypes_0").disabled = false;
            }
        } else {
            document.getElementById("otherReasons").style.display = "inline";
            $("input[name='errorContentTypes']").attr("disabled", false);
            document.getElementById("errorContentTypes_0").disabled = false;
        }
    }

    /**
     * 退回
     */
    function doBack() {
        var errorContentTypesArray = []; //退回理由
//        var errorImagesArray = [];	 //错误图片  location-locationType
        var backFlag = $("input[name='backFlag']:checked").val();//退回节点
        var backReasonTypeArray = [];
        var errorContentTypes = "";
        var otherReasons = $("#otherReasons").val();

        $('input[name="errorContentTypes"]:checked').each(function () {
            errorContentTypesArray.push($(this).val());
            backReasonTypeArray.push($(this).val());
        });
        if (backReasonTypeArray == "") {
            alertMsg("请勾选退回理由");
            return;
        }
        var backReasonType = "[" + backReasonTypeArray.toString() + "]";

        if (errorContentTypesArray != "") {
            errorContentTypes = errorContentTypesArray.toString();
        }

        if (null == backFlag || "undefined" == typeof(backFlag) || "" == backFlag) {
            backFlag = "";
        }

        confirm("确认退回此任务吗?", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&instanceId=" + '${taskDto.instanceId}' + "&defId=" + '${taskDto.defId}'
                + "&remark=" + '${taskDto.remark}' + "&backFlag=" + backFlag + "&backReasonType=" + backReasonType
                + "&errorContentTypes=" + errorContentTypes
                + "&otherReasons=" + otherReasons;

            var url = "${webRoot}/clientFundDeposit/doBack";
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    alert(result, function () {
                        //刷新父窗口列表
                        parent.parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    });
                } else {
                    alertMsg(result.msg);
                    layer.close(loading);
                }
            });
        });
    }


</script>

</html>