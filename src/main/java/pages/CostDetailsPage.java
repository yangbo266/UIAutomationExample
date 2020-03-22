package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CostDetailsPage {

	WebDriver driver;
	By addNewItemBtn = By.id("react-project_cost-vendors-add-item");
	By vendorSingapore = By.id("react-project_cost-vendors-0-local_vendor-true");
	By vendorOversea = By.id("react-project_cost-vendors-0-local_vendor-false");
	By vendorName = By.id("react-project_cost-vendors-0-vendor_name");
	// upload
	By uploadInput = By.id("react-project_cost-vendors-0-attachments-input");
	By billingAmount = By.id("react-project_cost-vendors-0-amount_in_billing_currency");
	By remarks = By.id("react-project_cost-remarks");
	By saveBtn = By.id("save-btn");
	By nextBtn = By.id("next-btn");

	public CostDetailsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// wait for this page load
	public void waitForReady() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
	}

	// is page displayed
	public Boolean isPageDisplayed() {
		return driver.findElement(addNewItemBtn).isDisplayed();
	}

	// is new item page displayed
	public Boolean isNewItemPageDisplayed() {
		return driver.findElement(vendorSingapore).isDisplayed();
	}

	public void clickSaveBtn() {
		driver.findElement(saveBtn).click();
	}

	public void clickNextBtn() {
		driver.findElement(nextBtn).click();
	}

	public void clickAddNewItemBtn() {
		driver.findElement(addNewItemBtn).click();
	}
	
	public void clickRemarks() {
		driver.findElement(remarks).click();
	}
	
	public WebElement getRemarks() {
		return driver.findElement(remarks);
	}

	public void setVendorName(String vendorNameStr) {
		driver.findElement(vendorName).sendKeys(vendorNameStr);
	}

	public void setVendorName(Keys enter) {
		driver.findElement(vendorName).sendKeys(enter);
	}

	public void setUploadInput(String uploadInputStr) {
		driver.findElement(uploadInput).sendKeys(uploadInputStr);
	}

	public void setBillingAmount(String billingAmountStr) {
		driver.findElement(billingAmount).sendKeys(billingAmountStr);
	}

	public void setBillingAmount(Keys enter) {
		driver.findElement(billingAmount).sendKeys(enter);
	}

	public void clickVendorSingapore() {
		driver.findElement(vendorSingapore).click();
	}

	public void clickVendorOversea() {
		driver.findElement(vendorOversea).click();
	}

	public void waitUploadComplete(String fileName) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + fileName + "']")));
	}

}
