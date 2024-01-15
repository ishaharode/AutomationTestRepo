package com.webautomation.pageobjects;

import com.webautomation.config.BrowserConfiguration;
import com.webautomation.exceptions.ElementNotFoundException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleHomePageFactory {
     private WebDriver driver;
    @FindBy(xpath="//textarea[@title=\"Search\"]")
    WebElement googleSearchBar;
    @FindBy(xpath="(//div[@class=\"MjjYud\"]/div//a)[1]/h3")
    WebElement firstSearchResult;

    public void enterTheSearchTerm(String searchKey)
    {
        if(googleSearchBar == null){
            throw new ElementNotFoundException();
        }
        googleSearchBar.sendKeys(searchKey);
        googleSearchBar.sendKeys(Keys.ENTER);

    }

    public String verifyTheFirstSearchResult()
    {
        if(firstSearchResult == null){
            throw new ElementNotFoundException();
        }
        String actualResult = firstSearchResult.getText();
        return actualResult;
    }

    public GoogleHomePageFactory()
    {
        this.driver = BrowserConfiguration.getDriver();
        PageFactory.initElements(driver,this);

    }

}
