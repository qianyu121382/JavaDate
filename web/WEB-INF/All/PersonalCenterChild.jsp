<%@ page import="java.util.ArrayList" %>
<%@ page import="book.entity.*" %><%--
  Created by IntelliJ IDEA.
  User: HH
  Date: 2023-11-20
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        UserInfo data = (UserInfo) session.getAttribute("user");
    %>
    <title>Title</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
        }

        table caption {
            font-size: 2em;
            font-weight: bold;
            margin: 1em 0;
        }

        th, td {
            border: 1px solid #999;
            text-align: center;
            padding: 20px 0;
        }

        table thead tr {
            background-color: #86d3f6;
            color: #fff;
        }

        table tbody tr:nth-child(odd) {
            background-color: #eee;
        }

        table tbody tr:hover {
            background-color: #ccc;
        }

        table tbody tr td:first-child {
            color: #f40;
        }

        table tfoot tr td {
            text-align: right;
            padding-right: 20px;
        }

        html, body {
            margin: 0;
            padding: 0
        }

        .center {
            padding: 15px 15px 15px 85px;
            width: 100%;
            height: 100%;
            background-color: white;
        }
    </style>
</head>
<body>
<div class="center">
    <form action="Admin.do?method=alterUser" method="post">
        <table>
            <caption>个人信息</caption>
            <thead>
            <tr>
                <th>类型</th>
                <th>值</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>用户名
                </td>
                <td>
                    <input type="text" name="userName" value="<%= data.getUserName() %>" readonly>
                </td>
            </tr>
            <tr>
                <td>
                    真实姓名
                </td>
                <td>
                    <input type="text" name="realName" value="<%= data.getRealName() %>">
                </td>
            </tr>
            <tr>
                <td>
                    联系电话
                </td>
                <td>
                    <input type="text" name="iphone" value="<%= data.getIphone() %>">
                </td>
            </tr>
            <tr>
                <td>
                    邮箱
                </td>
                <td>
                    <input type="text" name="email" value="<%= data.getEmail() %>">
                </td>
            </tr>
            <tr>
                <td>
                    出生地
                </td>
                <td>
                    <input type="text" name="place" value="<%= data.getPlace() %>">
                </td>
            </tr>
            <tr>
                <td>
                    性别
                </td>
                <td>
                    <input type="text" name="sex" value="<%= data.getSex() %>">
                </td>
            </tr>
            <tr>
                <td>
                    图片
                </td>
                <td>
                    <input type="text" name="image" value="<%= data.getImage() %>">
                </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="6">
                    <input type="submit" value="修改">
                    <input type="reset" value="复原">
                </td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>
