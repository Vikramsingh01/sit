package com.meganexus.nDeliusPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class TransferComponentPage extends Utils {
	//transfer offender to crc - Tapan Sahoo
	
	//SanketBiraje -Update + Dynamic Table handling 
	ExcelUtils excell = new ExcelUtils();
	String sheetName = "TransferOffender";
	
	public void transferTo_CRC (String sitNo) throws InterruptedException {
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		//waitForElementPresent(By.linkText("Offender Index")); //Manish
		driver.findElement(By.linkText("Offender Index")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Offender Transfer Request")).click();
		Thread.sleep(2000);
		selectAnElementFromText("offenderTransferRequestListForm:Trust", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Provider")).trim());
		Thread.sleep(3000);
		WebElement cluster = driver.findElement(By.xpath("//select[@id='offenderTransferRequestListForm:Cluster']"));
		cluster.sendKeys(excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Cluster")));
		Thread.sleep(2000);
		selectAnElementFromText("offenderTransferRequestListForm:LDU", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "LDU")).trim());
		Thread.sleep(3000);
		selectAnElementFromText("offenderTransferRequestListForm:Team", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Team")).trim());
		Thread.sleep(3000);
		selectAnElementFromText("offenderTransferRequestListForm:Staff", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "Officer")).trim());
		Thread.sleep(3000);
		
		try {
			WebElement transferTable = driver.findElement(By.id("offenderTransferRequestListForm:offenderTransferRequestTable"));
			List<WebElement> rows = transferTable.findElements(By.tagName("tr"));
			for(int rNum=0; rNum<=(rows.size()-2); rNum++) {
				System.out.println(rNum +""+ (rows.size()-1));
				selectAnElementFromText("offenderTransferRequestListForm:offenderTransferRequestTable:"+rNum+":TransferReason", excell.getData(sheetName, rowNum, excell.getCellNumber(sheetName, "ReasonForTransfer")).trim());
				
			}
					
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
				
		scrollToElement(driver.findElement(By.id("offenderTransferRequestListForm:j_id_id146")));
		//Thread.sleep(1000);
		driver.findElement(By.id("offenderTransferRequestListForm:j_id_id146")).click();
		Thread.sleep(3000);
		
		}


}
