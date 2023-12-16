package com.jarvis.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	
	public static String getBrowserName() {
		String base = System.getProperty("user.dir");
		String filepath = base+ "/src/test/resources/Config.properties";
		Properties prop = new Properties();
		String value = null;
		try {
			FileInputStream fis = new FileInputStream(filepath);
			try {
				prop.load(fis);
				value=prop.getProperty("browser_name");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public static String getAppURL() {
		String base = System.getProperty("user.dir");
		String filepath = base+"/src/test/resources/Config.properties";
		FileInputStream fis = null;
		String value = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
			value =prop.getProperty("url_name");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}
}

