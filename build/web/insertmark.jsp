<%-- 
    Document   : insertmark
    Created on : Jul 11, 2018, 3:19:10 PM
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
        <form action="MainController" method="POST">
            MarkID: <input type="text" name="txtMarkID"/>
            <font color="red">
            ${requestScope.INVALID.markIDError}
            </font>
            <br/>
            <input type="submit" name="action" value="InsertMark"/>
        </form>
    </body>
</html>
