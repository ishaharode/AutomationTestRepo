package testrunners;

import com.webautomation.config.BrowserConfiguration;
import com.webautomation.utils.ConfigProperties;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

import java.io.IOException;


@CucumberOptions(

        features ="src/test/java/Features/Search.feature",
        glue ={"stepdefinitions"},
        plugin = { "pretty","html:target/cucumber-reports/cucumberreport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags= "@Test"


)


public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("browser")
    public void initialize(String browser) throws IOException {

        BrowserConfiguration.initializeDriver(browser);

    }

}
