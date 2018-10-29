package com.meganexus.cmsPage;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class EqualityMonitoringCMSPage extends Utils  {
	
		
		String sheetName = "Equality Monitoring";
		ExcelUtils excell = new ExcelUtils();

		public void viewEqualityMonitoring(String sitNo) throws InterruptedException {
			Log.info("Viewing Equality Monitoring");
			int count = 0;
			while (count < 2) {
				try {
			
					int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
			waitForElementVisible(By.xpath("//button[contains(.,'Protected Characteristics')]"));
			
			driver.findElement(By.xpath("//button[contains(.,'Protected Characteristics')]")).click();
			Thread.sleep(5000);
		
		 WebElement SexualOrientation = driver.findElement(By.xpath("//div[@class='row']/div[1]/div[2]/tr-list-label"));
		 String SexualOrientationCMS = SexualOrientation.getText().trim();
		 Assert.assertEquals(SexualOrientationCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Sexual Orientation")).trim());
		
		 WebElement GenderReassignment = driver.findElement(By.xpath("//div[@class='row']/div[2]/div[2]/tr-list-label"));
		 String GenderReassignmentCMS = GenderReassignment.getText().trim();
		 Assert.assertEquals(GenderReassignmentCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Gender Reassignment")).trim());
		
		 WebElement ConsentToDiscolse = driver.findElement(By.xpath("//div[@class='row']/div[3]/div[2]/tr-list-label"));
		 String ConsentToDiscolseCMS = ConsentToDiscolse.getText().trim();
		 Assert.assertEquals(ConsentToDiscolseCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Consent To Disclose")).trim()); 
		 
		 
		 WebElement Ethnicity = driver.findElement(By.xpath("//div[@class='row']/div[4]/div[2]/tr-list-label"));
		 String EthnicityCMS = Ethnicity.getText().trim();
		 Assert.assertEquals(EthnicityCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Ethnicity")).trim());  
		 
		 
		 WebElement Nationality = driver.findElement(By.xpath("//div[@class='row']/div[5]/div[2]/tr-list-label"));
		 String NationalityCMS = Nationality.getText().trim();
		 Assert.assertEquals(NationalityCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Nationality")).trim());  
		 
		 
		 WebElement SecondNationality = driver.findElement(By.xpath("//div[@class='row']/div[6]/div[2]/tr-list-label"));
		 String SecondNationalityCMS = SecondNationality.getText().trim();
		 Assert.assertEquals(SecondNationalityCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Second Nationality")).trim());  
		 
		 
		 WebElement SecondLanguage = driver.findElement(By.xpath("//div[@class='row']/div[7]/div[2]/tr-list-label"));
		 String SecondLanguageCMS = SecondLanguage.getText().trim();
		 Assert.assertEquals(SecondLanguageCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Second Language")).trim());   
		 
		 
		 WebElement Interpreter = driver.findElement(By.xpath("//div[@class='row']/div[8]/div[2]/tr-list-label"));
		 String InterpreterCMS = Interpreter.getText().trim();
		 Assert.assertEquals(InterpreterCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Interpreter Required")).trim());   
		 
		 WebElement Immigration = driver.findElement(By.xpath("//div[@class='row']/div[9]/div[2]/tr-list-label"));
		 String ImmigrationCMS = Immigration.getText().trim();
		 Assert.assertEquals(ImmigrationCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Immigration Status")).trim());  
		 
		 WebElement ImmigrationNo = driver.findElement(By.xpath("//*[@id='immigrationNumber']"));
		 String ImmigrationNoCMS = ImmigrationNo.getText().trim();
		 Assert.assertEquals(ImmigrationNoCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Immigration Number")).trim()); 
		 
		 WebElement ReligionOrBelief = driver.findElement(By.xpath("//div[@class='row']/div[11]/div[2]/tr-list-label"));
		 String ReligionOrBeliefCMS = ReligionOrBelief.getText().trim();
		 Assert.assertEquals(ReligionOrBeliefCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Religion Or Belief")).trim());  
		 
		/* WebElement Notes = driver.findElement(By.xpath("//*[@id='equalityMonitoringNote']"));
		 String NotesCMS = Notes.getText().trim();
		 Assert.assertEquals(NotesCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Equality Monitoring Notes")).trim()); */
		 
		 System.out.println("Equality Monitoring Verified");
		 count=0;
			break;

		} catch (NoSuchElementException e) {
			count++;
			break;
		} catch (ElementNotInteractableException e) {
			System.out.println("Element is not in focus " + e.getMessage());
		} catch (StaleElementReferenceException e) {
			System.out.println("The dom is refreshed and element is not found " + e.getMessage());
		} catch (Exception e) {
			Log.error("CMS Equality Monitoring Page"+e.getMessage());
		}
	}
}

}