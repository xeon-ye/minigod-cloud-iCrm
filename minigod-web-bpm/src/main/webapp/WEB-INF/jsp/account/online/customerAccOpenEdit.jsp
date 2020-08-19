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
    <%--账户性质--%>
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
                        <label class="col-sm-2 control-label no-padding-right">开户途径</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <tag:select nameKey="AO_OPEN_ACCOUNT_ACCESS_WAY"
                                            id="openAccountAccessWay" isAddDefaltOption="true"
                                            initSelectedKey="${customerAccountOpenInfoEntity.openAccountAccessWay}"
                                            clazz="form-control" disabled="false"/>
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
                        <label class="col-sm-2 control-label no-padding-right">HashNo</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input id="caSignHashCode" name="caSignHashCode" type="text"
                                       value="${customerAccountOpenInfoEntity.caSignHashCode}" class="form-control" readonly/>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${customerAccountOpenInfoEntity.bankType == 0}">
        <div id="div0" v-cloak>
                <%-- 账户信息 Start --%>
            <div id="datas1" v-cloak>
                <div v-show="!showList" class="panel panel-default">
                    <div class="panel-heading"><b style="color: #368763">账户信息</b></div>
                    </br>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">账户性质</label>
                            <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                 <tag:select nameKey="AO_ACCOUNT_TYPE_CODE"
                                             id="accountType" isAddDefaltOption="true"
                                             initSelectedKey="${customerAccountOpenInfoEntity.accountType}"
                                             clazz="form-control" />
                            </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">语言选择</label>
                            <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                <tag:select nameKey="AO_LANGUAGE_CODE"
                                            id="language" isAddDefaltOption="true"
                                            initSelectedKey="${customerAccountOpenInfoEntity.language}"
                                            clazz="form-control" />
                            </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">证券交易</label>
                            <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                <input name="isOpenSecurity" type="radio" value="1" "
                                       checked="checked"/>开通
                                <input name="isOpenSecurity" type="radio" value="0" />不开通
                            </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">证券交易使用场景</label>
                            <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                <input name="optionsAccUsageScenarios" type="radio" value="0"
                                       <c:if test="${customerAccountOpenInfoEntity.optionsAccUsageScenarios==1}">checked</c:if>  />互联网交易
                                <input name="optionsAccUsageScenarios" type="radio" value="1"
                                       <c:if test="${customerAccountOpenInfoEntity.optionsAccUsageScenarios==2}">checked</c:if>  />全权委托交易
                            </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">证券账户类型</label>
                            <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                               <input name="fundAccountType" type="radio" value="1"
                                      <c:if test="${customerAccountOpenInfoEntity.fundAccountType==1}">checked</c:if> /> 现金账户
                               <input name="fundAccountType" type="radio" value="2"
                                      <c:if test="${customerAccountOpenInfoEntity.fundAccountType==2}">checked</c:if> /> 融资账户
                            </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">证券市场</label>
                            <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                               <input name="isOpenOptions" type="radio" value="1"
                                      <c:if test="${customerAccountOpenInfoEntity.isOpenOptions==1}">checked</c:if>  />股票期权
                            </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">期货交易</label>
                            <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                <input name="isOpenFutures" type="radio" value="1"
                                       <c:if test="${customerAccountOpenInfoEntity.isOpenFutures==1}">checked</c:if>  />开通
                                <input name="isOpenFutures" type="radio" value="0"
                                       <c:if test="${customerAccountOpenInfoEntity.isOpenFutures==0}">checked</c:if>  />不开通
                            </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">期货交易使用场景</label>
                            <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="futuresAccUsageScenarios" type="radio" value="0"
                                   <c:if test="${customerAccountOpenInfoEntity.futuresAccUsageScenarios==1}">checked</c:if>  />互联网交易
                            <input name="futuresAccUsageScenarios" type="radio" value="1"
                                   <c:if test="${customerAccountOpenInfoEntity.futuresAccUsageScenarios==2}">checked</c:if>  />全权委托交易
                            </span>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
                <%--賬戶信息 End--%>
            </c:if>
            <%--身份资料(CA认证开户 + 大陆身份证)-Start--%>
            <c:if test="${customerAccountOpenInfoEntity.idKind == 1 && customerAccountOpenInfoEntity.bankType == 1}">
                <div id="div0" v-cloak>
                    <div v-show="!showList" class="panel panel-default">
                        <div class="panel-heading"><b style="color: #368763">身份资料</b></div>
                        </br>
                        <div class="row">
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">证件类型</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">

 <tag:select nameKey="AO_ID_KIND" id="idKind" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.idKind}"
                                       clazz="form-control" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">国家/地区333</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
