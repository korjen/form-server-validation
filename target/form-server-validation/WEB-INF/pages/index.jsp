<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html lang="ru">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><spring:message code="page.title"/></title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <script>
        function setMaxDate() {
            var today = new Date();
            var day = today.getDate();
            var month = today.getMonth() + 1;
            var year = today.getFullYear();
            if (day < 10) {
                day = '0' + day
            }
            if (month < 10) {
                month = '0' + month
            }

            today = year + '-' + month + '-' + day;
            document.getElementById("datepicker").setAttribute("max", today);
        }
    </script>
</head>

<body onload="setMaxDate()">
<div class="container">
<form:form action="addUser" modelAttribute="user" method="post">
        <div class="row">
            <div class="col-sm-6">
                <label for="firstName"><spring:message code="form.label.firstName"/></label>
                <spring:message code="form.placeholder.firstName" var="firstNamePlaceholder" />
                <form:input type="text" id="firstName" path="firstName" placeholder='${firstNamePlaceholder}'/>
                <span><form:errors path="firstName"/></span>
            </div>
            <div class="col-sm-6">
                <label for="lastName"><spring:message code="form.label.lastName"/></label>
                <spring:message code="form.placeholder.lastName" var="lastNamePlaceholder" />
                <form:input type="text" id="lastName" path="lastName" placeholder='${lastNamePlaceholder}'/>
                <span><form:errors path="lastName"/></span>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="datepicker"><spring:message code="form.label.birthDate"/></label>
            <div class="col-sm-6">
                <spring:message code="form.placeholder.birthDate" var="birthDatePlaceholder" />
                <form:input type="date" class="form-control datepicker" id="datepicker" path="birthDate" placeholder='${birthDatePlaceholder}' min='1870-01-01'/>
                <span><form:errors path="birthDate"/></span>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="email"><spring:message code="form.label.email"/></label>
            <div class="col-sm-6">
                <spring:message code="form.placeholder.email" var="emailPlaceholder" />
                <form:input type="text" id="email" path="email" placeholder='${emailPlaceholder}'/>
                <span><form:errors path="email"/></span>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="userName"><spring:message code="form.label.username"/></label>
            <div class="col-sm-6">
                <spring:message code="form.placeholder.username" var="usernamePlaceholder" />
                <form:input type="text" id="userName" path="username" placeholder='${usernamePlaceholder}'/>
                <span><form:errors path="username"/></span>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="password"><spring:message code="form.label.password"/></label>
            <div class="col-sm-6">
                <spring:message code="form.placeholder.password" var="passwordPlaceholder" />
                <form:input type="password" id="password" path="password" placeholder='${passwordPlaceholder}'/>
                <span><form:errors path="password"/></span>
            </div>
        </div>
        </br>
        <div class="text-center">
            <input type="submit" class="button" id="buttonSubmit" value="<spring:message code="submit.button"/>">
        </div>
</form:form>
</div>
<script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery-3.5.1.js"/>" type="text/javascript"></script>
</body>

</html>
