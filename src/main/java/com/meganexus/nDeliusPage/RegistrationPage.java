package com.meganexus.nDeliusPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class RegistrationPage extends Utils{
	
	String sheetName = "Registration";
	ExcelUtils excell = new ExcelUtils();
    
	/*@FindBy(how =How.ID, using ="linkNavigation3Registration")
	WebElement lnk;*/
	 

	public void addRegistrationDetails(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		driver.findElement(By.id("linkNavigation3Registration")).click();
		waitForElementVisible(By.xpath("//h1[contains(.,'Register Summary')]"));
		driver.findElement(By.id("registrationListForm:j_id_id101")).click();
		waitForElementVisible(By.xpath("//h1[contains(.,'Add Registration')]"));
		Thread.sleep(2000);
		selectAnElementFromText("addRegistrationForm:Trust",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Registering Officer's Provider")).trim());
		//driver.findElement(By.id("addRegistrationForm:Trust")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Registering Officer's Provider")).trim());
		waitForElementVisible(By.id("addRegistrationForm:RegisterType"));
		Thread.sleep(2000);
		selectAnElementFromText("addRegistrationForm:RegisterType",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Type")).trim());
		//driver.findElement(By.xpath("//select[@id='addRegistrationForm:RegisterType']|[@name='addRegistrationForm:RegisterType']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Type")).trim());
		
		WebElement regDate = driver.findElement(By.id("RegistrationDate"));
		regDate.clear();
		regDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Date")).trim());
		Thread.sleep(1000);
		WebElement regPeriod =driver.findElement(By.xpath("//input[@id='ReviewPeriod']"));
		regPeriod.clear();
		regPeriod.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Review Period")).trim());
		Thread.sleep(1000);
		WebElement regNextDate =driver.findElement(By.xpath("//input[@id='NextReviewDate']"));
		regNextDate.clear();
		regNextDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Next Review Date")).trim());
		Thread.sleep(2000);
	    WebElement	reTime= driver.findElement(By.id("ReviewTime"));
	    reTime.clear();
	    reTime.sendKeys("05:20");
		Thread.sleep(6000);
		selectAnElementFromText("addRegistrationForm:Team",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Registering Officer's Team")).trim());
		Thread.sleep(6000);
		selectAnElementFromText("addRegistrationForm:Staff",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Registering Officer")).trim());
		//driver.findElement(By.xpath("//select[@id='addRegistrationForm:Team']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Registering Officer's Team")));
	//	Thread.sleep(6000);
	//	driver.findElement(By.xpath("//select[@id='addRegistrationForm:Staff']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Registering Officer")));
	  
		
		/*selectAnElementFromText("addRegistrationForm:Team",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Registering Officer's Team")));
		selectAnElementFromText("addRegistrationForm:Staff",
				excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Registering Officer")));
		*/
		driver.findElement(By.id("addRegistrationForm:Notes"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		Thread.sleep(4000);	
		//waitForElementVisible(By.id("addRegistrationForm:j_id_id123"));
		driver.findElement(By.id("addRegistrationForm:j_id_id132")).click();
		Thread.sleep(2000);	
		//waitForElementVisible(By.xpath("//h1[contains(.,'Add Registration')]"));
		System.out.println("Registration : Done");
			

	}

	public void editRegistrationDetails(String sitNo) throws InterruptedException {
		
		System.out.println("Edit reg screen");
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		driver.findElement(By.id("linkNavigation3Registration")).click();
		Thread.sleep(5000);	
		waitForElementVisible(By.xpath("//h1[contains(.,'Register Summary')]"));
		
		Thread.sleep(8000);	
		waitForElementVisible(By.xpath(".//*[@id='registrationListForm:registrationTable:tbody_element']/tr/td[7]/a"));
		Thread.sleep(5000);	
		driver.findElement(By.xpath(".//*[@id='registrationListForm:registrationTable:tbody_element']/tr/td[7]/a")).click();
		Thread.sleep(5000);	
		//waitForElementVisible(By.xpath("//textarea[@id='updateRegistrationForm:NewNotes'][@name='updateRegistrationForm:NewNotes']"));
	    WebElement notesUpdate= driver.findElement(By.xpath("//textarea[@id='updateRegistrationForm:NewNotes']"));
        notesUpdate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Note UPD")).trim());
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//input[@value='Save']")).click();	
	}

}
