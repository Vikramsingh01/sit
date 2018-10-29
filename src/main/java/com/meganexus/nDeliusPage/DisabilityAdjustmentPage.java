package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;

public class DisabilityAdjustmentPage extends DisablityPage{
	
	String sheetName = "Disability Adjustment";
	ExcelUtils excell = new ExcelUtils();
	
	public void addDisabilityAdjustment(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		
		waitForElementVisible(By.linkText("Add Adjustment"));
		driver.findElement(By.linkText("Add Adjustment")).click();
		Thread.sleep(1000);
		selectAnElementFromText("addProvisionForm:ProvisionType",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Adjustment")).trim());
		
		waitForElementVisible(By.id("addProvisionForm:StartDate"));
		WebElement StartDate= driver.findElement(By.xpath("//input[@id='addProvisionForm:StartDate']"));
		StartDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Start Date")).trim());
		
		waitForElementVisible(By.id("addProvisionForm:EndDate"));
		WebElement EndDate= driver.findElement(By.xpath("//input[@id='addProvisionForm:EndDate']"));
		EndDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "End Date")).trim());
		
		waitForElementVisible(By.id("addProvisionForm:Notes"));
		WebElement Notes= driver.findElement(By.xpath("//textarea[@id='addProvisionForm:Notes']"));
		Notes.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		
		driver.findElement(By.id("addProvisionForm:j_id_id70")).click();
		Thread.sleep(1000);
		
		waitForElementVisible(By.xpath("//h1[text()='Disabilities and Adjustments']"));
			
		
		
	}

}
