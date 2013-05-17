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
                <li class="active"><a href="${pageContext.request.contextPath}/users"><i
                        class="icon-user icon-white"></i> Users</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container">

    <div class="page-header">
        <h1>User&nbsp;
            <small>Dashboard</small>
        </h1>
    </div>

    <dl class="dl-horizontal">
        <dt>Id</dt>
        <dd>${user.id}</dd>
        <dt>Name</dt>
        <dd>&laquo; ${user.name} &raquo;</dd>
    </dl>


    <div class="well">

        <h2>Emprunts</h2>

        <c:if test="${!user.books.isEmpty()}">
            <ol>
                <c:forEach var="book" items="${user.books}">
                    <li><a href="${pageContext.request.contextPath}/books/show/${book.id}">${book.name}</a></li>
                </c:forEach>
            </ol>
        </c:if>
    </div>
</div>
</body>
</html>
