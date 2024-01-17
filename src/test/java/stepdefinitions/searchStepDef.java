package stepdefinitions;

import basetest.BaseTest;
import com.webautomation.config.BrowserConfiguration;
import com.webautomation.config.BrowserWaits;
import com.webautomation.pagemethods.HomePage;
import com.webautomation.pageobjects.GoogleHomePageFactory;
import com.webautomation.pageobjects.YahooHomePagefactory;
import com.webautomation.utils.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;


public class searchStepDef extends BrowserConfiguration {
    HomePage homePage ;
    GoogleHomePageFactory homePageFactory ;
    YahooHomePagefactory yahooHomePagefactory;
    BrowserWaits waits;
    BaseTest basetest;
    public static Logger log;
    String searchEngine="";

   public searchStepDef() {
       log = LogManager.getLogger(searchStepDef.class);
       log.info("Launch browser");
       homePage = new HomePage();
       waits= new BrowserWaits();
       homePageFactory = new GoogleHomePageFactory();
       yahooHomePagefactory= new YahooHomePagefactory();

    }

    @Given("visit the {string}")
    public void visit_the(String searchEngine) {
        this.searchEngine=searchEngine;

        switch (searchEngine) {
            case "Google":
                homePage.UrlLaunch(Constants.GOOGLE_URL);
                break;
            case "Yahoo":
                homePage.UrlLaunch(Constants.YAHOO_URL);
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
        if(searchEngine.equalsIgnoreCase("Yahoo")) {
            yahooHomePagefactory.enterTheSearchTerm(string);
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
            String actualResult = yahooHomePagefactory.verifyTheFirstSearchResult();
            Assert.assertEquals(actualResult, expectedResult, "Mismatch occurs");
            log.info("Assertion pass");
        }

    }


}
