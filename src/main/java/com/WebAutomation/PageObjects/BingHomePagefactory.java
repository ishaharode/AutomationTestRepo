package com.WebAutomation.PageObjects;

import com.WebAutomation.Config.BrowserConfiguration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingHomePagefactory {
    public static WebDriver driver;

    @FindBy(xpath="//textarea[@type='search']")
    WebElement BingSearchBar;

    @FindBy(xpath="//a[text()=\"Selenium Tutorial - Guru99\"]")
    WebElement firstSearchResult;


    public void enterTheSearchTerm(String searchKey)
    {
        BingSearchBar.sendKeys(searchKey);
        BingSearchBar.sendKeys(Keys.ENTER);

    }

    public String verifyTheFirstSearchResult()
    {
        String actualResult = firstSearchResult.getText();
        return actualResult;


    }
    public BingHomePagefactory()
    {
        this.driver =  driver= BrowserConfiguration.driver;
        PageFactory.initElements(driver,this);

    }
}
