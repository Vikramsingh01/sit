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
import com.meganexus.cmsPage.DrugTestCMSPage;
import com.meganexus.cmsPage.DrugTestProfileCMSPage;
import com.meganexus.cmsPage.LoginCMSPage;
import com.meganexus.cmsPage.ReferralCMSPage;
import com.meganexus.cmsPage.ServiceuserCmsPage;
import com.meganexus.nDeliusPage.AddEventPage;
import com.meganexus.nDeliusPage.AddOffenderPage;
import com.meganexus.nDeliusPage.CommunityRequirementPage;
import com.meganexus.nDeliusPage.DrugTestPage;
import com.meganexus.nDeliusPage.DrugTestProfilePage;
import com.meganexus.nDeliusPage.ReferralPage;
import com.meganexus.nDeliusPage.SearchOffenderPage;
import com.meganexus.nDeliusPage.TransferComponentPage;

public class E2ESIT082DI_DrugsTest_Inb {

	SearchOffenderPage searchOffender = new SearchOffenderPage();
	LoginCMSPage loginPage = new LoginCMSPage();
	AddOffenderPage addOff = new AddOffenderPage();
	TransferComponentPage transfer = new TransferComponentPage();
	AcceptOffenderCMSPage accept = new AcceptOffenderCMSPage();
	AddEventPage addEvent = new AddEventPage();
	ServiceuserCmsPage sUser = new ServiceuserCmsPage();
	ReferralCMSPage refCMS = new ReferralCMSPage();
	ReferralPage ref = new ReferralPage();
	CommunityRequirementPage commReq = new CommunityRequirementPage();
	DrugTestProfileCMSPage drugProfileCMS = new DrugTestProfileCMSPage();
	DrugTestProfilePage drugProfile = new DrugTestProfilePage();
	DrugTestCMSPage drugTestCMS = new DrugTestCMSPage();
	DrugTestPage drugTest = new DrugTestPage();
	private static final String sitNo = "E2ESIT082";
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
	public void drugTestTest() throws InterruptedException {
		Set<String> set = Utils.driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		String cmsWindow = it.next();
		String nDeliusWindow = it.next();

		Utils.driver.switchTo().window(nDeliusWindow);
		Utils.maxmizeBrowser();
		Thread.sleep(3000);
		searchOffender.searchOffender(sitNo);
		Thread.sleep(3000);
		addOff.addOffender(sitNo);
		Thread.sleep(3000);
		addEvent.addEvent(sitNo);
		Thread.sleep(3000);
		transfer.transferTo_CRC(sitNo);

		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Utils.driver.switchTo().window(cmsWindow);

		loginPage.loginToCMSApps();

		accept.acceptOffender(sitNo);
		Thread.sleep(6000);
		VPNConnectDisconnect.openCiscoVPN_Connect();
		Utils.driver.switchTo().window(nDeliusWindow);
		Thread.sleep(3000);
		addEvent.viewEvent(sitNo);
		commReq.navigateToCommReqmnt();
		commReq.addCommunityRequirement(sitNo);
		Thread.sleep(6000);

		//Add Referral in CMS
		VPNConnectDisconnect.openCiscoVPN_Disconnect(); 
		Utils.driver.switchTo().window(cmsWindow);
		Thread.sleep(6000);
		sUser.SUmanagement();
		sUser.viewServiceUser(sitNo);
		refCMS.clickAddReferralBtn();
		refCMS.addReferralDetails(sitNo);
		Thread.sleep(3000);

		//View Referral and Add drug test profile in Ndelius	
		VPNConnectDisconnect.openCiscoVPN_Connect();
		Utils.driver.switchTo().window(nDeliusWindow); 
		Thread.sleep(6000);
		searchOffender.searchOffenderWithCRNAndViewOffender(sitNo);
		addEvent.viewEvent(sitNo);
		ref.viewReferral(sitNo);
		Thread.sleep(3000);
		drugProfile.addDrugTestProfile(sitNo);

		//Add drug test profile in CMS
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Utils.driver.switchTo().window(cmsWindow);
		Thread.sleep(6000);
		refCMS.clickViewReferralBtn();
		Thread.sleep(5000);
		drugProfileCMS.addDrugTestProfile(sitNo);
		Thread.sleep(3000);
		//Add drug test in CMS
		drugTestCMS.addDrugTest(sitNo);
		Thread.sleep(3000);
		
		//View Drug Test after add in Ndelius 
		VPNConnectDisconnect.openCiscoVPN_Connect();
		Utils.driver.switchTo().window(nDeliusWindow);
		Thread.sleep(6000);
		drugTest.viewDrugTestAfterAdd(sitNo);
		Thread.sleep(3000);
		
		//Update drug test in CMS
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Utils.driver.switchTo().window(cmsWindow);
		Thread.sleep(6000);
		drugTestCMS.updateDrugTest(sitNo);
		Thread.sleep(3000);
		
		//View Drug Test after update in Ndelius 
		VPNConnectDisconnect.openCiscoVPN_Connect();
		Utils.driver.switchTo().window(nDeliusWindow); 
		Thread.sleep(6000);
		drugTest.viewDrugTestAfterUpdate(sitNo);
		Thread.sleep(3000);
		
		//Delete drug test in CMS
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Utils.driver.switchTo().window(cmsWindow);
		Thread.sleep(10000);
		drugTestCMS.clickDeleteDrugResultBtn();
		Thread.sleep(3000);
		
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
