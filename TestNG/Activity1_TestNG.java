package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity1_TestNG
{
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() 
	{
		 System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.get("https://www.training-support.net");
	}
	
	@Test
	public void Activity1()
	{
		//Verify training support page title
		String title= driver.getTitle();
		System.out.println("The title of the page is: "+title);
		Assert.assertEquals(title, "Training Support");
		
		driver.findElement(By.xpath("//*[@id='about-link']")).click();
		
		//Verify about us page title
		String titleabout = driver.getTitle();
		System.out.println("The title of the about us page is: "+titleabout);
		Assert.assertEquals(titleabout, "About Training Support");
		
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}
