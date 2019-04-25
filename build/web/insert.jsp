<%-- 
    Document   : insert
    Created on : Jul 5, 2018, 1:02:02 AM
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
        <h1>Sign Up</h1>
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
            AvengerName : <input type="text" name="txtAvengerName"/>
            <font color="red">
            ${requestScope.INVALID.avengerNameError}
            </font>
            <br/>
            Fullname : <input type="text" name="txtFullname"/>
            <br/>
            Date of birth : <input type="date" name="txtDateOfBirth"/>
            <br/>
            Role : <input type="text" name="txtRole"/>
            <font color="red">
            ${requestScope.INVALID.roleError}
            </font>
            <br/>
            <input type="submit" name="action" value="Insert"/>
        </form>
    </body>
</html>
