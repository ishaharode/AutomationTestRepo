package com.webautomation.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    public static Properties prop;
     private static String filepath = System.getProperty("user.dir")+"\\src\\main\\resources\\application.properties";

    public static void  initializePropertyFile() throws FileNotFoundException, IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream(filepath);
        prop.load(file);
        file.close();
    }

    public static Boolean getHeadlessMode()
    {
        String headless=ConfigProperties.prop.getProperty("browser.headlessMode");
        if(!StringUtils.isEmpty(headless)){
            return Boolean.parseBoolean(headless);
        }
        return null;

    }



}
