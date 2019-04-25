<%-- 
    Document   : searchmark
    Created on : Jul 10, 2018, 1:52:34 AM
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
        <h1>Search Page</h1>
        <a href="insertmark.jsp">Insert new mark</a>
        <form action="MainController" method="POST">
            MarkID : <input type="text" name="txtSearchMark"/>
            <font color="red">
            ${requestScope.INVALID.markIDError}
            </font>
            <br/>
            <input type="submit" name="action" value="SearchMarkAdmin"/> 
        </form>
            <c:if test="${requestScope.MARKINFO != null}">
                <c:if test="${not empty requestScope.MARKINFO}" var="table">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>MarkID</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${requestScope.MARKINFO}" var="dtoMark" varStatus="counter">
                <tbody>
                    <tr>
                        <td>${counter.count}</td>
                        <td>${dtoMark.markID}</td>
                        <td>
                            <c:url var="deleteLink" value="MainController">
                                <c:param name="action" value="DeleteMark"/>
                                <c:param name="id" value="${dtoMark.markID}"/>
                                <c:param name="txtSearchMark" value="${param.txtSearchMark}"/>
                            </c:url>
                            <a href="${deleteLink}">Delete</a>
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
