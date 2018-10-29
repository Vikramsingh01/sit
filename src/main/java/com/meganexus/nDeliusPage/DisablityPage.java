package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class DisablityPage extends Utils{
	
	String sheetName = "Disability";
	ExcelUtils excell = new ExcelUtils();
	
	public void addDisabilityNPS(String sitNo) throws InterruptedException{
		
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		driver.findElement(By.id("linkNavigation3Disability")).click();
		waitForElementVisible(By.xpath("//h1[text()='Disabilities and Adjustments']"));
		driver.findElement(By.xpath("//input[@value='Add Disability']")).click();
		waitForElementVisible(By.xpath("//h1[text()='Add Disability']"));
		
	selectAnElementFromText("addDisabilityForm:DisabilityType", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Disability")).trim());
	Thread.sleep(3000);
	
	WebElement StartDate= driver.findElement(By.xpath("//input[@id='addDisabilityForm:StartDate']"));
	StartDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Start Date")).trim());
	Thread.sleep(3000);
	
	WebElement EndDate= driver.findElement(By.xpath("//input[@id='addDisabilityForm:EndDate']"));
	EndDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "End Date")).trim());
	Thread.sleep(3000);
	
	WebElement Notes= driver.findElement(By.xpath("//textarea[@id='addDisabilityForm:Notes']"));
	Notes.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
	Thread.sleep(3000);
	
	WebElement Save= driver.findElement(By.xpath("//input[@value='Save']"));
	Save.click();
	
	
	}
	
	
	

}
