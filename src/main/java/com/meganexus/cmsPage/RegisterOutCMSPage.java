package com.meganexus.cmsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class RegisterOutCMSPage extends Utils{
	
	String sheetName = "Registration";
	ExcelUtils excell = new ExcelUtils();
	
	public void viewRegisterOut(String sitNo) throws InterruptedException {
		  
		  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  WebElement rLink =driver.findElement(By.xpath("(//button[contains(.,'R')])[1]"));
		  rLink.click();
		  Thread.sleep(3000);
		  WebElement viewRegBtn =driver.findElement(By.id("registration_view0"));
		  System.out.println("in registration details ... check screen");
		  viewRegBtn.click();
		  Thread.sleep(3000);
		  WebElement RegTypeddl =driver.findElement(By.xpath("//div[@id='label_registerTypeId']/following::tr-list-label"));
		  String registerTypeVal = RegTypeddl.getText().trim();
		  //registerTypeVal.trim();
		  WebElement regDate = driver.findElement(By.xpath("//div[@id='registrationDate']"));
		  String registerDate = regDate.getText();
		  WebElement reviewPeriod = driver.findElement(By.xpath("//div[@id='reviewPeriod']"));
		  String registerPeriod= reviewPeriod.getText();
		  WebElement nextReviewDate = driver.findElement(By.xpath("//div[@id='nextReviewDate']"));
		  String nextdDate =nextReviewDate.getText();
		  WebElement notes = driver.findElement(By.xpath("//div[@id='registrationNote']"));
		  String note =notes.getText();
		  WebElement provider = driver.findElement(By.xpath(".//*[@id='label_registrationProviderId']/following::span[1]"));
		  String providers =provider.getText();
		  System.out.println(providers);
		  WebElement team = driver.findElement(By.id("registeringTeam"));
		  WebElement officer = driver.findElement(By.id("registeringOfficer"));
		  
		  
		  
		  System.out.println(registerTypeVal);
		  Assert.assertEquals(registerTypeVal, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Type")).trim());
		  
		  Assert.assertEquals(registerDate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Date")).trim());
		  System.out.println(registerDate);
		 
		// Assert.assertEquals(registerPeriod, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Review Period")).trim());
		  System.out.println(registerPeriod);
		  
		//  Assert.assertEquals(nextdDate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Next Review Date")).trim());
		  System.out.println(nextdDate);
		  Assert.assertEquals(note, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		  System.out.println(note);
		  Thread.sleep(3000);
		 /* Assert.assertEquals(provider, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Registering Officer's Provider")).trim());
		  Thread.sleep(3000);
		  Assert.assertEquals(team, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Registering Officer's Team")).trim());
		  Thread.sleep(3000);
		  Assert.assertEquals(officer, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Registering Officer")).trim());*/
		
		  WebElement ListBtn =driver.findElement(By.xpath("//button[contains(.,'Registrations')]"));
		  ListBtn.click();
		  
		  
		  waitForElementPresent(By.xpath("//button[contains(text(),'Profile')]"));
		  driver.findElement(By.xpath("//button[contains(text(),'Profile')]")).click();
		  Thread.sleep(3000);
		  
		  //System.out.println("SIT 017 Passed");
	 }
	public void viewUpdateRegisterOut(String sitNo) throws InterruptedException {
		  
		  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		//  WebElement rLink =driver.findElement(By.xpath("(//button[contains(.,'R')])[1]"));
	//	  rLink.click();
		  Thread.sleep(4000);
		  WebElement viewRegBtn =driver.findElement(By.xpath("//button[@id='registration_view0']"));
		  viewRegBtn.click();
		  Thread.sleep(3000);
		  WebElement RegTypeddl =driver.findElement(By.xpath("//div[@id='label_registerTypeId']/following::tr-list-label"));
		  String registerTypeVal = RegTypeddl.getText();
		  WebElement regDate = driver.findElement(By.xpath("//div[@id='registrationDate']"));
		  String registerDate = regDate.getText();
		  WebElement reviewPeriod = driver.findElement(By.xpath("//div[@id='reviewPeriod']"));
		  String registerPeriod= reviewPeriod.getText();
		  WebElement nextReviewDate = driver.findElement(By.xpath("//div[@id='nextReviewDate']"));
		  String nextdDate =nextReviewDate.getText();
		  WebElement notes = driver.findElement(By.xpath("//div[@id='registrationNote']"));
		  String note =notes.getText();
		 
		  Assert.assertEquals(registerTypeVal, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Type")).trim());
		  System.out.println("registerTypeVal");

		  Assert.assertEquals(registerDate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Date")).trim());
		  System.out.println(registerDate);
		 
	//	  Assert.assertEquals(registerPeriod, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Review Period")));
		  System.out.println(registerPeriod);
		  
	//	  Assert.assertEquals(nextdDate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Next Review Date")));
		  System.out.println(nextdDate);
		  
	//	  Assert.assertEquals(note, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Note UPD")).trim());
		  System.out.println(note);
		  
		  System.out.println("SIT 017 Passed");
	 }

}
