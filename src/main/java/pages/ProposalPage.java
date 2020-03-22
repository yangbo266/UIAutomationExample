package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProposalPage {
	WebDriver driver;
	By projectTitle = By.id("react-project-title");
    By startDate = By.id("react-project-start_date");
    By endDate = By.id("react-project-end_date");
    By projectDescription = By.id("react-project-description");
    By listOfInputs = By.cssSelector("input[role=combobox]");
    By isNewMarket_true = By.id("react-project-is_new_market-true");
    By isNewMarket_false = By.id("react-project-is_new_market-false");

	By saveBtn = By.id("save-btn");
	By nextBtn = By.id("next-btn");
	public ProposalPage(WebDriver driver) {
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
		return driver.findElement(projectTitle).isDisplayed();
	}

	public void setProjectTitle(String projectTitleStr) {
		driver.findElement(projectTitle).sendKeys(projectTitleStr);
	}

	public void setStartDate(String startDateStr) {
		driver.findElement(startDate).sendKeys(startDateStr);
	}

	public void setEndDate(String endDateStr) {
		driver.findElement(endDate).sendKeys(endDateStr);
	}

	public void setProjectDescription(String projectDescriptionStr) {
		driver.findElement(projectDescription).sendKeys(projectDescriptionStr);
	}
	public void setActivityInput(Keys enter) {
		driver.findElements(listOfInputs).get(0).sendKeys(enter);
	}
	
	public void setActivityInput(String activityInputStr) {
		driver.findElements(listOfInputs).get(0).sendKeys(activityInputStr);
	}

	public void setTargetMarketInput(String targetMarketInputStr) {
		driver.findElements(listOfInputs).get(1).sendKeys(targetMarketInputStr);
	}
	public void setTargetMarketInput(Keys enter) {
		driver.findElements(listOfInputs).get(1).sendKeys(enter);
	}
	public void clickIsNewMarket_true() {
		driver.findElement(isNewMarket_true).click();
	}

	public void clickIsNewMarket_false() {
		driver.findElement(isNewMarket_false).click();
	}

	public void clickSaveBtn() {
		driver.findElement(saveBtn).click();
	}

	public void clickNextBtn() {
		driver.findElement(nextBtn).click();
	}





}
