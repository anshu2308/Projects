<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books Details</title>
<link rel="stylesheet" href="<c:url value="resources/style.css"/>" />

<style>
body {
	background-image:
		url("https://cdn.pixabay.com/photo/2016/06/01/06/26/open-book-1428428_1280.jpg");
	margin: auto;
	display: flex;
}

.panel {
	margin-top: 100px;
}

h2 {
	margin-left: 22em;
}

.addBook {
	margin-left: 80em;
	width: 120px;
	height: 40px;
	background-color: blue;
	border-radius: 5px;
	color: white;
	
}

.list {
	margin-left: 20em;
}

td {
	padding: 10px;
}

table {
	overflow-y: scroll;
	overflow-x: hidden;
	max-height: 300px;
	width: 670px;
	display: block;
	object-fit: cover;
	border: 2px groove black;
	border-radius: 10px;
	background-color:rgba(0, 0, 0, 0.5);
	color:white;
}


thead {
	background-color: rgb(77, 77, 77);	
}

.delete {
	width: 100px;
	height: 30px;
	border: 2px inset red;
	border-radius: 8px;
	margin: 2px;
}

.delete:hover, .edit:hover {
	background-color: rgb(192, 192, 192);
}

.edit {
	width: 100px;
	height: 30px;
	border: 2px inset green;
	border-radius: 8px;
	margin: 2px;
}


</style>

</head>
<body>
	<div class="container">
		<div class="head"><jsp:include page="header.jsp" /></div>

		<div class="panel">
			<div class="panel-heading">
				<h2>
					<u>BOOK LIST</u>
				</h2>
			</div>
			<div class="panel-body">
				<form action="newBook" method="post">
					<div>
						<button class="addBook">Add a Book</button>
					</div>

				</form>
				<div class="list">
					<table border=1>
						<thead>
							<tr>
								<td>Book Code</td>
								<td>Book Name</td>
								<td>Author</td>
								<td>Data Added</td>
								<td>Actions</td>
							</tr>
						</thead>
						<c:forEach items="${books}" var="book">
							<tr>
								<td><b><c:out value="${book.getbCode()}" /></b></td>
								<td><c:out value="${book.getbName() }" /></td>
								<td><c:out value="${book.getbAuthor() }" /></td>
								<td><c:out value="${book.getAddedDate() }" /></td>
								<td><form action="deletebooks" method="post">
										<button class="delete">Delete</button>
										<input type="hidden" name="Id" value="${book.getbCode()}"></input>
									</form>
									<form action="edit" method="post">
										<button class="edit">Edit</button>
										<input type="hidden" name="bId" value="${book.getbCode()}"></input>

									</form></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>

		</div>
		<div class="foot"><jsp:include page="footer.jsp" /></div>
	</div>

</body>
</html>