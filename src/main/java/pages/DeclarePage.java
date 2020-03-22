package pages;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Delay;

public class DeclarePage {

	public enum DeclareCommand {
		CRIMINAL_F, CRIMINAL_T, CIVIL_F, CIVIL_T, INSOLVENCY_F, INSOLVENCY_T, PROJECT_INCENTIVES_F, PROJECT_INCENTIVES_T, OTHER_INCENTIVES_F, OTHER_INCENTIVES_T, COMMENCE_F, COMMENCE_T, RELATED_PARTY_F, RELATED_PARTY_T, ACKNOWLEDGEMENT_CHECK, SAVE, REVIEW
	}

	WebDriver driver;
	By criminal_check_F = By.id("react-declaration-criminal_liability_check-false");
	By criminal_check_T = By.id("react-declaration-criminal_liability_check-true");
	By civil_check_F = By.id("react-declaration-civil_proceeding_check-false");
	By civil_check_T = By.id("react-declaration-civil_proceeding_check-true");
	By insolvency_check_F = By.id("react-declaration-insolvency_proceeding_check-false");
	By insolvency_check_T = By.id("react-declaration-insolvency_proceeding_check-true");
	By project_incentives_check_F = By.id("react-declaration-project_incentives_check-false");
	By project_incentives_check_T = By.id("react-declaration-project_incentives_check-true");
	By other_incentives_check_F = By.id("react-declaration-other_incentives_check-false");
	By other_incentives_check_T = By.id("react-declaration-other_incentives_check-true");
	By commence_check_F = By.id("react-declaration-project_commence_check-false");
	By commence_check_T = By.id("react-declaration-project_commence_check-true");
	By related_party_check_F = By.id("react-declaration-related_party_check-false");
	By related_party_check_T = By.id("react-declaration-related_party_check-true");
	By acknowledgement_check = By.id("react-declaration-consent_acknowledgement_check");
	
	By errorsInApplication = By.xpath("//*[text()='There are errors in your application.']");
	By other_incentives_alert = By.id("react-declaration-other_incentives_check-alert");
	
	By errorNumberInSidebar = By.xpath("//span[contains(text(), '1')]");
	
	By saveBtn = By.id("save-btn");
	By reviewBtn = By.id("review-btn");
	Map<DeclareCommand, By> dictOfCommand = new HashMap<DeclareCommand, By>();

	public DeclarePage(WebDriver driver) {
		super();
		this.driver = driver;
		dictOfCommand.put(DeclareCommand.CRIMINAL_F, criminal_check_F);
		dictOfCommand.put(DeclareCommand.CRIMINAL_T, criminal_check_T);
		dictOfCommand.put(DeclareCommand.CIVIL_F, civil_check_F);
		dictOfCommand.put(DeclareCommand.CIVIL_T, civil_check_T);
		dictOfCommand.put(DeclareCommand.INSOLVENCY_F, insolvency_check_F);
		dictOfCommand.put(DeclareCommand.INSOLVENCY_T, insolvency_check_T);
		dictOfCommand.put(DeclareCommand.PROJECT_INCENTIVES_F, project_incentives_check_F);
		dictOfCommand.put(DeclareCommand.PROJECT_INCENTIVES_T, project_incentives_check_T);
		dictOfCommand.put(DeclareCommand.OTHER_INCENTIVES_F, other_incentives_check_F);
		dictOfCommand.put(DeclareCommand.OTHER_INCENTIVES_T, other_incentives_check_T);
		dictOfCommand.put(DeclareCommand.COMMENCE_F, commence_check_F);
		dictOfCommand.put(DeclareCommand.COMMENCE_T, commence_check_T);
		dictOfCommand.put(DeclareCommand.RELATED_PARTY_F, related_party_check_F);
		dictOfCommand.put(DeclareCommand.RELATED_PARTY_T, related_party_check_T);
		dictOfCommand.put(DeclareCommand.ACKNOWLEDGEMENT_CHECK, acknowledgement_check);
		dictOfCommand.put(DeclareCommand.SAVE, saveBtn);
		dictOfCommand.put(DeclareCommand.REVIEW, reviewBtn);
	}

	// wait for this page load
	public void waitForReady() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
	}
	
	// wait for error trigger
	public void waitForErrorTrigger() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorsInApplication));
	}
	
	// get error trigger web element
	public WebElement getErrorsInApplication() {
		return driver.findElement(errorsInApplication);
	}
	
	// get other_incentives_alert
	public WebElement getOtherIncentivesAlert() {
		return driver.findElement(other_incentives_alert);
	}
	
	// get error number in sidebar web element
	public WebElement getErrorNumberInSidebar() {
		return driver.findElement(errorNumberInSidebar);
	}
	
	// is page displayed
	public Boolean isPageDisplayed() {
		return driver.findElement(saveBtn).isDisplayed();
	}

	/*
	 * valid command list:
	 * 
	 * CRIMINAL_F CRIMINAL_T CIVIL_F CIVIL_T INSOLVENCY_F INSOLVENCY_T
	 * PROJECT_INCENTIVES_F PROJECT_INCENTIVES_T OTHER_INCENTIVES_F
	 * OTHER_INCENTIVES_T COMMENCE_F COMMENCE_T RELATED_PARTY_F RELATED_PARTY_T
	 * ACKNOWLEDGEMENT_CHECK SAVE NEXT
	 * 
	 */
	public void clickByCommand(DeclareCommand command) {
		if (dictOfCommand.containsKey(command)) {
			driver.findElement(dictOfCommand.get(command)).click();
			Delay.sleep(100);
		} else {
			throw new InvalidParameterException("Command " + command + " is not define in DeclarePage");
		}
	}
}
