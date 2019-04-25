<%-- 
    Document   : admin
    Created on : Jul 4, 2018, 2:06:32 AM
    Author     : PC
--%>

<%@page import="baohq.dtos.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome ${sessionScope.USER}!</h1>
        <a href="insert.jsp">Add new Avenger</a>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="SearchAvenger"/>
            <input type="submit" name="action" value="SearchMark"/>
            <input type="submit" name="action" value="SearchMission"/>
        </form>
        
    </body>
</html>
