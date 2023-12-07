<%@page import="java.util.List"%>
<%@page import="com.dto.Appointment"%>
<%@page import="com.dao.AppointmentDao"%>
<%@page import="com.dto.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file="doctor_navbar.jsp" %>
	<%
	Doctor str = (Doctor) session.getAttribute("doctorObj");
	if (str == null) {
		response.sendRedirect("../doctor_login.jsp");
	} else {
	%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Patient Details</p>

						<table class="table">
							<thead>
								<tr>
									<th>Full Name</th>
									<th>Gender</th>
									<th>Age</th>
									<th>Appointment</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>Diseases</th>
									<th>Status</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								Doctor doc=(Doctor)session.getAttribute("doctorObj");
								AppointmentDao dao=new AppointmentDao();
								List<Appointment> list=dao.fetchAllAppointmentByDoctor(doc);
								for(Appointment ap:list){
								%>
								<tr>
								<td><%=ap.getName() %></td>
								<td><%=ap.getGender()%></td>
								<td><%=ap.getAge()%></td>
								<td><%=ap.getAppointDate()%></td>
								<td><%=ap.getEmail()%></td>
								<td><%=ap.getPhone()%></td>
								<td><%=ap.getDisease()%></td>
								<td><%=ap.getStatus() %></td>
								<td><a class="btn btn-sm btn-primary" href="comment.jsp?apId=<%=ap.getId()%>">Comment</a></td>
								
								</tr>
									<%
								}
								%>
								
								
							</tbody>
						</table>
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