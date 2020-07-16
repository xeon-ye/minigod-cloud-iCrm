<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>

<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer-jquery.min.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/ajaxupload.js"></script>
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
</head>
<style>
    #investTarget {
        display: inline
    }
</style>
<body>

<%-- 预约信息 Start --%>
<div id="div1" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">预约信息</b></div>
        </br>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">预约号</label>
                <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="applicationId" name="applicationId" type="text" class="form-control"
                               value="${customerAccountOpenInfoEntity.applicationId}" readonly/>
                    </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">申请时间</label>
                <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="applicationTime" name="applicationTime" type="text" class="form-control"
                               value="<fmt:formatDate value="${customerAccountOpenInfoEntity.applicationTime}" pattern="yyyy-MM-dd HH:mm"/>"
                               readonly/>
                    </span>
                </div>
            </div>
        </div>
        <%--        <div class="row">--%>
        <%--            <div class="form-group col-sm-6 col-md-6">--%>
        <%--                <label class="col-sm-2 control-label no-padding-right">开户途径</label>--%>
        <%--                <div class="col-xs-9">--%>
        <%--                    <span class="col-sm-12 block input-icon input-icon-right">--%>
        <%--                        <tag:select nameKey="AO_OPEN_ACCOUNT_ACCESS_WAY"--%>
        <%--                                    id="openAccountAccessWay" isAddDefaltOption="true"--%>
        <%--                                    initSelectedKey="${customerAccountOpenInfoEntity.openAccountAccessWay}"--%>
        <%--                                    clazz="form-control" disabled="false"/>--%>
        <%--                    </span>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--            <div class="form-group col-sm-6 col-md-6">--%>
        <%--                <label class="col-sm-3 control-label no-padding-right">渠道</label>--%>
        <%--                <div class="col-xs-9">--%>
        <%--                           <span class="col-sm-12 block input-icon input-icon-right">--%>
        <%--                           <input id="sourceChannelName" name="sourceChannelName" type="text" class="form-control"--%>
        <%--                                  value="${customerAccountOpenInfoEntity.sourceChannelId}" readonly/>--%>
        <%--                            </span>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">HashNo</label>
                <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="caSignHashCode" name="caSignHashCode" type="text" class="form-control"
                               value="${customerAccountOpenInfoEntity.caSignHashCode}" readonly/>
                    </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">客户帐号</label>
                <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="clientId" name="clientId" type="text" class="form-control"
                               value="${customerAccountOpenInfoEntity.clientId}" readonly/>
                    </span>
                </div>
            </div>
            <c:if test="${accountOpenApplicationEntity.applicationStatus == 6 || accountOpenApplicationEntity.applicationStatus == 4}">
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">电子证书序列号</label>
                        <div class="col-xs-9">
                                <span class="col-sm-12 block input-icon input-icon-right">
                                    <input id="caCertSn" name="caCertSn" type="text" class="form-control"
                                           value="${caCertSn}" readonly/>
                                </span>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
<%--预约信息End--%>

<%--基本信息(CA认证开户 + 大陆身份证)-Start--%>
<c:if test="${customerAccountOpenInfoEntity.idKind == 1 && customerAccountOpenInfoEntity.bankType == 1}">
    <div id="div0" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
            </br>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">账户类型</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                             <input name="fundAccountType" type="radio" value="1" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==1}">checked</c:if> /> 现金账户
                             <input name="fundAccountType" type="radio" value="2" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==2}">checked</c:if> /> 融资账户
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">证件类型</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <tag:select nameKey="AO_ID_KIND" id="idKind" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.idKind}"
                                       clazz="form-control" disabled="false"/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">国家/地区</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="nationality" type="text" class="form-control"
                                   value="${fns:getCodeName("AO_NATIONALITY",customerAccountOpenInfoEntity.nationality)}"
                                   readonly/>
                        </span>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">中文姓名</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="clientName" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.clientName}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">性别</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <tag:select nameKey="COMMON_SEX" id="sex" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                       clazz="form-control" disabled="false"/>
                        </span>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">英文名/姓名拼音</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="clientNameSpell" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.clientNameSpell}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">民族</label>
                    <div class="col-xs-9">
                        <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="nation" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.nation}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">证件号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idNo" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idNo}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">出生日期</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="birthday" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.birthday}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">签发机关</label>
                    <div class="col-xs-9">
                        <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="signingOrganization" type="text"
                                   class="form-control"
                                   value="${customerAccountOpenInfoEntity.signingOrganization}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">证件有效期至</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idCardValidDateEnd" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idCardValidDateEnd}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">证件地址</label>
                    <div class="col-sm-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                            <input name="idCardAddress" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idCardAddress}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">手机号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="phoneNumber" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.phoneNumber}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">电子邮箱</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                         <input name="email" type="text" class="form-control"
                                value="${customerAccountOpenInfoEntity.email}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">住宅地址</label>
                    <div class="col-xs-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                           <input name="homeAddress" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.familyAddress}" readonly/>
                            </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址</label>
                    <div class="col-sm-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                            <input name="contactDetailAddress" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.contactAddress}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址拆分</label>
                    <div class="col-xs-11">
                             <span class="col-sm-12 block input-icon input-icon-right">
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.contactProvinceName}" readonly/>
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.contactCityName}" readonly/>
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.contactCountyName}" readonly/>
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 54%;display: inline;"
                                       value="${customerAccountOpenInfoEntity.contactDetailAddress}" readonly/>
                                </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
<%--基本信息(CA认证开户 + 大陆身份证)-End--%>

<%--基本信息(香港银行卡认证开户 + 大陆身份证)-Start--%>
<c:if test="${customerAccountOpenInfoEntity.idKind == 1 && customerAccountOpenInfoEntity.bankType == 0}">
    <div id="div0" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
            </br>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">账户类型</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                             <input name="fundAccountType" type="radio" value="1" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==1}">checked</c:if> /> 现金账户
                             <input name="fundAccountType" type="radio" value="2" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==2}">checked</c:if> /> 融资账户
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">证件类型</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <tag:select nameKey="AO_ID_KIND" id="idKind" isAddDefaltOption="true"
                                        initSelectedKey="${customerAccountOpenInfoEntity.idKind}"
                                        clazz="form-control" disabled="false"/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">国家/地区</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="nationality" type="text" class="form-control"
                                   value="${fns:getCodeName("AO_NATIONALITY",customerAccountOpenInfoEntity.nationality)}"
                                   readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">中文姓名</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="clientName" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.clientName}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">性别</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <tag:select nameKey="COMMON_SEX" id="sex" isAddDefaltOption="true"
                                        initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                        clazz="form-control" disabled="false"/>
                        </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">英文/拼音姓名</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="clientNameSpell" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.clientNameSpell}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">出生日期</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="birthday" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.birthday}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">证件号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idNo" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idNo}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">证件有效期至</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idCardValidDateEnd" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idCardValidDateEnd}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">证件地址</label>
                    <div class="col-sm-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                            <input name="idCardAddress" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idCardAddress}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">手机号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="phoneNumber" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.phoneNumber}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">电子邮箱</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                         <input name="email" type="text" class="form-control"
                                value="${customerAccountOpenInfoEntity.email}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">住宅地址</label>
                    <div class="col-xs-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                           <input name="homeAddress" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.familyAddress}" readonly/>
                       </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址</label>
                    <div class="col-sm-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                            <input name="contactDetailAddress" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.contactAddress}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址拆分</label>
                    <div class="col-xs-11">
                        <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 15%;display: inline"
                                   value="${customerAccountOpenInfoEntity.contactProvinceName}" readonly/>
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 15%;display: inline"
                                   value="${customerAccountOpenInfoEntity.contactCityName}" readonly/>
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 15%;display: inline"
                                   value="${customerAccountOpenInfoEntity.contactCountyName}" readonly/>
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 54%;display: inline;"
                                   value="${customerAccountOpenInfoEntity.contactDetailAddress}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
