<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer-jquery.min.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/ajaxupload.js"></script>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
    <script src="${webRoot}/js/jquery.serializejson.js"></script>
</head>
<style>
    #investTarget {
        display: inline
    }
</style>
<body>
<div class="layui-tab-content" style="margin-left: 10px">
    <form id="basicInfoForm">
        <input name="isRecheck" style="display: none" value="${customerAccountOpenInfoEntity.isRecheck}">
        <input name="openAccountType" style="display: none" value="${customerAccountOpenInfoEntity.openAccountType}">
        <input name="openAccountAccessWay" style="display: none"
               value="${customerAccountOpenInfoEntity.openAccountAccessWay}">
        <input name="inviterId" style="display: none" value="${customerAccountOpenInfoEntity.inviterId}">
        <input name="bankType" style="display: none" value="${customerAccountOpenInfoEntity.bankType}">
        <div id="div10" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">预约信息</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">预约号</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input id="applicationId" name="applicationId" type="text" class="form-control"
                                       value="${customerAccountOpenInfoEntity.applicationId}" readonly/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">申请时间</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input id="applicationTime" name="applicationTime" type="text" class="form-control"
                                       readonly
                                       value="<fmt:formatDate value="${customerAccountOpenInfoEntity.applicationTime}" pattern="yyyy-MM-dd HH:mm"/>"/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">小神号</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input id="userId" name="userId" type="text" class="form-control" readonly
                                       value="${customerAccountOpenInfoEntity.userId}"/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">渠道</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                           <input id="sourceChannelId" name="sourceChannelId" type="text" class="form-control" readonly
                                  value="${customerAccountOpenInfoEntity.sourceChannelId}"/>

                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">客户账号</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input id="clientId" name="clientId" type="text"
                                       value="${customerAccountOpenInfoEntity.clientId}" class="form-control"/>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${customerAccountOpenInfoEntity.bankType == 0}">
            <div id="div0" v-cloak>
                <div v-show="!showList" class="panel panel-default">
                    <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
                    </br>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">姓氏(中文)</label>
                            <div class="col-xs-9"  style="width: 20%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyName" name="familyName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyName}"/>
                                </span>
                            </div>

                            <label class="col-sm-3 control-label no-padding-right">名字(中文)</label>
                            <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenName" name="givenName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenName}"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">证券帐户预留手机号</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="phoneNumber" name="phoneNumber" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.phoneNumber}"/>
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
                                           value="${customerAccountOpenInfoEntity.familyNameSpell}"/>
                                </span>
                            </div>

                            <label class="col-sm-3 control-label no-padding-right">名字(英文/拼音)</label>
                            <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenNameSpell" name="givenNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenNameSpell}"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">电子邮箱</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                 <input id="email" name="email" type="text" class="form-control"
                                        value="${customerAccountOpenInfoEntity.email}"/>
                                </span>
                            </div>
                        </div>

                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">性别</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                                    <tag:select nameKey="COMMON_SEX" id="sex" name="sex"
                                                                initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                                                clazz="form-control"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">出生日期</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="birthday" name="birthday" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.birthday}"/>
                                </span>
                            </div>
                        </div>

                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">证件类型</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <tag:select nameKey="AO_ID_KIND" id="idKind" name="idKind" isAddDefaltOption="true"
                                                initSelectedKey="${customerAccountOpenInfoEntity.idKind}"
                                                clazz="form-control"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">国家/地区</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <tag:select id="nationality" name="nationality" nameKey="AO_NATIONALITY"
                                                initSelectedKey="${customerAccountOpenInfoEntity.nationality}"
                                                clazz="form-control"/>
                                    <c:choose>
                                        <c:when test="${customerAccountOpenInfoEntity.nationality == 'OTH'}">
                                            <input id = "otherNationality" name="otherNationality" type="text" class="form-control"
                                                value="${customerAccountOpenInfoEntity.otherNationality}"
                                                   placeholder="选择其它国家/地区时填写"/>
                                        </c:when>
                                        <c:otherwise>
                                            <input id = "otherNationality" name="otherNationality" type="text" class="form-control"
                                            placeholder="选择其它国家/地区时填写" style="display: none"/>
                                        </c:otherwise>
                                    </c:choose>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">证件号</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="idNo" name="idNo" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.idNo}"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">证件生效期</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="idCardValidDateStart" name="idCardValidDateStart" type="text"
                                           class="form-control"
                                           value="${customerAccountOpenInfoEntity.idCardValidDateStart}"/>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6" style="display:none;">
                            <label class="col-sm-2 control-label no-padding-right">银行名称</label>
                            <div class="col-xs-9" style="display: inline">
                                <span class="col-xs-6 block input-icon input-icon-right">
                                    <tag:select id="hkBankId" name="bankId" nameKey="AO_BANK_HK"
                                                isAddDefaltOption="true"
                                                initSelectedKey="${customerAccountOpenInfoEntity.bankId}"
                                                clazz="form-control"/>
                                </span>
                                <span class="col-xs-6 block input-icon input-icon-right">
                                      <input style="display: none;" id="otherBankName" name="otherBankName" type="text"
                                             class="form-control"
                                             value="${customerAccountOpenInfoEntity.otherBankName}"/>
                                </span>
                            </div>

                        </div>


                        <div class="form-group col-sm-6 col-md-6" style="display:none;">
                            <label class="col-sm-3 control-label no-padding-right">银行户名</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input name="bankAccountName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.bankAccountName}"/>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">账户类型</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-12 block input-icon input-icon-right">
                                             <input name="fundAccountType" type="radio" value="1"
                                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==1}">checked</c:if>  /> 现金账户
                                             <input name="fundAccountType" type="radio" value="2"
                                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==2}">checked</c:if> /> 融资账户
                                        </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">证件有效期至</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="idCardValidDateEnd" name="idCardValidDateEnd" type="text"
                                           class="form-control"
                                           value="${customerAccountOpenInfoEntity.idCardValidDateEnd}"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6" style="display:none;">
                            <label class="col-sm-3 control-label no-padding-right">银行帐号</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                <%--<tag:select nameKey="AO_BANK_ID" id="bankId" name="bankId" isAddDefaltOption="true"--%>
                                            <%--initSelectedKey="${customerAccountOpenInfoEntity.bankId}"--%>
                                            <%--clazz="form-control " style="width:130px;display:inline"/>--%>

                                          <input class="form-control" name="bankNo"
                                                 type="text"
                                                 value="${customerAccountOpenInfoEntity.bankNo}"
                                                 style="height:34px; margin-right: 0px;"
                                          />
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-12 col-md-12">
                            <label class="col-sm-1 control-label no-padding-right">证件地址</label>
                            <div class="col-xs-11">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="idCardAddress" name="idCardAddress" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.idCardAddress}"/>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-12 col-md-12">
                            <label class="col-sm-1 control-label no-padding-right">现时住址</label>
                            <div class="col-xs-11">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                <input name="familyProvinceName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyProvinceName}"/>
                                <input name="familyCityName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyCityName}"/>
                                <input name="familyCountyName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyCountyName}"/>
                                <input name="familyDetailAddress" type="text"
                                       class="form-control" style="display: inline;width: 54%"
                                       value="${customerAccountOpenInfoEntity.familyDetailAddress}"/>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-12 col-md-12">
                            <label class="col-sm-1 control-label no-padding-right">通讯地址</label>
                            <div class="col-xs-11">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                <input name="contactProvinceName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.contactProvinceName}"/>
                                <input name="contactCityName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.contactCityName}"/>
                                <input name="contactCountyName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.contactCountyName}"/>
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="display: inline;width: 54%"
                                       value="${customerAccountOpenInfoEntity.contactDetailAddress}"/>
                                </span>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </c:if>
        <c:if test="${customerAccountOpenInfoEntity.bankType == 1}">
            <div id="div0" v-cloak>
                <div v-show="!showList" class="panel panel-default">
                    <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
                    </br>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">姓氏(中文)</label>
                            <div class="col-xs-9"  style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyName" name="familyName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyName}"/>
                                </span>
                            </div>

                            <label class="col-sm-2 control-label no-padding-right">名字(中文)</label>
                            <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenName" name="givenName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenName}"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">性别</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                                    <tag:select nameKey="COMMON_SEX" id="sex" name="sex"
                                                                isAddDefaltOption="true"
                                                                initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                                                clazz="form-control"/>
                                </span>
                            </div>
                        </div>

                    </div>

                    <div class="row">

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">姓氏(英文/拼音)</label>
                            <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyNameSpell" name="familyNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyNameSpell}"/>
                                </span>
                            </div>

                            <label class="col-sm-2 control-label no-padding-right">名字(英文/拼音)</label>
                            <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenNameSpell" name="givenNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.givenNameSpell}"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">证券帐户预留手机号</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input name="phoneNumber" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.phoneNumber}"/>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">出生日期</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input name="birthday" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.birthday}"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">电子邮箱</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                 <input name="email" type="text" class="form-control"
                                        value="${customerAccountOpenInfoEntity.email}"/>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">证件类型</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <tag:select nameKey="AO_ID_KIND" id="idKind" name="idKind"
                                                initSelectedKey="${customerAccountOpenInfoEntity.idKind}"
                                                clazz="form-control"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">国家/地区</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <tag:select id="nationality" name="nationality" nameKey="AO_NATIONALITY"
                                                initSelectedKey="${customerAccountOpenInfoEntity.nationality}"
                                                clazz="form-control"/>
                                    <c:choose>
                                        <c:when test="${customerAccountOpenInfoEntity.nationality == 'OTH'}">
                                            <input id = "otherNationality" name="otherNationality" type="text" class="form-control"
                                                   value="${customerAccountOpenInfoEntity.otherNationality}"
                                                   placeholder="选择其它国家/地区时填写"/>
                                        </c:when>
                                        <c:otherwise>
                                            <input id = "otherNationality" name="otherNationality" type="text" class="form-control"
                                                   placeholder="选择其它国家/地区时填写" style="display: none"/>
                                        </c:otherwise>
                                    </c:choose>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">证件号</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input name="idNo" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.idNo}"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6" style="display: none">
                            <label class="col-sm-3 control-label no-padding-right">证件生效期</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="idCardValidDateStart" name="idCardValidDateStart" type="text"
                                           class="form-control"
                                           value="${customerAccountOpenInfoEntity.idCardValidDateStart}"/>
                                </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">证件有效期至</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="idCardValidDateEnd" name="idCardValidDateEnd" type="text"
                                           class="form-control"
                                           value="${customerAccountOpenInfoEntity.idCardValidDateEnd}"/>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">民族</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input name="nation" type="nation" class="form-control"
                                           value="${customerAccountOpenInfoEntity.nation}"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">签发机关</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="signingOrganization" name="signingOrganization" type="text"
                                           class="form-control"
                                           value="${customerAccountOpenInfoEntity.signingOrganization}"/>
                                </span>
                            </div>
                        </div>
                    </div>

                    <%--<div class="row">--%>
                        <!--cubp迭代14.3需求：SZCA开户，去掉银行名称-->
                        <%--<div class="form-group col-sm-6 col-md-6">--%>
                            <%--<label class="col-sm-2 control-label no-padding-right">银行名称</label>--%>
                            <%--<div class="col-xs-9">--%>
                                <%--<span class="col-xs-12 block input-icon input-icon-right">--%>
                                    <%--<tag:select name="bankId" nameKey="AO_BANK_CHINA" isAddDefaltOption="true"--%>
                                                <%--initSelectedKey="${customerAccountOpenInfoEntity.bankId}"--%>
                                                <%--clazz="form-control"/>--%>
                                <%--</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>


                    <%--</div>--%>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">账户类型</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-12 block input-icon input-icon-right">
                                             <input name="fundAccountType" type="radio" value="1"
                                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==1}">checked</c:if>  /> 现金账户
                                             <input name="fundAccountType" type="radio" value="2"
                                                    <c:if test="${customerAccountOpenInfoEntity.fundAccountType==2}">checked</c:if> /> 融资账户
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
                                          />

                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-12 col-md-12">
                            <label class="col-sm-1 control-label no-padding-right">证件地址</label>
                            <div class="col-xs-11">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input name="idCardAddress" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.idCardAddress}"/>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-12 col-md-12">
                            <label class="col-sm-1 control-label no-padding-right">现时住址</label>
                            <div class="col-xs-11">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                <input name="familyProvinceName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyProvinceName}"/>
                                <input name="familyCityName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyCityName}"/>
                                <input name="familyCountyName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.familyCountyName}"/>
                                <input name="familyDetailAddress" type="text"
                                       class="form-control" style="display: inline;width: 54%"
                                       value="${customerAccountOpenInfoEntity.familyDetailAddress}"/>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-12 col-md-12">
                            <label class="col-sm-1 control-label no-padding-right">通讯地址</label>
                            <div class="col-xs-11">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                <input name="contactProvinceName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.contactProvinceName}"/>
                                <input name="contactCityName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.contactCityName}"/>
                                <input name="contactCountyName" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${customerAccountOpenInfoEntity.contactCountyName}"/>
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="display: inline;width: 54%"
                                       value="${customerAccountOpenInfoEntity.contactDetailAddress}"/>
                                </span>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </c:if>

        <div id="mainContent">
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
                                <button id="reLoadButtonV${i.index}" class="layui-btn layui-btn-small layui-btn-danger"
                                        type="button"
                                        name="reLoadButtonV" value="${imageInfo.id}">改</button>
                                     </span>
                                <!--循环调用方法-->
                                <script type="text/javascript">pictureList("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}", ${i.index});</script>
                            </c:forEach>
                        </div>
                        </br>
                    </div>
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
                                <label class="col-sm-1 control-label"
                                       style="width: 100px;text-align:left;">用户姓名: </label>
                                <span class="col-sm-1 control-label "
                                      style="width: 200px;text-align:left; ">${bankVerityInfo.clientName}</span>
                                <label class="col-sm-1 control-label "
                                       style="width: 100px;text-align:left; ">证件号: </label>
                                <span class="col-sm-1 control-label "
                                      style="width: 200px;text-align:left;">${bankVerityInfo.idNo}</span>
                                <label class="col-sm-1 control-label "
                                       style="width: 100px;text-align:left;">银行卡号:</label>
                                <span class="col-sm-1 control-label "
                                      style="width: 200px;text-align:left;">${bankVerityInfo.bankCard}</span>
                                <label class="col-sm-1 control-label "
                                       style="width: 100px;text-align:left;">证券帐户预留手机号:</label>
                                <span class="col-sm-1 control-label "
                                      style="width: 200px;text-align:left;">${bankVerityInfo.phoneNumber}</span>
                            </div>
                            <div class="form-group col-sm-12 col-md-12">
                                <label class="col-sm-1 control-label "
                                       style="width: 100px;text-align:left;">校验时间:</label>
                                <span class="col-sm-1 control-label"
                                      style="width: 200px;text-align:left;"><fmt:formatDate
                                        value="${bankVerityInfo.verityTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                <label class="col-sm-1 control-label" style="width: 100px;text-align:left;">校验方:</label>
                                <span class="col-sm-1 control-label" style="width: 200px;text-align:left;">CFCA</span>
                                <label class="col-sm-1 control-label"
                                       style="width: 100px;text-align:left;">校验次数:</label>
                                <span class="col-sm-1 control-label"
                                      style="width: 200px;text-align:left;">${bankVerityInfo.verifyCount}</span>
                                <label class="col-sm-1 control-label"
                                       style="width: 100px;text-align:left;">校验结果: </label>
                                <span class="col-sm-1 control-label"
                                      style="width: 200px;text-align:left;">
                                     <span class="col-sm-1 control-label"
                                           style="width: 200px;text-align:left;">
                                <c:if test="${bankVerityInfo.verifyStatus==0}">不通过</c:if>
                                <c:if test="${bankVerityInfo.verifyStatus==1}">通过</c:if>
                            </span>
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
                        <span class="col-xs-12 block input-icon input-icon-right">
                            <tag:select nameKey="AO_PROFESSION_CODE" id="professionCode" name="professionCode"
                                        initSelectedKey="${customerAccountOpenInfoEntity.professionCode}"
                                        clazz="form-control"
                            />

                        </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">所属行业</label>
                        <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right">
                            <tag:select initSelectedKey="${customerAccountOpenInfoEntity.professionType}"
                                        nameKey="AO_OCCUPATION_TYPE"
                                        name="professionType" isAddDefaltOption="true" clazz="form-control"
                                        initCludeKey="29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,47,48,49,50"
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
                                          clazz="display:inline"/>
                        </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">公司名称</label>
                        <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right">
                            <input id="companyName" name="companyName" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.companyName}"/>
                        </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">职位级别</label>
                        <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right">
                        <tag:select nameKey="AO_JOB_POSITION" id="jobPosition" name="jobPosition"
                                    isAddDefaltOption="true"
                                    initSelectedKey="${customerAccountOpenInfoEntity.jobPosition}"
                                    clazz="form-control"/>
                        </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-1 control-label no-padding-right">公司地址</label>
                        <div class="col-xs-11">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input id="companyAddress" name="companyAddress" type="text" class="form-control"
                                       value="${customerAccountOpenInfoEntity.companyAddress}"/>
                            </span>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <%--</form>--%>
        <div id="div4" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">财务与投资状况</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">全年收入</label>
                        <div class="col-xs-9">
                        <span class="col-xs-9 block input-icon input-icon-right">
                                            <tag:select nameKey="AO_INCOME" id="annualIncome" name="annualIncome"
                                                        isAddDefaltOption="true"
                                                        initSelectedKey="${customerAccountOpenInfoEntity.annualIncome}"
                                                        clazz="form-control"/>
                        </span>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">收入来源</label>
                        <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right" style="width:1000px">

                            <span id="capitalSource0"><input name="capitalSource[]" type="checkbox"
                                                             value="0"/>工资和奖金</span>
                            <span id="capitalSource1"><input name="capitalSource[]" type="checkbox"
                                                             value="1"/>投资回报</span>
                            <span id="capitalSource3"><input name="capitalSource[]" type="checkbox"
                                                                value="3" onclick="changePropertyType(this)"/>不动产租金</span>
                            <span id="capitalSource7"><input name="capitalSource[]" type="checkbox"
                                                             value="7"/>兼职收入</span>
                            <span id="capitalSource6"><input name="capitalSource[]" type="checkbox"
                                                             value="6"/>家人给予</span>
                            <span id="capitalSource2"><input name="capitalSource[]" type="checkbox"
                                                             value="2"/>劳务报酬</span>
                            <span id="capitalSource5"><input name="capitalSource[]" type="checkbox"
                                                             value="5"/>退休金</span>
                            <span id="capitalSource4"><input name="capitalSource[]" type="checkbox"
                                                             value="4"/>营业收入</span>
                            <span id="capitalSource8"><input name="capitalSource[]" type="checkbox"
                                                             value="8"/>生产收入</span>
                            <%--<tag:checkbox name="capitalSource[]" nameKey="AO_CAPITAL_SOURCE" initCheckKey="${customerAccountOpenInfoEntity.capitalSource}" ></tag:checkbox>--%>
                        </span>
                        </div>
                    </div>
                </div>

                <div id="propertyInfoForm">
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">财产种类</label>

                            <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right" style="width:1000px">

                                 <c:forEach begin="0" end="2" step="1" var="i">
                                                <span>
                                                    <input style="display: inline;" name="propertyType[]"
                                                           type="checkbox"
                                                           value="${i+1}"
                                                            <c:forEach items="${openAccountPropertyList}"
                                                                       var="openAccountPropertyType">
                                                                <c:if test="${openAccountPropertyType.propertyType == i+1}">
                                                                    checked
                                                                </c:if>
                                                            </c:forEach>
                                                    /> ${fns:getCodeName("AO_PROPERTY_TYPE",i+1)}
                                                   <c:if test="${fn:contains(propertyStr,i+1)}">
                                                       <c:forEach items="${openAccountPropertyList}" var="propertyInfo">
                                                           <c:if test="${propertyInfo.propertyType == i+1}">
                                                               <tag:select name="propertyAmount[]"
                                                                           nameKey="AO_PROPERTY_TYPE_${i+1}"
                                                                           clazz="form-control"
                                                                           style="width:150px;display:inline"
                                                                           initSelectedKey="${propertyInfo.propertyAmount}"
                                                                           isAddDefaltOption="true"/>港币
                                                           </c:if>
                                                       </c:forEach>
                                                   </c:if>
                                                      <c:if test="${!fn:contains(propertyStr,i+1)}">
                                                          <tag:select name="propertyAmount[]"
                                                                      nameKey="AO_PROPERTY_TYPE_${i+1}"
                                                                      clazz="form-control"
                                                                      style="width:150px;display:inline"
                                                                      isAddDefaltOption="true"/>港币
                                                      </c:if>
                                     <span style="width:20px;">&nbsp;&nbsp;&nbsp;</span>
                                 </c:forEach>
                                 
                            </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">投资目标</label>
                        <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right" style="width:1000px">
                         	<tag:checkbox nameKey="AO_INVEST_TARGET" id="investTarget" name="investTarget[]"
                                          initCheckKey="${customerAccountOpenInfoEntity.investTarget}"
                                          clazz="display:inline" initDidableKey="2,3"/>
                            <input class="form-control " style="width: 200px;display: inline"
                                   id="investTargetOther"
                                   name="investTargetOther" type="text"
                                   value="${customerAccountOpenInfoEntity.investTargetOther}"/>
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
                                <tag:select nameKey="AO_STOCKS_INVESTMENT_EXPERIENCE_TYPE" isAddDefaltOption="true"
                                            id="stocksInvestmentExperienceType" name="stocksInvestmentExperienceType"
                                            initSelectedKey="${customerAccountOpenInfoEntity.stocksInvestmentExperienceType}"
                                            clazz="form-control " style="width:120px;display:inline"/>

                            <span style="margin-left:20px;">认股证/股票期权</span>
                                 <tag:select nameKey="AO_WARRANTS_INVESTMENT_EXPERIENCE_TYPE"
                                             id="warrantsInvestmentExperienceType"
                                             name="warrantsInvestmentExperienceType" isAddDefaltOption="true"
                                             initSelectedKey="${customerAccountOpenInfoEntity.warrantsInvestmentExperienceType}"
                                             clazz="form-control" style="width:120px;display:inline"/>

                            <span style="margin-left:20px;">期货/期权</span>
                                <tag:select nameKey="AO_FUTURES_INVESTMENT_EXPERIENCE_TYPE" isAddDefaltOption="true"
                                            id="futuresInvestmentExperienceType" name="futuresInvestmentExperienceType"
                                            initSelectedKey="${customerAccountOpenInfoEntity.futuresInvestmentExperienceType}"
                                            clazz="form-control" style="width:120px;display:inline"/>
                        </span>
                        </div>
                    </div>
                </div>

                <%--<div class="row">--%>
                    <%--<div class="form-group col-sm-6 col-md-6">--%>
                        <%--<label class="col-sm-2 control-label no-padding-right">风险承受程度</label>--%>
                        <%--<div class="col-xs-9">--%>
                        <%--<span class="col-xs-12 block input-icon input-icon-right">--%>
                             <%--<input type="radio" name="acceptRisk"--%>
                                    <%--value="1" <c:if--%>
                                     <%--test="${customerAccountOpenInfoEntity.acceptRisk==1}"> checked="checked"</c:if> />低风险--%>
                             <%--<input type="radio" name="acceptRisk"--%>
                                    <%--value="2" <c:if--%>
                                     <%--test="${customerAccountOpenInfoEntity.acceptRisk==2}"> checked="checked"</c:if>  />中风险--%>
                            <%--<input type="radio" name="acceptRisk"--%>
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
                        <span class="col-xs-12 block input-icon input-icon-right">
                             <input type="radio" name="isKnowDerivativeProducts" onclick="canWrite();"
                                    value="1" <c:if
                                     test="${customerAccountOpenInfoEntity.isKnowDerivativeProducts==1}"> checked="checked"</c:if> />是
                             <input type="radio" name="isKnowDerivativeProducts" onclick="canRead();"
                                    value="0" <c:if
                                     test="${customerAccountOpenInfoEntity.isKnowDerivativeProducts==0}"> checked="checked"</c:if>  />否
                        </span>
                    </div>
                </div>

                <div id="isKnowProducts">
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-12 control-label no-padding-right">请选择您接收衍生产品相关的培训或课程的方式</label>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <c:forEach var="investTargetCodeEntity"
                                           items="${fns:getCodeInfoByParentMark('AO_DERIVATIVE_PRODUCTS_STUDY_TYPE')}"
                                           varStatus="i">
                                    <c:if test="${customerAccountOpenInfoEntity.derivativeProductsStudyType== investTargetCodeEntity.value}">
                                        <input type="radio" name="derivativeProductsStudyType"
                                               value="${investTargetCodeEntity.value}" checked="true"
                                        />${investTargetCodeEntity.name}
                                    </c:if>
                                    <c:if test="${customerAccountOpenInfoEntity.derivativeProductsStudyType != investTargetCodeEntity.value}">
                                        <input type="radio" name="derivativeProductsStudyType"
                                               value="${investTargetCodeEntity.value}"
                                        />${investTargetCodeEntity.name}
                                    </c:if>
                                </c:forEach>

                                <input class="form-control" style="width:100px;display: inline"
                                       id="derivativeProductsStudyTypeOther" name="derivativeProductsStudyTypeOther"
                                       type="text"
                                        <c:if test="${customerAccountOpenInfoEntity.derivativeProductsStudyType == 7}">
                                            value="${customerAccountOpenInfoEntity.derivativeProductsStudyTypeOther}"
                                        </c:if>
                                />

                            </span>
                        </div>

                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-12 control-label no-padding-right">您在经纪公司或银行，基金或资产管理公司，监管机构或交易所等金融机构拥有以下工作经验</label>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <c:forEach var="investTargetCodeEntity"
                                           items="${fns:getCodeInfoByParentMark('AO_FINANCING_INSTITUTION_WORK_EXPERIENCE_TYPE')}"
                                           varStatus="i">
                                    <c:if test="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType== investTargetCodeEntity.value}">
                                        <input type="radio" name="financingInstitutionWorkExperienceType"
                                               value="${investTargetCodeEntity.value}" checked="true"
                                               financingInstitutionWorkExperienceType
                                        />${investTargetCodeEntity.name}
                                    </c:if>
                                    <c:if test="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType != investTargetCodeEntity.value}">
                                        <input type="radio" name="financingInstitutionWorkExperienceType"
                                               value="${investTargetCodeEntity.value}"
                                        />${investTargetCodeEntity.name}
                                    </c:if>
                                </c:forEach>

                                <input class="form-control" style="width:100px;display: inline"
                                       id="financingInstitutionWorkExperienceTypeOther"
                                       name="financingInstitutionWorkExperienceTypeOther" type="text"
                                        <c:if test="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType == 4}">
                                            value="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceTypeOther}"
                                        </c:if>
                                       style="width:200px; margin-left:25px; height:34px;"/>

                            </span>
                        </div>

                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-12 control-label no-padding-right">您在过去三年是否曾进行过至少五次任何衍生产品的交易（不论是否在交易所买卖）</label>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                  <input type="radio" name="isTradedDerivativeProducts"
                                         value="1"
                                         <c:if test="${customerAccountOpenInfoEntity.isTradedDerivativeProducts == 1}">checked="true"</c:if>
                                  />是
                                  <input type="radio" name="isTradedDerivativeProducts"
                                         value="0"
                                         <c:if test="${customerAccountOpenInfoEntity.isTradedDerivativeProducts == 0}">checked="true"</c:if>
                                  />否
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>


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
                                           value="1"
                                           <c:if test="${customerAccountOpenInfoEntity.isAllowProvidePrivacy == 1}">checked="checked"</c:if>
                                    />是
                                    <input type="radio" name="isAllowProvidePrivacy"
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
                                    <input type="radio" name="northTrade"
                                           value="1"
                                           <c:if test="${customerAccountOpenInfoEntity.northTrade == 1}">checked="checked"</c:if>
                                    />是
                                    <input type="radio" name="northTrade"
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
                                    <input type="radio" name="FATCA"
                                           value="1" onclick="chooseFATCA();"
                                           <c:if test="${customerAccountOpenInfoEntity.fatca == 1}">checked="checked"</c:if>
                                    />是
                                    <input type="radio" name="FATCA"
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
                                <td class="col-sm-3">司法管辖区</td>
                                <td class="col-sm-3">税务编号</td>
                                <td class="col-sm-3">如没有提供税务编号，请选择理由</td>
                                <td class="col-sm-3"> 如选择理由B，请解释原因</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <c:if test="${taxInformationList!=null}">
                <c:forEach begin="0" end="4" step="1" var="i">
                <div class="row">
                    <div class="form-group col-sm-3 col-md-3">
                        <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" name="taxCountry[]"
                                               value="${taxInformationList[i].taxCountry}"
                                               class="form-control">
                                    </span>
                        </div>
                    </div>
                    <div class="form-group col-sm-3 col-md-3">
                        <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" name="taxNumber[]" value="${taxInformationList[i].taxNumber}"
                                               class="form-control">
                                    </span>
                        </div>
                    </div>
                    <div class="form-group col-sm-3 col-md-3">
                        <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <select name="reasonType[]" class="form-control">
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
                    <div class="form-group col-sm-3 col-md-3">
                        <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" name="reasonDesc[]"
                                               value="${taxInformationList[i].reasonDesc}"
                                               class="form-control">
                                    </span>
                        </div>
                    </div>
                </div>

                </c:forEach>
                </c:if>

        </div>
    </div>


    <form id="otherInfoForm">
        <div id="div7" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">身份资料申报</b></div>
                </br>

                <c:forEach items="${openAccountOtherDisclosureList}" var="openAccountOther" varStatus="i">
                    <c:choose>
                        <c:when test="${openAccountOther.disclosureCode ==16}">
                            <label class="control-label no-padding-right">
                                <input id="mustSure1" name="disclosureFlag_${openAccountOther.disclosureCode}"
                                       type="checkbox" value="openAccountOther.disclosureIsTrue"
                                       <c:if test="${openAccountOther.disclosureIsTrue==1}">checked="checked"</c:if>
                                />${fns:getCodeName("AO_DISCLOSURE_CODE",openAccountOther.disclosureCode)}
                            </label>
                        </c:when>
                        <c:otherwise>
                            <div class="row">
                                <div class="form-group col-sm-6 col-md-6">
                                    <label class="col-sm-12 control-label no-padding-right">${fns:getCodeName("AO_DISCLOSURE_CODE",openAccountOther.disclosureCode)}</label>
                                </div>
                                <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-12 block input-icon input-icon-right">
                            <input type="text" style="display: none;"
                                   id="disclosureCode_${openAccountOther.disclosureCode}"
                                   value="${openAccountOther.disclosureCode}"/>
                            <input type="radio" name="disclosureFlag_${openAccountOther.disclosureCode}"
                                   <c:if test="${openAccountOther.disclosureIsTrue==1}">checked="checked"</c:if>
                                   value="1"/>是
                            <input type="radio" name="disclosureFlag_${openAccountOther.disclosureCode}"
                                   <c:if test="${openAccountOther.disclosureIsTrue==0}">checked="checked"</c:if>
                                   value="0"/>否
                        </span>
                                </div>
                            </div>
                            <div id="otherInfoDetail_${openAccountOther.disclosureCode}" class="row"
                                 style="margin-left: 20px">
                                <table id="table_${openAccountOther.disclosureCode}">
                                </table>
                            </div>
                            <c:if test="${openAccountOther.disclosureCode ==1 || openAccountOther.disclosureCode ==2
                    || openAccountOther.disclosureCode ==3 || openAccountOther.disclosureCode >10}">
                                <div id="options" style="margin-left: 850px;margin-top: 10px">
                                    <button class="layui-btn layui-btn-small" type="button"
                                            onclick="addRow(${openAccountOther.disclosureCode})">
                                        <i class="layui-icon">&#xe654;</i>继续添加
                                    </button>
                                </div>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
        </div>
    </form>

    <div class="row">
        <div class="form-group col-sm-8 ">
            <label class="control-label col-sm-2" style="padding-left: 45px;">审批意见</label>
            <div class="col-sm-10">
                <div class="form-group">
                    <textarea name="remark" id="remark" class="form-control" rows="3"></textarea>
                </div>
            </div>
        </div>
    </div>

    <div v-cloak align="center">
        <button type="button" id="formSubmit" class="layui-btn" onclick="infoSubmit();">提交</button>
        <shiro:hasPermission name="customerAcc:doRecheck">
            <button class="layui-btn layui-btn-warm" type="button" onclick="submitDoRecheck()">转入复审</button>
        </shiro:hasPermission>
    </div>
