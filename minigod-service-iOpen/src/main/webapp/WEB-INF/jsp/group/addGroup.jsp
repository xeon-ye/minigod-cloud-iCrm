<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<div id="div0" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <div class="panel-heading"><b style="color: #368763">新增客户分组</b></div>
        </br>

        <div class="row">
            <form class="layui-form" id="search-from" method="post" action="">
                <table class="layui-table">
                        <tr>
                            <td>
                                <label class="col-sm-3 control-label no-padding-right">分组编号：</label>
                                <div class="col-xs-9">
                                    <span class="col-xs-8 block input-icon input-icon-right">
                                         <input id="groupNo" name="groupNo" type="text"
                                                class="form-control" placeholder="请输入分组编号"
                                                />
                                    </span>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="col-sm-3 control-label no-padding-right">分组名称：</label>
                                <div class="col-xs-9">
                                    <span class="col-xs-8 block input-icon input-icon-right">
                                         <input id="groupName" name="groupName" type="text"
                                                class="form-control" placeholder="请输入分组名称"
                                                />
                                    </span>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="col-sm-3 control-label no-padding-right">分组类型：</label>
                                <div class="col-xs-9">
                                    <span class="col-xs-8 block input-icon input-icon-right">
                                        <tag:select id="groupType" name="groupType" nameKey="SEC_GROUP_TYPE" isAddDefaltOption="true"></tag:select>
                                    </span>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="col-sm-3 control-label no-padding-right">分组说明：</label>
                                <div class="col-xs-9">
                                    <span class="col-xs-8 block input-icon input-icon-right">
                                        <textarea id="remark" name="remark" type="textarea"  class="form-control" style="text-align:left; resize: none;" >${info.remark}</textarea>
                                    </span>
                                </div>
                            </td>
                        </tr>
                    <tr>
                            <td align="center">
                                <input  id="formSubmit" type="button" class="layui-btn " value="提交" onclick="save();">
                            </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<script>

function save() {

    if($("#groupNo").val()==""){
        alert("分组编号不能为空！");
    }else if($("#groupName").val()==""){
        alert("分组名称不能为空！");
    }
    else if($("#groupType").val()==""){
        alert("分组类型必选！");
    }else{
        checkGroupNo();
    }
}

function checkGroupNo(){
    var groupNo = $("#groupNo").val();
    $.ajax({
        url:"${webRoot}/clientGroupManager/queryByGroupNo",   //处理页面的名称
        data:{
            groupNo:groupNo
        },  //为值取个名字
        type:"POST",  //传值方式
        dataType:"text",  //数据类型
        success: function(d){
            if(d.trim()=="exist"){
                layer.alert("该分组编号已存在！")
            }
            else{
                checkGroupName();
            }
        }
    })
}

function checkGroupName(){
    var groupNo = $("#groupNo").val();
    var groupName = $("#groupName").val();
    var remark = $("#remark").val();
    var groupType = $("#groupType").val();
    $.ajax({
        url:"${webRoot}/clientGroupManager/queryByGroupName",   //处理页面的名称
        data:{
            groupName:groupName
        },  //为值取个名字
        type:"POST",  //传值方式
        dataType:"text",  //数据类型
        success: function(d){
            if(d.trim()=="exist"){
                layer.alert("该分组名称已存在！")
            }
            else{
                $.ajax({
                    url:"${webRoot}/clientGroupManager/save",   //处理页面的名称
                    data:{
                        groupNo:groupNo,
                        groupName:groupName,
                        groupType:groupType,
                        remark:remark
                    },  //为值取个名字
                    type:"POST",  //传值方式
                    dataType:"text",  //数据类型
                    success: function(d){
                        if(d.trim()=="ok"){
                            layer.confirm('保存成功！', { btn: ['是'],btn1: function(){
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);
                                window.parent.location.reload();
                            }
                            })
                        }else if(d.trim()=="error"){
                            layer.confirm('保存失败！', { btn: ['是'],btn1: function(){
                                location.reload();
                            }
                            })
                        }
                    }
                })
            }
        }
    })
}
layui.form.render('select');
</script>
</body>
</html>
