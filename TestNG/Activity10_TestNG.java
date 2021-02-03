package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity10_TestNG 
{
	WebDriver driver;
	Actions builder;

	@BeforeClass
	public void openBrowser() 
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		builder = new Actions(driver);
		driver.get("https://www.training-support.net/selenium/sliders");
	}

	@Test (priority=0)
	public void midValSlider()
	{
		driver.findElement(By.id("slider")).click();
		String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
		Reporter.log("Mid Slider value: " + volumeLevel);
		Assert.assertEquals(volumeLevel, "50");
	}

	@Test (priority=1)
	public void maxValSlider()
	{
		WebElement Slider= driver.findElement(By.id("slider"));
		builder.clickAndHold(Slider).moveByOffset(100, 0).release().build().perform();
		String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
		Reporter.log("Max Slider value: " + volumeLevel);
		Assert.assertEquals(volumeLevel, "100");
	}

	@Test (priority=2)
	public void minValSlider()
	{
		WebElement Slider = driver.findElement(By.id("slider"));
		builder.clickAndHold(Slider).moveByOffset(-100, 0).release().build().perform();
		String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
		Reporter.log("Min Slider value: " + volumeLevel);
		Assert.assertEquals(volumeLevel, "0");
	}

	@Test
	public void thirtyValslider()
	{
		WebElement Slider = driver.findElement(By.id("slider"));
		builder.clickAndHold(Slider).moveByOffset(-30, 0).release().build().perform();
		String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
		Reporter.log("Slider value at 30 : " + volumeLevel);
		Assert.assertEquals(volumeLevel, "30");
	}

	@Test
	public void eightyValSlider()
	{
		WebElement Slider = driver.findElement(By.id("slider"));
		builder.clickAndHold(Slider).moveByOffset(45, 0).release().build().perform();
		String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
		Reporter.log("Min value: " + volumeLevel);
		Assert.assertEquals(volumeLevel, "80");
	}

	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
