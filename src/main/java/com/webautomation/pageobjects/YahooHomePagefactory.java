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

public class YahooHomePagefactory extends BrowserWaits {
    private WebDriver driver;
    private static Logger log= LogManager.getLogger(YahooHomePagefactory.class);

    @FindBy(xpath="//input[@placeholder=\"Search the web\"]")
    WebElement yahooSearchBar;

    @FindBy(xpath="(//span[contains(text(),\"Selenium Testing\")])[1]")
    WebElement firstSearchResult;
    By searchRslt = By.xpath("(//span[contains(text(),\"Selenium Testing\")])[1]");


    public void enterTheSearchTerm(String searchKey)
    {
        if(yahooSearchBar == null){
            throw new ElementNotFoundException();
        }
        yahooSearchBar.sendKeys(searchKey);
        yahooSearchBar.sendKeys(Keys.ENTER);
        log.info("Initiate the yahoo Search with Search key");
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
    public YahooHomePagefactory()
    {
        this.driver = BrowserConfiguration.getDriver();
        PageFactory.initElements(driver,this);
        log.info("Initialize the Yahoo page elements ");
    }
}
