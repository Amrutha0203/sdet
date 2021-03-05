package StepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertsSteps 
{
	WebDriver driver;
	WebDriverWait wait;
	Alert alert;
	
	@Given("^User is on the page$")
	public void userOpensPage()
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe"); 
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
	}
	@When("^User clicks the Simple Alert button$")
	public void simpleAlertButton()
	{
		driver.findElement(By.xpath("//*[@id='simple']")).click();
	}
	@When("^User clicks the Confirm Alert button$")
	public void confirmAlertButton()
	{
		driver.findElement(By.xpath("//*[@id='confirm']")).click();
	}
	@When("^User clicks the Prompt Alert button$")
	public void promptAlertButton()
	{
		driver.findElement(By.xpath("//*[@id='prompt']")).click();
	}
	@Then("^Alert opens$")
	public void alertOpens()
	{
		alert= driver.switchTo().alert();
	}
	@And("^Read the text from it and print it$")
	public void readTextFromPopup()
	{
		System.out.println("The text on alert is: "+alert.getText());
	}
	@And("^Write a custom message in it$")
	public void writeCustomPage()
	{
		alert.sendKeys("Prompt custom Message");
	}
	@And("^Close the alert$")
	public void closeAlert()
	{
		alert.accept();
	}
	@And("^Close the alert with Cancel$")
	public void cancelAlert()
	{
		alert.dismiss();
	}
	@And("^Close Browser$")
	public void closeBrowser()
	{
		driver.close();
	}

}
