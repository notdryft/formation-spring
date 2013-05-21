<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        class="icon-book icon-white"></i> <spring:message code="library.Books"/></a>
                </li>
                <li class="active"><a href="${pageContext.request.contextPath}/users"><i
                        class="icon-user icon-white"></i> <spring:message code="library.Users"/></a>
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
        <dt><spring:message code="library.table.name"/></dt>
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
                        <li><a href="${pageContext.request.contextPath}/books/show/${book.id}">${book.name}</a></li>
                    </c:forEach>
                </ol>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
