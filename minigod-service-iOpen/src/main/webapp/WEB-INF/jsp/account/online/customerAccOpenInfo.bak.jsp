<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>

<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
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

<%--预约信息Start--%>
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

        <div class="row">

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">小神号</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <input id="userId" name="userId" type="text" class="form-control"
                                       value="${customerAccountOpenInfoEntity.userId}" readonly/>
                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">开户方式</label>
                <div class="col-xs-9">
                               <span class="col-sm-12 block input-icon input-icon-right">
                                                    <tag:select nameKey="AO_OPEN_ACCOUNT_ACCESS_WAY"
                                                                id="openAccountAccessWay" isAddDefaltOption="true"
                                                                initSelectedKey="${customerAccountOpenInfoEntity.openAccountAccessWay}"
                                                                clazz="form-control" disabled="false"/>
                                </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">客户帐号</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="clientId" name="clientId" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.clientId}" readonly/>
	                            </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">渠道</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="sourceChannelName" name="sourceChannelName" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.sourceChannelId}" readonly/>

                            </span>
                </div>
            </div>
        </div>

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
            <c:if test="${accountOpenApplicationEntity.applicationStatus == 6 || accountOpenApplicationEntity.applicationStatus == 4}">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">电子证书序列号</label>
                    <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="caCertSn" name="caCertSn" type="text" class="form-control"
                                           value="${caCertSn}" readonly/>
	                            </span>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
<%--预约信息End--%>

<%--基本信息(大陆身份证+SZCA电子证书开户)-Start--%>
<c:if test="${customerAccountOpenInfoEntity.idKind == 1 && customerAccountOpenInfoEntity.bankType == 1}">
    <div id="div0" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
            </br>

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
                    <label class="col-sm-2 control-label no-padding-right">姓氏(中文)</label>
                    <div class="col-xs-9" style="width: 20%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyName" name="familyName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyName}" readonly/>
                                </span>
                    </div>

                    <label class="col-sm-3 control-label no-padding-right">名字(中文)</label>
                    <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenName" name="givenName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenName}" readonly/>
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

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">姓氏(英文/拼音)</label>
                    <div class="col-xs-9" style="width: 20%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyNameSpell" name="familyNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyNameSpell}" readonly/>
                                </span>
                    </div>

                    <label class="col-sm-3 control-label no-padding-right">名字(英文/拼音)</label>
                    <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenNameSpell" name="givenNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenNameSpell}" readonly/>
                                </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">签发机关</label>
                    <div class="col-xs-9">
                               <span class="col-sm-12 block input-icon input-icon-right">
                                    <input name="signingOrganization" type="text"
                                           class="form-control"
                                           value="${customerAccountOpenInfoEntity.signingOrganization}" readonly/>
                                </span>
                    </div>
                </div>

            </div>

            <div class="row">

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">性别</label>
                    <div class="col-xs-4">
                       <span class="col-sm-6 block input-icon input-icon-right">
                            <tag:select nameKey="COMMON_SEX" id="sex" isAddDefaltOption="true"
                                        initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                        clazz="form-control" disabled="false"/>
                        </span>
                    </div>

                    <label class="col-sm-2 control-label no-padding-right">民族</label>
                    <div class="col-xs-4">
                               <span class="col-sm-6 block input-icon input-icon-right">
                                    <input name="nation" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.nation}" readonly/>
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

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">出生日期</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="birthday" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.birthday}" readonly/>
                        </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">证券手机号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="phoneNumber" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.phoneNumber}" readonly/>
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
                <!--cubp迭代14.3需求：SZCA开户，去掉银行名称-->
                    <%--<div class="form-group col-sm-6 col-md-6">--%>
                    <%--<label class="col-sm-3 control-label no-padding-right">银行名称</label>--%>
                    <%--<div class="col-xs-9">--%>
                    <%--<span class="col-sm-12 block input-icon input-icon-right">--%>
                    <%--<tag:select name="bankId" nameKey="AO_BANK_CHINA" isAddDefaltOption="true"--%>
                    <%--initSelectedKey="${customerAccountOpenInfoEntity.bankId}" clazz="form-control"--%>
                    <%--disabled="disabled"/>--%>
                    <%--</span>--%>
                    <%--</div>--%>
                    <%--</div>--%>

            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">账户类型</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                             <input name="fundAccountType" type="radio" value="1" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==1}">checked</c:if>  /> 现金账户
                             <input name="fundAccountType" type="radio" value="2" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==2}">checked</c:if> /> 融资账户
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
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">现时住址</label>
                    <div class="col-xs-11">
                             <span class="col-sm-12 block input-icon input-icon-right">
                                <input name="familyProvinceName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyProvinceName}" readonly/>
                                <input name="familyCityName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyCityName}" readonly/>
                                <input name="familyCountyName" type="text"
                                       class="form-control" style="width: 15%;display: inline;"
                                       value="${customerAccountOpenInfoEntity.familyCountyName}" readonly/>
                                 <input name="familyDetailAddress" type="text"
                                        class="form-control" style="width: 54%;display: inline;"
                                        value="${customerAccountOpenInfoEntity.familyDetailAddress}" readonly/>
                                </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址</label>
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
<%--基本信息(大陆身份证+SZCA电子证书开户)End--%>

