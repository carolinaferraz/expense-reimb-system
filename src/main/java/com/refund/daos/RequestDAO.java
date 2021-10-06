package com.refund.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.refund.models.Request;
import com.refund.utils.HibernateSessionFactory;
public class RequestDAO {
	
	public List<Request> getAll()  {
			List<Request> requests = new ArrayList<Request>();
			Session s = null;
			Transaction tx = null;		 
			try  {
				s = HibernateSessionFactory.getSessionFactory().openSession();
				tx = s.beginTransaction();
				
				requests = s.createQuery("from Request r where approved=false order by r.request_id desc", Request.class).getResultList();
				s.close();
			} catch (HibernateException e) {
				tx.rollback();
				e.printStackTrace(); 
				}									
			return requests;
		}
	
	
	/**
	 * get a request by its id
	 * @param request_id
	 * @return request
	 */
	public  Request getRequest (int request_id) {
		Transaction tx = null;
		Request request = null;
		try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
			
			tx = session.beginTransaction();
			request = session.get(Request.class, request_id);		
			tx.commit();			
			session.close();	
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return request;
	} 
	
	/**
	 * get all requests by employee
	 * @param employee_id
	 */
	
	public List<Request> getAll(int employee_id)  {
		List<Request> requests = new ArrayList<Request>();
		Session s = null;
		Transaction tx = null;		 
		try  {
			s = HibernateSessionFactory.getSessionFactory().openSession();
			tx = s.beginTransaction();
			requests = s.createQuery("from Request r where r.approved=false and r.employee_id="+employee_id+" order by r.request_id desc", Request.class).getResultList();
			
			s.close();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace(); 
			}									
		return requests;
	}

/*
 * update  (aka pending=false) -- broken
 */
public void update (Request request) {
	Transaction tx = null;
	
	try (Session s = HibernateSessionFactory.getSessionFactory().openSession()) {

    	tx = s.beginTransaction();
   s.createQuery("update Request r set r.pending=false where r.employee_id="+ request.getRequest_id());
//    	Request request = new Request();
    	
    	request.getRequest_amount();
    	request.getRequest_description();
    	request.setPending(false);
    	request.setApproval_message("request approved");
    	
		s.saveOrUpdate(request);
		tx.commit();
		
		s.close();
		
	} catch (HibernateException e) {
		tx.rollback();
		e.printStackTrace();
	} 
}
	
/**
 * create a new request
 * @param request
 */
	public void save(Request request) {
		Transaction tx = null;
		
		try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			request.setPending(true);
			request.setApproved(false);
			request.setManager_id(700);
			session.save(request);
			tx.commit();
			
			session.close();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 		
	}	
}