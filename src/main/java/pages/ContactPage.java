package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
	WebDriver driver;
	By personName = By.id("react-contact_info-name");
	By personNameLabel = By.id("react-contact_info-name-label");
    By personJobTitle = By.id("react-contact_info-designation");
    By personJobTitleLabel = By.id("react-contact_info-designation-label");
    By personContactNo = By.id("react-contact_info-phone");
    By personContactNoLabel = By.id("react-contact_info-phone-label");
    By personEmail = By.id("react-contact_info-primary_email");
    By personEmailLabel = By.id("react-contact_info-primary_email-label");
    By alterEmailLabel = By.id("react-contact_info-secondary_email-label");
    By alterEmail = By.id("react-contact_info-secondary_email");
    //mail address
    By postalCode = By.id("react-contact_info-correspondence_address-postal");
    By searchOneMap = By.id("react-contact_info-correspondence_address-postal-postal");
    By blockNo = By.id("react-contact_info-correspondence_address-block");
    By street = By.id("react-contact_info-correspondence_address-street");
    By level = By.id("react-contact_info-correspondence_address-level");
    By unit = By.id("react-contact_info-correspondence_address-unit");
    //same mail address
    By sameMailingAddressBtn = By.id("react-contact_info-correspondence_address-copied");
    //same contact ppl
    By sameAsMainContactBtn = By.id("react-contact_info-copied");
    // contact ppl
    By contactName = By.id("react-contact_info-offeree_name");
    By contactJobTitle = By.id("react-contact_info-offeree_designation");
    By contactEmail = By.id("react-contact_info-offeree_email");
	By saveBtn = By.id("save-btn");
	By nextBtn = By.id("next-btn");
	
	public ContactPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getContactName() {
		return driver.findElement(contactName);
	}

	public WebElement getContactJobTitle() {
		return driver.findElement(contactJobTitle);
	}

	public WebElement getContactEmail() {
		return driver.findElement(contactEmail);
	}

	public WebElement getPersonName() {
		return driver.findElement(personName);
	}

	public WebElement getPersonNameLabel() {
		return driver.findElement(personNameLabel);
	}

	public WebElement getPersonJobTitle() {
		return driver.findElement(personJobTitle);
	}

	public WebElement getPersonJobTitleLabel() {
		return driver.findElement(personJobTitleLabel);
	}

	public WebElement getPersonContactNo() {
		return driver.findElement(personContactNo);
	}

	public WebElement getPersonContactNoLabel() {
		return driver.findElement(personContactNoLabel);
	}

	public WebElement getPersonEmail() {
		return driver.findElement(personEmail);
	}

	public WebElement getPersonEmailLabel() {
		return driver.findElement(personEmailLabel);
	}

	public WebElement getAlterEmailLabel() {
		return driver.findElement(alterEmailLabel);
	}

	public WebElement getAlterEmail() {
		return driver.findElement(alterEmail);
	}

	public WebElement getPostalCode() {
		return driver.findElement(postalCode);
	}

	public WebElement getSearchOneMap() {
		return driver.findElement(searchOneMap);
	}

	public WebElement getBlockNo() {
		return driver.findElement(blockNo);
	}

	public WebElement getStreet() {
		return driver.findElement(street);
	}

	public WebElement getLevel() {
		return driver.findElement(level);
	}

	public WebElement getUnit() {
		return driver.findElement(unit);
	}

	public void setPersonName(String personNameStr) {
		driver.findElement(personName).sendKeys(personNameStr);
	}

	public void setPersonJobTitle(String personJobTitleStr) {
		driver.findElement(personJobTitle).sendKeys(personJobTitleStr);
	}

	public void setPersonContactNo(String personContactNoStr) {
		driver.findElement(personContactNo).sendKeys(personContactNoStr);
	}

	public void setPersonEmail(String personEmailStr) {
		driver.findElement(personEmail).sendKeys(personEmailStr);
	}

	public void clickSameMailingAddressBtn() {
		driver.findElement(sameMailingAddressBtn).click();
	}

	public void clickSameAsMainContactBtn() {
		driver.findElement(sameAsMainContactBtn).click();
	}

	public void clickSaveBtn() {
		driver.findElement(saveBtn).click();
	}

	public void clickNextBtn() {
		driver.findElement(nextBtn).click();
	}

	// wait for this page load
	public void waitForReady() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(personName));
	}
	
	// is page displayed
	public Boolean isPageDisplayed() {
		return driver.findElement(personName).isDisplayed();
	}
}
