package com.trng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SampleClass2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// driver.get("http://toolsqa.com/automation-practice-form");
		driver.get("http:/the-internet.herokuapp.com/dropdown");
		// WebElement element = driver.findElement(By.id("continents"));
		WebElement element = driver.findElement(By.id("dropdown"));
		// use this for select html element
		Select select = new Select(element);
		// select.selectByVisibleText("Australia");
		select.selectByVisibleText("Option 2");
	}

}
