<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:mylayout title="Welcome employee!!!">
    <jsp:attribute name="content"> Employee welcome ${pageContext.request.userPrincipal.name}</jsp:attribute>

</mt:mylayout>