<%--基本信息(香港银行卡认证开户 + 大陆身份证)-End--%>

<%--基本信息(香港银行卡认证开户 + 香港身份证)-Start--%>
<c:if test="${customerAccountOpenInfoEntity.idKind == 2 && customerAccountOpenInfoEntity.bankType == 0}">
    <div id="div0" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
            </br>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">账户类型</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                             <input name="fundAccountType" type="radio" value="1" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==1}">checked</c:if> /> 现金账户
                             <input name="fundAccountType" type="radio" value="2" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==2}">checked</c:if> /> 融资账户
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">证件类型</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <tag:select nameKey="AO_ID_KIND" id="idKind" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.idKind}"
                                       clazz="form-control" disabled="false"/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">国家/地区</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="nationality" type="text" class="form-control"
                                  value="${fns:getCodeName("AO_NATIONALITY",customerAccountOpenInfoEntity.nationality)}"
                                  readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">中文名</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="clientName" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.clientName}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">性别</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <tag:select nameKey="COMMON_SEX" id="sex" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                       clazz="form-control" disabled="false"/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">英文/拼音姓名</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="clientNameSpell" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.clientNameSpell}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">出生日期</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="birthday" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.birthday}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">证件号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idNo" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idNo}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">证件有效期至</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idCardValidDateEnd" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idCardValidDateEnd}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">证件地址</label>
                    <div class="col-sm-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                           <input name="idCardAddress" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.idCardAddress}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">手机号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="phoneNumber" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.phoneNumber}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">电子邮箱</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="email" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.email}" readonly/>
                       </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">住宅地址</label>
                    <div class="col-xs-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                           <input name="homeAddress" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.familyAddress}" readonly/>
                            </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址</label>
                    <div class="col-sm-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                           <input name="contactDetailAddress" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.contactAddress}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址拆分</label>
                    <div class="col-xs-11">
                        <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 15%;display: inline"
                                   value="${customerAccountOpenInfoEntity.contactProvinceName}" readonly/>
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 15%;display: inline"
                                   value="${customerAccountOpenInfoEntity.contactCityName}" readonly/>
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 15%;display: inline"
                                   value="${customerAccountOpenInfoEntity.contactCountyName}" readonly/>
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 54%;display: inline;"
                                   value="${customerAccountOpenInfoEntity.contactDetailAddress}" readonly/>
                        </span>
                    </div>
                </div>
            </div>

        </div>
    </div>
</c:if>
<%--基本信息(香港银行卡认证开户 + 香港身份证)-End--%>

<%--基本信息(香港银行卡认证开户 + 护照)-Start--%>
<c:if test="${customerAccountOpenInfoEntity.idKind == 3 && customerAccountOpenInfoEntity.bankType == 0}">
    <div id="div0" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
            </br>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">账户类型</label>
                    <div class="col-xs-9">
                        <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="fundAccountType" type="radio" value="1" disabled="disabled"
                                   <c:if test="${customerAccountOpenInfoEntity.fundAccountType==1}">checked</c:if> /> 现金账户
                            <input name="fundAccountType" type="radio" value="2" disabled="disabled"
                                   <c:if test="${customerAccountOpenInfoEntity.fundAccountType==2}">checked</c:if> /> 融资账户
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">证件类型</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <tag:select nameKey="AO_ID_KIND" id="idKind" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.idKind}"
                                       clazz="form-control" disabled="false"/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">国家/地区</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="nationality" type="text" class="form-control"
                                  value="${fns:getCodeName("AO_NATIONALITY",customerAccountOpenInfoEntity.nationality)}"
                                  readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">中文姓名</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="clientName" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.clientName}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">性别</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <tag:select nameKey="COMMON_SEX" id="sex" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                       clazz="form-control" disabled="false"/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">英文/拼音姓名</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="clientNameSpell" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.clientNameSpell}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">出生日期</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="birthday" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.birthday}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">证件号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idNo" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idNo}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">证件有效期至</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="idCardValidDateEnd" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.idCardValidDateEnd}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">证件地址</label>
                    <div class="col-sm-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                           <input name="idCardAddress" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.idCardAddress}" readonly/>
                       </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">手机号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="phoneNumber" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.phoneNumber}" readonly/>
                        </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">电子邮箱</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="email" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.email}" readonly/>
                       </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">住宅地址</label>
                    <div class="col-xs-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                           <input name="homeAddress" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.familyAddress}" readonly/>
                       </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址</label>
                    <div class="col-sm-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                           <input name="contactDetailAddress" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.contactAddress}" readonly/>
                       </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址拆分</label>
                    <div class="col-xs-11">
                        <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 15%;display: inline"
                                   value="${customerAccountOpenInfoEntity.contactProvinceName}" readonly/>
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 15%;display: inline"
                                   value="${customerAccountOpenInfoEntity.contactCityName}" readonly/>
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 15%;display: inline"
                                   value="${customerAccountOpenInfoEntity.contactCountyName}" readonly/>
                            <input name="contactDetailAddress" type="text"
                                   class="form-control" style="width: 54%;display: inline;"
                                   value="${customerAccountOpenInfoEntity.contactDetailAddress}" readonly/>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
<%--基本信息(香港银行卡认证开户 + 护照)-End--%>

<!--隐藏图片-->
<div hidden id="imageList">
    <ul class="docs-pictures">
    </ul>
</div>
<div id="div1" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">影像资料</b></div>
        </br>
        <div style="margin-left: 5%;width: 90%; font-size: 0; height: 140px; vertical-align: middle;">
            </br>
            <div style="margin-left: 50px;width: 90%">
                <c:forEach var="imageInfo" items="${customerAccountOpenImages}" varStatus="i">
                        <span class="col-xs-2 block input-icon input-icon-right" style="margin-top: 15px">
                            <button class="layui-btn layui-btn-small layui-btn-warm" type="button"
                                    onclick="showAccountOpenImg(${i.index})"
                                    class="layui-icon"><i
                                    class="layui-icon">&#xe60d;</i>[${imageInfo.fileName}]</button>
                         </span>
                    <!--循环调用方法-->
                    <script type="text/javascript">pictureList("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}", ${i.index});</script>
                </c:forEach>
            </div>
            </br>
        </div>
    </div>
