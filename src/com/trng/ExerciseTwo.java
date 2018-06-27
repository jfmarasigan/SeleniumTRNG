package com.trng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExerciseTwo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://192.10.10.110:10/Geniisys/");
		Thread.sleep(10000);
		driver.findElement(By.id("userId")).sendKeys("CPI");
		driver.findElement(By.id("password")).sendKeys("CPI12345!");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("iconClaims")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Reports")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("batchOSPrinting")).click();
		Thread.sleep(3000);
	}

}