<%--基本信息(大陆身份证+香港银行卡开户)-Start--%>
<c:if test="${customerAccountOpenInfoEntity.idKind == 1 && customerAccountOpenInfoEntity.bankType == 0}">
    <div id="div0" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
            </br>

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

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">账户类型</label>
                        <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                             <input name="fundAccountType" type="radio" value="1" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==1}">checked</c:if>  /> 现金账户
                             <input name="fundAccountType" type="radio" value="2" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==2}">checked</c:if> /> 融资账户
                        </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">姓氏(中文)</label>
                    <div class="col-xs-9" style="width: 20%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyName" name="familyName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyName}" readonly/>
                                </span>
                    </div>

                    <label class="col-sm-3 control-label no-padding-right">名字(中文)</label>
                    <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenName" name="givenName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenName}" readonly/>
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
                    <label class="col-sm-2 control-label no-padding-right">姓氏(英文/拼音)</label>
                    <div class="col-xs-9" style="width: 20%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyNameSpell" name="familyNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyNameSpell}" readonly/>
                                </span>
                    </div>

                    <label class="col-sm-3 control-label no-padding-right">名字(英文/拼音)</label>
                    <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenNameSpell" name="givenNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenNameSpell}" readonly/>
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

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">性别</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <tag:select nameKey="COMMON_SEX" id="sex" isAddDefaltOption="true"
                                        initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                        clazz="form-control" disabled="false"/>
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

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">出生日期</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="birthday" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.birthday}" readonly/>
                        </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">证券帐户预留手机号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="phoneNumber" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.phoneNumber}" readonly/>
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
                    <label class="col-sm-2 control-label no-padding-right">证件号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idNo" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idNo}" readonly/>
                        </span>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">现时住址</label>
                    <div class="col-xs-11">
                             <span class="col-sm-12 block input-icon input-icon-right">
                                <input name="familyProvinceName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyProvinceName}" readonly/>
                                <input name="familyCityName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyCityName}" readonly/>
                                <input name="familyCountyName" type="text"
                                       class="form-control" style="width: 15%;display: inline;"
                                       value="${customerAccountOpenInfoEntity.familyCountyName}" readonly/>
                                 <input name="familyDetailAddress" type="text"
                                        class="form-control" style="width: 54%;display: inline;"
                                        value="${customerAccountOpenInfoEntity.familyDetailAddress}" readonly/>
                                </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址</label>
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
<%--基本信息(大陆身份证+香港银行卡开户)End--%>

