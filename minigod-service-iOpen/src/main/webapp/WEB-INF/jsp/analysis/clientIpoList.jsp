<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>打新查询</title>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <shiro:hasPermission name="channelBatch:qry">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/clientIpo/list">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:100px">小神号:</label>
                            <div class="col-xs-8">
                                <input type="text" name="userId" value="${model.userId}" placeholder="请输入小神号"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">客户姓名:</label>
                            <div class="col-xs-8">
                                <input type="text" name="clientName" value="${model.clientName}" placeholder="请输入客户姓名"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">交易帐号:</label>
                            <div class="col-xs-8">
                                <input type="text" name="clientId" value="${model.clientId}" placeholder="请输入交易帐号"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">资金帐号:</label>
                            <div class="col-xs-8">
                                <input type="text" name="fundAccount" value="${model.fundAccount}"
                                       placeholder="请输入资金帐号"
                                       class="form-control">
                            </div>
                        </td>

                        <td>
                            <label class="layui-form-label" style="width: 100px">证券代码:</label>
                            <div class="col-xs-8">
                                <input type="text" name="stockCode" value="${model.stockCode}" placeholder="请输入证券代码"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 100px">渠道号:</label>
                            <div class="col-xs-8">
                                <input type="text" name="channelId" value="${model.channelId}"
                                       placeholder="请输入渠道号"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                        <label class="layui-form-label" style="width: 100px">渠道名称:</label>
                        <div class="col-xs-8">
                        <input type="text" id="channelName" name="channelName" class="form-control" style="cursor:pointer;" onclick="menuTree();" readonly="readonly" value="${model.channelName}" placeholder="请选择渠道"/>
                        </div>
                        </td>
                        <input hidden type="text" id="checkedChannelId" name="checkedChannelId" value="${model.checkedChannelId}"/>
                        <td>
                        <label class="layui-form-label" style="width: 100px">认购状态:</label>
                        <div class="col-xs-8">
                        <tag:select nameKey="SEC_CURR_STATUS" name="status" id="status" initSelectedKey="${model.status}" isAddDefaltOption="true"></tag:select>
                        </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">申请状态:</label>
                            <div class="col-xs-8">
                                <tag:select nameKey="SEC_STATUS_CHECK" name="statusCheck" id="statusCheck"
                                            initSelectedKey="${model.statusCheck}"
                                            isAddDefaltOption="true"></tag:select>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">认购方式:</label>
                            <div class="col-xs-8">
                                <tag:select nameKey="SEC_CURR_TYPE" name="type" id="type"
                                            initSelectedKey="${model.type}" isAddDefaltOption="true"></tag:select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 100px">中签数量:</label>
                            <div class="col-xs-8">
                                <input type="number" name="quantityAllotted" value="${model.quantityAllotted}"
                                       placeholder="请输入中签数量"
                                       class="form-control">
                            </div>
                        </td>

                        <td>
                            <label class="layui-form-label" style="width: 100px">上市日期:</label>
                            <div class="col-xs-8">
                                <input type="text" id="tradingDate" name="tradingDate" value="${model.tradingDate}"
                                       class="form-control">
                            </div>
                        </td>

                        <td>
                            <label class="layui-form-label" style="width: 100px">开始日期:</label>
                            <div class="col-xs-8">
                                <input type="text" id="beginDate" name="beginDate" value="${model.beginDate}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">结束日期:</label>
                            <div class="col-xs-8">
                                <input type="text" id="endDate" name="endDate" value="${model.endDate}"
                                       class="form-control">
                            </div>
                        </td>

                        <td>&nbsp;&nbsp;&nbsp;
                            <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                            <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i class="layui-icon">&#x1002;</i>重
                                置
                            </button>
                            <shiro:hasPermission name="clientIpo:exp">
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
            <form class="layui-form" id="search-from" method="post"
                  action="${webRoot}/clientIpo/list">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:100px">小神号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="userId" value="${model.userId}" placeholder="请输入小神号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">客户姓名:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="clientName" value="${model.clientName}" placeholder="请输入客户姓名"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">交易帐号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="clientId" value="${model.clientId}" placeholder="请输入交易帐号"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">资金帐号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="fundAccount" value="${model.fundAccount}"
                                           placeholder="请输入资金帐号"
                                           class="form-control">
                                </div>
                            </td>

                            <td>
                                <label class="layui-form-label" style="width: 100px">证券代码:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="stockCode" value="${model.stockCode}" placeholder="请输入证券代码"
                                           class="form-control">
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 100px">渠道号:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="channelId" value="${model.channelId}"
                                           placeholder="请输入渠道号"
                                           class="form-control">
                                </div>
                            </td>
                                <%--<td>--%>
                                <%--<label class="layui-form-label" style="width: 100px">渠道名称:</label>--%>
                                <%--<div class="col-xs-8">--%>
                                <%--<input type="text" id="channelName" name="channelName" class="form-control" style="cursor:pointer;" onclick="menuTree();" readonly="readonly" value="${model.channelName}" placeholder="请选择渠道"/>--%>
                                <%--</div>--%>
                                <%--</td>--%>
                                <%--<input hidden type="text" id="checkedChannelId" name="checkedChannelId" value="${model.checkedChannelId}"/>--%>
                                <%--<td>--%>
                                <%--<label class="layui-form-label" style="width: 100px">认购状态:</label>--%>
                                <%--<div class="col-xs-8">--%>
                                <%--<tag:select nameKey="SEC_CURR_STATUS" name="status" id="status" initSelectedKey="${model.status}" isAddDefaltOption="true"></tag:select>--%>
                                <%--</div>--%>
                                <%--</td>--%>
                            <td>
                                <label class="layui-form-label" style="width: 100px">申请状态:</label>
                                <div class="col-xs-8">
                                    <tag:select nameKey="SEC_STATUS_CHECK" name="statusCheck" id="statusCheck"
                                                initSelectedKey="${model.statusCheck}"
                                                isAddDefaltOption="true"></tag:select>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">认购方式:</label>
                                <div class="col-xs-8">
                                    <tag:select nameKey="SEC_CURR_TYPE" name="type" id="type"
                                                initSelectedKey="${model.type}" isAddDefaltOption="true"></tag:select>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">中签数量:</label>
                                <div class="col-xs-8">
                                    <input type="number" name="quantityAllotted" value="${model.quantityAllotted}"
                                           placeholder="请输入中签数量"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">上市日期:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="tradingDate" name="tradingDate" value="${model.tradingDate}"
                                           class="form-control">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 100px">开始日期:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="beginDate" name="beginDate" value="${model.beginDate}"
                                           class="form-control">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 100px">结束日期:</label>
                                <div class="col-xs-8">
                                    <input type="text" id="endDate" name="endDate" value="${model.endDate}"
                                           class="form-control">
                                </div>
                            </td>

                            <td>&nbsp;&nbsp;&nbsp;
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i class="layui-icon">&#x1002;</i>重
                                    置
                                </button>
                                <shiro:hasPermission name="clientIpo:exp">
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
        <div class="col-xs-12" style="width:99%">
            <table id="tableList" lay-filter="table_list" class="layui-table">
                <thead>
                <tr width="99%">
                    <th lay-data="{field:'index',fixed:'left',width:60}">序号</th>
                    <th lay-data="{field:'id',hide:true}" hidden="true">id</th>
                    <th lay-data="{field:'userId'}">小神号</th>
                    <th lay-data="{field:'clientName'}">客户姓名</th>
                    <th lay-data="{field:'phoneNumber'}">手机号码</th>
                    <th lay-data="{field:'clientId'}">交易帐号</th>
                    <th lay-data="{field:'fundAccount'}">资金帐号</th>
                    <th lay-data="{field:'channelId'}">渠道</th>
                    <th lay-data="{field:'currDate'}">认购日期</th>
                    <th lay-data="{field:'stockCode'}">证券代码</th>
                    <th lay-data="{field:'exchangeType'}">证券市场</th>
                    <th lay-data="{field:'type'}">认购方式</th>
                    <th lay-data="{field:'status'}">申购状态</th>
                    <th lay-data="{field:'quantityApply'}">申购数量</th>
                    <th lay-data="{field:'applyAmount'}">总申购金额</th>
                    <th lay-data="{field:'depositRate'}">申购资金比例</th>
                    <th lay-data="{field:'depositAmount'}">客户申购资金</th>
                    <th lay-data="{field:'ipoIntrate'}">IPO利率</th>
                    <th lay-data="{field:'quantityAllotted'}">中签数量</th>
                    <th lay-data="{field:'finalAmount'}">中签金额</th>
                    <th lay-data="{field:'handlingFee'}">手续费</th>
                    <th lay-data="{field:'financingAmount'}">融资利息</th>
                    <th lay-data="{field:'cutoffDate'}">截至日期</th>
                    <th lay-data="{field:'tradingDate'}">上市日期</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr name="info_${info.id}">
                        <td>${i.index+1}</td>
                        <td hidden=" true">${info.id}</td>
                        <td>${info.userId}</td>
                        <td>${info.clientName}</td>
                        <c:if test="${shield==false}">
                            <td>${info.phoneNumber}</td>
                        </c:if>
                        <c:if test="${shield==true}">
                            <td>******</td>
                        </c:if>
                        <td>${info.clientId} </td>
                        <td>${info.fundAccount}</td>
                        <td>${info.channelId}</td>
                        <td>${info.currDate}</td>
                        <td>${info.stockCode}</td>
                        <td>${fns:getCodeName('SEC_EXCHANGE_TYPE',info.exchangeType)}</td>
                        <td>${fns:getCodeName('SEC_CURR_TYPE',info.type)}</td>
                        <td>${fns:getCodeName('SEC_CURR_STATUS',info.status)}</td>
                        <td>${info.quantityApply}</td>
                        <td>${info.applyAmount}</td>
                        <td>${info.depositRate}</td>
                        <td>${info.depositAmount}</td>
                        <td>${info.ipoIntrate}</td>
                        <td>${info.quantityAllotted}</td>
                        <td>${info.finalAmount}</td>
                        <td>${info.handlingFee}</td>
                        <td>${info.financingAmount}</td>
                        <td>${info.cutoffDate}</td>
                        <td>${info.tradingDate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
<!-- 选择菜单 -->
<div id="menuLayer" style="display: none;padding:10px;">
    <ul id="menuTree" class="ztree"></ul>
</div>
</body>

<script>

    layui.laydate.render({
        elem: '#beginDate' //指定元素
    });
    layui.laydate.render({
        elem: '#endDate' //指定元素
    });
    layui.laydate.render({
        elem: '#tradingDate' //指定元素
    });

    $(function () {
        layui.use('table', function () {
            var table = layui.table;

            table.init('table_list', { //转化静态表格
                cellMinWidth: 120,
                limit:${page.pageSize}
                , text: {
                    none: '暂无相关数据' //默认：无数据
                }
            });
        });
    });

    //    $(function () {
    //        DatetimeInit();
    //    });

    // 设置日期时间控件
    function DatetimeInit() {
        $('#datetimepicker1').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            initialDate: new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            locale: moment.locale('zh-cn')
        });
        $('#datetimepicker2').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            initialDate: new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            locale: moment.locale('zh-cn')
        });
        // 初始化交易查询开始日期和结束日期
        var date = new Date();
        date.setDate(date.getDate() - 1);
        var beginNowDateStr = (date.getFullYear()) + "-" + (date.getMonth() + 1) + "-" + date.getDate();
        //对日期格式进行处理
        var beginNowDate = new Date(beginNowDateStr);
        var beginMon = date.getMonth() + 1;
        var BeginDay = date.getDate();
        var beginDate = beginNowDate.getFullYear() + "-" + (beginMon < 10 ? "0" + beginMon : beginMon) + "-" + (BeginDay < 10 ? "0" + BeginDay : BeginDay);
    }

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/clientIpo/export?clientIpoEntity=&' + obj;
    }

    $("#refresh").click(function () {
        window.location.reload();
    })

    layui.form.render('select');
</script>


<script src="${webRoot}/js/channel/channel.js"></script>
</html>