<%--
  Created by IntelliJ IDEA.
  User: ghost
  Date: 12.11.2020
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: black;
        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
            background-color: white;
        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .registerbtn {
            background-color: #4CAF50;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .registerbtn:hover {
            opacity: 1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
    </style>
</head>
<body>

<form action="Controller" method="post">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="login"><b>Login</b></label>
        <input type="text" placeholder="Enter Login" id="login" name="userName" required>

        <label for="name"><b>Name</b></label>
        <input type="text" placeholder="Enter Name" name="name" id="name" required>

        <label for="surname"><b>Surname</b></label>
        <input type="text" placeholder="Enter Surname" name="surname" id="surname" required>

        <p><b>Gender</b></p>
        <p><input type="radio" value="M" name="gender" checked>Male</p>
        <p><input type="radio" value="F" name="gender">Female</p>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" id="psw" name="password" required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" id="psw-repeat" name="repeatPassword" required>
        <hr>
        <p style="color: red; padding: 0 16px">${errorMessage}</p>
    <%--        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>--%>

        <button type="submit" class="registerbtn">Register</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
        <a style="  border-radius: 10px;
  background: #E8CCB5;
  color: #B05151;
  padding: 15px 30px;
  position: relative;
  box-shadow: 2px 2px 3px rgba(0,0,0,0.3); text-decoration: none;" href="${pageContext.request.contextPath}/main">Cancel</a>
    </div>

<%--    <div class="container signin">--%>
<%--        <p>Already have an account? <a href="#">Sign in</a>.</p>--%>
<%--    </div>--%>
</form>

</body>
</html>
