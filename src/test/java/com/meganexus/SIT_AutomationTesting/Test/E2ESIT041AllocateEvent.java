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
import com.meganexus.cmsPage.InstitutionalReportCMSPage;
import com.meganexus.cmsPage.LicenceConditionCMSPage;
import com.meganexus.cmsPage.LoginCMSPage;
import com.meganexus.cmsPage.PSSRequirementCMSPage;
import com.meganexus.cmsPage.ServiceuserCmsPage;
import com.meganexus.nDeliusPage.AddEventPage;
import com.meganexus.nDeliusPage.AddOffenderPage;
import com.meganexus.nDeliusPage.InstitutionalReportPage;
import com.meganexus.nDeliusPage.LicenceConditionPage;
import com.meganexus.nDeliusPage.PSSRequirementPage;
import com.meganexus.nDeliusPage.ReleasePage;
import com.meganexus.nDeliusPage.SearchOffenderPage;
import com.meganexus.nDeliusPage.TransferComponentPage;

public class E2ESIT041AllocateEvent{
	SearchOffenderPage searchOffender = new SearchOffenderPage();
	LoginCMSPage loginPage = new LoginCMSPage();
	AddOffenderPage addOff = new AddOffenderPage();
	TransferComponentPage transfer = new TransferComponentPage();
	AcceptOffenderCMSPage accept = new AcceptOffenderCMSPage();
	AddEventPage addevent = new AddEventPage();
	ReleasePage addRelease = new ReleasePage();
	LicenceConditionPage addlicencecondition = new LicenceConditionPage();
	LicenceConditionCMSPage viewlic = new LicenceConditionCMSPage();
	PSSRequirementPage addpssreq = new PSSRequirementPage();
	PSSRequirementCMSPage viewpss = new PSSRequirementCMSPage();
	InstitutionalReportPage instReport = new InstitutionalReportPage();
	InstitutionalReportCMSPage institutionalReport = new InstitutionalReportCMSPage();
	ServiceuserCmsPage sUser = new ServiceuserCmsPage();
	EventCMSPage viewEvent = new EventCMSPage();
	private static final String sitNo = "E2ESIT041";
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
		addOff.addOffender(sitNo);
		addevent.addEvent(sitNo);
		addRelease.forceRelease(sitNo);
		addlicencecondition.addLicenceCondition(sitNo);
		addpssreq.addPSSRequirement(sitNo);
		instReport.institutionalReport(sitNo);
		transfer.transferTo_CRC(sitNo);
		Thread.sleep(6000);
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Thread.sleep(6000);
		Utils.driver.switchTo().window(cmsWindow);
		Thread.sleep(2000);
		loginPage.loginToCMSApps();
		accept.acceptOffender(sitNo);
		sUser.viewServiceUser(sitNo);
		viewEvent.viewEvent(sitNo);
		viewlic.viewLicenceCondition(sitNo);
		viewpss.viewPSSRequirement(sitNo);
		institutionalReport.viewInstitutionalReport(sitNo);
		VPNConnectDisconnect.openCiscoVPN_Connect();
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