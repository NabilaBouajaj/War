package org.formation.jsf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.jsf.model.Student;

public class StudentDao implements IStudentDao {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	@Override
	public List<Student> getStudents() throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		List<Student> listStudent = new ArrayList<>();
		
		try {
			tnx.begin();
			
			TypedQuery<Student> query = em.createQuery("from Student", Student.class);
			listStudent = query.getResultList();
			
			tnx.commit();

		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			throw e;
		} finally {
			em.close();
		}

		return listStudent;
	}

	@Override
	public void addStudent(Student theStudent) throws Exception {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		
		try {
			tnx.begin();
			
			em.persist(theStudent);
			
			tnx.commit();

		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			throw e;
		} finally {
			em.close();
		}
		
	}

	@Override
	public Student getStudent(Long studentId) throws Exception {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		Student std = null;
		
		try {
			tnx.begin();
			
			std = (Student) em.find(Student.class, studentId);
			
			tnx.commit();

		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			throw e;
		} finally {
			em.close();
		}

		return std;
		
	}

	@Override
	public void updateStudent(Student theStudent) throws Exception {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		
		try {
			tnx.begin();
			
			em.merge(theStudent);
			
			tnx.commit();

		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteStudent(Long studentId) throws Exception {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		Student std = null;
		
		try {
			tnx.begin();
			
			std = (Student) em.find(Student.class, studentId);
			em.remove(std);
			
			tnx.commit();

		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			throw e;
		} finally {
			em.close();
		}
		
	}

}
