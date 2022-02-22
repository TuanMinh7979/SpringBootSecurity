<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>REGISTER</h2>

<%--@elvariable id="account" type=""--%>
<s:form action="" method="post" modelAttribute="account">
    <table>
        <tr>
            <td>Username</td>
            <td><s:input type="text" path="userName"/></td>

        </tr>
        <tr>
            <td>
                Password
            </td>
            <td><s:input type="password" path="password"/></td>

        </tr>
        <tr>
            <td>Full name</td>
            <td><s:input type="text" path="fullName"/>   </td>

        </tr>
        <tr> <td>Status</td><td>
           <s:checkbox path="status"/></td></tr>
        <tr>
            <td>Author</td>
            <td><c:forEach var="role" items="${roles}">
                <input type="checkbox" name="role" value="${role.id}"> ${role.name}
                <br>

            </c:forEach>   </td>
        </tr>

    </table>
    <input type="submit" value="DANG KY">
</s:form>
</body>
</html>