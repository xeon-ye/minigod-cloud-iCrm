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
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
</head>
<body>
<div class="main-container" id="main-container">
    <!--隐藏图片-->
    <%--<div hidden id="imageList">
        <ul class="docs-pictures">
        </ul>
    </div>

    <div id="div6" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            </br>
            <div class="panel-heading"><b style="color: #368763">退回图片</b></div>
            <div style="margin-left: 5%;width: 90%;">
                <c:forEach var="imageInfo" items="${customerAccountOpenImages}" varStatus="i">
                    <c:if test="${((i.index % 3) eq 0) && i.index==0}">
                        </br>
                    </c:if>

                    <c:if test="${((i.index % 3) eq 0) && i.index >0}">
                        </br></br>
                    </c:if>
                    <c:if test="${imageInfo.imageLocationType !='509' && imageInfo.imageLocationType !='508' && imageInfo.imageLocationType !='506' && imageInfo.imageLocationType !='507'}">
                        <span class="col-xs-4 block input-icon input-icon-right">
                            <input type="checkbox" name="errorImages"
                                   value="${imageInfo.imageLocation}-${imageInfo.imageLocationType}"/>
                             <button class="layui-btn layui-btn-small layui-btn-warm" type="button"
                                     onclick="showAccountOpenImg(${i.index})" class="layui-icon">
                                     <i class="layui-icon">&#xe60d;</i>[${imageInfo.fileName}]
                             </button>

                        </span>
                        <!--循环调用方法-->
                        <script type="text/javascript">pictureList("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}", ${i.index});</script>

                    </c:if>

                </c:forEach>
                <br/>
            </div>
            </br></br>
        </div>
    </div>--%>

    <div id="div7" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">退回理由</b></div>

            <div style="margin-left: 5%;height: 200px;">

                <%-- <c:forEach var="codeEntity" items="${customerAccountOpenContentTypes}" varStatus="i">

                     <c:if test="${codeEntity.value>=53}">

                         <c:if test="${((i.index % 2) eq 0) && i.index==0}">
                             </br>
                         </c:if>

                         <c:if test="${((i.index % 2) eq 1) && i.index >0}">
                             </br></br>
                         </c:if>
                         <span class="col-xs-11 block input-icon input-icon-right">
                             <input type="checkbox" name="errorContentTypes" id="errorContentTypes_${codeEntity.value}"
                                    value="${codeEntity.value}" onclick="onChange(this.value)"/>${codeEntity.name}
                         </span>
                     </c:if>
                     <c:if test="${codeEntity.value==17}">
                         </br></br>
                         <span class="col-xs-4 block input-icon input-icon-right">
                         <input type="checkbox" name="errorContentTypes" id="errorContentTypes_${codeEntity.value}"
                                value="${codeEntity.value}" onclick="onChange(this.value)"/>${codeEntity.name}
                         </span>
                         <span class="col-xs-6 block input-icon input-icon-right">
                                 <input class="form-control" name="otherReasons" id="otherReasons" type="text"
                                        placeholder="告诉客户（选填）"/>
                             </span>
                     </c:if>
                 </c:forEach>--%>

                <span style="display: none">
                     <input type="checkbox" name="errorContentTypes" value="17" checked readonly/>
                </span>
                <span class="col-sm 6 block input-icon input-icon-right" style="padding-top: 20px">
                    <textarea class="form-control" name="otherReasons" id="otherReasons" rows="3"
                              placeholder="告诉客户（选填）"></textarea>
                </span>
            </div>
            </br>
        </div>
    </div>

    <div id="div8" v-cloak>
        <c:if test="${customerAccountOpenApply.applicationStatus == '2'}">
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

        <c:if test="${customerAccountOpenApply.applicationStatus == '3'}">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">退回节点</b></div>
                </br>
                <div style="margin-left: 5%;width: 90%">
                       <span class="col-xs-4 block input-icon input-icon-right">
                                <input type="radio" name="backFlag" value="1" checked="true"/>退回至客服
                       </span>
                    <span class="col-xs-4 block input-icon input-icon-right">
                             <input type="radio" name="backFlag" value="2"/>退回至持牌代表
                        </span>
                    <span class="col-xs-4 block input-icon input-icon-right">
                             <input type="radio" name="backFlag" value="3"/>退回至客户
                        </span>
                </div>
                </br> </br>
            </div>
        </c:if>

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
            if (value != '17') {
                $("input[name='errorContentTypes']").attr("disabled", false);
                document.getElementById("errorContentTypes_17").disabled = true;
            } else {
                $("input[name='errorContentTypes']").attr("disabled", true);
                document.getElementById("errorContentTypes_17").disabled = false;
            }
        } else {
            $("input[name='errorContentTypes']").attr("disabled", false);
            document.getElementById("errorContentTypes_17").disabled = false;
        }
    }

    /**
     * 退回
     */
    function doBack() {
        var errorContentTypesArray = []; //退回理由
        var errorImagesArray = [];	 //错误图片  location-locationType
        var backFlag = $("input[name='backFlag']:checked").val();//退回节点
        var backReasonTypeArray = [];
        var errorContentTypes = "";
        var otherReasons = $("#otherReasons").val();

        $('input[name="errorContentTypes"]:checked').each(function () {
            errorContentTypesArray.push($(this).val());
            backReasonTypeArray.push($(this).val());
        });
        $.each($("input[name='errorImages']:checked"), function () {
            var errorImages = $(this).val();
            errorImagesArray.push(errorImages);
            backReasonTypeArray.push(errorImages.substring(2, errorImages.length))
        });


        if (backReasonTypeArray == "") {
            alertMsg("请勾选退回理由");
            return;
        }
        var backReasonType = "[" + backReasonTypeArray.toString() + "]";

        if (errorContentTypesArray != "") {
            errorContentTypes = "[" + errorContentTypesArray.toString() + "]";
        }

        if (null == backFlag || "undefined" == typeof (backFlag) || "" == backFlag) {
            backFlag = "";
        }

        confirm("确认退回此任务吗?", function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&instanceId=" + '${taskDto.instanceId}' + "&defId=" + '${taskDto.defId}'
                + "&remark=" + '${taskDto.remark}' + "&backFlag=" + backFlag + "&backReasonType=" + backReasonType
                + "&errorImages=" + errorImagesArray
                + "&errorContentTypes=" + errorContentTypes
                + "&otherReasons=" + otherReasons

            var url = "${webRoot}/customer/doBack";
            $.post(url, params, function (result) {
                if (result.code == '0') {

                    layer.close(loading);

                    alert(result, function () {
                        //刷新父窗口列表
                        parent.parent.location.reload();
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

    function replaceLikeVal() {
        var otherReasons = $("#otherReasons").val();
        if (otherReasons.indexOf("'") != -1 || otherReasons.indexOf("\"") != -1) {
            var patt1 = new RegExp("/\\'/g");
            var patt2 = new RegExp("/\\\"/g");
            if (patt1.test(otherReasons) == false || patt2.test(otherReasons) == false) {
                var replaceValue = $("#otherReasons").val().replace(/\'/g, "").replace(/\"/g, "");
                $("#otherReasons").val(replaceValue);
            }
        }
    }

    $("#otherReasons").blur(function () {
        var otherReasons = $("#otherReasons").val();
        if (otherReasons.indexOf("'") != -1 || otherReasons.indexOf("\"") != -1) {
            var patt1 = new RegExp("/\\'/g");
            var patt2 = new RegExp("/\\\"/g");
            if (patt1.test(otherReasons) == false || patt2.test(otherReasons) == false) {
                var replaceValue = $("#otherReasons").val().replace(/\'/g, "").replace(/\"/g, "");
                $("#otherReasons").val(replaceValue);
            }
        }
    });

</script>

</html>