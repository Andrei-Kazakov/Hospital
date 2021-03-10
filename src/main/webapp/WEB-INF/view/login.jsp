<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 3/2/19
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/baseStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginFormStyle.css">
</head>
<body>
<form action="login" method="post">
<div class="container">
    <label for="login"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="login" required> <br>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button type="submit">Login</button>
</div>
</form>
</body>
</html>
