 // sending a req from manager is broken 
package com.refund.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendRequest {
//	login input
	@FindBy(className="mng-login-box")
	private WebElement loginBox;
WebElement mngr_usernameBox = loginBox.findElement(By.className("mngr_un"));

WebElement mngr_passwordBox = loginBox.findElement(By.className("mngr_pwd"));
WebElement mngr_loginButton = loginBox.findElement(By.className("mngr_send_btn"));

	@FindBy(className="submit_nav_link")
	private WebElement submitLink;
	
//	form input
	
	@FindBy(id="employee_id")
	private WebElement employeeIdBox;
	@FindBy(id="request_description")
	private WebElement descriptionBox;
	@FindBy(id="request_amount")
	private WebElement amountBox;
	@FindBy(id="submit_btn")
	private WebElement submitButton;
	
	public SendRequest(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	 manager login
	public void login(String username, String password) {
		mngr_usernameBox.sendKeys(username);
		mngr_passwordBox.sendKeys(password);
		mngr_loginButton.click();
		}
	
//	filling request form
	public void form(String employee_id, String description, String request_amount) {
		submitLink.click();
		employeeIdBox.sendKeys(employee_id);
		descriptionBox.sendKeys(description);
		amountBox.sendKeys(request_amount);
		submitButton.click();
		}

}
