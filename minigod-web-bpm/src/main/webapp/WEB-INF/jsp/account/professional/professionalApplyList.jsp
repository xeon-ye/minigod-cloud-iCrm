<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>

<html lang="en">
<head>
    <title>专业投资者申请记录列表</title>
    <link rel="stylesheet" href="${webRoot}/plugins/jqgrid/ui.jqgrid-bootstrap.css">
    <script type="text/javascript" src="${webRoot}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${webRoot}/js/vue.min.js"></script>
    <script type="text/javascript" src="${webRoot}/plugins/jqgrid/grid.locale-cn.js"></script>
    <script type="text/javascript" src="${webRoot}/plugins/jqgrid/jquery.jqGrid.min.js"></script>
    <script type="text/javascript" src="${webRoot}/js/common.js"></script>
    <style>
        .layui-form-label {
            width: 120px;
            font-size: 13px;
        }

        .layui-form-label + .layui-input-block {
            margin-left: 135px;
            width: 160px;
            font-size: 13px;
        }

        .layui-btn {
            font-size: 13px;
        }

        .layui-btn-mini {
            font-size: 11px;
        }
    </style>
</head>
<style>
    table {
        font-size: 14px;
    }
</style>

<body>
<div id="rrapp" v-cloak>
    <div v-show="showList">
        <div class="" style="margin-top: 20px;">
            <form class="layui-form" id="search-from">
                <input id="flag" name="flag" value="1" hidden>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">申请开始日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="applyDateSt" name="applyDateSt"
                               placeholder="请输入申请开始日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">申请结束日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="applyDateEd" name="applyDateEd"
                               placeholder="请输入申请结束日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">小神号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="userId" id="userId"
                               placeholder="请输入小神号"
                               class="form-control">
                    </div>

                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">客户帐号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="clientId" id="clientId"
                               placeholder="请输入客户帐号"
                               class="form-control">
                    </div>

                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">客户姓名:</label>
                    <div class="layui-input-block">
                        <input type="text" name="clientName" id="clientName"
                               placeholder="请输入客户姓名"
                               class="form-control">
                    </div>

                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">认定开始日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="accreditDateSt" name="accreditDateSt"
                               placeholder="请输入认定开始日期"
                               class="form-control">
                    </div>

                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">认定结束日期</label>
                    <div class="layui-input-block">
                        <input type="text" id="accreditDateEd" name="accreditDateEd"
                               placeholder="请输入认定结束日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">英文名:</label>
                    <div class="layui-input-block">
                        <input type="text" name="clientNameSpell" id="clientNameSpell"
                               placeholder="请输入英文名"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">证券手机号:</label>
                    <div class="layui-input-block">
                        <input type="text" id="phoneNumber" name="phoneNumber"
                               placeholder="请输入证券手机号"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">审核状态:</label>
                    <div class="layui-input-block">
                        <tag:select nameKey="PROFESSIONAL_APPLY_STATUS" name="applicationStatus"
                                    id="applicationStatus"
                                    initSelectedKey="${model.applicationStatus}"
                                    isAddDefaltOption="true"/>
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">失效开始日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="expireDateSt" name="expireDateSt"
                               placeholder="请输入失效开始日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">失效结束日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="expireDateEd" name="expireDateEd"
                               placeholder="请输入失效结束日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">撤销开始日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="revokeDateSt" name="revokeDateSt"
                               placeholder="请输入撤销开始日期"
                               class="form-control">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 2px;">
                    <label class="layui-form-label">撤销结束日期:</label>
                    <div class="layui-input-block">
                        <input type="text" id="revokeDateEd" name="revokeDateEd"
                               placeholder="请输入撤销结束日期"
                               class="form-control">
                    </div>

                </div>
                <div class="layui-form-item" style="padding: 10px 50px;">
                    <button class="layui-btn" onclick="query()" type="button"><i
                            class="layui-icon">&#xe615;</i>查询
                    </button>
                    <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                            class="layui-icon">&#x1002;</i>重置
                    </button>
                    <shiro:hasPermission name="professionalInvestor:export">
                        <button class="layui-btn layui-btn-danger" type="button" id="export"
                                onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                        </button>
                    </shiro:hasPermission>
                </div>
            </form>
        </div>
        <table id="jqGrid" width="99%"  class="layui-table"  lay-size=""></table>
        <div id="jqGridPager" style="height: 40px"></div>
    </div>
</div>
</body>

