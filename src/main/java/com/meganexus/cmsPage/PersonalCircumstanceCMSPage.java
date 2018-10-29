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

public class PersonalCircumstanceCMSPage extends Utils {

	String sheetName = "Personal Circumstance";
	ExcelUtils excell = new ExcelUtils();

	public void viewPCircumstance(String sitNo) throws InterruptedException {
		Log.info("Viewing Personal circumstance");
		int count = 0;
		while (count < 2) {
			try {
				int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
				driver.findElement(By.xpath("//button[contains(text(),'Personal Circumstances')]")).click();
				Thread.sleep(3000);

				// driver.findElement(By.xpath("//button[@id='address_view0']")).click();

				WebElement CircumstanceTypeCMS = driver
						.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[1]"));
				String CircumstanceType = CircumstanceTypeCMS.getText().trim();
				Assert.assertEquals(CircumstanceType,
						excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Personal Circumstance Type"))
								.trim());

				System.out.println("Circumstance Type");

				// table[@class="table table-bordered"]/tbody/tr[1]/td[1]
				WebElement CircumstanceSubTypeCMS = driver
						.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]"));
				String CircumstanceSubType = CircumstanceSubTypeCMS.getText().trim();
				Assert.assertEquals(CircumstanceSubType, excell
						.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Personal Circumstance Subtype"))
						.trim());

				System.out.println("Circumstance sub Type");

				WebElement StartDate = driver
						.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]"));
				String dateone = StartDate.getText().trim();
				System.out.println(dateone);
				if (excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Start Date"))
						.equalsIgnoreCase(dateone)) {

					/*
					 * WebElement StartDateCMS = driver .findElement(By.
					 * xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]")); String
					 * startDate = StartDateCMS.getText().trim();
					 */
					Assert.assertEquals(dateone,
							excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Start Date")).trim());

					System.out.println("Start Date");
				} else {
					WebElement StartDateCMS = driver
							.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[3]"));
					String startDate = StartDateCMS.getText().trim();
					System.out.println(StartDateCMS);
					Assert.assertEquals(startDate,
							excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Start Date")).trim());
				}

				WebElement EndDateCMS = driver
						.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[4]"));
				String endDate = EndDateCMS.getText().trim();
				Assert.assertEquals(endDate,
						excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "End Date")).trim());

				System.out.println("End Date");

				System.out.println("Personal circumstance Verified -CMS");

				driver.findElement(By.xpath("//button[@id='personalcircumstance_view0']")).click();
				Thread.sleep(3000);

				/*
				 * WebElement EvidencedCMS = driver .findElement(By.
				 * xpath("//table[@class=\"table table-bordered\"]/tbody/tr[1]/td[4]")); String
				 * evidenced = EvidencedCMS.getText().trim(); Assert.assertEquals(evidenced,
				 * excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName,
				 * "Evidenced")).trim());
				 * 
				 * WebElement NotesCMS =
				 * driver.findElement(By.xpath("//button[@id='personalcircumstance_view0']"));
				 * System.out.println(NotesCMS); String notes = NotesCMS.getText();
				 * Assert.assertEquals(notes, excell.getData(sheetName, rowNum,
				 * excell.getCellNumber(sheetName, "notes")));
				 */
				System.out.println("personal circumstance verified");

				count = 0;
				break;

			} catch (NoSuchElementException e) {
				count++;
				break;
			} catch (ElementNotInteractableException e) {
				System.out.println("Element is not in focus " + e.getMessage());
			} catch (StaleElementReferenceException e) {
				System.out.println("The dom is refreshed and element is not found " + e.getMessage());
			} catch (Exception e) {
				Log.error("CMS Personal Circumstance Page" + e.getMessage());
			}
		}
	}

}