<%--
  Created by IntelliJ IDEA.
  User: ghost
  Date: 04.11.2020
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/menu.css">
    <title>WebDelivery</title>
</head>
<body>
<header class="header">
    <div class="container">
        <div class="header__block">
            <div class="header__logo">
                <a href="${pageContext.request.contextPath}/" style="display: block">
                    <h1 class="logo">WebDelivery</h1>
                    <p class="logo-suptitle">№1 web delivery</p>
                </a>
            </div>
            <nav class="header__nav">
                <ul class="header__ul">
                    <c:if test="${sessionScope.auth == true}">
                        <jsp:include page="WEB-INF/jsp/menuLoggedIn.html"/>
                    </c:if>

                    <c:if test="${sessionScope.auth == null}">
                        <jsp:include page="WEB-INF/jsp/menuNotLoggedIn.html"/>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</header>

<p style="font-size: 1.25rem; margin-top: 2rem; padding-left: 3rem"><b>${param.message}</b></p>

<c:if test="${sessionScope.auth == true}">
    <p style="font-size: 1.25rem; margin-top: 2rem; padding-left: 3rem">Hello <b>${sessionScope.loginedUser.login}</b></p>
</c:if>

<c:if test="${sessionScope.auth == null}">
    <p style="font-size: 1.25rem; margin-top: 2rem; padding-left: 3rem">Welcome, <b>Guest</b>! Please login or register.</p>
</c:if>
</body>
</html>