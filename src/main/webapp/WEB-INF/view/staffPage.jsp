<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 3/3/19
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Staff page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminListStyle.css">
    <link rel="stylesheet" href="${contextPath}/css/baseStyle.css">
</head>
<body>
<h3>List of all your patients:</h3>

<form class="clientForm">
    <c:forEach var="client" items="${requestScope.clientsList}">
        <div class="clientsDiv">
            <p>Name: ${client.getName()}</p>
            <p>Surname: ${client.getSurname()}</p>
            <p>Date of birth: ${client.getAdditionalInfo()}</p>
        </div>
    </c:forEach>
</form>
</body>
</html>
