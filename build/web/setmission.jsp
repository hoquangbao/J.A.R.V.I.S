<%-- 
    Document   : setmission
    Created on : Jul 15, 2018, 1:31:35 AM
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
        <h1>Set New Mission</h1>
        ${requestScope.ERROR}
        <form action="MainController" method="POST">
            MissionID : <input type="text" name="txtMissionID"/>
            <font color="red">
            ${requestScope.INVALID.missionIDError}
            </font>
            <br/>
            AvengerID : <input type="text" name="txtUsername"/>
            <font color="red">
            ${requestScope.INVALID.usernameError}
            </font>
            <br/>
            <input type="submit" name="action" value="SetNewMission"/>
        </form>
    </body>
</html>
