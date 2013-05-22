<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <li class="active"><a href="<c:url value="/books"/>"><i
                        class="icon-book icon-white"></i>&nbsp;<spring:message code="library.Books"/></a></li>
                <li><a href="<c:url value="/users"/>"><i class="icon-user icon-white"></i>&nbsp;
                    <spring:message code="library.Users"/></a>
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
        <h1><spring:message code="library.Book"/>&nbsp;
            <small><spring:message code="library.dashboard"/></small>
        </h1>
    </div>

    <c:choose>
        <c:when test="${book.borrowed}">
            <form:form action="/books/lend" commandName="book">
                <form:hidden path="id"/>
                <button type="submit" class="btn btn-info"><spring:message code="library.books.lend"/></button>
            </form:form>
        </c:when>
        <c:otherwise>
            <form:form action="/books/borrow" commandName="book">
                <form:hidden path="id"/>
                <div class="input-prepend input-append">
                    <span class="add-on"><i class="icon-user"></i></span>
                    <input name="name" type="text" class="span2"
                           placeholder="<spring:message code="library.inputs.name"/>">
                    <button type="submit" class="btn"><spring:message code="library.books.borrow"/></button>
                </div>
            </form:form>
        </c:otherwise>
    </c:choose>

    <blockquote>
        <p>&laquo; ${book.name} &raquo;</p>
        <small>
            <c:choose>
                <c:when test="${book.borrowed}">
                    <span class="label label-important"><spring:message
                            code="library.books.borrowed"/></span> <spring:message
                        code="library.books.borrowed.by"/> <a
                        href="<c:url value="/users/show/${book.user.id}"/>">${book.user.name}</a>
                </c:when>
                <c:otherwise>
                    <span class="label label-success"><spring:message code="library.books.available"/></span>
                </c:otherwise>
            </c:choose>
        </small>
    </blockquote>
</div>
</body>
</html>
