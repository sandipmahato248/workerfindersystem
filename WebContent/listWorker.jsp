<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/me.css">
<%@ include file="header.jsp" %>
</head>
<body>
	<ul class="topnav">
		<li><a href="home.jsp">Home</a></li>
		<li><a  href="WorkerController?actions=add">Add
				Worker</a></li>
		<li><a class="active" href="#">Worker List</a></li>
		<li><a href="LogoutController">Logout</a></li>
		<li class="right"><a href="about.jsp">About</a></li>
	</ul>
	<h1>Worker List</h1>
	<br>
	<br>
	<c:if test="${!empty workerList}">
		<div class="container-fluid">
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading"
						style="font-size: 20px; font-weight: bold; color: #004080">
						<center>Worker List</center>
					</div>
					<a href="WorkerController?actions=add"
						class="btn btn-primary navbar-btn">Add Worker <span
						class="glyphicon glyphicon-user"></span></a>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>Id</th>
										<th>Worker Name</th>
										<th>Work Category</th>
										<th>Gender</th>
										<th>Phone</th>
										<th>Address</th>
										<th>Wages</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${workerList}" var="worker">
										<tr>
											<td><c:out value="${worker.id}" /></td>
											<td><c:out value="${worker.workerName}" /></td>
											<td><c:out value="${worker.workCategory}" /></td>
											<td><c:out value="${worker.gender}" /></td>
											<td><c:out value="${worker.phone}" /></td>
											<td><c:out value="${worker.address}" /></td>
											<td><c:out value="${worker.wages}" /></td>
											<td><a
												href="WorkerController?actions=edit&id=<c:out value="${worker.id}"/>"
												class="btn btn-warning navbar-btn"><span
													class="glyphicon glyphicon-pencil"></span>EDIT</a> <a
												href="WorkerController?actions=delete&id=<c:out value="${worker.id}"/>"
												class="btn btn-warning navbar-btn"><span
													class="glyphicon glyphicon-remove"></span>DELETE</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<script src="resources/js/jquery-2.2.0.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>

</body>
</html>