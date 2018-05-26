<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Form</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<h1>User Registration</h1>
	<form action="UserController" method="post">
	<div><label>User Id</label>
		<input type="hidden" name="user_id" value="${user.userId}"><br> <br>
		</div>
		<br>
		<div>
			<label>First Name </label><input type="text" name="first_name"
				value="${user.firstName}">
		</div>
		<br> <br>
		<div>
			<label>Last Name </label><input type="text" name="last_name"
				value="${user.lastName}">
		</div>
		<br> <br>
		<div>
			<label>Email </label><input type="text" name="email"
				value="${user.email}">
			
			<br> <br>
			<div>
				<label>DOB </label><input type="date" name="dob" value="${user.dob}">
			</div>	
				
				
				
		</div>
		<br> <br> <label>User Name: </label>
		<div>
			<input type="text" name="username" value="${user.username}">
		</div>
<div><label>Password : </label>
			<div>
				<input type="password" name="password" value="${user.password}">
			</div></div>


<div>
			<input type="submit" value="Submit"> <input type="reset"
				value="Reset">
		</div>


		


</form>
</body>
</html>