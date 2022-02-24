<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:mylayout title="Welcome !!!">
<jsp:attribute name="content">welcome ${pageContext.request.userPrincipal.name}</jsp:attribute>

</mt:mylayout>

