package pages;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import utils.DriverFactory;

public class SectorDevFuncAreaPageTest {
	private String browserType = "Chrome";
	private WebDriver driver;
	private BGPLoginPage bgpLoginPage;
	private OwnUserLoginPage ownUserLoginPage;
	private GrantPage grantPage;
	private SectorDevFuncAreaPage sectorDevFuncAreaPage;
	private EligibilityPage eligibilityPage;

	@Before
	public void setUp() throws Exception {
		driver = DriverFactory.openWebDriver(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		bgpLoginPage = new BGPLoginPage(driver);
		ownUserLoginPage = new OwnUserLoginPage(driver);
		grantPage = new GrantPage(driver);
		sectorDevFuncAreaPage = new SectorDevFuncAreaPage(driver);
		eligibilityPage = new EligibilityPage(driver);
		// repeat
		bgpLoginPage.navigateToBGP();
		bgpLoginPage.clickCorpPassLogin();
		ownUserLoginPage.waitForReady();
		ownUserLoginPage.loginWithOwnUser();
		grantPage.waitForReady();
		grantPage.loginWithOwnUser();
	}

	@After
	public void tearDown() throws Exception {
		eligibilityPage = null;
		sectorDevFuncAreaPage = null;
		grantPage = null;
		ownUserLoginPage = null;
		bgpLoginPage = null;
		driver = null;
	}

	@Test
	public void testSelectSectorDevFunctionalAreaApply() {

		// main test logic
		sectorDevFuncAreaPage.waitForSectorReady();
		sectorDevFuncAreaPage.selectSectorDevFunctionalAreaApplyProceed();
		// validate on next page
		eligibilityPage.waitForReady();
		Assert.assertTrue(eligibilityPage.isPageDisplayed());
	}

}
