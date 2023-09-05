<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
<style>
body {
	background-image:
		url("https://cdn.pixabay.com/photo/2016/06/01/06/26/open-book-1428428_1280.jpg");
}

.registration {
	margin-left: 26em;
	margin-top: 8em;
}

form {
	border: 2px double black;
	border-radius: 8px;
	height: 20em;
	width: 27em;
	padding-left: 2em;
	background-color:rgba(0, 0, 0, 0.5);
	color:white;
	
}

input {
	margin: 1.5em;
}

.btn {
	color: #2834a7;
	border-color: #2834a7
}

.btn:hover {
	background-color: #2834a7;
}
</style>
</head>

<body>
	<div class="head"><jsp:include page="header.jsp" /></div>
	<div class="container">

		<div class="registration">
			<h3>Please Register yourself first</h3>
			<form action="adduser" method="post" modelAttribute="user">
				<table>
					<tr>
						<div class="form-group">
							<td><label> Username : </label></td>
							<td><input type="text" name="uname"
								placeholder="Enter Username" required="required" /></td>

						</div>
					</tr>
					<tr>
						<div class="form-group">
							<td><label>Password :</label></td>
							<td><input type="password" name="password"
								placeholder="Enter your Password" required="required" /></td>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<td><label>Confirm Password :</label></td>
							<td><input type="password" name="password2"
								placeholder="Enter your Password" required="required" /></td>
						</div>
					</tr>
					<tr>
						<td></td>
						<td><div class="button">
								<button class="btn btn-outline-success">SUBMIT</button>
							</div></td>
					</tr>

				</table>

			</form>
			<c:if test="${error!=null}">
				<h4 style="color: #b30000">
					<c:out value="${error}" />
				</h4>
			</c:if>
		</div>

	</div>
	<div class="foot"><jsp:include page="footer.jsp" /></div>
</body>
</html>