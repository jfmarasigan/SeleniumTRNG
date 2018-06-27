package com.trng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");
		Thread.sleep(3000);
		// navigate
		driver.navigate().to("https://stackoverflow.com");
		Thread.sleep(3000);
		// back button in browser
		driver.navigate().back();
		Thread.sleep(3000);
		// forward button in browser
	}
}
