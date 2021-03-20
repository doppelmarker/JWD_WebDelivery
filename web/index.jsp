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
    <link href="http://netdna.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/menu.css">
    <title>WebDelivery</title>
</head>
<body>

<jsp:include page="WEB-INF/jsp/smallpart/header.jsp"/>

<p style="font-size: 1.25rem; margin-top: 2rem; padding-left: 3rem"><b>${param.message}</b></p>

<jsp:include page="WEB-INF/jsp/smallpart/welcome.jsp"/>

</body>
</html>