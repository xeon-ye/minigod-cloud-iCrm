<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <script src="${webRoot}/viewer/js/viewer.js"></script>
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

    #derivativeProductsStudyTypeOther {
        display: inline
    }
</style>
<body>
<div class="layui-tab-content" style="margin-left: 10px">
    <form id="basicInfoForm">
        <div v-cloak align="center" >
            <button type="button" id="formSubmit1" class="layui-btn" onclick="infoSubmit();">确认提交</button>
        </div>
        <input name="openAccountType" style="display: none" value="${customerAccountOpenInfoEntity.openAccountType}">
        <input name="openAccountAccessWay" style="display: none"
               value="${customerAccountOpenInfoEntity.openAccountAccessWay}">
        <input name="inviterId" style="display: none" value="${customerAccountOpenInfoEntity.inviterId}">
        <input name="bankType" style="display: none" value="${customerAccountOpenInfoEntity.bankType}">
        <input name="idCardValidDateStart" style="display: none"
               value="${customerAccountOpenInfoEntity.idCardValidDateStart}">
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
                                <input id="userId" name="userId" type="text" class="form-control"
                                       value="${customerAccountOpenInfoEntity.userId}"/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">渠道</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                           <input id="sourceChannelId" name="sourceChannelId" type="text" class="form-control"
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
        <div id="div0" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">中文名</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="clientName" name="clientName" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.clientName}"/>
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
                        <label class="col-sm-2 control-label no-padding-right">英文/拼音姓名</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="clientNameSpell" name="clientNameSpell" type="text" class="form-control"
                                           value="${customerAccountOpenInfoEntity.clientNameSpell}"/>
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
                            <span class="col-xs-6 block input-icon input-icon-right">
                                <tag:select id="nationality" name="nationality" nameKey="AO_NATIONALITY"
                                            initSelectedKey="${customerAccountOpenInfoEntity.nationality}"
                                            clazz="form-control"/>
                            </span>
                            <span class="col-xs-6 block input-icon input-icon-right">
                                <c:choose>
                                    <c:when test="${customerAccountOpenInfoEntity.nationality == 'OTH'}">
                                        <input id="otherNationality" name="otherNationality" type="text"
                                               class="form-control"
                                               value="${customerAccountOpenInfoEntity.otherNationality}"
                                               placeholder="选择其它国家/地区时填写"/>
                                    </c:when>
                                    <c:otherwise>
                                        <input id="otherNationality" name="otherNationality" type="text"
                                               class="form-control"
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
                        <label class="col-sm-2 control-label no-padding-right">银行名称</label>
                        <div class="col-xs-9" style="display: inline">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                <input style="display: none;" name="bankId" type="text"
                                       value="${customerAccountOpenInfoEntity.bankId}">
                                <input id="otherBankName" name="otherBankName" type="text" class="form-control"
                                       value="${customerAccountOpenInfoEntity.otherBankName}"/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
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
                        <label class="col-sm-3 control-label no-padding-right">银行帐号</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
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
                        <label class="col-sm-1 control-label no-padding-right">住宅地址</label>
                        <div class="col-xs-11">
                                <span class="col-xs-12 block input-icon input-icon-right">
                               <input id="familyAddress" name="familyAddress" type="text" class="form-control"
                                      value="${customerAccountOpenInfoEntity.familyAddress}"/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-1 control-label no-padding-right">通讯地址</label>
                        <div class="col-xs-11">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                <input id="contactAddress" name="contactAddress" type="text"
                                       class="form-control"
                                       value="${customerAccountOpenInfoEntity.contactAddress}"/>

                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-1 control-label no-padding-right">通讯地址拆分</label>
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
                                        name="professionType" isAddDefaltOption="true" clazz="form-control"/>
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
                                        isAddDefaltOption="true" clazz="form-control"
                                        initSelectedKey="${customerAccountOpenInfoEntity.annualIncome}"/>
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
                            <span id="capitalSource2"><input name="capitalSource[]" type="checkbox"
                                                             value="2"/>劳务报酬</span>
                            <span id="capitalSource3"><input name="capitalSource[]" type="checkbox"
                                                             value="3" onclick="changePropertyType(this)"/>不动产租金</span>
                            <span id="capitalSource4"><input name="capitalSource[]" type="checkbox"
                                                             value="4"/>营业收入</span>
                            <span id="capitalSource5"><input name="capitalSource[]" type="checkbox"
                                                             value="5"/>退休金</span>
                            <span id="capitalSource6"><input name="capitalSource[]" type="checkbox"
                                                             value="6"/>家人给予</span>
                            <span id="capitalSource7"><input name="capitalSource[]" type="checkbox"
                                                             value="7"/>兼职收入</span>
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
                                                        <c:forEach items="${openAccountPropertyList}"
                                                                   var="propertyInfo">
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
                                                </span>
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

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">风险承受程度</label>
                        <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right">
                             <input type="radio" name="acceptRisk" value="1"
                                     <c:if test="${customerAccountOpenInfoEntity.acceptRisk==1}"> checked="checked"</c:if> />低风险
                             <input type="radio" name="acceptRisk" value="2"
                                     <c:if test="${customerAccountOpenInfoEntity.acceptRisk==2}"> checked="checked"</c:if> />中风险
                            <input type="radio" name="acceptRisk" value="3"
                                    <c:if test="${customerAccountOpenInfoEntity.acceptRisk==3}"> checked="checked"</c:if> />高风险
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
                        <label class="col-sm-12 control-label no-padding-right">您对衍生品是否有认识？</label>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-12 block input-icon input-icon-right">
                             <input type="radio" name="isKnowDerivativeProducts" onclick="showProducts();"
                                    value="1" <c:if
                                     test="${customerAccountOpenInfoEntity.isKnowDerivativeProducts==1}"> checked="checked"</c:if> />是
                             <input type="radio" name="isKnowDerivativeProducts" onclick="hideProducts();"
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

                                <%--<c:if test="${customerAccountOpenInfoEntity.derivativeProductsStudyType == 7}"> &lt;%&ndash;其他的值 &ndash;%&gt;--%>
                                    <input class="form-control" style="width:150px;display: inline"
                                           id="derivativeProductsStudyTypeOther" name="derivativeProductsStudyTypeOther"
                                           type="text"
                                           value="${customerAccountOpenInfoEntity.derivativeProductsStudyTypeOther}"
                                    />
                                <%--</c:if>--%>
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

                                <%--<c:if test="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType == 4}"> &lt;%&ndash;其他的值 &ndash;%&gt;--%>
                                    <input class="form-control" style="width:150px;display: inline"
                                           id="financingInstitutionWorkExperienceTypeOther"
                                           name="financingInstitutionWorkExperienceTypeOther" type="text"
                                           value="${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceTypeOther}"
                                           style="margin-left:25px; height:34px;"/>
                                <%--</c:if>--%>
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
                    <label class="col-sm-12 control-label no-padding-right">您是否确认《个人资料（私隐）条例通知》并同意宝新证券及其控股集团使用及向其他人士提供本人的个人资料作直接促销用途。</label>
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
                                    <input type="radio" name="northTrade" value="1"
                                           <c:if test="${customerAccountOpenInfoEntity.northTrade == 1}">checked="checked"</c:if>
                                    />是
                                    <input type="radio" name="northTrade" value="0"
                                           <c:if test="${customerAccountOpenInfoEntity.northTrade == 0}">checked="checked"</c:if>
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
                                    <input type="radio" name="FATCA" value="1" onclick="chooseFATCA();"
                                           <c:if test="${customerAccountOpenInfoEntity.fatca == 1}">checked="checked"</c:if>
                                    />是
                                    <input type="radio" name="FATCA" value="0" onclick="chooseFATCA();"
                                           <c:if test="${customerAccountOpenInfoEntity.fatca == 0}">checked="checked"</c:if>
                                    />否
                            <c:choose>
                            <c:when test="${customerAccountOpenInfoEntity.fatca == 1}">
                                <span id="theUSTax">
                                <span style="color:red;margin-left: 30px">*</span>美国纳税人识别号码(TIN)
                                <input class="form-control" maxlength="20" style="width:200px;display: inline"
                                       id="theUSTaxNum" name="theUSTaxNum" placeholder="输入不超过20个字符"
                                       value="${customerAccountOpenInfoEntity.theUSTaxNum}" type="text"/>
                            </c:when>
                            <c:otherwise>
                                <span id="theUSTax" style="display: none">
                                <span style="color:red;margin-left: 30px">*</span>美国纳税人识别号码(TIN)
                                <input class="form-control" maxlength="20" style="width:200px;display: inline"
                                       id="theUSTaxNum" name="theUSTaxNum"
                                       placeholder="输入不超过20个字符" type="text"/>
                                </span>
                            </c:otherwise>
                            </c:choose>
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
                <div class="panel-heading"><b style="color: #368763">身份资料披露</b></div>
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
                            <c:if test="${openAccountOther.disclosureCode ==1 || openAccountOther.disclosureCode ==2 ||
                            openAccountOther.disclosureCode ==3 || openAccountOther.disclosureCode >10}">
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

        <div id="div8" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">客户声明及确认</b></div>
                </br>
                <div class="row">
                <span class="form-group col-sm-12 control-label no-padding-right">
                    本人声明就本人所知所信，税务信息内所填报的所有资料和声明均属真实、正确和完备。</span>
                    <span class="form-group col-sm-12 control-label no-padding-right">
                    本人知悉、明白和同意「智珠证券」可根据有关交换财务帐户资料的法令规定或政府间协议(a)收集本税务信息部分所载资料并可备存作自动交换财务帐户资料用途及
                (b)把该等资料和关于帐户持有人及任何须申报帐户的资料向财务帐户所设立的国家的税务机关及╱或美国国税局申报，
                从而把资料转交到帐户持有人的居留司法管辖区的税务当局。</span>
                    <span class="form-group col-sm-12 control-label no-padding-right">
                    本人承诺，如情况有所改变，以致影响本税务信息部分所述的个人的税务居民身份，或引致本税务信息部分所载的资料不正确或不完备，
                    本人会在情况发生改变后三十(30)天内，通知「智珠证券」，并提供一份已适当更新的自我证明表格。
                    </span>
                    <span class="form-group col-sm-12 control-label no-padding-right">
                依照客户协议中的电子交易服务的条款及条件，开立及维持一个电子交易服务的现金证券买卖户口，并为本人提供一个登入名称及密码以便使用「智珠证券」
                电子交易服务。本人将获取股票电子交易密码以便本人进行买卖交易。本人完全明白户口密码是绝对保密。本人须对「智珠证券」核实密码后被接纳的所有买卖、
                损失、费用及支出负全部责任。</span>
                    <span class="col-sm-12 control-label no-padding-right">
                    本人同意以电邮形式收取结单╱通告，结单╱通告将电邮至开户申请表所列本人之电邮地址，并同意「智珠证券」不再另行邮寄结单╱通告到本人之通讯地址，
                    本人承诺如本人之电邮地址有变更，会于七(7)天内通知「智珠证券」。</span>
                    <span class="form-group col-sm-12 control-label no-padding-right">
                    * 若以电邮形式收取结单╱通告，于结单╱通告发出时，本人将被视作已收到该结单╱通告。</span>
                    <span class="form-group col-sm-12 control-label no-padding-right">
                    本人清楚明白并愿意承担因额外要求以邮寄形式收取结单╱通告而产生相应的一切费用，且本人承诺如本人之通讯地址有变更，会于七(7)天内通知「智珠证券」。</span>
                    <span class="form-group col-sm-12 control-label no-padding-right">
                    本人于「智珠证券」开立一个或多个现金证券买卖户口（下称「该户口」）以进行证券买卖。智珠证券同意不时应本人要求,
                    按其独自酌情权让本人在「智珠证券」开立一个或多个户口并以代理人身份行事（除非客户协议之条款及条件中特别注明「智珠证券」为主事人）。</span>
                    <span class="form-group col-sm-12 control-label no-padding-right">
                    本人现声明已阅悉及同意「智珠证券」开户申请表，并已填写各项客户资料，及已阅悉及同意客户协议中的条例及条件。个人一自我证明表格说明（FATCA及CRS）、
                个人资料（私隐）条例通知、予沪港通及深港通客户通知、有关中华通证券北向交易的个人资料搜集声明及证券帐户风险披露声明。
                    上述所有文件均构成「智珠证券」与本人就该户口达成的协议。</span>
                    <span class="form-group col-sm-12 control-label no-padding-right">
                本人现声明及确认由「智珠证券」给予本人之协议，包括但不限于客户协议中的风险披露声明、个人一自我证明表格说明（FATCA及CRS）、
                个人资料（私隐）条例通知、予沪港通及深港通客户通知、有关中华通证券北向交易的个人资料搜集声明以及证券帐户风险披露声明，智珠证券」
                是按本人选择的语言提供。本人获邀请阅读证券帐户风险披露声明、个人一自我证明表格说明（FATCA及CRS）、个人资料（私隐）条例通知、
                予沪港通及深港通客户通知、有关中华通证券北向交易的个人资料搜集声明、提出问题，并按本身意愿选择是否听取独立法律意见。
                本人已获解释该证券帐户风险披露声明。</span>
                    <span class="form-group col-sm-12 control-label no-padding-right">
                    本人现授权「智珠证券」接受任何本人发出之传真及/或电邮讯息为原本指示及就「智珠证券」因执行此指示而招致、蒙受或遭受一切损失、赔款、利息、成本、
                费用及一切因法律行动而招致、蒙受或遭受之索偿，本人须向「智珠证券」作出赔偿保证及保障「智珠证券」不会因此蒙受损失。本人免除「智珠证券」
                    因此授权所引起的责任及损害。</span>
                    <span class="form-group col-sm-12 control-label no-padding-right">
                    本人现声明在开户申请表内的资料属真实、完整及正确，随附客户协议内之一切声明亦准确。除非「智珠证券」接到书面更改通知，否则「智珠证券」
                    有权为所有目的，完全依赖这些资料及声明。「智珠证券」有权随时联络任何人，包括本人之银行、经纪或任何信贷调査机构，以求证实此开户申请表内所载之内容。</span>
                </div>
                <label class="control-label no-padding-right"><input id="mustSure2" type="checkbox" checked="checked"/>
                    本人同意上述安排及选择。</label>
            </div>
        </div>
    </form>

    <input id="witnessFlag" style="display: none" type="text" value="${witnessesFileList[0]==null}">
    <form id="witnessForm">
        <div id="div15" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">见证人与审批人</b></div>
                </br>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">见证人姓名</label>
                        <div class="col-xs-9">
                            <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="witnessUser" name="witnessUser" type="text" class="form-control"
                                           value="${accountOpenApplicationEntity.witnessUser}"/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">审批人姓名</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="submitApprovalUser" name="submitApprovalUser" type="text"
                                           class="form-control"
                                           value="${accountOpenApplicationEntity.submitApprovalUser}"/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">见证人类型</label>
                        <div class="col-xs-9">
                               <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="witnessesType" name="witnessesType" type="text" class="form-control"
                                           value="${accountOpenApplicationEntity.witnessesType}"/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">牌照号码</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="licenseNumber" name="licenseNumber" type="text" class="form-control"
                                           value="${accountOpenApplicationEntity.licenseNumber}"/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div id="witnessesCard" class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right"> 见证人证书</label>
                        <div class="col-xs-9">
                        <span class="col-xs-12 block control-label no-padding-right">
                        <c:if test="${witnessesFileList!=null}">
                            <c:forEach begin="0" end="2" step="1" var="i">
                                <c:if test="${witnessesFileList[i]!=null}">
                                    <div class="layui-btn-group">
                                        <a class="layui-btn layui-btn-normal layui-btn-mini"
                                           href='${webRoot}/common/downloadFile?fullFilePath=${witnessesFileList[i].filePath}${witnessesFileList[i].fileStorageName}.${witnessesFileList[i].fileExtName}'>【见证人证书(${i+1})】</a>
                                        <button type="button"
                                                class="layui-btn layui-btn-primary layui-btn-mini"
                                                onclick="delWitnessInfo(${witnessesFileList[i].id});">
                                            <i class="layui-icon">&#xe640;</i>
                                        </button>
                                    </div>
                                </c:if>
                                <c:if test="${witnessesFileList[i]==null}">
                                    <button name="upLoadWitnesses" style="width: 100px;display: inline"
                                            class="layui-btn layui-btn-primary layui-btn-mini">上传[见证人证书]</button>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </span>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </form>


    <div v-cloak align="center">
        <button type="button" id="formSubmit" class="layui-btn" onclick="infoSubmit();">提交</button>
    </div>
