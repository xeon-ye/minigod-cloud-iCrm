<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<div id="div0" v-cloak>
    <div v-show="!showList" class="panel panel-default" style="text-align: center;   width: 99.9%">
        <div class="panel-heading"><b style="color: #368763">业务人员信息修改</b></div>
        </br>

        <form class="layui-form" id="search-from" name="search-from" method="post">
            <div class="layui-form-item">
                <table width="99%" height="85%">
                    <input type="text" id="id" name="id" hidden="hidden" value="${info.id}">
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px"><span style="color: red">*</span>客户姓名：</label>
                            <div class="col-xs-5">
                                <input type="text" id="personnelName" name="personnelName" value="${info.personnelName}"
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
                                <tag:select name="educationType" id="educationType" nameKey="SEC_EDUCATION_TYPE" isAddDefaltOption="true" initSelectedKey="${info.educationType}"></tag:select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px"><span style="color: red">*</span>员工状态：</label>
                            <div class="col-xs-5">
                                <select id="personnelStatus" name="personnelStatus">
                                    <option value="">请选择</option>
                                    <option <c:if test="${info.personnelStatus=='0'}"> selected</c:if> value="0">删除
                                    </option>
                                    <option <c:if test="${info.personnelStatus=='1'}"> selected</c:if> value="1">正常
                                    </option>
                                    <option <c:if test="${info.personnelStatus=='2'}"> selected</c:if> value="2">禁用
                                    </option>
                                    <option <c:if test="${info.personnelStatus=='3'}"> selected</c:if> value="3">离职
                                    </option>
                                    <c:if test="${info.personnelRole!='0'}">
                                        <option <c:if test="${info.personnelStatus=='4'}"> selected</c:if> value="4">待审核
                                        </option>
                                        <option <c:if test="${info.personnelStatus=='5'}"> selected</c:if> value="5">
                                            审核不通过
                                        </option>
                                    </c:if>
                                </select>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px"></span>出生日期：</label>
                            <div class="col-xs-5">
                                <input type="text" id="birthdayDate" name="birthdayDate" value="${info.birthdayDate}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px"><span style="color: red">*</span>证件类型：</label>
                            <div class="col-xs-5">
                                <tag:select id="idType" nameKey="SEC_ID_TYPE" name="idType" isAddDefaltOption="true" initSelectedKey="${info.idType}" ></tag:select>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">证件号：</label>
                            <div class="col-xs-5">
                                <input type="text" id="idNo" name="idNo" value="${info.idNo}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px">职位：</label>
                            <div class="col-xs-5">
                                <input type="text" id="jobPosition" name="jobPosition" value="${info.jobPosition}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">证券从业资格证编号：</label>
                            <div class="col-xs-5">
                                <input type="text" id="sacNo" name="sacNo" value="${info.sacNo}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px">见证资格证编号：</label>
                            <div class="col-xs-5">
                                <input type="text" id="witnessNo" name="witnessNo" value="${info.witnessNo}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">办公电话：</label>
                            <div class="col-xs-5">
                                <input type="text" id="officePhone" name="officePhone" value="${info.officePhone}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px">移动电话：</label>
                            <div class="col-xs-5">
                                <input type="text" id="mobilePhone" name="mobilePhone" value="${info.mobilePhone}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">家庭电话：</label>
                            <div class="col-xs-5">
                                <input type="text" id="homePhone" name="homePhone" value="${info.homePhone}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px">传真电话：</label>
                            <div class="col-xs-5">
                                <input type="text" id="faxPhone" name="faxPhone" value="${info.faxPhone}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">联系地址：</label>
                            <div class="col-xs-5">
                                <input type="text" id="contactAddress" name="contactAddress"
                                       value="${info.contactAddress}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 180px">邮政编码：</label>
                            <div class="col-xs-5">
                                <input type="text" id="postCode" name="postCode" value="${info.postCode}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 210px">电子邮箱：</label>
                            <div class="col-xs-5">
                                <input type="text" id="email" name="email" value="${info.email}"
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
                                <button id="saveButton" type="button" class="layui-btn">保存</button>
                                <button class="layui-btn layui-btn-warm " type="button" id="refresh">重置</button>
                                <button class="layui-btn  " type="button" id="closeLayer">关闭</button>
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
<script>
    $("#saveButton").click(function () {
        var id = $("#id").val();
        var personnelName = $("#personnelName").val();
        var personnelRole = $("#personnelRole").val().toString();
        var educationType = $("#educationType").val().toString();
        var personnelStatus = $("#personnelStatus").val().toString();
        var idType = $("#idType").val().toString();
        var idNo = $("#idNo").val();
        var mobilePhone = $("#mobilePhone").val();
        var email = $("#email").val();
        var sex = $("#sex").val();
        if (personnelName == null || personnelName == "") {
            alert("标*处不能为空！");
            return;
        } else if (personnelRole == null || personnelRole == "") {
            alert("标*处不能为空！");
            return;
        } else if (sex == null || sex == "") {
            alert("标*处不能为空！");
            return;
        } else if (educationType == null || educationType == "") {
            alert("标*处不能为空！");
            return;
        } else if (idType == null || idType == "") {
            alert("标*处不能为空！");
            return;
        } else if (idNo != null && idNo != "" && idType == '1'&&isCardID(idNo) == false) {
            return;
        }else if (mobilePhone != "" && mobilePhone != null&&checkMobile(mobilePhone)==false) {
            return;
        }else if (email != "" && email != null&&CheckMail(email) == false) {
            return ;
        }if (id != null && id != "") {
            if (personnelStatus == null || personnelStatus == "") {
                alert("标*处不能为空！5");
                return;
            } else {
                doSaveOrUpdate();
            }
        }
        else {
            doSaveOrUpdate();
        }
    })

    function doSaveOrUpdate() {
        var id = $("#id").val();
        var personnelName = $("#personnelName").val();
        var personnelRole = $("#personnelRole").val().toString();
        var sex = $("#sex").val().toString();
        var educationType = $("#educationType").val().toString();
        var personnelStatus = $("#personnelStatus").val().toString();
        var birthdayDate = $("#birthdayDate").val();
        var idType = $("#idType").val().toString();
        var idNo = $("#idNo").val();
        var jobPosition = $("#jobPosition").val();
        var sacNo = $("#sacNo").val();
        var witnessNo = $("#witnessNo").val();
        var officePhone = $("#officePhone").val();
        var mobilePhone = $("#mobilePhone").val();
        var homePhone = $("#homePhone").val();
        var faxPhone = $("#faxPhone").val();
        var contactAddress = $("#contactAddress").val();
        var postCode = $("#postCode").val();
        var email = $("#email").val();
        var aeCode = $("#aeCode").val();
        var url = "${webRoot}/companyBusinessPersonnel/update";
        $.ajax({
            url: url,   //处理页面的名称
            data: {
                id: id,
                personnelName: personnelName,
                personnelRole: personnelRole,
                sex: sex,
                educationType: educationType,
                personnelStatus: personnelStatus,
                birthdayDate: birthdayDate,
                idType: idType,
                idNo: idNo,
                jobPosition: jobPosition,
                sacNo: sacNo,
                witnessNo: witnessNo,
                officePhone: officePhone,
                mobilePhone: mobilePhone,
                homePhone: homePhone,
                faxPhone: faxPhone,
                contactAddress: contactAddress,
                postCode: postCode,
                email: email,
                aeCode: aeCode
            },  //为值取个名字
            type: "POST",  //传值方式
            dataType: "text",  //数据类型
            success: function (d) {
                if (d.trim() == "ok") {
                    layer.confirm('保存成功！', {
                        btn: ['是'], btn1: function () {
                            location.reload();
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
    }

    layui.laydate.render({
        elem: '#birthdayDate' //指定元素
    });

    $("#refresh").click(function () {
        location.reload();
    })

    $("#closeLayer").click(function () {
        closeLayer();
    })

    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }

    end: function close() {
        window.parent.location.reload();
    }

    function isCardID(sId) {
        var iSum = 0;
        sId = sId.replace(/x$/i, "a");
        for (var i = 17; i >= 0; i--) iSum += (Math.pow(2, i) % 11) * parseInt(sId.charAt(17 - i), 11);
        if (!/^\d{17}(\d|x)$/i.test(sId)) {
            alert("你输入的身份证长度或格式错误");
            return false;
        } else if (iSum % 11 != 1) {
            alert("你输入的身份证号非法");
            return false;
        } else
            return true;
    }

    function checkMobile(mobilePhone) {
        if (!(/^[1][3,4,5,7,8][0-9]{9}$/.test(mobilePhone))) {
            alert("不是完整的11位手机号!");
            return false;
        } else {
            return true;
        }
    }


    function CheckMail(mail) {
        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (!filter.test(mail)) {
            alert('您的电子邮件格式不正确');
            return false;
        } else {
            return true;
        }
    }
    layui.form.render('select');
</script>
</body>
</html>
