<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>

<html lang="en">
<head>
    <title>待入账列表</title>
    <link rel="stylesheet" href="${webRoot}/plugins/jqgrid/ui.jqgrid-bootstrap.css">
    <script type="text/javascript" src="${webRoot}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${webRoot}/plugins/jqgrid/grid.locale-cn.js"></script>
    <script type="text/javascript" src="${webRoot}/plugins/jqgrid/jquery.jqGrid.min.js"></script>
</head>
<style>
    table {
        font-size: 14px;
    }
</style>
<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 10px;">
        <form class="layui-form" id="search-from">
            <div class="layui-form-item" style="margin-bottom: 2px;">

                <label class="layui-form-label" style="width:120px">领取开始时间:</label>
                <div class="layui-input-inline">
                    <input type="text" id="receiveTimeStart" name="receiveTimeStart"
                           value="${queryCondition.receiveTimeStart}" placeholder="请选择领取开始时间"
                           class="layui-input">
                </div>

                <label class="layui-form-label" style="width:120px">领取结束时间:</label>
                <div class="layui-input-inline">
                    <input type="text" id="receiveTimeEnd" name="receiveTimeEnd"
                           value="${queryCondition.receiveTimeEnd}" placeholder="请选择领取结束时间"
                           class="layui-input">
                </div>

                <label class="layui-form-label" style="width:120px">打印状态:</label>
                <div class="layui-input-inline">
                    <tag:select initSelectedKey="${queryCondition.printStatus}"
                                nameKey="AO_PRINT_STATUS" id="printStatus"
                                name="printStatus" isAddDefaltOption="true"/>
                </div>

                <label class="layui-form-label" style="width: 140px">印花税状态:</label>
                <div class="layui-input-inline">
                    <tag:select initSelectedKey="${queryCondition.stampDutyStatus}"
                                nameKey="AO_STAMP_DUTY_STATUS" id="stampDutyStatus"
                                name="stampDutyStatus" isAddDefaltOption="true"/>
                </div>

                <label class="layui-form-label" style="width: 140px">入帐状态:</label>
                <div class="layui-input-inline">
                    <tag:select initSelectedKey="${queryCondition.accountEntryStatus}"
                                nameKey="AO_ACCOUNT_ENTRY_STATUS" id="accountEntryStatus"
                                name="accountEntryStatus" isAddDefaltOption="true"/>
                </div>
            </div>
            <div class="layui-form-item" style="margin-bottom: 2px;">
                <label class="layui-form-label" style="width:120px">英文名:</label>
                <div class="layui-input-inline">
                    <input type="text" name="clientNameSpell" value="${queryCondition.clientNameSpell}"
                           placeholder="请输入英文名" id="clientNameSpell"
                           class="layui-input">
                </div>
                <label class="layui-form-label" style="width:120px">客户帐号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="clientId" id="clientId"
                           value="${queryCondition.clientId}" placeholder="请输入客户帐号"
                           class="layui-input">
                </div>
                <label class="layui-form-label" style="width: 120px">证券手机号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="phoneNumber" id="phoneNumber"
                           value="${queryCondition.phoneNumber}" placeholder="请输入证券手机号"
                           class="layui-input">
                </div>
                <label class="layui-form-label" style="width: 140px">预约号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="applicationId" id="applicationId"
                           value="${queryCondition.applicationId}" placeholder="请输入预约号"
                           class="layui-input">
                </div>
                &nbsp;&nbsp;&nbsp;
                <button class="layui-btn" onclick="query()" type="button"><i
                        class="layui-icon">&#xe615;</i>搜 索
                </button>
                <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i
                        class="layui-icon">&#x1002;</i>重置
                </button>
                <shiro:hasPermission name="dealAccountPrint:exp">
                    <button class="layui-btn layui-btn-danger" type="button" id="print"
                            onclick="doPrint()"><i class="layui-icon">&#xe601;</i>打印
                    </button>
                    <button class="layui-btn layui-btn-normal" type="button" id="export"
                            onclick="expExcel()"><i class="layui-icon">&#xe601;</i>导出
                    </button>
                </shiro:hasPermission>
            </div>

            <div class="layui-form-item">
                <shiro:hasPermission name="donatedStock:payStampDuty">
                    <input type="hidden" id="payStampDutyStatus" name="payStampDutyStatus" value="1">
                    <button class="layui-btn layui-btn-radius layui-btn-normal "
                            style="float: left;margin-left: 10px;margin-top: 10px;"
                            type="button" onclick="payStampDuty();"><i
                            class="layui-icon ">&#xe60f;</i>已缴纳印花税
                    </button>
                </shiro:hasPermission>
                <shiro:hasPermission name="donatedStock:dealAccount">
                    <input type="hidden" id="dealAccountStatus" name="dealAccountStatus" value="1">
                    <button class="layui-btn layui-btn-radius layui-btn-normal "
                            style="float: left;margin-left: 10px;margin-top: 10px;"
                            type="button" onclick="dealAccount();"><i
                            class="layui-icon ">&#x1005;</i>授权入账
                    </button>
                </shiro:hasPermission>
            </div>
        </form>
    </div>
    <table id="jqGrid" width="99%"></table>
    <div id="jqGridPager" style="height: 40px"></div>
