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
 * @author Amardeep Patil
 *
 */
public class AdditionalSentenceCMSPage extends Utils{
	
	String sheetName = "AdditionalSentence";
	ExcelUtils excell = new ExcelUtils();

	public void verifyAdditionaSentenceCMS(String sitNo) throws InterruptedException {
	
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		WebElement addsentenceLink =driver.findElement(By.xpath("//button[contains(.,'Additional Sentences')]"));
		addsentenceLink.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='offenderAdditionalSentence_view0']")).click();

		Thread.sleep(5000);
		WebElement sentence =driver.findElement(By.xpath(".//*[@id='additionalSentenceId']/tr-list-label"));
		String addSentence=sentence.getText();

		WebElement length =driver.findElement(By.xpath(".//*[@id='length']"));
		String lengthSent=length.getText();

		WebElement amount =driver.findElement(By.xpath("//div[@id='amount']"));
		String amountSent=amount.getText();
		
		WebElement notes = driver.findElement(By.xpath("//div[@id='note']"));
		String note =notes.getText();

		Assert.assertEquals(addSentence, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Additional Sentence")).trim());
		System.out.println(addSentence);

		Assert.assertEquals(lengthSent, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Length")).trim());
		System.out.println(lengthSent);

		Assert.assertEquals(amountSent, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Value")).trim());
		System.out.println(amountSent);
		
		Assert.assertEquals(note, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		System.out.println(note);
	
		driver.findElement(By.xpath("//span[contains(.,'additional sentence')]")).click();
	
	}


	
	
	

}
