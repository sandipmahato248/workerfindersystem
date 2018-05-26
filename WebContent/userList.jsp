<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Details</title>
<%@ include file="header.jsp" %>
</head>
<body>
<body>
<a href="UserController?action=insert">Add user</a>

	<h1>User List</h1>
	
	<c:if test="${!empty users}">
		<table>
			<thead>
				<tr>
					<th>User Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>DOB</th>
					<th>Actions</th>
				</tr>

			</thead>
	<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.userId}" /></td>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.dob}" /></td>
					<td><a href="UserController?action=edit&userid=<c:out value="${user.userId}"/>">Update</a> 
										<a href="UserController?action=delete&userid=<c:out value="${user.userId}"/>">Delete</a></td>
			</c:forEach>
			
</tbody>

		</table>






	</c:if>

</body>
</html>