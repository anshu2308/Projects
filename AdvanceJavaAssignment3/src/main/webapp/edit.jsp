<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
.btn {
	border: 1px solid black;
	background: #34F0F4;
}

#editForm {
	border: 2px solid grey;
	height: 20em;
	width: 40em;
	border-radius: 8px;
	padding-top: 3em;
	padding-left: 8em;
}

input {
	margin-left: 6em;
	margin-right: 6em;
}

.body {
	margin-left: 20em;
}
</style>

</head>
<body style="background: aliceblue;">
	<%

	%>
	<div class="body mt-5">
		<h2>
			<b>Please enter product detail to edit</b>
		</h2>
		<fieldset id="editForm">

			<form action="edit" method="post">

				<div class="form-group row">
					<label for="Id" class="col-sm-1 col-form-label"> Id</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="Sno"
							value=<%=session.getAttribute("id")%> disabled="disabled">
					</div>
				</div>
				<div class="form-group row">
					<label for="Title" class="col-sm-1">Title </label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="Title" name="Title"
							value=<%=session.getAttribute("title")%> required>
					</div>
				</div>
				<div class="form-group row">
					<label for="Quantity" class="col-sm-1 "> Quantity</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="Quantity"
							name="Quantity" value=<%=session.getAttribute("quantity")%>
							required>
					</div>
				</div>
				<div class="form-group row">
					<label for="Size" class="col-sm-1 col-form-label"> Size</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="Size" name="Size"
							value=<%=session.getAttribute("size")%> required>
					</div>
				</div>
				<button type="submit" class="btn">SUBMIT</button>
			</form>
		</fieldset>
	</div>


</body>
</html>