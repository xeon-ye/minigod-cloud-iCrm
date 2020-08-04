<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>新增客户列表</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/clientGroupMemberInfo/addCustomerList">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td hidden="hidden"><input type="text" id="groupNo" name="groupNo" value="${model.groupNo}" class="form-control"></td>
                        <td>
                            <label class="layui-form-label" style="width: 120px">姓名:</label>
                            <div class="col-xs-7">
                                <input type="text" name="clientName" value="${model.clientName}" placeholder="请输入姓名"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 160px">证件号码:</label>
                            <div class="col-xs-7">
                                <input type="text" name="idNo" value="${model.idNo}" placeholder="请输入证件号码"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 120px">手机号:</label>
                            <div class="col-xs-7">
                                <input type="text" name="phoneNumber" value="${phoneNumber}" placeholder="请输入手机号"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <button class="layui-btn layui-btn-mini" type="submit" id="searchSubmit"><i
                                    class="layui-icon">&#xe615;</i>搜 索
                            </button>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-xs-1" style="width:100%">
            <table id="table-list" class="layui-table">
                <thead>
                <tr width="99%">
                    <th style="width: 10%;height: 20px;"><input type="checkbox" id="checkAll" value="选择"/></th>
                    <th hidden=true>tradeAccount</th>
                    <th>客户编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>证件类型</th>
                    <th>证件号码</th>
                    <th>客户类型</th>
                    <th>机构名称</th>
                    <th>联系地址</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="customer" varStatus="i">
                    <tr name="customer_${customer.gid }">
                        <td><input id="selectFlag" name="selectFlag" type="checkbox" value="${customer.gid}"/></td>
                        <td hidden="hidden">${customer.tradeAccount}</td>
                        <td>${customer.gid}</td>
                        <td>${customer.clientName}</td>
                        <td>
                                ${fns:getCodeName("COMMON_SEX", customer.sex)}
                        </td>
                        <td>
                                ${fns:getCodeName("AO_ID_KIND", customer.idKind)}
                        </td>
                        <td>${customer.idNo}</td>
                        <td>${fns:getCodeName("SEC_CLIENT_TYPE", customer.clientType)}</td>
                        <td>${customer.sourceChannelName}</td>
                        <td>${customer.idCardAddress}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table>
                <tr>
                    <button class="layui-btn" onclick="addChecked();"><i class="layui-icon">&#xe654;</i>添加</button>
                    <button class="layui-btn " onclick="addAll();"><i class="layui-icon">&#xe654;</i>全部添加</button>
                </tr>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
</body>

<script>
    function addChecked() {
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        var tradeAccounts = "";
        for (var i = 0; i < items.length; i++) {
            if (items[i].checked) {
                ++count;
                tradeAccounts += items[i].parentNode.parentNode.children[1].innerHTML + ",";
            }
        }
        if (count < 1) {
            alert("请选择行！");
            return;
        } else {
            var groupNo = ${groupNo}
                $.ajax({
                    url: "${webRoot}/clientGroupMemberInfo/add",   //处理页面的名称
                    data: {
                        tradeAccounts: tradeAccounts,
                        groupNo: groupNo
                    },  //为值取个名字
                    type: "POST",  //传值方式
                    dataType: "TEXT",  //数据类型
                    success: function (d) {
                        if (d.trim() == "ok") {
                            layer.confirm('添加成功！', {
                                btn: ['是'], btn1: function () {
                                    closeLayer();
                                }
                            })
                        } else if (d.trim() == "error") {
                            layer.confirm('添加失败！', {
                                btn: ['是'], btn1: function () {
                                    closeLayer();
                                }
                            })
                        }
                    }
                })
        }
    }

    function addAll() {
        var groupNo = ${groupNo};
        layer.confirm('确认全部添加吗?', {
            btn: ['是', '否'], btn1: function () {
                $.ajax({
                    url: "${webRoot}/clientGroupMemberInfo/addAll",   //处理页面的名称
                    data: {groupNo: groupNo},  //为值取个名字
                    type: "POST",  //传值方式
                    dataType: "TEXT",  //数据类型
                    success: function (d) {
                        if (d.trim() == "ok") {
                            layer.confirm('添加成功！', {
                                btn: ['是'], btn1: function () {
                                    closeLayer();
                                }
                            })
                        } else if (d.trim() == "error") {
                            layer.confirm('添加失败！', {
                                btn: ['是'], btn1: function () {
                                    closeLayer();
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
    })

    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }
    layui.form.render('select');
</script>

</html>