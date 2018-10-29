package com.meganexus.cmsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class RegisterINCMSPage extends Utils{
	
	String sheetName = "Registration";
	ExcelUtils excell = new ExcelUtils();
	
	public void AddRegisterIN(String sitNo) throws InterruptedException {
		  
		  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  Thread.sleep(3000);
		  WebElement rLink =driver.findElement(By.xpath("(//button[contains(.,'R')])[1]"));
		  rLink.click();
		  Thread.sleep(6000); 
		  WebElement addRegBtn =driver.findElement(By.xpath("//button[@id='registration_addButton']"));
		  addRegBtn.click();
		  Thread.sleep(10000);
		  selectAnElementFromText("registerTypeId",
					excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Type")).trim());
		  
		 // WebElement ddlRegtype =driver.findElement(By.xpath("//select[@id='registerTypeId']"));
		 // ddlRegtype.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Type")).trim());
		  Thread.sleep(4000);
		  WebElement regDate = driver.findElement(By.xpath("//input[@id='registrationDate']"));
		  regDate.clear();
		  regDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Register Date")).trim());
          Thread.sleep(4000);
		  WebElement regPeriod = driver.findElement(By.xpath("//input[@id='reviewPeriod']"));
		  regPeriod.clear();
		  regPeriod.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Review Period")).trim());

		  WebElement regNextDate = driver.findElement(By.xpath("//input[@id='nextReviewDate']"));
		  regNextDate.clear();
		  regNextDate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Next Review Date")).trim());
		  Thread.sleep(5000);
		  
		  WebElement note = driver.findElement(By.xpath("//textarea[@id='note']"));
		  note.clear();
		  note.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		  Thread.sleep(5000);
	      
		  WebElement btnSubmit = driver.findElement(By.xpath("//button[@id='saveButton']"));
		  btnSubmit.click();
		  Thread.sleep(10000);
		  
		  //WebElement EditBtn =driver.findElement(By.xpath("//button[@id='registration_edit0']"));
		  selectAnElementFromValue("registrationList_itemsPerPage", "10");
		  selectAnElementFromValue("registrationList_itemsPerPage", "50");
	   	// Select PageNo =new  Select (driver.findElement(By.id("registrationList_itemsPerPage")));
		// PageNo.selectByValue("50");
		 //driver.findElement(By.xpath("//option[@value='10']")).click();
		  
		  
		  Thread.sleep(5000);
		//select[@id='registrationList_itemsPerPage']
	
	}	
	
    public void editRegistrationDetails(String sitNo) throws InterruptedException {
		
		System.out.println("Edit reg screen");
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
	//	driver.findElement(By.id("linkNavigation3Registration")).click();
	//	waitForElementVisible(By.xpath("//h1[contains(.,'Register Summary')]"));
		Thread.sleep(4000);	
		WebElement EditBtn =driver.findElement(By.xpath("//button[@id='registration_edit0']"));
		EditBtn.click();
		Thread.sleep(2000);	
		WebElement notesUpdate= driver.findElement(By.xpath("//textarea[@id='note']"));
		
		//WebElement notesUpdate= driver.findElement(By.xpath("//textarea[@id='updateRegistrationForm:NewNotes']"));
		notesUpdate.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Note UPD")).trim());
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//button[@id='saveButton']")).click();	
	}

    

}
