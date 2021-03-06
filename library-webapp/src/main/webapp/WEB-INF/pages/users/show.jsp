<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><spring:message code="library.brand"/></title>
    <link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/main.css"/>">
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-2.0.0.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="<c:url value="/"/>"><spring:message code="library.brand"/></a>
            <ul class="nav">
                <li><a href="<c:url value="/books"/>"><i
                        class="icon-book icon-white"></i> <spring:message code="library.Books"/></a>
                </li>
                <li class="active"><a href="<c:url value="/users"/>"><i
                        class="icon-user icon-white"></i> <spring:message code="library.Users"/></a>
                </li>
            </ul>
            <ul class="nav pull-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                            class="icon-user icon-white"></i> ${sessionScope.user.name} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/users/show/${sessionScope.user.id}"/>"><i
                                class="icon-home"></i> <spring:message code="library.home"/></a></li>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/j_spring_security_logout"/>"><i
                                class="icon-off"></i> <spring:message code="library.logout"/></a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="container">

    <div class="page-header">
        <h1><spring:message code="library.User"/>&nbsp;
            <small><spring:message code="library.dashboard"/></small>
        </h1>
    </div>

    <dl>
        <dt><spring:message code="library.forms.name"/></dt>
        <dd>&laquo; ${user.name} &raquo;</dd>
    </dl>

    <div class="well well-large">

        <h2><spring:message code="library.user.borrowing"/></h2>

        <c:choose>
            <c:when test="${user.books.isEmpty()}">
                <p class="muted"><spring:message code="library.user.borrowing.none"/></p>
            </c:when>
            <c:otherwise>
                <ol>
                    <c:forEach var="book" items="${user.books}">
                        <li><a href="<c:url value="/books/show/${book.id}"/>">${book.name}</a></li>
                    </c:forEach>
                </ol>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
