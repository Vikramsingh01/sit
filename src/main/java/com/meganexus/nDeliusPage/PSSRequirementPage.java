package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;

public class PSSRequirementPage extends ThroughCarePage  {
	ExcelUtils excell = new ExcelUtils();
	String sheetName = "PSSR";
	
	public void addPSSRequirement(String sitNo) throws Exception {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		
		driver.findElement(By.linkText("Supervision Requirements")).click();
		Thread.sleep(200);
		
		driver.findElement(By.id("j_id_id11:j_id_id84")).click();
		Thread.sleep(1000);
		selectAnElementFromText("RequirementMainCategory",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Requirement Main Type")).trim());
		Thread.sleep(800);
		selectAnElementFromText("RequirementSubCategory",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Requirement Sub Type")).trim());
	    Thread.sleep(200);
	    driver.findElement(By.id("PSSForm:RequirementSentenceDate")).clear();
		driver.findElement(By.id("PSSForm:RequirementSentenceDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Imposed (Release Date) Date")).trim());
	  	Thread.sleep(200);
	  	selectAnElementFromText("Area",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim());    
	    Thread.sleep(200);
	  	driver.findElement(By.id("Note")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Note")).trim());
	  	Thread.sleep(1000);
	  	driver.findElement(By.id("PSSForm:j_id_id152")).click();
	  	Thread.sleep(1000);
	  	driver.findElement(By.id("PSSForm:j_id_id211")).click();
	  	Thread.sleep(1000);
	    	
	  }

}
