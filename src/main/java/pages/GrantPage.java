package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GrantPage {

	WebDriver driver;
	By getNewGrantBtn = By.xpath("//*[text()='Get new grant']");

	public GrantPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// wait for this page load
	public void waitForReady() {
		WebDriverWait waitGetNewGrant = new WebDriverWait(driver, 60);
		waitGetNewGrant.until(ExpectedConditions.visibilityOfElementLocated(getNewGrantBtn));
	}

	// Select 'Get New Grant' on the 'My Grants' dashboard to enter the Grant
	// Picker.
	public void loginWithOwnUser() {
		driver.findElement(getNewGrantBtn).click();
	}

	// is New Grant displayed
	public Boolean isGetNewGrantBtnDisplayed() {
		return driver.findElement(getNewGrantBtn).isDisplayed();
	}

}
