<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 3/14/19
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Add new client</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/baseStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="center">
    <form action="${contextPath}${action}" method="post">

        <input type="hidden" name="id" value="${requestScope.client.getId()}">

        <span>Name</span>
        <input type="text" name="name" value="${requestScope.client.getName()}" placeholder="Name" required>

        <br>

        <span>Surname</span>
        <input type="text" name="surname" value="${requestScope.client.getSurname()}" placeholder="Surname" required>

        <br>

        <div id="PatDate" style="display: none">
            <span>Patient date of birth</span>
            <input type="text" name="additionalInfo" value="${requestScope.client.getAdditionalInfo()}" placeholder="DD-MM-YYYY">
        </div>

        <span>Login</span>
        <input type="text" name="login" value="${requestScope.client.getLogin()}" placeholder="Login" required>

        <br>

        <span>Password</span>
        <input type="text" name="password" value="${requestScope.client.getPassword()}" placeholder="Password" required>

        <br>

        <span>Role</span>
        <select id="role" name="role">
            <c:forEach var="value" items="${requestScope.roles}">
                <option value="${value.name}" <c:if
                        test="${value.name eq requestScope.client.getRole().getName()}"> selected</c:if>>${value.name}</option>
            </c:forEach>
        </select>

        <br>

        <div style="display: none" id="docCat">
            <span>Select doctor category</span>
            <select name="docCategory">
                <c:forEach items="${requestScope.categories}" var="value">
                    <option value="${value.getName()}" <c:if
                            test="${value.getName() eq requestScope.client.getRole.getName()}"> selected </c:if>>${value.getName()}</option>
                </c:forEach>
            </select>
        </div>

        <br>

        <input type="submit" value="Add client">
    </form>
</div>
</body>
<script>
    $(document).ready(function () {
        $('#role').on('change', function () {
            if (this.value === "doctor") {
                $("#docCat").show();
                $("#PatDate").hide();
            } else if (this.value === "patient") {
                $("#PatDate").show();
                $("#docCat").hide();
            } else {
                $("#docCat").hide();
                $("#PatDate").hide();
            }
        })
    })
</script>
</html>
