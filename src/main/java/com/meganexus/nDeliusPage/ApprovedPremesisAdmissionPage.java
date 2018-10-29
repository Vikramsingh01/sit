/**
 * 
 */
package com.meganexus.nDeliusPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

/**
 * @author Amardeep.Patil
 *  I am adding Approved Premises admission  from nDelius
 */
public class ApprovedPremesisAdmissionPage extends Utils{
	
	String sheetName = "ApprovedPreAdmission";
	ExcelUtils excell = new ExcelUtils();
	
	public void addApprovedPremisisAdmission(String sitNo) throws InterruptedException {
		
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		waitForElementVisible(By.xpath("//a[@id='linkNavigation1HostelDiary']"));
		scrollToClickElement(driver.findElement(By.xpath("//a[@id='linkNavigation1HostelDiary']"))); //Click on Approved Premises admission link
		Thread.sleep(2000);
		scrollToClickElement(driver.findElement(By.xpath("///a[@id='linkNavigation2AwaitingArrival']"))); // Clicking on awaiting Arrival
	   /* driver.findElement(By.xpath("//select[@id='Trust']"))
		.sendKeys("NPS North West");*/
		
		driver.findElement(By.xpath("//select[@id='AwaitingArrivalForm:APGroup']"))
		.sendKeys("All APs");
		
		driver.findElement(By.xpath("//select[@id='AwaitingArrivalForm:APName']"))
		.sendKeys("Ascot Ho");
		
		driver.findElement(By.xpath("//input[@id='FromDate']"))
		.sendKeys("27/11/2017");
		
		driver.findElement(By.xpath("//select[@id='AwaitingArrivalForm:APName']"))
		.sendKeys("30/12/2020");
		
		driver.findElement(By.xpath("//input[@id='AwaitingArrivalForm:j_id_id63']"))
		.click();
		
		driver.findElement(By.xpath("//a[contains(.,'Admit')]"))
		.click();
		
		driver.findElement(By.xpath("//input[@id='addAPResidenceForm:ArrivalDate']"))
		.sendKeys(getSysDateAndTime());;
		
		driver.findElement(By.xpath("//input[@id='addAPResidenceForm:RoomNumber']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Room Number")).trim());
		
		driver.findElement(By.xpath("//select[@id='addAPResidenceForm:team']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "AP Team")).trim());
		
		driver.findElement(By.xpath("//select[@id='addAPResidenceForm:referringStaff']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "AP Officer")).trim());
		
		driver.findElement(By.xpath("//textarea[@id='addAPResidenceForm:Notes']"))
		.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Notes")).trim());
		
		scrollToClickElement(driver.findElement(By.xpath("//input[@id='addAPResidenceForm:j_id_id105']")));
		
	}
	public static String getSysDateAndTime() {
		DateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dtf.format(date);
	}

}
