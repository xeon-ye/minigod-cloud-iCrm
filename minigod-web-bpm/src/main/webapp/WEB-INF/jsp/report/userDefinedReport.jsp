<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>渠道业绩统计报表</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <script>
    </script>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post" action="${webRoot}/userDefinedReport/list">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:100px;">创建人:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="createOpr" name="createOpr" value="${info.createOpr}"
                                       class="layui-input" placeholder="请输入创建人">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:120px;">描述/备注:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="defRemark" name="defRemark" value="${info.defRemark}"
                                       class="layui-input" placeholder="请输入描述/备注">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:120px;">状态:</label>
                            <div class="layui-input-inline">
                                <tag:select nameKey="STATUS_EFFECTIVE_INVALID" id="isStatus" name="isStatus"
                                            isAddDefaltOption="true"
                                            clazz="layui-input" initSelectedKey="${info.isStatus}"/>
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-12">
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索
                                </button>
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>
                            </div>
                        </td>
                    </tr>

                </table>
            </div>
        </form>
    </div>

    <div class="row">
        <div class="col-sm-12" style="width:99%">
            <table id="table-list" name="tableList" class="layui-table">
                <thead>
                <tr width="99%">
                    <th style="width: 4%;height: 20px;">
                        <%--<input type="checkbox" />--%>
                        选择
                    </th>
                    <th>ID</th>
                    <th>状态</th>
                    <th>描述</th>
                    <th>备注</th>
                    <th>创建人</th>
                    <th>创建时间</th>
                    <th>修改人</th>
                    <th>更新时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr name="">
                        <td><input id="id" name="selectFlag" type="checkbox" value="${info.id}"/></td>
                            <%--<td>${i.index+1 }</td>--%>
                        <td>${info.id}</td>
                        <td>${fns:getCodeName("STATUS_EFFECTIVE_INVALID",info.isStatus)}</td>

                        <td>${info.defDesc}</td>
                        <td>${info.defRemark}</td>
                        <td>${info.createOpr}</td>
                        <td><fmt:formatDate value="${info.createTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${info.updateOpr}</td>
                        <td><fmt:formatDate value="${info.updateTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <table>
                <tr>
                    <shiro:hasPermission name="userDefinedReport:add">
                    <button id="add" class="layui-btn" onclick="addUserDefined();"><i class="layui-icon">&#xe654;</i>新增
                    </button>
                    <button id="update" class="layui-btn layui-btn-normal" onclick="updateUserDefined(1);"><i
                            class="layui-icon">&#xe642;</i>修改
                    </button>
                    <button id="auth" class="layui-btn layui-btn-warm" onclick="toAuthTab();"><i
                            class="layui-icon">&#x1005;</i>授权
                    </button>
                    </shiro:hasPermission>
                    <button id="run" class="layui-btn layui-btn-warm" onclick="updateUserDefined(0);"><i
                            class="layui-icon">&#xe614;</i>运行
                    </button>
                    <button class="layui-btn layui-btn-danger" onclick="deleteUserDefined();"><i class="layui-icon">&#xe640;</i>删除
                    </button>
                </tr>
            </table>

            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
</body>

<script>

    // 跳转授权页
    function toAuthTab() {

        var item_id;
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        for (var i = 0; i < items.length; i++) {
            if (items[i].checked) {
                ++count;
                item_id = items[i].value;
            }
        }

        if (count < 1) {
            alert("请选择行！");
            return;
        } else {

            var url = "${webRoot}/userDefinedReport/toAuthTab?sqlId=" + item_id;
            //弹框层
            layer.open({
                scrollbar: false,
                type: 2,
                title: ["授权页面", true],
                area: ['90%', '90%'], //宽高
                content: [url, 'yes'],
                shadeClose: false
            });
        }
    }

    //新增
    function addUserDefined() {
        var url = "${webRoot}/userDefinedReport/addUserDefinedReoprt";
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["自定义报表新增", true],
            area: ['100%', '100%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            offset: 't',
            move: false
        });
    }

    //查看/修改/运行
    function updateUserDefined(type) {
        var item_id;
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        for (var i = 0; i < items.length; i++) {
            if (items[i].checked) {
                ++count;
                item_id = items[i].value;
            }
        }

        if (count < 1) {
            alert("请选择行！");
            return;
        } else {
            var url = "${webRoot}/userDefinedReport/updateUserDefinedReport?id=" + item_id+"&type="+type;
            //弹框层
            layer.open({
                scrollbar: false,
                type: 2,
                title: ["修改自定义SQL", true],
                area: ['100%', '100%'], //宽高
                content: [url, 'yes'],
                shadeClose: false,
                offset: 't',
                move: false
            });
        }
    }

    //删除
    function deleteUserDefined() {
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
            confirm("确认删除该记录吗?", function () {
            $.ajax({
                url: "${webRoot}/userDefinedReport/delete",   //处理页面的名称
                data: {ids: item_id},  //为值取个名字
                type: "POST",  //传值方式
                dataType: "text",  //数据类型
                success: function (d) {
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
            });
        }
    }


    $(function () {
        $("#table-list tr:gt(0)").click(function () {
            console.log($(this).find(":checkbox").prop("checked"))
            $("tr").find(":checkbox").prop("checked", false);
            $(this).find(":checkbox").prop("checked", true);
            $("tr").removeClass();
            $(this).toggleClass('red');
        });
    })

    layui.laydate.render({
        elem: '#beginDate'
    });
    layui.laydate.render({
        elem: '#endDate'
    });

</script>

</html>