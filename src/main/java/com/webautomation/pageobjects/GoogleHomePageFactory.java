package com.webautomation.pageobjects;

import com.webautomation.config.BrowserConfiguration;
import com.webautomation.config.BrowserWaits;
import com.webautomation.exceptions.ElementNotFoundException;
import com.webautomation.utils.ExcelDriven;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Instantiate the WebElements
 */

public class GoogleHomePageFactory extends BrowserWaits {
     private WebDriver driver;
    private static Logger log= LogManager.getLogger(GoogleHomePageFactory.class);
    @FindBy(xpath="//textarea[@aria-label=\"Search\"]")
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
    public void clearSearchField(){
        googleSearchBar.clear();
        log.info("clear the search bar");
    }

    public String verifyTheFirstSearchResult()
    {
        if(firstSearchResult == null){
            throw new ElementNotFoundException();
        }
        waitForElementToAppear(searchRslt);
        String actualResult = firstSearchResult.getText();
        log.info("Get the actual search result");
        return actualResult;
    }

    public GoogleHomePageFactory()
    {
        this.driver = BrowserConfiguration.getDriver();
        PageFactory.initElements(driver,this);
        log.info("Initialize the Google page elements ");

    }


    public void GoogleSearchExcelData(String file) throws IOException {
        ExcelDriven excel = new ExcelDriven(file);
        int n=excel.getRowCount();

        for(int i=1;i<n;i++)
        {
            String s = excel.getCelldata(file,i,0);
            enterTheSearchTerm(s);
            waitForPageToBeLoad(7);
            String expectedText = excel.getCelldata(file,i,1);
            WebElement result= driver.findElement(By.xpath("//*[contains(text(),\""+ expectedText +"\")]"));
            String data = result.getText();
            log.info(data+"Actual result");
            excel.setCelldata(file,data,i,2);
            clearSearchField();

        }


    }

    public void compareSearchResult(String file) throws IOException {
        ExcelDriven excel = new ExcelDriven(file);
        ArrayList<String> expected = new ArrayList<String>();
        expected = excel.getColumnData(file,1);
        ArrayList<String> actual = new ArrayList<String>();
        actual = excel.getColumnData(file,2);
        log.info("Compare the expected search result with actual");
        assert expected.equals(actual);

        excel.cleanColumnData(file,2);

    }


}
