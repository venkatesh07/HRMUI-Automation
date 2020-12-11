package com.WebreUsableFunctions;

import java.io.File;



import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public static WebDriver driver;
	public static XSSFWorkbook xsw;
	public static String currentdate;
	public static ExtentReports report;
	public static ExtentTest logger;

	public static void navigatebrowserwithvalidur(String Browser) {

		try {
			if (Browser.equals("Chrome")) {

				String chromepath = System.getProperty("user.dir") + "//BrowserDriverFolder//chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromepath);
				driver = new ChromeDriver();
				driver.get(getstringcellvalue("login", 1, 0));
				driver.manage().window().maximize();
			}

			else if (Browser.equals("firefox")) {

				String Firefoxpath = System.getProperty("user.dir") + "//BrowserDriverFolder//geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", Firefoxpath);

				driver = new FirefoxDriver();
				driver.get("http://www.fb.com");
				driver.manage().window().maximize();
			}

			else if (Browser.equals("ie")) {

				String IEPath = System.getProperty("user.dir") + "//BrowserDriverFolder//IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", IEPath);

				driver = new InternetExplorerDriver();
				driver.get("http://www.fb.com");
				driver.manage().window().maximize();
			} else {
				System.out.println("unable to open browser");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			System.out.println("unable to open browser" + e.getMessage());

		}

	}

	public static String getthescreenshots() throws IOException {
		
		String folderPath = System.getProperty("user.dir")+"/Screenshots/hrm_"+getthesystemdateandtime()+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(folderPath));
		System.out.println("Screen captured");
		return folderPath;
		
	}
	
	public static String getthesystemdateandtime() {
		
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		 currentdate = sdf.format(dt);
		return currentdate;
		
	}
	
	public static void gettestdata() {
		
		String filepath = System.getProperty("user.dir")+"/TestData/websitedata.xlsx";
		
		try {
			
			FileInputStream fis = new FileInputStream(filepath);
			xsw = new XSSFWorkbook(fis);
			
		}
		catch(IOException e) {
			System.out.println("Exception"+e.getMessage());
			
		}
	}
		
		public static String getstringcellvalue(String sheetname, int rowno, int colmno) 
		{
			gettestdata();
			try {
				System.out.println(xsw.getSheet(sheetname).getRow(rowno).getCell(colmno).getStringCellValue());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return xsw.getSheet(sheetname).getRow(rowno).getCell(colmno).getStringCellValue();
		}
		
		
		@BeforeSuite
		public static void createreport()  {
			
			String reportpath = System.getProperty("user.dir")+"//Reports//hrm_"+getthesystemdateandtime()+".html";
			ExtentHtmlReporter extent = new ExtentHtmlReporter(reportpath);
			 report = new ExtentReports();
			 report.attachReporter(extent);
		}
		
	
		
		@AfterMethod
		public static void attachtestexecutionintoreport(ITestResult result) throws IOException {
              Reporter.log("Test results attaching");
			
			if(result.getStatus()==ITestResult.SUCCESS) {
				logger.pass("Success", MediaEntityBuilder.createScreenCaptureFromPath(getthescreenshots()).build());
				
			}
			else if(result.getStatus()==ITestResult.FAILURE) {
				logger.fail("Failure", MediaEntityBuilder.createScreenCaptureFromPath(getthescreenshots()).build());

			}
			else {
				System.out.println("unable to attach test execution result");
			}
			
			report.flush();
			Reporter.log("HTML report is created ", true);
			
		}
		
	
	
}
