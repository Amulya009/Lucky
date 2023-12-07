package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CountDao {
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("okay");
	
	public int countDoctor() {
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select s from Doctor s");
		return query.getResultList().size();
	}
	public int countSpecialist() {
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select s from Specialist s");
		return query.getResultList().size();
	}
	public int countAppointment() {
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select s from Appointment s");
		return query.getResultList().size();
	}

}
