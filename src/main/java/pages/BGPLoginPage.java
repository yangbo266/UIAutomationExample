package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Delay;

public class BGPLoginPage {

	WebDriver driver;
	By corpPassLoginBtn = By.xpath("//*[text()='Login with CorpPass']");
	By pageNotFound = By.xpath("//*[text()='Page Not Found']");

	public BGPLoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// Navigate to BPG Login https://bgp-qa.gds-gov.tech with user name public + pwd
	// Let$BeC001
	public void navigateToBGP() {
		driver.get("https://public:Let$BeC001@bgp-qa.gds-gov.tech");
		Delay.sleep(2000);
		if(driver.findElements(pageNotFound).size() != 0) {
			Delay.sleep(4000);
			driver.get("https://public:Let$BeC001@bgp-qa.gds-gov.tech");
		}
	}

	// Click on CorpPass login button
	public void clickCorpPassLogin() {
		WebDriverWait waitCropPassLoginButton = new WebDriverWait(driver, 30);
		waitCropPassLoginButton.until(ExpectedConditions.visibilityOfElementLocated(corpPassLoginBtn));
		driver.findElement(corpPassLoginBtn).click();
	}

	// Logo
	protected Boolean isHeaderLogoDisplayed() {
		return driver.findElement(By.id("sgds-bgp-header-logo")).isDisplayed();
	}
}