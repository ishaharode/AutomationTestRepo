package com.WebAutomation.PageObjects;

import com.WebAutomation.Config.BrowserConfiguration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooHomePagefactory {
    public static WebDriver driver;

    @FindBy(xpath="//input[@placeholder=\"Search the web\"]")
    WebElement yahooSearchBar;

    @FindBy(xpath="(//span[contains(text(),\"Selenium Testing\")])[1]")
    WebElement firstSearchResult;


    public void enterTheSearchTerm(String searchKey)
    {
        yahooSearchBar.sendKeys(searchKey);
        yahooSearchBar.sendKeys(Keys.ENTER);

    }

    public String verifyTheFirstSearchResult()
    {
        String actualResult = firstSearchResult.getText();
        return actualResult;


    }
    public YahooHomePagefactory()
    {
        this.driver = BrowserConfiguration.driver;
        PageFactory.initElements(driver,this);

    }
}
