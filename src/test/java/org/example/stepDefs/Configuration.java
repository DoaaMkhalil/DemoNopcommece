package org.example.stepDefs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    public void set(String Key,String Value) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("data.properties");
        prop.load(fis);
        prop.setProperty(Key, Value);
        fis.close();
        FileOutputStream fOs = new FileOutputStream("data.properties");
        prop.store(fOs,"");
    }
    public String get(String Key ) throws IOException {
        String Value;
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("data.properties");
        prop.load(fis);
        Value =prop.getProperty(Key);
        fis.close();
        return Value ;
    }
}
