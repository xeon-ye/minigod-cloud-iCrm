<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Excel导入</title>
    <script type="text/javascript" src="${webRoot}/js/excel/ace.js"></script>
    <script type="text/javascript" src="${webRoot}/js/excel/elements.fileinput.js"></script>
    <script type="text/javascript" src="${webRoot}/js/excel/jquery.tips.js"></script>
    <script type="text/javascript" src="${webRoot}/js/excel/ajaxfileupload.js"></script>
</head>
<body class="no-skin">

<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <div class="main-content-inner">
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <input type="hidden" name="groupNo" id="groupNo" value="${groupNo}">
                        <form action="${webRoot}/tmkCustomer/clientImportExcle" name="uploadForm"
                              id="uploadForm"
                              method="post"
                              enctype="multipart/form-data">
                            <div id="impDialog">
                                <table style="width:95%;">
                                    <tr>
                                        <td style="padding-top: 20px;"><input type="file" id="excel" name="excel" onchange="fileType(this)"/></td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: center;padding-top: 10px;">
                                            <a class="btn btn-mini btn-success"
                                               onclick="window.location.href='${webRoot}/tmkCustomer/downExcel'">下载模版</a>
                                            <a class="btn btn-mini btn-primary" onclick="save();">导入</a>
                                            <a class="btn btn-mini btn-danger" onclick="closeLayer();">取消</a>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </form>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.page-content -->
        </div>
    </div>
    <!-- /.main-content -->
</div>
<!-- /.main-container -->

<!-- basic scripts -->
<!-- 页面底部js¨ -->
<script type="text/javascript">
    $(function () {
        //上传
        $('#excel').ace_file_input({
            no_file: '请选择Excel',
            btn_choose: '选择',
            btn_change: '更改',
            droppable: false,
            onchange: null,
            thumbnail: false, //| true | large
            whitelist: 'xls|xls|xlsx',
            blacklist: 'gif|png|jpg|jpeg'
            //onchange:''
        });
    });

    //保存
    function save() {
        if ($("#excel").val() == "" || document.getElementById("excel").files[0] == '请选择xls格式的文件') {

            $("#excel").tips({
                side: 3,
                msg: '请选择文件',
                bg: '#AE81FF',
                time: 3
            });
            return false;
        }

        var groupNo = $("#groupNo").val();
        $.ajaxFileUpload({
            url: '${webRoot}/tmkCustomer/importExcle',
            data : {
                groupNo:groupNo
            },
            secureuri: false,
            fileElementId: 'excel',
            dataType: 'text',
            success: function (data){
                layer.confirm(data, { btn: ['是'],btn1: function(){
//                    location.reload();
                    closeLayer();
                }
                });
            },
            error: function (data, status, e){
                alert(data);
                $("#impDialog").hide();
            }
        });
    }

    function fileType(obj) {
        // 获得文件后缀名
        var fileType = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();
        if (fileType != '.xls' && fileType != '.xlsx') {
            $("#excel").tips({
                side: 3,
                msg: '请上传xls格式的文件',
                bg: '#AE81FF',
                time: 3
            });
            $("#excel").val('');
            document.getElementById("excel").files[0] = '请选择xls|xlsx格式的文件';
        }
    }

    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }
</script>


</body>
</html>