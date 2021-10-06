package com.refund.services;

import java.util.List;

import com.refund.daos.EmployeeDAO;
import com.refund.models.Employee;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO;

	public EmployeeService() {
		this.employeeDAO = new EmployeeDAO();
	}
	
	public List<Employee> getAll() {
		return this.employeeDAO.getAll();
	}
	
	

}
