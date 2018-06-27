package com.trng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExerciseOne {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/?locale=eu");
		/*System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getPageSource());
		Thread.sleep(5000);
		driver.close();*/
		// click event
		driver.findElement(By.id("password")).click();
		// send keys - type in to an element
		driver.findElement(By.id("username")).sendKeys("TESTUSERNAME");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("Login")).click();
	}

}