<%--                            <input name="nationality" type="text" class="form-control"--%>
<%--                                   value="${fns:getCodeName("AO_NATIONALITY",customerAccountOpenInfoEntity.nationality)}"--%>
<%--                            />--%>

                                        <tag:select nameKey="AO_NATIONALITY" id="nationality" isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.nationality}"
                                                    clazz="form-control"/>
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
                                   value="${customerAccountOpenInfoEntity.clientName}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">性别</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <tag:select nameKey="COMMON_SEX" id="sex" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                       clazz="form-control" />
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
                                  value="${customerAccountOpenInfoEntity.clientNameSpell}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">民族</label>
                                <div class="col-xs-9">
                        <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="nation" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.nation}" />
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
                                   value="${customerAccountOpenInfoEntity.idNo}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">出生日期</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="birthday" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.birthday}" />
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
                                   value="${customerAccountOpenInfoEntity.signingOrganization}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">证件有效期至</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idCardValidDateEnd" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idCardValidDateEnd}" />
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
                                       value="${customerAccountOpenInfoEntity.idCardAddress}" />
                            </span>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </c:if>
            <%--身份资料(CA认证开户 + 大陆身份证)-End--%>
            <%--身份资料(香港银行卡认证开户 + 大陆身份证)-Start--%>
            <c:if test="${customerAccountOpenInfoEntity.idKind == 1 && customerAccountOpenInfoEntity.bankType == 0}">
                <div id="div0" v-cloak>
                    <div v-show="!showList" class="panel panel-default">
                        <div class="panel-heading"><b style="color: #368763">身份资料</b></div>
                        </br>

                        <div class="row">
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">证件类型</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
     <tag:select nameKey="AO_ID_KIND" id="idKind" isAddDefaltOption="true"
                                        initSelectedKey="${customerAccountOpenInfoEntity.idKind}"
                                        clazz="form-control" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">国家/地区444</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
<%--                            <input name="nationality" type="text" class="form-control"--%>
<%--                                   value="${fns:getCodeName("AO_NATIONALITY",customerAccountOpenInfoEntity.nationality)}"--%>
<%--                            />--%>
                                        <tag:select nameKey="AO_NATIONALITY_HK" id="nationality" isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.nationality}"
                                                    clazz="form-control" />
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
                                   value="${customerAccountOpenInfoEntity.clientName}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">性别</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <tag:select nameKey="COMMON_SEX" id="sex" isAddDefaltOption="true"
                                        initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                        clazz="form-control" />
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
                                   value="${customerAccountOpenInfoEntity.clientNameSpell}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">出生日期</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="birthday" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.birthday}" />
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
                                   value="${customerAccountOpenInfoEntity.idNo}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">证件有效期至</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idCardValidDateEnd" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idCardValidDateEnd}" />
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
                                   value="${customerAccountOpenInfoEntity.idCardAddress}" />
                        </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <%--身份资料(香港银行卡认证开户 + 大陆身份证)-End--%>
            <%--身份资料(香港银行卡认证开户 + 香港身份证)-Start--%>
            <c:if test="${customerAccountOpenInfoEntity.idKind == 2 && customerAccountOpenInfoEntity.bankType == 0}">
                <div id="div0" v-cloak>
                    <div v-show="!showList" class="panel panel-default">
                        <div class="panel-heading"><b style="color: #368763">身份资料</b></div>
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
                                <label class="col-sm-2 control-label no-padding-right">国家/地区11</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
<%--                           <input name="nationality" type="text" class="form-control"--%>
<%--                                  value="${fns:getCodeName("AO_NATIONALITY",customerAccountOpenInfoEntity.nationality)}"--%>
<%--                                  readonly/>--%>


                                        <tag:select nameKey="AO_NATIONALITY" id="nationality" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.nationality}"
                                       clazz="form-control" disabled="false"/>
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
                                  value="${customerAccountOpenInfoEntity.clientName}" />
                        </span>
                                </div>
                            </div>
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
                                <label class="col-sm-2 control-label no-padding-right">英文/拼音姓名</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="clientNameSpell" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.clientNameSpell}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">出生日期</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="birthday" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.birthday}" />
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
                                   value="${customerAccountOpenInfoEntity.idNo}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">证件有效期至</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="idCardValidDateEnd" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.idCardValidDateEnd}" />
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
                                  value="${customerAccountOpenInfoEntity.idCardAddress}" />
                        </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <%--身份资料(香港银行卡认证开户 + 香港身份证)-End--%>
            <%--身份资料(香港银行卡认证开户 + 护照)-Start--%>
            <c:if test="${customerAccountOpenInfoEntity.idKind == 3 && customerAccountOpenInfoEntity.bankType == 0}">
                <div id="div0" v-cloak>
                    <div v-show="!showList" class="panel panel-default">
                        <div class="panel-heading"><b style="color: #368763">身份资料</b></div>
                        </br>
                        <div class="row">
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">证件类型</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">

   <tag:select nameKey="AO_ID_KIND" id="idKind" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.idKind}"
                                       clazz="form-control" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">国家/地区222</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
