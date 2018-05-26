<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<%--@ include file="header.jsp"--%>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/me.css">
<style>body {
	/* background-image: url("resources/images/createbg.jpg"); */
	background-color: brown;
}</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<h1>Welcome to Worker Finder System</h1>
		</div>
	</div>
	<hr>
	<div class="container">
		<div class="row">
			<div
				class="col-xs-12 col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 ">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="lghead">
							<h2
								style="text-shadow: 3px 2.5px 2.5px grey; color: black; font-weight: bold;">
								Search <font style="color: black;">Worker</font>
							</h2>
						</div>
						<form class="form-horizontal" role="form"
							action="SearchController" method="post">
							<div class="form-group">
								<label class="control-label col-sm-4" for="search">
									By Category </label>
								<div class="col-sm-6">
									<!-- <label class="control-label col-sm-4" for="search">
									select list:</label> --> 
									<select name="work_category"
										class="form-control" id="search">
										<option>mason</option>
										<option>cleaner</option>
										<option>electrician</option>
										<option>painter</option>
										<option>mechanic</option>
										<option>carpanter</option>
										<option>plumber</option>
										<option>driver</option>
									</select>
								</div>
								<br>
								<br>
								<label class="control-label col-sm-4" for="search">
									By Address </label>
								<div class="col-sm-6">
									<!-- <label class="control-label col-sm-4" for="search">select list:</label>  -->
									<select name="address"
										class="form-control" id="search">
										<option>damak</option>
										<option>kathmandu</option>
										<option>lalitpur</option>
										<option>bhaktapur</option>
										<option>biratnagar</option>
										<option>balkumari</option>
										<option>lagankhel</option>
										<option>butwal</option>
										<option>pokhara</option>
										<option>hetauda</option>
										<option>chitwan</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-search"></span> Search
									</button>
								</div>
							</div>
						</form>
						<center>${msg}</center>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="sandip">
			<a href="createWorker.jsp">Register as New Worker</a><br><br>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<img src="resources/images/download.jpeg" alt="Lights" style="width: 100%">
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<img src="resources/images/images (1).jpeg" alt="Nature" style="width: 100%">
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<img src="resources/images/images.png" alt="Fjords" style="width: 100%">
				</div>
			</div>
			
		</div>
	</div>
	<script src="resources/js/jquery-2.2.0.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>