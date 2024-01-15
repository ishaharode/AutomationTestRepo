package com.WebAutomation.Utils;

import com.WebAutomation.Config.BrowserConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {
    public static Logger log;

    public static Logger logger(String classname){
        log= LogManager.getLogger("classname"+".class");
        return log;
    }

}
