package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Appointment;
import com.dto.Doctor;
import com.dto.User;


public class AppointmentDao {
	
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("okay");


	public void saveAppointment(Appointment appointment) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(appointment);
		et.commit();
}
	public List<Appointment> fetchAllAppointmentByUser(User user){
		EntityManager em=emf.createEntityManager();
		
		String jpql="select a from Appointment a where a.user=?1";
		
		Query query =em.createQuery(jpql);
		query.setParameter(1, user);
		List<Appointment> list=query.getResultList();
		return list;
	
	}
	public List<Appointment>fetchAllAppointmentByDoctor(Doctor doctor){
		EntityManager em=emf.createEntityManager();
		String jpql="select d from Appointment d where d.doctor=?1";

		Query query =em.createQuery(jpql);query.setParameter(1, doctor);
		List<Appointment> list=query.getResultList();
		return list;

	
	}
	public Appointment fetchAppointmentById(int id){
		EntityManager em=emf.createEntityManager();
		Appointment appointment=em.find(Appointment.class,id);
	return appointment;
	}
	
	public List<Appointment>fetchAllAppointment(){
		EntityManager em=emf.createEntityManager();
		String jpql="select s from Appointment s";

		Query query =em.createQuery(jpql);
		List<Appointment> list=query.getResultList();
		return list;
	}
	
	
	
}
