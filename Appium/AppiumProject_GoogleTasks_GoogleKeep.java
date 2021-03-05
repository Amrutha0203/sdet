package AppiumActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class AppiumProject_GoogleTasks_GoogleKeep
{
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	

	@Test(priority=0)
	public void googleTaks() throws MalformedURLException 
	{
		DesiredCapabilities dsc = new DesiredCapabilities();
		dsc.setCapability("deviceId", "emulator-5554");
		dsc.setCapability("deviceName", "Pixel4Emulator");
		dsc.setCapability("platformName", "android");
		dsc.setCapability("appPackage", "com.google.android.apps.tasks");
		dsc.setCapability("appActivity", ".ui.TaskListsActivity");
		dsc.setCapability("noReset", true);

		driver = new AndroidDriver <MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"), dsc);
		wait = new WebDriverWait(driver, 10);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("tasks_fab").click();
		driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
		driver.findElementById("add_task_done").click();

		driver.findElementById("tasks_fab").click();
		driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
		driver.findElementById("add_task_done").click();

		driver.findElementById("tasks_fab").click();
		driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
		driver.findElementById("add_task_done").click();

		MobileElement Task1= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='Complete Activity with Google Tasks']");
		Assert.assertTrue(Task1.isDisplayed());

		MobileElement Task2= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='Complete Activity with Google Keep']");
		Assert.assertTrue(Task2.isDisplayed());

		MobileElement Task3= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='Complete the second Activity Google Keep']");
		Assert.assertTrue(Task3.isDisplayed());		
	}
	@Test(priority=1)
	public void googleKeepNote() throws MalformedURLException
	{
		DesiredCapabilities dsc = new DesiredCapabilities();
		dsc.setCapability("deviceId", "emulator-5554");
		dsc.setCapability("deviceName", "Pixel4Emulator");
		dsc.setCapability("platformName", "android");
		dsc.setCapability("appPackage", "com.google.android.keep");
		dsc.setCapability("appActivity", ".activities.BrowseActivity");
		dsc.setCapability("noReset", true);

		driver = new AndroidDriver <MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"), dsc);
		wait = new WebDriverWait(driver, 10);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("new_note_button").click();
		driver.findElementById("editable_title").sendKeys("SDET Project");
		driver.findElementById("edit_note_text").sendKeys("This is appium project activity on Google tasks and Google keep");
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		
		MobileElement noteAdded= driver.findElementById("browse_text_note");
		Assert.assertTrue(noteAdded.isDisplayed());
		
		MobileElement noteTitle= driver.findElementById("index_note_title");
		Assert.assertEquals("SDET Project", noteTitle.getText());
		
		MobileElement noteDescription= driver.findElementById("index_note_text_description");
		Assert.assertEquals("This is appium project activity on Google tasks and Google keep", noteDescription.getText());
				
	}
	@Test(priority=2)
	public void googleKeepNoteWithRemainder() throws MalformedURLException
	{
		DesiredCapabilities dsc = new DesiredCapabilities();
		dsc.setCapability("deviceId", "emulator-5554");
		dsc.setCapability("deviceName", "Pixel4Emulator");
		dsc.setCapability("platformName", "android");
		dsc.setCapability("appPackage", "com.google.android.keep");
		dsc.setCapability("appActivity", ".activities.BrowseActivity");
		dsc.setCapability("noReset", true);

		driver = new AndroidDriver <MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"), dsc);
		wait = new WebDriverWait(driver, 10);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("new_note_button").click();
		driver.findElementById("editable_title").sendKeys("SDET Project Google Keep");
		driver.findElementById("edit_note_text").sendKeys("This is appium project activity on Google tasks and Google keep with remainder");
		driver.findElementById("com.google.android.keep:id/menu_switch_to_list_view").click();
		driver.findElementById("menu_text").click();	
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		
		MobileElement noteRemainder = driver.findElementById("reminder_chip_text");
		Assert.assertTrue(noteRemainder.isDisplayed());
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
