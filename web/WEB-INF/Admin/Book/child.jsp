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

    <div style="display: flex; flex-wrap: wrap;margin-top: 100px"> <!-- 这个div是父亲div，设置它的display为flex，flex-wrap为wrap，让它的子元素可以流式布局 -->
        <% for (BookInfo bookInfo : data)
        {%>
        <div style="width: 450px; height: 500px; border: 1px solid #656565;margin-right: 10px"> <!-- 这个div替换了原来的table，设置它的width和height为固定值，border为1px solid black，加上一个边框线 -->
            <div style="float: left; margin: 10px; font-size: 18px;">图片：<img src=<%=bookInfo.getPath()%>></div> <!-- 这个div替换了原来的<tr><td>，设置它的float为left，margin为10px，font-size为18px，让它的内容向左浮动，有一些间距，字体更大 -->
            <div style="clear: both;"></div> <!-- 这个div用来清除浮动，让下一行的内容换行显示 -->
            <div style="float: left; margin: 10px; font-size: 18px;">ID:<%= bookInfo.getId() %></div>
            <div style="clear: both;"></div>
            <div style="float: left; margin: 10px; font-size: 18px;">书名:<%= bookInfo.getBookName() %></div>
            <div style="clear: both;"></div>
            <div style="float: left; margin: 10px; font-size: 18px;">作者:<%= bookInfo.getAuthor() %></div>
            <div style="clear: both;"></div>
            <div style="float: left; margin: 10px; font-size: 18px;">类型:<%= bookInfo.getKind() %></div>
            <div style="clear: both;"></div>
            <div style="float: left; margin: 10px; font-size: 18px;">价格:<%= bookInfo.getPrice() %></div>
            <div style="clear: both;"></div>
            <div style="float: left; margin: 10px; font-size: 18px;"><a href=skip.do?circulateId=<%=bookInfo.getId()%>>申请流通</a></div>
            <div style="clear: both;"></div>
            <div style="float: left; margin: 10px; font-size: 18px;"><a href=skip.do?id=<%=bookInfo.getId()%>>修改</a></div>
        </div>

        <% } %>
    </div>



</div>
</body>
</html>
