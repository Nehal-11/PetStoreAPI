package com.atmecs.qa.utils;


import constants.FilePathConstants;
import org.testng.log4testng.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public class FileReader {
    public Logger logger = Logger.getLogger(FileReader.class);

    public String getAttribute(String attributeName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(FilePathConstants.configPath));
            return properties.getProperty(attributeName);
        } catch (Exception exception) {
            logger.info("Exception occured: " + exception);
        }
        return null;
    }

}
