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


	<c:if test="${!empty workers}">
		<div class="container-fluid">
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading"
						style="font-size: 20px; font-weight: bold; color: #004080">
						<center>Search Result</center>
					</div>

					<div class="panel-body">
						<div class="table-responsive">
							<table class="table">

								<thead>
									<tr>
										<th>Worker Name</th>
										<th>Work Category</th>
										<th>Gender</th>
										<th>Phone</th>
										<th>Address</th>
										<th>Wages</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${workers}" var="worker">
										<tr>
											<td><c:out value="${worker.workerName}" /></td>
											<td><c:out value="${worker.workCategory}" /></td>
											<td><c:out value="${worker.gender}" /></td>
											<td><c:out value="${worker.phone}" /></td>
											<td><c:out value="${worker.address}" /></td>
											<td><c:out value="${worker.wages}" /></td>
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
	<div class="search">${msg}</div>
	
	
	<script src="resources/js/jquery-2.2.0.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>