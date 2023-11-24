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
        BookInfo data = (BookInfo) request.getAttribute("data");
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
    <form action="Book.do?method=circulateBook" method="post">
        <table>
            <caption>流通申请</caption>
            <thead>
            <tr>
                <th>类型</th>
                <th>值</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>ID
                </td>
                <td>
                    <input type="text" name="bookId" value="<%= data.getId() %>" readonly>
                </td>
            </tr>
            <tr>
                <td>图书名称
                </td>
                <td>
                    <input type="text" name="bookName" value="<%= data.getBookName() %>" readonly>
                </td>
            </tr>
            <tr>
                <td>
                    所属单位ID
                </td>
                <td>
                    <input type="text" name="unitId" value="<%= data.getUnitId() %>" readonly>
                </td>
            </tr>
            <tr>
                <td>
                    申请人ID
                </td>
                <td>
                    <input type="text" name="userId" value=${sessionScope.user.id}>
                </td>
            </tr>
            <tr>
                <td>
                    申请流通理由
                </td>
                <td>
                    <input type="text" name="circulateReason">
                </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="6">
                    <input type="submit" value="提交">
                    <input type="reset" value="复原">
                    <a href=skip.do?bookName=<%= data.getBookName() %>>返回</a>
                </td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>
