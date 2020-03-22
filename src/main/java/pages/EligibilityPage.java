package pages;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Delay;

public class EligibilityPage {
	
	public enum EligibilityCommand {  
		REGISTER_T,REGISTER_F,TURNOVER_T,TURNOVER_F,EQUITY_T,EQUITY_F,START_T,START_F,SAVE,NEXT,ADVISOR
	}
	
	
	WebDriver driver;
	By registerInSGTrue = By.id("react-eligibility-sg_registered_check-true");
	By registerInSGFalse = By.id("react-eligibility-sg_registered_check-false");
	By turnoverCheckTrue = By.id("react-eligibility-turnover_check-true");
	By turnoverCheckFalse = By.id("react-eligibility-turnover_check-false");
	By equityCheckTrue = By.id("react-eligibility-global_hq_check-true");
	By equityCheckFalse = By.id("react-eligibility-global_hq_check-false");
	By startProjectCheckTrue = By.id("react-eligibility-started_project_check-true");
	By startProjectCheckFalse = By.id("react-eligibility-started_project_check-false");
	By registerInSGLabel = By.xpath("//label[contains(text(),'registered in Singapore')]");
	By turnoverCheckLabel = By.xpath("//label[contains(text(), 'sales turnover less than')]");
	By equityCheckLabel = By.xpath("//label[contains(text(), 'Does the applicant have at least 30%')]");
	By otherCheckLabel = By.xpath("//label[contains(text(), 'Are ')]");
	By warningWhenClickNo = By.xpath("//span[contains(text(), 'The applicant may not meet the eligibility criteria for this grant.')]");
	By warningMsgAdvisor = By.xpath("//*[text()='Smart Advisor']");
	
	By saveBtn = By.id("save-btn");
	By nextBtn = By.id("next-btn");
	Map<EligibilityCommand,By> dictOfCommand = new HashMap<EligibilityCommand,By>();
	
	public EligibilityPage(WebDriver driver) {
		super();
		this.driver = driver;
		dictOfCommand.put(EligibilityCommand.REGISTER_T, registerInSGTrue);
		dictOfCommand.put(EligibilityCommand.REGISTER_F, registerInSGFalse);
		dictOfCommand.put(EligibilityCommand.TURNOVER_T, turnoverCheckTrue);
		dictOfCommand.put(EligibilityCommand.TURNOVER_F, turnoverCheckFalse);
		dictOfCommand.put(EligibilityCommand.EQUITY_T, equityCheckTrue);
		dictOfCommand.put(EligibilityCommand.EQUITY_F, equityCheckFalse);
		dictOfCommand.put(EligibilityCommand.START_T, startProjectCheckTrue);
		dictOfCommand.put(EligibilityCommand.START_F, startProjectCheckFalse);
		dictOfCommand.put(EligibilityCommand.SAVE, saveBtn);
		dictOfCommand.put(EligibilityCommand.NEXT, nextBtn);
		dictOfCommand.put(EligibilityCommand.ADVISOR, warningMsgAdvisor);
	}
	
	// wait for this page to load
	public void waitForReady() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(registerInSGTrue));
	}
	
	/*
	 * valid command list: 
	 * 
	 * REGISTER_T
	 * REGISTER_F
	 * TURNOVER_T
	 * TURNOVER_F
	 * EQUITY_T
	 * EQUITY_F
	 * START_T
	 * START_F
	 * SAVE
	 * NEXT
	 * 
	*/
	public void clickByCommand(EligibilityCommand command) {
		if(dictOfCommand.containsKey(command)) {
			driver.findElement(dictOfCommand.get(command)).click();
			Delay.sleep(500);
		}else {
			throw new InvalidParameterException("Command "+command+" is not define in EligibilityPage");
		}
	}
	
	// is page displayed
	public Boolean isPageDisplayed() {
		return driver.findElement(registerInSGTrue).isDisplayed();
	}

	//get text of eligibility check 1
	public String getTextOfRegisteredSingapore() {
		return driver.findElement(registerInSGLabel).getText();
	}
	//get text of eligibility check 2
	public String getTextOfTurnOver() {
		return driver.findElement(turnoverCheckLabel).getText();
	}
	
	//get text of eligibility check 3
	public String getTextOfEquity() {
		return driver.findElement(equityCheckLabel).getText();
	}
	
	//get text of eligibility check 4
	public String getTextOfStatementTrue() {
		return driver.findElement(otherCheckLabel).getText();
	}
	
	//is radio button displayed
	public Boolean isDisplayByCommand(EligibilityCommand command) {
		if(dictOfCommand.containsKey(command)) {
			return driver.findElement(dictOfCommand.get(command)).isDisplayed();
		}else {
			throw new InvalidParameterException("Command "+command+" is not define in EligibilityPage");
		}
	}
	
	//count the total number of warning message
	public int countWarningMsg() {
		return driver.findElements(warningWhenClickNo).size();
	}
}
