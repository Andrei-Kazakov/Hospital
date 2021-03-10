<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 3/13/19
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/baseStyle.css">
</head>
<body>
<h1>An error occurred!</h1>
<h3>${requestScope.error}</h3>
</body>
</html>
