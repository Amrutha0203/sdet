package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "src/test/java/Feature",
		glue = {"StepDefinitions"},
		tags= "@JobBoardactivity_2 or @HRMactivity4 or @CRM_activity1",
		plugin= {"html: test-project-reports"},
		monochrome= true
)
public class TestRunner
{
	
}
