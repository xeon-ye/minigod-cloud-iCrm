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
    <div id="div7">
        <div v-show="!showList" class="panel panel-default" v-cloak>
            <div class="panel-heading"><b style="color: #368763">退回原因</b></div>

            <div style="margin-left: 5%;width: 90%;height: 200px;">
                <c:forEach var="codeEntity" items="${backTypes}" varStatus="i">
                    <c:if test="${codeEntity.value == 0 or codeEntity.value == 9 or codeEntity.value == 10}">
                        <c:if test="${((i.index % 2) eq 0) && i.index==0}">
                            </br>
                        </c:if>

                        <c:if test="${(((i.index % 2) eq 0) && i.index >0) or codeEntity.value==0}">
                            </br></br>
                        </c:if>
                        <span class="col-xs-4 block input-icon input-icon-right">
                            <input type="checkbox" name="errorContentTypes" id="errorContentTypes_${codeEntity.value}"
                                   value="${codeEntity.value}" onclick="onChange(this.value)"/>${codeEntity.name}
                        </span>
                        <c:if test="${codeEntity.value==0}">
                        <span class="col-xs-4 block input-icon">
                            <input class="form-control" name="otherReasons" id="otherReasons" type="text"
                                   placeholder="告诉客户">
                        </span>
                        </c:if>
                    </c:if>
                </c:forEach>
            </div>
            </br>
        </div>
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
        var errorContentTypesArray = []; //退回理由
        var backReasonTypeArray = [];
        var otherReasons = $("#otherReasons").val();
        var applicationIds = '${applicationIds}';
        $('input[name="errorContentTypes"]:checked').each(function () {
            backReasonTypeArray.push($(this).val());
            errorContentTypesArray.push($(this).val());
        });
        if (backReasonTypeArray == "") {
            alertMsg("请勾选退回理由");
            return;
        }
        var backReasonType = "[" + backReasonTypeArray.toString() + "]";
        if(errorContentTypesArray !="")
        {
            errorContentTypes =  errorContentTypesArray.toString();
        }

        confirm("确认批量退回任务吗?", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            var params = "applicationIds=" + applicationIds + "&backReasonType=" + backReasonType + "&otherReasons=" + otherReasons
                + "&errorContentTypes=" + errorContentTypes;
            var url = "${webRoot}/clientFundDeposit/doRejectTaskBatch";
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    alert(result, function () {
                        //刷新父窗口列表
                        parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    });
                } else {
                    layer.close(loading);
                    alertMsg(result.msg);

                }
            });
        });
    }


</script>

</html>