/**
 * 
 */
package com.meganexus.cmsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

/**
 * @author IEUser
 *
 */
public class CommRequirmentPage extends Utils{
	
	 String sheetName = "Community Requirement";
	 ExcelUtils excell = new ExcelUtils();
	
	public void verifyCommunityReq(String sitNo) throws InterruptedException {
		  
		  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  WebElement viewEvent =driver.findElement(By.xpath("//button[@id='event_view0']"));
		  viewEvent.click();
		  Thread.sleep(3000);
		  WebElement requriLink =driver.findElement(By.xpath("(//a[contains(.,'Requirements')])[2]"));
		  requriLink.click();
		  WebElement reqViewBtn =driver.findElement(By.xpath("//button[@title='View Record']"));
		  reqViewBtn.click();
		  Thread.sleep(3000);
		  WebElement reqType =driver.findElement(By.xpath("(//div[@id='label_requirementTypeMainCategoryId']/following::tr-list-label)[1]"));
		  String MainReqType = reqType.getText().trim();
		  //registerTypeVal.trim();
		  WebElement reqSubType = driver.findElement(By.xpath("(//div[@id='label_requirementTypeMainCategoryId']/following::tr-list-label)[2]"));
		  String requirmentSubType = reqSubType.getText();
		  WebElement sentenceDate = driver.findElement(By.xpath("(//div[@id='label_imposedDate']/following::p)[1]"));
		  String sentDate= sentenceDate.getText();
		  WebElement startDate = driver.findElement(By.xpath("(//div[@id='label_imposedDate']/following::p)[3]"));
		  String expStartDate =startDate.getText();
		  WebElement actStartDate = driver.findElement(By.xpath("(//div[@id='label_imposedDate']/following::p)[4]"));
		  String actualStartDate =actStartDate.getText();
		  //System.out.println(providers);
		  WebElement notes = driver.findElement(By.xpath("//div[@id='registrationNote']"));
		  String note =notes.getText();
		   
		  System.out.println(MainReqType);
		  Assert.assertEquals(MainReqType, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Requirement")).trim());
		  
		  Assert.assertEquals(requirmentSubType, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Requirement Subtype")).trim());
		  System.out.println(requirmentSubType);
		 
		  Assert.assertEquals(sentDate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Imposed (Sentence) Date")).trim());
		  System.out.println(sentDate);
		  
		  Assert.assertEquals(expStartDate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Expected Start Date")).trim());
		  System.out.println(expStartDate);
		  Assert.assertEquals(note, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		  System.out.println(note);
		  Thread.sleep(3000);
		  Assert.assertEquals(actualStartDate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Actual Start Date")).trim());
		  Thread.sleep(3000);	  
		  
		  waitForElementPresent(By.xpath("//button[contains(.,'Event Details')]"));
		  driver.findElement(By.xpath("//button[contains(.,'Event Details')]")).click();
		  Thread.sleep(3000);
		  
		  
		  //System.out.println("SIT 017 Passed");
	 }
	

}
