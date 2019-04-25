<%-- 
    Document   : searchforuser
    Created on : Jul 15, 2018, 9:52:43 AM
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
        <h1>Hello World!</h1>
        <form action="MainControllerUser" method="POST">
            Search : <input type="text" name="txtSearchUser"/>
            <font color="red">
            ${requestScope.INVALID.avengerNameError}
            </font>
            <br/>
            <input type="submit" name="action" value="Search "/>
            <input type="submit" name="action" value="AllListAvenger"/>
        </form>
    <c:if test="${requestScope.INFOUSER != null}">
        <c:if test="${not empty requestScope.INFOUSER}" var="table">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Username</th>
                        <th>AvengerName</th>
                        <th>Fullname</th>
                        <th>DateOfBirth</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <c:forEach items="${requestScope.INFOUSER}" var="dto" varStatus="counter">
                    <tbody>
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.username}</td>
                            <td>${dto.avengerName}</td>
                            <td>${dto.fullname}</td>
                            <td>${dto.dateOfBirth}</td>
                            <td>${dto.role}</td>
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
