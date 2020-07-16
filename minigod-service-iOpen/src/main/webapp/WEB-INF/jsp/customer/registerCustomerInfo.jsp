<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>登记客户资料</title>
</head>
<body>
<div id="div0" v-cloak>
    <div v-show="!showList" class="panel panel-default">

        <div class="row">
            <form class="layui-form" id="search-from" method="post">
                <table class="layui-table">
                    <tr>
                        <td hidden="hidden">
                            <input id="id" value="${info.id}" name="id">
                        </td>
                        <td>
                            <label class="col-sm-3 control-label no-padding-right">手机号码：</label>
                            <div class="col-xs-9">
                                    <span class="col-xs-8 block input-icon input-icon-right">
                                         <input id="groupNo" name="groupNo" type="text" value="${info.phoneNumber}"
                                                class="form-control" placeholder="请输入手机号码" disabled
                                         />
                                    </span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="col-sm-3 control-label no-padding-right">触达情况：</label>
                            <div class="col-xs-9">
                                    <span class="col-xs-8 block input-icon input-icon-right">
                                         <tag:select id="contactStatus" name="contactStatus"
                                                     nameKey="SEC_CONTACT_STATUS"
                                                     isAddDefaltOption="true" initSelectedKey="${info.contactStatus}"
                                                     clazz="form-control"></tag:select>
                                    </span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="col-sm-3 control-label no-padding-right">添加微信：</label>
                            <div class="col-xs-9">
                                    <span class="col-xs-8 block input-icon input-icon-right">
                                         <tag:select id="addWechat" name="addWechat"
                                                     nameKey="SEC_ADD_WECHAT"
                                                     isAddDefaltOption="true" initSelectedKey="${info.addWechat}"
                                                     clazz="form-control"></tag:select>
                                    </span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="col-sm-3 control-label no-padding-right">开户情况：</label>
                            <div class="col-xs-9">
                                    <span class="col-xs-8 block input-icon input-icon-right">
                                         <tag:select id="openAccountStatus" name="openAccountStatus"
                                                     nameKey="SEC_OPEN_ACCOUNT_STATUS"
                                                     isAddDefaltOption="true" initSelectedKey="${info.openAccountStatus}"
                                                     clazz="form-control"></tag:select>
                                    </span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="col-sm-3 control-label no-padding-right">入金情况：</label>
                            <div class="col-xs-9">
                                    <span class="col-xs-8 block input-icon input-icon-right">
                                         <tag:select id="depositStatus" name="depositStatus"
                                                     nameKey="SEC_DEPOSIT_STATUS"
                                                     isAddDefaltOption="true" initSelectedKey="${info.depositStatus}"
                                                     clazz="form-control"></tag:select>
                                    </span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="col-sm-3 control-label no-padding-right">香港银行卡：</label>
                            <div class="col-xs-9">
                                    <span class="col-xs-8 block input-icon input-icon-right">
                                         <tag:select id="isBankCard" name="isBankCard"
                                                     nameKey="YES_NO"
                                                     isAddDefaltOption="true" initSelectedKey="${info.isBankCard}"
                                                     clazz="form-control"></tag:select>
                                    </span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="col-sm-3 control-label no-padding-right">沟通内容记录：</label>
                            <div class="col-xs-9">
                                         <textarea id="contentDescription" name="contentDescription" placeholder="请输入沟通内容记录" class="layui-textarea">${info.contentDescription}</textarea>
                                    </span>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td align="center">
                            <input type="button" class="layui-btn " value="提交" onclick="register();">
                            <input type="button" class="layui-btn layui-btn-primary " value="关闭" onclick="closeLayer();">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<script>

    // 修改
    function register() {
        var id = $("#id").val();
        var contactStatus = $("#contactStatus").val();
        var addWechat = $("#addWechat").val();
        var openAccountStatus = $("#openAccountStatus").val();
        var depositStatus = $("#depositStatus").val();
        var contentDescription = $("#contentDescription").val();
        var isBankCard = $("#isBankCard").val();
        $.ajax({
            url: "${webRoot}/tmkCustomer/register",   //处理页面的名称
            data: {
                id:id,
                contactStatus: contactStatus,
                addWechat: addWechat,
                openAccountStatus: openAccountStatus,
                depositStatus: depositStatus,
                contentDescription: contentDescription,
                isBankCard: isBankCard
            },  //为值取个名字
            type: "POST",  //传值方式
            dataType: "text",  //数据类型
            success: function (d) {
                if (d.trim() == "ok") {
                    layer.confirm('登记成功！', {
                        btn: ['是'], btn1: function () {
                            closeLayer();
                        }
                    })
                } else if (d.trim() == "error") {
                    layer.confirm('登记失败！', {
                        btn: ['是'], btn1: function () {
                            location.reload();
                        }
                    })
                }
            }
        })
    }

    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }
</script>
</body>
</html>
