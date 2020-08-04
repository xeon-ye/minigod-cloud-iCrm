<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>客户综合查询</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;width: 101%" >
        <shiro:hasPermission name="channelBatch:qry">
        <form style="width: 101%" class="layui-form" id="search-from" method="post" action="${webRoot}/secUserInfo/synList">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td >
                            <label class="layui-form-label" style="width:120px;">小神号:</label>
                            <div class="layui-input-inline">
                                <input type="number" name="userId" value="${model.userId}" placeholder="请输入小神号" oninput="if(value.length>5)value=value.slice(0,9)"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 120px">客户姓名:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="clientName" value="${model.clientName}" placeholder="姓名"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 120px">证件类型:</label>
                            <div class="layui-input-inline">
                                <tag:select initSelectedKey="${model.idKind}" nameKey="AO_ID_KIND" name="idKind"
                                            isAddDefaltOption="true"></tag:select>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 120px">证件号:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="idNo" value="${model.idNo}" placeholder="请输入证件号"
                                       class="layui-input">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 120px">证券手机号:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="phoneNumber" value="${model.phoneNumber}" placeholder="请输入手机号"
                                       class="form-control">
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 120px">客户账号:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="tradeAccount" value="${model.tradeAccount}"
                                       placeholder="请输入客户账号" class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 120px">注册来源:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="regSourceType" value="${model.regSourceType}"
                                       placeholder="请输入注册来源" class="form-control">
                            </div>
                        </td>

                        <td>
                            <label class="layui-form-label" style="width: 120px">渠道号:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="sourceChannelId" value="${model.sourceChannelId}"
                                       placeholder="请输入渠道号"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:120px;">渠道:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="channelName" name="sourceChannelName" class="form-control" style="cursor:pointer;" onclick="menuTree();" readonly="readonly" value="${model.sourceChannelName}" placeholder="请选择渠道"/>
                                <input hidden type="text" id="checkedChannelId" name="checkedChannelId" value="${model.checkedChannelId}"/>
                            </div>
                        </td>

                        <td>
                            <label class="layui-form-label" style="width: 120px">全年收入:</label>
                            <div class="layui-input-inline">
                                <tag:select nameKey="AO_INCOME" id="annualIncome" name="annualIncome" isAddDefaltOption="true"
                                            initSelectedKey="${model.annualIncome}"
                                            clazz="form-control"/>
                            </div>
                        </td>
                    </tr>
                    <%--<tr>--%>
                        <%--<td>--%>
                            <%--<label class="layui-form-label" style="width: 120px">净资产:</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<tag:select nameKey="SEC_TOTALASSETS" id="totalAssets" name="totalAssets" isAddDefaltOption="true"--%>
                                            <%--initSelectedKey="${model.totalAssets}"--%>
                                            <%--clazz="form-control"/>--%>
                            <%--</div>--%>
                        <%--</td>--%>

                        <%--<td>--%>
                            <%--<label class="layui-form-label" style="width: 120px">入金次数:</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<tag:select nameKey="SEC_COUNTS"  name="depositInCount" isAddDefaltOption="true"--%>
                                            <%--initSelectedKey="${model.depositInCount}"--%>
                                            <%--clazz="form-control"/>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<label class="layui-form-label" style="width: 120px">出金次数:</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<tag:select nameKey="SEC_COUNTS" name="depositOutCount" isAddDefaltOption="true"--%>
                                            <%--initSelectedKey="${model.depositOutCount}"--%>
                                            <%--clazz="form-control"/>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<label class="layui-form-label" style="width: 120px">交易次数:</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<tag:select nameKey="SEC_COUNTS" name="tradeCount" isAddDefaltOption="true"--%>
                                            <%--initSelectedKey="${model.tradeCount}"--%>
                                            <%--clazz="form-control"/>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<label class="layui-form-label" style="width: 120px">打新次数:</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<tag:select nameKey="SEC_COUNTS" name="ipoCount" isAddDefaltOption="true"--%>
                                            <%--initSelectedKey="${model.ipoCount}"--%>
                                            <%--clazz="form-control"/>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td>--%>
                            <%--<label class="layui-form-label" style="width: 120px">开户开始时间:</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<input type="text" id="openAccountStartTime" name="openAccountStartTime"--%>
                                       <%--value="${model.openAccountStartTime}" placeholder="请选择开户开始时间"--%>
                                       <%--class="form-control">--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<label class="layui-form-label" style="width: 120px">开户结束时间:</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<input type="text" id="openAccountEndTime" name="openAccountEndTime"--%>
                                       <%--value="${model.openAccountEndTime}" placeholder="请选择开户结束时间"--%>
                                       <%--class="form-control">--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<label class="layui-form-label" style="width: 120px">开户途径:</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<tag:select nameKey="AO_OPEN_ACCOUNT_TYPE" name="openAccountType" isAddDefaltOption="true"--%>
                                            <%--initSelectedKey="${model.openAccountType}"--%>
                                            <%--clazz="form-control"/>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<label class="layui-form-label" style="width: 120px">邀请人:</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<input type="text" name="inviterId"--%>
                                       <%--value="${model.inviterId}" placeholder="请输入邀请人"--%>
                                       <%--class="form-control">--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<label class="layui-form-label" style="width:120px;">客户状态:</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<tag:select initSelectedKey="${model.clientStatus}" nameKey="SEC_CLIENT_STATUS"--%>
                                            <%--name="clientStatus" isAddDefaltOption="true"></tag:select>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:120px;">客户状态:</label>
                            <div class="layui-input-inline">
                                <tag:select initSelectedKey="${model.clientStatus}" nameKey="SEC_CLIENT_STATUS"
                                            name="clientStatus" isAddDefaltOption="true"></tag:select>
                            </div>
                        </td>
                        <td style="align-items: center">
                            <label class="layui-form-label" style="width: 50px"></label>
                            <div class="layui-input-inline" >
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜索</button>
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh">&nbsp;&nbsp;&nbsp;重 置&nbsp;&nbsp;</button>
                            </div>
                            <shiro:hasPermission name="securitiesUserInfo:synExp">
                                <button class="layui-btn layui-btn-danger" type="button" id="export"
                                        onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                </button>
                            </shiro:hasPermission>
                        </td>
                    </tr>
                   
                </table>
            </div>
        </form>
        </shiro:hasPermission>

        <shiro:lacksPermission name="channelBatch:qry">
            <form style="width: 101%" class="layui-form" id="search-from" method="post" action="${webRoot}/secUserInfo/synList">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td >
                                <label class="layui-form-label" style="width:120px;">小神号:</label>
                                <div class="layui-input-inline">
                                    <input type="number" name="userId" value="${model.userId}" placeholder="请输入小神号" oninput="if(value.length>5)value=value.slice(0,9)"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">客户姓名:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="clientName" value="${model.clientName}" placeholder="姓名"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">证件类型:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${model.idKind}" nameKey="AO_ID_KIND" name="idKind"
                                                isAddDefaltOption="true"></tag:select>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">证件号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="idNo" value="${model.idNo}" placeholder="请输入证件号"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">证券手机号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="phoneNumber" value="${model.phoneNumber}" placeholder="请输入手机号"
                                           class="form-control">
                                </div>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 120px">客户账号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="tradeAccount" value="${model.tradeAccount}"
                                           placeholder="请输入客户账号" class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">注册来源:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="regSourceType" value="${model.regSourceType}"
                                           placeholder="请输入注册来源" class="form-control">
                                </div>
                            </td>

                            <td>
                                <label class="layui-form-label" style="width: 120px">渠道号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="sourceChannelId" value="${model.sourceChannelId}"
                                           placeholder="请输入渠道号"
                                           class="form-control">
                                </div>
                            </td>
                            <%--<td>--%>
                                <%--<label class="layui-form-label" style="width:120px;">渠道:</label>--%>
                                <%--<div class="layui-input-inline">--%>
                                    <%--<input type="text" id="channelName" name="sourceChannelName" class="form-control" style="cursor:pointer;" onclick="menuTree();" readonly="readonly" value="${model.sourceChannelName}" placeholder="请选择渠道"/>--%>
                                    <%--<input hidden type="text" id="checkedChannelId" name="checkedChannelId" value="${model.checkedChannelId}"/>--%>
                                <%--</div>--%>
                            <%--</td>--%>

                            <td>
                                <label class="layui-form-label" style="width: 120px">全年收入:</label>
                                <div class="layui-input-inline">
                                    <tag:select nameKey="AO_INCOME" id="annualIncome" name="annualIncome" isAddDefaltOption="true"
                                                initSelectedKey="${model.annualIncome}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 120px">净资产:</label>
                                <div class="layui-input-inline">
                                    <tag:select nameKey="SEC_TOTALASSETS" id="totalAssets" name="totalAssets" isAddDefaltOption="true"
                                                initSelectedKey="${model.totalAssets}"
                                                clazz="form-control"/>
                                </div>
                            </td>

                            <td>
                                <label class="layui-form-label" style="width: 120px">入金次数:</label>
                                <div class="layui-input-inline">
                                    <tag:select nameKey="SEC_COUNTS"  name="depositInCount" isAddDefaltOption="true"
                                                initSelectedKey="${model.depositInCount}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">出金次数:</label>
                                <div class="layui-input-inline">
                                    <tag:select nameKey="SEC_COUNTS" name="depositOutCount" isAddDefaltOption="true"
                                                initSelectedKey="${model.depositOutCount}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">交易次数:</label>
                                <div class="layui-input-inline">
                                    <tag:select nameKey="SEC_COUNTS" name="tradeCount" isAddDefaltOption="true"
                                                initSelectedKey="${model.tradeCount}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">打新次数:</label>
                                <div class="layui-input-inline">
                                    <tag:select nameKey="SEC_COUNTS" name="ipoCount" isAddDefaltOption="true"
                                                initSelectedKey="${model.ipoCount}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 120px">开户开始时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="openAccountStartTime" name="openAccountStartTime"
                                           value="${model.openAccountStartTime}" placeholder="请选择开户开始时间"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">开户结束时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="openAccountEndTime" name="openAccountEndTime"
                                           value="${model.openAccountEndTime}" placeholder="请选择开户结束时间"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">开户途径:</label>
                                <div class="layui-input-inline">
                                    <tag:select nameKey="AO_OPEN_ACCOUNT_TYPE" name="openAccountType" isAddDefaltOption="true"
                                                initSelectedKey="${model.openAccountType}"
                                                clazz="form-control"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">邀请人:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="inviterId"
                                           value="${model.inviterId}" placeholder="请输入邀请人"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">客户状态:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${model.clientStatus}" nameKey="SEC_CLIENT_STATUS"
                                                name="clientStatus" isAddDefaltOption="true"></tag:select>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="align-items: center">
                                <label class="layui-form-label" style="width: 50px"></label>
                                <div class="layui-input-inline" >
                                    <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜索</button>
                                    <button class="layui-btn layui-btn-warm" type="button" id="refresh">&nbsp;&nbsp;&nbsp;重 置&nbsp;&nbsp;</button>
                                </div>
                                <shiro:hasPermission name="securitiesUserInfo:synExp">
                                    <button class="layui-btn layui-btn-danger" type="button" id="export"
                                            onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                    </button>
                                </shiro:hasPermission>
                            </td>
                        </tr>

                    </table>
                </div>
            </form>
        </shiro:lacksPermission>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <table id="table-list" class="layui-table">
                <thead>
                <tr width="99%">
                    <th>序号</th>
                    <th hidden=true>id</th>
                    <th>开户日期</th>
                    <th>小神号</th>
                    <th>客户姓名</th>
                    <th>客户账号</th>
                    <th>客户状态</th>
                    <th>证券手机号</th>
                    <th>注册来源</th>
                    <th>渠道号</th>
                    <th>全年收入</th>
                    <th>入金次数</th>
                    <th>出金次数</th>
                    <th>净资产HKD</th>
                    <th>交易次数</th>
                    <th>打新次数</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="customer" varStatus="i">
                    <tr name="customer_${customer.id }">
                        <td>${i.index+1 }</td>
                        <td hidden=" true">${customer.id}</td>
                        <td><fmt:formatDate value="${customer.openAccountTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${customer.userId}</td>
                        <td>${customer.clientName}</td>
                        <td>${customer.tradeAccount}</td>
                        <td>${fns:getCodeName("SEC_CLIENT_STATUS",customer.clientStatus)}</td>
                        <c:if test="${shield==false}">
                            <td>${customer.phoneNumber}</td>
                        </c:if>
                        <c:if test="${shield==true}">
                            <td>***********</td>
                        </c:if>
                        <td>${customer.regSourceType}</td>
                        <td>${customer.sourceChannelId}</td>
                        <td>${fns:getCodeName("AO_INCOME",customer.annualIncome)}</td>
                        <td>${customer.depositInCount}</td>
                        <td>${customer.depositOutCount}</td>
                        <td>${customer.totalAssets}</td>
                        <td>${customer.tradeCount}</td>
                        <td>${customer.ipoCount}</td>
                        <td width="50px">
                            <button class="layui-btn layui-btn-mini" type="button"
                                    onclick="doDetail('${customer.id}')">
                                <i class="layui-icon">&#xe60a;</i>查看
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
<!-- 选择渠道 -->
<div id="menuLayer" style="display: none;padding:10px;">
    <ul id="menuTree" class="ztree"></ul>
</div>
</body>

<script>
    /**
     * 客户详情Tab
     */
    function doDetail(id) {
        var url = "${webRoot}/secUserInfo/customerSynInfo?id=" + id;
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["客户综合信息详情", true],
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
    }


    layui.laydate.render({
        elem: '#openAccountStartTime' //指定元素
    });
    layui.laydate.render({
        elem: '#registerStartTime' //指定元素
    });
    layui.laydate.render({
        elem: '#openAccountEndTime' //指定元素
    });
    layui.laydate.render({
        elem: '#registerEndTime' //指定元素
    });

    /**
     * 导出excel
     */
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
//        layer.alert(obj);
         window.location.href = '${webRoot}/secUserInfo/cusSynExpExcel?SecuritiesUserInfoEntity=&' + obj;
    }
    layui.form.render('select');
</script>
<script src="${webRoot}/js/channel/channel.js"></script>

</html>