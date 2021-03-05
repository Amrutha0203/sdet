package AppiumActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class session2AppiumActivity1
{
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void beforeSetUp()
	{
		DesiredCapabilities dsc = new DesiredCapabilities();
		dsc.setCapability("deviceId", "emulator-5554");
		dsc.setCapability("deviceName", "Pixel4Emulator");
		dsc.setCapability("platformName", "android");
		dsc.setCapability("appPackage", "com.android.chrome");
		dsc.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		dsc.setCapability("noReset", true);
		try 
		{
			driver = new AndroidDriver <MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"), dsc);
			wait = new WebDriverWait(driver, 10);
		} 
		catch (MalformedURLException e) 
		{
			System.out.println(e.getMessage());
		}		
	}
	@Test
	public void loginWeb()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.training-support.net/");

		String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
		System.out.println("Title of the homepage is: "+pageTitle);
		
		MobileElement aboutUsButton= driver.findElementById("about-link");
	    aboutUsButton.click();
		String AboutUSTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]").getText();
		System.out.println("Title of the About Us page is: "+AboutUSTitle);
		
		Assert.assertEquals(pageTitle, "Training Support");
		Assert.assertEquals(AboutUSTitle, "About Us");
	}
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}
}
