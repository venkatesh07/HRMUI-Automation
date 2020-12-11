package com.WebreUsableFunctions;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Appreusable extends BaseClass {
	
	public static String date1;
	public static String splitdate;
	
	/*
	 * 
	 * 
	 * 
	 */
	
	public static void browserclose(){
		
		try{
			
		}
		catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			
		}
	}
	
	public static void hoverelement(WebElement element)
	{
		try {
			
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
		}
		catch(Exception e)
		{
			
			System.out.println("Exception"+e.getMessage());
		}
	}
	
	public static void selectoption(WebElement element ,String option) {
		try {
			Select sel = new Select(element);
			sel.selectByVisibleText(option);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("Exception:"+e.getMessage());
		}
		
		
	}

	/*
	 * 
	 * 
	 */
	 
	public static String  selectfromdate() {
		getthesystemdateandtime();
		String[] date = currentdate.split("_");
		 splitdate = date[0];
		System.out.println(splitdate);
		 date1 = date[1];
		System.out.println(date1);
		return splitdate;
		
		
		
		
	}
}
