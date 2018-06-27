package com.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class SampleTestNG {
	@Test(priority = 0, enabled = true)
	public void test1() {
		System.out.println("Test 1");
	}

	@Test(priority = 1, dependsOnMethods = { "test1" })
	public void test2() {
		System.out.println("Test 2");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

}
