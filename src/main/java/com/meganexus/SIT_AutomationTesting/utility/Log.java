package com.meganexus.SIT_AutomationTesting.utility;

import org.apache.log4j.Logger;

public class Log {
	private static Logger log = Logger.getLogger(Log.class.getName());

	public static void startTestCase(String sTestcaseName) {
		log.info(
				"*****************************************************************************************************************");
		log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$          " + sTestcaseName
				+ "            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		log.info(
				"*****************************************************************************************************************");
	}

	public static void endTestCase(String sTestCaseName) {
		log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX      " + "-E---N---D-"
				+ "             XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

	public static void info(String message) {
		log.info(message);
	}

	public static void warn(String message) {
		log.warn(message);
	}

	public static void error(String message) {
		log.error(message);
	}
	public static void fatal(String message) {
		log.fatal(message);
	}
	public static void debug(String message) {
		log.debug(message);
	}
}
