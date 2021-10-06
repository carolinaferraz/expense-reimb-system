 /*
  * employee login and check active requests
  */
package com.refund.selenium;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.refund.pom.EmployeeLogin;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Employee {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		
//		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//		driver = new ChromeDriver();
		
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
	public void req_active() {
		WebElement check = driver.findElement(By.id("empl_getAll"));
		check.click();			
	}
//	@Test	
//	public void req_logout() {
//		WebElement logout = driver.findElement(By.id("logout"));
//		logout.click();			
//	}
	
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
