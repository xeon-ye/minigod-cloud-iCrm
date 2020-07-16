<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html lang="en">
<head>
    <title>汇款成功页面</title>
</head>
<body>
<div class="main-container" id="main-container">

    <div id="div7" v-cloak>
        <div v-show="!showList" class="panel panel-default">
            <div class="panel-heading"><b style="color: #368763">请选择入金银行</b></div>
            <div class="row" style="margin-top: 20px;">
                <form class="layui-form" id="search-from" method="post"
                      action="${webRoot}/clientFundDeposit/toChooseDepositBank?busId=${taskDto.busId}&taskId=${taskDto.taskId}&defId=${taskDto.defId}&instanceId=${taskDto.instanceId}&applicationIds=${applicationIds}">
                </form>
            </div>
            <div class="row">
                <div class="col-xs-12" style="width:99%">
                    <table id="table-list" class="layui-table">
                        <thead>
                        <tr width="99%">
                            <th style="width: 7%;height: 20px;"><input type="checkbox"/></th>
                            <th>银行名称</th>
                            <th>银行编号</th>
                            <th>币种</th>
                            <th>银行帐户</th>
                            <th>备注</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.result}" var="hsCompanyBankInfo" varStatus="i">
                            <tr name="${hsCompanyBankInfo.id}">
                                <td><input id="id" name="selectFlag" type="checkbox" value="${hsCompanyBankInfo.id}-${hsCompanyBankInfo.bankName}-${hsCompanyBankInfo.moneyType}"/>
                                </td>
                                <td>${hsCompanyBankInfo.bankName} </td>
                                <td>${hsCompanyBankInfo.bankId} </td>
                                <td>
                                        ${fns:getCodeName("SEC_MONEY_TYPE", hsCompanyBankInfo.moneyType)}
                                </td>
                                <td>${hsCompanyBankInfo.bankAccount} </td>
                                <td>${hsCompanyBankInfo.remark}</td>
                                <td>
                                    <c:if test = "${hsCompanyBankInfo.isTop == 0 or hsCompanyBankInfo.isTop == null}">
                                        <button class="layui-btn layui-btn-small" type="button"
                                                onclick="topHsBank(${hsCompanyBankInfo.id},1)">
                                            <i class="layui-icon">&#xe604;</i>置顶
                                        </button>
                                    </c:if>
                                    <c:if test = "${hsCompanyBankInfo.isTop == 1}">
                                        <button class="layui-btn layui-btn-small" type="button"
                                                onclick="topHsBank(${hsCompanyBankInfo.id},0)">
                                            <i class="layui-icon">&#xe604;</i>取消置顶
                                        </button>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <sys:page page="${page}"></sys:page>
                </div>
            </div>
        </div>
    </div>

    <div class="row" style="margin-left: 40%;padding-bottom: 28px;margin-top: 15px;">
        <button class="layui-btn " type="button" onclick="doSubmit()">提交</button>
        <button class="layui-btn layui-btn-primary" type="button" onclick="closeThisWindow()">关 闭</button>
    </div>

</div>

