package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AppointmentDao;
import com.dto.Appointment;
@WebServlet("/update_comments")
public class UpdateComment extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String comment =req.getParameter("comment");
		String strId=req.getParameter("apId");
		int apId =Integer.parseInt(strId);
		
		AppointmentDao dao=new AppointmentDao();
		Appointment ap=dao.fetchAppointmentById(apId);
		ap.setStatus(comment);
		dao.saveAppointment(ap);
		
		resp.sendRedirect("doctor/patient.jsp");
	}

}
