<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>线下开户资料</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<body>
<div class="col-sm-11" id="main-container">
    <form class="col-sm-12  bv-form" id="accountOpenInfo">
        <%@ include file="custAccOpenInfo.jsp" %>
    </form>
</div>

<c:if test="${flag == 2}">
    <%@include file="activitiSubAcct.jsp" %>
</c:if>
</br>
</body>
<script>

</script>
</html>

