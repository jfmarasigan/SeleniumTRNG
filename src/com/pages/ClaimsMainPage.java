package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ClaimsMainPage {

	private WebDriver driver;
	private FluentWait<WebDriver> wait;
	
	private By reportsMenu = By.linkText("Reports");
	private By batchOSPrintingMenu = By.linkText("Batch O/S Printing");
	
	public ClaimsMainPage (WebDriver driver) {
		this.driver = driver;
		wait = new FluentWait<>(this.driver);
	}
	
	public ClaimsMainPage (WebDriver driver, FluentWait<WebDriver> wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public ClaimsMainPage goToReports() {
		wait.until(ExpectedConditions.elementToBeClickable(reportsMenu)).click();
		return this;
	}
	
	public ClaimsMainPage goToReportsWithAction() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(reportsMenu)).click(driver.findElement(batchOSPrintingMenu)).perform();
		return this;
	}
	
	public BatchOSPrinting goToBatchOSPrinting() {
		wait.until(ExpectedConditions.elementToBeClickable(batchOSPrintingMenu)).click();
		return new BatchOSPrinting(driver, wait);
	}
}