</div>
<c:if test="${customerAccountOpenInfoEntity.bankType !=null and customerAccountOpenInfoEntity.bankType == 0}">
    <div id="div1" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">香港银行账户资料</b></div>
            </br>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">银行名称</label>
                    <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <tag:select name="bankId" nameKey="AO_BANK_HK" isAddDefaltOption="true"
                                    initSelectedKey="${customerAccountOpenInfoEntity.bankId}" clazz="form-control"
                                    disabled="disabled"></tag:select>
                    </span>
                    </div>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">银行卡号</label>
                    <div class="col-xs-9">
                    <span class="col-xs-12 block input-icon input-icon-right">
                        <input class="form-control" name="bankNo" type="text"
                               value="${customerAccountOpenInfoEntity.bankNo}"
                               style="height:34px; margin-right: 0px;"
                               readonly/>
                    </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">银行账户名</label>
                    <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                         <input name="clientNameSpell" type="text" class="form-control"
                                value="${customerAccountOpenInfoEntity.bankAccountName}" readonly/>
                    </span>
                    </div>
                </div>
                    <%--                <div class="form-group col-sm-6 col-md-6">--%>
                    <%--                    <label class="col-sm-3 control-label no-padding-right">账户类型</label>--%>
                    <%--                    <div class="col-xs-9">--%>
                    <%--                    <span class="col-xs-12 block input-icon input-icon-right">--%>
                    <%--                        <tag:select name="bankId" nameKey="AO_BANK_HK" isAddDefaltOption="true"--%>
                    <%--                                    initSelectedKey="${customerAccountOpenInfoEntity.bankId}" clazz="form-control"--%>
                    <%--                                    disabled="disabled"></tag:select>--%>
                    <%--                    </span>--%>
                    <%--                    </div>--%>
                    <%--                </div>--%>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${customerAccountOpenInfoEntity.bankType !=null and customerAccountOpenInfoEntity.bankType == 1}">
    <div id="div2" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">大陸银行账户四要素校验信息</b></div>
            </br>
            <div class="row">
                <c:forEach items="${bankVerityInfoList}" var="bankVerityInfo">
                    <div class="form-group col-sm-12 col-md-12">
                        <div class="layui-inline">
                            <label class="col-sm-1 control-label" style="width: 120px;text-align:left;">用户姓名: </label>
                            <span class="col-sm-1 control-label layui-inline"
                                  style="width: 200px;text-align:left; ">${bankVerityInfo.clientName}</span>
                        </div>
                        <div class="layui-inline">
                            <label class="col-sm-1 control-label " style="width: 120px;text-align:left; ">证件号: </label>
                            <span class="col-sm-1 control-label layui-inline"
                                  style="width: 200px;text-align:left;">${bankVerityInfo.idNo}</span>
                        </div>
                        <div class="layui-inline">
                            <label class="col-sm-1 control-label " style="width: 120px;text-align:left;">银行卡号:</label>
                            <span class="col-sm-1 control-label layui-inline"
                                  style="width: 200px;text-align:left;">${bankVerityInfo.bankCard}</span>
                        </div>
                        <div class="layui-inline">
                            <label class="col-sm-1 control-label "
                                   style="width: 120px;text-align:left;">预留手机号:</label>
                            <span class="col-sm-1 control-label layui-inline"
                                  style="width: 200px;text-align:left;">${bankVerityInfo.phoneNumber}</span>
                        </div>
                        <div class="layui-inline">
                            <label class="col-sm-1 control-label " style="width: 120px;text-align:left;">校验时间:</label>
                            <span class="col-sm-1 control-label layui-inline"
                                  style="width: 200px;text-align:left;"><fmt:formatDate
                                    value="${bankVerityInfo.verityTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                        </div>
                        <div class="layui-inline">
                            <label class="col-sm-1 control-label" style="width: 120px;text-align:left;">校验方:</label>
                            <span class="col-sm-1 control-label layui-inline"
                                  style="width: 200px;text-align:left;">CFCA</span>
                        </div>
                        <div class="layui-inline">
                            <label class="col-sm-1 control-label" style="width: 120px;text-align:left;">校验次数:</label>
                            <span class="col-sm-1 control-label layui-inline"
                                  style="width: 200px;text-align:left;">${bankVerityInfo.verifyCount}</span>
                        </div>
                        <div class="layui-inline">
                            <label class="col-sm-1 control-label" style="width: 120px;text-align:left;">校验结果: </label>
                            <span class="col-sm-1 control-label layui-inline"
                                  style="width: 200px;text-align:left;">
                            <c:if test="${bankVerityInfo.verifyStatus==0}">不通过</c:if>
                            <c:if test="${bankVerityInfo.verifyStatus==1}">通过</c:if>
                        </span>
                        </div>
                        <hr class="layui-bg-gray">
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</c:if>
<div id="div3" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">职业信息</b></div>
        </br>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">职业状态</label>
                <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <tag:select nameKey="AO_PROFESSION_CODE" id="professionCode" isAddDefaltOption="true"
                                    initSelectedKey="${customerAccountOpenInfoEntity.professionCode}"
                                    clazz="form-control"
                                    disabled="false"/>
                    </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">所属行业</label>
                <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <tag:select initSelectedKey="${customerAccountOpenInfoEntity.professionType}"
                                    nameKey="AO_OCCUPATION_TYPE"
                                    name="professionType" isAddDefaltOption="true" clazz="form-control "
                                    disabled="disabled"
                        ></tag:select>
                    </span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">公司名称</label>
                <div class="col-xs-9">
                   <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="companyName" name="companyName" type="text" class="form-control aaa"
                               value="${customerAccountOpenInfoEntity.companyName}" readonly/>
                    </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">职位级别</label>
                <div class="col-xs-9">
                   <span class="col-sm-12 block input-icon input-icon-right">
                    <tag:select nameKey="AO_JOB_POSITION" id="jobPosition"
                                initSelectedKey="${customerAccountOpenInfoEntity.jobPosition}"
                                clazz="form-control" isAddDefaltOption="true"
                                disabled="false"/>
                    </span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-12 col-md-12">
                <label class="col-sm-1 control-label no-padding-right">公司地址</label>
                <div class="col-xs-11">
                   <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="companyAddress" name="companyAddress" type="text" class="form-control"
                               value="${customerAccountOpenInfoEntity.companyAddress}" readonly/>
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="div4" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">投资概况</b></div>
        </br>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">年收入</label>
                <div class="col-xs-9">
                   <span class="col-sm-12 block input-icon input-icon-right">
                       <tag:select nameKey="AO_INCOME" id="income" isAddDefaltOption="true"
                                   initSelectedKey="${customerAccountOpenInfoEntity.annualIncome}"
                                   clazz="form-control" disabled="false"/>
                    </span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">资金来源</label>
                <div class="col-xs-9">
                    <span class="col-xs-12 block input-icon input-icon-right" style="width:1000px">
                        <tag:checkbox name="capitalSource" nameKey="AO_CAPITAL_SOURCE"
                                      initCheckKey="${customerAccountOpenInfoEntity.capitalSource}"
                                      disabled="disabled"></tag:checkbox>
                    </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">财产种类</label>
                <div class="col-xs-9">
                    <span class="col-xs-12 block input-icon input-icon-right" style="width:1000px">
                        <c:if test="${openAccountPropertyList!=null}">
                            <c:forEach items="${openAccountPropertyList}" var="openAccountPropertyType">
                                <span>
                                    <input style="display: inline;" name="propertyType" type="checkbox"
                                           value="${openAccountPropertyType.propertyType}"
                                           disabled="disabled"
                                           checked="true"/> ${fns:getCodeName("AO_PROPERTY_TYPE",openAccountPropertyType.propertyType)}
                                    <span style="width:10px;">&nbsp;&nbsp;&nbsp;</span>
                                    <tag:select nameKey="AO_PROPERTY_TYPE_${openAccountPropertyType.propertyType}"
                                                clazz="form-control" style="width:150px;display:inline"
                                                isAddDefaltOption="true"
                                                initSelectedKey="${openAccountPropertyType.propertyAmount}"
                                                disabled="disabled"></tag:select>
                                    <span style="width:10px;">&nbsp;&nbsp;&nbsp;</span>
                                    港币
                                </span>
                            </c:forEach>
                        </c:if>
                    </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">投资目标</label>
                <div class="col-xs-9">
                    <span class="col-xs-12 block input-icon input-icon-right" style="width:1000px">
                         <tag:checkbox name="investTarget" nameKey="AO_INVEST_TARGET"
                                       initCheckKey="${customerAccountOpenInfoEntity.investTarget}"
                                       disabled="disabled" style="display: inline"></tag:checkbox>
                            <input class="form-control " style="width: 200px;display: inline"
                                   id="investTargetOther"
                                   name="investTargetOther" type="text"
                                   value="${customerAccountOpenInfoEntity.investTargetOther}" readonly/>
                    </span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">投资经验</label>
                <div class="col-xs-9">
                    <span class="col-xs-12 block input-icon input-icon-right" style="width:700px">
                        <span>股票</span>
                        <tag:select nameKey="AO_STOCKS_INVESTMENT_EXPERIENCE_TYPE"
                                    id="stocksInvestmentExperienceType" isAddDefaltOption="true"
                                    initSelectedKey="${customerAccountOpenInfoEntity.stocksInvestmentExperienceType}"
                                    clazz="form-control " style="width:120px;display:inline"
                                    disabled="true"/>
                        <span style="margin-left:20px;">认股证/股票期权</span>
                        <tag:select nameKey="AO_WARRANTS_INVESTMENT_EXPERIENCE_TYPE"
                                    id="warrantsInvestmentExperienceType" isAddDefaltOption="true"
                                    initSelectedKey="${customerAccountOpenInfoEntity.warrantsInvestmentExperienceType}"
                                    clazz="form-control" style="width:120px;display:inline"
                                    disabled="true"/>

                        <span style="margin-left:20px;">期货/期权</span>
                        <tag:select nameKey="AO_FUTURES_INVESTMENT_EXPERIENCE_TYPE"
                                    id="futuresInvestmentExperienceType" isAddDefaltOption="true"
                                    initSelectedKey="${customerAccountOpenInfoEntity.futuresInvestmentExperienceType}"
                                    clazz="form-control" style="width:120px;display:inline"
                                    disabled="true"/>
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="div5" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">衍生产品认知评估</b></div>
        </br>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-12 control-label no-padding-right">您是否具有衍生品交易经验</label>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input type="radio" name="isKnowDerivativeProducts" disabled="disabled"
                           value="1" <c:if
                            test="${customerAccountOpenInfoEntity.isKnowDerivativeProducts==1}"> checked="checked"</c:if> />是
                    <input type="radio" name="isKnowDerivativeProducts" disabled="disabled"
                           value="0" <c:if
                            test="${customerAccountOpenInfoEntity.isKnowDerivativeProducts==0}"> checked="checked"</c:if> />否
                </span>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-12 control-label no-padding-right">请选择您接收衍生产品相关的培训或课程的方式</label>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <c:forEach var="investTargetCodeEntity"
                               items="${fns:getCodeInfoByParentMark('AO_DERIVATIVE_PRODUCTS_STUDY_TYPE')}"
                               varStatus="i">
                        <c:if test="${customerAccountOpenInfoEntity.derivativeProductsStudyType== investTargetCodeEntity.value}">
                            <input type="radio" name="derivativeProductsStudyType" disabled="disabled"
                                   value="${investTargetCodeEntity.value}" checked="checked"
                            />${investTargetCodeEntity.name}
                        </c:if>
                        <c:if test="${customerAccountOpenInfoEntity.derivativeProductsStudyType != investTargetCodeEntity.value}">
                            <input type="radio" name="derivativeProductsStudyType" disabled="disabled"
                                   value="${investTargetCodeEntity.value}"
                            />${investTargetCodeEntity.name}
                        </c:if>
                    </c:forEach>
                    <c:if test="${customerAccountOpenInfoEntity.derivativeProductsStudyType == 7}"> <%--其他的值 --%>
                        <input class="form-control" style="width:200px;display: inline"
                               id="derivativeProductsStudyTypeOther" name="derivativeProductsStudyTypeOther"
                               type="text" readonly
                               value="${customerAccountOpenInfoEntity.derivativeProductsStudyTypeOther}"
                        />
                    </c:if>
                </span>
                <c:if test="${proofImage_601!=null && customerAccountOpenInfoEntity.derivativeProductsStudyType!=null && customerAccountOpenInfoEntity.derivativeProductsStudyType!=''}">
                    <span class="col-xs-2 block input-icon input-icon-right">
                        <button class="layui-btn layui-btn-mini layui-btn-warm" type="button"
                                onclick="openPhoto('${proofImage_601.storagePath}${proofImage_601.fileStorageName}.${proofImage_601.extName}');">凭证</button>
                    </span>
                </c:if>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-12 control-label no-padding-right">您在经纪公司或银行，基金或资产管理公司，监管机构或交易所等金融机构拥有以下工作经验</label>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <c:forEach var="investTargetCodeEntity"
                               items="${fns:getCodeInfoByParentMark('AO_FINANCING_INSTITUTION_WORK_EXPERIENCE_TYPE')}"
                               varStatus="i">
                        <c:if test="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType== investTargetCodeEntity.value}">
                            <input type="radio" name="financingInstitutionWorkExperienceType"
                                   value="${investTargetCodeEntity.value}" checked="true" disabled="disabled"
                            />${investTargetCodeEntity.name}
                        </c:if>
                        <c:if test="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType != investTargetCodeEntity.value}">
                            <input type="radio" name="financingInstitutionWorkExperienceType"
                                   value="${investTargetCodeEntity.value}" disabled="disabled"
                            />${investTargetCodeEntity.name}
                        </c:if>
                    </c:forEach>
                    <c:if test="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType == 4}"> <%--其他的值 --%>
                        <input class="form-control" style="width:100px;display: inline"
                               id="financingInstitutionWorkExperienceTypeOther" readonly
                               name="financingInstitutionWorkExperienceTypeOther" type="text"
                               value="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceTypeOther}"
                               style="width:200px; margin-left:25px; height:34px;"/>
                    </c:if>
                </span>
                <c:if test="${proofImage_602!=null&& customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType!=null && customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType!=''}">
                    <span class="col-xs-2 block input-icon input-icon-right">
                        <button class="layui-btn layui-btn-mini layui-btn-warm" type="button"
                                onclick="openPhoto('${proofImage_602.storagePath}${proofImage_602.fileStorageName}.${proofImage_602.extName}');">凭证</button>
                    </span>
                </c:if>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-12 control-label no-padding-right">您在过去三年是否曾进行过至少五次任何衍生产品的交易（不论是否在交易所买卖）</label>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input type="radio" name="isTradedDerivativeProducts"
                           value="1" disabled="disabled"
                           <c:if test="${customerAccountOpenInfoEntity.isTradedDerivativeProducts == 1}">checked="true"</c:if>
                    />是
                    <input type="radio" name="isTradedDerivativeProducts"
                           value="${investTargetCodeEntity.isTradedDerivativeProducts}" disabled="disabled"
                           <c:if test="${customerAccountOpenInfoEntity.isTradedDerivativeProducts == 0}">checked="true"</c:if>
                    />否
                </span>
                <c:if test="${proofImage_603!=null && customerAccountOpenInfoEntity.isTradedDerivativeProducts == 1}">
                    <span class="col-xs-2 block input-icon input-icon-right">
                        <button class="layui-btn layui-btn-mini layui-btn-warm" type="button"
                                onclick="openPhoto('${proofImage_603.storagePath}${proofImage_603.fileStorageName}.${proofImage_603.extName}');">凭证</button>
                    </span>
                </c:if>
            </div>
        </div>
    </div>
