package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OwnUserLoginPage {

	WebDriver driver;
	By NRICInputLine = By.name("CPUID");
	By nameInputLine = By.name("CPUID_FullName");
	By UENInputLine = By.name("CPEntID");
	By roleInputLine = By.name("CPRole");
	By ownUserLoginBtn = By.xpath("//form[2]//button[1]");

	// constructor
	public OwnUserLoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// wait for this page load
	public void waitForReady() {
		WebDriverWait waitOwnUserLoginBtn = new WebDriverWait(driver, 30);
		waitOwnUserLoginBtn.until(ExpectedConditions.visibilityOfElementLocated(ownUserLoginBtn));
	}

	// Login with your own user flow
	public void loginWithOwnUser() {
		WebElement weNRIC = driver.findElement(NRICInputLine);
		weNRIC.clear();
		weNRIC.sendKeys("S1234567A");

		WebElement weUserName = driver.findElement(nameInputLine);
		weUserName.clear();
		weUserName.sendKeys("Tan Ah Kow");

		WebElement weUEM = driver.findElement(UENInputLine);
		weUEM.clear();
		weUEM.sendKeys("BGPQEDEMO");

		WebElement weRole = driver.findElement(roleInputLine);
		weRole.sendKeys("Acceptor");

		WebElement weLoginBtn = driver.findElement(ownUserLoginBtn);
		weLoginBtn.click();
	}

	// Input CPUID
	protected Boolean isOwnUserLoginBtnDisplayed() {
		return driver.findElement(NRICInputLine).isDisplayed();
	}

}
