package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusinessImpactPage {
	WebDriver driver;
	By impactEndDate = By.id("react-project_impact-fy_end_date_0");
	By overseaSales_1 = By.id("react-project_impact-overseas_sales_0");
	By overseaSales_2 = By.id("react-project_impact-overseas_sales_1");
	By overseaSales_3 = By.id("react-project_impact-overseas_sales_2");
	By overseaSales_4 = By.id("react-project_impact-overseas_sales_3");
	By overseaInvestment_1 = By.id("react-project_impact-overseas_investments_0");
	By overseaInvestment_2 = By.id("react-project_impact-overseas_investments_1");
	By overseaInvestment_3 = By.id("react-project_impact-overseas_investments_2");
	By overseaInvestment_4 = By.id("react-project_impact-overseas_investments_3");
	By retionalRemark = By.id("react-project_impact-rationale_remarks");
	By tangibleBenifits = By.id("react-project_impact-benefits_remarks");
	By saveBtn = By.id("save-btn");
	By nextBtn = By.id("next-btn");

	public BusinessImpactPage(WebDriver driver) {
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
		return driver.findElement(saveBtn).isDisplayed();
	}

	public void clickSaveBtn() {
		driver.findElement(saveBtn).click();
	}

	public void clickNextBtn() {
		driver.findElement(nextBtn).click();
	}

	public void setImpactEndDate(String impactEndDate_str) {
		driver.findElement(impactEndDate).sendKeys(impactEndDate_str);
	}

	public void setImpactEndDate(Keys enter) {
		driver.findElement(impactEndDate).sendKeys(enter);
	}

	public void setOverseaSales_1(String overseaSales_1_str) {
		driver.findElement(overseaSales_1).sendKeys(overseaSales_1_str);
	}

	public void setOverseaSales_2(String overseaSales_2_str) {
		driver.findElement(overseaSales_2).sendKeys(overseaSales_2_str);
	}

	public void setOverseaSales_3(String overseaSales_3_str) {
		driver.findElement(overseaSales_3).sendKeys(overseaSales_3_str);
	}

	public void setOverseaSales_4(String overseaSales_4_str) {
		driver.findElement(overseaSales_4).sendKeys(overseaSales_4_str);
	}

	public void setOverseaInvestment_1(String overseaInvestment_1_str) {
		driver.findElement(overseaInvestment_1).sendKeys(overseaInvestment_1_str);
	}

	public void setOverseaInvestment_2(String overseaInvestment_2_str) {
		driver.findElement(overseaInvestment_2).sendKeys(overseaInvestment_2_str);
	}

	public void setOverseaInvestment_3(String overseaInvestment_3_str) {
		driver.findElement(overseaInvestment_3).sendKeys(overseaInvestment_3_str);
	}

	public void setOverseaInvestment_4(String overseaInvestment_4_str) {
		driver.findElement(overseaInvestment_4).sendKeys(overseaInvestment_4_str);
	}

	public void setRetionalRemark(String retionalRemark_str) {
		driver.findElement(retionalRemark).sendKeys(retionalRemark_str);
	}

	public void setTangibleBenifits(String tangibleBenifits_str) {
		driver.findElement(tangibleBenifits).sendKeys(tangibleBenifits_str);
	}

}
