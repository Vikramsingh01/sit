package com.meganexus.nDeliusPage;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class AddEventPage extends Utils {
	ExcelUtils excell = new ExcelUtils();
	String sheetName = "Event";

	public void addEvent(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		
		
		/*try {*/
			waitForElementVisible(By.id("linkNavigation2EventList"));
			driver.findElement(By.id("linkNavigation2EventList")).click();

			waitForElementVisible(By.xpath("//h1[contains(text(),'Events')]"));
			driver.findElement(By.id("eventsListForm:j_id_id74")).click();
			Thread.sleep(1000);
			System.out.println(sheetName);
			waitForElementVisible(By.xpath("//h1[contains(text(),'Create New Event')]"));
			System.out.println(excell.getData("Event", rowNum, excell.getCellNumber("Event", "Referral Date")).trim());
			driver.findElement(By.id("ReferralDate")).sendKeys(excell.getData("Event", rowNum, excell.getCellNumber("Event", "Referral Date")).trim());
			waitForElementVisible(By.id("OffenceDate"));
			driver.findElement(By.id("OffenceDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offence Date")).trim());
			waitForElementVisible(By.id("ConvictionDate"));
			driver.findElement(By.id("ConvictionDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Conviction Date")).trim());
			waitForElementVisible(By.id("MainOffence"));
			selectAnElementFromText("MainOffence",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Main Offence")).trim());
			waitForElementPresent(By.id("addEventForm:SubOffence"));
			Thread.sleep(5000);
			selectAnElementFromText("addEventForm:SubOffence",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offence Sub-Cat")).trim());
			waitForElementPresent(By.id("addEventForm:EventNotes"));
			driver.findElement(By.id("addEventForm:EventNotes")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
			waitForElementPresent(By.id("Court"));
			selectAnElementFromText("Court",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Court")).trim());
			waitForElementPresent(By.id("AppearanceType"));
			selectAnElementFromText("AppearanceType",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Appearance Type")).trim());
			waitForElementVisible(By.id("Plea"));
			selectAnElementFromText("Plea",	excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Plea")).trim());
			scrollToElement(driver.findElement(By.id("addEventForm:Outcome")));
			Thread.sleep(200);
			waitForElementPresent(By.id("addEventForm:Outcome"));
			selectAnElementFromText("addEventForm:Outcome",	excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Outcome")).trim());
			Thread.sleep(200);
			waitForElementVisible(By.id("addEventForm:Length"));
			driver.findElement(By.id("addEventForm:Length")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Length")).trim());
			waitForElementPresent(By.id("OutcomeArea"));
			Thread.sleep(2000);
			selectAnElementFromText("OutcomeArea",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Supervising Provider")).trim());
			scrollToElement(driver.findElement(By.xpath("//input[@value='Save']")));
			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@value='Save']")).click();
			Thread.sleep(2000);
			
			
			
			
			

		/*} catch (NoSuchElementException n) {
			System.out.println("Element not available" + n.getMessage());

		} catch (StaleElementReferenceException e) {
			System.out.println("The dom is refreshed and element is not found" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/

	}
	
	
	public void viewEvent(String sitNo) throws InterruptedException {
		
		Thread.sleep(6000);
		//waitForElementVisible(By.id("linkNavigation2EventList"));
		scrollToElement(driver.findElement(By.id("linkNavigation2EventList")));
		driver.findElement(By.id("linkNavigation2EventList")).click();

		waitForElementVisible(By.xpath("//h1[contains(text(),'Events')]"));
		//driver.findElement(By.id("eventsListForm:j_id_id74")).click();
	
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='eventsListForm:eventsTable:tbody_element']/tr/td[6]/a")).click();

	}

}