<%--基本信息(香港身份证/临时身份证+香港银行卡开户)-Start--%>
<c:if test="${(customerAccountOpenInfoEntity.idKind == 2 || customerAccountOpenInfoEntity.idKind == 4)&& customerAccountOpenInfoEntity.bankType == 0}">
    <div id="div0" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
            </br>

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

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">账户类型</label>
                        <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                             <input name="fundAccountType" type="radio" value="1" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==1}">checked</c:if>  /> 现金账户
                             <input name="fundAccountType" type="radio" value="2" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==2}">checked</c:if> /> 融资账户
                        </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">姓氏(中文)</label>
                    <div class="col-xs-9" style="width: 20%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyName" name="familyName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyName}" readonly/>
                                </span>
                    </div>

                    <label class="col-sm-3 control-label no-padding-right">名字(中文)</label>
                    <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenName" name="givenName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenName}" readonly/>
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
                    <label class="col-sm-2 control-label no-padding-right">姓氏(英文/拼音)</label>
                    <div class="col-xs-9" style="width: 20%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyNameSpell" name="familyNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyNameSpell}" readonly/>
                                </span>
                    </div>

                    <label class="col-sm-3 control-label no-padding-right">名字(英文/拼音)</label>
                    <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenNameSpell" name="givenNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenNameSpell}" readonly/>
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

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">出生日期</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="birthday" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.birthday}" readonly/>
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

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">性别</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <tag:select nameKey="COMMON_SEX" id="sex" isAddDefaltOption="true"
                                        initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                        clazz="form-control" disabled="false"/>
                        </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">证券帐户预留手机号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="phoneNumber" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.phoneNumber}" readonly/>
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
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">现时住址</label>
                    <div class="col-xs-11">
                             <span class="col-sm-12 block input-icon input-icon-right">
                                <input name="familyProvinceName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyProvinceName}" readonly/>
                                <input name="familyCityName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyCityName}" readonly/>
                                <input name="familyCountyName" type="text"
                                       class="form-control" style="width: 15%;display: inline;"
                                       value="${customerAccountOpenInfoEntity.familyCountyName}" readonly/>
                                 <input name="familyDetailAddress" type="text"
                                        class="form-control" style="width: 54%;display: inline;"
                                        value="${customerAccountOpenInfoEntity.familyDetailAddress}" readonly/>
                                </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址</label>
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
<%--基本信息(香港身份证+香港银行卡开户)End--%>

<%--基本信息(护照+香港银行卡开户)-Start--%>
<c:if test="${customerAccountOpenInfoEntity.idKind == 3 && customerAccountOpenInfoEntity.bankType == 0}">
    <div id="div0" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
            </br>

            <div class="row">

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">国家/地区</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <c:choose>
                               <c:when test="${customerAccountOpenInfoEntity.nationality == 'OTH'}">
                                <input name="nationality" type="text" class="form-control"
                                       value="${customerAccountOpenInfoEntity.otherNationality}"
                                       readonly/>
                               </c:when>
                               <c:otherwise>
                               <input name="nationality" type="text" class="form-control"
                                      value="${fns:getCodeName("AO_NATIONALITY",customerAccountOpenInfoEntity.nationality)}"
                                      readonly/>
                               </c:otherwise>
                           </c:choose>
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
                    <label class="col-sm-3 control-label no-padding-right">证券帐户预留手机号</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="phoneNumber" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.phoneNumber}" readonly/>
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

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">姓氏(中文)</label>
                    <div class="col-xs-9" style="width: 20%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyName" name="familyName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyName}" readonly/>
                                </span>
                    </div>

                    <label class="col-sm-3 control-label no-padding-right">名字(中文)</label>
                    <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenName" name="givenName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenName}" readonly/>
                                </span>
                    </div>
                </div>
            </div>

            <div class="row">

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">姓氏(英文/拼音)</label>
                    <div class="col-xs-9" style="width: 20%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyNameSpell" name="familyNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyNameSpell}" readonly/>
                                </span>
                    </div>

                    <label class="col-sm-3 control-label no-padding-right">名字(英文/拼音)</label>
                    <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenNameSpell" name="givenNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenNameSpell}" readonly/>
                                </span>
                    </div>
                </div>

            </div>

            <div class="row">

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
                    <label class="col-sm-2 control-label no-padding-right">性别</label>
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
                    <label class="col-sm-2 control-label no-padding-right">账户类型</label>
                    <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                             <input name="fundAccountType" type="radio" value="1" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==1}">checked</c:if>  /> 现金账户
                             <input name="fundAccountType" type="radio" value="2" disabled="disabled"
                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==2}">checked</c:if> /> 融资账户
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
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">现时住址</label>
                    <div class="col-xs-11">
                             <span class="col-sm-12 block input-icon input-icon-right">
                                <input name="familyProvinceName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyProvinceName}" readonly/>
                                <input name="familyCityName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyCityName}" readonly/>
                                <input name="familyCountyName" type="text"
                                       class="form-control" style="width: 15%;display: inline;"
                                       value="${customerAccountOpenInfoEntity.familyCountyName}" readonly/>
                                 <input name="familyDetailAddress" type="text"
                                        class="form-control" style="width: 54%;display: inline;"
                                        value="${customerAccountOpenInfoEntity.familyDetailAddress}" readonly/>
                                </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-12 col-md-12">
                    <label class="col-sm-1 control-label no-padding-right">通讯地址</label>
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
<%--基本信息(护照+香港银行卡开户)End--%>

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

