<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOCTOR HOMEPAGE</title>
<%@ include file="../component/allcss.jsp" %>
</head>
<body>
<center>WELCOME TO DOCTOR HOMEPAGE</center>

<%
    Doctor str=(Doctor)session.getAttribute("doctorObj");
    if(str==null){
    	response.sendRedirect("../Doctor_login.jsp");
    }
    else{
    %>
    <%@include file="doctor_navbar.jsp" %>
    <p class="text-center fs-3">Doctor Dashboard</p>
	
	<div class="container p-5">
        <div class="row">
            <div class="col-md-4 offset-md-2">
               <%--  <div class="card paint-card">
                 <   <div class="card-body text-center text-primary">
                        <i class="fas fa-user-md fa-3x"></i><br>
                        <p class="fs-4 text-center">Doctor</p><br>12
                    </div>  

                </div> --%>
            </div>
            <div class="col-md-8 offset-md-2">
                <div class="card paint-card">
                    <div class="card-body text-center text-primary">
                        <i class="far fa-calendar-check fa-3x"></i><br>
                        <p class="fs-4 text-center"><a href="Total_appointment.jsp">Total Appointment</a></p><br>12
                    </div>
                </div>
            </div>

        </div>
    </div>
	
    <%
}
    %>
    


</body>
</html>