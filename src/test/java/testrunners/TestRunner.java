package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(

        features ={"src/test/java/Features/"},
        glue ={"stepdefinitions","basetest"},
        plugin = { "pretty","html:target/cucumber-reports/cucumberreport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags= "@Test"


)


public class TestRunner extends AbstractTestNGCucumberTests {


}
