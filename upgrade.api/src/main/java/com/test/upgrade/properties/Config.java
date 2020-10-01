package com.test.upgrade.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import org.testng.annotations.BeforeMethod;


import io.restassured.RestAssured;

public enum Config {

	INSTANCE;
	
	Properties prop = new Properties();
	protected static Logger log = Logger.getLogger(Config.class.getName());
	
	@BeforeMethod
	public void init() throws FileNotFoundException, IOException {
        try  {

        	String configFile = new File(".").getCanonicalPath() + File.separator + "config/qa/test.properties";
        	log.info("properties loading.. " + configFile);
			prop.load(new FileInputStream(configFile));
    		RestAssured.baseURI = prop.getProperty("hostname");

        } catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Problem loading configurations : " + this.getClass().getName());
		}
	}	
}
