<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book Details</title>

<style>
.form {
	margin-left: 26em;
	margin-top: 5em;
	padding: 10px;
}

body {
	background-image:url("https://cdn.pixabay.com/photo/2016/06/01/06/26/open-book-1428428_1280.jpg")	
}

td {
	padding: 10px;
	border-radius: 10px;
}

form {
	border: 2px groove black;
	border-radius: 10px;
	height: 400px;
	width: 370px;
	background-color:rgba(0, 0, 0, 0.5);
	color:white;
}
fieldset{
border:none;}
</style>
<script>
	function resetForm() {
		document.getElementById("form").reset();
	}
</script>
</head>
<body>
	<div class=container>
		<div class="head"><jsp:include page="header.jsp" /></div>
		<fieldset>
			<div class="form" >
				<form  action="addBook" method="post" modelAttribute="book" id="form">
					<center>
						<h2>
							<c:out value="${page }" />
							BOOK DETAILS
						</h2>
					</center>

					<hr>
					<table class="addDeatils" style="margin: 3em;">
						<tr>
							<td>Book Code:</td>
							<td><c:if test="${page.equals('ADD')}">
									<input type="text" name="bCode" required="required"
										value="${bCode }">
								</c:if> <c:if test="${page.equals('EDIT')}">
									<input type="text" name="bCode" required="required"
										value="${bCode }" readonly />
								</c:if></td>

						</tr>
						<tr>
							<td>Book Name:</td>
							<td><input type="text" name="bName" value="${bName }"
								required="required" /></td>

						</tr>
						<tr>

							<td>Author:</td>
							<td><select name="bAuthor">
									
									<c:if test="${page.equals('EDIT')}">
										<option value="${bAuthor }" label="${bAuthor }"></option>
									</c:if>
									<c:forEach items="${authorList }" var="author">
										<option value="${author.getName()}"
											label="${author.getName()}" />
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>Added On:</td>
							<td><input id="current_date" name="addedDate"
								value="${baddedDate}" readonly /></td>
						</tr>

						<tr>
							<td>
								<button class="btn btn-outline-success">SUBMIT</button>
							</td>
							<td><input type="button" onclick="resetForm()" value="RESET" />
							</td>
							
						</tr>
					</table>

				</form>

			</div>
		</fieldset>
		<div class="foot"><jsp:include page="footer.jsp" /></div>
	</div>
</body>
</html>
