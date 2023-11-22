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
    <title>Title</title>0
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
        <caption>图书信息</caption>
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
            <td><%= data.getId()%>
            </td>
        </tr>
        <tr>
            <td>图书名称
            </td>
            <td>
                <%= data.getBookName() %>
            </td>
        </tr>
        <tr>
            <td>
                作者
            </td>
            <td><%= data.getAuthor() %>
            </td>
        </tr>
        <tr>
            <td>
                类型
            </td>
            <td><%= data.getKind() %>
            </td>
        </tr>
        <tr>
            <td>
                价格
            </td>
            <td><%= data.getPrice() %>
            </td>
        </tr>
        <tr>
            <td>
                页数
            </td>
            <td><%= data.getPageNum() %>
            </td>
        </tr>
        <tr>
            <td>
                出版社
            </td>
            <td><%= data.getPublish() %>
            </td>
        </tr>
        <tr>
            <td>
                图片
            </td>
            <td><%= data.getPath() %>
            </td>
        </tr>
        <tr>
            <td>
                入库时间
            </td>
            <td><%= data.getCreateTime() %>
            </td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="6">
                <a href=skip.do?id=<%=data.getId()%>>修改</a>
                <a href="skip.do?method=showBook">返回</a></td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>
