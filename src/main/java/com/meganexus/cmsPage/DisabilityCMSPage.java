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

public class DisabilityCMSPage extends Utils {
	
	String sheetName = "Disability";
	 ExcelUtils excell = new ExcelUtils();
	 
	 public void ViewDisability(String sitNo) throws InterruptedException{
		 Log.info("Viewing accessibility");
			int count = 0;
			while (count < 2) {
				try {
		 int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		 waitForElementVisible(By.xpath("//button[contains(.,'Accessibility')]"));
		 driver.findElement(By.xpath("//button[contains(text(),'Accessibility')]")).click();
		 waitForElementVisible(By.xpath("//a[contains(text(),'Accessibility')]"));
		 waitForElementVisible(By.xpath("//button[@id='offenderDisability_view0']"));
		 driver.findElement(By.xpath("//button[@id='offenderDisability_view0']")).click();
		 waitForElementVisible(By.xpath("//div[@class='row']/div[1]/div[2]"));
		 Thread.sleep(3000);
		 WebElement AccessibilityTypeCMS= driver.findElement(By.xpath("//div[@title='Accessibility Type ']/following::tr-list-label"));
		 String accessibilityType= AccessibilityTypeCMS.getText().trim();
		 System.out.println(accessibilityType);
		// System.out.println(excell.getData(sheetName, rowNum,excell.getCellNumber(sheetName, "Disability")).trim());
		 Assert.assertEquals(accessibilityType, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "Disability")).trim());
	
		 
		 WebElement StartDateCMS= driver.findElement(By.xpath("//div[@class='row']/div[2]/div[2]"));
		 String startDate= StartDateCMS.getText().trim();
		 Assert.assertEquals(startDate, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "Start Date")).trim());
		 System.out.println("Disability Start date");
		 WebElement NotesCMS= driver.findElement(By.xpath("//div[@class='row']/div[4]/div/div[2]"));
		 String notes=NotesCMS.getText().trim();
		 Assert.assertEquals(notes, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		 
		 System.out.println("Disability Notes");
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
			Log.error("Cms Disability Page"+e.getMessage());
		}
	}
}

}