<script>
    $(function () {
        $("#jqGrid").jqGrid({
            url: '${webRoot}/professionalInvestor/list',
            datatype: "json",
            colModel: [
                {name: 'applicationId', index: 'application_id', label: '预约号', hidden: true}
                , {name: 'applyTime', index: 'apply_time', label: '申请日期'}
                , {name: 'accreditTime', index: 'accredit_time', label: '认定日期'}
                , {name: 'expireTime', index: 'expire_time', label: '失效日期'}
                , {name: 'revokeTime', index: 'revoke_time', label: '撤销日期'}
                , {name: 'userId', index: 'user_id', label: '小神号', sortable: false}
                , {name: 'clientId', index: 'client_id', label: '客户账号', sortable: false}
                , {name: 'clientName', index: 'client_name', label: '客户姓名', sortable: false}
                , {name: 'clientNameSpell', index: 'client_name', label: '英文名', sortable: false}
                , {name: 'phoneNumber', index: 'phone_number', label: '证券手机号', sortable: false}
                , {name: 'applicationStatus', index: 'application_status', label: '审核状态', sortable: false}
                , {
                    name: 'operate', index: 'operate', label: '操作', width: 100, sortable: false,
                    formatter: function cLink(cellvalue, options, rowObject) {
                        var clik = "viewTab('" + rowObject.applicationId + "','" + rowObject.instanceId + "','" + rowObject.defid + "','" + rowObject.assignDrafter + "')";
                        return '<button class="layui-btn layui-btn-mini" type="button" onclick="' + clik + '">' +
                            '<i class="layui-icon">&#xe705;</i>查看</button>';
                    }
                }
            ],
            viewrecords: true,
            height: 420,
            rowNum: 10,
            rowList: [10, 30, 50],
            rownumbers: true,
            rownumWidth: 40,
            autowidth: true,
            pager: "#jqGridPager",
            jsonReader: {
                root: "page.list",
                page: "page.currPage",
                total: "page.totalPage",
                records: "page.totalCount"
            },
            prmNames: {
                page: "page",
                rows: "limit",
                order: "order"
            },
            postData: {},
            emptyrecords: "没有符合条件的数据"
//            gridComplete: function () {
//                //隐藏grid底部滚动条
//                $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
//            }
        });
    });

    function query() {
        var applyDateSt = $('#applyDateSt').val();
        var applyDateEd = $('#applyDateEd').val();
        var accreditDateSt = $('#accreditDateSt').val();
        var accreditDateEd = $('#accreditDateEd').val();
        var expireDateSt = $('#expireDateSt').val();
        var expireDateEd = $('#expireDateEd').val();
        var revokeDateSt = $('#revokeDateSt').val();
        var revokeDateEd = $('#revokeDateEd').val();
        if (applyDateSt != null && applyDateSt != '') {
            applyDateSt = applyDateSt + " 00:00:00";
        }
        if (applyDateEd != null && applyDateEd != '') {
            applyDateEd = applyDateEd + " 23:59:59";
        }
        if (accreditDateSt != null && accreditDateSt != '') {
            accreditDateSt = accreditDateSt + " 00:00:00";
        }
        if (accreditDateEd != null && accreditDateEd != '') {
            accreditDateEd = accreditDateEd + " 23:59:59";
        }
        if (expireDateSt != null && expireDateSt != '') {
            expireDateSt = expireDateSt + " 00:00:00";
        }
        if (expireDateEd != null && expireDateEd != '') {
            expireDateEd = expireDateEd + " 23:59:59";
        }
        if (revokeDateSt != null && revokeDateSt != '') {
            revokeDateSt = revokeDateSt + " 00:00:00";
        }
        if (revokeDateEd != null && revokeDateEd != '') {
            revokeDateEd = revokeDateEd + " 23:59:59";
        }
        $("#jqGrid").jqGrid('setGridParam', {
            page: 1,
            dataType: 'json',
            postData: {
                'userId': $('#userId').val(),
                'clientId': $('#clientId').val(),
                'clientName': $('#clientName').val(),
                'clientNameSpell': $('#clientNameSpell').val(),
                'clientStatus': $('#clientStatus').val(),
                'applicationStatus': $('#applicationStatus').val(),
                'phoneNumber': $('#phoneNumber').val(),
                'applyDateSt': applyDateSt,
                'applyDateEd': applyDateEd,
                'accreditDateSt': accreditDateSt,
                'accreditDateEd': accreditDateEd,
                'expireDateSt': expireDateSt,
                'expireDateEd': expireDateEd,
                'revokeDateSt': revokeDateSt,
                'revokeDateEd': revokeDateEd
            }
        }).trigger("reloadGrid");
    }

    function viewTab(busId, instanceId, defid, dealId) {

        var url = "${webRoot}/act/deal/flowInfoTab?flag=0&actKey=professionalApplication" + "&busId=" + busId + "&instanceId=" + instanceId
            + "&defId=" + defid + "&dealId=" + dealId;
        // 弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["查看详情", true],
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
    }

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled", "true").addClass('layui-btn-disabled');
        setTimeout(function () {
            $("#export").attr("disabled", false).removeClass("layui-btn-disabled");
        }, 6000);
        var obj = $('#search-from').serialize();
        var sidx = $("#jqGrid").jqGrid('getGridParam', 'sortname');
        var order = $("#jqGrid").jqGrid('getGridParam', 'sortorder');
        window.location.href = '${webRoot}/professionalInvestor/export?sidx=' + sidx + '&order=' + order + '&params=&' + obj;
    }

    $("#refresh").click(function () {
        window.location.reload();
    });

    //申请日期
    layui.laydate.render({
        elem: '#applyDateSt'
    });
    layui.laydate.render({
        elem: '#applyDateEd'
    });

    //认定日期
    layui.laydate.render({
        elem: '#accreditDateSt'
    });
    layui.laydate.render({
        elem: '#accreditDateEd'
    });

    //失效日期
    layui.laydate.render({
        elem: '#expireDateSt'
    });
    layui.laydate.render({
        elem: '#expireDateEd'
    });

    //撤销日期
    layui.laydate.render({
        elem: '#revokeDateSt'
    });
    layui.laydate.render({
        elem: '#revokeDateEd'
    });

    layui.form.render('select');
</script>
</html>