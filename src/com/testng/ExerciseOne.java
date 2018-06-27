package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExerciseOne {

	private WebDriver driver;
	private WebDriverWait wait;
	private static final Integer BASE_WAIT_TIME = 60;

	@Test(priority = 0)
	public void login() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userId"))).sendKeys("CPI");
		driver.findElement(By.id("password")).sendKeys("CPI12345!");
		driver.findElement(By.id("loginButton")).click();
	}

	@Test(priority = 1)
	public void goToClaims() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("iconClaims"))).click();
	}

	@Test(priority = 2)
	public void goToBordereuxReportPage() {
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Reports"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bordereauxClaimsRegister"))).click();
	}

	@Test(priority = 3)
	public void reportCbxTypeElemTest() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("rdoClaimsRegister"))).click();
	}

	@Test(priority = 4)
	public void brdrxSideTaggableElemsTest () {
		final String lossRdo = "rdoPerLoss";
		final String perLineCbx = "chkPerLine";
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id(lossRdo)));
		
		if (!driver.findElement(By.id(lossRdo)).isSelected()) {
			driver.findElement(By.id(lossRdo)).click();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id(perLineCbx)));
		if (!driver.findElement(By.id(perLineCbx)).isSelected()) {
			driver.findElement(By.id(perLineCbx)).click();
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
	}
	
	@Test(priority = 5)
	public void datePickerTest() {
		driver.findElement(By.id("imgDspFromDate")).click();
		new Select(driver.findElement(By.id("scwMonths"))).selectByVisibleText("Apr");
		new Select(driver.findElement(By.id("scwYears"))).selectByVisibleText("2018");
		driver.findElement(By.xpath("//*[@id=\"scwCell_0\"]")).click();

		driver.findElement(By.id("imgDspToDate")).click();
		new Select(driver.findElement(By.id("scwMonths"))).selectByVisibleText("Apr");
		new Select(driver.findElement(By.id("scwYears"))).selectByVisibleText("2018");
		driver.findElement(By.xpath("//*[@id=\"scwCell_29\"]")).click();
	}

	@Test(priority = 6)
	public void lovTest() {
		final String inputFieldXpath = "//input[@type='text' and starts-with(@id, 'modal_dialog')]";
		driver.findElement(By.id("searchLineLOV")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputFieldXpath))).sendKeys("MC%", Keys.ENTER);

		driver.findElement(By.id("searchSublineLOV")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputFieldXpath))).sendKeys("MNP%", Keys.ENTER);

		driver.findElement(By.id("searchBranchLOV")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputFieldXpath))).sendKeys("HO%", Keys.ENTER);
	}
	
	@Test(priority = 7)
	public void rdoClmTypeTest() {
		driver.findElement(By.id("rdoClaimIssCd")).click();
	}
	
	@Test(priority = 8)
	public void extractAndPrintTest() {

		driver.findElement(By.id("btnExtract")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"btnMsgBoxOk\"]"))).click();
		driver.findElement(By.id("btnPrintGicls202")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnPrint"))).click();
	}
	
	@Test(priority = 9)
	public void closeSecondWindow() throws InterruptedException {
		String mainWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(5000);
		driver.close();
	}
	
	@BeforeTest
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver-v0.21.0-win64\\\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, BASE_WAIT_TIME);
	}

	@AfterTest
	public void afterClass() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

	@BeforeClass
	public void getURL() {
		driver.get("http://192.10.10.240:9090/Geniisys/");
	}

}
