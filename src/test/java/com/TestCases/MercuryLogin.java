package com.TestCases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.ObjectRepo.WebpageObjects;
import com.WebreUsableFunctions.BaseClass;

public class MercuryLogin extends BaseClass{
	
	public static void TC_02_Case() throws InterruptedException{
		
	
	navigatebrowserwithvalidur("Chrome");
	WebpageObjects pob = PageFactory.initElements(driver, WebpageObjects.class);

	pob.Adv1.click();
	pob.Dest.sendKeys("Goa");
	Thread.sleep(2000);
	
	Actions act = new Actions(driver);
	act.moveToElement(pob.Destselect).click(pob.Destselect).build().perform();
	
	pob.StartdateClick.click();

	act.moveToElement(pob.Startdate).click(pob.Startdate).build().perform();

	
	
	


}}
