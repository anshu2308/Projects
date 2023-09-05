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
<style>

td,th{
padding:1em;
}

</style>
<title>Search Page</title>
</head>
<body  style="background: #ccffff 
	;margin:3em;" >
	<div class="container mt-3">
		<h1 class="text-center" style="color:#80b3ff">Product Search Page</h1>

		
		<hr>
		
				<header><h3><u>SEARCH FORM</u></h3></header>
				
				<form action="addUserInput" method="post" modelAttribute="userInput">
					<table class=
					 style="margin:3em;">
						<tr>
							<td>COLOR:</td>
							<td><input type="text" name="color" required="required" /></td>

						</tr>
						<tr>
							<td>SIZE:</td>
							<td>
									<select name="size">
										<option value="NONE" label="-Select-" ></option>
										<c:forEach items="${sizeList }" var="size">
										 <option value="${size }"  label="${ size}"/>
										 </c:forEach>
									</select>
									
							</td>
							

						</tr>
						<tr>

							<td>GENDER:</td>
							<td><input type="radio" name="gender" value="M" />Male <input
								type="radio" name="gender" value="F" />Female</td>


						</tr>
						<tr>
							<td>OUTPUT PREFERENCE:</td>
							<td><input type="checkbox" name="preference" value="Price" />Price
								<input type="checkbox" name="preference" value="Rating" />Rating</td>

						</tr>
						<tr>
							<td colspan="2">
								<button class="btn btn-outline-success">SEARCH</button>
						</tr>
					</table>
				</form>
			
   <c:if test="${message!=null }">
   <h4 style="color:red">***Enter Full details</h4>
   </c:if>

		
		<c:if test="${list.size()>0}">
		<header><h3><u>Available Tshirts</u></h3></header>
			<table border=1 >
				<thead>
					<tr style="background:#80b3ff">
						<th><strong>ID</strong></th>

						<th><strong>NAME</strong></th>

						<th><strong>COLOR</strong></th>

						<th><strong>GENDER</strong></th>

						<th><strong>SIZE</strong></th>

						<th><strong>PRIZE</strong></th>

						<th><strong>RATING</strong></th>

						<th><strong>AVAILABILITY</strong></th>
					</tr>
				</thead>
				<c:forEach items="${list}" var="tshirt">
					<tr>
						<td><b><c:out value="${tshirt.getId() }" /></b></td>
						<td><c:out value="${tshirt.getName() }" /></td>
						<td><c:out value="${tshirt.getColor() }" /></td>
						<td><c:out value="${tshirt.getGender() }" /></td>
						<td><c:out value="${tshirt.getSize() }" /></td>
						<td><c:out value="${tshirt.getPrice() }" /></td>
						<td><c:out value="${tshirt.getRating() }" /></td>
						<td><c:out value="${tshirt.getAvailability() }" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${list.size()<=0 }">
		<header><h3><u>No matching results...</u></h3></header>
		</c:if>
	</div>


</body>