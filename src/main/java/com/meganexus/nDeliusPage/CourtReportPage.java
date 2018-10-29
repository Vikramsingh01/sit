/**
 * 
 */
package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

/**
 * @author Amardeep.Patil
 * adding court report from nDelius
 */
public class CourtReportPage extends Utils{
	
	String sheetName = "CourtReport";
	ExcelUtils excell = new ExcelUtils();

	public void addCourtReport(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		waitForElementVisible(By.id("linkNavigation3CourtAppearance"));
		scrollToClickElement(driver.findElement(By.id("linkNavigation3CourtAppearance"))); //Click on Court appearance
		Thread.sleep(2000);
		scrollToClickElement(driver.findElement(By.xpath("//a[contains(.,'update')]"))); // Click on Update button
		Thread.sleep(2000);
		WebElement newCourtBtn =driver.findElement(By.xpath("//input[@id='updateCourtAppearanceForm:j_id_id396']"));
		newCourtBtn.click();
		alertAccept();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='RequiredByDate']"))
		.sendKeys(getSysDate().trim());
		Thread.sleep(6000);
		//driver.findElement(By.id("addCourtReportForm:RequiredCourt"))
		//.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Required by Court")).trim());
		
		selectAnElementFromText("addCourtReportForm:RequiredCourt",	excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Required by Court")).trim());
		Thread.sleep(15000);
		//driver.findElement(By.id("RequestedReportType"))
		//.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Requested Report Type")).trim());
		
		selectAnElementFromText("RequestedReportType",	excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Requested Report Type")).trim());
		
		Thread.sleep(10000);
		//driver.findElement(By.id("Trust"))
		//.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim());
		
		selectAnElementFromText("Trust",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim());
		Thread.sleep(10000);
		//driver.findElement(By.id("Team"))
		//.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Team")).trim());
		selectAnElementFromText("Team",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Team")).trim());
		Thread.sleep(10000);
		//driver.findElement(By.id("Staff"))
		//.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Staff")).trim());
		selectAnElementFromText("Staff",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Officer")).trim());
		scrollToClickElement(driver.findElement(By.xpath("//input[@value='Save']")));
		
	}

}
	
	
	
	
	


