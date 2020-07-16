<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html>
<head>
    <title>上传银行凭证页</title>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer-jquery.min.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
    <script src="${webRoot}/js/jquery.serializejson.js"></script>
</head>
<body>
<div id="div0" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div style="margin-left: 1%;width: 90%; font-size: 0; height: 80%; vertical-align: middle;" style="overflow:auto">
            <div style="margin-left: 20px;width: 90%;">
                <div hidden id="imageList">
                    <ul class="docs-pictures"></ul>
                </div>
                <c:forEach var="imageInfo" items="${bankImages}" varStatus="i">
                                <span class="col-xs-2 block input-icon " style="margin-top: 15px; margin-left: 50px">
                                        <img width="150" height="120"
                                             src ='${webRoot}/common/downloadFile?fullFilePath=${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}'
                                             onclick="showAccountOpenImg(${i.index})"/>
                                    <span class="col-xs-1 block input-icon" style="margin-top: 5px;margin-left: 20px">
                                        <button id="reLoadButtonV${i.index}" type="button"
                                                name="reLoadButtonV" value="${imageInfo.id}">
                                                <i class="layui-icon" style="font-size: 20px; color: #209d6c;">
                                                    &#xe642;</i>
                                        </button>
                                    </span>
                                    <span class="col-xs-1 block input-icon" style="margin-top: 5px;margin-left: 20px">
                                        <button id="deleteImage" type="button"
                                                name="deleteImage" onclick="deleteImage(${imageInfo.id})">
                                                <i class="layui-icon" style="font-size: 20px; color: #ff2128;">
                                                    &#xe640;</i>
                                        </button>
                                    </span>
                                </span>
                    <!--循环调用方法-->
                    <script type="text/javascript">pictureList("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}", ${i.index});</script>
                </c:forEach>
                    <span class="col-xs-2 block input-icon input-icon-right" style="margin-top: 15px;margin-left: 50px">
                        <button id="uploadBank" type="button" name="uploadBank">
                            <i class="layui-icon" style="font-size: 110px; color: #209d6c;">
                                &#xe608;</i>
                        </button>
                        <div class="layui-upload-list">
                            <img class="layui-upload-img" id="image">
                            <p id="demoText"></p>
                        </div>
                    </span>
            </div>
        </div>
    </div>
    <div class="col-sm-12" align="center">
        <br>
        <button class="layui-btn layui-btn-radius" type="button" onclick="doBankPass()">提交</button>
    </div>
</div>
</body>
<script>
    $(function () {
        $('#imageList').viewer();
    });
    // 流程相关信息类
    function processInfo(busId, actKey, taskId, instanceId, changeFields, defId,remark) {
        this.busId = busId;//业务id
        this.actKey = actKey;//流程key也是业务key
        this.taskId = taskId;//任务id
        this.instanceId = instanceId;//流程实例
        this.changeFields = changeFields;//可更改的字段
        this.defId = defId;//流程定义id
        this.remark = remark;
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

    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;
        //文件上传
        var uploadInst = upload.render({
            elem: '#uploadBank'
            , url: '${webRoot}/clientFundDeposit/uploadImage'
            ,accept : 'image'
            ,size: 24000
            ,acceptMime : 'image/jpg,image/jpeg,image/bmp,image/png' //layui 2.2.6开始支持
            ,exts: 'jpg|jpeg|bmp|png' //只允许上传图片文件
            ,data: {
                imageType:1
                ,applicationId:'${info.applicationId}'
            }
            ,method:'POST'
            , done: function (res) {
                if (res.code == 0) {
                    window.location.reload();
                    alert("上传成功");
                } else {
                    alert(res.msg);
                    window.location.reload();
                }
            }
        });
        var reButton = document.getElementsByName('reLoadButtonV');
        for (var i = 0; i < reButton.length; i++) {
            var id = $("#reLoadButtonV"+i).val();
            upload.render({
                elem: reButton[i]
                ,url: '${webRoot}/clientFundDeposit/reUpload'
                ,accept : 'image'
                ,acceptMime : 'jpg|jpeg|bmp|png'
                ,exts: 'jpg|jpeg|bmp|png' //只允许上传图片文件
                ,data: {
                    gid:id
                }
                ,method:'POST'
                , done: function (res) {
                    if (res.code == 0) {
                        window.location.reload();
                        alert("上传成功");
                    } else {
                        alert(res.msg);
                        window.location.reload();
                    }
                }
            });
        }
    });
    function deleteImage(id) {
        confirm('确定删除图片吗？', function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var url = "${webRoot}/clientFundDeposit/deleteImage";
            var params = {
                'id': id
            };
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result, function () {
                        // 刷新列表
                        window.location.reload();
                    })
                } else {
                    alertMsg(result.msg);
                    layer.close(loading);
                    // 刷新列表
//                    window.location.reload();
                }
            }, "json");

        });
    }

    // 提交
    function doBankPass() {
        var count = 0;
        <c:forEach items="${bankImages}" var="item" varStatus="status" >
            count++;
        </c:forEach>
        if(count ==0 || count>5){
            alertMsg('请上传多余1张且少于5张图片');
        }else{
        confirm("确定执行此操作吗？", function () {
            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
            var url = "${webRoot}/clientFundDeposit/doBankCheckPass";
            var userIds = new Array();
            $("#userTab input[name='userIds']").each(function () {
                userIds.push($(this).val());
            });
            var params = {
                'flowId':${flowId},
                'busId': '${info.applicationId}',
                'taskId': '${taskDto.taskId}',
                'instanceId': '${taskDto.instanceId}',
                'defId': '${taskDto.defId}',
                'varValue': processInfo.varValue,
                'varName': processInfo.varName,
                'nodeType': processInfo.nodeType,
                'remark':processInfo.remark,
                'nextUserIds': userIds.join(",")

            };
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    toast(result, function () {
                        //刷新父窗口列表
                        parent.parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    })
                } else {
                    alertMsg(result.msg);
                    layer.close(loading);
                }
            });

        });
        }
    }
</script>
</html>
