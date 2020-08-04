<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<html lang="en">
<head>
    <script src="${webRoot}/js/ajaxupload.js"></script>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <script type="text/javascript" src="${webRoot}/js/jquery.validate.js"></script>
    <script src="${webRoot}/js/jquery.serializejson.js"></script>
</head>
<style type="text/css">
    .divX {
        z-index: 200;
        -moz-border-radius: 20px;
        -webkit-border-radius: 20px;
        line-height: 10px;
        text-align: center;
        font-weight: bold;
        cursor: pointer;
        font-size: 10px;
        display: none;
    }


    #investTarget {
        display: inline
    }

    #derivativeProductsStudyTypeOther {
        display: inline
    }
</style>
<body style="width:99%;">
<div class="layui-tab-content" style="margin-left: 10px">
    <input style="display: none" id="submitCode" value="0">
    <form id="basicInfoForm" class="basicInfoForm" name="basicInfoForm">
        <div id="div1" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">预约信息</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-xs-2 control-label no-padding-right">预约号</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input style="display:inline;width: 75%" id="applicationId" name="applicationId"
                                       type="text" class="form-control" value="${applicationId}" readonly/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">渠道号</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                               <input style="display:inline;width: 75%" id="sourceChannelId" name="sourceChannelId"
                                      type="text" class="form-control" value="1" placeholder="请输入渠道号"/>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-xs-2 control-label no-padding-right">客户账号</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input style="display:inline;width: 75%" id="clientId" name="clientId" type="text"
                                       class="form-control"/>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="div2" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-xs-2 control-label no-padding-right">中文名</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="clientName" name="clientName" type="text" class="form-control"
                                           maxlength="50" style="display:inline;width: 75%"
                                           placeholder="请输入中文名"/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>移动电话</label>
                        <div class="col-xs-9" style="display: inline">
                            <span class="col-xs-3 block input-icon input-icon-right">
                                  <tag:select data="${phoneAreaCodeList}" isAddDefaltOption="true" isJXdata="true"
                                              id="phoneAreaCode"
                                              clazz="form-control"></tag:select>
                            </span>
                            <span class="col-xs-6 block input-icon input-icon-right">
                                    <input id="phoneNumber" name="phoneNumber" style="display:inline;" type="text"
                                           class="form-control" placeholder="请输入移动电话" required/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-xs-2 control-label no-padding-right"><span style="color: red">*</span>英文/拼音姓名</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="clientNameSpell" name="clientNameSpell" maxlength="50" type="text"
                                           class="form-control" style="display:inline;width: 75%"
                                           placeholder="请输入英文/拼音姓名" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>电子邮箱</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                 <input id="email" name="email" type="email" class="form-control"
                                        style="display:inline;width: 75%"
                                        placeholder="请输入电子邮箱" required/>
                                </span>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-xs-2 control-label no-padding-right"><span
                                style="color: red">*</span>性别</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                                    <tag:select nameKey="COMMON_SEX" id="sex" name="sex"
                                                                isAddDefaltOption="true"
                                                                clazz="form-control "
                                                                style="display:inline;width: 75%"/>
                                </span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>出生日期</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="birthday" name="birthday" type="text" class="form-control"
                                           style="display:inline;width: 75%" placeholder="请选择出生日期" required/>
                                </span>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-xs-2 control-label no-padding-right"><span
                                style="color: red">*</span>证件类型</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <tag:select nameKey="AO_ID_KIND" id="idKind" name="idKind" isAddDefaltOption="true"
                                                clazz="form-control " style="display:inline;width: 75%"/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>国家/地区</label>
                        <div class="col-xs-9">
                            <span class="col-xs-6 block input-icon input-icon-right">
                                    <tag:select id="nationality" name="nationality" nameKey="AO_NATIONALITY"
                                                isAddDefaltOption="true"
                                                clazz="form-control"/>
                            </span>
                            <span class="col-xs-6 block input-icon input-icon-right">
                                      <input style="display: none;" id="otherNationality" name="otherNationality"
                                             type="text" class="form-control"/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-xs-2 control-label no-padding-right"><span
                                style="color: red">*</span>证件号</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="idNo" name="idNo" type="text" class="form-control"
                                           style="display:inline;width: 75%"
                                           maxlength="50" placeholder="请输入证件号" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">银行名称</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <%--银行名称由字典改为输入框，默认写入字典值"OTHERS"--%>
                                    <input style="display: none;" name="bankId" type="text" value="OTHERS">
                                    <input id="otherBankName " name="otherBankName" type="text" class="form-control"
                                           style="display:inline;width: 75%" maxlength="50" placeholder="请输入银行名称"/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-xs-2 control-label no-padding-right">证件有效期至</label>
                        <div class="col-xs-9">
                                <span class="col-xs-6 block input-icon input-icon-right">
                                    <input id="idCardValidDateEnd" name="idCardValidDateEnd" type="text"
                                           style="display:inline;width: 100%"
                                           class="form-control"
                                           placeholder="请选择证件失效日期"/>
                                </span>
                            <span class="col-xs-2 block input-icon input-icon-right">
                                      <input class="layui-btn layui-btn-small layui-btn-primary" id="idCardValidForever"
                                             type="button" style="display: inline;width: 50px" value="长期"/>
                                </span>
                        </div>

                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">银行户名</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <input id="bankAccountName" name="bankAccountName" type="text" class="form-control"
                                           style="display:inline;width: 75%"
                                           maxlength="50" placeholder="请输入银行户名"/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-xs-2 control-label no-padding-right">账户类型</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                     <input name="fundAccountType" type="radio" value="1" checked="checked"/> 现金账户
                                     <input name="fundAccountType" type="radio" value="2"/> 融资账户
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">银行帐号</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input class="form-control" id="bankNo" name="bankNo" type="number"
                                       placeholder="请输入银行账号"
                                       style="display:inline;width: 75%"
                                       maxlength="50" style="height:34px; margin-right: 0px;"/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-1 control-label no-padding-right"><span
                                style="color: red;">*</span>住宅地址</label>
                        <div class="col-xs-10" style="display:inline;">
                               <span class="col-xs-12 block input-icon input-icon-right">
                               <input id="familyAddress" name="familyAddress" type="text" maxlength="100"
                                      class="form-control"
                                      placeholder="请输入住宅地址" required/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-1 control-label no-padding-right"><span
                                style="color: red">*</span>通讯地址</label>
                        <div class="col-xs-10">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                <input id="contactAddress" name="contactAddress" type="text"
                                       class="form-control" style="display:inline;" maxlength="100"
                                       placeholder="请输入通讯地址" required/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-1 control-label no-padding-right">通讯地址拆分</label>
                        <div class="col-xs-10">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                <input name="contactProvinceName" type="text" placeholder="输入省"
                                       class="form-control" style="width: 15%;display: inline"/>
                                <input name="contactCityName" type="text" placeholder="输入市"
                                       class="form-control" style="width: 15%;display: inline"/>
                                <input name="contactCountyName" type="text" placeholder="输入区"
                                       class="form-control" style="width: 15%;display: inline"/>
                                <input name="contactDetailAddress" type="text" placeholder="详细地址"
                                       class="form-control" style="display: inline;width: 54%;"/>
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
                                            isAddDefaltOption="true"
                                            clazz="form-control " style="display:inline;width: 75%"/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">所属行业</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <tag:select nameKey="AO_OCCUPATION_TYPE" id="professionType" name="professionType"
                                            isAddDefaltOption="true"
                                            clazz="form-control" style="display:inline;width: 75%"/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right">公司名称</label>
                        <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right">
                            <input id="companyName" name="companyName" style="display:inline;width: 75%" type="text"
                                   maxlength="100" class="form-control" placeholder="请输入公司名称"/>
                        </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">职位级别</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <tag:select nameKey="AO_JOB_POSITION" id="jobPosition" name="jobPosition"
                                            isAddDefaltOption="true" clazz="form-control"
                                            style="display:inline;width: 75%"/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-1 control-label no-padding-right">公司地址</label>
                        <div class="col-xs-10">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input id="companyAddress" name="companyAddress" type="text" maxlength="100"
                                       style="display:inline;" class="form-control" placeholder="请输入公司地址"/>
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
                        <label class="col-sm-2 control-label no-padding-right"><span
                                style="color: red">*</span>全年收入</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                  <tag:select nameKey="AO_INCOME" id="annualIncome" name="annualIncome"
                                              isAddDefaltOption="true" clazz="form-control "
                                              style="display:inline;width: 75%"/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right"><span
                                style="color: red">*</span>收入来源</label>
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
                            <label class="col-sm-2 control-label no-padding-right"><span style="color: red">*</span>财产种类</label>
                            <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right" style="width:1000px">
                                        <c:forEach begin="0" end="2" step="1" var="i">
                                            <span>
                                                <input style="display: inline;" name="propertyType[]" value="${i+1}"
                                                       type="checkbox"/> ${fns:getCodeName("AO_PROPERTY_TYPE",i+1)}
                                                 <tag:select name="propertyAmount[]" nameKey="AO_PROPERTY_TYPE_${i+1}"
                                                             clazz="form-control" style="width:150px;display:inline"
                                                             isAddDefaltOption="true"/>港币
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
                        <label class="col-sm-2 control-label no-padding-right"><span
                                style="color: red">*</span>投资目标</label>
                        <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right" style="width:1000px">
                         	<tag:checkbox nameKey="AO_INVEST_TARGET" id="investTarget" name="investTarget[]"
                                          clazz="display:inline" initDidableKey="2,3"/>
                            <input class="form-control " style="width: 200px;display: inline" maxlength="50"
                                   id="investTargetOther" name="investTargetOther" type="text"
                                   placeholder="输入不超过50个字符"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right"><span
                                style="color: red">*</span>投资经验</label>

                        <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right" style="width:800px">

                            <span>股票/基金/债券</span>
                                <tag:select nameKey="AO_STOCKS_INVESTMENT_EXPERIENCE_TYPE" isAddDefaltOption="true"
                                            id="stocksInvestmentExperienceType" name="stocksInvestmentExperienceType"
                                            clazz="form-control " style="width:120px;display:inline"/>

                            <span style="margin-left:20px;">认股证/股票期权</span>
                                 <tag:select nameKey="AO_WARRANTS_INVESTMENT_EXPERIENCE_TYPE"
                                             id="warrantsInvestmentExperienceType"
                                             name="warrantsInvestmentExperienceType" isAddDefaltOption="true"
                                             clazz="form-control " style="width:120px;display:inline"/>

                            <span style="margin-left:20px;">期货/期权</span>
                                <tag:select nameKey="AO_FUTURES_INVESTMENT_EXPERIENCE_TYPE" isAddDefaltOption="true"
                                            id="futuresInvestmentExperienceType" name="futuresInvestmentExperienceType"
                                            clazz="form-control " style="width:120px;display:inline"/>
                        </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-2 control-label no-padding-right"><span
                                style="color: red">*</span>风险承受程度</label>
                        <div class="col-xs-9">
                        <span class="col-xs-12 block input-icon input-icon-right">
                             <input type="radio" name="acceptRisk" value="1"/>低风险
                             <input type="radio" name="acceptRisk" value="2"/>中风险
                             <input type="radio" name="acceptRisk" value="3"/>高风险
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
                        <label class="col-sm-12 control-label no-padding-right"><span style="color: red">*</span>您对衍生品是否有认识？</label>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                        <div id="products">
                            <span class="col-xs-12 block input-icon input-icon-right">
                             <input id="isKnowDerivativeProducts" type="radio" name="isKnowDerivativeProducts"
                                    onclick="showProducts();"
                                    value="1"/>是
                             <input type="radio" name="isKnowDerivativeProducts" checked="checked"
                                    onclick="hideProducts();"
                                    value="0"/>否
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-12 control-label no-padding-right">请选择您接收衍生产品相关的培训或课程的方式</label>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-9 block input-icon input-icon-right">
                        	<c:forEach var="investTargetCodeEntity"
                                       items="${fns:getCodeInfoByParentMark('AO_DERIVATIVE_PRODUCTS_STUDY_TYPE')}"
                                       varStatus="i">
                                <input type="radio" name="derivativeProductsStudyType"
                                       value="${investTargetCodeEntity.value}" disabled="disabled"
                                />${investTargetCodeEntity.name}
                            </c:forEach>
                            <input class="form-control" style="width:100px;display: inline"
                                   id="derivativeProductsStudyTypeOther" name="derivativeProductsStudyTypeOther"
                                   readonly="readonly"
                                   type="text"/>
                        </span>
                        <span class="col-xs-2 block input-icon input-icon-right">
                                <div class="layui-upload">
                                    <button type="button" class="layui-btn layui-btn-normal layui-btn-mini" id="proof1"
                                            style="display: none">上传凭证</button>
                                    <div class="layui-upload-list" style="display:inline;">
                                        <img class="layui-upload-img" id="proofImg1">
                                    </div>
                                    <div class="divX" id="proofImgDel1" onclick="delImg(this.id,601)">
                                        <button style="display: none" type="button"
                                                class="layui-btn layui-btn-mini layui-btn-danger">DEL</button>
                                    </div>
                                </div>
                            <%--<button class="layui-btn layui-btn-normal layui-btn-mini demoMore" type="button"--%>
                                    <%--lay-data="{url: '${webRoot}/offlineCustAccOpen/upload?locationType=601'}">上传凭证</button>--%>
                        </span>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-12 control-label no-padding-right">您在经纪公司或银行，基金或资产管理公司，监管机构或交易所等金融机构拥有以下工作经验</label>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-9 block input-icon input-icon-right">
                            <c:forEach var="investTargetCodeEntity"
                                       items="${fns:getCodeInfoByParentMark('AO_FINANCING_INSTITUTION_WORK_EXPERIENCE_TYPE')}"
                                       varStatus="i">
                                 <input type="radio" name="financingInstitutionWorkExperienceType"
                                        value="${investTargetCodeEntity.value}" disabled="disabled"
                                 />${investTargetCodeEntity.name}
                            </c:forEach>
                            <input class="form-control" style="width:100px;display: inline"
                                   id="financingInstitutionWorkExperienceTypeOther" readonly
                                   name="financingInstitutionWorkExperienceTypeOther"
                                   type="text" style="width:200px; margin-left:25px; height:34px;"/>
                        </span>
                        <span class="col-xs-2 block input-icon input-icon-right">
                                <button type="button" class="layui-btn layui-btn-normal layui-btn-mini" id="proof2"
                                        style="display: none"> 上传凭证</button>
                                    <div class="layui-upload-list" style="display:inline">
                                        <img class="layui-upload-img" id="proofImg2">
                                    </div>
                                    <div class="divX" id="proofImgDel2" onclick="delImg(this.id,602)">
                                            <button style="display: none" type="button"
                                                    class="layui-btn layui-btn-mini layui-btn-danger">DEL</button>
                                    </div>
                        </span>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-12 control-label no-padding-right">您在过去三年是否曾进行过至少五次任何衍生产品的交易（不论是否在交易所买卖）</label>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-9 block input-icon input-icon-right">
                        	  <input type="radio" name="isTradedDerivativeProducts" disabled="disabled"
                                     value="1"/>是
                        	  <input type="radio" name="isTradedDerivativeProducts" disabled="disabled"
                                     value="0"/>否
                        </span>
                        <span class="col-xs-2 block input-icon input-icon-right">
                                <button type="button" class="layui-btn layui-btn-normal layui-btn-mini" id="proof3"
                                        style="display: none">上传凭证</button>
                                    <div class="layui-upload-list" style="display:inline">
                                        <img class="layui-upload-img" id="proofImg3">
                                    </div>
                                    <div class="divX" id="proofImgDel3" onclick="delImg(this.id,603)">
                                            <button style="display: none" type="button"
                                                    class="layui-btn layui-btn-mini layui-btn-danger">DEL</button>
                                    </div>
                        </span>
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
                    <label class="col-sm-12 control-label no-padding-right"><span style="color:red;">*</span>您是否确认《个人资料（私隐）条例通知》并同意智珠证券及其控股集团使用及向其他人士提供本人的个人资料作直接促销用途。</label>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-12 block input-icon input-icon-right">
                                    <input type="radio" name="isAllowProvidePrivacy"
                                           value="1" checked="checked"/>是
                                    <input type="radio" name="isAllowProvidePrivacy"
                                           value="0"/>否
                        </span>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-12 control-label no-padding-right"><span style="color:red;">*</span>您是否确认智珠证券根据《有关中华通证券北向交易的个人资料收集声明》所述的目的使用您的个人资料</label>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-12 block input-icon input-icon-right">
                                    <input type="radio" name="northTrade" value="1" checked="checked"/>是
                                    <input type="radio" name="northTrade" value="0"/>否
                        </span>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-12 control-label no-padding-right"><span style="color:red;">*</span>您是否出生于美国/美国公民/美国居民/美国永久居民外国人(即所谓的美国绿卡持有人(不论到期日))。</label>
                </div>
                <div class="form-group col-sm-6 col-md-6">
                        <span class="col-xs-12 block input-icon input-icon-right">
                                    <input type="radio" name="FATCA" value="1" onclick="chooseFATCA();"/>是
                                    <input type="radio" name="FATCA" value="0" onclick="chooseFATCA();"
                                           checked="checked"/>否

                            <span id="theUSTax" style="display: none">
                            <span style="color:red;margin-left: 30px">*</span>美国纳税人识别号码(TIN)
                                <input class="form-control" maxlength="20" style="width:200px;display: inline"
                                       id="theUSTaxNum" name="theUSTaxNum"
                                       placeholder="输入不超过20个字符" type="text"/>
                            </span>
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
                <c:forEach begin="0" end="4" step="1" var="i">
                <div class="row">
                    <div class="form-group col-sm-3 col-md-3">
                        <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" name="taxCountry[]"
                                               class="form-control">
                                    </span>
                        </div>
                    </div>
                    <div class="form-group col-sm-3 col-md-3">
                        <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" name="taxNumber[]"
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
                                            >理由 A – 帐户持有人的居留司法管辖区并没有向其居民发出税务编号。</option>
                                            <option value="B"
                                            >理由 B – 帐户持有人不能取得税务编号。如选取这一理由，解释帐户持有人不能取得税务编号的原因。</option>
                                            <option value="C"
                                            >理由 C – 帐户持有人毋须提供税务编号。居留司法管辖区的主管机关不需要帐户持有人披露税务编号。</option>
                                        </select>
                                    </span>
                        </div>
                    </div>
                    <div class="form-group col-sm-3 col-md-3">
                        <div class="col-xs-12">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" name="reasonDesc[]"
                                               class="form-control">
                                    </span>
                        </div>
                    </div>
                </div>

                </c:forEach>

        </div>
    </div>
    </form>

    <form id="otherInfoForm">
        <div id="div7" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">身份资料披露</b></div>
                </br>

                <c:forEach begin="1" end="20" step="1" var="i">
                    <c:if test="${i == 1}">
                        <div class="row">
                            <div class="form-group col-sm-6 col-md-6">
                                <label class="col-sm-12 control-label no-padding-right">
                                    <span style="color: red">*</span>${fns:getCodeName("AO_DISCLOSURE_CODE",i)}</label>
                            </div>
                            <div class="form-group col-sm-6 col-md-6">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" style="display: none;" id="disclosureCode_${i}"
                                               value="${i}"/>
                                        <input type="radio" name="disclosureFlag_${i}" value="1" checked="checked"/>是
                                        <input type="radio" name="disclosureFlag_${i}" value="0"/>否
                                    </span>
                            </div>
                        </div>
                        <div id="otherInfoDetail_${i}" class="row"
                             style="margin-left: 20px">
                            <table id="table_${i}">
                            </table>
                        </div>
                        <div id="options" style="margin-left: 850px;margin-top: 10px">
                            <button class="layui-btn layui-btn-small" type="button"
                                    onclick="addRow(${i})">
                                <i class="layui-icon">&#xe654;</i>继续添加
                            </button>
                        </div>
                    </c:if>
                </c:forEach>
                <c:forEach begin="21" end="26" step="1" var="i">
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-12 control-label no-padding-right">
                                <span style="color: red">*</span>${fns:getCodeName("AO_DISCLOSURE_CODE",i)}</label>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" style="display: none;" id="disclosureCode_${i}"
                                               value="${i}"/>
                                        <input type="radio" name="disclosureFlag_${i}" value="1"/>是
                                        <input type="radio" name="disclosureFlag_${i}" value="0" checked="checked"/>否
                                    </span>
                        </div>
                    </div>
                    <div id="otherInfoDetail_${i}" class="row" style="margin-left: 20px">
                        <table id="table_${i}">
                        </table>
                    </div>
                    <div id="options" style="margin-left: 850px;margin-top: 10px">
                        <button class="layui-btn layui-btn-small" type="button"
                                onclick="addRow(${i})">
                            <i class="layui-icon">&#xe654;</i>继续添加
                        </button>
                    </div>
                </c:forEach>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-12 control-label no-padding-right">
                            <span style="color: red">*</span>${fns:getCodeName("AO_DISCLOSURE_CODE",9)}</label>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input type="text" style="display: none;" id="disclosureCode_9"
                                               value="9"/>
                                        <input type="radio" name="disclosureFlag_9" value="1" checked="checked"/>是
                                        <input type="radio" name="disclosureFlag_9" value="0"/>否
                                    </span>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <div id="div10" v-cloak>
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

    <div id="div8" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">补充资料</b></div>
            </br>
            <div class="row" style="margin-left: 10px">
                <div class="form-group col-sm-11 col-md-11">
                    <div class="layui-upload">
                        <div class="layui-upload">
                            <button type="button" class="layui-btn layui-btn-normal layui-btn-small" id="supList">选择文件
                            </button>
                            <div class="layui-upload-list">
                                <table class="layui-table form-group col-sm-12 ">
                                    <thead>
                                    <tr>
                                        <th>文件名</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="supFileList">

                                    </tbody>
                                </table>
                            </div>
                            <button type="button" style="display: none" class="layui-btn layui-btn-small"
                                    id="supListAction">开始上传
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <input id="amlFlag" style="display: none" type="text" value="${amlFileList[0]==null}">
    <div v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">审批操作</b></div>
            </br>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-4 control-label no-padding-right" style="margin-left: 10px">
                        <span style="color:red;">*</span>该申请人有无AML可疑信息？</label>
                    <span class="col-sm-4 control-label no-padding-right">
                        <input type="radio" name="amlSuspicious" value="1"/>有可疑
                        <input type="radio" name="amlSuspicious" value="0"/>无可疑
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
                                                   href='${webRoot}/common/downloadFile?fullFilePath=${amlFileList[i].filePath}${amlFileList[i].fileStorageName}.${amlFileList[i].fileExtName}'>【AML文件(${i+1})】</a>
                                                <button type="button"
                                                        class="layui-btn layui-btn-primary layui-btn-mini"
                                                        onclick="delAmlInfo(${amlFileList[i].id});">
                                                    <i class="layui-icon">&#xe640;</i>
                                                </button>
                                                </div>
                                            </c:if>
                                            <c:if test="${amlFileList[i]==null}">
                                                <button name="upLoadAml" style="width: 100px;display: inline"
                                                        class="layui-btn layui-btn-primary layui-btn-mini">上传[AML文件]</button>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </span>
                </div>
            </div>
        </div>
    </div>

    <input id="witnessFlag" style="display: none" type="text" value="${witnessesFileList[0]==null}">
    <div id="div9" v-cloak>
        <form id="witnessForm">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">见证人与审批人</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>见证人姓名</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input id="witnessUser" name="witnessUser" type="text" class="form-control"
                                               maxlength="50"
                                               style="display:inline;width: 75%" required/>
                                    </span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>审批人姓名</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input id="submitApprovalUser" name="submitApprovalUser" type="text"
                                       class="form-control" maxlength="50"
                                       style="display:inline;width: 75%" required/>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">见证人类型</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-12 block input-icon input-icon-right">
                                        <input id="witnessesType" name="witnessesType" type="text" class="form-control"
                                               maxlength="50"
                                               style="display:inline;width: 75%"/>
                                    </span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">牌照号码</label>
                        <div class="col-xs-9">
                            <span class="col-xs-12 block input-icon input-icon-right">
                                <input id="licenseNumber" name="licenseNumber" type="text" class="form-control"
                                       maxlength="50"
                                       style="display:inline;width: 75%"/>
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
        </form>
    </div>


    <div v-cloak align="center">
        <button type="button" id="formSubmit" class="layui-btn" onclick="infoSubmit();">确认提交</button>
    </div>
