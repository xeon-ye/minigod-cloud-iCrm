<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@include file="/common/commonCSS.jsp" %>--%>
<%--<%@include file="/common/commonJS.jsp" %>--%>
<html lang="en">
<head>
    <script src="${webRoot}/js/ajaxupload.js"></script>
</head>
<body>
<input id="witnessFlag" style="display: none" type="text" value="${witnessesFileList[0]==null}">
<label class="col-sm-3 control-label no-padding-right"> 见证人证书</label>
<div class="col-xs-9">
    <span class="col-xs-12 block control-label no-padding-right">
        <c:if test="${witnessesFileList!=null}">
        <c:forEach begin="0" end="2" step="1" var="i">
            <c:if test="${witnessesFileList[i]!=null}">
                <div class="layui-btn-group">
                    <a class="layui-btn layui-btn-normal layui-btn-mini"
                       href='${webRoot}/common/downloadFile?fullFilePath=${witnessesFileList[i].filePath}${witnessesFileList[i].fileStorageName}.${witnessesFileList[i].fileExtName}'>【见证人证书(${i+1})】</a>
                    <button type="button"
                            class="layui-btn layui-btn-primary layui-btn-mini"
                            onclick="delWitnessInfo(${witnessesFileList[i].id});">
                        <i class="layui-icon">&#xe640;</i>
                    </button>
                </div>
            </c:if>
            <c:if test="${witnessesFileList[i]==null}">
                <button name="upLoadWitnesses" style="width: 100px;display: inline"
                        class="layui-btn layui-btn-primary layui-btn-mini">上传[见证人证书]</button>
            </c:if>
        </c:forEach>
            </c:if>
    </span>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        //上传见证人证书
        var reButton = document.getElementsByName('upLoadWitnesses');
        for (var i = 0; i < reButton.length; i++) {
            var applicationId = '${applicationId}';
            new AjaxUpload(reButton[i], {
                action: '${webRoot}/offlineCustAccOpen/uploadFile',
                name: 'file',
                contentType: "application/json;charset=UTF-8",
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    fileType: 4
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(jpg|jpeg|png|bmp|pdf)$/.test(extension.toLowerCase()))) {
                        alert('只支持jpg、jpeg、png、bmp、pdf格式的文件！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/offlineCustAccOpen/witnessesRefresh?applicationId=${applicationId}",
                            timeout: 3000, success: function (page) {

                                $.ajaxPrefilter('script', function (options) {
                                    options.cache = true;
                                });

                                $("#witnessFlag").remove();
                                $("#witnessesCard").html(page);
                                alert("上传成功");
                            },
                            error: function () {
                                console.log("faild");
                            }
                        });
                    } else {
                        alert(result.message);
                    }
                }
            });
        }
    });
</script>
</html>
