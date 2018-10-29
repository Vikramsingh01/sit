package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class DrugTestPage extends Utils {
	String sheetName = "Drug Test";
	ExcelUtils excell = new ExcelUtils();
	

	public void viewDrugTestAfterAdd(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		
		driver.findElement(By.id("linkNavigation3DRRReferrals")).click();
		waitForElementVisible(By.xpath("//h1[contains(.,'Drug Testing Referrals')]"));
		Thread.sleep(2000);
		waitForElementVisible(By.xpath("//a[contains(.,'view')]"));
		driver.findElement(By.xpath("//a[contains(.,'view')]")).click();
		waitForElementVisible(By.id("j_id_id11:j_id_id64"));
		driver.findElement(By.id("j_id_id11:j_id_id64")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(@title,'Link to view the Drug test record')]")).click();
		waitForElementVisible(By.xpath("//h1[contains(.,'View Drugs Test')]"));
		
		 Thread.sleep(2000);
		  WebElement DateOfTest = driver.findElement(By.xpath(".//*[@id='j_id_id11:DateOfTest']"));
	      Assert.assertEquals(DateOfTest.getText(), excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Date of Test")).trim());
		  
		  Thread.sleep(2000);
		  WebElement TestedBy = driver.findElement(By.xpath(".//*[@id='j_id_id11:TestedBy']"));
		  //System.out.println(TestedBy.getText());
	      Assert.assertEquals(TestedBy.getText(), excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Tested by")).trim());
		  
		  Thread.sleep(2000);
		  WebElement OffenderComplied = driver.findElement(By.xpath(".//*[@id='content']/section/div[3]/div"));
		  //System.out.println(OffenderComplied.getText());
	      Assert.assertEquals(OffenderComplied.getText().trim(), excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offender Complied")).trim());
		  
		  Thread.sleep(2000);
		  WebElement Admitted_DrugOne = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[1]/td[2]"));
		  System.out.println(Admitted_DrugOne.getText());
		  Assert.assertEquals(Admitted_DrugOne.getText().trim(), "Yes");
		  Thread.sleep(2000);
		  WebElement Result_DrugOne = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[1]/td[3]"));
	      Assert.assertEquals(Result_DrugOne.getText().trim(),"Positive");
		  Thread.sleep(2000);
		  WebElement Agreed_DrugOne = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[1]/td[4]"));
	      Assert.assertEquals(Agreed_DrugOne.getText().trim(), "Yes");
		  Thread.sleep(2000);
		
		  WebElement Admitted_DrugTwo = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[2]/td[2]"));
	      Assert.assertEquals(Admitted_DrugTwo.getText().trim(), "Yes");
		  Thread.sleep(2000);
		  WebElement Result_DrugTwo = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[2]/td[3]"));
	      Assert.assertEquals(Result_DrugTwo.getText().trim(),"Not Tested");
		  Thread.sleep(2000);
		  WebElement Agreed_DrugTwo = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[2]/td[4]"));
	      Assert.assertEquals(Agreed_DrugTwo.getText().trim(), "No");
		  Thread.sleep(2000);
		
		  WebElement Admitted_DrugThree = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[3]/td[2]"));
	      Assert.assertEquals(Admitted_DrugThree.getText().trim(), "No");
		  Thread.sleep(2000);
		  WebElement Result_DrugThree = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[3]/td[3]"));
	      Assert.assertEquals(Result_DrugThree.getText().trim(),"Negative");
		  Thread.sleep(2000);
		  WebElement Agreed_DrugThree = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[3]/td[4]"));
	      Assert.assertEquals(Agreed_DrugThree.getText().trim(), "No");
		  Thread.sleep(2000);
		  
		  /*WebElement NotesCMS = driver.findElement(By.xpath(".//*[@id='j_id_id11:Notes']"));
		 String Notes =  NotesCMS.getText();
		  Assert.assertEquals(Notes, excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")));*/
		  
	
    }
	
	
	public void viewDrugTestAfterUpdate(String sitNo) throws InterruptedException {
	int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		
		driver.findElement(By.id("linkNavigation3DRRReferrals")).click();
		waitForElementVisible(By.xpath("//h1[contains(.,'Drug Testing Referrals')]"));
		Thread.sleep(2000);
		waitForElementVisible(By.xpath("//a[contains(.,'view')]"));
		driver.findElement(By.xpath("//a[contains(.,'view')]")).click();
		waitForElementVisible(By.id("j_id_id11:j_id_id64"));
		driver.findElement(By.id("j_id_id11:j_id_id64")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(@title,'Link to view the Drug test record')]")).click();
		waitForElementVisible(By.xpath("//h1[contains(.,'View Drugs Test')]"));
		
		 Thread.sleep(2000);

		  WebElement OffenderComplied = driver.findElement(By.xpath(".//*[@id='content']/section/div[3]/div"));
	      Assert.assertEquals(OffenderComplied.getText(), excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Offender Complied")).trim());
		  
		  Thread.sleep(2000);
		  WebElement Admitted_DrugOne = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[1]/td[2]"));
	      Assert.assertEquals(Admitted_DrugOne.getText().trim(), "No");
		  Thread.sleep(2000);
		  WebElement Result_DrugOne = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[1]/td[3]"));
	      Assert.assertEquals(Result_DrugOne.getText(),"Negative");
		  Thread.sleep(2000);
		  WebElement Agreed_DrugOne = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[1]/td[4]"));
	      Assert.assertEquals(Agreed_DrugOne.getText(), "No");
		  Thread.sleep(2000);
		
		  WebElement Admitted_DrugTwo = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[2]/td[2]"));
	      Assert.assertEquals(Admitted_DrugTwo.getText(), "No");
		  Thread.sleep(2000);
		  WebElement Result_DrugTwo = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[2]/td[3]"));
	      Assert.assertEquals(Result_DrugTwo.getText(),"Positive");
		  Thread.sleep(2000);
		  WebElement Agreed_DrugTwo = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[2]/td[4]"));
	      Assert.assertEquals(Agreed_DrugTwo.getText(), "Yes");
		  Thread.sleep(2000);
		
		  WebElement Admitted_DrugThree = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[3]/td[2]"));
	      Assert.assertEquals(Admitted_DrugThree.getText(), "Yes");
		  Thread.sleep(2000);
		  WebElement Result_DrugThree = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[3]/td[3]"));
	      Assert.assertEquals(Result_DrugThree.getText(),"Not Tested");
		  Thread.sleep(2000);
		  WebElement Agreed_DrugThree = driver.findElement(By.xpath(".//*[@id='j_id_id11:drugsTable:tbody_element']/tr[3]/td[4]"));
	      Assert.assertEquals(Agreed_DrugThree.getText(), "Yes");
		  Thread.sleep(2000);
		
	
    }


}
