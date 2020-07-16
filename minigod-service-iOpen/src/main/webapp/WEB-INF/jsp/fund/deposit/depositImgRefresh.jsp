<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
</head>
<body>
    <div hidden id="imageList${info.applicationId}0">
        <ul class="docs-pictures"></ul>
    </div>
    <c:forEach var="imageInfo" items="${info.despositImage}" varStatus="i">
    <span class="col-xs-1 block input-icon input-icon-right" style="margin-top: 10px; margin-left: 50px">
        <img width="150" height="120"
             src='${webRoot}/common/downloadFile?fullFilePath=${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}&_=${random}'
             onclick="showImage('${info.applicationId}0',${i.index});">
        <c:if test="${operationFlag==2}">
            <span class="col-xs-1 block input-icon"
                  style="margin-top: 5px;margin-left: 20px">
                <button id="reLoadButtonV${i.index}" type="button"
                        name="reLoadButtonV" value="${imageInfo.id}">
                    <i class="layui-icon" style="font-size: 20px; color: #209d6c;">
                        &#xe642;</i>
                </button>
            </span>
            <span class="col-xs-1 block input-icon" style="margin-top: 5px;margin-left: 20px">
                <button id="deleteImage" type="button" name="deleteImage" onclick="deleteImage(${imageInfo.id})">
                    <i class="layui-icon" style="font-size: 20px; color: #ff2128;">
                        &#xe640;</i>
                </button>
            </span>
        </c:if>
    </span>
        <!--循环调用方法-->
        <script type="text/javascript">pictureListWithId("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}", ${i.index}, '${info.applicationId}0');</script>
    </c:forEach>
    <c:if test="${operationFlag==2}">
    <span class="col-xs-2 block input-icon input-icon-right" style="margin-top: 10px; margin-left: 50px">
        <button id="uploadImage" type="button" name="uploadImage">
            <i class="layui-icon" style="font-size: 105px; color: #209d6c;">
                &#xe608;</i>
        </button>
    </span>
    </c:if>
</body>
<script>

    $(function () {
        $('#imageList${info.applicationId}0').viewer();
    });

    $(document).ready(function () {
        var reButton = document.getElementsByName('reLoadButtonV');
        for (var i = 0; i < reButton.length; i++) {
            var id = $("#reLoadButtonV" + i).val();
            var applicationId = '${info.applicationId}';
            new AjaxUpload(reButton[i], {
                action: '${webRoot}/clientFundDeposit/reUpload',
                name: 'file',
                contentType: "application/json;charset=UTF-8",
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    gid: id
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(jpg|jpeg|bmp|png)$/.test(extension.toLowerCase()))) {
                        alert('只支持jpg、jpeg、png、bmp格式的图片！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/clientFundDeposit/depositImgRefresh?flag=${operationFlag}&applicationId=${info.applicationId}",
                            timeout: 3000,
                            success: function (page) {
                                $.ajaxPrefilter('script', function (options) {
                                    options.cache = true;
                                });
                                $("#despositImageDiv").html(page);
                                alert("更新成功");
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
        var updateButtons2 = document.getElementsByName('uploadImage');
        for (var i = 0; i < updateButtons2.length; i++) {
            var applicationId = '${info.applicationId}';
            new AjaxUpload(updateButtons2[i], {
                action: '${webRoot}/clientFundDeposit/uploadImage',
                name: 'file',
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    imageType: 0
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(jpg|jpeg|bmp|png)$/.test(extension.toLowerCase()))) {
                        alert('只支持jpg、jpeg、bmp、png格式的图片！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/clientFundDeposit/depositImgRefresh?flag=${operationFlag}&applicationId=${info.applicationId}",
                            timeout: 3000,
                            success: function (page) {
                                $.ajaxPrefilter('script', function (options) {
                                    options.cache = true;
                                });
                                $("#despositImageDiv").html(page);
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

    function deleteImage(id) {
        confirm("确定删除图片吗？", function () {
            var url = "${webRoot}/clientFundDeposit/deleteImage";
            var params = {
                'id': id,
            };
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    $.ajax({
                        type: "get",
                        async: false,
                        cache: false,
                        url: "${webRoot}/clientFundDeposit/depositImgRefresh?flag=${operationFlag}&applicationId=${info.applicationId}",
                        timeout: 3000,
                        success: function (page) {
                            $.ajaxPrefilter('script', function (options) {
                                options.cache = true;
                            });
                            $("#despositImageDiv").html(page);
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
</script>
</html>
