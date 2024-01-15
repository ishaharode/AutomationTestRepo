package StepDefinitions;

import BaseTest.BaseTest;
import com.WebAutomation.Config.BrowserConfiguration;
import com.WebAutomation.Config.BrowserWaits;
import com.WebAutomation.PageMethods.HomePage;
import com.WebAutomation.PageObjects.BingHomePagefactory;
import com.WebAutomation.PageObjects.GoogleHomePageFactory;
import com.WebAutomation.Utils.Constants;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.cms.bc.BcKEKRecipientInfoGenerator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.*;


public class searchStepDef extends BrowserConfiguration {
    HomePage homePage ;
    GoogleHomePageFactory homePageFactory ;
    BingHomePagefactory bingPageFactory;
    BrowserWaits waits;
    BaseTest basetest;
    public static Logger log;
    String searchEngine="";

   public searchStepDef()
   {
       log = LogManager.getLogger(searchStepDef.class);
       log.info("Launch browser");
       homePage = new HomePage();
       waits= new BrowserWaits();
       homePageFactory = new GoogleHomePageFactory();
       bingPageFactory= new BingHomePagefactory();

    }

    @Given("visit the {string}")
    public void visit_the(String searchEngine) {
        this.searchEngine=searchEngine;

        switch (searchEngine) {
            case "Google":
                homePage.UrlLaunch(Constants.googleurl);
                break;
            case "Bing":
                homePage.UrlLaunch(Constants.bingUrl);
                break;
            case "Yahoo":
                homePage.UrlLaunch(Constants.yahooUrl);
                break;

        }

        log.info("Url is launched");
    }

    @When("search for {string}")
    public void search_for(String string) {
       if(searchEngine.equalsIgnoreCase("Google")) {
           homePageFactory.enterTheSearchTerm(string);
           waits.waitForPageToBeLoad(20);
           log.info("Search initiated");
       }
        if(searchEngine.equalsIgnoreCase("Bing")) {
            bingPageFactory.enterTheSearchTerm(string);
            waits.waitForPageToBeLoad(20);
            log.info("Search initiated");
        }

    }


    @Then("verify the first search result with {string}")
    public void verify_the_first_search_result_with(String expectedResult) {
        if(searchEngine.equalsIgnoreCase("Google")) {
            String actualResult = homePageFactory.verifyTheFirstSearchResult();
            Assert.assertEquals(actualResult, expectedResult, "Mismatch occurs");
            log.info("Assertion pass");
        }
        if(searchEngine.equalsIgnoreCase("Bing")) {
            String actualResult = bingPageFactory.verifyTheFirstSearchResult();
            Assert.assertEquals(actualResult, expectedResult, "Mismatch occurs");
            log.info("Assertion pass");
        }

    }



}
