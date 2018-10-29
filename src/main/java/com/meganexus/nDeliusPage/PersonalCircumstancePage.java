package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class PersonalCircumstancePage extends Utils{
	ExcelUtils excell = new ExcelUtils();
	String sheetName = "Personal Circumstance";
	
	public void addPersonalCircumstance(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		waitForElementVisible(By.id("linkNavigation3Circumstances"));
		driver.findElement(By.id("linkNavigation3Circumstances")).click();
		
		waitForElementVisible(By.id("j_id_id11:addPersonalCircumstance"));
		driver.findElement(By.id("j_id_id11:addPersonalCircumstance")).click();
		
		waitForElementVisible(By.id("CircumstanceType"));
		
		
		waitForElementVisible(By.id("CircumstanceType"));
		selectAnElementFromText("CircumstanceType",
		excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Personal Circumstance Type")).trim());
		
		Thread.sleep(500);

		waitForElementPresent(By.id("CircumstanceSubType"));
		selectAnElementFromText("CircumstanceSubType",
		excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Personal Circumstance Subtype")).trim());
		
		waitForElementVisible(By.id("StartDate"));
		driver.findElement(By.id("StartDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Start Date")).trim());
		
				
		waitForElementVisible(By.id("EndDate"));
		driver.findElement(By.id("EndDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "End Date")).trim());
	
		
		waitForElementVisible(By.id("Evidenced"));
		selectAnElementFromText("Evidenced",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Evidenced")).trim());
		
		
		waitForElementVisible(By.id("addPersonalCircumstanceForm:Notes"));
		driver.findElement(By.id("addPersonalCircumstanceForm:Notes")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
				
		waitForElementVisible(By.xpath("//input[@value='Save']"));
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		waitForElementVisible(By.xpath("//h1[contains(text(),'Personal Circumstances')]"));
		
		System.out.println("Personal Circumstance : Done");
		
				
		
	}

}
