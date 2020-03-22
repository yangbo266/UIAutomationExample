package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReferenceIdPage {
	WebDriver driver;
	By refIdLabel = By.xpath("//td[contains(text(), 'Ref ID:')]");
	By refIdTD = By.xpath("//td[contains(text(), 'Ref ID:')]/following-sibling::td");
	public ReferenceIdPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	// wait for this page load
	public void waitForReady() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(refIdLabel));
	}

	// is page displayed
	public Boolean isPageDisplayed() {
		return driver.findElement(refIdLabel).isDisplayed();
	}
	
	public String getRefId() {
		return driver.findElement(refIdTD).getText();
	}
}
