package seleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alchemy_LMS 
{
	WebDriver driver;


	@BeforeMethod
	public void launchBrowser() 
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe"); 
		driver= new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	@Test (priority=0)
	public void verifyTitle()
	{	
		String ActualTitle= driver.getTitle();
		String ExpectedTitle= "Alchemy LMS – An LMS Application";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	@Test (priority=1)
	public void verifyHeading()
	{
		String ActualHeading= driver.findElement(By.xpath("//*[@id='uagb-infobox-74cd79b6-b855-4e72-81bc-e70591de1896']//h1")).getText();
		String ExpectedHeading= "Learn from Industry Experts";
		Assert.assertEquals(ActualHeading, ExpectedHeading);
	}
	@Test (priority=2)
	public void verifyFirstInfoTitle()
	{
		String ActualFirstInfoTitle= driver.findElement(By.xpath("//*[@id='uagb-infobox-f08ebab0-fbf1-40ec-9b2a-c9feeb3d4810']//h3")).getText();
		String ExpectedFirstInfoTitle= "Actionable Training";
		Assert.assertEquals(ActualFirstInfoTitle, ExpectedFirstInfoTitle);
	}
	@Test (priority=3)
	public void verifySecondPopularCourse()
	{
		String ActualSecondPopularCourse= driver.findElement(By.xpath("//article[@id='post-71']//h3")).getText();
		String ExpectedSecondPoularCourse= "Email Marketing Strategies";
		Assert.assertEquals(ActualSecondPopularCourse, ExpectedSecondPoularCourse);
	}
	@Test(priority=4)
	public void navigateToMyAccountPage()
	{
		driver.findElement(By.xpath("//*[@id='primary-menu']/li[5]")).click();
		String ActualMyAccountPageTitle= driver.getTitle();
		String ExpectedMyAccountPageTittle= "My Account – Alchemy LMS";
		Assert.assertEquals(ActualMyAccountPageTitle, ExpectedMyAccountPageTittle);
	}
	@Test (priority=5)
	public void login()
	{
		navigateToMyAccountPage();
		driver.findElement(By.xpath("//*[@href='#login']")).click();
		driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//*[@id='user_pass']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//*[@id='wp-submit']")).click();
		String ActualUser= driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']//a//span")).getText();
		String ExpectedUser= "root";
		Assert.assertEquals(ActualUser, ExpectedUser);	
	}
	@Test (priority=6)
	public void verifyAllCourses()
	{   
		int i;
		int noOfCourses;
		driver.findElement(By.xpath("//*[@id='primary-menu']/li[2]")).click();
		noOfCourses = driver.findElements(By.xpath("//*[@class='ld-course-list-content']//article")).size();
		System.out.println("The total no.of courses available are: "+noOfCourses);
		for(i=1; i<=noOfCourses; i++)
		{
			String listOfCourses = driver.findElement(By.xpath("(//*[@class='ld-course-list-content']//article//div//h3)" + "["+i+"]")).getText();
			System.out.println("The list of available courses are: "+listOfCourses);
		}
	}
	@Test (priority=7) 
	public void admin()
	{
		driver.findElement(By.xpath("//*[@id='primary-menu']/li[4]")).click();
		driver.findElement(By.xpath("//*[@id='wpforms-8-field_0']")).sendKeys("Amrutha");
		driver.findElement(By.xpath("//*[@id='wpforms-8-field_1']")).sendKeys("amrutha@gmail.com");
		driver.findElement(By.xpath("//*[@id='wpforms-8-field_3']")).sendKeys("SDET_TRAINING");
		driver.findElement(By.xpath("//*[@id='wpforms-8-field_2']")).sendKeys("Testing Application");
		driver.findElement(By.xpath("//*[contains(text(), 'Send Message')]")).click();
		String confirmationMessage = driver.findElement(By.xpath("//*[@id='wpforms-confirmation-8']//p")).getText();
		System.out.println("Submission messgae is: "+confirmationMessage);		
	}
	@Test (priority=8)
	public void completelesson() throws InterruptedException
	{
		login();
		driver.findElement(By.xpath("//*[@id='primary-menu']/li[2]")).click();
		driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
		driver.findElement(By.xpath("//*[@id='ld-expand-button-69']")).click();
		driver.findElement(By.xpath("(//*[@class='ld-table-list-items']//div)[1]")).click();
		String ActualLessonPageTitle = driver.getTitle();
		String ExpectedLessonPageTitle= "This is the First Topic – Alchemy LMS";
		Assert.assertEquals(ActualLessonPageTitle, ExpectedLessonPageTitle);	
	}
}
