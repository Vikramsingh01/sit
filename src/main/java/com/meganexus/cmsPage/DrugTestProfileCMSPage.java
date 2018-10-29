package com.meganexus.cmsPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class DrugTestProfileCMSPage extends Utils{
	String sheetName = "Drug Test Profile";
	ExcelUtils excell = new ExcelUtils();
	
public void addDrugTestProfile(String sitNo) throws InterruptedException {

	waitForElementVisible(By.xpath(".//*[@id='drugTestProfile_addButton']"));
	driver.findElement(By.xpath(".//*[@id='drugTestProfile_addButton']")).click();
	Thread.sleep(3000);
    int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
    Thread.sleep(3000);
		  
	 driver.findElement(By.id("dateAssessed"))
    .sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Date Assessed")).trim());
			 Thread.sleep(3000);
	 selectAnElementFromIndexNoX("//select[@id='teamId']",2);
			 Thread.sleep(1000);
			 selectAnElementFromIndexNoX("//select[@id='officeTeamId']",2);
			 Thread.sleep(1000);
			 selectAnElementFromIndexNoX("//select[@id='officerId']",2);
			 Thread.sleep(1000);
			
			selectAnElementFromText("mainDrugId",
			excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Main Drug")).trim());
			Thread.sleep(1000);
					
			 selectAnElementFromText("addMainDrugYesNoId",
			excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Add Main Drug")).trim());
		      Thread.sleep(1000);
		      
		      driver.findElement(By.id("estimatedWeekelyCost"))
				.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Estimated weekly cost")).trim());
			  Thread.sleep(3000);
			
				scrollToClickElement(driver.findElement(By.id("drugToBeTestedForId")));
		      selectAnElementFromText("drugToBeTestedForId",
		  		excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Drug To Be Tested 1")).trim());
		  		Thread.sleep(1000);
		  		 waitForElementVisible(By.xpath(".//*[@id='addToListButton']"));
				  driver.findElement(By.id("addToListButton")).click();
			    Thread.sleep(1000);
		  		selectAnElementFromText("drugToBeTestedForId",
				 excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Drug To Be Tested 2")).trim());
				 Thread.sleep(1000);
				 waitForElementVisible(By.xpath(".//*[@id='addToListButton']"));
			  driver.findElement(By.id("addToListButton")).click();
				Thread.sleep(3000);
				 waitForElementVisible(By.xpath(".//*[@id='saveButton']"));
			
			  driver.findElement(By.xpath(".//*[@id='saveButton']")).click();
	  
		  
   }	
	

}
