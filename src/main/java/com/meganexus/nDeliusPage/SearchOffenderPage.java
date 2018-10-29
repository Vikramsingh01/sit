package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class SearchOffenderPage extends Utils {

	ExcelUtils excell = new ExcelUtils();

	// search offender in nDelius _ Tapan Sahoo
	public void searchOffender(String sitNo) throws InterruptedException {
		Log.info("Searching offender with firstname and last name");
		int rowNum = excell.getRowNums("OffenderDetails", "SIT NO", sitNo);
		Thread.sleep(1000);
		String firstname = excell.getData("OffenderDetails", rowNum, excell.getCellNumber("OffenderDetails", "First Name")).trim();
		String lastname = excell.getData("OffenderDetails", rowNum, excell.getCellNumber("OffenderDetails", "Surname"))
				.trim();
		try {
			waitForElementVisible(By.xpath("//a[contains(text(),'National Search')]"));
			driver.findElement(By.xpath("//a[contains(text(),'National Search')]")).click();
			Thread.sleep(6000);
			waitForElementVisible(By.id("SearchForm:FirstName"));
			driver.findElement(By.id("SearchForm:FirstName")).sendKeys(firstname);
			waitForElementVisible(By.id("SearchForm:LastName"));
			driver.findElement(By.id("SearchForm:LastName")).sendKeys(lastname);
			waitForElementVisible(By.id("SearchForm:searchButton"));
			driver.findElement(By.id("SearchForm:searchButton")).click();
		} catch (Exception e) {
			Log.error("nDelius offender search page Element not found" + e.getMessage());
		}

	}

	// if offender is already added and you want to check your later part of script is working or not
	public void searchOffenderWithCRNAndViewOffender(String sitNo) throws InterruptedException {
		
		int rowNum = excell.getRowNums("OffenderDetails", "SIT NO", sitNo);
		String crnNo = excell.getData("OffenderDetails", rowNum, excell.getCellNumber("OffenderDetails", "CRN NO"))
				.trim();
		Thread.sleep(6000);
		try {
			Log.info("Searched offender with crnNO = "+crnNo);
			waitForElementPresent(By.xpath("//a[contains(text(),'National Search')]"));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[contains(text(),'National Search')]")).click();
			driver.findElement(By.id("SearchForm:refreshButton")).click();
			Thread.sleep(500);
			if (crnNo.length() > 0) {
				driver.findElement(By.id("SearchForm:CRN")).sendKeys(crnNo);
				waitForElementVisible(By.id("SearchForm:searchButton"));
				driver.findElement(By.id("SearchForm:searchButton")).click();
				waitForElementVisible(By.xpath("//td[text()='" + crnNo + "']/following-sibling::td[9]"));
				scrollToElement(driver.findElement(By.linkText("View")));
				
				Thread.sleep(3000);
				driver.findElement(By.linkText("View")).click();
				waitForElementVisible(By.xpath("//h1[text()='Offender Summary']"));
				Thread.sleep(3000);
				driver.findElement(By.linkText("Offender Index")).click();
			}

		} catch (Exception e) {
			Log.error("unable to view offender "+crnNo+" " + e.getMessage());
		}
		
	}
	
	public void searchExistingOffender(String sitNo) throws InterruptedException {
		
		int rowNum = excell.getRowNums("OffenderDetails", "SIT NO", sitNo);
		String crnNo = excell.getData("OffenderDetails", rowNum, excell.getCellNumber("OffenderDetails", "CRN NO"))
				.trim();
		Thread.sleep(6000);
		
		if (crnNo.length() > 0) {
			driver.findElement(By.id("SearchForm:CRN")).sendKeys(crnNo);
			waitForElementVisible(By.id("SearchForm:searchButton"));
			driver.findElement(By.id("SearchForm:searchButton")).click();
			waitForElementVisible(By.xpath("//td[text()='" + crnNo + "']/following-sibling::td[9]"));
			scrollToElement(driver.findElement(By.linkText("View")));
			
			Thread.sleep(3000);
			driver.findElement(By.linkText("View")).click();
			waitForElementVisible(By.xpath("//h1[text()='Offender Summary']"));
			Thread.sleep(3000);
			driver.findElement(By.linkText("Offender Index")).click();
		}

	
		
		
		
	}

}
