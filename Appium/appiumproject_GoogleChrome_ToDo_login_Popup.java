package AppiumActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class appiumproject_GoogleChrome_ToDo_login_Popup
{
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void beforeSetUp() throws MalformedURLException
	{
		DesiredCapabilities dsc = new DesiredCapabilities();
		dsc.setCapability("deviceId", "emulator-5554");
		dsc.setCapability("deviceName", "Pixel4Emulator");
		dsc.setCapability("platformName", "android");
		dsc.setCapability("appPackage", "com.android.chrome");
		dsc.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		dsc.setCapability("noReset", true);

		driver = new AndroidDriver <MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"), dsc);
		wait = new WebDriverWait(driver, 10);
	}

	@Test (priority=0)
	public void loginWeb() throws InterruptedException
	{
		driver.get("https://www.training-support.net/selenium");
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Selenium']")));
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"To-Do List\"))")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]")));


		MobileElement ToEntertask = driver.findElementByXPath("//*[@resource-id='taskInput']");		
		MobileElement ToAddtask= driver.findElementByXPath("//*[@text='Add Task']");

		ArrayList<String> tasklist = new ArrayList<String>();
		tasklist.add("Add tasks to list");
		tasklist.add("Get number of tasks");
		tasklist.add("Clear the list");		
		for(int i=0;i<tasklist.size();i++)
		{
			ToEntertask.sendKeys(tasklist.get(i));
			ToAddtask.isDisplayed();
			ToAddtask.click();
			Thread.sleep(2000);		
		}		
		for(int i=0;i<tasklist.size();i++)
		{			
			String temp = "//*[@text='"+tasklist.get(i)+"']";
			driver.findElementByXPath(temp).click();			
		}		
		driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[3]/android.widget.TextView").click();					
		boolean taskdisplayed = true;	

		driver.findElementByXPath("//*[@text='Add tasks to list']");			
		taskdisplayed = false;			
		Assert.assertEquals(false, taskdisplayed);
	}

	@Test(priority=1)
	public void loginFormValidCredentials() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium");		
		Thread.sleep(5000);	

		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"Login Form\")"));
		driver.findElementByXPath("//*[@text='Login Form']").click();

		driver.findElementByXPath("//*[@resource-id='username']").sendKeys("admin");
		driver.findElementByXPath("//*[@resource-id='password']").sendKeys("password");
		driver.findElementByXPath("//*[@text='Log in']").click();

		Thread.sleep(3000);
		String validcredentials = driver.findElementByXPath("//*[@text='Welcome Back, admin']").getText();
		Assert.assertEquals(validcredentials, "Welcome Back, admin");		
	}

	@Test(priority=2)
	public void loginFormInvalidCredentials() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium");		
		Thread.sleep(5000);		
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"Login Form\")"));
		driver.findElementByXPath("//*[@text='Login Form']").click();

		driver.findElementByXPath("//*[@resource-id='username']").sendKeys("admin");
		driver.findElementByXPath("//*[@resource-id='password']").sendKeys("1234");
		driver.findElementByXPath("//*[@text='Log in']").click();

		Thread.sleep(3000);
		String inValidCredentials = driver.findElementByXPath("//*[@text='Invalid Credentials']").getText();
		Assert.assertEquals(inValidCredentials, "Invalid Credentials");		
	}

	@Test (priority=3)
	public void popUpValidCredentials() throws InterruptedException
	{	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium");		
		Thread.sleep(5000);	

		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"Popups\")"));
		driver.findElementByXPath("//*[@text='Popups']").click();
		driver.findElementByXPath("//*[@text='Sign In']").click();

		driver.findElementByXPath("//*[@resource-id='username']").sendKeys("admin");
		driver.findElementByXPath("//*[@resource-id='password']").sendKeys("password");
		driver.findElementByXPath("//*[@text='Log in']").click();
		Thread.sleep(3000);

		String validcredentials = driver.findElementByXPath("//*[@text='Welcome Back, admin']").getText();
		Assert.assertEquals(validcredentials, "Welcome Back, admin");					
	}

	@Test (priority=4)
	public void incorrectcredentials() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium");		
		Thread.sleep(5000);	

		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"Popups\")"));
		driver.findElementByXPath("//*[@text='Popups']").click();		
		driver.findElementByXPath("//*[@text='Sign In']").click();

		driver.findElementByXPath("//*[@resource-id='username']").sendKeys("admin");
		driver.findElementByXPath("//*[@resource-id='password']").sendKeys("ABCD");
		driver.findElementByXPath("//*[@text='Log in']").click();

		Thread.sleep(3000);
		String InValidCredentials = driver.findElementByXPath("//*[@text='Invalid Credentials']").getText();
		Assert.assertEquals(InValidCredentials , "Invalid Credentials");		
	}

	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
