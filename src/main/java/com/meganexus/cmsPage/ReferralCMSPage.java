package com.meganexus.cmsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class ReferralCMSPage extends Utils {
	String sheetName = "Referral";
	ExcelUtils excell = new ExcelUtils();

	public void clickAddReferralBtn() throws InterruptedException {
		driver.findElement(By.id(".//*[@id='eventtab']")).click();
		Thread.sleep(6000);
		// View Event
		driver.findElement(By.xpath("//button[@id='event_view0']")).click();
		Thread.sleep(10000);
		// Click Referral tab
		waitForElementVisible(By.id(".//*[@id='5referral']"));
		driver.findElement(By.id(".//*[@id='5referral']")).click();
		Thread.sleep(3000);
		// click add referral
		waitForElementVisible(By.xpath("//button[@id='referral_addButton']"));
		driver.findElement(By.xpath("//button[@id='referral_addButton']")).click();
		Thread.sleep(3000);
	}

	public void addReferralDetails(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		waitForElementVisible(By.xpath("//h2[text()='Add Referral']"));
		Thread.sleep(5000);
		waitForElementVisible(By.id("referralTypeId"));
		selectAnElementFromText("referralTypeId",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Type")).trim());
		Thread.sleep(1000);
		waitForElementVisible(By.id("referralDate"));
		driver.findElement(By.id("referralDate"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Date")).trim());
		Thread.sleep(1000);
		waitForElementVisible(By.id("referralOutcomeId"));
		selectAnElementFromText("referralOutcomeId",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Outcome")).trim());
		Thread.sleep(1000);
		waitForElementVisible(By.id("referralSourceId"));
		selectAnElementFromText("referralSourceId",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Source")).trim());
		Thread.sleep(1000);

		waitForElementVisible(By.id("note"));
		driver.findElement(By.id("note"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('saveButton').focus();");
		driver.findElement(By.id("saveButton")).click();
		Thread.sleep(2000);

	}

	public void clickViewReferralBtn() throws InterruptedException {
		driver.findElement(By.id(".//*[@id='eventtab']")).click();
		Thread.sleep(6000);
		// View Event
		driver.findElement(By.xpath("//button[@id='event_view0']")).click();
		Thread.sleep(10000);
		// Click Referral tab
		waitForElementVisible(By.id(".//*[@id='5referral']"));
		driver.findElement(By.id(".//*[@id='5referral']")).click();
		Thread.sleep(3000);
		waitForElementVisible(By.xpath(".//*[@id='referral_view0']"));
		driver.findElement(By.xpath(".//*[@id='referral_view0']")).click();
		Thread.sleep(3000);

	}

}
