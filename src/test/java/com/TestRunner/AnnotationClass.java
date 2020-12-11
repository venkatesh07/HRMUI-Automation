package com.TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationClass {

	@BeforeSuite
	public static void m1() {

		System.out.println("Before Suite");

	}

	@BeforeClass
	public static void m2() {
		System.out.println("Before Class");

	}

	@BeforeMethod
	public static void m3() {
		System.out.println("Before Method");

	}

	@AfterMethod
	public static void m6() {
		System.out.println("After Method");

	}

	@AfterClass
	public static void m7() {
		System.out.println("After Class");

	}

	@AfterSuite
	public static void m8() {
		System.out.println("After Suite");

	}

	@Test
	public static void m9() {

		System.out.println("TESt");

	}

}
