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
        ArrayList<BookInfo> data = (ArrayList<BookInfo>) request.getAttribute("data");
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
    <div>
        <h2 style="margin-left: 380px;margin-top: 40px;font-size: 34px">所有图书信息</h2>
    </div>
    <div style="background-color: white;margin-top:30px;margin-left: 50px;margin-bottom: 30px;">
        <form action="Book.do?" method="post">
            <input type="text" name="filterTxt">
            <input type="submit" value="搜索"></form>
    </div>
    <table>

        <thead>
        <tr>
            <th>ID</th>
            <th>图书名称</th>
            <th>作者</th>
            <th>类型</th>
            <th>价格</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <% for (BookInfo bookInfo : data)
        {%>
        <tr>
            <td><%= bookInfo.getId() %>
            </td>
            <td><%= bookInfo.getBookName() %>
            </td>
            <td><%= bookInfo.getAuthor() %>
            </td>
            <td><%= bookInfo.getKind() %>
            </td>
            <td><%= bookInfo.getPrice() %>
            </td>
            <td>
                <%=bookInfo.getBorrowState()%>
            </td>
            <td><a href=Book.do?borrowId=<%= bookInfo.getId() %>>借阅</a></td>
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
