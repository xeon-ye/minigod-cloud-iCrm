<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<jsp:useBean id="dateValue" class="java.util.Date"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>客户资料详情</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<style>
    #investTarget {
        display: inline
    }
</style>
<%--<body style="width: 99%">--%>
<body>
<div class="col-sm-11" id="main-container">
    <form class="customerList" id="customerList" name="customerList" style="width: 100%">

        <c:if test="${securitiesUserInfo.bankType == 0 or securitiesUserInfo.bankType == 2}">
            <div id="div0" v-cloak style="margin-top: 20px">
                <div v-show="!showList" class="panel panel-default">
                    <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
                    </br>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">姓氏(中文)</label>
                            <div class="col-xs-9" style="width: 20%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyName" name="familyName" type="text" class="form-control"
                                           value="${securitiesUserInfo.familyName}" readonly/>
                                </span>
                            </div>

                            <label class="col-sm-3 control-label no-padding-right">名字(中文)</label>
                            <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenName" name="givenName" type="text" class="form-control"
                                           value="${securitiesUserInfo.givenName}" readonly/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">证券帐户预留手机号</label>
                            <div class="col-xs-9">
                               <span class="col-sm-12 block input-icon input-icon-right">
                                    <c:if test="${shield==false}">
                                                  <input id="phoneNumber" name="phoneNumber" type="text"
                                                         class="form-control"
                                                         value="${securitiesUserInfo.phoneNumber}" required/>
                                    </c:if>
                                           <c:if test="${shield==true}">
                                            <input id="phoneNumber" name="phoneNumber" type="text" class="form-control"
                                                   value="***********" required/>
                                           </c:if>
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
                                           value="${securitiesUserInfo.familyNameSpell}" readonly/>
                                </span>
                            </div>

                            <label class="col-sm-3 control-label no-padding-right">名字(英文/拼音)</label>
                            <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenNameSpell" name="givenNameSpell" type="text" class="form-control"
                                           value="${securitiesUserInfo.givenNameSpell}" readonly/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">电子邮箱</label>
                            <div class="col-xs-9">
                               <span class="col-sm-12 block input-icon input-icon-right">
                                 <input id="email" name="email" type="text" class="form-control"
                                        value="${securitiesUserInfo.email}" readonly/>
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
                                                                initSelectedKey="${securitiesUserInfo.sex}"
                                                                clazz="form-control" disabled="false"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">出生日期</label>
                            <div class="col-xs-9">
                               <span class="col-sm-12 block input-icon input-icon-right">
                                    <input id="birthday" name="birthday" type="text" class="form-control"
                                           value="${securitiesUserInfo.birthday}" readonly/>
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
                                                initSelectedKey="${securitiesUserInfo.idKind}"
                                                clazz="form-control" disabled="false"/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">国家/地区</label>
                            <div class="col-xs-9">
                               <span class="col-sm-12 block input-icon input-icon-right">
                                   <c:choose>
                                       <c:when test="${securitiesUserInfo.nationality == 'OTH'}">
                                            <input id="nationality" name="nationality" type="text" class="form-control"
                                                   value="${securitiesUserInfo.otherNationality}" readonly/>
                                       </c:when>
                                       <c:otherwise>
                                           <input id="nationality" name="nationality" type="text" class="form-control"
                                                  value="${fns:getCodeName("AO_NATIONALITY",securitiesUserInfo.nationality)}"
                                                  readonly/>
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
                               <span class="col-sm-12 block input-icon input-icon-right">
                                    <input name="idNo" type="text" class="form-control"
                                           value="${securitiesUserInfo.idNo}" readonly/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">证件有效期至</label>
                            <div class="col-xs-9">
                               <span class="col-sm-12 block input-icon input-icon-right">
                                    <input id="idCardValidDateEnd" name="idCardValidDateEnd" type="text"
                                           class="form-control"
                                           value="${securitiesUserInfo.idCardValidDateEnd}" readonly/>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">

                        <div class="form-group col-sm-6 col-md-6" style="display: none">
                            <label class="col-sm-3 control-label no-padding-right">银行名称</label>
                            <div class="col-xs-9" style="display: inline">
                                <span class="col-xs-6 block input-icon input-icon-right">
                                    <tag:select id="hkBankId" name="bankId" nameKey="AO_BANK_HK"
                                                isAddDefaltOption="true"
                                                initSelectedKey="${securitiesUserInfo.bankId}"
                                                disabled="disabled"
                                                clazz="form-control"/>
                                </span>
                                <span class="col-xs-6 block input-icon input-icon-right">
                                  <input style="display: none;" id="otherBankName" name="otherBankName" type="text"
                                         class="form-control"
                                         value="${securitiesUserInfo.otherBankName}" readonly/>
                            </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6" style="display: none">
                            <label class="col-sm-3 control-label no-padding-right">银行户名</label>
                            <div class="col-xs-9">
                               <span class="col-sm-12 block input-icon input-icon-right">
                                    <input name="bankAccountName" type="text" class="form-control"
                                           value="${securitiesUserInfo.bankAccountName}" readonly/>
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
                                                    <c:if test="${securitiesUserInfo.fundAccountType==1}">checked</c:if>  /> 现金账户
                                             <input name="fundAccountType" type="radio" value="2" disabled="disabled"
                                                    <c:if test="${securitiesUserInfo.fundAccountType==2}">checked</c:if> /> 融资账户
                                        </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6" style="display: none">
                            <label class="col-sm-3 control-label no-padding-right">银行帐号</label>
                            <div class="col-xs-9">
                                <span class="col-sm-12 block input-icon input-icon-right">
                                <%--<tag:select nameKey="AO_BANK_ID" id="bankId" isAddDefaltOption="true"--%>
                                            <%--initSelectedKey="${securitiesUserInfo.bankId}"--%>
                                            <%--clazz="form-control " style="width:130px;display:inline" disabled="true"/>--%>

                                          <input class="form-control" name="bankNo"
                                                 type="text"
                                                 value="${securitiesUserInfo.bankNo}"
                                                 style="height:34px; margin-right: 0px;"
                                                 readonly/>

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
                                   value="${securitiesUserInfo.idCardAddress}" readonly/>
                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-12 col-md-12">
                            <label class="col-sm-1 control-label no-padding-right">现时住址</label>
                            <div class="col-xs-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                           <input name="homeAddress" type="text" class="form-control"
                                  value="${securitiesUserInfo.familyAddress}" readonly/>

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
                                   value="${securitiesUserInfo.contactAddress}" readonly/>
                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-12 col-md-12">
                            <label class="col-sm-1 control-label no-padding-right">拆分地址</label>
                            <div class="col-xs-11">
                             <span class="col-sm-12 block input-icon input-icon-right">
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${securitiesUserInfo.contactProvinceName}" readonly/>
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${securitiesUserInfo.contactCityName}" readonly/>
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${securitiesUserInfo.contactCountyName}" readonly/>
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 54%;display: inline;"
                                       value="${securitiesUserInfo.contactDetailAddress}" readonly/>
                                </span>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </c:if>
        <c:if test="${securitiesUserInfo.bankType == 1}">
            <div id="div0" v-cloak style="margin-top: 20px">
                <div v-show="!showList" class="panel panel-default">
                    <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
                    </br>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">姓氏(中文)</label>
                            <div class="col-xs-9" style="width: 20%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="familyName" name="familyName" type="text" class="form-control"
                                           value="${securitiesUserInfo.familyName}" readonly/>
                                </span>
                            </div>

                            <label class="col-sm-3 control-label no-padding-right">名字(中文)</label>
                            <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenName" name="givenName" type="text" class="form-control"
                                           value="${securitiesUserInfo.givenName}" readonly/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">性别</label>
                            <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <tag:select nameKey="COMMON_SEX" id="sex" isAddDefaltOption="true"
                                        initSelectedKey="${securitiesUserInfo.sex}"
                                        clazz="form-control" disabled="false"/>
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
                                           value="${securitiesUserInfo.familyNameSpell}" readonly/>
                                </span>
                            </div>

                            <label class="col-sm-3 control-label no-padding-right">名字(英文/拼音)</label>
                            <div class="col-xs-9" style="width: 30%">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="givenNameSpell" name="givenNameSpell" type="text" class="form-control"
                                           value="${securitiesUserInfo.givenNameSpell}" readonly/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">证券帐户预留手机号</label>
                            <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <c:if test="${shield==false}">
                                                  <input id="phoneNumber" name="phoneNumber" type="text"
                                                         class="form-control"
                                                         value="${securitiesUserInfo.phoneNumber}" required readonly/>
                            </c:if>
                                           <c:if test="${shield==true}">
                                            <input id="phoneNumber" name="phoneNumber" type="text" class="form-control"
                                                   value="***********" required readonly/>
                                           </c:if>
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
                                   value="${securitiesUserInfo.birthday}" readonly/>
                        </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">电子邮箱</label>
                            <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                         <input name="email" type="text" class="form-control"
                                value="${securitiesUserInfo.email}" readonly/>
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
                                        initSelectedKey="${securitiesUserInfo.idKind}"
                                        clazz="form-control" disabled="false"/>
                        </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">国家/地区</label>
                            <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="nationality" type="text" class="form-control"
                                   value="${fns:getCodeName("AO_NATIONALITY",securitiesUserInfo.nationality)}"
                                   readonly/>
                        </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">证件号</label>
                            <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                          <c:if test="${shield==false}">
                                                <input id="idNo" name="idNo" type="text" class="form-control"
                                                       value="${securitiesUserInfo.idNo}" required/>
                          </c:if>
                                               <c:if test="${shield==true}">
                                                <input id="idNo" name="idNo" type="text" class="form-control"
                                                       value="**************" required/>
                                               </c:if>
                        </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">证件有效期至</label>
                            <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idCardValidDateEnd" type="text" class="form-control"
                                   value="${securitiesUserInfo.idCardValidDateEnd}" readonly/>
                        </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">银行名称</label>
                            <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <tag:select name="bankId" nameKey="AO_BANK_CHINA" isAddDefaltOption="true"
                                        initSelectedKey="${securitiesUserInfo.bankId}" clazz="form-control"
                                        disabled="disabled"/>
                        </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">银行卡号</label>
                            <div class="col-xs-9">
                       <span class="col-xs-12 block input-icon input-icon-right">
                                  <input class="form-control" name="bankNo" type="text"
                                         value="${securitiesUserInfo.bankNo}"
                                         style="height:34px; margin-right: 0px;"
                                         readonly/>

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
                                    <c:if test="${securitiesUserInfo.fundAccountType==1}">checked</c:if>  /> 现金账户
                             <input name="fundAccountType" type="radio" value="2" disabled="disabled"
                                    <c:if test="${securitiesUserInfo.fundAccountType==2}">checked</c:if> /> 融资账户
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
                                   value="${securitiesUserInfo.idCardAddress}" readonly/>
                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-12 col-md-12">
                            <label class="col-sm-1 control-label no-padding-right">现时住址</label>
                            <div class="col-xs-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                           <input name="homeAddress" type="text" class="form-control"
                                  value="${securitiesUserInfo.familyAddress}" readonly/>

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
                                   value="${securitiesUserInfo.contactAddress}" readonly/>
                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-12 col-md-12">
                            <label class="col-sm-1 control-label no-padding-right">拆分地址</label>
                            <div class="col-xs-11">
                             <span class="col-sm-12 block input-icon input-icon-right">
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${securitiesUserInfo.contactProvinceName}" readonly/>
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${securitiesUserInfo.contactCityName}" readonly/>
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 15%;display: inline"
                                       value="${securitiesUserInfo.contactCountyName}" readonly/>
                                <input name="contactDetailAddress" type="text"
                                       class="form-control" style="width: 54%;display: inline;"
                                       value="${securitiesUserInfo.contactDetailAddress}" readonly/>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

        <div id="div2" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">职业信息</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">职业类型</label>
                        <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <tag:select nameKey="AO_PROFESSION_CODE" id="professionCode" isAddDefaltOption="true"
                                        initSelectedKey="${securitiesUserInfo.professionCode}"
                                        clazz="form-control"
                                        disabled="false"/>

                        </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">所属行业</label>
                        <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <tag:select initSelectedKey="${securitiesUserInfo.professionType}"
                                        nameKey="AO_OCCUPATION_TYPE"
                                        name="professionType" isAddDefaltOption="true" clazz="form-control "
                                        disabled="disabled"
                            />
                        </span>
                        </div>
                    </div>
                </div>

                <div id="freelanceDiv" class="row" style="display: none">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-1 control-label no-padding-right">职业名称</label>
                        <div class="col-xs-11">
                        <span class="col-sm-12 block input-icon input-icon-right" style="width:100%">
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
                               value="${securitiesUserInfo.companyName}" readonly/>
                    </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">职位级别</label>
                        <div class="col-xs-9">
                   <span class="col-sm-12 block input-icon input-icon-right">
                    <tag:select nameKey="AO_JOB_POSITION" id="jobPosition"
                                initSelectedKey="${securitiesUserInfo.jobPosition}"
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
                               value="${securitiesUserInfo.companyAddress}" readonly/>
                    </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="div3" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">财务与投资状况</b></div>
                </br>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">全年收入</label>
                        <div class="col-xs-9">
                           <span class="col-xs-10 block input-icon input-icon-right">
                                                <tag:select nameKey="AO_INCOME" id="income" isAddDefaltOption="true"
                                                            initSelectedKey="${securitiesUserInfo.annualIncome}"
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
                                    <span id="capitalSource2"><input name="capitalSource" type="checkbox" value="2"
                                                                     disabled="false"/>劳务报酬</span>
                                    <span id="capitalSource3"><input name="capitalSource" type="checkbox" value="3"
                                                                     disabled="false"/>不动产租金</span>
                                    <span id="capitalSource4"><input name="capitalSource" type="checkbox" value="4"
                                                                     disabled="false"/>营业收入</span>
                                    <span id="capitalSource5"><input name="capitalSource" type="checkbox" value="5"
                                                                     disabled="false"/>退休金</span>
                                    <span id="capitalSource6"><input name="capitalSource" type="checkbox" value="6"
                                                                     disabled="false"/>家人给予</span>
                                    <span id="capitalSource7"><input name="capitalSource" type="checkbox" value="7"
                                                                     disabled="false"/>兼职收入</span>
                                    <span id="capitalSource8"><input name="capitalSource" type="checkbox" value="8"
                                                                     disabled="false"/>生产收入</span>
                            </span>
                        </div>
                    </div>
                </div>

                <c:if test="${openAccountPropertyList!=null}">
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
                                                <tag:select
                                                        nameKey="AO_PROPERTY_TYPE_${openAccountPropertyType.propertyType}"
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
                </c:if>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">投资目标</label>
                        <div class="col-xs-9">
                    <span class="col-xs-12 block input-icon input-icon-right" style="width:1000px">
                        <tag:checkbox nameKey="AO_INVEST_TARGET" id="investTarget" name="investTarget"
                                      initCheckKey="${securitiesUserInfo.investTarget}" clazz=""
                                      disabled="disabled" style="display: inline" initDidableKey="2,3"/>
                            <input class="form-control " style="width: 200px;display: inline"
                                   id="investTargetOther"
                                   name="investTargetOther" type="text"
                                   value="${securitiesUserInfo.investTargetOther}" readonly/>
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
                                        initSelectedKey="${securitiesUserInfo.stocksInvestmentExperienceType}"
                                        clazz="form-control " style="width:120px;display:inline"
                                        disabled="true"/>

                        <span style="margin-left:20px;">认股证/股票期权</span>
                             <tag:select nameKey="AO_WARRANTS_INVESTMENT_EXPERIENCE_TYPE"
                                         id="warrantsInvestmentExperienceType" isAddDefaltOption="true"
                                         initSelectedKey="${securitiesUserInfo.warrantsInvestmentExperienceType}"
                                         clazz="form-control" style="width:120px;display:inline"
                                         disabled="true"/>

                        <span style="margin-left:20px;">期货/期权</span>
                            <tag:select nameKey="AO_FUTURES_INVESTMENT_EXPERIENCE_TYPE"
                                        id="futuresInvestmentExperienceType" isAddDefaltOption="true"
                                        initSelectedKey="${securitiesUserInfo.futuresInvestmentExperienceType}"
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
                                     <%--test="${securitiesUserInfo.acceptRisk==1}"> checked="checked"</c:if> />低风险--%>
                             <%--<input type="radio" name="acceptRisk" disabled="disabled"--%>
                                    <%--value="2" <c:if--%>
                                     <%--test="${securitiesUserInfo.acceptRisk==2}"> checked="checked"</c:if>  />中风险--%>
                            <%--<input type="radio" name="acceptRisk" disabled="disabled"--%>
                                   <%--value="3" <c:if--%>
                                    <%--test="${securitiesUserInfo.acceptRisk==3}"> checked="checked"</c:if>  />高风险--%>
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
                        <span class="col-xs-10 block input-icon input-icon-right">
                             <input type="radio" name="isKnowDerivativeProducts" disabled="disabled"
                                    value="1" <c:if
                                     test="${securitiesUserInfo.isKnowDerivativeProducts==1}"> checked="checked"</c:if> />是
                             <input type="radio" name="isKnowDerivativeProducts" disabled="disabled"
                                    value="0" <c:if
                                     test="${securitiesUserInfo.isKnowDerivativeProducts==0}"> checked="checked"</c:if>  />否
                        </span>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-12 control-label no-padding-right">请选择您接收衍生产品相关的培训或课程的方式</label>
                    </div>


                    <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-10 block input-icon input-icon-right">
                        	 <c:forEach var="investTargetCodeEntity"
                                        items="${fns:getCodeInfoByParentMark('AO_DERIVATIVE_PRODUCTS_STUDY_TYPE')}"
                                        varStatus="i">
                                 <c:if test="${securitiesUserInfo.derivativeProductsStudyType== investTargetCodeEntity.value}">
                                    <input type="radio" name="derivativeProductsStudyType" disabled="disabled"
                                           value="${investTargetCodeEntity.value}" checked="checked"
                                    />${investTargetCodeEntity.name}
                                 </c:if>
                                 <c:if test="${securitiesUserInfo.derivativeProductsStudyType != investTargetCodeEntity.value}">
                                    <input type="radio" name="derivativeProductsStudyType" disabled="disabled"
                                           value="${investTargetCodeEntity.value}"
                                    />${investTargetCodeEntity.name}
                                 </c:if>
                             </c:forEach>
                            <c:if test="${securitiesUserInfo.derivativeProductsStudyType == 7}"> <%--其他的值 --%>
                                <input class="form-control" style="width:100px;display: inline"
                                       id="derivativeProductsStudyTypeOther" name="derivativeProductsStudyTypeOther"
                                       type="text" readonly
                                       value="${securitiesUserInfo.derivativeProductsStudyTypeOther}"
                                />
                            </c:if>
                        </span>
                        <c:if test="${proofImage_601!=null && securitiesUserInfo.derivativeProductsStudyType!=null && securitiesUserInfo.derivativeProductsStudyType!=''}">
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
                        <span class="col-xs-10 block input-icon input-icon-right">
                                  <c:forEach var="investTargetCodeEntity"
                                             items="${fns:getCodeInfoByParentMark('AO_FINANCING_INSTITUTION_WORK_EXPERIENCE_TYPE')}"
                                             varStatus="i">
                                      <c:if test="${securitiesUserInfo.financingInstitutionWorkExperienceType== investTargetCodeEntity.value}">
                                    <input type="radio" name="financingInstitutionWorkExperienceType"
                                           value="${investTargetCodeEntity.value}" checked="true" disabled="disabled"
                                    />${investTargetCodeEntity.name}
                                      </c:if>
                                      <c:if test="${securitiesUserInfo.financingInstitutionWorkExperienceType != investTargetCodeEntity.value}">
                                    <input type="radio" name="financingInstitutionWorkExperienceType"
                                           value="${investTargetCodeEntity.value}" disabled="disabled"
                                    />${investTargetCodeEntity.name}
                                      </c:if>
                                  </c:forEach>
                            <c:if test="${securitiesUserInfo.financingInstitutionWorkExperienceType == 4}"> <%--其他的值 --%>
                                <input class="form-control" style="width:100px;display: inline"
                                       id="financingInstitutionWorkExperienceTypeOther" readonly
                                       name="financingInstitutionWorkExperienceTypeOther" type="text"
                                       value="${securitiesUserInfo.financingInstitutionWorkExperienceTypeOther}"
                                       style="width:200px; margin-left:25px; height:34px;"/>
                            </c:if>
                        </span>
                        <c:if test="${proofImage_602!=null&& securitiesUserInfo.financingInstitutionWorkExperienceType!=null && securitiesUserInfo.financingInstitutionWorkExperienceType!=''}">
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
                        <span class="col-xs-10 block input-icon input-icon-right">
                        	  <input type="radio" name="isTradedDerivativeProducts"
                                     value="1" disabled="disabled"
                                     <c:if test="${securitiesUserInfo.isTradedDerivativeProducts == 1}">checked="true"</c:if>
                              />是
                        	  <input type="radio" name="isTradedDerivativeProducts"
                                     value="${investTargetCodeEntity.isTradedDerivativeProducts}" disabled="disabled"
                                     <c:if test="${securitiesUserInfo.isTradedDerivativeProducts == 0}">checked="true"</c:if>
                              />否
                        </span>
                        <c:if test="${proofImage_603!=null && securitiesUserInfo.isTradedDerivativeProducts == 1}">
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
                        <label class="col-sm-12 control-label no-padding-right">您是否确认《个人资料（私隐）条例通知》并同意智珠证券及其控股集团使用及向其他人士提供本人的个人资料作直接促销用途。</label>
                    </div>


                    <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-12 block input-icon input-icon-right">
                                    <input type="radio" name="isAllowProvidePrivacy"
                                           value="1" disabled="disabled"
                                           <c:if test="${securitiesUserInfo.isAllowProvidePrivacy == 1}">checked="checked"</c:if>
                                    />是
                                    <input type="radio" name="isAllowProvidePrivacy" disabled="disabled"
                                           <c:if test="${securitiesUserInfo.isAllowProvidePrivacy == 0}">checked="checked"</c:if>
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
                                           <c:if test="${securitiesUserInfo.northTrade == 1}">checked="checked"</c:if>
                                    />是
                                    <input type="radio" name="northTrade" disabled="disabled"
                                           <c:if test="${securitiesUserInfo.northTrade == 0}">checked="checked"</c:if>
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
                                           <c:if test="${securitiesUserInfo.fatca == 1}">checked="checked"</c:if>
                                    />是
                                    <input type="radio" name="FATCA" disabled="disabled"
                                           value="0"
                                           <c:if test="${securitiesUserInfo.fatca == 0}">checked="checked"</c:if>
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
                    <c:if test="${taxInformationList[i]!=null}">
                    <div class="row">
                        <div class="form-group col-sm-3 col-md-3">
                            <div class="col-xs-12">
                                        <span class="col-xs-12 block input-icon input-icon-right">
                                            <input type="text" name="taxCountry[]"
                                                   value="${taxInformationList[i].taxCountry}" readonly
                                                   class="form-control">
                                        </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-3 col-md-3">
                            <div class="col-xs-12">
                                        <span class="col-xs-12 block input-icon input-icon-right">
                                            <input type="text" name="taxNumber[]"
                                                   value="${taxInformationList[i].taxNumber}" readonly
                                                   class="form-control">
                                        </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-3 col-md-3">
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
                        <div class="form-group col-sm-3 col-md-3">
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
                         <c:if test="${openAccountOther.disclosureNameJoinDetail!=null && openAccountOther.disclosureNameJoinDetail!=''}">
                                 <input class="form-control" style="display: inline"
                                        id="disclosureCode" name="disclosureCode" type="text"
                                        value="${openAccountOther.disclosureNameJoinDetail}"
                                        style="width:600px; margin-left:25px; height:34px;"
                                        readonly/>
                         </c:if>
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
    </form>
</div>
</body>
<script>
    $("input").attr("readonly", true);
    $("select").attr("disabled", true);

    $(function () {
        initFreelanceOther('${securitiesUserInfo.freelanceOther}');

        //初始化职业类型，收入来源
        onChangeProfessionCode('${securitiesUserInfo.professionCode}', '${securitiesUserInfo.capitalSource}');

        var hkBankId = '${securitiesUserInfo.bankId}';
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

    function openPhoto(src) {
        layer.photos({
            photos: {
                "data": [{"src": '${webRoot}/image' + src}]
            },
            shadeClose: false,
            shade: [0.5, '#000'],
            closeBtn: 2,
            anim: 0,
        });
    }

    layui.form.render('select');
</script>
</html>
