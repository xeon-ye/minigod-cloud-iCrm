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
    <title>专业投资者申请详情</title>
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
        <c:if test="${operationFlag ==1}">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;text-align:center">基本信息</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">审核状态</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                               <tag:select nameKey="PROFESSIONAL_APPLY_STATUS" id="applicationStatus"
                                           isAddDefaltOption="true"
                                           initSelectedKey="${info.applicationStatus}"
                                           clazz="form-control" disabled="false"/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">小神号</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                                <input id="userId" name="userId" type="text" class="form-control"
                                       value="${info.userId}" readonly/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">申请日期</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                                <input id="applyTime" name="applyTime" type="text" class="form-control"
                                       value="<fmt:formatDate value="${info.applyTime}" pattern="yyyy-MM-dd"/>"
                                       readonly/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">客户帐号</label>
                        <div class="col-xs-9">
	                           <span class="col-sm-8 block input-icon input-icon-right">
	                                <input id="clientId" name="clientId" type="text" class="form-control"
                                           value="${info.clientId}" readonly/>
	                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">于智珠证券所有交易账户近12个月内总资产HKD</label>
                        <div class="col-xs-9">
                        <span class="col-sm-8 block input-icon input-icon-right">
                            <input id="totalAssets" name="totalAssets" type="text" class="form-control"
                                   value="<fmt:formatNumber value="${info.totalAssets}" pattern="#,##0.00#"/>"
                                   readonly/>
                        </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">客户姓名</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                                <input id="clientName" name="clientName" type="text" class="form-control"
                                       value="${info.clientName}" readonly/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">于智珠证券所有交易账户近12个月内总资产对应日期</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                                <input id="totalAssetsDate" name="totalAssetsDate" type="text" class="form-control"
                                       value="<fmt:formatDate value="${info.totalAssetsDate}" pattern="yyyy-MM-dd"/>"
                                       readonly/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">英文名</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                           <input id="clientNameSpell" name="clientNameSpell" type="text" class="form-control"
                                  value="${info.clientNameSpell}" readonly/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">证券手机号</label>
                        <div class="col-xs-9">
                        <span class="col-sm-8 block input-icon input-icon-right">
                            <input id="phoneNumber" name="phoneNumber" type="text" class="form-control"
                                   value="${info.phoneNumber}" readonly/>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${operationFlag ==0 || operationFlag ==3}">
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;text-align:center">基本信息</b></div>
                </br>
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">审核状态</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                               <tag:select nameKey="PROFESSIONAL_APPLY_STATUS" id="applicationStatus"
                                           isAddDefaltOption="true"
                                           initSelectedKey="${info.applicationStatus}"
                                           clazz="form-control" disabled="false"/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">小神号</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                                <input id="userId" name="userId" type="text" class="form-control"
                                       value="${info.userId}" readonly/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">申请日期</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                                <input id="applyTime" name="applyTime" type="text" class="form-control"
                                       value="<fmt:formatDate value="${info.applyTime}" pattern="yyyy-MM-dd"/>"
                                       readonly/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">客户帐号</label>
                        <div class="col-xs-9">
	                           <span class="col-sm-8 block input-icon input-icon-right">
	                                <input id="clientId" name="clientId" type="text" class="form-control"
                                           value="${info.clientId}" readonly/>
	                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">认定日期</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                                <input id="accreditTime" name="accreditTime" type="text" class="form-control"
                                       value="<fmt:formatDate value="${info.accreditTime}" pattern="yyyy-MM-dd"/>"
                                       readonly/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">客户姓名</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                                <input id="clientName" name="clientName" type="text" class="form-control"
                                       value="${info.clientName}" readonly/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">失效日期</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                                <input id="expireTime" name="expireTime" type="text" class="form-control"
                                       value="<fmt:formatDate value="${info.expireTime}" pattern="yyyy-MM-dd"/>"
                                       readonly/>
                            </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">英文名</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                           <input id="clientNameSpell" name="clientNameSpell" type="text" class="form-control"
                                  value="${info.clientNameSpell}" readonly/>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">撤销日期</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                                <input id="revokeTime" name="revokeTime" type="text" class="form-control"
                                       value="<fmt:formatDate value="${info.revokeTime}" pattern="yyyy-MM-dd"/>"
                                       readonly/>
                            </span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-sm-6 col-md-6">
                            <label class="col-sm-3 control-label no-padding-right">证券手机号</label>
                            <div class="col-xs-9">
                        <span class="col-sm-8 block input-icon input-icon-right">
                            <input id="phoneNumber" name="phoneNumber" type="text" class="form-control"
                                   value="${info.phoneNumber}" readonly/>
                        </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">于智珠证券所有交易账户近12个月内总资产HKD</label>
                        <div class="col-xs-9">
                        <span class="col-sm-8 block input-icon input-icon-right">
                            <input id="totalAssets" name="totalAssets" type="text" class="form-control"
                                   value="<fmt:formatNumber value="${info.totalAssets}" pattern="#,##0.00#"/>"
                                   readonly/>
                        </span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">于智珠证券所有交易账户近12个月内总资产对应日期</label>
                        <div class="col-xs-9">
                           <span class="col-sm-8 block input-icon input-icon-right">
                                <input id="totalAssetsDate" name="totalAssetsDate" type="text" class="form-control"
                                       value="<fmt:formatDate value="${info.totalAssetsDate}" pattern="yyyy-MM-dd"/>"
                                       readonly/>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </div>

    <div id="div2" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763;text-align:center">「专业投资者」之待遇</b></div>
            </br>
            <div style="margin-left: 10px;width: 99%; height: 150px;">
                <div class="col-xs-9">
                    <span>本人谨此声明本人为个人客户在考虑以下任何一项或多于一项时，拥有的投资组合在有关日期不少于800万港币或等值货币</span>
                    <span class="col-xs-12">
                        <tag:checkbox nameKey="PROFESSIONAL_PORTFOLIOS" id="portfolios" name="portfolios"
                                      initCheckKey="${info.portfolios}"
                                      disabled="disabled"/>
                    </span>
                </div>
            </div>
        </div>
    </div>


    <div id="div3" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763;text-align:center">资产凭证</b></div>
            <div style="margin-left: 10px;width: 99%; font-size: 0; height: 150px; vertical-align: middle;">
                <div id="assetsImgsDiv" style="margin-left: 10px;width: 99%">
                    <div hidden id="imageList_assetsImgs">
                        <ul class="docs-pictures"></ul>
                    </div>
                    <c:forEach var="imageInfo" items="${info.assetsImgs}" varStatus="i">
                        <span class="col-xs-1 block input-icon input-icon-right"
                              style="margin-top: 10px; margin-left: 20px">
                            <button type="button" class="layui-btn" onclick="showImage('_assetsImgs',${i.index});">
                                <i class="layui-icon">&#xe64a;</i>凭证${i.index}</button>
                        </span>
                        <c:if test="${((i.index % 10) eq 0) && i.index >0}">
                            <br><br>
                        </c:if>
                        <!--循环调用方法-->
                        <script type="text/javascript">pictureListWithId("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}", ${i.index}, '_assetsImgs');</script>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <div id="div5" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763;text-align:center">补充凭证</b></div>
            <div style="margin-left: 10px;width: 99%; font-size: 0; height: 150px; vertical-align: middle;">
                <div id="addImgsDiv" style="margin-left: 10px;width: 99%">
                    <div hidden id="imageList_addImgs">
                        <ul class="docs-pictures"></ul>
                    </div>
                    <c:forEach var="imageInfo" items="${info.addImgs}" varStatus="i">
                        <span class="col-xs-1 block input-icon input-icon-right"
                              style="margin-top: 10px; margin-left: 20px">
                            <button type="button" class="layui-btn" onclick="showImage('_addImgs',${i.index});">
                                <i class="layui-icon">&#xe64a;</i>凭证${i.index}</button>
                        </span>
                        <c:if test="${((i.index % 10) eq 0) && i.index >0}">
                            <br><br>
                        </c:if>
                        <!--循环调用方法-->
                        <script type="text/javascript">pictureListWithId("${imageInfo.storagePath}${imageInfo.fileStorageName}.${imageInfo.extName}", ${i.index}, '_addImgs');</script>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${operationFlag ==1}">
        <div id="div6" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;text-align:center">审批操作</b></div>
                <div style="margin: 5px;width: 99%; height: auto; vertical-align: middle;">
                    <table id="table-list" class="layui-table">
                        <thead>
                        <tr>
                            <th style="width:180px">开始时间</th>
                            <th style="width:180px">结束时间</th>
                            <th style="width:90px">流程节点</th>
                            <th style="width:200px">审批结果</th>
                            <th>审批意见</th>
                            <th>退回理由</th>
                            <th style="width:180px">操作员</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="info" items="${taskLogs}" varStatus="i">
                            <tr id="log_${info.id }">
                                <td><fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td><fmt:formatDate value="${info.dealTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td>${info.taskName }</td>
                                <td>${fns:getCodeName("act_task_result",info.appAction)}</td>
                                <td>${info.appOpinion }</td>
                                <td>${info.backReasonType }</td>
                                <td>${info.dealName }</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td align="center">审批意见</td>
                            <td colspan="6" align="center">
                                <div class="form-group" style="margin: 5px;width: 99%">
                                <textarea name="remark" id="remark" class="form-control" rows="3" style="resize:none;"
                                          placeholder="不超过100个字符"></textarea>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test="${operationFlag ==3 || info.applicationStatus==6}">
        <div id="div7" v-cloak>
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763;text-align:center">撤销操作</b></div>
                <table style="width:99.9%">
                    <tr>
                        <td style="width:10%" align="center">
                            <label class="control-label no-padding-right" style="margin: 10px">撤销原因</label>
                        </td>
                        <td style="display:inline-table;width:90%;">
                            <c:choose>
                                <c:when test="${operationFlag ==3}">
                                <textarea name="revokeReson" id="revokeReson" class="form-control" rows="3"
                                          style="resize:none;margin: 10px"
                                          placeholder="不超过100个字符"></textarea>
                                </c:when>
                                <c:otherwise>
                                <textarea name="revokeReson" id="revokeReson" class="form-control" rows="3"
                                          style="resize:none;margin: 10px" wrap="soft"
                                          readonly>${info.approvalOpinion}</textarea>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </c:if>

</div>

<%@include file="activitiOperate.jsp" %>
</body>

<script type="text/javascript">
    $(function () {
        Array.from(document.getElementById("portfolios").children).forEach(function (item) {
            item.style.display = "block";
        });
        $('#imageList_addImgs').viewer();
        $('#imageList_assetsImgs').viewer();
    });

    layui.form.render('select');
</script>
</html>

