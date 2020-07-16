<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<jsp:useBean id="dateValue" class="java.util.Date"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>客户资料补录</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <script type="text/javascript" src="${webRoot}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${webRoot}/js/jquery.validate.js"></script>
    <script type="text/javascript" src="${webRoot}/js/messages_zh.min.js"></script>
    <script type="text/javascript" src="${webRoot}/js/jquery.metadata.js"></script>
</head>
<body>
<div class="col-sm-11" id="main-container">
    <form class="customerList" id="customerList" name="customerList" style="width: 100%">
        <div id="div0" v-cloak class="">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">账号信息</b></div>
                </br>
                <input id="gid" name="gid" value="${info.gid}" hidden="hidden">
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">开户类型:</label>
                        <div class="col-sm-9">
                            <span class="col-xs-9 block input-icon input-icon-right">
                                <tag:select nameKey="AO_OPEN_ACCOUNT_TYPE" id="openAccountType" name="openAccountType"
                                            isAddDefaltOption="true"
                                            initSelectedKey="${info.openAccountType}"
                                            clazz="form-control required"/>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">小神号:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="userId" name="userId" type="number" class="form-control "
                                               value="${info.userId}"/>
                                    </span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">推荐人小神号:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="inviterId" name="inviterId" type="number" class="form-control  "
                                               required
                                               value="${info.inviterId}" required/>
                                    </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">客户来源渠道编号:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="sourceChannelId" name="sourceChannelId" type="number"
                                               class="form-control  " required
                                               value="${info.sourceChannelId}"/>
                                    </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">客户来源渠道名称:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="sourceChannelName" name="sourceChannelName" type="text"
                                               class="form-control"
                                               value="${info.sourceChannelName}" required/>
                                    </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="div1" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">基本资料</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">客户中文名:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="clientName" name="clientName" type="text" class="form-control"
                                           value="${info.clientName}" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">客户英文名:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="clientNameSpell" name="clientNameSpell" type="text" class="form-control"
                                           value="${info.clientNameSpell}" required/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">姓氏:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="familyName" name="familyName" type="text" class="form-control"
                                           value="${info.familyName}" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">名字:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="givenName" name="givenName" type="text" class="form-control"
                                           value="${info.givenName}" required/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">证件类型:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <tag:select nameKey="AO_ID_KIND" id="idKind" name="idKind"
                                                    isAddDefaltOption="true"
                                                    initSelectedKey="${info.idKind}"
                                                    clazz="form-control required"/>
                                    </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">证件号码:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="idNo" name="idNo" type="text" class="form-control"
                                               value="${info.idNo}" required/>
                                    </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">性别:</label>
                        <div class="col-xs-9">
                            <span class="col-xs-9 block input-icon input-icon-right">
                                <tag:select nameKey="COMMON_SEX" id="sex" name="sex" isAddDefaltOption="true"
                                            initSelectedKey="${info.sex}"
                                            clazz="form-control required"/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">生日:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="birthday" name="birthday" type="text" class="form-control"
                                               value="${info.birthday}" required/>
                                    </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">身份证地址:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="idCardAddress" name="idCardAddress" type="text" class="form-control"
                                               value="${info.idCardAddress}" required/>
                                    </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">银行编号:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="bankId" name="bankId" type="number" class="form-control"
                                           value="${info.bankId}" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">银行卡号:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="bankNo" name="bankNo" type="number" class="form-control required"
                                           value="${info.bankNo}"/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">国籍:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="nationality" name="nationality" type="text" class="form-control"
                                           value="${info.nationality}" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">是否美国绿卡持有人:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="COMMON_YES_NO" id="isAmericanGreenCardHolder" name="isAmericanGreenCardHolder" isAddDefaltOption="true"
                                                initSelectedKey="${info.isAmericanGreenCardHolder}"
                                                clazz="form-control required"/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">联系地址的省份:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="contactProvinceName" name="contactProvinceName" type="text"
                                           class="form-control"
                                           value="${info.contactProvinceName}" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">联系地址的城市:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="contactCityName" name="contactCityName" type="text" class="form-control"
                                           value="${info.contactCityName}" required/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">联系地址的区域:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="contactCountyName" name="contactCountyName" type="text"
                                           class="form-control"
                                           value="${info.contactCountyName}" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">联系地址的详细地址:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="contactDetailAddress" name="contactDetailAddress" type="text"
                                           class="form-control"
                                           value="${info.contactDetailAddress}" required/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">电子邮箱:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="email" name="email" type="email" class="form-control"
                                           value="${info.email}" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">手机号:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="phoneNumber" name="phoneNumber" type="number" class="form-control"
                                           value="${info.phoneNumber}" required/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">就业情况类型:</label>
                        <div class="col-xs-9">
                            <span class="col-xs-9 block input-icon input-icon-right">
                                <tag:select nameKey="AO_PROFESSION_TYPE" id="professionCode" name="professionCode" isAddDefaltOption="true"
                                            initSelectedKey="${info.professionCode}"
                                            clazz="form-control required"/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">就业情况其它说明:</label>
                        <div class="col-xs-9">
                            <span class="col-xs-9 block input-icon input-icon-right">
                                <input id="otherProfession" name="otherProfession" type="text" class="form-control"
                                       value="${info.otherProfession}" required/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">公司名称:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="companyName" name="companyName" type="text" class="form-control"
                                           value="${info.companyName}" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">公司电话:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="companyPhoneNumber" name="companyPhoneNumber" type="number"
                                           class="form-control"
                                           value="${info.companyPhoneNumber}" required/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">职位:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="jobPosition" name="jobPosition" type="text" class="form-control"
                                           value="${info.jobPosition}" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">业务性质:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="industryRange" name="industryRange" type="text" class="form-control"
                                           value="${info.industryRange}" required/>
                                </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="div2" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">资产与投资情况</b></div>

                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">年收入(港币):</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="AO_INCOME" id="income" name="income" isAddDefaltOption="true"
                                                initSelectedKey="${info.income}"
                                                clazz="form-control required"/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">净资产(港币):</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                       <tag:select nameKey="AO_NET_CAPITAL" id="netCapital" isAddDefaltOption="true"
                                                   initSelectedKey="${info.netCapital}"
                                                   clazz="form-control required"/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">投资目标类型:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right ">
                                    <tag:checkbox nameKey="AO_INVEST_TARGET" id="investTarget" name="investTarget" initCheckKey="${info.investTarget}" clazz="required" ></tag:checkbox>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">投资目标其它说明:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="investTargetOther" name="investTargetOther" type="text"
                                           class="form-control"
                                           value="${info.investTargetOther}" required/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">股票投资经验 :</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="AO_INVEST_TARGET" id="stocksInvestmentExperienceType" name="stocksInvestmentExperienceType" isAddDefaltOption="true"
                                                initSelectedKey="${info.stocksInvestmentExperienceType}"
                                                clazz="form-control required"/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">认证股权投资经验</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="AO_WARRANTS_INVESTMENT_EXPERIENCE_TYPE" id="warrantsInvestmentExperienceType" name="warrantsInvestmentExperienceType" isAddDefaltOption="true"
                                                initSelectedKey="${info.warrantsInvestmentExperienceType}"
                                                clazz="form-control required"/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">期货投资经验:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="AO_FUTURES_INVESTMENT_EXPERIENCE_TYPE" id="futuresInvestmentExperienceType" name="futuresInvestmentExperienceType" isAddDefaltOption="true"
                                                initSelectedKey="${info.futuresInvestmentExperienceType}"
                                                clazz="form-control required"/>
                                </span>
                        </div>
                    </div>
                </div>


            </div>
        </div>

        <div id="div3" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">衍生品问卷调查</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">是否了解衍生产品:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="COMMON_YES_NO" id="isKnowDerivativeProducts" name="isKnowDerivativeProducts" isAddDefaltOption="true"
                                                initSelectedKey="${info.isKnowDerivativeProducts}"
                                                clazz="form-control required"/>
                                </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">衍生产品学习途径:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <tag:select nameKey="AO_DERIVATIVE_PRODUCTS_STUDY_TYPE" id="derivativeProductsStudyType" name="derivativeProductsStudyType" isAddDefaltOption="true"
                                                    initSelectedKey="${info.derivativeProductsStudyType}"
                                                    clazz="form-control required"/>
                                    </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">衍生产品其他学习途径:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="derivativeProductsStudyTypeOther"
                                               name="derivativeProductsStudyTypeOther" type="text"
                                               class="form-control" value="${info.derivativeProductsStudyTypeOther}"
                                        />
                                    </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label ">在金融机构工作经验 :</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <tag:select nameKey="AO_FINANCING_INSTITUTION_WORK_EXPERIENCE_TYPE" id="financingInstitutionWorkExperienceType"
                                                    name="financingInstitutionWorkExperienceType" isAddDefaltOption="true"
                                                    initSelectedKey="${info.financingInstitutionWorkExperienceType}"
                                                    clazz="form-control required"/>
                                    </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">在金融机构其它工作经验:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="financingInstitutionWorkExperienceTypeOther"
                                               name="financingInstitutionWorkExperienceTypeOther" type="text"
                                               class="form-control"
                                               value="${info.financingInstitutionWorkExperienceTypeOther}"/>
                                    </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">是否在过去三年曾买卖过至少五次任何衍生产品的交易:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <tag:select nameKey="COMMON_YES_NO" id="isTradedDerivativeProducts"
                                                    name="isTradedDerivativeProducts" isAddDefaltOption="true"
                                                    initSelectedKey="${info.isTradedDerivativeProducts}"
                                                    clazz="form-control required"/>
                                    </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="div4" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading">
                    <b style="color: #368763">其他信息披露</b>
                    <b style="color: red">(标*处选填，若选存在，至少填写一个！)</b>
                </div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">账户受益人:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="AO_OWNER_OF_ACCOUNT_TYPE" id="ownerOfAccountType"
                                                name="ownerOfAccountType" isAddDefaltOption="true"
                                                initSelectedKey="${info.ownerOfAccountType}"
                                                clazz="form-control required"/>
                                </span>
                        </div>
                    </div>
                </div>
                <div id="otherPerson">
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span
                                    style="color: red">*</span>姓名:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="ownName1" name="ownName1" type="text" class="form-control"
                                                  value="${info.ownName1}"/>
                                        </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span
                                    style="color: red">*</span>地址:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="ownAddress1" name="ownAddress1" type="text" class="form-control"
                                                  value="${info.ownAddress1}"/>
                                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span
                                    style="color: red">*</span>姓名:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="ownName2" name="ownName2" type="text" class="form-control"
                                                  value="${info.ownName2}"/>
                                        </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span
                                    style="color: red">*</span>地址:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="ownAddress2" name="ownAddress2" type="text" class="form-control"
                                                  value="${info.ownAddress2}"/>
                                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span
                                    style="color: red">*</span>姓名:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="ownName3" name="ownName3" type="text" class="form-control"
                                                  value="${info.ownName3}"/>
                                        </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span
                                    style="color: red">*</span>地址:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="ownAddress3" name="ownAddress3" type="text" class="form-control"
                                                  value="${info.ownAddress3}"/>
                                        </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">是否证券及期货事务监察委员会之注册公司雇员或注册人:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="COMMON_YES_NO" id="isSfcEmployee"
                                                name="isSfcEmployee" isAddDefaltOption="true"
                                                initSelectedKey="${info.isSfcEmployee}"
                                                clazz="form-control required"/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>注册人名称:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="registeredPersonName" name="registeredPersonName" type="text"
                                           class="form-control"
                                           value="${info.registeredPersonName}" required/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">是否与智珠集团之任何董事、职员或代表有亲属关系:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="COMMON_YES_NO" id="isClerkRelation"
                                                name="isClerkRelation" isAddDefaltOption="true"
                                                initSelectedKey="${info.isClerkRelation}"
                                                clazz="form-control required"/>
                                </span>
                        </div>
                    </div>


                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right"><span style="color: red">*</span>董事、职员或代表的亲属关系:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="clerkRelationInfo" name="clerkRelationInfo" type="text"
                                               class="form-control" value="${info.clerkRelationInfo}" required/>
                                    </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">是否有其他股票行或银行的股票户口资料:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="COMMON_YES_NO" id="hasOtherAccount"
                                                name="hasOtherAccount" isAddDefaltOption="true"
                                                initSelectedKey="${info.hasOtherAccount}"
                                                clazz="form-control required"/>
                                </span>
                        </div>
                    </div>
                </div>
                <div id="otherAccount">
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span style="color: red">*</span>银行名称:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="bankName1" name="bankName1" type="text" class="form-control"
                                                  value="${info.bankName1}"/>
                                        </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span style="color: red">*</span>银行卡号:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="accountNumber1" name="accountNumber1" type="number"
                                                  class="form-control"
                                                  value="${info.accountNumber1}"/>
                                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span style="color: red">*</span>银行名称:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="bankName2" name="bankName2" type="text" class="form-control"
                                                  value="${info.bankName2}"/>
                                        </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span style="color: red">*</span>银行卡号:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="accountNumber2" name="accountNumber2" type="number"
                                                  class="form-control"
                                                  value="${info.accountNumber2}"/>
                                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span style="color: red">*</span>银行名称:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="bankName3" name="bankName3" type="text" class="form-control"
                                                  value="${info.bankName3}"/>
                                        </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right"><span style="color: red">*</span>银行卡号:</label>
                            <div class="col-xs-9">
                                        <span class="col-xs-9 block input-icon input-icon-right">
                                           <input id="accountNumber3" name="accountNumber3" type="number"
                                                  class="form-control"
                                                  value="${info.accountNumber3}"/>
                                        </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="div5" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">其它信息</b></div>

                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">是否开通美股市场:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="COMMON_YES_NO" id="isOpenUsaStockMarket"
                                                name="isOpenUsaStockMarket" isAddDefaltOption="true"
                                                initSelectedKey="${info.isOpenUsaStockMarket}"
                                                clazz="form-control required"/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">是否开通港股市场:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <tag:select nameKey="COMMON_YES_NO" id="isOpenHkStockMarket"
                                                name="isOpenHkStockMarket" isAddDefaltOption="true"
                                                initSelectedKey="${info.isOpenHkStockMarket}"
                                                clazz="form-control required" />
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">资金帐号:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="fundAccount" name="fundAccount" type="number" class="form-control"
                                           value="${info.fundAccount}" required/>
                                </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">交易帐号:</label>
                        <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input id="tradeAccount" name="tradeAccount" type="number" class="form-control"
                                           value="${info.tradeAccount}" required/>
                                </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">是否允许衍生品交易:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <tag:select nameKey="COMMON_YES_NO" id="isAllowDerivativesTransaction"
                                                    name="isAllowDerivativesTransaction" isAddDefaltOption="true"
                                                    initSelectedKey="${info.isAllowDerivativesTransaction}"
                                                    clazz="form-control required"/>
                                    </span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">开户日期:</label>
                        <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="openAccountTime" name="openAccountTime" type="text"
                                               class="form-control"
                                               value="${info.openAccountTime}" required/>
                                    </span>
                        </div>
                    </div>
                </div>
                <c:if test="${info.gid!=null and info.gid!=''}">
                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">更新时间：</label>
                            <div class="col-xs-9">
                                <span class="col-xs-9 block input-icon input-icon-right">
                                    <input name="updateTime" type="text" class="form-control" value="${info.updateTime}"
                                           readonly/>
                                </span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">创建时间：</label>
                            <div class="col-xs-9">
                             <span class="col-xs-9 block input-icon input-icon-right">
                                   <input name="createTime" type="text" value="${info.createTime}" class="form-control"
                                          readonly/>
                              </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">创建人:</label>
                            <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="createUser" name="createUser" type="text" class="form-control"
                                               value="${info.createUser}" readonly/>
                                    </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">修改人:</label>
                            <div class="col-xs-9">
                                    <span class="col-xs-9 block input-icon input-icon-right">
                                        <input id="modifyUser" name="modifyUser" type="text" class="form-control"
                                               value="${info.modifyUser}" readonly/>
                                    </span>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
        <div id="div7" v-cloak>
            <div class="row" style="margin-left: 40%;padding-bottom: 28px;margin-top: 25px;">
                <button class="layui-btn " type="button" id="submitBtn" name="submitBtn">保存</button>
                <button class="layui-btn " type="button" id="clsBtn" name="clsBtn">关闭</button>
            </div>
        </div>
    </form>
