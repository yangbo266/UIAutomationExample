package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SectorDevFuncAreaPage {
	WebDriver driver;
	By sectorIT = By.id("IT");
	By devAreaBringOverSeas = By.xpath("//div[contains(text(), 'Bring my business overseas')]");
	By functionalAreaMarketAssistance = By.xpath("//div[contains(text(), 'Market Readiness Assistance')]");
	By applyBtn = By.id("go-to-grant");
	By proceedBtn = By.id("keyPage-form-button");

	public SectorDevFuncAreaPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// wait for this page load
	public void waitForSectorReady() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sectorIT));
	}

	// wait for Dev load
	public void waitForDevelopmentAreaReady() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(devAreaBringOverSeas));
	}

	// wait for Func load
	public void waitForFunctionalAreaReady() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(functionalAreaMarketAssistance));
	}

	// wait for Proceed load
	public void waitForProceedPageReady() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedBtn));
	}

	// Click Apply then Proceed
	public void selectSectorDevFunctionalAreaApplyProceed() {
		driver.findElement(sectorIT).click();
		waitForDevelopmentAreaReady();
		driver.findElement(devAreaBringOverSeas).click();
		waitForFunctionalAreaReady();
		driver.findElement(functionalAreaMarketAssistance).click();
		driver.findElement(applyBtn).click();
		waitForProceedPageReady();
		driver.findElement(proceedBtn).click();

	}

	// is sector displayed
	public Boolean isSectorDisplayed() {
		return driver.findElement(sectorIT).isDisplayed();
	}
}
