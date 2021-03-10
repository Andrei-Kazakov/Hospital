<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 3/4/19
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/headerStyle.css">
</head>
<body>
<div class="header">
    <c:if test="${not empty sessionScope.login}">
        <h2>Hello, ${sessionScope.login}</h2>
    </c:if>

    <div class="header-right">
        <c:choose>
            <c:when test="${sessionScope.role=='admin'}">
                <a href="${contextPath}/admin/page" class="active">Home page</a>
                <a href="${contextPath}/admin/doctors">View Doctors</a>
                <a href="${contextPath}/admin/patients">View Patients</a>
                <a href="${contextPath}/admin/hospitalCard">View Hospital cards</a>
            </c:when>
            <c:when test="${sessionScope.role=='nurse' || sessionScope.role=='doctor'}">
                <a href="${contextPath}/staff/patients" class="active">View Patients</a>
                <a href="${contextPath}/staff/hospitalCard">View Hospital cards</a>
            </c:when>
        </c:choose>

        <form style="margin: 0; padding: 0; float: right;" action="${contextPath}/logout">
            <button id="logoutButton" type="submit">LogOut</button>
        </form>

    </div>

</div>

</body>
</html>
