<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <title>客户分组列表</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post"  action="${webRoot}/clientGroupManager/groupList">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:180px;">分组编号:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="groupNo" name="groupNo" value="${clientGroupManagerEntity.groupNo}"  placeholder="请输入分组编号"  class="layui-input" >
                            </div>
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                        <%--<td>
                            <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>
                        </td>--%>
                    </tr>
                </table>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-sm-12" >
            <table id="table-list" name="tableList" class="layui-table" >
                <thead>
                <tr width="99%" >
                    <th style="width: 7%;height: 20px;"><input type="checkbox" /></th>
                    <th>分组编号</th>
                    <th>分组名称</th>
                    <th>分组类型</th>
                    <th>组成员人数</th>
                    <th>分组说明</th>
                    <th>创建人</th>
                </tr>
                </thead>
                <tbody >
                <c:forEach items="${page.result}" var="group" varStatus="i">
                    <tr >
                        <td><input id="id" name="selectFlag" type="checkbox"  value="${group.id}"/></td>
                       <td>${group.groupNo}</td>
                       <td>${group.groupName}</td>
                        <td hidden="hidden" >${group.groupType}</td>
                       <td>
                           ${fns:getCodeName("SEC_GROUP_TYPE",group.groupType)}
                       </td>
                       <td>${group.clientNumber}</td>
                       <td>${group.remark}</td>
                       <td>${group.createUser}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table>
                <tr>
                    <button id="add" class="layui-btn" onclick="addGroup();"><i class="layui-icon" >&#xe654;</i>新增</button>
                    <button id="update" class="layui-btn layui-btn-warm" onclick="updateGroup();"><i class="layui-icon">&#xe642;</i>修改</button>
                    <button class="layui-btn layui-btn-danger" onclick="deleteGroup();"><i class="layui-icon">&#xe640;</i>删除</button>
                    <button id="infoList" class="layui-btn" onclick="groupListInfo();"><i class="layui-icon">&#xe638;</i>成员管理</button>
                </tr>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
</body>

<script>


    /**
     * 客户详情Tab
     */
    function addGroup() {
        var url="${webRoot}/clientGroupManager/addGroup";
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title : ["分组新增" , true],
            area: ['45%', '50%'], //宽高
            content: [url,'no']
        });
    }


    function updateGroup() {
        var item_id;
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        for(var i = 0;i<items.length;i++) {
            if(items[i].checked) {
                ++count;
                item_id = items[i].value;
            }
        }

        if(count<1) {
            alert("请选择行！");
            return;
        } else {
            var url="${webRoot}/clientGroupManager/updateGroup?id="+item_id;
            //弹框层
            layer.open({
                scrollbar: false,
                type: 2,
                title : ["分组新增" , true],
                area: ['45%', '50%'], //宽高
                content: [url,'no']
            });
        }

    }


    function deleteGroup() {
        var item_id;
        var groupNo;
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        for(var i = 0;i<items.length;i++) {
            if(items[i].checked) {
                ++count;
                item_id = items[i].value;
                groupNo = items[i].parentNode.parentNode.children[1].innerHTML;
            }
        }

        if(count<1) {
            alert("请选择行！");
            return;
        } else {
            $.ajax({
                url:"${webRoot}/clientGroupManager/deleteGroup",   //处理页面的名称
                data:{
                    id:item_id,
                    groupNo:groupNo
                },  //为值取个名字
                type:"POST",  //传值方式
                dataType:"TEXT",  //数据类型
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

    function groupListInfo() {
        var groupNo;
        var groupType = 0;
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        for(var i = 0;i<items.length;i++) {
            if(items[i].checked) {
                ++count;
                groupNo = items[i].parentNode.parentNode.children[1].innerHTML;
                groupType += items[i].parentNode.parentNode.children[3].innerHTML;
            }
        }
        if(count<1) {
            alert("请选择行！");
            return;
        } else {
            var url="${webRoot}/clientGroupMemberInfo/list?groupNo="+groupNo+"&groupType="+groupType;
            //弹框层
            layer.open({
                scrollbar: false,
                type: 2,
                title : ["分组成员管理" , true],
                area: ['95%', '90%'], //宽高
                content: [url,'no'],
                shadeClose : false,
                end: function () {
                    location.reload();
                }
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

    $(function(){
        $("#searchSubmit").click(function () {
            var groupNo = $("#groupNo").val();
            if(!isRealNum(groupNo)&&groupNo!=null&&groupNo!=""){
                alert("分组编号必须为数字！")
            }else if(groupNo.length>10){
                alert("编号限定在10位以内");
            }else{
                document.getElementById("search-from").submit();
            }
        });
    })

    function isRealNum(val){
        // isNaN()函数 把空串 空格 以及NUll 按照0来处理 所以先去除
        if(val === "" || val ==null){
            return false;
        }
        if(!isNaN(val)){
            return true;
        }else{
            return false;
        }
    }
    layui.form.render('select');
</script>

</html>