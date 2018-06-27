package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class BatchOSPrinting {

	private WebDriver driver;
	private FluentWait<WebDriver> wait;

	public BatchOSPrinting(WebDriver driver) {
		this.driver = driver;
	}

	public BatchOSPrinting(WebDriver driver, FluentWait<WebDriver> wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void printSelectedRecord(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		driver.findElement(By.xpath("//*[@id=\"btnPrint\"]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"btnPrint\"]"))).click();
	}
}
