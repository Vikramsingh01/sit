package com.meganexus.cmsPage;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class NSICMSPage extends Utils {

	String sheetName = "NSI";
	ExcelUtils excell = new ExcelUtils();

	public void viewNSICMS(String sitNo) throws InterruptedException {
		Log.info("Viewing NSI CMS");
		int count = 0;
		while (count < 2) {
			try {

				int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
				
				driver.findElement(By.xpath("//button[text()='Profile']")).click();
				Thread.sleep(3000);

				driver.findElement(By.xpath("//button[contains(text(),'NSI')]")).click();
				Thread.sleep(3000);

				waitForElementVisible(By.id("processContact_view0"));

				driver.findElement(By.id("processContact_view0")).click();
				Thread.sleep(3000);

				WebElement nsiProvider = driver.findElement(By.xpath("//div[@id='intendedProviderId']/tr-list-label"));
				String Provider = nsiProvider.getText().trim();
				Assert.assertEquals(Provider,
						excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim());
				System.out.println("NSI Provider");

				WebElement NSIntervention = driver.findElement(By.xpath("//div[@id='processTypeId']/tr-list-label"));
				String InterventionType = NSIntervention.getText().trim();
				Assert.assertEquals(InterventionType,
						excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Non Statutory Intervention"))
								.trim());
				System.out.println("NSI Intervention Type");

				WebElement NSInterventionSubType = driver
						.findElement(By.xpath("//div[@id='processSubTypeId']/tr-list-label"));
				String InterventionSubType = NSInterventionSubType.getText().trim();
				Assert.assertEquals(InterventionSubType, excell.getData(sheetName, rowNum,
						excell.getCellNumber(sheetName, "Non Statutory Intervention Sub Type")).trim());
				System.out.println("NSI Intervention Sub Type");

				WebElement ReferralDate = driver.findElement(By.xpath("//div[@id='processRefDate']"));
				String ReferralDateNSI = ReferralDate.getText().trim();
				Assert.assertEquals(ReferralDateNSI,
						excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Referral Date")).trim());
				System.out.println("Referral Date");

				WebElement ExpectedDate = driver.findElement(By.xpath("//div[@id='processExpectedStartDate']"));
				String ExpectedDateNSI = ExpectedDate.getText().trim();
				Assert.assertEquals(ExpectedDateNSI, excell
						.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Expected Start Date")).trim());
				System.out.println("Expected Start Date");

				WebElement ActualDate = driver.findElement(By.xpath("//div[@id='processStartDate']"));
				String ActualDateNSI = ActualDate.getText().trim();
				Assert.assertEquals(ActualDateNSI,
						excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Actual Start Date")).trim());
				System.out.println("Actual Start Date");

				WebElement Status = driver.findElement(By.xpath("//div[@id='processStageId']/tr-list-label"));
				String StatusNSI = Status.getText().trim();
				Assert.assertEquals(StatusNSI,
						excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Status")).trim());
				System.out.println("Status");

				WebElement StatusDate = driver.findElement(By.xpath("//div[@id='processStageDate']"));
				String StatusDateNSI = StatusDate.getText().trim();
				Assert.assertEquals(StatusDateNSI,
						excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Status Date")).trim());
				System.out.println("Status Date");

				WebElement ExpectedEndDate = driver.findElement(By.xpath("//div[@id='processExpectedEndDate']"));
				String ExpectedEndDateNSI = ExpectedEndDate.getText().trim();
				Assert.assertEquals(ExpectedEndDateNSI,
						excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Expected End Date")).trim());
				System.out.println("Expected End Date");

				WebElement NSINotes = driver.findElement(By.xpath("//div[@class='row']/div[15]/div/div[2]"));
				String Notes = NSINotes.getText().trim();
				Assert.assertEquals(Notes,
						excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
				System.out.println("Notes");

				System.out.println("NSI Verified-CMS");

				count = 0;
				break;

			} catch (NoSuchElementException e) {
				count++;
				break;
			} catch (ElementNotInteractableException e) {
				System.out.println("Element is not in focus " + e.getMessage());
			} catch (StaleElementReferenceException e) {
				System.out.println("The dom is refreshed and element is not found " + e.getMessage());
			} catch (Exception e) {
				Log.error("CMS NSI Page" + e.getMessage());
			}
		}
	}

}