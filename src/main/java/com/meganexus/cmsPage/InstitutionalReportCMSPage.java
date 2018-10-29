package com.meganexus.cmsPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class InstitutionalReportCMSPage extends Utils {
	String sheetName = "Institutional Report";
	ExcelUtils excell = new ExcelUtils();
	
	public void viewInstitutionalReport(String sitNo)throws InterruptedException{
		int rowNum = excell.getRowNumsWithStatusToDo(sheetName, "SIT NO", sitNo);
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()='Through The Gate']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Institutional Report')]")).click();
		Thread.sleep(1000);
		
		try {
			WebElement transferTable = driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-institutional-report/div/div[2]/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table"));
			List<WebElement> rows = transferTable.findElements(By.tagName("tr"));
			for(int rNum=1; rNum<=(rows.size()-1); rNum++) {
				System.out.println(rNum +""+ (rows.size()-1));
				String PSSType = driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-institutional-report/div/div[2]/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table/tbody/tr["+rNum+"]/td[3]/span")).getText().trim();
				System.out.println(PSSType);
				rowNum = excell.getRowNums("Institutional Report", "SIT NO", sitNo);
				String mainType = excell.getData("Institutional Report", rowNum, excell.getCellNumber("Institutional Report", "RequestedReportType")).trim();
				if(PSSType.equals(mainType)) {
					driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-institutional-report/div/div[2]/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table/tbody/tr["+rNum+"]/td[7]/span[1]/button")).click();
				break;
				}
			}
		}catch (Exception e) {
				System.out.println(e.getMessage());
		}
		
		
	Thread.sleep(6000);
	driver.navigate().back();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[contains(text(),'Event Details')]")).click();
	Thread.sleep(2000);
		
		
	}

	
}
