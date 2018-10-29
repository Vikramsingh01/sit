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
import com.meganexus.cmsPage.AddressAssessmentCMSPage;
import com.meganexus.cmsPage.AddressCMSPage;
import com.meganexus.cmsPage.LoginCMSPage;
import com.meganexus.cmsPage.ServiceuserCmsPage;
import com.meganexus.nDeliusPage.AddOffenderPage;
import com.meganexus.nDeliusPage.AddressAssessment;
import com.meganexus.nDeliusPage.AddressPage;
import com.meganexus.nDeliusPage.SearchOffenderPage;
import com.meganexus.nDeliusPage.TransferComponentPage;

public class E2ESIT006Address_Inb {
	SearchOffenderPage searchOffender = new SearchOffenderPage();
	LoginCMSPage loginPage = new LoginCMSPage();
	AddOffenderPage addOff = new AddOffenderPage();
	TransferComponentPage transfer = new TransferComponentPage();
	AcceptOffenderCMSPage accept = new AcceptOffenderCMSPage();
	AddressCMSPage addAddress = new AddressCMSPage();
	AddressPage viewaddress = new AddressPage(); 
	AddressAssessmentCMSPage assessCMS = new AddressAssessmentCMSPage();
	AddressAssessment assessment = new AddressAssessment();
	ServiceuserCmsPage sUser = new ServiceuserCmsPage();
	private static final String sitNo = "E2ESIT006";
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
		public void AddAddress() throws InterruptedException {

			Set<String> set = Utils.driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			String cmsWindow = it.next();
			String nDeliusWindow = it.next();
			Utils.driver.switchTo().window(nDeliusWindow);
			Utils.maxmizeBrowser();
			searchOffender.searchOffender(sitNo);
			//searchOffender.searchOffenderWithCRNAndViewOffender(sitNo);
			addOff.addOffender(sitNo);
			transfer.transferTo_CRC(sitNo);
			VPNConnectDisconnect.openCiscoVPN_Disconnect();
			Thread.sleep(6000);
			Utils.driver.switchTo().window(cmsWindow);
			loginPage.loginToCMSApps();
			accept.acceptOffender(sitNo);
			sUser.SUmanagement();
			sUser.viewServiceUser(sitNo);
			Thread.sleep(6000);
			addAddress.addaddress(sitNo);
			Thread.sleep(6000);
			VPNConnectDisconnect.openCiscoVPN_Connect();
			Utils.driver.switchTo().window(nDeliusWindow);
			Thread.sleep(6000);			
			viewaddress.viewAddress(sitNo);
			Thread.sleep(6000);
			VPNConnectDisconnect.openCiscoVPN_Disconnect();
			Utils.driver.switchTo().window(cmsWindow);
			Thread.sleep(6000);
			addAddress.editaddress(sitNo);
			VPNConnectDisconnect.openCiscoVPN_Connect();
			Utils.driver.switchTo().window(nDeliusWindow);
			Thread.sleep(6000);
			viewaddress.viewEditAddressIN(sitNo);
			Thread.sleep(6000);
			VPNConnectDisconnect.openCiscoVPN_Disconnect();
			Utils.driver.switchTo().window(cmsWindow);
			Thread.sleep(6000);
			assessCMS.addassessment(sitNo);
			Thread.sleep(6000);
			VPNConnectDisconnect.openCiscoVPN_Connect();
			Utils.driver.switchTo().window(nDeliusWindow);
			Thread.sleep(6000);
			assessment.viewAssessmentIN(sitNo);
			Thread.sleep(6000);
			VPNConnectDisconnect.openCiscoVPN_Disconnect();
			Utils.driver.switchTo().window(cmsWindow);
			Thread.sleep(6000);
			assessCMS.editassessment(sitNo);
			Thread.sleep(6000);
			VPNConnectDisconnect.openCiscoVPN_Connect();
			Utils.driver.switchTo().window(nDeliusWindow);
			Thread.sleep(6000);
			assessment.vieweditAssessmentIN(sitNo);
			Thread.sleep(6000);
			VPNConnectDisconnect.openCiscoVPN_Disconnect();
			Utils.driver.switchTo().window(cmsWindow);
			Thread.sleep(6000);
			assessCMS.deleteassessment(sitNo);
			Thread.sleep(6000);			
			//sUser.viewServiceUser(sitNo);
			Thread.sleep(2000);
			
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
