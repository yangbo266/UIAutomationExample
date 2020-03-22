package user.stories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.BGPLoginPage;
import pages.ContactPage;
import pages.EligibilityPage;
import pages.EligibilityPage.EligibilityCommand;
import pages.GrantPage;
import pages.OwnUserLoginPage;
import pages.SectorDevFuncAreaPage;
import utils.Delay;
import utils.DriverFactory;

public class EligibilitySectionStory {

	private String browserType = "Chrome";
	private WebDriver driver;
	private BGPLoginPage bgpLoginPage;
	private OwnUserLoginPage ownUserLoginPage;
	private GrantPage grantPage;
	private SectorDevFuncAreaPage sectorDevFuncAreaPage;
	private EligibilityPage eligibilityPage;
	private ContactPage contactPage;

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
		// repeat
		bgpLoginPage.navigateToBGP();
		bgpLoginPage.clickCorpPassLogin();
		ownUserLoginPage.waitForReady();
		ownUserLoginPage.loginWithOwnUser();
		grantPage.waitForReady();
		grantPage.loginWithOwnUser();
		sectorDevFuncAreaPage.waitForSectorReady();
		sectorDevFuncAreaPage.selectSectorDevFunctionalAreaApplyProceed();
	}

	@After
	public void tearDown() throws Exception {
		contactPage = null;
		eligibilityPage = null;
		sectorDevFuncAreaPage = null;
		grantPage = null;
		ownUserLoginPage = null;
		bgpLoginPage = null;
//		driver.close();
		driver = null;

	}

	/*
	 * AC 1: The section should contain 4 questions: AC1.1 Is the applicant
	 * registered in Singapore? AC1.2 Is the applicant's group sales turnover less
	 * than or equal to S$100m or is the applicant's group employment size less than
	 * or equal to 200? AC1.3 Does the applicant have at least 30% local equity?
	 * AC1.4 Are all the following statements true for this project? AC1.4.1 The
	 * applicant has not started work on this project AC1.4.2 The applicant has not
	 * made any payment to any supplier, vendor, or third party prior to applying
	 * for this grant AC1.4.3 The applicant has not signed any contractual agreement
	 * with any supplier, vendor, or third party prior to applying for this grant
	 * 
	 */
	@Test
	public void eligibilitySectionStoryTest_AC01() {
		// wait page load complete
		eligibilityPage.waitForReady();
		// AC1.1
		String actualText = eligibilityPage.getTextOfRegisteredSingapore().replace("\n", "").replaceAll("\\*", "")
				.trim();
		System.out.println(actualText);
		Assert.assertEquals("Is the applicant registered in Singapore?", actualText);
		// AC1.2
		actualText = eligibilityPage.getTextOfTurnOver().replace("\n", "").replaceAll("\\*", "").trim();
		System.out.println(actualText);
		Assert.assertEquals(
				"Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's group employment size less than or equal to 200?",
				actualText);
		// AC1.3
		actualText = eligibilityPage.getTextOfEquity().replace("\n", "").replaceAll("\\*", "").trim();
		System.out.println(actualText);
		Assert.assertEquals("Does the applicant have at least 30% local equity?", actualText);
		// AC1.4
		actualText = eligibilityPage.getTextOfStatementTrue().replace("\n", "").replaceAll("\\*", "").trim();
		System.out.println(actualText);
		Assert.assertTrue(actualText.contains("statements true for this project?"));
	}

	// AC 2: Each question can be answered Yes or No through radio buttons.
	@Test
	public void eligibilitySectionStoryTest_AC02() {
		eligibilityPage.waitForReady();
		Assert.assertTrue(eligibilityPage.isDisplayByCommand(EligibilityCommand.REGISTER_T));
		Assert.assertTrue(eligibilityPage.isDisplayByCommand(EligibilityCommand.REGISTER_F));
		Assert.assertTrue(eligibilityPage.isDisplayByCommand(EligibilityCommand.TURNOVER_T));
		Assert.assertTrue(eligibilityPage.isDisplayByCommand(EligibilityCommand.TURNOVER_F));
		Assert.assertTrue(eligibilityPage.isDisplayByCommand(EligibilityCommand.EQUITY_T));
		Assert.assertTrue(eligibilityPage.isDisplayByCommand(EligibilityCommand.EQUITY_F));
		Assert.assertTrue(eligibilityPage.isDisplayByCommand(EligibilityCommand.START_T));
		Assert.assertTrue(eligibilityPage.isDisplayByCommand(EligibilityCommand.START_F));
	}

	// AC 3: Answering No for any of the questions should display a warning message
	// ‘Visit Smart Advisor on the SME Portal for more information on other
	// government assistance.’
	@Test
	public void eligibilitySectionStoryTest_AC03() {
		eligibilityPage.waitForReady();
		eligibilityPage.clickByCommand(EligibilityCommand.REGISTER_F);
		Assert.assertEquals(1, eligibilityPage.countWarningMsg());
		eligibilityPage.clickByCommand(EligibilityCommand.TURNOVER_F);
		Assert.assertEquals(2, eligibilityPage.countWarningMsg());
		eligibilityPage.clickByCommand(EligibilityCommand.EQUITY_F);
		Assert.assertEquals(3, eligibilityPage.countWarningMsg());
		eligibilityPage.clickByCommand(EligibilityCommand.START_F);
		Assert.assertEquals(4, eligibilityPage.countWarningMsg());
	}

	// AC 4: Clicking the link in the warning message in AC 3 will launch a website
	// in another window tab to the url:
	// https://www.smeportal.sg/content/smeportal/en/moneymatters.html#saText
	@Test
	public void eligibilitySectionStoryTest_AC04() {
		eligibilityPage.waitForReady();
		eligibilityPage.clickByCommand(EligibilityCommand.REGISTER_F);
		//check if url in warning msg displayed
		Assert.assertTrue(eligibilityPage.isDisplayByCommand(EligibilityCommand.ADVISOR));
		//click thr url
		eligibilityPage.clickByCommand(EligibilityCommand.ADVISOR);
		//get all tabs of browser
		Delay.sleep(100);
		List<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("moneymatters.html"));
		driver.switchTo().window(tabs.get(0));
	}
	
	// AC 5: Clicking ‘Save’ will save the Applicant’s inputs and refreshing the
	// page should reload the saved values.
	@Test
	public void eligibilitySectionStoryTest_AC05() {
		eligibilityPage.waitForReady();
		eligibilityPage.clickByCommand(EligibilityCommand.REGISTER_T);
		eligibilityPage.clickByCommand(EligibilityCommand.TURNOVER_F);
		eligibilityPage.clickByCommand(EligibilityCommand.EQUITY_T);
		eligibilityPage.clickByCommand(EligibilityCommand.START_F);
		Assert.assertEquals(2, eligibilityPage.countWarningMsg());
		// check save then refresh logic
		eligibilityPage.clickByCommand(EligibilityCommand.SAVE);
		Delay.sleep(1000);
		driver.navigate().refresh();
		Delay.sleep(100);
		eligibilityPage.waitForReady();
		Assert.assertEquals(2, eligibilityPage.countWarningMsg());
	}


}
