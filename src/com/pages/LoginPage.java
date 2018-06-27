package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class LoginPage {

	private WebDriver driver;
	private FluentWait<WebDriver> wait;

	private By usernameLocator = By.xpath("//*[@id='userId']");
	private By passwordLocator = By.xpath("//*[@id='password']");
	private By loginBtnLocator = By.xpath("//*[@id='loginButton']");

	@FindBy(xpath = "//*[@id='userId']")
	private WebElement userId;

	@FindBy(xpath = "//*[@id='password']")
	private WebElement password;
	
	@FindBy(xpath= "//*[@id='loginButton']")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new FluentWait<>(driver);
	}

	public LoginPage(WebDriver driver, FluentWait<WebDriver> wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public HomePage login(String username, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator)).sendKeys(username);
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(loginBtnLocator).click();
		
		return new HomePage(driver, wait);
	}
	
	public LoginPage open() {
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
