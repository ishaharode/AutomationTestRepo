package com.WebAutomation.PageMethods;

import com.WebAutomation.Config.BrowserConfiguration;
import com.WebAutomation.Config.BrowserWaits;
import org.openqa.selenium.WebDriver;

public class  HomePage {

   public static WebDriver driver;
   public HomePage()
   {
       driver= BrowserConfiguration.driver;
   }

    BrowserWaits wait = new BrowserWaits();


    public void UrlLaunch(String browser)
    {
        driver.get(browser);
        wait.waitForPageToBeLoad(30);
        System.out.println("URL is Launched");

    }


}
