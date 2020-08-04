<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<jsp:useBean id="dateValue" class="java.util.Date"></jsp:useBean>
<%@include file="/common/commonJS.jsp" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<style>
    #investTarget {
        display: inline
    }
</style>
<body style="width: 99%">
<div v-cloak style="margin-top: 20px">
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">基本信息</b></div>
        </br>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">客户姓名</label>
                <div class="col-xs-9">
                                   <span class="col-xs-10 block input-icon input-icon-right">
                                        <input id="clientName" name="clientName" type="text" class="form-control"
                                               value="${customer.clientName}" readonly/>
                                    </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">小神号</label>
                <div class="col-xs-9">
                                   <span class="col-xs-10 block input-icon input-icon-right">
                                        <input id="userId" name="userId" type="text" class="form-control"
                                               value="${customer.userId}" readonly/>
                                    </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">证券手机号</label>
                <div class="col-xs-9" style="display: inline">
                            <span class="col-xs-10 block input-icon input-icon-right">
                                        <input id="phoneNumber" name="phoneNumber" style="display:inline;" type="text"
                                               value="${customer.phoneNumber}" readonly
                                               class="form-control" placeholder="请输入移动电话"/>
                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">客户账号</label>
                <div class="col-xs-9">
                                   <span class="col-xs-10 block input-icon input-icon-right">
                                   <input id="tradeAccount" name="tradeAccount" type="text" class="form-control"
                                          value="${customer.tradeAccount}" readonly/>

                                    </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">注册来源</label>
                <div class="col-xs-9">
                               <span class="col-xs-10 block input-icon input-icon-right">
                               <input id="regSourceType" name="regSourceType" type="text" class="form-control"
                                      value="${customer.regSourceType}" readonly/>
                                </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">渠道号</label>
                <div class="col-xs-9">
                                   <span class="col-xs-10 block input-icon input-icon-right">
                                        <input id="sourceChannelId" name="sourceChannelId" type="text" class="form-control"
                                               value="${customer.sourceChannelId}" readonly/>
                                    </span>
                </div>
            </div>
        </div>

        <div class="row">

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">邀请人</label>
                <div class="col-xs-9">
                                   <span class="col-xs-10 block input-icon input-icon-right">
                                        <input id="inviterId" name="inviterId" type="text" class="form-control"
                                               value="${customer.inviterId}"
                                               readonly/>
                                    </span>
                </div>
            </div>
        </div>
    </div>
</div>

<div v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">财务与投资状况</b></div>
        </br>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">全年收入</label>
                <div class="col-xs-9">
                       <span class="col-xs-10 block input-icon input-icon-right">
                                <tag:select nameKey="AO_INCOME" id="income" isAddDefaltOption="true"
                                            initSelectedKey="${customer.annualIncome}"
                                            clazz="form-control" disabled="false"/>
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">收入来源</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right" style="width:1000px">
                             <tag:checkbox name="capitalSource" nameKey="AO_CAPITAL_SOURCE"
                                           initCheckKey="${customer.capitalSource}"
                                           disabled="disabled"/>
                        </span>
                </div>
            </div>
        </div>
        <c:if test="${propertyTypeList!=null}">
                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-sm-3 control-label no-padding-right">财产种类</label>
                        <div class="col-xs-9">
                                <span class="col-xs-10 block input-icon input-icon-right" style="width:1000px">
                                    <c:if test="${propertyTypeList!=null}">
                                        <c:forEach items="${propertyTypeList}" var="openAccountPropertyType">
                                            <span>
                                                <input style="display: inline;" name="propertyType" type="checkbox"
                                                       value="${openAccountPropertyType.propertyType}"
                                                       disabled="disabled"
                                                       checked="true"/> ${fns:getCodeName("AO_PROPERTY_TYPE",openAccountPropertyType.propertyType)}
                                                <%--<input class="form-control" style="width:150px;display: inline;"--%>
                                                       <%--name="propertyAmount" type="text"--%>
                                                       <%--value="${openAccountPropertyType.propertyAmount}"--%>
                                                       <%--style="height:34px; margin-right: 0px;" readonly/>万港元--%>
                                                <tag:select nameKey="AO_PROPERTY_TYPE_${openAccountPropertyType.propertyType}"  clazz="form-control" style="width:150px;display:inline"
                                                            isAddDefaltOption="true" initSelectedKey="${openAccountPropertyType.propertyAmount}" disabled="disabled"/>港币
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
                <label class="col-sm-3 control-label no-padding-right">投资目标</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right" style="width:1000px">
                            <tag:checkbox nameKey="AO_INVEST_TARGET" id="investTarget" name="investTarget"
                                          initCheckKey="${customer.investTarget}" clazz=""
                                          disabled="disabled" style="display: inline" initDidableKey="2,3"/>
                                <input class="form-control " style="width: 200px;display: inline"
                                       id="investTargetOther"
                                       name="investTargetOther" type="text"
                                       value="${customer.investTargetOther}" readonly/>
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">投资经验</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right" style="width:800px">
                            <span>股票/基金/债券</span>
                                <tag:select nameKey="AO_STOCKS_INVESTMENT_EXPERIENCE_TYPE"
                                            id="stocksInvestmentExperienceType" isAddDefaltOption="true"
                                            initSelectedKey="${customer.stocksInvestmentExperienceType}"
                                            clazz="form-control " style="width:120px;display:inline"
                                            disabled="true"/>

                            <span style="margin-left:20px;">认股证/股票期权</span>
                                 <tag:select nameKey="AO_WARRANTS_INVESTMENT_EXPERIENCE_TYPE"
                                             id="warrantsInvestmentExperienceType" isAddDefaltOption="true"
                                             initSelectedKey="${customer.warrantsInvestmentExperienceType}"
                                             clazz="form-control" style="width:120px;display:inline"
                                             disabled="true"/>

                            <span style="margin-left:20px;">期货/期权</span>
                                <tag:select nameKey="AO_FUTURES_INVESTMENT_EXPERIENCE_TYPE"
                                            id="futuresInvestmentExperienceType" isAddDefaltOption="true"
                                            initSelectedKey="${customer.futuresInvestmentExperienceType}"
                                            clazz="form-control" style="width:120px;display:inline"
                                            disabled="true"/>
                        </span>
                </div>
            </div>
        </div>
    </div>
