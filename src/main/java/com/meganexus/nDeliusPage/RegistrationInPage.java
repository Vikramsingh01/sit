package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class RegistrationInPage extends Utils{
	
	String sheetName = "Registration";
	ExcelUtils excell = new ExcelUtils();
	
	public void viewRegisterIN(String sitNo) throws InterruptedException {
		  
		  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  Thread.sleep(3000);
		  driver.findElement(By.id("linkNavigation2OffenderIndex")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.id("linkNavigation3Registration")).click();
		  Thread.sleep(3000);
		  WebElement viewRegBtn =driver.findElement(By.xpath("//a[@title='Link to view the details of this registration record and access the Registration History view.']"));
		  viewRegBtn.click();
		  Thread.sleep(3000);
		  WebElement RegTypeddl =driver.findElement(By.id("registrationForm:RegisterType"));
		  String registerTypeVal = RegTypeddl.getText().trim();
		  //registerTypeVal.trim();
		  WebElement regDate = driver.findElement(By.id("registrationForm:RegistrationDate"));
		  String registerDate = regDate.getText();
		  WebElement reviewPeriod = driver.findElement(By.xpath("//span[@id='registrationForm:ReviewPeriod']"));
		  String registerPeriod= reviewPeriod.getText();
		  WebElement nextReviewDate = driver.findElement(By.id("registrationForm:NextReviewDate"));
		  String nextdDate =nextReviewDate.getText();
		  WebElement notes = driver.findElement(By.id("registrationForm:Notes"));
		  String note =notes.getText();
		  
		  System.out.println(registerTypeVal);
		  Assert.assertEquals(registerTypeVal, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Type")).trim());
		  
		  Assert.assertEquals(registerDate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Date")).trim());
		  System.out.println(registerDate);
		 
		//  Assert.assertEquals(registerPeriod, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Review Period")).trim());
		  System.out.println(registerPeriod);
		  
		//  Assert.assertEquals(nextdDate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Next Review Date")).trim());
		  System.out.println(nextdDate);
		  
		 // Assert.assertEquals(note, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		 // System.out.println(note);
		  
		  System.out.println("SIT 20 Passed");
	 }
	public void viewEditRegisterIN(String sitNo) throws InterruptedException {
		
		  
		  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  WebElement btnClose =driver.findElement(By.id("registrationForm:j_id_id170"));
		  btnClose.click();
		  Thread.sleep(3000);
		  WebElement viewRegBtn =driver.findElement(By.xpath("//a[@title='Link to view the details of this registration record and access the Registration History view.']"));
		  viewRegBtn.click();
		  //WebElement viewRegBtn =driver.findElement(By.xpath("//a[contains(.,'view')]"));
	//	  viewRegBtn.click();
		  Thread.sleep(3000);
		  WebElement notes = driver.findElement(By.id("registrationForm:Notes"));
		  String note =notes.getText();
	//	  Assert.assertEquals(note, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Note UPD")).trim());
		  System.out.println(note);
		
	}
	
	

}
