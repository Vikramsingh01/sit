package com.meganexus.cmsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class AddressAssessmentCMSPage  extends Utils {
	String sheetName = "Address Assessment";
	ExcelUtils excell = new ExcelUtils();
	
	public void viewAssessment(String sitNo) throws InterruptedException {
		   Log.info("Viewing address assessment");
		   int count = 0;
		   while (count < 2) {
		    try {
		   int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		   driver.findElement(By.xpath("//button[@id='address_view0']")).click();
		   Thread.sleep(3000);   
		   waitForElementVisible(By.xpath("//a[contains(text(),'Address Assessment')]"));
		   scrollToClickElement(driver.findElement(By.xpath("//a[contains(text(),'Address Assessment')]")));
		   
		    WebElement Date = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]"));
		    String assessmentDate = Date.getText().trim();
		    Assert.assertEquals(assessmentDate, excell.getData(sheetName, rowNum,
		       excell.getCellNumber(sheetName, "Date")).trim());
		   
		    
		      WebElement assessmentProvider = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]"));
		     String assessmentProviderCMS = assessmentProvider.getText().trim();
		     Assert.assertEquals(assessmentProviderCMS, excell.getData(sheetName, rowNum,
		        excell.getCellNumber(sheetName, "Provider")).trim());
		   
		     System.out.println("Assessment Verified");
		   
				Thread.sleep(500);
				driver.findElement(By.xpath("//button[contains(text(),'contact details')]")).click();
				Thread.sleep(1000);
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
		    }
		   }
		  }
	
	//--------add assessment from CMS--------------------------
		 public void addassessment(String sitNo) throws InterruptedException {
			  
			  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
			  driver.findElement(By.xpath("//button[contains(text(),'Contact Details')]")).click();
			  Thread.sleep(3000);
			  driver.findElement(By.xpath("//a[contains(text(),'ADDRESS')]")).click();
			  Thread.sleep(4000);
		      driver.findElement(By.xpath("//button[@id='address_view0']")).click();
		      Thread.sleep(4000);
		      //driver.findElement(By.xpath("//a[contains(text(),'Address Assessment']")).click();
		      waitForElementVisible(By.xpath("//button[@title='Add Record']"));
		      driver.findElement(By.xpath("//button[@title='Add Record']")).click(); 
		      Thread.sleep(4000);
		      driver.findElement(By.xpath("//input[@id='date']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Date")));
		      //driver.findElement(By.xpath("//button[contains(text(),'Today')]")).click();      
		      driver.findElement(By.xpath("//select[contains(@id,'addressAssessmentProviderId')]")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")));
		      driver.findElement(By.xpath("//textarea[contains(@class,'form-control ng-untouched ng-pristine ng-valid')]")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")));
		      driver.findElement(By.xpath("//button[@id='saveButton']")).click();
		      //WebElement NotesCMS = driver.findElement(By.xpath("//div[@class='detail-value-note col-sm-7']"));
			  //Assert.assertEquals(NotesCMS.getText().trim().equals("Note added from CMS"), false, sheetName);
			  System.out.println("Assessment Added from CMS");
		 }
		
		 //----------Edit Assessment from CMS--------------------------------
		 public void editassessment(String sitNo) throws InterruptedException {
			  
			  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
			  //driver.findElement(By.xpath("//button[contains(text(),'Contact Details')]")).click();
			  Thread.sleep(3000);
			  //driver.findElement(By.xpath("//a[contains(text(),'ADDRESS')]")).click();
		      Thread.sleep(3000);
		      driver.findElement(By.xpath("//a[contains(text(),'Address Assessment')]")).click();
		      Thread.sleep(3000);
		      driver.findElement(By.xpath("//select[@class='form-control']")).click();
		      driver.findElement(By.xpath("//option[contains(text(),'10')]")).click();
		      Thread.sleep(3000);
		      driver.findElement(By.xpath("//span[contains(@class,'glyphicon glyphicon-chevron-right')]")).click();
		      driver.findElement(By.xpath("//button[contains(@id,'edit0')]")).click();
		      Thread.sleep(3000);
		      driver.findElement(By.xpath("//input[contains(@id,'date')]")).clear();
		      driver.findElement(By.xpath("//input[contains(@id,'date')]")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Date UPD")));
		      driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys("updated note added");
		      driver.findElement(By.xpath("//button[@id='saveButton']")).click();
		      Thread.sleep(3000);
			  System.out.println("Edit operation Done from CMS ");
		 }
		 
		 //----------------------Delete Assessment from CMS-----------------------------
		 
		 public void deleteassessment(String sitNo) throws InterruptedException {
			  
			  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
			  //driver.findElement(By.xpath("//button[contains(text(),'Contact Details')]")).click();
			  Thread.sleep(3000);
			  //driver.findElement(By.xpath("//a[contains(text(),'ADDRESS')]")).click();
			  driver.findElement(By.xpath("//a[contains(text(),'Address Assessment')]")).click();
		      Thread.sleep(3000);
		      //driver.findElement(By.xpath("//button[@id='address_view0']")).click();
		      //driver.findElement(By.xpath("//span[contains(@class,'glyphicon glyphicon-chevron-right')]")).click();
		      driver.findElement(By.xpath("//select[@class='form-control']")).click();
		      driver.findElement(By.xpath("//option[contains(text(),'10')]")).click();
		      Thread.sleep(3000);
		      driver.findElement(By.xpath("//button[@id='addressAssessment_delete0']")).click();
		      Thread.sleep(3000);
		      driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			  System.out.println("Deleted Assessment from CMS ");
		 }

	}

	
	

