package com.trng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExerciseFour {

	private static WebDriver driver;
	private static WebDriverWait wait;

	private static final Integer BASE_WAIT_TIME = 60;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver-v0.21.0-win64\\\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, BASE_WAIT_TIME);
		driver.get("http://192.10.10.240:9090/Geniisys/");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userId"))).sendKeys("CPI");
		driver.findElement(By.id("password")).sendKeys("CPI12345!");
		driver.findElement(By.id("loginButton")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("iconClaims"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Reports"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bordereauxClaimsRegister"))).click();		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("rdoClaimsRegister"))).click();
		
		if (!driver.findElement(By.id("rdoPerLoss")).isSelected()) {
			driver.findElement(By.id("rdoPerLoss")).click();
		}
		if (!driver.findElement(By.id("chkPerLine")).isSelected()) {
			driver.findElement(By.id("chkPerLine")).click();
		}
		if (driver.findElement(By.id("chkPerBranch")).isSelected()) {
			driver.findElement(By.id("chkPerBranch")).click();
		}
		if (driver.findElement(By.id("chkPerIntermediary")).isSelected()) {
			driver.findElement(By.id("chkPerIntermediary")).click();
		}
		if (driver.findElement(By.id("chkPerLossCategory")).isSelected()) {
			driver.findElement(By.id("chkPerLossCategory")).click();
		}
		
		driver.findElement(By.id("imgDspFromDate")).click();
		new Select(driver.findElement(By.id("scwMonths"))).selectByVisibleText("Apr");
		new Select(driver.findElement(By.id("scwYears"))).selectByVisibleText("2018"); 
		driver.findElement(By.xpath("//*[@id=\"scwCell_0\"]")).click();
		
		driver.findElement(By.id("imgDspToDate")).click();
		new Select(driver.findElement(By.id("scwMonths"))).selectByVisibleText("Apr");
		new Select(driver.findElement(By.id("scwYears"))).selectByVisibleText("2018"); 
		driver.findElement(By.xpath("//*[@id=\"scwCell_29\"]")).click();
		
		/*driver.findElement(By.id("txtDspLineCd")).sendKeys("MC");
		driver.findElement(By.id("txtDspLineName")).click();
		driver.findElement(By.id("txtDspSublineCd")).sendKeys("MNP");
		driver.findElement(By.id("txtDspSublineName")).click();
		driver.findElement(By.id("txtDspIssCd")).sendKeys("HO");
		driver.findElement(By.id("txtDspIssName")).click();*/
		
		// String okXPath = "//input[@type='button' and @value='Ok']";
		
		driver.findElement(By.id("searchLineLOV")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text' and starts-with(@id, 'modal_dialog')]"))).sendKeys("MC%", Keys.ENTER);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), \"MC\")]"))).click();
		//driver.findElement(By.xpath(okXPath)).click();
		
		driver.findElement(By.id("searchSublineLOV")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text' and starts-with(@id, 'modal_dialog')]"))).sendKeys("MNP%", Keys.ENTER);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), \"MNP\")]"))).click();
		//driver.findElement(By.xpath(okXPath)).click();
		
		driver.findElement(By.id("searchBranchLOV")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text' and starts-with(@id, 'modal_dialog')]"))).sendKeys("HO%", Keys.ENTER);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), \"HO\")]"))).click();
		//driver.findElement(By.xpath(okXPath)).click();

		driver.findElement(By.id("rdoClaimIssCd")).click(); 
		
		driver.findElement(By.id("btnExtract")).click(); 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"btnMsgBoxOk\"]"))).click();
		driver.findElement(By.id("btnPrintGicls202")).click(); 
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnPrint"))).click();
	}

}
