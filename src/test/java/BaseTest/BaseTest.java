package BaseTest;

import com.webautomation.config.BrowserConfiguration;
import com.webautomation.exceptions.DriverNotFoundException;
import io.cucumber.java.*;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class BaseTest extends BrowserConfiguration {


    @AfterStep
    public void takeScreenShotOnFailedScenario(Scenario scenario) throws IOException, DriverNotFoundException {
        System.out.println("Taking screenshot from Cucumber After hook with order=2 if the scenario fails");
        if ((scenario.isFailed()))
        {
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }



}
