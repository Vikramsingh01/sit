package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class NSIPage extends Utils {

	String sheetName = "NSI";
	ExcelUtils excell = new ExcelUtils();

	public void addNSI(String sitNo) throws InterruptedException {

		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		waitForElementVisible(By.id("linkNavigation3OffenderNsi"));
		driver.findElement(By.id("linkNavigation3OffenderNsi")).click();

		waitForElementPresent(By.id("nsiListForm:j_id_id85"));
		driver.findElement(By.id("nsiListForm:j_id_id85")).click();
		Thread.sleep(500);

		// waitForElementPresent(By.xpath("//h1[contains(text()='Add Non Statutory
		// Intervention']"));

		// selectAnElementFromIndexNo("//select[@id='NsiProvider']", 23);
		selectAnElementFromText("NsiProvider", "NPS North West");

		/*
		 * waitForElementVisible(By.id("NsiEstablishmentProvider"));
		 * selectAnElementFromText("NsiEstablishmentProvider", "Altcourse (HMP)");
		 */

		waitForElementPresent(By.id("NsiType"));
		Thread.sleep(1000);
		selectAnElementFromText("NsiType", excell
				.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Non Statutory Intervention")).trim());

		waitForElementPresent(By.id("NsiSubType"));
		Thread.sleep(1000);
		selectAnElementFromText("NsiSubType", excell
				.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Non Statutory Intervention Sub Type"))
				.trim());

		waitForElementVisible(By.id("ReferralDate"));
		driver.findElement(By.xpath("//input[@id='ReferralDate']"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Date")).trim());

		waitForElementVisible(By.id("ExpectedStartDate"));
		driver.findElement(By.xpath("//input[@id='ExpectedStartDate']")).sendKeys(
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Expected Start Date")).trim());

		waitForElementVisible(By.id("ActualStartDate"));
		driver.findElement(By.xpath("//input[@id='ActualStartDate']")).sendKeys(
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Actual Start Date")).trim());

		waitForElementVisible(By.id("Provider"));
		selectAnElementFromText("Provider",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim());

		waitForElementVisible(By.id("Status"));
		selectAnElementFromText("Status",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Status")).trim());
		Thread.sleep(1000);
		waitForElementVisible(By.id("StatusDate"));
		driver.findElement(By.xpath("//input[@id='StatusDate']")).clear();
		driver.findElement(By.xpath("//input[@id='StatusDate']"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Status Date")).trim());

		/*waitForElementVisible(By.id("StatusTime"));
		driver.findElement(By.xpath("//input[@id='StatusTime']"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Status Time")).trim());*/

		waitForElementVisible(By.id("addNsiForm:Notes"));
		scrollToElement(driver.findElement(By.id("addNsiForm:Notes")));

		driver.findElement(By.xpath("//textarea[@id='addNsiForm:Notes']"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());

		waitForElementVisible(By.id("ExpectedEndDate"));
		// scrollToElement(driver.findElement(By.id("ExpectedEndDate")));
		driver.findElement(By.xpath("//input[@id='ExpectedEndDate']")).sendKeys(
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Expected End Date")).trim());

		//scrollToElement(driver.findElement(By.xpath("//input[@value='Save']")));
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		//scrollToClickElement(driver.findElement(By.xpath("//input[@value='Save']")));

		Thread.sleep(1000);
		System.out.println("NSI : Done");
	}
}
