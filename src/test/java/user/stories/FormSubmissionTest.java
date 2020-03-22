package user.stories;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import pages.BGPLoginPage;
import pages.BusinessImpactPage;
import pages.ContactPage;
import pages.CostDetailsPage;
import pages.DeclarePage;
import pages.DeclarePage.DeclareCommand;
import pages.EligibilityPage;
import pages.EligibilityPage.EligibilityCommand;
import pages.GrantPage;
import pages.OwnUserLoginPage;
import pages.ProposalPage;
import pages.ReferenceIdPage;
import pages.ReviewPage;
import pages.SectorDevFuncAreaPage;
import utils.Delay;
import utils.DriverFactory;

public class FormSubmissionTest {

	private String browserType = "Chrome";
	private WebDriver driver;
	private BGPLoginPage bgpLoginPage;
	private OwnUserLoginPage ownUserLoginPage;
	private GrantPage grantPage;
	private SectorDevFuncAreaPage sectorDevFuncAreaPage;
	private EligibilityPage eligibilityPage;
	private ContactPage contactPage;
	private ProposalPage proposalPage;
	private BusinessImpactPage businessImpactPage;
	private CostDetailsPage costDetailsPage;
	private DeclarePage declarePage;
	private ReviewPage reviewPage;
	private ReferenceIdPage referenceIdPage;

