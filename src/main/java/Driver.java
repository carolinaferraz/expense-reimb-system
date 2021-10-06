import com.refund.controllers.EmployeeController;
import com.refund.controllers.RequestController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Driver {
	@SuppressWarnings("unused")
	
	public static void main(String[] args) {
//	booting up server here on port 7777 :)
	Javalin app = Javalin.create(config -> {
        config.addStaticFiles("/static", Location.CLASSPATH);
    }).start(7777);
	
	
//	CORS error-patch
	app.after(ctx-> {
		ctx.res.addHeader("Access-Control-Allow-Origin", "null");
		
	})	;
	
	EmployeeController employeeController = new EmployeeController(app);
	RequestController requestController = new RequestController(app);

	app.get("/hello", ctx -> {
		ctx.result("reimbursement app entry point here - port 7777 :) ");
		});
	}
};
