<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>开户资料详情</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<body>
<div class="col-sm-12" id="main-container">
    <form class="form-horizontal  bv-form" id="accountOpenInfo" style="width:120%;">
        <%@ include file="customerAccOpenInfo.jsp" %>
    </form>
</div>

</body>

</html>
