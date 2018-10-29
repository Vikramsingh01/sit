package com.meganexus.cmsPage;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;

public class AddressCMSPage extends Utils {
	String sheetName = "Address";
	 ExcelUtils excell = new ExcelUtils();
	
	public void viewAddress(String sitNo) throws InterruptedException {Log.info("Viewing address");
	int count = 0;
	while (count < 2) {
		try {
int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);

waitForElementVisible(By.xpath("//button[contains(.,'Contact Details')]"));
driver.findElement(By.xpath("//button[contains(.,'Contact Details')]")).click();

waitForElementVisible(By.xpath("//a[contains(text(),'ADDRESS')]"));
scrollToClickElement(driver.findElement(By.xpath("//a[contains(text(),'ADDRESS')]")));

 WebElement addressStatus = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]"));
	String addressStatusCMS = addressStatus.getText().trim();
	Assert.assertEquals(addressStatusCMS, excell.getData(sheetName, rowNum,
				excell.getCellNumber(sheetName, "Status")).trim());
	
 WebElement postCode = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[3]"));
		String postCodeCMS = postCode.getText().trim();
		Assert.assertEquals(postCodeCMS, excell.getData(sheetName, rowNum,
					excell.getCellNumber(sheetName, "Postcode")).trim());
		
 WebElement StartDate = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[4]"));
			String StartDateCMS = StartDate.getText().trim();
			Assert.assertEquals(StartDateCMS, excell.getData(sheetName, rowNum,
						excell.getCellNumber(sheetName, "Start Date")).trim());	
		
 WebElement EndDate = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]"));
				String EndDateCMS = EndDate.getText().trim();
				Assert.assertEquals(EndDateCMS, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "End Date")).trim());		
		System.out.println("Address Verified");
		
					
		 count=0;
			break;

		} catch (NoSuchElementException e) {
			count++;
			break;
		} catch (ElementNotInteractableException e) {
			System.out.println("Element is not in focus " + e.getMessage());
		} catch (AssertionError e) {
			System.out.println("The dom is refreshed and element is not found " + e.getMessage());
		} catch (Exception e) {
			Log.error("CMS address Page"+e.getMessage());
		}
	}
}
		  
		  
	
	//-------------------- Adding Addess from CMS --------------------------------
	 
	 public void addaddress (String sitNo) throws InterruptedException {
		  
		 int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  driver.findElement(By.xpath("//button[contains(text(),'Contact Details')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[contains(text(),'ADDRESS')]")).click();
	      Thread.sleep(3000);
	     // driver.findElement(By.xpath("//button[@id='address_view0']")).click();
	      driver.findElement(By.xpath("//button[@title='Add Record']")).click();
	      waitForElementVisible(By.xpath("//select[@id='addressStatusId']"));
	      selectAnElementFromText("addressStatusId","Postal");
	      driver.findElement(By.xpath("//input[@id='startDate']")).click(); 
	      driver.findElement(By.xpath("//button[contains(text(),'Today')]")).click();
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("//input[@id='houseNumber']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "House Number")).trim());
	     Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@id='streetName']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Street Name")).trim());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='townCity']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName,"Town/City")).trim());
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Postcode")).trim());
      	Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'SUBMIT')]")).click();
		System.out.println("Address Added from CMS  : Done");
	
	 }
	 //----------------Edit Address from CMS----------------------------
	 public void editaddress(String sitNo) throws InterruptedException {
		  
		    int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  driver.findElement(By.xpath("//button[contains(text(),'Contact Details')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[contains(text(),'ADDRESS')]")).click();
	      Thread.sleep(3000);
	      //driver.navigate().refresh();
	      driver.findElement(By.xpath("//select[@class='form-control']")).click();
	      driver.findElement(By.xpath("//option[contains(text(),'10')]")).click();
	      Thread.sleep(3000);
	      waitForElementVisible(By.xpath("//button[@id='address_edit0']"));
	      driver.findElement(By.xpath("//button[@id='address_edit0']")).click();
	      Thread.sleep(4000);
	      waitForElementVisible(By.xpath("//input[@id='houseNumber']"));
	      driver.findElement(By.xpath("//input[@id='houseNumber']")).clear();
	      driver.findElement(By.xpath("//input[@id='houseNumber']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "House Number UPD")).trim());
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//input[@id='streetName']")).clear();
		  driver.findElement(By.xpath("//input[@id='streetName']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Street Name UPD")).trim());
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//input[@id='townCity']")).clear();
		  driver.findElement(By.xpath("//input[@id='townCity']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Town/City UPD")).trim());
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//input[@id='postcode']")).clear();
		  driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Postcode UPD")).trim());
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//textarea[@id='note']")).clear();
		  driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes UPD")).trim());
		  Thread.sleep(3000);
		  waitForElementVisible(By.xpath("//button[contains(text(),'SUBMIT')]"));
	      driver.findElement(By.xpath("//button[contains(text(),'SUBMIT')]")).click();
	      Thread.sleep(3000);
		  System.out.println("Edit operation Done from CMS ");
	 }
	 //----------------Delete Address from CMS-----------------------------------------------
	     public void deleteaddress() throws InterruptedException {
		  
		  //int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  driver.findElement(By.xpath("//button[contains(text(),'Contact Details')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[contains(text(),'ADDRESS')]")).click();
	      Thread.sleep(3000);
	      driver.findElement(By.id("//button[@id='address_delete0']")).click();
	      driver.findElement(By.id("//button[contains(text(),'Ok')]")).click();
		  System.out.println("Delete operation Done from CMS ");
	 }
	 
	
	
	
}