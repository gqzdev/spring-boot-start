<%--
  Created by IntelliJ IDEA.
  User: ganquanzhong
  Date: 2019/9/19
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h>This is my first spring boot web jsp page</h>

    <br>
    <form action="/login" method="get">
        <button type="submit">login in</button>
    </form>

    <a href="/login">登录</a>
</body>
</html>
