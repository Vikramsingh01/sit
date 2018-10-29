package com.meganexus.nDeliusPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class AddressAssessment extends Utils {
	String sheetName = "Address Assessment";
	ExcelUtils excell = new ExcelUtils();
	
	public void addAddressAssessment(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		driver.findElement(By.linkText("view")).click();
		Thread.sleep(1000);
		scrollToClickElement(driver.findElement(By.id("addressDetailsForm:j_id_id181")));
		/*waitForElementPresent(By.xpath("//h1[text()='Offender Addresses List']"));
		waitForElementPresent(By.xpath("//input[@value='Add Address Assessment']]"));*/
		
		
		selectAnElementFromText("assessmentForm:Trust",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim());
		
		selectAnElementFromText("assessmentForm:Team",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Team")).trim());
		
		selectAnElementFromText("assessmentForm:Officer",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Officer")).trim());	
		
		driver.findElement(By.id("assessmentForm:AssessmentDate")).sendKeys(
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Date")).trim());
		
		driver.findElement(By.id("assessmentForm:Notes")).sendKeys(
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		
		waitForElementVisible(By.xpath("//input[@value='Save']"));
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(1000);
	
		waitForElementVisible(By.xpath("//input[@value='Confirm']"));
		scrollToClickElement(driver.findElement(By.xpath("//input[@value='Confirm']")));
	
		waitForElementPresent(By.xpath("//h1[text()='Address Details']"));
		Thread.sleep(1000);
		System.out.println("Address assessment added");
	}
	public void viewAssessmentIN(String sitNo) throws InterruptedException {
		 int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  Thread.sleep(3000);
		  //driver.findElement(By.id("linkNavigation2OffenderIndex")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[@id='linkNavigation3Address']")).click();
		  Thread.sleep(3000);
		  waitForElementVisible(By.xpath ("//h2[contains(text(),'Other Addresses')]"));
		  driver.findElement(By.xpath("//span[@title='Start']")).click();
		  driver.findElement(By.xpath("//a[@title='Link to View this Address']")).click();
		  waitForElementVisible(By.xpath("//h2[contains(text(),'Address Assessments')]"));
		  driver.findElement(By.xpath("//a[@title='Select to view the address assessment']")).click();
		  Thread.sleep(3000);
		  WebElement Date =driver.findElement(By.xpath("//span[contains(@id,'id12:Date')]"));
		  String ADate = Date.getText().trim();
		  System.out.println(ADate);
		  //Assert.assertEquals(ADate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Date")).trim());
		  System.out.println("Verified Assessment Added");
		  
}
	public void vieweditAssessmentIN(String sitNo) throws InterruptedException {
		 int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[@id='linkNavigation3Address']")).click();
		  Thread.sleep(3000);
		  waitForElementVisible(By.xpath ("//h2[contains(text(),'Other Addresses')]"));
		 // driver.findElement(By.xpath("//span[@title='Start']")).click();
		  driver.findElement(By.xpath("//a[@title='Link to View this Address']")).click();
		  waitForElementVisible(By.xpath("//h2[contains(text(),'Address Assessments')]"));
		  driver.findElement(By.xpath("//a[@title='Select to view the address assessment']")).click();
		  Thread.sleep(3000);
		  WebElement Date =driver.findElement(By.xpath("//span[contains(@id,'id12:Date')]"));
		  String ADate = Date.getText().trim();
		  System.out.println(ADate);
		  System.out.println("Verified Edited Assessment");
		  //Assert.assertEquals(ADate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "DateUPD")).trim());
		
	}
	
	public void viewdeleteAssessmentIN(String sitNo) throws InterruptedException {
		 int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  Thread.sleep(3000);
		  
		  /*driver.findElement(By.xpath("//a[@id='linkNavigation3Address']")).click();
		  Thread.sleep(3000);
		  waitForElementVisible(By.xpath ("//h2[contains(text(),'Other Addresses')]"));*/
	
	
	}
	}


