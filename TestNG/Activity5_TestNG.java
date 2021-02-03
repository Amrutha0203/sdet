package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5_TestNG
{
	WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void openBrowser() 
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}	
	@Test(groups = {"HeaderTests","ButtonTests"})
	public void verifyPageTitle()
	{
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Target Practice");
	}	
	
	@Test (dependsOnMethods = {"verifyPageTitle"}, groups = {"HeaderTests"})
	public void headerTest3()
	{
		String thirdHeader= driver.findElement(By.xpath("//*[@id='third-header']")).getText();
		Assert.assertEquals(thirdHeader, "Third header");
	}
	
	@Test (dependsOnMethods = {"verifyPageTitle"}, groups = {"HeaderTests"})
	public void headerTest5()
	{
		String fifthheader = driver.findElement(By.cssSelector("h3#third-header")).getCssValue("color");
		System.out.println(fifthheader);
		Assert.assertEquals(fifthheader, "rgb(251, 189, 8)");
	}
	
	@Test (dependsOnMethods = {"verifyPageTitle"}, groups = {"ButtonTests"})
	public void buttonTests1()
	{
		String button1 = driver.findElement(By.cssSelector("button.olive")).getText();
		Assert.assertEquals(button1, "Olive");
	}
	
	@Test  (dependsOnMethods = {"verifyPageTitle"}, groups = {"ButtonTests"})
	public void buttonTest2()
	{
		String button2 = driver.findElement(By.cssSelector("button.brown")).getCssValue("color");
		Assert.assertEquals(button2, "rgb(255, 255, 255)");
	}
	
	@AfterClass (alwaysRun=true)
	public void closeBrowser()
	{
		driver.quit();
	}
}