</div>
<div id="div6" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">隐私和税务</b></div>
        </br>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-12 control-label no-padding-right">您是否确认个人资料（私隐）条例通知并同意xx证券公司及其控股集团使用及向其他人士提供本人的个人资料作直接促销用途。</label>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <span class="col-xs-12 block input-icon input-icon-right">
                    <input type="radio" name="isAllowProvidePrivacy"
                           value="1" disabled="disabled"
                           <c:if test="${customerAccountOpenInfoEntity.isAllowProvidePrivacy == 1}">checked="checked"</c:if>
                    />是
                    <input type="radio" name="isAllowProvidePrivacy" disabled="disabled"
                           <c:if test="${customerAccountOpenInfoEntity.isAllowProvidePrivacy == 0}">checked="checked"</c:if>
                           value="0"
                    />否
                </span>
            </div>
        </div>
        <div>
            <form id="taxInfoForm">
                <div class="row">
                    <div class="form-group col-xs-12 col-xs-12">
                        <table class="form-group col-xs-12 col-xs-12">
                            <tr align="center">
                                <td class="col-sm-2">司法管辖区</td>
                                <td class="col-sm-2">税务编号</td>
                                <td class="col-sm-2">如没有提供税务编号，请选择理由</td>
                                <td class="col-sm-2"> 如选择理由B，请解释原因</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <c:if test="${taxInformationList!=null}">
                    <c:forEach begin="0" end="4" step="1" var="i">
                        <c:if test="${taxInformationList[i]!=null}">
                            <div class="row">
                                <div class="form-group col-sm-2 col-md-3">
                                    <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" name="taxCountry[]"
                                               value="${taxInformationList[i].taxCountry}" readonly
                                               class="form-control">
                                    </span>
                                    </div>
                                </div>
                                <div class="form-group col-sm-2 col-md-3">
                                    <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" name="taxNumber[]"
                                               value="${taxInformationList[i].taxNumber}" readonly
                                               class="form-control">
                                    </span>
                                    </div>
                                </div>
                                <div class="form-group col-sm-2 col-md-3">
                                    <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <select name="reasonType[]" class="form-control" disabled="disabled">
                                            <option value="">--- 请下拉选择 ---</option>
                                            <option value="A"
                                                    <c:if test="${taxInformationList[i].reasonType=='A'}">selected</c:if> >理由 A – 帐户持有人的居留司法管辖区并没有向其居民发出税务编号。</option>
                                            <option value="B"
                                                    <c:if test="${taxInformationList[i].reasonType=='B'}">selected</c:if> >理由 B – 帐户持有人不能取得税务编号。如选取这一理由，解释帐户持有人不能取得税务编号的原因。</option>
                                            <option value="C"
                                                    <c:if test="${taxInformationList[i].reasonType=='C'}">selected</c:if> >理由 C – 帐户持有人毋须提供税务编号。居留司法管辖区的主管机关不需要帐户持有人披露税务编号。</option>
                                        </select>
                                    </span>
                                    </div>
                                </div>
                                <div class="form-group col-sm-2 col-md-3">
                                    <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" name="reasonDesc[]"
                                               value="${taxInformationList[i].reasonDesc}" readonly
                                               class="form-control">
                                    </span>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </c:if>
            </form>
        </div>
    </div>
