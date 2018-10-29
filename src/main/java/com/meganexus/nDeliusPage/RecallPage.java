package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class RecallPage extends Utils {
	
	ExcelUtils excell = new ExcelUtils();
	String sheetName = "Recall";
	
	public void viewRecall(String sitNo) throws Exception {
	
	int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
	driver.findElement(By.xpath("//a[@id='linkNavigation2EventList']")).click();
	
	waitForElementVisible(By.xpath("//h1[contains(text(),'Events')]"));
	driver.findElement(By.xpath("//a[contains(.,'view')]")).click();
	
	waitForElementVisible(By.xpath("//h1[contains(text(),'Event Details')]"));
	scrollToElement(driver.findElement(By.xpath("//a[@id='linkNavigation3Throughcare']")));
	
	driver.findElement(By.xpath("//a[@id='linkNavigation3Throughcare']")).click();
	waitForElementVisible(By.xpath("//h1[contains(text(),'Throughcare Details')]"));
	
	waitForElementVisible(By.xpath("//h1[contains(text(),'Throughcare Details')]"));
	waitForElementVisible(By.xpath("//label[@for='j_id_id11:RecallDate']"));
	
	WebElement ReturnToCustody= driver.findElement(By.xpath("//span[@id='j_id_id11:RecallDate']"));
	 String returnToCustody= ReturnToCustody.getText().trim();
	 Assert.assertEquals(returnToCustody, excell.getData(sheetName, rowNum,
				excell.getCellNumber(sheetName, "Recall Date")).trim());
	
	
	
	
	
	
	
	

}
}
