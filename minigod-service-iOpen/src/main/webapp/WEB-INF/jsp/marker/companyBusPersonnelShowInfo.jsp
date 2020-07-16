<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<div id="div0" v-cloak>
    <div v-show="!showList" class="panel panel-default" style="text-align: center;   width: 99.9%">
        <div class="panel-heading"><b style="color: #368763">业务人员信息</b></div>
        </br>

        <form class="layui-form" id="search-from" name="search-from" method="post">
            <div class="layui-form-item">
                <table width="99%" height="85%">
                    <input type="text" id="id" name="id" hidden="hidden" value="${info.id}">
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px"><span style="color: red">*</span>客户姓名：</label>
                            <div class="col-xs-5">
                                <input type="text" id="personnelName" name="personnelName" value="${info.personnelName}" readonly
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px"><span style="color: red">*</span>员工角色：</label>
                            <div class="col-xs-5 ">
                                <tag:select id="personnelRole" name="personnelRole" nameKey="SEC_PERSONNEL_ROLE" isAddDefaltOption="true" initSelectedKey="${info.personnelRole}" disabled="disabled"></tag:select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px"><span
                                    style="color: red">*</span>性别：</label>
                            <div class="col-xs-5">
                                <tag:select id="sex" name="sex" nameKey="COMMON_SEX" isAddDefaltOption="true" initSelectedKey="${info.sex}" ></tag:select>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px"><span
                                    style="color: red">*</span>学历：</label>
                            <div class="col-xs-5">
                                <tag:select name="educationType" id="educationType" nameKey="SEC_EDUCATION_TYPE" isAddDefaltOption="true" initSelectedKey="${info.educationType}"  disabled="disabled"></tag:select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px"><span style="color: red">*</span>员工状态：</label>
                            <div class="col-xs-5">
                                <tag:select id="personnelStatus" nameKey="SEC_PERSONNEL_STATUS" name="personnelStatus" isAddDefaltOption="true" initSelectedKey="${info.personnelStatus}" disabled="disabled"></tag:select>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px"></span>出生日期：</label>
                            <div class="col-xs-5">
                                <input type="text" id="birthdayDate" name="birthdayDate" value="${info.birthdayDate}" readonly
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px"><span style="color: red">*</span>证件类型：</label>
                            <div class="col-xs-5">
                                <tag:select id="idType" nameKey="SEC_ID_TYPE" name="idType" isAddDefaltOption="true" initSelectedKey="${info.idType}" disabled="disabled"></tag:select>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">证件号：</label>
                            <div class="col-xs-5">
                                <input type="text" id="idNo" name="idNo" value="${info.idNo}" readonly
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px">职位：</label>
                            <div class="col-xs-5">
                                <input type="text" id="jobPosition" name="jobPosition" value="${info.jobPosition}" readonly
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">证券从业资格证编号：</label>
                            <div class="col-xs-5">
                                <input type="text" id="sacNo" name="sacNo" value="${info.sacNo}" readonly
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px">见证资格证编号：</label>
                            <div class="col-xs-5">
                                <input type="text" id="witnessNo" name="witnessNo" value="${info.witnessNo}" readonly
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">办公电话：</label>
                            <div class="col-xs-5">
                                <input type="text" id="officePhone" name="officePhone" value="${info.officePhone}" readonly
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px">移动电话：</label>
                            <div class="col-xs-5">
                                <input type="text" id="mobilePhone" name="mobilePhone" value="${info.mobilePhone}" readonly
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">家庭电话：</label>
                            <div class="col-xs-5">
                                <input type="text" id="homePhone" name="homePhone" value="${info.homePhone}" readonly
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px">传真电话：</label>
                            <div class="col-xs-5">
                                <input type="text" id="faxPhone" name="faxPhone" value="${info.faxPhone}" readonly
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">联系地址：</label>
                            <div class="col-xs-5">
                                <input type="text" id="contactAddress" name="contactAddress" readonly
                                       value="${info.contactAddress}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px">邮政编码：</label>
                            <div class="col-xs-5">
                                <input type="text" id="postCode" name="postCode" value="${info.postCode}" readonly
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">电子邮箱：</label>
                            <div class="col-xs-5">
                                <input type="text" id="email" name="email" value="${info.email}" readonly
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px">邀约码：</label>
                            <div class="col-xs-5">
                                <input type="text" id="aeCode" name="aeCode" value="${info.aeCode}" readonly
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <div class="col-xs-8">
                                <button class="layui-btn " type="button" id="closeLayer">关闭</button>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</div>
</div>
</div>
</body>
<script>
    $("#closeLayer").click(function () {
        closeLayer();
    })

    end: function close() {
        window.parent.location.reload();
    }

    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }
    layui.form.render('select');
</script>
</html>
