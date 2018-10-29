package com.meganexus.cmsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class RecallCMSPage extends Utils {
	
	String sheetName = "Recall";
	ExcelUtils excell = new ExcelUtils();

	public void addRecall(String sitNo) throws InterruptedException {

	int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);

	Thread.sleep(15000);
	//waitForElementPresent(By.xpath("//button[contains(text(),'Throughcare')]"));
	driver.findElement(By.xpath("//button[text()='Through The Gate']")).click();
	Thread.sleep(5000);
	//waitForElementPresent(By.xpath("//button[contains(text(),'Recall')]"));
	driver.findElement(By.xpath("//button[contains(text(),'Recall')]")).click();
	Thread.sleep(5000);
	//waitForElementPresent(By.xpath("//button[@id='recall_addButton']"));
	driver.findElement(By.xpath("//button[@id='recall_addButton']")).click();
	//waitForElementPresent(By.xpath("//h2[contains(text(),'Add Recall')]"));
	Thread.sleep(5000);
	WebElement ReleaseDate= driver.findElement(By.xpath("//input[@id='recallDate']"));
	ReleaseDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Recall Date")).trim());
	//waitForElementPresent(By.xpath("//select[@id='recallReasonId']"));
	
	selectAnElementFromText("recallReasonId", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Recall Reason")).trim());
	//waitForElementPresent(By.xpath("//select[@id='recallLocationId']"));
	
	selectAnElementFromText("recallLocationId", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Location")).trim());
	//waitForElementPresent(By.xpath("//textarea[@id='note']"));
	
	WebElement Notes= driver.findElement(By.xpath("//textarea[@id='note']"));
	Notes.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")));
	
	waitForElementPresent(By.xpath("//button[@id='saveButton']"));
	WebElement Submit= driver.findElement(By.xpath("//button[@id='saveButton']"));
	Submit.click();
	driver.findElement(By.xpath("//button[contains(.,'Ok')]")).click();
	selectAnElementFromValue("recall_itemsPerPage", "10");
	selectAnElementFromValue("recall_itemsPerPage", "50");
	Thread.sleep(3000);
	
	}
	
	public void deleteRecall(String sitNo) throws InterruptedException {
		 /* waitForElementPresent(By.xpath("//button[@id='recall_addButton']"));
		  driver.findElement(By.xpath("//button[@id='recall_addButton']")).click();*/
		 
		  driver.findElement(By.id("recall_delete0")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[contains(text(), 'Ok')]")).click();
		  Thread.sleep(1000);
		  
		 }
}
