<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html>
<body>
<div id="div0" v-cloak>
    <div v-show="!showList" class="panel panel-default" style="width: 65%">
        <div class="panel-heading"><b style="color: #368763">潜在用户录入</b></div>
        </br>

        <form class="layui-form" id="search-from" name="search-from" method="post" >
            <div class="layui-form-item">
                <table width="100%">
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 120px"><span style="color: red">*</span>客户编号：</label>
                            <div class="col-xs-8">
                                <input type="text" id="gid" name="gid" value="0" readonly
                                       class="form-control">
                            </div>
                        </td>

                        <td>
                            <label class="layui-form-label" style="width: 120px"><span style="color: red">*</span>客户姓名：</label>
                            <div class="col-xs-7">
                                <input type="text" id="clientName" name="clientName" value="${clientName}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 120px">渠道：</label>
                            <div class="col-xs-8">
                                <input type="text" id="sourceChannelName" name="sourceChannelName"
                                       class="form-control">
                            </div>
                        </td>

                        <td>
                            <label class="layui-form-label" style="width: 120px">客户类型：</label>
                            <div class="col-xs-7">
                                <input type="text" name="clientType" value="潜在客户" readonly
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 120px">客户性别：</label>
                            <div class="col-xs-8">
                                <tag:select id="sex" nameKey="COMMON_SEX" name="sex" isAddDefaltOption="true" clazz="form-control"></tag:select>
                            </div>
                        </td>

                        <td>
                            <label class="layui-form-label" style="width: 120px"><span style="color: red">*</span>开户日期：</label>
                            <div class="col-xs-7">
                                <input type="text" id="openAccountTime" name="openAccountTime"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 120px">证件类型：</label>
                            <div class="col-xs-8">
                                <tag:select id="idKind" nameKey="AO_ID_KIND" name="idKind" isAddDefaltOption="true" clazz="form-control"></tag:select>
                            </div>
                        </td>

                        <td>
                            <label class="layui-form-label" style="width: 120px">证件号码：</label>
                            <div class="col-xs-7">
                                <input type="text" id="idNo" name="idNo"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 120px"><span style="color: red">*</span>出生日期：</label>
                            <div class="col-xs-8">
                                <input type="text" id="birthday" name="birthday"
                                       class="form-control">
                            </div>
                        </td>

                        <td>
                            <label class="layui-form-label" style="width: 120px">手机号：</label>
                            <div class="col-xs-7">
                                <input type="text" id="phoneNumber" name="phoneNumber"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 120px">emial：</label>
                            <div class="col-xs-8">
                                <input type="text" id="emial" name="emial"
                                       class="form-control">
                            </div>
                        </td>

                        <td>
                            <label class="layui-form-label" style="width: 120px">联系地址：</label>
                            <div class="col-xs-7">
                                <input type="text" id="contactDetailAddress" name="contactDetailAddress"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 120px">备注：</label>
                            <div class="col-xs-7"><textarea id="remark" name="remark" class="form-control " style="resize: none;"></textarea>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td >
                            <div class="col-xs-7">
                                <button  id="saveButton" type="button" class="layui-btn" >保存</button>
                                <button class="layui-btn layui-btn-warm " type="button" id="refresh">重 置</button>
                            </div>
                        </td>

                    </tr>
                </table>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    $("#saveButton").click(function () {
        var clientName = $("#clientName").val();
        var sourceChannelName = $("#sourceChannelName").val();
        var clientType = $("#clientType").val();
        var sex = $("#sex").val();
        var openAccountTime = $("#openAccountTime").val();
        var idKind = $("#idKind").val();
        var idNo = $("#idNo").val();
        var birthday = $("#birthday").val();
        var phoneNumber = $("#phoneNumber").val();
        var email = $("#email").val();
        var contactDetailAddress = $("#contactDetailAddress").val();
        var remark = $("#remark").val();
        if(clientName==null||clientName==""){
            alert("标*处必填！");
            return;
        }else
        if(openAccountTime==null||openAccountTime==""){
            alert("标*处必填！");
            return;
        }else
        if(birthday==null||birthday==""){
            alert("标*处必填！");
            return;
        }else{

        }
        $.ajax({
            url:"${webRoot}/secUserInfo/doPotentialUserSave",   //处理页面的名称
            data:{
                clientName:clientName,
                sourceChannelName:sourceChannelName,
                clientType:clientType,
                sex:sex,
                openAccountTime:openAccountTime,
                idKind:idKind,
                idNo:idNo,
                birthday:birthday,
                phoneNumber:phoneNumber,
                email:email,
                contactDetailAddress:contactDetailAddress,
                remark:remark
            },  //为值取个名字
            type:"POST",  //传值方式
            dataType:"text",  //数据类型
            success: function(d){
                if(d.trim()=="ok"){
                    layer.confirm('保存成功！', { btn: ['是'],btn1: function(){
                        location.reload();
                    }
                    })
                }else if(d.trim()=="error"){
                    layer.confirm('保存失败！', { btn: ['是'],btn1: function(){
                        location.reload();
                    }
                    })
                }
            }
        })
    })

    layui.laydate.render({
        elem: '#openAccountTime' //指定元素
    });
    layui.laydate.render({
        elem: '#birthday' //指定元素
    });

    $("#refresh").click(function () {
        location.reload();
    })
    layui.form.render('select');
</script>
</html>