<%--                           <input name="nationality" type="text" class="form-control"--%>
<%--                                  value="${fns:getCodeName("AO_NATIONALITY",customerAccountOpenInfoEntity.nationality)}"--%>
<%--                                  />--%>

                                        <tag:select nameKey="AO_NATIONALITY" id="nationality" isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.nationality}"
                                                    clazz="form-control" disabled="false"/>
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
                                  value="${customerAccountOpenInfoEntity.clientName}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">性别</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <tag:select nameKey="COMMON_SEX" id="sex" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.sex}"
                                       clazz="form-control" />
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
                                   value="${customerAccountOpenInfoEntity.clientNameSpell}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">出生日期</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                            <input name="birthday" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.birthday}" />
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
                                   value="${customerAccountOpenInfoEntity.idNo}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">证件有效期至</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="idCardValidDateEnd" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.idCardValidDateEnd}" />
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
                                  value="${customerAccountOpenInfoEntity.idCardAddress}" />
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
                                  value="${customerAccountOpenInfoEntity.phoneNumber}" />
                        </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">电子邮箱</label>
                                <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <input name="email" type="text" class="form-control"
                                  value="${customerAccountOpenInfoEntity.email}" />
                       </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <%--身份资料(香港银行卡认证开户 + 护照)-End--%>

            <%--基本信息--%>
            <div>
                <div id="div-user" v-cloak>
                    <div v-show="!showList" class="panel panel-default">
                        <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
                        </br>
                        <div class="row">
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">教育程度</label>
                                <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                <tag:select nameKey="AO_EDUCATION_LEVEL_CODE"
                                            id="educationLevel" isAddDefaltOption="true"
                                            initSelectedKey="${customerAccountOpenInfoEntity.educationLevel}"
                                            clazz="form-control" />
                            </span>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">电子邮箱</label>
                                <div class="col-xs-9">
                               <span class="col-sm-12 block input-icon input-icon-right">
                                   <input name="email" type="text" class="form-control"
                                          value="${customerAccountOpenInfoEntity.email}" />
                               </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">手机号</label>
                                <div class="col-xs-9">
                               <span class="col-sm-12 block input-icon input-icon-right">
                                    <input name="phoneNumber" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.phoneNumber}" />
                                </span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">住宅电话</label>
                                <div class="col-xs-9">
                               <span class="col-sm-12 block input-icon input-icon-right">
                                    <input name="familyPhone" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.familyPhone}" />
                                </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">通讯电话</label>
                                <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                            <input id="contactPhone" name="contactPhone" type="text" class="form-control"
                                   value="${customerAccountOpenInfoEntity.contactPhone}" />
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
                                           value="${customerAccountOpenInfoEntity.familyAddress}" />
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
                               value="${customerAccountOpenInfoEntity.contactAddress}" />
                    </span>
                                </div>
                            </div>
                        </div>

                        <%--<div class="row">
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
                        </div>--%>
                    </div>
                </div>
            </div>
            <%--基本信息--%>
            <!--隐藏图片-->
            <div hidden id="imageList">
                <ul class="docs-pictures">
                </ul>
            </div>
            <div hidden id="imageList_604">
                <ul class="docs-pictures"></ul>
            </div>
            <!--影像资料 Start-->
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
                            <c:if test="${proofImage_604!=null && customerAccountOpenInfoEntity.isTradedDerivativeProducts == 1}">
                                <script type="text/javascript">pictureListWithId("${proofImage_604.storagePath}${proofImage_604.fileStorageName}.${proofImage_604.extName}", 0, '_604');</script>
                                <span class="col-xs-2 block input-icon input-icon-right" style="margin-top: 15px">
                            <button class="layui-btn layui-btn-small layui-btn-warm" type="button"
                                    onclick="showImage('_604',0)"
                                    class="layui-icon"><i
                                    class="layui-icon">&#xe60d;</i>[地址证明]</button>
                         </span>
                            </c:if>
                        </div>
                        </br>
                    </div>
                </div>
            </div>
            <!--影像资料 End-->
            <!--香港银行卡信息 Start-->
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
                                            initSelectedKey="${customerAccountOpenInfoEntity.bankId}"
                                            clazz="form-control"
                                ></tag:select>
                                <c:if test="${customerAccountOpenInfoEntity.bankId == 'OTHERS'}">
                                    : <input id="otherBankName" name="otherBankName" type="text" class="form-control"
                                             value="${customerAccountOpenInfoEntity.otherBankName}"/>
                                </c:if>
                            </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">银行卡号</label>
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
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">银行账户名</label>
                                <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                 <input name="clientNameSpell" type="text" class="form-control"
                                        value="${customerAccountOpenInfoEntity.bankAccountName}" />
                            </span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">银行卡币种</label>
                                <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                <tag:select name="bankCurrency" nameKey="AO_BANK_CURRENCY" isAddDefaltOption="true"
                                            initSelectedKey="${customerAccountOpenInfoEntity.bankCurrency}"
                                            clazz="form-control"
                                ></tag:select>
                            </span>
                                </div>
                            </div>
                                <%--  <div class="form-group col-sm-6 col-md-6">
                                      <label class="col-sm-2 control-label no-padding-right">账户类型</label>
                                      <div class="col-xs-9">
                                          <span class="col-xs-12 block input-icon input-icon-right">
                                              <tag:select name="bankId" nameKey="AO_BANK_HK" isAddDefaltOption="true"
                                                          initSelectedKey="${customerAccountOpenInfoEntity.bankId}"
                                                          clazz="form-control"
                                                          disabled="disabled"></tag:select>
                                          </span>
                                      </div>--%>
                        </div>
                    </div>
                </div>
            </c:if>
            <!--香港银行卡信息 End-->
            <!--大陆银行卡信息 Start-->
            <c:if test="${customerAccountOpenInfoEntity.bankType !=null and customerAccountOpenInfoEntity.bankType == 1}">
                <div id="div2" v-cloak>
                    <div v-show="!showList" class="panel panel-default">
                        <div class="panel-heading"><b style="color: #368763">大陸银行账户四要素校验信息</b></div>
                        </br>
                        <div class="row">
                            <c:forEach items="${bankVerityInfoList}" var="bankVerityInfo">
                                <div class="form-group col-sm-12 col-md-12">
                                    <div class="layui-inline">
                                        <label class="col-sm-1 control-label"
                                               style="width: 120px;text-align:left;">用户姓名: </label>
                                        <span class="col-sm-1 control-label layui-inline"
                                              style="width: 200px;text-align:left; ">${bankVerityInfo.clientName}</span>
                                    </div>
                                    <div class="layui-inline">
                                        <label class="col-sm-1 control-label "
                                               style="width: 120px;text-align:left; ">证件号: </label>
                                        <span class="col-sm-1 control-label layui-inline"
                                              style="width: 200px;text-align:left;">${bankVerityInfo.idNo}</span>
                                    </div>
                                    <div class="layui-inline">
                                        <label class="col-sm-1 control-label "
                                               style="width: 120px;text-align:left;">银行卡号:</label>
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
                                        <label class="col-sm-1 control-label "
                                               style="width: 120px;text-align:left;">校验时间:</label>
                                        <span class="col-sm-1 control-label layui-inline"
                                              style="width: 200px;text-align:left;"><fmt:formatDate
                                                value="${bankVerityInfo.verityTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                    </div>
                                        <%--<div class="layui-inline">
                                            <label class="col-sm-1 control-label" style="width: 120px;text-align:left;">校验方:</label>
                                            <span class="col-sm-1 control-label layui-inline"
                                                  style="width: 200px;text-align:left;">CFCA</span>
                                        </div>--%>
                                        <%--<div class="layui-inline">
                                            <label class="col-sm-1 control-label"
                                                   style="width: 120px;text-align:left;">校验次数:</label>
                                            <span class="col-sm-1 control-label layui-inline"
                                                  style="width: 200px;text-align:left;">${bankVerityInfo.verifyCount}</span>
                                        </div>--%>
                                    <div class="layui-inline">
                                        <label class="col-sm-1 control-label"
                                               style="width: 120px;text-align:left;">校验结果: </label>
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
            <!--大陆银行卡信息 End-->

            <%--职业信息-Start--%>
            <div id="div3" v-cloak>
                <div v-show="!showList" class="panel panel-default">
                    <div class="panel-heading"><b style="color: #368763">职业信息</b></div>
                    </br>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-12">
                            <label class="col-sm-1 control-label no-padding-right">职业状态</label>
                            <div class="col-xs-11">
                        <span class="col-sm-6 block input-icon input-icon-right">
                            <c:forEach var="professionEntity"
                                       items="${fns:getCodeInfoByParentMark('AO_PROFESSION_CODE')}"
                                       varStatus="i">
                                <span class="layui-inline" style="padding-right: 15px">
                                    <c:if test="${customerAccountOpenInfoEntity.professionCode== professionEntity.value}">
                                        <input type="radio" name="professionCode"
                                               value="${professionEntity.value}" checked="checked"
                                        />${professionEntity.name}
                                    </c:if>
                                    <c:if test="${customerAccountOpenInfoEntity.professionCode != professionEntity.value}">
                                            <input type="radio" name="professionCode"
                                                   value="${professionEntity.value}"
                                            />${professionEntity.name}
                                    </c:if>
                                    <c:if test="${i.last}">
                                    <input class="form-control " style="width: 200px;display: inline"
                                           id="otherProfession"
                                           name="otherProfession" type="text"
                                           value="${customerAccountOpenInfoEntity.otherProfession}" />
                                    </c:if>
                                </span>
                            </c:forEach>

                        </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">从业年限</label>
                            <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="workingSeniority" name="workingSeniority" type="text" class="form-control"
                               value="${customerAccountOpenInfoEntity.workingSeniority}" />
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
                               value="${customerAccountOpenInfoEntity.companyName}" />
                    </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">营业范围</label>
                            <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="industryRange" name="companyName" type="text" class="form-control aaa"
                               value="${customerAccountOpenInfoEntity.industryRange}" />
                    </span>
                            </div>
                        </div>
                        <%--<div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">所属行业</label>
                            <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                <tag:select initSelectedKey="${customerAccountOpenInfoEntity.professionType}"
                                            nameKey="AO_OCCUPATION_TYPE"
                                            name="professionType" isAddDefaltOption="true" clazz="form-control "
                                            disabled="disabled"
                                ></tag:select>
                            </span>
                            </div>
                        </div>--%>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">职位级别</label>
                            <div class="col-xs-9">
                   <span class="col-sm-12 block input-icon input-icon-right">
                        <tag:select nameKey="AO_JOB_POSITION" id="jobPosition"
                                    initSelectedKey="${customerAccountOpenInfoEntity.jobPosition}"
                                    clazz="form-control" isAddDefaltOption="true"
                        />
                    </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">公司电话</label>
                            <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input id="companyPhoneNumber" name="companyPhoneNumber" type="text" class="form-control"
                               value="${customerAccountOpenInfoEntity.companyPhoneNumber}" />
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
                                   value="${customerAccountOpenInfoEntity.companyAddress}" />
                        </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--投资概况-Start--%>
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
                                   clazz="form-control" />
                    </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-2 control-label no-padding-right">投资年期</label>
                            <div class="col-xs-9">
                       <span class="col-sm-12 block input-icon input-icon-right">
                           <tag:select nameKey="AO_INVESTMENT_HORIZON" id="income" isAddDefaltOption="true"
                                       initSelectedKey="${customerAccountOpenInfoEntity.investmentHorizon}"
                                       clazz="form-control" />
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
                        ></tag:checkbox>
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
                                <div style="padding-bottom: 10px">
                                    <span class="col-sm-2">
                                        <input style="display: inline;" name="propertyType" type="checkbox"
                                               value="${openAccountPropertyType.propertyType}"

                                               checked="true"/> ${fns:getCodeName("AO_PROPERTY_TYPE",openAccountPropertyType.propertyType)}
                                    </span>
                                    <tag:select nameKey="AO_PROPERTY_TYPE_${openAccountPropertyType.propertyType}"
                                                clazz="form-control" style="width:150px;display:inline"
                                                isAddDefaltOption="true"
                                                initSelectedKey="${openAccountPropertyType.propertyAmount}"
                                    ></tag:select>
                                    <span style="width:10px;">&nbsp;&nbsp;&nbsp;</span>
                                    港币
                                </div>
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
                         <span class="layui-inline">
                             <tag:checkbox name="investTarget" nameKey="AO_INVEST_TARGET"
                                           initCheckKey="${customerAccountOpenInfoEntity.investTarget}"
                                           style="display: inline"></tag:checkbox>
                         </span>
                            <input class="form-control " style="width: 200px;display: inline"
                                   id="investTargetOther"
                                   name="investTargetOther" type="text"
                                   value="${customerAccountOpenInfoEntity.investTargetOther}" />
                    </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--投资概况-End--%>
            <%-- 投资经验 Start --%>
            <div id="datas2" v-cloak>
                <div v-show="!showList" class="panel panel-default">
                    <div class="panel-heading"><b style="color: #368763">投资经验</b></div>
                    </br>
                    <div class="row">
                        <div class="form-group col-xs-6 col-xs-6">
                            <table class="form-group col-xs-12 col-xs-12">
                                <tr align="left" style="font-weight: bold;">
                                    <td class="col-sm-4" style="padding:8px 20px; font-weight: bold;">种类</td>
                                    <td class="col-sm-2" style="padding:8px 20px">投资年限</td>
                                    <td class="col-sm-2" style="padding:8px 20px">交易频率次/年</td>
                                </tr>
                                <!-- 股票 -->
                                <tr align="left">
                                    <td class="col-sm-4" style="padding:8px 20px; font-weight: bold;">股票</td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_STOCKS_INVESTMENT_EXPERIENCE_TYPE"
                                                    id="stocksInvestmentExperienceType"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.stocksInvestmentExperienceType}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_TRADE_STOCK_FREQUENCY"
                                                    id="tradeStockFrequency"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.tradeStockFrequency}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                </tr>
                                <!-- 认股证 -->
                                <tr align="left">
                                    <td class="col-sm-4" style="padding:8px 20px; font-weight: bold;">认股证</td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_WARRANTS_INVESTMENT_EXPERIENCE_TYPE"
                                                    id="warrantsInvestmentExperienceType"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.warrantsInvestmentExperienceType}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_TRADE_WARRANTS_FREQUENCY"
                                                    id="tradeWarrantsFrequency"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.tradeWarrantsFrequency}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                </tr>
                                <!-- 期权 -->
                                <tr align="left">
                                    <td class="col-sm-4" style="padding:8px 20px; font-weight: bold;">期权</td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_OPTIONS_EXPERIENCE"
                                                    id="optionsExperience"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.optionsExperience}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_TRADE_OPTIONS_FREQUENCY"
                                                    id="tradeOptionsFrequency"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.tradeOptionsFrequency}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                </tr>
                                <!-- 期货 -->
                                <tr align="left">
                                    <td class="col-sm-4" style="padding:8px 20px; font-weight: bold;">期货</td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_FUTURES_INVESTMENT_EXPERIENCE_TYPE"
                                                    id="futuresInvestmentExperienceType"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.futuresInvestmentExperienceType}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_TRADE_FUTURES_FREQUENCY"
                                                    id="tradeFuturesFrequency"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.tradeFuturesFrequency}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                </tr>
                                <!-- 基金 -->
                                <tr align="left">
                                    <td class="col-sm-4" style="padding:8px 20px; font-weight: bold;">单位信托基金/互惠基金</td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_UNIT_TRUSTS_EXPERIENCE"
                                                    id="unitTrustsExperience"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.unitTrustsExperience}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_TRADE_UNIT_TRUSTS_FREQUENCY"
                                                    id="tradeUnitTrustsFrequency"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.tradeUnitTrustsFrequency}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                </tr>
                                <!-- 其他 -->
                                <tr align="left">
                                    <td class="col-sm-4" style="padding:8px 20px; font-weight: bold;">
                                        其他:${customerAccountOpenInfoEntity.otherProductsName}</td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_OTHER_PRODUCTS_EXPERIENCE"
                                                    id="otherProductsExperience"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.otherProductsExperience}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                    <td class="col-sm-2" style="padding:8px 20px">
                                        <tag:select nameKey="AO_TRADE_OTHER_PRODUCTS_FREQUENCY"
                                                    id="tradeOtherProductsFrequency"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${customerAccountOpenInfoEntity.tradeOtherProductsFrequency}"
                                                    clazz="form-control "
                                                    style="width:120px;display:inline"
                                        />
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
            <%--投资经验 End--%>

            <%--衍生产品认知评估-Start--%>
            <div id="div5" v-cloak>
                <div v-show="!showList" class="panel panel-default">
                    <div class="panel-heading"><b style="color: #368763">衍生产品认知评估</b></div>
                    </br>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-12 control-label no-padding-right">对结构性及衍生产品之认识</label>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input type="radio" name="isKnowDerivativeProducts"
                           value="1" <c:if
                            test="${customerAccountOpenInfoEntity.isKnowDerivativeProducts==1}"> checked="checked"</c:if> />有了解
                    <input type="radio" name="isKnowDerivativeProducts"
                           value="0" <c:if
                            test="${customerAccountOpenInfoEntity.isKnowDerivativeProducts==0}"> checked="checked"</c:if> />没有了解
                </span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-12 control-label no-padding-right">曾接受有关结构性及/或衍生产品的培训或修读有关课程</label>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input type="radio" name="derivativeProductsStudyType"
                               value="1"
                               <c:if test="${customerAccountOpenInfoEntity.derivativeProductsStudyType ==1}">checked="true"</c:if>
                        />是
                        <input type="radio" name="derivativeProductsStudyType"
                               value="0"
                               <c:if test="${customerAccountOpenInfoEntity.derivativeProductsStudyType == 0}">checked="true"</c:if>
                        />否
                        <%--<c:forEach var="investTargetCodeEntity"
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
                        <c:if test="${customerAccountOpenInfoEntity.derivativeProductsStudyType == 7}"> &lt;%&ndash;其他的值 &ndash;%&gt;
                            <input class="form-control" style="width:200px;display: inline"
                                   id="derivativeProductsStudyTypeOther" name="derivativeProductsStudyTypeOther"
                                   type="text" readonly
                                   value="${customerAccountOpenInfoEntity.derivativeProductsStudyTypeOther}"
                            />
                        </c:if>--%>
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
                            <label class="col-sm-12 control-label no-padding-right">现时或过去拥有与结构性及/或衍生产品有关的工作经验</label>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input type="radio" name="financingInstitutionWorkExperienceType"
                               value="1"
                               <c:if test="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType ==1}">checked="true"</c:if>
                        />是
                        <input type="radio" name="financingInstitutionWorkExperienceType"
                               value="0"
                               <c:if test="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType == 0}">checked="true"</c:if>
                        />否
                        <%--<c:forEach var="investTargetCodeEntity"
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
                        <c:if test="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType == 4}"> &lt;%&ndash;其他的值 &ndash;%&gt;
                            <input class="form-control" style="width:100px;display: inline"
                                   id="financingInstitutionWorkExperienceTypeOther" readonly
                                   name="financingInstitutionWorkExperienceTypeOther" type="text"
                                   value="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceTypeOther}"
                                   style="width:200px; margin-left:25px; height:34px;"/>
                        </c:if>--%>
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
                            <label class="col-sm-12 control-label no-padding-right">于过去3年曾执行5次或以上有关结构性及/或衍生产品的交易
                                (不论是否在交易所买卖) </label>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <input type="radio" name="isTradedDerivativeProducts"
                               value="1"
                               <c:if test="${customerAccountOpenInfoEntity.isTradedDerivativeProducts ==1}">checked="true"</c:if>
                        />是
                        <input type="radio" name="isTradedDerivativeProducts"
                               value="0"
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
            <%--隐私和税务-Start--%>
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
                           value="1"
                           <c:if  test="${customerAccountOpenInfoEntity.isAllowProvidePrivacy == 1}">checked="checked"</c:if>
                    />是
                    <input type="radio" name="isAllowProvidePrivacy"
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
                                               value="${taxInformationList[i].taxCountry}"
                                               class="form-control">
                                    </span>
                                                </div>
                                            </div>
                                            <div class="form-group col-sm-2 col-md-3">
                                                <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" name="taxNumber[]"
                                               value="${taxInformationList[i].taxNumber}"
                                               class="form-control">
                                    </span>
                                                </div>
                                            </div>
                                            <div class="form-group col-sm-2 col-md-3">
                                                <div class="col-xs-12">
                                            <span class="col-xs-12 block input-icon input-icon-right">
                                                <select name="reasonType[]" class="form-control" >
                                                    <option value="">--- 请下拉选择 ---</option>
                                                    <option value="A"
                                                            <c:if test="${taxInformationList[i].reasonType=='A'}">selected</c:if> >理由 A </option>
                                                    <option value="B"
                                                            <c:if test="${taxInformationList[i].reasonType=='B'}">selected</c:if> >理由 B </option>
                                                    <option value="C"
                                                            <c:if test="${taxInformationList[i].reasonType=='C'}">selected</c:if> >理由 C </option>
                                                </select>
                                            </span>
                                                </div>
                                            </div>
                                            <div class="form-group col-sm-2 col-md-3">
                                                <div class="col-xs-12">
                                            <span class="col-xs-12 block input-icon input-icon-right">
                                                <input type="text" name="reasonDesc[]"
                                                       value="${taxInformationList[i].reasonDesc}"
                                                       class="form-control">
                                            </span>
                                                </div>
                                            </div>

                                        </div>

                                    </c:if>
                                </c:forEach>
                                <div class="row">
                                    <div class="form-group col-sm-12 col-md-12" style="margin: 20px">
                                        <div>无税务编号可选理由：</div>
                                        <div>理由 A – 帐户持有人的居留司法管辖区并没有向其居民发出税务编号。</div>
                                        <div>理由 B – 帐户持有人不能取得税务编号。如选取这一理由，解释帐户持有人不能取得税务编号的原因。</div>
                                        <div>理由 C – 帐户持有人毋须提供税务编号。居留司法管辖区的主管机关不需要帐户持有人披露税务编号。</div>
                                    </div>
                                </div>
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
                            />是
                            <input type="radio"
                                   name="disclosureCode_${openAccountOther.disclosureCode }"
                                   value="${openAccountOther.disclosureIsTrue}"
                            />否
                        </c:if>
                        <c:if test="${openAccountOther.disclosureIsTrue == 0}">
                            <input type="radio"
                                   name="disclosureCode_${openAccountOther.disclosureCode }"
                                   value="${openAccountOther.disclosureIsTrue}"
                            />是
                            <input type="radio"
                                   name="disclosureCode_${openAccountOther.disclosureCode }"
                                   value="${openAccountOther.disclosureIsTrue}" checked="true"
                            />否
                        </c:if>
                    </span>
                            </div>
                            <div class="form-group col-sm-12 col-md-12">
                    <span class="col-sm-12 block input-icon input-icon-right">
                         <%-- 受益人，亲属关系，注册人否的值 --%>
                         <c:if test="${(openAccountOther.disclosureCode <= 20)}">
                             <c:if test="${openAccountOther.disclosureIsTrue ==0 and openAccountOther.disclosureNameJoinDetail!=null}">
                                 <input class="form-control" style="display: inline"
                                        id="disclosureCode" name="disclosureCode" type="text"
                                        value="${openAccountOther.disclosureNameJoinDetail}"
                                        style="width:600px; margin-left:25px; height:34px;"
                                 />
                             </c:if>
                         </c:if>

                        <c:if test="${(openAccountOther.disclosureCode >= 21)}">
                            <c:if test="${openAccountOther.disclosureIsTrue ==1 and openAccountOther.disclosureNameJoinDetail!=null}">
                                 <input class="form-control" style="display: inline"
                                        id="disclosureCode" name="disclosureCode" type="text"
                                        value="${openAccountOther.disclosureNameJoinDetail}"
                                        style="width:600px; margin-left:25px; height:34px;"
                                 />
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
                                <input type="text" class="form-control" value="${addFile.remark}" >
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
                            <input name="remark" type="text" class="form-control"
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
                            <input type="radio" value="${investTargetCodeEntity.value}"
                                   <c:if test="${customerAccountOpenInfoEntity.isAmlSuspicious == 1}">checked="true"</c:if>
                            />有可疑
                            <input type="radio" value="${investTargetCodeEntity.value}"
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
                                <label class="col-sm-4 control-label no-padding-right">客户风险等级</label>
                                <span class="col-sm-8 control-label no-padding-right">
                                    <input type="radio" name="acceptRisk" value="1"
                                           <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 1}">checked="checked"</c:if>
                                    />高风险
                                <input type="radio" name="acceptRisk" value="2"
                                       <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 2}">checked="checked"</c:if> />中风险
                                    <input type="radio" name="acceptRisk" value="3"
                                           <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 3}">checked="checked"</c:if> />低风险
                                </span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-2 control-label no-padding-right">客户帐号</label>
                                <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                <input name="clientId" type="text" class="form-control"
                                       value="${customerAccountOpenInfoEntity.clientId}"


                                />
                            </span>
                                </div>
                            </div>
                        </div>
                        <%-- <div class="row">
                             <div class="form-group col-sm-6 col-md-6">
                                 <label class="col-sm-4 control-label no-padding-right" style="margin-left: 10px">
                                     证券交易账号</label>
                                 <span class="col-xs-8 block input-icon input-icon-right">
                                     <input id="stockTradeAccount" name="stockTradeAccount" type="text" class="form-control"

                                            value="${customerAccountOpenInfoEntity.stockTradeAccount}"/>
                                 </span>
                             </div>
                         </div>--%>
                        <%--<c:if test="${customerAccountOpenInfoEntity.isOpenFutures==1}">
                            <div class="row">
                                <div class="form-group col-sm-6 col-md-6">
                                    <label class="col-sm-4 control-label no-padding-right" style="margin-left: 10px">
                                        期货交易账号</label>
                                    <span class="col-xs-8 block input-icon input-icon-right">
                                    <input id="futuresTradeAccount" name="futuresTradeAccount" type="text" class="form-control"

                                           value="${customerAccountOpenInfoEntity.futuresTradeAccount}"/>
                                </span>
                                </div>
                            </div>
                        </c:if>--%>
                    </c:if>
                </div>
            </div>
            <div style="display:none;">
                <input name="entityClientId" type="text" class="form-control"
                       value="${customerAccountOpenInfoEntity.clientId}" />
            </div>

            <c:if test="${flag==2}">
                <div v-cloak>
                    <c:if test="${accountOpenApplicationEntity.applicationStatus==1 || accountOpenApplicationEntity.applicationStatus==2 || accountOpenApplicationEntity.applicationStatus==3}">
                        <div v-show="!showList" class="panel panel-default">
                            <div class="panel-heading"><b style="color: #368763">审批操作</b></div>
                            </br>
                            <div class="row">
                                <div class="form-group col-sm-6 col-md-6">
                                    <label class="col-sm-4 control-label no-padding-right">
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
                                                </button>
                                                </c:if>
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
                                    <label class="col-sm-4 control-label no-padding-right">客户风险等级</label>
                                    <span class="col-sm-8 control-label no-padding-right">
                                    <input type="radio" name="acceptRisk" value="1" onclick="editAmlRisk();"
                                           <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 1}">checked="checked"</c:if>/>高风险
                                    <input type="radio" name="acceptRisk" value="2" onclick="editAmlRisk();"
                                           <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 2}">checked="checked"</c:if> />中风险
                                    <input type="radio" name="acceptRisk" value="3" onclick="editAmlRisk();"
                                           <c:if test="${customerAccountOpenInfoEntity.acceptRisk == 3 || customerAccountOpenInfoEntity.acceptRisk ==null}">checked="checked"</c:if> />低风险
                                </span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6 col-md-6">
                                    <label class="col-sm-4 control-label no-padding-right">客户账号</label>
                                    <c:choose>
                                        <c:when test="${accountOpenApplicationEntity.applicationStatus ==1 || accountOpenApplicationEntity.applicationStatus ==2}">
                                    <span class="col-sm-6 block input-icon input-icon-right">
                                        <input name="clientId" type="text" class="form-control"
                                               value="${customerAccountOpenInfoEntity.clientId}"/>
                                    </span>
                                            <span class="col-sm-2">
                                        <button type="button" class="layui-btn layui-btn-normal"
                                                onclick="updateClientId();">设置</button>
                                    </span>
                                        </c:when>
                                        <c:otherwise>
                                    <span class="col-sm-6 block input-icon input-icon-right">
                                        <input name="clientId" type="text" class="form-control"
                                               value="${customerAccountOpenInfoEntity.clientId}" />
                                    </span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-12 col-md-12" style="margin: 20px">
                                    <div>客户交易账户说明：</div>
                                    <div>期货交易账号 = F+客户账号</div>
                                    <div>证券现金交易账号 = P+客户账号</div>
                                    <div>证券孖展交易账号 = M+客户账号</div>
                                </div>
                            </div>
                                <%--<c:if test="${customerAccountOpenInfoEntity.isOpenFutures==1}">
                                    <div class="row">
                                        <div class="form-group col-sm-6 col-md-6">
                                            <label class="col-sm-4 control-label no-padding-right" style="margin-left: 10px">
                                                期货交易账号</label>
                                            <span class="col-xs-8 block input-icon input-icon-right">
                                        <input id="futuresTradeAccount" name="futuresTradeAccount" type="text" class="form-control"
                                               value="${customerAccountOpenInfoEntity.futuresTradeAccount}"/>
                                    </span>
                                        </div>
                                    </div>
                                </c:if>--%>
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
        </div>




        <div v-cloak align="center">
            <button type="button" id="formSubmit" class="layui-btn" onclick="infoSubmit();">提交</button>
            <%--<shiro:hasPermission name="customerAcc:doRecheck">
                <button class="layui-btn layui-btn-warm" type="button" onclick="submitDoRecheck()">转入复审</button>
            </shiro:hasPermission>--%>
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
        console.log(123);
        console.log(openAccountInfo);


        if (openAccountInfo['isKnowDerivativeProducts'] == 0) {
            openAccountInfo['derivativeProductsStudyType'] = null;
            openAccountInfo['financingInstitutionWorkExperienceType'] = null;
            openAccountInfo['isTradedDerivativeProducts'] = null;
            openAccountInfo['derivativeProductsStudyTypeOther'] = null;
            openAccountInfo['isTradedDerivativeProducts'] = null;
        }


        openAccountInfo['applicationTime'] = new Date(openAccountInfo['applicationTime']);
        openAccountInfo['isAllowProvidePrivacy'] = $('input[name="isAllowProvidePrivacy"]').filter(':checked').val();
        openAccountInfo['isTradedDerivativeProducts'] = $('input[name="isTradedDerivativeProducts"]').filter(':checked').val();
        openAccountInfo['isAllowProvidePrivacy'] = $('input[name="isAllowProvidePrivacy"]').filter(':checked').val();

        openAccountInfo['isRecheck'] = 0;

        confirm('确定提交', function () {
            console.log(2)
            console.log(openAccountInfo);
            $.ajax({
                type: "POST",
                url: "${webRoot}/customer/haha",
                data:JSON.stringify(openAccountInfo),
                contentType: 'application/json; charset=utf-8',
                dataType: "json",        //返回数据形式为json
                success: function () {
                    confirm('修改成功', function () {
                        //刷新父窗口列表
                        parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    });



                }, error: function (msg) {
                    confirm('修改失败', function () {
                        //刷新父窗口列表
                        parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    });

                }

            });
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
