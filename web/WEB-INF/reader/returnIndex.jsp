<%--
  Created by IntelliJ IDEA.
  User: HH
  Date: 2023-11-17
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/style_Admin_index.css"/>
  <title>Title</title>
</head>
<body>
<div id="bg">
  <div id="sadrzaj">
    <div id="zaglavlje">
      <div id="title">小费的图书管理系统</div>
      <div id="title_info">
        <p><i>欢迎登录</i></p>
        <p><b>${sessionScope.user.userName}[${sessionScope.role.roleName}]</b></p>
      </div>
    </div>
    <div id="navigacija">
      <ul>
        <li><a href="#">首页</a></li>
        <li><a href="skip.do?method=alterUser">个人中心</a></li>
        <li><a href="skip.do?method=showBook">借阅图书</a></li>
        <li><a href="skip.do?method=returnBorrow">归还图书</a></li>
      </ul>
    </div>
    <div id="clanci">
      <jsp:include page="returnIndexChild.jsp"/>
    </div>
  </div>
</div>
<script>
  function toggleDropdown() {
    // 获取下拉框的元素
    var dropdown = document.querySelector(".dropdown-content");
    // 判断下拉框的状态，如果是隐藏的，就显示，如果是显示的，就隐藏
    if (dropdown.classList.contains("show")) {
      dropdown.classList.remove("show");
    } else {
      dropdown.classList.add("show");
    }
  }
</script>
</body>
</html>
