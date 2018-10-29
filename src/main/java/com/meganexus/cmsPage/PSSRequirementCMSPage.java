package com.meganexus.cmsPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class PSSRequirementCMSPage extends Utils {
	String sheetName = "TerminatePSSR";
	ExcelUtils excell = new ExcelUtils();
	
	public void viewPSSRequirement(String sitNo)throws InterruptedException{
		int rowNum = excell.getRowNumsWithStatusToDo(sheetName, "SIT NO", sitNo);
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'Pss Requirements')]")).click();
		System.out.println("Click on PSS Requirement");
		Thread.sleep(1000);
		try {
			WebElement transferTable = driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-event-detail/tr-pss-requirement/div/div/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table"));
			List<WebElement> rows = transferTable.findElements(By.tagName("tr"));
			for(int rNum=1; rNum<=(rows.size()-1); rNum++) {
				System.out.println(rNum +""+ (rows.size()-1));
				String PSSType = driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-event-detail/tr-pss-requirement/div/div/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table/tbody/tr["+rNum+"]/td[1]")).getText().trim();
				System.out.println(PSSType);
				rowNum = excell.getRowNums("PSSR", "SIT NO", sitNo);
				String mainType = excell.getData("PSSR", rowNum, excell.getCellNumber("PSSR", "Requirement Main Type")).trim();
				if(PSSType.equals(mainType)) {
					driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-event-detail/tr-pss-requirement/div/div/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table/tbody/tr["+rNum+"]/td[6]/span[1]/button")).click();
				break;
				}
			}
		}catch (Exception e) {
				System.out.println(e.getMessage());
		}
		
		
	Thread.sleep(6000);
	driver.navigate().back();
	Thread.sleep(2000);
		
		
	}

	
}
