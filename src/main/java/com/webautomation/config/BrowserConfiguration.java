    package com.webautomation.config;

    import com.webautomation.exceptions.DriverNotFoundException;
    import com.webautomation.utils.ConfigProperties;
    import com.webautomation.utils.Constants;
    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;

    import java.io.IOException;
    import java.time.Duration;

    /***
     *
     */
    public class BrowserConfiguration {


        private static WebDriver driver;

        private static Boolean isHeadless;
        private static Logger log=LogManager.getLogger(BrowserConfiguration.class);

        public static void initializeDriver(String browser) throws IOException {
            ConfigProperties.initializePropertyFile();
            isHeadless= ConfigProperties.getHeadlessMode();

            if(browser.equalsIgnoreCase(Constants.CHROME_BROWSER))
            {
                if(isHeadless)
                {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                }
                else
                {
                    driver = WebDriverManager.chromedriver().create();
                }
                log.info("Initialize Chrome Driver");
            }
            else if(browser.equalsIgnoreCase(Constants.FIREFOX_BROWSER))
            {
                driver = WebDriverManager.firefoxdriver().create();
                log.info("Initialize Firefox Driver");
            }
            else if(browser.equalsIgnoreCase(Constants.EDGE_BROWSER))
            {
                driver = WebDriverManager.edgedriver().create();
                log.info("Initialize MS Edge Driver");
            }


            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            log.info("Screen maximized and cookies deleted");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        }

        public static WebDriver getDriver()
        {
            if(driver ==null){
                throw new DriverNotFoundException();
            }
            return driver;
        }


        public void quitBrowser()
        {
            driver.quit();
            log.info("Quit the browser");
        }

    }