<c:if test="${customerAccountOpenInfoEntity.bankType !=null and customerAccountOpenInfoEntity.bankType == 1}">
    <div id="div2" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">四要素信息</b></div>
            </br>
            <div class="row">
                <c:forEach items="${bankVerityInfoList}" var="bankVerityInfo">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-1 control-label" style="width: 100px;text-align:left;"></label>
                        <label class="col-sm-1 control-label" style="width: 100px;text-align:left;">用户姓名: </label>
                        <span class="col-sm-1 control-label "
                              style="width: 200px;text-align:left; ">${bankVerityInfo.clientName}</span>
                        <label class="col-sm-1 control-label " style="width: 100px;text-align:left; ">证件号: </label>
                        <span class="col-sm-1 control-label "
                              style="width: 200px;text-align:left;">${bankVerityInfo.idNo}</span>
                        <label class="col-sm-1 control-label " style="width: 100px;text-align:left;">银行卡号:</label>
                        <span class="col-sm-1 control-label "
                              style="width: 200px;text-align:left;">${bankVerityInfo.bankCard}</span>
                        <label class="col-sm-1 control-label " style="width: 100px;text-align:left;">证券帐户预留手机号:</label>
                        <span class="col-sm-1 control-label "
                              style="width: 200px;text-align:left;">${bankVerityInfo.phoneNumber}</span>
                    </div>
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-1 control-label" style="width: 100px;text-align:left;"></label>
                        <label class="col-sm-1 control-label " style="width: 100px;text-align:left;">校验时间:</label>
                        <span class="col-sm-1 control-label" style="width: 200px;text-align:left;"><fmt:formatDate
                                value="${bankVerityInfo.verityTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                        <label class="col-sm-1 control-label" style="width: 100px;text-align:left;">校验方:</label>
                        <span class="col-sm-1 control-label" style="width: 200px;text-align:left;">CFCA</span>
                        <label class="col-sm-1 control-label" style="width: 100px;text-align:left;">校验次数:</label>
                        <span class="col-sm-1 control-label"
                              style="width: 200px;text-align:left;">${bankVerityInfo.verifyCount}</span>
                        <label class="col-sm-1 control-label" style="width: 100px;text-align:left;">校验结果: </label>
                        <span class="col-sm-1 control-label"
                              style="width: 200px;text-align:left;">
                            <c:if test="${bankVerityInfo.verifyStatus==0}">不通过</c:if>
                            <c:if test="${bankVerityInfo.verifyStatus==1}">通过</c:if>
                        </span>
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
                <label class="col-sm-2 control-label no-padding-right">职业类型</label>
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
                            />
                        </span>
                </div>
            </div>
        </div>

        <div id="freelanceDiv" class="row" style="display: none">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">职业名称</label>
                <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right" style="width:250%">
                         	<tag:radio nameKey="AO_FREELANCE_CODE" id="freelanceCode" name="freelanceCode"
                                          initCheckKey="${customerAccountOpenInfoEntity.freelanceCode}"
                                          clazz="display:inline" disabled="disabled"/>
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
        <div class="panel-heading"><b style="color: #368763">财务与投资状况</b></div>
        </br>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">全年收入</label>
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
                <label class="col-sm-2 control-label no-padding-right">收入来源</label>
                <div class="col-xs-9">
                    <span class="col-xs-12 block input-icon input-icon-right" style="width:1000px">
                        <span id="capitalSource0"><input name="capitalSource" type="checkbox" value="0"
                                                         disabled="false"/>工资和奖金</span>
                            <span id="capitalSource1"><input name="capitalSource" type="checkbox" value="1"
                                                             disabled="false"/>投资回报</span>
                            <span id="capitalSource3"><input name="capitalSource" type="checkbox" value="3"
                                                         disabled="false"/>不动产租金</span>
                            <span id="capitalSource7"><input name="capitalSource" type="checkbox" value="7"
                                                         disabled="false"/>兼职收入</span>
                            <span id="capitalSource6"><input name="capitalSource" type="checkbox" value="6"
                                                         disabled="false"/>家人给予</span>
                            <span id="capitalSource2"><input name="capitalSource" type="checkbox" value="2"
                                                             disabled="false"/>劳务报酬</span>
                            <span id="capitalSource5"><input name="capitalSource" type="checkbox" value="5"
                                                             disabled="false"/>退休金</span>
                            <span id="capitalSource4"><input name="capitalSource" type="checkbox" value="4"
                                                             disabled="false"/>营业收入</span>
                            <span id="capitalSource8"><input name="capitalSource" type="checkbox" value="8"
                                                             disabled="false"/>生产收入</span>

                           <%--<tag:checkbox name="capitalSource" nameKey="AO_CAPITAL_SOURCE"--%>
                                         <%--initCheckKey="${customerAccountOpenInfoEntity.capitalSource}"--%>
                                         <%--disabled="disabled"></tag:checkbox>--%>
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
                                    <%--<input class="form-control" style="width:150px;display: inline;"--%>
                                           <%--name="propertyAmount" type="text"--%>
                                           <%--value="${openAccountPropertyType.propertyAmount}"--%>
                                           <%--style="height:34px; margin-right: 0px;" readonly/>万港元--%>
                                    <tag:select nameKey="AO_PROPERTY_TYPE_${openAccountPropertyType.propertyType}"
                                                clazz="form-control" style="width:150px;display:inline"
                                                isAddDefaltOption="true"
                                                initSelectedKey="${openAccountPropertyType.propertyAmount}"
                                                disabled="disabled"/>港币
                                </span>
                                <span style="width:20px;">&nbsp;&nbsp;&nbsp;</span>
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
                        <tag:checkbox nameKey="AO_INVEST_TARGET" id="investTarget" name="investTarget"
                                      initCheckKey="${customerAccountOpenInfoEntity.investTarget}" clazz=""
                                      disabled="disabled" style="display: inline" initDidableKey="2,3"/>
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
                    <span class="col-xs-12 block input-icon input-icon-right" style="width:800px">
                        <span>股票/基金/债券</span>
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

        <%--<div class="row">--%>
            <%--<div class="form-group col-sm-6 col-md-6">--%>
                <%--<label class="col-sm-2 control-label no-padding-right">风险承受程度</label>--%>
                <%--<div class="col-xs-9">--%>
                        <%--<span class="col-xs-12 block input-icon input-icon-right">--%>
                             <%--<input type="radio" name="acceptRisk" disabled="disabled"--%>
                                    <%--value="1" <c:if--%>
                                     <%--test="${customerAccountOpenInfoEntity.acceptRisk==1}"> checked="checked"</c:if> />低风险--%>
                             <%--<input type="radio" name="acceptRisk" disabled="disabled"--%>
                                    <%--value="2" <c:if--%>
                                     <%--test="${customerAccountOpenInfoEntity.acceptRisk==2}"> checked="checked"</c:if>  />中风险--%>
                            <%--<input type="radio" name="acceptRisk" disabled="disabled"--%>
                                   <%--value="3" <c:if--%>
                                    <%--test="${customerAccountOpenInfoEntity.acceptRisk==3}"> checked="checked"</c:if>  />高风险--%>
                        <%--</span>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
