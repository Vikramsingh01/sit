package com.meganexus.nDeliusPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class AddressPage extends Utils {
	String sheetName = "Address";
	ExcelUtils excell = new ExcelUtils();
	
//	-------------Add Address From Ndelius------------------------------------
	public void addAddressPage(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		driver.findElement(By.id("linkNavigation3Address")).click();
		waitForElementVisible(By.xpath("//h1[text()='Offender Addresses List']"));
		driver.findElement(By.id("addressListForm:j_id_id175")).click();
		waitForElementVisible(By.xpath("//h1[text()='Add Address']"));
		
		if(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "No Fixed Abode")).trim().length()>0) {
			waitForElementVisible(By.id("addAddressForm:NoFixedAbode"));
			driver.findElement(By.id("addAddressForm:NoFixedAbode"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "No Fixed Abode")).trim());
			}
		
		if(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Building Name")).trim().length()>0) {
			waitForElementVisible(By.id("addAddressForm:BuildingName"));
			driver.findElement(By.id("addAddressForm:BuildingName"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Building Name")).trim());
			}
		
		
		WebElement Housenumber = driver.findElement(By.id("addAddressForm:HouseNumber"));
		Housenumber.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "House Number")).trim());
	
		WebElement Streetname = driver.findElement(By.id("addAddressForm:StreetName"));
		Streetname.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Street Name")).trim());
	
		
		if(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "District")).trim().length()>0) {
			waitForElementVisible(By.id("addAddressForm:District"));
			driver.findElement(By.id("addAddressForm:District"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "District")).trim());
			}
		
        WebElement Towncity = driver.findElement(By.id("addAddressForm:TownCity"));
        Towncity.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Town/City")).trim());
    
        
        if(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "County")).trim().length()>0) {
			waitForElementVisible(By.id("addAddressForm:County"));
			driver.findElement(By.id("addAddressForm:County"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "County")).trim());
			}
        
        WebElement postcode = driver.findElement(By.id("addAddressForm:Postcode"));
        postcode.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Postcode")).trim());
	
		
	    if(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Telephone Number")).trim().length()>0) {
				waitForElementVisible(By.id("addAddressForm:TelephoneNumber"));
				driver.findElement(By.id("addAddressForm:TelephoneNumber"))
						.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Telephone Number")).trim());
				}
	    
	    if(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Start Date")).trim().length()>0) {
			waitForElementVisible(By.id("addAddressForm:StartDate"));
			driver.findElement(By.id("addAddressForm:StartDate"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Start Date")).trim());
			}
		
	    if(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "End Date")).trim().length()>0) {
			waitForElementVisible(By.id("addAddressForm:EndDate"));
			driver.findElement(By.id("addAddressForm:EndDate"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "End Date")).trim());
			}
	    
	    if(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Status")).trim().length()>0) {
			waitForElementVisible(By.id("addAddressForm:AddressStatus"));
			driver.findElement(By.id("addAddressForm:AddressStatus"))
					.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Status")).trim());
			}
		
                  
        
	/*	waitForElementVisible(By.id("addAddressForm:AddressStatus"));
		WebElement status = driver.findElement(By.xpath("//select[@id='addAddressForm:AddressStatus']"));
		status.sendKeys("Main");
		Thread.sleep(3000);*/
		
		waitForElementVisible(By.id("addAddressForm:CircumstanceSubType"));
		Thread.sleep(3000);
		WebElement subtype= driver.findElement(By.xpath("//select[@id='addAddressForm:CircumstanceSubType']"));
		subtype.sendKeys("Approved Premises");
		Thread.sleep(500);
		
		waitForElementVisible(By.id("addAddressForm:StatusVerified"));
		WebElement option = driver.findElement(By.xpath("//select[@id='addAddressForm:StatusVerified']"));
		option.sendKeys("Yes");
		Thread.sleep(500);
		
		 WebElement Notes = driver.findElement(By.id("addAddressForm:newNotes"));
	        Notes.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")));	
	        Thread.sleep(3000);
		
		driver.findElement(By.id("addAddressForm:j_id_id138")).click();
		Thread.sleep(3000);
		scrollToClickElement(driver.findElement(By.id("addAddressForm:j_id_id140")));
		Thread.sleep(3000);
		
		System.out.println("Address Added : Done");	
	
		
	}
	//----------------------View Address Added from CMS--------------------
	
	public void viewAddress(String sitNo) throws InterruptedException {
		
		  int rowNum = excell.getRowNums(sheetName,"SIT NO", sitNo);
		  Thread.sleep(4000);
		  //driver.findElement(By.id("linkNavigation2OffenderIndex")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//a[@id='linkNavigation3Address']")).click();
		  Thread.sleep(4000);
		  //waitForElementVisible(By.xpath ("//h2[contains(text(),'Other Addresses')]"));
		  driver.findElement(By.xpath("//span[@title='Start']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[@title='Link to View this Address']")).click();
		  Thread.sleep(4000);
		  WebElement NO =driver.findElement(By.xpath("//span[contains(@id,'addressDetailsForm:HouseNumber')]"));
		  String Houseno = NO.getText().trim();
		  WebElement ST =driver.findElement(By.xpath("//span[@id='addressDetailsForm:StreetName']"));
		  String Street = ST.getText().trim();
		  WebElement DT =driver.findElement(By.xpath("//span[@id='addressDetailsForm:District']"));
		  String District = DT.getText().trim();
		  WebElement TC =driver.findElement(By.xpath("//span[@id='addressDetailsForm:TownCity']"));
		  String Town = TC.getText().trim();
		  WebElement PO =driver.findElement(By.xpath("//span[@id='addressDetailsForm:Postcode']"));
		  String postcode = TC.getText().trim();
		  WebElement NP =driver.findElement(By.xpath("//textarea[@id='addressDetailsForm:notes']"));
		  String Notes = NP.getText().trim();
		  
		  System.out.println(Houseno);
		  //Assert.assertEquals(Houseno, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "House Number")).trim());
	      
		  System.out.println(Street);
		  //Assert.assertEquals(Street, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Street Name")).trim());
	   
		  System.out.println(Notes);
		 // Assert.assertEquals(Notes, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		  
		  System.out.println("Verified Address Added");
	}
	//--------------------View Editited Address in Ndelius -------------
	public void viewEditAddressIN(String sitNo) throws InterruptedException {
		
		 int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		 Thread.sleep(4000);
		  //driver.findElement(By.id("linkNavigation2OffenderIndex")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//a[@id='linkNavigation3Address']")).click();
		  Thread.sleep(4000);
		  waitForElementVisible(By.xpath("//span[@title='Start']"));
		  driver.findElement(By.xpath("//span[@title='Start']")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//a[@title='Link to View this Address']")).click();	 
		  Thread.sleep(6000);
		  WebElement NO =driver.findElement(By.xpath("//span[contains(@id,'addressDetailsForm:HouseNumber')]"));
		  String Houseno = NO.getText().trim();
		  WebElement ST =driver.findElement(By.xpath("//span[@id='addressDetailsForm:StreetName']"));
		  String Street = ST.getText().trim();
		  WebElement DT =driver.findElement(By.xpath("//span[@id='addressDetailsForm:District']"));
		  String District = DT.getText().trim();
		  WebElement TC =driver.findElement(By.xpath("//span[@id='addressDetailsForm:TownCity']"));
		  String Town = TC.getText().trim();
		  WebElement PO =driver.findElement(By.xpath("//span[@id='addressDetailsForm:Postcode']"));
		  String postcode = TC.getText().trim();
		  WebElement NP =driver.findElement(By.xpath("//textarea[@id='addressDetailsForm:notes']"));
		  String Notes = NP.getText().trim();
		  
		  System.out.println(Houseno);
		  Assert.assertEquals(Houseno, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "House Number UPD")).trim());
	      
		  System.out.println(Street);
		  Assert.assertEquals(Street, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Street Name UPD")).trim());
	   
		  System.out.println(Notes);
		  //Assert.assertEquals(Notes, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes UPD")).trim());
		  
		  System.out.println("Verified Address updated");
	
}
	
	     //------------- View Deleted address in Ndelius --------- 
	     public void ViewdeleteAddressIN(String sitNo) throws InterruptedException {
		 int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		 driver.findElement(By.id("linkNavigation2OffenderIndex")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.id("//a[@id='linkNavigation3Address']")).click();
		  Thread.sleep(3000);
		  waitForElementVisible(By.id ("//h2[contains(text(),'Other Addresses')]"));
		  WebElement add =driver.findElement(By.id("//a[@title='Link to View this Address']"));
		  if (add != null  ){
			  System.out.println("Address has not been deleted");
						 
		  }
		  else	  
			  System.out.println("Address has not been deleted");  
}
	
	

}
