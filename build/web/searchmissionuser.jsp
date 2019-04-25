<%-- 
    Document   : searchmissionuser
    Created on : Jul 15, 2018, 10:47:45 AM
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
        <h1>Search Mission</h1>
        <form action="MainControllerUser" name="POST">
            MissionID: <input type="text" name="txtSearchMission"/>
            <font color="red">
            ${requestScope.INVALID.missionIDError}
            </font>
            <br/>
            <input type="submit" name="action" value="SearchMissionUser"/>
            <input type="submit" name="action" value="AllListMission"/>
        </form>
        <c:if test="${requestScope.MissionINFO != null}">
            <c:if test="${not empty requestScope.MissionINFO}" var="table">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>MissionID</th>
                            <th>AvengerID</th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.MissionINFO}" var="dtoMission" varStatus="counter">
                        <tbody>
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dtoMission.missionID}</td>
                                <td>${dtoMission.username}</td>
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
