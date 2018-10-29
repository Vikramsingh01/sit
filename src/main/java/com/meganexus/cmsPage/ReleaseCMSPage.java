package com.meganexus.cmsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class ReleaseCMSPage extends Utils{
	
	String sheetName = "Force Release";
	ExcelUtils excell = new ExcelUtils();
	
	 public void addRelease(String sitNo) throws InterruptedException {

	int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
	
	Thread.sleep(15000);
	//waitForElementPresent(By.xpath("//button[contains(text(),'Throughcare')]"));
	driver.findElement(By.xpath("//button[text()='Through The Gate']")).click();
	
	waitForElementPresent(By.xpath("//button[contains(text(),'Release')]"));
	driver.findElement(By.xpath("//button[contains(text(),'Release')]")).click();
	
	waitForElementPresent(By.xpath("//button[@id='release_addButton']"));
	driver.findElement(By.xpath("//button[@id='release_addButton']")).click();
	waitForElementPresent(By.xpath("//h2[contains(text(),'Add Release')]"));
	
	WebElement ReleaseDate= driver.findElement(By.xpath("//input[@id='releaseDate']"));
	ReleaseDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Actual Release Date")).trim());
	Thread.sleep(10000);
	/*WebElement rType= driver.findElement(By.id("releaseTypeId"));
	rType.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Release Type")).trim());
	*/
	waitForElementPresent(By.id("releaseTypeId"));
	//Thread.sleep(6000);
	selectAnElementFromText("releaseTypeId", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Release Type")).trim());
	
	waitForElementPresent(By.xpath("//button[@id='saveButton']"));
	
	driver.findElement(By.xpath("//button[@id='saveButton']")).click();
	Thread.sleep(6000);
	/*String confirmRelease = driver.getWindowHandle();
	driver.switchTo().window("confirmRelease");*/
	driver.findElement(By.xpath("//button[contains(.,'Ok')]")).click();
	Thread.sleep(6000);
	
	
	
	
	
	
	
	
}
	 
}
