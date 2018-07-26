package com.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class PageObjectModelSample {

	private WebDriver driver;
	private FluentWait<WebDriver> wait;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://192.10.10.110:10/Geniisys/");
		wait = new FluentWait<>(driver);
		wait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
	}

	@Test
	public void test() {
		By record = By.xpath("//*[@id=\"mtgInputBatchOS_2,0\"]");
		new LoginPage(driver, wait).login("CPI", "CPI12345!")
				.goToClaims()
				.goToReports()
				.goToBatchOSPrinting()
				.printSelectedRecord(record);
	}
}
