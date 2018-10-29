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

public class AliasCMSPage extends Utils  {
	
	String sheetName = "Alias";
	ExcelUtils excell = new ExcelUtils();

	public void viewAlias(String sitNo) throws InterruptedException {
		
		Log.info("Viewing Alias");
		int count = 0;
		while (count < 2) {
			try {
		int rowNum = excell.getRowNumsWithStatusToDo(sheetName, "SIT NO", sitNo);
		waitForElementVisible(By.xpath("//button[contains(.,'Identifiers')]"));
		driver.findElement(By.xpath("//button[contains(.,'Identifiers')]")).click();
		
		waitForElementPresent(By.xpath("//a[contains(text(),'Alias')]"));
		scrollToClickElement(driver.findElement(By.xpath("//a[contains(text(),'Alias')]")));
		
		Thread.sleep(2000);
	    WebElement FirstName = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]"));
		String FirstNameAlias = FirstName.getText().trim();
		Assert.assertEquals(FirstNameAlias, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "FirstName")).trim());
		
	    WebElement SecondName = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]"));
			String SecondNameAlias = SecondName.getText().trim();
			Assert.assertEquals(SecondNameAlias, excell.getData(sheetName, rowNum,
						excell.getCellNumber(sheetName, "SecondName")).trim());
			
		WebElement ThirdName = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]"));
		String ThirdNameAlias = ThirdName.getText().trim();
		Assert.assertEquals(ThirdNameAlias, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "ThirdName")).trim());
		
		WebElement FamilyName = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[4]"));
		String FamilyNameAlias = FamilyName.getText().trim();
		System.out.println(FamilyNameAlias);
		Assert.assertEquals(FamilyNameAlias, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Surname")).trim());
		
		
		WebElement DOB = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]"));
		String DOBAlias = DOB.getText().trim();
		Assert.assertEquals(DOBAlias, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "DateOfBirth")).trim());
		
		WebElement Gender = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[6]"));
		String GenderAlias = Gender.getText().trim();
		Assert.assertEquals(GenderAlias, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Gender")).trim());
		
		System.out.println("Alias Verified -CMS");
		 count=0;
			break;

		} catch (NoSuchElementException e) {
			count++;
			break;
		} catch (ElementNotInteractableException e) {
			System.out.println("Element is not in focus " + e.getMessage());
		} catch (AssertionError e) {
			System.out.println("The dom is refreshed and element is not found " + e.getMessage());
		} catch (Exception e) {
			Log.error("CMS Alias Page"+e.getMessage());
		}
	}
}

}