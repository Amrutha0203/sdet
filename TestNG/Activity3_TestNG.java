package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3_TestNG
{
	WebDriver driver;

	@BeforeClass
	public void openBrowser() 
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
	}
	
	@Test
	public void login()
	{
		//Enter username and password
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		
		//Login
		driver.findElement(By.xpath("//*[@onclick='signIn()']")).click();
		
		//Verify confirmation message
		String confirmationmsg= driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals(confirmationmsg, "Welcome Back, admin");
	}

	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
