package com.meganexus.cmsPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class UPWContactCMSPage extends Utils{
	String sheetName = "UPW Contact";
	ExcelUtils excell = new ExcelUtils();
	
	//private functions required to add UPW recurring appointment
	private static String getTodaysDate() {
		DateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println("Today's date is: " + dtf.format(date));
		return dtf.format(date);
	}
	
	private static String getTodaysDay() {
		DateFormat dtf = new SimpleDateFormat("EEEE");
		Date date = new Date();
		System.out.println("Today's day is: " + dtf.format(date));
		return dtf.format(date);
	}
	
	//private functions required to edit UPW appointment
	private static String getTomorrowsDate() {
		DateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date todate1 = cal.getTime();
		System.out.println("Tomorrow's date is: " + dtf.format(todate1));
		return dtf.format(todate1);
	}
	
	private void navigate_to_UPW(){
		try {
			// navigating to UPW details
			Thread.sleep(3000);
			scrollToClickElement(driver.findElement(By.xpath("//button[contains(text(),'SU Activities')]")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='UPW']")).click();
			Thread.sleep(3000);
			//waitForElementVisible(By.xpath("//a[contains(text(),'Upw Details')]"));
			scrollToClickElement(driver.findElement(By.xpath("//button[@id='upw_detail_view0']")));
			Thread.sleep(3000);
		} catch (NoSuchElementException n) {
			System.out.println("Element not available" + n.getMessage());
		} catch (StaleElementReferenceException e) {
			System.out.println("The dom is refreshed and element is not found" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addUPWContact(String sitNo) throws Exception {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		Log.info("Adding UPW contact.");
		
		navigate_to_UPW();
		
		try {
			//Adding a UPW contact (recurring UPW appointment)
			Thread.sleep(2000);
			scrollToClickElement(driver.findElement(By.xpath("//button[@id='upwAppointment_addRecButton']")));
			
			Thread.sleep(2000);
			driver.findElement(By.id("startDate")).sendKeys(getTodaysDate());
			
			Thread.sleep(2000);
			new Select(driver.findElement(By.id("dayOfWeekId"))).selectByVisibleText(getTodaysDay());
			
			Thread.sleep(10000);
			String team = excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Team")).trim();
			System.out.println("team selected is : "+team);
			new Select(driver.findElement(By.id("officeTeamId"))).selectByVisibleText(team);
			
			Thread.sleep(2000);
			new Select(driver.findElement(By.id("projectTypeId"))).selectByVisibleText(excell
					.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Project Type")).trim());
			
			//Clicking on search button
			Thread.sleep(2000);
			driver.findElement(By.id("searchButton")).click();
			
			Thread.sleep(2000);
			new Select(driver.findElement(By.id("projectName"))).selectByVisibleText(excell
					.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Project")).trim());
			
			Thread.sleep(2000);
			WebElement projectAvailibility = driver.findElement(By.id("projectAvailibility"));
			List<WebElement> list = projectAvailibility.findElements(By.tagName("option"));
			Iterator<WebElement> i = list.iterator();
			while(i.hasNext()) {
			    WebElement wel = i.next();
			    System.out.println(wel.getText());
			    if(wel.getText().contains(getTodaysDay()))
			    {
			       wel.click();
			    }
			} 
			//selectAnElementFromIndexNo("projectAvailibility", Integer.parseInt(excell
			//	.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Project Availability")).trim()));
			
			Thread.sleep(2000);
			driver.findElement(By.id("endDate")).sendKeys(getTodaysDate());
			
			//Clicking on add button
			Thread.sleep(2000);
			driver.findElement(By.id("addAppointmentButton")).click();
			
			Thread.sleep(20000);
			if(driver.findElement(By.xpath("//tbody[@formarrayname='upwAppointment']/tr")).isDisplayed()){
				System.out.println("UPW contact addition successful, submitting the form now.");
			}
			else {
				System.out.println("UPW contact addition NOT successful, verify for errors.");
			}
			//Clicking on submit button
			Thread.sleep(20000);
			driver.findElement(By.id("saveButton")).click();
			
		} catch (NoSuchElementException n) {
			System.out.println("Element not available" + n.getMessage());
		} catch (StaleElementReferenceException e) {
			System.out.println("The dom is refreshed and element is not found" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		/*if(driver.findElement(By.xpath("//span[text()='"+getTodaysDay()+"']")).isDisplayed()){
			System.out.println("UPW contact added successfully.");
		}*/
		
	}
	
	public void editUPWContact(String sitNo) throws Exception {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		Log.info("Editing UPW contact.");
		
		navigate_to_UPW();
		
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[contains(text(),'Upw Appointments')]")).click();
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@id='upwAppointment_edit0']")).click();
			
			Thread.sleep(5000);
			driver.findElement(By.id("appointmentDate")).sendKeys(getTomorrowsDate());
			
			Thread.sleep(5000);
			driver.findElement(By.id("note")).sendKeys(sitNo);
		} catch (NoSuchElementException n) {
			System.out.println("Element not available" + n.getMessage());
		} catch (StaleElementReferenceException e) {
			System.out.println("The dom is refreshed and element is not found" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		/*if(driver.findElement(By.xpath("//span[text()='"+getTodaysDay()+"']")).isDisplayed()){
			System.out.println("UPW contact edited successfully.");
		}*/
	}
	
	public void deleteUPWContact(String sitNo) {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		Log.info("Deleting UPW contact.");
		
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//li[@title='UPW Project Admin']/button")).click();
			
			Thread.sleep(5000);
			driver.findElement(By.id("Upw Project Diary")).click();
			
			Thread.sleep(5000);
			driver.findElement(By.id("appointmentDate")).sendKeys(getTodaysDate());
			
			Thread.sleep(5000);
			driver.findElement(By.id("officeTeamId")).sendKeys(excell
					.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Team")).trim());
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//button[contains(text(),'Search') and @type='submit'])[2]")).click();
			
			Thread.sleep(5000);
			String project = excell
					.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Project")).trim();
			driver.findElement(By.xpath("//td[text()='"+project+"']/following-sibling::td[6]//button[contains(@id,'upwProjectDiary_view')]")).click();
			
			Thread.sleep(5000);
			driver.findElement(By.id("upwAppointment_delete")).click();
		} catch (NoSuchElementException n) {
			System.out.println("Element not available" + n.getMessage());
		} catch (StaleElementReferenceException e) {
			System.out.println("The dom is refreshed and element is not found" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//method from Sanket to handle delete pop up
		
		System.out.println("UPW contact deleted successfully.");
	}
}
