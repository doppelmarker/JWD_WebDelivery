<%--
  Created by IntelliJ IDEA.
  User: ghost
  Date: 04.11.2020
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        form {
            border: 3px solid #f1f1f1;
        }

        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
        }

        img.avatar {
            width: 40%;
            border-radius: 50%;
        }

        .container {
            padding: 16px;
        }

        span.psw {
            float: right;
            padding-top: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }

            .cancelbtn {
                width: 100%;
            }
        }
    </style>
</head>
<body>

<h2>Login Form</h2>

<form action="Controller" method="post">
    <input type="hidden" name="command" value="login"/>
    <div class="imgcontainer">
        <img src="${pageContext.servletContext.contextPath}/assets/airplane.jpg" alt="Avatar" class="avatar">
    </div>
    <p style="color: red; padding: 0 16px">${param.errorMessage}</p>
    <div class="container">
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" id="uname" name="username" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" id="psw" name="password" required>

        <button type="submit">Login</button>
    </div>
</form>
<div class="container" style="background-color:#f1f1f1">
    <a style="  border-radius: 10px;
  background: #E8CCB5;
  color: #B05151;
  padding: 15px 30px;
  position: relative;
  box-shadow: 2px 2px 3px rgba(0,0,0,0.3); text-decoration: none;" href="${pageContext.request.contextPath}/">Cancel</a>
</div>

</body>
</html>