<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 3/16/19
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Add new hospital card</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/baseStyle.css">
</head>
<body>
<form action="${contextPath}${action}" method="post" accept-charset="UTF-8">
    <div class="center">
        <input type="hidden" name="id" value="${requestScope.hospitalCard.getId()}">

        <span>Select doctor login</span>
        <select name="doctor">
            <c:forEach var="value" items="${requestScope.doctors}">
                <option value="${value.getLogin()}"
                        <c:if test="${value.getLogin() == hospitalCard.getDoctor().getLogin()}">selected</c:if>>${value.getLogin()}</option>
            </c:forEach>
        </select>

        <br>

        <span>Select patient login</span>
        <select name="patient">
            <c:forEach var="value" items="${requestScope.patients}">
                <option value="${value.getLogin()}"
                        <c:if test="${value.getLogin() == hospitalCard.getPatient().getLogin()}">selected</c:if>>${value.getLogin()}</option>
            </c:forEach>
        </select>

        <br>

        <span>Select nurse (not required)</span>
        <select name="nurse">
            <option disabled selected value> Select nurse</option>
            <c:forEach var="value" items="${requestScope.nurses}">
                <option value="${value.getLogin()}"
                        <c:if test="${value.getLogin() == hospitalCard.getNurse().getLogin()}">selected</c:if>>${value.getLogin()}</option>
            </c:forEach>
        </select>

        <br>

        <span>Patient status</span>
        <select name="status">
            <c:forEach var="value" items="${requestScope.statuses}">
                <option value="${value.getName()}"
                        <c:if test="${value.getName() == hospitalCard.getPatientStatus().getName()}">selected</c:if>>${value.getName()}</option>
            </c:forEach>
        </select>

        <br>

        <span>Select current patient diagnosis</span>
        <select name="currentDiagnosis">
            <option disabled selected value>No diagnosis</option>
            <c:forEach var="value" items="${requestScope.diagnoses}">
                <option value="${value.getName()}"
                        <c:if test="${value.getName() == hospitalCard.getPatientDiagnosis().getName()}">selected</c:if>>${value.getName()}</option>
            </c:forEach>
        </select>

        <br>

        <span>Select final patient diagnosis</span>
        <select name="finalDiagnosis">
            <option disabled selected value>No final diagnosis</option>
            <c:forEach var="value" items="${requestScope.diagnoses}">
                <option value="${value.getName()}"
                        <c:if test="${value.getName() == hospitalCard.getPatientFinalDiagnosis().getName()}">selected</c:if>>${value.getName()}</option>
            </c:forEach>
        </select>

        <br>

        <span>Patient medicine (separated by "/")</span>
        <input type="text" name="medicine" placeholder="Medicine" value=<c:forEach var="medicine" items="${requestScope.hospitalCard.getPatientMedicines()}">${medicine}/</c:forEach>>

        <br>

        <span>Patient operations (separated by "/")</span>
        <input type="text" name="operation" placeholder="Operation" value=<c:forEach var="operation" items="${requestScope.hospitalCard.getPatientOperations()}">${operation}/</c:forEach>>

        <br>

        <span>Patient procedures (separated by "/")</span>
        <input type="text" name="procedure" placeholder="Procedure" value=<c:forEach var="procedure" items="${requestScope.hospitalCard.getPatientOperations()}">${procedure}/</c:forEach>>

        <br>

        <input type="submit" value="Add card">
    </div>
</form>
</body>
</html>
