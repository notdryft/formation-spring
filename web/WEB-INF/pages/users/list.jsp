<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/main.css">
    <script type="text/javascript" src="assets/js/jquery-2.0.0.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">Library</a>
            <ul class="nav">
                <li><a href="#">Books</a></li>
                <li class="active"><a href="#">Users</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <div class="alert alert-success">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>Hey !</strong> ${users}
    </div>
</div>
</body>
</html>
