package com.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;

import com.ObjectRepo.WebpageObjects;
import com.WebreUsableFunctions.Appreusable;
import com.WebreUsableFunctions.BaseClass;

public class LoginModule extends Appreusable {
	
	
	public static WebpageObjects pob;
	
	public static void TC_01_case() throws IOException {
		
		navigatebrowserwithvalidur("Chrome");
		
		pob = PageFactory.initElements(driver, WebpageObjects.class);

		
		pob.username.sendKeys(getstringcellvalue("login",1,1));
		pob.password.sendKeys(getstringcellvalue("login",1,2));
		pob.login.click();
		String leavetext = pob.leavetab.getText();
		System.out.println(leavetext);
		
		if(leavetext.equals("Leave")) {
			System.out.println("user loggedin success");
			}
		else {
			System.out.println("user loggedin Failed");

		}
		
		//getthescreenshots();
	}
	
	public static void TC_03_Case() {
		hoverelement(pob.Leave);
		pob.Apply.click();
	}
	
	
	public static void TC_04_Case() {
		selectoption(pob.Leavetype, "Personal Leave");
		pob.Leavedateclean.clear();
		pob.Leavedateclean.click();
		selectfromdate();
		driver.findElement(By.xpath("//a[contains(text(),"+splitdate+")]")).click();
		String todate = splitdate+2;
		System.out.println(todate);
		pob.Leavecomments.sendKeys("Personal reasons");
		pob.clickbutton.click();
	
		
	}
	

}	
