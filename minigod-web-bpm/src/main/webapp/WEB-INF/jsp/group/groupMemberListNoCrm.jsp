<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>非CRM列表</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <script type="text/javascript" src="${webRoot}/js/jquery.form.js"></script>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" action="${webRoot}/clientGroupMemberInfo/list">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td hidden="hidden"><input name="groupNo" value="${groupNo}" class="layui-input"></td>
                        <td hidden="hidden"><input name="groupType" value="${groupType}" class="layui-input"></td>


                        <td>
                            <label class="layui-form-label" style="width:120px;">客户姓名:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="clientName" name="clientName" value="${ClientGroupMemberInfoEntity.clientName}"
                                       placeholder="请输入客户姓名" class="layui-input">
                            </div>
                        </td>

                        <td>
                            &nbsp;&nbsp;&nbsp;&nbsp;<button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜
                            索
                        </button>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>

                </table>

            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <table id="table-list" name="tableList" class="layui-table col-xs-12 right">
                <thead>
                <tr width="99%">
                    <th style="width: 10%;height: 20px;">
                        <input id="checkAll" type="checkbox"/>
                    </th>
                    <th>分组编号</th>
                    <th>客户姓名</th>
                    <th>是否CRM客户</th>
                    <th>移动电话</th>
                    <th>电子邮箱</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr>
                        <td><input id="id" name="selectFlag" type="checkbox" value="${info.id}"/></td>
                        <td>${info.groupNo}</td>
                        <td>${info.clientName}</td>
                        <td>否</td>
                        <td>${info.phoneNumber}</td>
                        <td>${info.email}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table>
                <tr>
                    <button class="layui-btn layui-btn-danger" type="button" id="import"
                            onclick="importExcel()"><i class="layui-icon">&#xe62f;</i>导 入
                    </button>
                    <button class="layui-btn  layui-btn-danger" onclick="deleteChecked();"><i
                            class="layui-icon">&#xe640;</i>删除
                    </button>
                    <button class="layui-btn  layui-btn-danger" onclick="deleteAll();"><i
                            class="layui-icon">&#xe640;</i>全部删除
                    </button>
                    <button id="infoList" class="layui-btn " onclick="closeLayer();"><i
                            class="layui-icon">&#xe638;</i>取消
                    </button>
                    <shiro:hasPermission name="securitiesUserInfo:notCrmExp">
                        <button class="layui-btn layui-btn-danger " type="button" id="export"
                                onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                        </button>
                    </shiro:hasPermission>
                </tr>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">

    // 导入excel弹层
    function importExcel() {
        var url="${webRoot}/clientGroupMemberInfo/goUploadExcel?groupNo="+${groupNo};
        layer.open({
            scrollbar: false,
            type: 2,
            title : ["从Excel文件导入数据" , true],
            area: ['35%', '40%'],
            content: [url,'no']
        });
    }

    /**
     * 导出excel
     */
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
//        layer.alert(obj);
        window.location.href = '${webRoot}/clientGroupMemberInfo/clientGroupNocrmExpExcel?info=&' + obj;
    }

    /**
     * 客户详情Tab
     */
    function addGroup() {

        var url = "${webRoot}/clientGroupMemberInfo/addCustomerList?groupNo=" +${groupNo};
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["分组新增", true],
            area: ['95%', '90%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
        });
    }

    function deleteChecked() {
        var ids = new Array();
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        var item_id = "";
        for (var i = 0; i < items.length; i++) {
            if (items[i].checked) {
                ++count;
                item_id += items[i].value + ",";
            }
        }
        if (count < 1) {
            alert("请选择行！");
            return;
        } else {
            $.ajax({
                url: "${webRoot}/clientGroupMemberInfo/delete",   //处理页面的名称
                data: {ids: item_id},  //为值取个名字
                type: "POST",  //传值方式
                dataType: "TEXT",  //数据类型
                success: function(d){
                        if (d.trim() == "ok") {
                            layer.confirm('删除成功！', {
                                btn: ['是'], btn1: function () {
                                    location.reload();
                                }
                            })
                        } else if (d.trim() == "error") {
                            layer.confirm('删除失败！', {
                                btn: ['是'], btn1: function () {
                                    location.reload();
                                }
                            })
                        }
                    }
            })
        }
    }

    function deleteAll() {
        var groupNo = ${groupNo};
        layer.confirm('确认全部删除吗?', {
            btn: ['是', '否'], btn1: function () {
                $.ajax({
                    url: "${webRoot}/clientGroupMemberInfo/deleteAll",   //处理页面的名称
                    data: {groupNo: groupNo},  //为值取个名字
                    type: "POST",  //传值方式
                    dataType: "TEXT",  //数据类型
                    success: function(d){
                            if (d.trim() == "ok") {
                                layer.confirm('删除成功！', {
                                    btn: ['是'], btn1: function () {
                                        location.reload();
                                    }
                                })
                            } else if (d.trim() == "error") {
                                layer.confirm('删除失败！', {
                                    btn: ['是'], btn1: function () {
                                        location.reload();
                                    }
                                })
                            }
                        }
                })
            },
            btn2: function () {
                alert("取消成功");
            }
        })
    }

    function updateChecked() {
        var tradeAccounts = "";
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        for (var i = 0; i < items.length; i++) {
            if (items[i].checked) {
                ++count;
                tradeAccounts += items[i].parentNode.parentNode.children[3].innerHTML + ",";
            }
        }
        tradeAccounts = tradeAccounts.substring(0, tradeAccounts.length - 1);
        if (count < 1) {
            alert("请选择行！");
            return;
        } else {
            var url = "${webRoot}/clientGroupMemberInfo/updateInit?tradeAccounts=" + tradeAccounts;
            //弹框层
            layer.open({
                scrollbar: false,
                type: 2,
                title: ["分组成员管理", true],
                area: ['95%', '90%'], //宽高
                content: [url, 'no'],
                shadeClose: false
            });
        }
    }

    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }

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
    $(function () {
        $("#checkAll").click(function () {
            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
        });
    });

</script>

</html>