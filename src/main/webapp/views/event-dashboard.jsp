<!DOCTYPE html>
<%@page import="com.jim.model.Admin"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<%
Admin admin=(Admin) session.getAttribute("admin");
if(admin==null){
	response.sendRedirect("/adminlogin");
}
%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/style.css">
<title>Admin||Portal</title>
</head>
<style>
/* Set form size */
.form-container {
	width: auto;
	height: auto;
	padding: 30px;
	background-color: black;
	border: 1px solid #ccc;
	border-radius: 5px;
}
</style>

<body>
   <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
  <a class="navbar-brand" href="#">JIM</a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="admin_dashboard">Home <span class="sr-only">(current)</span></a>
      </li>
        <li class="nav-item active">
        <a class="nav-link" href="add-event-page">Add Event <span class="sr-only">(current)</span></a>
      </li>
    </ul>
   
      <a href="logout-admin"><button class="btn my-2 my-sm-0 text-danger btn btn-outline-danger" type="submit">Logout</button></a>
  </div>
</nav>
	<div class="masthead"
		style="background-image: url('/resources/img/home.jpeg');">
		<div
			class="color-overlay d-flex justify-content-center align-items-center">
			<div class="container center text">
				<div class="form-container">
					<table class="table">
						<thead class="table-light">
							<tr>
								<th scope="col">E.Id</th>
								<th scope="col">Name</th>
								<th scope="col">Description</th>
								<th scope="col">Date & Time</th>
								<th scope="col">Actions</th>
							</tr>
						</thead>
						<tbody class="text-white">
							<c:forEach items="${events}" var="e">
								<tr>
									<th scope="row">${e.eId}</th>
									<td>${e.name}</td>
									<td>${e.description}</td>
									<td>${e.date_time}</td>
									
									<%-- <td><a href="deleteStudent/${s.sId}"><i
											class="fas fa-trash text-danger"></i></a> &nbsp; <a
										href="editStudent/${s.sId}"><i
											class="fas 	far fa-edit text-secondary"></i></a></td> --%>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Bootstrap 4 JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>