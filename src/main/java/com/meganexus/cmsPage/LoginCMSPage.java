package com.meganexus.cmsPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ConfigFile;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class LoginCMSPage extends Utils {

	public void loginToCMSApps() {
		cmsApps();
		try {
			Log.info("Login to cms application");
			waitForElementVisible(By.id("email"));
			driver.findElement(By.id("email")).sendKeys(ConfigFile.readProperty("/config.propeties", "cmsUserName"));
			Log.info("CMS User Name "+ConfigFile.readProperty("/config.propeties", "cmsUserName"));
			driver.findElement(By.id("pwd"))
					.sendKeys(ConfigFile.readProperty("/config.propeties", "cmsSystemAdminPassword"));
			Log.info("Password"+ConfigFile.readProperty("/config.propeties", "cmsSystemAdminPassword"));
			driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
			pageLoad();
		}

		catch (Exception e) {
			waitForImplicitWait();
			Log.error("Taking more time to load cms application "+e.getMessage());
			
		}
	}
	
	public void rbacs_login(String username, String password) {
		try {
			Log.info("Login to cms application");
			waitForElementVisible(By.id("email"));
			driver.findElement(By.id("email")).sendKeys(username);
			driver.findElement(By.id("pwd")).sendKeys(password);
			driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		} catch (Exception e) {
			waitForImplicitWait();
			Log.error("Taking more time to load cms application "+e.getMessage());
			System.out.println("Unable to login ... please verify rbacsURL and credentials.");
			e.printStackTrace();
		}	
	}
	
	public void rbacs_logout(){
		try {
			Log.info("Logging out ...");
			waitForElementVisible(By.id("logout"));
			driver.findElement(By.id("logout")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			waitForImplicitWait();
			Log.error("Problems loggin out "+e.getMessage());
			e.printStackTrace();
		}	
	}
}
