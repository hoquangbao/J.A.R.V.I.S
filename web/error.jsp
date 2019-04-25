<%-- 
    Document   : error
    Created on : Jul 4, 2018, 2:07:12 AM
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
        <h1>Error Page</h1>
        <h2>
            <font color="red">
            ${requestScope.ERROR}
            </font>
        </h2>
    </body>
</html>
