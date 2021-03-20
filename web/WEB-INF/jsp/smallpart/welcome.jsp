<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.auth == true}">
    <p style="font-size: 1.25rem; margin-top: 2rem; padding-left: 3rem">Hello <b>${sessionScope.loginedUser.login}</b></p>
</c:if>

<c:if test="${sessionScope.auth == null}">
    <p style="font-size: 1.25rem; margin-top: 2rem; padding-left: 3rem">Welcome, <b>Guest</b>! Please login or register.</p>
</c:if>