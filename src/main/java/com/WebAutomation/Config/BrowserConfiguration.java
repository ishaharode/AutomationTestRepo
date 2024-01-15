package com.WebAutomation.Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.time.Duration;

public class BrowserConfiguration {

    public static WebDriver driver;
    public static Logger log;
    ChromeOptions chromeOptions = new ChromeOptions();

    FirefoxOptions firefoxOptions = new FirefoxOptions();
    EdgeOptions edgeOptions = new EdgeOptions();

    public static void initializeDriver(String Browser)
    {
        log= LogManager.getLogger(BrowserConfiguration.class);

        if(Browser.equalsIgnoreCase("chrome"))
        {
            driver = WebDriverManager.chromedriver().create();
            log.info("Initialize Chrome Driver");
        }
        else if(Browser.equalsIgnoreCase("firefox"))
        {
            driver = WebDriverManager.firefoxdriver().create();
            log.info("Initialize Firefox Driver");
        }
        else if(Browser.equalsIgnoreCase("edge"))
        {
            driver = WebDriverManager.edgedriver().create();
            log.info("Initialize MS Edge Driver");
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        log.info("Screen maximized and cookies deleted");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    public static WebDriver getDriver()
    {
        return driver;
    }


    public void quitBrowser()
    {
        driver.quit();
        log.info("Quit the browser");
    }



}
