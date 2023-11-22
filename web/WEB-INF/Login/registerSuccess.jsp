<%--
  Created by IntelliJ IDEA.
  User: HH
  Date: 2023-11-19
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/my_login/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/my-login.css"/>
</head>
<body class="my-login-page">
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="brand">
                    <img src="images/logo.jpg"0i8>
                </div>
                <div class="card fat">
                    <div class="card-body" style="height: 300px">
                        <h4 class="card-title" style="margin-top: 100px;margin-left:115px;align-content: center">注册成功!</h4>
                        <a href="${pageContext.request.contextPath}/index.jsp" style="margin-top: 10px;margin-left:120px;">返回登录界面</a>
                    </div>
                </div>
                <div class="footer">

                </div>
            </div>
        </div>
    </div>
</section>

<script src="js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/my-login.js"></script>
</body>
</html>
