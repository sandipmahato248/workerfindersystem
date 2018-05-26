<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Page</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/me.css">
<jsp:include page="header.jsp" />
</head>
<body>
	
	<ul class="topnav">
		<li><a href="home.jsp">Home</a></li>
		<li><a href="WorkerController?actions=add">Add Worker</a></li>
		<li><a class="active" href="searchresult.jsp">Search Result</a></li>
		<li><a href="LogoutController">Logout</a></li>
		<li class="right"><a href="about.jsp">About</a></li>
	</ul>


		<div class="container-fluid">
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading"
						style="font-size: 20px; font-weight: bold; color: #004080">
						<center>About Us </center>
					</div>

					<div class="panel-body">
					Our minor project is about worker finder system.
					
					</div>
				</div>
			</div>
		</div>
	
	
	<script src="resources/js/jquery-2.2.0.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>