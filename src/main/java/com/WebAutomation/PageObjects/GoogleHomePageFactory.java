package com.WebAutomation.PageObjects;

import com.WebAutomation.Config.BrowserConfiguration;
import com.WebAutomation.Config.BrowserWaits;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleHomePageFactory {
     public static WebDriver driver;


    @FindBy(xpath="//textarea[@title=\"Search\"]")
    WebElement googleSearchBar;
    @FindBy(xpath="(//div[@class=\"MjjYud\"]/div//a)[1]/h3")
    WebElement FirstSearchResult;


    public void enterTheSearchTerm(String searchKey)
    {
        googleSearchBar.sendKeys(searchKey);
        googleSearchBar.sendKeys(Keys.ENTER);

    }



    public String verifyTheFirstSearchResult()
    {
        String actualResult = FirstSearchResult.getText();
        return actualResult;


    }

    public GoogleHomePageFactory()
    {
        this.driver =  driver= BrowserConfiguration.driver;
        PageFactory.initElements(driver,this);

    }







}