</div>
</body>

<script type="text/javascript">

    $(function () {
        //初始化职业类型，收入来源
        onChangeProfessionCode('${customerAccountOpenInfoEntity.professionCode}', '${customerAccountOpenInfoEntity.capitalSource}');

        <c:forEach var="obj" items="${openAccountOtherDisclosureList}">
        initOtherDisclosureDetail('${obj.disclosure1}', '${obj.disclosure2}', '${obj.disclosure3}', '${obj.disclosure4}', ${obj.disclosureCode});
        </c:forEach>

        //请选择您接收衍生产品相关的培训或课程的方式、您在经纪公司或银行，基金或资产管理公司，监管机构或交易所等金融机构拥有以下工作经验  隐藏其他值的输入框
        if ('${customerAccountOpenInfoEntity.financingInstitutionWorkExperienceType}' != '4') {
            //隐藏其他输入框，
            $("#financingInstitutionWorkExperienceTypeOther").attr("style", "display:none");
        }

        if ('${customerAccountOpenInfoEntity.derivativeProductsStudyType}' != '7') {
            //隐藏其他输入框，
            $("#derivativeProductsStudyTypeOther").attr("style", "display:none");
        }


    });
    $("#professionCode").change(function () {
        onChangeProfessionCode($("#professionCode").val(), "");
    });

    function onChangeProfessionCode(professionCode, capitalSource) {
        //初始化勾选值
        if (capitalSource != "") {
            $(capitalSource.toString().split(",")).each(function (i, value) {
                $("input[name='capitalSource[]'][value='" + value + "']").prop("checked", true);
            });
        }
        if (professionCode == "1")//受雇
        {
            $("#jobPosition").removeAttr("disabled", "disabled");
            $("#companyName").removeAttr("readonly", "readonly");
            $("#companyAddress").removeAttr("readonly", "readonly");
            $("#professionType").removeAttr("disabled", "disabled");

        } else if (professionCode == "2") {//个体户
            $("#jobPosition").attr("disabled", "disabled").val("");
            $("#companyName").removeAttr("readonly", "readonly");
            $("#companyAddress").removeAttr("readonly", "readonly");
            $("#professionType").removeAttr("disabled", "disabled");

        } else if (professionCode == "3" || professionCode == "4" || professionCode == "5")//学生 自由职业者 家庭主妇
        {
            $("#jobPosition").attr("disabled", "disabled").val("");
            $("#companyName").attr("readonly", "readonly").val("");
            $("#companyAddress").attr("readonly", "readonly").val("");
            $("#professionType").attr("disabled", "disabled").val("");

        } else if (professionCode == "6")//农林牧副渔
        {
            $("#jobPosition").attr("disabled", "disabled").val("");
            $("#companyName").attr("readonly", "readonly").val("");
            $("#companyAddress").attr("readonly", "readonly").val("");
            $("#professionType").attr("disabled", "disabled").val("");

        } else if (professionCode == "7")//退休
        {

            $("#jobPosition").attr("disabled", "disabled");
            $("#companyName").attr("readonly", "readonly");
            $("#companyAddress").attr("readonly", "readonly");
            $("#professionType").attr("disabled", "disabled");
        }
    }


    function infoSubmit() {
        var isChecked2 = $('#mustSure2').is(":checked");
        if (!isChecked2) {
            alertMsg("请勾选服务协议");
            return;
        }

        if ("true" == $("#witnessFlag").val()) {
            alertMsg("请上传见证人证书");
            return;
        }
        var openAccountInfo = $('#basicInfoForm').all_serialize();
        if (openAccountInfo['isKnowDerivativeProducts'] == 0) {
            openAccountInfo['derivativeProductsStudyType'] = null;
            openAccountInfo['financingInstitutionWorkExperienceType'] = null;
            openAccountInfo['isTradedDerivativeProducts'] = null;
            openAccountInfo['derivativeProductsStudyTypeOther'] = null;
            openAccountInfo['isTradedDerivativeProducts'] = null;
        }

        if (openAccountInfo['professionCode'] == 1 || openAccountInfo['professionCode'] == 2) {
            if (openAccountInfo['companyName'] == "") {
                alertMsg("请填写公司名称");
                return;
            } else if (openAccountInfo['companyAddress'] == "") {
                alertMsg("请填写公司地址");
                return;
            } else if (openAccountInfo['professionType'] == "") {
                alertMsg("请填写所属行业");
                return;
            } else if (openAccountInfo['professionCode'] == 1 && openAccountInfo['jobPosition'] == "") {
                alertMsg("请填写职位级别");
                return;
            }
        }

        openAccountInfo['isKnowDerivativeProducts'] = $("input[name='isKnowDerivativeProducts']:checked").val();
        if (openAccountInfo['isKnowDerivativeProducts'] == 1) {
            if (openAccountInfo['derivativeProductsStudyType'] == null &&
                openAccountInfo['financingInstitutionWorkExperienceType'] == null &&
                (openAccountInfo['isTradedDerivativeProducts'] == null || openAccountInfo['isTradedDerivativeProducts'] == "0")) {
                alert("请至少勾选一种衍生产品认知!");
                return;
            }
        }

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
        if (openAccountInfo['stocksInvestmentExperienceType'] == "" || openAccountInfo['warrantsInvestmentExperienceType'] == "" || openAccountInfo['futuresInvestmentExperienceType'] == "") {
            alertMsg("请选择投资经验");
            return;
        }
        //【结束】

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
                if (null == flag) {
                    alertMsg("身份资料申报中有选项未勾选");
                    return;
                }
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
                }
                disclosureJson.disclosureIsTrue = flag;
            }
            otherInfoJsonList.push(disclosureJson)
        }
        openAccountInfo['otherInfo'] = JSON.stringify(otherInfoJsonList);
        //其他信息披露  数据拼接 【结束】

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
                    } else {
                        alertMsg("请填写税务编号或理由");
                        return;
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

        if (openAccountInfo['isAllowProvidePrivacy'] == null) {
            alertMsg("请勾选是否确认个人资料（私隐）条例！");
            return;
        }
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
            if ('1' == FATCA) {
                var theUSTaxNum = $("#theUSTaxNum").val();
                if (theUSTaxNum.length == 0 || theUSTaxNum == '') {
                    alertMsg("请输入美国纳税人识别号码");
                    return;
                }else{
                    openAccountInfo['theUSTaxNum'] = theUSTaxNum;
                }
            }
        }

        //见证人
        var witnessInfo = $('#witnessForm').serializeJSON();
        openAccountInfo['witnessUser'] = witnessInfo['witnessUser'];
        openAccountInfo['witnessesType'] = witnessInfo['witnessesType'];
        openAccountInfo['licenseNumber'] = witnessInfo['licenseNumber'];
        openAccountInfo['submitApprovalUser'] = witnessInfo['submitApprovalUser'];

        openAccountInfo['sourceChannelId'] = $("#sourceChannelId").val();
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
                                url: "${webRoot}/offlineCustAccOpen/custAccOpenEditSubmit",
                                data: JSON.stringify(openAccountInfo),
                                contentType: 'application/json',
                                dataType: "json",        //返回数据形式为json
                                success: function (r) {
                                    if (r.code == 0) {
                                        alert(r, function (index) {
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
                    url: "${webRoot}/offlineCustAccOpen/custAccOpenEditSubmit",
                    data: JSON.stringify(openAccountInfo),
                    contentType: 'application/json',
                    dataType: "json",        //返回数据形式为json
                    success: function (r) {
                        if (r.code == 0) {
                            alert(r, function (index) {
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

        //上传见证人证书
        var reButton = document.getElementsByName('upLoadWitnesses');
        for (var i = 0; i < reButton.length; i++) {
            var applicationId = '${customerAccountOpenInfoEntity.applicationId}';
            new AjaxUpload(reButton[i], {
                action: '${webRoot}/offlineCustAccOpen/uploadFile',
                name: 'file',
                contentType: "application/json;charset=UTF-8",
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    fileType: 4
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(jpg|jpeg|png|bmp|pdf)$/.test(extension.toLowerCase()))) {
                        alert('只支持jpg、jpeg、png、bmp、pdf格式的文件！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/offlineCustAccOpen/witnessesRefresh?applicationId=${customerAccountOpenInfoEntity.applicationId}",
                            timeout: 3000, success: function (page) {

                                $.ajaxPrefilter('script', function (options) {
                                    options.cache = true;
                                });

                                $("#witnessFlag").remove();
                                $("#witnessesCard").html(page);
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

    //您是否有意进行衍生品买卖   否
    function hideProducts() {
        //清空值
        $("input:radio[name='derivativeProductsStudyType']").attr("checked", false);
        $("#derivativeProductsStudyTypeOther").val("");
        $("input:radio[name='financingInstitutionWorkExperienceType']").attr("checked", false);
        $("#financingInstitutionWorkExperienceTypeOther").val("");
        $("input:radio[name='isTradedDerivativeProducts']").attr("checked", false);


        $("#isKnowProducts").find('input').attr("disabled", "disabled").attr("readonly", "readonly");
    }

    //您是否有意进行衍生品买卖   是
    function showProducts() {
        $("#isKnowProducts").find('input').removeAttr("disabled", "disabled").removeAttr("readonly", "readonly");
    }

    //请选择您接收衍生产品相关的培训或课程的方式 当选中的值为其他显示其他输入框
    $('input[type=radio][name=derivativeProductsStudyType]').change(function () {

        var derivativeProductsStudyType = $("input[name='derivativeProductsStudyType']:checked").val();
        if (derivativeProductsStudyType == 7) {
            //显示其他输入框
            $("#derivativeProductsStudyTypeOther").attr("style", "display:inline;width:150px");
        } else {
            //隐藏其他输入框，同清空输入框的值
            $("#derivativeProductsStudyTypeOther").val("");
            $("#derivativeProductsStudyTypeOther").attr("style", "display:none");
        }

    });

    //您在经纪公司或银行，基金或资产管理公司，监管机构或交易所等金融机构拥有以下工作经验   当选中的值为其他显示其他输入框
    $('input[type=radio][name=financingInstitutionWorkExperienceType]').change(function () {
        var financingInstitutionWorkExperienceType = $("input[name='financingInstitutionWorkExperienceType']:checked").val();
        if (financingInstitutionWorkExperienceType == 4) {
            //显示其他输入框
            $("#financingInstitutionWorkExperienceTypeOther").attr("style", "display:inline;width:150px");
        } else {
            //隐藏其他输入框，同清空输入框的值
            $("#financingInstitutionWorkExperienceTypeOther").val("");
            $("#financingInstitutionWorkExperienceTypeOther").attr("style", "display:none");
        }

    });

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

    $.fn.all_serialize = function () {
        var info = this.serializeJSON();
        $(':radio', this).each(function () {
            if ($("input[name='" + this.name + "']:checked").length == 0) {
                info[this.name] = null;
            }
        });
        $(':checkbox', this).each(function () {
            if ($("input[name='" + this.name + "']:checked").length == 0) {
                info[this.name] = null;
            }
        });

        return info;
    };

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

    $("#nationality").change(function () {
        var nationality = $("#nationality").val();
        if ("OTH" == nationality) {
            $("#otherNationality").val('');
            $("#otherNationality").attr("style", "display:inline");
        } else {
            $("#otherNationality").attr("style", "display:none");
        }
    });

    function chooseFATCA() {
        var FATCA = $('input:radio[name="FATCA"]:checked').val();
        if ('0' == FATCA) {
            $("#theUSTaxNum").val('');
            $("#theUSTax").attr("style", "display:none");
        } else {
            $("#theUSTax").attr("style", "display:inline");
        }
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
                new_col.innerHTML = "<span>亲属关系：</span>";
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
                    new_col.innerHTML = "<span>亲属关系：</span>";
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

    /**
     * 删除见证人 文件信息
     */
    function delWitnessInfo(id) {
        confirm("您确定要删除吗?", function () {
            var url = "${webRoot}/offlineCustAccOpen/delFileInfo";
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
                        url: "${webRoot}/offlineCustAccOpen/witnessesRefresh?applicationId=${customerAccountOpenInfoEntity.applicationId}",
                        timeout: 3000, success: function (page) {

                            $.ajaxPrefilter('script', function (options) {
                                options.cache = true;
                            });

                            $("#witnessFlag").remove();
                            $("#witnessesCard").html(page);
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

    layui.laydate.render({
        elem: '#idCardValidDateEnd' //指定元素
    });
</script>
</html>
