/**
 * 
 */
package com.meganexus.cmsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

/**
 * @author IEUser
 *
 */
public class CourtReportCMSPage extends Utils{
	
	
	 String sheetName = "CourtReport";
	 ExcelUtils excell = new ExcelUtils();
	
	public void verifyCourtReport(String sitNo) throws InterruptedException {
		  
		  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  Thread.sleep(3000);
		  WebElement courtReportLink =driver.findElement(By.xpath("//button[contains(.,'Court Reports')]"));
		  courtReportLink.click();
		  WebElement courtViewBtn =driver.findElement(By.xpath("//button[@id='courtReport_view0']"));
		  courtViewBtn.click();
		  Thread.sleep(3000);
		  WebElement RequestedReportType =driver.findElement(By.xpath("(.//*[@id='label_requestedReportTypeId']/following::tr-list-label)[1]"));
		  String RequestedRepType = RequestedReportType.getText().trim();
		
		  WebElement provider = driver.findElement(By.xpath("(.//*[@id='label_requestedReportTypeId']/following::tr-list-label)[2]"));
		  String providerCRP =provider.getText();
		  //System.out.println(providers);
		  WebElement notes = driver.findElement(By.xpath("//div[@id='registrationNote']"));
		  String note =notes.getText();
		   
		  System.out.println(RequestedRepType);
		  Assert.assertEquals(RequestedRepType, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Requested Report Type")).trim());
		 
		  System.out.println(providerCRP);
		  Assert.assertEquals(providerCRP, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim());
		  
		  Assert.assertEquals(note, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		  System.out.println(note);
		  Thread.sleep(3000);    
		
		 // waitForElementPresent(By.xpath("//button[contains(.,'Events')]"));
		  driver.findElement(By.xpath("//button[contains(.,'Events')]")).click(); 
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[contains(.,'Event Details')]")).click();
		  Thread.sleep(10000); 
		 
	 }

}
