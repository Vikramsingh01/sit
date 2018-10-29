package com.meganexus.cmsPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class ServiceuserCmsPage extends Utils {
	ExcelUtils xcell = new ExcelUtils();
	
	public void viewServiceUser(String sitNo) throws InterruptedException {
		int rowNum=xcell.getRowNums("OffenderDetails", "SIT NO", sitNo);
		int cellNum=xcell.getCellNumber("OffenderDetails", "CRN NO");
		String crnNo=xcell.getData("OffenderDetails", rowNum, cellNum).trim();
		
		//waitForElementVisible(By.xpath("//a[@id='SU Management']"));
		//scrollToClickElement(driver.findElement(By.xpath("//a[@id='SU Management']")));
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@id='SU Management']")).click();
		Thread.sleep(1000);
		//waitForElementVisible(By.xpath("//button[text()='Service Users']"));
		scrollToClickElement(driver.findElement(By.xpath("//button[text()='Service Users']")));
		waitForElementVisible(By.xpath("//button[contains(text(),'CRC Service Users')]"));
		scrollToClickElement(driver.findElement(By.xpath("//button[text()='CRC Service Users']")));
		waitForElementVisible(By.id("filter"));
		scrollToClickElement(driver.findElement(By.id("filter")));
		waitForElementVisible(By.id("caseReferenceNumber"));
		driver.findElement(By.id("caseReferenceNumber")).sendKeys(crnNo);
		Thread.sleep(10000);
		//waitForElementVisible(By.xpath("//button[text()='Search']"));
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(8000);
		//waitForElementVisible(By.xpath("//td[text()='" + crnNo + "']/following-sibling::td[6]"));
		driver.findElement(By.xpath("//td[text()='" + crnNo + "']/following-sibling::td[6]")).click();
		Thread.sleep(2000);

	}
	
	public void viewrbacsServiceUser(String crnNo) throws InterruptedException {
		waitForElementVisible(By.xpath("//a[@id='SU Management']"));
		scrollToClickElement(driver.findElement(By.xpath("//a[@id='SU Management']")));
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@id='SU Management']")).click();
		//waitForElementVisible(By.xpath("//button[text()='Service Users']"));
		scrollToClickElement(driver.findElement(By.xpath("//button[text()='Service Users']")));
		waitForElementVisible(By.xpath("//button[contains(text(),'CRC Service Users')]"));
		scrollToClickElement(driver.findElement(By.xpath("//button[text()='CRC Service Users']")));
		waitForElementVisible(By.id("filter"));
		scrollToClickElement(driver.findElement(By.id("filter")));
		waitForElementVisible(By.id("caseReferenceNumber"));
		driver.findElement(By.id("caseReferenceNumber")).sendKeys(crnNo);
		Thread.sleep(3000);
		//waitForElementVisible(By.xpath("//button[text()='Search']"));
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(6000);
		//waitForElementVisible(By.xpath("//td[text()='" + crnNo + "']/following-sibling::td[6]"));
		driver.findElement(By.xpath("//td[text()='" + crnNo + "']/following-sibling::td[6]")).click();
		Thread.sleep(2000);

	}

	public void SUmanagement() throws InterruptedException {
		//driver.navigate().refresh();
		waitForElementVisible(By.xpath("//a[@id='SU Management']"));
		scrollToClickElement(driver.findElement(By.xpath("//a[@id='SU Management']")));
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//a[@id='SU Management']")).click();
		
	}
	
}
