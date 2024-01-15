package testlisteners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static Logger log= LogManager.getLogger(RetryAnalyzer.class);
    int count=0;
    int retryCount=0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        while(count<retryCount)
        {
            count++;
            log.info("Retry Failed scenarios");
            return true;
        }
        return false;
    }
}
