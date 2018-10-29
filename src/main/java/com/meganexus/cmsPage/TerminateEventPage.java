package com.meganexus.cmsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class TerminateEventPage extends Utils {
	String sheetName = "TerminateEvent";
	ExcelUtils excell = new ExcelUtils();
	
	public void terminateEvent(String sitNo)throws InterruptedException{
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('Terminate Event').focus();");
		((JavascriptExecutor)driver).executeScript("window.focus();");
		driver.findElement(By.xpath("//a[contains(text(),'Terminate Event')]")).click();
		Thread.sleep(2000);
		//waitForElementVisible(By.id("terminationDate"));
		driver.findElement(By.id("terminationDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Termination Date")).trim());
		Thread.sleep(1000);
		selectAnElementFromText("terminationReasonId",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Reason")).trim());
		Thread.sleep(1000);		
		waitForElementVisible(By.id("note"));
		driver.findElement(By.id("note")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		Thread.sleep(2000);
		driver.findElement(By.id("saveButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(), 'Ok')]")).click();
		Thread.sleep(3000);
		
		
	}

	
}
