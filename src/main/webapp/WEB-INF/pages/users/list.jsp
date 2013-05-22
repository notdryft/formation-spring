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
<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="${pageContext.request.contextPath}/"><spring:message code="library.brand"/></a>
            <ul class="nav">
                <li><a href="${pageContext.request.contextPath}/books"><i
                        class="icon-book icon-white"></i> <spring:message code="library.Books"/></a></li>
                <li class="active"><a href="#"><i
                        class="icon-user icon-white"></i> <spring:message code="library.Users"/></a></li>
            </ul>
            <ul class="nav pull-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                            class="icon-user icon-white"></i> ${sessionScope.user.name} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/users/show/${sessionScope.user.id}"><i
                                class="icon-home"></i> <spring:message code="library.home"/></a></li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/j_spring_security_logout"><i
                                class="icon-off"></i> <spring:message code="library.logout"/></a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="container">

    <div class="page-header">
        <h1><spring:message code="library.Users"/>&nbsp;
            <small><spring:message code="library.dashboard"/></small>
        </h1>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th><i class="icon-tag"></i> <spring:message code="library.forms.id"/></th>
            <th><i class="icon-user"></i> <spring:message code="library.forms.name"/></th>
            <th><i class="icon-info-sign"></i> <spring:message code="library.forms.info"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <c:set var="size" value="${user.books.size()}"/>
            <tr>
                <td>${user.id}</td>
                <td><a href="${pageContext.request.contextPath}/users/show/${user.id}">${user.name}</a></td>
                <td>
                    <c:choose>
                        <c:when test="${size == 1}">
                            <span class="text-info"><spring:message code="library.users.borrowed.one"/></span>
                        </c:when>
                        <c:when test="${size > 1}">
                            <span class="text-success"><spring:message code="library.users.borrowed.many"
                                                                       arguments="${size}"/></span>
                        </c:when>
                        <c:otherwise>
                            <span class="muted"><spring:message code="library.users.borrowed.none"/></span>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
