<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <title>客户基本查询</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<style>
    #table-list td {
        white-space: nowrap;
    }

    #table-list th {
        white-space: nowrap;
    }
</style>
<body>
<div class="main-container" id="main-container">
    <div class="row">
        <shiro:hasPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post" action="${webRoot}/secUserInfo/customerList">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">小神号:</label>
                                <div class="layui-input-inline">
                                    <input type="number" name="userId" value="${model.userId}" placeholder="请输入小神号"
                                           class="layui-input" oninput="if(value.length>5)value= value.slice(0,9)">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">中文姓名:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="clientName" value="${model.clientName}"
                                           placeholder="请输入中文姓名" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">英文名称:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="clientNameSpell" value="${model.clientNameSpell}"
                                           placeholder="请输入英文名称" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">证券手机号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="phoneNumber" value="${model.phoneNumber}"
                                           placeholder="请输入证券手机号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">邀请人:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="inviterId" value="${model.inviterId}"
                                           placeholder="请输入邀请人"
                                           class="layui-input">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">证件类型:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${model.idKind}" nameKey="AO_ID_KIND" name="idKind"
                                                isAddDefaltOption="true"></tag:select>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">证件号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="idNo" value="${model.idNo}" placeholder="请输入证件号"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px">客户帐号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="tradeAccount" value="${model.tradeAccount}"
                                           placeholder="请输入客户帐号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px">资金帐号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="fundAccount" value="${model.fundAccount}"
                                           placeholder="请输入资金帐号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">开户途径:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${model.openAccountType}"
                                                nameKey="AO_OPEN_ACCOUNT_TYPE"
                                                name="openAccountType" isAddDefaltOption="true"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">渠道号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="sourceChannelId" value="${model.sourceChannelId}"
                                           placeholder="请输入渠道号"
                                           class="layui-input">
                                </div>
                            </td>

                            <td>
                                <label class="layui-form-label" style="width: 120px">渠道名称:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="channelName" name="sourceChannelName" class="form-control"
                                           style="cursor:pointer;" onclick="menuTree();" readonly="readonly"
                                           value="${model.sourceChannelName}" placeholder="请选择渠道"/>
                                </div>
                                <input hidden type="text" id="checkedChannelId" name="checkedChannelId"
                                       value="${model.checkedChannelId}"/>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">账户状态:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${model.clientStatus}" nameKey="SEC_CLIENT_STATUS"
                                                name="clientStatus" isAddDefaltOption="true"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px;">开户开始时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="openAccountStartTime" name="openAccountStartTime"
                                           value="${model.openAccountStartTime}" placeholder="请选择开户开始时间"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px;">开户结束时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="openAccountEndTime" name="openAccountEndTime"
                                           value="${model.openAccountEndTime}" placeholder="请选择开户结束时间"
                                           class="layui-input">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 120px;">预约号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="applicationId" value="${model.applicationId}"
                                           placeholder="请输入预约号"
                                           class="layui-input">
                                </div>
                            </td>

                            <td>
                                <label class="layui-form-label" style="width:120px;">客户级别:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${model.roomCode}" nameKey="SEC_CLIENT_LEVEL"
                                                name="roomCode" isAddDefaltOption="true"/>
                                </div>
                            </td>

                            <td>
                                <div class="col-xs-12">
                                    <button class="layui-btn " id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                    </button>
                                    <button class="layui-btn layui-btn-warm " type="button" id="refresh">重 置</button>
                                    <shiro:hasPermission name="securitiesUserInfo:exp">
                                        <button class="layui-btn layui-btn-danger" type="button" id="export"
                                                onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                        </button>
                                    </shiro:hasPermission>
                                </div>
                                <div class="col-xs-2"></div>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </shiro:hasPermission>

        <shiro:lacksPermission name="channelBatch:qry">
            <form class="layui-form" id="search-from" method="post" action="${webRoot}/secUserInfo/customerList">
                <div class="layui-form-item">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">小神号:</label>
                                <div class="layui-input-inline">
                                    <input type="number" name="userId" value="${model.userId}" placeholder="请输入小神号"
                                           class="layui-input" oninput="if(value.length>5)value= value.slice(0,9)">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">中文姓名:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="clientName" value="${model.clientName}"
                                           placeholder="请输入中文姓名" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">英文名称:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="clientNameSpell" value="${model.clientNameSpell}"
                                           placeholder="请输入英文名称" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">证券手机号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="phoneNumber" value="${model.phoneNumber}"
                                           placeholder="请输入证券手机号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">邀请人:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="inviterId" value="${model.inviterId}"
                                           placeholder="请输入邀请人"
                                           class="layui-input">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">证件类型:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${model.idKind}" nameKey="AO_ID_KIND" name="idKind"
                                                isAddDefaltOption="true"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">证件号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="idNo" value="${model.idNo}" placeholder="请输入证件号"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px">客户帐号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="tradeAccount" value="${model.tradeAccount}"
                                           placeholder="请输入客户帐号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px">资金帐号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="fundAccount" value="${model.fundAccount}"
                                           placeholder="请输入资金帐号" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">开户途径:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${model.openAccountType}"
                                                nameKey="AO_OPEN_ACCOUNT_TYPE"
                                                name="openAccountType" isAddDefaltOption="true"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">渠道号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="sourceChannelId" value="${model.sourceChannelId}"
                                           placeholder="请输入渠道号"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px">渠道名称:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="channelName" name="sourceChannelName" class="form-control"
                                           style="cursor:pointer;" onclick="menuTree();" readonly="readonly"
                                           value="${model.sourceChannelName}" placeholder="请选择渠道"/>
                                </div>
                                <input hidden type="text" id="checkedChannelId" name="checkedChannelId"
                                       value="${model.checkedChannelId}"/>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">客户状态:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${model.clientStatus}" nameKey="SEC_CLIENT_STATUS"
                                                name="clientStatus" isAddDefaltOption="true"/>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px;">开户开始时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="openAccountStartTime" name="openAccountStartTime"
                                           value="${model.openAccountStartTime}" placeholder="请选择开户开始时间"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px;">开户结束时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="openAccountEndTime" name="openAccountEndTime"
                                           value="${model.openAccountEndTime}" placeholder="请选择开户结束时间"
                                           class="layui-input">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width: 120px;">预约号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="applicationId" value="${model.applicationId}"
                                           placeholder="请输入预约号"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">客户级别:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${model.roomCode}" nameKey="SEC_CLIENT_LEVEL"
                                                name="roomCode" isAddDefaltOption="true"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="col-xs-12">
                                    <button class="layui-btn " id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                    </button>
                                    <button class="layui-btn layui-btn-warm " type="button" id="refresh">重 置</button>
                                    <shiro:hasPermission name="securitiesUserInfo:exp">
                                        <button class="layui-btn layui-btn-danger" type="button" id="export"
                                                onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                        </button>
                                    </shiro:hasPermission>
                                </div>
                                <div class="col-xs-2"></div>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </shiro:lacksPermission>
    </div>
    <table id="tableList" lay-filter="table_list" class="layui-table">
        <thead>
        <tr width="99%">
            <th lay-data="{field:'id',hide:true}" hidden="true">id</th>
            <th lay-data="{field:'num',width:'60',fixed:'left'}">序号</th>
            <th lay-data="{field:'applicationId',minWidth:'170'}">预约号</th>
            <th lay-data="{field:'openAccountTime',minWidth:'160'}">开户日期</th>
            <th lay-data="{field:'openAccountType'}">开户途径</th>
            <th lay-data="{field:'userId'}">小神号</th>
            <th lay-data="{field:'tradeAccount',minWidth:'120'}">客户账号</th>
            <th lay-data="{field:'fundAccount',minWidth:'120'}">资金帐号</th>
            <th lay-data="{field:'clientStatus'}">账户状态</th>
            <th lay-data="{field:'roomCode'}">客户级别</th>
            <th lay-data="{field:'clientName'}">中文姓名</th>
            <th lay-data="{field:'clientNameSpell'}">英文姓名</th>
            <th lay-data="{field:'idKind',minWidth:'200'}">证件类型</th>
            <th lay-data="{field:'idNo',minWidth:'180'}">证件号</th>
            <th lay-data="{field:'phoneNumber',minWidth:'130'}">证券手机号码</th>
            <th lay-data="{field:'sourceChannelId'}">渠道号</th>
            <th lay-data="{field:'inviterId'}">邀请人</th>
            <th lay-data="{field:'options',align:'center',fixed: 'right'}">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="customer" varStatus="i">
            <tr name="customer_${customer.id }">
                    <%--<td hidden><input name="selectFlag" type="checkbox" value="${customer.id}"/></td>--%>
                <td hidden=" true">${customer.id}</td>
                <td>${i.index+1 }</td>
                <td>${customer.applicationId}</td>
                <td><fmt:formatDate value="${customer.openAccountTime}"
                                    pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <c:if test="${customer.openAccountType == 0}">未知</a></c:if>
                    <c:if test="${customer.openAccountType == 1 && (model.openAccountType ==null || model.openAccountType ==1)}">互联网开户</a></c:if>
                    <c:if test="${customer.openAccountType == 1 && customer.bankType == 0 && model.openAccountType == 4}">香港银行卡</a></c:if>
                    <c:if test="${customer.openAccountType == 1 && customer.bankType == 1 && model.openAccountType == 5}">大陆银行卡</a></c:if>
                    <c:if test="${customer.openAccountType == 1 && customer.bankType == 1 && model.openAccountType == 6}">SZCA电子证书</a></c:if>
                    <c:if test="${customer.openAccountType == 2}">线下开户</a></c:if>
                    <c:if test="${customer.openAccountType == 3}">BPM</a></c:if>
                </td>
                <td>${customer.userId}</td>
                <td>${customer.tradeAccount}</td>
                <td>${customer.fundAccount}</td>
                <td>${fns:getCodeName("SEC_CLIENT_STATUS",customer.clientStatus)}</td>
                <td>${fns:getCodeName("SEC_CLIENT_LEVEL",customer.roomCode)}</td>
                <td>${customer.clientName}</td>
                <td>${customer.clientNameSpell}</td>
                <td>${fns:getCodeName("AO_ID_KIND",customer.idKind)}</td>

                <c:if test="${shield==false}">
                    <td>${customer.idNo}</td>
                    <td>${customer.phoneNumber}</td>
                </c:if>
                <c:if test="${shield==true}">
                    <td>**************</td>
                    <td>******</td>
                </c:if>
                <td>${customer.sourceChannelId}</td>
                <td>${customer.inviterId}</td>
                <td>
                    <button class="layui-btn layui-btn-mini" type="button"
                            onclick="doDetail('${customer.id}')">
                        <i class="layui-icon">&#xe60a;</i>查看
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" id="add" onclick="addCustomer();" class="layui-btn layui-btn-small"><i
            class="layui-icon">&#xe654;</i>新增
    </button>
    <button type="button" id="modify" onclick="updateCustomer();" class="layui-btn  layui-btn-small"><i
            class="layui-icon">&#xe642;</i>修改
    </button>
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

    $("#add").hide();
    $("#modify").hide();

    $(function () {
        layui.use('table', function () {
            var table = layui.table;
            table.init('table_list', { //转化静态表格
                cellMinWidth: 100,
                limit:${page.pageSize}
                , text: {
                    none: '暂无相关数据' //默认：无数据
                }
            });
        });
    });

    //添加
    function addCustomer() {
        var url = "${webRoot}/secUserInfo/addCustomerInit";
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["客户详情", true],
            area: ['90%', '90%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
        });
    }


    /**
     * 修改
     */
    function updateCustomer() {
        var ids = document.getElementsByName("selectFlag");
        var count = 0;
        var id = "";
        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                ++count;
                id = ids[i].value;
            }
        }
        if (count < 1) {
            alert("请选择行！");
            return;
        } else if (count > 1) {
            alert("只能选择一行！");
        } else {
            var url = "${webRoot}/secUserInfo/updateCustomerInit?gid=" + id;
            //弹框层
            layer.open({
                scrollbar: false,
                type: 2,
                title: ["客户详情", true],
                area: ['90%', '90%'], //宽高
                content: [url, 'yes'],
                shadeClose: false,
                cancel: function () {
                    location.reload();
                }
            });
        }
    }

    /**
     * 客户详情Tab
     */
    function doDetail(id) {
        var url = "${webRoot}/secUserInfo/customerInfo?id=" + id;
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["客户基本详情", true],
            area: ['100%', '100%'], //宽高
//            area: ['90%', '90%'], //宽高
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
        elem: '#openAccountEndTime' //指定元素
    });

    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }

    /**
     * 点击行选中
     */
    $(function () {
        $("#table-list tr:gt(0)").click(function () {
            console.log($(this).find(":checkbox").prop("checked"))
            if ($(this).find(":checkbox").is(':checked')) {
                $(this).find(":checkbox").prop("checked", false);
            } else {
                $(this).find(":checkbox").prop("checked", true);
            }
        });
    })


    /**
     * 全选按钮
     */
    $(function () {
        $("#checkAll").click(function () {
            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
        });
    });

    /**
     * 导出excel
     */
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/secUserInfo/customerExpExcel?SecuritiesUserInfoEntity=&' + obj;
    }

    layui.form.render('select');
</script>
<script src="${webRoot}/js/channel/channel.js"></script>
</html>