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
import com.meganexus.cmsPage.EventCMSPage;
import com.meganexus.cmsPage.LicenseConditionCMSPage;
import com.meganexus.cmsPage.LoginCMSPage;
import com.meganexus.cmsPage.RecallCMSPage;
import com.meganexus.cmsPage.ReleaseCMSPage;
import com.meganexus.cmsPage.ServiceuserCmsPage;
import com.meganexus.nDeliusPage.AddEventPage;
import com.meganexus.nDeliusPage.AddOffenderPage;
import com.meganexus.nDeliusPage.SearchOffenderPage;
import com.meganexus.nDeliusPage.TransferComponentPage;

public class E2ESIT070MCS_CustodyRecall_Inb {
	
	SearchOffenderPage searchOffender = new SearchOffenderPage();
	AddOffenderPage addOff = new AddOffenderPage();
	AddEventPage addEvent = new AddEventPage();
	TransferComponentPage transfer = new TransferComponentPage();
	LoginCMSPage loginPage = new LoginCMSPage();
	AcceptOffenderCMSPage accept = new AcceptOffenderCMSPage();
	ServiceuserCmsPage sUser = new ServiceuserCmsPage();
	EventCMSPage viewEvent = new EventCMSPage();
	ReleaseCMSPage Release=new ReleaseCMSPage();
	LicenseConditionCMSPage LicCon=new LicenseConditionCMSPage();
	RecallCMSPage Recall=new RecallCMSPage();
	private static final String sitNo = "E2ESIT070";
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
	public void addEventTest() throws Exception {
		Set<String> set = Utils.driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String cmsWindow = it.next();
		String nDeliusWindow = it.next();	
		Utils.driver.switchTo().window(nDeliusWindow);
		Utils.maxmizeBrowser();
	    searchOffender.searchOffender(sitNo);
		searchOffender.searchOffenderWithCRNAndViewOffender(sitNo);
		addOff.addOffender(sitNo);
		addEvent.addEvent(sitNo);
		Thread.sleep(6000);
		transfer.transferTo_CRC(sitNo);
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Utils.driver.switchTo().window(cmsWindow);
		Thread.sleep(10000);
		loginPage.loginToCMSApps();
		accept.acceptOffender(sitNo);
		Thread.sleep(10000);
		sUser.viewServiceUser(sitNo);
		viewEvent.viewEvent(sitNo);
		Release.addRelease(sitNo);
		LicCon.addLicenseCondition(sitNo);
		Recall.addRecall(sitNo);
		//Recall.deleteRecall(sitNo);
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
