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
                <li class="active"><a href="#"><i class="icon-book icon-white"></i> <spring:message
                        code="library.Books"/></a></li>
                <li><a href="<c:url value="/users"/>"><i
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
        <h1><spring:message code="library.Books"/>&nbsp;
            <small><spring:message code="library.dashboard"/></small>
        </h1>
    </div>

    <form:form action="/books/batchAction">
        <div class="input-prepend input-append">
            <span class="add-on"><i class="icon-user"></i></span>
            <input name="name" type="text" class="span2" placeholder="<spring:message code="library.inputs.name"/>">
            <button type="submit" class="btn"><spring:message code="library.books.batch"/></button>
        </div>

        <table class="table table-striped">
            <thead>
            <tr>
                <th><i class="icon-tag"></i> <spring:message code="library.forms.id"/></th>
                <th><i class="icon-book"></i> <spring:message code="library.forms.name"/></th>
                <th><i class="icon-info-sign"></i> <spring:message code="library.forms.info"/></th>
                <th><i class="icon-tasks"></i> <spring:message code="library.forms.actions"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${books}">
                <tr class="<c:if test="${!book.borrowed}">success</c:if>">
                    <td>${book.id}</td>
                    <td><a href="<c:url value="/books/show/${book.id}"/>">${book.name}</a></td>
                    <td>
                        <c:choose>
                            <c:when test="${book.borrowed}"><span
                                    class="label label-important"><spring:message
                                    code="library.books.borrowed"/> &times;</span></c:when>
                            <c:otherwise><span class="label label-success"><spring:message
                                    code="library.books.available"/> &#10004;</span></c:otherwise>
                        </c:choose>
                    </td>
                    <td><input name="booksIds" type="checkbox" value="${book.id}"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form:form>
</div>
</body>
</html>
