package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "D:\\eclipse-workspace\\automationexercise\\src\\test\\resources\\features\\login.feature",
		glue = "stepDefinitions", 
		plugin = {"pretty", "html:target/cucumber-report.hrml" }, 
		monochrome = true, 
		dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
