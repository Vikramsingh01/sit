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
public class AdditionalOffenceCMSPage extends Utils{

	String sheetName = "AdditionalOffences";
	ExcelUtils excell = new ExcelUtils();

	public void verifyAddtionalOffence(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		WebElement addOffLink =driver.findElement(By.xpath("//button[contains(.,'Additional Offences')]"));
		addOffLink.click();
		Thread.sleep(5000);
		WebElement offence =driver.findElement(By.xpath("//tr/td/span"));
		String offType=offence.getText();

		WebElement offDate =driver.findElement(By.xpath("//tr/td[2]"));
		String date=offDate.getText();

		WebElement count =driver.findElement(By.xpath("//tr/td[3]"));
		String offCount=count.getText();

		Assert.assertEquals(offType, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offence Main Category")).trim());
		System.out.println(offType);

		Assert.assertEquals(date, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offence Date")).trim());
		System.out.println(date);

		Assert.assertEquals(offCount, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offence Count")).trim());
		System.out.println(offCount);
	
	}



	//button[contains(.,'Additional Offences')]





}
