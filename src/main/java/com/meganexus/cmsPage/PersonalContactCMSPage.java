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

public class PersonalContactCMSPage extends Utils {
	
	String sheetName = "Personal Contact";
	 ExcelUtils excell = new ExcelUtils();
	 
	 public void viewpersonalcontact(String sitNo) throws InterruptedException {
		 Log.info("Viewing Personal Contact");
			int count = 0;
			while (count < 2) {
				try { 
		  int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		  driver.findElement(By.xpath("//button[contains(text(),'Contact Details')]")).click();
		 
		  waitForElementPresent(By.xpath("//a[contains(text(),'Network')]"));
		  scrollToClickElement(driver.findElement(By.xpath("//a[contains(text(),'Network')]")));
		 
		  WebElement RelationToSU = driver.findElement(By.xpath("(//table[@class='table table-bordered']/tbody/tr[1]/td[1])[2]"));
			String RelationToSUNetwork = RelationToSU.getText().trim();
			Assert.assertEquals(RelationToSUNetwork, excell.getData(sheetName, rowNum,
						excell.getCellNumber(sheetName, "Relationship To Offender")).trim());
		  
		  
		  WebElement FirstName = driver.findElement(By.xpath("(//table[@class='table table-bordered']/tbody/tr[1]/td[2])[2]"));
				String FirstNameNetwork = FirstName.getText().trim();
				Assert.assertEquals(FirstNameNetwork, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "First Name")).trim()); 
		  
		  
		 WebElement FamilyName = driver.findElement(By.xpath("(//table[@class='table table-bordered']/tbody/tr[1]/td[3])[2]"));
		 String FamilyNameNetwork = FamilyName.getText().trim();
					Assert.assertEquals(FamilyNameNetwork, excell.getData(sheetName, rowNum,
								excell.getCellNumber(sheetName, "Surname")).trim());
		  
		WebElement PostCode = driver.findElement(By.xpath("(//table[@class='table table-bordered']/tbody/tr[1]/td[4])[2]"));
		 String PostCodeNetwork = PostCode.getText().trim();
								Assert.assertEquals(PostCodeNetwork, excell.getData(sheetName, rowNum,
											excell.getCellNumber(sheetName, "Postcode")).trim());
		  
		WebElement TelephoneNumber = driver.findElement(By.xpath("(//table[@class='table table-bordered']/tbody/tr[1]/td[5])[2]"));
		 String TelephoneNumberNetwork = TelephoneNumber.getText().trim();
		Assert.assertEquals(TelephoneNumberNetwork, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Telephone Number")).trim());
		  
		WebElement Email = driver.findElement(By.xpath("(//table[@class='table table-bordered']/tbody/tr[1]/td[6])[2]"));
		 String EmailNetwork = Email.getText().trim();
		Assert.assertEquals(EmailNetwork, excell.getData(sheetName, rowNum,
							excell.getCellNumber(sheetName, "Email Address")).trim());
		
		System.out.println("Personal Contact Verified -CMS");
		  
	
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
		Log.error("CMS Personal Contact Page"+e.getMessage());
	}
}
}

}