</div>

<div id="div5" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">衍生产品认知评估</b></div>
        </br>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-12 control-label no-padding-right">您对衍生品是否有认识？</label>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                        <span class="col-sm-12 block input-icon input-icon-right">
                             <input type="radio" name="isKnowDerivativeProducts" disabled="disabled"
                                    value="1" <c:if
                                     test="${customerAccountOpenInfoEntity.isKnowDerivativeProducts==1}"> checked="checked"</c:if> />是
                             <input type="radio" name="isKnowDerivativeProducts" disabled="disabled"
                                    value="0" <c:if
                                     test="${customerAccountOpenInfoEntity.isKnowDerivativeProducts==0}"> checked="checked"</c:if>  />否
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
                <div hidden id="imageList_601">
                    <ul class="docs-pictures"></ul>
                </div>
                <c:if test="${proofImage_601!=null && customerAccountOpenInfoEntity.derivativeProductsStudyType!=null && customerAccountOpenInfoEntity.derivativeProductsStudyType!=''}">
                    <script type="text/javascript">pictureListWithId("${proofImage_601.storagePath}${proofImage_601.fileStorageName}.${proofImage_601.extName}", 0, '_601');</script>
                    <span class="col-xs-2 block input-icon input-icon-right">
                                <button class="layui-btn layui-btn-mini layui-btn-warm" type="button"
                                        onclick="showImage('_601',0)">凭证</button>
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
                <div hidden id="imageList_602">
                    <ul class="docs-pictures"></ul>
                </div>
                <c:if test="${proofImage_602!=null&& customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType!=null && customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType!=''}">
                    <script type="text/javascript">pictureListWithId("${proofImage_602.storagePath}${proofImage_602.fileStorageName}.${proofImage_602.extName}", 0, '_602');</script>
                    <span class="col-xs-2 block input-icon input-icon-right">
                                <button class="layui-btn layui-btn-mini layui-btn-warm" type="button"
                                        onclick="showImage('_602',0)">凭证</button>
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
                <div hidden id="imageList_603">
                    <ul class="docs-pictures"></ul>
                </div>
                <c:if test="${proofImage_603!=null && customerAccountOpenInfoEntity.isTradedDerivativeProducts == 1}">
                    <script type="text/javascript">pictureListWithId("${proofImage_603.storagePath}${proofImage_603.fileStorageName}.${proofImage_603.extName}", 0, '_603');</script>
                    <span class="col-xs-2 block input-icon input-icon-right">
                                <button class="layui-btn layui-btn-mini layui-btn-warm" type="button"
                                        onclick="showImage('_603',0)">凭证</button>
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
                <label class="col-sm-12 control-label no-padding-right">您是否确认《个人资料（私隐）条例通知》并同意智珠证券及其控股集团使用及向其他人士提供本人的个人资料作直接促销用途。</label>
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
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-12 control-label no-padding-right">您是否确认智珠证券根据《有关中华通证券北向交易的个人资料收集声明》所述的目的使用您的个人资料</label>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-12 block input-icon input-icon-right">
                                    <input type="radio" name="northTrade" disabled="disabled"
                                           value="1"
                                           <c:if test="${customerAccountOpenInfoEntity.northTrade == 1}">checked="checked"</c:if>
                                    />是
                                    <input type="radio" name="northTrade" disabled="disabled"
                                           <c:if test="${customerAccountOpenInfoEntity.northTrade == 0}">checked="checked"</c:if>
                                           value="0"
                                    />否
                        </span>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-12 control-label no-padding-right">您是否出生于美国/美国公民/美国居民/美国永久居民外国人(即所谓的美国绿卡持有人(不论到期日))。</label>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-12 block input-icon input-icon-right">
                                    <input type="radio" name="FATCA" disabled="disabled"
                                           value="1"
                                           <c:if test="${customerAccountOpenInfoEntity.fatca == 1}">checked="checked"</c:if>
                                    />是
                                    <input type="radio" name="FATCA" disabled="disabled"
                                           value="0"
                                           <c:if test="${customerAccountOpenInfoEntity.fatca == 0}">checked="checked"</c:if>
                                    />否
                        </span>
            </div>
        </div>
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

    </div>
