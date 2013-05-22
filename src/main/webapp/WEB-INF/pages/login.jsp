<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><spring:message code="library.brand"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-2.0.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body onload="document.loginForm.j_username.focus()">

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="${pageContext.request.contextPath}/"><spring:message code="library.brand"/></a>
        </div>
    </div>
</div>

<div class="container">

    <div class="page-header">
        <h1><spring:message code="library.login"/>&nbsp;
            <small><spring:message code="library.authenticate"/></small>
        </h1>
    </div>

    <c:if test="${not empty error}">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong><spring:message
                    code="library.error"/></strong> ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </c:if>

    <c:if test="${not empty info}">
        <div class="alert alert-info">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong><spring:message code="library.info"/></strong> <spring:message code="library.logoutSuccess"/>
        </div>
    </c:if>

    <form name="loginForm" action="<c:url value="${pageContext.request.contextPath}/j_spring_security_check"/>"
          method="POST" class="form-horizontal">
        <div class="control-group">
            <label class="control-label" for="inputEmail"><spring:message code="library.forms.email"/></label>

            <div class="controls">
                <input type="text" id="inputEmail" name="j_username"
                       placeholder="<spring:message code="library.forms.email"/>">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="inputPassword"><spring:message code="library.forms.password"/></label>

            <div class="controls">
                <input type="password" id="inputPassword" name="j_password"
                       placeholder="<spring:message code="library.forms.password"/>">
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn"><spring:message code="library.forms.signIn"/></button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
