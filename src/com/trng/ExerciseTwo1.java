package com.trng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExerciseTwo1 {

	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://192.10.10.110:10/Geniisys/");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userId"))).sendKeys("CPI");
		driver.findElement(By.id("password")).sendKeys("CPI12345!");
		driver.findElement(By.id("loginButton")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("iconClaims"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Reports"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Batch O/S Printing"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mtgInputBatchOS_2,0\"]"))).click();
		driver.findElement(By.id("btnPrint")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"btnPrint\"]"))).click();
		Thread.sleep(3000);
	}

}