</div>


<div id="div7" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">身份资料披露</b></div>
        </br>
        <c:forEach items="${openAccountOtherDisclosureList}" var="openAccountOther" varStatus="i">
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-12 control-label no-padding-right">${fns:getCodeName("AO_DISCLOSURE_CODE",openAccountOther.disclosureCode)}</label>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <c:if test="${openAccountOther.disclosureIsTrue== 1}">
                            <input type="radio"
                                   name="disclosureCode_${openAccountOther.disclosureCode }"
                                   value="${openAccountOther.disclosureIsTrue}" checked="true"
                                   disabled="disabled"/>是
                            <input type="radio"
                                   name="disclosureCode_${openAccountOther.disclosureCode }"
                                   value="${openAccountOther.disclosureIsTrue}"
                                   disabled="disabled"/>否
                        </c:if>
                        <c:if test="${openAccountOther.disclosureIsTrue == 0}">
                            <input type="radio"
                                   name="disclosureCode_${openAccountOther.disclosureCode }"
                                   value="${openAccountOther.disclosureIsTrue}"
                                   disabled="disabled"/>是
                            <input type="radio"
                                   name="disclosureCode_${openAccountOther.disclosureCode }"
                                   value="${openAccountOther.disclosureIsTrue}" checked="true"
                                   disabled="disabled"/>否
                        </c:if>
                    </span>
                </div>
                <div class="form-group col-sm-12 col-md-12">
                    <span class="col-sm-12 block input-icon input-icon-right">
                         <%-- 受益人，亲属关系，注册人否的值 --%>
                         <c:if test="${(openAccountOther.disclosureCode == 1 || openAccountOther.disclosureCode == 2 ||openAccountOther.disclosureCode == 3)}">
                             <c:if test="${openAccountOther.disclosureIsTrue ==0 and openAccountOther.disclosureNameJoinDetail!=null}">
                                 <input class="form-control" style="display: inline"
                                        id="disclosureCode" name="disclosureCode" type="text"
                                        value="${openAccountOther.disclosureNameJoinDetail}"
                                        style="width:600px; margin-left:25px; height:34px;"
                                        readonly/>
                             </c:if>
                         </c:if>
                    </span>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<c:if test="${proofFileList!=null or addFileList!=null}">
    <div id="updateFileProof" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">资料修改凭证</b></div>
            </br>
            <c:if test="${(proofFileList == null || proofFileList.size()== 0) && (addFileList == null || addFileList.size() == 0)}">
                <div class="row">
                    <div class="form-group col-sm-12 col-md-12" style="height: 80px">
                        <label class="col-sm-2 control-label no-padding-right">暂无修改</label>
                    </div>
                </div>
            </c:if>
            <c:if test="${proofFileList!=null}">
                <div class="row">
                    <div class="form-group col-sm-12 col-md-12" style="height: 80px">
                        <label class="col-sm-2 control-label no-padding-right">资料修改凭证</label>
                        <div class="col-sm-12">
                            <span class="col-sm-12 block">

                                <c:forEach items="${proofFileList}" var="proofFile" varStatus="i">
                                    <a class="layui-btn layui-btn-normal layui-btn-mini"
                                       style="width: 80px;display: inline"
                                       href='${webRoot}/common/downloadFile?fullFilePath=${proofFile.filePath}${proofFile.fileStorageName}.${proofFile.fileExtName}'>【资料修改凭证(${i.index+1})】</a>
                                </c:forEach>
                            </span>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:forEach items="${addFileList}" var="addFile" varStatus="i">
                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-2 control-label no-padding-right">资料修改意见(${i.index+1})</label>
                        <div class="col-xs-9">
                            <span class="col-sm-10 block">
                                <input type="text" class="form-control" value="${addFile.remark}" readonly>
                            </span>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</c:if>

