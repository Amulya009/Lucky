package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Doctor;

public class DoctorDao {
	static int count=0;
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("okay");
	public void save(Doctor d) {
      EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(d);
		et.commit();
		
		
	}
	public List<Doctor> fetchALLDoctor() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("okay");
		EntityManager em=emf.createEntityManager();
		String jpql="select d from Doctor d";
		Query q=em.createQuery(jpql);
		List<Doctor> list=q.getResultList();
		return list;
	}
	
	public Doctor fetchbyId(int id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("okay");
		EntityManager em=emf.createEntityManager();
		
		
		Doctor d=em.find(Doctor.class, id);
		
		return d;
		
	}
	public void editdoctor(Doctor dd) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("okay");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(dd);
		et.commit();
	}
	public Doctor deletebyid(int id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("okay");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Doctor d=em.find(Doctor.class, id);
		if(d!=null) {
			et.begin();
			em.remove(d);
			et.commit();
		}
		return d;
	}
	public Doctor Dlogin(String email,String password) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("okay");
		EntityManager em=emf.createEntityManager();
	   	  Doctor us=null;
	   	  String jpql="select u from Doctor u where u.email=?1 and u.password=?2";
	   	  Query q=em.createQuery(jpql);
	   	  q.setParameter(1, email);
	   	  q.setParameter(2, password);
	   	  List<Doctor> list=q.getResultList();
	   	  if(list.size()!=0)
	   	  {
	   		  us=list.get(0);
	   	  }
		return us;
	}
	public int countdoctor() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("okay");
		EntityManager em=emf.createEntityManager();
		
		String jpql="select d from Doctor d";
		Query q=em.createQuery(jpql);
		List <Doctor> list=q.getResultList();
		for(int i=0;i<list.size();i++)
		{
			count++;
		}
		return count;
		
	}
	
	
	
}
