package com.meganexus.nDeliusPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class PersonalContactPage extends Utils {
	String sheetName = "Personal Contact";
	ExcelUtils excell = new ExcelUtils();
	
	public void addpersonalcontact (String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		
		driver.findElement(By.id("linkNavigation3PersonalContact")).click();		
		waitForElementVisible(By.xpath("//input[@value='Add Personal Contact']"));
		driver.findElement(By.id("j_id_id11:j_id_id71")).click();
		
		selectAnElementFromText("addPersonalContactForm:Relationship",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Relationship Type")).trim());
		
		waitForElementVisible(By.id("addPersonalContactForm:Title"));
		driver.findElement(By.id("addPersonalContactForm:Title")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Title")).trim());

                waitForElementVisible(By.id("addPersonalContactForm:FirstName"));
                driver.findElement(By.id("addPersonalContactForm:FirstName"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "First Name")).trim());
				
		waitForElementVisible(By.id("addPersonalContactForm:OtherNames"));
                driver.findElement(By.id("addPersonalContactForm:OtherNames"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "other Name")).trim());
		
		
		waitForElementVisible(By.id("addPersonalContactForm:Surname"));
                driver.findElement(By.id("addPersonalContactForm:Surname"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Surname")).trim());
				
		waitForElementVisible(By.id("addPersonalContactForm:PreviousName"));
                driver.findElement(By.id("addPersonalContactForm:PreviousName"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Previous Surname")).trim());
		
		waitForElementVisible(By.id("addPersonalContactForm:RelationshipToOffender"));
                driver.findElement(By.id("addPersonalContactForm:RelationshipToOffender"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Relationship To Offender")).trim());
				
		waitForElementVisible(By.id("addPersonalContactForm:Gender"));
                driver.findElement(By.id("addPersonalContactForm:Gender")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Gender")).trim());	
				
		waitForElementVisible(By.id("addPersonalContactForm:BuildingName"));
                driver.findElement(By.id("addPersonalContactForm:BuildingName")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Building Name")).trim());			
				
		waitForElementVisible(By.id("addPersonalContactForm:HouseNumber"));
                driver.findElement(By.id("addPersonalContactForm:HouseNumber")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "House Number")).trim());	
				
		waitForElementVisible(By.id("addPersonalContactForm:StreetName"));
                driver.findElement(By.id("addPersonalContactForm:StreetName")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Street Name")).trim());

		waitForElementVisible(By.id("addPersonalContactForm:District"));
                driver.findElement(By.id("addPersonalContactForm:District")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "District")).trim());	
		
		waitForElementVisible(By.id("addPersonalContactForm:TownCity"));
                driver.findElement(By.id("addPersonalContactForm:TownCity")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Town/City")).trim());	

		waitForElementVisible(By.id("addPersonalContactForm:County"));
                driver.findElement(By.id("addPersonalContactForm:County")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "County")).trim());	

		waitForElementVisible(By.id("addPersonalContactForm:Postcode"));
                driver.findElement(By.id("addPersonalContactForm:Postcode")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Postcode")).trim());	

		waitForElementVisible(By.id("addPersonalContactForm:MobileNumber"));
                driver.findElement(By.id("addPersonalContactForm:MobileNumber")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Mobile Number")).trim());

		waitForElementVisible(By.id("addPersonalContactForm:TelephoneNumber"));
                driver.findElement(By.id("addPersonalContactForm:TelephoneNumber")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Telephone Number")).trim());			
				
		waitForElementVisible(By.id("addPersonalContactForm:EmailAddress"));
                driver.findElement(By.id("addPersonalContactForm:EmailAddress")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Email Address")).trim());	
		
                Thread.sleep(1000);
                driver.findElement(By.id("addPersonalContactForm:StartDate")).clear();
        waitForElementVisible(By.id("addPersonalContactForm:StartDate"));
                driver.findElement(By.id("addPersonalContactForm:StartDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Start Date")).trim());
				
		waitForElementVisible(By.id("addPersonalContactForm:EndDate"));
                driver.findElement(By.id("addPersonalContactForm:EndDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "End Date")).trim());	

		waitForElementVisible(By.id("addPersonalContactForm:Notes"));
                driver.findElement(By.id("addPersonalContactForm:Notes")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());				
				
		driver.findElement(By.id("addPersonalContactForm:j_id_id192")).click();	
		
		System.out.println("Personal Contact : Done");
		
	

	
	}
}
