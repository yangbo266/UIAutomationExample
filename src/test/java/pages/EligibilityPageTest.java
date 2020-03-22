package pages;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.EligibilityPage.EligibilityCommand;
import utils.DriverFactory;

public class EligibilityPageTest {

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
		driver = null;
	}

	@Test
	public void eligibilityTest_positive01() {
		// main test logic
		eligibilityPage.waitForReady();
		eligibilityPage.clickByCommand(EligibilityCommand.REGISTER_T);
		eligibilityPage.clickByCommand(EligibilityCommand.TURNOVER_T);
		eligibilityPage.clickByCommand(EligibilityCommand.EQUITY_T);
		eligibilityPage.clickByCommand(EligibilityCommand.START_T);
		eligibilityPage.clickByCommand(EligibilityCommand.SAVE);
		eligibilityPage.clickByCommand(EligibilityCommand.NEXT);
		// validate on next page
		contactPage.waitForReady();
		Assert.assertTrue(contactPage.isPageDisplayed());
	}

}
