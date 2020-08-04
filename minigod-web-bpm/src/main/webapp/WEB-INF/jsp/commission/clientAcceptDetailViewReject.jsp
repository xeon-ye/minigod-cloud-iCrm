<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>客户佣金套餐</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="layui-tab layui-table-view" style="margin-top: 20px;">
        <table width="40%" align="center" valign="center" border="0px">
            <tr>
                <td align="center">
                    <div class="col-xs-6">
                        <label class="layui-form-label "
                               style="width: 250px;font-weight: bold;font-size: 20px">个人佣金修改:</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;">渠道号:</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" name="" value="${clientFareInfo.channelId}"
                               class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;">渠道名:</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" name="" value="${clientFareInfo.channelName}"
                               class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;">小神号:</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" name="" value="${clientFareInfo.userId}"
                               class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;">姓名:</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" name="" value="${clientFareInfo.clientName}"
                               class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;font-weight:bold ;">目前方案</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;">佣金方案:</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" style="width: 80%;display: inline" name="" value="${clientFareInfo.fareKind}"
                               class="form-control">
                        <i v-show="icon" id="iconTips"  class="layui-icon" style="font-size: 20px; color: #4caf50;">  &#xe607;</i>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;">方案有效期:</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" name=""
                               value="<fmt:formatDate value="${clientFareInfo.beginDate}" pattern="yyyy-MM-dd"/>"
                               class="form-control" style="display: inline">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;">到:</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" name=""
                               value="<fmt:formatDate value="${clientFareInfo.endDate}" pattern="yyyy-MM-dd"/>"
                               class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
        </table>
        <div class="row">
            <div class="form-group col-sm-8 ">
                <label class="control-label col-sm-2">审批意见:</label>
                <div class="col-sm-10">
                    <div class="form-group">
                        <textarea name="remark" id="remark" class="form-control" rows="3"></textarea>
                    </div>
                </div>
            </div>

            <button class="layui-btn layui-btn-danger layui-btn-warm" type="button"
                    onclick="flowEnd('${processTaskDto.busId}','${processTaskDto.taskId}','${processTaskDto.defId}','${processTaskDto.instanceId}')">
                <i class="layui-icon">&#x1007;</i>终止
            </button>
        </div>
    </div>

</div>
<c:if test="${flag == 2}">
    <%@include file="../activiti/processComSub.jsp" %>
</c:if>

</body>
<script>

    /**
     * 历史记录
     */
    function showHistory(){
        url = "${webRoot}/clientFareSetupLog/list?clientId="+${clientFareInfo.clientId};
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["客户佣金方案历史记录", true],
            area: ['90%', '90%'], //宽高
            content: [url, 'yes'],
            shadeClose: false
        });
    }
    //tips
    $("#iconTips").hover(function () {
        if (${clientFareInfo.fareKind != null and clientFareInfo.fareKind != ''}) {
            openMsg(this.id);
        }
    }, function () {
        layer.close(subtips);
    });

    //tips
    function openMsg(tipsIndex) {
        var url = "${webRoot}/farePackageSetup/info/" + ${clientFareInfo.fareKind}
        $.get(url, function (result) {
            if(result.tips!=null && result.tips!=''){
                subtips = layer.tips("<span style='font-size: 15px'>"+result.tips+"</span>", '#'+tipsIndex,
                    {
                        tips: [1, '#0FA6D8'], //设置tips方向和颜色 类型：Number/Array，默认：2 tips层的私有参数。支持上右下左四个方向，通过1-4进行方向设定。如tips: 3则表示在元素的下面出现。有时你还可能会定义一些颜色，可以设定tips: [1, '#c00']
                        tipsMore: false, //是否允许多个tips 类型：Boolean，默认：false 允许多个意味着不会销毁之前的tips层。通过tipsMore: true开启
                        area: 'auto',
                        maxWidth:1000,
                        maxHeight:350,
                        time:0 //2秒后销毁，还有其他的基础参数可以设置。。。。这里就不添加了
                    }
                );
            }
        })
    }

    function closeLayer() {
        window.parent.location.reload(); //刷新父页面
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.close(index);  // 关闭layer
    }

    /**
     * 终止
     * @param actKey
     * @param busId
     */
    function flowEnd(busId, taskId, defId, instanceId) {

        var remark = $("#remark").val();

        var params = "remark=" + remark + "&busId=" + busId + "&taskId=" + taskId + "&defId=" + defId + "&instanceId=" + instanceId;
        var url = "${webRoot}/clientFareSetupLog/reject";

        confirm("确认终止流程吗?", function () {
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    alert(result, function () {
                        closeThisWindow();
                        window.parent.location.reload();
                    })
                } else {
                    alertMsg(result.msg);
                }
            }, "json");
        });
    }
</script>
</html>