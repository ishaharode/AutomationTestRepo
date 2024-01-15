package com.webautomation.pageobjects;

import com.webautomation.config.BrowserConfiguration;
import com.webautomation.exceptions.ElementNotFoundException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooHomePagefactory {
    private WebDriver driver;

    @FindBy(xpath="//input[@placeholder=\"Search the web\"]")
    WebElement yahooSearchBar;

    @FindBy(xpath="(//span[contains(text(),\"Selenium Testing\")])[1]")
    WebElement firstSearchResult;


    public void enterTheSearchTerm(String searchKey)
    {
        if(yahooSearchBar == null){
            throw new ElementNotFoundException();
        }
        yahooSearchBar.sendKeys(searchKey);
        yahooSearchBar.sendKeys(Keys.ENTER);
    }

    public String verifyTheFirstSearchResult()
    {
        if(firstSearchResult == null){
            throw new ElementNotFoundException();
        }
        String actualResult = firstSearchResult.getText();
        return actualResult;
    }
    public YahooHomePagefactory()
    {
        this.driver = BrowserConfiguration.getDriver();
        PageFactory.initElements(driver,this);
    }
}