</div>
</body>

<script>
    //jqGrid的配置信息
//    $.jgrid.defaults.width = 1000;
    $.jgrid.defaults.responsive = true;
    $.jgrid.defaults.styleUI = 'Bootstrap';

    $(function () {
        $("#jqGrid").jqGrid({
            url: '${webRoot}/donatedStock/dealAccountListData',
            datatype: "json",
            colModel: [
                  {label: 'id', name: 'id', hidden: true, key: true }
                , {name: 'applicationId', index: 'application_id', label: '预约号', width: 160}
                , {name: 'receiveTime', index: 'receive_time', label: '领取时间', width: 160}
                , {name: 'clientId', index: 'client_id', label: '客户账号'}
                , {name: 'clientName', index: 'client_name', label: '客户姓名', sortable: false}
                , {name: 'clientNameSpell', index: 'client_name_spell', label: '英文名', sortable: false}
                , {name: 'phoneNumber', index: 'phone_number', label: '证券手机号', sortable: false}
                , {name: 'stockCode', index: 'stock_code', label: '股票代码'}
                , {name: 'stockName', index: 'stock_name', label: '股票名称', sortable: false}
                , {name: 'stockQuantity', index: 'stock_quantity', label: '数量', sortable: false}
                , {name: 'printStatus', index: 'print_status', label: '打印状态'}
                , {name: 'stampDutyStatus', index: 'stamp_duty_status', label: '印花税状态'}
                , {name: 'accountEntryStatus', index: 'account_entry_status', label: '入帐状态'}
            ],
            viewrecords: true,
            height: 420,
            rowNum: 10,
            rowList: [10, 30, 50],
            rownumbers: true,
            rownumWidth: 40,
            autowidth: true,
            shrinkToFit:true,//宽度自适应
            multiselect: true,
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
            postData: {
                'printStatus': $('#printStatus').val(),
                'accountEntryStatus': $('#accountEntryStatus').val(),
                'stampDutyStatus': $('#stampDutyStatus').val()
            },
            emptyrecords: "没有符合条件的数据",
            loadComplete: function() {
                var ids =jQuery("#jqGrid").jqGrid('getDataIDs');
                for(var i=0;i < ids.length;i++){
                    var curRowData = jQuery("#jqGrid").jqGrid('getRowData', ids[i]);
                    var payStampDutyStatus = $('#payStampDutyStatus').val();
                    var dealAccountStatus = $('#dealAccountStatus').val();
                    var printStatus = curRowData.printStatus;
                    var stampDutyStatus = curRowData.stampDutyStatus;
                    var accountEntryStatus = curRowData.accountEntryStatus;

                    if('1'==payStampDutyStatus && '待缴纳'==stampDutyStatus && '已打印'==printStatus ){
                        $("#jqg_jqGrid_"+ids[i]).prop("disabled", false);
                    }else if('1'==dealAccountStatus && '已缴纳'==stampDutyStatus && '待入账'==accountEntryStatus){
                        $("#jqg_jqGrid_"+ids[i]).prop("disabled", false);
                    }else{
                        $("#jqg_jqGrid_"+ids[i]).prop("disabled", true);
                    }
                }
            },
            beforeSelectRow : function(id, event) {
                var curRowData = jQuery("#jqGrid").jqGrid('getRowData', id);
                    var payStampDutyStatus = $('#payStampDutyStatus').val();
                    var dealAccountStatus = $('#dealAccountStatus').val();
                    var printStatus = curRowData.printStatus;
                    var stampDutyStatus = curRowData.stampDutyStatus;
                    var accountEntryStatus = curRowData.accountEntryStatus;

                    if ('1' == payStampDutyStatus && '待缴纳' == stampDutyStatus && '已打印' == printStatus) {
                        return true;
                    } else if ('1' == dealAccountStatus && '已缴纳' == stampDutyStatus && '待入账' == accountEntryStatus) {
                        return true;
                    } else {
                        return false;
                    }
            },
            onSelectAll:function(rowids,status) { //点击全选时触发事件
                if(status) {
                    var ids = jQuery("#jqGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var curRowData = jQuery("#jqGrid").jqGrid('getRowData', ids[i]);
                        var payStampDutyStatus = $('#payStampDutyStatus').val();
                        var dealAccountStatus = $('#dealAccountStatus').val();
                        var printStatus = curRowData.printStatus;
                        var stampDutyStatus = curRowData.stampDutyStatus;
                        var accountEntryStatus = curRowData.accountEntryStatus;

                        if ('1' == payStampDutyStatus && '待缴纳' == stampDutyStatus && '已打印' == printStatus) {
                            continue;
                        } else if ('1' == dealAccountStatus && '已缴纳' == stampDutyStatus && '待入账' == accountEntryStatus) {
                            continue;
                        } else {
                            $("#jqGrid").jqGrid('setSelection',ids[i], false);
                        }
                    }
                }else{
                    $("#jqGrid").jqGrid('resetSelection');
                }
            }
//            gridComplete: function () {
//                //隐藏grid底部滚动条
//                $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
//            }
        });
    });

    function query() {
        var receiveTimeStart = $('#receiveTimeStart').val();
        var receiveTimeEnd = $('#receiveTimeEnd').val();
        if (receiveTimeStart != null && receiveTimeStart != '') {
            receiveTimeStart = receiveTimeStart + " 00:00:00";
        }
        if (receiveTimeEnd != null && receiveTimeEnd != '') {
            receiveTimeEnd = receiveTimeEnd + " 23:59:59";
        }
        var phoneNumber = $('#phoneNumber').val();
        $("#jqGrid").jqGrid('setGridParam', {
            page: 1,
            dataType: 'json',
            postData: {
                'printStatus': $('#printStatus').val(),
                'clientId': $('#clientId').val(),
                'accountEntryStatus': $('#accountEntryStatus').val(),
                'clientNameSpell': $('#clientNameSpell').val(),
                'stampDutyStatus': $('#stampDutyStatus').val(),
                'applicationId': $('#applicationId').val(),
                'phoneNumber': phoneNumber,
                'receiveTimeStart': receiveTimeStart,
                'receiveTimeEnd': receiveTimeEnd
            }
        },true).trigger("reloadGrid");
    }

    function doTaskTab(actKey, busId, instanceId, taskId, defid, nodeType, dealId) {

        var url = "${webRoot}/act/deal/flowInfoTab?actKey=" + actKey + "&busId=" + busId + "&instanceId=" + instanceId
            + "&taskId=" + taskId + "&defId=" + defid + "&nodeType=" + nodeType + "&dealId=" + dealId;
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["办理任务", true],
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
    }


    /**
     * 打印pdf
     */
    function doPrint() {
        confirm('<span style=\'color: red;\'>盤中打印為按盤價，可能與收盤價不同!確定要打印嗎?</span>', function () {

            $('#print').attr("disabled", "true").addClass('layui-btn-disabled');
            $('#export').attr("disabled", "true").addClass('layui-btn-disabled');

            $.ajax({
                url: "${webRoot}/donatedStock/dealAccountPrintExist",   //处理页面的名称
                data: $('#search-from').serialize(), //为值取个名字
                type: "POST",  //传值方式
                dataType: "text",  //数据类型
                success: function (d) {
                    if (d.trim() == "exist") {

                        var params = $('#search-from').serialize();
                        var sidx = $("#jqGrid").jqGrid('getGridParam','sortname');
                        var order=$("#jqGrid").jqGrid('getGridParam','sortorder');
                        var pdfUrl = '${webRoot}/donatedStock/dealAccountPrint?sidx='+sidx+'&order='+order+'&DonatedStockApplicationInfoEntity=&' + params;

                        downloadFile('', pdfUrl);
                    }
                    else {
                        toast("没有要打印的数据！");
                    }
                }
            });
            layer.close(loading);
        });
    }

    /**
     * 导出excel
     */
    function expExcel() {
        confirm('<span style=\'color: red;\'>盤中打印為按盤價，可能與收盤價不同!確定要打印嗎?</span>', function () {

            $('#export').attr("disabled", "true").addClass('layui-btn-disabled');
            $('#print').attr("disabled", "true").addClass('layui-btn-disabled');

            $.ajax({
                url: "${webRoot}/donatedStock/dealAccountPrintExist",   //处理页面的名称
                data: $('#search-from').serialize(), //为值取个名字
                type: "POST",  //传值方式
                dataType: "text",  //数据类型
                success: function (d) {
                    if (d.trim() == "exist") {

                        var obj = $('#search-from').serialize();
                        var sidx = $("#jqGrid").jqGrid('getGridParam','sortname');
                        var order=$("#jqGrid").jqGrid('getGridParam','sortorder');
                        var excelUrl = '${webRoot}/donatedStock/dealAccountExcel?sidx='+sidx+'&order='+order+'&DonatedStockApplicationInfoEntity=&' + obj;

                        downloadFile('', excelUrl);
                    }
                    else {
                        toast("没有要打印的数据！");
                    }
                }
            });
            layer.close(loading);
        });
    }

    function downloadFile(name, href) {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        setTimeout(function () {
            $("#export").attr("disabled", false).removeClass("layui-btn-disabled");
        }, 6000);
        setTimeout(function () {
            $("#print").attr("disabled", false).removeClass("layui-btn-disabled");
        }, 6000);
        var a = document.createElement("a"), //创建a标签
            e = document.createEvent("MouseEvents"); //创建鼠标事件对象
        e.initEvent("click", false, false); //初始化事件对象
        a.href = href; //设置下载地址
        a.download = name; //设置下载文件名
        a.dispatchEvent(e); //给指定的元素，执行事件click事件
    }

    window.confirm = function (option, yesCallback, cancelCallback) {
        if (typeof option == 'string') {
            $layer.confirm(option, {icon: 3, title: '提示'}, function (index) {
                $layer.close(index);
                if (typeof yesCallback == 'function') {
                    yesCallback();
                }
            }, function (index) {
                $layer.close(index);
                if (typeof cancelCallback == 'function') {
                    cancelCallback();
                }
            });
        } else {
            var ops = $.extend({icon: 3, title: '提示'}, option);

            updateOptionIcon(option, ops);
            $layer.confirm(option.msg, ops, function (index) {
                $layer.close(index);
                if (typeof yesCallback == 'function') {
                    yesCallback();
                }
            }, function (index) {
                $layer.close(index);
                if (typeof cancelCallback == 'function') {
                    cancelCallback();
                }
            });
        }
    }


    function dealAccountPrint() {
        var params = $('#search-from').serialize();
        window.location.href = '${webRoot}/donatedStock/dealAccountPrint?DonatedStockApplicationInfoEntity=&' + params;
        setTimeout("location.reload()", 2500);
    }

    /**
     * 判断是否收盘
     */
    function checkStockClose() {
        var myDate = new Date();
        var hours = myDate.getHours();       //获取当前小时数(0-23)
        var mins = myDate.getMinutes();     //获取当前分钟数(0-59)
        // debugger;
        if (hours < 16 && hours > 9) {
            myToast("请于交易日收盘后操作！", 4);
            return true;
        } else {
            return true;
        }
    }

    /**
     * 已缴纳印花税
     */
    function payStampDuty() {
        if (checkStockClose() == false) {
            return;
        }
        var ids = getSelectedRows().toString();
        var params = {'ids': ids};
        var url = "${webRoot}/donatedStock/payStampDuty";
        $.post(url, params, function callback(result) {
            if (result.code == '0') {
                toast(result, function () {
                    // 刷新列表
                    window.location.reload();
                })
            } else {
                toast(result.msg, function () {
                    // 刷新列表
                    window.location.reload();
                })
            }
        }, "json");
    }


    /**
     * 授权入账
     */
    function dealAccount() {
        var ids = getSelectedRows().toString();

        confirm("确认授权入账吗?", function () {
            var params = {
                'ids': ids
            };
            var url = "${webRoot}/donatedStock/dealAccount";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                    toast(result, function () {
                        // 刷新列表
                        window.location.reload();
                    })
                } else {
                    toast(result.msg, function () {
                        // 刷新列表
                        window.location.reload();
                    })
                }
            }, "json");
        });
    }

    /**
     * 全选按钮
     */
    $(function () {
        $("#checkAll").click(function () {
            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
        });
    });


    layui.laydate.render({
        elem: '#receiveTimeStart' //指定元素
    });
    layui.laydate.render({
        elem: '#receiveTimeEnd' //指定元素
    });

    /**
     * 导出excel
     */
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled", "true").addClass('layui-btn-disabled');
        setTimeout(function () {
            $("#export").attr("disabled", false).removeClass("layui-btn-disabled");
        }, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/donatedStock/dealAccountExcel?DonatedStockApplicationInfoEntity=&' + obj;
    }


    $("#refresh").click(function () {
        window.location.reload();
    });

    //选择多条记录
    function getSelectedRows() {
        var grid = $("#jqGrid");
        var rowKey = grid.getGridParam("selrow");
        if(!rowKey){
            alert("请选择一条记录");
            return ;
        }

        return grid.getGridParam("selarrrow");
    }

    layui.form.render('select');


</script>
</html>