package com.prestashop.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;
    static {
      String path= "configuration.properties";
        try {
            FileInputStream fileInputStream= new FileInputStream(path);
            properties= new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String property){
     return properties.getProperty(property);
    }
}