</div>
</body>
<style>
    .error {
        color: red;
    }
</style>
<script>
    //提交
    $("#submitBtn").click(function () {
        if ($("#customerList").valid()) {
            var userId = $("#userId").val();
            var infoUserId = ${info.userId}+"";
            //验证userID 若userId没改动 则直接验证交易帐号
            if (${tab=="update"}) {
                if (userId != infoUserId) {
                    checkUserId();
                } else if (userId == infoUserId ||userId == null || userId == "") {
                    var tradeAccount = $("#tradeAccount").val();
                    var infoAccount = ${info.tradeAccount}+"";
                    if (tradeAccount != infoAccount) {
                        checkTradeAccount();
                    } else if (tradeAccount == infoAccount) {
                        save();
                    }
                }
            } else if (${tab=="insert"}) {
                checkUserId();
            }
        }
    });

    //提交方法
    function save() {

        // 把其他受益人拼接成JSON字符串存入数据库
        var ownName1 = $("#ownName1").val();
        var ownAddress1 = $("#ownAddress1").val()
        var ownName2 = $("#ownName2").val();
        var ownAddress2 = $("#ownAddress2").val()
        var ownName3 = $("#ownName3").val();
        var ownAddress3 = $("#ownAddress3").val()
        var params = [];
        if (ownName1 != null && ownName1 != "" && ownAddress1 != null && ownAddress1 != "") {
            params.push({"ownAddress": ownAddress1, "ownName": ownName1});
        }
        if (ownName2 != null && ownName2 != "" && ownAddress2 != null && ownAddress2 != "") {
            params.push({"ownAddress": ownAddress2, "ownName": ownName2});
        }
        if (ownName3 != null && ownName3 != "" && ownAddress3 != null && ownAddress3 != "") {
            params.push({"ownAddress": ownAddress3, "ownName": ownName3});
        }

        var ownerOfAccountsDetail = JSON.stringify(params);

        // 把其他银行卡信息拼接成JSON字符串存入数据库
        params = [];
        var accountNumber1 = $("#accountNumber1").val();
        var bankName1 = $("#bankName1").val();
        var accountNumber2 = $("#accountNumber2").val();
        var bankName2 = $("#bankName2").val();
        var accountNumber3 = $("#accountNumber3").val();
        var bankName3 = $("#bankName3").val();

        if (bankName1 != null && bankName1 != "" && accountNumber1 != null && accountNumber1 != "") {
            params.push({"accountNumber": accountNumber1, "bankName": bankName1});
        }
        if (bankName2 != null && bankName2 != "" && accountNumber2 != null && accountNumber2 != "") {
            params.push({"accountNumber": accountNumber2, "bankName": bankName2});
        }
        if (bankName3 != null && bankName3 != "" && accountNumber3 != null && accountNumber3 != "") {
            params.push({"accountNumber": accountNumber3, "bankName": bankName3});
        }
        if(params == "[]"){
            params = null;
        }
        var otherAccountsDetailInfo = JSON.stringify(params);
        $.ajax({
            url: "${webRoot}/secUserInfo/updateCustomer",   //处理页面的名称
            data: $.param({
                ownerOfAccountsDetail: ownerOfAccountsDetail,
                otherAccountsDetailInfo: otherAccountsDetailInfo
            }) + '&' + $("#customerList").serialize(), //为值取个名字*/
            type: "post",  //传值方式
            dataType: "text",
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

    //验证userId的方法
    function checkUserId() {
        var userId = $("#userId").val();
            $.ajax({
                url: "${webRoot}/secUserInfo/checkUserId",   //处理页面的名称
                data: {
                    userId: userId
                },  //为值取个名字
                type: "POST",  //传值方式
                dataType: "text",  //数据类型
                success: function (d) {
                    if (d.trim() == "exist") {
                        layer.alert("该小神号已存在！")
                        return;
                    } else {
                        var tradeAccount = $("#tradeAccount").val();
                        var infoAccount = ${info.tradeAccount}+"";
                        if (tradeAccount != infoAccount) {
                            checkTradeAccount();
                        } else if (tradeAccount == infoAccount) {
                            save();
                        }
                    }
                }
            })
    }

    // 验证交易帐号的方法
    function checkTradeAccount() {
        var tradeAccount = $("#tradeAccount").val();
        $.ajax({
            url: "${webRoot}/secUserInfo/checkTradeAccount",   //处理页面的名称
            data: {
                tradeAccount: tradeAccount
            },  //为值取个名字
            type: "POST",  //传值方式
            dataType: "text",  //数据类型
            success: function (d) {
                if (d.trim() == "exist") {
                    layer.alert("该交易账户号已存在！")
                } else {
                    save();
                }
            }
        })
    }

    //时间控件 生日 开户日期
    layui.laydate.render({
        elem: '#birthday'
    });
    layui.laydate.render({
        elem: '#openAccountTime'
    });

    $("#clsBtn").click(function () {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    });

    end: function close() {
        window.parent.location.reload();
    }

    $("#hasOtherAccount").bind("change", function(){
        var value = $(this).val();
        if(value == "1"){
            $("#otherAccount").show();
        }else {
            $("#otherAccount").hide();
        }

    });

    $("#ownerOfAccountType").bind("change", function(){
        var value = $(this).val();
        if(value == "1"){
            $("#otherPerson").show();
        }else {
            $("#otherPerson").hide();
        }

    });


    $(function(){
        if($("#hasOtherAccount").val()=='1'){
            $("#otherAccount").show();
        }else{
            $("#otherAccount").hide();
        }
        if($("#ownerOfAccountType").val()=='1'){
            $("#otherPerson").show();
        }else{
            $("#otherPerson").hide();
        }
    });

    layui.form.render('select');

</script>
</html>