	@Before
	public void setUp() throws Exception {
		driver = DriverFactory.openWebDriver(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		bgpLoginPage = new BGPLoginPage(driver);
		ownUserLoginPage = new OwnUserLoginPage(driver);
		grantPage = new GrantPage(driver);
		sectorDevFuncAreaPage = new SectorDevFuncAreaPage(driver);
		eligibilityPage = new EligibilityPage(driver);
		contactPage = new ContactPage(driver);
		proposalPage = new ProposalPage(driver);
		businessImpactPage = new BusinessImpactPage(driver);
		costDetailsPage = new CostDetailsPage(driver);
		declarePage = new DeclarePage(driver);
		reviewPage = new ReviewPage(driver);
		referenceIdPage = new ReferenceIdPage(driver);
		// repeat
		bgpLoginPage.navigateToBGP();
		bgpLoginPage.clickCorpPassLogin();
		ownUserLoginPage.waitForReady();
		ownUserLoginPage.loginWithOwnUser();
		grantPage.waitForReady();
		grantPage.loginWithOwnUser();
		sectorDevFuncAreaPage.waitForSectorReady();
		sectorDevFuncAreaPage.selectSectorDevFunctionalAreaApplyProceed();
		eligibilityPage.waitForReady();
		eligibilityPage.clickByCommand(EligibilityCommand.REGISTER_T);
		eligibilityPage.clickByCommand(EligibilityCommand.TURNOVER_T);
		eligibilityPage.clickByCommand(EligibilityCommand.EQUITY_T);
		eligibilityPage.clickByCommand(EligibilityCommand.START_T);
		eligibilityPage.clickByCommand(EligibilityCommand.SAVE);
		eligibilityPage.clickByCommand(EligibilityCommand.NEXT);
		contactPage.waitForReady();
		contactPage.setPersonName("Tan Ah Kow");
		contactPage.setPersonJobTitle("Software Engineer");
		contactPage.setPersonContactNo("82690000");
		contactPage.setPersonEmail("test_email_01@gmail.com");
		contactPage.clickSameMailingAddressBtn();
		contactPage.clickSameAsMainContactBtn();
		contactPage.clickSaveBtn();
		contactPage.clickNextBtn();
		proposalPage.waitForReady();
		proposalPage.setProjectTitle("Participate in Trade Fair XYZ");
		proposalPage.setStartDate("29 Jan 2021");
		proposalPage.setEndDate("28 Feb 2021");
		proposalPage.setProjectDescription(
				"Describe the products/services that you will be promoting/providing in the market");
		proposalPage.setActivityInput("Overseas Marketing and PR activities");
		proposalPage.setActivityInput(Keys.ENTER);
		proposalPage.setTargetMarketInput("Anguilla");
		proposalPage.setTargetMarketInput(Keys.ENTER);
		proposalPage.clickIsNewMarket_false();
		proposalPage.clickSaveBtn();
		proposalPage.clickNextBtn();
		businessImpactPage.waitForReady();
		businessImpactPage.setImpactEndDate("29 Jan 2020");
		businessImpactPage.setImpactEndDate(Keys.ENTER);
		businessImpactPage.setOverseaSales_1("10000000");
		businessImpactPage.setOverseaSales_2("20000000");
		businessImpactPage.setOverseaSales_3("30000000");
		businessImpactPage.setOverseaSales_4("40000000");
		businessImpactPage.setOverseaInvestment_1("6000000");
		businessImpactPage.setOverseaInvestment_2("7000000");
		businessImpactPage.setOverseaInvestment_3("8000000");
		businessImpactPage.setOverseaInvestment_4("9000000");
		businessImpactPage.setRetionalRemark("Rationale for Projections XXX Test Text 001");
		businessImpactPage.setTangibleBenifits("Non Tangible Benefits XXX Test Text 001");
		businessImpactPage.clickSaveBtn();
		businessImpactPage.clickNextBtn();
		costDetailsPage.waitForReady();
		costDetailsPage.clickAddNewItemBtn();
		costDetailsPage.clickVendorOversea();
		costDetailsPage.setVendorName("Vendor Sample Name 001 ");
		costDetailsPage.setVendorName(Keys.ENTER);
		costDetailsPage.getRemarks().sendKeys("remark 3");
		// upload
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		costDetailsPage.setUploadInput(path+"\\resources\\upload_001.png");
		costDetailsPage.waitUploadComplete("upload_001.png");
		costDetailsPage.setBillingAmount("123456789");
		costDetailsPage.setBillingAmount(Keys.ENTER);
		costDetailsPage.clickSaveBtn();
		costDetailsPage.clickNextBtn();

	}

	@After
	public void tearDown() throws Exception {
		
		referenceIdPage = null;
		reviewPage = null;
		declarePage = null;
		costDetailsPage = null;
		businessImpactPage = null;
		proposalPage = null;
		contactPage = null;
		eligibilityPage = null;
		sectorDevFuncAreaPage = null;
		grantPage = null;
		ownUserLoginPage = null;
		bgpLoginPage = null;
		driver = null;
	}

	/*
	 * 
	 * AC 1: Upon filling all mandatory inputs in all 6 form sections and clicking the ‘Review’ button in the
	 * ‘Declare and Review’ section, the Applicant should be taken to a read-only summary page.
	 * 
	 */	
	@Test
	public void formSubmission_AC01() {
		//repeat
		declarePage.waitForReady();
		declarePage.clickByCommand(DeclareCommand.CRIMINAL_F);
		declarePage.clickByCommand(DeclareCommand.CIVIL_F);
		declarePage.clickByCommand(DeclareCommand.INSOLVENCY_F);
		declarePage.clickByCommand(DeclareCommand.PROJECT_INCENTIVES_F);
		declarePage.clickByCommand(DeclareCommand.OTHER_INCENTIVES_F);
		declarePage.clickByCommand(DeclareCommand.COMMENCE_F);
		declarePage.clickByCommand(DeclareCommand.RELATED_PARTY_F);
		declarePage.clickByCommand(DeclareCommand.ACKNOWLEDGEMENT_CHECK);
		declarePage.clickByCommand(DeclareCommand.SAVE);
		declarePage.clickByCommand(DeclareCommand.REVIEW);
		// main test logic
		reviewPage.waitForReady();
		reviewPage.clickDeclareBtn();
		reviewPage.clickSubmitBtn();
		// validate refer id
		referenceIdPage.waitForReady();
		String refId = referenceIdPage.getRefId();
		System.out.println("Generate Ref ID: "+ refId);
		Assert.assertTrue(null != refId && refId.length() > 1);
	}
	/*
	 * AC 2: If there are any mandatory inputs missing, a validation error should trigger and the form
	 * should redirect to the section with the missing details. An error number should also be shown in the
	 * sidebar next to the offending section.
	 * 
	 */
	@Test
	public void formSubmission_AC02() {
		//repeat with missed mandatory inputs
		declarePage.waitForReady();
		declarePage.clickByCommand(DeclareCommand.CRIMINAL_F);
		declarePage.clickByCommand(DeclareCommand.CIVIL_F);
		declarePage.clickByCommand(DeclareCommand.INSOLVENCY_F);
		declarePage.clickByCommand(DeclareCommand.PROJECT_INCENTIVES_F);
//		declarePage.clickByCommand(DeclareCommand.OTHER_INCENTIVES_F);
		declarePage.clickByCommand(DeclareCommand.COMMENCE_F);
		declarePage.clickByCommand(DeclareCommand.RELATED_PARTY_F);
		declarePage.clickByCommand(DeclareCommand.ACKNOWLEDGEMENT_CHECK);

		declarePage.clickByCommand(DeclareCommand.REVIEW);
		//AC02.1 check error trigger "There are errors in your application." on DeclarePage
		declarePage.waitForErrorTrigger();
		String errorMsg = declarePage.getErrorsInApplication().getText();
		System.out.println(errorMsg);
		Assert.assertEquals("There are errors in your application.", errorMsg);
		//AC02.2 check redirect to the section with the missing details
		Delay.sleep(500);
		errorMsg = declarePage.getOtherIncentivesAlert().getText();
		System.out.println(errorMsg);
		Assert.assertEquals("Select an option", errorMsg);
		//AC02.3 check error number in side bar TODO: enhance to find Declare & Review's follow slibing
		driver.manage().window().maximize();
		Delay.sleep(1000);
		//Assert.assertEquals("1", declarePage.getErrorNumberInSidebar().getText());
	}

	/*
	 * 
	 * AC 3: The read-only summary page should correctly contain all the details previously filled in each
	 * form section.
	 * 
	 */	
	@Test
	public void formSubmission_AC03() {
		//repeat
		declarePage.waitForReady();
		declarePage.clickByCommand(DeclareCommand.CRIMINAL_F);
		declarePage.clickByCommand(DeclareCommand.CIVIL_F);
		declarePage.clickByCommand(DeclareCommand.INSOLVENCY_F);
		declarePage.clickByCommand(DeclareCommand.PROJECT_INCENTIVES_F);
		declarePage.clickByCommand(DeclareCommand.OTHER_INCENTIVES_F);
		declarePage.clickByCommand(DeclareCommand.COMMENCE_F);
		declarePage.clickByCommand(DeclareCommand.RELATED_PARTY_F);
		declarePage.clickByCommand(DeclareCommand.ACKNOWLEDGEMENT_CHECK);
		declarePage.clickByCommand(DeclareCommand.SAVE);
		declarePage.clickByCommand(DeclareCommand.REVIEW);
		// main test logic
		reviewPage.waitForReady();
		reviewPage.clickDeclareBtn();
		
		// validate all the details (check on sampling data)
		//Assert.assertEquals("BGPQEDEMO", reviewPage.getUEN().getText());
		//Assert.assertEquals("Tan Ah Kow", reviewPage.getContactName().getText());
	}
	
	/*
	 * 
	 * AC 4: At the bottom of the read-only summary page is a final ‘Consent and Acknowledgement’
	 * checkbox.
	 * 
	 */	
	//@Test
	public void formSubmission_AC04() {
		//repeat
		declarePage.waitForReady();
		declarePage.clickByCommand(DeclareCommand.CRIMINAL_F);
		declarePage.clickByCommand(DeclareCommand.CIVIL_F);
		declarePage.clickByCommand(DeclareCommand.INSOLVENCY_F);
		declarePage.clickByCommand(DeclareCommand.PROJECT_INCENTIVES_F);
		declarePage.clickByCommand(DeclareCommand.OTHER_INCENTIVES_F);
		declarePage.clickByCommand(DeclareCommand.COMMENCE_F);
		declarePage.clickByCommand(DeclareCommand.RELATED_PARTY_F);
		declarePage.clickByCommand(DeclareCommand.ACKNOWLEDGEMENT_CHECK);
		declarePage.clickByCommand(DeclareCommand.SAVE);
		declarePage.clickByCommand(DeclareCommand.REVIEW);
		// main test logic
		reviewPage.waitForReady();
		reviewPage.clickDeclareBtn();
		
		// validate is Consent and Acknowledgement displayed
		//Assert.assertTrue(reviewPage.isDeclareBtnDisplayed());
	}
	
	/*
	 * 
	 * AC 5: Once checked, the Applicant can submit the entire Application and a Success message box
	 * should be shown. The Success message box should contain an Application Ref ID and Agency details
	 * should display the receiving Agency as ‘Enterprise Singapore’.
	 * 
	 */	
	@Test
	public void formSubmission_AC05() {
		//repeat
		declarePage.waitForReady();
		declarePage.clickByCommand(DeclareCommand.CRIMINAL_F);
		declarePage.clickByCommand(DeclareCommand.CIVIL_F);
		declarePage.clickByCommand(DeclareCommand.INSOLVENCY_F);
		declarePage.clickByCommand(DeclareCommand.PROJECT_INCENTIVES_F);
		declarePage.clickByCommand(DeclareCommand.OTHER_INCENTIVES_F);
		declarePage.clickByCommand(DeclareCommand.COMMENCE_F);
		declarePage.clickByCommand(DeclareCommand.RELATED_PARTY_F);
		declarePage.clickByCommand(DeclareCommand.ACKNOWLEDGEMENT_CHECK);
		declarePage.clickByCommand(DeclareCommand.SAVE);
		declarePage.clickByCommand(DeclareCommand.REVIEW);
		// main test logic
		reviewPage.waitForReady();
		reviewPage.clickDeclareBtn();
		reviewPage.clickSubmitBtn();
		// validate refer id
		referenceIdPage.waitForReady();
		String refId = referenceIdPage.getRefId();
		System.out.println("Generate Ref ID: "+ refId);
		Assert.assertTrue(null != refId && refId.length() > 1);
		// validate Agency Details : Enterprise Singapore
		// find Agency Details: td -> next td -> child first span -> text
	}
}