</div>

<div id="div7" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">身份资料申报</b></div>
        </br>

        <c:forEach items="${openAccountOtherDisclosureList}" var="openAccountOther" varStatus="i">

            <c:choose>
                <c:when test="${openAccountOther.disclosureCode ==16}">
                    <%--<label class="control-label no-padding-right">--%>
                    <%--<input id="mustSure1" name="disclosureFlag_${openAccountOther.disclosureCode}"--%>
                    <%--type="checkbox" disabled="disabled" value="openAccountOther.disclosureIsTrue"--%>
                    <%--<c:if test="${openAccountOther.disclosureIsTrue==1}">checked="checked"</c:if>--%>
                    <%--/>${fns:getCodeName("AO_DISCLOSURE_CODE",openAccountOther.disclosureCode)}--%>
                    <%--</label>--%>
                </c:when>
                <c:otherwise>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-12 control-label no-padding-right">${fns:getCodeName("AO_DISCLOSURE_CODE",openAccountOther.disclosureCode)}</label>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                    <span class="col-sm-12 block input-icon input-icon-right">
                         <input type="radio" name="disclosureFlag_${openAccountOther.disclosureCode}"
                                <c:if test="${openAccountOther.disclosureIsTrue==1}">checked="checked"</c:if>
                                value="1" disabled="disabled"/>是
                            <input type="radio" name="disclosureFlag_${openAccountOther.disclosureCode}"
                                   <c:if test="${openAccountOther.disclosureIsTrue==0}">checked="checked"</c:if>
                                   value="0" disabled="disabled"/>否
                    </span>
                        </div>
                        <div class="form-group col-sm-12 col-md-12">
                    <span class="col-sm-12 block input-icon input-icon-right">
                         <%--<c:if test="${(openAccountOther.disclosureCode ==1 || openAccountOther.disclosureCode ==2 ||openAccountOther.disclosureCode ==3)}"> &lt;%&ndash;受益人，亲属关系，注册人否的值 &ndash;%&gt;--%>
                             <c:if test="${openAccountOther.disclosureNameJoinDetail!=null && openAccountOther.disclosureNameJoinDetail!=''}">
                                 <input class="form-control" style="display: inline"
                                        id="disclosureCode" name="disclosureCode" type="text"
                                        value="${openAccountOther.disclosureNameJoinDetail}"
                                        style="width:600px; margin-left:25px; height:34px;"
                                        readonly/>
                             </c:if>
                         <%--</c:if>--%>
                    </span>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
