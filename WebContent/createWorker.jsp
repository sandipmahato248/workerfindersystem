<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/me.css">
<style>
body {
	/* background-image: url("resources/images/createbg.jpg"); */
	background-color: maroon;
}
</style>
<%@ include file="header.jsp" %>
</head>
<body>
	<ul class="topnav">
		<li><a href="home.jsp">Home</a></li>
		<li><a class="active" href="#">Add Worker</a></li>
	
		<li><a href="LogoutController">Logout</a></li>
		<li class="right"><a href="about.jsp">About</a></li>
	</ul>
	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading"
					style="font-size: 20px; font-weight: bold; color: #004080">
					<center>Register Worker</center>
				</div>
				<div class="panel-body" style="background-color: silver;">
					<form class="form-horizontal" role="form" action="WorkerController"
						method="post">
						<input type="hidden" name="id" value="${worker.id}">
						<div class="form-group">
							<label class="control-label col-sm-4" for="wname">Worker
								Name:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="wname" name="wname"
									value="${worker.workerName}">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="workcategory">Work
								Category:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="workcategory"
									name="workcategory" value="${worker.workCategory}">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="address">Address:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="address"
									name="address" value="${worker.address}">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="phone">Phone:</label>
							<div class="col-sm-4">
								<input type="number" class="form-control" id="phone"
									name="phone" value="${worker.phone}">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="wages">Wages:</label>
							<div class="col-sm-4">
								<input type="number" class="form-control" id="wages"
									name="wages" value="${worker.wages}">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="gender">Gender:</label>
							<div class="col-sm-4">
								<input type="radio" name="gender" value="male"
									${worker.gender=='male'?'checked':'' || worker.gender==null?'checked':''}>Male
								<input type="radio" name="gender" value="female"
									${worker.gender=='female'?'checked':''}>Female
							</div>
						</div>


						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-6">
								<button type="submit" class="btn btn-primary">
									<span class="glyphicon glyphicon-save-file"></span>Register
								</button>
								<button type="reset" class="btn btn-primary">
									<span class="glyphicon glyphicon-erase"></span>Reset
								</button>
							</div>
						</div>
					</form>
					${msg}
				</div>
			</div>
		</div>
	</div>
	<script src="resources/js/jquery-2.2.0.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>