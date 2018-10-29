/**
 * 
 */
package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

/**
 * @author Amardeep.Patil
 * I am adding Additional Offense from nDelius
 */
public class AdditionalOffencePage extends Utils{
	
	String sheetName = "AdditionalOffences";
	ExcelUtils excell = new ExcelUtils();
	
	
	public void addAdditionalOffence(String sitNo) throws InterruptedException {
		
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		waitForElementVisible(By.id("linkNavigation3AdditionalOffence"));
		scrollToClickElement(driver.findElement(By.xpath("//a[@id='linkNavigation3AdditionalOffence']"))); //Click on additional offence link
		Thread.sleep(10000);
		//driver.findElement(By.id("MainOffence"))
		//.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offence Main Category")).trim());
		
		selectAnElementFromText("MainOffence",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offence Main Category")).trim());
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//select[@id='updateAdditionalOffencesForm:SubOffence']"))
		//.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offence Sub Category")).trim());
		
		//selectAnElementFromText("updateAdditionalOffencesForm:SubOffence",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offence Sub Category")).trim());
		Thread.sleep(5000);
		driver.findElement(By.id("updateAdditionalOffencesForm:OffenceDate"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offence Date")).trim());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='updateAdditionalOffencesForm:OffenceCount']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offence Count")).trim());
		Thread.sleep(2000);
		scrollToClickElement(driver.findElement(By.xpath("//input[@value='Add']")));
		
	}


}
