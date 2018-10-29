package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class ReleasePage extends Utils {
	ExcelUtils excell = new ExcelUtils();
	String sheetName = "Force Release";
	
	
public void forceRelease(String sitNo) throws Exception {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		
		//view Event details
		waitForElementVisible(By.xpath("//h1[contains(text(),'Event Details')]"));
		//Click on through-care button
		scrollToClickElement(driver.findElement(By.xpath("//input[@value='Throughcare']")));
		waitForElementVisible(By.xpath("//h1[contains(text(),'Throughcare Details')]"));
		Thread.sleep(500);
		
		scrollToClickElement(driver.findElement(By.id("j_id_id11:j_id_id192")));
		Thread.sleep(2000);
		
		driver.findElement(By.id("ReleaseDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Actual Release Date")).trim());
	    Thread.sleep(200);
	    selectAnElementFromText("forceRelease:ReleaseType",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Release Type")).trim());
	    Thread.sleep(1000);
	    selectAnElementFromText("forceRelease:Institution",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Location")).trim() );
	    Thread.sleep(500);
	    
	    driver.findElement(By.id("forceRelease:j_id_id74")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("forceRelease:j_id_id75")).click();
	    Thread.sleep(2000);
	
	}
}
