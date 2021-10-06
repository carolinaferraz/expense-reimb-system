/*
 * i'm a pom (page object model) & i work as a repo for WebElements to be interacted with to avoid repetition & verbose-ness seen on intro code.  these elements are found by selenium's @FindBy annotation 
 */

package com.refund.pom;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy(id="user-name")
	private WebElement usernameBox;
	@FindBy(id="password")
	private WebElement passwordBox;
	@FindBy(id="login-button")
	private WebElement loginButton;
	
//	the absence of the driver from the @queries require the following constructor : :	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		/*
		 * explicit waits
		 */
		WebDriverWait wait = new WebDriverWait(driver, 5);	
		wait.until(ExpectedConditions.elementToBeClickable(usernameBox));
		
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(250)).withMessage("the password box didn't appear in the allotted 5 seconds.");
		
		fluentWait.until(ExpectedConditions.visibilityOf(passwordBox));
	}
	
/* util method for logging in	*/	
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
