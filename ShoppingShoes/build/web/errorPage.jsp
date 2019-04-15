<%-- 
    Document   : errorPage
    Created on : Oct 27, 2018, 10:30:35 PM
    Author     : vtkth
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
    </head>
    <body>
        <c:if test="${requestScope.ERROR=='invalid_account'}">
            <h1>
                <font color="red">Invalid username or password!!!</font>
            </h1>

            Click <a href="login.html">here</a> to try again!!!<br/>
            Click <a href="register.html">here</a> to register.
        </c:if>
    </body>
</html>
