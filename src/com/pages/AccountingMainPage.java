package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class AccountingMainPage {

	private WebDriver driver;
	private FluentWait<WebDriver> wait;

	public AccountingMainPage(WebDriver driver) {
		this.driver = driver;
	}

	public AccountingMainPage(WebDriver driver, FluentWait<WebDriver> wait) {
		this.driver = driver;
		this.wait = wait;
	}

	
}
