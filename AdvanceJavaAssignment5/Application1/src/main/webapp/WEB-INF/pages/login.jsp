<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
<style>
fieldset {
	border: 2px groove #ddd !important;
	border-radius: 9px;
	padding: 20px !important;
	width: 50%;
	display: block;
	background-color:rgba(0, 0, 0, 0.5);
	color:white;
}

fieldset:hover {
	background: rgba(0,0,0,0.3);
}

body {
	background-image:
		url("https://cdn.pixabay.com/photo/2016/06/01/06/26/open-book-1428428_1280.jpg");
	margin: auto;
}

table, td {
	padding: 10px;
	margin-left: 3.5em;
	font-size: 18px
}

.loginfieldset {
	margin-top: 7em;
	margin-left: 25em;
	padding:
}

.newuser {
	background-color: rgb(38, 38, 217);
	border: 1px groove blue;
	width: 30em;
	height: 3.5em;
	border-radius: 6px;
	
}

.newuser:hover {
	background-color: rgb(38, 38, 239);
	color: white;
}

.btn {
	width: 6em;
	height: 2.5em;
	margin-left: 20px;
}

.button {
	margin-right: -20px;
}

</style>
<title>Login Page</title>
</head>

<body>
	<div class="container">
		<div class="head"><jsp:include page="header.jsp" /></div>

		<div class="loginfieldset">
			<fieldset>
				<legend>
					<h3>
						<strong>Login</strong>
					</h3>
				</legend>
				<form action="verify" method="post" modelAttribute="user">
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
							<td></td>
							<td><div class="button">
									<button class="btn btn-outline-success">LOGIN</button>
								</div></td>
						</tr>

					</table>

				</form>
				<form action="newUser" method="post">
					<div>
						<input class="newuser" type="submit" value="NEW USER??" />
					</div>
				</form>
				<div>
					<c:if test="${error!=null }">
						<h4 style="color: #b30000">
							<c:out value="${error}" />
						</h4>
					</c:if>
					<%-- <c:if test="${success!=null }">
						<h4 style="color: green">
							<c:out value="${success}" />
						</h4>
					</c:if> --%>
				</div>
			</fieldset>
		</div>


		</fieldset>

		<div class="foot"><jsp:include page="footer.jsp" /></div>
	</div>
</body>
</html>
