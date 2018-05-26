<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<script type="text/javascript" src="resources/js/validation.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/me.css">
<style>body {
	
	background-color:light;
}</style>
</head>
<body>
	<div class="container" style="margin-top: 9%">
		<div class="row">
			<div class="lghead">
				<h1>Worker Finder System</h1>
			</div>
		</div>
		<div class="row">
			<div
				class="col-xs-12 col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 ">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="lghead">
							<h2
								style="text-shadow: 3px 2.5px 2.5px #1a1aff; color: red; font-weight: bold;">
								Admin <font style="color: red;">Panel</font>
							</h2>
						</div>
						<form class="form-horizontal" role="form" action="LoginController"
							method="post" onsubmit="return validation">
							<div align="center" style="color: red">${LoginFail}</div>
							<div align="center" style="color: blue">${logout}</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="username">UserName:</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="username"
										placeholder="Enter Username" name="uname">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="passwords">Password:</label>
								<div class="col-sm-6">
									<input type="password" class="form-control" id="pwd"
										placeholder="Enter password" name="pass">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-log-in"></span> Login
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="resources/js/jquery-2.2.0.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>