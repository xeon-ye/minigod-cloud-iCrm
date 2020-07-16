<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>参数设置</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<body>
<div v-show="!showList" class="panel panel-default">
    <div class="panel-heading"><b style="color: #368763;text-align:center">参数设置</b></div>
    </br>
    <div class="row">
        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-4 control-label no-padding-right">币种</label>
            <div class="col-xs-8">
               <span class="col-sm-30 block input-icon input-icon-right">
                   <tag:select id="ccy" name="ccy" nameKey="SEC_CCY_TYPE"
                               isAddDefaltOption="false" clazz="form-control" initDidableKey="CNY"/>
                </span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-4 control-label no-padding-right">入金上限金额</label>
            <div class="col-xs-8">
                <span class="col-sm-30 block input-icon input-icon-right">
                    <input id="maxAmount" name="maxAmount" type="number" class="form-control" lay-verify="number"
                           onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')" onblur="if(this.value ==0||!/^\d+(\.\d{1,2})?$/.test(this.value))this.value=''" placeholder="请输入数字，保留小数点后两位">
                </span>
            </div>

        </div>
        <div class="layui-form-mid layui-word-aux"><a style="color: red">*大于以上金额的入金申请需经过人工审核</a></div>
    </div>
    <div class="row">
        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-4 control-label no-padding-right">生效时间</label>
            <div class="col-xs-8">
                <span class="col-sm-30 block input-icon input-icon-right">
                    <input id="validTime" name="validTime" type="text" class="layui-input" readonly>
                </span>
            </div>
        </div>
    </div>


    <div class="row" style="margin-left: 40%;padding-bottom: 28px;margin-top: 15px;">
        <button class="layui-btn " type="button" onclick="save()">保存</button>
        <button class="layui-btn layui-btn-primary" type="button" onclick="closeThisWindow()">关 闭</button>
    </div>
</div>

</body>
<script>
    // 新增信息
    function save() {

        if($("#maxAmount").val()==''){
            alertMsg("请输入入金上限金额");
            return;
        }

        if($("#validTime").val()==''){
            alertMsg("请输入生效时间");
            return;
        }

        var url = "${webRoot}/dbsIccDepositConfig/save";
        var params = {
            'ccy': $("#ccy").val(),
            'maxAmount': $("#maxAmount").val(),
            'validTime': new Date($("#validTime").val())
        };
        $.post(url, params, function (result) {
            if (result.code == '0') {
                toast(result, function () {
                    //刷新父窗口列表
                    parent.location.reload();
                    //关闭弹框
                    closeThisWindow();
                })
            } else {
                alertMsg(result.msg);
            }
        }, "json");
    }

    layui.laydate.render({
        elem: '#validTime',
        type: 'datetime'
    });

    layui.form.render('select');

</script>

</html>