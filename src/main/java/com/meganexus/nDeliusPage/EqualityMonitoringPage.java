package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class EqualityMonitoringPage extends Utils {
	
	ExcelUtils excell = new ExcelUtils();
	String sheetName = "Equality Monitoring";
	
	public void updateEqualityMonitoring(String sitNo) throws InterruptedException{
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		
		waitForElementVisible(By.id("linkNavigation3Diversity"));
		driver.findElement(By.id("linkNavigation3Diversity")).click();
		
		//waitForElementVisible(By.xpath("//h1[contains(text(),'Equality Monitoring']"));
		waitForElementVisible(By.id("diversityForm:updateDiversity"));
		scrollToClickElement(driver.findElement(By.id("diversityForm:updateDiversity")));
		Thread.sleep(1000); 
		
		//waitForElementVisible(By.xpath("//h1[contains(text(),'Update Equality Monitoring']"));
		
		selectAnElementFromText("diversityForm:sexualOrientation",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Sexual Orientation")).trim());
		Thread.sleep(200);
		
		selectAnElementFromText("diversityForm:transgenderProcess",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Gender Reassignment")).trim());
		Thread.sleep(1000);
		
		selectAnElementFromText("diversityForm:consentToDisclose",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Consent To Disclose")).trim());
		Thread.sleep(2000);
		
		selectAnElementFromText("diversityForm:remMainCategory",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Ethnicity")).trim());
		Thread.sleep(200);
		
		selectAnElementFromText("diversityForm:nationality",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Nationality")).trim());
		Thread.sleep(200);
		
		selectAnElementFromText("diversityForm:secondNationality",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Second Nationality")).trim());
		Thread.sleep(200);
		
		selectAnElementFromText("diversityForm:language",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Language")).trim());
		Thread.sleep(200);
		
		selectAnElementFromText("diversityForm:interpreterRequired",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Interpreter Required")).trim());
		Thread.sleep(200);
		
		
		selectAnElementFromText("diversityForm:immigrationStatus",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Immigration Status")).trim());
		Thread.sleep(200);
		
		driver.findElement(By.id("diversityForm:immigrationNumber")).clear();
		 driver.findElement(By.id("diversityForm:immigrationNumber")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Immigration Number")).trim());
		    Thread.sleep(200);
		
	     selectAnElementFromText("diversityForm:religion",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Religion Or Belief")).trim());
			Thread.sleep(500);
			
			waitForElementVisible(By.id("diversityForm:newNotes"));
			scrollToElement(driver.findElement(By.id("diversityForm:newNotes")));
		 driver.findElement(By.id("diversityForm:newNotes")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Equality Monitoring Notes")).trim());
			    Thread.sleep(200);
		
		
			scrollToClickElement(driver.findElement(By.id("diversityForm:saveButton")));
			Thread.sleep(1000);
			
			waitForElementVisible(By.id("diversityForm:confirmButton"));
			scrollToClickElement(driver.findElement(By.id("diversityForm:confirmButton")));
			Thread.sleep(1000);
		
			System.out.println("Equality Monitoring : Done");
	}

}
