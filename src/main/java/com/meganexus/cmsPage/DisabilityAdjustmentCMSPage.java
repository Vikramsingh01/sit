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

public class DisabilityAdjustmentCMSPage extends Utils {
	
	String sheetName = "Disability Adjustment";
	 ExcelUtils excell = new ExcelUtils();
	 
	 public void ViewDisabilityAdjustment(String sitNo) throws InterruptedException{
		 Log.info("Viewing provision");
			int count = 0;
			while (count < 2) {
				try {
		 int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		 waitForElementVisible(By.xpath("//a[contains(text(),' Accessibility Provision')]"));
		 driver.findElement(By.xpath("//a[contains(text(),' Accessibility Provision')]")).click();
		 waitForElementPresent(By.xpath("//button[@id='provision_view0']"));
		 driver.findElement(By.xpath("//button[@id='provision_view0']")).click();
		 waitForElementPresent(By.xpath("//a[@id='Accessibility Provision']"));
		 Thread.sleep(3000);
		 WebElement StartDateCMS= driver.findElement(By.xpath("(//div[@class='detail-value col-sm-7'])[1]"));
		 String startDate= StartDateCMS.getText().trim();
		 Assert.assertEquals(startDate, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "Start Date")).trim());
		 WebElement EndDateCMS= driver.findElement(By.xpath("//div[@class='row']/div[2]/div[2]"));
		 String endDate= EndDateCMS.getText().trim();
		 Assert.assertEquals(endDate, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "End Date")).trim());
		 WebElement AccessibilityProvisionCMS= driver.findElement(By.xpath("//div[@class='row']/div[3]/div[2]/tr-list-label"));
		 String accessibilityProvision= AccessibilityProvisionCMS.getText().trim();
		 Assert.assertEquals(accessibilityProvision, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "Adjustment")).trim());
		 WebElement NotesCMS= driver.findElement(By.xpath("//div[@class='row']/div[4]/div/div[2]"));
		 String notes=NotesCMS.getText().trim();
		 Assert.assertEquals(notes, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		 
		 Thread.sleep(500);
			driver.findElement(By.xpath("//button[contains(text(),'Accessibility')]")).click();
			Thread.sleep(1000);
		 count=0;
			break;

		} catch (NoSuchElementException e) {
			count++;
			break;
		} catch (ElementNotInteractableException e) {
			System.out.println("Element is not in focus " + e.getMessage());
		} catch (StaleElementReferenceException e) {
			System.out.println("The dom is refreshed and element is not found " + e.getMessage());
		} catch (Exception e) {
			Log.error("Cms Accessibility Adjustment Page"+e.getMessage());

        }
			
	 }
	 
   }
	 
}
