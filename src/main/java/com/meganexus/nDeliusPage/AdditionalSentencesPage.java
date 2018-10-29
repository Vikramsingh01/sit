/**
 * 
 */
package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

/**
 * @author Amardeep.Patil
 *  I am adding Additional Sentences from nDelius
 */
public class AdditionalSentencesPage extends Utils{
	
	String sheetName = "AdditionalSentence";
	ExcelUtils excell = new ExcelUtils();
	
public void addAdditionalSentences(String sitNo) throws InterruptedException {
		
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		waitForElementVisible(By.xpath("//a[@id='linkNavigation3AdditionalSentence']"));
		scrollToClickElement(driver.findElement(By.xpath("//a[@id='linkNavigation3AdditionalSentence']"))); //Click on additional offence link
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='sentenceForm:AdditionalSentenceType']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Additional Sentence")).trim());
		
		driver.findElement(By.xpath("//input[@id='sentenceForm:Length']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Length")).trim());
		
		driver.findElement(By.xpath("//input[@id='sentenceForm:Value']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Value")).trim());
		
		driver.findElement(By.xpath("//textarea[@id='sentenceForm:Notes']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		
		scrollToClickElement(driver.findElement(By.xpath("//input[@id='sentenceForm:j_id_id63']")));
		
	}

	
	

}
