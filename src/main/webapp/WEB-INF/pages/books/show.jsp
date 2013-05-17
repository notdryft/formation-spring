<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-2.0.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="${pageContext.request.contextPath}/">Library</a>
            <ul class="nav">
                <li class="active"><a href="${pageContext.request.contextPath}/books"><i
                        class="icon-book icon-white"></i> Books</a></li>
                <li><a href="${pageContext.request.contextPath}/users"><i class="icon-user icon-white"></i> Users</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="container">

    <div class="page-header">
        <h1>Book&nbsp;
            <small>Dashboard</small>
        </h1>
    </div>


    <c:choose>
        <c:when test="${book.borrowed}">
            <form:form action="${pageContext.request.contextPath}/books/lend/${book.id}">
                <button type="submit" class="btn btn-info">Lend book</button>
            </form:form>
        </c:when>
        <c:otherwise>
            <form:form action="${pageContext.request.contextPath}/books/borrow/${book.id}">
                <div class="input-append">
                    <input name="name" type="text" class="span2">
                    <button type="submit" class="btn">Borrow book</button>
                </div>
            </form:form>
        </c:otherwise>
    </c:choose>

    <blockquote>
        <p>&laquo; ${book.name} &raquo;</p>
        <small>
            <c:choose>
                <c:when test="${book.borrowed}">
                    <span class="label label-important">Emprunté </span> par <a
                        href="${pageContext.request.contextPath}/users/show/${book.user.id}">${book.user.name}</a>
                </c:when>
                <c:otherwise>
                    <span class="label label-success">Disponible</span>
                </c:otherwise>
            </c:choose>
        </small>
    </blockquote>
</div>
</body>
</html>
