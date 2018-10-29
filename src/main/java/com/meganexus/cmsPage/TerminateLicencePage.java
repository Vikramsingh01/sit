package com.meganexus.cmsPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class TerminateLicencePage extends Utils {
	private static String sheetName = "TerminateLicenceCondition";
	private ExcelUtils excell = new ExcelUtils();
	
	public void terminateLicenceCondition(String sitNo)throws InterruptedException{
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
				
		scrollToElement(driver.findElement(By.xpath("//a[contains(text(),'Licence Conditions')]")));
		Thread.sleep(6000);
		System.out.println("Click on Licence Condition");
		driver.findElement(By.xpath("//a[contains(text(),'Licence Conditions')]")).click();
		Thread.sleep(1000);
		
		try {			
			waitForImplicitWait();
			WebElement transferTable = driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-event-detail/tr-licence-condition/div/div/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table"));
			List<WebElement> rows = transferTable.findElements(By.tagName("tr"));
			for(int rNum=1; rNum<=(rows.size()-1); rNum++) {
				System.out.println(rNum +""+ (rows.size()-1));
				String licMainType = driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-event-detail/tr-licence-condition/div/div/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table/tbody/tr["+rNum+"]/td[1]")).getText().trim();
				System.out.println(licMainType);
				rowNum = excell.getRowNums("Licence Condition", "SIT NO", sitNo);
				String mainType = excell.getData("Licence Condition", rowNum, excell.getCellNumber("Licence Condition", "Licence Condition")).trim();
				System.out.println("Print from excell" + "    "+mainType);
				System.out.println(excell.getData("Licence Condition", rowNum, excell.getCellNumber("Licence Condition", "Referral Date")).trim());
						
				if(licMainType.equals(mainType)) {
					driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-event-detail/tr-licence-condition/div/div/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table/tbody/tr["+rNum+"]/td[6]/span[1]/button")).click();
				break;
				}
			}
		}catch (Exception e) {
				System.out.println(e.getMessage());
		}
		
		Thread.sleep(6000);
		driver.findElement(By.id("Terminate Licence Condition")).click();
		Thread.sleep(1000);
		rowNum = excell.getRowNums("TerminateLicenceCondition", "SIT NO", sitNo);
		System.out.println(excell.getData("TerminateLicenceCondition", rowNum, excell.getCellNumber("TerminateLicenceCondition","Termination Date")));
		driver.findElement(By.id("actualEndDate")).sendKeys(excell.getData("TerminateLicenceCondition", rowNum, excell.getCellNumber("TerminateLicenceCondition", "Termination Date")).trim());
		Thread.sleep(1000);
		selectAnElementFromText("terminationReasonId",excell.getData("TerminateLicenceCondition", rowNum, excell.getCellNumber("TerminateLicenceCondition", "Reason")).trim());
		Thread.sleep(1000);	
		driver.findElement(By.id("terminate-note")).sendKeys(excell.getData("TerminateLicenceCondition", rowNum, excell.getCellNumber("TerminateLicenceCondition", "Notes")).trim());
		Thread.sleep(1000);
		
		/*try {
			driver.findElement(By.id("attendanceCount")).sendKeys(xcell.getData(sheetName, rowNum, xcell.getCellNumber(sheetName, "Attendance Count")).trim());	
		}
		catch(Exception e){
			e.getMessage();
		}*/
		
			
		Thread.sleep(1000);
		driver.findElement(By.id("saveButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(), 'Ok')]")).click();
		Thread.sleep(2000);
	}

	
}
