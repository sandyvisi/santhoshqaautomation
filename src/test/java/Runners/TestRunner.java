package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "D:\\eclipse-workspace\\vinothqaacademy\\src\\test\\resources\\features\\regformfill.feature", 
		glue = "stepDefinitions", 
		plugin = {"pretty", "html:target/cucumber-report.html" }, 		 
		monochrome = true, 
		dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests {

}

