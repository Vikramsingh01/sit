package com.meganexus.cmsPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class EventCMSPage extends Utils {
	String sheetName = "Event";
	ExcelUtils excell = new ExcelUtils();
	
	public void viewEvent(String sitNo)throws InterruptedException{
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Profile')]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[contains(text(),'Summary')]")).click();
		Thread.sleep(200);
		try {
			WebElement transferTable = driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-offenderprofile-summary/tr-summary-event/div/div/div/div/div/div/table"));
			List<WebElement> rows = transferTable.findElements(By.tagName("tr"));
			for(int rNum=1; rNum<=(rows.size()-1); rNum++) {
				System.out.println(rNum +"  "+ (rows.size()-1));
				System.out.println("html/body/tr-root/div[2]/div/div[4]/tr-offenderprofile-summary/tr-summary-event/div/div/div/div/div/div/table/tbody/tr["+rNum+"]/td[4]");
				String outcome = driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-offenderprofile-summary/tr-summary-event/div/div/div/div/div/div/table/tbody/tr["+rNum+"]/td[4]")).getText().trim();
				System.out.println(outcome);
				//rowNum = excell.getRowNums("Event", "SIT NO", sitNo);
				String event= excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Outcome")).trim();
				System.out.println(event);
				if(outcome.equals(event)) {
					System.out.println("Outcome matched");
					Thread.sleep(2000);
					driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-offenderprofile-summary/tr-summary-event/div/div/div/div/div/div/table/tbody/tr["+rNum+"]/td[5]/button")).click();
				break;
				}
			}
		}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		Thread.sleep(2000);
	}

	
}