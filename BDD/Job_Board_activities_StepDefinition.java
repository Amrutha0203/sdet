package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Job_Board_activities_StepDefinition
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Open Browser$")
	public void openBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe"); 
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);						
	}
	
	@When("^Open job board system application$")
	public void openJobBoardApplication()
	{
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}
	
	@Then("^Login to the application with \"(.*)\\\" and \\\"(.*)\"$")
	public void loginApplication(String Username, String Password)
	{
		Username= "root";
		Password= "pa$$w0rd";
		driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys(Username);
		driver.findElement(By.xpath("//*[@id='user_pass']")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id='wp-submit']")).click();
		
	}
	
	@Given("^Locate left hand menu and click on Users$")
	public void userMenu() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class='wp-menu-name'])[9]")).click();
	}
	
	@When("^Find Add New button and click on it$")
	public void addnewUser()
	{
		driver.findElement(By.xpath("(//*[@href='https://alchemy.hguy.co/jobs/wp-admin/user-new.php'])[2]")).click();			
	}
	
	@Then("^Fill all necessary detail and click Add New User button$")
	public void fillUserDetails()
	{
		driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("User98");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("ammu560319@gmail.com");
		driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Kushi");
		driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Bellur");
		driver.findElement(By.xpath("//*[@id='url']")).sendKeys("https//670708");	
		driver.findElement(By.xpath("//button[contains (text(), 'Show password')]")).click();
		driver.findElement(By.xpath("//*[@id='pass1']")).sendKeys("Ammu@23#95#9");	
		driver.findElement(By.xpath("//*[@class='pw-checkbox']")).click();
		driver.findElement(By.xpath("//*[@id='createusersub']")).click();
	}
	@And("^Verify user has been created$")
	public void verifyUserAdded()
	{
		driver.findElement(By.xpath("//*[@id='user-search-input']")).sendKeys("ammu560319@gmail.com");
		driver.findElement(By.xpath("//*[@id='search-submit']")).click();
		boolean user= driver.findElement(By.xpath("(//*[@id='the-list'])//a[contains (text(), 'ammu560319@gmail.com')]")).isDisplayed();
		Assert.assertTrue(user);
	}
	
	@When("^Open Alchemy job site and navigate to Jobs Page$")
	public void navigateToJobsPage()
	{
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.findElement(By.xpath("//*[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
	}
	
	@Then("^Search for jobs$")
	public void searchForJobs()
	{
		driver.findElement(By.xpath("//*[@id='search_keywords']")).sendKeys("Cucumber_Tester");
	}
	
	@And("^Filter Full-Time job$")
	public void filterFullTimeJob()
	{
		driver.findElement(By.xpath("//*[@id='job_type_freelance']")).click();
		driver.findElement(By.xpath("//*[@id='job_type_internship']")).click();
		driver.findElement(By.xpath("//*[@id='job_type_part-time']")).click();
		driver.findElement(By.xpath("//*[@id='job_type_temporary']")).click();
		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
	}
	@And("^List the job filtered and print title in console$")
	public void filteredJobTitle() throws InterruptedException
	{
		Thread.sleep(10000);
		boolean jobSearched = driver.findElement(By.xpath("//h3[contains(text(), 'Cucumber_Tester')]")).isDisplayed();
		Assert.assertTrue(jobSearched);
		driver.findElement(By.xpath("//h3[contains(text(), 'Cucumber_Tester')]")).click();
		String SearchedJobTitle= driver.findElement(By.xpath("//*[@class='entry-title']")).getText();
		System.out.println("The searched job title is: "+SearchedJobTitle);
		String SearchedJobDescription = driver.findElement(By.xpath("//*[@class='job_description']//p")).getText();
		System.out.println("The searched job description is: "+SearchedJobDescription);
	}
	
	@And("^Apply for job$")
	public void applyForJob()
	{
		driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
	}
	
	@When("^Open Alchemy job site and navigate to post job page$")
	public void navigateToJobSiteAndPostJobPage()
	{
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.findElement(By.xpath("//*[@href='https://alchemy.hguy.co/jobs/post-a-job/']")).click();
	}
	
	@Then("^User enters \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void fillPostJobForm(String Emailid, String JobTitle, String Location, String Description, String Url, String CompanyName)
	{
		driver.findElement(By.xpath("//*[@id='create_account_email']")).sendKeys(Emailid);
		driver.findElement(By.xpath("//*[@id='job_title']")).sendKeys(JobTitle);
		driver.findElement(By.xpath("//*[@id='job_location']")).sendKeys(Location);
		driver.findElement(By.xpath("//*[@id='job_description_ifr']")).sendKeys(Description);
		driver.findElement(By.xpath("//*[@id='application']")).sendKeys(Url);
		driver.findElement(By.xpath("//*[@id='company_name']")).sendKeys(CompanyName);		
	}
	
	@And("^Click on Submit$")
	public void submitJob()
	{
		driver.findElement(By.xpath("//input[@class='button secondary save_draft']")).click();
	}
	
	@And("^Go to jobs page$")
	public void goToJobspage()
	{
	    driver.findElement(By.xpath("(//*[@href='https://alchemy.hguy.co/jobs/job-dashboard/'])[2]")).click();	
	}
	
	@And("^Verify newly added job is shown in job listing page$")
	public void verifyNewlyAddedJob()
	{
		Boolean NewlyAddedJobTitle= driver.findElement(By.xpath("//*[@id='job-manager-job-dashboard']//td[@class='job_title']")).isDisplayed();
		Assert.assertTrue(NewlyAddedJobTitle);
	}
	
	@And("^Close the browser$")
	public void closeBrowser()
	{
		driver.close();
	}

}
