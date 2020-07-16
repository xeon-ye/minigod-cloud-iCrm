<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>出金申请详情页</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">
    <link rel="stylesheet" href="${webRoot}/viewer/css/main.css">
    <script src="${webRoot}/viewer/js/viewer.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div id="div10" v-cloak>
    <div v-show="!showList" class="panel panel-default" >
        <div class="panel-heading"><b style="color: #368763">详细信息</b></div>
        </br>

        <%--<div class="row">--%>
            <%--<div class="form-group col-sm-6 col-md-6">--%>
                <%--<label class="col-sm-2 control-label no-padding-right">客户帐号</label>--%>
                <%--<div class="col-xs-9">--%>
	                           <%--<span class="col-sm-12 block input-icon input-icon-right">--%>
	                                <%--<input id="clientId" name="clientId" type="text" class="form-control"--%>
                                           <%--value="${info.clientId}" readonly/>--%>
	                            <%--</span>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="form-group col-sm-6 col-md-6">--%>
                <%--<label class="col-sm-2 control-label no-padding-right">收款人名称</label>--%>
                <%--<div class="col-xs-9">--%>
                           <%--<span class="col-sm-12 block input-icon input-icon-right">--%>
                                <%--<input id="clientNameSpell" name="clientNameSpell" type="text" class="form-control"--%>
                                       <%--value="${info.clientNameSpell}" readonly/>--%>
                            <%--</span>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
            <%--<div class="form-group col-sm-6 col-md-6">--%>
                <%--<label class="col-sm-2 control-label no-padding-right">资金帐号</label>--%>
                <%--<div class="col-xs-9">--%>
	                           <%--<span class="col-sm-12 block input-icon input-icon-right">--%>
	                                <%--<input id="fundAccount" name="fundAccount" type="text" class="form-control"--%>
                                           <%--value="${info.fundAccount}" readonly/>--%>
	                            <%--</span>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="form-group col-sm-6 col-md-6">--%>
                <%--<label class="col-sm-2 control-label no-padding-right">收款银行名称</label>--%>
                <%--<div class="col-xs-9">--%>
                           <%--<span class="col-sm-12 block input-icon input-icon-right">--%>
                                <%--<input id="bankName" name="bankName" type="text" class="form-control"--%>
                                       <%--value="${info.bankName}" readonly/>--%>
                            <%--</span>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
            <%--<div class="form-group col-sm-6 col-md-6">--%>
                <%--<label class="col-sm-2 control-label no-padding-right">客户姓名</label>--%>
                <%--<div class="col-xs-9">--%>
	                           <%--<span class="col-sm-12 block input-icon input-icon-right">--%>
	                                <%--<input id="clientName" name="clientName" type="text" class="form-control"--%>
                                           <%--value="${info.clientName}" readonly/>--%>
	                            <%--</span>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="form-group col-sm-6 col-md-6">--%>
                <%--<label class="col-sm-2 control-label no-padding-right">收款银行帐户</label>--%>
                <%--<div class="col-xs-9">--%>
                           <%--<span class="col-sm-12 block input-icon input-icon-right">--%>
                           <%--<input id="bankNo" name="bankNo" type="text" class="form-control"--%>
                                  <%--value="${info.bankNo}" readonly/>--%>

                            <%--</span>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
            <%--<div class="form-group col-sm-6 col-md-6">--%>
                <%--<label class="col-sm-2 control-label no-padding-right">Swift Code</label>--%>
                <%--<div class="col-xs-9">--%>
                           <%--<span class="col-sm-12 block input-icon input-icon-right">--%>
                           <%--<input id="swiftCode" name="swiftCode" type="text" class="form-control"--%>
                                  <%--value="${info.swiftCode}" readonly/>--%>

                            <%--</span>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="form-group col-sm-6 col-md-6">--%>
                <%--<label class="col-sm-2 control-label no-padding-right">币种</label>--%>
                <%--<div class="col-xs-9">--%>
                           <%--<span class="col-sm-12 block input-icon input-icon-right">--%>
                            <%--<tag:select nameKey="SEC_MONEY_TYPE_TRD" id="moneyType" isAddDefaltOption="true"--%>
                                        <%--initSelectedKey="${info.moneyType}"--%>
                                        <%--clazz="form-control" disabled="false"/>--%>
                            <%--</span>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
            <%--<div class="form-group col-sm-6 col-md-6">--%>
                <%--<label class="col-sm-2 control-label no-padding-right">联系地址</label>--%>
                <%--<div class="col-xs-9">--%>
                           <%--<span class="col-sm-12 block input-icon input-icon-right">--%>
                           <%--<input id="contactAddress" name="contactAddress" type="text" class="form-control"--%>
                                  <%--value="${info.contactAddress}" readonly/>--%>
                            <%--</span>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="form-group col-sm-6 col-md-6">--%>
                <%--<label class="col-sm-2 control-label no-padding-right">提取金额</label>--%>
                <%--<div class="col-xs-9">--%>
                           <%--<span class="col-sm-12 block input-icon input-icon-right">--%>
                           <%--<input id="occurBalance" name="occurBalance" type="text" class="form-control"--%>
                                  <%--value="<fmt:formatNumber value="${info.occurBalance}" pattern="#,#00.00"/>" readonly/>--%>
                            <%--</span>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">提取方式</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <tag:select nameKey="FUND_BANK_TYPE" id="withdrawType" isAddDefaltOption="true"
                                            initSelectedKey="${info.withdrawType}"
                                            clazz="form-control" disabled="false"/>
                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">收款人名称</label>
                <div class="col-xs-9">
                    <span class="col-sm-12 block input-icon input-icon-right">
                        <c:choose>
                            <c:when test="${operationFlag == true && info.applicationStatus =='1'}">
                                <input id="clientNameSpell" name="clientNameSpell" type="text" class="form-control"
                                       value="${info.clientNameSpell}"/>
                            </c:when>
                            <c:otherwise>
                                <input id="clientNameSpell" name="clientNameSpell" type="text" class="form-control"
                                       value="${info.clientNameSpell}" readonly/>
                            </c:otherwise>
                        </c:choose>
                    </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">申请时间</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <input id="receiveTime" name="receiveTime" type="text" class="form-control"
                                       value="<fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                       readonly/>
                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">收款银行名称</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <input id="bankName" name="bankName" type="text" class="form-control"
                                       value="${info.bankName}" readonly/>
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
                                           value="${info.clientId}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">收款银行帐户</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="bankNo" name="bankNo" type="text" class="form-control"
                                  value="${info.bankNo}" readonly/>

                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">资金帐号</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="fundAccount" name="fundAccount" type="text" class="form-control"
                                           value="${info.fundAccount}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">Swift Code</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="swiftCode" name="swiftCode" type="text" class="form-control"
                                  value="${info.swiftCode}" readonly/>

                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">客户姓名</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="clientName" name="clientName" type="text" class="form-control"
                                           value="${info.clientName}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">联系地址</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="contactAddress" name="contactAddress" type="text" class="form-control"
                                  value="${info.contactAddress}" readonly/>
                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">英文名</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="clientNameEn" name="clientNameEn" type="text" class="form-control"
                                           value="${info.clientNameEn}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">币种</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                            <tag:select nameKey="SEC_MONEY_TYPE_TRD" id="moneyType" isAddDefaltOption="true"
                                        initSelectedKey="${info.moneyType}"
                                        clazz="form-control" disabled="false"/>
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
                                                initSelectedKey="${info.idKind}"
                                                clazz="form-control" disabled="false"/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">提取金额</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="occurBalance" name="occurBalance" type="text" class="form-control"
                                  value="${info.occurBalance}" readonly/>
                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">证件号码</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                               <input id="idNo" name="idNo" type="text" class="form-control"
                                          value="${info.idNo}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">冻结金额</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="frozenBalance" name="frozenBalance" type="text" class="form-control"
                                  value="${info.frozenBalance}" readonly/>

                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">证券手机号</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="phoneNumber" name="phoneNumber" type="text" class="form-control"
                                           value="${info.phoneNumber}" readonly/>
	                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">可取金额</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="currentBalance" name="currentBalance" type="text" class="form-control"
                                  value="${info.currentBalance}" readonly/>
                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">手续费</label>
                <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                           <input id="chargeMoney" name="chargeMoney" type="text" class="form-control"
                                      value="<fmt:formatNumber value="${info.chargeMoney}" pattern="#,##0.00"/>" readonly/>
                                </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-2 control-label no-padding-right">实际提取金额</label>
                <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="actualBalance" name="actualBalance" type="text" class="form-control"
                                  value="<fmt:formatNumber value="${info.actualBalance}" pattern="#,##0.00"/>" readonly/>
                            </span>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
