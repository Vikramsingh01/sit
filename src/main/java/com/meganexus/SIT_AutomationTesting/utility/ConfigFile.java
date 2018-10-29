package com.meganexus.SIT_AutomationTesting.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
	//To read property value with key name - Tapan Sahoo
	public static String readProperty(String fileName, String keyName) {
		FileInputStream fileInput = null;
		Properties prop = null;
		String value = null;
		try {
			Log.info("Reading property file");
			File file = new File(System.getProperty("user.dir")+ "/src/test/resources" + fileName);
			//System.out.println(file);
			fileInput = new FileInputStream(file);
			prop = new Properties();
			prop.load(fileInput);
			value = prop.getProperty(keyName);

		} catch (Exception e) {
			Log.error("Unable to read property file "+e.getMessage());
		}

		return value;
	}

	/*public static void main(String args[]) {
		String path = readProperty("/config.propeties", "nDeliusURL");
		System.out.println(path);
	}*/
}
