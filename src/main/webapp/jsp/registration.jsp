<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <form action="/sign_up" method="post">
        <p>Sign up</p>
        <p>
            <label for="firstName">Firstname<input id="firstName" type="text" name="firstName"></label><br>
            <label for="lastName">Lastname<input id="lastName" type="text" name="lastName"></label><br>
            <label for="login">Login<input id="login" type="text" name="login"></label><br>
            <label for="password">Password<input id="password" type="text" name="password"></label><br>
        </p>
        <p><button type="submit">Register</button> </p><br>
    </form>

</body>
</html>
