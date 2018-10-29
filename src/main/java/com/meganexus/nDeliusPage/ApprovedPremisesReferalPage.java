/**
 * 
 */
package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

/**
 * @author Amardeep.Patil
 * I an adding Approved Premises Referral from nDelius
 */
public class ApprovedPremisesReferalPage extends Utils{
	
	String sheetName = "APReferral";
	ExcelUtils excell = new ExcelUtils();
	
public void addApprovedPremisesReferal(String sitNo) throws InterruptedException {
		
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		waitForElementVisible(By.xpath("//a[@id='linkNavigation3APReferrals']"));
		scrollToClickElement(driver.findElement(By.xpath("//a[@id='linkNavigation3APReferrals']"))); //Click on Approved premises referral link
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='New Referral']")).click();
		Thread.sleep(6000);
         
		waitForElementPresent(By.id("referralGrouping"));
		selectAnElementFromText("referralGrouping",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Group")).trim());
		Thread.sleep(6000);
		waitForElementPresent(By.id("referralAP"));
		selectAnElementFromText("referralAP",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral AP")).trim());
		
		Thread.sleep(6000);
		waitForElementPresent(By.id("addAPFrom:ReferralCategory"));
		selectAnElementFromText("addAPFrom:ReferralCategory",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Category")).trim());
		
		waitForElementPresent(By.id("ReferralSource"));
		selectAnElementFromText("ReferralSource",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Source")).trim());
		
		/*driver.findElement(By.xpath("//select[@id='ReferralSource']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Source")).trim());
		Thread.sleep(6000);*/
		/*driver.findElement(By.xpath("//select[@id='ReferralDecision']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Decision")).trim());
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@id='addAPFrom:decisionDate']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Decision Date")).trim());
		Thread.sleep(6000);*/
		/*driver.findElement(By.xpath("//select[@id='decisionTeam']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Decision by Team")).trim());
		
		driver.findElement(By.xpath("//select[@id='decisionByStaff']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Decision by Officer")).trim());
		*/
		driver.findElement(By.xpath("//input[@id='expAddDate']"))
		.sendKeys(getSysDate().trim());
		
		driver.findElement(By.xpath("//input[@id='expDepDate']"))
		.sendKeys(getYearAfterCurrentDate().trim());
	
		driver.findElement(By.xpath("//textarea[@id='addAPFrom:notes']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());

		scrollToClickElement(driver.findElement(By.id("addAPFrom:j_id_id194")));
		
	}

	
	

}
