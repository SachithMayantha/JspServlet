<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Add User</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	 	
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
							<label>User ID (maximum 3 numbers only)</label> <input type="text" class="form-control"
							name="id" required="required" maxlength="3"
							placeholder="Enter your ID" autofocus>
						</fieldset>

						<fieldset class="form-group">
							<label>User Name (0-15 characters only)</label> <input type="text" class="form-control"
							name="username" required="required" pattern="[A-Za-z\s]{0,15}"
							placeholder="Enter your username">
						</fieldset>

						<fieldset class="form-group">
							<label>User Password (must be 8-15 characters only)</label> <input type="password" class="form-control"
							name="password" required="required" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}"
							 placeholder="Enter the password">
						</fieldset>

						<fieldset class="form-group">
							<label>User Department</label> <input type="text" class="form-control"
							name="department" list="department"
							placeholder="Select the department">
							<datalist id="department">
							    <option value="Technical">
							    <option value="Finance">
							    <option value="Marketing">
							    <option value="Transportation">
							    <option value="HR">
							  </datalist>
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