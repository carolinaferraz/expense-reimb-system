package com.refund.selenium;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.refund.pom.SendRequest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Manager {

private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost:7777/");
	}
	
	@Test
	public void login() {
		SendRequest loginPage = new SendRequest(driver);
		loginPage.login("manager700", "password700");
		Assert.assertEquals("redirect failed", "http://localhost:7777/locked.html", driver.getCurrentUrl());
	}
	
//	@Test
//	public void req_create() {
//		SendRequest sendRequest = new SendRequest(driver);
//		
//		sendRequest.form("6", "request from selenium", "10.50");
//		
//	}
};


