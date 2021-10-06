/*
 * business logic lives here
 */

package com.refund.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.refund.daos.RequestDAO;
import com.refund.models.Request;
import com.refund.utils.HibernateSessionFactory;

public class RequestService {

	private RequestDAO requestDAO;

	public RequestService() {
		this.requestDAO = new RequestDAO();
	}

	/* return list of records */
	public List<Request> getAll() {
		return this.requestDAO.getAll();
	}
	
	public List<Request> getAllFromEmployee(int employee_id) {
		return this.requestDAO.getAll(employee_id);
	}
	
	public List<Request> getAllApproved() {
		List<Request> requests = new ArrayList<Request>();
		Session s = null;
		Transaction tx = null;		 
		try  {
			s = HibernateSessionFactory.getSessionFactory().openSession();
			tx = s.beginTransaction();
			
			requests = s.createQuery("from Request r where r.approved=true", Request.class).getResultList();
			s.close();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace(); 
			}									
		return requests;
	}
	
	public List<Request> getAllApprovedByEmp(int employee_id)  {
		List<Request> requests = new ArrayList<Request>();
		Session s = null;
		Transaction tx = null;		 
		try  {
			s = HibernateSessionFactory.getSessionFactory().openSession();
			tx = s.beginTransaction();
			requests = s.createQuery("from Request r where r.approved=true and r.employee_id="+employee_id, Request.class).getResultList();
			
			s.close();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace(); 
			}									
		return requests;
	}
	
	
	public List<Request> getAllPendingByAmount() {
		List<Request> requests = new ArrayList<Request>();
		Session s = null;
		Transaction tx = null;		 
		try  {
			s = HibernateSessionFactory.getSessionFactory().openSession();
			tx = s.beginTransaction();
			
			requests = s.createQuery("from Request r where r.pending=true order by r.employee_id asc, r.request_amount asc", Request.class).getResultList();
			s.close();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace(); 
			}									
		return requests;
	}
	
	
	public Request getRequest(int request_id) {
		return this.requestDAO.getRequest(request_id);
	}

	public void update(Request request) {
		this.requestDAO.update(request);
	}
	
	public void save(Request request) {
		this.requestDAO.save(request);
	}

}
