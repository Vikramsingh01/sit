package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class ReferralPage extends Utils {
	String sheetName = "Referral";
	ExcelUtils excell = new ExcelUtils();
	

	public void viewReferral(String sitNo) throws InterruptedException {
		Thread.sleep(2000);
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		driver.findElement(By.id("linkNavigation3DRRReferrals")).click();
		waitForElementVisible(By.xpath("//h1[contains(.,'Drug Testing Referrals')]"));
		
		driver.findElement(By.xpath("//a[contains(.,'view')]")).click();
		waitForElementVisible(By.xpath("//h1[contains(.,'View Drug Testing Referral')]"));
		
		 Thread.sleep(2000);
		  WebElement ReferralDateCMS = driver.findElement(By.xpath(".//*[@id='j_id_id11:ReferralDate']"));
	      String ReferralDate =  ReferralDateCMS.getText();
		  Assert.assertEquals(ReferralDate, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Date")).trim());
		  
		  Thread.sleep(2000);
		  WebElement ReferralTypeCMS = driver.findElement(By.xpath(".//*[@id='j_id_id11:ReferralType']"));
		  System.out.println(ReferralTypeCMS);
		  String ReferralType =  ReferralTypeCMS.getText();
		  Assert.assertEquals(ReferralType, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Type")).trim());
		  
		  Thread.sleep(2000);
		  WebElement ReferralSourceCMS = driver.findElement(By.xpath(".//*[@id='j_id_id11:ReferralSource']"));
		  String ReferralSource =  ReferralSourceCMS.getText();
		  Assert.assertEquals(ReferralSource, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Source")).trim());
		  
		  Thread.sleep(2000);
		  WebElement OutcomeCMS = driver.findElement(By.xpath(".//*[@id='j_id_id11:Outcome']"));
	      String Outcome =  OutcomeCMS.getText();
		  Assert.assertEquals(Outcome, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Outcome")).trim());
		  
		  Thread.sleep(2000);
		  WebElement NotesCMS = driver.findElement(By.xpath(".//*[@id='j_id_id11:Notes']"));
		  String Notes =  NotesCMS.getText();
		 // Assert.assertEquals(Notes, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());		  
	
    }
	 public void addReferral(String sitNo) throws InterruptedException {   // Adding referral in nDelius
			
			int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
			waitForElementVisible(By.xpath("//a[@id='linkNavigation3Referrals']"));
			scrollToClickElement(driver.findElement(By.xpath("//a[@id='linkNavigation3Referrals']"))); //Click on Referral link
			Thread.sleep(2000);
			scrollToClickElement(driver.findElement(By.xpath("//input[@id='referrals:j_id_id72']")));
			Thread.sleep(15000);
			//waitForElementPresent(By.id("addReferralForm:ReferralType"));

			//driver.findElement(By.id("addReferralForm:ReferralType"))
			//.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Type")).trim());
			
			
			waitForElementPresent(By.id("addReferralForm:ReferralType"));
			selectAnElementFromText("addReferralForm:ReferralType",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Type")).trim());
			
			driver.findElement(By.xpath("//input[@id='addReferralForm:ReferralDate']"))
			.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Date")).trim());
			
			waitForElementPresent(By.id("addReferralForm:ReferralSource"));
			selectAnElementFromText("addReferralForm:ReferralSource",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Source")).trim());
			
			waitForElementPresent(By.id("addReferralForm:Area"));
			selectAnElementFromText("addReferralForm:Area",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Provider")).trim());
			
			
			waitForElementPresent(By.id("addReferralForm:Team"));
			selectAnElementFromText("addReferralForm:Team",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Team")).trim());
			
			waitForElementPresent(By.id("addReferralForm:Staff"));
			selectAnElementFromText("addReferralForm:Staff",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Officer")).trim());
          
			Thread.sleep(10000);
			waitForElementPresent(By.id("addReferralForm:Outcome"));
			selectAnElementFromText("addReferralForm:Outcome",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Outcome")).trim());
			
			driver.findElement(By.xpath("//textarea[@id='addReferralForm:Notes']"))
			.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
			
			scrollToClickElement(driver.findElement(By.xpath("//input[@id='addReferralForm:j_id_id100']")));
			
		}
		
	
}