</body>
<script>
    // 流程相关信息类
    function processInfo(busId, actKey, taskId, instanceId, changeFields, defId, remark) {
        this.busId = busId;//业务id
        this.actKey = actKey;//流程key也是业务key
        this.taskId = taskId;//任务id
        this.instanceId = instanceId;//流程实例
        this.changeFields = changeFields;//可更改的字段
        this.defId = defId;//流程定义id
        this.remark = remark;//审批意见
    }

    var processInfo = new processInfo();
    $(function () {

        //获取业务可更改的字段，和流程业务基本信息
        processInfo.busId = '${taskDto.busId}';
        processInfo.taskId = '${taskDto.taskId}';
        processInfo.instanceId = '${taskDto.instanceId}';
        processInfo.defId = '${taskDto.defId}';
        processInfo.remark = '${taskDto.remark}';
    });

    function doSubmit() {
        var item_id;
        var item_name;
        var money_type;
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        for (var i = 0; i < items.length; i++) {
            if (items[i].checked) {
                ++count;

                var arr=new Array();
                arr=items[i].value.split('-');

                item_id = arr[0];
                item_name = arr[1];
                money_type = arr[2];
            }
        }

        if (count < 1) {
            alertMsg("请选择行！");
            return;
        } else {
            <c:forEach var="obj" items="${applicationEntities}">
                if('!'!=money_type && money_type != '${obj.moneyType}'){
                    alertMsg("入账币种不符，请核对！");
                    return;
                }
            </c:forEach>
            var applicationIds = '${applicationIds}';
           if(applicationIds==null || applicationIds==''){
               doPassTask(item_id,item_name);
           }else{
               doPassTaskBatch(applicationIds,'${currentUserId}',item_id,item_name);
           }
        }
    }

    function doPassTask(item_id,item_name,money_type) {
            confirm('确定该申请从<span style=\'color: red;\'>'+item_name+'</span>入账吗？', function () {
                var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});
                var params = "busId=" + '${taskDto.busId}' + "&taskId=" + '${taskDto.taskId}' + "&instanceId=" + '${taskDto.instanceId}' + "&defId=" + '${taskDto.defId}'
                    + "&remark=" + '${taskDto.remark}'
                    + "&itemId=" + item_id;

                var url = "${webRoot}/clientFundDeposit/doDepositEntry";
                $.post(url, params, function (result) {
                    if (result.code == '0') {
                            // 刷新父窗口列表
                            parent.parent.location.reload();
                            // 关闭弹框
                            closeThisWindow();
                    } else {
                        alertMsg(result.msg);
                        layer.close(loading);
                    }
                });
            });
    }
    // 批量入账
    function doPassTaskBatch(applicationIds, currentUserId,item_id,item_name) {
        confirm('确定以下申请都是入账<span style=\'color: red;\'>'+item_name+'</span>吗?', function () {

            var loading = layer.msg('Loading...', {icon: 16, shade: 0.01});

            var params = {
                'applicationIds': applicationIds,
                'toUserId': currentUserId,
                'actKey': 'fundDepositApplication',
                'itemId':item_id
            };
            var url = "${webRoot}/clientFundDeposit/doPassTaskBatch";
            $.post(url, params, function callback(result) {
                if (result.code == '0') {
                        // 刷新列表
                        parent.location.reload();
                        // 关闭弹框
                        closeThisWindow();
                } else {
                    alertMsg(result.msg);
                    layer.close(loading);
                }
            }, "json");
        });
    }

    //置顶/取消置顶恒生公司账号
    function topHsBank(id,isTop) {
        var params = {
            'id': id,
            'isTop': isTop
        };
        var url = "${webRoot}/clientBankCardInfo/updateHsCompanyBank";
        $.post(url, params, function callback(result) {
            if (result.code == '0') {
                // 刷新列表
                window.location.reload();
            } else {
                alertMsg(result.msg);
            }
        }, "json");
    }

    $(function () {

        $("#table-list tr:gt(0)").click(function () {
            if ($('input[type="checkbox"]').is(':checked')) {
                $('input[type="checkbox"]').prop("checked", false);
                // 当前点击的checkbox
                var cobj = $(this).find("input[type='checkbox']");
                // 将当前点击的checkbox置为选中状态
                cobj.prop("checked", true);
                $("tr").removeClass();
                $(this).toggleClass('red');
            } else {
                // 每次点击前，将所有checkbox置为 未选中
                $('input[type="checkbox"]').prop("checked", false);
                // 当前点击的checkbox
                var cobj = $(this).find("input[type='checkbox']");
                // 将当前点击的checkbox置为选中状态
                cobj.prop("checked", true);
                $("tr").removeClass();
                $(this).toggleClass('red');
            }
        })
    });

</script>

</html>