<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
</head>
<body>
<div class="container">
  <div class="jumbotron">
	<div class="container col-md-5">
			<div class="card">
				<div class="card-body">
					<form action="insert" method="post">
						<fieldset class="form-group">
						<h2>Add User</h2><br>
							<label>User ID</label> <input type="text" class="form-control"
							name="id" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>User Name</label> <input type="text" class="form-control"
							name="username" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>User Password</label> <input type="password" class="form-control"
							name="password" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>User Department</label> <input type="text" class="form-control"
							name="department">
						</fieldset>
						<input type="submit" class="btn btn-success" value="Save"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>