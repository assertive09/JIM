<!DOCTYPE html>
<%@page import="com.jim.model.Admin"%>
<html lang="en">
<%
Admin admin=(Admin) session.getAttribute("admin");
if(admin==null){
	response.sendRedirect("/adminlogin");
}
%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/style.css">
    <title>Admin||Portal</title>
</head>
<style>
    /* Set form size */
    #div1,
    #div2 {
        width: 600px;
        height: auto;
        padding: 30px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
</style>


<body>
    <div class="masthead" style="background-image: url('/resources/img/home.jpeg');">
    <%@include file="navbar_admin.jsp"%>
     <div class="color-overlay d-flex justify-content-center align-items-center"> -->
            <div class="container center text">
                <div id="div1" class="text-center bg-secondary">
                    <a href="all_student">Check All Students</a>
                </div>
              &nbsp;
                <div id="div2" class="text-center bg-secondary ">
                    <a href="event-dashboard">Events</a>
                </div>
            </div>
    </div>
    </div>
    
    <!-- Bootstrap 4 JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>