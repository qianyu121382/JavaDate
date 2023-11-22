<%--
  Created by IntelliJ IDEA.
  User: HH
  Date: 2023-11-19
  Time: 17:39
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
                    <img src="images/logo.jpg">
                </div>
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">Register</h4>
                        <h3 class="card-title" style="color: red">${requestScope.error}</h3>
                        <form action="register.do?method=register1" method="POST">
                            <div class="form-group">
                                <label for="name">用户名</label>
                                <input id="name" type="text" class="form-control" name="userName" required autofocus>
                            </div>

                            <div class="form-group">
                                <label for="email">邮箱地址</label>
                                <input id="email" type="email" class="form-control" name="email" required>
                            </div>

                            <div class="form-group">
                                <label for="password">密码</label>
                                <input id="password" type="password" class="form-control" name="password" required
                                       data-eye>
                            </div>

                            <div class="form-grouxp">
                                <label>
                                    <input type="checkbox" name="aggree" value="1"> I agree to the Terms and Conditions
                                </label>
                            </div>

                            <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    注册
                                </button>
                            </div>
                            <div class="margin-top20 text-center">
                                已经拥有用户? <a href="index.jsp">登录</a>
                            </div>
                        </form>
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
