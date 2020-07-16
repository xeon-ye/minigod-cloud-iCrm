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
<body>
<script>
    $(document).ready(function(){
        //上传音频、视频文件按钮
        var updateButtons1 = document.getElementsByName('upload1');
        var applicationId = '${applicationId}';
        <%--var additionalId = '${additionalId}';--%>
        for (var i = 0; i<updateButtons1.length; i++) {
            new AjaxUpload(updateButtons1[i], {
                action: '${webRoot}/supOpenAccountInfo/upload',
                name: 'file',
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    fileType:1
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(avi|rmvb|rm|asf|divx|mpg|mpeg|mpe|wmv|mp4|mkv|vob|mp3|wma|wav|ogg)$/.test(extension.toLowerCase()))) {
                        alert('只支持avi、rmvb、rm、asf、divx、mpg、mpeg、mpe、wmv、mp4、mkv、vob、mp3、wma、wav、ogg格式的音频或视频！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/supOpenAccountInfo/supFileRefresh?applicationId=${applicationId}",
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
                    //location.replace("${webRoot}/supOpenAccountInfo/supOpenAccountInfo?&applicationId="+applicationId);
                }
            });
        }

        //重新上传音频、视频文件按钮
        var reButton = document.getElementsByName('reLoadButtonV');
        for (var i = 0; i<reButton.length; i++) {
            var id = $("#reLoadButtonV"+i).val();
            var applicationId = ${applicationId};
            <%--var additionalId = '${additionalId}';--%>
            new AjaxUpload(reButton[i], {
                action: '${webRoot}/supOpenAccountInfo/upload',
                name: 'file',
                contentType:"application/json;charset=UTF-8",
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    id:id
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(avi|rmvb|rm|asf|divx|mpg|mpeg|mpe|wmv|mp4|mkv|vob|mp3|wma|wav|ogg)$/.test(extension.toLowerCase()))) {
                        alert('只支持avi、rmvb、rm、asf、divx、mpg、mpeg、mpe、wmv、mp4、mkv、vob、mp3、wma、wav、ogg格式的音频或视频！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/supOpenAccountInfo/supFileRefresh?applicationId=${applicationId}",
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
//                    window.location.reload();
                }
            });
        }


        //上传图片文件按钮
        var updateButtons2 = document.getElementsByName('upload2');
        for (var i = 0; i<updateButtons2.length; i++) {
            var applicationId = ${applicationId};
            <%--var additionalId = '${additionalId}';--%>
            new AjaxUpload(updateButtons2[i], {
                action: '${webRoot}/supOpenAccountInfo/upload',
                name: 'file',
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    fileType:0
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(jpg|jpeg|png|gif|bmp)$/.test(extension.toLowerCase()))) {
                        alert('只支持jpg、png、gif、bmp、jpeg格式的图片！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
//                        alert("上传成功");
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/supOpenAccountInfo/supFileRefresh?applicationId=${applicationId}",
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
                    <%--location.replace("${webRoot}/supOpenAccountInfo/supOpenAccountInfo?&applicationId="+applicationId);--%>
                }
            });
        }

        var reLoadButton = document.getElementsByName('reLoadButtonP');
        for (var i = 0; i<reLoadButton.length; i++) {
            var id = $("#reLoadButtonP"+i).val();
            var applicationId = ${applicationId};
            <%--var additionalId = '${additionalId}';--%>
            new AjaxUpload(reLoadButton[i], {
                action: '${webRoot}/supOpenAccountInfo/reUpload',
                name: 'file',
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    id: id
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(jpg|jpeg|png|gif|bmp)$/.test(extension.toLowerCase()))) {
                        alert('只支持jpg、png、gif、bmp、jpeg格式的图片！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/supOpenAccountInfo/supFileRefresh?applicationId=${applicationId}",
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
//                    window.location.reload();
                }
            });
        }

    })


    function deleteFile(id) {
        url = "${webRoot}/supOpenAccountInfo/deleteFile";
        $.ajax({
            url: url,   //处理页面的名称
            data: {
               id:id
            },  //为值取个名字
            type: "POST",  //传值方式
            dataType: "text",  //数据类型
            success: function (result) {
                if (result=='ok') {
                    $.ajax({
                        type: "get",
                        async: false,
                        cache: false,
                        url: "${webRoot}/supOpenAccountInfo/supFileRefresh?applicationId=${applicationId}",
                        timeout: 3000, success: function (page) {

                            $.ajaxPrefilter('script', function(options) {
                                options.cache = true;
                            });

                            $("#imageList").remove();
                            $("#mainContent").html(page);
                            alert("删除成功");
                        },
                        error: function () {
                            console.log("faild");
                        }
                    });
                } else if(result=='error') {
                    alert("删除失败！");
                }
//                window.location.reload();
            }
        })
    }



    //音频、视频文件下载
    function downLoadFile(filePath) {
      window.location.href="${webRoot}/common/downloadFile?fullFilePath="+filePath;
    }

    function  saveComment() {
        var remark = $("#remark").val();
        var applicationId = ${applicationId};
        <%--var additionalId = '${additionalId}';--%>
        url = "${webRoot}/supOpenAccountInfo/saveComment";
        $.ajax({
            url: url,   //处理页面的名称
            data: {
                remark: remark,
                applicationId:applicationId
            },  //为值取个名字
            type: "POST",  //传值方式
            dataType: "text",  //数据类型
            success: function (result) {
                if (result=='ok') {
                    layer.confirm('保存成功！', { btn: ['是'],btn1: function(){
                        window.parent.parent.location.reload(); //刷新父页面
                        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                        parent.layer.close(index);  // 关闭layer
                        }
                    })

                } else if(result=='error') {
                    alert("保存失败！");
                }
            }
        })
    }
    flag = false;
    function showButton(){
        if(flag==false){
            $("button[name='reLoadButtonV']").show();
            $("button[name='reLoadButtonP']").show();
            $("button[name='delete1']").show();
            $("button[name='delete2']").show();
        }
        if(flag==true){
            $("button[name='reLoadButtonV']").hide();
            $("button[name='reLoadButtonP']").hide();
            $("button[name='delete1']").hide();
            $("button[name='delete2']").hide();
        }
        flag=!flag;
    }
