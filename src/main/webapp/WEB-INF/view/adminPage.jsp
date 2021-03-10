<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 3/3/19
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminListStyle.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/baseStyle.css">
</head>
<body>
<form action="${contextPath}/admin/addClient">
    <button type="submit">Add new client</button>
</form>
<form action="${contextPath}/admin/addHospitalCard">
    <button type="submit">Add new hospital card</button>
</form>
</body>
</html>
