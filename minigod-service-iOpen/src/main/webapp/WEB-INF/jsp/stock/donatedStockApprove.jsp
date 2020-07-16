<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/mytag" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>增股领取审批</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>
<body>
<div class="col-sm-11" id="main-container">
    <form class="col-sm-12  bv-form" id="accountOpenInfo">
        <%@ include file="donatedStockInfo.jsp" %>
    </form>
</div>


<%@include file="activitiSubAcct.jsp" %>

</br>
</body>
<script>

</script>
</html>

