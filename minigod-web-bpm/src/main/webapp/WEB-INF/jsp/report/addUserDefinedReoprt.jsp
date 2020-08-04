<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ taglib prefix="fns" uri="myfus" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>自定义报表新增</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<body>
<div class="col-sm-12" id="main-container">
    <form class="customerList" id="userDefinedForm" style="width: 99%">
        <div id="div0" v-cloak style="margin-top: 20px;margin-bottom: 20px;" >
            <div v-show="!showList" class="panel panel-default">
                <div class="panel-heading"><b style="color: #368763">自定义SQL</b></div>
                </br>
                <br>

                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-xs-2 control-label no-padding-right">重要说明:</label>
                        <div class="col-xs-9">
                           <span class="col-xs-12 block input-icon input-icon-right" style="color: red;font-weight: 700">
                               请尽量在 非 开盘 时间运行！只能执行查询语句！
                            </span>
                        </div>
                    </div>

                </div>


                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-xs-1 control-label no-padding-right"><span
                                style="color: red">*</span>描述:</label>
                        <div class="col-sm-11">
                           <span class="col-xs-6 block input-icon input-icon-right">
                                <input name="defDesc" id="defDesc" type="text" value="${info.defDesc}" class="form-control" placeholder="请输入描述"/>
                            </span>
                            <span style="font-weight: 700">说明：请描述该sql具体查询内容，如：查询每日新增用户数</span>
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-xs-1 control-label no-padding-right"><span
                                style="color: red">*</span>自定义参数:</label>
                        <div class="col-sm-11">
                           <span class="col-xs-6 block input-icon input-icon-right">
                                <input name="params" id="params" type="text" class="form-control" value="${info.params}" placeholder="请输入参数，以|间隔"/>
                            </span>
                            <span style="font-weight: 700">说明：多个参数请使用竖线"|"分割</span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-xs-1 control-label no-padding-right"><span
                                style="color: red">*</span>SQL语句:</label>
                        <div class="col-xs-11">
                       <span class="col-xs-12 block input-icon input-icon-right">
                             <textarea name="defSql" id="defSql" class="form-control" rows="7" style="display:inline;" placeholder="请输入SQL语句">${info.defSql}</textarea>
                        </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-xs-1 control-label no-padding-right"><span
                                style="color: red">*</span>数据列名称:</label>
                        <div class="col-xs-11">
                           <span class="col-xs-6 block input-icon input-icon-right">
                                <input id="defTitle" name="defTitle" type="text" value="${info.defTitle}" class="form-control" placeholder="请输入数据列名称"/>
                            </span>
                            <span style="font-weight: 700">说明：使用竖线"|"分割列名称，比如第一列数据是日期，第二列数据是新用户数，格式：日期|新用户数</span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-xs-1 control-label no-padding-right">备注:</label>
                        <div class="col-xs-11">
                       <span class="col-xs-12 block input-icon input-icon-right" >
                             <textarea name="defRemark" id="defRemark" class="form-control" rows="7" placeholder="请输入备注">${info.defRemark}</textarea>
                        </span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-xs-1 control-label no-padding-right"></label>
                        <div class="col-xs-11">
                            <span class="col-xs-12 block input-icon input-icon-right"  style="font-weight: 700">
                                说明：请描述该sql的具体使用方式，注意事项等，如：查询每日新增用户数，日期可修改
                            </span>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-sm-6 col-md-6">
                        <label class="col-xs-2 control-label no-padding-right"><span
                                style="color: red">*</span>状态</label>
                        <div class="col-xs-9">
                                <span class="col-xs-12 block input-icon input-icon-right">
                                    <tag:select nameKey="STATUS_EFFECTIVE_INVALID" id="isStatus" initSelectedKey="${info.isStatus}" name="isStatus" isAddDefaltOption="true"
                                                clazz="form-control " style="display:inline;"/>
                                </span>
                        </div>
                    </div>

                </div>

                <div class="row" style="margin-top: 10px;margin-bottom: 10px;" align="center">
                    <button id="save" type="button" class="layui-btn ">保存</button>
                    <button id="resetForm" type="reset" class="layui-btn  layui-btn-warm" >重置</button>
                    <button id="goBack" type="button" class="layui-btn layui-btn-primary" >关闭</button>
                </div>

                <div class="row" style="margin-top: 20px;margin-bottom: 20px;margin-right: 45px;" align="right">
                    <button id="run" type="button" class="layui-btn  layui-btn-warm">运行</button>
                    <button id="exportExcel" type="button" class="layui-btn layui-btn-danger"><i class="layui-icon">&#xe601;</i>导出</button>
                </div>

            </div>
        </div>
    </form>


    <form class="layui-form" id="search-from" action="${webRoot}/userDefinedReport/runUserDefinedSQL">
        <input name="defDesc" style="display: none" value="${info.defDesc}" />
        <input name="beginDate" style="display: none" value="${info.beginDate}" />
        <input name="endDate" style="display: none" value="${info.endDate}" />
        <input name="defSql" style="display: none" value="${info.defSql}" />
        <input name="defTitle" style="display: none" value="${info.defTitle}" />
        <input name="defRemark" style="display: none" value="${info.defRemark}" />
        <input name="isStatus" style="display: none" value="${info.isStatus}" />
        <input name="flag" style="display: none" value="${flag}" />
    </form>
    <div class="row" style="width: 99%;margin-left: 3px;">
        <table id="table-list" class="layui-table">
            <thead>
            <tr>
                <c:forEach var="info" items="${fileTiltList}" varStatus="i">
                    <th >${info}</th>
                </c:forEach>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="info" items="${page.result}" varStatus="i">
                <tr id="log_${i.index }">
                    <c:forEach items="${info}" var="entry">
                        <th>${entry.value}</th>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <sys:page page="${page}"></sys:page>
    </div>

