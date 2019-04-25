<%-- 
    Document   : searchmarkuser
    Created on : Jul 15, 2018, 11:25:07 AM
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
        <h1>Search Mark</h1>
        <form action="MainControllerUser" method="POST">
            MarkID : <input type="text" name="txtSearchMark"/>
            <font color="red">
            ${requestScope.INVALID.markIDError}
            </font>
            <br/>
            <input type="submit" name="action" value="Search Mark"/> 
        </form>
            <c:if test="${requestScope.MARKINFO != null}">
                <c:if test="${not empty requestScope.MARKINFO}" var="table">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>MarkID</th>
                    </tr>
                </thead>
                <c:forEach items="${requestScope.MARKINFO}" var="dtoMark" varStatus="counter">
                <tbody>
                    <tr>
                        <td>${counter.count}</td>
                        <td>${dtoMark.markID}</td>
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
