package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class AditionalIdentifierPage extends Utils {
	String sheetName = "Additional Identifier";
	ExcelUtils excell = new ExcelUtils();

	public void addAditionalIdentifier(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		waitForElementVisible(By.id("linkNavigation3AdditionalIdentifiers"));
		scrollToClickElement(driver.findElement(By.id("linkNavigation3AdditionalIdentifiers")));
		//driver.findElement(By.id("linkNavigation3AdditionalIdentifiers")).click();
		waitForElementVisible(By.xpath("//h1[text()='Additional Identifiers']"));
		driver.findElement(By.id("additionalIdentifierListForm:insertAddIdent")).click();
		waitForElementVisible(By.xpath("//h1[text()='Add Additional Identifier']"));
		selectAnElementFromText("addForm:addIdentfierId",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Additional IdentifierType")).trim());
		waitForElementVisible(By.id("addForm:descId"));
		driver.findElement(By.id("addForm:descId"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Value")).trim());
		waitForElementVisible(By.id("addForm:j_id_id43"));
		driver.findElement(By.id("addForm:j_id_id43")).click();
		System.out.println("Additional Identifier : Done");
	}

}