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
import com.meganexus.cmsPage.ServiceuserCmsPage;
import com.meganexus.cmsPage.UPWContactCMSPage;
import com.meganexus.nDeliusPage.AddEventPage;
import com.meganexus.nDeliusPage.AddOffenderPage;
import com.meganexus.nDeliusPage.CommunityRequirementPage;
import com.meganexus.nDeliusPage.SearchOffenderPage;
import com.meganexus.nDeliusPage.TransferComponentPage;
import com.meganexus.nDeliusPage.UPWContactPage;

public class E2ESIT080DI_UnpaidWorkContact_Inb {
	private static final String sitNo = "E2ESIT080";
	// Creating objects of pages
	SearchOffenderPage searchOffender = new SearchOffenderPage();
	AddOffenderPage addOff = new AddOffenderPage();
	AddEventPage addEvent = new AddEventPage();
	CommunityRequirementPage addReq = new CommunityRequirementPage();
	UPWContactPage nDeliusUPWContact = new UPWContactPage();
	TransferComponentPage transfer = new TransferComponentPage();

	LoginCMSPage cmsloginPage = new LoginCMSPage();
	AcceptOffenderCMSPage accept = new AcceptOffenderCMSPage();
	ServiceuserCmsPage sUser = new ServiceuserCmsPage();
	UPWContactCMSPage cmsUPWContact = new UPWContactCMSPage();

	private String sTestCaseName;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("src/test/resources/log4j.xml");
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		Utils.openFireFoxBrowserAndLaunch_nDelius();
	}

	@Test(invocationCount = 1)
	public void unpaidWorkContactTest() throws Exception {
		Set<String> set = Utils.driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String cmsWindow = it.next();
		String nDeliusWindow = it.next();
		Utils.driver.switchTo().window(nDeliusWindow);
		Utils.maxmizeBrowser();
		searchOffender.searchOffender(sitNo);
		addOff.addOffender(sitNo);
		// method to add event for UPW
		addEvent.addEvent(sitNo);
		// method to add requirement for UPW
		addReq.addCommunityRequirement(sitNo);

		// transfer the offender and event to the CRC
		transfer.transferTo_CRC(sitNo);

		// disconnecting the VPN
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Thread.sleep(6000);

		// navigating to the CMS URL and logging in
		Utils.driver.switchTo().window(cmsWindow);

		cmsloginPage.loginToCMSApps();

		// Reading and accepting CRN number from CMS pending transfers
		accept.acceptOffender(sitNo);

		// Adding a new UPW contact from CMS
		sUser.SUmanagement();
		sUser.viewServiceUser(sitNo);
		cmsUPWContact.addUPWContact(sitNo);

		// connecting the VPN again and navigating to nDelius
		VPNConnectDisconnect.openCiscoVPN_Connect();
		Utils.driver.switchTo().window(nDeliusWindow);

		// method to view Unpaid Work Contact added(verifications)
		nDeliusUPWContact.viewUPWContactAdded(sitNo);

		/* Following code is commented due to bug IC-11589 the code will not work unless that gets fixed.
		 * // disconnecting the VPN
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Thread.sleep(6000);

		// Editing already added UPW contact
		Utils.driver.switchTo().window(cmsWindow);
		sUser.viewServiceUser(sitNo);
		cmsUPWContact.editUPWContact(sitNo);
		
		// connecting the VPN again and navigating to nDelius
		VPNConnectDisconnect.openCiscoVPN_Connect();
		Utils.driver.switchTo().window(nDeliusWindow);
		
		// method to view Unpaid Work Contact edited(verifications)
		//nDeliusUPWContact.viewUPWContactEdited(sitNo);
*/		
		// disconnecting the VPN
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Thread.sleep(6000);
		
		// Deleting the existing UPW contact
		Utils.driver.switchTo().window(cmsWindow);
		sUser.viewServiceUser(sitNo);
		cmsUPWContact.deleteUPWContact(sitNo);
	
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
