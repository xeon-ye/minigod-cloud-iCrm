<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>审批范围选择框</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px; margin-left: 20px">
        <form class="layui-form" id="search-from" method="post" action="${webRoot}/userDefinedReport/toAuthTab?sqlId=${sqlId}">
            <div class="layui-form-item">
                <label class="layui-form-label" style="width:7%;">类型：</label>
                <div class="layui-input-inline">
                    <tag:select nameKey="act_user_type" otherAttr="lay-filter='searchFilter'" name="type"
                                initSelectedKey="${type}"/>
                </div>
                <label class="layui-form-label" style="width:8%;">搜索框：</label>
                <div class="layui-input-inline layui-input-inline">
                    <input type="text" name="name" value="${userWindow.name }" placeholder="请输入标题" class="layui-input">
                </div>
                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>
                <button class="layui-btn" type="button" id="submitBtn">确 定</button>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <div class="row">
                <div class="col-xs-12">
                    <table id="table-list" class="layui-table">
                        <thead>
                        <tr>
                            <th>选择</th>
                            <th>类型</th>
                            <th>名称</th>
                            <th>归属</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="dto" items="${page.result }" varStatus="i">
                            <tr id="dto_${dto.id }">
                                <td><input type="checkbox" value="${dto.id}"></td>
                                <td>${fns:getCodeName("act_examine_type",type)} </td>
                                <td>${dto.name }</td>
                                <td>${dto.bapName }</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <sys:page page="${page}"></sys:page>
            </div>
        </div>
    </div>
</div>
</body>
<script>

    //td checkBox事件
    $("#table-list tbody tr").off("click").click(function (e) {
        var tag = e.target.tagName;
        if (tag == "INPUT") {
            return;
        }
        var isCheck = $(this).find(":checkbox").is(":checked");
        if (isCheck) {
            $(this).find(":checkbox").prop("checked", false);
        } else {
            $(this).find(":checkbox").prop("checked", true);
        }
    });

    /**
     * 切换用户类型select事件
     */
    layui.use(['form'], function () {
        var form = layui.form;
        form.on('select(searchFilter)', function (data) {
            $("#search-from").submit();
        });
    });


    //确定选择
    $("#submitBtn").click(function () {

        var userIds = "";

        $("#table-list tbody input:checkbox:checked").each(function () {
            userIds += $(this).val() + "|";
        });

        if (userIds.length > 1) {
            userIds = userIds.substring(0, userIds.length - 1);
        }

        if (userIds == null || userIds ==''){
            alertMsg("请选择用户");
            return
        }

        confirm("确定执行此操作吗？", function () {
            var url = "${webRoot}/userDefinedReport/auth";
            var params = {
                'userIds': userIds,
                'sqlId': '${sqlId}'
            };
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    toast(result, function () {
                        //刷新父窗口列表
                        parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    })
                } else {
                    alertMsg(result.msg);
                }
            }, "json");
        });
    });

</script>
</html>