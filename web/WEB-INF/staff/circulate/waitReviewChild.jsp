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
    <table>
        <caption>所有待审核图书信息</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>图书名称</th>
            <th>作者</th>
            <th>类型</th>
            <th>价格</th>
            <th>状态</th>
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
                <%=bookInfo.getCirculateState()%>
            </td>
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
