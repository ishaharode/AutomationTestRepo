package testlisteners;

import com.webautomation.config.BrowserConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class SuiteListener extends BrowserConfiguration  implements ITestListener, IAnnotationTransformer {

    private static Logger log= LogManager.getLogger(SuiteListener.class);


    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
