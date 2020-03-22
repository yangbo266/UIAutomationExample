/**
 * 
 */
package pages;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import utils.DriverFactory;

/**
 * @author Yang Bo
 *
 */
public class BGPLoginPageTest {

	private String browserType = "Chrome";
	private WebDriver driver;
	private BGPLoginPage bgpLoginPage;
	private OwnUserLoginPage ownUserLoginPage;
	@Before
	public void setUp() throws Exception {
		driver = DriverFactory.openWebDriver(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		bgpLoginPage = new BGPLoginPage(driver);
		ownUserLoginPage = new OwnUserLoginPage(driver);
		// repeat
		bgpLoginPage.navigateToBGP();
	}

	@After
	public void tearDown() throws Exception {
		ownUserLoginPage = null;
		bgpLoginPage = null;
		driver = null;
	}

	@Test
	public void testNavigateToBGP() {
		// main test logic
		bgpLoginPage.navigateToBGP();
		// validate on next page
		Assert.assertTrue(bgpLoginPage.isHeaderLogoDisplayed());
	}

	@Test
	public void testClickCorpPassLogin() {

		// main test logic
		bgpLoginPage.clickCorpPassLogin();
		// validate on next page
		ownUserLoginPage.waitForReady();
		Assert.assertTrue(ownUserLoginPage.isOwnUserLoginBtnDisplayed());
	}

}
