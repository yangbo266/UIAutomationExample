package user.stories;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.BGPLoginPage;
import pages.ContactPage;
import pages.EligibilityPage;
import pages.GrantPage;
import pages.OwnUserLoginPage;
import pages.ProposalPage;
import pages.SectorDevFuncAreaPage;
import pages.EligibilityPage.EligibilityCommand;
import utils.Delay;
import utils.DriverFactory;

public class ContactDetailsSectionStory {

	private String browserType = "Chrome";
	private WebDriver driver;
	private BGPLoginPage bgpLoginPage;
	private OwnUserLoginPage ownUserLoginPage;
	private GrantPage grantPage;
	private SectorDevFuncAreaPage sectorDevFuncAreaPage;
	private EligibilityPage eligibilityPage;
	private ContactPage contactPage;
	private ProposalPage proposalPage;

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
	}

	@After
	public void tearDown() throws Exception {
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
	 * As an Applicant, I should be able to input values for the Main Contact Person
	 * and Letter of Offeree in the Contact Details page.
	 * 
	 */

	// AC 1: The page contains a ‘Main Contact Person’ subsection with the following
	// inputs:
	//  Name
	//  Job Title
	//  Contact No
	//  Email
	//  Alternate Contact Person’s Email
	//  Mailing Address
	@Test
	public void contactPageTest_AC01() {
		// wait page load complete
		contactPage.waitForReady();
		// check name
		Assert.assertTrue(contactPage.getPersonName().isDisplayed());
		Assert.assertTrue(contactPage.getPersonNameLabel().isDisplayed());
		// check job title
		Assert.assertTrue(contactPage.getPersonJobTitle().isDisplayed());
		Assert.assertTrue(contactPage.getPersonJobTitleLabel().isDisplayed());
		// check contact no
		Assert.assertTrue(contactPage.getPersonContactNo().isDisplayed());
		Assert.assertTrue(contactPage.getPersonContactNoLabel().isDisplayed());
		// check email
		Assert.assertTrue(contactPage.getPersonEmail().isDisplayed());
		Assert.assertTrue(contactPage.getPersonEmailLabel().isDisplayed());
		// check alternate person email
		Assert.assertTrue(contactPage.getAlterEmail().isDisplayed());
		Assert.assertTrue(contactPage.getAlterEmailLabel().isDisplayed());
		// check mail address items
		Assert.assertTrue(contactPage.getPostalCode().isDisplayed());
		Assert.assertTrue(contactPage.getSearchOneMap().isDisplayed());
		Assert.assertTrue(contactPage.getBlockNo().isDisplayed());
		Assert.assertTrue(contactPage.getStreet().isDisplayed());
		Assert.assertTrue(contactPage.getLevel().isDisplayed());
		Assert.assertTrue(contactPage.getUnit().isDisplayed());
	}

	// AC 2: The Mailing Address input should be able to take in a valid postal code
	// which auto-populates
	// the ‘Blk/Hse No.’ and ‘Street details’ from an external API (One-map).
	@Test
	public void contactPageTest_AC02() {
		// wait page load complete
		contactPage.waitForReady();
		contactPage.getPostalCode().sendKeys("478935");
		contactPage.getSearchOneMap().click();
		//Assert.assertEquals("19", contactPage.getBlockNo().getAttribute("value"));
		//Assert.assertEquals("BEDOK RESERVOIR VIEW", contactPage.getStreet().getAttribute("value"));
	}

	// AC 3: Alternatively, there should be a checkbox ‘Same as registered address
	// in Company Profile’
	// which will auto-populate Mailing Address details from the Applicant’s Company
	// Profile.
	@Test
	public void contactPageTest_AC03() {
		// wait page load complete
		contactPage.waitForReady();
		contactPage.clickSameMailingAddressBtn();
		Delay.sleep(1000);
		//Assert.assertEquals("453123", contactPage.getPostalCode().getAttribute("value"));
		Assert.assertEquals("45", contactPage.getBlockNo().getAttribute("value"));
		Assert.assertEquals("CHOA CHU KANG CENTRAL", contactPage.getStreet().getAttribute("value"));
		Assert.assertEquals("03", contactPage.getLevel().getAttribute("value"));
		Assert.assertEquals("19", contactPage.getUnit().getAttribute("value"));
	}

	// AC 4: The page also contains a ‘Letter of Offer Addressee’ subsection with
	// the following inputs:
	//  Name
	//  Job Title
	//  Email
	@Test
	public void contactPageTest_AC04() {
		// wait page load complete
		contactPage.waitForReady();
		// check contact name
		Assert.assertTrue(contactPage.getContactName().isDisplayed());
		// check job title
		Assert.assertTrue(contactPage.getContactJobTitle().isDisplayed());
		// check contact email
		Assert.assertTrue(contactPage.getContactEmail().isDisplayed());
	}

	// AC 5: There should be an option ‘Same as main contact person’ which will
	// populate the subsection
	// in AC 4 with details from the ‘Main Contact Person’ in AC 1.
	@Test
	public void contactPageTest_AC05() {
		// wait page load complete
		contactPage.waitForReady();
		// check contact details copy logic
		contactPage.setPersonName("Tan Ah Kow");
		contactPage.setPersonJobTitle("Software Engineer");
		contactPage.setPersonContactNo("82690000");
		contactPage.setPersonEmail("test_email_01@govtech.com");
		contactPage.clickSameAsMainContactBtn();
		Delay.sleep(1000);
		Assert.assertEquals("Tan Ah Kow", contactPage.getContactName().getAttribute("value"));
		Assert.assertEquals("Software Engineer", contactPage.getContactJobTitle().getAttribute("value"));
		Assert.assertEquals("test_email_01@govtech.com", contactPage.getContactEmail().getAttribute("value"));

	}

	// AC 6: Clicking ‘Save’ will save the Applicant’s inputs and refreshing the
	// page should reload the saved
	// values.
	@Test
	public void contactPageTest_AC06() {
		// wait page load complete
		contactPage.waitForReady();
		// check save then refresh logic
		contactPage.waitForReady();
		contactPage.setPersonName("Tan Ah Kow");
		contactPage.setPersonJobTitle("Software Engineer");
		contactPage.setPersonContactNo("82690000");
		contactPage.setPersonEmail("test_email_01@govtech.com");
		contactPage.clickSameMailingAddressBtn();
		contactPage.clickSameAsMainContactBtn();

		Assert.assertEquals("Tan Ah Kow", contactPage.getContactName().getAttribute("value"));
		Assert.assertEquals("Software Engineer", contactPage.getContactJobTitle().getAttribute("value"));
		Assert.assertEquals("test_email_01@govtech.com", contactPage.getContactEmail().getAttribute("value"));
		contactPage.clickSaveBtn();
		Delay.sleep(1000);
		driver.navigate().refresh();
		Delay.sleep(100);
		contactPage.waitForReady();
		Assert.assertEquals("Tan Ah Kow", contactPage.getContactName().getAttribute("value"));
		Assert.assertEquals("Software Engineer", contactPage.getContactJobTitle().getAttribute("value"));
		Assert.assertEquals("test_email_01@govtech.com", contactPage.getContactEmail().getAttribute("value"));
	}

}
