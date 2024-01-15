package com.webautomation.pagemethods;

import com.webautomation.config.BrowserConfiguration;
import com.webautomation.config.BrowserWaits;
import org.openqa.selenium.WebDriver;

public class  HomePage {

   private WebDriver driver;

   public HomePage()
   {
       driver= BrowserConfiguration.getDriver();
   }
    BrowserWaits wait = new BrowserWaits();
    public void UrlLaunch(String url)
    {
        driver.get(url);
        wait.waitForPageToBeLoad(30);
        System.out.println("URL is Launched");

    }
}
