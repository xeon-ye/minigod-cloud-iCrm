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
    <script src="${webRoot}/js/ajaxupload.js"></script>
    <script src="${webRoot}/viewer/js/main.js"></script>
    <script src="${webRoot}/js/photo/pictureShow.js"></script>
</head>
<body>
<div id="div0" v-cloak>
    <div id="div1" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763;text-align:center">客户信息</b></div>
            </br>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">开户途径</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                    <input id="openAccountType" name="openAccountType" type="text" class="form-control"
                                           value="${info.openAccountType}" readonly>
                            </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">帐户审批通过时间</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <input id="openSussTime" name="openSussTime" type="text" class="form-control"
                                       value="<fmt:formatDate value="${info.openAccountTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
                                       value="${info.userId}" readonly/>
                            </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">客户姓名</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <input id="clientName" name="clientName" type="text" class="form-control"
                                       value="${info.clientName}" readonly/>
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
                    <label class="col-sm-3 control-label no-padding-right">英文/拼音名</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="clientNameSpell" name="clientNameSpell" type="text" class="form-control"
                                  value="${info.clientNameSpell}" readonly/>

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
                    <label class="col-sm-3 control-label no-padding-right">证件类型</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                               <tag:select nameKey="AO_ID_KIND" id="idkind" isAddDefaltOption="true"
                                           initSelectedKey="${info.idkind}"
                                           clazz="form-control" disabled="false"/>
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
                    <label class="col-sm-3 control-label no-padding-right">证件号码</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="idNo" name="idNo" type="text" class="form-control"
                                  value="${info.idNo}" readonly/>
                            </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="div2" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763;text-align:center">入金信息</b></div>
            </br>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">入金申请时间</label>
                    <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="applicationTime" name="applicationTime" type="text" class="form-control"
                                           value="<fmt:formatDate value="${info.applicationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                           readonly/>
	                            </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">存入方式</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <tag:select nameKey="FUND_BANK_TYPE" id="depositType" isAddDefaltOption="true"
                                            initSelectedKey="${info.depositType}"
                                            clazz="form-control" disabled="false"/>
                            </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">收款帐户名称</label>
                    <div class="col-xs-9">
                        <span class="col-sm-12 block input-icon input-icon-right">
                            <c:if test="${operationFlag==0 or operationFlag==1}">
	                                <input id="benefitAccount" name="benefitAccount" type="text" class="form-control"
                                           value="${info.benefitAccount}" readonly/>
                            </c:if>
                            <c:if test="${operationFlag==2}">
	                                <input id="benefitAccount" name="benefitAccount" type="text" class="form-control"
                                           value="${info.benefitAccount}"/>
                            </c:if>
                        </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">汇款帐户名称</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                           <input id="depositAccount" name="depositAccount" type="text" class="form-control"
                                  value="${info.depositAccount}" readonly/>
                            </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">收款银行名称</label>
                    <div class="col-xs-9">
                        <span class="col-sm-12 block input-icon input-icon-right">
                            <c:if test="${operationFlag==0 or operationFlag==1}">
                                <tag:select nameKey="FUND_DEPOSIT_BANK" id="benefitBank" isAddDefaltOption="true"
                                            initSelectedKey="${info.benefitBank}"
                                            clazz="form-control" disabled="false"/>
                            </c:if>
                            <c:if test="${operationFlag==2}">
                                <tag:select nameKey="FUND_DEPOSIT_BANK" id="benefitBank" isAddDefaltOption="true"
                                            initSelectedKey="${info.benefitBank}"
                                            clazz="form-control"/>
                            </c:if>
                        </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">汇款银行名称</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                            <c:if test="${operationFlag==0 or operationFlag==1}">
                                 <input id="depositBank" name="depositBank" type="text" class="form-control"
                                        value="${info.depositBank}" readonly/>
                            </c:if>
                            <c:if test="${operationFlag==2}">
                                 <input id="depositBank" name="depositBank" type="text" class="form-control"
                                        value="${info.depositBank}"/>
                            </c:if>
                            </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">收款帐户号码</label>
                    <div class="col-xs-9">
                            <span class="col-sm-12 block input-icon input-icon-right">
                                <c:if test="${operationFlag==0 or operationFlag==1}">
	                                <input id="benefitNo" name="benefitNo" type="text" class="form-control"
                                           value="${info.benefitNo}" readonly/>
                                </c:if>
                                <c:if test="${operationFlag==2}">
	                                <input id="benefitNo" name="benefitNo" type="text" class="form-control"
                                           value="${info.benefitNo}"/>
                                </c:if>
                            </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">汇款帐户号码</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                            <c:if test="${operationFlag==0 or operationFlag==1}">
                                <input id="depositNo" name="depositNo" type="text" class="form-control"
                                       value="${info.depositNo}" readonly/>
                            </c:if>
                            <c:if test="${operationFlag==2}">
                                <input id="depositNo" name="depositNo" type="text" class="form-control"
                                       value="${info.depositNo}"/>
                            </c:if>
                            </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">Swift Code</label>
                    <div class="col-xs-9">
	                      <span class="col-sm-12 block input-icon input-icon-right">
                                <c:if test="${operationFlag==0 or operationFlag==1}">
	                                <input id="swiftCode" name="swiftCode" type="text" class="form-control"
                                           value="${info.swiftCode}" readonly/>
                                </c:if>
                                <c:if test="${operationFlag==2}">
	                                <input id="swiftCode" name="swiftCode" type="text" class="form-control"
                                           value="${info.swiftCode}"/>
                                </c:if>
                          </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">币种</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <c:if test="${operationFlag==0 or operationFlag==1}">
                                    <tag:select nameKey="SEC_MONEY_TYPE_TRD" id="moneyType" isAddDefaltOption="true"
                                                initSelectedKey="${info.moneyType}" initDidableKey="0,w"
                                                clazz="form-control" disabled="false"/>

                                </c:if>
                               <c:if test="${operationFlag==2}">
                                   <tag:select nameKey="SEC_MONEY_TYPE_TRD" id="moneyType" name="moneyType"
                                               initSelectedKey="${info.moneyType}" initDidableKey="0,w"
                                               clazz="form-control"/>
                               </c:if>
                            </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">联系地址</label>
                    <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="contactAddress" name="contactAddress" type="text" class="form-control"
                                           value="${info.contactAddress}" readonly/>
	                            </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">申请金额</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
                                <c:if test="${operationFlag==0 or operationFlag==1}">
                                    <input id="depositBalance" name="depositBalance" type="text" class="form-control"
                                           value="<fmt:formatNumber value="${info.depositBalance}" pattern="#,##0.00#"/>"
                                           readonly/>
                                </c:if>
                               <c:if test="${operationFlag==2}">
                                   <input id="depositBalance" name="depositBalance" type="number" class="form-control"
                                          value="${info.depositBalance}"/>
                               </c:if>
                            </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">是否首次入金</label>
                    <div class="col-xs-9">
	                           <span class="col-sm-12 block input-icon input-icon-right">
                                 <c:choose>
                                     <c:when test="${info.firstDepFlag < 1}">
                                         <input id="firstDepFlag" name="firstDepFlag" type="text" class="form-control"
                                                value="是" readonly/>
                                     </c:when>
                                     <c:otherwise>
                                         <input id="firstDepFlag" name="firstDepFlag" type="text" class="form-control"
                                                value="否" readonly/>
                                     </c:otherwise>
                                 </c:choose>
	                            </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">到账金额</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="benefitBalance" name="benefitBalance" type="text" class="form-control"
                                           value="<fmt:formatNumber value="${info.benefitBalance}" pattern="#,##0.00#"/>"
                                           readonly/>
	                            </span>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-2 control-label no-padding-right">银行到账日期</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="bankEntryTime" name="bankEntryTime" type="text" class="form-control"
                                           value="<fmt:formatDate value="${info.bankEntryTime}" pattern="yyyy-MM-dd"/>"
                                           readonly/>
	                            </span>
                    </div>
                </div>

                <div class="form-group col-sm-6 col-md-6">
                    <label class="col-sm-3 control-label no-padding-right">银行流水号</label>
                    <div class="col-xs-9">
                           <span class="col-sm-12 block input-icon input-icon-right">
	                                <input id="referenceNo" name="referenceNo" type="text" class="form-control"
                                           value="${info.referenceNo}" readonly/>
                           </span>
                    </div>
                </div>
            </div>
        </div>

        <div id="div7" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;text-align:center">开户银行卡</b></div>
                <div style="margin-left: 10px;width: 99%; font-size: 0; height: 150px; vertical-align: middle;">
                    <div style="margin-left: 10px;width: 99%">
                        <div hidden id="imageList_bankCards">
                            <ul class="docs-pictures"></ul>
                        </div>
                        <c:forEach var="imageInfo" items="${bankCards}" varStatus="i">
                                <span class="col-xs-1 block input-icon input-icon-right"
                                      style="margin-top: 10px; margin-left: 50px">
                                    <img width="150" height="120"
                                         src='${webRoot}/common/downloadFile?fullFilePath=${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}'
                                         onclick="showImage('_bankCards',${i.index})">
                                </span>
                            <!--循环调用方法-->
                            <script type="text/javascript">pictureListWithId("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}", ${i.index}, '_bankCards');</script>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

        <div id="div3" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;text-align:center">客户凭证</b></div>
                <div style="margin-left: 10px;width: 99%; font-size: 0; height: 150px; vertical-align: middle;">
                    <div id="despositImageDiv" style="margin-left: 10px;width: 99%">
                        <div hidden id="imageList${info.applicationId}0">
                            <ul class="docs-pictures"></ul>
                        </div>
                        <c:forEach var="imageInfo" items="${info.despositImage}" varStatus="i">
                                <span class="col-xs-1 block input-icon input-icon-right"
                                      style="margin-top: 10px; margin-left: 50px">
                                    <img width="150" height="120"
                                         src='${webRoot}/common/downloadFile?fullFilePath=${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}'
                                         onclick="showImage('${info.applicationId}0',${i.index});">
                                    <c:if test="${operationFlag==2}">
                                        <span class="col-xs-1 block input-icon"
                                              style="margin-top: 5px;margin-left: 20px">
                                        <button id="reLoadButtonV${i.index}" type="button"
                                                name="reLoadButtonV" value="${imageInfo.id}">
                                                <i class="layui-icon" style="font-size: 20px; color: #209d6c;">
                                                    &#xe642;</i>
                                        </button>
                                        </span>
                                        <span class="col-xs-1 block input-icon"
                                              style="margin-top: 5px;margin-left: 20px">
                                        <button id="deleteImage" type="button"
                                                name="deleteImage" onclick="deleteImage(${imageInfo.id})">
                                                <i class="layui-icon" style="font-size: 20px; color: #ff2128;">
                                                    &#xe640;</i>
                                        </button>
                                        </span>
                                    </c:if>
                                </span>
                            <!--循环调用方法-->
                            <script type="text/javascript">pictureListWithId("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}", ${i.index}, '${info.applicationId}0');</script>
                        </c:forEach>
                        <c:if test="${operationFlag==2}">
                        <span class="col-xs-2 block input-icon input-icon-right"
                              style="margin-top: 10px; margin-left: 50px">
                            <button id="uploadImage" type="button" name="uploadImage">
                                <i class="layui-icon" style="font-size: 105px; color: #209d6c;">
                                    &#xe608;</i>
                            </button>
                        </span>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

        <c:if test="${info.applicationStatus !='1' && flowSource!=1}">
            <div id="div5" v-cloak>
                <div v-show="!showList" class="panel panel-default">
                    <div class="panel-heading"><b style="color: #368763;text-align:center">银行凭证</b></div>
                    <div style="margin-left: 10px;width: 99%; font-size: 0; height: 150px; vertical-align: middle;">
                        <div style="margin-left: 10px;width: 99%">
                            <div hidden id="imageList${info.applicationId}1">
                                <ul class="docs-pictures"></ul>
                            </div>
                            <c:forEach var="imageInfo" items="${info.bankImage}" varStatus="i">
                                <span class="col-xs-1 block input-icon input-icon-right"
                                      style="margin-top: 10px; margin-left: 50px">
                                    <img width="150" height="120"
                                         src='${webRoot}/common/downloadFile?fullFilePath=${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}'
                                         onclick="showImage(${info.applicationId}+'1',${i.index})">
                                </span>
                                <!--循环调用方法-->
                                <script type="text/javascript">pictureListWithId("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}", ${i.index}, ${info.applicationId}+'1');</script>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${info.applicationStatus !='1' && flowSource==1}">
        <div id="div7" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;text-align:center">银行流水</b></div>
                <table class="layui-table" style="width:100%">
                    <thead>
                    <th>流水号</th>
                    <th>交易日期</th>
                    <th>交易时间</th>
                    <th>交易类型</th>
                    <th>汇款帐户名称</th>
                    <th>汇款帐户号码</th>
                    <th>汇款银行ID</th>
                    <th>币种</th>
                    <th>汇款金额</th>
                    <th>手续费</th>
                    <th>到账金额</th>
                    <th>收款帐户号码</th>
                    <th>客户流水号</th>
                    <th>银行流水号</th>
                    </thead>
                    <tbody>
                    <c:if test="${empty bankBill}">
                        <tr>
                            <td colspan="14" align="center">暂无数据</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${bankBill}" var="info" varStatus="i">
                        <tr>
                            <td>${info.msgId}</td>
                            <td><fmt:formatDate value="${info.timeStamp}" pattern="dd/MM/yyyy"/></td>
                            <td><fmt:formatDate value="${info.timeStamp}" pattern="HH:mm:ss"/></td>
                            <td>${info.txnType}</td>
                            <td>${info.senderAccName}</td>
                            <td>${info.senderAccNo}</td>
                            <td>${info.senderBankId}</td>
                            <td>
                                    ${fns:getCodeName("SEC_MONEY_TYPE_EN", info.currency)}
                            </td>
                            <td><fmt:formatNumber value="${info.actualMoney}" pattern="#,##0.00#"/></td>
                            <c:if test="${info.areChargeMoney == null or info.areEnqStatus == '' or info.areEnqStatus!='ACSP'}">
                                <td><span style="color: red">未获取</span></td>
                            </c:if>
                            <c:if test="${info.areEnqStatus =='ACSP'}">
                                <td><fmt:formatNumber value="${info.areChargeMoney}" pattern="#,##0.00#"/></td>
                            </c:if>
                            <td><fmt:formatNumber value="${info.creditAmount}" pattern="#,##0.00#"/></td>
                            <td>${info.subAccno}</td>
                            <td>${info.customerReference}</td>
                            <td>${info.referenceNo}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        </c:if>

        <c:if test="${operationFlag ==0 or (operationFlag ==1 and info.applicationStatus =='4')}">
            <div id="div6" v-cloak>
                <div v-show="!showList" class="panel panel-default">
                    <div class="panel-heading"><b style="color: #368763;text-align:center">客户银行卡记录</b></div>
                    <table class="layui-table" style="width:100%">
                        <thead>
                        <tr width="99%">
                            <th>银行卡类型</th>
                            <th>银行名称</th>
                            <th>银行账户名称</th>
                            <th>银行账户号码</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${empty cards}">
                            <tr>
                                <td colspan="4" align="center">暂无数据</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${cards}" var="card" varStatus="i">
                            <tr>
                                <td>
                                        ${fns:getCodeName("FUND_BANK_TYPE", card.bankType)}
                                </td>
                                <td>${card.bankName}</td>
                                <td>${card.bankAccount}</td>
                                <td>${card.bankNo}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:if>

        <c:if test="${operationFlag==1}">
            <div id="div4" v-cloak>
                <div v-show="!showList" class="panel panel-default">
                    <div class="panel-heading"><b style="color: #368763;text-align:center">审批意见</b></div>
                    </br>
                    <div class="form-group" style="margin-left: 10px;width: 99%">
                    <textarea name="remark" id="remark" class="form-control" rows="3"
                              placeholder="不超过100个字符,非必填"></textarea>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
    <%@include file="activitiOperate.jsp" %>
</body>
<script type="text/javascript">

    $(function () {
        $('#imageList${info.applicationId}0').viewer();
        $('#imageList${info.applicationId}1').viewer();
        $('#imageList_bankCards').viewer();
    });

    $(document).ready(function () {
        var reButton = document.getElementsByName('reLoadButtonV');
        for (var i = 0; i < reButton.length; i++) {
            var id = $("#reLoadButtonV" + i).val();
            var applicationId = '${info.applicationId}';
            new AjaxUpload(reButton[i], {
                action: '${webRoot}/clientFundDeposit/reUpload',
                name: 'file',
                contentType: "application/json;charset=UTF-8",
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    gid: id
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(jpg|jpeg|bmp|png)$/.test(extension.toLowerCase()))) {
                        alert('只支持jpg、jpeg、png、bmp格式的图片！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/clientFundDeposit/depositImgRefresh?flag=${operationFlag}&applicationId=${info.applicationId}",
                            timeout: 3000,
                            success: function (page) {
                                $.ajaxPrefilter('script', function (options) {
                                    options.cache = true;
                                });
                                $("#despositImageDiv").html(page);
                                alert("更新成功");
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
        var updateButtons2 = document.getElementsByName('uploadImage');
        for (var i = 0; i < updateButtons2.length; i++) {
            var applicationId = '${info.applicationId}';
            new AjaxUpload(updateButtons2[i], {
                action: '${webRoot}/clientFundDeposit/uploadImage',
                name: 'file',
                autoSubmit: true,
                data: {
                    applicationId: applicationId,
                    imageType: 0
                },
                responseType: "json",
                onSubmit: function (file, extension) {
                    if (!(extension && /^(jpg|jpeg|bmp|png)$/.test(extension.toLowerCase()))) {
                        alert('只支持jpg、jpeg、bmp、png格式的图片！');
                        return false;
                    }
                },
                onComplete: function (file, result) {
                    if (result.code == 0) {
                        $.ajax({
                            type: "get",
                            async: false,
                            cache: false,
                            url: "${webRoot}/clientFundDeposit/depositImgRefresh?flag=${operationFlag}&applicationId=${info.applicationId}",
                            timeout: 3000,
                            success: function (page) {
                                $.ajaxPrefilter('script', function (options) {
                                    options.cache = true;
                                });
                                $("#despositImageDiv").html(page);
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

    function deleteImage(id) {
        confirm("确定删除图片吗？", function () {
            var url = "${webRoot}/clientFundDeposit/deleteImage";
            var params = {
                'id': id,
            };
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    $.ajax({
                        type: "get",
                        async: false,
                        cache: false,
                        url: "${webRoot}/clientFundDeposit/depositImgRefresh?flag=${operationFlag}&applicationId=${info.applicationId}",
                        timeout: 3000,
                        success: function (page) {
                            $.ajaxPrefilter('script', function (options) {
                                options.cache = true;
                            });
                            $("#despositImageDiv").html(page);
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

    layui.form.render('select');
</script>
</html>

