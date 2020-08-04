<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>分组修改页面</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post"  action="${webRoot}/clientGroupMemberInfo/updateInit">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td hidden="hidden"><input type="text" name="ids" value="${ids}"  ></td>
                        <td>
                            <label class="layui-form-label" style="width:180px;">分组编号:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="groupNo" name="groupNo" value="${groupNo}"  placeholder="请输入分组编号"  class="layui-input" >
                            </div>
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
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
                       <td>${group.clientNumber}</td>
                       <td>${group.remark}</td>
                       <td>${group.createUser}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table>
                <tr style="align-content: center">
                    <button id="confirmButton" class="layui-btn" ><i class="layui-icon" ></i>确认</button>
                </tr>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
</body>

<script>

    $(function(){
        $("#confirmButton").click(function () {
            var groupNo;
            var items = document.getElementsByName("selectFlag");
            var count = 0;
            var tradeAccounts ;
            for(var i = 0;i<items.length;i++) {
                if(items[i].checked) {
                    ++count;
                    groupNo = items[i].parentNode.parentNode.children[1].innerHTML;
                }
            }

            tradeAccounts = "${tradeAccounts}";
            if(count<1) {
                alert("请选择行！");
                return;
            }else {
                layer.confirm('确认调整吗?', { btn: ['是','否'],btn1: function(){
                    $.ajax({
                        url:"${webRoot}/clientGroupMemberInfo/update",   //处理页面的名称
                        data:{
                            tradeAccounts:tradeAccounts,
                            groupNo:groupNo
                        },  //为值取个名字
                        type:"POST",  //传值方式
                        dataType:"text",  //数据类型
                        success: function(d){
                            if (d.trim() == "ok") {
                                layer.confirm('调整成功！', {
                                    btn: ['是'], btn1: function () {
                                        closeLayer();
                                    }
                                })
                            } else if (d.trim() == "error") {
                                layer.confirm('调整失败！', {
                                    btn: ['是'], btn1: function () {
                                        closeLayer();
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
        })
    })

    $(function () {
        $("#table-list tr:gt(0)").click(function () {
            console.log($(this).find(":checkbox").prop("checked"))
            $("tr").find(":checkbox").prop("checked", false);
            $(this).find(":checkbox").prop("checked", true);
            $("tr").removeClass();
            $(this).toggleClass('red');
        });
    })

    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }

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