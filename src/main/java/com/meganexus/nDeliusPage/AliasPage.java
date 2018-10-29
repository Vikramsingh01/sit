package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class AliasPage extends Utils {
	
	ExcelUtils excell = new ExcelUtils();
	String sheetName = "Alias";
	
	public void addAlias(String sitNo) throws InterruptedException{
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		
		waitForElementVisible(By.id("linkNavigation3Alias"));
		driver.findElement(By.id("linkNavigation3Alias")).click();
		
		waitForElementVisible(By.id("aliasListForm:j_id_id76"));
		driver.findElement(By.id("aliasListForm:j_id_id76")).click();
		
		waitForElementVisible(By.xpath("//h1[contains(text(),'Add Alias')]"));
		
		driver.findElement(By.id("addAliasForm:FirstName")).sendKeys(
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "FirstName")).trim());
		
		driver.findElement(By.id("addAliasForm:SecondName")).sendKeys(
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "SecondName")).trim());
		
		driver.findElement(By.id("addAliasForm:ThirdName")).sendKeys(
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "ThirdName")).trim());
		
		driver.findElement(By.id("addAliasForm:Surname")).sendKeys(
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Surname")).trim());
		
		driver.findElement(By.id("addAliasForm:DateOfBirth")).sendKeys(
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "DateOfBirth")).trim());
		
		selectAnElementFromText("addAliasForm:Gender",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Gender")).trim());
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);
		scrollToClickElement(driver.findElement(By.id("addAliasForm:j_id_id91")));
		Thread.sleep(3000);
		
		System.out.println("Alias : Done");
	}
	
	
	
}
