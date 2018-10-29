package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;

public class LicenceConditionPage extends ThroughCarePage {
	
	ExcelUtils excell = new ExcelUtils();
	String sheetName = "Licence Condition";
	
	public void addLicenceCondition(String sitNo) throws Exception {

		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		Thread.sleep(1000);
		selectAnElementFromText("LicenceMainCategory",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Licence Condition")).trim());
		Thread.sleep(800);
		selectAnElementFromText("LicenceSubCategory",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Licence Condition Subtype")).trim());
		Thread.sleep(200);
	    
		driver.findElement(By.id("AddSentenceComponentsForm:licenceCondition:LicenceReleaseDate")).clear();
	    driver.findElement(By.id("AddSentenceComponentsForm:licenceCondition:LicenceReleaseDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Imposed (Release Date) Date")).trim());
	    Thread.sleep(200);
	    selectAnElementFromText("AreaLC",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim());
	    Thread.sleep(200);
	    
	    driver.findElement(By.id("AddSentenceComponentsForm:licenceCondition:Note")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Note")).trim());
	    
	    scrollToElement(driver.findElement(By.id("AddSentenceComponentsForm:licenceCondition:j_id_id122pc8")));
	    driver.findElement(By.id("AddSentenceComponentsForm:licenceCondition:j_id_id122pc8")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("AddSentenceComponentsForm:licenceCondition:j_id_id175pc8")).click();
		Thread.sleep(2000);
		//waitForElementClickable(driver.findElement(By.xpath("//input[contains(text(),'Close')]")));
	}
	
	public void viewLicenceConditionNPS(String sitNo) throws Exception {
		
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		driver.findElement(By.xpath("//a[@id='linkNavigation2EventList']")).click();
		
		waitForElementVisible(By.xpath("//h1[contains(text(),'Events')]"));
		driver.findElement(By.xpath("//a[contains(.,'view')]")).click();
		
		waitForElementVisible(By.xpath("//h1[contains(text(),'Event Details')]"));
		scrollToElement(driver.findElement(By.xpath("//a[@id='linkNavigation3SentenceComponent']")));
		
		driver.findElement(By.xpath("//a[@id='linkNavigation3SentenceComponent']")).click();
		waitForElementVisible(By.xpath("//h1[contains(text(),'Licence Conditions')]"));
		
		waitForElementVisible(By.xpath("//a[contains(.,'view')]"));
		driver.findElement(By.xpath("//a[contains(.,'view')]")).click();
		
		WebElement LicConMainType= driver.findElement(By.xpath("//span[@id='j_id_id11:licenceCondition:Component']"));
		 String licConMainType= LicConMainType.getText().trim();
		 Assert.assertEquals(licConMainType, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "Licence Condition")).trim());
		 
		 WebElement LicConSubType= driver.findElement(By.xpath("//span[@id='j_id_id11:licenceCondition:SubComponent']"));
		 String licConSubType= LicConSubType.getText().trim();
		 Assert.assertEquals(licConSubType, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "Licence Condition Subtype")).trim());
		 
		 
		 WebElement ImpReleaseDate= driver.findElement(By.xpath("//span[@id='j_id_id11:licenceCondition:SentenceDate']"));
		 String impReleaseDate= ImpReleaseDate.getText().trim();
		 Assert.assertEquals(impReleaseDate, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "Imposed (Release Date) Date")).trim());
		 
		 
		 WebElement ExpStartDate= driver.findElement(By.xpath("//span[@id='j_id_id11:licenceCondition:SentenceDate']"));
		 String expStartDate= ExpStartDate.getText().trim();
		 Assert.assertEquals(expStartDate, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "Expected Start Date")).trim());
		 
		 WebElement ActStartDate= driver.findElement(By.xpath("//span[@id='j_id_id11:licenceCondition:ExpectedStartDate']"));
		 String actStartDate= ActStartDate.getText().trim();
		 Assert.assertEquals(actStartDate, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "Actual Start Date")).trim());
		
		 
		 WebElement Notes= driver.findElement(By.xpath("//textarea[@id='j_id_id11:licenceCondition:Note']"));
		 String notes= Notes.getText().trim();
		 Assert.assertEquals(notes, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "Note")).trim());
	}
}
