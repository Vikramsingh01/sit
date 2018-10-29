package com.meganexus.SIT_AutomationTesting.Test;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.meganexus.SIT_AutomationTesting.utility.ExcelUtils;
import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;
import com.meganexus.SIT_AutomationTesting.utility.VPNConnectDisconnect;
import com.meganexus.cmsPage.AcceptOffenderCMSPage;
import com.meganexus.cmsPage.LoginCMSPage;
import com.meganexus.cmsPage.RegisterOutCMSPage;
import com.meganexus.cmsPage.ServiceuserCmsPage;
import com.meganexus.nDeliusPage.AddOffenderPage;
import com.meganexus.nDeliusPage.RegistrationPage;
import com.meganexus.nDeliusPage.SearchOffenderPage;
import com.meganexus.nDeliusPage.TransferComponentPage;

public class E2ESIT017Registration_Out {

	SearchOffenderPage searchOffender = new SearchOffenderPage();
	LoginCMSPage loginPage = new LoginCMSPage();
	AddOffenderPage addOff = new AddOffenderPage();
	TransferComponentPage transfer = new TransferComponentPage();
	AcceptOffenderCMSPage accept = new AcceptOffenderCMSPage();
	RegistrationPage addRegistration = new RegistrationPage();
	ServiceuserCmsPage sUser = new ServiceuserCmsPage();
	RegisterOutCMSPage regOutCMS = new RegisterOutCMSPage();
	private static final String sitNo = "E2ESIT017";
	private String sTestCaseName;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("src/test/resources/log4j.xml");
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		Utils.openFireFoxBrowserAndLaunch_nDelius();
	}

	@Test
	public void addResisterOutTest() throws InterruptedException {

		Set<String> set = Utils.driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String cmsWindow = it.next();
		String nDeliusWindow = it.next();
		Utils.driver.switchTo().window(nDeliusWindow);
		Utils.maxmizeBrowser();
		searchOffender.searchOffender(sitNo);
		addOff.addOffender(sitNo);
		transfer.transferTo_CRC(sitNo);
		Thread.sleep(6000);
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Thread.sleep(6000);
		Utils.driver.switchTo().window(cmsWindow);
		loginPage.loginToCMSApps();
		accept.acceptOffender(sitNo);
		Thread.sleep(6000);
		VPNConnectDisconnect.openCiscoVPN_Connect();
		Thread.sleep(6000);
		Utils.driver.switchTo().window(nDeliusWindow);
		Thread.sleep(6000);
		addRegistration.addRegistrationDetails("E2ESIT017");
		Thread.sleep(6000);
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Thread.sleep(6000);
		Utils.driver.switchTo().window(cmsWindow);
		sUser.viewServiceUser(sitNo);
		Thread.sleep(2000);
		Thread.sleep(2000);
		regOutCMS.viewRegisterOut(sitNo);

		VPNConnectDisconnect.openCiscoVPN_Connect();
		Thread.sleep(6000);
		Utils.driver.switchTo().window(nDeliusWindow);
		Thread.sleep(6000);
		addRegistration.editRegistrationDetails("E2ESIT017");
		Thread.sleep(6000);
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Thread.sleep(6000);
		Utils.driver.switchTo().window(cmsWindow);
		//sUser.viewServiceUser(sitNo);
		//Thread.sleep(2000);
		Thread.sleep(2000);
		regOutCMS.viewUpdateRegisterOut(sitNo);

	}

	@AfterMethod
	public void writeTestResult(ITestResult result) {
		int status = result.getStatus();
		ExcelUtils xcell = new ExcelUtils();
		String sheetName = "OffenderDetails";
		int rowNum = xcell.getRowNumsWithStatusToDo(sheetName, "SIT NO", sitNo);
		switch (status) {
		case ITestResult.SUCCESS:
			xcell.writeExcellFile(sheetName, rowNum, xcell.getCellNumber(sheetName, "Status"), "PASS");
			xcell.writeExcellFile(sheetName, rowNum, xcell.getCellNumber(sheetName, "TestCaseExecutionDateAndTime"),
					Utils.getSysDateAndTime());
			break;
		case ITestResult.FAILURE:
			xcell.writeExcellFile(sheetName, rowNum, xcell.getCellNumber(sheetName, "Status"), "FAIL");
			xcell.writeExcellFile(sheetName, rowNum, xcell.getCellNumber(sheetName, "TestCaseExecutionDateAndTime"),
					Utils.getSysDateAndTime());
			break;
		case ITestResult.SKIP:
			xcell.writeExcellFile(sheetName, rowNum, xcell.getCellNumber(sheetName, "Status"), "SKIP");
			xcell.writeExcellFile(sheetName, rowNum, xcell.getCellNumber(sheetName, "TestCaseExecutionDateAndTime"),
					Utils.getSysDateAndTime());
			break;
		default:
			throw new RuntimeException("Invalid status");
		}
		Log.endTestCase(sTestCaseName);
		Utils.tearDown();
	}

}
