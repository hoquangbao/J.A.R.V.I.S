<%-- 
    Document   : searchmission
    Created on : Jul 11, 2018, 8:28:46 PM
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
        <a href="insertmission.jsp">Insert New Mission</a>
        <form action="MainController" name="POST">
            MissionID: <input type="text" name="txtSearchMission"/>
            <font color="red">
            ${requestScope.INVALID.missionIDError}
            </font>
            <br/>
            <input type="submit" name="action" value="SearchMissionAdmin"/>
            <input type="submit" name="action" value="ShowAllListMission"/>
            <input type="submit" name="action" value="SetMission"/>
        </form>
        <c:if test="${requestScope.MissionINFO != null}">
            <c:if test="${not empty requestScope.MissionINFO}" var="table">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>MissionID</th>
                            <th>AvengerID</th>
                            <th>Delete</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.MissionINFO}" var="dtoMission" varStatus="counter">
                        <tbody>
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dtoMission.missionID}</td>
                                <td>${dtoMission.username}</td>
                                <td>
                                    <c:url var="deleteLink" value="MainController">
                                        <c:param name="action" value="DeleteMission"/>
                                        <c:param name="id" value="${dtoMission.missionID}"/>
                                        <c:param name="txtSearchMission" value="${param.txtSearchMission}"/>
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <form action="MainController" method="POST">
                                        <input type="hidden" name="id" value="${dtoMission.missionID}"/>
                                        <input type="hidden" name="username" value="${dtoMission.username}"/>
                                        <input type="hidden" name="txtSearchMission" value="${param.txtSearchMission}"/>
                                        <input type="submit" name="action" value="EditMission"/>
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