</div>

<div v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">行情与佣金</b></div>
        </br>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">佣金套餐</label>
                <div class="col-xs-9">
                       <span class="col-xs-10 block input-icon input-icon-right">
                                <input  type="text" class="form-control" value="${fareCase}" readonly/>
                            </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">佣金状态</label>
                <div class="col-xs-9">
                       <span class="col-xs-10 block input-icon input-icon-right">
                                <input  type="text" class="form-control" value="${customer.freeStatus}" readonly/>
                            </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">免佣有有效期至</label>
                <div class="col-xs-9">
                       <span class="col-xs-10 block input-icon input-icon-right">
                        <input id="freeEndDate" name="freeEndDate" type="text"
                               class="form-control"
                               value="${customer.freeEndDate}" readonly/>
                        </span>
                </div>
            </div>

            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">免佣累计时长</label>
                <div class="col-xs-9">
                       <span class="col-xs-10 block input-icon input-icon-right">
                        <input id="freeTotalTime" name="freeTotalTime" type="text"
                               class="form-control"
                               value="${customer.freeTotalTime}" readonly/>
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">美股行情套餐</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input  type="text" class="form-control" value="${usaUserHqInfo.packageName}" readonly/>
                        </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">港股行情套餐</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input  type="text" class="form-control" value="${hkUserHqInfo.packageName}" readonly/>
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">美股行情有效期至</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input  type="text" class="form-control" value="${usaUserHqInfo.endTime}" readonly/>
                        </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">港股行情有效期至</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input  type="text" class="form-control" value="${hkUserHqInfo.endTime}" readonly/>
                        </span>
                </div>
            </div>
        </div>
    </div>
</div>

<div v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">活跃情况</b></div>
        </br>
        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">注册时间</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="registerTime" name="registerTime" type="text"
                                   class="form-control"
                                   value="${customer.registerTime}" readonly/>
                        </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">入金次数</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="depositInCount" name="depositInCount" type="text"
                                   class="form-control"
                                   value="${customer.depositInCount}" readonly/>
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">开户时间</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="openAccountTime" name="openAccountTime" type="text"
                                   class="form-control"
                                   value="<fmt:formatDate value="${customer.openAccountTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly/>
                        </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">出金次数</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="depositOutCount" name="depositOutCount" type="text"
                                   class="form-control"
                                   value="${customer.depositOutCount}" readonly/>
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">首次入金时间</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="firstIncomeTime" name="firstIncomeTime" type="text"
                                   class="form-control"
                                   value="${customer.firstIncomeTime}" readonly/>
                        </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">交易次数</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="tradeCount" name="tradeCount" type="text"
                                   class="form-control"
                                   value="${customer.tradeCount}" readonly/>
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">首次交易时间</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="firstTradeTime" name="firstTradeTime" type="text"
                                   class="form-control"
                                   value="${customer.firstTradeTime}" readonly/>
                        </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">打新次数</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="ipoCount" name="ipoCount" type="text"
                                   class="form-control"
                                   value="${customer.ipoCount}" readonly/>
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">最近入金时间</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="nearIncomeTime" name="nearIncomeTime" type="text"
                                   class="form-control"
                                   value="${customer.nearIncomeTime}" readonly/>
                        </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">净资产HKD</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="totalAssets" name="totalAssets" type="text"
                                   class="form-control"
                                   value="${customer.totalAssets}" readonly/>
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">最近交易时间</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="nearTradeTime" name="nearTradeTime" type="text"
                                   class="form-control"
                                   value="${customer.nearTradeTime}" readonly/>
                        </span>
                </div>
            </div>
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">最近出金时间</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="nearOutcomeTime" name="nearOutcomeTime" type="text"
                                   class="form-control"
                                   value="${customer.nearOutcomeTime}" readonly/>
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-6 col-md-6">
                <label class="col-sm-3 control-label no-padding-right">最近打新时间</label>
                <div class="col-xs-9">
                        <span class="col-xs-10 block input-icon input-icon-right">
                            <input id="nearHitTime" name="nearHitTime" type="text"
                                   class="form-control"
                                   value="${customer.nearIpoTime}" readonly/>
                        </span>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    layui.form.render('select');
</script>
</html>
