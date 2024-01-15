package TestRunners;

import com.webautomation.config.BrowserConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;


@CucumberOptions(

        features ="src/test/java/Features/Search.feature",
        glue ={"StepDefinitions"},
        plugin = { "pretty","html:target/cucumber-reports/cucumberreport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags= "@Test"


)


public class TestRunner extends AbstractTestNGCucumberTests {

    //@BeforeSuite(alwaysRun = true)
    @BeforeTest
    @Parameters("browser")
    public void initialize(String browser){
        System.out.println(browser);
        BrowserConfiguration.initializeDriver(browser);
    }

}