<input id="amlFlag" style="display: none" type="text" value="${amlFileList[0]==null}">
<div id="div8" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">补充资料</b></div>
        </br>
        <input hidden id="supFlag" value="0">
        <div class="row">
            <div class="form-group col-sm-12 col-md-12">
                <label class="col-sm-2 control-label no-padding-right">视频/音频/图片</label>
                <div class="col-sm-12">
                        <span class="col-sm-12 block input-icon input-icon-right">
                            <c:if test="${openAccountAdditionalFileList!=null}">
                                <c:forEach items="${openAccountAdditionalFileList}" var="additionFile">
                                    <button class="layui-btn layui-btn-small layui-btn-warm" style="width: 80px"
                                            type="button"
                                            onclick="downloadAccountOpenReport('${additionFile.filePath}${additionFile.fileStorageName}.${additionFile.fileExtName}')">${additionFile.fileName}</button>
                                </c:forEach>
                            </c:if>
                        </span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-12 col-md-12">
                <label class="col-sm-2 control-label no-padding-right">证明原因</label>
                <div class="col-xs-9">
                        <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="remark" type="text" class="form-control" readonly
                                    <c:if test="${openAccountAdditionalFileList[0]!=null}">
                                        value="${openAccountAdditionalFileList[0].remark}"
                                    </c:if> />
                        </span>
                    <%--<div>--%>
                    <%--<button id="supButton${i}"--%>
                    <%--onclick="addSupInformation('${customerAccountOpenInfoEntity.applicationId}','${openAccountAdditionalFileList[i][0]==null?null:openAccountAdditionalFileList[i][0].additionalId}');"--%>
                    <%--class="layui-btn layui-btn-normal layui-btn-small" style="display: none;"--%>
                    <%--type="button">编辑--%>
                    <%--</button>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>
        <c:if test="${flag==1}">
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-4 control-label no-padding-right">
                        该申请人有无AML可疑信息？</label>
                    <span class="col-sm-4 control-label no-padding-right">

                        <input type="radio" value="${investTargetCodeEntity.value}" disabled="disabled"
                               <c:if test="${customerAccountOpenInfoEntity.isAmlSuspicious == 1}">checked="true"</c:if>
                        />有可疑
                        <input type="radio" value="${investTargetCodeEntity.value}" disabled="disabled"
                                <c:if test="${customerAccountOpenInfoEntity.isAmlSuspicious == 0}">
                                    checked="checked"
                                </c:if>
                        />无可疑


                </span>
                </div>
                <c:if test="${isCustomer==0}">
                    <div class="form-group col-sm-6 col-md-6" align="left">
                        <label class="col-sm-4 control-label no-padding-right"> AML检查结果文件</label>
                        <span class="col-sm-8 block">
                            <c:if test="${amlFileList!=null}">
                                <c:forEach begin="0" end="2" step="1" var="i">
                                    <c:if test="${amlFileList[i]!=null}">
                                        <a class="layui-btn layui-btn-normal layui-btn-mini"
                                           onclick=showFileOnline('${amlFileList[i].filePath}${amlFileList[i].fileStorageName}.${amlFileList[i].fileExtName}','${amlFileList[i].fileExtName}')>【AML文件(${i+1})】</a>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </span>
                    </div>
                </c:if>
            </div>
            <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-4 control-label no-padding-right">
                            客户风险等级</label>
                        <span class="col-sm-8 control-label no-padding-right">
                                    <input type="radio" name="acceptRisk" value="1" disabled="disabled"
                                           <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 1}">checked="checked"</c:if>
                                    />高风险
                                <input type="radio" name="acceptRisk" value="2" disabled="disabled"
                                       <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 2}">checked="checked"</c:if> />中风险
                                    <input type="radio" name="acceptRisk" value="3" disabled="disabled"
                                           <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 3}">checked="checked"</c:if> />低风险
                                </span>
                    </div>
            </div>
        </c:if>
    </div>
</div>

