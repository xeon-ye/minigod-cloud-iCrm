<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<html lang="en">
<head>
    <script src="${webRoot}/js/ajaxupload.js"></script>
</head>
<body>
<input id ="amlFlag" style="display: none" type="text" value="${amlFileList[0]==null}">
<label class="col-sm-4 control-label no-padding-right"> AML检查结果文件</label>
<span class="col-xs-8 block control-label no-padding-right">
    <c:if test="${amlFileList!=null}">
        <c:forEach begin="0" end="2" step="1" var="i">
            <c:if test="${amlFileList[i]!=null}">
                <div class="layui-btn-group">
                <a class="layui-btn layui-btn-normal layui-btn-mini"
                   onclick=showFileOnline('${amlFileList[i].filePath}${amlFileList[i].fileStorageName}.${amlFileList[i].fileExtName}','${amlFileList[i].fileExtName}')>【AML文件(${i+1})】</a>
                <button type="button" class="layui-btn layui-btn-primary layui-btn-mini"
                        onclick="delAmlInfo(${amlFileList[i].id});"><i class="layui-icon">&#xe640;</i>
                </button>
                </div>
            </c:if>
            <c:if test="${amlFileList[i]==null}">
                <button name="upLoadAml" style="width: 100px;display: inline"
                        class="layui-btn layui-btn-primary layui-btn-mini">上传[AML文件]</button>
            </c:if>
        </c:forEach>
    </c:if>
</span>
</body>
<script type="text/javascript">
    $(document).ready(function () {

        //上传图片文件按钮
        var updateButtons2 = document.getElementsByName('upLoadAml');

        for (var i = 0; i < updateButtons2.length; i++) {
            var applicationId = '${applicationId}';
//            var isAmlSuspicious = ;
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
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/customer/amlRefresh?applicationId=${applicationId}",
                            timeout: 3000, success: function (page) {

                                $.ajaxPrefilter('script', function(options) {
                                    options.cache = true;
                                });

                                $("#amlFlag").val("${amlFileList[0]!=null ? amlFileList[0] : null}");
                                $("#amlDiv").html(page);
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
