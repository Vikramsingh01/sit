package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class DrugTestProfilePage extends Utils{
	String sheetName = "Drug Test Profile";
	ExcelUtils excell = new ExcelUtils();
	

	
public void addDrugTestProfile(String sitNo) throws InterruptedException {
	int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);

	waitForElementVisible(By.xpath(".//*[@id='j_id_id11:j_id_id64']"));
	driver.findElement(By.xpath(".//*[@id='j_id_id11:j_id_id64']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@Value='Add Drug Test Profile']")).click();
	Thread.sleep(1000);
		
		  
	driver.findElement(By.id("AssessmentDate"))
    .sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Date Assessed")).trim());
	 Thread.sleep(2000);

	selectAnElementFromIndexNoX("//select[@id='Trust']",2);
	 Thread.sleep(1000);
	 selectAnElementFromIndexNoX("//select[@id='Team']",3);
	 Thread.sleep(1000);
	 selectAnElementFromIndexNoX("//select[@id='Staff']",1);
	 Thread.sleep(1000);
	
	selectAnElementFromText("MainDrugs",
	excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Main Drug")).trim());
	Thread.sleep(2000);
			
	/* selectAnElementFromText("AddDrugProfile:IncludeInMainDrugs",
	excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Add Main Drug to test list")).trim());
      Thread.sleep(2000);*/
      
      driver.findElement(By.xpath(".//*[@id='EstimatedCost']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Estimated weekly cost")).trim());
	  Thread.sleep(2000);
	
	  
      selectAnElementFromText("AddDrugProfile:DrugsToBeTested",
  		excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Drug To Be Tested 1")).trim());
  		Thread.sleep(2000);
  		
		  
	  driver.findElement(By.id("AddDrugProfile:j_id_id92")).click();
		Thread.sleep(2000);
			
	  driver.findElement(By.xpath("//input[@Value='Save']")).click();

	  Thread.sleep(2000);
  
  }	
	

}
