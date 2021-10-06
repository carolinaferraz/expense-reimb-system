/* employee logs in and checks active req */

package com.refund.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeLogin {
	
	@FindBy(className="empl_un")
	private WebElement usernameBox;
	@FindBy(className="empl_pw")
	private WebElement passwordBox;
	@FindBy(className="empl_send_btn")
	private WebElement loginButton;
	@FindBy(id="empl_getArchive")
private WebElement activeReq;
	
	public EmployeeLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	/* util methods for logging in	*/	
public void login(String username, String password) {
	usernameBox.sendKeys(username);
	passwordBox.sendKeys(password);
	loginButton.click();
	}
	
	public void loginByHittingEnterInPasswordBox(String username, String password) {
	usernameBox.sendKeys(username);
	passwordBox.sendKeys(password, Keys.ENTER);
	}
	
	
}