</script>
<fieldset >
    <!--隐藏图片-->
    <div hidden id="imageList">
        <ul class="docs-pictures">
        </ul>
    </div>
    <form>
        <div id="mainContent">
            <table class="layui-form" style="height: 200px;margin-top: 30px"  >
            <br>
            <span hidden>预约号:<input  id="applicationId" value="${applicationId}"></span>
            <span hidden>预约号:<input  id="additionalId" value="${additionalId}"></span>
            <tr >
                <td  width="80px" ></td>
                <td  width="100px" ><span style="font-weight:bold;font-size: 15px" >视频/语音：</span></td>
                <c:forEach items="${videoPathList}" var="info" varStatus="i">
                        <td  width="30px" ></td>
                        <td >
                            <button name="reLoad" style="width: 100px" class="layui-btn layui-btn-small layui-btn-warm" type="button" onclick="downLoadFile('${info.filePath}${info.fileStorageName}.${info.fileExtName}')" >${info.fileName}</button><br>
                            <button id="reLoadButtonV${i.index}"  class="layui-btn layui-btn-small layui-btn-danger" style="width: 40px;display: none;"  type="button"  name="reLoadButtonV" value="${info.id}">改</button>
                            <button id="delete1"  class="layui-btn layui-btn-small layui-btn-danger" style="width: 40px;display: none;" type="button"  name="delete1" value="${info.id}" onclick="deleteFile(${info.id});">删</button>
                        </td>

                </c:forEach>
                <c:if test="${videoPathList.size()<5}">
                    <td width="50px" ></td>
                    <td width="100px" ><button class="layui-btn layui-btn-small layui-btn-normal" type="button" name="upload1" >上传文件 </button></td>
                </c:if>
            </tr>
            <tr>
                <td  width="80px" ></td>
                <td width="100px"><span style="font-weight:bold;font-size: 15px" >图片：</span></td>
                <c:forEach items="${photoPathList}" var="info" varStatus="i">
                    <td  width="30px" ></td>
                    <td >
                        <button class="layui-btn layui-btn-small layui-btn-warm" style="width: 100px" type="button" onclick="showAccountOpenImg(${i.index})">&nbsp;[ ${info.fileName}&nbsp;]</button><br>
                        <button id="reLoadButtonP${i.index}" style="width: 40px;display: none;" class="layui-btn layui-btn-small layui-btn-danger"  type="button"  name="reLoadButtonP" value="${info.id}">改</button>
                        <button id="delete2" style="width: 40px;display: none;" class="layui-btn layui-btn-small layui-btn-danger"   type="button"  name="delete2" value="${info.id}" onclick="deleteFile(${info.id});">删</button>
                    </td>
                    <script type="text/javascript">pictureList("${info.filePath}${info.fileStorageName}.${info.fileExtName}", ${i.index});</script>
                </c:forEach>
                <c:if test="${photoPathList.size()<5}">
                    <td width="50px" ></td>
                    <td width="100px"><button class="layui-btn layui-btn-small layui-btn-normal" type="button" name="upload2">上传文件</button></td>
                </c:if>
            </tr>
        </table>
        </div>
        <table style="height: 250px">
            <tr>
                <td  width="80px" ></td>
                <br>
                <td width="100px" ><span style="font-weight:bold;font-size: 15px" class="float_left">证明原因：</span></td>
                <td width="100px" ><span class="float_left"><textarea id="remark" name="remark"  style="resize:none;" rows="5" cols="50" tabindex="false"></textarea></span></td>
            </tr>
            <tr><br></tr>
            <tr>
                <td  width="80px" ></td>
                <td width="100px" ><button class="layui-btn layui-btn-small layui-btn-primary" type="button"  name="cancle" onclick="closeLayer();">取消</button></td>
                <td width="50px" ></td>
                <td width="100px" ><button  class="layui-btn layui-btn-small" onclick="saveComment();" type="button" name="formSubmit">提交</button></td>
                <td width="100px"><button  class="layui-btn layui-btn-small layui-btn-warm" onclick="showButton();" type="button" name="formSubmit">修改</button></td>
            </tr>
        </table>
    </form>
    <br>
</fieldset>
</form>
</body>
<script>
    var htmlStr = "${remark}";
    if(htmlStr!=null){
        if(htmlStr.length>100){
            htmlStr = htmlStr.substring(0,99)+"......";
        }
    }
    document.getElementById("remark").value=htmlStr;

    function closeLayer() {
        window.parent.location.reload(); //刷新父页面
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.close(index);  // 关闭layer
    }
</script>
</html>