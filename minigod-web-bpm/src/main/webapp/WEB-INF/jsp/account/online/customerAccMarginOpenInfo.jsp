<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>

<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer-jquery.min.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/ajaxupload.js"></script>
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
</head>
<style>
    #investTarget {
        display: inline
    }
</style>
<body>
<div v-cloak>
    <%-- 基本信息 Start --%>
    <div id="div1" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
            </br>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">预约号</label>
                    <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="applicationId" name="applicationId" type="text" class="form-control"
                               value="${accountOpenApplicationEntity.applicationId}" readonly/>
                    </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">客户姓名</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="clientName" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.clientName}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">证件号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idNo" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idNo}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">申请时间</label>
                    <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="applicationTime" name="applicationTime" type="text" class="form-control"
                               value="<fmt:formatDate value="${accountOpenApplicationEntity.createTime}" pattern="yyyy-MM-dd HH:mm"/>"
                               readonly/>
                    </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">信用额度</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="creditQuota" name="creditQuota" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.creditQuota}"/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">信用比率</label>
                    <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="creditRatio" name="creditRatio" type="text" class="form-control"
                               value="${customerAccountOpenInfoEntity.creditRatio}"/>
                    </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--预约信息End--%>

    <div id="div7" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">身份资料披露</b></div>
            </br>
            <c:forEach items="${openAccountOtherDisclosureList}" var="openAccountOther" varStatus="i">
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-12 control-label no-padding-right">${fns:getCodeName("AO_DISCLOSURE_CODE",openAccountOther.disclosureCode)}</label>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <c:if test="${openAccountOther.disclosureIsTrue== 1}">
                            <input type="radio"
                                   name="disclosureCode_${openAccountOther.disclosureCode }"
                                   value="${openAccountOther.disclosureIsTrue}" checked="true"
                                   disabled="disabled"/>是
                            <input type="radio"
                                   name="disclosureCode_${openAccountOther.disclosureCode }"
                                   value="${openAccountOther.disclosureIsTrue}"
                                   disabled="disabled"/>否
                        </c:if>
                        <c:if test="${openAccountOther.disclosureIsTrue == 0}">
                            <input type="radio"
                                   name="disclosureCode_${openAccountOther.disclosureCode }"
                                   value="${openAccountOther.disclosureIsTrue}"
                                   disabled="disabled"/>是
                            <input type="radio"
                                   name="disclosureCode_${openAccountOther.disclosureCode }"
                                   value="${openAccountOther.disclosureIsTrue}" checked="true"
                                   disabled="disabled"/>否
                        </c:if>
                    </span>
                    </div>
                    <div class="form-group col-sm-12 col-md-12">
                    <span class="col-sm-12 block input-icon input-icon-right">
                         <c:if test="${openAccountOther.disclosureIsTrue ==0 and openAccountOther.disclosureNameJoinDetail!=null}">
                                 <input class="form-control" style="display: inline"
                                        id="disclosureCode" name="disclosureCode" type="text"
                                        value="${openAccountOther.disclosureNameJoinDetail}"
                                        style="width:600px; margin-left:25px; height:34px;"
                                        readonly/>
                         </c:if>
                    </span>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <c:if test="${accountOpenApplicationEntity.applicationStatus==6 or accountOpenApplicationEntity.applicationStatus==4}">
        <div id="div9" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">开户资料下载</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-2 col-md-2">

                    </div>
                    <c:forEach items="${reportFiles}" var="files">
                        <div class="form-group col-sm-2 col-md-2">
                            <button onclick="downloadAccountOpenReport('${files.fileUri}')"
                                    class="layui-btn layui-btn-mini layui-btn-normal"
                                    type="button">${files.displayName}</button>
                        </div>
                    </c:forEach>
                    <div class="form-group col-sm-2 col-md-2">

                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>
</body>

