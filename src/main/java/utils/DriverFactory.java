package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	//This method return a WebDriver object
	public static WebDriver openWebDriver(String browserType) {
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		if (browserType.equalsIgnoreCase("firefox")) {
	        System.setProperty("webdriver.chrome.driver", path+"\\resources\\geckodriver.exe");
	        return new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("IE")) {
	        System.setProperty("webdriver.chrome.driver", path+"\\resources\\IEDriveServer.exe");
	        return new InternetExplorerDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", path+"\\resources\\chromedriver.exe");
	        return new ChromeDriver();
		}				
	}	
}
