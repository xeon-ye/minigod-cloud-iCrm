<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>小神用户资料查询</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;">
        <shiro:hasPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post" action="${webRoot}/secUserInfo/userList">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:100px;">小神号:</label>
                                <div class="layui-input-inline">
                                    <input type="number" name="userId" value="${info.userId}" placeholder="请输入小神号"
                                           class="layui-input" oninput="if(value.length>5)value= value.slice(0,9)">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">注册手机号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="phoneNumber" value="${info.phoneNumber}"
                                           placeholder="请输入手机号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">渠道号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="sourceChannelId" value="${info.sourceChannelId}"
                                           placeholder="请输入渠道号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">渠道名称:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="channelName" name="sourceChannelName" class="form-control"
                                           style="cursor:pointer;" onclick="menuTree();" readonly="readonly"
                                           value="${info.sourceChannelName}" placeholder="请选择渠道"/>
                                    <input hidden type="text" id="checkedChannelId" name="checkedChannelId"
                                           value="${info.checkedChannelId}"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">注册来源:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="regSourceType" value="${info.regSourceType}"
                                           placeholder="请输入注册来源" class="layui-input">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:100px;">来源标识:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="regSource" value="${info.regSource}" placeholder="请输入来源标识"
                                           class="layui-input">
                                </div>
                            </td>

                            <td>
                                <label class="layui-form-label" style="width:120px;">注册开始时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="registerStartTime" name="registerStartTime"
                                           value="${info.registerStartTime}" placeholder="请选择注册开始时间"
                                           class="layui-input" onchange="checkRegisterDate()">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">注册结束时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="registerEndTime" name="registerEndTime"
                                           value="${info.registerEndTime}" placeholder="请选择注册结束时间"
                                           class="layui-input" onchange="checkRegisterDate()">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">最后活跃开始时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="lastLoginStartTime" name="lastLoginStartTime"
                                           value="${info.lastLoginStartTime}" placeholder="请选择最后活跃开始时间"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">最后活跃结束时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="lastLoginEndTime" name="lastLoginEndTime"
                                           value="${info.lastLoginEndTime}" placeholder="请选择最后活跃结束时间"
                                           class="layui-input">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:100px;">用户状态:</label>
                                <div class="layui-input-inline">
                                    <select name="userStatus">
                                        <option value="">-请选择-</option>
                                        <option
                                                <c:if test="${info.userStatus=='1'}">selected</c:if> value="1">已注册
                                        </option>
                                        <option
                                                <c:if test="${info.userStatus=='2'}">selected</c:if> value="2">已开户
                                        </option>
                                        <option
                                                <c:if test="${info.userStatus=='3'}">selected</c:if> value="3">开户中
                                        </option>
                                        <option
                                                <c:if test="${info.userStatus=='4'}">selected</c:if> value="4">已终止
                                        </option>
                                    </select>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:40px;"></label>
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                </button>&nbsp;
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>
                                &nbsp

                                <shiro:hasPermission name="securitiesUserInfo:userExp">
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
            <form class="layui-form" id="search-from" method="post" action="${webRoot}/secUserInfo/userList">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:130px;">小神号:</label>
                                <div class="layui-input-inline">
                                    <input type="number" name="userId" value="${info.userId}" placeholder="请输入小神号"
                                           class="layui-input" oninput="if(value.length>5)value= value.slice(0,9)">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">注册手机号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="phoneNumber" value="${info.phoneNumber}"
                                           placeholder="请输入手机号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">渠道号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="sourceChannelId" value="${info.sourceChannelId}"
                                           placeholder="请输入渠道号" class="layui-input">
                                </div>
                            </td>
                                <%--<td>--%>
                                <%--<label class="layui-form-label" style="width:150px;">渠道来源</label>--%>
                                <%--<div class="layui-input-inline">--%>
                                <%--<input type="text" id="channelName" name="sourceChannelName" class="form-control" style="cursor:pointer;" onclick="menuTree();" readonly="readonly" value="${info.sourceChannelName}" placeholder="请选择渠道"/>--%>
                                <%--<input hidden type="text" id="checkedChannelId" name="checkedChannelId" value="${info.checkedChannelId}"/>--%>
                                <%--</div>--%>
                                <%--</td>--%>
                            <td>
                                <label class="layui-form-label" style="width:150px;">注册来源:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="regSourceType" value="${info.regSourceType}"
                                           placeholder="请输入注册来源" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:100px;">来源标识:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="regSource" value="${info.regSource}" placeholder="请输入来源标识"
                                           class="layui-input">
                                </div>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:130px;">注册开始时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="registerStartTime" name="registerStartTime"
                                           value="${info.registerStartTime}" placeholder="请选择注册开始时间"
                                           class="layui-input" onchange="checkRegisterDate()">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">注册结束时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="registerEndTime" name="registerEndTime"
                                           value="${info.registerEndTime}" placeholder="请选择注册结束时间" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">最后活跃开始时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="lastLoginStartTime" name="lastLoginStartTime"
                                           value="${info.lastLoginStartTime}" placeholder="请选择最后活跃开始时间"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:150px;">最后活跃结束时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="lastLoginEndTime" name="lastLoginEndTime"
                                           value="${info.lastLoginEndTime}" placeholder="请选择最后活跃结束时间"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:100px;">用户状态:</label>
                                <div class="layui-input-inline">
                                    <select name="userStatus">
                                        <option value="">-请选择-</option>
                                        <option
                                                <c:if test="${info.userStatus=='1'}">selected</c:if> value="1">已注册
                                        </option>
                                        <option
                                                <c:if test="${info.userStatus=='2'}">selected</c:if> value="2">已开户
                                        </option>
                                        <option
                                                <c:if test="${info.userStatus=='3'}">selected</c:if> value="3">开户中
                                        </option>
                                        <option
                                                <c:if test="${info.userStatus=='4'}">selected</c:if> value="4">已终止
                                        </option>
                                    </select>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:40px;"></label>
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                </button>&nbsp;
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>
                                &nbsp

                                <shiro:hasPermission name="securitiesUserInfo:userExp">
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
                <tr width="99%" overflow:scroll>
                    <th hidden=true>userId</th>
                    <th>序号</th>
                    <th>注册时间</th>
                    <th>最后活跃时间</th>
                    <th>小神号</th>
                    <th>注册手机号码</th>
                    <th>注册来源</th>
                    <th>来源标识</th>
                    <th>渠道号</th>
                    <th>用户状态</th>
                    <th width="90px;">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${checkDate == false}">
                    <script type="text/javascript">alertMsg("请将查询范围限定在半年内");</script>
                </c:if>
                <c:forEach items="${page.result}" var="customer" varStatus="i">
                    <tr name="customer_${customer.userId }">
                        <td>${i.index+1 }</td>
                        <td>${customer.registerTime}</td>
                        <td>${customer.lastLoginTime}</td>
                        <td>${customer.userId}</td>
                        <td>${customer.phoneNumber}</td>
                        <td>${customer.regSourceType}</td>
                        <td>${customer.regSource}</td>
                        <td>${customer.sourceChannelId}</td>
                        <td>${customer.userStatus} </td>
                        <td>
                            <button class="layui-btn layui-btn-mini" type="button"
                                    onclick="doDetail('${customer.userId}')">
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
     * 导出excel
     */
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/secUserInfo/cusUserExpExcel?SecuritiesUserInfoEntity=&' + obj;
    }

    function alertCheck(){
        alertMsg("选择日期超出范围");
        alert("选择日期超出范围!!!");
    }

    <%--function doUpdate(userId) {--%>
    <%--var url = "${webRoot}/secUserInfo/userListInfo?userId=" + userId+"&getType=update";--%>
    <%--//弹框层--%>
    <%--layer.open({--%>
    <%--scrollbar: false,--%>
    <%--type: 2,--%>
    <%--title: ["客户详情", true],--%>
    <%--area: ['65%', '80%'], //宽高--%>
    <%--content: [url, 'yes'],--%>
    <%--shadeClose: false,--%>
    <%--});--%>
    <%--}--%>

    /**
     * 客户详情Tab
     */
    function doDetail(userId) {
        var url = "${webRoot}/secUserInfo/userListInfo?userId=" + userId;
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["用户详情", true],
//            area: ['65%', '80%'], //宽高
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
    }

    //时间选择器
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        var startTime = laydate.render({
            elem: '#registerStartTime',
            type: 'date',
            max: 'nowTime',//默认最大值为当前日期
            done: function (value, date) {
                endTime.config.min = {
                    year: date.year,
                    month: date.month - 1,//关键
                    date: date.date
                };
                endTime.config.max={
                    year:date.year,
                    month:date.month+5,
                    date:date.date
                };
            }
        });
        var endTime = laydate.render({
            elem: '#registerEndTime',
            type: 'date',
            max: 'nowTime',
            done: function (value, date) {
                startTime.config.min={
                    year:date.year,
                    month:date.month-7,
                    date:date.date
                };
                startTime.config.max = {
                    year: date.year,
                    month: date.month - 1,//关键
                    date: date.date
                };
            }
        });

        laydate.render({
            elem: '#lastLoginStartTime' //指定元素
        });
        laydate.render({
            elem: '#lastLoginEndTime' //指定元素
        });
    });

    layui.form.render('select');
</script>
<script src="${webRoot}/js/channel/channel.js"></script>
</html>