<script type="text/javascript">
    //通过
    function doTaskPass() {
        confirm("确定执行此操作吗？", function () {
            var url = "${webRoot}/act/deal/doActTask";
            var userIds = new Array();
            $("#userTab input[name='userIds']").each(function () {
                userIds.push($(this).val());
            });
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

    //终止
    function doTaskStop() {
        confirm("确定执行此操作吗？", function () {
            var url = "${webRoot}/act/deal/doActTask";
            var userIds = new Array();
            $("#userTab input[name='userIds']").each(function () {
                userIds.push($(this).val());
            });
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

    //退回
    function doTaskBack() {
        var url = "${webRoot}/customer/doTaskBackView";
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["退回理由", true],
            area: ['55%', '80%'], //宽高
            content: [url, 'yes']
        });
    }

    //进入补充资料页面
    function addSupInformation(applicationId, additionalId) {
        var url = "${webRoot}/supOpenAccountInfo/supOpenAccountInfo?applicationId=" + applicationId;
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["补充资料", true],
            area: ['50%', '80%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
        });
    }

    /**
     * 下载用户报表
     */
    function downloadAccountOpenReport(fullFilePath) {
        window.location.href = webRoot + "/common/downloadFile?fullFilePath=" + fullFilePath;
    }

    /**
     * 更新AML信息
     */
    function editAmlInfo() {
        var isAmlSuspicious = $('input[name="isAmlSuspicious"]').filter(':checked').val();
        var acceptRisk = $('input[name="acceptRisk"]').filter(':checked').val();

        if (isAmlSuspicious == 1) {
            $("input[name='acceptRisk'][value='" + 1 + "']").prop("checked", true);
            $("input[name='acceptRisk'][value='" + 2 + "']").prop("checked", false);
            $("input[name='acceptRisk'][value='" + 3 + "']").prop("checked", false);
            acceptRisk = 1;
        }

        url = "${webRoot}/customer/editAmlInfo?isAmlSuspicious=" + isAmlSuspicious + "&acceptRisk=" + acceptRisk + "&applicationId=" + '${customerAccountOpenInfoEntity.applicationId}';
        $.post(url)
    }

    /**
     * 更新AML信息
     */
    function editAmlRisk() {
        var acceptRisk = $('input[name="acceptRisk"]').filter(':checked').val();

        url = "${webRoot}/customer/editAmlInfo?acceptRisk=" + acceptRisk + "&applicationId=" + '${customerAccountOpenInfoEntity.applicationId}';
        $.post(url)
    }

    /**
     * 删除AML信息
     */
    function delAmlInfo(id) {
        confirm("您确定要删除吗?", function () {
            var url = "${webRoot}/customer/delAmlInfo";
            var params = {
                'applicationId': ${customerAccountOpenInfoEntity.applicationId},
                'id': id
            };
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    $.ajax({
                        type: "get",
                        async: false,
                        cache: false,
                        url: "${webRoot}/customer/amlRefresh?applicationId=${customerAccountOpenInfoEntity.applicationId}",
                        timeout: 3000, success: function (page) {
                            $.ajaxPrefilter('script', function (options) {
                                options.cache = true;
                            });
                            $("#amlFlag").remove();
                            $("#amlDiv").html(page);
                            alert("删除成功");
                        },
                        error: function () {
                            console.log("faild");
                        }
                    });
                } else {
                    alertMsg(result.msg);
                }
            });
        });
    }

    function showFileOnline(urlPath, type) {

        var url = "${webRoot}/common/showFile?fullFilePath=" + urlPath + "&fileType=" + type;

        // 弹框层
        var index = layer.open({
            scrollbar: false,
            type: 2,
            title: ["AML文件预览", true],
            area: ['100%', '100%'],
            content: [url, 'yes']
        });

        if ("jpg,jepg,gif,png,pdf".indexOf(type) == -1) {
            layer.close(index);
            alertMsg("无法预览(." + type + ")类型的文件，请下载查看");
        }
    }

    <%--function openPhoto(src) {--%>
    <%--layer.photos({--%>
    <%--photos: {--%>
    <%--"data": [{"src": '${webRoot}/image' + src}]--%>
    <%--},--%>
    <%--shadeClose: false,--%>
    <%--shade: [0.5, '#000'],--%>
    <%--closeBtn: 2,--%>
    <%--anim: 0,--%>
    <%--});--%>
    <%--}--%>

</script>
</html>
