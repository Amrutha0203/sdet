package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2_TestNG 
{
	WebDriver driver;

	@BeforeClass
	public void openBrowser() 
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}

	@Test
	public void test1()
	{
		//Verify training support page title
		String title= driver.getTitle();
		System.out.println("The title of the page is: "+title);
		Assert.assertEquals(title, "Target Practice");
	}
	
	@Test 
	public void test2()
	{
		WebElement blackbutton = driver.findElement(By.xpath("//*[@class='bullseye icon icon']"));
		Assert.assertFalse(blackbutton.isDisplayed());
	}
	
	@Test (enabled=false)
	public void test3()
	{
		System.out.println("This method will be skipped since 'Enabled-false'.");
	}
	
	@Test
	public void test4()
	{
		throw new SkipException("This testcase will be skipped");
	}

	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

}
