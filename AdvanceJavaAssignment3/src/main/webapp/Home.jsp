<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.hibernate.*"%>
<%@page import="com.nagarro.training.Utility.HibernateUtility"%>
<%@page import="com.nagarro.training.Entity.*"%>
<%@page import="com.nagarro.training.Utility.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Blob" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Management </title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
.btn {
	border: 1px solid black;
	background:#34F0F4;
}

form {
	margin: 2px;
}

body {
margin:10px;
	padding: 10px;
}

table, th, td, tr {
	border: 2px solid black;
	text-align: center;
}

table {
	width: 70em;
	margin-left: 50px;
}

.title {
	margin-top: 2em;
	margin-bottom: 2em;
	margin-left: 20em;
}

.profile {
	margin-left: 4em;
	margin-top: 4em;
}
.editRow{
border-radius:10px;
}
</style>

</head>


<body style="background: aliceblue;">

	<div class="Header row">
		<div class="col-sm-6 title">
			<h3>
				<b>Product Management Tool</b>
			</h3>
		</div>
		<div class="profile">
			<form action="index.jsp">Hi, <%=session.getAttribute("uname")%>  <button class="btn">Logout</button></form>
		</div>
	</div>
	<form action="add" method="post">

		<b>Please enter product detail to add to stock</b>
       
		<div class="form-group row">
			<label for="Title" class="col-sm-1">Title </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id ="Title" name="Title" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="Quantity" class="col-sm-1 "> Quantity</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id ="Quantity" name="Quantity" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="Size" class="col-sm-1 col-form-label"> Size</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id ="Size" name="Size" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="Image" class="col-sm-1 col-form-label"> Image</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="Image" name="Image" >
				
			</div>
			</input>
		</div>
		<button type="submit" class="btn">SUBMIT</button>
	</form>

	<hr>
	<table class="w3-table-all" id="mytable">
		<thead>
			<tr>
				<th>Sno</th>
				<th>Title</th>
				<th>Quantity</th>
				<th>Size</th>
				<th>Image</th>
				<th>Action</th>
			</tr>
		</thead>
		<%
		String name = (String) session.getAttribute("uname");
		Session sess = HibernateUtility.getSessionFactory().openSession();
		Transaction tc = sess.beginTransaction();
		Query query = sess.createQuery("from User where name=:uname");
		query.setParameter("uname", name);
		
		User u = (User) query.getSingleResult();

		String str = "from Products where user_id_id=" + "'" + u.getId() + "'";
		Query q2 = sess.createQuery(str);
		List<Products> li = q2.list();
		tc.commit();
		int count = 1;
		
		for (Products p : li) {
			
	   %>

		<tr>
			<td><%=count%></td>
			<td><%=p.getTitle()%></td>
			<td><%=p.getQuantity()%></td>
			<td><%=p.getSize()%></td>
			
			<td><img src="data:image/jpg;base64,<%=Base64.getEncoder().encodeToString(p.getImage())%>"
				style="width: 100px; height: 100px;"></td>
			<td style="border:none;">
			<div class="change">
			<% session.setAttribute("productId", p.getSno());%>
			 <form action="editPage" method="post" >
			 <div class="editRow" >
			 <button><img id="editButton" style="width: 25px; height: 25px;" src="https://fontawesomeicons.com/images/png/black/edit/outline-4x.png" ></button> 
			 <input  type="hidden" name="Id" value=<%=p.getSno()%>></input>
			         Edit 
			  </div>
			 </form>
			 
			 <form action="delete" method="post"><div class="deleteRow">
			 <button>
			 <img id="editButton" style="width: 25px; height: 25px;" src="https://fontawesomeicons.com/images/png/black/delete/outline-4x.png"></button>Delete
			 	 <input type="hidden" name="Id" value=<%=p.getSno()%>></input>
			 </div>
			 </form>
			</div></td>
		</tr>


		<%	
		count += 1;
		}
		%>
	</table>
	

</body>
</html>