package StepDefinitions;

import BaseTest.BaseTest;
import com.WebAutomation.Config.BrowserConfiguration;
import com.WebAutomation.Config.BrowserWaits;
import com.WebAutomation.PageMethods.HomePage;
import com.WebAutomation.PageObjects.GoogleHomePageFactory;
import com.WebAutomation.PageObjects.YahooHomePagefactory;
import com.WebAutomation.Utils.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class searchStepDef extends BrowserConfiguration {
    HomePage homePage ;
    GoogleHomePageFactory homePageFactory ;
    YahooHomePagefactory yahooHomePagefactory;
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
       yahooHomePagefactory= new YahooHomePagefactory();

    }

    @Given("visit the {string}")
    public void visit_the(String searchEngine) {
        this.searchEngine=searchEngine;

        switch (searchEngine) {
            case "Google":
                homePage.UrlLaunch(Constants.googleurl);
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
