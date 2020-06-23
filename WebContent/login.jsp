<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		<title>Login Page</title>
	</head>

	<body>
		<div class="container">
  		<div class="jumbotron">
			<h2>Login Form</h2><br><br>
			<form class="form-horizontal" action="login" method="post">
			  <div class="form-group"><br>
			    <label class="control-label col-sm-2" for="username">Username :</label>
			    <div class="col-sm-10">
			      <input type="username" class="form-control" id="username" name="un" placeholder="Enter username">
			    </div><br><br>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="pwd">Password :</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="pwd" name="pw" placeholder="Enter password">
			    </div><br>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label><input type="checkbox">Remember me</label>
			      </div>
			    </div>
			  </div><br>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" value="LOGIN" class="btn btn-success">Login</button>
			    </div>
			  </div>
			</form><br><br>
		</div>
		</div>
	</body>
</html>