<%-- 
    Document   : insertmission
    Created on : Jul 14, 2018, 1:05:04 AM
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
        <h1>Insert Page</h1>
        <font color="red">
        ${requestScope.ERROR}
        </font>
        <form action="MainController" method="POST">
            MissionID : <input type="text" name="txtMissionID"/>
            <font color="red">
            ${requestScope.INVALID.missionIDError}
            </font>
            <br/>
            MissionDescription : <input type="text" name="txtMissionDescription"/>
            <br/>
            MissionStatus : <input type="text" name="txtMissionStatus"/>
            <font color="red">
            ${requestScope.INVALID.missionStatusError}
            </font>
            <br/>
            <input type="submit" name="action" value="InsertMission"/>
        </form>
    </body>
</html>
