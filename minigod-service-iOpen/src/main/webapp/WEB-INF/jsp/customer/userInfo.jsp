<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<jsp:useBean id="dateValue" class="java.util.Date"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>小神用户详情</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<body>
<div class="col-sm-12" id="main-container">
    <form class="layui-icon-form" id="userList" name="userList" style="width: 100%">
        <div id="div0" v-cloak class="" >
            <br>
            <div v-show="!showList" class="panel panel-default" style="height: 570px">
                <%--<input hidden type="text" name="userId" id="userId" value="${resultInfo.userId}">--%>
                <%--<div class="panel-heading"><b style="color: #368763">${resultInfo.clientName}账号信息</b></div>--%>
                    <div class="panel-heading"><b style="color: #368763">用户详情</b></div>
                </br>
                <br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">小神号:</label>
                        <div class="col-sm-9">
                            <span class="col-xs-9 block input-icon input-icon-right">
                                <input id="userId" name="userId" type="text" class="form-control " required
                                       value="${resultInfo.userId}" readonly/>
                            </span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">注册来源:</label>
                        <div class="col-sm-9">
                            <span class="col-xs-9 block input-icon input-icon-right">
                                <input id="regSourceType" name="regSourceType" type="text" class="form-control " required
                                       value="${resultInfo.regSourceType}" readonly/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">用户昵称:</label>
                        <div class="col-sm-9">
                            <span class="col-xs-9 block input-icon input-icon-right">
                                <input id="clientName" name="clientName" type="text" class="form-control " required
                                       value="${resultInfo.clientName}" readonly/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">来源标识:</label>
                        <div class="col-sm-9">
                            <span class="col-xs-9 block input-icon input-icon-right">
                                <input id="regSource" name="regSource" type="text" class="form-control " required
                                       value="${resultInfo.regSource}" readonly/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">注册手机号:</label>
                        <div class="col-sm-9">
                            <span class="col-xs-9 block input-icon input-icon-right">
                                <input id="phoneNumber" name="phoneNumber" type="text" class="form-control " required
                                       value="${resultInfo.phoneNumber}" readonly/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">渠道号:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <%--<input type="text" id="channelName" name="sourceChannelName" class="form-control" style="cursor:pointer;" onclick="menuTree();"  value="${resultInfo.sourceChannelName}" placeholder="请选择渠道"/>--%>
                                        <input  type="text" id="sourceChannelId" name="sourceChannelId" value="${resultInfo.sourceChannelId}" class="form-control " required readonly/>
                                    </span>
                        </div>
                    </div>
                </div>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">微信号:</label>
                            <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="certCode" name="certCode" type="text" class="form-control  "
                                               required
                                               value="${resultInfo.certCode}"  readonly/>
                                    </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">好友数量:</label>
                            <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="friendCount" name="friendCount" type="text" class="form-control  "
                                               required
                                               value="${resultInfo.friendCount}"  readonly/>
                                    </span>
                            </div>
                        </div>

                    </div>


                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">用户状态:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                             <input id="userStatus" name="userStatus" type="text"
                                                    class="form-control"
                                                    value="${resultInfo.userStatus}" />

                                    </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">好友上限:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="friendLimit" name="friendLimit" type="text"
                                               class="form-control"
                                               value="${resultInfo.friendLimit}" />
                                    </span>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">最后活跃时间:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="lastLoginTime" name="lastLoginTime" type="text"
                                               class="form-control  " required
                                               value="${resultInfo.lastLoginTime}" readonly/>
                                    </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">注册时间:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="registerTime" name="registerTime" type="text" class="form-control  "
                                               required
                                               value="${resultInfo.registerTime}"  readonly/>
                                    </span>
                        </div>
                    </div>

                </div>

                <c:if test="${getType!=null}">
                    <div class="row" >
                        <div class="form-group col-sm-6 col-md-6">
                            <div class="col-xs-9">
                                <br><br><br><br><br>
                                <span class="col-xs-9 block input-icon input-icon-right">
                                      <button id="saveChange" type="button" class="layui-btn " >保存</button>
                                      <button id="resetForm" type="reset" class="layui-btn  layui-btn-warm" >重置</button>
                                      <button id="goBack" type="button" class="layui-btn " >返回</button>
                                    </span>
                            </div>
                        </div>
                    </div>
                </c:if>

            </div>
        </div>
    </form>
</div>
<!-- 选择渠道 -->
<div id="menuLayer" style="display: none;padding:10px;">
    <ul id="menuTree" class="ztree"></ul>
</div>
</body>
<script>
    $().ready(function(){
        if(${getType ==null or getType ==""}){
            $("input").attr("readonly", true);
            $("select").attr("disabled", true);
        }
    });

    /**
     * 保存小神用户详情修改
     */
    $("#saveChange").click(function () {
        $.ajax({
            url: "${webRoot}/secUserInfo/updateUserInfo",
            data: $("#userList").serialize(), //为值取个名字*/
            type: "post",  //传值方式
            dataType: "text",
            success: function (d) {
                if (d.trim() == "ok") {
                    layer.confirm('保存成功！', {
                        btn: ['是'], btn1: function () {
                            closeLayer();
                        }
                    })
                } else if (d.trim() == "error") {
                    layer.confirm('保存失败！', {
                        btn: ['是'], btn1: function () {
                            location.reload();
                        }
                    })
                }
            }
        })
    });

    $("#goBack").click(function () {
        closeLayer();
    });

    $("#resetForm").click(function () {
        location.reload();
    });

    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }

    layui.form.render('select');



</script>
<script src="${webRoot}/js/channel/channel.js"></script>
</html>
