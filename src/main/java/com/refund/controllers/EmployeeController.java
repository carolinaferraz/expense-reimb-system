package com.refund.controllers;

//import static io.javalin.apibuilder.ApiBuilder.put;
//import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

import javax.servlet.http.HttpSession;

import com.refund.daos.EmployeeDAO;
import com.refund.models.Employee;
import com.refund.services.EmployeeService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeeController {

	private EmployeeService employeeService; 
	private EmployeeDAO employeeDao; 
	
	public EmployeeController (Javalin app) {
		this.employeeService = new EmployeeService();
		this.employeeDao = new EmployeeDAO();
		
		app.routes(() -> {
			path("/hi", () -> {
				get(getAllEmployees);				
			});
	});
		
		app.post("/login", ctx -> {
			Employee empl = new Employee (
					ctx.req.getParameter("username"),
					ctx.req.getParameter("password"));

			this.employeeDao.EmployeeLogin(empl.getUsername(), empl.getPassword());
			ctx.req.getSession();
//			ctx.result("EmployeeLogin ok  :) ");
			ctx.redirect("/home.html");
		});
		
/*	manager-only areas */
		
		app.post("/locked", ctx -> {
			Employee empl = new Employee (
					ctx.req.getParameter("username"),
					ctx.req.getParameter("password"));
 
			this.employeeDao.ManagerLogin(empl.getUsername(), empl.getPassword());
			ctx.req.getSession();
			ctx.result("ManagerLogin ok :) ");

			ctx.redirect("/locked.html");
		});
		
		
		app.get("/logout", ctx -> {
			HttpSession session = ctx.req.getSession(false);
			if (session != null) session.invalidate();
			ctx.result("logged out! ");
//			ctx.redirect("/index.html");
		});
}
// Handlers
		private Handler getAllEmployees = ctx -> ctx.json(this.employeeService.getAll());
}
