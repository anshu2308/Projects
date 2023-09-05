<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Login Page</title>
</head>
<body  style="background: #ccffff "">
	<div class="container mt-3">
		<h1 class="text-center" style="font:Arial;color:#80b3ff">Welcome to Product Management</h1>

		<div class="card col-md-8 " style="margin-left: 11em;background:rgba(200,0,0,0.1); padding:2em">
			<div class="card-body">
				<header><h3>LOGIN FORM</h3></header>
				<hr>

				<form action="verify" method="post" modelAttribute="user">
					<div class="form-group">
						Username : <input type="text" name="uname"
							placeholder="Enter Username" required="required"/>

					</div>
					<div class="form-group">
						Password   : <input type="password" name="password"
							placeholder="Enter your Password" required="required"/>

					</div>
					<div class="container text-center">
						<button class="btn btn-outline-success">Login>></button>
					</div>

				</form>
<div>
		  <c:if test="${error !=null }">
   <h4 style="color:red;margin-top:20px;magin-bottom:5px;"><c:out value="${error}"/></h4>
   </c:if>
		</div>

			</div>
		</div>
		


	</div>


	
</body>