package com.meganexus.RBAC_AutomationTesting.Test;

import com.meganexus.SIT_AutomationTesting.utility.Utils;
import com.meganexus.cmsPage.AditionalidentifierCmsPage;
import com.meganexus.cmsPage.LoginCMSPage;
import com.meganexus.cmsPage.ServiceuserCmsPage;
import com.meganexus.nDeliusPage.SearchOffenderPage;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;

public class action_additional_identifier_create extends Utils {
	private static String permissions_sheet = "rbacs";
	private static String cred_sheet = "Credentials";
	private static String action = "ACTION_ADDITIONAL_IDENTIFIER_CREATE";
	private ExcelUtils excell = new ExcelUtils();

	SearchOffenderPage searchOffender = new SearchOffenderPage();
	LoginCMSPage loginPage = new LoginCMSPage();
	ServiceuserCmsPage sUser = new ServiceuserCmsPage();
	AditionalidentifierCmsPage viewIdent = new AditionalidentifierCmsPage();
	
	private String sTestCaseName;
	
	private void navigateToAddIdentifier() {
		int count = 0;
		while (count < 2) {
			try {
				Thread.sleep(3000);
				waitForElementVisible(By.xpath("//button[contains(.,'Identifiers')]"));
				driver.findElement(By.xpath("//button[contains(.,'Identifiers')]")).click();
				Thread.sleep(3000);
				waitForElementVisible(By.xpath("//a[contains(text(),'Additional Identifiers')]"));
				scrollToClickElement(driver.findElement(By.xpath("//a[contains(text(),'Additional Identifiers')]")));
				count=0;
				break;
			} catch (NoSuchElementException e) {
				count++;
				break;
			} catch (ElementNotInteractableException e) {
				System.out.println("Element is not in focus " + e.getMessage());
			} catch (StaleElementReferenceException e) {
				System.out.println("The dom is refreshed and element is not found " + e.getMessage());
			} catch (Exception e) {
				Log.error("Cms Additional Identifier Page"+e.getMessage());
			}
		}
	}
	
	private void verifyAddButton(String role, String addButtonXpath){
		// login to the CMS application using given role
		int rowNum = excell.getrbacsRowNums(cred_sheet, "Roles", role);
		String username = excell
				.getrbacsData(cred_sheet, rowNum, excell.getrbacsCellNumber(cred_sheet, "Username")).trim();
		String password = excell
				.getrbacsData(cred_sheet, rowNum, excell.getrbacsCellNumber(cred_sheet, "Password")).trim();
		loginPage.rbacs_login(username, password);
		
		rowNum = excell.getrbacsRowNums(permissions_sheet, "action_identifier", action);
		// reading the permission from rbacs sheet, 0 means false 1 means true
		String permission = excell
				.getrbacsData(permissions_sheet, rowNum, excell.getrbacsCellNumber(permissions_sheet, role)).trim();
		String crnno = excell
				.getrbacsData(permissions_sheet, rowNum, excell.getrbacsCellNumber(permissions_sheet, "CRN NO")).trim();
		System.out.println("CRN no for role : " + role + " is " + crnno);
		try {
			Thread.sleep(4000);
			sUser.viewrbacsServiceUser(crnno);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (permission.equals("0")) {
			System.out.println(role + " : " + "does not have permission to create additional identifier");
			// navigate to additional identifier
			navigateToAddIdentifier();
			// verify add button should not be visible
			try {
				Thread.sleep(5000);
				WebElement button = driver.findElement(By.xpath(addButtonXpath));
				if (button.isDisplayed()) {
					System.out.println("add button is displayed which is not expected ... hence failing the test case");
					Log.error("add button is displayed which is not expected ... hence failing the test case");
					// ITestResult.setStatus(2);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchElementException e) {
				System.out.println("Add Additional Identifier button is not present as expected.");
				Log.info("Add Additional Identifier button is not present as expected.");
			}
		}
		else if (permission.equals("1")) {
			System.out.println(role + " :" + " has permission to create additional identifier");
			// navigate to additional identifier
			navigateToAddIdentifier();
			// verify add button should be visible
			waitForElementVisible(By.xpath(addButtonXpath));
			WebElement button = driver.findElement(By.xpath(addButtonXpath));
			try {
				Thread.sleep(5000);
				if (button.isDisplayed()) {
					System.out.println("Add Additional Identifier button is present as expected.");
					Log.info("Add Additional Identifier button is present as expected.");
				}
			} catch (NoSuchElementException e) {
				System.out.println("add button is NOT displayed which is not expected ... hence failing the test case");
				Log.error("add button is NOT displayed which is not expected ... hence failing the test case");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (permission.equals(" ")){
			Log.fatal("Permission is not specified for "+role+" please check in rbacs_data file.");
		}
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("src/test/resources/log4j.xml");
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
	}

	@Test(invocationCount = 1)
	public void actionAdditionalIdentifierCreate() {
		// create driver and launch CMS url
		Utils.get_rbacs_CMS_driver();
		String addButtonXpath = "//tr-accordiontab[@header='Additional Identifiers']//button[@title='Add Record']";
		
		int rolecount = 5;
		
		for (int counter=0;counter<=rolecount;counter++){
			String role = excell
					.getrbacsData(cred_sheet, counter, excell.getrbacsCellNumber(cred_sheet, "Roles")).trim();
			if (role.equals("")){
				System.out.println("first row is skipped.");
			}
			else{
				verifyAddButton(role, addButtonXpath);
				loginPage.rbacs_logout();
			}
		}
		
		/*String role = "Community Director";
		//checking add button
		verifyAddButton(role, addButtonXpath);
		loginPage.rbacs_logout();
		
		String role = "UPW Placement Co-ordinator";
		verifyAddButton(role, addButtonXpath);
		loginPage.rbacs_logout();*/
		
	}
	
	@AfterMethod
	public void writeTestResult(ITestResult result) {
		int status = result.getStatus();
		ExcelUtils xcell = new ExcelUtils();
		int rowNum = xcell.getRowNumsWithStatusToDo(permissions_sheet, "action_identifier", action);
		switch (status) {
		case ITestResult.SUCCESS:
			xcell.writerbacsExcellFile(permissions_sheet, rowNum, xcell.getrbacsCellNumber(permissions_sheet, "Status"), "PASS");
			xcell.writerbacsExcellFile(permissions_sheet, rowNum, xcell.getrbacsCellNumber(permissions_sheet, "TestCaseExecutionDateAndTime"),
					Utils.getSysDateAndTime());
			break;
		case ITestResult.FAILURE:
			xcell.writerbacsExcellFile(permissions_sheet, rowNum, xcell.getrbacsCellNumber(permissions_sheet, "Status"), "FAIL");
			xcell.writerbacsExcellFile(permissions_sheet, rowNum, xcell.getrbacsCellNumber(permissions_sheet, "TestCaseExecutionDateAndTime"),
					Utils.getSysDateAndTime());
			break;
		case ITestResult.SKIP:
			xcell.writerbacsExcellFile(permissions_sheet, rowNum, xcell.getrbacsCellNumber(permissions_sheet, "Status"), "SKIP");
			xcell.writerbacsExcellFile(permissions_sheet, rowNum, xcell.getrbacsCellNumber(permissions_sheet, "TestCaseExecutionDateAndTime"),
					Utils.getSysDateAndTime());
			break;
		default:
			throw new RuntimeException("Invalid status");
		}
		Log.endTestCase(sTestCaseName);
		Utils.tearDown();
	}

}
