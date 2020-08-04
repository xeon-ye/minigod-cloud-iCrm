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
                <c:if test="${acceptView == 'add'}">
                <td align="center">
                    <div class="col-xs-6">
                        <label class="layui-form-label "
                               style="width: 250px;font-weight: bold;font-size: 20px">新增渠道:</label>
                    </div>
                </td>
                </c:if>
                <c:if test="${acceptView == 'update'}">
                <td align="center">
                    <div class="col-xs-6">
                        <label class="layui-form-label "
                               style="width: 250px;font-weight: bold;font-size: 20px">修改渠道:</label>
                    </div>
                </td>
                </c:if>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;">上级菜单:</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" value="${fareKindInfo.parentId}"
                               class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;">所属片区:</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" value="${fareKindInfo.areaName==null?'暂无所属片区':fareKindInfo.areaName}"
                               class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;">渠道号:</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" name="" value="${fareKindInfo.channelId}"
                               class="form-control">
                    </div>
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<div class="col-xs-6">--%>
                        <%--<label class="layui-form-label" style="width: 250px;">渠道名:</label>--%>
                    <%--</div>--%>
                    <%--<div class="col-xs-3">--%>
                        <%--<input type="text" name="" value="${fareKindInfo.channelName}"--%>
                               <%--class="form-control">--%>
                    <%--</div>--%>
                <%--</td>--%>
            <%--</tr>--%>
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
                        <label class="layui-form-label" style="width: 250px;">是否参加官方开户免佣活动:</label>
                    </div>
                    <div class="col-xs-3">
                        <c:if test="${fareKindInfo.isFreeCommission==0}">
                            <input type="text" name="" value="否"
                                   class="form-control">
                        </c:if>
                        <c:if test="${fareKindInfo.isFreeCommission==1}">
                            <input type="text" name="" value="是"
                                   class="form-control">
                        </c:if>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="col-xs-6">
                        <label class="layui-form-label" style="width: 250px;">佣金方案:</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" name="" style="width:80%;display: inline" value="${fareKindInfo.fareKind}" class="form-control">
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
                               value="<fmt:formatDate value="${fareKindInfo.beginDate}" pattern="yyyy-MM-dd"/>"
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
                               value="<fmt:formatDate value="${fareKindInfo.endDate}" pattern="yyyy-MM-dd"/>"
                               class="form-control">
                    </div>
                </td>
            </tr>
            <c:if test="${nextFareKindInfo!=null}">
                <tr>
                    <td>
                        <div class="col-xs-9">
                            <label class="layui-form-label" style="width: 250px;font-weight:bold ;">下一方案</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="col-xs-6">
                            <label class="layui-form-label" style="width: 250px;">是否参加官方开户免佣活动:</label>
                        </div>
                        <div class="col-xs-3">
                            <c:if test="${nextFareKindInfo.isFreeCommission==0}">
                                <input type="text" name="" value="否"
                                       class="form-control">
                            </c:if>
                            <c:if test="${nextFareKindInfo.isFreeCommission==1}">
                                <input type="text" name="" value="是"
                                       class="form-control">
                            </c:if>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="col-xs-6">
                            <label class="layui-form-label" style="width: 250px;">佣金方案:</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" style="width:80%;display: inline" name="" value="${nextFareKindInfo.fareKind}"class="form-control">
                            <i v-show="icon" id="nextIconTips"   class="layui-icon" style="font-size: 20px; color: #4caf50;">  &#xe607;</i>
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
                                   value="<fmt:formatDate value="${nextFareKindInfo.beginDate}" pattern="yyyy-MM-dd"/>"
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
                                   value="<fmt:formatDate value="${nextFareKindInfo.endDate}" pattern="yyyy-MM-dd"/>"
                                   class="form-control">
                        </div>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td><br></td>
            </tr>
        </table>
    </div>

</div>

<c:if test="${flag == 2}">
    <%@include file="../activiti/processComSub.jsp" %>
</c:if>
</body>
<script>

    function ToChildren() {
        return ${fareKindInfo.channelId};
    }
    //展开套餐列表
    function historyOnClick() {
        url = "${webRoot}/marker/channelFareHistory.html",
            layer.open({
                scrollbar: false,
                type: 2,
                title: ["客户佣金方案", true],
                area: ['90%', '80%'], //宽高
                content: [url, 'yes'],
                shadeClose: false,
                btn: ['确认'],
                yes: function (index) {
                    layer.close(index);
                }
            });
    }


    //tips
    $("#iconTips").hover(function () {
        if (${fareKindInfo.fareKind != null and fareKindInfo.fareKind != ''}) {
            openMsg(this.id);
        }
    }, function () {
        layer.close(subtips);
    });
    //tips
    $("#nextIconTips").hover(function () {
        if (${nextFareKindInfo.fareKind != null and nextFareKindInfo.fareKind != ''}) {
            openMsg(this.id);
        }
    }, function () {
        layer.close(subtips);
    });
    //tips
    function openMsg(tipsIndex) {
        var fareKind = "${fareKindInfo.fareKind}";
        if(tipsIndex=='nextIconTips'){
            fareKind = "${nextFareKindInfo.fareKind}";
        }
        var url = "${webRoot}/farePackageSetup/info/" + fareKind;
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
</script>
</html>