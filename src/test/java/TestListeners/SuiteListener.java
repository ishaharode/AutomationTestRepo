package TestListeners;

import com.webautomation.config.BrowserConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class SuiteListener extends BrowserConfiguration  implements ITestListener, IAnnotationTransformer {

    private static Logger log= LogManager.getLogger(SuiteListener.class);

    @Override
    public void onFinish(ITestContext context) {
        quitBrowser();
        log.info("Driver Quit");
    }

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
