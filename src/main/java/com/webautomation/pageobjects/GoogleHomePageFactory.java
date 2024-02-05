package com.webautomation.pageobjects;

import com.webautomation.config.BrowserConfiguration;
import com.webautomation.config.BrowserWaits;
import com.webautomation.exceptions.ElementNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Instantiate the WebElements
 */

public class GoogleHomePageFactory extends BrowserWaits {
     private WebDriver driver;
    private static Logger log= LogManager.getLogger(GoogleHomePageFactory.class);
    @FindBy(xpath="//textarea[@title=\"Search\"]")
    WebElement googleSearchBar;
    @FindBy(xpath="(//div[@class=\"MjjYud\"]/div//a)[1]/h3")
    WebElement firstSearchResult;
    By searchRslt = By.xpath("(//div[@class=\"MjjYud\"]/div//a)[1]/h3");

    public void enterTheSearchTerm(String searchKey)
    {
        if(googleSearchBar == null){
            throw new ElementNotFoundException();
        }
        googleSearchBar.sendKeys(searchKey);
        googleSearchBar.sendKeys(Keys.ENTER);
        log.info("Initiate the Google Search with Search key ");

    }

    public String verifyTheFirstSearchResult()
    {
        if(firstSearchResult == null){
            throw new ElementNotFoundException();
        }
        waitForElementToAppear(searchRslt);
        String actualResult = firstSearchResult.getText();
        return actualResult;
    }

    public GoogleHomePageFactory()
    {
        this.driver = BrowserConfiguration.getDriver();
        PageFactory.initElements(driver,this);
        log.info("Initialize the Google page elements ");

    }

}
