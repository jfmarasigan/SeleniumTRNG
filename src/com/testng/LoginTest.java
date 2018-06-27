package com.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {
	
	private WebDriver driver;
	private FluentWait<WebDriver> wait;
	
	//SoftAssert continues test even if a previous one (within the same method) failed
	private SoftAssert softAssert;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://192.10.10.240:9090/Geniisys/");
		softAssert = new SoftAssert();
		wait = new FluentWait<>(driver);
		wait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
	}
	
	@Test(dataProvider = "getCredentials")
	public void login(String username, String password) {
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userId")));
		usernameField.sendKeys(username);
		//assertEquals(username, usernameField.getAttribute("value"));
		softAssert.assertEquals("BOnok", usernameField.getAttribute("value"));
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys(password);
		//assertEquals(password, passwordField.getAttribute("value"));
		softAssert.assertEquals(password, passwordField.getAttribute("value"));
		driver.findElement(By.id("loginButton")).click();
		
		//assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iconUnderwriting"))).isDisplayed());
		boolean isDisplayed = true;
		try {
			isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iconUnderwriting"))).isDisplayed();
		} catch (TimeoutException e) {
			isDisplayed = false;
		}
		
		softAssert.assertTrue(isDisplayed);
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
	
	@DataProvider
	public Object[][] getCredentials() {
		return new Object[][]{{"CPI", "CPI12345!"}, {"BONOK", "CPI12345!"}};
	}
}
