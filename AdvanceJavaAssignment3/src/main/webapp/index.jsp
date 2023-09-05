<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	 <style>
	.card-body{
	 border:2px solid #00bfff;
	 border-radius:5px;
	 }
	 .container{
	 padding-left:60px;
	 padding-right:60px;
	 padding-top:20px;
	 }
	 
	 </style>
</head>
<body>
<div class="container" >
  <div class="card">
   <div class="card-body" style="background:#BEECF8">
    <form action="check" method="post" >
      <h1  >Login Form</h1>
      <hr>
     <div class="form-group row" >
      <label for="UserName" class="col-sm-2 col-form-label">User
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="UserName"
        required>
      </div>
     </div>

     <div class="form-group row">
      <label for="Password" class="col-sm-2 col-form-label">
      Password</label>
      <div class="col-sm-7">
       <input type="Password" class="form-control" name="Password" required>
      </div>
     </div>
     <hr>
     <button type="submit" class="btn btn-primary">Login >></button>
    </form>
   </div>
  </div>
 </div>
 
</body>
</html>