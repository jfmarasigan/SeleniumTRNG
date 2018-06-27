package com.trng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExerciseThree {
	
	private static WebDriver driver;
	private static WebDriverWait wait;

	private static final Integer BASE_WAIT_TIME = 60;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver-v0.21.0-win64\\\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, BASE_WAIT_TIME);
		driver.get("http://toolsqa.com/automation-practice-form");
		
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		
		ex.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.name("firstname")));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("firstname"))).sendKeys("John Daniel");
		Thread.sleep(1000);
		driver.findElement(By.name("lastname")).sendKeys("Marasigan");
		Thread.sleep(1000);
		ex.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("sex-0")));
		Thread.sleep(1000);
		driver.findElement(By.id("sex-0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("exp-1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("datepicker")).sendKeys("06-25-2018");
		Thread.sleep(1000);
		ex.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("profession-1")));
		driver.findElement(By.id("profession-1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("tool-1")).click();
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("continents"))).selectByVisibleText("Antartica");
		Thread.sleep(1000);
		ex.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("selenium_commands")));
		Select mult = new Select(driver.findElement(By.id("selenium_commands")));
		mult.selectByIndex(0);
		Thread.sleep(1000);
		mult.selectByIndex(1);
		Thread.sleep(1000);
		mult.selectByIndex(2);
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		
	}

}
