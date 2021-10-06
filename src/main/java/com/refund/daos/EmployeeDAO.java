package com.refund.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.refund.models.Employee;
import com.refund.utils.HibernateSessionFactory;

public class EmployeeDAO {
	
	public List<Employee> getAll()  {
		List<Employee> employees = new ArrayList<Employee>();
		try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) 
		{
			return session.createQuery("from Employee", Employee.class).list();
		} catch (HibernateException e) {
			e.printStackTrace(); 
			}											
		return employees;
	}
	
	/**
	 * employee login 
	 * @param username
	 * @param password
	 * @return
	 */
	public Employee EmployeeLogin(String username, String password) {
		 	SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		 	
	        Session session = null;

	        try {
	        	String qs = "from Employee e where e.username=:username and e.password=:password and is_manager=false";
	        	session = sessionFactory.openSession();
	        	Query q = session.createQuery(qs);
	        	q.setParameter("username", username);
	        	q.setParameter("password", password);
	        	q.getSingleResult();
	        	 
			} catch (HibernateException e) {
				e.printStackTrace();  	    				
			} finally {
	        	session.close();
			} return null;
	} 
	
	/**
	 * manager login 
	 * @param username
	 * @param password
	 * @return
	 */
	public Employee ManagerLogin(String username, String password) {
		 	SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		 	
	        Session session = null;

	        try {
	        	String qs = "from Employee e where e.username=:username and e.password=:password and is_manager=true";
	        	session = sessionFactory.openSession();
	        	Query q = session.createQuery(qs);
	        	q.setParameter("username", username);
	        	q.setParameter("password", password);
	        	q.getSingleResult();
	        	 
			} catch (HibernateException e) {
				e.printStackTrace();  	    				
			} finally {
	        	session.close();
			} return null;
	} 
};