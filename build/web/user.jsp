<%-- 
    Document   : user
    Created on : Jul 4, 2018, 2:06:50 AM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome ${sessionScope.USER}</h1>
        <form action="MainControllerUser" method="POST">
            <input type="submit" name="action" value="SearchUser"/>
            <input type="submit" name="action" value="SearchMark"/>
            <input type="submit" name="action" value="SearchMission"/>
        </form>
    </body>
</html>