</div>
</body>

<script type="text/javascript">
    function infoSubmit() {
        var isChecked2 = $('#mustSure2').is(":checked");
        if (!isChecked2) {
            alertMsg("请勾选服务协议");
            return;
        }
        var isAmlSuspicious = $('input[name="amlSuspicious"]').filter(':checked').val();
        if (isAmlSuspicious == null || isAmlSuspicious == '') {
            alertMsg("请勾选该申请人有无AML可疑信息");
            return;
        } else if ($("#amlFlag").val() == "true") {
            alertMsg("请上传aml文件");
            return;
        }

        if ("true" == $("#witnessFlag").val()) {
            alertMsg("请上传见证人证书");
            return;
        }
        if ($("#basicInfoForm").valid() && $("#witnessForm").valid()) {
            var openAccountInfo = $('#basicInfoForm').all_serialize();
            openAccountInfo['isAmlSuspicious'] = isAmlSuspicious;
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
                    alert("请填写职位级别");
                    return;
                }
            }

            if (openAccountInfo['isKnowDerivativeProducts'] == 1) {
                if (openAccountInfo['derivativeProductsStudyType'] == null &&
                    openAccountInfo['financingInstitutionWorkExperienceType'] == null &&
                    (openAccountInfo['isTradedDerivativeProducts'] == null || openAccountInfo['isTradedDerivativeProducts'] == "0")) {
                    alert("请至少勾选一种衍生产品认知!");
                    return;
                }
                if (openAccountInfo['derivativeProductsStudyType'] != null && ($('#proofImg1').val() == null || $('#proofImg1').val() == '')) {
                    alertMsg("勾选了培训或课程接受的方式,请上传凭证！")
                    return;
                }
                if (openAccountInfo['financingInstitutionWorkExperienceType'] != null && ($('#proofImg2').val() == null || $('#proofImg2').val() == '')) {
                    alertMsg("勾选了有金融机构工作经验,请上传凭证！")
                    return;
                }
                if (openAccountInfo['isTradedDerivativeProducts'] != null && ($('#proofImg3').val() == null || $('#proofImg3').val() == '')) {
                    alertMsg("勾选了进行过衍生产品的交易,请上传凭证！")
                    return;
                }
            }


            //收入来源 投资目标 checkBox 处理
            //【开始】
            if (openAccountInfo['capitalSource'] == null) {
                if (openAccountInfo['professionCode'] == 1) {
                    openAccountInfo['capitalSource'] = "0";
                } else if (openAccountInfo['professionCode'] == 2) {
                    openAccountInfo['capitalSource'] = "4";
                } else {
                    alertMsg("收入来源不可为空!");
                    return;
                }
            } else {
                if (openAccountInfo['professionCode'] == 1) {
                    var capitalSource = "0," + openAccountInfo['capitalSource'].toString();
                } else if (openAccountInfo['professionCode'] == 2) {
                    var capitalSource = openAccountInfo['capitalSource'].toString() + ",4";
                } else {
                    var capitalSource = openAccountInfo['capitalSource'].toString();
                }
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
            var acceptRisk = $('input:radio[name="acceptRisk"]:checked').val();
            if (acceptRisk == null) {
                alertMsg("风险承受程度不可为空!");
                return;
            } else {
                openAccountInfo['acceptRisk'] = acceptRisk;
            }
            //【结束】


            openAccountInfo['applicationTime'] = new Date(openAccountInfo['applicationTime']);
            openAccountInfo['isAllowProvidePrivacy'] = $('input[name="isAllowProvidePrivacy"]').filter(':checked').val();
            openAccountInfo['isTradedDerivativeProducts'] = $('input[name="isTradedDerivativeProducts"]').filter(':checked').val();
            openAccountInfo['isAllowProvidePrivacy'] = $('input[name="isAllowProvidePrivacy"]').filter(':checked').val();

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
                    } else {
                        openAccountInfo['theUSTaxNum'] = theUSTaxNum;
                    }
                }
            }
            var witnessInfo = $('#witnessForm').serializeJSON();
            openAccountInfo['witnessUser'] = witnessInfo['witnessUser'];
            openAccountInfo['witnessesType'] = witnessInfo['witnessesType'];
            openAccountInfo['licenseNumber'] = witnessInfo['licenseNumber'];
            openAccountInfo['submitApprovalUser'] = witnessInfo['submitApprovalUser'];

            openAccountInfo['sourceChannelId'] = $("#sourceChannelId").val();


            //其他信息披露  数据拼接 【开始】
            var disclosureCodes = [11, 12, 13, 14, 15, 16];
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
                                if (typeof (filed1) != "undefined" && filed1 != null && filed1 != '') {
                                    disclosure1 += filed1 + ",";
                                }
                                if (typeof (filed2) != "undefined" && filed2 != null && filed2 != '') {
                                    disclosure2 += filed2 + ",";
                                }
                                if (typeof (filed3) != "undefined" && filed3 != null && filed3 != '') {
                                    disclosure3 += filed3 + ",";
                                }
                                if (typeof (filed4) != "undefined" && filed4 != null && filed4 != '') {
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
            if (taxInfoList.length == 0) {
                alert("税务信息不可为空，请至少填写一条税务信息！");
                return;
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


            if ($("#phoneAreaCode").val() != null && $("#phoneAreaCode").val() != '') {
                openAccountInfo['phoneNumber'] = $("#phoneAreaCode").val() + '-' + openAccountInfo['phoneNumber'];
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
                                alertMsg("客户账号已存在");
                            } else {
                                $("#supListAction").click();
                                if ($("#submitCode").val() == 0) {
                                    $.ajax({
                                        type: "POST",
                                        url: "${webRoot}/offlineCustAccOpen/doCusAccOpenEntering",
                                        data: JSON.stringify(openAccountInfo),
                                        contentType: 'application/json',
                                        dataType: "json",        //返回数据形式为json
                                        success: function (r) {
                                            if (r.code == 0) {
                                                alert(r, function (index) {
                                                    window.location.reload();
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
                        }
                    })
                } else {
                    openAccountInfo['clientId'] = null;
                    $("#supListAction").click();
                    if ($("#submitCode").val() == 0) {
                        $.ajax({
                            type: "POST",
                            url: "${webRoot}/offlineCustAccOpen/doCusAccOpenEntering",
                            data: JSON.stringify(openAccountInfo),
                            contentType: 'application/json',
                            dataType: "json",        //返回数据形式为json
                            success: function (r) {
                                if (r.code == 0) {
                                    alert(r, function (index) {
                                        window.location.reload();
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
            });
        }
    }

    layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;

        var uploadProof1 = upload.render({
            elem: '#proof1'
            , url: '${webRoot}/offlineCustAccOpen/proofUpload'
            , exts: 'jpg|png|jpeg|bmp'
            , data: {
                imageLocation: '6',
                imageLocationType: '601',
                applicationId:${applicationId}
            }
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#proofImg1').attr('src', result).attr('style', 'width: 100px;height: 50px;'); //图片链接（base64）
                    $('#proofImg1').val(result);
                    var left = $('#proofImg1').position().left;
                    var top = $('#proofImg1').position().top;
                    $('#proofImgDel1').css({position: "absolute", left: left + 65, top: top + 10, display: "block"});
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    alertMsg('上传失败');
                }
                //上传成功
                if (res.code == 0) {
//                        alert(res.result)
                    alert('上传成功');
                }
            }
        });

        var uploadProof2 = upload.render({
            elem: '#proof2'
            , url: '${webRoot}/offlineCustAccOpen/proofUpload'
            , exts: 'jpg|png|jpeg|bmp'
            , data: {
                imageLocation: '6',
                imageLocationType: '602',
                applicationId:${applicationId}
            }
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#proofImg2').attr('src', result).attr('style', 'width: 100px;height: 50px;'); //图片链接（base64）
                    $('#proofImg2').val(result);
                    var left = $('#proofImg2').position().left;
                    var top = $('#proofImg2').position().top;
                    $('#proofImgDel2').css({position: "absolute", left: left + 65, top: top + 10, display: "block"});
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    alertMsg('上传失败');
                }
                //上传成功
                if (res.code == 0) {
//                        alert(res.result)
                    alert('上传成功');
                }
            }
        });

        var uploadProof3 = upload.render({
            elem: '#proof3'
            , url: '${webRoot}/offlineCustAccOpen/proofUpload'
            , exts: 'jpg|png|jpeg|bmp'
            , data: {
                imageLocation: '6',
                imageLocationType: '603',
                applicationId:${applicationId}
            }
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#proofImg3').attr('src', result).attr('style', 'width: 100px;height: 50px;'); //图片链接（base64）
                    $('#proofImg3').val(result);
                    var left = $('#proofImg3').position().left;
                    var top = $('#proofImg3').position().top;
                    $('#proofImgDel3').css({position: "absolute", left: left + 65, top: top + 10, display: "block"});
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    alertMsg('上传失败');
                }
                //上传成功
                if (res.code == 0) {
//                        alert(res.result)
                    alert('上传成功');
                }
            }
        });

        //多文件列表示例
        var supFileListView = $('#supFileList')
            , uploadListIns = upload.render({
            elem: '#supList'
            , url: '${webRoot}/offlineCustAccOpen/supUpload'
            , accept: 'file'
            , multiple: true
            , auto: false
            , data: {
                applicationId:${applicationId}
            }
            , bindAction: '#supListAction'
            , choose: function (obj) {
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function (index, file, result) {

                    var ext = file.name.substring(file.name.lastIndexOf('.') + 1).toLowerCase();
                    if (!(ext && /^(jpg|png|jpeg|bmp|avi|rmvb|wmv|mkv|mp3|pdf)$/.test(ext.toLowerCase()))) {
                        alert('文件格式不支持，只支持jpg、png、jpeg、bmp、AVI、RMVB、WMV、MKV、MP3、PDF格式的文件');
                        return false;
                    }
                    var size = file.size / (1024 * 1024);
                    if (size > 20) {
                        alert('文件不能大于20m!');
                        return false;
                    }
                    var tr = $(['<tr id="upload-' + index + '">'
                        , '<td>' + file.name + '</td>'
                        , '<td>等待上传</td>'
                        , '<td>'
                        , '<button class="layui-btn layui-btn-mini layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        , '</td>'
                        , '</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function () {
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function () {
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    supFileListView.append(tr);
                });
            }
            , done: function (res, index, upload) {
                if (res.code == 0) { //上传成功
                    var tr = supFileListView.find('tr#upload-' + index)
                        , tds = tr.children();

                    $.ajaxPrefilter('script', function (options) {
                        options.cache = true;
                    });

                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空操作
                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                }
                //如果上传失败
                if (res.code > 0) {
                    $("#submitCode").val(1)
                    alertMsg('上传失败');
                }
                //上传成功
                if (res.code == 0) {
                    alert('上传成功');
                }
            }
            , error: function (index, upload) {

                $.ajaxPrefilter('script', function (options) {
                    options.cache = true;
                });

                var tr = supFileListView.find('tr#upload-' + index)
                    , tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });

    });

    function delImg(delId, type) {
        var params = {
            applicationId: ${applicationId},
            imageLocationType: type
        };
        $.post("${webRoot}/offlineCustAccOpen/delImg", params, function (result) {
            if (result.code == 0) {
                alert('删除成功！');
                $('#' + delId).attr('style', 'display:none'); //图片链接置空
                var imgId = delId.replace("Del", "");
                $('#' + imgId).attr('src', '').attr('style', 'display:none'); //图片链接置空
            } else {
                alertMsg(result.msg);
            }
        })
    }


    layui.laydate.render({
        elem: '#birthday' //指定元素
    });
    layui.laydate.render({
        elem: '#idCardValidDateEnd' //指定元素
    });

    // 自定义提示语 及 样式
    (function ($) {
        $.extend($.validator.messages, {
            required: "<span style='color: red;'>该字段不能为空！</span>",
            remote: "输入的值有误，请重新输入！",
            email: "<span style='color: red;'>请输入有效的电子邮件地址！</span>",
            url: "请输入合法的网址",
            date: "请输入合法的日期",
            dateISO: "请输入合法的日期 (ISO).",
            number: "<span style='color: red;'>请输入合法的数字！</span>",
            digits: "只能输入整数",
            creditcard: "请输入合法的信用卡号",
            equalTo: "请再次输入相同的值",
            accept: "请输入拥有合法后缀名的字符串",
            maxlength: $.validator.format("<span style='color: red;'>请输入一个长度最多是 {0} 的字符串</span>"),
            minlength: $.validator.format("请输入一个长度最少是 {0} 的字符串"),
            rangelength: $.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
            range: $.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
            max: $.validator.format("请输入一个最大为 {0} 的值"),
            min: $.validator.format("请输入一个最小为 {0} 的值")
        });
    }(jQuery));

    function showProducts() {
        $("#div5").find("input").removeAttr("disabled", "disabled").removeAttr("readonly", "readonly");
        $("#div5").find("button").removeAttr("style", "display:none");
    }

    function hideProducts() {
        $("#div5").find("input").attr("disabled", "disabled").attr("readonly", "readonly");
        $("#div5").find("button").attr("style", "display:none");

        $("input:radio[name='derivativeProductsStudyType']").attr("checked", false);
        $("#derivativeProductsStudyTypeOther").val("");
        $("input:radio[name='financingInstitutionWorkExperienceType']").attr("checked", false);
        $("#financingInstitutionWorkExperienceTypeOther").val("");
        $("input:radio[name='isTradedDerivativeProducts']").attr("checked", false);

        $("#products").find("input").removeAttr("disabled", "disabled");
    }

    $("#professionCode").change(function () {
        onChangeProfessionCode($("#professionCode").val(), "");
    });

    function onChangeProfessionCode(professionCode, capitalSource) {
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

    $("#idCardValidForever").click(function () {
        $("#idCardValidDateEnd").val("长期");
    });


    function pictureView(url) {
        src = '${webRoot}/image' + url;
        var imgHtml = "<img src='' />";
        var img = new Image();
        img.src = src;
        img.onload = function () {
            layer.open({
                type: 1,
                closeBtn: 1,
                shade: false,
                title: ['凭证照片', true], //显示标题
                skin: 'layui-layer-nobg', //没有背景色
                shadeClose: false,
                area: [img.width + 'px', img.height + 50 + 'px'],
                content: imgHtml
            })
        }
    }

    //请选择您接收衍生产品相关的培训或课程的方式 当选中的值为其他显示其他输入框
    $('input[type=radio][name=derivativeProductsStudyType]').change(function () {

        var derivativeProductsStudyType = $("input[name='derivativeProductsStudyType']:checked").val();
        if (derivativeProductsStudyType == 7) {
            //显示其他输入框
            $("#derivativeProductsStudyTypeOther").attr("style", "display:inline;width:100px");
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
            $("#financingInstitutionWorkExperienceTypeOther").attr("style", "display:inline;width:100px");
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


    //为jquery.serializeArray()解决radio,checkbox未选中时没有序列化的问题
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

        for (var Key in info) {
            if (info[Key] == "") {
                info[Key] = null;
            }
        }

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
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>受益人姓名：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                var new_col = new_row.insertCell(2);
                new_col.innerHTML = "&nbsp;<span>证件类型：</span>";
                var new_col = new_row.insertCell(3);
                new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                var new_col = new_row.insertCell(4);
                new_col.innerHTML = "<span>证件号码：</span>";
                var new_col = new_row.insertCell(5);
                new_col.innerHTML = "<input type='text' id='disclosure3_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                break;
            case 21:
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>职位：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                break;
            case 22:
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>董事/雇员：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                var new_col = new_row.insertCell(2);
                new_col.innerHTML = "&nbsp;<span> 与本人关系：</span>";
                var new_col = new_row.insertCell(3);
                new_col.innerHTML = "<input type='text' id='disclosure2_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                break;
            case 23:
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
            case 24:
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>所在职位：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
                break;
            case 24:
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
            case 25:
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
            case 26:
                var new_row = table.insertRow(table.rows.length);
                new_row.setAttribute("id", "row" + row_index);
                var new_col = new_row.insertCell(0);
                new_col.innerHTML = "<span>美国纳税人识别号：</span>";
                var new_col = new_row.insertCell(1);
                new_col.innerHTML = "<input type='text' id='disclosure1_" + disclosureCode + "_" + row_index + "' placeholder='输入不超过20个字符' class='form-control'>";
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

    $(document).ready(function () {
        //上传见证人证书
        var reButton = document.getElementsByName('upLoadWitnesses');
        for (var i = 0; i < reButton.length; i++) {
            var applicationId = '${applicationId}';
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
                            url: "${webRoot}/offlineCustAccOpen/witnessesRefresh?applicationId=${applicationId}",
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

        //上传aml文件
        var updateButtons2 = document.getElementsByName('upLoadAml');

        for (var i = 0; i < updateButtons2.length; i++) {
            var applicationId = '${applicationId}';

            new AjaxUpload(updateButtons2[i], {
                action: '${webRoot}/offlineCustAccOpen/uploadFile',
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
                            url: "${webRoot}/customer/amlRefresh?applicationId=${applicationId}",
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
    });

    /**
     * 删除aml文件信息
     */
    function delAmlInfo(id) {
        confirm("您确定要删除吗?", function () {
            var url = "${webRoot}/offlineCustAccOpen/delFileInfo";
            var params = {
                'applicationId': ${applicationId},
                'id': id
            };
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    $.ajax({
                        type: "get",
                        async: false,
                        cache: false,
                        url: "${webRoot}/customer/amlRefresh?applicationId=${applicationId}",
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

    /**
     * 删除见证人 文件信息
     */
    function delWitnessInfo(id) {
        confirm("您确定要删除吗?", function () {
            var url = "${webRoot}/offlineCustAccOpen/delFileInfo";
            var params = {
                'applicationId': ${applicationId},
                'id': id
            };
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    $.ajax({
                        type: "get",
                        async: false,
                        cache: false,
                        url: "${webRoot}/offlineCustAccOpen/witnessesRefresh?applicationId=${applicationId}",
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
</script>
</html>
