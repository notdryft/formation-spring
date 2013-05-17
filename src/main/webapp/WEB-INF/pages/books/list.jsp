<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <li class="active"><a href="#">Books</a></li>
                <li><a href="${pageContext.request.contextPath}/users">Users</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">

    <div class="page-header">
        <h1>Books&nbsp;
            <small>Dashboard</small>
        </h1>
    </div>

    <c:if test="${!books.isEmpty()}">
        <ul>
            <c:forEach var="book" items="${books}">
                <li>
                    <a href="${pageContext.request.contextPath}/books/show/${book.id}">${book.name}</a>
                    &nbsp;
                    <c:choose>
                        <c:when test="${book.borrowed}"><span class="badge badge-important">&times;</span></c:when>
                        <c:otherwise><span class="badge badge-success">&#10004;</span></c:otherwise>
                    </c:choose>
                </li>
            </c:forEach>
        </ul>
    </c:if>
</div>
</body>
</html>
