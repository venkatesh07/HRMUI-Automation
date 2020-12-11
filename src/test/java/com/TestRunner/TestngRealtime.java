package com.TestRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.WebreUsableFunctions.BaseClass;

public class TestngRealtime extends BaseClass {
	
	
	@BeforeSuite
	public static void browserlaunch() {
		
		navigatebrowserwithvalidur("Chrome");
	}
	
	@BeforeTest
	public static void login() {
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("user03");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("pass1234");

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
	}
	
	
	
	@Test
	public static void DashboardValidation() {
		
		String dashboardurl = driver.getCurrentUrl();
		
		if(dashboardurl.contains("dashboard")) {
			System.out.println("user successfully logged in");
		}
		else {
			System.out.println("user successfully not logged in");
		}
	}
	
	@AfterSuite
	public static void logout() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		WebElement lout = driver.findElement(By.xpath("//a[text()='Logout']"));
		Actions act = new Actions(driver);
		act.moveToElement(lout).click(lout).build().perform();
       		
 
		
		
		
		
	}

}
