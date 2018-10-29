package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class InstitutionalReportPage extends Utils {
	ExcelUtils excell = new ExcelUtils();
	String sheetName = "Institutional Report";
	
	
public void institutionalReport(String sitNo) throws Exception {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		
		//view Event details
		waitForElementVisible(By.id("linkNavigation3Reports"));
		driver.findElement(By.id("linkNavigation3Reports")).click();
		Thread.sleep(1500);
		scrollToClickElement(driver.findElement(By.id("reportListForm:j_id_id156")));
		Thread.sleep(3000);
		
		driver.findElement(By.id("RequestedDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "RequestedDate")).trim());
	    Thread.sleep(1500);
	    driver.findElement(By.id("RequiredDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "RequiredDate")).trim());
	    Thread.sleep(1000);
	    selectAnElementFromText("addInstitutionalReportForm:RequestedReportType",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "RequestedReportType")).trim());
	    Thread.sleep(1500);
	    selectAnElementFromText("Area",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim() );
	    Thread.sleep(1500);
	    selectAnElementFromText("Team",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Team")).trim() );
	    Thread.sleep(1500);
	    selectAnElementFromText("addInstitutionalReportForm:Staff",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Officer")).trim() );
	    Thread.sleep(1500);
	    driver.findElement(By.id("AllocatedDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "AllocatedDate")).trim());
	    Thread.sleep(1000);
	    driver.findElement(By.id("CompletedDate")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "CompletedDate")).trim());
	    Thread.sleep(1000);
	    selectAnElementFromText("addInstitutionalReportForm:Institution",excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Institution")).trim() );
	    Thread.sleep(1500);
	    driver.findElement(By.id("deliveredToEstablishment")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "DeliveredToEstablishmentDate")).trim());
	    Thread.sleep(1000);
	    driver.findElement(By.id("dateAbandoned")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "DateAbandoned")).trim());
	    Thread.sleep(1000);
	    driver.findElement(By.id("addInstitutionalReportForm:Notes")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Note")).trim());
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("addInstitutionalReportForm:j_id_id137")).click();
	    Thread.sleep(1000);
	    
	
	}
}
