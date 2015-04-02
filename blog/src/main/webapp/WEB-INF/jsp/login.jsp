<%-- 
    Document   : login
    Created on : Nov 7, 2014, 3:11:29 PM
    Author     : petroff
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
		   uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div id="login-box">

			<sec:authorize access="isAuthenticated()">
				<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
			</sec:authorize>


			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>

			<c:if test="${empty pageContext.request.remoteUser}">
				<h3>Login with Username and Password</h3>
				<form name='loginForm'
					  action="<c:url value='j_spring_security_check' />" method='POST'>

					<table>
						<tr>
							<td>User:</td>
							<td><input type='text' name='username' value=''></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type='password' name='password' /></td>
						</tr>
						<tr>
							<td colspan='2'><input name="submit" type="submit"
												   value="submit" /></td>
						</tr>
					</table>

				</form>
			</c:if>

		</div>

    </body>
</html>
