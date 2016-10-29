package com.kodeir.enzim2016.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class PropertyHandler {

    private static PropertyHandler instance = null;

    private Properties properties = null;

    private String path = "./config/database.properties";

    public static PropertyHandler getInstance() {
        if (instance == null){
            instance = new PropertyHandler();
        }
        return instance;
    }

    private PropertyHandler() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String propKey) {
        return properties.getProperty(propKey);
    }
}
