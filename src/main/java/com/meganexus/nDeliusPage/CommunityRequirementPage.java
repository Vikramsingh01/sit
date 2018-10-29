package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class CommunityRequirementPage extends Utils {

	ExcelUtils excell = new ExcelUtils();
	String sheetName = "Community Requirement";

	public void addCommunityRequirement(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		//try {
			waitForElementVisible(By.id("RequirementMainCategory"));
			selectAnElementFromText("RequirementMainCategory", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Requirement")).trim());
			Thread.sleep(6000);
			
			waitForElementVisible(By.id("RequirementSubCategory"));
			selectAnElementFromText("RequirementSubCategory", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Requirement Subtype")).trim());
			Thread.sleep(1000);
			
			try{
				waitForElementVisible(By.id("Length"));
				driver.findElement(By.id("Length")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Length")).trim());
			}catch(Exception e) {
				System.out.println("Length field is not available");
			}
			
			waitForElementVisible(By.id("AddSentenceComponentsForm:requirement:RequirementSentenceDate"));
			driver.findElement(By.id("AddSentenceComponentsForm:requirement:RequirementSentenceDate")).clear();
			driver.findElement(By.id("AddSentenceComponentsForm:requirement:RequirementSentenceDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Imposed (Sentence) Date")).trim());
			Thread.sleep(1000);

			waitForElementVisible(By.id("AddSentenceComponentsForm:requirement:ExpectedStartDate"));
			driver.findElement(By.id("AddSentenceComponentsForm:requirement:ExpectedStartDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Expected Start Date")).trim());
			Thread.sleep(1000);

			waitForElementVisible(By.id("AddSentenceComponentsForm:requirement:ActualStartDate"));
			driver.findElement(By.id("AddSentenceComponentsForm:requirement:ActualStartDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Actual Start Date")).trim());
			Thread.sleep(1000);
			
			waitForElementVisible(By.id("Area"));
			driver.findElement(By.id("Area")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim());
			Thread.sleep(2000);
			
			/*waitForElementVisible(By.id("AddSentenceComponentsForm:requirement:Team"));
			driver.findElement(By.id("AddSentenceComponentsForm:requirement:Team"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Team")).trim());
			Thread.sleep(2000);
			
			waitForElementVisible(By.id("AddSentenceComponentsForm:requirement:Officer"));
			driver.findElement(By.id("AddSentenceComponentsForm:requirement:Officer"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Officer")).trim());
			Thread.sleep(4000);
			*/
			waitForElementVisible(By.id("AddSentenceComponentsForm:requirement:Note"));
			driver.findElement(By.id("AddSentenceComponentsForm:requirement:Note")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@value='Add']")).click();
			Thread.sleep(1000);
			
			waitForElementVisible(By.id("AddSentenceComponentsForm:requirement:requirementsTable:tbody_element"));
			System.out.println("requirement added in table.");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Save']")).click();
			Thread.sleep(2000);
			
			waitForElementVisible(By.xpath("//h1[contains(text(),'Requirement Types')]"));
			System.out.println("requirement added successfully...");

			driver.findElement(By.xpath("//input[@value='Close']")).click();
		/*} catch (NoSuchElementException n) {
			System.out.println("Element not available" + n.getMessage());
		} catch (StaleElementReferenceException e) {
			System.out.println("The dom is refreshed and element is not found" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/

	}
	
	//Navigate to Add Comm Requirement from main Menu
	public void navigateToCommReqmnt() throws InterruptedException
	{ 
		Thread.sleep(2000);
		waitForElementVisible(By.id("linkNavigation3SentenceComponent"));
		driver.findElement(By.id("linkNavigation3SentenceComponent")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("j_id_id11:requirement:j_id_id76pc9")).click();
		Thread.sleep(2000);
	}

}
