<!doctype html>
<%@page import="com.jim.model.Admin"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Admin admin = (Admin) session.getAttribute("admin");
if (admin == null) {
	response.sendRedirect("/adminlogin");
}
%>
<html lang="en">
<head>
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
	width: auto;
	height: auto;
	padding: 30px;
	background-color: black;
	border: 1px solid #ccc;
	border-radius: 5px;
}
</style>
</head>
<body>
	<div class="masthead"
		style="background-image: url('/resources/img/home.jpeg');">
		<%@include file="navbar_admin.jsp"%>
		<div
			class="color-overlay d-flex justify-content-center align-items-center">
			<div class="container center text">
				<div class="form-container">
					<table class="table">
						<thead class="table-light">
							<tr>
								<th scope="col">S.Id</th>
								<th scope="col">Student Name</th>
								<th scope="col">Email</th>
								<th scope="col">Mobile No.</th>
								<th scope="col">Address</th>
								<th scope="col">Password</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody class="text-white">
							<c:forEach items="${students}" var="s">
								<tr>
									<th scope="row">${s.getsId()}</th>
									<td>${s.name}</td>
									<td>${s.email}</td>
									<td>${s.mobileNumber}</td>
									<td>${s.address}</td>
									<td>${s.password}</td>
									<td><a href="deleteStudent/${s.sId}"><i
											class="fas fa-trash text-danger"></i></a> &nbsp; <a
										href="editStudent/${s.sId}"><i
											class="fas 	far fa-edit text-secondary"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
