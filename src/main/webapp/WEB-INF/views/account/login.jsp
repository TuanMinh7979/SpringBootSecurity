<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>LOGIN</h2>
<h2>
${msg}
</h2>
<form action="/account/process-login" method="post">
    username <input type="text" name="username">
    <br>password <input type="text" name="password">
    <br>
    <input type="submit" value="login">
    <br>

    <a href="/account/register">Register</a>

</form>
</body>
</html>