<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <title>分组成员列表</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" action="${webRoot}/clientGroupMemberInfo/list">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td hidden="hidden"><input  name="groupNo" value="${groupNo}"  class="layui-input" > </td>
                        <td hidden="hidden"><input  name="groupType" value="${groupType}"  class="layui-input" > </td>

                        <td>
                            <label class="layui-form-label " style="width:120px;">客户编号:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="gid" name="gid" value="${ClientGroupMemberInfoEntity.gid}"  placeholder="请输入客户编号"  class="layui-input" >
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:120px;">客户姓名:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="clientName" name="clientName" value="${ClientGroupMemberInfoEntity.clientName}"  placeholder="请输入客户姓名"  class="layui-input" >
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:120px;">渠道号:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="sourceChannelId" name="sourceChannelId" value="${ClientGroupMemberInfoEntity.sourceChannelId}"  placeholder="请输入渠道号"  class="layui-input" >
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:120px;">渠道:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="channelName" name="sourceChannelName" class="form-control" style="cursor:pointer;" onclick="menuTree();" readonly="readonly" value="${ClientGroupMemberInfoEntity.sourceChannelName}" placeholder="请选择渠道"/>
                                <input hidden type="text" id="checkedChannelId" name="checkedChannelId" value="${ClientGroupMemberInfoEntity.checkedChannelId}"/>
                            </div>
                        </td>


                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:120px;">性别:</label>
                            <div class="layui-input-inline">
                                <tag:select id="sex" name="sex" nameKey="COMMON_SEX" isAddDefaltOption="true" clazz="layui-input-inline"
                                            initSelectedKey="${ClientGroupMemberInfoEntity.sex}"></tag:select>
                            </div>
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;&nbsp;<button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>

                </table>

            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-sm-12" >
            <table id="table-list" name="tableList" class="layui-table col-xs-12 right" >
                <thead>
                <tr width="99%" >
                    <th style="width: 10%;height: 20px;">
                        <input id="checkAll" type="checkbox" />
                    </th>
                    <th>客户编号</th>
                    <th>客户姓名</th>
                    <th>渠道</th>
                    <th>客户类型</th>
                    <th>客户状态</th>
                    <th>开户日期</th>
                    <th>出生日期</th>
                    <th>性别    </th>
                </tr>
                </thead>
                <tbody >
                <c:forEach items="${page.result}" var="info" varStatus="i">
                    <tr >
                        <td><input id="id" name="selectFlag" type="checkbox"  value="${info.id}"/></td>
                       <td>${info.gid}</td>
                       <td>${info.clientName}</td>
                       <td>${info.sourceChannelName}</td>
                        <td hidden="hidden">${info.tradeAccount}</td>
                       <td>
                           ${fns:getCodeName("SEC_CLIENT_TYPE", info.clientType)}
                       </td>
                        <td>
                            ${fns:getCodeName("SEC_CLIENT_STATUS",info.clientStatus)}
                        </td>
                       <td>${info.openAccountTime}</td>
                        <td>
                                ${info.birthday}
                        </td>
                       <td>
                           ${fns:getCodeName("COMMON_SEX",info.sex)}
                       </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table>
                <tr>
                    <button id="add" class="layui-btn" onclick="addGroup();"><i class="layui-icon" >&#xe654;</i>新增</button>
                    <button class="layui-btn layui-btn-danger" onclick="deleteChecked();"><i class="layui-icon">&#xe640;</i>删除</button>
                    <button class="layui-btn layui-btn-danger" onclick="deleteAll();"><i class="layui-icon">&#xe640;</i>全部删除</button>
                    <button class="layui-btn layui-btn-warm" onclick="updateChecked();"><i class="layui-icon">&#xe640;</i>批量调整</button>
                    <shiro:hasPermission name="securitiesUserInfo:crmExp">
                        <button class="layui-btn layui-btn-danger" type="button" id="export"
                                onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                        </button>
                    </shiro:hasPermission>
                    <button id="infoList" class="layui-btn" onclick="closeLayer();"><i class="layui-icon">&#xe638;</i>取消</button>
                </tr>
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
<script src="${webRoot}/js/channel/channel.js"></script>
<script>
    /**
     * 添加分组
     */
    function addGroup() {
        var url="${webRoot}/clientGroupMemberInfo/addCustomerList?groupNo="+${groupNo};
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title : ["分组新增" , true],
            area: ['95%', '90%'], //宽高
            content: [url,'yes'],
            shadeClose : false,
        });
    }

    /**
     * 删除选中的分组
     */
    function deleteChecked() {
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        var item_id = "";
        for(var i = 0;i<items.length;i++) {
            if(items[i].checked) {
                ++count;
                item_id+=items[i].value+",";
            }
        }
        if(count<1) {
            alert("请选择行！");
            return;
        } else {
            $.ajax({
                url:"${webRoot}/clientGroupMemberInfo/delete",   //处理页面的名称
                data:{ids:item_id},  //为值取个名字
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

    /**
     * 删除全部分组
     */
    function deleteAll() {
        var groupNo = ${groupNo};
        layer.confirm('确认全部删除吗?', { btn: ['是','否'],btn1: function(){
            $.ajax({
                url:"${webRoot}/clientGroupMemberInfo/deleteAll",   //处理页面的名称
                data:{groupNo:groupNo},  //为值取个名字
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
        },
            btn2: function(){
                alert("取消成功");
            }
        })
    }

    /**
     * 批量调整
     */

    function updateChecked() {
        var tradeAccounts = "";
        var items = document.getElementsByName("selectFlag");
        var count = 0;
        for(var i = 0;i<items.length;i++) {
            if(items[i].checked) {
                ++count;
                tradeAccounts += items[i].parentNode.parentNode.children[3].innerHTML+",";
            }
        }
        tradeAccounts = tradeAccounts.substring(0,tradeAccounts.length-1);
        if(count<1) {
            alert("请选择行！");
            return;
        } else {
            var url="${webRoot}/clientGroupMemberInfo/updateInit?tradeAccounts="+tradeAccounts;
            //弹框层
            layer.open({
                scrollbar: false,
                type: 2,
                title : ["分组成员管理" , true],
                area: ['95%', '90%'], //宽高
                content: [url,'no'],
                shadeClose : false
            });
        }
    }

    /**
     * 关闭本页面刷新父页面
     */
    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }

    /**
     * 选中事件
     */
    $(function () {
        $("#table-list tr:gt(0)").click(function () {
            console.log($(this).find(":checkbox").prop("checked"))
                if ( $(this).find(":checkbox").is(':checked')){
                    $(this).find(":checkbox").prop("checked", false);
                }else{
                    $(this).find(":checkbox").prop("checked", true);
                }
        });
    })
    /**
     * 全选事件
     */
    $(function(){
        $("#checkAll").click(function(){
            $("input[name='selectFlag']").prop("checked",$(this).prop("checked"));
        });
    });

    /**
     * layer open end回调事件
     */
    end: function  cls() {
        window.parent.location.reload();
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
        window.location.href = '${webRoot}/clientGroupMemberInfo/clientGroupExpExcel?info=&' + obj;
    }
    layui.form.render('select');
</script>

</html>