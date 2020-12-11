package com.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebpageObjects {
	
	
	
	@FindBy(xpath="//input[@id='txtUsername']")public WebElement username;
	@FindBy(xpath="//input[@id='txtPassword']")public WebElement password;

	@FindBy(xpath="//input[@id='btnLogin']")public WebElement login;

	@FindBy(xpath="//a[@id='menu_leave_viewLeaveModule']//b")public WebElement leavetab;
	
	
	//apply Leave
	@FindBy(xpath="//a[@id='menu_leave_viewLeaveModule']")public static WebElement Leave;
	@FindBy(xpath="//a[@id='menu_leave_applyLeave']")public static WebElement Apply;
	
	//Apply leave page 
	@FindBy(xpath="//select[@id='applyleave_txtLeaveType']")public static WebElement Leavetype;
	@FindBy(xpath="//input[@id='applyleave_txtFromDate']")public static WebElement Leavedateclean;
    @FindBy(xpath="//input[@id='applyleave_txtFromDate']/following::img")public static WebElement fromdate;
	@FindBy(xpath="//a[contains(text(),'23')]")public static WebElement date;
	@FindBy(xpath="//textarea[@id='applyleave_txtComment']")public static WebElement Leavecomments;
	@FindBy(xpath="//input[@id='applyBtn']")public static WebElement clickbutton;
	




	
	
	
	
	/* --------------
	 * Mercury
	 */
	@FindBy(className="white-text")public WebElement Adv1;
	

	@FindBy(id="holiday_category_id")public WebElement Dest;
	@FindBy(xpath="//li[@class='ui-menu-item']/following::a")public WebElement Destselect;
	@FindBy(xpath="//input[@id='dphh1']")public WebElement StartdateClick;
	@FindBy(xpath="//table[@class=' table-condensed']/tbody/tr[4]/td[5]")public WebElement Startdate;
	@FindBy(id="duration_d")public WebElement Duration;
	@FindBy(id="themes")public WebElement TypeHoliday;
	
	
}
