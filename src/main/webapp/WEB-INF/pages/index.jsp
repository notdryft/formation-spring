<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a class="brand" href="#">Library</a>
            <ul class="nav">
                <li><a href="${pageContext.request.contextPath}/books">Books</a></li>
                <li><a href="${pageContext.request.contextPath}/users">Users</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">

    <h1>Dashboard</h1>

    <p>Things you can do:</p>

    <ol>
        <li>Consult the list of <a href="books">books</a> you can borrow</li>
        <li>Get to the list of <a href="users">users</a> that can actually borrow a book</li>
    </ol>
</div>
</body>
</html>
