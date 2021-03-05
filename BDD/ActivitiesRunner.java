package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "src/test/java/Feature",
		glue= {"StepDefinitions"},
		tags= "@SmokeTest",
		//plugin= {"html: test-reports"},
	    plugin = {"json: json-reports.json"},
		monochrome= true
)
public class ActivitiesRunner
{

}
