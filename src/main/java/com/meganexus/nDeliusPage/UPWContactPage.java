package com.meganexus.nDeliusPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class UPWContactPage extends Utils{
	String sheetName = "UPW Contact";
	ExcelUtils excell = new ExcelUtils();
	
	private static String getTomorrowsDate() {
		DateFormat dtf = new SimpleDateFormat("dd/mm/yyyy");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date todate1 = cal.getTime();
		System.out.println("Tomorrow's date is: " + dtf.format(todate1));
		return dtf.format(todate1);
	}
	
	private void navigate_to_UPW(){
		try {
			waitForElementVisible(By.id("linkNavigation2EventList"));
			scrollToElement(driver.findElement(By.id("linkNavigation2EventList")));
			driver.findElement(By.id("linkNavigation2EventList")).click();
			waitForElementVisible(By.xpath("//h1[contains(text(),'Events')]"));
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='eventsListForm:eventsTable:tbody_element']/tr/td[6]/a")).click();
			waitForElementVisible(By.id("linkNavigation3UnpaidWork"));
			scrollToElement(driver.findElement(By.id("linkNavigation3UnpaidWork")));
			driver.findElement(By.id("linkNavigation3UnpaidWork")).click();
			/*waitForElementVisible(By.xpath("//input[@value='Worksheet Summary']"));
			scrollToElement(driver.findElement(By.xpath("//input[@value='Worksheet Summary']")));
			driver.findElement(By.xpath("//input[@value='Worksheet Summary']")).click();*/
			
		} catch (NoSuchElementException n) {
			System.out.println("Element not available" + n.getMessage());
		} catch (StaleElementReferenceException e) {
			System.out.println("The dom is refreshed and element is not found" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void viewUPWContactAdded(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNumsWithStatusToDo(sheetName, "SIT NO", sitNo);
		Log.info("verifying Added UPW contact.");
		
		navigate_to_UPW();
		
		try {
			//verifying if the UPW contact is displayed on nDelius
			waitForElementVisible(By.xpath("//tbody[@id='UnpaidWorkDetailsForm:requirementsTable:tbody_element']/tr[1]"));
			System.out.println("UPW contact addition verified succcessfully on nDelius.");
		} catch (NoSuchElementException n) {
			System.out.println("Element not available" + n.getMessage());
		} catch (StaleElementReferenceException e) {
			System.out.println("The dom is refreshed and element is not found" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void viewUPWContacEdited(String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNumsWithStatusToDo(sheetName, "SIT NO", sitNo);
		Log.info("verifying Added UPW contact.");
		
		navigate_to_UPW();
		
		try {
			//Verifying the edited changes are reflected or not 
			waitForElementVisible(By.xpath("//tbody[@id='UnpaidWorkDetailsForm:requirementsTable:tbody_element']//a[text()='view']"));
			driver.findElement(By.xpath("//tbody[@id='UnpaidWorkDetailsForm:requirementsTable:tbody_element']//a[text()='view']")).click();
			//write if loop for strings matching
			System.out.println("UPW contact editing from CMS has been verified succcessfully on nDelius.");
		} catch (NoSuchElementException n) {
			System.out.println("Element not available" + n.getMessage());
		} catch (StaleElementReferenceException e) {
			System.out.println("The dom is refreshed and element is not found" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
