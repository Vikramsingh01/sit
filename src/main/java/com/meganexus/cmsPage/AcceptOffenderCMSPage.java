package com.meganexus.cmsPage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Utils;

public class AcceptOffenderCMSPage extends Utils {
	//SanketBiraje
	
	ExcelUtils xcell = new ExcelUtils();
	String sheetName = "OffenderDetails";

	@SuppressWarnings("static-access")
	public void acceptOffender(String sitNo) throws InterruptedException {
		int rowNum = xcell.getRowNums(sheetName, "SIT NO", sitNo);
		int cellNum = xcell.getCellNumber(sheetName, "CRN NO");
		String crnNo = xcell.getData(sheetName, rowNum, cellNum).trim();
		System.out.println(crnNo);
		waitForElementVisible(By.id("SU Admin"));
		driver.findElement(By.id("SU Admin")).click();
		waitForImplicitWait();
		Thread.sleep(2000);
		scrollToClickElement(driver.findElement(By.xpath("//button[contains(text(),'Pending Transfers')]")));
		waitForElementVisible(By.id("filter"));
		scrollToClickElement(driver.findElement(By.id("filter")));
		waitForElementVisible(By.id("crn"));
		driver.findElement(By.id("crn")).sendKeys(crnNo);
		Thread.sleep(2000);
		waitForElementVisible(By.xpath("//button[text()='Search']"));
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("pendingTransfer_view0")).click();
		waitForImplicitWait();
		
		try {
			WebElement transferTable = driver.findElement(By.id("ConsolatedTransferRequestListTable"));
			List<WebElement> rows = transferTable.findElements(By.tagName("tr"));
			System.out.println("Going in loop");
			for(int rNum=1; rNum<=rows.size(); rNum++) {
				System.out.println(rows.size());
				waitForImplicitWait();
				System.out.println("//table[@id='ConsolatedTransferRequestListTable']/tbody/tr["+rNum+"]/td[5]/span/button");
				Thread.sleep(10000);
				String component = driver.findElement(By.xpath("//table[@id='ConsolatedTransferRequestListTable']/tbody/tr["+rNum+"]/td[1]")).getText().trim();
				System.out.println(component);
				if(component.equals("Service User")) {
					System.out.println("Component is Service user");
					waitForElementClickable(driver.findElement(By.xpath("//table[@id='ConsolatedTransferRequestListTable']/tbody/tr["+rNum+"]/td[5]/span/button")));
					driver.findElement(By.xpath("//table[@id='ConsolatedTransferRequestListTable']/tbody/tr["+rNum+"]/td[5]/span/button")).click();
					Thread.sleep(10000);
					waitForImplicitWait();
					System.out.println("Allocation Page");
					rowNum = xcell.getRowNums("AcceptOffender", "SIT NO", sitNo);
					System.out.println(xcell.getData("AcceptOffender", rowNum, xcell.getCellNumber("AcceptOffender", "Team")).trim());
					System.out.println(xcell.getData("AcceptOffender", rowNum, xcell.getCellNumber("AcceptOffender", "Officer")).trim());
					selectAnElementFromText("teamId", xcell.getData("AcceptOffender", rowNum, xcell.getCellNumber("AcceptOffender", "Team")).trim());
					waitForImplicitWait();
					selectAnElementFromText("officerId", xcell.getData("AcceptOffender", rowNum, xcell.getCellNumber("AcceptOffender", "Officer")).trim());
					waitForImplicitWait();
					System.out.println("Band avaialble");
					selectAnElementFromText("bandId", xcell.getData("AcceptOffender", rowNum, xcell.getCellNumber("AcceptOffender", "Band")).trim());
					driver.findElement(By.id("saveButton")).click();
					waitForImplicitWait();
								
				}else {
					waitForElementClickable(driver.findElement(By.xpath("//table[@id='ConsolatedTransferRequestListTable']/table/tbody/tr["+rNum+"]/td[5]/span/button")));
					driver.findElement(By.xpath("//table[@id='ConsolatedTransferRequestListTable']/tbody/tr["+rNum+"]/td[5]/span/button")).click();
					Thread.sleep(10000);
					waitForImplicitWait();
					System.out.println("Allocation Page");
					rowNum = xcell.getRowNums("AcceptOffender", "SIT NO", sitNo);
					System.out.println(xcell.getData("AcceptOffender", rowNum, xcell.getCellNumber("AcceptOffender", "Team")).trim());
					System.out.println(xcell.getData("AcceptOffender", rowNum, xcell.getCellNumber("AcceptOffender", "Officer")).trim());
					selectAnElementFromText("teamId", xcell.getData("AcceptOffender", rowNum, xcell.getCellNumber("AcceptOffender", "Team")).trim());
					waitForImplicitWait();
					selectAnElementFromText("officerId", xcell.getData("AcceptOffender", rowNum, xcell.getCellNumber("AcceptOffender", "Officer")).trim());
					waitForImplicitWait();
					driver.findElement(By.id("saveButton")).click();
					waitForImplicitWait();
				}					
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
					
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('saveButton').focus();");
		((JavascriptExecutor)driver).executeScript("window.focus();");
		System.out.println("Submit button found");
		driver.manage().timeouts().setScriptTimeout(40,TimeUnit.SECONDS);
		Thread.sleep(15000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		waitForImplicitWait();

	}

}
