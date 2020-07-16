<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>补充资料</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<script src="${webRoot}/js/ajaxupload.js"></script>
<link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
<link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
<script src="${webRoot}/viewer/js/viewer.js"></script>
<script src="${webRoot}/viewer/js/main.js"></script>
<script type="text/javascript" src="${webRoot}/js/photo/pictureShow.js"></script>
<script>
    $(document).ready(function () {
        //上传图片文件按钮
        var updateButtons2 = document.getElementsByName('upLoadProof');
        for (var i = 0; i < updateButtons2.length; i++) {
            var applicationId = '${supFile.applicationId}';
            new AjaxUpload(updateButtons2[i], {
                action: '${webRoot}/customer/uploadAml',
                name: 'file',
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    fileType: 3
                },
                responseType: "json",
                onComplete: function (file, result) {
                    if (result.code == 0) {

                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/customer/getProofFileData?applicationId=${supFile.applicationId}",
                            timeout: 3000, success: function (result) {

                                $.ajaxPrefilter('script', function(options) {
                                    options.cache = true;
                                });

                                for (var i = 0; i < 3; i++) {
                                    var file = result.result[i]
                                    if(file!=null){
                                        var key = i+1;
                                        var path ="${webRoot}/common/downloadFile?fullFilePath="+result.result[i].filePath+result.result[i].fileStorageName+'.'+result.result[i].fileExtName;
                                        $("#proofDiv"+i).html('<a class="layui-btn layui-btn-normal layui-btn-mini" href="'+path+'">【修改资料凭证('+key+')】</a>')
                                    }
                                }
                                alert("上传成功");
                            },
                            error: function () {
                                alert("上传失败！")
                            }
                        });
                    } else {
                        alert(result.message);
                    }
//                    window.location.reload();
                }
            });
        }
    })
</script>
<body>
<div v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">资料修改凭证上传</b></div>
        </br>
        <div class="row" align="center">
            <div class="form-group col-sm-12 col-md-12" style="height: 30px;margin-top: 40px">
                <label class="col-sm-12 control-label no-padding-right"> 资料修改凭证</label>
            </div>

                <div class="form-group col-sm-12 col-md-12" style="height: 30px">
                        <span class="col-xs-12 block control-label no-padding-right">

                                    <c:if test="${proofFiles!=null}">
                                        <c:forEach begin="0" end="2" step="1" var="i">
                                         <div id="proofDiv${i}" style="display: inline">
                                            <c:if test="${proofFiles[i]!=null}">
                                                <a class="layui-btn layui-btn-normal layui-btn-mini"
                                                   href='${webRoot}/common/downloadFile?fullFilePath=${proofFiles[i].filePath}${proofFiles[i].fileStorageName}.${proofFiles[i].fileExtName}'>【修改资料凭证(${i+1})】</a>
                                            </c:if>
                                            <c:if test="${proofFiles[i]==null}">
                                                <button name="upLoadProof" style="width: 100px;display: inline"
                                                        class="layui-btn layui-btn-primary layui-btn-mini">上传[证明文件]</button>
                                            </c:if>
                                         </div>
                                        </c:forEach>
                                    </c:if>

                        </span>
                </div>

        </div>
        <div class="row" align="center">
            <div class="form-group col-sm-12 col-md-12" style="height: 120px;margin-top: 20px">
                <label class="col-sm-12 control-label no-padding-right" style="height: 30px">修改意见</label>
                <textarea id="remark" name="remark" style="resize:none;" rows="5" cols="50" tabindex="false"
                          style="height: 30px"></textarea>
            </div>

        </div>

    </div>
</div>
<div class="row" align="center">
    <button type="button" class="layui-btn" onclick="saveComment();">完成</button>
</div>
</body>
<script>
    function closeLayer() {
        window.parent.parent.location.reload(); //刷新父父页面
    }

    function saveComment() {
        var remark = $("#remark").val();
        var applicationId = '${supFile.applicationId}';
        var additionalId = '${additionalId}';
        url = "${webRoot}/customer/saveComment";
        if (remark == null || remark == '') {
            closeLayer();
        } else {
            $.ajax({
                url: url,   //处理页面的名称
                data: {
                    remark: remark,
                    applicationId: applicationId,
                    additionalId: additionalId
                },  //为值取个名字
                type: "POST",  //传值方式
                dataType: "text",  //数据类型
                success: function (result) {
                    layer.alert(JSON.parse(result).message, function () {
                        closeLayer();
                    })
                }
            })
        }
    }
</script>
</html>