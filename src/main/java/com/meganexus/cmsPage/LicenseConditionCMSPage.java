package com.meganexus.cmsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class LicenseConditionCMSPage extends Utils {
	
	String sheetName = "Licence Condition";
	ExcelUtils excell = new ExcelUtils();
	
	public void addLicenseCondition(String sitNo) throws InterruptedException {
		
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		//waitForElementPresent(By.xpath("//h2[contains(text(),'Add Licence Condition')]"));
		Thread.sleep(10000);
		waitForElementPresent(By.id("licCondTypeMainCategoryId"));
		selectAnElementFromText("licCondTypeMainCategoryId", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Licence Condition")).trim());
		
		waitForElementPresent(By.xpath("//select[@id='licCondTypeSubCategoryId']"));
		selectAnElementFromText("licCondTypeSubCategoryId", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Licence Condition Subtype")).trim());
		
		waitForElementPresent(By.xpath("//input[@id='sentenceDate']"));
		WebElement SentenceDate= driver.findElement(By.xpath("//input[@id='sentenceDate']"));
		SentenceDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Imposed (Release Date) Date")).trim());
		
		waitForElementPresent(By.xpath("//input[@id='expectedStartDate']"));
		WebElement ExpectedDate= driver.findElement(By.xpath("//input[@id='expectedStartDate']"));
		ExpectedDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Expected Start Date")).trim());
		
		waitForElementPresent(By.xpath("//input[@id='actualStartDate']"));
		WebElement ActualDate= driver.findElement(By.xpath("//input[@id='actualStartDate']"));
		ActualDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Actual Start Date")).trim());
		
		waitForElementPresent(By.xpath("//textarea[@id='note']"));
		WebElement Notes= driver.findElement(By.xpath("//textarea[@id='note']"));
		Notes.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Note")).trim());
		Thread.sleep(2000);
		scrollToElement(driver.findElement(By.xpath("//button[text()='Submit']")));
		//waitForElementPresent(By.id("saveButton"));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//Submit.click();
		
		
	}
	}


