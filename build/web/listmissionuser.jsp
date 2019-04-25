<%-- 
    Document   : listmissionuser
    Created on : Jul 15, 2018, 11:02:02 AM
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
        <h1>List Mission</h1>
        <c:if test="${requestScope.LISTMISSION != null}">
            <c:if test="${not empty requestScope.LISTMISSION}" var="table">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>MissionID</th>
                            <th>MissionDescription</th>
                            <th>MissionStatus</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.LISTMISSION}" var="dtoMission" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dtoMission.missionID}</td>
                                <td>${dtoMission.missionDescription}</td>
                                <td>${dtoMission.missionStatus}</td>
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
