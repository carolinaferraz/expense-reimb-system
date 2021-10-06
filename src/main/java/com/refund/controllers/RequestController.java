package com.refund.controllers;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import javax.servlet.http.HttpSession;

import com.refund.daos.RequestDAO;
import com.refund.models.Request;
import com.refund.services.RequestService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class RequestController {
	
	private RequestService requestService; 
	
	public RequestController (Javalin app) {
		this.requestService = new RequestService();
		
	app.routes(() -> {
		path("/locked", () -> {
			path("/asc", () -> { 
				get(getAllPendingByAmount); 
			});
			
	});
		
			path("/r", () -> {
				path("/all", () -> { 
					get(getAllRequests);
					
					path("/ok", () -> { 
						get(getAllApproved); 
						path("/:employee_id", () -> { 
							get(getAllApprovedFromEmployee);	
							});
					});					
					path("/:employee_id", () -> { 
						get(getAllFromEmployee);	
						});
				});	
				path("/:request_id", () -> {
					get(getOneRequest);	
					path("/up", () ->{
						put(approveRequest);	
						});
				});
				path("/new", () -> {
					post(saveNew);
					});
				
			});	// closes /r	
		
	}); // close app.routes()
}
	
	
// Handlers	
	private Handler saveNew = ctx ->  {
		
	 HttpSession session = ctx.req.getSession(false);
		
		if(session != null) {

		Request request = new Request (
				(Integer.parseInt(ctx.req.getParameter("employee_id"))),
				ctx.req.getParameter("request_description"),
				(Double.parseDouble(ctx.req.getParameter("request_amount"))));

		this.requestService.save(request);
		ctx.res.getWriter().write("request submitted! ");
		}
		
		else  {
			ctx.res.getWriter().write("you are not logged in! ");
//			ctx.redirect("/index.html");
		}
	};
	
	private Handler getAllRequests = ctx -> ctx.json(this.requestService.getAll());
			
	private Handler getAllApproved = ctx -> ctx.json(this.requestService.getAllApproved());
	
	private Handler getOneRequest = ctx -> ctx.json(this.requestService.getRequest(Integer.parseInt(ctx.pathParam("request_id"))));

private Handler getAllFromEmployee = ctx -> ctx.json(this.requestService.getAllFromEmployee(Integer.parseInt(ctx.pathParam("employee_id"))));	
	
private Handler getAllApprovedFromEmployee = ctx -> ctx.json(this.requestService.getAllApprovedByEmp(Integer.parseInt(ctx.pathParam("employee_id"))));

private Handler getAllPendingByAmount = ctx -> ctx.json(this.requestService.getAllPendingByAmount());	
	
private Handler approveRequest = ctx -> {
								
	Request updatedReq = this.requestService.getRequest
	(Integer.parseInt(ctx.pathParam("request_id")));
	
	
		Request request = updatedReq;
		updatedReq.setPending(false);
		updatedReq.setApproved(true);
		updatedReq.setApproval_message("approved from controller");
														
	this.requestService.update(request);
			 ctx.html("request approved.");
//			 ctx.redirect("/locked.html");
		};
}

