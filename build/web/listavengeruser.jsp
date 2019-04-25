<%-- 
    Document   : listavengeruser
    Created on : Jul 15, 2018, 10:27:13 AM
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
        <h1>List Avenger</h1>
        <c:if test="${requestScope.LISTAVENGER != null}">
            <c:if test="${not empty requestScope.LISTAVENGER}" var="table">
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>AvengerID</th>
                    <th>AvengerName</th>
                    <th>Fullname</th>
                    <th>DateOfBirth</th>
                    <th>Role</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.LISTAVENGER}" var="dto" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${dto.username}</td>
                    <td>${dto.avengerName}</td>
                    <td>${dto.fullname}</td>
                    <td>${dto.dateOfBirth}</td>
                    <td>${dto.role}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
            </c:if>
            <c:if test="${!table}">
                No record found!
            </c:if>
        </c:if>
    </body>
</html>
