<%@ page import="java.util.ArrayList" %>
<%@ page import="book.entity.*" %>
<%@ page import="book.entity.Mapping.Circulate" %><%--
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
        ArrayList<Circulate> data = (ArrayList<Circulate>) request.getAttribute("data");
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
        <caption>所有流出申请图书信息</caption>
        <thead>
        <tr>
            <th>图书ID</th>
            <th>申请人ID</th>
            <th>申请理由</th>
            <th>申请时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <% for (Circulate c : data)
        {%>
        <tr>
            <td><%= c.getBookId() %>
            </td>
            <td><%= c.getUserId() %>
            </td>
            <td><%= c.getCirculateReason() %>
            </td>
            <td><%= c.getCirculateTime() %>
            </td>
            <td><%= c.getState() %>
            </td>
            <td>
                <a href="<%= c.getState().equals("待审核") ? "Book.do?agreeId=" + c.getId() : "Book.do?returnAppId="+c.getId() %>">同意</a>
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
