<%@page import="com.jim.model.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%
Admin admin=(Admin) session.getAttribute("admin");
if(admin==null){
	response.sendRedirect("/adminlogin");
}
%>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<style>
.form-container {
	width: 600px;
	height: auto;
	padding: 30px;
	background-color: black;
	border: 1px solid #ccc;
	border-radius: 5px;
	color: white;
}
</style>
</head>
<body>
	<div class="masthead"
		style="background-image: url('/resources/img/home.jpeg');">
		<%@include file="navbar_admin.jsp"%>

		<div
			class="color-overlay d-flex justify-content-center align-items-center mt-5 ">

			<form class="form-container"
				action="add_event" method="post">
				<h1 class="text-center mb-3">Events Details</h1>
				<div class="form-group">
					<label for="name">Event Name</label> <input type="text"
						class="form-control" aria-describedby="emailHelp" name="name"
						placeholder="Enter the product name here">
				</div>
				<div class="form-group">
					<label for="description">Description</label>
					<textarea class="form-control" name="description" rows="3">${student.address}</textarea>
				</div>
				<div class="form-group">
					<label for="date_time">Date&Time</label> <input
						type="datetime-local" name="date_time" class="form-control">
				</div>
				<div class="container text-center">
					<a href="<%=request.getContextPath() + "/event-dashboard"%>"
						class="btn btn-outline-danger text-danger">Back</a>
					<button type="submit" class="btn btn-outline-success text-white">Add</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>