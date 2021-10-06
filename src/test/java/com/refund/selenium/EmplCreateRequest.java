package com.refund.selenium;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.refund.pom.EmployeeLogin;
import com.refund.pom.SendRequest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmplCreateRequest {
private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost:7777/");
	}
	
	@Test
	public void login() {
		EmployeeLogin loginPage = new EmployeeLogin(driver);
		loginPage.login("username01", "password01");
		Assert.assertEquals("redirect failed", "http://localhost:7777/home.html", driver.getCurrentUrl());
	}
	
	@Test
	public void req_create() {
		SendRequest sendRequest = new SendRequest(driver);	
		sendRequest.form("1", "request from selenium", "10.50");
		
	}
	
	@AfterClass
	public static void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
