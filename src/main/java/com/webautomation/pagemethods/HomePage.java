package com.webautomation.pagemethods;

import com.webautomation.config.BrowserConfiguration;
import com.webautomation.config.BrowserWaits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class  HomePage {

   private WebDriver driver;
    private static Logger log= LogManager.getLogger(HomePage.class);
   public HomePage()
   {
       driver= BrowserConfiguration.getDriver();
   }
    BrowserWaits wait = new BrowserWaits();
    public void UrlLaunch(String url)
    {
        driver.get(url);
        wait.waitForPageToBeLoad(30);
        log.info("URL is Launched");

    }


}
