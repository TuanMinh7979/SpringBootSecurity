<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:mylayout title="Welcome admin!!!">
    <jsp:attribute name="content"> Admin welcome ${pageContext.request.userPrincipal.name}</jsp:attribute>

</mt:mylayout>
