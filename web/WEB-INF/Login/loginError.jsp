<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
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
                        <h4 class="card-title">Login</h4>
                        <h3 class="card-title" style="color: red">${requestScope.error}</h3>
                        <form action="login.do?method=login1" method="POST">
                            <div class="form-group">
                                <label for="userName">用户名</label>
                                <input id="userName" type="text" class="form-control" name="userName" value="" required autofocus>
                            </div>
                            <div class="form-group">
                                <label for="password">密码
                                    <a href="forgot.html" class="float-right">
                                        忘记密码?
                                    </a>
                                </label>
                                <input id="password" type="password" class="form-control" name="password" required data-eye>
                            </div>
                            <div class="form-group">
                                <label>
                                    <input type="checkbox" name="remember"> 记住密码
                                </label>
                            </div>

                            <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    登录
                                </button>
                            </div>
                            <div class="margin-top20 text-center">
                                还未拥有用户? <a href="${pageContext.request.contextPath}/register.jsp">注册</a>
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

<script src="../../js/my_login/jquery.min.js"></script>
<script src="../../js/my_login/bootstrap.min.js"></script>
<script src="../../js/my_login/my-login.js"></script>
</body>
</html>
