package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity7_TestNG 
{
	WebDriver driver;

	@BeforeClass
	public void openBrowser() 
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
	}
	
	@DataProvider(name ="Authentication")
	public static Object [][] credentials()
	{
		return new Object[][] {{ "admin", "password" }};
	}
	
	@Test (dataProvider = "Authentication")
	public void login(String Username, String Password)
	{
		driver.findElement(By.id("username")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);		
		//Login
		driver.findElement(By.xpath("//*[@onclick='signIn()']")).click();		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

}
