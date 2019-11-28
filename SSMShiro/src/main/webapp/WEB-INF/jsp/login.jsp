<%--
  Created by IntelliJ IDEA.
  User: RongChao Xu
  Date: 2019/11/26
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<h2 align="center">用户登录</h2>
<h5>${login}</h5>
<form action="${pageContext.request.contextPath}/login/login" method="post">
    <table border="1" align="center" width="50%" cellpadding="5">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="userpwd"/></td>
        </tr>
        <tr>
            <td align="center" colspan="2" >
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
