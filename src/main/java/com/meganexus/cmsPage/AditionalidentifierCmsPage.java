package com.meganexus.cmsPage;

import java.util.NoSuchElementException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class AditionalidentifierCmsPage extends Utils {
	
	String sheetName = "Additional Identifier";
	ExcelUtils excell = new ExcelUtils();

	public void verifyAditionalIdentifier(String sitNo) throws InterruptedException {
		Log.info("Viewing additional identifier");
		int count = 0;
		while (count < 2) {
			try {
				int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
				waitForElementVisible(By.xpath("//button[contains(.,'Identifiers')]"));
				driver.findElement(By.xpath("//button[contains(.,'Identifiers')]")).click();
				waitForElementVisible(By.xpath("//a[contains(text(),'Additional Identifiers')]"));
				scrollToClickElement(driver.findElement(By.xpath("//a[contains(text(),'Additional Identifiers')]")));
				waitForElementVisible(By.id("additionalIdentifier_view0"));
				scrollToClickElement(driver.findElement(By.id("additionalIdentifier_view0")));
			
				waitForElementPresent(By.xpath("//a[contains(text(),'Additional Identifier')]"));
				WebElement IdentifierTypeCMS = driver
						.findElement(By.xpath("//div[@class='row']/div[1]/div[2]/tr-list-label"));
				String identifierType = IdentifierTypeCMS.getText().trim();
				Assert.assertEquals(identifierType, excell.getData(sheetName, rowNum,
						excell.getCellNumber(sheetName, "Additional IdentifierType")).trim());
				
				System.out.println("Identifier type");
				
				WebElement IdentifierValueCMS = driver
						.findElement(By.xpath("//div[@class='row']/div[2]/div[2]"));
				String IdentifierValue = IdentifierValueCMS.getText().trim();
				Assert.assertEquals(IdentifierValue,
						excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Value")).trim());
				
				System.out.println("Identifier value");
				
				driver.findElement(By.xpath("//button[contains(text(),'Profile')]")).click();
				Thread.sleep(3000);
				
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
				Log.error("Cms Additional Identifier Page"+e.getMessage());
			}
		}
	}

}
