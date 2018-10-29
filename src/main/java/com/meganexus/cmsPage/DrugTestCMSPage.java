package com.meganexus.cmsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class DrugTestCMSPage extends Utils{
	String sheetName = "Drug Test";
	ExcelUtils excell = new ExcelUtils();
		
    public void addDrugTest(String sitNo) throws InterruptedException {
	
	    Thread.sleep(5000);
	    waitForElementVisible(By.xpath(".//*[@id='drugTest_addButton']"));
       driver.findElement(By.xpath(".//*[@id='drugTest_addButton']")).click();
       Thread.sleep(3000);

	  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
	  Thread.sleep(5000);
	   driver.findElement(By.xpath(".//*[@id='dateOfTest']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Date of Test")).trim());
		 Thread.sleep(3000);

		 driver.findElement(By.xpath(".//*[@id='testedBy']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Tested by")).trim());
			 Thread.sleep(3000);

		 selectAnElementFromText("offenderComplianceYesNoId",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offender Complied")).trim());
		Thread.sleep(3000);
		  
		  driver.findElement(By.id("note")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		  Thread.sleep(5000);
		  
		  scrollToElement(driver.findElement(By.id("admittedUseYesNoId0")));	
		  selectAnElementFromIndexNoX("(//select[@id='admittedUseYesNoId0'])[1]",2);
	     Thread.sleep(3000);
	     selectAnElementFromIndexNoX("(//select[@id='testResultId0'])[1]",3);
	     Thread.sleep(3000);
	     selectAnElementFromIndexNoX("(//select[@id='agreedYesNoId0'])[1]",2);
	     Thread.sleep(6000);
	     scrollToClickElement(driver.findElement(By.xpath(".//*[contains(text(),'Heroin')]/parent::td/following-sibling::td[1]//select[@id='@id='admittedUseYesNoId1']")));
     //selectAnElementFromIndexNoX("(//select[@id='admittedUseYesNoId'])[2]",2); 
	     Thread.sleep(3000);
		  selectAnElementFromIndexNoX(".//*[contains(text(),'Heroin')]/parent::td/following-sibling::td[1]//select[@id='admittedUseYesNoId1']",2);
		  selectAnElementFromIndexNoX(".//*[contains(text(),'Heroin')]/parent::td/following-sibling::td[1]//select[@id='admittedUseYesNoId1']",2);

		  Thread.sleep(3000);
		  selectAnElementFromIndexNoX(".//*[contains(text(),'Heroin')]/parent::td/following-sibling::td[2]//select[@id='testResultId1']",2);
		     selectAnElementFromIndexNoX(".//*[contains(text(),'Heroin')]/parent::td/following-sibling::td[3]//select[@id='agreedYesNoId1']",1);
		     Thread.sleep(5000);
		     selectAnElementFromIndexNoX(".//*[contains(text(),'Methadone')]/parent::td/following-sibling::td[1]//select[@id='admittedUseYesNoId2']",1);
		     Thread.sleep(3000);
		     selectAnElementFromIndexNoX(".//*[contains(text(),'Methadone')]/parent::td/following-sibling::td[2]//select[@id='testResultId2']",1);
		     Thread.sleep(3000);
		     selectAnElementFromIndexNoX(".//*[contains(text(),'Methadone')]/parent::td/following-sibling::td[3]//select[@id='agreedYesNoId2']",1);
		     Thread.sleep(3000);
		
		     waitForElementVisible(By.xpath(".//*[@id='saveButton']"));
		  driver.findElement(By.xpath(".//*[@id='saveButton']")).click();
		  Thread.sleep(5000);
		  waitForElementVisible(By.xpath("(//a[contains(.,'   Drug Test ')])[2]"));
    	   driver.findElement(By.xpath("(//a[contains(.,'   Drug Test ')])[2]")).click();
        Thread.sleep(5000);
 	   scrollToElement(driver.findElement(By.id("drugTestList_itemsPerPage")));
		   selectAnElementFromValue("drugTestList_itemsPerPage", "10");
		   selectAnElementFromValue("drugTestList_itemsPerPage", "10");
		  Thread.sleep(5000);
  
  
}	

//Update Drug Test

public void updateDrugTest(String sitNo) throws InterruptedException {
	

	/*waitForElementVisible(By.xpath((//a[contains(.,"   Drug Test ")])[2]));
	   driver.findElement(By.xpath((//a[contains(.,"   Drug Test ")])[2])).click();
	   Thread.sleep(3000);*/
	waitForElementVisible(By.xpath(".//*[@id='drugTest_edit0']"));
	   driver.findElement(By.xpath(".//*[@id='drugTest_edit0']")).click();
	   Thread.sleep(3000);
	   
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		 Thread.sleep(3000);
		 waitForElementVisible(By.id("offenderComplianceYesNoId"));
	   selectAnElementFromText("offenderComplianceYesNoId",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offender Complied")).trim());
		Thread.sleep(3000);
		selectAnElementFromIndexNoX("(//select[@id='admittedUseYesNoId0'])[1]",1);
	     Thread.sleep(3000);
	     selectAnElementFromIndexNoX("(//select[@id='testResultId0'])[1]",1);
	     Thread.sleep(3000);
	     selectAnElementFromIndexNoX("(//select[@id='agreedYesNoId0'])[1]",1);
	     Thread.sleep(8000);
	     scrollToElement(driver.findElement(By.xpath(".//*[contains(text(),'Heroin')]/parent::td/following-sibling::td[1]//select[@id='admittedUseYesNoId1']")));
		Thread.sleep(2000);
	     selectAnElementFromIndexNoX(".//*[contains(text(),'Heroin')]/parent::td/following-sibling::td[1]//select[@id='admittedUseYesNoId'1]",1);

		  selectAnElementFromIndexNoX(".//*[contains(text(),'Heroin')]/parent::td/following-sibling::td[1]//select[@id='admittedUseYesNoId1']",1);
		  Thread.sleep(3000);
		  selectAnElementFromIndexNoX(".//*[contains(text(),'Heroin')]/parent::td/following-sibling::td[2]//select[@id='testResultId1']",3);
			Thread.sleep(3000);
			selectAnElementFromIndexNoX(".//*[contains(text(),'Heroin')]/parent::td/following-sibling::td[3]//select[@id='agreedYesNoId1']",2);
			 Thread.sleep(8000);
		     selectAnElementFromIndexNoX(".//*[contains(text(),'Methadone')]/parent::td/following-sibling::td[1]//select[@id='admittedUseYesNoId2']",2);
			 Thread.sleep(3000);
			 selectAnElementFromIndexNoX(".//*[contains(text(),'Methadone')]/parent::td/following-sibling::td[2]//select[@id='testResultId2']",2);
			  Thread.sleep(3000);
			  selectAnElementFromIndexNoX(".//*[contains(text(),'Methadone')]/parent::td/following-sibling::td[3]//select[@id='agreedYesNoId2']",2);
			   Thread.sleep(3000);
			    waitForElementVisible(By.xpath(".//*[@id='saveButton']"));
			  driver.findElement(By.xpath(".//*[@id='saveButton']")).click();
			  Thread.sleep(5000);
			  scrollToElement(driver.findElement(By.xpath("(//a[contains(.,'   Drug Test ')])[2]")));
				Thread.sleep(2000);
		      waitForElementVisible(By.xpath("(//a[contains(.,'   Drug Test ')])[2]"));
	     	   driver.findElement(By.xpath("(//a[contains(.,'   Drug Test ')])[2]")).click();
	     	  Thread.sleep(5000);
	    	   scrollToElement(driver.findElement(By.id("drugTestList_itemsPerPage")));
	   		   selectAnElementFromValue("drugTestList_itemsPerPage", "20");
	   		   selectAnElementFromValue("drugTestList_itemsPerPage", "20");
      
	}

//Delete Drug Test
public void clickDeleteDrugResultBtn() throws InterruptedException {
	   
	/*Thread.sleep(3000);

	 waitForElementVisible(By.xpath("(//a[contains(.,'   Drug Test ')])[2]"));
	     	   driver.findElement(By.xpath("(//a[contains(.,'   Drug Test ')])[2]")).click();*/
	   Thread.sleep(3000);
	   scrollToElement(driver.findElement(By.id("drugTest_delete0")));
	     waitForElementVisible(By.xpath("//button[@id='drugTest_delete0']"));
	     driver.findElement(By.xpath("//button[@id='drugTest_delete0']")).click();
		  Thread.sleep(3000);
		  waitForElementVisible(By.xpath("//button[contains(text(),'Ok')]"));
		  driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		   Thread.sleep(5000);
		   selectAnElementFromValue("drugTestList_itemsPerPage", "10");
		   selectAnElementFromValue("drugTestList_itemsPerPage", "10");
		   Thread.sleep(5000);

   }
}