</div>

</body>
<script>


    /**
     * 保存
     */
    $("#save").click(function () {

        var defDesc = $("#defDesc").val();
        if (defDesc ==null || defDesc ==''){
            alertMsg("描述不可为空!");
            return;
        }

        var defSql = $("#defSql").val();
        if (defSql == null || defSql ==''){
            alertMsg("SQL语句不能为空!");
            return
        }

        var defTitle =  $("#defTitle").val();
        if (defTitle == null || defTitle ==''){
            alertMsg("数据列名称不能为空!");
            return
        }

        var isStatus = $("#isStatus").val();
        if (isStatus == null || isStatus ==''){
            alertMsg("状态不能为空!");
            return
        }

        if(defSql.toLowerCase().indexOf("update") != -1 || defSql.toLowerCase().indexOf("insert") != -1 || defSql.toLowerCase().indexOf("delete") != -1){
            alertMsg("SQL语句不能含insert或update或delete语句");
            return
        }

        $.ajax({
            url: "${webRoot}/userDefinedReport/save",
            data: $('#userDefinedForm').serialize(), //为值取个名字*/
            type: "POST",  //传值方式
            dataType: "text",
            success: function (d) {
                if (d.trim() == "ok") {
                    //刷新父窗口列表
                    parent.location.reload();
                    //关闭弹框
                    closeThisWindow();
                } else{
                    alertMsg(d.msg);
                }
            }
        })
    });

    /**
     * 运行
     */
    $("#run").click(function () {
        var beginDate = $("#beginDate").val();
        var endDate = $("#endDate").val();

        var defSql = $("#defSql").val();
        if (defSql == null || defSql ==''){
            alertMsg("SQL语句不能为空!");
            return
        }

        var defTitle =$("#defTitle").val();
        if (defTitle == null || defTitle ==''){
            alertMsg("数据列名称不能为空!");
            return
        }

        if(defSql.toLowerCase().indexOf("update") != -1 || defSql.toLowerCase().indexOf("insert") != -1 || defSql.toLowerCase().indexOf("delete") != -1){
            alertMsg("SQL语句不能含insert或update或delete语句");
            return
        }

        var  userDefined =$('#userDefinedForm').serialize();
        window.location.href = '${webRoot}/userDefinedReport/runUserDefinedSQL?userDefinedSql=&' +userDefined+"&flag=1";

    });

    /**
     * 导出excel
     */
    $("#exportExcel").click(function () {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#exportExcel').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#exportExcel").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var  userDefined =$('#userDefinedForm').serialize();
        var defSql = $("#defSql").val();
        if (defSql.toLowerCase().indexOf("insert") !=-1 || defSql.toLowerCase().indexOf("update") != -1 ||  defSql.toLowerCase().indexOf("delete") != -1){
            alertMsg("SQL语句不能含insert或update或delete语句");
            return
        }
        window.location.href = '${webRoot}/userDefinedReport/userDefinedExpExcel?userDefined=&' +userDefined;
    });

    $("#goBack").click(function () {
        closeLayer();
    });

    $("#resetForm").click(function () {
        location.reload();
    });

    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }

    layui.form.render('select');

    layui.laydate.render({
        elem: '#beginDate' //指定元素
    });
    layui.laydate.render({
        elem: '#endDate' //指定元素
    });


</script>

</html>
