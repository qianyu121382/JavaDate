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
    <form action="${pageContext.request.contextPath}/staff.do?method=book1" method="post">
        <h2 class="">添加书籍</h2>
        <div>
            <ul>
                <li>
                    <p>书籍名称</p>
                    <input type="text" name="bookName">
                </li>
                <li>
                    <p>作者</p>
                    <input type="text" name="author">
                </li>
                <li>
                    <p>出版社</p>
                    <input type="text" name="publish">
                </li>
                <li>
                    <p>图书分类</p>
                    <input type="text" name="kind">
                </li>
                <li>
                    <p>页数</p>
                    <input type="text" name="pageNum">
                </li>
                <li>
                    <p>价格</p>
                    <input type="text" name="price">
                </li>
                <li>
                    <p>单位ID</p>
                    <input type="text" name="unitId">
                </li>
                <div style="height: 50px">
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
