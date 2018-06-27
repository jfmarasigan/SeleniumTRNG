package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HomePage {

	private WebDriver driver;
	private FluentWait<WebDriver> wait;

	private By claimsOption = By.xpath("//*[@id='iconClaims']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new FluentWait<>(this.driver);
	};

	public HomePage(WebDriver driver, FluentWait<WebDriver> wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public ClaimsMainPage goToClaims() {
		wait.until(ExpectedConditions.elementToBeClickable(claimsOption)).click();
		return new ClaimsMainPage(driver, wait);
	}
}
