package com.meganexus.nDeliusPage;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class AddOffenderPage extends Utils {
	ExcelUtils excell = new ExcelUtils();
	String sheetName = "OffenderDetails";

	public void addOffender(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		Thread.sleep(3000);
		waitForElementVisible(By.xpath("//input[@value='Add Offender']"));
		scrollToClickElement(driver.findElement(By.xpath("//input[@value='Add Offender']")));
		waitForElementVisible(By.id("addOffenderForm:Trust"));
		selectAnElementFromIndexNo("addOffenderForm:Trust", 2);
		waitForElementVisible(By.id("addOffenderForm:Title"));
		selectAnElementFromText("addOffenderForm:Title",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Title")).trim());
		waitForElementVisible(By.id("addOffenderForm:FirstName"));
		driver.findElement(By.id("addOffenderForm:FirstName")).clear();
		waitForElementVisible(By.id("addOffenderForm:FirstName"));
		driver.findElement(By.id("addOffenderForm:FirstName"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "First Name")).trim());

		if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Second Name")).trim().length() > 0) {
			waitForElementVisible(By.id("addOffenderForm:SecondName"));
			driver.findElement(By.id("addOffenderForm:SecondName"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Second Name")).trim());
		}
		if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Third Name")).trim().length() > 0) {
			waitForElementVisible(By.id("addOffenderForm:ThirdName"));
			driver.findElement(By.id("addOffenderForm:ThirdName"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Third Name")).trim());
		}
		waitForElementVisible(By.id("addOffenderForm:Surname"));
		driver.findElement(By.id("addOffenderForm:Surname")).clear();
		driver.findElement(By.id("addOffenderForm:Surname"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Surname")).trim());

		if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Previous Name")).trim().length() > 0) {
			waitForElementVisible(By.id("addOffenderForm:PreviousSurname"));
			driver.findElement(By.id("addOffenderForm:PreviousSurname")).sendKeys(
					excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Previous Name")).trim());
		}

		waitForElementVisible(By.id("addOffenderForm:Gender"));
		selectAnElementFromText("addOffenderForm:Gender",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Gender")).trim());
		waitForElementVisible(By.id("DateOfBirth"));
		driver.findElement(By.id("DateOfBirth"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Date Of Birth")).trim());
		waitForElementVisible(By.id("addOffenderForm:Notes"));
		driver.findElement(By.id("addOffenderForm:Notes"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		// Contact details

		if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Mobile  Number")).trim().length() > 0) {
			// scrollToElement(driver.findElement(By.id("Mobile")));
			waitForElementVisible(By.id("Mobile"));
			Thread.sleep(2000);
			driver.findElement(By.id("Mobile")).sendKeys(
					excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Mobile  Number")).trim());
		}

		Thread.sleep(3000);
		if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "SMS Contact")).trim().length() > 0) {
			// scrollToElement(driver.findElement(By.id("SMS")));
			waitForElementVisible(By.id("SMS"));
			Thread.sleep(1000);
			selectAnElementFromText("SMS",
					excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "SMS Contact")).trim());
		}
		if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Telephone Number")).trim()
				.length() > 0) {
			// scrollToElement(driver.findElement(By.id("addOffenderForm:Telephone")));
			waitForElementVisible(By.id("addOffenderForm:Telephone"));
			Thread.sleep(1000);
			driver.findElement(By.id("addOffenderForm:Telephone")).sendKeys(
					excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Telephone Number")).trim());
		}
		if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Email Address")).trim().length() > 0) {
			waitForElementVisible(By.id("addOffenderForm:Email"));
			Thread.sleep(1000);
			driver.findElement(By.id("addOffenderForm:Email")).sendKeys(
					excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Email Address")).trim());
		}
		// Personal Identifiers
		if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "PNC Number")).trim().length() > 0) {
			selectAnElementFromText("addOffenderForm:identifierType", "PNC");
			driver.findElement(By.id("addOffenderForm:identifierValue"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "PNC Number")).trim());
			driver.findElement(By.xpath("//input[@value='Add/Update']")).click();
		}
		if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "CRO Number")).trim().length() > 0) {
			selectAnElementFromText("addOffenderForm:identifierType", "CRO");

			driver.findElement(By.id("addOffenderForm:identifierValue")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("addOffenderForm:identifierValue"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "CRO Number")).trim());
			driver.findElement(By.xpath("//input[@value='Add/Update']")).click();
		}
		if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "NOMS Number")).trim().length() > 0) {
			selectAnElementFromText("addOffenderForm:identifierType", "NOMS");
			driver.findElement(By.id("addOffenderForm:identifierValue")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("addOffenderForm:identifierValue"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "NOMS Number")).trim());
			driver.findElement(By.xpath("//input[@value='Add/Update']")).click();
		}
		if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "NI Number")).trim().length() > 0) {
			selectAnElementFromText("addOffenderForm:identifierType", "NI");
			driver.findElement(By.id("addOffenderForm:identifierValue")).clear();
			Thread.sleep(2000);
			driver.findElement(By.id("addOffenderForm:identifierValue"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "NI Number")).trim());
			driver.findElement(By.xpath("//input[@value='Add/Update']")).click();
		}

		waitForElementVisible(By.id("addOffenderForm:j_id_id183"));
		scrollToElement(driver.findElement(By.id("addOffenderForm:j_id_id183")));
		driver.findElement(By.id("addOffenderForm:j_id_id183")).click();
		// scrollToClickElement(driver.findElement(By.id("addOffenderForm:j_id_id183")));

		try {
			if (driver.findElement(By.id("addOffenderForm:j_id_id184")).isDisplayed() == true) {
				driver.findElement(By.id("addOffenderForm:j_id_id184")).click();
			}
		} catch (Exception e) {
			Log.error("Unable to locate element");
		}

		saveCRN_NO(sheetName, rowNum);

	}

	private void saveCRN_NO(String sheetName, int rowNum) {
		try {
			Log.info("Storing crn no to excell sheet");
			String crnNo = driver.findElement(By.id("SearchForm:crn")).getText().trim();
			int cellNum = excell.getCellNumber(sheetName, "CRN NO");
			excell.writeExcellFile(sheetName, rowNum, cellNum, crnNo);

		} catch (NoSuchElementException e) {
			Log.error("unable to get the crn from nDelius");
		}

	}

}
