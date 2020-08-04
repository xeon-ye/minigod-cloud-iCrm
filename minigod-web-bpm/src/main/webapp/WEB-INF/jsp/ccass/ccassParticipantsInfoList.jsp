<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>CCASS参与者信息列表</title>
</head>

<body>
<div class="main-container" id="main-container">
    <div class="" style="margin-top: 20px;">
        <form class="layui-form" id="search-from" method="post"
              action="${webRoot}/ccassParticipants/getCcassParticiInfoList">
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:130px">CCASS编号:</label>
                            <div class="col-xs-7">
                                <input type="text" name="ccassId" value="${params.ccassId}" placeholder="请输入CCASS编号"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:160px">参与者英文名:</label>
                            <div class="col-xs-7">
                                <input type="text" name="ccassNameEn" value="${params.ccassNameEn}"
                                       placeholder="请输入参与者英文名"
                                       class="form-control">
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:160px">参与者中文名:</label>
                            <div class="col-xs-7">
                                <input type="text" name="ccassNameTc" value="${params.ccassNameTc}"
                                       placeholder="请输入参与者中文名"
                                       class="form-control">
                            </div>
                        </td>
                        <%--<td>--%>
                        <%--<label class="layui-form-label" style="width:130px">外部编号:</label>--%>
                        <%--<div class="col-xs-7">--%>
                        <%--<input type="text" name="partId" value="${params.partId}" placeholder="请输入外部编号"--%>
                        <%--class="form-control">--%>
                        <%--</div>--%>
                        <%--</td>--%>
                        <td>&nbsp;&nbsp;&nbsp;
                            <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                            <button class="layui-btn layui-btn-warm" type="button" id="refresh"><i class="layui-icon">&#x1002;</i>重
                                置
                            </button>

                            <shiro:hasPermission name="ccassParticiInfoListExpExcel:exp">
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
    <div class="row">
        <div class="col-xs-12" style="width:99%">
            <table id="table-list" class="layui-table">
                <thead>
                <tr width="99%">
                    <th>序号</th>
                    <th>操作</th>
                    <th>CCASS编号</th>
                    <th>参与者英文名</th>
                    <th>参与者中文名</th>
                    <%--<th>外部编号</th>--%>
                    <th>创建时间</th>
                    <th>更新时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="ccassParticiInfoList" varStatus="i">
                    <tr name="ccassParticiInfo_${ccassParticiInfoList.id }">
                        <td>${i.index+1 }</td>
                        <td>
                            <button class="layui-btn layui-btn-small" type="button"
                                    onclick="getHoldingsDetail('${ccassParticiInfoList.id}','${ccassParticiInfoList.ccassNameEn}');">
                                <i class="layui-icon">&#xe60a;</i>持仓信息
                            </button>
                        </td>
                        <td>${ccassParticiInfoList.ccassId}</td>
                        <td>${ccassParticiInfoList.ccassNameEn}</td>
                        <td>${ccassParticiInfoList.ccassNameTc}</td>
                            <%--<td>${ccassParticiInfoList.partId}</td>--%>
                        <td>${ccassParticiInfoList.createTime}</td>
                        <td>${ccassParticiInfoList.updateTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
</body>

<script>

    // 导出excel
    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
//        layer.alert(obj);
        window.location.href = '${webRoot}/ccassParticipants/ccassParticiInfoListExpExcel?ccassParticipantsEntity=&' + obj;
    }

    function getHoldingsDetail(participantId, ccassNameEn) {
        var url = "${webRoot}/ccassHoldings/getCcassHoldingsInfoList?participantId=" + participantId;

        layer.open({
            scrollbar: false,
            type: 2,
            title: ["[" + ccassNameEn + "]&nbsp;持仓信息汇总", true],
            area: ['95%', '90%'], //宽高
            content: [url, 'no'],
            shadeClose: false,
            end: function () {
                location.reload();
            }
        });
    }

</script>

</html>