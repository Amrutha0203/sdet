package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on Login page$")
	public void userLogin()
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe"); 
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.training-support.net/selenium/login-form");
	}
	@When("^User enters username and password$")
	public void enterUsernamePassword()
	{
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@onclick='signIn()']")).click();
	}
	
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void enterUsernamePasswordWithoutExample(String username, String password)
	{
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@onclick='signIn()']")).click();
	}
	@Then("^Read the page title and confirmation message$")
	public void getPageTitleVerifyMessage()
	{
		String pageTitle= driver.getTitle();
		System.out.println("The page title is: "+pageTitle);
		String confirmationmsg= driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("The login confirmation message is: "+confirmationmsg);
	}
	@And("^Close the Browser$")
	public void closeBrowser()
	{
		driver.close();		
	}

}
