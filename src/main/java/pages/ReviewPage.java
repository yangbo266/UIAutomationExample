package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPage {
	WebDriver driver;
	By declareBtn = By.id("react-declaration-info_truthfulness_check");
	By UEN = By.id("react-company-uen");
	By contactName = By.id("react-contact_info-name");
	By submitBtn = By.id("submit-btn");
	public ReviewPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	// wait for this page load
	public void waitForReady() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(declareBtn));
	}

	// is page displayed
	public Boolean isPageDisplayed() {
		return driver.findElement(declareBtn).isDisplayed();
	}
	
	public void clickSubmitBtn() {
		driver.findElement(submitBtn).click();
	}
	
	public void clickDeclareBtn() {
		driver.findElement(declareBtn).click();
	}
	
	public Boolean isDeclareBtnDisplayed() {
		return driver.findElement(declareBtn).isDisplayed();
	}
	
	public WebElement getUEN() {
		return driver.findElement(UEN);
	}
	
	public WebElement getContactName() {
		return driver.findElement(contactName);
	}
}
