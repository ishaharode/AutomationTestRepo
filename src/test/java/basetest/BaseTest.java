package basetest;

import com.webautomation.config.BrowserConfiguration;
import com.webautomation.exceptions.DriverNotFoundException;
import io.cucumber.java.*;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testlisteners.RetryAnalyzer;


public class BaseTest extends BrowserConfiguration {
    private static Logger log= LogManager.getLogger(BaseTest.class);

    @AfterStep
    public void takeScreenShotOnFailedScenario(Scenario scenario) throws IOException, DriverNotFoundException {
        log.info("Taking screenshot if the scenario fails");
        if ((scenario.isFailed()))
        {
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }



}