<c:if test="${flag==2}">
    <div v-cloak>
        <c:if test="${accountOpenApplicationEntity.applicationStatus==1 || accountOpenApplicationEntity.applicationStatus==2 || accountOpenApplicationEntity.applicationStatus==3}">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">审批操作</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-4 control-label no-padding-right" style="margin-left: 10px">
                            该申请人有无AML可疑信息？</label>
                        <span class="col-sm-4 control-label no-padding-right">
                            <input type="radio" name="isAmlSuspicious" value="1" onclick="editAmlInfo();"
                                   <c:if test="${customerAccountOpenInfoEntity.isAmlSuspicious == 1}">checked="checked"</c:if>
                            />有可疑
                                <input type="radio" name="isAmlSuspicious" value="0" onclick="editAmlInfo();"
                                       <c:if test="${customerAccountOpenInfoEntity.isAmlSuspicious == 0}">checked="checked"</c:if> />无可疑
                        </span>
                    </div>
                    <div id="amlDiv" class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-4 control-label no-padding-right"> AML检查结果文件</label>
                        <span class="col-xs-8 block control-label no-padding-right">
                                    <c:if test="${amlFileList!=null}">
                                        <c:forEach begin="0" end="2" step="1" var="i">
                                            <c:if test="${amlFileList[i]!=null}">
                                                <div class="layui-btn-group">
                                               <a class="layui-btn layui-btn-normal layui-btn-mini"
                                                  onclick=showFileOnline('${amlFileList[i].filePath}${amlFileList[i].fileStorageName}.${amlFileList[i].fileExtName}','${amlFileList[i].fileExtName}')>【AML文件(${i+1})】</a>
                                                <c:if test="${accountOpenApplicationEntity.applicationStatus!=3}">
                                                <button type="button"
                                                        class="layui-btn layui-btn-primary layui-btn-mini"
                                                        onclick="delAmlInfo(${amlFileList[i].id});">
                                                    <i class="layui-icon">&#xe640;</i>
                                                </button></c:if>
                                                </div>
                                            </c:if>
                                            <c:if test="${amlFileList[i]==null && accountOpenApplicationEntity.applicationStatus!=3}">
                                                <button name="upLoadAml" style="width: 100px;display: inline"
                                                        class="layui-btn layui-btn-primary layui-btn-mini">上传[AML文件]</button>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </span>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-4 control-label no-padding-right" style="margin-left: 10px">
                            客户风险等级</label>
                                <span class="col-xs-8 block input-icon input-icon-right">
                                    <input type="radio" name="acceptRisk" value="1" onclick="editAmlRisk();"
                                           <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 1}">checked="checked"</c:if>/>高风险
                                    <input type="radio" name="acceptRisk" value="2" onclick="editAmlRisk();"
                                       <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 2}">checked="checked"</c:if> />中风险
                                    <input type="radio" name="acceptRisk" value="3" onclick="editAmlRisk();"
                                           <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 3 || customerAccountOpenInfoEntity.acceptRisk ==null}">checked="checked"</c:if> />低风险
                                </span>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</c:if>

<c:if test="${accountOpenApplicationEntity.applicationStatus==6 or accountOpenApplicationEntity.applicationStatus==4}">
    <div id="div9" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">开户资料下载</b></div>
            </br>
            <div class="row">
                <div class="form-group col-sm-2 col-md-2">

                </div>
                <c:forEach items="${reportFiles}" var="files">
                    <div class="form-group col-sm-2 col-md-2">
                        <button onclick="downloadAccountOpenReport('${files.fileUri}')"
                                class="layui-btn layui-btn-mini layui-btn-normal"
                                type="button">${files.displayName}</button>
                    </div>
                </c:forEach>
                <div class="form-group col-sm-2 col-md-2">

                </div>
            </div>
        </div>
    </div>
</c:if>


</body>