</div>
<%--<div id="div8" v-cloak>--%>
<%--<div v-show="!showList" class="panel panel-default">--%>
<%--<div class="panel-heading"><b style="color: #368763">客户声明及确认</b></div>--%>
<%--</br>--%>
<%--<div class="row">--%>
<%--<span class="form-group col-sm-12 control-label no-padding-right">--%>
<%--本人声明就本人所知所信，税务信息内所填报的所有资料和声明均属真实、正确和完备。</span>--%>
<%--<span class="form-group col-sm-12 control-label no-padding-right">--%>
<%--本人知悉、明白和同意「智珠证券」可根据有关交换财务帐户资料的法令规定或政府间协议(a)收集本税务信息部分所载资料并可备存作自动交换财务帐户资料用途及--%>
<%--(b)把该等资料和关于帐户持有人及任何须申报帐户的资料向财务帐户所设立的国家的税务机关及╱或美国国税局申报，--%>
<%--从而把资料转交到帐户持有人的居留司法管辖区的税务当局。</span>--%>
<%--<span class="form-group col-sm-12 control-label no-padding-right">--%>
<%--本人承诺，如情况有所改变，以致影响本税务信息部分所述的个人的税务居民身份，或引致本税务信息部分所载的资料不正确或不完备，--%>
<%--本人会在情况发生改变后三十(30)天内，通知「智珠证券」，并提供一份已适当更新的自我证明表格。--%>
<%--</span>--%>
<%--<span class="form-group col-sm-12 control-label no-padding-right">--%>
<%--依照客户协议中的电子交易服务的条款及条件，开立及维持一个电子交易服务的现金证券买卖户口，并为本人提供一个登入名称及密码以便使用「智珠证券」--%>
<%--电子交易服务。本人将获取股票电子交易密码以便本人进行买卖交易。本人完全明白户口密码是绝对保密。本人须对「智珠证券」核实密码后被接纳的所有买卖、--%>
<%--损失、费用及支出负全部责任。</span>--%>
<%--<span class="col-sm-12 control-label no-padding-right">--%>
<%--本人同意以电邮形式收取结单╱通告，结单╱通告将电邮至开户申请表所列本人之电邮地址，并同意「智珠证券」不再另行邮寄结单╱通告到本人之通讯地址，--%>
<%--本人承诺如本人之电邮地址有变更，会于七(7)天内通知「智珠证券」。</span>--%>
<%--<span class="form-group col-sm-12 control-label no-padding-right">--%>
<%--* 若以电邮形式收取结单╱通告，于结单╱通告发出时，本人将被视作已收到该结单╱通告。</span>--%>
<%--<span class="form-group col-sm-12 control-label no-padding-right">--%>
<%--本人清楚明白并愿意承担因额外要求以邮寄形式收取结单╱通告而产生相应的一切费用，且本人承诺如本人之通讯地址有变更，会于七(7)天内通知「智珠证券」。</span>--%>
<%--<span class="form-group col-sm-12 control-label no-padding-right">--%>
<%--本人于「智珠证券」开立一个或多个现金证券买卖户口（下称「该户口」）以进行证券买卖。智珠证券同意不时应本人要求,--%>
<%--按其独自酌情权让本人在「智珠证券」开立一个或多个户口并以代理人身份行事（除非客户协议之条款及条件中特别注明「智珠证券」为主事人）。</span>--%>
<%--<span class="form-group col-sm-12 control-label no-padding-right">--%>
<%--本人现声明已阅悉及同意「智珠证券」开户申请表，并已填写各项客户资料，及已阅悉及同意客户协议中的条例及条件。个人一自我证明表格说明（FATCA及CRS）、--%>
<%--个人资料（私隐）条例通知、予沪港通及深港通客户通知、有关中华通证券北向交易的个人资料搜集声明及证券帐户风险披露声明。--%>
<%--上述所有文件均构成「智珠证券」与本人就该户口达成的协议。</span>--%>
<%--<span class="form-group col-sm-12 control-label no-padding-right">--%>
<%--本人现声明及确认由「智珠证券」给予本人之协议，包括但不限于客户协议中的风险披露声明、个人一自我证明表格说明（FATCA及CRS）、--%>
<%--个人资料（私隐）条例通知、予沪港通及深港通客户通知、有关中华通证券北向交易的个人资料搜集声明以及证券帐户风险披露声明，智珠证券」--%>
<%--是按本人选择的语言提供。本人获邀请阅读证券帐户风险披露声明、个人一自我证明表格说明（FATCA及CRS）、个人资料（私隐）条例通知、--%>
<%--予沪港通及深港通客户通知、有关中华通证券北向交易的个人资料搜集声明、提出问题，并按本身意愿选择是否听取独立法律意见。--%>
<%--本人已获解释该证券帐户风险披露声明。</span>--%>
<%--<span class="form-group col-sm-12 control-label no-padding-right">--%>
<%--本人现授权「智珠证券」接受任何本人发出之传真及/或电邮讯息为原本指示及就「智珠证券」因执行此指示而招致、蒙受或遭受一切损失、赔款、利息、成本、--%>
<%--费用及一切因法律行动而招致、蒙受或遭受之索偿，本人须向「智珠证券」作出赔偿保证及保障「智珠证券」不会因此蒙受损失。本人免除「智珠证券」--%>
<%--因此授权所引起的责任及损害。</span>--%>
<%--<span class="form-group col-sm-12 control-label no-padding-right">--%>
<%--本人现声明在开户申请表内的资料属真实、完整及正确，随附客户协议内之一切声明亦准确。除非「智珠证券」接到书面更改通知，否则「智珠证券」--%>
<%--有权为所有目的，完全依赖这些资料及声明。「智珠证券」有权随时联络任何人，包括本人之银行、经纪或任何信贷调査机构，以求证实此开户申请表内所载之内容。</span>--%>
<%--</div>--%>
<%--<label class="control-label no-padding-right"><input id="mustSure2" type="checkbox" checked="checked"--%>
<%--disabled="disabled"/>--%>
<%--本人同意上述安排及选择。</label>--%>
<%--</div>--%>
<%--</div>--%>
<c:if test="${proofFileList!=null or addFileList!=null}">
    <div id="updateFileProof" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">资料修改凭证</b></div>
            </br>
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
                        <span class="col-sm-4 control-label no-padding-right">
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
                                <span class="col-xs-4 block input-icon input-icon-right">
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

        } else if (professionCode == "2") {//个体户
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
        var acceptRisk=$('input[name="acceptRisk"]').filter(':checked').val();

        if (isAmlSuspicious == 1){
            $("input[name='acceptRisk'][value='" + 1 + "']").prop("checked", true);
            $("input[name='acceptRisk'][value='" + 2 + "']").prop("checked", false);
            $("input[name='acceptRisk'][value='" + 3 + "']").prop("checked", false);
            acceptRisk=1;
        }

        url = "${webRoot}/customer/editAmlInfo?isAmlSuspicious=" + isAmlSuspicious+ "&acceptRisk="+acceptRisk+ "&applicationId=" + '${customerAccountOpenInfoEntity.applicationId}';
        $.post(url)
    }

    /**
     * 更新AML信息
     */
    function editAmlRisk() {
        var acceptRisk = $('input[name="acceptRisk"]').filter(':checked').val();

        url = "${webRoot}/customer/editAmlInfo?acceptRisk=" + acceptRisk+ "&applicationId=" + '${customerAccountOpenInfoEntity.applicationId}';
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

        var url = "${webRoot}/common/showFile?fullFilePath="+urlPath+"&fileType="+type;

        // 弹框层
        var index = layer.open({
            scrollbar: false,
            type: 2,
            title: ["AML文件预览", true],
            area: ['100%', '100%'],
            content: [url, 'yes']
        });

        if("jpg,jepg,gif,png,pdf".indexOf(type)==-1){
            layer.close(index);
            alertMsg("无法预览(."+type+")类型的文件，请下载查看");
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
