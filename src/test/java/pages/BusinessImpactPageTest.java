package pages;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import pages.EligibilityPage.EligibilityCommand;
import utils.DriverFactory;

public class BusinessImpactPageTest {

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

	}

	@After
	public void tearDown() throws Exception {
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

	@Test
	public void businessImpactPageTest01() {
		// main test logic
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
		// validate on next page
		costDetailsPage.waitForReady();
		Assert.assertTrue(costDetailsPage.isPageDisplayed());
	}

}
