<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<body>
<div id="div0" v-cloak>
    <div v-show="!showList" class="panel panel-default" style="margin-top: 40px;height: 400px">

        </br>

        <input id="id" name="id" type="text" style="display: none;"
               class="form-control" value="${id}"
        />
        <div class="row" style="margin-top: 30px">
            <form class="" id="search-from" method="post" action="">

                <div class="row" style="margin-left: 50px">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-3 control-label  no-padding-right"><span
                                style="color: red">*</span>账户类型</label>
                        <div class="col-xs-9">
                            <span class="col-xs-8 block input-icon input-icon-right">
                                <select id="accountType" name="accountType" class="form-control"
                                        onchange="changeDirection();">
                                    <option value="0" selected>小神号</option>
                                    <option value="1">客户账号</option>
                                </select>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row" style="margin-left: 50px;margin-top: 10px">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-3 control-label  no-padding-right"><span
                                style="color: red">*</span>账户号码</label>
                        <div class="col-xs-9">
                            <span class="col-xs-8 block input-icon input-icon-right">
                                 <input id="accountNo" name="accountNo" type="text"
                                        class="form-control" placeholder="必填"
                                 />
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-left: 50px;margin-top: 10px">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-3 control-label  no-padding-right">通话备注</label>
                        <div class="col-xs-9">
                            <span class="col-xs-8 block input-icon input-icon-right">
                                 <input id="remark" name="remark" type="text" maxlength="50"
                                        class="form-control" placeholder="请输入通话备注"
                                 />
                            </span>
                        </div>
                    </div>
                </div>


                <div class="row" align="center" style="margin-top: 50px">
                    <td align="center">
                        <input id="formSubmit" type="button" class="layui-btn layui-btn-small" value="关联"
                               onclick="save();">
                        <input id="cancelButton" type="button" class="layui-btn layui-btn-small layui-btn-primary"
                               value="取消" onclick="cencelPage();">
                    </td>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>

    function save() {
        if($("#accountNo").val() == null || $("#accountNo").val() == ""){
            myToast("账户号码必须填写！",2);
            return;
        }
        var url = "${webRoot}/callrecord/connectAccount"
        var userId = "";
        var clientId = "";
        if ($("#accountType").val() == 0) {
            userId = $("#accountNo").val();
            if(userId.length==8){
                toast("您输入了8位数小神号 请选择客户账号!");
                return;
            }
        } else if ($("#accountType").val() == 1) {
            clientId = $("#accountNo").val();
            if(clientId.length!=8){
                toast("您输入客户账号非8位 请选择小神号!");
                return;
            }
        }

        var params = {
            id: $("#id").val(),
            userId: userId,
            clientId: clientId,
            remark:$("#remark").val()
        }
        $.post(url, params, function (result) {
            toast(result, function () {
                //刷新父窗口列表
                parent.location.reload();
                //关闭弹框
                closeThisWindow();
            });
        });
    }

    function cencelPage() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }


</script>
</html>
