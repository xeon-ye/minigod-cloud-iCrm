<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/ajaxupload.js"></script>
    <script src="${webRoot}/js/jquery.serializejson.js"></script>

</head>
<body>
<!--隐藏图片-->
<div hidden id="imageList">
    <ul class="docs-pictures">
    </ul>
</div>
    <div id="div1" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">影像资料</b></div>
            </br>
            <div style="margin-left: 5%;width: 90%; font-size: 0; height: 140px; vertical-align: middle;">
                </br>
                <div style="margin-left: 50px;width: 90%">
                    <c:forEach var="imageInfo" items="${customerAccountOpenImages}" varStatus="i">
                            <span class="col-xs-2 block input-icon input-icon-right" style="margin-top: 15px">
                                <button class="layui-btn layui-btn-small layui-btn-warm" type="button"
                                        onclick="showAccountOpenImg(${i.index})"
                                        class="layui-icon"><i
                                        class="layui-icon">&#xe60d;</i>[${imageInfo.fileName}]</button>
                            <button id="reLoadButtonV${i.index}" class="layui-btn layui-btn-small layui-btn-danger" type="button"
                                    name="reLoadButtonV" value="${imageInfo.id}">改</button>
                             </span>
                        <!--循环调用方法-->
                        <script type="text/javascript">pictureList("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}", ${i.index});</script>
                    </c:forEach>
                </div>
                </br>
            </div>
        </div>
    </div>
</body>

<script>
    $(document).ready(function () {
        //重新上传音频、视频文件按钮
        var reButton = document.getElementsByName('reLoadButtonV');
        for (var i = 0; i < reButton.length; i++) {
            var id = $("#reLoadButtonV"+i).val();
            var applicationId = '${customerAccountOpenInfoEntity.applicationId}';
            new AjaxUpload(reButton[i], {
                action: '${webRoot}/customer/reUpload',
                name: 'file',
                contentType: "application/json;charset=UTF-8",
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    id: id
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                        alert('只支持jpg、png、gif格式的图片！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/customer/pictureRefresh?applicationId=${applicationId}",
                            timeout: 3000, success: function (page) {

                                $.ajaxPrefilter('script', function(options) {
                                    options.cache = true;
                                });

                                $("#imageList").remove();
                                $("#mainContent").html(page);
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

        //上传图片文件按钮
        var updateButtons2 = document.getElementsByName('upLoadAml');
        for (var i = 0; i < updateButtons2.length; i++) {
            var applicationId = '${customerAccountOpenInfoEntity.applicationId}';
            new AjaxUpload(updateButtons2[i], {
                action: '${webRoot}/customer/uploadAml',
                name: 'file',
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    fileType: 2
                },
                responseType: "json",
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        alert("上传成功");
                    } else {
                        alert(result.message);
                    }
                    window.location.reload();
                }
            });
        }
    })

</script>
</html>
