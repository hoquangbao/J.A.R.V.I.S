<%-- 
    Document   : index
    Created on : Jul 4, 2018, 1:10:22 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="MainController" method="POST">
            Username : <input type="text" name="txtUsername"/>
            <font color="red">
            ${requestScope.INVALID.usernameError}
            </font>
            <br/>
            Password : <input type="password" name="txtPassword"/>
            <font color="red">
            ${requestScope.INVALID.passwordError}
            </font>
            <br/>
            <input type="submit" name="action" value="Login"/>
        </form>
    </body>
</html>
