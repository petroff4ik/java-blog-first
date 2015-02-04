<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
		<form:form method="POST" action="/user/registration" commandName="user">
			<table>
				<tr>
					<td><form:label path="username"><spring:message
						code="label.name" /></form:label></td>
			<td><form:input path="username" />	</td>
			<td><form:errors path="username" cssclass="error"></form:errors></td>
			</tr>

			<tr>
				<td><form:label path="password">Password</form:label></td>
			<td><form:input type="password" path="password" />	</td>
			<td><form:errors path="password" cssclass="error"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="repassword">Re password</form:label></td>
			<td><form:input path="repassword" type="password" />	</td>
			<td><form:errors path="repassword" cssclass="error"></form:errors></td>
			</tr>

			<tr>
				<td><form:label path="email">Email</form:label></td>
			<td><form:input  path="email" />	</td>
			<td><form:errors path="email" cssclass="error"></form:errors></td>
			</tr>

			<tr>
				<td><form:label path="profile">Profile</form:label></td>
			<td><form:input path="profile" />	</td>
			<td><form:errors path="profile" cssclass="error"></form:errors></td>
			</tr>



			<tr>
				<td colspan="2"><input type="submit" value='<spring:message code="label.registration" />'/></td>
	</tr>
</table>  
</form:form>
</body>
</html>