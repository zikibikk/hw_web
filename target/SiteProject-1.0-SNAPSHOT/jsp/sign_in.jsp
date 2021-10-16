<%--
  Created by IntelliJ IDEA.
  User: alinabikkinina
  Date: 16.10.2021
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
<form action="/sign_in" method="post">
    <p>Sign In</p>
    <p>
        <label for="login">Login<input id="login" type="text" name="login"></label><br>
        <label for="password">Password<input id="password" type="password" name="password"></label><br>

    <p><button type="submit">Вход</button></p><br>
</form>
</body>
</html>