</div>
</body>

<script type="text/javascript">

    $(function () {
        $('#imageList').viewer();
        initFreelanceOther('${customerAccountOpenInfoEntity.freelanceOther}');
        //初始化职业类型，收入来源
        onChangeProfessionCode('${customerAccountOpenInfoEntity.professionCode}', '${customerAccountOpenInfoEntity.capitalSource}');
        <c:forEach var="obj" items="${openAccountOtherDisclosureList}">
        initOtherDisclosureDetail('${obj.disclosure1}', '${obj.disclosure2}', '${obj.disclosure3}', '${obj.disclosure4}', ${obj.disclosureCode});
        </c:forEach>
    });
    $("#professionCode").change(function () {
        onChangeProfessionCode($("#professionCode").val(), "");
    });

    $("#nationality").change(function () {
        var nationality = $("#nationality").val();
        if("OTH"==nationality){
            $("#otherNationality").val('');
            $("#otherNationality").css("display", "inline");
        }else{
            $("#otherNationality").css("display", "none");
        }
    });

    /**
     * 自由职业其他说明项
     * */
    function initFreelanceOther(freelanceOther){
        $("#freelanceCode").append('<input class="form-control " style="width: 500px;display: inline" id="freelanceOther" ' +
            'name="freelanceOther" placeholder="不多于30个字符" type="text" value="'+freelanceOther+'"/>');
    }

    /*
    * 增加一行
    */
    function addRow(disclosureCode) {

        var table_name = "table_" + disclosureCode;
        var table = document.getElementById(table_name);
        var row_index = table.rows.length;
        row_index++;
        if (row_index > 5) {
            alertMsg("该项目最多允许5项");
            return;
        }

        switch (disclosureCode) {
            case 1:
            case 2:
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>姓名：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                var new_col = new_row.insertCell(2);
                new_col.innerHTML = "&nbsp;<span> 地址/关系：</span>";
                var new_col = new_row.insertCell(3);
                new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                break;
            case 3:
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>姓名：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                break;
            case 11:
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>所在职位：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                break;
            case 12:
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>亲属姓名：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                var new_col = new_row.insertCell(2);
                new_col.innerHTML = "&nbsp;<span>与本人之关系：</span>";
                var new_col = new_row.insertCell(3);
                new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                break;
            case 13:
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>公司名称：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                var new_col = new_row.insertCell(2);
                new_col.innerHTML = "&nbsp;<span>职位：</span>";
                var new_col = new_row.insertCell(3);
                new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                break;
            case 14:
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>监管机构名称：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                var new_col = new_row.insertCell(2);
                new_col.innerHTML = "&nbsp;<span>国家/地区：</span>";
                var new_col = new_row.insertCell(3);
                new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                break;
            case 15:
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>公司机构名称：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                var new_col = new_row.insertCell(2);
                new_col.innerHTML = "&nbsp;<span>职位：</span>";
                var new_col = new_row.insertCell(3);
                new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                var new_col = new_row.insertCell(4);
                new_col.innerHTML = "<span>交易所/市场：</span>";
                var new_col = new_row.insertCell(5);
                new_col.innerHTML = "<input type='text' id='disclosure3_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                var new_col = new_row.insertCell(6);
                new_col.innerHTML = "&nbsp;<span>股份代码：</span>";
                var new_col = new_row.insertCell(7);
                new_col.innerHTML = "<input type='text' id='disclosure4_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                break;
            default:
                return;
        }
        var new_col = new_row.insertCell(new_row.length);
        new_col.innerHTML = "&nbsp;<button class='layui-btn layui-btn-danger layui-btn-mini' type='button'" +
            "onclick='deleteRow(this.parentNode.offsetParent.id,this.parentNode.parentNode.rowIndex)'> " +
            "<i class='layui-icon'>&#x1006;</i>删除</button>";
    }

    /*
    * 删除一行
    */
    function deleteRow(table_name, rowIndex) {
        var table = document.getElementById(table_name);
        table.deleteRow(rowIndex);
    }

    function onChangeProfessionCode(professionCode, capitalSource) {
        //初始化勾选值
        if (capitalSource != "") {
            $(capitalSource.toString().split(",")).each(function (i, value) {
                $("input[name='capitalSource[]'][value='" + value + "']").prop("checked", true);
            });
        }
        if(professionCode == "4"){
            $("#freelanceDiv").css("display", "inline");
        } else{
            $("#freelanceDiv").css("display", "none");
            $('input[type=radio][name="freelanceCode"]:checked').removeAttr('checked').attr("checked", false);
            $("#freelanceOther").val('');
        }
        var noCheck = "";
        if (professionCode == "1")//受雇
        {
            //显示工资和奖金、投资回报、劳务报酬、不动产租金
            $("#capitalSource0").css("display", "inline");
            $("#capitalSource1").css("display", "inline");
            $("#capitalSource2").css("display", "inline");
            $("#capitalSource3").css("display", "inline");

            //隐藏
            noCheck = "4,5,6,7,8";
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
            noCheck = "0,5,6,7,8";
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
            noCheck = "0,2,4,5,8";
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
            noCheck = "0,4,5,6,7";
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
            noCheck = "0,4,7,8";
            $("#capitalSource0").css("display", "none");
            $("#capitalSource4").css("display", "none");
            $("#capitalSource7").css("display", "none");
            $("#capitalSource8").css("display", "none");
        }
        //把隐藏的设置为不勾选
        $(noCheck.toString().split(",")).each(function (i, value) {
            $("input[name='capitalSource[]'][value='" + value + "']").prop("checked", false);
        });

    }

    function initOtherDisclosureDetail(disclosure1, disclosure2, disclosure3, disclosure4, disclosureCode) {
        if (disclosure1 == '' && disclosure2 == '' && disclosure3 == '' && disclosure4 == '') {
            return;
        }
        var table_name = "table_" + disclosureCode;
        var table = document.getElementById(table_name);
        var row_index = table.rows.length;
        switch (disclosureCode) {
            case 1:
                var filed1 = disclosure1.toString().split(",");
                var filed2 = disclosure2.toString().split(",");
                var length = Math.max(filed1.length, filed2.length);
                for (var i = 0; i < length; i++) {
                    if (typeof(filed1[i]) == "undefined") {
                        filed1[i] = "";
                    }
                    if (typeof(filed2[i]) == "undefined") {
                        filed2[i] = "";
                    }
                    row_index++;
                    var new_row = table.insertRow(table.rows.length);
                    new_row.setAttribute("id", "row" + row_index);
                    var new_col = new_row.insertCell(0);
                    new_col.innerHTML = "<span>姓名：</span>";
                    var new_col = new_row.insertCell(1);
                    new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed1[i] + "'>";
                    var new_col = new_row.insertCell(2);
                    new_col.innerHTML = "&nbsp;<span>地址/关系：</span>";
                    var new_col = new_row.insertCell(3);
                    new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed2[i] + "'>";
                    var new_col = new_row.insertCell(new_row.length);
                    new_col.innerHTML = "&nbsp;<button class='layui-btn layui-btn-danger layui-btn-mini' type='button'" +
                        "onclick='deleteRow(this.parentNode.offsetParent.id,this.parentNode.parentNode.rowIndex)'> " +
                        "<i class='layui-icon'>&#x1006;</i>删除</button>";
                }
                break;
            case 2:
                var filed1 = disclosure1.toString().split(",");
                var filed2 = disclosure2.toString().split(",");
                var length = Math.max(filed1.length, filed2.length);
                for (var i = 0; i < length; i++) {
                    if (typeof(filed1[i]) == "undefined") {
                        filed1[i] = "";
                    }
                    if (typeof(filed2[i]) == "undefined") {
                        filed2[i] = "";
                    }
                    row_index++;
                    var new_row = table.insertRow(table.rows.length);
                    new_row.setAttribute("id", "row" + row_index);
                    var new_col = new_row.insertCell(0);
                    new_col.innerHTML = "<span>姓名：</span>";
                    var new_col = new_row.insertCell(1);
                    new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed1[i] + "'>";
                    var new_col = new_row.insertCell(2);
                    new_col.innerHTML = "&nbsp;<span>地址/关系：</span>";
                    var new_col = new_row.insertCell(3);
                    new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed2[i] + "'>";
                    var new_col = new_row.insertCell(new_row.length);
                    new_col.innerHTML = "&nbsp;<button class='layui-btn layui-btn-danger layui-btn-mini' type='button'" +
                        "onclick='deleteRow(this.parentNode.offsetParent.id,this.parentNode.parentNode.rowIndex)'> " +
                        "<i class='layui-icon'>&#x1006;</i>删除</button>";
                }
                break;
            case 3:
                var filed1 = disclosure1.toString().split(",");
                for (var i = 0; i < filed1.length; i++) {
                    if (typeof(filed1[i]) == "undefined") {
                        filed1[i] = "";
                    }
                    row_index++;
                    var new_row = table.insertRow(table.rows.length);
                    new_row.setAttribute("id", "row" + row_index);
                    var new_col = new_row.insertCell(0);
                    new_col.innerHTML = "<span>姓名：</span>";
                    var new_col = new_row.insertCell(1);
                    new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed1[i] + "'>";
                    var new_col = new_row.insertCell(new_row.length);
                    new_col.innerHTML = "&nbsp;<button class='layui-btn layui-btn-danger layui-btn-mini' type='button'" +
                        "onclick='deleteRow(this.parentNode.offsetParent.id,this.parentNode.parentNode.rowIndex)'> " +
                        "<i class='layui-icon'>&#x1006;</i>删除</button>";
                }
                break;
            case 11:
                var filed1 = disclosure1.toString().split(",");
                for (var i = 0; i < filed1.length; i++) {
                    if (typeof(filed1[i]) == "undefined") {
                        filed1[i] = "";
                    }
                    row_index++;
                    var new_row = table.insertRow(table.rows.length);
                    new_row.setAttribute("id", "row" + row_index);
                    var new_col = new_row.insertCell(0);
                    new_col.innerHTML = "<span>所在职位：</span>";
                    var new_col = new_row.insertCell(1);
                    new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed1[i] + "'>";
                    var new_col = new_row.insertCell(new_row.length);
                    new_col.innerHTML = "&nbsp;<button class='layui-btn layui-btn-danger layui-btn-mini' type='button'" +
                        "onclick='deleteRow(this.parentNode.offsetParent.id,this.parentNode.parentNode.rowIndex)'> " +
                        "<i class='layui-icon'>&#x1006;</i>删除</button>";
                }
                break;
            case 12:
                var filed1 = disclosure1.toString().split(",");
                var filed2 = disclosure2.toString().split(",");
                var length = Math.max(filed1.length, filed2.length);
                for (var i = 0; i < length; i++) {
                    if (typeof(filed1[i]) == "undefined") {
                        filed1[i] = "";
                    }
                    if (typeof(filed2[i]) == "undefined") {
                        filed2[i] = "";
                    }
                    row_index++;
                    var new_row = table.insertRow(table.rows.length);
                    new_row.setAttribute("id", "row" + row_index);
                    var new_col = new_row.insertCell(0);
                    new_col.innerHTML = "<span>亲属姓名：</span>";
                    var new_col = new_row.insertCell(1);
                    new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed1[i] + "'>";
                    var new_col = new_row.insertCell(2);
                    new_col.innerHTML = "&nbsp;<span>与本人之关系：</span>";
                    var new_col = new_row.insertCell(3);
                    new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed2[i] + "'>";
                    var new_col = new_row.insertCell(new_row.length);
                    new_col.innerHTML = "&nbsp;<button class='layui-btn layui-btn-danger layui-btn-mini' type='button'" +
                        "onclick='deleteRow(this.parentNode.offsetParent.id,this.parentNode.parentNode.rowIndex)'> " +
                        "<i class='layui-icon'>&#x1006;</i>删除</button>";
                }
                break;
            case 13:
                var filed1 = disclosure1.toString().split(",");
                var filed2 = disclosure2.toString().split(",");
                if (typeof(filed1[i]) == "undefined") {
                    filed1[i] = "";
                }
                if (typeof(filed2[i]) == "undefined") {
                    filed2[i] = "";
                }
                var length = Math.max(filed1.length, filed2.length);
                for (var i = 0; i < length; i++) {
                    row_index++;
                    var new_row = table.insertRow(table.rows.length);
                    new_row.setAttribute("id", "row" + row_index);
                    var new_col = new_row.insertCell(0);
                    new_col.innerHTML = "<span>公司名称：</span>";
                    var new_col = new_row.insertCell(1);
                    new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed1[i] + "'>";
                    var new_col = new_row.insertCell(2);
                    new_col.innerHTML = "&nbsp;<span>职位：</span>";
                    var new_col = new_row.insertCell(3);
                    new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed2[i] + "'>";
                    var new_col = new_row.insertCell(new_row.length);
                    new_col.innerHTML = "&nbsp;<button class='layui-btn layui-btn-danger layui-btn-mini' type='button'" +
                        "onclick='deleteRow(this.parentNode.offsetParent.id,this.parentNode.parentNode.rowIndex)'> " +
                        "<i class='layui-icon'>&#x1006;</i>删除</button>";
                }
                break;
            case 14:
                var filed1 = disclosure1.toString().split(",");
                var filed2 = disclosure2.toString().split(",");
                if (typeof(filed1[i]) == "undefined") {
                    filed1[i] = "";
                }
                if (typeof(filed2[i]) == "undefined") {
                    filed2[i] = "";
                }
                var length = Math.max(filed1.length, filed2.length);
                for (var i = 0; i < length; i++) {
                    row_index++;
                    var new_row = table.insertRow(table.rows.length);
                    new_row.setAttribute("id", "row" + row_index);
                    var new_col = new_row.insertCell(0);
                    new_col.innerHTML = "<span>监管机构名称：</span>";
                    var new_col = new_row.insertCell(1);
                    new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed1[i] + "'>";
                    var new_col = new_row.insertCell(2);
                    new_col.innerHTML = "&nbsp;<span>国家/地区：</span>";
                    var new_col = new_row.insertCell(3);
                    new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed2[i] + "'>";
                    var new_col = new_row.insertCell(new_row.length);
                    new_col.innerHTML = "&nbsp;<button class='layui-btn layui-btn-danger layui-btn-mini' type='button'" +
                        "onclick='deleteRow(this.parentNode.offsetParent.id,this.parentNode.parentNode.rowIndex)'> " +
                        "<i class='layui-icon'>&#x1006;</i>删除</button>";
                }
                break;
            case 15:
                var filed1 = disclosure1.toString().split(",");
                var filed2 = disclosure2.toString().split(",");
                var filed3 = disclosure3.toString().split(",");
                var filed4 = disclosure4.toString().split(",");
                if (typeof(filed1[i]) == "undefined") {
                    filed1[i] = "";
                }
                if (typeof(filed2[i]) == "undefined") {
                    filed2[i] = "";
                }
                if (typeof(filed3[i]) == "undefined") {
                    filed3[i] = "";
                }
                if (typeof(filed4[i]) == "undefined") {
                    filed4[i] = "";
                }
                var length = Math.max(Math.max(filed1.length, filed2.length), Math.max(filed3.length, filed4.length));
                for (var i = 0; i < length; i++) {
                    row_index++;
                    var new_row = table.insertRow(table.rows.length);
                    new_row.setAttribute("id", "row" + row_index);
                    var new_col = new_row.insertCell(0);
                    new_col.innerHTML = "<span>公司机构名称：</span>";
                    var new_col = new_row.insertCell(1);
                    new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed1[i] + "'>";
                    var new_col = new_row.insertCell(2);
                    new_col.innerHTML = "&nbsp;<span>职位：</span>";
                    var new_col = new_row.insertCell(3);
                    new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed2[i] + "'>";
                    var new_col = new_row.insertCell(4);
                    new_col.innerHTML = "<span>交易所/市场：</span>";
                    var new_col = new_row.insertCell(5);
                    new_col.innerHTML = "<input type='text' id='disclosure3_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed3[i] + "'>";
                    var new_col = new_row.insertCell(6);
                    new_col.innerHTML = "&nbsp;<span>股份代码：</span>";
                    var new_col = new_row.insertCell(7);
                    new_col.innerHTML = "<input type='text' id='disclosure4_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'" +
                        "value='" + filed4[i] + "'>";
                    var new_col = new_row.insertCell(new_row.length);
                    new_col.innerHTML = "&nbsp;<button class='layui-btn layui-btn-danger layui-btn-mini' type='button'" +
                        "onclick='deleteRow(this.parentNode.offsetParent.id,this.parentNode.parentNode.rowIndex)'> " +
                        "<i class='layui-icon'>&#x1006;</i>删除</button>";
                }
                break;
            default:
                return;
        }

    }


    function infoSubmit() {
        var openAccountInfo = $('#basicInfoForm').serializeJSON();
        if (openAccountInfo['isKnowDerivativeProducts'] == 0) {
            openAccountInfo['derivativeProductsStudyType'] = null;
            openAccountInfo['financingInstitutionWorkExperienceType'] = null;
            openAccountInfo['isTradedDerivativeProducts'] = null;
            openAccountInfo['derivativeProductsStudyTypeOther'] = null;
            openAccountInfo['isTradedDerivativeProducts'] = null;
        }
        //姓名拼接
        openAccountInfo['clientName']=openAccountInfo['familyName']+openAccountInfo['givenName'];
        openAccountInfo['clientNameSpell']=openAccountInfo['familyNameSpell']+openAccountInfo['givenNameSpell'];

        //地址拼接
        openAccountInfo['contactAddress']=openAccountInfo['contactProvinceName']+openAccountInfo['contactCityName']
            +openAccountInfo['contactCountyName']+openAccountInfo['contactDetailAddress'];
        openAccountInfo['familyAddress']=openAccountInfo['familyProvinceName']+openAccountInfo['familyCityName']
            +openAccountInfo['familyCountyName']+openAccountInfo['familyDetailAddress'];

        //其他信息披露  数据拼接 【开始】
        var disclosureCodes = [];
        <c:forEach var="obj" items="${openAccountOtherDisclosureList}">
        disclosureCodes.push(${obj.disclosureCode});
        </c:forEach>
        var otherInfoJsonList = [];
        for (i in disclosureCodes) {
            var disclosureJson = {};
            if (disclosureCodes[i] == 16) {
                disclosureJson.disclosureCode = 16;
                disclosureJson.disclosureIsTrue = 1;
            } else {
                var disclosureCode = 'disclosureCode_' + disclosureCodes[i];
                var disclosureFlag = 'disclosureFlag_' + disclosureCodes[i];
                var code = $("#" + disclosureCode).val();
                var flag = $('input:radio[name=' + disclosureFlag + ']:checked').val();
                disclosureJson.disclosureCode = code;
                var disclosure1 = "";
                var disclosure2 = "";
                var disclosure3 = "";
                var disclosure4 = "";
                var ischeck = false;
                //1,2,3选择否,11,12,13,14,15选择是时需要添加详细信息
                if (flag == 0 && (code == 1 || code == 2 || code == 3)) {
                    ischeck = true;
                }
                if (flag == 1 && (code > 10 && code < 16)) {
                    ischeck = true;
                }
                if (ischeck) {
                    var table_name = "table_" + disclosureCodes[i];
                    var table = document.getElementById(table_name);
                    for (var j = 0; j < table.rows.length; j++) {
                        for (var k = 0; k < table.rows[j].cells.length; k++) {
                            var filed1 = "";
                            var filed2 = "";
                            var filed3 = "";
                            var filed4 = "";
                            var input = table.rows[j].cells[k].getElementsByTagName("input");
                            if (input.length > 0) {
                                switch (k) {
                                    case 1:
                                        filed1 = input[0].value;
                                        break;
                                    case 3:
                                        filed2 = input[0].value;
                                        break;
                                    case 5:
                                        filed3 = input[0].value;
                                        break;
                                    case 7:
                                        filed4 = input[0].value;
                                        break;
                                    default:
                                }
                            }
                            if (typeof(filed1) != "undefined" && filed1 != null && filed1 != '') {
                                disclosure1 += filed1 + ",";
                            }
                            if (typeof(filed2) != "undefined" && filed2 != null && filed2 != '') {
                                disclosure2 += filed2 + ",";
                            }
                            if (typeof(filed3) != "undefined" && filed3 != null && filed3 != '') {
                                disclosure3 += filed3 + ",";
                            }
                            if (typeof(filed4) != "undefined" && filed4 != null && filed4 != '') {
                                disclosure4 += filed4 + ",";
                            }
                        }
                    }
                    var isTrue = false;
                    if (disclosure1 != null && disclosure1 != "") {
                        disclosureJson.disclosure1 = disclosure1.substring(0, disclosure1.length - 1);
                        isTrue = true;
                    }
                    if (disclosure2 != null && disclosure2 != "") {
                        disclosureJson.disclosure2 = disclosure2.substring(0, disclosure2.length - 1);
                        isTrue = true;
                    }
                    if (disclosure3 != null && disclosure3 != "") {
                        disclosureJson.disclosure3 = disclosure3.substring(0, disclosure3.length - 1);
                        isTrue = true;
                    }
                    if (disclosure4 != null && disclosure4 != "") {
                        disclosureJson.disclosure4 = disclosure4.substring(0, disclosure4.length - 1);
                        isTrue = true;
                    }
                    if (code == 1 || code == 2 || code == 3 || (code > 10 && code < 16)) {
                        if (!isTrue) {
                            alertMsg("身份资料申报中有选项需要添加详细信息");
                            return;
                        }
                    }
                }else{
                    //如果选择否，需要清空数据库的值
                    disclosureJson.disclosure1="";
                    disclosureJson.disclosure2="";
                    disclosureJson.disclosure3="";
                    disclosureJson.disclosure4="";
                }
                disclosureJson.disclosureIsTrue = flag;
            }
            otherInfoJsonList.push(disclosureJson)
        }
        openAccountInfo['otherInfo'] = JSON.stringify(otherInfoJsonList);
        //其他信息披露  数据拼接 【结束】

        //收入来源 投资目标 checkBox 处理
        //【开始】
        if (openAccountInfo['capitalSource'] == null) {
            alertMsg("收入来源不可为空!");
            return;
        } else {
            var capitalSource = openAccountInfo['capitalSource'].toString();
            openAccountInfo['capitalSource'] = capitalSource;
        }
        if (openAccountInfo['investTarget'] == null) {
            alertMsg("投资目标不可为空!");
            return;
        } else {
            var investTarget = openAccountInfo['investTarget'].toString();
            openAccountInfo['investTarget'] = investTarget;
        }
//        var acceptRisk = $('input:radio[name="acceptRisk"]:checked').val();
//        if (acceptRisk == null) {
//            alertMsg("风险承受程度不可为空!");
//            return;
//        } else {
//            openAccountInfo['acceptRisk'] = acceptRisk;
//        }
        var northTrade = $('input:radio[name="northTrade"]:checked').val();
        if (northTrade == null) {
            alertMsg("北向交易资料不可为空!");
            return;
        } else {
            openAccountInfo['northTrade'] = northTrade;
        }
        var FATCA = $('input:radio[name="FATCA"]:checked').val();
        if (FATCA == null) {
            alertMsg("FATCA声明不可为空!");
            return;
        } else {
            openAccountInfo['fatca'] = FATCA;
        }
        //【结束】

        //税务信息处理
        //【开始】
        var taxInfo = $('#taxInfoForm').serializeJSON();
        var taxInfoList = [];
        for (var i = 0; i < 5; i++) {
            var taxInfoObject = {};
            if (taxInfo.taxCountry[i] != null && taxInfo.taxCountry[i] != '') {
                taxInfoObject['taxCountry'] = taxInfo.taxCountry[i];
                if (taxInfo.taxNumber[i] != null && taxInfo.taxNumber[i] != '') {
                    taxInfoObject['taxNumber'] = taxInfo.taxNumber[i];
                    taxInfoObject['hasTaxNumber'] = 1;
                    taxInfoList.push(taxInfoObject);
                } else {
                    taxInfoObject['hasTaxNumber'] = 0;
                    if (taxInfo.reasonType[i] != null && taxInfo.reasonType[i] != '') {
                        taxInfoObject['reasonType'] = taxInfo.reasonType[i];
                        if (taxInfoObject['reasonType'] != null && 'B' == taxInfoObject['reasonType']) {
                            taxInfoObject['reasonDesc'] = taxInfo.reasonDesc[i]
                            taxInfoList.push(taxInfoObject);
                        } else {
                            taxInfoList.push(taxInfoObject);
                        }
                    }
                }
            }
        }
        openAccountInfo['taxInfo'] = JSON.stringify(taxInfoList);
        //【结束】

        //财产种类 信息处理
        //【开始】
        var propertyInfo = [];
        if (openAccountInfo.propertyType != null && openAccountInfo.propertyType != '') {
            for (var i = 0; i < 3; i++) {
                var propertyObject = {};
                if (openAccountInfo.propertyType[i] != null && openAccountInfo.propertyType[i] != '') {
                    propertyObject['propertyType'] = openAccountInfo.propertyType[i];

                    var type = parseInt(openAccountInfo.propertyType[i]) - 1;
                    if (openAccountInfo.propertyAmount[type] != null && openAccountInfo.propertyAmount[type] != '') {
                        propertyObject['propertyAmount'] = openAccountInfo.propertyAmount[type];
                        propertyInfo.push(propertyObject);
                    } else {
                        alertMsg("财产金额不能为空 请填写对应的财产金额");
                        return;
                    }
                } else if (openAccountInfo['capitalSource'].indexOf("3") >= 0 && openAccountInfo.propertyType.indexOf("3") == -1) {
                    //收入来源有“不动产租金”的时候，财产种类下“不动产”为必选必填；
                    alertMsg("收入来源含【不动产租金】，财产种类【不动产】 不能为空");
                    return;
                }
            }
        } else {
            alertMsg("财产种类不能为空 请填写财产种类");
            return;
        }
        openAccountInfo['propertyInfo'] = JSON.stringify(propertyInfo);
        //财产种类表单包含在 开户信息form之中 json解析出错 故 剔除不存在的属性
        delete openAccountInfo.propertyType;
        delete openAccountInfo.propertyAmount;
        //【结束】

        openAccountInfo['applicationTime'] = new Date(openAccountInfo['applicationTime']);
        openAccountInfo['isAllowProvidePrivacy'] = $('input[name="isAllowProvidePrivacy"]').filter(':checked').val();
        openAccountInfo['isTradedDerivativeProducts'] = $('input[name="isTradedDerivativeProducts"]').filter(':checked').val();
        openAccountInfo['isAllowProvidePrivacy'] = $('input[name="isAllowProvidePrivacy"]').filter(':checked').val();

        openAccountInfo['isRecheck'] = 0;

        confirm('确定提交', function () {
            if ($("#clientId").val() != null && $("#clientId").val() != '') {
                openAccountInfo['clientId'] = $("#clientId").val();
                $.ajax({
                    url: "${webRoot}/secUserInfo/checkTradeAccount",   //处理页面的名称
                    data: {
                        tradeAccount: $("#clientId").val()
                    },  //为值取个名字
                    type: "POST",  //传值方式
                    dataType: "text",  //数据类型
                    success: function (d) {
                        if (d.trim() == "exist") {
                            alertMsg("客户账号已存在");
                        } else {
                            $.ajax({
                                type: "POST",
                                url: "${webRoot}/customer/editCustomerAccountOpenInfo",
                                data: JSON.stringify(openAccountInfo),
                                contentType: 'application/json',
                                dataType: "json",        //返回数据形式为json
                                success: function (r) {
                                    if (r.code == 0) {
                                        alert(r, function (index) {
//                        window.parent.location.reload();
                                            var url = "${webRoot}/customer/proofFiles?applicationId=" + '${customerAccountOpenInfoEntity.applicationId}'
                                            layer.open({
                                                scrollbar: false,
                                                type: 2,
                                                title: ["编辑资料", true],
                                                area: ['50%', '60%'], //宽高
                                                content: [url, 'no'],
                                                cancel: function () {
                                                    window.parent.location.reload();
                                                }
                                            });
                                        });
                                    } else {
                                        alertMsg(r.msg);
                                    }
                                },
                                error: function (r) {
                                    alertMsg(r.msg);
                                }
                            });
                        }
                    }
                })
            } else {
                openAccountInfo['clientId'] = null;
                $.ajax({
                    type: "POST",
                    url: "${webRoot}/customer/editCustomerAccountOpenInfo",
                    data: JSON.stringify(openAccountInfo),
                    contentType: 'application/json',
                    dataType: "json",        //返回数据形式为json
                    success: function (r) {
                        if (r.code == 0) {
                            alert(r, function (index) {
//                        window.parent.location.reload();
                                var url = "${webRoot}/customer/proofFiles?applicationId=" + '${customerAccountOpenInfoEntity.applicationId}'
                                layer.open({
                                    scrollbar: false,
                                    type: 2,
                                    title: ["编辑资料", true],
                                    area: ['50%', '60%'], //宽高
                                    content: [url, 'no'],
                                    cancel: function () {
                                        window.parent.location.reload();
                                    }
                                });
                            });
                        } else {
                            alertMsg(r.msg);
                        }
                    },
                    error: function (r) {
                        alertMsg(r.msg);
                    }
                });
            }
        });
    }

    /**
     * 下载用户报表
     */
    function downloadAccountOpenReport(fullFilePath) {
        window.location.href = webRoot + "/common/downloadFile?fullFilePath=" + fullFilePath;
    }

    $(document).ready(function () {
        //重新上传音频、视频文件按钮
        var reButton = document.getElementsByName('reLoadButtonV');
        for (var i = 0; i < reButton.length; i++) {
            var id = $("#reLoadButtonV" + i).val();
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
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/customer/pictureRefresh?applicationId=${customerAccountOpenInfoEntity.applicationId}",
                            timeout: 3000, success: function (page) {

                                $.ajaxPrefilter('script', function (options) {
                                    options.cache = true;
                                });

                                $("#imageList").remove();
                                $("#mainContent").html(page);
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

        //上传图片文件按钮
        var updateButtons2 = document.getElementsByName('upLoadAml');
        for (var i = 0; i < updateButtons2.length; i++) {
            var applicationId = '${customerAccountOpenInfoEntity.applicationId}';
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
                        alert("上传成功");
                    } else {
                        alert(result.message);
                    }
                    window.location.reload();
                }
            });
        }

        var hkBankId = '${customerAccountOpenInfoEntity.bankId}';
        if (hkBankId == 'OTHERS') {
            $("#otherBankName").removeAttr("style", "display:none").attr("style", "display:inline")
        }

        if (${customerAccountOpenInfoEntity.isKnowDerivativeProducts == 0}) {
            $("#isKnowProducts").find('input').attr("disabled", "disabled").attr("readonly", "readonly");
        }

    })

    $("#hkBankId").change(function () {
        var value = $("#hkBankId").val();
        if (value == "OTHERS") {
            $("#otherBankName").attr("style", "display:inline")
        } else {
            $("#otherBankName").attr("style", "display:none")
        }
    });

    function canRead() {
        $("#isKnowProducts").find('input').attr("disabled", "disabled").attr("readonly", "readonly");
    }

    function canWrite() {
        $("#isKnowProducts").find('input').removeAttr("disabled", "disabled").removeAttr("readonly", "readonly");
    }

    var radioFlag = null;
    $("#div5 :radio").click(function (e) {
        if (radioFlag == null || radioFlag == $(this).val()) {
            var check = $(this).attr('checked');
            if (check != undefined && check == 'checked') {
                $(this).removeAttr("checked")
            } else if (check == undefined) {
                $(this).attr('checked', "checked")
            }
        }
        radioFlag = $(this).val();

    });

    //收入来源为不动产租金时，财产种类 不动产必须勾选上
    function changePropertyType(checkBox) {
        if (checkBox.checked == true) {
            $("input[name='propertyType[]'][value='" + 3 + "']").prop("checked", true);
//            $("input[name='propertyType[]'][value='" + 3 + "']").prop("disabled", true);
        } else {
            $("input[name='propertyType[]'][value='" + 3 + "']").prop("checked", false);
//            $("input[name='propertyType[]'][value='" + 3 + "']").prop("disabled", false);
        }
    }

    // 编辑资料转入复审
    function submitDoRecheck() {
        var openAccountInfo = $('#basicInfoForm').serializeJSON();
        if (openAccountInfo['isKnowDerivativeProducts'] == 0) {
            openAccountInfo['derivativeProductsStudyType'] = null;
            openAccountInfo['financingInstitutionWorkExperienceType'] = null;
            openAccountInfo['isTradedDerivativeProducts'] = null;
            openAccountInfo['derivativeProductsStudyTypeOther'] = null;
            openAccountInfo['isTradedDerivativeProducts'] = null;
        }
        //姓名拼接
        openAccountInfo['clientName']=openAccountInfo['familyName']+openAccountInfo['givenName'];
        openAccountInfo['clientNameSpell']=openAccountInfo['familyNameSpell']+openAccountInfo['givenNameSpell'];

        //地址拼接
        openAccountInfo['contactAddress']=openAccountInfo['contactProvinceName']+openAccountInfo['contactCityName']
            +openAccountInfo['contactCountyName']+openAccountInfo['contactDetailAddress'];
        openAccountInfo['familyAddress']=openAccountInfo['familyProvinceName']+openAccountInfo['familyCityName']
            +openAccountInfo['familyCountyName']+openAccountInfo['familyDetailAddress'];

        //其他信息披露  数据拼接 【开始】
        var disclosureCodes = [];
        <c:forEach var="obj" items="${openAccountOtherDisclosureList}">
        disclosureCodes.push(${obj.disclosureCode});
        </c:forEach>
        var otherInfoJsonList = [];
        for (i in disclosureCodes) {
            var disclosureJson = {};
            if (disclosureCodes[i] == 16) {
                disclosureJson.disclosureCode = 16;
                disclosureJson.disclosureIsTrue = 1;
            } else {
                var disclosureCode = 'disclosureCode_' + disclosureCodes[i];
                var disclosureFlag = 'disclosureFlag_' + disclosureCodes[i];
                var code = $("#" + disclosureCode).val();
                var flag = $('input:radio[name=' + disclosureFlag + ']:checked').val();
                disclosureJson.disclosureCode = code;
                var disclosure1 = "";
                var disclosure2 = "";
                var disclosure3 = "";
                var disclosure4 = "";
                var ischeck = false;
                //1,2,3选择否,11,12,13,14,15选择是时需要添加详细信息
                if (flag == 0 && (code == 1 || code == 2 || code == 3)) {
                    ischeck = true;
                }
                if (flag == 1 && (code > 10 && code < 16)) {
                    ischeck = true;
                }
                if (ischeck) {
                    var table_name = "table_" + disclosureCodes[i];
                    var table = document.getElementById(table_name);
                    for (var j = 0; j < table.rows.length; j++) {
                        for (var k = 0; k < table.rows[j].cells.length; k++) {
                            var filed1 = "";
                            var filed2 = "";
                            var filed3 = "";
                            var filed4 = "";
                            var input = table.rows[j].cells[k].getElementsByTagName("input");
                            if (input.length > 0) {
                                switch (k) {
                                    case 1:
                                        filed1 = input[0].value;
                                        break;
                                    case 3:
                                        filed2 = input[0].value;
                                        break;
                                    case 5:
                                        filed3 = input[0].value;
                                        break;
                                    case 7:
                                        filed4 = input[0].value;
                                        break;
                                    default:
                                }
                            }
                            if (typeof(filed1) != "undefined" && filed1 != null && filed1 != '') {
                                disclosure1 += filed1 + ",";
                            }
                            if (typeof(filed2) != "undefined" && filed2 != null && filed2 != '') {
                                disclosure2 += filed2 + ",";
                            }
                            if (typeof(filed3) != "undefined" && filed3 != null && filed3 != '') {
                                disclosure3 += filed3 + ",";
                            }
                            if (typeof(filed4) != "undefined" && filed4 != null && filed4 != '') {
                                disclosure4 += filed4 + ",";
                            }
                        }
                    }
                    var isTrue = false;
                    if (disclosure1 != null && disclosure1 != "") {
                        disclosureJson.disclosure1 = disclosure1.substring(0, disclosure1.length - 1);
                        isTrue = true;
                    }
                    if (disclosure2 != null && disclosure2 != "") {
                        disclosureJson.disclosure2 = disclosure2.substring(0, disclosure2.length - 1);
                        isTrue = true;
                    }
                    if (disclosure3 != null && disclosure3 != "") {
                        disclosureJson.disclosure3 = disclosure3.substring(0, disclosure3.length - 1);
                        isTrue = true;
                    }
                    if (disclosure4 != null && disclosure4 != "") {
                        disclosureJson.disclosure4 = disclosure4.substring(0, disclosure4.length - 1);
                        isTrue = true;
                    }
                    if (code == 1 || code == 2 || code == 3 || code > 10) {
                        if (!isTrue) {
                            alertMsg("身份资料申报中有选项需要添加详细信息");
                            return;
                        }
                    }
                }else{
                    //如果选择否，需要清空数据库的值
                    disclosureJson.disclosure1="";
                    disclosureJson.disclosure2="";
                    disclosureJson.disclosure3="";
                    disclosureJson.disclosure4="";
                }
                disclosureJson.disclosureIsTrue = flag;
            }
            otherInfoJsonList.push(disclosureJson)
        }
        openAccountInfo['otherInfo'] = JSON.stringify(otherInfoJsonList);
        //其他信息披露  数据拼接 【结束】

        //收入来源 投资目标 checkBox 处理
        //【开始】
        if (openAccountInfo['capitalSource'] == null) {
            alertMsg("收入来源不可为空!");
            return;
        } else {
            var capitalSource = openAccountInfo['capitalSource'].toString();
            openAccountInfo['capitalSource'] = capitalSource;
        }
        if (openAccountInfo['investTarget'] == null) {
            alertMsg("投资目标不可为空!");
            return;
        } else {
            var investTarget = openAccountInfo['investTarget'].toString();
            openAccountInfo['investTarget'] = investTarget;
        }
//        var acceptRisk = $('input:radio[name="acceptRisk"]:checked').val();
//        if (acceptRisk == null) {
//            alertMsg("风险承受程度不可为空!");
//            return;
//        } else {
//            openAccountInfo['acceptRisk'] = acceptRisk;
//        }
        var northTrade = $('input:radio[name="northTrade"]:checked').val();
        if (northTrade == null) {
            alertMsg("北向交易资料不可为空!");
            return;
        } else {
            openAccountInfo['northTrade'] = northTrade;
        }
        var FATCA = $('input:radio[name="FATCA"]:checked').val();
        if (FATCA == null) {
            alertMsg("FATCA声明不可为空!");
            return;
        } else {
            openAccountInfo['fatca'] = FATCA;
        }
        //【结束】

        //税务信息处理
        //【开始】
        var taxInfo = $('#taxInfoForm').serializeJSON();
        var taxInfoList = [];
        for (var i = 0; i < 5; i++) {
            var taxInfoObject = {};
            if (taxInfo.taxCountry[i] != null && taxInfo.taxCountry[i] != '') {
                taxInfoObject['taxCountry'] = taxInfo.taxCountry[i];
                if (taxInfo.taxNumber[i] != null && taxInfo.taxNumber[i] != '') {
                    taxInfoObject['taxNumber'] = taxInfo.taxNumber[i];
                    taxInfoObject['hasTaxNumber'] = 1;
                    taxInfoList.push(taxInfoObject);
                } else {
                    taxInfoObject['hasTaxNumber'] = 0;
                    if (taxInfo.reasonType[i] != null && taxInfo.reasonType[i] != '') {
                        taxInfoObject['reasonType'] = taxInfo.reasonType[i];
                        if (taxInfoObject['reasonType'] != null && 'B' == taxInfoObject['reasonType']) {
                            taxInfoObject['reasonDesc'] = taxInfo.reasonDesc[i]
                            taxInfoList.push(taxInfoObject);
                        } else {
                            taxInfoList.push(taxInfoObject);
                        }
                    }
                }
            }
        }
        openAccountInfo['taxInfo'] = JSON.stringify(taxInfoList);
        //【结束】

        //财产种类 信息处理
        //【开始】
        var propertyInfo = [];
        if (openAccountInfo.propertyType != null && openAccountInfo.propertyType != '') {
            for (var i = 0; i < 3; i++) {
                var propertyObject = {};
                if (openAccountInfo.propertyType[i] != null && openAccountInfo.propertyType[i] != '') {
                    propertyObject['propertyType'] = openAccountInfo.propertyType[i];

                    var type = parseInt(openAccountInfo.propertyType[i]) - 1;
                    if (openAccountInfo.propertyAmount[type] != null && openAccountInfo.propertyAmount[type] != '') {
                        propertyObject['propertyAmount'] = openAccountInfo.propertyAmount[type];
                        propertyInfo.push(propertyObject);
                    } else {
                        alertMsg("财产金额不能为空 请填写对应的财产金额");
                        return;
                    }
                } else if (openAccountInfo['capitalSource'].indexOf("3") >= 0 && openAccountInfo.propertyType.indexOf("3") == -1) {
                    //资金来源有“不动产租金”的时候，财产种类下“不动产”为必选必填；
                    alertMsg("收入来源含【不动产租金】，财产种类【不动产】 不能为空");
                    return;
                }
            }
        } else {
            alertMsg("财产种类不能为空 请填写财产种类");
            return;
        }
        openAccountInfo['propertyInfo'] = JSON.stringify(propertyInfo);
        //财产种类表单包含在 开户信息form之中 json解析出错 故 剔除不存在的属性
        delete openAccountInfo.propertyType;
        delete openAccountInfo.propertyAmount;
        //【结束】

        openAccountInfo['applicationTime'] = new Date(openAccountInfo['applicationTime']);
        openAccountInfo['isAllowProvidePrivacy'] = $('input[name="isAllowProvidePrivacy"]').filter(':checked').val();
        openAccountInfo['isTradedDerivativeProducts'] = $('input[name="isTradedDerivativeProducts"]').filter(':checked').val();
        openAccountInfo['isAllowProvidePrivacy'] = $('input[name="isAllowProvidePrivacy"]').filter(':checked').val();

        openAccountInfo['isRecheck'] = 1;
        openAccountInfo['remark'] = $("#remark").val()
        confirm('确定提交', function () {
            if ($("#clientId").val() != null && $("#clientId").val() != '') {
                openAccountInfo['clientId'] = $("#clientId").val();
                $.ajax({
                    url: "${webRoot}/secUserInfo/checkTradeAccount",   //处理页面的名称
                    data: {
                        tradeAccount: $("#clientId").val()
                    },  //为值取个名字
                    type: "POST",  //传值方式
                    dataType: "text",  //数据类型
                    success: function (d) {
                        if (d.trim() == "exist") {
                            alertMsg("客户账号已存在");
                        } else {
                            $.ajax({
                                type: "POST",
                                url: "${webRoot}/customer/editCustomerAccountOpenInfo",
                                data: JSON.stringify(openAccountInfo),
                                contentType: 'application/json',
                                dataType: "json",        //返回数据形式为json
                                success: function (r) {
                                    if (r.code == 0) {
                                        var url = "${webRoot}/act/deal/doActTask";
                                        var userIds = new Array();
                                        $("#userTab input[name='userIds']").each(function () {
                                            userIds.push($(this).val());
                                        });
                                        var params = {
                                            'busId': '${taskDto.busId}',
                                            'taskId': '${taskDto.taskId}',
                                            'instanceId': '${taskDto.instanceId}',
                                            'defId': '${taskDto.defId}',
                                            'varValue': '${taskDto.varValue}',
                                            'varName': '${taskDto.varName}',
                                            'nodeType': '${taskDto.nodeType}',
                                            'nextUserIds': userIds.join(",")
                                        };
                                        var remark = $("#remark").val();
                                        params["remark"] = remark;
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
                                        });
                                    } else {
                                        alertMsg(r.msg);
                                    }
                                },
                                error: function (r) {
                                    alertMsg(r.msg);
                                }
                            });
                        }
                    }
                })
            } else {
                openAccountInfo['clientId'] = null;
                $.ajax({
                    type: "POST",
                    url: "${webRoot}/customer/editCustomerAccountOpenInfo",
                    data: JSON.stringify(openAccountInfo),
                    contentType: 'application/json',
                    dataType: "json",        //返回数据形式为json
                    success: function (r) {
                        if (r.code == 0) {

                            var url = "${webRoot}/act/deal/doActTask";
                            var userIds = new Array();
                            $("#userTab input[name='userIds']").each(function () {
                                userIds.push($(this).val());
                            });
                            var params = {
                                'busId': '${taskDto.busId}',
                                'taskId': '${taskDto.taskId}',
                                'instanceId': '${taskDto.instanceId}',
                                'defId': '${taskDto.defId}',
                                'varValue': '${taskDto.varValue}',
                                'varName': '${taskDto.varName}',
                                'nodeType': '${taskDto.nodeType}',
                                'nextUserIds': userIds.join(",")
                            };
                            var remark = $("#remark").val();
                            params["remark"] = remark;
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
                            });
                        } else {
                            alertMsg(r.msg);
                        }
                    },
                    error: function (r) {
                        alertMsg(r.msg);
                    }
                });
            }
        });
    }

    function chooseFATCA() {
        $("input[name='FATCA']").get(0).checked = false;
        $("input[name='FATCA']").get(1).checked = true;
        alertMsg("智珠证券暂不支持美国居民线上开户！");
        return;
    }

    layui.laydate.render({
        elem: '#idCardValidDateStart' //指定元素
    });
    layui.laydate.render({
        elem: '#idCardValidDateEnd' //指定元素
    });
</script>
</html>
