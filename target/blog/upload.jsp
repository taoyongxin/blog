<%--
  Created by IntelliJ IDEA.
  User: 14271
  Date: 2019/11/20
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图片上传页面</title>
</head>
<body>
<form action="/api/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="filename" multiple>
    <input type="submit" value="上传">
</form>
<p>${ msg}</p>

</body>
</html>
