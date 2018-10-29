package com.meganexus.nDeliusPage;

import org.openqa.selenium.By;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;

public class RegistrationReviewPage extends RegistrationPage {
	
	String sheetName = "Registration";
	ExcelUtils excell = new ExcelUtils();
	
	public void registrationReview(String sitNo) {
		
		int rowNum = excell.getRowNums(sheetName, "SIT NO", sitNo);
		waitForElementVisible(By.xpath("//h1[contains(.,'Register Summary')]"));
		driver.findElement(By.linkText("update")).click();
	}
	
	

}
