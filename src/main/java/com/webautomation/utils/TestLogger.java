package com.webautomation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {
    public static Logger log;

    public static Logger logger(Class classname){
        log = LogManager.getLogger(classname);
        return (log != null ? log : null);
    }

}
