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
                <li><a href="${pageContext.request.contextPath}/books">Books</a></li>
                <li class="active"><a href="#">Users</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">

    <h1>Users dashboard</h1>

    <c:if test="${!users.isEmpty()}">
        <ul>
            <c:forEach var="user" items="${users}">
                <li><a href="${pageContext.request.contextPath}/users/show/${user.id}">${user.name}</a></li>
            </c:forEach>
        </ul>
    </c:if>
</div>
</body>
</html>
