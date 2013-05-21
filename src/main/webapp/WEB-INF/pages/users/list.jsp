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
                <li><a href="${pageContext.request.contextPath}/books"><i class="icon-book icon-white"></i> Books</a>
                </li>
                <li class="active"><a href="#"><i class="icon-user icon-white"></i> Users</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container">

    <div class="page-header">
        <h1>Users&nbsp;
            <small>Dashboard</small>
        </h1>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th><i class="icon-tag"></i> Id</th>
            <th><i class="icon-user"></i> Name</th>
            <th><i class="icon-info-sign"></i> Info</th>
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
                            <span class="text-info">Borrowed one book</span>
                        </c:when>
                        <c:when test="${size > 1}">
                            <span class="text-success">Borrowed ${size} books</span>
                        </c:when>
                        <c:otherwise>
                            <span class="muted">Did not borrow anything</span>
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
