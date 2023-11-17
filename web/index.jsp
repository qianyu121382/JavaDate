<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="css/styles_index.css"/>
</head>
<body>
<div id="container">
    <div id="header"><h1>用户登录</h1></div>
    <div id="wrapper">
        <div id="content">
            <form action="login.do?method=login1" method="post">
                <p> 用户名
                    <input type="text" name="userName">
                </p>
                <p>密码
                    <input type="password" name="password">
                </p>
                <div>
                    <input type="submit" value="登录">
                </div>
                <div>
                    <div>
                        <form>
                            <input type="submit" value="忘记密码">
                        </form>
                    </div>
                    <div>
                        <form>
                            <input type="submit" value="注册">
                        </form>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div id="navigation">
        <p><strong>Navigation Here</strong></p>
        <ul>
            <li><a href="http://www.free-css.com/">Free CSS Templates</a></li>
            <li><a href="http://www.free-css.com/free-css-layouts.php">Free CSS Layouts</a></li>
        </ul>
    </div>
    <div id="extra">
        <p><strong>More stuff here.</strong></p>
        <p>sit malesuada lacus pellus parturpiscing. Pellenterdumat maecenatoque cras a magna nibh et quis diam ames et.
            Laoremvolutpat ac dolor eget eget temper lacus vestibus velit lacus venean. Magnaipsum tellus morbi leo
            aliquat nulla convallis pellentesque.</p>
    </div>
    <div id="footer">
        <p>Footer</p>
    </div>
</div>
</body>
</html>
