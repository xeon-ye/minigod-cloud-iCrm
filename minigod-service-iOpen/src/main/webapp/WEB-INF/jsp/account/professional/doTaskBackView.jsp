<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>退回页面</title>
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
        <c:if test="${applicationStatus == '2'}">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">退回节点</b></div>
                <br>
                <div class ="panel-body" style="margin-left: 5%;width: 90%;height: auto">
                    <span class="col-xs-4 block input-icon input-icon-right">
                        <input type="radio" name="backFlag" value="1" checked="true"/>退至客服
                    </span>
                    <span class="col-xs-4 block input-icon input-icon-right">
                        <input type="radio" name="backFlag" value="2"/>退至客户
                    </span>
                </div>
                <br>
            </div>
        </c:if>
    </div>

    <div id="div7" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">退回原因(可多选)</b></div>
            <div class ="panel-body" style="margin-left: 5%;width: 99%;height: 250px">
                <c:forEach var="codeEntity" items="${backTypes}" varStatus="i">
                    <c:if test="${((i.index % 2) eq 0) && i.index==0}">
                        <br>
                    </c:if>

                    <c:if test="${(((i.index % 2) eq 0) && i.index >0)}">
                        <br><br>
                    </c:if>
                    <c:if test="${codeEntity.value>0}">
                    <span class="col-xs-11 block input-icon input-icon-right" style="margin-top: 10px;">
                        <input type="checkbox" name="errorContentTypes" id="errorContentTypes_${codeEntity.value}"
                               value="${codeEntity.value}"/>${codeEntity.name}<br/>
                        </span>
                    </c:if>
                    <c:if test="${codeEntity.value==0}">
                        <span class="col-xs-3 block input-icon input-icon-right"
                              style="margin-top: 10px;font-size:15px">
                        <input type="checkbox" name="errorContentTypes" id="errorContentTypes_${codeEntity.value}"
                               value="${codeEntity.value}"/>${codeEntity.name}
                        </span>
                        <span class="col-xs-6 block input-icon" style="margin-top: 10px;">
                            <input class="form-control" name="otherReasons" id="otherReasons" type="text"
                                   placeholder="不超过50个字符">
                        </span>
                    </c:if>
                </c:forEach>
            </div>
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
        var backFlag = $("input[name='backFlag']:checked").val();//退回节点
        var backReasonTypeArray = [];
        var backReasonType = "";
        var otherReasons = $("#otherReasons").val();

        $('input[name="errorContentTypes"]:checked').each(function () {
            backReasonTypeArray.push($(this).val());
        });
        if (backReasonTypeArray == "") {
            alertMsg("请勾选退回理由");
            return;
        }

        if (backReasonTypeArray != "") {
            backReasonType = "[" + backReasonTypeArray.toString() + "]";
        }

        if (null == backFlag || "undefined" == typeof(backFlag) || "" == backFlag) {
            backFlag = "";
        }

        confirm("确认退回此任务吗?", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&instanceId=" + '${taskDto.instanceId}' + "&defId=" + '${taskDto.defId}'
                + "&remark=" + '${taskDto.remark}' + "&backFlag=" + backFlag + "&backReasonType=" + backReasonType
                + "&otherReasons=" + otherReasons;

            var url = "${webRoot}/professionalInvestor/doBack";
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