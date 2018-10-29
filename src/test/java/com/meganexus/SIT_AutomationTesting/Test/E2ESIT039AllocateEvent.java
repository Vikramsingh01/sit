package com.meganexus.SIT_AutomationTesting.Test;

/**
 * @author Amardeep.Patil
 * 
 */

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.meganexus.SIT_AutomationTesting.utility.Log;
import com.meganexus.SIT_AutomationTesting.utility.Utils;
import com.meganexus.SIT_AutomationTesting.utility.VPNConnectDisconnect;
import com.meganexus.cmsPage.AcceptOffenderCMSPage;
import com.meganexus.cmsPage.AdditionalOffenceCMSPage;
import com.meganexus.cmsPage.AdditionalSentenceCMSPage;
import com.meganexus.cmsPage.CommRequirmentPage;
import com.meganexus.cmsPage.CourtReportCMSPage;
import com.meganexus.cmsPage.EventCMSPage;
import com.meganexus.cmsPage.LoginCMSPage;
import com.meganexus.cmsPage.ServiceuserCmsPage;
import com.meganexus.nDeliusPage.AddEventPage;
import com.meganexus.nDeliusPage.AddOffenderPage;
import com.meganexus.nDeliusPage.AdditionalOffencePage;
import com.meganexus.nDeliusPage.AdditionalSentencesPage;
import com.meganexus.nDeliusPage.ApprovedPremesisAdmissionPage;
import com.meganexus.nDeliusPage.ApprovedPremisesReferalPage;
import com.meganexus.nDeliusPage.CommunityRequirementPage;
import com.meganexus.nDeliusPage.CourtReportPage;
import com.meganexus.nDeliusPage.ReferralPage;
import com.meganexus.nDeliusPage.SearchOffenderPage;
import com.meganexus.nDeliusPage.TransferComponentPage;

public class E2ESIT039AllocateEvent {
	
	
	SearchOffenderPage searchOffender = new SearchOffenderPage();
	AddOffenderPage addOff = new AddOffenderPage();
	AddEventPage addEvent = new AddEventPage();
	TransferComponentPage transfer = new TransferComponentPage();
	LoginCMSPage loginPage = new LoginCMSPage();
	AcceptOffenderCMSPage accept = new AcceptOffenderCMSPage();
	ServiceuserCmsPage sUser = new ServiceuserCmsPage();
	EventCMSPage viewEvent = new EventCMSPage();
	CommunityRequirementPage commReq =new CommunityRequirementPage();
	CourtReportPage courtReport = new CourtReportPage();
	AdditionalOffencePage addOffence =new AdditionalOffencePage();
	AdditionalSentencesPage addSentence = new AdditionalSentencesPage();
	ApprovedPremisesReferalPage appPremicesRef = new ApprovedPremisesReferalPage();
	ApprovedPremesisAdmissionPage appPremiceAdmission = new ApprovedPremesisAdmissionPage();
	ReferralPage referral =  new ReferralPage();
	private static final String sitNo = "E2ESIT039";
	private String sTestCaseName;
	CommRequirmentPage commReqCMS = new CommRequirmentPage();
	CourtReportCMSPage courtCMSReport =new CourtReportCMSPage();
	AdditionalOffenceCMSPage addOffenceCMS =new AdditionalOffenceCMSPage();
	AdditionalSentenceCMSPage addSenCMS =new AdditionalSentenceCMSPage();
	
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
		addEvent.addEvent(sitNo);
		commReq.addCommunityRequirement(sitNo);
	    courtReport.addCourtReport(sitNo);
		addOffence.addAdditionalOffence(sitNo);
		addSentence.addAdditionalSentences(sitNo);
		appPremicesRef.addApprovedPremisesReferal(sitNo);
		//appPremiceAdmission.addApprovedPremisisAdmission(sitNo);
		referral.addReferral(sitNo);
		transfer.transferTo_CRC(sitNo);
		VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Thread.sleep(6000);
		Utils.driver.switchTo().window(cmsWindow);
		loginPage.loginToCMSApps();
		//accept.acceptOffender(sitNo);
		Thread.sleep(6000);
		sUser.SUmanagement();
		sUser.viewServiceUser(sitNo);
		commReqCMS.verifyCommunityReq(sitNo);
		courtCMSReport.verifyCourtReport(sitNo);
		addOffenceCMS.verifyAddtionalOffence(sitNo);
		//addSenCMS.verifyAdditionaSentenceCMS(sitNo);
		/*VPNConnectDisconnect.openCiscoVPN_Disconnect();
		Thread.sleep(6000);
		Utils.driver.switchTo().window(cmsWindow);
		Thread.sleep(2000);
		loginPage.loginToCMSApps();
		accept.acceptOffender(sitNo);
		sUser.viewServiceUser(sitNo);
		viewEvent.viewEvent(sitNo);*/
		
		
	}
	
	

}
