package com.filesloader.tm;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.filesloader.tm.contracts.Constants;

public class FileLoaderDaemonProp {

    private static FileLoaderDaemonProp _instance;

    public static FileLoaderDaemonProp getInstance(){
        if(_instance == null){
            _instance = new FileLoaderDaemonProp();
        }

        return _instance;
    }


    public Map<String, String> getPropValues(){

        Map<String, String> props = new HashMap<String, String>();

        try (InputStream input = FileLoaderDaemonProp.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();
    
            if (input == null) {
                System.out.println("Unable to find config.properties");
                return null;
            }
    
            //load a properties file from class path, inside static method
            prop.load(input);
    
            //get the property value and print it out
            props.put(Constants.FILE_PATH, prop.getProperty(Constants.FILE_PATH));

            return props;
    
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}