<script type="text/javascript">
    $(function () {

        $('#imageList').viewer();
        $('#imageList_601').viewer();
        $('#imageList_602').viewer();
        $('#imageList_603').viewer();

        initFreelanceOther('${customerAccountOpenInfoEntity.freelanceOther}');
        //初始化职业类型，收入来源
        onChangeProfessionCode('${customerAccountOpenInfoEntity.professionCode}', '${customerAccountOpenInfoEntity.capitalSource}');

        //重新上传音频、视频文件按钮
        var reButton = document.getElementsByName('reLoadButtonV');
        for (var i = 0; i < reButton.length; i++) {
            var id = $("#reLoadButtonV").val();
            var applicationId = '${customerAccountOpenInfoEntity.applicationId}';
            new AjaxUpload(reButton[i], {
                action: '${webRoot}/customer/reUpload',
                name: 'file',
                contentType: "application/json;charset=UTF-8",
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    id: id
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                        alert('只支持jpg、png、gif格式的图片！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        alert("上传成功");
                    } else {
                        alert(result.message);
                    }
                    window.location.reload();
                }
            });
        }

        //上传图片文件按钮
        var updateButtons2 = document.getElementsByName('upLoadAml');

        for (var i = 0; i < updateButtons2.length; i++) {
            var applicationId = '${customerAccountOpenInfoEntity.applicationId}';
//            var isAmlSuspicious = ;

            new AjaxUpload(updateButtons2[i], {
                action: '${webRoot}/customer/uploadAml',
                name: 'file',
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    fileType: 2
                },
                responseType: "json",
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/customer/amlRefresh?applicationId=${customerAccountOpenInfoEntity.applicationId}",
                            timeout: 3000, success: function (page) {

                                $.ajaxPrefilter('script', function (options) {
                                    options.cache = true;
                                });

                                $("#amlFlag").remove();
                                $("#amlDiv").html(page);
                                alert("上传成功");
                            },
                            error: function () {
                                console.log("faild");
                            }
                        });
                    } else {
                        alert(result.message);
                    }
                }
            });
        }

        var hkBankId = '${customerAccountOpenInfoEntity.bankId}';
        if (hkBankId == 'OTHERS') {
            $("#otherBankName").removeAttr("style", "display:none").attr("style", "display:inline")
        }
    });

    $("#professionCode").change(function () {
        onChangeProfessionCode($("#professionCode").val(), "");
    });

    /**
     * 自由职业其他说明项
     * */
    function initFreelanceOther(freelanceOther){
        $("#freelanceCode").append('<input class="form-control " style="width: 500px;display: inline" ' +
            'id="freelanceOther" name="freelanceOther" type="text" value="'+freelanceOther+'" readonly/>');
    }

    function onChangeProfessionCode(professionCode, capitalSource) {
        if (capitalSource != "") {
            $(capitalSource.toString().split(",")).each(function (i, value) {
                $("input[name='capitalSource'][value='" + value + "']").prop("checked", true);
            });
        }

        if(professionCode == "4"){
            $("#freelanceDiv").css("display", "inline");
        }

        if (professionCode == "1")//受雇
        {
            //显示工资和奖金、投资回报、劳务报酬、不动产租金
            $("#capitalSource0").css("display", "inline");
            $("#capitalSource1").css("display", "inline");
            $("#capitalSource2").css("display", "inline");
            $("#capitalSource3").css("display", "inline");

            //隐藏
            $("#capitalSource4").css("display", "none");
            $("#capitalSource5").css("display", "none");
            $("#capitalSource6").css("display", "none");
            $("#capitalSource7").css("display", "none");
            $("#capitalSource8").css("display", "none");

        } else if (professionCode == "2") //个体户
        {
            //显示营业收入、投资回报、劳务报酬、不动产租金
            $("#capitalSource1").css("display", "inline");
            $("#capitalSource2").css("display", "inline");
            $("#capitalSource3").css("display", "inline");
            $("#capitalSource4").css("display", "inline");

            //隐藏
            $("#capitalSource0").css("display", "none");
            $("#capitalSource5").css("display", "none");
            $("#capitalSource6").css("display", "none");
            $("#capitalSource7").css("display", "none");
            $("#capitalSource8").css("display", "none");

        } else if (professionCode == "3" || professionCode == "4" || professionCode == "5")//学生 自由职业者 家庭主妇
        {
            //显示家人回报、投资回报、不动产租金、兼职收入
            $("#capitalSource6").css("display", "inline");
            $("#capitalSource1").css("display", "inline");
            $("#capitalSource3").css("display", "inline");
            $("#capitalSource7").css("display", "inline");

            //隐藏
            $("#capitalSource0").css("display", "none");
            $("#capitalSource2").css("display", "none");
            $("#capitalSource4").css("display", "none");
            $("#capitalSource5").css("display", "none");
            $("#capitalSource8").css("display", "none");

        } else if (professionCode == "6")//农林牧副渔
        {
            //显示生产收入、投资回报、劳务报酬、不动产租金
            $("#capitalSource1").css("display", "inline");
            $("#capitalSource2").css("display", "inline");
            $("#capitalSource3").css("display", "inline");
            $("#capitalSource8").css("display", "inline");

            //隐藏
            $("#capitalSource0").css("display", "none");
            $("#capitalSource4").css("display", "none");
            $("#capitalSource5").css("display", "none");
            $("#capitalSource6").css("display", "none");
            $("#capitalSource7").css("display", "none");

        } else if (professionCode == "7")//退休
        {
            //显示退休金、家人给与、投资报酬、劳务报酬、不动产租金
            $("#capitalSource5").css("display", "inline");
            $("#capitalSource6").css("display", "inline");
            $("#capitalSource1").css("display", "inline");
            $("#capitalSource2").css("display", "inline");
            $("#capitalSource3").css("display", "inline");

            //隐藏
            $("#capitalSource0").css("display", "none");
            $("#capitalSource4").css("display", "none");
            $("#capitalSource7").css("display", "none");
            $("#capitalSource8").css("display", "none");
        }
    }

    //通过
    function doTaskPass() {
        confirm("确定执行此操作吗？", function () {
            var url = "${webRoot}/act/deal/doActTask";
            var userIds = new Array();
            $("#userTab input[name='userIds']").each(function () {
                userIds.push($(this).val());
            });
            var params = {
                'busId': processInfo.busId,
                'taskId': processInfo.taskId,
                'instanceId': processInfo.instanceId,
                'defId': processInfo.defId,
                'varValue': processInfo.varValue,
                'varName': processInfo.varName,
                'nodeType': processInfo.nodeType,
                'nextUserIds': userIds.join(",")
            };
            var remark = $("#remark").val();
            params["remark"] = remark;

            $.post(url, params, function (result) {
                if (result.code == '0') {
                    alert(result, function () {
                        //刷新父窗口列表
                        parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    });
                } else {
                    alertMsg(result.msg);
                }
            });

        });
    }

    //终止
    function doTaskStop() {
        confirm("确定执行此操作吗？", function () {
            var url = "${webRoot}/act/deal/doActTask";
            var userIds = new Array();
            $("#userTab input[name='userIds']").each(function () {
                userIds.push($(this).val());
            });
            var params = {
                'busId': processInfo.busId,
                'taskId': processInfo.taskId,
                'instanceId': processInfo.instanceId,
                'defId': processInfo.defId,
                'varValue': processInfo.varValue,
                'varName': processInfo.varName,
                'nodeType': processInfo.nodeType,
                'nextUserIds': userIds.join(",")
            };
            var remark = $("#remark").val();
            params["remark"] = remark;

            $.post(url, params, function (result) {
                if (result.code == '0') {
                    alert(result, function () {
                        //刷新父窗口列表
                        parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    });
                } else {
                    alertMsg(result.msg);
                }
            });
        });
    }

    //退回
    function doTaskBack() {
        var url = "${webRoot}/customer/doTaskBackView";
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["退回理由", true],
            area: ['55%', '80%'], //宽高
            content: [url, 'yes']
        });
    }

    //进入补充资料页面
    function addSupInformation(applicationId, additionalId) {
        var url = "${webRoot}/supOpenAccountInfo/supOpenAccountInfo?applicationId=" + applicationId;
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["补充资料", true],
            area: ['50%', '80%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
        });
    }

    /**
     * 下载用户报表
     */
    function downloadAccountOpenReport(fullFilePath) {
        window.location.href = webRoot + "/common/downloadFile?fullFilePath=" + fullFilePath;
    }

    /**
     * 更新AML信息
     */
    function editAmlInfo() {
        var isAmlSuspicious = $('input[name="isAmlSuspicious"]').filter(':checked').val();
        var acceptRisk = $('input[name="acceptRisk"]').filter(':checked').val();

        if (isAmlSuspicious == 1) {
            $("input[name='acceptRisk'][value='" + 1 + "']").prop("checked", true);
            $("input[name='acceptRisk'][value='" + 2 + "']").prop("checked", false);
            $("input[name='acceptRisk'][value='" + 3 + "']").prop("checked", false);
            acceptRisk = 1;
        }

        url = "${webRoot}/customer/editAmlInfo?isAmlSuspicious=" + isAmlSuspicious + "&acceptRisk=" + acceptRisk + "&applicationId=" + '${customerAccountOpenInfoEntity.applicationId}';
        $.post(url)
    }

    /**
     * 更新AML信息
     */
    function editAmlRisk() {
        var acceptRisk = $('input[name="acceptRisk"]').filter(':checked').val();

        url = "${webRoot}/customer/editAmlInfo?acceptRisk=" + acceptRisk + "&applicationId=" + '${customerAccountOpenInfoEntity.applicationId}';
        $.post(url)
    }

    /**
     * 删除AML信息
     */
    function delAmlInfo(id) {
        confirm("您确定要删除吗?", function () {
            var url = "${webRoot}/customer/delAmlInfo";
            var params = {
                'applicationId': ${customerAccountOpenInfoEntity.applicationId},
                'id': id
            };
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    $.ajax({
                        type: "get",
                        async: false,
                        cache: false,
                        url: "${webRoot}/customer/amlRefresh?applicationId=${customerAccountOpenInfoEntity.applicationId}",
                        timeout: 3000, success: function (page) {
                            $.ajaxPrefilter('script', function (options) {
                                options.cache = true;
                            });
                            $("#amlFlag").remove();
                            $("#amlDiv").html(page);
                            alert("删除成功");
                        },
                        error: function () {
                            console.log("faild");
                        }
                    });
                } else {
                    alertMsg(result.msg);
                }
            });
        });
    }

    function showFileOnline(urlPath, type) {

        var url = "${webRoot}/common/showFile?fullFilePath=" + urlPath + "&fileType=" + type;

        // 弹框层
        var index = layer.open({
            scrollbar: false,
            type: 2,
            title: ["AML文件预览", true],
            area: ['100%', '100%'],
            content: [url, 'yes']
        });

        if ("jpg,jepg,gif,png,pdf".indexOf(type) == -1) {
            layer.close(index);
            alertMsg("无法预览(." + type + ")类型的文件，请下载查看");
        }
    }

    <%--function openPhoto(src) {--%>
    <%--layer.photos({--%>
    <%--photos: {--%>
    <%--"data": [{"src": '${webRoot}/image' + src}]--%>
    <%--},--%>
    <%--shadeClose: false,--%>
    <%--shade: [0.5, '#000'],--%>
    <%--closeBtn: 2,--%>
    <%--anim: 0,--%>
    <%--});--%>
    <%--}--%>

</script>
</html>
