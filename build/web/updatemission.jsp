<%-- 
    Document   : updatemission
    Created on : Jul 12, 2018, 2:32:18 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Page</h1>
        <font color="red">
        ${requestScope.ERROR}
        </font>
        <form action="MainController" method="POST">
            MissionID : <input type="text" name="txtMissionID" value="${param.id}" readonly="true"/>
            <font color="red">
            ${requestScope.INVALID.missionIDError}
            </font>
            <br/>
            AvengerID : <input type="text" name="txtUsername" value="${param.username}"/>
            <font color="red">
            ${requestScope.INVALID.usernameError}
            </font>
            <br/>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="hidden" name="username" value="${param.username}"/>
            <input type="hidden" name="id" value="${param.id}"/>
            <input type="submit" name="action" value="UpdateMission"/>
        </form>
    </body>
</html>
