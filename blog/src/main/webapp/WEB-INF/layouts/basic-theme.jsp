<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head> 
		<link href="/resources/style.css" rel="stylesheet" type="text/css">
			<title><decorator:title /></title>
			<decorator:head />
	</head> 
	<body>
		<table align=center border="0" cellpadding="0" cellspacing="0" class="tbl1" width="795">
			<tr> 

				<td colspan="4">

					<span style="float: right;margin-left: 20px;">
						<a href="?lang=en">en</a> 
						| 
						<a href="?lang=ru">ru</a>
					</span>
					<span style="float: right;">
						<sec:authorize access="isAuthenticated()">
							<a href="<c:url value="j_spring_security_logout"/>">Logout</a>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">

							<a href="<c:url value="user/registration"/>">Registration</a>
							<a href="<c:url value="login"/>">Login</a>

						</sec:authorize>
					</span>


				</td>
			</tr>
			<tr valign="top"> 
				<td width="60%" height="91"><img src="/resources/single_pixel.gif" width="0" height="93"></td>
				<td width="40%" height="91" colspan="3" valign="top" align="center"> 

				</td>
			</tr>
			<tr> 
				<td colspan="3"  > 
					<tr> 
						<td valign="top" colspan="4"> 
							<table width="100%" border="0" cellspacing="15">
								<tr>
									<td width="17%" valign="top"><img src="/resources/single_pixel.gif" width="60" height="1"><br>
												<div id="navcontainer">
													<ul id="navlist">
														<c:import url="/WEB-INF/jsp/navigator.jsp"/>
													</ul>
												</div>
												</td>
												<td width="100%"> 

													<decorator:body />

												</td>
												</tr>
												</table>
												<h2>&nbsp;</h2>
												</td>
												</tr>
												</table>
												<!-- Do not remove this div -->
												<div align="center"><p>
														<a href="http://www.logodesignweb.com/">Logo design web</a> 
														| <a href="http://www.logodesignweb.com/webhostingguide/">web hosting guide</a>
														| <a href="http://www.logodesignweb.com/stockphoto/">stock photos</a>
													</p>
													<br>
												</div>
												<!-- End of footer div -->

												<div style="font-size: 0.8em; text-align: center; margin-top: 1.0em; margin-bottom: 1.0em;">
													<a href="http://web-mastery.info/">Êàê ñäåëàòü ñàéò</a>
												</div>
												</body> 
												</html>