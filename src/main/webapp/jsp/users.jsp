<%--<%@ page import="java.util.List" %>
<%@ page import="models.User" %> --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body><h1>from jsp users</h1>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>AGE</th>
        </tr>
        <c:forEach items="${userForJsp}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
            </tr>
        </c:forEach>
        <%--<%
            List<User> users = (List<User>) request.getAttribute("usersForJsp");
            for (User user :
                    users) {%>
        <tr>
                <td><%=user.getId()%></td>
                <td><%=user.getFirstName()%></td>
                <td><%=user.getLastName()%></td>
        </tr>
            <%}
        %>--%>
    </table>
</div>

</body>
</html>
