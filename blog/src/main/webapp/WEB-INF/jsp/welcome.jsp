<%-- 
    Document   : hello
    Created on : Oct 23, 2014, 10:45:56 AM
    Author     : petroff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome <c:out value="${pageContext.request.remoteUser}"/>!
		</title>
    </head>
    <body>
        <h1>Welcome <c:out value="${pageContext.request.remoteUser}"/>!</h1>
	
    </body>
</html>
