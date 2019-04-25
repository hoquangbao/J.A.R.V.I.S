<%-- 
    Document   : update
    Created on : Jul 6, 2018, 1:59:18 AM
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
        <h1>Update Page</h1>
        <form action="MainController" method="POST">
            Username : <input type="text" name="txtUsername" value="${requestScope.DTO.username}" readonly="true"/>
            <font color="red">
            ${requestScope.INVALID.usernameError}
            </font>
            <br/>
            Password : <input type="password" name="txtPassword" value="${requestScope.DTO.password}"/>
            <font color="red">
            ${requestScope.INVALID.passwordError}
            </font>
            <br/>
            AvengerName : <input type="text" name="txtAvengerName" value="${requestScope.DTO.avengerName}"/>
            <font color="red">
            ${requestScope.INVALID.avengerNameError}
            </font>
            <br/>
            Fullname : <input type="text" name="txtFullname" value="${requestScope.DTO.fullname}"/>
            <br/>
            DateOfBirth : <input type="date" name="txtDateOfBirth" value="${requestScope.DTO.dateOfBirth}"/>
            <br/>
            Role : <input type="text" name="txtRole" value="${requestScope.DTO.role}"/>
            <font color="red">
            ${requestScope.INVALID.roleError}
            </font>
            <br/>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="action" value="Update"/>
        </form>
    </body>
</html>
