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
                <li><a href="users">Users</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">

    <h1>Books dashboard</h1>

    <c:if test="${!books.isEmpty()}">
        <ul>
            <c:forEach var="book" items="${books}">
                <li><a href="users/show/${book.id}">${book.name}</a></li>
            </c:forEach>
        </ul>
    </c:if>
</div>
</body>
</html>
