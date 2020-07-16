<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>营销人员管理</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="row" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post" action="${webRoot}/companyBusinessPersonnel/list">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 100px">员工姓名:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="personnelName" value="${model.personnelName}"
                                       placeholder="员工姓名"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:100px;">员工角色：</label>
                            <div class="layui-input-inline">
                                <tag:select id="personnelRole" name="personnelRole" nameKey="SEC_PERSONNEL_ROLE"
                                            initSelectedKey="${model.personnelRole}"
                                            isAddDefaltOption="true"/>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 180px"></span>性别：</label>
                            <div class="layui-input-inline">
                                <tag:select name="sex" id="sex" nameKey="COMMON_SEX" isAddDefaltOption="true"
                                            initSelectedKey="${model.sex}"/>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">学历：</label>
                            <div class="layui-input-inline">
                                <tag:select id="educationType" name="educationType" nameKey="SEC_EDUCATION_TYPE"
                                            initSelectedKey="${model.educationType}" isAddDefaltOption="true"
                                            clazz="form-control"/>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">员工状态：</label>
                            <div class="layui-input-inline">
                                <select id="personnelStatus" name="personnelStatus">
                                    <option value="">请选择</option>
                                    <option <c:if test="${model.personnelStatus=='0'}"> selected</c:if> value="0">删除
                                    </option>
                                    <option <c:if test="${model.personnelStatus=='1'}"> selected</c:if> value="1">正常
                                    </option>
                                    <option <c:if test="${model.personnelStatus=='2'}"> selected</c:if> value="2">禁用
                                    </option>
                                    <option <c:if test="${model.personnelStatus=='3'}"> selected</c:if> value="3">离职
                                    </option>
                                    <c:if test="${model.personnelRole!='0'}">
                                        <option <c:if test="${model.personnelStatus=='4'}"> selected</c:if> value="4">
                                            待审核
                                        </option>
                                        <option <c:if test="${model.personnelStatus=='5'}"> selected</c:if> value="5">
                                            审核不通过
                                        </option>
                                    </c:if>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 100px">证件类型：</label>
                            <div class="layui-input-inline">
                                <tag:select id="idType" name="idType" nameKey="SEC_ID_TYPE"
                                            initSelectedKey="${model.idType}" isAddDefaltOption="true"
                                            clazz="form-control"/>
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">证件号：</label>
                            <div class="layui-input-inline">
                                <input type="text" id="idNo" name="idNo" value="${model.idNo}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 180px">证券从业资格证编号：</label>
                            <div class="layui-input-inline">
                                <input type="text" id="sacNo" name="sacNo" value="${model.sacNo}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">创建人：</label>
                            <div class="layui-input-inline">
                                <input type="text" id="createUser" name="createUser" value="${model.createUser}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">移动电话：</label>
                            <div class="layui-input-inline">
                                <input type="text" id="mobilePhone" name="mobilePhone" value="${model.mobilePhone}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width: 100px">电子邮箱：</label>
                            <div class="layui-input-inline">
                                <input type="text" id="email" name="email" value="${model.email}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 100px">邀约码：</label>
                            <div class="layui-input-inline">
                                <input type="text" id="aeCode" name="aeCode" value="${model.aeCode}"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width: 180px">见证资格证编号：</label>
                            <div class="layui-input-inline">
                                <input type="text" id="witnessNo" name="witnessNo" value="${model.witnessNo}"
                                       class="form-control">
                            </div>
                        </td>
                        <td style="align-items: center">
                            <label class="layui-form-label" style="width: 120px"></label>
                            <div class="layui-input-inline">
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜索
                                </button>&nbsp;&nbsp;&nbsp;
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>

                            </div>
                        </td>
                        <td>

                            <shiro:hasPermission name="companyBusinessPersonnel:exp">
                                <button class="layui-btn layui-btn-danger" type="button" id="export"
                                        onclick="exportExcel()"><i class="layui-icon">&#xe601;</i>导 出
                                </button>
                            </shiro:hasPermission>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
    <table id="tableList" lay-filter="table_list" class="layui-table">
        <thead>
        <tr width="99%">
            <th lay-data="{type:'checkbox',unresize:true,fixed:'left'}"></th>
            <th lay-data="{field:'userId',fixed:'left'}">操作</th>
            <th lay-data="{field:'id',hide:true}" hidden="true">id</th>
            <th lay-data="{field:'personnelName'}">员工姓名</th>
            <th lay-data="{field:'personnelRole'}">员工角色</th>
            <th lay-data="{field:'sex',minWidth:'60'}">性别</th>
            <th lay-data="{field:'educationType',width:'70'}">学历</th>
            <th lay-data="{field:'personnelStatus'}">员工状态</th>
            <th lay-data="{field:'birthdayDate'}">出生日期</th>
            <th lay-data="{field:'idType'}">证件类型</th>
            <th lay-data="{field:'idNo',width:'200'}">证件号码</th>
            <th lay-data="{field:'jobPosition'}">职位</th>
            <th lay-data="{field:'sacNo',minWidth:'160'}">证券从业资格证编号</th>
            <th lay-data="{field:'witnessNo',minWidth:'160'}">见证资格证编号</th>
            <th lay-data="{field:'officePhone'}">办公电话</th>
            <th lay-data="{field:'mobilePhone'}">移动电话</th>
            <th lay-data="{field:'homePhone'}">家庭电话</th>
            <th lay-data="{field:'faxPhone'}">传真电话</th>
            <th lay-data="{field:'contactAddress',width:'300'}">联系地址</th>
            <th lay-data="{field:'postCode'}">邮编号码</th>
            <th lay-data="{field:'email',minWidth:'160'}">电子邮件</th>
            <th lay-data="{field:'aeCode'}">邀约码</th>
            <th lay-data="{field:'createUser'}">创建人</th>
            <th lay-data="{field:'createTime',minWidth:'160'}">创建时间</th>
            <th lay-data="{field:'modifyUser'}">修改人</th>
            <th lay-data="{field:'updateTime',minWidth:'160'}">修改时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="info" varStatus="i">
            <tr name="info_${info.id }">
                <td></td>
                <td>
                    <c:choose>
                        <c:when test="${info.personnelStatus != '0'}">
                            <button class="layui-btn layui-btn-small" type="button"
                                    onclick="doDetail('${info.id}')">
                                <i class="layui-icon">&#xe60a;</i>详细信息
                            </button>
                        </c:when>
                        <c:when test="${info.personnelStatus == '0'}">
                            <button class="layui-btn-small layui-btn-disabled" type="button"
                                    onclick="detailDelete('${info.id}')" disabled="disabled">
                                <i class="layui-icon">&#xe60a;</i>已经删除
                            </button>
                        </c:when>
                    </c:choose>
                </td>
                <td hidden=" true">${info.id}</td>
                <td>${info.personnelName}</td>
                <td>${fns:getCodeName("SEC_PERSONNEL_ROLE",info.personnelRole )}</td>
                <td>${fns:getCodeName("COMMON_SEX",info.sex )}</td>
                <td>${fns:getCodeName("SEC_EDUCATION_TYPE",info.educationType )}</td>
                <td>${fns:getCodeName("SEC_PERSONNEL_STATUS",info.personnelStatus )}</td>
                <td>${info.birthdayDate}</td>
                <td>${fns:getCodeName("SEC_ID_TYPE",info.idType )}</td>
                <td>${info.idNo}</td>
                <td>${info.jobPosition}</td>
                <td>${info.sacNo}</td>
                <td>${info.witnessNo}</td>
                <td>${info.officePhone}</td>
                <td>${info.mobilePhone}</td>
                <td>${info.homePhone}</td>
                <td>${info.faxPhone}</td>
                <td>${info.contactAddress}</td>
                <td>${info.postCode}</td>
                <td>${info.email}</td>
                <td>${info.aeCode}</td>
                <td>${info.createUser}</td>
                <td>${info.createTime}</td>
                <td>${info.modifyUser}</td>
                <td>${info.updateTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" class="layui-btn" onclick="addcomPerson();"><i class="layui-icon">&#xe654;</i>新增
    </button>
    <button type="button" class="layui-btn" onclick="updateDetail();"><i class="layui-icon">&#xe642;</i>修改
    </button>
    <button type="button" class="layui-btn layui-btn-danger" onclick="deleteById();"><i class="layui-icon">&#xe640;</i>删除
    </button>
    <sys:page page="${page}"></sys:page>
</div>
</div>
</div>
</body>

<script>
    var id = [];
    $(function () {
        layui.use('table', function () {
            var table = layui.table;

            table.init('table_list', { //转化静态表格
                cellMinWidth: 120,
                limit:${page.pageSize}
                , text: {
                    none: '暂无相关数据' //默认：无数据
                }
            });

            table.on('checkbox(table_list)', function (obj) {
                var checkStatus = table.checkStatus('tableList');
                var data = checkStatus.data;
                id = [];
                for (var i = 0; i < data.length; i++) {    //循环筛选出id
                    id.push(data[i].id.trim());
                }
            });

        });
    });

    /**
     * 客户详情Tab
     */
    function doDetail(id) {
        var url = "${webRoot}/companyBusinessPersonnel/info?flag='info'&id=" + id;
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["业务人员信息", true],
            area: ['60%', '72%'], //宽高
            content: [url, 'no'],
            shadeClose: false,
        });
    }

    function updateDetail() {
        if (id.toString() == "") {
            alert("请选择行！");
            return;
        } else if (id.length > 1) {
            alert("只能选择一行！");
        } else {
            var url = "${webRoot}/companyBusinessPersonnel/info?id=" + id;
            //弹框层
            layer.open({
                scrollbar: false,
                type: 2,
                title: ["业务人员修改", true],
                area: ['60%', '72%'], //宽高
                content: [url, 'no'],
                shadeClose: false,
            });
        }
    }

    function detailDelete() {
        layer.confirm('该记录已删除！', {
            btn: ['是'], btn1: function (index) {
                $('input:checkbox').removeAttr('checked');
                layer.close(index);
            }
        })
    }

    function addcomPerson() {
        var url = "${webRoot}/companyBusinessPersonnel/info";
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["业务人员新增", true],
            area: ['60%', '72%'], //宽高
            content: [url, 'no'],
            shadeClose: false,
        });
    }

    function deleteById() {
        if (id.toString() == "") {
            alert("请选择行！");
            return;
        } else {
            layer.confirm('确认删除记录吗?', {
                btn: ['是', '否'], btn1: function () {
                    $.ajax({
                        url: "${webRoot}/companyBusinessPersonnel/delete",   //处理页面的名称
                        data: {ids: id.toString()},  //为值取个名字
                        type: "POST",  //传值方式
                        dataType: "TEXT",  //数据类型
                        success: function (d) {
                            if (d.trim() == "ok") {
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
                        }
                    })
                },
                btn2: function (index) {
                    layer.close(index);
                }
            })
        }
    }


    function closeLayer() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        window.parent.location.reload();
    }

    $(function () {
        $("#table-list tr:gt(0)").click(function () {
            if ("删除" != trim($(this).children("td").eq(7).text())) {
                console.log($(this).find(":checkbox").prop("checked"));
                if ($(this).find(":checkbox").is(':checked')) {
                    $(this).find(":checkbox").prop("checked", false);
                } else {
                    $(this).find(":checkbox").prop("checked", true);
                }
            }
        });
    });


//    $(function () {
//        $("#checkAll").click(function () {
//            $("input[name='selectFlag']").prop("checked", $(this).prop("checked"));
//        });
//    });

    function trim(s) {
        return s.replace(/(^\s*)|(\s*$)/g, "");
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
        window.location.href = '${webRoot}/companyBusinessPersonnel/comBusExpExcel?info=&' + obj;
    }

    layui.form.render('select');
</script>

</html>