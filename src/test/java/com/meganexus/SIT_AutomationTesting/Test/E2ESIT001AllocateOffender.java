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
import com.meganexus.cmsPage.AditionalidentifierCmsPage;
import com.meganexus.cmsPage.AliasCMSPage;
import com.meganexus.cmsPage.DisabilityAdjustmentCMSPage;
import com.meganexus.cmsPage.DisabilityCMSPage;
import com.meganexus.cmsPage.EqualityMonitoringCMSPage;
import com.meganexus.cmsPage.LoginCMSPage;
import com.meganexus.cmsPage.NSICMSPage;
import com.meganexus.cmsPage.PersonalCircumstanceCMSPage;
import com.meganexus.cmsPage.PersonalContactCMSPage;
import com.meganexus.cmsPage.RegisterOutCMSPage;
import com.meganexus.cmsPage.ServiceuserCmsPage;
//import com.meganexus.nDeliusPage.AddAddressPage;
import com.meganexus.nDeliusPage.AddOffenderPage;
import com.meganexus.nDeliusPage.AddressAssessment;
import com.meganexus.nDeliusPage.AddressPage;
//import com.meganexus.nDeliusPage.AddressAssessmentPage;
import com.meganexus.nDeliusPage.AditionalIdentifierPage;
import com.meganexus.nDeliusPage.AliasPage;
import com.meganexus.nDeliusPage.DisabilityAdjustmentPage;
import com.meganexus.nDeliusPage.DisablityPage;
import com.meganexus.nDeliusPage.EqualityMonitoringPage;
import com.meganexus.nDeliusPage.NSIPage;
import com.meganexus.nDeliusPage.PersonalCircumstancePage;
import com.meganexus.nDeliusPage.PersonalContactPage;
import com.meganexus.nDeliusPage.RegistrationPage;
import com.meganexus.nDeliusPage.RestrictionListPage;
import com.meganexus.nDeliusPage.SearchOffenderPage;
import com.meganexus.nDeliusPage.TransferComponentPage;

public class E2ESIT001AllocateOffender {

	SearchOffenderPage searchOffender = new SearchOffenderPage();
	LoginCMSPage loginPage = new LoginCMSPage();
	AddOffenderPage addOff = new AddOffenderPage();
	TransferComponentPage transfer = new TransferComponentPage();
	AcceptOffenderCMSPage accept = new AcceptOffenderCMSPage();
	EqualityMonitoringPage equalityMonitoring = new EqualityMonitoringPage();
	AliasPage alias = new AliasPage();
	AddressPage addAddress = new AddressPage();
	AddressAssessment addAssessment = new AddressAssessment();
	DisablityPage addDisability = new DisablityPage();
	DisabilityAdjustmentPage addAjustment = new DisabilityAdjustmentPage();
	PersonalContactPage addContact = new PersonalContactPage();
	PersonalCircumstancePage addCircumstance = new PersonalCircumstancePage();
	RegistrationPage addRegistration = new RegistrationPage();
	AditionalIdentifierPage addIdent = new AditionalIdentifierPage();
	NSIPage addNSINPS = new NSIPage();
	RestrictionListPage addRestriction = new RestrictionListPage();
	ServiceuserCmsPage sUser = new ServiceuserCmsPage();
	EqualityMonitoringCMSPage equalityCMS = new EqualityMonitoringCMSPage();
	AliasCMSPage aliasCMS = new AliasCMSPage();
	AddressCMSPage addressCMS = new AddressCMSPage();
	AddressAssessmentCMSPage assessmentCMS = new AddressAssessmentCMSPage();
	DisabilityCMSPage disabilityCMS = new DisabilityCMSPage();
	DisabilityAdjustmentCMSPage adjustmentCMS = new DisabilityAdjustmentCMSPage();
	PersonalContactCMSPage pcontactCMS = new PersonalContactCMSPage();
	PersonalCircumstanceCMSPage circumstanceCMS = new PersonalCircumstanceCMSPage();
	RegisterOutCMSPage registrationCMS = new RegisterOutCMSPage();
	AditionalidentifierCmsPage viewIdent = new AditionalidentifierCmsPage();
	NSICMSPage nsiCMS = new NSICMSPage();
	
	private static final String sitNo = "E2ESIT001";
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
	public void allocateOffender() throws InterruptedException {

		Set<String> set = Utils.driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String cmsWindow = it.next();
		String nDeliusWindow = it.next();
		Utils.driver.switchTo().window(nDeliusWindow);
		Utils.maxmizeBrowser();
		searchOffender.searchOffender(sitNo);
		//searchOffender.searchOffenderWithCRNAndViewOffender(sitNo);
		addOff.addOffender(sitNo);
		equalityMonitoring.updateEqualityMonitoring(sitNo);
		alias.addAlias(sitNo);
		addAddress.addAddressPage(sitNo);
		addAssessment.addAddressAssessment(sitNo);
		addDisability.addDisabilityNPS(sitNo);
		addAjustment.addDisabilityAdjustment(sitNo);
		addContact.addpersonalcontact(sitNo);
		addCircumstance.addPersonalCircumstance(sitNo);
		addRegistration.addRegistrationDetails(sitNo);
		addIdent.addAditionalIdentifier(sitNo);
		addNSINPS.addNSI(sitNo);
		addRestriction.addRestrictionList(sitNo);
		searchOffender.searchExistingOffender(sitNo);
		transfer.transferTo_CRC(sitNo);
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Thread.sleep(6000);
		Utils.driver.switchTo().window(cmsWindow);
		loginPage.loginToCMSApps();
		searchOffender.searchOffenderWithCRNAndViewOffender(sitNo);
		accept.acceptOffender(sitNo);
		sUser.SUmanagement();
		sUser.viewServiceUser(sitNo);
		equalityCMS.viewEqualityMonitoring(sitNo);
		aliasCMS.viewAlias(sitNo);
		viewIdent.verifyAditionalIdentifier(sitNo);
		addressCMS.viewAddress(sitNo);
		assessmentCMS.viewAssessment(sitNo);
		disabilityCMS.ViewDisability(sitNo);
		adjustmentCMS.ViewDisabilityAdjustment(sitNo);
		pcontactCMS.viewpersonalcontact(sitNo);
		circumstanceCMS.viewPCircumstance(sitNo);
		registrationCMS.viewRegisterOut(sitNo);
		nsiCMS.viewNSICMS(sitNo);
		

	}

	@AfterMethod
	public void writeTestResult(ITestResult result) throws InterruptedException {
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