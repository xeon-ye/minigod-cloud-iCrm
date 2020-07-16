<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>开户资料</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<body>
<div class="col-sm-11" id="main-container">
    <form class="col-sm-12  bv-form" id="accountOpenInfo">
        <%@ include file="customerAccOpenInfo.jsp" %>
    </form>
</div>

<c:if test="${flag == 2}">
    <%@include file="processComSubAcct.jsp" %>
</c:if>
<%--<%@include file="../../activiti/processComSubAcct.jsp" %>--%>
</br>
</body>
<script>

//    /**
//     * 查看开户图片
//     */
//    function showFlowImg(instanceId) {
//        var url = webRoot + "/customer/downloadImage?imageFullPath=" + instanceId;
//        var html = "<img src ='" + url + "'/>";
//        //弹框层
//        layer.open({
//            type: 1,
//            area: ['70%', '70%'], //宽高
//            content: html,
//            title: ['查看流程图', true],
//            shadeClose: true, //开启遮罩关闭
//        });
//    }
</script>
</html>
