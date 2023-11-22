<%--
  Created by IntelliJ IDEA.
  User: HH
  Date: 2023-11-17
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/addUser.css" type="text/css" rel="stylesheet">
<body>
<div class="center">
    <form action="workUnit.do?method=addWorkUnit" method="post">
        <h2 class="">添加单位</h2>
        <h2 style="color:red;">${requestScope.error}</h2>
        <div>
            <ul>
                <li>
                    <p>单位名称</p>
                    <input type="text" name="unitName">
                </li>
                <li>
                    <p>联系人</p>
                    <input type="text" name="person">
                </li>
                <li>
                    <p>联系电话</p>
                    <input type="password" name="telephone">
                </li>
                <li>
                    <p>邮箱地址</p>
                    <input type="text" name="email">
                </li>
                <li>
                    <p>单位地址</p>
                    <input type="text" name="address">
                </li>
                <div>
                    <input type="submit" value="添加">
                    <input type="reset" value="清空">
                </div>
                </li>
            </ul>
        </div>
    </form>
</div>
</body>
</html>
