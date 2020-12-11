package com.TestRunner;

import java.io.IOException;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.TestCases.LoginModule;
import com.TestCases.MercuryLogin;
import com.WebreUsableFunctions.BaseClass;

public class Execution extends BaseClass{
	

	@Test
	public static void run() throws IOException, InterruptedException {
		
		logger = report.createTest("HRM login and apply");
		logger.info("verify user and login the apply the leave");
		LoginModule.TC_01_case();
		
		//LoginModule.TC_03_Case();
		//LoginModule.TC_04_Case();
		logger.pass("user successfully logged in ");
		logger.fail("user not successfully logged in");

		
	}
	
	

}
