<%--
  Created by IntelliJ IDEA.
  User: RongChao Xu
  Date: 2019/6/25
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>上传图片</h2>
<div align="center">
    <form action="upload" enctype="multipart/form-data" method="post">
        名称：<input name="name" /> <br>
        上传文件：<input name="picFile" type="file"/><br>
        <input type="submit" value="提交" /> &nbsp;&nbsp;
        <input type="reset" value="重置" />
    </form>
</div>

</body>
</html>
