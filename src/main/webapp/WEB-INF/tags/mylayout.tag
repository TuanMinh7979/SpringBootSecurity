
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@attribute name="title" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@attribute name="content" required="true" fragment="true" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<html>
<head> <title>${title}</title> </head>

<table border="1" width="800" align="center">


    <tr >
        <td width="300" valign="top">
            <h5>Dashboard </h5>
            <ul>
                <li><a href="">DASHBOARD</a></li>
            </ul>
            <s:authorize access="hasRole('ROLE_SUPER_ADMIN')">

            <ul>
                <li><a href="">CTO</a></li>
                    <li><a href="">architest</a></li>
            </ul>
            </s:authorize>

            <s:authorize access="hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')">

                <ul>
                    <li><a href="">project manager</a></li>
                        <li><a href="">leader</a></li>
                </ul>
            </s:authorize>
            <s:authorize access="hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')">

                <ul>
                    <li><a href="">Dev</a></li>
                   <li><a href="">fresher</a></li>
                </ul>
            </s:authorize>
        </td>
        <td valign="top"> <h3>Welcome ${pageContext.request.userPrincipal.name}</h3>
            <a href="/account/logout">Dang xuat</a>
            <br>
            <br>
            <jsp:invoke fragment="content"/>
        </td>
    </tr>
</table>
</html>

