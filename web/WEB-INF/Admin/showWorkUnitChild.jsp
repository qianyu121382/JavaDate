<%@ page import="java.util.ArrayList" %>
<%@ page import="book.entity.UserInfo" %>
<%@ page import="book.entity.Role" %>
<%@ page import="book.entity.UserInfoAndRole" %>
<%@ page import="book.entity.WorkUnit" %><%--
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
        ArrayList<WorkUnit> workUnit = (ArrayList<WorkUnit>) request.getAttribute("allWorkUnit");
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
    <form>
        <input type="text">
        <a href="skip.do?method=addWork">新建单位</a>
    </form>
    <table>
        <caption>所有用户信息</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>单位名称</th>
            <th>单位地址</th>
            <th>单位地址</th>
            <th>联系人</th>
            <th>邮箱地址</th>
        </tr>
        </thead>
        <tbody>
        <% for (WorkUnit workUnit1:workUnit)
        {%>
        <tr>
            <td><%= workUnit1.getId() %>
            </td>
            <td><%= workUnit1.getUnitName() %>
            </td>
            <td><%= workUnit1.getAddress() %>
            </td>
            <td><%= workUnit1.getPerson() %>
            </td>
            <td><%= workUnit1.getEmail() %>
            </td>
            <td><a href=“editRole.jsp?roleId=<%= workUnit1.getEmail() %>”>编辑</a> | <a
                    href=“deleteRole.jsp?roleId=<%= workUnit1.getEmail() %>”>删除</a></td>
        </tr>
        <% } %>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="6"></td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>
