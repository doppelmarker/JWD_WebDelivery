<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                        <jsp:include page="menuLoggedIn.html"/>
                    </c:if>

                    <c:if test="${sessionScope.auth == null}">
                        <jsp:include page="menuNotLoggedIn.html"/>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</header>