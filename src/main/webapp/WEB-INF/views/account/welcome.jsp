<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
welcome ${pageContext.request.userPrincipal.name}

<a href="/account/logout">Dang xuat</a></body>
</html>