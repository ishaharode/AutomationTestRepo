package com.webautomation.config;

import com.webautomation.utils.TestLogger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BrowserWaits {
    private WebDriver driver;
    private Logger log;

    public BrowserWaits()
    {
        log = TestLogger.logger(BrowserWaits.class);
        driver=BrowserConfiguration.getDriver();
    }
    public void webDriverWait(int time)
    {
        log.info("implicit wait applied");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void waitForPageToBeLoad(long time)
    {
        log.info("PageLoadWait is applied");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

    }
    public void waitForScriptTimeout(int time)
    {
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }
    public WebElement waitUntilElementToBeClickable(WebElement element)
    {
        log.info("waiting for element to be clickable");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        return webElement;
    }
}
