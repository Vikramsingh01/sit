package com.meganexus.cmsPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class TerminateCommunityRequirement extends Utils {
	private static String sheetName = "TerminateCommunityReq";
	private ExcelUtils excell = new ExcelUtils();
	
	public void terminateLicenceCondition(String sitNo)throws InterruptedException{
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
				
		scrollToElement(driver.findElement(By.xpath("(//a[contains(text(),'Requirements ')])[2]")));
		Thread.sleep(6000);
		System.out.println("Click on Community Requirement");
		driver.findElement(By.xpath("(//a[contains(text(),'Requirements ')])[2]")).click();
		Thread.sleep(1000);
		
		try {			
			waitForImplicitWait();
			WebElement transferTable = driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-event-detail/tr-community-requirement/div/div/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table"));
			List<WebElement> rows = transferTable.findElements(By.tagName("tr"));
			for(int rNum=1; rNum<=(rows.size()-1); rNum++) {
				System.out.println(rNum +""+ (rows.size()-1));
				String ReqMainType = driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-event-detail/tr-community-requirement/div/div/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table/tbody/tr["+rNum+"]/td[3]")).getText().trim();
				System.out.println(ReqMainType);
				rowNum = excell.getRowNums("Community Requirement", "SIT NO", sitNo);
				String mainType = excell.getData("Community Requirement", rowNum, excell.getCellNumber("Community Requirement", "Requirement")).trim();
				System.out.println("Print from excell" + "    "+mainType);
				if(ReqMainType.equals(mainType)) {
					driver.findElement(By.xpath("html/body/tr-root/div[2]/div/div[4]/tr-event-detail/tr-community-requirement/div/div[2]/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table/tbody/tr["+rNum+"]/td[8]/span[1]/button")).click();
												// html/body/tr-root/div[2]/div/div[4]/tr-event-detail/tr-community-requirement/div/div[2]/tr-accordion/div/tr-accordiontab/div[2]/div/div[2]/div/div/div/table/tbody/tr/td[8]/span[1]/button
					break;
				}
			}
		}catch (Exception e) {
				System.out.println(e.getMessage());
		}
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@id='Terminate Requirement']")).click();
		Thread.sleep(1000);
		rowNum = excell.getRowNums("TerminateCommunityReq", "SIT NO", sitNo);
		System.out.println(excell.getData("TerminateCommunityReq", rowNum, excell.getCellNumber("TerminateCommunityReq","Termination Date")));
		driver.findElement(By.id("actualEndDate")).sendKeys(excell.getData("TerminateCommunityReq", rowNum, excell.getCellNumber("TerminateCommunityReq", "Actual End Date")).trim());
		Thread.sleep(1000);
		selectAnElementFromText("terminationReasonId",excell.getData("TerminateCommunityReq", rowNum, excell.getCellNumber("TerminateCommunityReq", "Termination Reason")).trim());
		Thread.sleep(1000);	
		driver.findElement(By.id("note")).sendKeys(excell.getData("TerminateCommunityReq", rowNum, excell.getCellNumber("TerminateCommunityReq", "Note")).trim());
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
