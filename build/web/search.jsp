<%-- 
    Document   : search
    Created on : Jul 10, 2018, 12:54:23 AM
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
        <h1>Search Page</h1>
        <form action="MainController" method="POST">
            Search : <input type="text" name="txtSearch"/>
            <font color="red">
            ${requestScope.INVALID.avengerNameError}
            </font>
            <br/>
            <input type="submit" name="action" value="Search"/>
            <input type="submit" name="action" value="ListAvenger"/>
        </form>
    <c:if test="${requestScope.INFO != null}">
        <c:if test="${not empty requestScope.INFO}" var="table">
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>AvengerName</th>
                    <th>Fullname</th>
                    <th>DateOfBirth</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
            <tbody>
                <tr>
                    <td>${counter.count}</td>
                    <td>${dto.username}</td>
                    <td>${dto.avengerName}</td>
                    <td>${dto.fullname}</td>
                    <td>${dto.dateOfBirth}</td>
                    <td>${dto.role}</td>
                    <td>
                        <c:url var="deleteLink" value="MainController">
                            <c:param name="action" value="Delete"/>
                            <c:param name="id" value="${dto.username}"/>
                            <c:param name="txtSearch" value="${param.txtSearch}"/>
                        </c:url>
                        <a href="${deleteLink}">Delete</a>
                    </td>
                    <td>
                        <form action="MainController" method="POST">
                            <input type="hidden" name="id" value="${dto.username}"/>
                            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                            <input type="submit" name="action" value="Edit"/>
                        </form>
                    </td>
                </tr>
            </tbody>
            </c:forEach>
        </table>
        </c:if>
        <c:if test="${!table}">
            No record found!
        </c:if>
    </c:if>
    </body>
</html>
