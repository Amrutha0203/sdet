package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Activity9_TestNG 
{
	WebDriver driver;

	@BeforeTest
	public void openBrowser() 
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		Reporter.log("Test started");

		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Reporter.log("Browser opened");

		Reporter.log("The page tilte is: " +driver.getTitle());
	}
	@BeforeMethod
	public void beforeMethod()
	{
		Reporter.log("To switch content");
		driver.switchTo().defaultContent();
	}

	@Test (priority=0)
	public void  simpleAlertTestCase()
	{
		Reporter.log("SimpleAlert Testcase started");
		driver.findElement(By.id("simple")).click();
		
		Reporter.log("Simple Alert displayed");
		Alert simpleAlert = driver.switchTo().alert();
		Reporter.log("Switched to simple Alert");
		
		String simpleAlerttxt = simpleAlert.getText();
		Reporter.log("Simple alert text: " +simpleAlerttxt);
		
		Assert.assertEquals(simpleAlerttxt, "This is a JavaScript Alert!");
		simpleAlert.accept();
		Reporter.log("Simple Alert Closed");
		Reporter.log("SimpleAlert Testcase execution ended");
	}

	@Test (priority=1)
	public void confirmAlertTestCase()
	{
		Reporter.log("Confirm Alert Testcase started");
		driver.findElement(By.id("confirm")).click();
		
		Reporter.log("Confirm alert displayed");
		Alert confirmAlert = driver.switchTo().alert();
		Reporter.log("Switched to confirm Alert");
		
		String confirmAlerttxt = confirmAlert.getText();
		Reporter.log("Confirm alert text: "+confirmAlerttxt);
		
		Assert.assertEquals(confirmAlerttxt, "This is a JavaScript Confirmation!");
		confirmAlert.accept();
		Reporter.log("Confirm alert closed");
		Reporter.log("Confirm Alert Testcase execution ended");
	}

	@Test (priority=2)
	public void promptAlertTestCase()
	{
		Reporter.log("Prompt alert testcase execution started");
		driver.findElement(By.id("prompt")).click();
		
		Reporter.log("prompt alert displayed");
		Alert promptAlert= driver.switchTo().alert();
		Reporter.log("Switched to prompt alert");
		
		String promptalerttxt= promptAlert.getText();
		Reporter.log("Prompt Alert text: " +promptalerttxt);
		
		promptAlert.sendKeys("Test");
		Reporter.log("Entered text to prompt alert");
		
		Assert.assertEquals(promptalerttxt, "This is a JavaScript Prompt!");
		promptAlert.accept();
		Reporter.log("Prompt alert closed");
		Reporter.log("Prompt Alert Testcase execution ended");
		
	}

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
