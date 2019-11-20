<%--
  Created by IntelliJ IDEA.
  User: 14271
  Date: 2019/11/20
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<img src="/api/code" alt="">
<form action="/api/login" method="post">
    <label>
        <input type="text" name="code">
    </label>
    <input type="submit" value="登录">
</form>

</body>
</html>
