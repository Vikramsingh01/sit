package com.meganexus.nDeliusPage;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class RestrictionListPage extends Utils {

	String sheetName = "Restriction List";
	ExcelUtils excell = new ExcelUtils();

	public void addRestrictionList(String sitNo) throws InterruptedException {

		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		try {
			Log.info("Clicked on data maintenance tab");
			driver.findElement(By.xpath("//a[@id='linkNavigation1DataMaintenance']")).click();
			waitForElementVisible(By.xpath("//h1[contains(text(),'Data Maintenance')]"));

			driver.findElement(By.xpath("//a[contains(text(),'Restrictions')]")).click();
			waitForElementVisible(By.xpath("//h1[contains(text(),'Restriction List')]"));
			Log.info("adding Crn no to restrication list");
			driver.findElement(By.xpath("//input[@id='restrictionListForm:CRN']"))
					.sendKeys(excell.getData("OffenderDetails", excell.getRowNums("OffenderDetails", "SIT NO", sitNo),
							excell.getCellNumber("OffenderDetails", "CRN NO")));

			driver.findElement(By.xpath("//input[@id='restrictionListForm:searchButton']")).click();
			waitForElementVisible(By.xpath("//input[@id='restrictionListForm:insertRestriction']"));
			Log.info("adding restrication details");
			driver.findElement(By.xpath("//input[@id='restrictionListForm:insertRestriction']")).click();
			waitForElementVisible(By.xpath("//h1[contains(text(),'Add Restriction')]"));

			waitForElementVisible(By.id("UserID"));
			driver.findElement(By.id("UserID"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "User ID")).trim());
			driver.findElement(By.xpath("//input[@value='Search']")).click();

			waitForElementVisible(By.id("RestrictionReason"));
			selectAnElementFromText("RestrictionReason",
					excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Restriciton Reason")).trim());

			waitForElementVisible(By.id("TransferToTrust"));
			selectAnElementFromText("TransferToTrust",
					excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim());

			waitForElementVisible(By.id("RestrictionStartTeam"));
			selectAnElementFromText("RestrictionStartTeam",
					excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Team")).trim());

			waitForElementVisible(By.id("RestrictionStartOfficer"));
			selectAnElementFromText("RestrictionStartOfficer",
					excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Officer")).trim());

			waitForElementVisible(By.xpath("//input[@value='Save']"));
			driver.findElement(By.xpath("//input[@value='Save']")).click();

			waitForElementVisible(By.xpath("//input[@value='Confirm']"));
			driver.findElement(By.xpath("//input[@value='Confirm']")).click();

			System.out.println("Restriction List : Done");
			
			waitForElementPresent(By.id("linkNavigation1Search"));
			Thread.sleep(1000);
			driver.findElement(By.id("linkNavigation1Search")).click();
			
		} catch (NoSuchElementException e) {
			Log.error("Element not visibile or check your locators " + e.getMessage());
		} catch (Exception e) {
			Log.error("Unable to add Registration");
		}

	}
}
