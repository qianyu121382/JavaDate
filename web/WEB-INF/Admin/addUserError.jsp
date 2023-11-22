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
    <form action="Admin.do?method=addUser" method="post">
        <h2 class="">添加用户</h2>
        <h2>${requestScope.error}</h2>
        <div>
            <ul>
                <li>
                    <p>用户名</p>
                    <input type="text" name="userName">
                </li>
                <li>
                    <p>真实姓名</p>
                    <input type="text" name="realName">
                </li>
                <li>
                    <p>密码</p>
                    <input type="password" name="password">
                </li>
                <li>
                    <p>角色</p>
                    <select name="role">
                        <option value="staff">工作人员</option>
                        <option value="reader">读者</option>
                    </select>
                </li>
                <li>
                    <p>头像</p>
                    <input type="text" name="image">
                </li>
                <li>
                    <p>性别</p>
                    <input type="radio" name="sex" id="check1" value="man" >
                    <p style="margin-left: 3px;width: 60px"  >男</p>
                    <input type="radio" name="sex" id="check2" value="woman" style="margin-left: 8px">
                    <p style="margin-left: 3px;width: 60px">女</p>
                </li>
                <li>
                    <p>工作编号</p>
                    <input type="text" name="jobId">
                </li>
                <li>
                    <p>联系电话</p>
                    <input type="text" name="iphone">
                </li>
                <li>
                    <p>邮箱</p>
                    <input type="text" name="email">
                </li>
                <li>
                    <p>住址</p>
                    <input type="text" name="place">
                </li>
                <li>
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
